package androidx.activity.result;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.InterfaceC0489l;
import androidx.lifecycle.InterfaceC0492o;
import androidx.lifecycle.Lifecycle;
import c.AbstractC0540a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.random.Random;

/* loaded from: classes.dex */
public abstract class ActivityResultRegistry {

    /* renamed from: a, reason: collision with root package name */
    public final Map<Integer, String> f7127a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final Map<String, Integer> f7128b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final Map<String, d> f7129c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public ArrayList<String> f7130d = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    public final transient Map<String, c<?>> f7131e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    public final Map<String, Object> f7132f = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    public final Bundle f7133g = new Bundle();

    /* JADX INFO: Add missing generic type declarations: [I] */
    /* loaded from: classes.dex */
    public class a<I> extends androidx.activity.result.b<I> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f7138a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AbstractC0540a f7139b;

        public a(String str, AbstractC0540a abstractC0540a) {
            this.f7138a = str;
            this.f7139b = abstractC0540a;
        }

        @Override // androidx.activity.result.b
        public void b(I i10, androidx.core.app.b bVar) {
            Integer num = ActivityResultRegistry.this.f7128b.get(this.f7138a);
            if (num != null) {
                ActivityResultRegistry.this.f7130d.add(this.f7138a);
                try {
                    ActivityResultRegistry.this.f(num.intValue(), this.f7139b, i10, bVar);
                    return;
                } catch (Exception e10) {
                    ActivityResultRegistry.this.f7130d.remove(this.f7138a);
                    throw e10;
                }
            }
            throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + this.f7139b + " and input " + i10 + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
        }

        @Override // androidx.activity.result.b
        public void c() {
            ActivityResultRegistry.this.l(this.f7138a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [I] */
    /* loaded from: classes.dex */
    public class b<I> extends androidx.activity.result.b<I> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f7141a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AbstractC0540a f7142b;

        public b(String str, AbstractC0540a abstractC0540a) {
            this.f7141a = str;
            this.f7142b = abstractC0540a;
        }

        @Override // androidx.activity.result.b
        public void b(I i10, androidx.core.app.b bVar) {
            Integer num = ActivityResultRegistry.this.f7128b.get(this.f7141a);
            if (num != null) {
                ActivityResultRegistry.this.f7130d.add(this.f7141a);
                try {
                    ActivityResultRegistry.this.f(num.intValue(), this.f7142b, i10, bVar);
                    return;
                } catch (Exception e10) {
                    ActivityResultRegistry.this.f7130d.remove(this.f7141a);
                    throw e10;
                }
            }
            throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + this.f7142b + " and input " + i10 + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
        }

        @Override // androidx.activity.result.b
        public void c() {
            ActivityResultRegistry.this.l(this.f7141a);
        }
    }

    /* loaded from: classes.dex */
    public static class c<O> {

        /* renamed from: a, reason: collision with root package name */
        public final androidx.activity.result.a<O> f7144a;

        /* renamed from: b, reason: collision with root package name */
        public final AbstractC0540a<?, O> f7145b;

        public c(androidx.activity.result.a<O> aVar, AbstractC0540a<?, O> abstractC0540a) {
            this.f7144a = aVar;
            this.f7145b = abstractC0540a;
        }
    }

    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final Lifecycle f7146a;

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList<InterfaceC0489l> f7147b = new ArrayList<>();

        public d(Lifecycle lifecycle) {
            this.f7146a = lifecycle;
        }

        public void a(InterfaceC0489l interfaceC0489l) {
            this.f7146a.a(interfaceC0489l);
            this.f7147b.add(interfaceC0489l);
        }

        public void b() {
            Iterator<InterfaceC0489l> it = this.f7147b.iterator();
            while (it.hasNext()) {
                this.f7146a.d(it.next());
            }
            this.f7147b.clear();
        }
    }

    public final void a(int i10, String str) {
        this.f7127a.put(Integer.valueOf(i10), str);
        this.f7128b.put(str, Integer.valueOf(i10));
    }

    public final boolean b(int i10, int i11, Intent intent) {
        String str = this.f7127a.get(Integer.valueOf(i10));
        if (str == null) {
            return false;
        }
        d(str, i11, intent, this.f7131e.get(str));
        return true;
    }

    public final <O> boolean c(int i10, O o10) {
        androidx.activity.result.a<?> aVar;
        String str = this.f7127a.get(Integer.valueOf(i10));
        if (str == null) {
            return false;
        }
        c<?> cVar = this.f7131e.get(str);
        if (cVar != null && (aVar = cVar.f7144a) != null) {
            if (this.f7130d.remove(str)) {
                aVar.a(o10);
                return true;
            }
            return true;
        }
        this.f7133g.remove(str);
        this.f7132f.put(str, o10);
        return true;
    }

