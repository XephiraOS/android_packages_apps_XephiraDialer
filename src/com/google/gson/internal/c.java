package com.google.gson.internal;

import com.google.gson.r;
import com.google.gson.s;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: Excluder.java */
/* loaded from: classes3.dex */
public final class c implements s, Cloneable {

    /* renamed from: g, reason: collision with root package name */
    public static final c f24788g = new c();

    /* renamed from: d, reason: collision with root package name */
    public boolean f24792d;

    /* renamed from: a, reason: collision with root package name */
    public double f24789a = -1.0d;

    /* renamed from: b, reason: collision with root package name */
    public int f24790b = 136;

    /* renamed from: c, reason: collision with root package name */
    public boolean f24791c = true;

    /* renamed from: e, reason: collision with root package name */
    public List<com.google.gson.a> f24793e = Collections.emptyList();

    /* renamed from: f, reason: collision with root package name */
    public List<com.google.gson.a> f24794f = Collections.emptyList();

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Excluder.java */
    /* loaded from: classes3.dex */
    public class a<T> extends r<T> {

        /* renamed from: a, reason: collision with root package name */
        public r<T> f24795a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f24796b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f24797c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.google.gson.d f24798d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ J4.a f24799e;

        public a(boolean z10, boolean z11, com.google.gson.d dVar, J4.a aVar) {
            this.f24796b = z10;
            this.f24797c = z11;
            this.f24798d = dVar;
            this.f24799e = aVar;
        }

        @Override // com.google.gson.r
        public T b(K4.a aVar) {
            if (this.f24796b) {
                aVar.s0();
                return null;
            }
            return e().b(aVar);
        }

        @Override // com.google.gson.r
        public void d(K4.b bVar, T t10) {
            if (this.f24797c) {
                bVar.I();
            } else {
                e().d(bVar, t10);
            }
        }

        public final r<T> e() {
            r<T> rVar = this.f24795a;
            if (rVar == null) {
                r<T> n10 = this.f24798d.n(c.this, this.f24799e);
                this.f24795a = n10;
                return n10;
            }
            return rVar;
        }
    }

    @Override // com.google.gson.s
    public <T> r<T> a(com.google.gson.d dVar, J4.a<T> aVar) {
        boolean z10;
        boolean z11;
        Class<? super T> rawType = aVar.getRawType();
        boolean d10 = d(rawType);
        if (!d10 && !e(rawType, true)) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (!d10 && !e(rawType, false)) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z10 && !z11) {
            return null;
        }
        return new a(z11, z10, dVar, aVar);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c clone() {
        try {
            return (c) super.clone();
        } catch (CloneNotSupportedException e10) {
            throw new AssertionError(e10);
        }
    }

    public boolean c(Class<?> cls, boolean z10) {
        if (!d(cls) && !e(cls, z10)) {
            return false;
        }
        return true;
    }

    public final boolean d(Class<?> cls) {
        if (this.f24789a != -1.0d && !l((E4.d) cls.getAnnotation(E4.d.class), (E4.e) cls.getAnnotation(E4.e.class))) {
            return true;
        }
        if (!this.f24791c && h(cls)) {
            return true;
        }
        return g(cls);
    }

    public final boolean e(Class<?> cls, boolean z10) {
        List<com.google.gson.a> list;
        if (z10) {
            list = this.f24793e;
        } else {
            list = this.f24794f;
        }
        Iterator<com.google.gson.a> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().b(cls)) {
                return true;
            }
        }
        return false;
    }

    public boolean f(Field field, boolean z10) {
        List<com.google.gson.a> list;
        E4.a aVar;
        if ((this.f24790b & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.f24789a != -1.0d && !l((E4.d) field.getAnnotation(E4.d.class), (E4.e) field.getAnnotation(E4.e.class))) || field.isSynthetic()) {
            return true;
        }
        if (this.f24792d && ((aVar = (E4.a) field.getAnnotation(E4.a.class)) == null || (!z10 ? !aVar.deserialize() : !aVar.serialize()))) {
            return true;
        }
        if ((!this.f24791c && h(field.getType())) || g(field.getType())) {
            return true;
        }
        if (z10) {
            list = this.f24793e;
        } else {
            list = this.f24794f;
        }
        if (!list.isEmpty()) {
            com.google.gson.b bVar = new com.google.gson.b(field);
            Iterator<com.google.gson.a> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().a(bVar)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public final boolean g(Class<?> cls) {
        if (!Enum.class.isAssignableFrom(cls) && !i(cls) && (cls.isAnonymousClass() || cls.isLocalClass())) {
            return true;
        }
        return false;
    }

    public final boolean h(Class<?> cls) {
        if (cls.isMemberClass() && !i(cls)) {
            return true;
        }
        return false;
    }

    public final boolean i(Class<?> cls) {
        if ((cls.getModifiers() & 8) != 0) {
            return true;
        }
        return false;
    }

    public final boolean j(E4.d dVar) {
        if (dVar == null) {
            return true;
        }
        if (this.f24789a >= dVar.value()) {
            return true;
        }
        return false;
    }

    public final boolean k(E4.e eVar) {
        if (eVar == null) {
            return true;
        }
        if (this.f24789a < eVar.value()) {
            return true;
        }
        return false;
    }

    public final boolean l(E4.d dVar, E4.e eVar) {
        if (j(dVar) && k(eVar)) {
            return true;
        }
        return false;
    }
}
