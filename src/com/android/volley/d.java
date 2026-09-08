package com.android.volley;

import com.android.volley.a;

/* compiled from: Response.java */
/* loaded from: classes.dex */
public class d<T> {

    /* renamed from: a, reason: collision with root package name */
    public final T f19247a;

    /* renamed from: b, reason: collision with root package name */
    public final a.C0186a f19248b;

    /* renamed from: c, reason: collision with root package name */
    public final VolleyError f19249c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f19250d;

    /* compiled from: Response.java */
    /* loaded from: classes.dex */
    public interface a {
        void b(VolleyError volleyError);
    }

    /* compiled from: Response.java */
    /* loaded from: classes.dex */
    public interface b<T> {
        void a(T t10);
    }

    public d(T t10, a.C0186a c0186a) {
        this.f19250d = false;
        this.f19247a = t10;
        this.f19248b = c0186a;
        this.f19249c = null;
    }

    public static <T> d<T> a(VolleyError volleyError) {
        return new d<>(volleyError);
    }

    public static <T> d<T> c(T t10, a.C0186a c0186a) {
        return new d<>(t10, c0186a);
    }

    public boolean b() {
        if (this.f19249c == null) {
            return true;
        }
        return false;
    }

    public d(VolleyError volleyError) {
        this.f19250d = false;
        this.f19247a = null;
        this.f19248b = null;
        this.f19249c = volleyError;
    }
}
