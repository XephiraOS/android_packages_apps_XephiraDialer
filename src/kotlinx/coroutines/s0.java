package kotlinx.coroutines;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.InterfaceC1265l0;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import p9.C1472f;

/* compiled from: JobSupport.kt */
/* loaded from: classes4.dex */
public class s0 implements InterfaceC1265l0, InterfaceC1279u, A0 {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f34558a = AtomicReferenceFieldUpdater.newUpdater(s0.class, Object.class, "_state");

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f34559b = AtomicReferenceFieldUpdater.newUpdater(s0.class, Object.class, "_parentHandle");
    private volatile Object _parentHandle;
    private volatile Object _state;

    /* compiled from: JobSupport.kt */
    /* loaded from: classes4.dex */
    public static final class a<T> extends C1268n<T> {

        /* renamed from: i, reason: collision with root package name */
        public final s0 f34560i;

        public a(kotlin.coroutines.c<? super T> cVar, s0 s0Var) {
            super(cVar, 1);
            this.f34560i = s0Var;
        }

        @Override // kotlinx.coroutines.C1268n
        public String H() {
            return "AwaitContinuation";
        }

        @Override // kotlinx.coroutines.C1268n
        public Throwable v(InterfaceC1265l0 interfaceC1265l0) {
            Throwable e10;
            Object d02 = this.f34560i.d0();
            if ((d02 instanceof c) && (e10 = ((c) d02).e()) != null) {
                return e10;
            }
            if (d02 instanceof C1282x) {
                return ((C1282x) d02).f34650a;
            }
            return interfaceC1265l0.B();
        }
    }

    /* compiled from: JobSupport.kt */
    /* loaded from: classes4.dex */
    public static final class b extends AbstractC1276r0 {

        /* renamed from: e, reason: collision with root package name */
        public final s0 f34561e;

        /* renamed from: f, reason: collision with root package name */
        public final c f34562f;

        /* renamed from: g, reason: collision with root package name */
        public final C1278t f34563g;

        /* renamed from: h, reason: collision with root package name */
        public final Object f34564h;

        public b(s0 s0Var, c cVar, C1278t c1278t, Object obj) {
            this.f34561e = s0Var;
            this.f34562f = cVar;
            this.f34563g = c1278t;
            this.f34564h = obj;
        }

        @Override // v9.l
        public /* bridge */ /* synthetic */ m9.q invoke(Throwable th) {
            u(th);
            return m9.q.f35511a;
        }

        @Override // kotlinx.coroutines.AbstractC1284z
        public void u(Throwable th) {
            this.f34561e.K(this.f34562f, this.f34563g, this.f34564h);
        }
    }

    /* compiled from: JobSupport.kt */
    /* loaded from: classes4.dex */
    public static final class c implements InterfaceC1245g0 {

        /* renamed from: b, reason: collision with root package name */
        public static final AtomicIntegerFieldUpdater f34565b = AtomicIntegerFieldUpdater.newUpdater(c.class, "_isCompleting");

        /* renamed from: c, reason: collision with root package name */
        public static final AtomicReferenceFieldUpdater f34566c = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_rootCause");

        /* renamed from: d, reason: collision with root package name */
        public static final AtomicReferenceFieldUpdater f34567d = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_exceptionsHolder");
        private volatile Object _exceptionsHolder;
        private volatile int _isCompleting;
        private volatile Object _rootCause;

        /* renamed from: a, reason: collision with root package name */
        public final x0 f34568a;

        public c(x0 x0Var, boolean z10, Throwable th) {
            this.f34568a = x0Var;
            this._isCompleting = z10 ? 1 : 0;
            this._rootCause = th;
        }

        public final void a(Throwable th) {
            Throwable e10 = e();
            if (e10 == null) {
                m(th);
                return;
            }
            if (th == e10) {
                return;
            }
            Object d10 = d();
            if (d10 == null) {
                l(th);
                return;
            }
            if (d10 instanceof Throwable) {
                if (th == d10) {
                    return;
                }
                ArrayList<Throwable> b10 = b();
                b10.add(d10);
                b10.add(th);
                l(b10);
                return;
            }
            if (d10 instanceof ArrayList) {
                ((ArrayList) d10).add(th);
                return;
            }
            throw new IllegalStateException(("State is " + d10).toString());
        }

        public final ArrayList<Throwable> b() {
            return new ArrayList<>(4);
        }

