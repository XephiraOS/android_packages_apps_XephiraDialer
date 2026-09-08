package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.InterfaceC0489l;
import androidx.lifecycle.InterfaceC0492o;
import androidx.lifecycle.Lifecycle;
import androidx.savedstate.Recreator;
import d0.d;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import l.C1286b;

/* compiled from: SavedStateRegistry.kt */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: g, reason: collision with root package name */
    public static final b f11412g = new b(null);

    /* renamed from: b, reason: collision with root package name */
    public boolean f11414b;

    /* renamed from: c, reason: collision with root package name */
    public Bundle f11415c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f11416d;

    /* renamed from: e, reason: collision with root package name */
    public Recreator.b f11417e;

    /* renamed from: a, reason: collision with root package name */
    public final C1286b<String, c> f11413a = new C1286b<>();

    /* renamed from: f, reason: collision with root package name */
    public boolean f11418f = true;

    /* compiled from: SavedStateRegistry.kt */
    /* renamed from: androidx.savedstate.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0139a {
        void a(d dVar);
    }

    /* compiled from: SavedStateRegistry.kt */
    /* loaded from: classes.dex */
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(f fVar) {
            this();
        }
    }

    /* compiled from: SavedStateRegistry.kt */
    /* loaded from: classes.dex */
    public interface c {
        Bundle saveState();
    }

    public static final void d(a this$0, InterfaceC0492o interfaceC0492o, Lifecycle.Event event) {
        i.f(this$0, "this$0");
        i.f(interfaceC0492o, "<anonymous parameter 0>");
        i.f(event, "event");
        if (event == Lifecycle.Event.ON_START) {
            this$0.f11418f = true;
        } else if (event == Lifecycle.Event.ON_STOP) {
            this$0.f11418f = false;
        }
    }

    public final Bundle b(String key) {
        Bundle bundle;
        i.f(key, "key");
        if (this.f11416d) {
            Bundle bundle2 = this.f11415c;
            if (bundle2 == null) {
                return null;
            }
            if (bundle2 != null) {
                bundle = bundle2.getBundle(key);
            } else {
                bundle = null;
            }
            Bundle bundle3 = this.f11415c;
            if (bundle3 != null) {
                bundle3.remove(key);
            }
            Bundle bundle4 = this.f11415c;
            if (bundle4 == null || bundle4.isEmpty()) {
                this.f11415c = null;
            }
            return bundle;
        }
        throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component".toString());
    }

    public final c c(String key) {
        i.f(key, "key");
        Iterator<Map.Entry<String, c>> it = this.f11413a.iterator();
        while (it.hasNext()) {
            Map.Entry<String, c> components = it.next();
            i.e(components, "components");
            String key2 = components.getKey();
            c value = components.getValue();
            if (i.b(key2, key)) {
                return value;
            }
        }
        return null;
    }

    public final void e(Lifecycle lifecycle) {
        i.f(lifecycle, "lifecycle");
        if (!this.f11414b) {
            lifecycle.a(new InterfaceC0489l() { // from class: d0.b
                @Override // androidx.lifecycle.InterfaceC0489l
                public final void onStateChanged(InterfaceC0492o interfaceC0492o, Lifecycle.Event event) {
                    androidx.savedstate.a.d(androidx.savedstate.a.this, interfaceC0492o, event);
                }
            });
            this.f11414b = true;
            return;
        }
        throw new IllegalStateException("SavedStateRegistry was already attached.".toString());
    }

    public final void f(Bundle bundle) {
        Bundle bundle2;
        if (this.f11414b) {
            if (!this.f11416d) {
                if (bundle != null) {
                    bundle2 = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
                } else {
                    bundle2 = null;
                }
                this.f11415c = bundle2;
                this.f11416d = true;
                return;
            }
            throw new IllegalStateException("SavedStateRegistry was already restored.".toString());
        }
        throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).".toString());
    }

    public final void g(Bundle outBundle) {
        i.f(outBundle, "outBundle");
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f11415c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        C1286b<String, c>.d e10 = this.f11413a.e();
        i.e(e10, "this.components.iteratorWithAdditions()");
        while (e10.hasNext()) {
            Map.Entry next = e10.next();
            bundle.putBundle((String) next.getKey(), ((c) next.getValue()).saveState());
        }
        if (!bundle.isEmpty()) {
            outBundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle);
        }
    }

    public final void h(String key, c provider) {
        i.f(key, "key");
        i.f(provider, "provider");
        if (this.f11413a.i(key, provider) == null) {
        } else {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered".toString());
        }
    }

    public final void i(Class<? extends InterfaceC0139a> clazz) {
        i.f(clazz, "clazz");
        if (this.f11418f) {
            Recreator.b bVar = this.f11417e;
            if (bVar == null) {
                bVar = new Recreator.b(this);
            }
            this.f11417e = bVar;
            try {
                clazz.getDeclaredConstructor(null);
                Recreator.b bVar2 = this.f11417e;
                if (bVar2 != null) {
                    String name = clazz.getName();
                    i.e(name, "clazz.name");
                    bVar2.a(name);
                    return;
                }
                return;
            } catch (NoSuchMethodException e10) {
                throw new IllegalArgumentException("Class " + clazz.getSimpleName() + " must have default constructor in order to be automatically recreated", e10);
            }
        }
        throw new IllegalStateException("Can not perform this action after onSaveInstanceState".toString());
    }
}
