package com.android.contacts.business.calllog.breenocall.backupandrestore;

import H7.b;
import android.content.Context;
import android.database.Cursor;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.business.calllog.breenocall.BreenoCallLogEntity;
import com.android.contacts.business.calllog.breenocall.BreenoCallLogEntityUtils;
import com.android.contacts.business.calllog.breenocall.FeatureOpt;
import com.oplus.foundation.util.io.d;
import com.oplus.foundation.util.io.e;
import java.io.File;
import java.util.ArrayList;
import kotlin.Result;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import m9.q;

/* compiled from: BreenoCallLogBackuper.kt */
/* loaded from: classes.dex */
public final class BreenoCallLogBackuper {
    public static final String BREENO_CALL_XML = "breeno_call_backup.xml";
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "BreenoCallLogBackuper";
    private String backupDir;
    private Cursor cursor;
    private ArrayList<BreenoCallLogEntity> entityList;
    private boolean hasDatas;
    private BreenoCallEntityXMLComposer xmlComposer;
    private final boolean support = FeatureOpt.isBreenoCallLogSupport();
    private int stepCount = 1;

    /* compiled from: BreenoCallLogBackuper.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    public final void onBackup(int i10, int i11) {
        Cursor cursor;
        if (this.hasDatas && (cursor = this.cursor) != null) {
            int i12 = this.stepCount;
            int i13 = 1;
            if (1 > i12) {
                return;
            }
            while (true) {
                if (cursor.moveToNext()) {
                    ArrayList<BreenoCallLogEntity> arrayList = this.entityList;
                    if (arrayList != null) {
                        arrayList.add(BreenoCallLogEntityUtils.Companion.buildBreenoCallLogEntity(cursor));
                    }
                } else if (i13 != i12) {
                    i13++;
                } else {
                    return;
                }
            }
        }
    }

    public final void onCreate(Context context, int i10, String backupDir) {
        i.f(context, "context");
        i.f(backupDir, "backupDir");
        if (this.support) {
            this.backupDir = backupDir;
            if (i10 > 0) {
                Cursor query = context.getContentResolver().query(BreenoCallContract.Call.CONTENT_URI, BreenoCallLogEntityUtils.Companion.getQuery_projection(), null, null, "_id ASC");
                this.cursor = query;
                if (query != null) {
                    if (query.getCount() > 0) {
                        this.hasDatas = true;
                        this.stepCount = (query.getCount() / i10) + 1;
                    } else {
                        e.a(query);
                    }
                }
            }
        }
        b.b(TAG, "onPrepare: support: " + this.support + ", hasDatas: " + this.hasDatas + ", callLogCount: " + i10 + ", stepCount: " + this.stepCount);
    }

    public final void onDestroy(d fileWriter, boolean z10) {
        Object b10;
        boolean z11;
        byte[] bArr;
        String xmlInfo;
        i.f(fileWriter, "fileWriter");
        if (this.hasDatas) {
            try {
                Result.a aVar = Result.f34166a;
                q qVar = null;
                if (!z10) {
                    BreenoCallEntityXMLComposer breenoCallEntityXMLComposer = this.xmlComposer;
                    if (breenoCallEntityXMLComposer != null) {
                        breenoCallEntityXMLComposer.endCompose();
                    }
                    ArrayList<BreenoCallLogEntity> arrayList = this.entityList;
                    if (arrayList != null) {
                        z11 = !arrayList.isEmpty();
                    } else {
                        z11 = false;
                    }
                    b.b(TAG, "onDestroy: hasEntityList: " + z11);
                    if (z11) {
                        String str = this.backupDir + File.separator + BREENO_CALL_XML;
                        BreenoCallEntityXMLComposer breenoCallEntityXMLComposer2 = this.xmlComposer;
                        if (breenoCallEntityXMLComposer2 != null && (xmlInfo = breenoCallEntityXMLComposer2.getXmlInfo()) != null) {
                            bArr = xmlInfo.getBytes(kotlin.text.d.f34284b);
                            i.e(bArr, "getBytes(...)");
                        } else {
                            bArr = null;
                        }
                        fileWriter.writeToFile(str, bArr);
                    }
                }
                Cursor cursor = this.cursor;
                if (cursor != null) {
                    cursor.close();
                }
                ArrayList<BreenoCallLogEntity> arrayList2 = this.entityList;
                if (arrayList2 != null) {
                    arrayList2.clear();
                    qVar = q.f35511a;
                }
                b10 = Result.b(qVar);
            } catch (Throwable th) {
                Result.a aVar2 = Result.f34166a;
                b10 = Result.b(kotlin.b.a(th));
            }
            Throwable d10 = Result.d(b10);
            if (d10 != null) {
                b.c(TAG, "onDestroy: onFailure: " + d10);
            }
        }
    }

    public final void onPrepare() {
        if (this.hasDatas) {
            this.entityList = new ArrayList<>();
            BreenoCallEntityXMLComposer breenoCallEntityXMLComposer = new BreenoCallEntityXMLComposer();
            this.xmlComposer = breenoCallEntityXMLComposer;
            breenoCallEntityXMLComposer.startCompose();
            Cursor cursor = this.cursor;
            if (cursor != null) {
                cursor.moveToPosition(-1);
            }
        }
    }

    public final void onWriteToXml() {
        ArrayList<BreenoCallLogEntity> arrayList;
        if (this.hasDatas && (arrayList = this.entityList) != null) {
            for (BreenoCallLogEntity breenoCallLogEntity : arrayList) {
                BreenoCallEntityXMLComposer breenoCallEntityXMLComposer = this.xmlComposer;
                if (breenoCallEntityXMLComposer != null) {
                    breenoCallEntityXMLComposer.addOne(breenoCallLogEntity);
                }
            }
        }
    }
}
