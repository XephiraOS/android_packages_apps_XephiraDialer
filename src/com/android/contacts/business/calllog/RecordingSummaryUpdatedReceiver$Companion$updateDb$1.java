package com.android.contacts.business.calllog;

import android.content.Context;
import com.android.contacts.business.calllog.RecordingSummaryUpdatedReceiver;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: RecordingSummaryUpdatedReceiver.kt */
@InterfaceC1470d(c = "com.android.contacts.business.calllog.RecordingSummaryUpdatedReceiver$Companion$updateDb$1", f = "RecordingSummaryUpdatedReceiver.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class RecordingSummaryUpdatedReceiver$Companion$updateDb$1 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
    final /* synthetic */ Context $context;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecordingSummaryUpdatedReceiver$Companion$updateDb$1(Context context, kotlin.coroutines.c<? super RecordingSummaryUpdatedReceiver$Companion$updateDb$1> cVar) {
        super(2, cVar);
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new RecordingSummaryUpdatedReceiver$Companion$updateDb$1(this.$context, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            RecordingSummaryUpdatedReceiver.Companion companion = RecordingSummaryUpdatedReceiver.f13694a;
            companion.e(this.$context, false);
            companion.e(this.$context, true);
            return q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
        return ((RecordingSummaryUpdatedReceiver$Companion$updateDb$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
