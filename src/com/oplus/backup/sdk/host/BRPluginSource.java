package com.oplus.backup.sdk.host;

import android.content.Context;
import com.oplus.backup.sdk.common.plugin.BRPluginConfig;
import com.oplus.backup.sdk.common.plugin.BRPluginConfigParser;
import com.oplus.backup.sdk.common.utils.BRLog;
import com.oplus.backup.sdk.common.utils.FileUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class BRPluginSource {
    private static final String ASSETS_PLUGINS_PATH = "br_plugins";
    public static final String BR_BASE_DIR = "br_cache";
    public static final String LOCAL_PLUGINS_DIR = "local_plugins";
    private static final String TAG = "BRPluginSource";
    private static BRPluginConfig[] sBRPluginConfigs;

    public static BRPluginConfig[] getLocalBRPlugins(Context context, String str) {
        String[] strArr;
        String[] strArr2;
        Throwable th;
        InputStream inputStream;
        IOException iOException;
        StringBuilder sb;
        BRPluginConfig[] bRPluginConfigArr = sBRPluginConfigs;
        if (bRPluginConfigArr != null) {
            return bRPluginConfigArr;
        }
        initBaseFolder(context);
        BRPluginConfig[] bRPluginConfigArr2 = new BRPluginConfig[0];
        ArrayList arrayList = new ArrayList();
        InputStream inputStream2 = null;
        try {
            strArr = context.getAssets().list(ASSETS_PLUGINS_PATH);
        } catch (IOException e10) {
            BRLog.e(TAG, "getLocalBRPlugins, e =" + e10.getMessage());
            strArr = null;
        }
        if (strArr == null) {
            return bRPluginConfigArr2;
        }
        int length = strArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            BRLog.d(TAG, strArr[i10]);
            try {
                strArr2 = context.getAssets().list("br_plugins/" + strArr[i10]);
            } catch (IOException e11) {
                BRLog.e(TAG, "getLocalBRPlugins, e =" + e11.getMessage());
                strArr2 = null;
            }
            if (strArr2 == null) {
                return bRPluginConfigArr2;
            }
            int length2 = strArr2.length;
            for (int i11 = 0; i11 < length2; i11++) {
                if (strArr2[i11].endsWith(".config")) {
                    BRLog.d(TAG, strArr2[i11]);
                    try {
                        inputStream = context.getAssets().open("br_plugins/" + strArr[i10] + "/" + strArr2[i11]);
                        try {
                            try {
                                BRPluginConfig parse = BRPluginConfigParser.parse(inputStream);
                                if (parse != null) {
                                    arrayList.add(parse);
                                    BRLog.d(TAG, "add success");
                                } else {
                                    BRLog.w(TAG, "BRPluginConfigParser.parse(inputStream) failed:");
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e12) {
                                        iOException = e12;
                                        sb = new StringBuilder();
                                        sb.append("getLocalBRPlugins, e =");
                                        sb.append(iOException.getMessage());
                                        BRLog.e(TAG, sb.toString());
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                inputStream2 = inputStream;
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                        throw th;
                                    } catch (IOException e13) {
                                        BRLog.e(TAG, "getLocalBRPlugins, e =" + e13.getMessage());
                                        throw th;
                                    }
                                }
                                throw th;
                            }
                        } catch (IOException e14) {
                            e = e14;
                            BRLog.e(TAG, "getLocalBRPlugins, e =" + e.getMessage());
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e15) {
                                    iOException = e15;
                                    sb = new StringBuilder();
                                    sb.append("getLocalBRPlugins, e =");
                                    sb.append(iOException.getMessage());
                                    BRLog.e(TAG, sb.toString());
                                }
                            }
                        }
                    } catch (IOException e16) {
                        e = e16;
                        inputStream = null;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
            }
        }
        BRPluginConfig[] bRPluginConfigArr3 = (BRPluginConfig[]) arrayList.toArray(new BRPluginConfig[arrayList.size()]);
        sBRPluginConfigs = bRPluginConfigArr3;
        return bRPluginConfigArr3;
    }

    public static File initBaseFolder(Context context) {
        File dir = context.getDir(BR_BASE_DIR, 0);
        FileUtils.setPermissionsReadOnly(dir.getAbsolutePath());
        return dir;
    }

    public static BRPluginConfig[] getLocalBRPlugins(Context context) {
        return getLocalBRPlugins(context, LOCAL_PLUGINS_DIR);
    }
}