        @Override // kotlinx.coroutines.InterfaceC1245g0
        public boolean c() {
            if (e() == null) {
                return true;
            }
            return false;
        }

        public final Object d() {
            return f34567d.get(this);
        }

        public final Throwable e() {
            return (Throwable) f34566c.get(this);
        }

        @Override // kotlinx.coroutines.InterfaceC1245g0
        public x0 f() {
            return this.f34568a;
        }

        public final boolean g() {
            if (e() != null) {
                return true;
            }
            return false;
        }

        public final boolean h() {
            if (f34565b.get(this) != 0) {
                return true;
            }
            return false;
        }

        public final boolean i() {
            kotlinx.coroutines.internal.C c10;
            Object d10 = d();
            c10 = t0.f34639e;
            if (d10 == c10) {
                return true;
            }
            return false;
        }

        public final List<Throwable> j(Throwable th) {
            ArrayList<Throwable> arrayList;
            kotlinx.coroutines.internal.C c10;
            Object d10 = d();
            if (d10 == null) {
                arrayList = b();
            } else if (d10 instanceof Throwable) {
                ArrayList<Throwable> b10 = b();
                b10.add(d10);
                arrayList = b10;
            } else if (d10 instanceof ArrayList) {
                arrayList = (ArrayList) d10;
            } else {
                throw new IllegalStateException(("State is " + d10).toString());
            }
            Throwable e10 = e();
            if (e10 != null) {
                arrayList.add(0, e10);
            }
            if (th != null && !kotlin.jvm.internal.i.b(th, e10)) {
                arrayList.add(th);
            }
            c10 = t0.f34639e;
            l(c10);
            return arrayList;
        }

        public final void k(boolean z10) {
            f34565b.set(this, z10 ? 1 : 0);
        }

        public final void l(Object obj) {
            f34567d.set(this, obj);
        }

        public final void m(Throwable th) {
            f34566c.set(this, th);
        }

        public String toString() {
            return "Finishing[cancelling=" + g() + ", completing=" + h() + ", rootCause=" + e() + ", exceptions=" + d() + ", list=" + f() + ']';
        }
    }

    /* compiled from: LockFreeLinkedList.kt */
    /* loaded from: classes4.dex */
    public static final class d extends LockFreeLinkedListNode.a {

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ s0 f34569d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Object f34570e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(LockFreeLinkedListNode lockFreeLinkedListNode, s0 s0Var, Object obj) {
            super(lockFreeLinkedListNode);
            this.f34569d = s0Var;
            this.f34570e = obj;
        }

        @Override // kotlinx.coroutines.internal.AbstractC1251b
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public Object d(LockFreeLinkedListNode lockFreeLinkedListNode) {
            if (this.f34569d.d0() == this.f34570e) {
                return null;
            }
            return kotlinx.coroutines.internal.o.a();
        }
    }

    public s0(boolean z10) {
        this._state = z10 ? t0.f34641g : t0.f34640f;
    }

    public static /* synthetic */ CancellationException C0(s0 s0Var, Throwable th, String str, int i10, Object obj) {
        if (obj == null) {
            if ((i10 & 1) != 0) {
                str = null;
            }
            return s0Var.B0(th, str);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
    }

    public final boolean A(Object obj) {
        Object obj2;
        kotlinx.coroutines.internal.C c10;
        kotlinx.coroutines.internal.C c11;
        kotlinx.coroutines.internal.C c12;
        obj2 = t0.f34635a;
        if (!W() || (obj2 = D(obj)) != t0.f34636b) {
            c10 = t0.f34635a;
            if (obj2 == c10) {
                obj2 = l0(obj);
            }
            c11 = t0.f34635a;
            if (obj2 != c11 && obj2 != t0.f34636b) {
                c12 = t0.f34638d;
                if (obj2 == c12) {
                    return false;
                }
                v(obj2);
                return true;
            }
            return true;
        }
        return true;
    }

    public final String A0(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (cVar.g()) {
                return "Cancelling";
            }
            if (!cVar.h()) {
                return "Active";
            }
            return "Completing";
        }
        if (obj instanceof InterfaceC1245g0) {
            if (((InterfaceC1245g0) obj).c()) {
                return "Active";
            }
            return "New";
        }
        if (obj instanceof C1282x) {
            return "Cancelled";
        }
        return "Completed";
    }

