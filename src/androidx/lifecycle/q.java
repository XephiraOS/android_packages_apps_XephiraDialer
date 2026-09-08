package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import l.C1285a;
import l.C1286b;

/* compiled from: LifecycleRegistry.kt */
/* loaded from: classes.dex */
public class q extends Lifecycle {

    /* renamed from: j, reason: collision with root package name */
    public static final a f10370j = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public final boolean f10371b;

    /* renamed from: c, reason: collision with root package name */
    public C1285a<InterfaceC0491n, b> f10372c;

    /* renamed from: d, reason: collision with root package name */
    public Lifecycle.State f10373d;

    /* renamed from: e, reason: collision with root package name */
    public final WeakReference<InterfaceC0492o> f10374e;

    /* renamed from: f, reason: collision with root package name */
    public int f10375f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f10376g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f10377h;

    /* renamed from: i, reason: collision with root package name */
    public ArrayList<Lifecycle.State> f10378i;

    /* compiled from: LifecycleRegistry.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public final Lifecycle.State a(Lifecycle.State state1, Lifecycle.State state) {
            kotlin.jvm.internal.i.f(state1, "state1");
            if (state != null && state.compareTo(state1) < 0) {
                return state;
            }
            return state1;
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: LifecycleRegistry.kt */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public Lifecycle.State f10379a;

        /* renamed from: b, reason: collision with root package name */
        public InterfaceC0489l f10380b;

        public b(InterfaceC0491n interfaceC0491n, Lifecycle.State initialState) {
            kotlin.jvm.internal.i.f(initialState, "initialState");
            kotlin.jvm.internal.i.c(interfaceC0491n);
            this.f10380b = s.f(interfaceC0491n);
            this.f10379a = initialState;
        }

        public final void a(InterfaceC0492o interfaceC0492o, Lifecycle.Event event) {
            kotlin.jvm.internal.i.f(event, "event");
            Lifecycle.State c10 = event.c();
            this.f10379a = q.f10370j.a(this.f10379a, c10);
            InterfaceC0489l interfaceC0489l = this.f10380b;
            kotlin.jvm.internal.i.c(interfaceC0492o);
            interfaceC0489l.onStateChanged(interfaceC0492o, event);
            this.f10379a = c10;
        }

