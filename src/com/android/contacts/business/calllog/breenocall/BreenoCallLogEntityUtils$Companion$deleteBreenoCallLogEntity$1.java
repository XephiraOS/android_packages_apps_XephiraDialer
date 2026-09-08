package com.android.contacts.business.calllog.breenocall;

import android.content.ContentUris;
import android.content.Context;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import m9.q;
import p9.C1467a;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: BreenoCallLogEntityUtils.kt */
@InterfaceC1470d(c = "com.android.contacts.business.calllog.breenocall.BreenoCallLogEntityUtils$Companion$deleteBreenoCallLogEntity$1", f = "BreenoCallLogEntityUtils.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class BreenoCallLogEntityUtils$Companion$deleteBreenoCallLogEntity$1 extends SuspendLambda implements p<E, c<? super q>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ long $id;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BreenoCallLogEntityUtils$Companion$deleteBreenoCallLogEntity$1(long j10, Context context, c<? super BreenoCallLogEntityUtils$Companion$deleteBreenoCallLogEntity$1> cVar) {
        super(2, cVar);
        this.$id = j10;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<q> create(Object obj, c<?> cVar) {
        return new BreenoCallLogEntityUtils$Companion$deleteBreenoCallLogEntity$1(this.$id, this.$context, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object b10;
        b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            long j10 = this.$id;
            Context context = this.$context;
            try {
                Result.a aVar = Result.f34166a;
                H7.b.b("BreenoCallLogEntityUtils", "deleteBreenoCallLogEntity id: " + j10);
                b10 = Result.b(C1467a.d(context.getContentResolver().delete(ContentUris.withAppendedId(BreenoCallContract.Call.CONTENT_URI, j10), null, null)));
            } catch (Throwable th) {
                Result.a aVar2 = Result.f34166a;
                b10 = Result.b(kotlin.b.a(th));
            }
            Throwable d10 = Result.d(b10);
            if (d10 != null) {
                H7.b.c("BreenoCallLogEntityUtils", "deleteBreenoCallLogEntity failed: " + d10);
            }
            return q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, c<? super q> cVar) {
        return ((BreenoCallLogEntityUtils$Companion$deleteBreenoCallLogEntity$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
