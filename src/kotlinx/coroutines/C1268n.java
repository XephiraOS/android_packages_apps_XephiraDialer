package kotlinx.coroutines;

import com.android.incallui.OplusPhoneCapabilities;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.InterfaceC1265l0;
import kotlinx.coroutines.internal.C1258i;
import p9.InterfaceC1469c;

/* compiled from: CancellableContinuationImpl.kt */
/* renamed from: kotlinx.coroutines.n, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C1268n<T> extends O<T> implements InterfaceC1266m<T>, InterfaceC1469c, Q0 {

    /* renamed from: f, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f34548f = AtomicIntegerFieldUpdater.newUpdater(C1268n.class, "_decisionAndIndex");

    /* renamed from: g, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f34549g = AtomicReferenceFieldUpdater.newUpdater(C1268n.class, Object.class, "_state");

    /* renamed from: h, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f34550h = AtomicReferenceFieldUpdater.newUpdater(C1268n.class, Object.class, "_parentHandle");
    private volatile int _decisionAndIndex;
    private volatile Object _parentHandle;
    private volatile Object _state;

    /* renamed from: d, reason: collision with root package name */
    public final kotlin.coroutines.c<T> f34551d;

    /* renamed from: e, reason: collision with root package name */
    public final CoroutineContext f34552e;

    /* JADX WARN: Multi-variable type inference failed */
    public C1268n(kotlin.coroutines.c<? super T> cVar, int i10) {
        super(i10);
        this.f34551d = cVar;
        this.f34552e = cVar.getContext();
        this._decisionAndIndex = 536870911;
        this._state = C1238d.f34419a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void M(C1268n c1268n, Object obj, int i10, v9.l lVar, int i11, Object obj2) {
        if (obj2 == null) {
            if ((i11 & 4) != 0) {
                lVar = null;
            }
            c1268n.L(obj, i10, lVar);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
    }

    public void A() {
        T B10 = B();
        if (B10 != null && D()) {
            B10.b();
            f34550h.set(this, y0.f34653a);
        }
    }

    public final T B() {
        InterfaceC1265l0 interfaceC1265l0 = (InterfaceC1265l0) getContext().a(InterfaceC1265l0.f34546v);
        if (interfaceC1265l0 == null) {
            return null;
        }
        T d10 = InterfaceC1265l0.a.d(interfaceC1265l0, true, false, new r(this), 2, null);
        f34550h.compareAndSet(this, null, d10);
        return d10;
    }

    public final void C(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f34549g;
        while (true) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof C1238d) {
                if (f34549g.compareAndSet(this, obj2, obj)) {
                    return;
                }
            } else if ((obj2 instanceof AbstractC1262k) || (obj2 instanceof kotlinx.coroutines.internal.z)) {
                G(obj, obj2);
            } else {
                if (obj2 instanceof C1282x) {
                    C1282x c1282x = (C1282x) obj2;
                    if (!c1282x.b()) {
                        G(obj, obj2);
                    }
                    if (obj2 instanceof C1274q) {
                        Throwable th = null;
                        if (!(obj2 instanceof C1282x)) {
                            c1282x = null;
                        }
                        if (c1282x != null) {
                            th = c1282x.f34650a;
                        }
                        if (obj instanceof AbstractC1262k) {
                            n((AbstractC1262k) obj, th);
                            return;
                        } else {
                            kotlin.jvm.internal.i.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>");
                            p((kotlinx.coroutines.internal.z) obj, th);
                            return;
                        }
                    }
                    return;
                }
                if (obj2 instanceof C1281w) {
                    C1281w c1281w = (C1281w) obj2;
                    if (c1281w.f34645b != null) {
                        G(obj, obj2);
                    }
                    if (obj instanceof kotlinx.coroutines.internal.z) {
                        return;
                    }
                    kotlin.jvm.internal.i.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                    AbstractC1262k abstractC1262k = (AbstractC1262k) obj;
                    if (c1281w.c()) {
                        n(abstractC1262k, c1281w.f34648e);
                        return;
                    } else {
                        if (f34549g.compareAndSet(this, obj2, C1281w.b(c1281w, null, abstractC1262k, null, null, null, 29, null))) {
                            return;
                        }
                    }
                } else {
                    if (obj instanceof kotlinx.coroutines.internal.z) {
                        return;
                    }
                    kotlin.jvm.internal.i.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                    if (f34549g.compareAndSet(this, obj2, new C1281w(obj2, (AbstractC1262k) obj, null, null, null, 28, null))) {
                        return;
                    }
                }
            }
        }
    }

    public boolean D() {
        return !(y() instanceof z0);
    }

    public final boolean E() {
        if (P.c(this.f34330c)) {
            kotlin.coroutines.c<T> cVar = this.f34551d;
            kotlin.jvm.internal.i.d(cVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
            if (((C1258i) cVar).p()) {
                return true;
            }
        }
        return false;
    }

    public final AbstractC1262k F(v9.l<? super Throwable, m9.q> lVar) {
        if (lVar instanceof AbstractC1262k) {
            return (AbstractC1262k) lVar;
        }
        return new C1249i0(lVar);
    }

    public final void G(Object obj, Object obj2) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + obj + ", already has " + obj2).toString());
    }

    public String H() {
        return "CancellableContinuation";
    }

    public final void I(Throwable th) {
        if (r(th)) {
            return;
        }
        q(th);
        t();
    }

    public final void J() {
        C1258i c1258i;
        Throwable s10;
        kotlin.coroutines.c<T> cVar = this.f34551d;
        if (cVar instanceof C1258i) {
            c1258i = (C1258i) cVar;
        } else {
            c1258i = null;
        }
        if (c1258i != null && (s10 = c1258i.s(this)) != null) {
            s();
            q(s10);
        }
    }

    public final boolean K() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f34549g;
        Object obj = atomicReferenceFieldUpdater.get(this);
        if ((obj instanceof C1281w) && ((C1281w) obj).f34647d != null) {
            s();
            return false;
        }
        f34548f.set(this, 536870911);
        atomicReferenceFieldUpdater.set(this, C1238d.f34419a);
        return true;
    }

    public final void L(Object obj, int i10, v9.l<? super Throwable, m9.q> lVar) {
        Object obj2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f34549g;
        do {
            obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof z0) {
            } else {
                if (obj2 instanceof C1274q) {
                    C1274q c1274q = (C1274q) obj2;
                    if (c1274q.c()) {
                        if (lVar != null) {
                            o(lVar, c1274q.f34650a);
                            return;
                        }
                        return;
                    }
                }
                l(obj);
                throw new KotlinNothingValueException();
            }
        } while (!f34549g.compareAndSet(this, obj2, N((z0) obj2, obj, i10, lVar, null)));
        t();
        u(i10);
    }

    public final Object N(z0 z0Var, Object obj, int i10, v9.l<? super Throwable, m9.q> lVar, Object obj2) {
        AbstractC1262k abstractC1262k;
        if (!(obj instanceof C1282x)) {
            if (P.b(i10) || obj2 != null) {
                if (lVar != null || (z0Var instanceof AbstractC1262k) || obj2 != null) {
                    if (z0Var instanceof AbstractC1262k) {
                        abstractC1262k = (AbstractC1262k) z0Var;
                    } else {
                        abstractC1262k = null;
                    }
                    return new C1281w(obj, abstractC1262k, lVar, obj2, null, 16, null);
                }
                return obj;
            }
            return obj;
        }
        return obj;
    }

    public final boolean O() {
        int i10;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f34548f;
        do {
            i10 = atomicIntegerFieldUpdater.get(this);
            int i11 = i10 >> 29;
            if (i11 != 0) {
                if (i11 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f34548f.compareAndSet(this, i10, 1073741824 + (536870911 & i10)));
        return true;
    }

    public final kotlinx.coroutines.internal.C P(Object obj, Object obj2, v9.l<? super Throwable, m9.q> lVar) {
        Object obj3;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f34549g;
        do {
            obj3 = atomicReferenceFieldUpdater.get(this);
            if (obj3 instanceof z0) {
            } else {
                if (!(obj3 instanceof C1281w) || obj2 == null || ((C1281w) obj3).f34647d != obj2) {
                    return null;
                }
                return C1270o.f34554a;
            }
        } while (!f34549g.compareAndSet(this, obj3, N((z0) obj3, obj, this.f34330c, lVar, obj2)));
        t();
        return C1270o.f34554a;
    }

    public final boolean Q() {
        int i10;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f34548f;
        do {
            i10 = atomicIntegerFieldUpdater.get(this);
            int i11 = i10 >> 29;
            if (i11 != 0) {
                if (i11 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!f34548f.compareAndSet(this, i10, OplusPhoneCapabilities.MTK_CAPABILITY_VIDEO_RINGTONE + (536870911 & i10)));
        return true;
    }

    @Override // kotlinx.coroutines.O
    public void a(Object obj, Throwable th) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f34549g;
        while (true) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (!(obj2 instanceof z0)) {
                if (obj2 instanceof C1282x) {
                    return;
                }
                if (obj2 instanceof C1281w) {
                    C1281w c1281w = (C1281w) obj2;
                    if (!c1281w.c()) {
                        if (f34549g.compareAndSet(this, obj2, C1281w.b(c1281w, null, null, null, null, th, 15, null))) {
                            c1281w.d(this, th);
                            return;
                        }
                    } else {
                        throw new IllegalStateException("Must be called at most once".toString());
                    }
                } else if (f34549g.compareAndSet(this, obj2, new C1281w(obj2, null, null, null, th, 14, null))) {
                    return;
                }
            } else {
                throw new IllegalStateException("Not completed".toString());
            }
        }
    }

    @Override // kotlinx.coroutines.InterfaceC1266m
    public void b(T t10, v9.l<? super Throwable, m9.q> lVar) {
        L(t10, this.f34330c, lVar);
    }

    @Override // kotlinx.coroutines.Q0
    public void c(kotlinx.coroutines.internal.z<?> zVar, int i10) {
        int i11;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f34548f;
        do {
            i11 = atomicIntegerFieldUpdater.get(this);
            if ((i11 & 536870911) != 536870911) {
                throw new IllegalStateException("invokeOnCancellation should be called at most once".toString());
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i11, ((i11 >> 29) << 29) + i10));
        C(zVar);
    }

    @Override // kotlinx.coroutines.O
    public final kotlin.coroutines.c<T> d() {
        return this.f34551d;
    }

    @Override // kotlinx.coroutines.O
    public Throwable e(Object obj) {
        Throwable e10 = super.e(obj);
        if (e10 == null) {
            return null;
        }
        return e10;
    }

    @Override // kotlinx.coroutines.InterfaceC1266m
    public Object f(T t10, Object obj, v9.l<? super Throwable, m9.q> lVar) {
        return P(t10, obj, lVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.O
    public <T> T g(Object obj) {
        if (obj instanceof C1281w) {
            return (T) ((C1281w) obj).f34644a;
        }
        return obj;
    }

    @Override // p9.InterfaceC1469c
    public InterfaceC1469c getCallerFrame() {
        kotlin.coroutines.c<T> cVar = this.f34551d;
        if (cVar instanceof InterfaceC1469c) {
            return (InterfaceC1469c) cVar;
        }
        return null;
    }

    @Override // kotlin.coroutines.c
    public CoroutineContext getContext() {
        return this.f34552e;
    }

    @Override // kotlinx.coroutines.InterfaceC1266m
    public void h(CoroutineDispatcher coroutineDispatcher, T t10) {
        C1258i c1258i;
        int i10;
        kotlin.coroutines.c<T> cVar = this.f34551d;
        CoroutineDispatcher coroutineDispatcher2 = null;
        if (cVar instanceof C1258i) {
            c1258i = (C1258i) cVar;
        } else {
            c1258i = null;
        }
        if (c1258i != null) {
            coroutineDispatcher2 = c1258i.f34511d;
        }
        if (coroutineDispatcher2 == coroutineDispatcher) {
            i10 = 4;
        } else {
            i10 = this.f34330c;
        }
        M(this, t10, i10, null, 4, null);
    }

    @Override // kotlinx.coroutines.InterfaceC1266m
    public void i(v9.l<? super Throwable, m9.q> lVar) {
        C(F(lVar));
    }

    @Override // kotlinx.coroutines.O
    public Object k() {
        return y();
    }

    public final Void l(Object obj) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
    }

    @Override // kotlinx.coroutines.InterfaceC1266m
    public void m(Object obj) {
        u(this.f34330c);
    }

    public final void n(AbstractC1262k abstractC1262k, Throwable th) {
        try {
            abstractC1262k.f(th);
        } catch (Throwable th2) {
            D.a(getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void o(v9.l<? super Throwable, m9.q> lVar, Throwable th) {
        try {
            lVar.invoke(th);
        } catch (Throwable th2) {
            D.a(getContext(), new CompletionHandlerException("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    public final void p(kotlinx.coroutines.internal.z<?> zVar, Throwable th) {
        int i10 = f34548f.get(this) & 536870911;
        if (i10 != 536870911) {
            try {
                zVar.o(i10, th, getContext());
                return;
            } catch (Throwable th2) {
                D.a(getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
                return;
            }
        }
        throw new IllegalStateException("The index for Segment.onCancellation(..) is broken".toString());
    }

    public boolean q(Throwable th) {
        Object obj;
        boolean z10;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f34549g;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
            z10 = false;
            if (!(obj instanceof z0)) {
                return false;
            }
            if ((obj instanceof AbstractC1262k) || (obj instanceof kotlinx.coroutines.internal.z)) {
                z10 = true;
            }
        } while (!f34549g.compareAndSet(this, obj, new C1274q(this, th, z10)));
        z0 z0Var = (z0) obj;
        if (z0Var instanceof AbstractC1262k) {
            n((AbstractC1262k) obj, th);
        } else if (z0Var instanceof kotlinx.coroutines.internal.z) {
            p((kotlinx.coroutines.internal.z) obj, th);
        }
        t();
        u(this.f34330c);
        return true;
    }

    public final boolean r(Throwable th) {
        if (!E()) {
            return false;
        }
        kotlin.coroutines.c<T> cVar = this.f34551d;
        kotlin.jvm.internal.i.d(cVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        return ((C1258i) cVar).q(th);
    }

    @Override // kotlin.coroutines.c
    public void resumeWith(Object obj) {
        M(this, A.b(obj, this), this.f34330c, null, 4, null);
    }

    public final void s() {
        T w10 = w();
        if (w10 == null) {
            return;
        }
        w10.b();
        f34550h.set(this, y0.f34653a);
    }

    public final void t() {
        if (!E()) {
            s();
        }
    }

    public String toString() {
        return H() + '(' + G.c(this.f34551d) + "){" + z() + "}@" + G.b(this);
    }

    public final void u(int i10) {
        if (O()) {
            return;
        }
        P.a(this, i10);
    }

    public Throwable v(InterfaceC1265l0 interfaceC1265l0) {
        return interfaceC1265l0.B();
    }

    public final T w() {
        return (T) f34550h.get(this);
    }

    public final Object x() {
        InterfaceC1265l0 interfaceC1265l0;
        Object c10;
        boolean E10 = E();
        if (Q()) {
            if (w() == null) {
                B();
            }
            if (E10) {
                J();
            }
            c10 = kotlin.coroutines.intrinsics.b.c();
            return c10;
        }
        if (E10) {
            J();
        }
        Object y10 = y();
        if (!(y10 instanceof C1282x)) {
            if (P.b(this.f34330c) && (interfaceC1265l0 = (InterfaceC1265l0) getContext().a(InterfaceC1265l0.f34546v)) != null && !interfaceC1265l0.c()) {
                CancellationException B10 = interfaceC1265l0.B();
                a(y10, B10);
                throw B10;
            }
            return g(y10);
        }
        throw ((C1282x) y10).f34650a;
    }

    public final Object y() {
        return f34549g.get(this);
    }

    public final String z() {
        Object y10 = y();
        if (y10 instanceof z0) {
            return "Active";
        }
        if (y10 instanceof C1274q) {
            return "Cancelled";
        }
        return "Completed";
    }
}