    @Override // kotlinx.coroutines.InterfaceC1265l0
    public final CancellationException B() {
        Object d02 = d0();
        if (d02 instanceof c) {
            Throwable e10 = ((c) d02).e();
            if (e10 != null) {
                CancellationException B02 = B0(e10, G.a(this) + " is cancelling");
                if (B02 != null) {
                    return B02;
                }
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        if (!(d02 instanceof InterfaceC1245g0)) {
            if (d02 instanceof C1282x) {
                return C0(this, ((C1282x) d02).f34650a, null, 1, null);
            }
            return new JobCancellationException(G.a(this) + " has completed normally", null, this);
        }
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    public final CancellationException B0(Throwable th, String str) {
        CancellationException cancellationException;
        if (th instanceof CancellationException) {
            cancellationException = (CancellationException) th;
        } else {
            cancellationException = null;
        }
        if (cancellationException == null) {
            if (str == null) {
                str = F();
            }
            cancellationException = new JobCancellationException(str, th, this);
        }
        return cancellationException;
    }

    public void C(Throwable th) {
        A(th);
    }

    public final Object D(Object obj) {
        kotlinx.coroutines.internal.C c10;
        Object G02;
        kotlinx.coroutines.internal.C c11;
        do {
            Object d02 = d0();
            if (!(d02 instanceof InterfaceC1245g0) || ((d02 instanceof c) && ((c) d02).h())) {
                c10 = t0.f34635a;
                return c10;
            }
            G02 = G0(d02, new C1282x(M(obj), false, 2, null));
            c11 = t0.f34637c;
        } while (G02 == c11);
        return G02;
    }

    public final String D0() {
        return o0() + '{' + A0(d0()) + '}';
    }

    public final boolean E(Throwable th) {
        if (i0()) {
            return true;
        }
        boolean z10 = th instanceof CancellationException;
        InterfaceC1277s b02 = b0();
        if (b02 != null && b02 != y0.f34653a) {
            if (b02.e(th) || z10) {
                return true;
            }
            return false;
        }
        return z10;
    }

    public final boolean E0(InterfaceC1245g0 interfaceC1245g0, Object obj) {
        if (!f34558a.compareAndSet(this, interfaceC1245g0, t0.g(obj))) {
            return false;
        }
        s0(null);
        t0(obj);
        J(interfaceC1245g0, obj);
        return true;
    }

    public String F() {
        return "Job was cancelled";
    }

    public final boolean F0(InterfaceC1245g0 interfaceC1245g0, Throwable th) {
        x0 Y9 = Y(interfaceC1245g0);
        if (Y9 == null) {
            return false;
        }
        if (!f34558a.compareAndSet(this, interfaceC1245g0, new c(Y9, false, th))) {
            return false;
        }
        q0(Y9, th);
        return true;
    }

    public final Object G0(Object obj, Object obj2) {
        kotlinx.coroutines.internal.C c10;
        kotlinx.coroutines.internal.C c11;
        if (!(obj instanceof InterfaceC1245g0)) {
            c11 = t0.f34635a;
            return c11;
        }
        if (((obj instanceof V) || (obj instanceof AbstractC1276r0)) && !(obj instanceof C1278t) && !(obj2 instanceof C1282x)) {
            if (!E0((InterfaceC1245g0) obj, obj2)) {
                c10 = t0.f34637c;
                return c10;
            }
            return obj2;
        }
        return H0((InterfaceC1245g0) obj, obj2);
    }

    public boolean H(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        if (A(th) && T()) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Throwable, T] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public final Object H0(InterfaceC1245g0 interfaceC1245g0, Object obj) {
        c cVar;
        C1282x c1282x;
        kotlinx.coroutines.internal.C c10;
        kotlinx.coroutines.internal.C c11;
        kotlinx.coroutines.internal.C c12;
        x0 Y9 = Y(interfaceC1245g0);
        if (Y9 == null) {
            c12 = t0.f34637c;
            return c12;
        }
        ?? r22 = 0;
        if (interfaceC1245g0 instanceof c) {
            cVar = (c) interfaceC1245g0;
        } else {
            cVar = null;
        }
        if (cVar == null) {
            cVar = new c(Y9, false, null);
        }
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        synchronized (cVar) {
            if (cVar.h()) {
                c11 = t0.f34635a;
                return c11;
            }
            cVar.k(true);
            if (cVar != interfaceC1245g0 && !f34558a.compareAndSet(this, interfaceC1245g0, cVar)) {
                c10 = t0.f34637c;
                return c10;
            }
            boolean g10 = cVar.g();
            if (obj instanceof C1282x) {
                c1282x = (C1282x) obj;
            } else {
                c1282x = null;
            }
            if (c1282x != null) {
                cVar.a(c1282x.f34650a);
            }
            Throwable e10 = cVar.e();
            if (true ^ g10) {
                r22 = e10;
            }
            ref$ObjectRef.element = r22;
            m9.q qVar = m9.q.f35511a;
            if (r22 != 0) {
                q0(Y9, r22);
            }
            C1278t P10 = P(interfaceC1245g0);
            if (P10 != null && I0(cVar, P10, obj)) {
                return t0.f34636b;
            }
            return N(cVar, obj);
        }
    }

    @Override // kotlinx.coroutines.InterfaceC1279u
    public final void I(A0 a02) {
        A(a02);
    }

    public final boolean I0(c cVar, C1278t c1278t, Object obj) {
        while (InterfaceC1265l0.a.d(c1278t.f34634e, false, false, new b(this, cVar, c1278t, obj), 1, null) == y0.f34653a) {
            c1278t = p0(c1278t);
            if (c1278t == null) {
                return false;
            }
        }
        return true;
    }

    public final void J(InterfaceC1245g0 interfaceC1245g0, Object obj) {
        C1282x c1282x;
        InterfaceC1277s b02 = b0();
        if (b02 != null) {
            b02.b();
            y0(y0.f34653a);
        }
        Throwable th = null;
        if (obj instanceof C1282x) {
            c1282x = (C1282x) obj;
        } else {
            c1282x = null;
        }
        if (c1282x != null) {
            th = c1282x.f34650a;
        }
        if (interfaceC1245g0 instanceof AbstractC1276r0) {
            try {
                ((AbstractC1276r0) interfaceC1245g0).u(th);
                return;
            } catch (Throwable th2) {
                f0(new CompletionHandlerException("Exception in completion handler " + interfaceC1245g0 + " for " + this, th2));
                return;
            }
        }
        x0 f10 = interfaceC1245g0.f();
        if (f10 != null) {
            r0(f10, th);
        }
    }

    public final void K(c cVar, C1278t c1278t, Object obj) {
        C1278t p02 = p0(c1278t);
        if (p02 != null && I0(cVar, p02, obj)) {
            return;
        }
        v(N(cVar, obj));
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext L(CoroutineContext.b<?> bVar) {
        return InterfaceC1265l0.a.e(this, bVar);
    }

    public final Throwable M(Object obj) {
        if (obj == null || (obj instanceof Throwable)) {
            Throwable th = (Throwable) obj;
            if (th == null) {
                return new JobCancellationException(F(), null, this);
            }
            return th;
        }
        kotlin.jvm.internal.i.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((A0) obj).V();
    }

    public final Object N(c cVar, Object obj) {
        C1282x c1282x;
        Throwable th;
        boolean g10;
        Throwable R10;
        if (obj instanceof C1282x) {
            c1282x = (C1282x) obj;
        } else {
            c1282x = null;
        }
        if (c1282x != null) {
            th = c1282x.f34650a;
        } else {
            th = null;
        }
        synchronized (cVar) {
            g10 = cVar.g();
            List<Throwable> j10 = cVar.j(th);
            R10 = R(cVar, j10);
            if (R10 != null) {
                t(R10, j10);
            }
        }
        if (R10 != null && R10 != th) {
            obj = new C1282x(R10, false, 2, null);
        }
        if (R10 != null && (E(R10) || e0(R10))) {
            kotlin.jvm.internal.i.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
            ((C1282x) obj).b();
        }
        if (!g10) {
            s0(R10);
        }
        t0(obj);
        f34558a.compareAndSet(this, cVar, t0.g(obj));
        J(cVar, obj);
        return obj;
    }

    @Override // kotlinx.coroutines.InterfaceC1265l0
    public final T O(boolean z10, boolean z11, v9.l<? super Throwable, m9.q> lVar) {
        C1282x c1282x;
        AbstractC1276r0 n02 = n0(lVar, z10);
        while (true) {
            Object d02 = d0();
            if (d02 instanceof V) {
                V v10 = (V) d02;
                if (v10.c()) {
                    if (f34558a.compareAndSet(this, d02, n02)) {
                        return n02;
                    }
                } else {
                    v0(v10);
                }
            } else {
                Throwable th = null;
                if (d02 instanceof InterfaceC1245g0) {
                    x0 f10 = ((InterfaceC1245g0) d02).f();
                    if (f10 == null) {
                        kotlin.jvm.internal.i.d(d02, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                        w0((AbstractC1276r0) d02);
                    } else {
                        T t10 = y0.f34653a;
                        if (z10 && (d02 instanceof c)) {
                            synchronized (d02) {
                                try {
                                    th = ((c) d02).e();
                                    if (th != null) {
                                        if ((lVar instanceof C1278t) && !((c) d02).h()) {
                                        }
                                        m9.q qVar = m9.q.f35511a;
                                    }
                                    if (q(d02, f10, n02)) {
                                        if (th == null) {
                                            return n02;
                                        }
                                        t10 = n02;
                                        m9.q qVar2 = m9.q.f35511a;
                                    }
                                } catch (Throwable th2) {
                                    throw th2;
                                }
                            }
                        }
                        if (th != null) {
                            if (z11) {
                                lVar.invoke(th);
                            }
                            return t10;
                        }
                        if (q(d02, f10, n02)) {
                            return n02;
                        }
                    }
                } else {
                    if (z11) {
                        if (d02 instanceof C1282x) {
                            c1282x = (C1282x) d02;
                        } else {
                            c1282x = null;
                        }
                        if (c1282x != null) {
                            th = c1282x.f34650a;
                        }
                        lVar.invoke(th);
                    }
                    return y0.f34653a;
                }
            }
        }
    }

    public final C1278t P(InterfaceC1245g0 interfaceC1245g0) {
        C1278t c1278t;
        if (interfaceC1245g0 instanceof C1278t) {
            c1278t = (C1278t) interfaceC1245g0;
        } else {
            c1278t = null;
        }
        if (c1278t == null) {
            x0 f10 = interfaceC1245g0.f();
            if (f10 == null) {
                return null;
            }
            return p0(f10);
        }
        return c1278t;
    }

    public final Throwable Q(Object obj) {
        C1282x c1282x;
        if (obj instanceof C1282x) {
            c1282x = (C1282x) obj;
        } else {
            c1282x = null;
        }
        if (c1282x == null) {
            return null;
        }
        return c1282x.f34650a;
    }

    public final Throwable R(c cVar, List<? extends Throwable> list) {
        Object obj = null;
        if (list.isEmpty()) {
            if (!cVar.g()) {
                return null;
            }
            return new JobCancellationException(F(), null, this);
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (!(((Throwable) next) instanceof CancellationException)) {
                obj = next;
                break;
            }
        }
        Throwable th = (Throwable) obj;
        if (th != null) {
            return th;
        }
        return list.get(0);
    }

    public boolean T() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.Throwable] */
    @Override // kotlinx.coroutines.A0
    public CancellationException V() {
        CancellationException cancellationException;
        Object d02 = d0();
        CancellationException cancellationException2 = null;
        if (d02 instanceof c) {
            cancellationException = ((c) d02).e();
        } else if (d02 instanceof C1282x) {
            cancellationException = ((C1282x) d02).f34650a;
        } else if (!(d02 instanceof InterfaceC1245g0)) {
            cancellationException = null;
        } else {
            throw new IllegalStateException(("Cannot be cancelling child in this state: " + d02).toString());
        }
        if (cancellationException instanceof CancellationException) {
            cancellationException2 = cancellationException;
        }
        if (cancellationException2 == null) {
            return new JobCancellationException("Parent job is " + A0(d02), cancellationException, this);
        }
        return cancellationException2;
    }

    public boolean W() {
        return false;
    }

    @Override // kotlinx.coroutines.InterfaceC1265l0
    public final boolean X() {
        return !(d0() instanceof InterfaceC1245g0);
    }

    public final x0 Y(InterfaceC1245g0 interfaceC1245g0) {
        x0 f10 = interfaceC1245g0.f();
        if (f10 == null) {
            if (interfaceC1245g0 instanceof V) {
                return new x0();
            }
            if (interfaceC1245g0 instanceof AbstractC1276r0) {
                w0((AbstractC1276r0) interfaceC1245g0);
                return null;
            }
            throw new IllegalStateException(("State should have list: " + interfaceC1245g0).toString());
        }
        return f10;
    }

    @Override // kotlin.coroutines.CoroutineContext.a, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.a> E a(CoroutineContext.b<E> bVar) {
        return (E) InterfaceC1265l0.a.c(this, bVar);
    }

    public final InterfaceC1277s b0() {
        return (InterfaceC1277s) f34559b.get(this);
    }

    @Override // kotlinx.coroutines.InterfaceC1265l0
    public boolean c() {
        Object d02 = d0();
        if ((d02 instanceof InterfaceC1245g0) && ((InterfaceC1245g0) d02).c()) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.InterfaceC1265l0
    public final InterfaceC1277s c0(InterfaceC1279u interfaceC1279u) {
        T d10 = InterfaceC1265l0.a.d(this, true, false, new C1278t(interfaceC1279u), 2, null);
        kotlin.jvm.internal.i.d(d10, "null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
        return (InterfaceC1277s) d10;
    }

    public final Object d0() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f34558a;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof kotlinx.coroutines.internal.v)) {
                return obj;
            }
            ((kotlinx.coroutines.internal.v) obj).a(this);
        }
    }

    @Override // kotlinx.coroutines.InterfaceC1265l0, kotlinx.coroutines.channels.n
    public void e(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(F(), null, this);
        }
        C(cancellationException);
    }

