package com.oplus.foundation.appsupport.lifecycle;

import androidx.lifecycle.InterfaceC0492o;
import androidx.lifecycle.PausingDispatcherKt;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import kotlinx.coroutines.flow.a;
import m9.q;
import p9.InterfaceC1470d;
import v9.l;
import v9.p;

/* compiled from: FlowExt.kt */
@InterfaceC1470d(c = "com.oplus.foundation.appsupport.lifecycle.FlowExtKt$observeWhenStarted$1", f = "FlowExt.kt", l = {63}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class FlowExtKt$observeWhenStarted$1 extends SuspendLambda implements p<E, c<? super q>, Object> {
    final /* synthetic */ l<V, q> $block;
    final /* synthetic */ InterfaceC0492o $lifecycleOwner;
    final /* synthetic */ a<V> $this_observeWhenStarted;
    int label;

    /* compiled from: FlowExt.kt */
    @InterfaceC1470d(c = "com.oplus.foundation.appsupport.lifecycle.FlowExtKt$observeWhenStarted$1$1", f = "FlowExt.kt", l = {64}, m = "invokeSuspend")
    /* renamed from: com.oplus.foundation.appsupport.lifecycle.FlowExtKt$observeWhenStarted$1$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements p<E, c<? super q>, Object> {
        final /* synthetic */ l<V, q> $block;
        final /* synthetic */ a<V> $this_observeWhenStarted;
        int label;

        /* JADX INFO: Add missing generic type declarations: [V] */
        /* compiled from: FlowExt.kt */
        @InterfaceC1470d(c = "com.oplus.foundation.appsupport.lifecycle.FlowExtKt$observeWhenStarted$1$1$1", f = "FlowExt.kt", l = {}, m = "invokeSuspend")
        /* renamed from: com.oplus.foundation.appsupport.lifecycle.FlowExtKt$observeWhenStarted$1$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C02621<V> extends SuspendLambda implements p<V, c<? super q>, Object> {
            final /* synthetic */ l<V, q> $block;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C02621(l<? super V, q> lVar, c<? super C02621> cVar) {
                super(2, cVar);
                this.$block = lVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final c<q> create(Object obj, c<?> cVar) {
                C02621 c02621 = new C02621(this.$block, cVar);
                c02621.L$0 = obj;
                return c02621;
            }

            @Override // v9.p
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public final Object invoke(V v10, c<? super q> cVar) {
                return ((C02621) create(v10, cVar)).invokeSuspend(q.f35511a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                b.c();
                if (this.label == 0) {
                    kotlin.b.b(obj);
                    this.$block.invoke(this.L$0);
                    return q.f35511a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(a<? extends V> aVar, l<? super V, q> lVar, c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$this_observeWhenStarted = aVar;
            this.$block = lVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final c<q> create(Object obj, c<?> cVar) {
            return new AnonymousClass1(this.$this_observeWhenStarted, this.$block, cVar);
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
                a e10 = kotlinx.coroutines.flow.c.e(this.$this_observeWhenStarted);
                C02621 c02621 = new C02621(this.$block, null);
                this.label = 1;
                if (kotlinx.coroutines.flow.c.d(e10, c02621, this) == c10) {
                    return c10;
                }
            }
            return q.f35511a;
        }

        @Override // v9.p
        public final Object invoke(E e10, c<? super q> cVar) {
            return ((AnonymousClass1) create(e10, cVar)).invokeSuspend(q.f35511a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowExtKt$observeWhenStarted$1(InterfaceC0492o interfaceC0492o, a<? extends V> aVar, l<? super V, q> lVar, c<? super FlowExtKt$observeWhenStarted$1> cVar) {
        super(2, cVar);
        this.$lifecycleOwner = interfaceC0492o;
        this.$this_observeWhenStarted = aVar;
        this.$block = lVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<q> create(Object obj, c<?> cVar) {
        return new FlowExtKt$observeWhenStarted$1(this.$lifecycleOwner, this.$this_observeWhenStarted, this.$block, cVar);
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
            InterfaceC0492o interfaceC0492o = this.$lifecycleOwner;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_observeWhenStarted, this.$block, null);
            this.label = 1;
            if (PausingDispatcherKt.b(interfaceC0492o, anonymousClass1, this) == c10) {
                return c10;
            }
        }
        return q.f35511a;
    }

    @Override // v9.p
    public final Object invoke(E e10, c<? super q> cVar) {
        return ((FlowExtKt$observeWhenStarted$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
