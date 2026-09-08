package com.oplus.anim.model.layer;

import com.oplus.anim.C0820a;
import com.oplus.anim.model.content.Mask;
import f6.C1015b;
import f6.j;
import f6.k;
import f6.l;
import g6.C1048a;
import g6.c;
import j6.C1182j;
import java.util.List;
import java.util.Locale;
import m6.C1337c;

/* loaded from: classes3.dex */
public class Layer {

    /* renamed from: a, reason: collision with root package name */
    public final List<c> f26040a;

    /* renamed from: b, reason: collision with root package name */
    public final C0820a f26041b;

    /* renamed from: c, reason: collision with root package name */
    public final String f26042c;

    /* renamed from: d, reason: collision with root package name */
    public final long f26043d;

    /* renamed from: e, reason: collision with root package name */
    public final LayerType f26044e;

    /* renamed from: f, reason: collision with root package name */
    public final long f26045f;

    /* renamed from: g, reason: collision with root package name */
    public final String f26046g;

    /* renamed from: h, reason: collision with root package name */
    public final List<Mask> f26047h;

    /* renamed from: i, reason: collision with root package name */
    public final l f26048i;

    /* renamed from: j, reason: collision with root package name */
    public final int f26049j;

    /* renamed from: k, reason: collision with root package name */
    public final int f26050k;

    /* renamed from: l, reason: collision with root package name */
    public final int f26051l;

    /* renamed from: m, reason: collision with root package name */
    public final float f26052m;

    /* renamed from: n, reason: collision with root package name */
    public final float f26053n;

    /* renamed from: o, reason: collision with root package name */
    public final float f26054o;

    /* renamed from: p, reason: collision with root package name */
    public final float f26055p;

    /* renamed from: q, reason: collision with root package name */
    public final j f26056q;

    /* renamed from: r, reason: collision with root package name */
    public final k f26057r;

    /* renamed from: s, reason: collision with root package name */
    public final C1015b f26058s;

    /* renamed from: t, reason: collision with root package name */
    public final List<C1337c<Float>> f26059t;

    /* renamed from: u, reason: collision with root package name */
    public final MatteType f26060u;

    /* renamed from: v, reason: collision with root package name */
    public final boolean f26061v;

    /* renamed from: w, reason: collision with root package name */
    public final C1048a f26062w;

    /* renamed from: x, reason: collision with root package name */
    public final C1182j f26063x;

    /* loaded from: classes3.dex */
    public enum LayerType {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    /* loaded from: classes3.dex */
    public enum MatteType {
        NONE,
        ADD,
        INVERT,
        LUMA,
        LUMA_INVERTED,
        UNKNOWN
    }

    public Layer(List<c> list, C0820a c0820a, String str, long j10, LayerType layerType, long j11, String str2, List<Mask> list2, l lVar, int i10, int i11, int i12, float f10, float f11, float f12, float f13, j jVar, k kVar, List<C1337c<Float>> list3, MatteType matteType, C1015b c1015b, boolean z10, C1048a c1048a, C1182j c1182j) {
        this.f26040a = list;
        this.f26041b = c0820a;
        this.f26042c = str;
        this.f26043d = j10;
        this.f26044e = layerType;
        this.f26045f = j11;
        this.f26046g = str2;
        this.f26047h = list2;
        this.f26048i = lVar;
        this.f26049j = i10;
        this.f26050k = i11;
        this.f26051l = i12;
        this.f26052m = f10;
        this.f26053n = f11;
        this.f26054o = f12;
        this.f26055p = f13;
        this.f26056q = jVar;
        this.f26057r = kVar;
        this.f26059t = list3;
        this.f26060u = matteType;
        this.f26058s = c1015b;
        this.f26061v = z10;
        this.f26062w = c1048a;
        this.f26063x = c1182j;
    }

    public C1048a a() {
        return this.f26062w;
    }

    public C0820a b() {
        return this.f26041b;
    }

    public C1182j c() {
        return this.f26063x;
    }

    public long d() {
        return this.f26043d;
    }

    public List<C1337c<Float>> e() {
        return this.f26059t;
    }

    public LayerType f() {
        return this.f26044e;
    }

    public List<Mask> g() {
        return this.f26047h;
    }

    public MatteType h() {
        return this.f26060u;
    }

    public String i() {
        return this.f26042c;
    }

    public long j() {
        return this.f26045f;
    }

    public float k() {
        return this.f26055p;
    }

    public float l() {
        return this.f26054o;
    }

    public String m() {
        return this.f26046g;
    }

    public List<c> n() {
        return this.f26040a;
    }

    public int o() {
        return this.f26051l;
    }

    public int p() {
        return this.f26050k;
    }

    public int q() {
        return this.f26049j;
    }

    public float r() {
        return this.f26053n / this.f26041b.e();
    }

    public j s() {
        return this.f26056q;
    }

    public k t() {
        return this.f26057r;
    }

    public String toString() {
        return y("");
    }

    public C1015b u() {
        return this.f26058s;
    }

    public float v() {
        return this.f26052m;
    }

    public l w() {
        return this.f26048i;
    }

    public boolean x() {
        return this.f26061v;
    }

    public String y(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(i());
        sb.append("\n");
        Layer t10 = this.f26041b.t(j());
        if (t10 != null) {
            sb.append("\t\tParents: ");
            sb.append(t10.i());
            Layer t11 = this.f26041b.t(t10.j());
            while (t11 != null) {
                sb.append("->");
                sb.append(t11.i());
                t11 = this.f26041b.t(t11.j());
            }
            sb.append(str);
            sb.append("\n");
        }
        if (!g().isEmpty()) {
            sb.append(str);
            sb.append("\tMasks: ");
            sb.append(g().size());
            sb.append("\n");
        }
        if (q() != 0 && p() != 0) {
            sb.append(str);
            sb.append("\tBackground: ");
            sb.append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(q()), Integer.valueOf(p()), Integer.valueOf(o())));
        }
        if (!this.f26040a.isEmpty()) {
            sb.append(str);
            sb.append("\tShapes:\n");
            for (c cVar : this.f26040a) {
                sb.append(str);
                sb.append("\t\t");
                sb.append(cVar);
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