    public boolean e0(Throwable th) {
        return false;
    }

    public final void g0(InterfaceC1265l0 interfaceC1265l0) {
        if (interfaceC1265l0 == null) {
            y0(y0.f34653a);
            return;
        }
        interfaceC1265l0.start();
        InterfaceC1277s c02 = interfaceC1265l0.c0(this);
        y0(c02);
        if (X()) {
            c02.b();
            y0(y0.f34653a);
        }
    }

    @Override // kotlin.coroutines.CoroutineContext.a
    public final CoroutineContext.b<?> getKey() {
        return InterfaceC1265l0.f34546v;
    }

    @Override // kotlinx.coroutines.InterfaceC1265l0
    public InterfaceC1265l0 getParent() {
        InterfaceC1277s b02 = b0();
        if (b02 != null) {
            return b02.getParent();
        }
        return null;
    }

    public final T h0(v9.l<? super Throwable, m9.q> lVar) {
        return O(false, true, lVar);
    }

    public boolean i0() {
        return false;
    }

    @Override // kotlinx.coroutines.InterfaceC1265l0
    public final boolean isCancelled() {
        Object d02 = d0();
        if (!(d02 instanceof C1282x) && (!(d02 instanceof c) || !((c) d02).g())) {
            return false;
        }
        return true;
    }

