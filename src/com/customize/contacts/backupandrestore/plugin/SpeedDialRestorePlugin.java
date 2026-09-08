package com.customize.contacts.backupandrestore.plugin;

import H7.b;
import android.content.Context;
import android.os.Bundle;
import com.oplus.backup.sdk.common.host.BREngineConfig;
import com.oplus.backup.sdk.component.BRPluginHandler;
import com.oplus.backup.sdk.component.plugin.RestorePlugin;
import com.oplus.backup.sdk.host.listener.ProgressHelper;
import java.io.File;
import java.io.FileDescriptor;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import m9.q;

/* compiled from: SpeedDialRestorePlugin.kt */
/* loaded from: classes3.dex */
public class SpeedDialRestorePlugin extends RestorePlugin {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "SpeedDialRestorePlugin";
    private static Map<String, String[]> map = new HashMap();
    private Context mContext;
    private boolean mIsCancel;
    private boolean mIsPause;
    private final Object mProgressLock = new Object();
    private BREngineConfig mRestoreConfig;

    /* compiled from: SpeedDialRestorePlugin.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public final Map<String, String[]> getMap() {
            return SpeedDialRestorePlugin.map;
        }

        public final void setMap(Map<String, String[]> map) {
            i.f(map, "<set-?>");
            SpeedDialRestorePlugin.map = map;
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    @Override // com.oplus.backup.sdk.component.plugin.IBRPlugin
    public void onCancel(Bundle bundle) {
        this.mIsCancel = true;
        this.mIsPause = false;
        synchronized (this.mProgressLock) {
            this.mProgressLock.notifyAll();
            q qVar = q.f35511a;
        }
    }

    @Override // com.oplus.backup.sdk.component.plugin.IBRPlugin
    public void onContinue(Bundle bundle) {
        this.mIsPause = false;
        synchronized (this.mProgressLock) {
            this.mProgressLock.notifyAll();
            q qVar = q.f35511a;
        }
    }

    @Override // com.oplus.backup.sdk.component.plugin.AbstractPlugin
    public void onCreate(Context context, BRPluginHandler brPluginHandler, BREngineConfig config) {
        i.f(context, "context");
        i.f(brPluginHandler, "brPluginHandler");
        i.f(config, "config");
        super.onCreate(context, brPluginHandler, config);
        this.mContext = context;
        this.mRestoreConfig = config;
    }

    @Override // com.oplus.backup.sdk.component.plugin.IBRPlugin
    public Bundle onDestroy(Bundle bundle) {
        int i10;
        Bundle bundle2 = new Bundle();
        if (this.mIsCancel) {
            i10 = 3;
        } else {
            i10 = 1;
        }
        ProgressHelper.putBRResult(bundle2, i10);
        return bundle2;
    }

    @Override // com.oplus.backup.sdk.component.plugin.IBRPlugin
    public void onPause(Bundle bundle) {
        this.mIsPause = true;
    }

    @Override // com.oplus.backup.sdk.component.plugin.IBRPlugin
    public Bundle onPrepare(Bundle bundle) {
        BREngineConfig bREngineConfig = this.mRestoreConfig;
        if (bREngineConfig == null) {
            i.q("mRestoreConfig");
            bREngineConfig = null;
        }
        String restoreRootPath = bREngineConfig.getRestoreRootPath();
        String str = File.separator;
        String str2 = (restoreRootPath + str + "Contact") + str + BRConstant.SPEEDDIAL_XML;
        try {
            SpeedDialXmlParser speedDialXmlParser = SpeedDialXmlParser.INSTANCE;
            FileDescriptor fileDescriptor = getFileDescriptor(str2);
            i.e(fileDescriptor, "getFileDescriptor(filePath)");
            speedDialXmlParser.parse(fileDescriptor);
        } catch (Exception e10) {
            b.c(TAG, "exception e: " + e10);
        }
        return null;
    }

    @Override // com.oplus.backup.sdk.component.plugin.IBRPlugin
    public Bundle onPreview(Bundle bundle) {
        return null;
    }

    @Override // com.oplus.backup.sdk.component.plugin.IBRPlugin
    public void onRestore(Bundle bundle) {
        if (!this.mIsCancel) {
            synchronized (this.mProgressLock) {
                while (this.mIsPause) {
                    try {
                        this.mProgressLock.wait();
                    } catch (InterruptedException e10) {
                        b.c(TAG, "InterruptedException : " + e10);
                    } catch (Exception e11) {
                        b.c(TAG, "Exception : " + e11);
                    }
                }
                q qVar = q.f35511a;
            }
            Context context = this.mContext;
            if (context == null) {
                i.q("mContext");
                context = null;
            }
            new SpeedDialXmlComposer(context).setSpeedDialData(map.get("phone"), map.get("name"));
        }
    }
}
