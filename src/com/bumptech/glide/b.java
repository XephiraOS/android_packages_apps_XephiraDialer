package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;
import com.bumptech.glide.manager.n;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import m3.AbstractC1328a;
import m3.C1331d;
import m3.InterfaceC1329b;
import o3.C1401e;
import o3.InterfaceC1400d;
import p3.C1436f;
import p3.InterfaceC1438h;
import s3.C1540k;
import s3.C1541l;

/* compiled from: Glide.java */
/* loaded from: classes.dex */
public class b implements ComponentCallbacks2 {

    /* renamed from: k, reason: collision with root package name */
    public static volatile b f19296k;

    /* renamed from: l, reason: collision with root package name */
    public static volatile boolean f19297l;

    /* renamed from: a, reason: collision with root package name */
    public final com.bumptech.glide.load.engine.f f19298a;

    /* renamed from: b, reason: collision with root package name */
    public final a3.d f19299b;

    /* renamed from: c, reason: collision with root package name */
    public final b3.h f19300c;

    /* renamed from: d, reason: collision with root package name */
    public final d f19301d;

    /* renamed from: e, reason: collision with root package name */
    public final a3.b f19302e;

    /* renamed from: f, reason: collision with root package name */
    public final n f19303f;

    /* renamed from: g, reason: collision with root package name */
    public final com.bumptech.glide.manager.c f19304g;

    /* renamed from: i, reason: collision with root package name */
    public final a f19306i;

    /* renamed from: h, reason: collision with root package name */
    public final List<i> f19305h = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    public MemoryCategory f19307j = MemoryCategory.NORMAL;

    /* compiled from: Glide.java */
    /* loaded from: classes.dex */
    public interface a {
        C1401e build();
    }

    public b(Context context, com.bumptech.glide.load.engine.f fVar, b3.h hVar, a3.d dVar, a3.b bVar, n nVar, com.bumptech.glide.manager.c cVar, int i10, a aVar, Map<Class<?>, j<?, ?>> map, List<InterfaceC1400d<Object>> list, List<InterfaceC1329b> list2, AbstractC1328a abstractC1328a, e eVar) {
        this.f19298a = fVar;
        this.f19299b = dVar;
        this.f19302e = bVar;
        this.f19300c = hVar;
        this.f19303f = nVar;
        this.f19304g = cVar;
        this.f19306i = aVar;
        this.f19301d = new d(context, bVar, g.d(this, list2, abstractC1328a), new C1436f(), aVar, map, list, fVar, eVar, i10);
    }

    public static void a(Context context, GeneratedAppGlideModule generatedAppGlideModule) {
        if (!f19297l) {
            f19297l = true;
            try {
                m(context, generatedAppGlideModule);
                return;
            } finally {
                f19297l = false;
            }
        }
        throw new IllegalStateException("Glide has been called recursively, this is probably an internal library error!");
    }

    public static b c(Context context) {
        if (f19296k == null) {
            GeneratedAppGlideModule d10 = d(context.getApplicationContext());
            synchronized (b.class) {
                try {
                    if (f19296k == null) {
                        a(context, d10);
                    }
                } finally {
                }
            }
        }
        return f19296k;
    }

    public static GeneratedAppGlideModule d(Context context) {
        try {
            return (GeneratedAppGlideModule) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(Context.class).newInstance(context.getApplicationContext());
        } catch (ClassNotFoundException unused) {
            if (Log.isLoggable("Glide", 5)) {
                Log.w("Glide", "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
            }
            return null;
        } catch (IllegalAccessException e10) {
            q(e10);
            return null;
        } catch (InstantiationException e11) {
            q(e11);
            return null;
        } catch (NoSuchMethodException e12) {
            q(e12);
            return null;
        } catch (InvocationTargetException e13) {
            q(e13);
            return null;
        }
    }

    public static n l(Context context) {
        C1540k.e(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return c(context).k();
    }

    public static void m(Context context, GeneratedAppGlideModule generatedAppGlideModule) {
        n(context, new c(), generatedAppGlideModule);
    }

    public static void n(Context context, c cVar, GeneratedAppGlideModule generatedAppGlideModule) {
        n.b bVar;
        Context applicationContext = context.getApplicationContext();
        List<InterfaceC1329b> emptyList = Collections.emptyList();
        if (generatedAppGlideModule == null || generatedAppGlideModule.c()) {
            emptyList = new C1331d(applicationContext).b();
        }
        if (generatedAppGlideModule != null && !generatedAppGlideModule.d().isEmpty()) {
            Set<Class<?>> d10 = generatedAppGlideModule.d();
            Iterator<InterfaceC1329b> it = emptyList.iterator();
            while (it.hasNext()) {
                InterfaceC1329b next = it.next();
                if (d10.contains(next.getClass())) {
                    if (Log.isLoggable("Glide", 3)) {
                        Log.d("Glide", "AppGlideModule excludes manifest GlideModule: " + next);
                    }
                    it.remove();
                }
            }
        }
        if (Log.isLoggable("Glide", 3)) {
            Iterator<InterfaceC1329b> it2 = emptyList.iterator();
            while (it2.hasNext()) {
                Log.d("Glide", "Discovered GlideModule from manifest: " + it2.next().getClass());
            }
        }
        if (generatedAppGlideModule != null) {
            bVar = generatedAppGlideModule.e();
        } else {
            bVar = null;
        }
        cVar.b(bVar);
        Iterator<InterfaceC1329b> it3 = emptyList.iterator();
        while (it3.hasNext()) {
            it3.next().a(applicationContext, cVar);
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.b(applicationContext, cVar);
        }
        b a10 = cVar.a(applicationContext, emptyList, generatedAppGlideModule);
        applicationContext.registerComponentCallbacks(a10);
        f19296k = a10;
    }

    public static void q(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    public static i t(Context context) {
        return l(context).d(context);
    }

    public void b() {
        C1541l.a();
        this.f19300c.b();
        this.f19299b.b();
        this.f19302e.b();
    }

    public a3.b e() {
        return this.f19302e;
    }

    public a3.d f() {
        return this.f19299b;
    }

    public com.bumptech.glide.manager.c g() {
        return this.f19304g;
    }

    public Context h() {
        return this.f19301d.getBaseContext();
    }

    public d i() {
        return this.f19301d;
    }

    public Registry j() {
        return this.f19301d.i();
    }

    public n k() {
        return this.f19303f;
    }

    public void o(i iVar) {
        synchronized (this.f19305h) {
            try {
                if (!this.f19305h.contains(iVar)) {
                    this.f19305h.add(iVar);
                } else {
                    throw new IllegalStateException("Cannot register already registered manager");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        b();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i10) {
        r(i10);
    }

    public boolean p(InterfaceC1438h<?> interfaceC1438h) {
        synchronized (this.f19305h) {
            try {
                Iterator<i> it = this.f19305h.iterator();
                while (it.hasNext()) {
                    if (it.next().y(interfaceC1438h)) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void r(int i10) {
        C1541l.a();
        synchronized (this.f19305h) {
            try {
                Iterator<i> it = this.f19305h.iterator();
                while (it.hasNext()) {
                    it.next().onTrimMemory(i10);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f19300c.a(i10);
        this.f19299b.a(i10);
        this.f19302e.a(i10);
    }

    public void s(i iVar) {
        synchronized (this.f19305h) {
            try {
                if (this.f19305h.contains(iVar)) {
                    this.f19305h.remove(iVar);
                } else {
                    throw new IllegalStateException("Cannot unregister not yet registered manager");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }
}
