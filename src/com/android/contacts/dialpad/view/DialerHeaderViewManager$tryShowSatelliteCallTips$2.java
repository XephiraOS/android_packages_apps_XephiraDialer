package com.android.contacts.dialpad.view;

import android.content.Context;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlinx.coroutines.E;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: DialerHeaderViewManager.kt */
@InterfaceC1470d(c = "com.android.contacts.dialpad.view.DialerHeaderViewManager$tryShowSatelliteCallTips$2", f = "DialerHeaderViewManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class DialerHeaderViewManager$tryShowSatelliteCallTips$2 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Ref$BooleanRef $showSatelliteCallTips;
    int label;
    final /* synthetic */ DialerHeaderViewManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialerHeaderViewManager$tryShowSatelliteCallTips$2(Ref$BooleanRef ref$BooleanRef, DialerHeaderViewManager dialerHeaderViewManager, Context context, kotlin.coroutines.c<? super DialerHeaderViewManager$tryShowSatelliteCallTips$2> cVar) {
        super(2, cVar);
        this.$showSatelliteCallTips = ref$BooleanRef;
        this.this$0 = dialerHeaderViewManager;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new DialerHeaderViewManager$tryShowSatelliteCallTips$2(this.$showSatelliteCallTips, this.this$0, this.$context, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean W10;
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            Ref$BooleanRef ref$BooleanRef = this.$showSatelliteCallTips;
            W10 = this.this$0.W(this.$context);
            ref$BooleanRef.element = W10;
            return q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
        return ((DialerHeaderViewManager$tryShowSatelliteCallTips$2) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
