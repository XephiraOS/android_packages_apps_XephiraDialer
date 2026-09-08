package androidx.lifecycle;

import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.K;
import java.lang.reflect.Constructor;
import java.util.List;

/* compiled from: SavedStateViewModelFactory.kt */
/* loaded from: classes.dex */
public final class E extends K.d implements K.b {

    /* renamed from: b, reason: collision with root package name */
    public Application f10247b;

    /* renamed from: c, reason: collision with root package name */
    public final K.b f10248c;

    /* renamed from: d, reason: collision with root package name */
    public Bundle f10249d;

    /* renamed from: e, reason: collision with root package name */
    public Lifecycle f10250e;

    /* renamed from: f, reason: collision with root package name */
    public androidx.savedstate.a f10251f;

    public E(Application application, d0.d owner, Bundle bundle) {
        K.a aVar;
        kotlin.jvm.internal.i.f(owner, "owner");
        this.f10251f = owner.getSavedStateRegistry();
        this.f10250e = owner.getLifecycle();
        this.f10249d = bundle;
        this.f10247b = application;
        if (application != null) {
            aVar = K.a.f10266f.b(application);
        } else {
            aVar = new K.a();
        }
        this.f10248c = aVar;
    }

    @Override // androidx.lifecycle.K.b
    public <T extends I> T a(Class<T> modelClass) {
        kotlin.jvm.internal.i.f(modelClass, "modelClass");
        String canonicalName = modelClass.getCanonicalName();
        if (canonicalName != null) {
            return (T) d(canonicalName, modelClass);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // androidx.lifecycle.K.b
    public <T extends I> T b(Class<T> modelClass, V.a extras) {
        List list;
        Constructor c10;
        List list2;
        kotlin.jvm.internal.i.f(modelClass, "modelClass");
        kotlin.jvm.internal.i.f(extras, "extras");
        String str = (String) extras.a(K.c.f10275d);
        if (str != null) {
            if (extras.a(SavedStateHandleSupport.f10325a) != null && extras.a(SavedStateHandleSupport.f10326b) != null) {
                Application application = (Application) extras.a(K.a.f10268h);
                boolean isAssignableFrom = AndroidViewModel.class.isAssignableFrom(modelClass);
                if (!isAssignableFrom || application == null) {
                    list = F.f10253b;
                    c10 = F.c(modelClass, list);
                } else {
                    list2 = F.f10252a;
                    c10 = F.c(modelClass, list2);
                }
                if (c10 == null) {
                    return (T) this.f10248c.b(modelClass, extras);
                }
                if (isAssignableFrom && application != null) {
                    return (T) F.d(modelClass, c10, application, SavedStateHandleSupport.a(extras));
                }
                return (T) F.d(modelClass, c10, SavedStateHandleSupport.a(extras));
            }
            if (this.f10250e != null) {
                return (T) d(str, modelClass);
            }
            throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
        }
        throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
    }

    @Override // androidx.lifecycle.K.d
    public void c(I viewModel) {
        kotlin.jvm.internal.i.f(viewModel, "viewModel");
        if (this.f10250e != null) {
            androidx.savedstate.a aVar = this.f10251f;
            kotlin.jvm.internal.i.c(aVar);
            Lifecycle lifecycle = this.f10250e;
            kotlin.jvm.internal.i.c(lifecycle);
            LegacySavedStateHandleController.a(viewModel, aVar, lifecycle);
        }
    }

    public final <T extends I> T d(String key, Class<T> modelClass) {
        List list;
        Constructor c10;
        T t10;
        Application application;
        List list2;
        kotlin.jvm.internal.i.f(key, "key");
        kotlin.jvm.internal.i.f(modelClass, "modelClass");
        Lifecycle lifecycle = this.f10250e;
        if (lifecycle != null) {
            boolean isAssignableFrom = AndroidViewModel.class.isAssignableFrom(modelClass);
            if (!isAssignableFrom || this.f10247b == null) {
                list = F.f10253b;
                c10 = F.c(modelClass, list);
            } else {
                list2 = F.f10252a;
                c10 = F.c(modelClass, list2);
            }
            if (c10 == null) {
                if (this.f10247b != null) {
                    return (T) this.f10248c.a(modelClass);
                }
                return (T) K.c.f10273b.a().a(modelClass);
            }
            androidx.savedstate.a aVar = this.f10251f;
            kotlin.jvm.internal.i.c(aVar);
            SavedStateHandleController b10 = LegacySavedStateHandleController.b(aVar, lifecycle, key, this.f10249d);
            if (isAssignableFrom && (application = this.f10247b) != null) {
                kotlin.jvm.internal.i.c(application);
                t10 = (T) F.d(modelClass, c10, application, b10.b());
            } else {
                t10 = (T) F.d(modelClass, c10, b10.b());
            }
            t10.f("androidx.lifecycle.savedstate.vm.tag", b10);
            return t10;
        }
        throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
    }
}
