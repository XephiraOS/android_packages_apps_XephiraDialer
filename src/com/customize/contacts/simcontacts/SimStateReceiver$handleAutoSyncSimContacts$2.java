package com.customize.contacts.simcontacts;

import android.content.Context;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import m1.AbstractC1316l;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: SimStateReceiver.kt */
@InterfaceC1470d(c = "com.customize.contacts.simcontacts.SimStateReceiver$handleAutoSyncSimContacts$2", f = "SimStateReceiver.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class SimStateReceiver$handleAutoSyncSimContacts$2 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
    final /* synthetic */ Context $context;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimStateReceiver$handleAutoSyncSimContacts$2(Context context, kotlin.coroutines.c<? super SimStateReceiver$handleAutoSyncSimContacts$2> cVar) {
        super(2, cVar);
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new SimStateReceiver$handleAutoSyncSimContacts$2(this.$context, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            AbstractC1316l.f(this.$context).c(true);
            return q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
        return ((SimStateReceiver$handleAutoSyncSimContacts$2) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
