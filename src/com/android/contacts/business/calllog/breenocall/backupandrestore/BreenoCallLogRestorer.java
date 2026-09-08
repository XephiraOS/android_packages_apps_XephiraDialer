package com.android.contacts.business.calllog.breenocall.backupandrestore;

import H7.b;
import android.content.ContentProviderOperation;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.business.calllog.breenocall.BreenoCallLogEntity;
import com.android.contacts.business.calllog.breenocall.BreenoCallLogEntityUtils;
import com.android.contacts.business.calllog.breenocall.FeatureOpt;
import com.android.contacts.business.calllog.breenocall.backupandrestore.BreenoCallEntityXmlParser;
import com.oplus.foundation.util.io.c;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Result;
import kotlin.io.a;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import m9.q;

/* compiled from: BreenoCallLogRestorer.kt */
/* loaded from: classes.dex */
public final class BreenoCallLogRestorer {
    private static final int BATCH_SIZE = 100;
    private static final boolean DEBUG = false;
    private static final int ID_INDEX = 0;
    private Context context;
    private ArrayList<BreenoCallLogEntity> datas;
    private ArrayList<ContentProviderOperation> dbOperations;
    private boolean hasDatas;
    private Iterator<BreenoCallLogEntity> iterator;
    private HashMap<String, Long> numberIdMap;
    private String restoreDir;
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "BreenoCallLogRestorer";
    private static final String[] projection = {BreenoCallContract.BaseColumns._ID, "number"};
    private static final int NUMBER_INDEX = 1;
    private final boolean support = FeatureOpt.isBreenoCallLogSupport();
    private int stepCount = 1;

    /* compiled from: BreenoCallLogRestorer.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    private final void applyBatch(boolean z10) {
        Object b10;
        ArrayList<ContentProviderOperation> arrayList = this.dbOperations;
        if (arrayList != null) {
            if (arrayList.size() >= 100 || (z10 && (!arrayList.isEmpty()))) {
                b.b(TAG, "applyBatch: size: " + arrayList.size() + ", force: " + z10);
                try {
                    Result.a aVar = Result.f34166a;
                    Context context = this.context;
                    i.c(context);
                    context.getContentResolver().applyBatch(BreenoCallContract.AUTHORITY, arrayList);
                    arrayList.clear();
                    b10 = Result.b(q.f35511a);
                } catch (Throwable th) {
                    Result.a aVar2 = Result.f34166a;
                    b10 = Result.b(kotlin.b.a(th));
                }
                Throwable d10 = Result.d(b10);
                if (d10 != null) {
                    b.c(TAG, "applyBatch: Exception: " + d10);
                }
            }
        }
    }

    private final void queryCurrentDatas(Context context) {
        Object b10;
        try {
            Result.a aVar = Result.f34166a;
            Cursor query = context.getContentResolver().query(BreenoCallContract.Call.CONTENT_URI, projection, null, null, "_id ASC");
            q qVar = null;
            if (query != null) {
                try {
                    if (query.getCount() > 0) {
                        query.moveToPosition(-1);
                        while (query.moveToNext()) {
                            HashMap<String, Long> hashMap = this.numberIdMap;
                            i.c(hashMap);
                            String string = query.getString(NUMBER_INDEX);
                            i.e(string, "it.getString(NUMBER_INDEX)");
                            hashMap.put(string, Long.valueOf(query.getLong(ID_INDEX)));
                        }
                    }
                    q qVar2 = q.f35511a;
                    a.a(query, null);
                    qVar = q.f35511a;
                } finally {
                }
            }
            b10 = Result.b(qVar);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            b.c(TAG, "queryCurrentDatas: exception: " + d10);
        }
    }

    public final void onCreate(Context context, String dir) {
        i.f(context, "context");
        i.f(dir, "dir");
        if (this.support) {
            this.restoreDir = dir;
            this.context = context;
        }
    }

    public final void onDestroy() {
        if (this.hasDatas) {
            ArrayList<BreenoCallLogEntity> arrayList = this.datas;
            if (arrayList != null) {
                arrayList.clear();
            }
            HashMap<String, Long> hashMap = this.numberIdMap;
            if (hashMap != null) {
                hashMap.clear();
            }
        }
    }

    public final void onPrepare(c fileReader, int i10) {
        boolean z10;
        i.f(fileReader, "fileReader");
        if (this.support && i10 > 0) {
            String fileContent = fileReader.getFileContent(this.restoreDir + File.separator + BreenoCallLogBackuper.BREENO_CALL_XML);
            if (!TextUtils.isEmpty(fileContent)) {
                ArrayList<BreenoCallLogEntity> arrayList = new ArrayList<>();
                this.datas = arrayList;
                i.c(arrayList);
                BreenoCallEntityXmlParser.Companion companion = BreenoCallEntityXmlParser.Companion;
                i.c(fileContent);
                arrayList.addAll(companion.parse(fileContent));
                if (arrayList.size() > 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                this.hasDatas = z10;
                if (z10) {
                    this.stepCount = (arrayList.size() / i10) + 1;
                    this.numberIdMap = new HashMap<>();
                    this.dbOperations = new ArrayList<>();
                    this.iterator = arrayList.iterator();
                    Context context = this.context;
                    i.c(context);
                    queryCurrentDatas(context);
                }
            }
        }
        b.b(TAG, "onPrepare: support: " + this.support + ", hasDatas: " + this.hasDatas + ", callsCount: " + i10 + ", stepCount: " + this.stepCount);
    }

    public final void onRestore(int i10, int i11) {
        Iterator<BreenoCallLogEntity> it;
        Long l10;
        if (this.hasDatas && (it = this.iterator) != null) {
            int i12 = this.stepCount;
            if (1 <= i12) {
                int i13 = 1;
                while (true) {
                    if (it.hasNext()) {
                        BreenoCallLogEntity next = it.next();
                        HashMap<String, Long> hashMap = this.numberIdMap;
                        if (hashMap != null) {
                            l10 = hashMap.get(next.getNumber());
                        } else {
                            l10 = null;
                        }
                        if (DEBUG) {
                            b.b(TAG, "onRestore: entity: " + next + ", id: " + l10);
                        }
                        if (l10 != null && l10.longValue() > 0) {
                            ArrayList<ContentProviderOperation> arrayList = this.dbOperations;
                            if (arrayList != null) {
                                arrayList.add(BreenoCallLogEntityUtils.Companion.buildUpdateOperation(l10.longValue(), next));
                            }
                            b.i(TAG, "onRestore: override entity with same number, id: " + l10);
                        } else {
                            ArrayList<ContentProviderOperation> arrayList2 = this.dbOperations;
                            if (arrayList2 != null) {
                                arrayList2.add(BreenoCallLogEntityUtils.Companion.buildInsertOperation(next));
                            }
                        }
                    } else {
                        applyBatch(true);
                    }
                    if (i13 == i12) {
                        break;
                    } else {
                        i13++;
                    }
                }
            }
            applyBatch(false);
        }
    }
}