        public final Lifecycle.State b() {
            return this.f10379a;
        }
    }

    public q(InterfaceC0492o interfaceC0492o, boolean z10) {
        this.f10371b = z10;
        this.f10372c = new C1285a<>();
        this.f10373d = Lifecycle.State.INITIALIZED;
        this.f10378i = new ArrayList<>();
        this.f10374e = new WeakReference<>(interfaceC0492o);
    }

    @Override // androidx.lifecycle.Lifecycle
    public void a(InterfaceC0491n observer) {
        InterfaceC0492o interfaceC0492o;
        boolean z10;
        kotlin.jvm.internal.i.f(observer, "observer");
        g("addObserver");
        Lifecycle.State state = this.f10373d;
        Lifecycle.State state2 = Lifecycle.State.DESTROYED;
        if (state != state2) {
            state2 = Lifecycle.State.INITIALIZED;
        }
        b bVar = new b(observer, state2);
        if (this.f10372c.i(observer, bVar) != null || (interfaceC0492o = this.f10374e.get()) == null) {
            return;
        }
        if (this.f10375f == 0 && !this.f10376g) {
            z10 = false;
        } else {
            z10 = true;
        }
        Lifecycle.State f10 = f(observer);
        this.f10375f++;
        while (bVar.b().compareTo(f10) < 0 && this.f10372c.contains(observer)) {
            m(bVar.b());
            Lifecycle.Event b10 = Lifecycle.Event.Companion.b(bVar.b());
            if (b10 != null) {
                bVar.a(interfaceC0492o, b10);
                l();
                f10 = f(observer);
            } else {
                throw new IllegalStateException("no event up from " + bVar.b());
            }
        }
        if (!z10) {
            o();
        }
        this.f10375f--;
    }

    @Override // androidx.lifecycle.Lifecycle
    public Lifecycle.State b() {
        return this.f10373d;
    }

    @Override // androidx.lifecycle.Lifecycle
    public void d(InterfaceC0491n observer) {
        kotlin.jvm.internal.i.f(observer, "observer");
        g("removeObserver");
        this.f10372c.j(observer);
    }

    public final void e(InterfaceC0492o interfaceC0492o) {
        Iterator<Map.Entry<InterfaceC0491n, b>> descendingIterator = this.f10372c.descendingIterator();
        kotlin.jvm.internal.i.e(descendingIterator, "observerMap.descendingIterator()");
        while (descendingIterator.hasNext() && !this.f10377h) {
            Map.Entry<InterfaceC0491n, b> next = descendingIterator.next();
            kotlin.jvm.internal.i.e(next, "next()");
            InterfaceC0491n key = next.getKey();
            b value = next.getValue();
            while (value.b().compareTo(this.f10373d) > 0 && !this.f10377h && this.f10372c.contains(key)) {
                Lifecycle.Event a10 = Lifecycle.Event.Companion.a(value.b());
                if (a10 != null) {
                    m(a10.c());
                    value.a(interfaceC0492o, a10);
                    l();
                } else {
                    throw new IllegalStateException("no event down from " + value.b());
                }
            }
        }
    }

    public final Lifecycle.State f(InterfaceC0491n interfaceC0491n) {
        Lifecycle.State state;
        b value;
        Map.Entry<InterfaceC0491n, b> k10 = this.f10372c.k(interfaceC0491n);
        Lifecycle.State state2 = null;
        if (k10 != null && (value = k10.getValue()) != null) {
            state = value.b();
        } else {
            state = null;
        }
        if (!this.f10378i.isEmpty()) {
            state2 = this.f10378i.get(r0.size() - 1);
        }
        a aVar = f10370j;
        return aVar.a(aVar.a(this.f10373d, state), state2);
    }

    public final void g(String str) {
        if (this.f10371b && !k.c.g().b()) {
            throw new IllegalStateException(("Method " + str + " must be called on the main thread").toString());
        }
    }

    public final void h(InterfaceC0492o interfaceC0492o) {
        C1286b<InterfaceC0491n, b>.d e10 = this.f10372c.e();
        kotlin.jvm.internal.i.e(e10, "observerMap.iteratorWithAdditions()");
        while (e10.hasNext() && !this.f10377h) {
            Map.Entry next = e10.next();
            InterfaceC0491n interfaceC0491n = (InterfaceC0491n) next.getKey();
            b bVar = (b) next.getValue();
            while (bVar.b().compareTo(this.f10373d) < 0 && !this.f10377h && this.f10372c.contains(interfaceC0491n)) {
                m(bVar.b());
                Lifecycle.Event b10 = Lifecycle.Event.Companion.b(bVar.b());
                if (b10 != null) {
                    bVar.a(interfaceC0492o, b10);
                    l();
                } else {
                    throw new IllegalStateException("no event up from " + bVar.b());
                }
            }
        }
    }

    public void i(Lifecycle.Event event) {
        kotlin.jvm.internal.i.f(event, "event");
        g("handleLifecycleEvent");
        k(event.c());
    }

    public final boolean j() {
        if (this.f10372c.size() == 0) {
            return true;
        }
        Map.Entry<InterfaceC0491n, b> a10 = this.f10372c.a();
        kotlin.jvm.internal.i.c(a10);
        Lifecycle.State b10 = a10.getValue().b();
        Map.Entry<InterfaceC0491n, b> g10 = this.f10372c.g();
        kotlin.jvm.internal.i.c(g10);
        Lifecycle.State b11 = g10.getValue().b();
        if (b10 == b11 && this.f10373d == b11) {
            return true;
        }
        return false;
    }

    public final void k(Lifecycle.State state) {
        Lifecycle.State state2 = this.f10373d;
        if (state2 == state) {
            return;
        }
        if (state2 == Lifecycle.State.INITIALIZED && state == Lifecycle.State.DESTROYED) {
            throw new IllegalStateException(("no event down from " + this.f10373d + " in component " + this.f10374e.get()).toString());
        }
        this.f10373d = state;
        if (!this.f10376g && this.f10375f == 0) {
            this.f10376g = true;
            o();
            this.f10376g = false;
            if (this.f10373d == Lifecycle.State.DESTROYED) {
                this.f10372c = new C1285a<>();
                return;
            }
            return;
        }
        this.f10377h = true;
    }

    public final void l() {
        this.f10378i.remove(r1.size() - 1);
    }

    public final void m(Lifecycle.State state) {
        this.f10378i.add(state);
    }

    public void n(Lifecycle.State state) {
        kotlin.jvm.internal.i.f(state, "state");
        g("setCurrentState");
        k(state);
    }

    public final void o() {
        InterfaceC0492o interfaceC0492o = this.f10374e.get();
        if (interfaceC0492o != null) {
            while (!j()) {
                this.f10377h = false;
                Lifecycle.State state = this.f10373d;
                Map.Entry<InterfaceC0491n, b> a10 = this.f10372c.a();
                kotlin.jvm.internal.i.c(a10);
                if (state.compareTo(a10.getValue().b()) < 0) {
                    e(interfaceC0492o);
                }
                Map.Entry<InterfaceC0491n, b> g10 = this.f10372c.g();
                if (!this.f10377h && g10 != null && this.f10373d.compareTo(g10.getValue().b()) > 0) {
                    h(interfaceC0492o);
                }
            }
            this.f10377h = false;
            return;
        }
        throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is already garbage collected. It is too late to change lifecycle state.");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public q(InterfaceC0492o provider) {
        this(provider, true);
        kotlin.jvm.internal.i.f(provider, "provider");
    }
}
