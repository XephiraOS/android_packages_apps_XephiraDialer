package androidx.activity;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import v9.InterfaceC1637a;

/* compiled from: OnBackPressedCallback.kt */
/* loaded from: classes.dex */
public abstract class n {

    /* renamed from: a, reason: collision with root package name */
    public boolean f7119a;

    /* renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<c> f7120b = new CopyOnWriteArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    public InterfaceC1637a<m9.q> f7121c;

    public n(boolean z10) {
        this.f7119a = z10;
    }

    public final void a(c cancellable) {
        kotlin.jvm.internal.i.f(cancellable, "cancellable");
        this.f7120b.add(cancellable);
    }

    public final InterfaceC1637a<m9.q> b() {
        return this.f7121c;
    }

    public abstract void d();

    public void e(b backEvent) {
        kotlin.jvm.internal.i.f(backEvent, "backEvent");
    }

    public void f(b backEvent) {
        kotlin.jvm.internal.i.f(backEvent, "backEvent");
    }

    public final boolean g() {
        return this.f7119a;
    }

    public final void h() {
        Iterator<T> it = this.f7120b.iterator();
        while (it.hasNext()) {
            ((c) it.next()).cancel();
        }
    }

    public final void i(c cancellable) {
        kotlin.jvm.internal.i.f(cancellable, "cancellable");
        this.f7120b.remove(cancellable);
    }

    public final void j(boolean z10) {
        this.f7119a = z10;
        InterfaceC1637a<m9.q> interfaceC1637a = this.f7121c;
        if (interfaceC1637a != null) {
            interfaceC1637a.invoke();
        }
    }

    public final void k(InterfaceC1637a<m9.q> interfaceC1637a) {
        this.f7121c = interfaceC1637a;
    }

    public void c() {
    }
}
