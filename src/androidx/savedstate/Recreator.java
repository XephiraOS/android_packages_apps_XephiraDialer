package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.InterfaceC0489l;
import androidx.lifecycle.InterfaceC0492o;
import androidx.lifecycle.Lifecycle;
import androidx.savedstate.a;
import d0.d;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: Recreator.kt */
/* loaded from: classes.dex */
public final class Recreator implements InterfaceC0489l {

    /* renamed from: b, reason: collision with root package name */
    public static final a f11409b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final d f11410a;

    /* compiled from: Recreator.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: Recreator.kt */
    /* loaded from: classes.dex */
    public static final class b implements a.c {

        /* renamed from: a, reason: collision with root package name */
        public final Set<String> f11411a;

        public b(androidx.savedstate.a registry) {
            i.f(registry, "registry");
            this.f11411a = new LinkedHashSet();
            registry.h("androidx.savedstate.Restarter", this);
        }

        public final void a(String className) {
            i.f(className, "className");
            this.f11411a.add(className);
        }

        @Override // androidx.savedstate.a.c
        public Bundle saveState() {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("classes_to_restore", new ArrayList<>(this.f11411a));
            return bundle;
        }
    }

    public Recreator(d owner) {
        i.f(owner, "owner");
        this.f11410a = owner;
    }

    public final void a(String str) {
        try {
            Class<? extends U> asSubclass = Class.forName(str, false, Recreator.class.getClassLoader()).asSubclass(a.InterfaceC0139a.class);
            i.e(asSubclass, "{\n                Class.…class.java)\n            }");
            try {
                Constructor declaredConstructor = asSubclass.getDeclaredConstructor(null);
                declaredConstructor.setAccessible(true);
                try {
                    Object newInstance = declaredConstructor.newInstance(null);
                    i.e(newInstance, "{\n                constr…wInstance()\n            }");
                    ((a.InterfaceC0139a) newInstance).a(this.f11410a);
                } catch (Exception e10) {
                    throw new RuntimeException("Failed to instantiate " + str, e10);
                }
            } catch (NoSuchMethodException e11) {
                throw new IllegalStateException("Class " + asSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e11);
            }
        } catch (ClassNotFoundException e12) {
            throw new RuntimeException("Class " + str + " wasn't found", e12);
        }
    }

    @Override // androidx.lifecycle.InterfaceC0489l
    public void onStateChanged(InterfaceC0492o source, Lifecycle.Event event) {
        i.f(source, "source");
        i.f(event, "event");
        if (event == Lifecycle.Event.ON_CREATE) {
            source.getLifecycle().d(this);
            Bundle b10 = this.f11410a.getSavedStateRegistry().b("androidx.savedstate.Restarter");
            if (b10 == null) {
                return;
            }
            ArrayList<String> stringArrayList = b10.getStringArrayList("classes_to_restore");
            if (stringArrayList != null) {
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    a(it.next());
                }
                return;
            }
            throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
        }
        throw new AssertionError("Next event must be ON_CREATE");
    }
}
