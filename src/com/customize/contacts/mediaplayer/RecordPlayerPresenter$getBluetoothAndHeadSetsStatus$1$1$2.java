package com.customize.contacts.mediaplayer;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: RecordPlayerPresenter.kt */
@InterfaceC1470d(c = "com.customize.contacts.mediaplayer.RecordPlayerPresenter$getBluetoothAndHeadSetsStatus$1$1$2", f = "RecordPlayerPresenter.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class RecordPlayerPresenter$getBluetoothAndHeadSetsStatus$1$1$2 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
    int label;
    final /* synthetic */ RecordPlayerPresenter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecordPlayerPresenter$getBluetoothAndHeadSetsStatus$1$1$2(RecordPlayerPresenter recordPlayerPresenter, kotlin.coroutines.c<? super RecordPlayerPresenter$getBluetoothAndHeadSetsStatus$1$1$2> cVar) {
        super(2, cVar);
        this.this$0 = recordPlayerPresenter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new RecordPlayerPresenter$getBluetoothAndHeadSetsStatus$1$1$2(this.this$0, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        a aVar;
        boolean z10;
        a aVar2;
        boolean z11;
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            aVar = this.this$0.f21650d;
            z10 = this.this$0.f21663q;
            aVar.e(z10);
            aVar2 = this.this$0.f21650d;
            z11 = this.this$0.f21662p;
            aVar2.g(z11);
            return q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
        return ((RecordPlayerPresenter$getBluetoothAndHeadSetsStatus$1$1$2) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
