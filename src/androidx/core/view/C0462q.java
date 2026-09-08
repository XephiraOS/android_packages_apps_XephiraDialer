package androidx.core.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.lifecycle.InterfaceC0489l;
import androidx.lifecycle.InterfaceC0492o;
import androidx.lifecycle.Lifecycle;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: MenuHostHelper.java */
/* renamed from: androidx.core.view.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0462q {

    /* renamed from: a, reason: collision with root package name */
    public final Runnable f9513a;

    /* renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<InterfaceC0463s> f9514b = new CopyOnWriteArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    public final Map<InterfaceC0463s, a> f9515c = new HashMap();

    /* compiled from: MenuHostHelper.java */
    /* renamed from: androidx.core.view.q$a */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final Lifecycle f9516a;

        /* renamed from: b, reason: collision with root package name */
        public InterfaceC0489l f9517b;

        public a(Lifecycle lifecycle, InterfaceC0489l interfaceC0489l) {
            this.f9516a = lifecycle;
            this.f9517b = interfaceC0489l;
            lifecycle.a(interfaceC0489l);
        }

        public void a() {
            this.f9516a.d(this.f9517b);
            this.f9517b = null;
        }
    }

    public C0462q(Runnable runnable) {
        this.f9513a = runnable;
    }

    public void c(InterfaceC0463s interfaceC0463s) {
        this.f9514b.add(interfaceC0463s);
        this.f9513a.run();
    }

    public void d(final InterfaceC0463s interfaceC0463s, InterfaceC0492o interfaceC0492o) {
        c(interfaceC0463s);
        Lifecycle lifecycle = interfaceC0492o.getLifecycle();
        a remove = this.f9515c.remove(interfaceC0463s);
        if (remove != null) {
            remove.a();
        }
        this.f9515c.put(interfaceC0463s, new a(lifecycle, new InterfaceC0489l() { // from class: androidx.core.view.p
            @Override // androidx.lifecycle.InterfaceC0489l
            public final void onStateChanged(InterfaceC0492o interfaceC0492o2, Lifecycle.Event event) {
                C0462q.this.f(interfaceC0463s, interfaceC0492o2, event);
            }
        }));
    }

    public void e(final InterfaceC0463s interfaceC0463s, InterfaceC0492o interfaceC0492o, final Lifecycle.State state) {
        Lifecycle lifecycle = interfaceC0492o.getLifecycle();
        a remove = this.f9515c.remove(interfaceC0463s);
        if (remove != null) {
            remove.a();
        }
        this.f9515c.put(interfaceC0463s, new a(lifecycle, new InterfaceC0489l() { // from class: androidx.core.view.o
            @Override // androidx.lifecycle.InterfaceC0489l
            public final void onStateChanged(InterfaceC0492o interfaceC0492o2, Lifecycle.Event event) {
                C0462q.this.g(state, interfaceC0463s, interfaceC0492o2, event);
            }
        }));
    }

    public final /* synthetic */ void f(InterfaceC0463s interfaceC0463s, InterfaceC0492o interfaceC0492o, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            l(interfaceC0463s);
        }
    }

    public final /* synthetic */ void g(Lifecycle.State state, InterfaceC0463s interfaceC0463s, InterfaceC0492o interfaceC0492o, Lifecycle.Event event) {
        if (event == Lifecycle.Event.d(state)) {
            c(interfaceC0463s);
            return;
        }
        if (event == Lifecycle.Event.ON_DESTROY) {
            l(interfaceC0463s);
        } else if (event == Lifecycle.Event.b(state)) {
            this.f9514b.remove(interfaceC0463s);
            this.f9513a.run();
        }
    }

    public void h(Menu menu, MenuInflater menuInflater) {
        Iterator<InterfaceC0463s> it = this.f9514b.iterator();
        while (it.hasNext()) {
            it.next().c(menu, menuInflater);
        }
    }

    public void i(Menu menu) {
        Iterator<InterfaceC0463s> it = this.f9514b.iterator();
        while (it.hasNext()) {
            it.next().b(menu);
        }
    }

    public boolean j(MenuItem menuItem) {
        Iterator<InterfaceC0463s> it = this.f9514b.iterator();
        while (it.hasNext()) {
            if (it.next().a(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void k(Menu menu) {
        Iterator<InterfaceC0463s> it = this.f9514b.iterator();
        while (it.hasNext()) {
            it.next().d(menu);
        }
    }

    public void l(InterfaceC0463s interfaceC0463s) {
        this.f9514b.remove(interfaceC0463s);
        a remove = this.f9515c.remove(interfaceC0463s);
        if (remove != null) {
            remove.a();
        }
        this.f9513a.run();
    }
}
