package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ImageView;
import com.bumptech.glide.b;
import java.util.List;
import java.util.Map;
import o3.C1401e;
import o3.InterfaceC1400d;
import p3.C1436f;
import s3.C1535f;

/* compiled from: GlideContext.java */
/* loaded from: classes.dex */
public class d extends ContextWrapper {

    /* renamed from: k, reason: collision with root package name */
    public static final j<?, ?> f19326k = new a();

    /* renamed from: a, reason: collision with root package name */
    public final a3.b f19327a;

    /* renamed from: b, reason: collision with root package name */
    public final C1535f.b<Registry> f19328b;

    /* renamed from: c, reason: collision with root package name */
    public final C1436f f19329c;

    /* renamed from: d, reason: collision with root package name */
    public final b.a f19330d;

    /* renamed from: e, reason: collision with root package name */
    public final List<InterfaceC1400d<Object>> f19331e;

    /* renamed from: f, reason: collision with root package name */
    public final Map<Class<?>, j<?, ?>> f19332f;

    /* renamed from: g, reason: collision with root package name */
    public final com.bumptech.glide.load.engine.f f19333g;

    /* renamed from: h, reason: collision with root package name */
    public final e f19334h;

    /* renamed from: i, reason: collision with root package name */
    public final int f19335i;

    /* renamed from: j, reason: collision with root package name */
    public C1401e f19336j;

    public d(Context context, a3.b bVar, C1535f.b<Registry> bVar2, C1436f c1436f, b.a aVar, Map<Class<?>, j<?, ?>> map, List<InterfaceC1400d<Object>> list, com.bumptech.glide.load.engine.f fVar, e eVar, int i10) {
        super(context.getApplicationContext());
        this.f19327a = bVar;
        this.f19329c = c1436f;
        this.f19330d = aVar;
        this.f19331e = list;
        this.f19332f = map;
        this.f19333g = fVar;
        this.f19334h = eVar;
        this.f19335i = i10;
        this.f19328b = C1535f.a(bVar2);
    }

    public <X> p3.i<ImageView, X> a(ImageView imageView, Class<X> cls) {
        return this.f19329c.a(imageView, cls);
    }

    public a3.b b() {
        return this.f19327a;
    }

    public List<InterfaceC1400d<Object>> c() {
        return this.f19331e;
    }

    public synchronized C1401e d() {
        try {
            if (this.f19336j == null) {
                this.f19336j = this.f19330d.build().M();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f19336j;
    }

    public <T> j<?, T> e(Class<T> cls) {
        j<?, T> jVar = (j) this.f19332f.get(cls);
        if (jVar == null) {
            for (Map.Entry<Class<?>, j<?, ?>> entry : this.f19332f.entrySet()) {
                if (entry.getKey().isAssignableFrom(cls)) {
                    jVar = (j) entry.getValue();
                }
            }
        }
        if (jVar == null) {
            return (j<?, T>) f19326k;
        }
        return jVar;
    }

    public com.bumptech.glide.load.engine.f f() {
        return this.f19333g;
    }

    public e g() {
        return this.f19334h;
    }

    public int h() {
        return this.f19335i;
    }

    public Registry i() {
        return this.f19328b.get();
    }
}
