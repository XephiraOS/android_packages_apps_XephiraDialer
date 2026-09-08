package androidx.lifecycle;

import V.a;
import android.app.Application;
import java.lang.reflect.InvocationTargetException;

/* compiled from: ViewModelProvider.kt */
/* loaded from: classes.dex */
public class K {

    /* renamed from: a, reason: collision with root package name */
    public final M f10263a;

    /* renamed from: b, reason: collision with root package name */
    public final b f10264b;

    /* renamed from: c, reason: collision with root package name */
    public final V.a f10265c;

    /* compiled from: ViewModelProvider.kt */
    /* loaded from: classes.dex */
    public interface b {

        /* renamed from: a, reason: collision with root package name */
        public static final a f10271a = a.f10272a;

        /* compiled from: ViewModelProvider.kt */
        /* loaded from: classes.dex */
        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f10272a = new a();
        }

        default <T extends I> T a(Class<T> modelClass) {
            kotlin.jvm.internal.i.f(modelClass, "modelClass");
            throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
        }

        default <T extends I> T b(Class<T> modelClass, V.a extras) {
            kotlin.jvm.internal.i.f(modelClass, "modelClass");
            kotlin.jvm.internal.i.f(extras, "extras");
            return (T) a(modelClass);
        }
    }

    /* compiled from: ViewModelProvider.kt */
    /* loaded from: classes.dex */
    public static class c implements b {

        /* renamed from: c, reason: collision with root package name */
        public static c f10274c;

        /* renamed from: b, reason: collision with root package name */
        public static final a f10273b = new a(null);

        /* renamed from: d, reason: collision with root package name */
        public static final a.b<String> f10275d = a.C0126a.f10276a;

        /* compiled from: ViewModelProvider.kt */
        /* loaded from: classes.dex */
        public static final class a {

            /* compiled from: ViewModelProvider.kt */
            /* renamed from: androidx.lifecycle.K$c$a$a, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0126a implements a.b<String> {

                /* renamed from: a, reason: collision with root package name */
                public static final C0126a f10276a = new C0126a();
            }

            public a() {
            }

            public final c a() {
                if (c.f10274c == null) {
                    c.f10274c = new c();
                }
                c cVar = c.f10274c;
                kotlin.jvm.internal.i.c(cVar);
                return cVar;
            }

            public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
                this();
            }
        }

        @Override // androidx.lifecycle.K.b
        public <T extends I> T a(Class<T> modelClass) {
            kotlin.jvm.internal.i.f(modelClass, "modelClass");
            try {
                T newInstance = modelClass.getDeclaredConstructor(null).newInstance(null);
                kotlin.jvm.internal.i.e(newInstance, "{\n                modelC…wInstance()\n            }");
                return newInstance;
            } catch (IllegalAccessException e10) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e10);
            } catch (InstantiationException e11) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e11);
            } catch (NoSuchMethodException e12) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e12);
            }
        }
    }

    /* compiled from: ViewModelProvider.kt */
    /* loaded from: classes.dex */
    public static class d {
        public void c(I viewModel) {
            kotlin.jvm.internal.i.f(viewModel, "viewModel");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public K(M store, b factory) {
        this(store, factory, null, 4, null);
        kotlin.jvm.internal.i.f(store, "store");
        kotlin.jvm.internal.i.f(factory, "factory");
    }

    public <T extends I> T a(Class<T> modelClass) {
        kotlin.jvm.internal.i.f(modelClass, "modelClass");
        String canonicalName = modelClass.getCanonicalName();
        if (canonicalName != null) {
            return (T) b("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, modelClass);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public <T extends I> T b(String key, Class<T> modelClass) {
        T t10;
        d dVar;
        kotlin.jvm.internal.i.f(key, "key");
        kotlin.jvm.internal.i.f(modelClass, "modelClass");
        T t11 = (T) this.f10263a.b(key);
        if (modelClass.isInstance(t11)) {
            Object obj = this.f10264b;
            if (obj instanceof d) {
                dVar = (d) obj;
            } else {
                dVar = null;
            }
            if (dVar != null) {
                kotlin.jvm.internal.i.c(t11);
                dVar.c(t11);
            }
            kotlin.jvm.internal.i.d(t11, "null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
            return t11;
        }
        V.d dVar2 = new V.d(this.f10265c);
        dVar2.c(c.f10275d, key);
        try {
            t10 = (T) this.f10264b.b(modelClass, dVar2);
        } catch (AbstractMethodError unused) {
            t10 = (T) this.f10264b.a(modelClass);
        }
        this.f10263a.d(key, t10);
        return t10;
    }

    /* compiled from: ViewModelProvider.kt */
    /* loaded from: classes.dex */
    public static class a extends c {

        /* renamed from: g, reason: collision with root package name */
        public static a f10267g;

        /* renamed from: e, reason: collision with root package name */
        public final Application f10269e;

        /* renamed from: f, reason: collision with root package name */
        public static final C0124a f10266f = new C0124a(null);

        /* renamed from: h, reason: collision with root package name */
        public static final a.b<Application> f10268h = C0124a.C0125a.f10270a;

        /* compiled from: ViewModelProvider.kt */
        /* renamed from: androidx.lifecycle.K$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0124a {

            /* compiled from: ViewModelProvider.kt */
            /* renamed from: androidx.lifecycle.K$a$a$a, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0125a implements a.b<Application> {

                /* renamed from: a, reason: collision with root package name */
                public static final C0125a f10270a = new C0125a();
            }

            public C0124a() {
            }

            public final b a(N owner) {
                kotlin.jvm.internal.i.f(owner, "owner");
                if (owner instanceof InterfaceC0485h) {
                    return ((InterfaceC0485h) owner).getDefaultViewModelProviderFactory();
                }
                return c.f10273b.a();
            }

            public final a b(Application application) {
                kotlin.jvm.internal.i.f(application, "application");
                if (a.f10267g == null) {
                    a.f10267g = new a(application);
                }
                a aVar = a.f10267g;
                kotlin.jvm.internal.i.c(aVar);
                return aVar;
            }

            public /* synthetic */ C0124a(kotlin.jvm.internal.f fVar) {
                this();
            }
        }

        public a(Application application, int i10) {
            this.f10269e = application;
        }

        @Override // androidx.lifecycle.K.c, androidx.lifecycle.K.b
        public <T extends I> T a(Class<T> modelClass) {
            kotlin.jvm.internal.i.f(modelClass, "modelClass");
            Application application = this.f10269e;
            if (application != null) {
                return (T) g(modelClass, application);
            }
            throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
        }

        @Override // androidx.lifecycle.K.b
        public <T extends I> T b(Class<T> modelClass, V.a extras) {
            kotlin.jvm.internal.i.f(modelClass, "modelClass");
            kotlin.jvm.internal.i.f(extras, "extras");
            if (this.f10269e != null) {
                return (T) a(modelClass);
            }
            Application application = (Application) extras.a(f10268h);
            if (application != null) {
                return (T) g(modelClass, application);
            }
            if (!AndroidViewModel.class.isAssignableFrom(modelClass)) {
                return (T) super.a(modelClass);
            }
            throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
        }

        public final <T extends I> T g(Class<T> cls, Application application) {
            if (AndroidViewModel.class.isAssignableFrom(cls)) {
                try {
                    T newInstance = cls.getConstructor(Application.class).newInstance(application);
                    kotlin.jvm.internal.i.e(newInstance, "{\n                try {\n…          }\n            }");
                    return newInstance;
                } catch (IllegalAccessException e10) {
                    throw new RuntimeException("Cannot create an instance of " + cls, e10);
                } catch (InstantiationException e11) {
                    throw new RuntimeException("Cannot create an instance of " + cls, e11);
                } catch (NoSuchMethodException e12) {
                    throw new RuntimeException("Cannot create an instance of " + cls, e12);
                } catch (InvocationTargetException e13) {
                    throw new RuntimeException("Cannot create an instance of " + cls, e13);
                }
            }
            return (T) super.a(cls);
        }

        public a() {
            this(null, 0);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(Application application) {
            this(application, 0);
            kotlin.jvm.internal.i.f(application, "application");
        }
    }

    public K(M store, b factory, V.a defaultCreationExtras) {
        kotlin.jvm.internal.i.f(store, "store");
        kotlin.jvm.internal.i.f(factory, "factory");
        kotlin.jvm.internal.i.f(defaultCreationExtras, "defaultCreationExtras");
        this.f10263a = store;
        this.f10264b = factory;
        this.f10265c = defaultCreationExtras;
    }

    public /* synthetic */ K(M m10, b bVar, V.a aVar, int i10, kotlin.jvm.internal.f fVar) {
        this(m10, bVar, (i10 & 4) != 0 ? a.C0073a.f3957b : aVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public K(N owner) {
        this(owner.getViewModelStore(), a.f10266f.a(owner), L.a(owner));
        kotlin.jvm.internal.i.f(owner, "owner");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public K(N owner, b factory) {
        this(owner.getViewModelStore(), factory, L.a(owner));
        kotlin.jvm.internal.i.f(owner, "owner");
        kotlin.jvm.internal.i.f(factory, "factory");
    }
}
