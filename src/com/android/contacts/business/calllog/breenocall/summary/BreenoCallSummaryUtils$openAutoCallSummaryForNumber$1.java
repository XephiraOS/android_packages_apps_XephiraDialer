package com.android.contacts.business.calllog.breenocall.summary;

import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.E;
import m9.q;
import p9.C1467a;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: BreenoCallSummaryUtils.kt */
@InterfaceC1470d(c = "com.android.contacts.business.calllog.breenocall.summary.BreenoCallSummaryUtils$openAutoCallSummaryForNumber$1", f = "BreenoCallSummaryUtils.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class BreenoCallSummaryUtils$openAutoCallSummaryForNumber$1 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ ArrayList<Long> $ids;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BreenoCallSummaryUtils$openAutoCallSummaryForNumber$1(ArrayList<Long> arrayList, Context context, kotlin.coroutines.c<? super BreenoCallSummaryUtils$openAutoCallSummaryForNumber$1> cVar) {
        super(2, cVar);
        this.$ids = arrayList;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new BreenoCallSummaryUtils$openAutoCallSummaryForNumber$1(this.$ids, this.$context, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object b10;
        int i10;
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            ArrayList<Long> arrayList = this.$ids;
            Context context = this.$context;
            try {
                Result.a aVar = Result.f34166a;
                ContentValues contentValues = new ContentValues(2);
                contentValues.put(BreenoCallContract.SummaryColumns.EVER_ADDED, C1467a.d(1));
                contentValues.put(BreenoCallContract.SummaryColumns.WHITELIST_TIMESTAMP, C1467a.e(System.currentTimeMillis()));
                ArrayList arrayList2 = new ArrayList();
                Iterator<T> it = arrayList.iterator();
                while (it.hasNext()) {
                    ContentProviderOperation.Builder newUpdate = ContentProviderOperation.newUpdate(ContentUris.withAppendedId(BreenoCallContract.Summary.CONTENT_URI, ((Number) it.next()).longValue()));
                    i.e(newUpdate, "newUpdate(ContentUris.wi…Summary.CONTENT_URI, it))");
                    newUpdate.withValues(contentValues);
                    arrayList2.add(newUpdate.build());
                }
                ContentProviderResult[] a10 = G7.a.a(context, BreenoCallContract.AUTHORITY, arrayList2);
                if (a10 != null) {
                    i10 = a10.length;
                } else {
                    i10 = 0;
                }
                if (H7.a.b()) {
                    H7.b.b("BreenoCallSummaryUtils", "openAutoCallSummaryForNumber: count: " + i10);
                }
                if (i10 > 0) {
                    Intent intent = new Intent("oplus.intent.action.ADD_CALL_AUTO_SUMMARY");
                    intent.setPackage("com.android.phone");
                    R7.b.f(context, intent, 0, null, 6, null);
                }
                b10 = Result.b(q.f35511a);
            } catch (Throwable th) {
                Result.a aVar2 = Result.f34166a;
                b10 = Result.b(kotlin.b.a(th));
            }
            Throwable d10 = Result.d(b10);
            if (d10 != null) {
                H7.b.c("BreenoCallSummaryUtils", "openAutoCallSummaryForNumber: exception: " + d10);
            }
            return q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
        return ((BreenoCallSummaryUtils$openAutoCallSummaryForNumber$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
