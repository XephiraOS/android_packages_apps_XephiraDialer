package com.android.contacts.dialpad.view;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import p9.InterfaceC1470d;

/* compiled from: DialerHeaderViewManager.kt */
@InterfaceC1470d(c = "com.android.contacts.dialpad.view.DialerHeaderViewManager", f = "DialerHeaderViewManager.kt", l = {1300}, m = "tryShowNewCallTips")
/* loaded from: classes.dex */
public final class DialerHeaderViewManager$tryShowNewCallTips$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DialerHeaderViewManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialerHeaderViewManager$tryShowNewCallTips$1(DialerHeaderViewManager dialerHeaderViewManager, kotlin.coroutines.c<? super DialerHeaderViewManager$tryShowNewCallTips$1> cVar) {
        super(cVar);
        this.this$0 = dialerHeaderViewManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object y02;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        y02 = this.this$0.y0(null, this);
        return y02;
    }
}
