package com.bumptech.glide;

import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.e;
import d3.o;
import d3.p;
import d3.q;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import n3.C1364a;
import n3.C1365b;
import n3.C1366c;
import n3.C1367d;
import n3.C1368e;
import n3.C1369f;
import t3.C1589a;

/* loaded from: classes.dex */
public class Registry {

    /* renamed from: a, reason: collision with root package name */
    public final q f19286a;

    /* renamed from: b, reason: collision with root package name */
    public final C1364a f19287b;

    /* renamed from: c, reason: collision with root package name */
    public final C1368e f19288c;

    /* renamed from: d, reason: collision with root package name */
    public final C1369f f19289d;

    /* renamed from: e, reason: collision with root package name */
    public final com.bumptech.glide.load.data.f f19290e;

    /* renamed from: f, reason: collision with root package name */
    public final l3.f f19291f;

    /* renamed from: g, reason: collision with root package name */
    public final C1365b f19292g;

    /* renamed from: h, reason: collision with root package name */
    public final C1367d f19293h = new C1367d();

    /* renamed from: i, reason: collision with root package name */
    public final C1366c f19294i = new C1366c();

    /* renamed from: j, reason: collision with root package name */
    public final I.e<List<Throwable>> f19295j;

    /* loaded from: classes.dex */
    public static class MissingComponentException extends RuntimeException {
        public MissingComponentException(String str) {
            super(str);
        }
    }

    /* loaded from: classes.dex */
    public static final class NoImageHeaderParserException extends MissingComponentException {
        public NoImageHeaderParserException() {
            super("Failed to find image header parser.");
        }
    }

    /* loaded from: classes.dex */
    public static class NoModelLoaderAvailableException extends MissingComponentException {
        public NoModelLoaderAvailableException(Object obj) {
            super("Failed to find any ModelLoaders registered for model class: " + obj.getClass());
        }

        public <M> NoModelLoaderAvailableException(M m10, List<o<M, ?>> list) {
            super("Found ModelLoaders for model class: " + list + ", but none that handle this specific model instance: " + m10);
        }

        public NoModelLoaderAvailableException(Class<?> cls, Class<?> cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }
    }

