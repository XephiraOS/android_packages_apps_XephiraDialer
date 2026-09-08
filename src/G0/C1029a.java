package g0;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.startup.InitializationProvider;
import androidx.startup.StartupException;
import i0.C1089a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: AppInitializer.java */
/* renamed from: g0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1029a {

    /* renamed from: d, reason: collision with root package name */
    public static volatile C1029a f31816d;

    /* renamed from: e, reason: collision with root package name */
    public static final Object f31817e = new Object();

    /* renamed from: c, reason: collision with root package name */
    public final Context f31820c;

    /* renamed from: b, reason: collision with root package name */
    public final Set<Class<? extends InterfaceC1030b<?>>> f31819b = new HashSet();

    /* renamed from: a, reason: collision with root package name */
    public final Map<Class<?>, Object> f31818a = new HashMap();

    public C1029a(Context context) {
        this.f31820c = context.getApplicationContext();
    }

    public static C1029a e(Context context) {
        if (f31816d == null) {
            synchronized (f31817e) {
                try {
                    if (f31816d == null) {
                        f31816d = new C1029a(context);
                    }
                } finally {
                }
            }
        }
        return f31816d;
    }

    public void a() {
        try {
            try {
                C1089a.a("Startup");
                b(this.f31820c.getPackageManager().getProviderInfo(new ComponentName(this.f31820c.getPackageName(), InitializationProvider.class.getName()), 128).metaData);
            } catch (PackageManager.NameNotFoundException e10) {
                throw new StartupException(e10);
            }
        } finally {
            C1089a.b();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void b(Bundle bundle) {
        String string = this.f31820c.getString(C1031c.f31821a);
        if (bundle != null) {
            try {
                HashSet hashSet = new HashSet();
                for (String str : bundle.keySet()) {
                    if (string.equals(bundle.getString(str, null))) {
                        Class<?> cls = Class.forName(str);
                        if (InterfaceC1030b.class.isAssignableFrom(cls)) {
                            this.f31819b.add(cls);
                        }
                    }
                }
                Iterator<Class<? extends InterfaceC1030b<?>>> it = this.f31819b.iterator();
                while (it.hasNext()) {
                    d(it.next(), hashSet);
                }
            } catch (ClassNotFoundException e10) {
                throw new StartupException(e10);
            }
        }
    }

    public <T> T c(Class<? extends InterfaceC1030b<?>> cls) {
        T t10;
        synchronized (f31817e) {
            try {
                t10 = (T) this.f31818a.get(cls);
                if (t10 == null) {
                    t10 = (T) d(cls, new HashSet());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return t10;
    }

    public final <T> T d(Class<? extends InterfaceC1030b<?>> cls, Set<Class<?>> set) {
        T t10;
        if (C1089a.c()) {
            try {
                C1089a.a(cls.getSimpleName());
            } catch (Throwable th) {
                C1089a.b();
                throw th;
            }
        }
        if (!set.contains(cls)) {
            if (!this.f31818a.containsKey(cls)) {
                set.add(cls);
                try {
                    InterfaceC1030b<?> newInstance = cls.getDeclaredConstructor(null).newInstance(null);
                    List<Class<? extends InterfaceC1030b<?>>> a10 = newInstance.a();
                    if (!a10.isEmpty()) {
                        for (Class<? extends InterfaceC1030b<?>> cls2 : a10) {
                            if (!this.f31818a.containsKey(cls2)) {
                                d(cls2, set);
                            }
                        }
                    }
                    t10 = (T) newInstance.b(this.f31820c);
                    set.remove(cls);
                    this.f31818a.put(cls, t10);
                } catch (Throwable th2) {
                    throw new StartupException(th2);
                }
            } else {
                t10 = (T) this.f31818a.get(cls);
            }
            C1089a.b();
            return t10;
        }
        throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", cls.getName()));
    }

    public <T> T f(Class<? extends InterfaceC1030b<T>> cls) {
        return (T) c(cls);
    }

    public boolean g(Class<? extends InterfaceC1030b<?>> cls) {
        return this.f31819b.contains(cls);
    }
}
