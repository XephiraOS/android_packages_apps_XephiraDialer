package com.bumptech.glide;

import android.content.Context;
import b3.InterfaceC0520a;
import b3.i;
import c3.ExecutorServiceC0552a;
import com.bumptech.glide.b;
import com.bumptech.glide.e;
import com.bumptech.glide.manager.n;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import m3.AbstractC1328a;
import m3.InterfaceC1329b;
import o3.C1401e;
import o3.InterfaceC1400d;
import p.C1415a;

/* compiled from: GlideBuilder.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: c, reason: collision with root package name */
    public com.bumptech.glide.load.engine.f f19310c;

    /* renamed from: d, reason: collision with root package name */
    public a3.d f19311d;

    /* renamed from: e, reason: collision with root package name */
    public a3.b f19312e;

    /* renamed from: f, reason: collision with root package name */
    public b3.h f19313f;

    /* renamed from: g, reason: collision with root package name */
    public ExecutorServiceC0552a f19314g;

    /* renamed from: h, reason: collision with root package name */
    public ExecutorServiceC0552a f19315h;

    /* renamed from: i, reason: collision with root package name */
    public InterfaceC0520a.InterfaceC0145a f19316i;

    /* renamed from: j, reason: collision with root package name */
    public b3.i f19317j;

    /* renamed from: k, reason: collision with root package name */
    public com.bumptech.glide.manager.c f19318k;

    /* renamed from: n, reason: collision with root package name */
    public n.b f19321n;

    /* renamed from: o, reason: collision with root package name */
    public ExecutorServiceC0552a f19322o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f19323p;

    /* renamed from: q, reason: collision with root package name */
    public List<InterfaceC1400d<Object>> f19324q;

    /* renamed from: a, reason: collision with root package name */
    public final Map<Class<?>, j<?, ?>> f19308a = new C1415a();

    /* renamed from: b, reason: collision with root package name */
    public final e.a f19309b = new e.a();

    /* renamed from: l, reason: collision with root package name */
    public int f19319l = 4;

    /* renamed from: m, reason: collision with root package name */
    public b.a f19320m = new a();

    /* compiled from: GlideBuilder.java */
    /* loaded from: classes.dex */
    public class a implements b.a {
        public a() {
        }

        @Override // com.bumptech.glide.b.a
        public C1401e build() {
            return new C1401e();
        }
    }

    /* compiled from: GlideBuilder.java */
    /* loaded from: classes.dex */
    public static final class b {
    }

    /* compiled from: GlideBuilder.java */
    /* renamed from: com.bumptech.glide.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0188c {
    }

    public com.bumptech.glide.b a(Context context, List<InterfaceC1329b> list, AbstractC1328a abstractC1328a) {
        if (this.f19314g == null) {
            this.f19314g = ExecutorServiceC0552a.i();
        }
        if (this.f19315h == null) {
            this.f19315h = ExecutorServiceC0552a.g();
        }
        if (this.f19322o == null) {
            this.f19322o = ExecutorServiceC0552a.d();
        }
        if (this.f19317j == null) {
            this.f19317j = new i.a(context).a();
        }
        if (this.f19318k == null) {
            this.f19318k = new com.bumptech.glide.manager.e();
        }
        if (this.f19311d == null) {
            int b10 = this.f19317j.b();
            if (b10 > 0) {
                this.f19311d = new a3.j(b10);
            } else {
                this.f19311d = new a3.e();
            }
        }
        if (this.f19312e == null) {
            this.f19312e = new a3.i(this.f19317j.a());
        }
        if (this.f19313f == null) {
            this.f19313f = new b3.g(this.f19317j.d());
        }
        if (this.f19316i == null) {
            this.f19316i = new b3.f(context);
        }
        if (this.f19310c == null) {
            this.f19310c = new com.bumptech.glide.load.engine.f(this.f19313f, this.f19316i, this.f19315h, this.f19314g, ExecutorServiceC0552a.j(), this.f19322o, this.f19323p);
        }
        List<InterfaceC1400d<Object>> list2 = this.f19324q;
        if (list2 == null) {
            this.f19324q = Collections.emptyList();
        } else {
            this.f19324q = Collections.unmodifiableList(list2);
        }
        return new com.bumptech.glide.b(context, this.f19310c, this.f19313f, this.f19311d, this.f19312e, new n(this.f19321n), this.f19318k, this.f19319l, this.f19320m, this.f19308a, this.f19324q, list, abstractC1328a, this.f19309b.b());
    }

    public void b(n.b bVar) {
        this.f19321n = bVar;
    }
}
