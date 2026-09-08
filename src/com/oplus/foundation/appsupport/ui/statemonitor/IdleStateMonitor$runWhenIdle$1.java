package com.oplus.foundation.appsupport.ui.statemonitor;

import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import kotlinx.coroutines.flow.m;
import m9.q;
import p9.InterfaceC1470d;
import v9.InterfaceC1637a;
import v9.p;

/* compiled from: IdleStateMonitor.kt */
@InterfaceC1470d(c = "com.oplus.foundation.appsupport.ui.statemonitor.IdleStateMonitor$runWhenIdle$1", f = "IdleStateMonitor.kt", l = {27}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class IdleStateMonitor$runWhenIdle$1 extends SuspendLambda implements p<E, c<? super q>, Object> {
    int label;
    final /* synthetic */ IdleStateMonitor this$0;

    /* compiled from: IdleStateMonitor.kt */
    @InterfaceC1470d(c = "com.oplus.foundation.appsupport.ui.statemonitor.IdleStateMonitor$runWhenIdle$1$1", f = "IdleStateMonitor.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.oplus.foundation.appsupport.ui.statemonitor.IdleStateMonitor$runWhenIdle$1$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements p<a, c<? super q>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ IdleStateMonitor this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(IdleStateMonitor idleStateMonitor, c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.this$0 = idleStateMonitor;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final c<q> create(Object obj, c<?> cVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, cVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // v9.p
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public final Object invoke(a aVar, c<? super q> cVar) {
            return ((AnonymousClass1) create(aVar, cVar)).invokeSuspend(q.f35511a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            InterfaceC1637a interfaceC1637a;
            b.c();
            if (this.label == 0) {
                kotlin.b.b(obj);
                if (((a) this.L$0).a()) {
                    interfaceC1637a = this.this$0.f28208b;
                    if (interfaceC1637a != null) {
                        interfaceC1637a.invoke();
                    }
                    this.this$0.f28208b = null;
                }
                return q.f35511a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IdleStateMonitor$runWhenIdle$1(IdleStateMonitor idleStateMonitor, c<? super IdleStateMonitor$runWhenIdle$1> cVar) {
        super(2, cVar);
        this.this$0 = idleStateMonitor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<q> create(Object obj, c<?> cVar) {
        return new IdleStateMonitor$runWhenIdle$1(this.this$0, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c10;
        c10 = b.c();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 == 1) {
                kotlin.b.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            kotlin.b.b(obj);
            m<a> c11 = this.this$0.c();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, null);
            this.label = 1;
            if (kotlinx.coroutines.flow.c.d(c11, anonymousClass1, this) == c10) {
                return c10;
            }
        }
        return q.f35511a;
    }

    @Override // v9.p
    public final Object invoke(E e10, c<? super q> cVar) {
        return ((IdleStateMonitor$runWhenIdle$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
