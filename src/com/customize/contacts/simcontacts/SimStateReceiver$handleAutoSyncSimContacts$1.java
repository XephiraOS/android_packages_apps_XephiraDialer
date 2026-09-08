package com.customize.contacts.simcontacts;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import p9.InterfaceC1470d;

/* compiled from: SimStateReceiver.kt */
@InterfaceC1470d(c = "com.customize.contacts.simcontacts.SimStateReceiver", f = "SimStateReceiver.kt", l = {122}, m = "handleAutoSyncSimContacts")
/* loaded from: classes3.dex */
public final class SimStateReceiver$handleAutoSyncSimContacts$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SimStateReceiver this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimStateReceiver$handleAutoSyncSimContacts$1(SimStateReceiver simStateReceiver, kotlin.coroutines.c<? super SimStateReceiver$handleAutoSyncSimContacts$1> cVar) {
        super(cVar);
        this.this$0 = simStateReceiver;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c10;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        c10 = this.this$0.c(null, null, this);
        return c10;
    }
}
