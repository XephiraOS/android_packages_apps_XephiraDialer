package androidx.lifecycle;

import V.a;
import android.os.Bundle;
import androidx.lifecycle.K;
import androidx.lifecycle.Lifecycle;
import androidx.savedstate.a;

/* compiled from: SavedStateHandleSupport.kt */
/* loaded from: classes.dex */
public final class SavedStateHandleSupport {

    /* renamed from: a, reason: collision with root package name */
    public static final a.b<d0.d> f10325a = new b();

    /* renamed from: b, reason: collision with root package name */
    public static final a.b<N> f10326b = new c();

    /* renamed from: c, reason: collision with root package name */
    public static final a.b<Bundle> f10327c = new a();

    /* compiled from: SavedStateHandleSupport.kt */
    /* loaded from: classes.dex */
    public static final class a implements a.b<Bundle> {
    }

    /* compiled from: SavedStateHandleSupport.kt */
    /* loaded from: classes.dex */
    public static final class b implements a.b<d0.d> {
    }

    /* compiled from: SavedStateHandleSupport.kt */
    /* loaded from: classes.dex */
    public static final class c implements a.b<N> {
    }

    public static final D a(V.a aVar) {
        kotlin.jvm.internal.i.f(aVar, "<this>");
        d0.d dVar = (d0.d) aVar.a(f10325a);
        if (dVar != null) {
            N n10 = (N) aVar.a(f10326b);
            if (n10 != null) {
                Bundle bundle = (Bundle) aVar.a(f10327c);
                String str = (String) aVar.a(K.c.f10275d);
                if (str != null) {
                    return b(dVar, n10, str, bundle);
                }
                throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
            }
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
        }
        throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
    }

    public static final D b(d0.d dVar, N n10, String str, Bundle bundle) {
        SavedStateHandlesProvider d10 = d(dVar);
        SavedStateHandlesVM e10 = e(n10);
        D d11 = e10.g().get(str);
        if (d11 == null) {
            D a10 = D.f10237f.a(d10.a(str), bundle);
            e10.g().put(str, a10);
            return a10;
        }
        return d11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T extends d0.d & N> void c(T t10) {
        kotlin.jvm.internal.i.f(t10, "<this>");
        Lifecycle.State b10 = t10.getLifecycle().b();
        if (b10 != Lifecycle.State.INITIALIZED && b10 != Lifecycle.State.CREATED) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (t10.getSavedStateRegistry().c("androidx.lifecycle.internal.SavedStateHandlesProvider") == null) {
            SavedStateHandlesProvider savedStateHandlesProvider = new SavedStateHandlesProvider(t10.getSavedStateRegistry(), t10);
            t10.getSavedStateRegistry().h("androidx.lifecycle.internal.SavedStateHandlesProvider", savedStateHandlesProvider);
            t10.getLifecycle().a(new SavedStateHandleAttacher(savedStateHandlesProvider));
        }
    }

    public static final SavedStateHandlesProvider d(d0.d dVar) {
        SavedStateHandlesProvider savedStateHandlesProvider;
        kotlin.jvm.internal.i.f(dVar, "<this>");
        a.c c10 = dVar.getSavedStateRegistry().c("androidx.lifecycle.internal.SavedStateHandlesProvider");
        if (c10 instanceof SavedStateHandlesProvider) {
            savedStateHandlesProvider = (SavedStateHandlesProvider) c10;
        } else {
            savedStateHandlesProvider = null;
        }
        if (savedStateHandlesProvider != null) {
            return savedStateHandlesProvider;
        }
        throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
    }

    public static final SavedStateHandlesVM e(N n10) {
        kotlin.jvm.internal.i.f(n10, "<this>");
        V.c cVar = new V.c();
        cVar.a(kotlin.jvm.internal.k.b(SavedStateHandlesVM.class), new v9.l<V.a, SavedStateHandlesVM>() { // from class: androidx.lifecycle.SavedStateHandleSupport$savedStateHandlesVM$1$1
            @Override // v9.l
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final SavedStateHandlesVM invoke(V.a initializer) {
                kotlin.jvm.internal.i.f(initializer, "$this$initializer");
                return new SavedStateHandlesVM();
            }
        });
        return (SavedStateHandlesVM) new K(n10, cVar.b()).b("androidx.lifecycle.internal.SavedStateHandlesVM", SavedStateHandlesVM.class);
    }
}
