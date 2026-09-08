package com.android.contacts.dialpad.view;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import p9.InterfaceC1470d;

/* compiled from: DialerHeaderViewManager.kt */
@InterfaceC1470d(c = "com.android.contacts.dialpad.view.DialerHeaderViewManager", f = "DialerHeaderViewManager.kt", l = {1278}, m = "tryShowNoNetworkCommTips")
/* loaded from: classes.dex */
public final class DialerHeaderViewManager$tryShowNoNetworkCommTips$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DialerHeaderViewManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialerHeaderViewManager$tryShowNoNetworkCommTips$1(DialerHeaderViewManager dialerHeaderViewManager, kotlin.coroutines.c<? super DialerHeaderViewManager$tryShowNoNetworkCommTips$1> cVar) {
        super(cVar);
        this.this$0 = dialerHeaderViewManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object z02;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        z02 = this.this$0.z0(0, null, this);
        return z02;
    }
}