    public final boolean j0() {
        Object d02;
        do {
            d02 = d0();
            if (!(d02 instanceof InterfaceC1245g0)) {
                return false;
            }
        } while (z0(d02) < 0);
        return true;
    }

    public final Object k0(kotlin.coroutines.c<? super m9.q> cVar) {
        kotlin.coroutines.c b10;
        Object c10;
        Object c11;
        b10 = IntrinsicsKt__IntrinsicsJvmKt.b(cVar);
        C1268n c1268n = new C1268n(b10, 1);
        c1268n.A();
        C1272p.a(c1268n, h0(new C0(c1268n)));
        Object x10 = c1268n.x();
        c10 = kotlin.coroutines.intrinsics.b.c();
        if (x10 == c10) {
            C1472f.c(cVar);
        }
        c11 = kotlin.coroutines.intrinsics.b.c();
        if (x10 == c11) {
            return x10;
        }
        return m9.q.f35511a;
    }

    public final Object l0(Object obj) {
        kotlinx.coroutines.internal.C c10;
        kotlinx.coroutines.internal.C c11;
        kotlinx.coroutines.internal.C c12;
        kotlinx.coroutines.internal.C c13;
        kotlinx.coroutines.internal.C c14;
        kotlinx.coroutines.internal.C c15;
        Throwable th = null;
        Throwable th2 = null;
        while (true) {
            Object d02 = d0();
            if (d02 instanceof c) {
                synchronized (d02) {
                    if (((c) d02).i()) {
                        c11 = t0.f34638d;
                        return c11;
                    }
                    boolean g10 = ((c) d02).g();
                    if (obj != null || !g10) {
                        if (th2 == null) {
                            th2 = M(obj);
                        }
                        ((c) d02).a(th2);
                    }
                    Throwable e10 = ((c) d02).e();
                    if (!g10) {
                        th = e10;
                    }
                    if (th != null) {
                        q0(((c) d02).f(), th);
                    }
                    c10 = t0.f34635a;
                    return c10;
                }
            }
            if (!(d02 instanceof InterfaceC1245g0)) {
                c12 = t0.f34638d;
                return c12;
            }
            if (th2 == null) {
                th2 = M(obj);
            }
            InterfaceC1245g0 interfaceC1245g0 = (InterfaceC1245g0) d02;
            if (interfaceC1245g0.c()) {
                if (F0(interfaceC1245g0, th2)) {
                    c13 = t0.f34635a;
                    return c13;
                }
            } else {
                Object G02 = G0(d02, new C1282x(th2, false, 2, null));
                c14 = t0.f34635a;
                if (G02 != c14) {
                    c15 = t0.f34637c;
                    if (G02 != c15) {
                        return G02;
                    }
                } else {
                    throw new IllegalStateException(("Cannot happen in " + d02).toString());
                }
            }
        }
    }