    /* loaded from: classes.dex */
    public static class NoResultEncoderAvailableException extends MissingComponentException {
        public NoResultEncoderAvailableException(Class<?> cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    /* loaded from: classes.dex */
    public static class NoSourceEncoderAvailableException extends MissingComponentException {
        public NoSourceEncoderAvailableException(Class<?> cls) {
            super("Failed to find source encoder for data class: " + cls);
        }
    }

    public Registry() {
        I.e<List<Throwable>> e10 = C1589a.e();
        this.f19295j = e10;
        this.f19286a = new q(e10);
        this.f19287b = new C1364a();
        this.f19288c = new C1368e();
        this.f19289d = new C1369f();
        this.f19290e = new com.bumptech.glide.load.data.f();
        this.f19291f = new l3.f();
        this.f19292g = new C1365b();
        r(Arrays.asList("Animation", "Bitmap", "BitmapDrawable"));
    }

    public <Data> Registry a(Class<Data> cls, X2.a<Data> aVar) {
        this.f19287b.a(cls, aVar);
        return this;
    }

    public <TResource> Registry b(Class<TResource> cls, X2.f<TResource> fVar) {
        this.f19289d.a(cls, fVar);
        return this;
    }

    public <Data, TResource> Registry c(Class<Data> cls, Class<TResource> cls2, X2.e<Data, TResource> eVar) {
        e("legacy_append", cls, cls2, eVar);
        return this;
    }

    public <Model, Data> Registry d(Class<Model> cls, Class<Data> cls2, p<Model, Data> pVar) {
        this.f19286a.a(cls, cls2, pVar);
        return this;
    }

    public <Data, TResource> Registry e(String str, Class<Data> cls, Class<TResource> cls2, X2.e<Data, TResource> eVar) {
        this.f19288c.a(str, eVar, cls, cls2);
        return this;
    }

    public final <Data, TResource, Transcode> List<com.bumptech.glide.load.engine.e<Data, TResource, Transcode>> f(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        ArrayList arrayList = new ArrayList();
        for (Class cls4 : this.f19288c.d(cls, cls2)) {
            for (Class cls5 : this.f19291f.b(cls4, cls3)) {
                arrayList.add(new com.bumptech.glide.load.engine.e(cls, cls4, cls5, this.f19288c.b(cls, cls4), this.f19291f.a(cls4, cls5), this.f19295j));
            }
        }
        return arrayList;
    }

    public List<ImageHeaderParser> g() {
        List<ImageHeaderParser> b10 = this.f19292g.b();
        if (!b10.isEmpty()) {
            return b10;
        }
        throw new NoImageHeaderParserException();
    }

    public <Data, TResource, Transcode> com.bumptech.glide.load.engine.i<Data, TResource, Transcode> h(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        com.bumptech.glide.load.engine.i<Data, TResource, Transcode> a10 = this.f19294i.a(cls, cls2, cls3);
        if (this.f19294i.c(a10)) {
            return null;
        }
        if (a10 == null) {
            List<com.bumptech.glide.load.engine.e<Data, TResource, Transcode>> f10 = f(cls, cls2, cls3);
            if (f10.isEmpty()) {
                a10 = null;
            } else {
                a10 = new com.bumptech.glide.load.engine.i<>(cls, cls2, cls3, f10, this.f19295j);
            }
            this.f19294i.d(cls, cls2, cls3, a10);
        }
        return a10;
    }

    public <Model> List<o<Model, ?>> i(Model model) {
        return this.f19286a.d(model);
    }

    public <Model, TResource, Transcode> List<Class<?>> j(Class<Model> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        List<Class<?>> a10 = this.f19293h.a(cls, cls2, cls3);
        if (a10 == null) {
            a10 = new ArrayList<>();
            Iterator<Class<?>> it = this.f19286a.c(cls).iterator();
            while (it.hasNext()) {
                for (Class<?> cls4 : this.f19288c.d(it.next(), cls2)) {
                    if (!this.f19291f.b(cls4, cls3).isEmpty() && !a10.contains(cls4)) {
                        a10.add(cls4);
                    }
                }
            }
            this.f19293h.b(cls, cls2, cls3, Collections.unmodifiableList(a10));
        }
        return a10;
    }

    public <X> X2.f<X> k(Z2.j<X> jVar) {
        X2.f<X> b10 = this.f19289d.b(jVar.d());
        if (b10 != null) {
            return b10;
        }
        throw new NoResultEncoderAvailableException(jVar.d());
    }

    public <X> com.bumptech.glide.load.data.e<X> l(X x10) {
        return this.f19290e.a(x10);
    }

    public <X> X2.a<X> m(X x10) {
        X2.a<X> b10 = this.f19287b.b(x10.getClass());
        if (b10 != null) {
            return b10;
        }
        throw new NoSourceEncoderAvailableException(x10.getClass());
    }

    public boolean n(Z2.j<?> jVar) {
        if (this.f19289d.b(jVar.d()) != null) {
            return true;
        }
        return false;
    }

    public Registry o(ImageHeaderParser imageHeaderParser) {
        this.f19292g.a(imageHeaderParser);
        return this;
    }

    public Registry p(e.a<?> aVar) {
        this.f19290e.b(aVar);
        return this;
    }

    public <TResource, Transcode> Registry q(Class<TResource> cls, Class<Transcode> cls2, l3.e<TResource, Transcode> eVar) {
        this.f19291f.c(cls, cls2, eVar);
        return this;
    }

    public final Registry r(List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.add("legacy_prepend_all");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        arrayList.add("legacy_append");
        this.f19288c.e(arrayList);
        return this;
    }
}
