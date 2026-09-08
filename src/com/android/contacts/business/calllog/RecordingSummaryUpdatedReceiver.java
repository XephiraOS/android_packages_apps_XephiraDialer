package com.android.contacts.business.calllog;

import android.content.BroadcastReceiver;
import android.content.ContentProviderOperation;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.provider.CallLog;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.business.calllog.breenocall.FeatureOpt;
import com.android.incallui.OplusPhoneCapabilities;
import com.google.common.collect.n;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.C1241e0;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.S;
import m9.q;

/* compiled from: RecordingSummaryUpdatedReceiver.kt */
/* loaded from: classes.dex */
public final class RecordingSummaryUpdatedReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static final Companion f13694a = new Companion(null);

    /* compiled from: RecordingSummaryUpdatedReceiver.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public Companion() {
        }

        public final void c(Context context) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.oplus.contacts.external.ACTION_RECORDING_SUMMARY_UPDATED");
            context.registerReceiver(new RecordingSummaryUpdatedReceiver(), intentFilter, "com.oplus.permission.safe.PHONE", null, 2);
        }

        public final void d(Context context) {
            i.f(context, "context");
            if (FeatureOpt.isCallSummaryIconDisplayable()) {
                H7.b.e("RecordingSummaryUpdater", "start.");
                f(context);
                c(context);
            }
        }

        public final void e(Context context, boolean z10) {
            int i10;
            boolean z11;
            boolean z12;
            Object obj;
            int i11;
            if (z10) {
                i10 = 1;
            } else {
                i10 = -1;
            }
            ArrayList<Q0.c> c10 = Q0.c.f3102l.c(context, false, "data4=" + i10, null);
            if (H7.a.b()) {
                H7.b.b("RecordingSummaryUpdater", "updateCallLogSummaryFeatures: set: " + z10 + ", count: " + c10.size());
            }
            if (!c10.isEmpty()) {
                List<List> partitions = n.j(c10, 500);
                i.e(partitions, "partitions");
                for (List<Q0.c> partitionlist : partitions) {
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    i.e(partitionlist, "partitionlist");
                    for (Q0.c cVar : partitionlist) {
                        arrayList.add(Long.valueOf(cVar.b()));
                        arrayList2.add(Long.valueOf(cVar.g()));
                    }
                    ArrayList arrayList3 = new ArrayList();
                    ContentValues contentValues = new ContentValues();
                    Cursor query = context.getContentResolver().query(CallLog.Calls.CONTENT_URI, new String[]{BreenoCallContract.BaseColumns._ID, "features"}, "date IN " + G7.a.d(arrayList), null, null);
                    if (query != null) {
                        while (query.moveToNext()) {
                            try {
                                int i12 = (int) query.getLong(1);
                                if ((i12 & OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE) == 268435456) {
                                    z11 = true;
                                } else {
                                    z11 = false;
                                }
                                contentValues.clear();
                                if (z10 && !z11) {
                                    contentValues.put("features", Integer.valueOf(i12 | OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE));
                                } else if (!z10 && z11) {
                                    contentValues.put("features", Integer.valueOf(i12 ^ OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE));
                                }
                                ContentProviderOperation.Builder newUpdate = ContentProviderOperation.newUpdate(ContentUris.withAppendedId(CallLog.Calls.CONTENT_URI, query.getLong(0)));
                                i.e(newUpdate, "newUpdate(\n             …lls.CONTENT_URI, callId))");
                                newUpdate.withValues(contentValues);
                                arrayList3.add(newUpdate.build());
                            } catch (Throwable th) {
                                try {
                                    throw th;
                                } catch (Throwable th2) {
                                    kotlin.io.a.a(query, th);
                                    throw th2;
                                }
                            }
                        }
                        q qVar = q.f35511a;
                        kotlin.io.a.a(query, null);
                    }
                    if ((!arrayList3.isEmpty()) && G7.a.a(context, "call_log", arrayList3) == null) {
                        z12 = false;
                    } else {
                        z12 = true;
                    }
                    if (z12) {
                        contentValues.clear();
                        contentValues.put("data4", (Integer) 0);
                        obj = null;
                        i11 = G7.c.g(context.getContentResolver(), com.android.contacts.framework.baseui.calllog.a.f15766a, contentValues, "_id IN " + G7.a.d(arrayList2), null);
                    } else {
                        obj = null;
                        i11 = 0;
                    }
                    H7.b.e("RecordingSummaryUpdater", "partitionlist: " + partitionlist.size() + ", operationList: " + arrayList3.size() + ", success: " + z12 + ", updated: " + i11);
                }
            }
        }

        public final void f(Context context) {
            if (P7.e.d(context)) {
                C1248i.d(C1241e0.f34422a, S.b(), null, new RecordingSummaryUpdatedReceiver$Companion$updateDb$1(context, null), 2, null);
            }
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public static final void a(Context context) {
        f13694a.d(context);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context != null && intent != null && i.b(intent.getAction(), "com.oplus.contacts.external.ACTION_RECORDING_SUMMARY_UPDATED")) {
            H7.b.e("RecordingSummaryUpdater", "Receive action: RECORDING_SUMMARY_UPDATED_ACTION.");
            f13694a.f(context);
        }
    }
}