    public final Object m0(Object obj) {
        Object G02;
        kotlinx.coroutines.internal.C c10;
        kotlinx.coroutines.internal.C c11;
        do {
            G02 = G0(d0(), obj);
            c10 = t0.f34635a;
            if (G02 != c10) {
                c11 = t0.f34637c;
            } else {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + obj, Q(obj));
            }
        } while (G02 == c11);
        return G02;
    }

    public final AbstractC1276r0 n0(v9.l<? super Throwable, m9.q> lVar, boolean z10) {
        AbstractC1276r0 abstractC1276r0 = null;
        if (z10) {
            if (lVar instanceof AbstractC1267m0) {
                abstractC1276r0 = (AbstractC1267m0) lVar;
            }
            if (abstractC1276r0 == null) {
                abstractC1276r0 = new C1261j0(lVar);
            }
        } else {
            if (lVar instanceof AbstractC1276r0) {
                abstractC1276r0 = (AbstractC1276r0) lVar;
            }
            if (abstractC1276r0 == null) {
                abstractC1276r0 = new C1263k0(lVar);
            }
        }
        abstractC1276r0.w(this);
        return abstractC1276r0;
    }

    public String o0() {
        return G.a(this);
    }

    public final C1278t p0(LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (lockFreeLinkedListNode.p()) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.o();
        }
        while (true) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.n();
            if (!lockFreeLinkedListNode.p()) {
                if (lockFreeLinkedListNode instanceof C1278t) {
                    return (C1278t) lockFreeLinkedListNode;
                }
                if (lockFreeLinkedListNode instanceof x0) {
                    return null;
                }
            }
        }
    }

    public final boolean q(Object obj, x0 x0Var, AbstractC1276r0 abstractC1276r0) {
        int t10;
        d dVar = new d(abstractC1276r0, this, obj);
        do {
            t10 = x0Var.o().t(abstractC1276r0, x0Var, dVar);
            if (t10 == 1) {
                return true;
            }
        } while (t10 != 2);
        return false;
    }

    public final void q0(x0 x0Var, Throwable th) {
        s0(th);
        Object m10 = x0Var.m();
        kotlin.jvm.internal.i.d(m10, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        CompletionHandlerException completionHandlerException = null;
        for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) m10; !kotlin.jvm.internal.i.b(lockFreeLinkedListNode, x0Var); lockFreeLinkedListNode = lockFreeLinkedListNode.n()) {
            if (lockFreeLinkedListNode instanceof AbstractC1267m0) {
                AbstractC1276r0 abstractC1276r0 = (AbstractC1276r0) lockFreeLinkedListNode;
                try {
                    abstractC1276r0.u(th);
                } catch (Throwable th2) {
                    if (completionHandlerException != null) {
                        m9.b.a(completionHandlerException, th2);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + abstractC1276r0 + " for " + this, th2);
                        m9.q qVar = m9.q.f35511a;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            f0(completionHandlerException);
        }
        E(th);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext r(CoroutineContext coroutineContext) {
        return InterfaceC1265l0.a.f(this, coroutineContext);
    }

    public final void r0(x0 x0Var, Throwable th) {
        Object m10 = x0Var.m();
        kotlin.jvm.internal.i.d(m10, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        CompletionHandlerException completionHandlerException = null;
        for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) m10; !kotlin.jvm.internal.i.b(lockFreeLinkedListNode, x0Var); lockFreeLinkedListNode = lockFreeLinkedListNode.n()) {
            if (lockFreeLinkedListNode instanceof AbstractC1276r0) {
                AbstractC1276r0 abstractC1276r0 = (AbstractC1276r0) lockFreeLinkedListNode;
                try {
                    abstractC1276r0.u(th);
                } catch (Throwable th2) {
                    if (completionHandlerException != null) {
                        m9.b.a(completionHandlerException, th2);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + abstractC1276r0 + " for " + this, th2);
                        m9.q qVar = m9.q.f35511a;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            f0(completionHandlerException);
        }
    }

    @Override // kotlinx.coroutines.InterfaceC1265l0
    public final boolean start() {
        int z02;
        do {
            z02 = z0(d0());
            if (z02 == 0) {
                return false;
            }
        } while (z02 != 1);
        return true;
    }

    public final void t(Throwable th, List<? extends Throwable> list) {
        if (list.size() <= 1) {
            return;
        }
        Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
        for (Throwable th2 : list) {
            if (th2 != th && th2 != th && !(th2 instanceof CancellationException) && newSetFromMap.add(th2)) {
                m9.b.a(th, th2);
            }
        }
    }

    public String toString() {
        return D0() + '@' + G.b(this);
    }

    @Override // kotlinx.coroutines.InterfaceC1265l0
    public final Object u(kotlin.coroutines.c<? super m9.q> cVar) {
        Object c10;
        if (!j0()) {
            C1271o0.f(cVar.getContext());
            return m9.q.f35511a;
        }
        Object k02 = k0(cVar);
        c10 = kotlin.coroutines.intrinsics.b.c();
        if (k02 == c10) {
            return k02;
        }
        return m9.q.f35511a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [kotlinx.coroutines.f0] */
    public final void v0(V v10) {
        x0 x0Var = new x0();
        if (!v10.c()) {
            x0Var = new C1243f0(x0Var);
        }
        f34558a.compareAndSet(this, v10, x0Var);
    }

    public final Object w(kotlin.coroutines.c<Object> cVar) {
        Object d02;
        do {
            d02 = d0();
            if (!(d02 instanceof InterfaceC1245g0)) {
                if (!(d02 instanceof C1282x)) {
                    return t0.h(d02);
                }
                throw ((C1282x) d02).f34650a;
            }
        } while (z0(d02) < 0);
        return x(cVar);
    }

    public final void w0(AbstractC1276r0 abstractC1276r0) {
        abstractC1276r0.i(new x0());
        f34558a.compareAndSet(this, abstractC1276r0, abstractC1276r0.n());
    }

    public final Object x(kotlin.coroutines.c<Object> cVar) {
        kotlin.coroutines.c b10;
        Object c10;
        b10 = IntrinsicsKt__IntrinsicsJvmKt.b(cVar);
        a aVar = new a(b10, this);
        aVar.A();
        C1272p.a(aVar, h0(new B0(aVar)));
        Object x10 = aVar.x();
        c10 = kotlin.coroutines.intrinsics.b.c();
        if (x10 == c10) {
            C1472f.c(cVar);
        }
        return x10;
    }

    public final void x0(AbstractC1276r0 abstractC1276r0) {
        Object d02;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        V v10;
        do {
            d02 = d0();
            if (d02 instanceof AbstractC1276r0) {
                if (d02 != abstractC1276r0) {
                    return;
                }
                atomicReferenceFieldUpdater = f34558a;
                v10 = t0.f34641g;
            } else {
                if ((d02 instanceof InterfaceC1245g0) && ((InterfaceC1245g0) d02).f() != null) {
                    abstractC1276r0.q();
                    return;
                }
                return;
            }
        } while (!atomicReferenceFieldUpdater.compareAndSet(this, d02, v10));
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R y(R r10, v9.p<? super R, ? super CoroutineContext.a, ? extends R> pVar) {
        return (R) InterfaceC1265l0.a.b(this, r10, pVar);
    }

    public final void y0(InterfaceC1277s interfaceC1277s) {
        f34559b.set(this, interfaceC1277s);
    }

    public final boolean z(Throwable th) {
        return A(th);
    }

    public final int z0(Object obj) {
        V v10;
        if (obj instanceof V) {
            if (((V) obj).c()) {
                return 0;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f34558a;
            v10 = t0.f34641g;
            if (!atomicReferenceFieldUpdater.compareAndSet(this, obj, v10)) {
                return -1;
            }
            u0();
            return 1;
        }
        if (!(obj instanceof C1243f0)) {
            return 0;
        }
        if (!f34558a.compareAndSet(this, obj, ((C1243f0) obj).f())) {
            return -1;
        }
        u0();
        return 1;
    }

    public void f0(Throwable th) {
        throw th;
    }

    public void s0(Throwable th) {
    }

    public void t0(Object obj) {
    }

    public void v(Object obj) {
    }

    public void u0() {
    }
}
