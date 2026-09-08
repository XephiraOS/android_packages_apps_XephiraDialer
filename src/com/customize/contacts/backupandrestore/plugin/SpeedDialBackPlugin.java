package com.customize.contacts.backupandrestore.plugin;

import H7.b;
import android.content.Context;
import android.os.Bundle;
import com.oplus.backup.sdk.common.host.BREngineConfig;
import com.oplus.backup.sdk.component.BRPluginHandler;
import com.oplus.backup.sdk.component.plugin.BackupPlugin;
import com.oplus.backup.sdk.host.listener.ProgressHelper;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import m9.q;

/* compiled from: SpeedDialBackPlugin.kt */
/* loaded from: classes3.dex */
public class SpeedDialBackPlugin extends BackupPlugin {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "SpeedDialBackPlugin";
    private FileDescriptor fileDescriptor;
    private BREngineConfig mBackupConfig;
    private Context mContext;
    private boolean mIsCancel;
    private boolean mIsPause;
    private final Object mProgressLock = new Object();
    private Writer mWriter;

    /* compiled from: SpeedDialBackPlugin.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    @Override // com.oplus.backup.sdk.component.plugin.IBRPlugin
    public void onBackup(Bundle bundle) {
        String str;
        StringBuilder sb;
        if (!this.mIsCancel) {
            synchronized (this.mProgressLock) {
                while (this.mIsPause) {
                    try {
                        b.e(TAG, "backup paused, wait lock here");
                        this.mProgressLock.wait();
                    } catch (Exception e10) {
                        b.c(TAG, "onBackup Exception1 : " + e10);
                    }
                }
                q qVar = q.f35511a;
            }
            Writer writer = null;
            try {
                try {
                    Context context = this.mContext;
                    if (context == null) {
                        i.q("mContext");
                        context = null;
                    }
                    String speedDialData = new SpeedDialXmlComposer(context).getSpeedDialData();
                    Writer writer2 = this.mWriter;
                    if (writer2 == null) {
                        i.q("mWriter");
                        writer2 = null;
                    }
                    writer2.write(speedDialData);
                    Writer writer3 = this.mWriter;
                    if (writer3 == null) {
                        i.q("mWriter");
                        writer3 = null;
                    }
                    writer3.flush();
                    FileDescriptor fileDescriptor = this.fileDescriptor;
                    if (fileDescriptor != null) {
                        fileDescriptor.sync();
                    }
                    try {
                        Writer writer4 = this.mWriter;
                        if (writer4 == null) {
                            i.q("mWriter");
                        } else {
                            writer = writer4;
                        }
                        writer.close();
                    } catch (Exception e11) {
                        e = e11;
                        str = TAG;
                        sb = new StringBuilder();
                        sb.append("onBackup Exception3 : ");
                        sb.append(e);
                        b.c(str, sb.toString());
                    }
                } finally {
                    try {
                        Writer writer5 = this.mWriter;
                        if (writer5 == null) {
                            i.q("mWriter");
                        } else {
                            writer = writer5;
                        }
                        writer.close();
                    } catch (Exception e12) {
                        b.c(TAG, "onBackup Exception3 : " + e12);
                    }
                }
            } catch (IOException e13) {
                b.c(TAG, "onBackup IOException : " + e13);
                try {
                    Writer writer6 = this.mWriter;
                    if (writer6 == null) {
                        i.q("mWriter");
                    } else {
                        writer = writer6;
                    }
                    writer.close();
                } catch (Exception e14) {
                    e = e14;
                    str = TAG;
                    sb = new StringBuilder();
                    sb.append("onBackup Exception3 : ");
                    sb.append(e);
                    b.c(str, sb.toString());
                }
            } catch (Exception e15) {
                b.c(TAG, "onBackup Exception2 : " + e15);
                try {
                    Writer writer7 = this.mWriter;
                    if (writer7 == null) {
                        i.q("mWriter");
                    } else {
                        writer = writer7;
                    }
                    writer.close();
                } catch (Exception e16) {
                    e = e16;
                    str = TAG;
                    sb = new StringBuilder();
                    sb.append("onBackup Exception3 : ");
                    sb.append(e);
                    b.c(str, sb.toString());
                }
            }
        }
    }

    @Override // com.oplus.backup.sdk.component.plugin.IBRPlugin
    public void onCancel(Bundle bundle) {
        this.mIsCancel = true;
        this.mIsPause = false;
        synchronized (this.mProgressLock) {
            this.mProgressLock.notifyAll();
            b.e(TAG, "onCancel notifyAll");
            q qVar = q.f35511a;
        }
    }

    @Override // com.oplus.backup.sdk.component.plugin.IBRPlugin
    public void onContinue(Bundle bundle) {
        this.mIsPause = false;
        synchronized (this.mProgressLock) {
            this.mProgressLock.notifyAll();
            b.e(TAG, "onContinue notifyAll");
            q qVar = q.f35511a;
        }
    }

    @Override // com.oplus.backup.sdk.component.plugin.AbstractPlugin
    public void onCreate(Context context, BRPluginHandler brPluginHandler, BREngineConfig config) {
        i.f(context, "context");
        i.f(brPluginHandler, "brPluginHandler");
        i.f(config, "config");
        super.onCreate(context, brPluginHandler, config);
        this.mBackupConfig = config;
        this.mContext = context;
    }

    @Override // com.oplus.backup.sdk.component.plugin.IBRPlugin
    public Bundle onDestroy(Bundle bundle) {
        int i10;
        try {
            Writer writer = this.mWriter;
            if (writer == null) {
                i.q("mWriter");
                writer = null;
            }
            writer.close();
        } catch (Exception e10) {
            b.c(TAG, "onDestroy Exception : " + e10);
        }
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
        BREngineConfig bREngineConfig = this.mBackupConfig;
        if (bREngineConfig == null) {
            i.q("mBackupConfig");
            bREngineConfig = null;
        }
        String backupRootPath = bREngineConfig.getBackupRootPath();
        String str = File.separator;
        try {
            this.fileDescriptor = getFileDescriptor((backupRootPath + str + "Contact") + str + BRConstant.SPEEDDIAL_XML);
            this.mWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.fileDescriptor)));
        } catch (Exception e10) {
            b.c(TAG, "onPrepare Exception : " + e10);
        }
        return null;
    }

    @Override // com.oplus.backup.sdk.component.plugin.IBRPlugin
    public Bundle onPreview(Bundle bundle) {
        return null;
    }
}
