package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.C1268n;
import kotlinx.coroutines.C1283y;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.I0;
import kotlinx.coroutines.InterfaceC1266m;
import kotlinx.coroutines.O;
import kotlinx.coroutines.W;
import p9.InterfaceC1469c;

/* compiled from: DispatchedContinuation.kt */
/* renamed from: kotlinx.coroutines.internal.i, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1258i<T> extends O<T> implements InterfaceC1469c, kotlin.coroutines.c<T> {

    /* renamed from: h, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f34510h = AtomicReferenceFieldUpdater.newUpdater(C1258i.class, Object.class, "_reusableCancellableContinuation");
    private volatile Object _reusableCancellableContinuation;

    /* renamed from: d, reason: collision with root package name */
    public final CoroutineDispatcher f34511d;

    /* renamed from: e, reason: collision with root package name */
    public final kotlin.coroutines.c<T> f34512e;

    /* renamed from: f, reason: collision with root package name */
    public Object f34513f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f34514g;

    /* JADX WARN: Multi-variable type inference failed */
    public C1258i(CoroutineDispatcher coroutineDispatcher, kotlin.coroutines.c<? super T> cVar) {
        super(-1);
        this.f34511d = coroutineDispatcher;
        this.f34512e = cVar;
        this.f34513f = C1259j.a();
        this.f34514g = ThreadContextKt.b(getContext());
    }

    @Override // kotlinx.coroutines.O
    public void a(Object obj, Throwable th) {
        if (obj instanceof C1283y) {
            ((C1283y) obj).f34652b.invoke(th);
        }
    }

    @Override // p9.InterfaceC1469c
    public InterfaceC1469c getCallerFrame() {
        kotlin.coroutines.c<T> cVar = this.f34512e;
        if (cVar instanceof InterfaceC1469c) {
            return (InterfaceC1469c) cVar;
        }
        return null;
    }

    @Override // kotlin.coroutines.c
    public CoroutineContext getContext() {
        return this.f34512e.getContext();
    }

    @Override // kotlinx.coroutines.O
    public Object k() {
        Object obj = this.f34513f;
        this.f34513f = C1259j.a();
        return obj;
    }

    public final void l() {
        do {
        } while (f34510h.get(this) == C1259j.f34516b);
    }

    public final C1268n<T> n() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f34510h;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                f34510h.set(this, C1259j.f34516b);
                return null;
            }
            if (obj instanceof C1268n) {
                if (f34510h.compareAndSet(this, obj, C1259j.f34516b)) {
                    return (C1268n) obj;
                }
            } else if (obj != C1259j.f34516b && !(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        }
    }

    public final C1268n<?> o() {
        Object obj = f34510h.get(this);
        if (obj instanceof C1268n) {
            return (C1268n) obj;
        }
        return null;
    }

    public final boolean p() {
        if (f34510h.get(this) != null) {
            return true;
        }
        return false;
    }

    public final boolean q(Throwable th) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f34510h;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            C c10 = C1259j.f34516b;
            if (kotlin.jvm.internal.i.b(obj, c10)) {
                if (f34510h.compareAndSet(this, c10, th)) {
                    return true;
                }
            } else {
                if (obj instanceof Throwable) {
                    return true;
                }
                if (f34510h.compareAndSet(this, obj, null)) {
                    return false;
                }
            }
        }
    }

    public final void r() {
        l();
        C1268n<?> o10 = o();
        if (o10 != null) {
            o10.s();
        }
    }

    @Override // kotlin.coroutines.c
    public void resumeWith(Object obj) {
        CoroutineContext context = this.f34512e.getContext();
        Object d10 = kotlinx.coroutines.A.d(obj, null, 1, null);
        if (this.f34511d.g0(context)) {
            this.f34513f = d10;
            this.f34330c = 0;
            this.f34511d.f0(context, this);
            return;
        }
        W b10 = I0.f34322a.b();
        if (b10.s0()) {
            this.f34513f = d10;
            this.f34330c = 0;
            b10.m0(this);
            return;
        }
        b10.q0(true);
        try {
            CoroutineContext context2 = getContext();
            Object c10 = ThreadContextKt.c(context2, this.f34514g);
            try {
                this.f34512e.resumeWith(obj);
                m9.q qVar = m9.q.f35511a;
                do {
                } while (b10.v0());
            } finally {
                ThreadContextKt.a(context2, c10);
            }
        } catch (Throwable th) {
            try {
                j(th, null);
            } finally {
                b10.i0(true);
            }
        }
    }

    public final Throwable s(InterfaceC1266m<?> interfaceC1266m) {
        C c10;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f34510h;
        do {
            Object obj = atomicReferenceFieldUpdater.get(this);
            c10 = C1259j.f34516b;
            if (obj != c10) {
                if (obj instanceof Throwable) {
                    if (f34510h.compareAndSet(this, obj, null)) {
                        return (Throwable) obj;
                    }
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        } while (!f34510h.compareAndSet(this, c10, interfaceC1266m));
        return null;
    }

    public String toString() {
        return "DispatchedContinuation[" + this.f34511d + ", " + kotlinx.coroutines.G.c(this.f34512e) + ']';
    }

    @Override // kotlinx.coroutines.O
    public kotlin.coroutines.c<T> d() {
        return this;
    }
}
