package com.customize.contacts.mediaplayer;

import com.customize.contacts.mediaplayer.RecordPlayerPresenter;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: RecordPlayerPresenter.kt */
@InterfaceC1470d(c = "com.customize.contacts.mediaplayer.RecordPlayerPresenter$PositionUpdater$startUpdating$1", f = "RecordPlayerPresenter.kt", l = {415, 441}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class RecordPlayerPresenter$PositionUpdater$startUpdating$1 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ RecordPlayerPresenter this$0;
    final /* synthetic */ RecordPlayerPresenter.PositionUpdater this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecordPlayerPresenter$PositionUpdater$startUpdating$1(RecordPlayerPresenter recordPlayerPresenter, RecordPlayerPresenter.PositionUpdater positionUpdater, kotlin.coroutines.c<? super RecordPlayerPresenter$PositionUpdater$startUpdating$1> cVar) {
        super(2, cVar);
        this.this$0 = recordPlayerPresenter;
        this.this$1 = positionUpdater;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        RecordPlayerPresenter$PositionUpdater$startUpdating$1 recordPlayerPresenter$PositionUpdater$startUpdating$1 = new RecordPlayerPresenter$PositionUpdater$startUpdating$1(this.this$0, this.this$1, cVar);
        recordPlayerPresenter$PositionUpdater$startUpdating$1.L$0 = obj;
        return recordPlayerPresenter$PositionUpdater$startUpdating$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0136 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0127 -> B:6:0x012a). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r26) {
        /*
            Method dump skipped, instructions count: 330
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.mediaplayer.RecordPlayerPresenter$PositionUpdater$startUpdating$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
        return ((RecordPlayerPresenter$PositionUpdater$startUpdating$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
