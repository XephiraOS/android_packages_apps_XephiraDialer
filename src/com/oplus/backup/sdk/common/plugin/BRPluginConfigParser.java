package com.oplus.backup.sdk.common.plugin;

import android.os.Bundle;
import com.google.gson.g;
import com.google.gson.j;
import com.google.gson.l;
import com.google.gson.m;
import com.google.gson.n;
import com.oplus.backup.sdk.common.utils.BRLog;
import com.oplus.backup.sdk.common.utils.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

/* loaded from: classes3.dex */
public class BRPluginConfigParser {
    public static final String JSON_ENCODE = "json";
    private static final String TAG = "BRPluginConfigParser";

    private static Bundle fromJson(j jVar) {
        g gVar;
        n nVar;
        Bundle bundle = new Bundle();
        if (!jVar.i()) {
            return null;
        }
        for (Map.Entry<String, j> entry : ((l) jVar).l()) {
            String key = entry.getKey();
            j value = entry.getValue();
            if (value.g()) {
                gVar = (g) value;
            } else {
                gVar = null;
            }
            if (value.j()) {
                nVar = (n) value;
            } else {
                nVar = null;
            }
            if (gVar != null && gVar.size() <= 0) {
                bundle.putStringArray(key, new String[0]);
            } else if (gVar != null && gVar.l(0).j()) {
                int size = gVar.size();
                String[] strArr = new String[size];
                for (int i10 = 0; i10 < size; i10++) {
                    n nVar2 = (n) gVar.l(i10);
                    if (nVar2.t()) {
                        strArr[i10] = nVar2.p();
                    }
                }
                bundle.putStringArray(key, strArr);
            } else if (nVar != null) {
                if (nVar.q()) {
                    bundle.putBoolean(key, nVar.k());
                } else if (nVar.s()) {
                    bundle.putDouble(key, nVar.o().doubleValue());
                } else if (nVar.t()) {
                    bundle.putString(key, nVar.p());
                } else {
                    BRLog.d(TAG, "unable to transform json to bundle " + key);
                }
            }
        }
        return bundle;
    }

    private static String getValue(String str, String str2) {
        int indexOf = str.indexOf(str2);
        if (indexOf != -1) {
            int indexOf2 = str.indexOf("=", indexOf) + 1;
            int indexOf3 = str.indexOf(Constants.DataMigration.SPLIT_TAG, indexOf2);
            if (indexOf3 == -1) {
                indexOf3 = str.length();
            }
            return str.substring(indexOf2, indexOf3);
        }
        return null;
    }

    public static BRPluginConfig parse(InputStream inputStream) {
        String readInputStream = readInputStream(inputStream);
        String value = getValue(readInputStream, "encode");
        String value2 = getValue(readInputStream, BRPluginConfig.VERSION);
        String value3 = getValue(readInputStream, "context");
        if (value3 != null) {
            value3 = value3.replaceAll("\r|\n", "");
        }
        return parse(value, value2, value3);
    }

    private static String readFile(File file) {
        FileInputStream fileInputStream = null;
        if (file == null) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e10) {
            BRLog.e(TAG, "new FileInputStream failed, " + e10.getMessage());
        }
        return readInputStream(fileInputStream);
    }

    private static String readInputStream(InputStream inputStream) {
        StringBuilder sb;
        if (inputStream == null) {
            return null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            try {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    stringBuffer.append(readLine);
                } catch (Throwable th) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e10) {
                            BRLog.w(TAG, "close failed, " + e10.getMessage());
                            throw th;
                        }
                    }
                    bufferedReader.close();
                    throw th;
                }
            } catch (IOException e11) {
                BRLog.e(TAG, "readInputStream, e =" + e11.getMessage());
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e12) {
                        e = e12;
                        sb = new StringBuilder();
                        sb.append("close failed, ");
                        sb.append(e.getMessage());
                        BRLog.w(TAG, sb.toString());
                        return stringBuffer.toString();
                    }
                }
                bufferedReader.close();
            }
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception e13) {
                e = e13;
                sb = new StringBuilder();
                sb.append("close failed, ");
                sb.append(e.getMessage());
                BRLog.w(TAG, sb.toString());
                return stringBuffer.toString();
            }
        }
        bufferedReader.close();
        return stringBuffer.toString();
    }

    public static BRPluginConfig parse(File file) {
        String readFile = readFile(file);
        String value = getValue(readFile, "encode");
        String value2 = getValue(readFile, BRPluginConfig.VERSION);
        String value3 = getValue(readFile, "context");
        if (value3 != null) {
            return parse(value, value2, value3.replaceAll("\r|\n", ""));
        }
        return null;
    }

    public static BRPluginConfig parse(String str, String str2, String str3) {
        Bundle bundle;
        BRLog.d(TAG, str + ", " + str2 + ", " + str3);
        if (!JSON_ENCODE.equals(str)) {
            return null;
        }
        try {
            bundle = fromJson(new m().a(str3));
        } catch (Exception e10) {
            BRLog.w(TAG, "parse failed: " + e10.getMessage());
            bundle = null;
        }
        if (bundle != null) {
            return new BRPluginConfig(bundle);
        }
        return null;
    }
}
