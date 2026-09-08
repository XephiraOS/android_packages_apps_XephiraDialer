package d0;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.savedstate.Recreator;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: SavedStateRegistryController.kt */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: d, reason: collision with root package name */
    public static final a f29919d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final d f29920a;

    /* renamed from: b, reason: collision with root package name */
    public final androidx.savedstate.a f29921b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f29922c;

    /* compiled from: SavedStateRegistryController.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public final c a(d owner) {
            i.f(owner, "owner");
            return new c(owner, null);
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public /* synthetic */ c(d dVar, f fVar) {
        this(dVar);
    }

    public static final c a(d dVar) {
        return f29919d.a(dVar);
    }

    public final androidx.savedstate.a b() {
        return this.f29921b;
    }

    public final void c() {
        Lifecycle lifecycle = this.f29920a.getLifecycle();
        if (lifecycle.b() == Lifecycle.State.INITIALIZED) {
            lifecycle.a(new Recreator(this.f29920a));
            this.f29921b.e(lifecycle);
            this.f29922c = true;
            return;
        }
        throw new IllegalStateException("Restarter must be created only during owner's initialization stage".toString());
    }

    public final void d(Bundle bundle) {
        if (!this.f29922c) {
            c();
        }
        Lifecycle lifecycle = this.f29920a.getLifecycle();
        if (!lifecycle.b().b(Lifecycle.State.STARTED)) {
            this.f29921b.f(bundle);
            return;
        }
        throw new IllegalStateException(("performRestore cannot be called when owner is " + lifecycle.b()).toString());
    }

    public final void e(Bundle outBundle) {
        i.f(outBundle, "outBundle");
        this.f29921b.g(outBundle);
    }

    public c(d dVar) {
        this.f29920a = dVar;
        this.f29921b = new androidx.savedstate.a();
    }
}
