package com.customize.contacts.simcontacts;

import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.customize.contacts.util.b0;
import com.customize.contacts.util.c0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: SimStateReceiver.kt */
@InterfaceC1470d(c = "com.customize.contacts.simcontacts.SimStateReceiver$onReceive$1", f = "SimStateReceiver.kt", l = {76}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class SimStateReceiver$onReceive$1 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Intent $intent;
    int label;
    final /* synthetic */ SimStateReceiver this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimStateReceiver$onReceive$1(Context context, SimStateReceiver simStateReceiver, Intent intent, kotlin.coroutines.c<? super SimStateReceiver$onReceive$1> cVar) {
        super(2, cVar);
        this.$context = context;
        this.this$0 = simStateReceiver;
        this.$intent = intent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new SimStateReceiver$onReceive$1(this.$context, this.this$0, this.$intent, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c10;
        Object c11;
        c10 = kotlin.coroutines.intrinsics.b.c();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 == 1) {
                kotlin.b.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            kotlin.b.b(obj);
            c0.v();
            b0.G0();
            b0.E0(this.$context, 0);
            b0.E0(this.$context, 1);
            Process.setThreadPriority(10);
            this.this$0.d(this.$context, this.$intent);
            SimStateReceiver simStateReceiver = this.this$0;
            Context context = this.$context;
            Intent intent = this.$intent;
            this.label = 1;
            c11 = simStateReceiver.c(context, intent, this);
            if (c11 == c10) {
                return c10;
            }
        }
        return q.f35511a;
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
        return ((SimStateReceiver$onReceive$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
