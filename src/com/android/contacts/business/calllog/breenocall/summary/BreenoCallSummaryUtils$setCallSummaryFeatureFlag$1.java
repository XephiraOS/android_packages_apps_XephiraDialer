package com.android.contacts.business.calllog.breenocall.summary;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CallLog;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.E;
import m9.q;
import p9.C1467a;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: BreenoCallSummaryUtils.kt */
@InterfaceC1470d(c = "com.android.contacts.business.calllog.breenocall.summary.BreenoCallSummaryUtils$setCallSummaryFeatureFlag$1", f = "BreenoCallSummaryUtils.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class BreenoCallSummaryUtils$setCallSummaryFeatureFlag$1 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
    final /* synthetic */ long $callId;
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $set;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BreenoCallSummaryUtils$setCallSummaryFeatureFlag$1(long j10, Context context, boolean z10, kotlin.coroutines.c<? super BreenoCallSummaryUtils$setCallSummaryFeatureFlag$1> cVar) {
        super(2, cVar);
        this.$callId = j10;
        this.$context = context;
        this.$set = z10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new BreenoCallSummaryUtils$setCallSummaryFeatureFlag$1(this.$callId, this.$context, this.$set, cVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [T, java.lang.Integer] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object b10;
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            long j10 = this.$callId;
            Context context = this.$context;
            boolean z10 = this.$set;
            try {
                Result.a aVar = Result.f34166a;
                Uri withAppendedId = ContentUris.withAppendedId(CallLog.Calls.CONTENT_URI, j10);
                i.e(withAppendedId, "withAppendedId(CallLog.Calls.CONTENT_URI, callId)");
                Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                Cursor query = context.getContentResolver().query(withAppendedId, new String[]{"features"}, null, null, null);
                q qVar = null;
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            ref$ObjectRef.element = C1467a.d(query.getInt(0));
                        }
                        q qVar2 = q.f35511a;
                        kotlin.io.a.a(query, null);
                    } finally {
                    }
                }
                Integer num = (Integer) ref$ObjectRef.element;
                if (num != null) {
                    BreenoCallSummaryUtils.updateCallSummaryFeatureFlag(context, j10, num.intValue(), z10);
                    qVar = q.f35511a;
                }
                b10 = Result.b(qVar);
            } catch (Throwable th) {
                Result.a aVar2 = Result.f34166a;
                b10 = Result.b(kotlin.b.a(th));
            }
            Throwable d10 = Result.d(b10);
            if (d10 != null) {
                H7.b.c("BreenoCallSummaryUtils", "setCallSummaryFeatureFlag: exception: " + d10);
            }
            return q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
        return ((BreenoCallSummaryUtils$setCallSummaryFeatureFlag$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
