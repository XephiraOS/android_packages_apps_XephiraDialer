package com.android.contacts.business.calllog.breenocall.summary;

import android.content.Context;
import android.database.Cursor;
import android.provider.CallLog;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.E;
import m9.q;
import p9.C1467a;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: BreenoCallSummaryUtils.kt */
@InterfaceC1470d(c = "com.android.contacts.business.calllog.breenocall.summary.BreenoCallSummaryUtils$setCallSummaryFeatureFlag$2", f = "BreenoCallSummaryUtils.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class BreenoCallSummaryUtils$setCallSummaryFeatureFlag$2 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $set;
    final /* synthetic */ String $uuid;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BreenoCallSummaryUtils$setCallSummaryFeatureFlag$2(Context context, String str, boolean z10, kotlin.coroutines.c<? super BreenoCallSummaryUtils$setCallSummaryFeatureFlag$2> cVar) {
        super(2, cVar);
        this.$context = context;
        this.$uuid = str;
        this.$set = z10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new BreenoCallSummaryUtils$setCallSummaryFeatureFlag$2(this.$context, this.$uuid, this.$set, cVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v4, types: [T, java.lang.Integer] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object b10;
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            Context context = this.$context;
            String str = this.$uuid;
            boolean z10 = this.$set;
            try {
                Result.a aVar = Result.f34166a;
                Ref$LongRef ref$LongRef = new Ref$LongRef();
                Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                Cursor query = context.getContentResolver().query(CallLog.Calls.CONTENT_URI, new String[]{BreenoCallContract.BaseColumns._ID, "features"}, "virtual_call_id=?", new String[]{str}, null);
                q qVar = null;
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            ref$LongRef.element = query.getLong(0);
                            ref$ObjectRef.element = C1467a.d(query.getInt(1));
                        }
                        q qVar2 = q.f35511a;
                        kotlin.io.a.a(query, null);
                    } finally {
                    }
                }
                Integer num = (Integer) ref$ObjectRef.element;
                if (num != null) {
                    BreenoCallSummaryUtils.updateCallSummaryFeatureFlag(context, ref$LongRef.element, num.intValue(), z10);
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
        return ((BreenoCallSummaryUtils$setCallSummaryFeatureFlag$2) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
