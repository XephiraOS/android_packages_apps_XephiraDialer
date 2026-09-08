package com.oplus.anim;

import android.graphics.Rect;
import com.oplus.anim.model.layer.Layer;
import e6.C0984c;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p.C1420f;

/* compiled from: EffectiveAnimationComposition.java */
/* renamed from: com.oplus.anim.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0820a {

    /* renamed from: c, reason: collision with root package name */
    public Map<String, List<Layer>> f25904c;

    /* renamed from: d, reason: collision with root package name */
    public Map<String, I> f25905d;

    /* renamed from: e, reason: collision with root package name */
    public Map<String, C0984c> f25906e;

    /* renamed from: f, reason: collision with root package name */
    public List<e6.g> f25907f;

    /* renamed from: g, reason: collision with root package name */
    public p.j<e6.d> f25908g;

    /* renamed from: h, reason: collision with root package name */
    public C1420f<Layer> f25909h;

    /* renamed from: i, reason: collision with root package name */
    public List<Layer> f25910i;

    /* renamed from: j, reason: collision with root package name */
    public Rect f25911j;

    /* renamed from: k, reason: collision with root package name */
    public float f25912k;

    /* renamed from: l, reason: collision with root package name */
    public float f25913l;

    /* renamed from: m, reason: collision with root package name */
    public float f25914m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f25915n;

    /* renamed from: a, reason: collision with root package name */
    public final O f25902a = new O();

    /* renamed from: b, reason: collision with root package name */
    public final HashSet<String> f25903b = new HashSet<>();

    /* renamed from: o, reason: collision with root package name */
    public int f25916o = 0;

    public void a(String str) {
        l6.e.c(str);
        this.f25903b.add(str);
    }

    public Rect b() {
        return this.f25911j;
    }

    public p.j<e6.d> c() {
        return this.f25908g;
    }

    public float d() {
        return (e() / this.f25914m) * 1000.0f;
    }

    public float e() {
        return this.f25913l - this.f25912k;
    }

    public float f() {
        return this.f25913l;
    }

    public Map<String, C0984c> g() {
        return this.f25906e;
    }

    public float h(float f10) {
        return l6.g.i(this.f25912k, this.f25913l, f10);
    }

    public float i() {
        return this.f25914m;
    }

    public Map<String, I> j() {
        return this.f25905d;
    }

    public List<Layer> k() {
        return this.f25910i;
    }

    public e6.g l(String str) {
        int size = this.f25907f.size();
        for (int i10 = 0; i10 < size; i10++) {
            e6.g gVar = this.f25907f.get(i10);
            if (gVar.a(str)) {
                return gVar;
            }
        }
        return null;
    }

    public int m() {
        return this.f25916o;
    }

    public O n() {
        return this.f25902a;
    }

    public List<Layer> o(String str) {
        return this.f25904c.get(str);
    }

    public float p() {
        return this.f25912k;
    }

    public boolean q() {
        return this.f25915n;
    }

    public void r(int i10) {
        this.f25916o += i10;
    }

    public void s(Rect rect, float f10, float f11, float f12, List<Layer> list, C1420f<Layer> c1420f, Map<String, List<Layer>> map, Map<String, I> map2, p.j<e6.d> jVar, Map<String, C0984c> map3, List<e6.g> list2) {
        this.f25911j = rect;
        this.f25912k = f10;
        this.f25913l = f11;
        this.f25914m = f12;
        this.f25910i = list;
        this.f25909h = c1420f;
        this.f25904c = map;
        this.f25905d = map2;
        this.f25908g = jVar;
        this.f25906e = map3;
        this.f25907f = list2;
    }

    public Layer t(long j10) {
        return this.f25909h.d(j10);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("EffectiveAnimationComposition:\n");
        Iterator<Layer> it = this.f25910i.iterator();
        while (it.hasNext()) {
            sb.append(it.next().y("\t"));
        }
        return sb.toString();
    }

    public void u(boolean z10) {
        this.f25915n = z10;
    }

    public void v(boolean z10) {
        this.f25902a.b(z10);
    }
}
