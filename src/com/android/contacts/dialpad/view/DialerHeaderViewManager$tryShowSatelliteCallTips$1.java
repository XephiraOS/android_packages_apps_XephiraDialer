package com.android.contacts.dialpad.view;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import p9.InterfaceC1470d;

/* compiled from: DialerHeaderViewManager.kt */
@InterfaceC1470d(c = "com.android.contacts.dialpad.view.DialerHeaderViewManager", f = "DialerHeaderViewManager.kt", l = {1040}, m = "tryShowSatelliteCallTips")
/* loaded from: classes.dex */
public final class DialerHeaderViewManager$tryShowSatelliteCallTips$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DialerHeaderViewManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialerHeaderViewManager$tryShowSatelliteCallTips$1(DialerHeaderViewManager dialerHeaderViewManager, kotlin.coroutines.c<? super DialerHeaderViewManager$tryShowSatelliteCallTips$1> cVar) {
        super(cVar);
        this.this$0 = dialerHeaderViewManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object D02;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        D02 = this.this$0.D0(null, this);
        return D02;
    }
}
