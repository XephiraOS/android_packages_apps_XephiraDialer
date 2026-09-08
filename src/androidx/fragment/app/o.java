package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: FragmentLifecycleCallbacksDispatcher.java */
/* loaded from: classes.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<a> f10181a = new CopyOnWriteArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    public final FragmentManager f10182b;

    /* compiled from: FragmentLifecycleCallbacksDispatcher.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final FragmentManager.k f10183a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f10184b;

        public a(FragmentManager.k kVar, boolean z10) {
            this.f10183a = kVar;
            this.f10184b = z10;
        }
    }

    public o(FragmentManager fragmentManager) {
        this.f10182b = fragmentManager;
    }

    public void a(Fragment fragment, Bundle bundle, boolean z10) {
        Fragment C02 = this.f10182b.C0();
        if (C02 != null) {
            C02.getParentFragmentManager().B0().a(fragment, bundle, true);
        }
        Iterator<a> it = this.f10181a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z10 || next.f10184b) {
                next.f10183a.onFragmentActivityCreated(this.f10182b, fragment, bundle);
            }
        }
    }

    public void b(Fragment fragment, boolean z10) {
        Context f10 = this.f10182b.z0().f();
        Fragment C02 = this.f10182b.C0();
        if (C02 != null) {
            C02.getParentFragmentManager().B0().b(fragment, true);
        }
        Iterator<a> it = this.f10181a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z10 || next.f10184b) {
                next.f10183a.onFragmentAttached(this.f10182b, fragment, f10);
            }
        }
    }

    public void c(Fragment fragment, Bundle bundle, boolean z10) {
        Fragment C02 = this.f10182b.C0();
        if (C02 != null) {
            C02.getParentFragmentManager().B0().c(fragment, bundle, true);
        }
        Iterator<a> it = this.f10181a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z10 || next.f10184b) {
                next.f10183a.onFragmentCreated(this.f10182b, fragment, bundle);
            }
        }
    }

    public void d(Fragment fragment, boolean z10) {
        Fragment C02 = this.f10182b.C0();
        if (C02 != null) {
            C02.getParentFragmentManager().B0().d(fragment, true);
        }
        Iterator<a> it = this.f10181a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z10 || next.f10184b) {
                next.f10183a.onFragmentDestroyed(this.f10182b, fragment);
            }
        }
    }

    public void e(Fragment fragment, boolean z10) {
        Fragment C02 = this.f10182b.C0();
        if (C02 != null) {
            C02.getParentFragmentManager().B0().e(fragment, true);
        }
        Iterator<a> it = this.f10181a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z10 || next.f10184b) {
                next.f10183a.onFragmentDetached(this.f10182b, fragment);
            }
        }
    }

    public void f(Fragment fragment, boolean z10) {
        Fragment C02 = this.f10182b.C0();
        if (C02 != null) {
            C02.getParentFragmentManager().B0().f(fragment, true);
        }
        Iterator<a> it = this.f10181a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z10 || next.f10184b) {
                next.f10183a.onFragmentPaused(this.f10182b, fragment);
            }
        }
    }

    public void g(Fragment fragment, boolean z10) {
        Context f10 = this.f10182b.z0().f();
        Fragment C02 = this.f10182b.C0();
        if (C02 != null) {
            C02.getParentFragmentManager().B0().g(fragment, true);
        }
        Iterator<a> it = this.f10181a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z10 || next.f10184b) {
                next.f10183a.onFragmentPreAttached(this.f10182b, fragment, f10);
            }
        }
    }

    public void h(Fragment fragment, Bundle bundle, boolean z10) {
        Fragment C02 = this.f10182b.C0();
        if (C02 != null) {
            C02.getParentFragmentManager().B0().h(fragment, bundle, true);
        }
        Iterator<a> it = this.f10181a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z10 || next.f10184b) {
                next.f10183a.onFragmentPreCreated(this.f10182b, fragment, bundle);
            }
        }
    }

    public void i(Fragment fragment, boolean z10) {
        Fragment C02 = this.f10182b.C0();
        if (C02 != null) {
            C02.getParentFragmentManager().B0().i(fragment, true);
        }
        Iterator<a> it = this.f10181a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z10 || next.f10184b) {
                next.f10183a.onFragmentResumed(this.f10182b, fragment);
            }
        }
    }

    public void j(Fragment fragment, Bundle bundle, boolean z10) {
        Fragment C02 = this.f10182b.C0();
        if (C02 != null) {
            C02.getParentFragmentManager().B0().j(fragment, bundle, true);
        }
        Iterator<a> it = this.f10181a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z10 || next.f10184b) {
                next.f10183a.onFragmentSaveInstanceState(this.f10182b, fragment, bundle);
            }
        }
    }

    public void k(Fragment fragment, boolean z10) {
        Fragment C02 = this.f10182b.C0();
        if (C02 != null) {
            C02.getParentFragmentManager().B0().k(fragment, true);
        }
        Iterator<a> it = this.f10181a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z10 || next.f10184b) {
                next.f10183a.onFragmentStarted(this.f10182b, fragment);
            }
        }
    }

    public void l(Fragment fragment, boolean z10) {
        Fragment C02 = this.f10182b.C0();
        if (C02 != null) {
            C02.getParentFragmentManager().B0().l(fragment, true);
        }
        Iterator<a> it = this.f10181a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z10 || next.f10184b) {
                next.f10183a.onFragmentStopped(this.f10182b, fragment);
            }
        }
    }

    public void m(Fragment fragment, View view, Bundle bundle, boolean z10) {
        Fragment C02 = this.f10182b.C0();
        if (C02 != null) {
            C02.getParentFragmentManager().B0().m(fragment, view, bundle, true);
        }
        Iterator<a> it = this.f10181a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z10 || next.f10184b) {
                next.f10183a.onFragmentViewCreated(this.f10182b, fragment, view, bundle);
            }
        }
    }

    public void n(Fragment fragment, boolean z10) {
        Fragment C02 = this.f10182b.C0();
        if (C02 != null) {
            C02.getParentFragmentManager().B0().n(fragment, true);
        }
        Iterator<a> it = this.f10181a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z10 || next.f10184b) {
                next.f10183a.onFragmentViewDestroyed(this.f10182b, fragment);
            }
        }
    }

    public void o(FragmentManager.k kVar, boolean z10) {
        this.f10181a.add(new a(kVar, z10));
    }

    public void p(FragmentManager.k kVar) {
        synchronized (this.f10181a) {
            try {
                int size = this.f10181a.size();
                int i10 = 0;
                while (true) {
                    if (i10 >= size) {
                        break;
                    }
                    if (this.f10181a.get(i10).f10183a == kVar) {
                        this.f10181a.remove(i10);
                        break;
                    }
                    i10++;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
