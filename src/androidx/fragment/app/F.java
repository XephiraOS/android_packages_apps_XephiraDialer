package androidx.fragment.app;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import androidx.lifecycle.InterfaceC0485h;
import androidx.lifecycle.K;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.M;
import androidx.lifecycle.N;
import androidx.lifecycle.SavedStateHandleSupport;

/* compiled from: FragmentViewLifecycleOwner.java */
/* loaded from: classes.dex */
public class F implements InterfaceC0485h, d0.d, N {

    /* renamed from: a, reason: collision with root package name */
    public final Fragment f9914a;

    /* renamed from: b, reason: collision with root package name */
    public final M f9915b;

    /* renamed from: c, reason: collision with root package name */
    public K.b f9916c;

    /* renamed from: d, reason: collision with root package name */
    public androidx.lifecycle.q f9917d = null;

    /* renamed from: e, reason: collision with root package name */
    public d0.c f9918e = null;

    public F(Fragment fragment, M m10) {
        this.f9914a = fragment;
        this.f9915b = m10;
    }

    public void a(Lifecycle.Event event) {
        this.f9917d.i(event);
    }

    public void b() {
        if (this.f9917d == null) {
            this.f9917d = new androidx.lifecycle.q(this);
            d0.c a10 = d0.c.a(this);
            this.f9918e = a10;
            a10.c();
            SavedStateHandleSupport.c(this);
        }
    }

    public boolean c() {
        if (this.f9917d != null) {
            return true;
        }
        return false;
    }

    public void d(Bundle bundle) {
        this.f9918e.d(bundle);
    }

    public void e(Bundle bundle) {
        this.f9918e.e(bundle);
    }

    public void f(Lifecycle.State state) {
        this.f9917d.n(state);
    }

    @Override // androidx.lifecycle.InterfaceC0485h
    public V.a getDefaultViewModelCreationExtras() {
        Application application;
        Context applicationContext = this.f9914a.requireContext().getApplicationContext();
        while (true) {
            if (applicationContext instanceof ContextWrapper) {
                if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                }
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            } else {
                application = null;
                break;
            }
        }
        V.d dVar = new V.d();
        if (application != null) {
            dVar.c(K.a.f10268h, application);
        }
        dVar.c(SavedStateHandleSupport.f10325a, this);
        dVar.c(SavedStateHandleSupport.f10326b, this);
        if (this.f9914a.getArguments() != null) {
            dVar.c(SavedStateHandleSupport.f10327c, this.f9914a.getArguments());
        }
        return dVar;
    }

    @Override // androidx.lifecycle.InterfaceC0485h
    public K.b getDefaultViewModelProviderFactory() {
        Application application;
        K.b defaultViewModelProviderFactory = this.f9914a.getDefaultViewModelProviderFactory();
        if (!defaultViewModelProviderFactory.equals(this.f9914a.mDefaultFactory)) {
            this.f9916c = defaultViewModelProviderFactory;
            return defaultViewModelProviderFactory;
        }
        if (this.f9916c == null) {
            Context applicationContext = this.f9914a.requireContext().getApplicationContext();
            while (true) {
                if (applicationContext instanceof ContextWrapper) {
                    if (applicationContext instanceof Application) {
                        application = (Application) applicationContext;
                        break;
                    }
                    applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
                } else {
                    application = null;
                    break;
                }
            }
            this.f9916c = new androidx.lifecycle.E(application, this, this.f9914a.getArguments());
        }
        return this.f9916c;
    }

    @Override // androidx.lifecycle.InterfaceC0492o
    public Lifecycle getLifecycle() {
        b();
        return this.f9917d;
    }

    @Override // d0.d
    public androidx.savedstate.a getSavedStateRegistry() {
        b();
        return this.f9918e.b();
    }

    @Override // androidx.lifecycle.N
    public M getViewModelStore() {
        b();
        return this.f9915b;
    }
}
