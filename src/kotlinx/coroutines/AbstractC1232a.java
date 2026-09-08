package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;

/* compiled from: AbstractCoroutine.kt */
/* renamed from: kotlinx.coroutines.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1232a<T> extends s0 implements InterfaceC1265l0, kotlin.coroutines.c<T>, E {

    /* renamed from: c, reason: collision with root package name */
    public final CoroutineContext f34353c;

    public AbstractC1232a(CoroutineContext coroutineContext, boolean z10, boolean z11) {
        super(z11);
        if (z10) {
            g0((InterfaceC1265l0) coroutineContext.a(InterfaceC1265l0.f34546v));
        }
        this.f34353c = coroutineContext.r(this);
    }

    @Override // kotlinx.coroutines.s0
    public String F() {
        return G.a(this) + " was cancelled";
    }

    public void J0(Object obj) {
        v(obj);
    }

    public final <R> void M0(CoroutineStart coroutineStart, R r10, v9.p<? super R, ? super kotlin.coroutines.c<? super T>, ? extends Object> pVar) {
        coroutineStart.b(pVar, r10, this);
    }

    @Override // kotlinx.coroutines.s0, kotlinx.coroutines.InterfaceC1265l0
    public boolean c() {
        return super.c();
    }

    @Override // kotlinx.coroutines.s0
    public final void f0(Throwable th) {
        D.a(this.f34353c, th);
    }

    @Override // kotlin.coroutines.c
    public final CoroutineContext getContext() {
        return this.f34353c;
    }

    @Override // kotlinx.coroutines.s0
    public String o0() {
        String b10 = CoroutineContextKt.b(this.f34353c);
        if (b10 == null) {
            return super.o0();
        }
        return '\"' + b10 + "\":" + super.o0();
    }

    @Override // kotlin.coroutines.c
    public final void resumeWith(Object obj) {
        Object m02 = m0(A.d(obj, null, 1, null));
        if (m02 == t0.f34636b) {
            return;
        }
        J0(m02);
    }

    @Override // kotlinx.coroutines.E
    public CoroutineContext s() {
        return this.f34353c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.s0
    public final void t0(Object obj) {
        if (obj instanceof C1282x) {
            C1282x c1282x = (C1282x) obj;
            K0(c1282x.f34650a, c1282x.a());
        } else {
            L0(obj);
        }
    }

    public void L0(T t10) {
    }

    public void K0(Throwable th, boolean z10) {
    }
}
