package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.base.f;
import com.google.common.collect.MapMakerInternalMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: MapMaker.java */
/* loaded from: classes3.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public boolean f24576a;

    /* renamed from: b, reason: collision with root package name */
    public int f24577b = -1;

    /* renamed from: c, reason: collision with root package name */
    public int f24578c = -1;

    /* renamed from: d, reason: collision with root package name */
    public MapMakerInternalMap.Strength f24579d;

    /* renamed from: e, reason: collision with root package name */
    public MapMakerInternalMap.Strength f24580e;

    /* renamed from: f, reason: collision with root package name */
    public Equivalence<Object> f24581f;

    public o a(int i10) {
        boolean z10;
        int i11 = this.f24578c;
        boolean z11 = false;
        if (i11 == -1) {
            z10 = true;
        } else {
            z10 = false;
        }
        com.google.common.base.k.w(z10, "concurrency level was already set to %s", i11);
        if (i10 > 0) {
            z11 = true;
        }
        com.google.common.base.k.d(z11);
        this.f24578c = i10;
        return this;
    }

    public int b() {
        int i10 = this.f24578c;
        if (i10 == -1) {
            return 4;
        }
        return i10;
    }

    public int c() {
        int i10 = this.f24577b;
        if (i10 == -1) {
            return 16;
        }
        return i10;
    }

    public Equivalence<Object> d() {
        return (Equivalence) com.google.common.base.f.a(this.f24581f, e().b());
    }

    public MapMakerInternalMap.Strength e() {
        return (MapMakerInternalMap.Strength) com.google.common.base.f.a(this.f24579d, MapMakerInternalMap.Strength.STRONG);
    }

    public MapMakerInternalMap.Strength f() {
        return (MapMakerInternalMap.Strength) com.google.common.base.f.a(this.f24580e, MapMakerInternalMap.Strength.STRONG);
    }

    public o g(int i10) {
        boolean z10;
        int i11 = this.f24577b;
        boolean z11 = false;
        if (i11 == -1) {
            z10 = true;
        } else {
            z10 = false;
        }
        com.google.common.base.k.w(z10, "initial capacity was already set to %s", i11);
        if (i10 >= 0) {
            z11 = true;
        }
        com.google.common.base.k.d(z11);
        this.f24577b = i10;
        return this;
    }

    public o h(Equivalence<Object> equivalence) {
        boolean z10;
        Equivalence<Object> equivalence2 = this.f24581f;
        if (equivalence2 == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        com.google.common.base.k.x(z10, "key equivalence was already set to %s", equivalence2);
        this.f24581f = (Equivalence) com.google.common.base.k.o(equivalence);
        this.f24576a = true;
        return this;
    }

    public <K, V> ConcurrentMap<K, V> i() {
        if (!this.f24576a) {
            return new ConcurrentHashMap(c(), 0.75f, b());
        }
        return MapMakerInternalMap.d(this);
    }

    public o j(MapMakerInternalMap.Strength strength) {
        boolean z10;
        MapMakerInternalMap.Strength strength2 = this.f24579d;
        if (strength2 == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        com.google.common.base.k.x(z10, "Key strength was already set to %s", strength2);
        this.f24579d = (MapMakerInternalMap.Strength) com.google.common.base.k.o(strength);
        if (strength != MapMakerInternalMap.Strength.STRONG) {
            this.f24576a = true;
        }
        return this;
    }

    public o k(MapMakerInternalMap.Strength strength) {
        boolean z10;
        MapMakerInternalMap.Strength strength2 = this.f24580e;
        if (strength2 == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        com.google.common.base.k.x(z10, "Value strength was already set to %s", strength2);
        this.f24580e = (MapMakerInternalMap.Strength) com.google.common.base.k.o(strength);
        if (strength != MapMakerInternalMap.Strength.STRONG) {
            this.f24576a = true;
        }
        return this;
    }

    public o l() {
        return j(MapMakerInternalMap.Strength.WEAK);
    }

    public String toString() {
        f.b c10 = com.google.common.base.f.c(this);
        int i10 = this.f24577b;
        if (i10 != -1) {
            c10.b("initialCapacity", i10);
        }
        int i11 = this.f24578c;
        if (i11 != -1) {
            c10.b("concurrencyLevel", i11);
        }
        MapMakerInternalMap.Strength strength = this.f24579d;
        if (strength != null) {
            c10.d("keyStrength", com.google.common.base.a.b(strength.toString()));
        }
        MapMakerInternalMap.Strength strength2 = this.f24580e;
        if (strength2 != null) {
            c10.d("valueStrength", com.google.common.base.a.b(strength2.toString()));
        }
        if (this.f24581f != null) {
            c10.k("keyEquivalence");
        }
        return c10.toString();
    }
}
