package com.heytap.epona;

import android.app.Application;
import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Epona.java */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: i, reason: collision with root package name */
    public static c f25428i;

    /* renamed from: d, reason: collision with root package name */
    public Application f25433d;

    /* renamed from: g, reason: collision with root package name */
    public Context f25436g;

    /* renamed from: h, reason: collision with root package name */
    public static final Object f25427h = new Object();

    /* renamed from: j, reason: collision with root package name */
    public static AtomicBoolean f25429j = new AtomicBoolean(false);

    /* renamed from: a, reason: collision with root package name */
    public final List<d> f25430a = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public e f25432c = new C5.d();

    /* renamed from: b, reason: collision with root package name */
    public g f25431b = new g();

    /* renamed from: f, reason: collision with root package name */
    public C5.g f25435f = new C5.c();

    /* renamed from: e, reason: collision with root package name */
    public C5.a f25434e = new C5.a();

    public static b c(String str) {
        return g().f25432c.a(str);
    }

    public static G5.a d(String str) {
        return g().f25432c.b(str);
    }

    public static Application e() {
        return g().f25433d;
    }

    public static Context f() {
        return g().f25436g;
    }

    public static c g() {
        synchronized (f25427h) {
            try {
                if (f25428i == null) {
                    f25428i = new c();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f25428i;
    }

    public static List<d> h() {
        return g().f25430a;
    }

    public static void i(Context context) {
        if (f25429j.getAndSet(true)) {
            return;
        }
        g().a(context);
        H5.a.e(context);
        I5.b.a().b(context);
        b();
    }

    public static C5.e j(Request request) {
        return g().f25431b.i(request);
    }

    public final void a(Context context) {
        this.f25436g = context;
        if (context instanceof Application) {
            this.f25433d = (Application) context;
        } else {
            this.f25433d = (Application) context.getApplicationContext();
        }
        this.f25434e.c(this.f25433d);
    }

    public static void b() {
    }
}