    public final <O> void d(String str, int i10, Intent intent, c<O> cVar) {
        if (cVar != null && cVar.f7144a != null && this.f7130d.contains(str)) {
            cVar.f7144a.a(cVar.f7145b.c(i10, intent));
            this.f7130d.remove(str);
        } else {
            this.f7132f.remove(str);
            this.f7133g.putParcelable(str, new ActivityResult(i10, intent));
        }
    }

    public final int e() {
        int c10 = Random.f34246a.c(2147418112);
        while (true) {
            int i10 = c10 + 65536;
            if (this.f7127a.containsKey(Integer.valueOf(i10))) {
                c10 = Random.f34246a.c(2147418112);
            } else {
                return i10;
            }
        }
    }

    public abstract <I, O> void f(int i10, AbstractC0540a<I, O> abstractC0540a, I i11, androidx.core.app.b bVar);

    public final void g(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
        if (stringArrayList != null && integerArrayList != null) {
            this.f7130d = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
            this.f7133g.putAll(bundle.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
            for (int i10 = 0; i10 < stringArrayList.size(); i10++) {
                String str = stringArrayList.get(i10);
                if (this.f7128b.containsKey(str)) {
                    Integer remove = this.f7128b.remove(str);
                    if (!this.f7133g.containsKey(str)) {
                        this.f7127a.remove(remove);
                    }
                }
                a(integerArrayList.get(i10).intValue(), stringArrayList.get(i10));
            }
        }
    }

    public final void h(Bundle bundle) {
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(this.f7128b.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(this.f7128b.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(this.f7130d));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) this.f7133g.clone());
    }

    public final <I, O> androidx.activity.result.b<I> i(final String str, InterfaceC0492o interfaceC0492o, final AbstractC0540a<I, O> abstractC0540a, final androidx.activity.result.a<O> aVar) {
        Lifecycle lifecycle = interfaceC0492o.getLifecycle();
        if (!lifecycle.b().b(Lifecycle.State.STARTED)) {
            k(str);
            d dVar = this.f7129c.get(str);
            if (dVar == null) {
                dVar = new d(lifecycle);
            }
            dVar.a(new InterfaceC0489l() { // from class: androidx.activity.result.ActivityResultRegistry.1
                @Override // androidx.lifecycle.InterfaceC0489l
                public void onStateChanged(InterfaceC0492o interfaceC0492o2, Lifecycle.Event event) {
                    if (Lifecycle.Event.ON_START.equals(event)) {
                        ActivityResultRegistry.this.f7131e.put(str, new c<>(aVar, abstractC0540a));
                        if (ActivityResultRegistry.this.f7132f.containsKey(str)) {
                            Object obj = ActivityResultRegistry.this.f7132f.get(str);
                            ActivityResultRegistry.this.f7132f.remove(str);
                            aVar.a(obj);
                        }
                        ActivityResult activityResult = (ActivityResult) ActivityResultRegistry.this.f7133g.getParcelable(str);
                        if (activityResult != null) {
                            ActivityResultRegistry.this.f7133g.remove(str);
                            aVar.a(abstractC0540a.c(activityResult.d(), activityResult.b()));
                            return;
                        }
                        return;
                    }
                    if (Lifecycle.Event.ON_STOP.equals(event)) {
                        ActivityResultRegistry.this.f7131e.remove(str);
                    } else if (Lifecycle.Event.ON_DESTROY.equals(event)) {
                        ActivityResultRegistry.this.l(str);
                    }
                }
            });
            this.f7129c.put(str, dVar);
            return new a(str, abstractC0540a);
        }
        throw new IllegalStateException("LifecycleOwner " + interfaceC0492o + " is attempting to register while current state is " + lifecycle.b() + ". LifecycleOwners must call register before they are STARTED.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <I, O> androidx.activity.result.b<I> j(String str, AbstractC0540a<I, O> abstractC0540a, androidx.activity.result.a<O> aVar) {
        k(str);
        this.f7131e.put(str, new c<>(aVar, abstractC0540a));
        if (this.f7132f.containsKey(str)) {
            Object obj = this.f7132f.get(str);
            this.f7132f.remove(str);
            aVar.a(obj);
        }
        ActivityResult activityResult = (ActivityResult) this.f7133g.getParcelable(str);
        if (activityResult != null) {
            this.f7133g.remove(str);
            aVar.a(abstractC0540a.c(activityResult.d(), activityResult.b()));
        }
        return new b(str, abstractC0540a);
    }

    public final void k(String str) {
        if (this.f7128b.get(str) != null) {
            return;
        }
        a(e(), str);
    }

    public final void l(String str) {
        Integer remove;
        if (!this.f7130d.contains(str) && (remove = this.f7128b.remove(str)) != null) {
            this.f7127a.remove(remove);
        }
        this.f7131e.remove(str);
        if (this.f7132f.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f7132f.get(str));
            this.f7132f.remove(str);
        }
        if (this.f7133g.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f7133g.getParcelable(str));
            this.f7133g.remove(str);
        }
        d dVar = this.f7129c.get(str);
        if (dVar != null) {
            dVar.b();
            this.f7129c.remove(str);
        }
    }
}
