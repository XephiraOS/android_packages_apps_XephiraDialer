package com.oplus.epona;

import android.app.Application;
import android.content.Context;
import com.oplus.epona.interceptor.IPCInterceptor;
import com.oplus.epona.provider.ProviderInfo;
import com.oplus.utils.C0864z;
import f7.C1019a;
import h7.C1084a;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Epona.java */
/* loaded from: classes3.dex */
public class d {

    /* renamed from: n, reason: collision with root package name */
    public static d f28144n;

    /* renamed from: h, reason: collision with root package name */
    public Application f28153h;

    /* renamed from: j, reason: collision with root package name */
    public Context f28155j;

    /* renamed from: k, reason: collision with root package name */
    public static final h7.c f28141k = new C1084a();

    /* renamed from: l, reason: collision with root package name */
    public static final e f28142l = new g();

    /* renamed from: m, reason: collision with root package name */
    public static final Object f28143m = new Object();

    /* renamed from: o, reason: collision with root package name */
    public static AtomicBoolean f28145o = new AtomicBoolean(false);

    /* renamed from: a, reason: collision with root package name */
    public Map<String, b> f28146a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    public final List<f> f28147b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public h7.c f28148c = f28141k;

    /* renamed from: d, reason: collision with root package name */
    public e f28149d = f28142l;

    /* renamed from: e, reason: collision with root package name */
    public f f28150e = new IPCInterceptor();

    /* renamed from: g, reason: collision with root package name */
    public h f28152g = new f7.e();

    /* renamed from: f, reason: collision with root package name */
    public j f28151f = new j();

    /* renamed from: i, reason: collision with root package name */
    public C1019a f28154i = new C1019a();

    public static boolean a(b bVar) {
        Map<String, b> map = j().f28146a;
        if (bVar != null && !map.containsKey(bVar.b())) {
            map.put(bVar.b(), bVar);
            return true;
        }
        return false;
    }

    public static void d(PrintWriter printWriter) {
        j().f28152g.c(printWriter);
    }

    public static c e(String str) {
        return j().f28152g.a(str);
    }

    public static ProviderInfo f(String str) {
        return j().f28152g.b(str);
    }

    public static Context g() {
        return j().f28155j;
    }

    public static b h(String str) {
        if (str != null && str.length() > 0) {
            return j().f28146a.get(str);
        }
        return null;
    }

    public static f i() {
        return j().f28150e;
    }

    public static d j() {
        synchronized (f28143m) {
            try {
                if (f28144n == null) {
                    f28144n = new d();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f28144n;
    }

    public static List<f> k() {
        return j().f28147b;
    }

    public static e l() {
        return j().f28149d;
    }

    public static h7.c m() {
        return j().f28148c;
    }

    public static void n(Context context) {
        if (f28145o.getAndSet(true)) {
            return;
        }
        j().b(context);
        a(i7.b.e());
        C0864z.g().h(context);
        c();
    }

    public static f7.f o(Request request) {
        return j().f28151f.i(request);
    }

    public static void p(f fVar) {
        j().f28150e = fVar;
    }

    public static void q(e eVar) {
        j().f28149d = eVar;
    }

    public static void r(h7.c cVar) {
        j().f28148c = cVar;
    }

    public final void b(Context context) {
        this.f28155j = context;
        if (context instanceof Application) {
            this.f28153h = (Application) context;
        } else {
            this.f28153h = (Application) context.getApplicationContext();
        }
        this.f28154i.c(this.f28153h);
    }

    public static void c() {
    }
}
