package com.oplus.anim.model.layer;

import a6.C0423a;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import b6.e;
import c6.AbstractC0558a;
import c6.C0561d;
import c6.h;
import c6.p;
import com.oplus.anim.C0820a;
import com.oplus.anim.EffectiveAnimationDrawable;
import com.oplus.anim.N;
import com.oplus.anim.model.content.Mask;
import com.oplus.anim.model.layer.Layer;
import e6.f;
import g6.C1048a;
import g6.i;
import h6.C1083b;
import h6.c;
import h6.d;
import j6.C1182j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import m6.C1336b;

/* compiled from: BaseLayer.java */
/* loaded from: classes3.dex */
public abstract class a implements e, AbstractC0558a.b, f {

    /* renamed from: A, reason: collision with root package name */
    public Paint f26079A;

    /* renamed from: B, reason: collision with root package name */
    public float f26080B;

    /* renamed from: C, reason: collision with root package name */
    public BlurMaskFilter f26081C;

    /* renamed from: a, reason: collision with root package name */
    public final Path f26082a = new Path();

    /* renamed from: b, reason: collision with root package name */
    public final Matrix f26083b = new Matrix();

    /* renamed from: c, reason: collision with root package name */
    public final Matrix f26084c = new Matrix();

    /* renamed from: d, reason: collision with root package name */
    public final Paint f26085d = new C0423a(1);

    /* renamed from: e, reason: collision with root package name */
    public final Paint f26086e;

    /* renamed from: f, reason: collision with root package name */
    public final Paint f26087f;

    /* renamed from: g, reason: collision with root package name */
    public final Paint f26088g;

    /* renamed from: h, reason: collision with root package name */
    public final Paint f26089h;

    /* renamed from: i, reason: collision with root package name */
    public final RectF f26090i;

    /* renamed from: j, reason: collision with root package name */
    public final RectF f26091j;

    /* renamed from: k, reason: collision with root package name */
    public final RectF f26092k;

    /* renamed from: l, reason: collision with root package name */
    public final RectF f26093l;

    /* renamed from: m, reason: collision with root package name */
    public final RectF f26094m;

    /* renamed from: n, reason: collision with root package name */
    public final String f26095n;

    /* renamed from: o, reason: collision with root package name */
    public final Matrix f26096o;

    /* renamed from: p, reason: collision with root package name */
    public final EffectiveAnimationDrawable f26097p;

    /* renamed from: q, reason: collision with root package name */
    public final Layer f26098q;

    /* renamed from: r, reason: collision with root package name */
    public h f26099r;

    /* renamed from: s, reason: collision with root package name */
    public C0561d f26100s;

    /* renamed from: t, reason: collision with root package name */
    public a f26101t;

    /* renamed from: u, reason: collision with root package name */
    public a f26102u;

    /* renamed from: v, reason: collision with root package name */
    public List<a> f26103v;

    /* renamed from: w, reason: collision with root package name */
    public final List<AbstractC0558a<?, ?>> f26104w;

    /* renamed from: x, reason: collision with root package name */
    public final p f26105x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f26106y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f26107z;

    /* compiled from: BaseLayer.java */
    /* renamed from: com.oplus.anim.model.layer.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C0235a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f26108a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f26109b;

        static {
            int[] iArr = new int[Mask.MaskMode.values().length];
            f26109b = iArr;
            try {
                iArr[Mask.MaskMode.MASK_MODE_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f26109b[Mask.MaskMode.MASK_MODE_SUBTRACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f26109b[Mask.MaskMode.MASK_MODE_INTERSECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f26109b[Mask.MaskMode.MASK_MODE_ADD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[Layer.LayerType.values().length];
            f26108a = iArr2;
            try {
                iArr2[Layer.LayerType.SHAPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f26108a[Layer.LayerType.PRE_COMP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f26108a[Layer.LayerType.SOLID.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f26108a[Layer.LayerType.IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f26108a[Layer.LayerType.NULL.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f26108a[Layer.LayerType.TEXT.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f26108a[Layer.LayerType.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public a(EffectiveAnimationDrawable effectiveAnimationDrawable, Layer layer) {
        PorterDuff.Mode mode = PorterDuff.Mode.DST_IN;
        this.f26086e = new C0423a(1, mode);
        PorterDuff.Mode mode2 = PorterDuff.Mode.DST_OUT;
        this.f26087f = new C0423a(1, mode2);
        C0423a c0423a = new C0423a(1);
        this.f26088g = c0423a;
        this.f26089h = new C0423a(PorterDuff.Mode.CLEAR);
        this.f26090i = new RectF();
        this.f26091j = new RectF();
        this.f26092k = new RectF();
        this.f26093l = new RectF();
        this.f26094m = new RectF();
        this.f26096o = new Matrix();
        this.f26104w = new ArrayList();
        this.f26106y = true;
        this.f26080B = 0.0f;
        this.f26097p = effectiveAnimationDrawable;
        this.f26098q = layer;
        this.f26095n = layer.i() + "#draw";
        if (layer.h() == Layer.MatteType.INVERT) {
            c0423a.setXfermode(new PorterDuffXfermode(mode2));
        } else {
            c0423a.setXfermode(new PorterDuffXfermode(mode));
        }
        p b10 = layer.w().b();
        this.f26105x = b10;
        b10.b(this);
        if (layer.g() != null && !layer.g().isEmpty()) {
            h hVar = new h(layer.g());
            this.f26099r = hVar;
            Iterator<AbstractC0558a<i, Path>> it = hVar.a().iterator();
            while (it.hasNext()) {
                it.next().a(this);
            }
            for (AbstractC0558a<Integer, Integer> abstractC0558a : this.f26099r.c()) {
                j(abstractC0558a);
                abstractC0558a.a(this);
            }
        }
        O();
    }

    public static a v(b bVar, Layer layer, EffectiveAnimationDrawable effectiveAnimationDrawable, C0820a c0820a) {
        switch (C0235a.f26108a[layer.f().ordinal()]) {
            case 1:
                return new d(effectiveAnimationDrawable, layer, bVar, c0820a);
            case 2:
                return new b(effectiveAnimationDrawable, layer, c0820a.o(layer.m()), c0820a);
            case 3:
                return new h6.e(effectiveAnimationDrawable, layer);
            case 4:
                return new C1083b(effectiveAnimationDrawable, layer);
            case 5:
                return new c(effectiveAnimationDrawable, layer);
            case 6:
                return new h6.f(effectiveAnimationDrawable, layer);
            default:
                l6.e.c("Unknown layer type " + layer.f());
                return null;
        }
    }

    public boolean A() {
        h hVar = this.f26099r;
        if (hVar != null && !hVar.a().isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean B() {
        if (this.f26101t != null) {
            return true;
        }
        return false;
    }

    public final void C(RectF rectF, Matrix matrix) {
        this.f26092k.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (!A()) {
            return;
        }
        int size = this.f26099r.b().size();
        for (int i10 = 0; i10 < size; i10++) {
            Mask mask = this.f26099r.b().get(i10);
            Path h10 = this.f26099r.a().get(i10).h();
            if (h10 != null) {
                this.f26082a.set(h10);
                this.f26082a.transform(matrix);
                int i11 = C0235a.f26109b[mask.a().ordinal()];
                if (i11 != 1 && i11 != 2) {
                    if ((i11 == 3 || i11 == 4) && mask.d()) {
                        return;
                    }
                    this.f26082a.computeBounds(this.f26094m, false);
                    if (i10 == 0) {
                        this.f26092k.set(this.f26094m);
                    } else {
                        RectF rectF2 = this.f26092k;
                        rectF2.set(Math.min(rectF2.left, this.f26094m.left), Math.min(this.f26092k.top, this.f26094m.top), Math.max(this.f26092k.right, this.f26094m.right), Math.max(this.f26092k.bottom, this.f26094m.bottom));
                    }
                } else {
                    return;
                }
            }
        }
        if (!rectF.intersect(this.f26092k)) {
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    public final void D(RectF rectF, Matrix matrix) {
        if (!B() || this.f26098q.h() == Layer.MatteType.INVERT) {
            return;
        }
        this.f26093l.set(0.0f, 0.0f, 0.0f, 0.0f);
        this.f26101t.e(this.f26093l, matrix, true);
        if (!rectF.intersect(this.f26093l)) {
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    public final void E() {
        this.f26097p.invalidateSelf();
    }

    public final /* synthetic */ void F() {
        boolean z10;
        if (this.f26100s.p() == 1.0f) {
            z10 = true;
        } else {
            z10 = false;
        }
        N(z10);
    }

    public final void G(float f10) {
        this.f26097p.L().n().a(this.f26098q.i(), f10);
    }

    public void H(AbstractC0558a<?, ?> abstractC0558a) {
        this.f26104w.remove(abstractC0558a);
    }

    public void J(a aVar) {
        this.f26101t = aVar;
    }

    public void K(boolean z10) {
        if (z10 && this.f26079A == null) {
            this.f26079A = new C0423a();
        }
        this.f26107z = z10;
    }

    public void L(a aVar) {
        this.f26102u = aVar;
    }

    public void M(float f10) {
        this.f26105x.j(f10);
        if (this.f26099r != null) {
            for (int i10 = 0; i10 < this.f26099r.a().size(); i10++) {
                this.f26099r.a().get(i10).m(f10);
            }
        }
        C0561d c0561d = this.f26100s;
        if (c0561d != null) {
            c0561d.m(f10);
        }
        a aVar = this.f26101t;
        if (aVar != null) {
            aVar.M(f10);
        }
        for (int i11 = 0; i11 < this.f26104w.size(); i11++) {
            this.f26104w.get(i11).m(f10);
        }
    }

    public final void N(boolean z10) {
        if (z10 != this.f26106y) {
            this.f26106y = z10;
            E();
        }
    }

    public final void O() {
        boolean z10 = true;
        if (!this.f26098q.e().isEmpty()) {
            C0561d c0561d = new C0561d(this.f26098q.e());
            this.f26100s = c0561d;
            c0561d.l();
            this.f26100s.a(new AbstractC0558a.b() { // from class: h6.a
                @Override // c6.AbstractC0558a.b
                public final void a() {
                    com.oplus.anim.model.layer.a.this.F();
                }
            });
            if (this.f26100s.h().floatValue() != 1.0f) {
                z10 = false;
            }
            N(z10);
            j(this.f26100s);
            return;
        }
        N(true);
    }

    @Override // c6.AbstractC0558a.b
    public void a() {
        E();
    }

    @Override // b6.e
    public void e(RectF rectF, Matrix matrix, boolean z10) {
        this.f26090i.set(0.0f, 0.0f, 0.0f, 0.0f);
        s();
        this.f26096o.set(matrix);
        if (z10) {
            List<a> list = this.f26103v;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f26096o.preConcat(this.f26103v.get(size).f26105x.f());
                }
            } else {
                a aVar = this.f26102u;
                if (aVar != null) {
                    this.f26096o.preConcat(aVar.f26105x.f());
                }
            }
        }
        this.f26096o.preConcat(this.f26105x.f());
    }

    @Override // e6.f
    public void g(e6.e eVar, int i10, List<e6.e> list, e6.e eVar2) {
        a aVar = this.f26101t;
        if (aVar != null) {
            e6.e a10 = eVar2.a(aVar.getName());
            if (eVar.c(this.f26101t.getName(), i10)) {
                list.add(a10.i(this.f26101t));
            }
            if (eVar.h(getName(), i10)) {
                this.f26101t.I(eVar, eVar.e(this.f26101t.getName(), i10) + i10, list, a10);
            }
        }
        if (!eVar.g(getName(), i10)) {
            return;
        }
        if (!"__container".equals(getName())) {
            eVar2 = eVar2.a(getName());
            if (eVar.c(getName(), i10)) {
                list.add(eVar2.i(this));
            }
        }
        if (eVar.h(getName(), i10)) {
            I(eVar, i10 + eVar.e(getName(), i10), list, eVar2);
        }
    }

    @Override // b6.c
    public String getName() {
        return this.f26098q.i();
    }

    @Override // b6.e
    public void h(Canvas canvas, Matrix matrix, int i10) {
        int i11;
        Paint paint;
        Integer h10;
        N.a(this.f26095n);
        if (this.f26106y && !this.f26098q.x()) {
            s();
            N.a("Layer#parentMatrix");
            this.f26083b.reset();
            this.f26083b.set(matrix);
            for (int size = this.f26103v.size() - 1; size >= 0; size--) {
                this.f26083b.preConcat(this.f26103v.get(size).f26105x.f());
            }
            N.b("Layer#parentMatrix");
            AbstractC0558a<?, Integer> h11 = this.f26105x.h();
            if (h11 != null && (h10 = h11.h()) != null) {
                i11 = h10.intValue();
            } else {
                i11 = 100;
            }
            int i12 = (int) ((((i10 / 255.0f) * i11) / 100.0f) * 255.0f);
            if (!B() && !A()) {
                this.f26083b.preConcat(this.f26105x.f());
                N.a("Layer#drawLayer");
                u(canvas, this.f26083b, i12);
                N.b("Layer#drawLayer");
                G(N.b(this.f26095n));
                return;
            }
            N.a("Layer#computeBounds");
            e(this.f26090i, this.f26083b, false);
            D(this.f26090i, matrix);
            this.f26083b.preConcat(this.f26105x.f());
            C(this.f26090i, this.f26083b);
            this.f26091j.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
            canvas.getMatrix(this.f26084c);
            if (!this.f26084c.isIdentity()) {
                Matrix matrix2 = this.f26084c;
                matrix2.invert(matrix2);
                this.f26084c.mapRect(this.f26091j);
            }
            if (!this.f26090i.intersect(this.f26091j)) {
                this.f26090i.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
            N.b("Layer#computeBounds");
            if (this.f26090i.width() >= 1.0f && this.f26090i.height() >= 1.0f) {
                N.a("Layer#saveLayer");
                this.f26085d.setAlpha(255);
                l6.h.n(canvas, this.f26090i, this.f26085d);
                N.b("Layer#saveLayer");
                t(canvas);
                N.a("Layer#drawLayer");
                u(canvas, this.f26083b, i12);
                N.b("Layer#drawLayer");
                if (A()) {
                    p(canvas, this.f26083b);
                }
                if (B()) {
                    N.a("Layer#drawMatte");
                    N.a("Layer#saveLayer");
                    l6.h.o(canvas, this.f26090i, this.f26088g, 19);
                    N.b("Layer#saveLayer");
                    t(canvas);
                    this.f26101t.h(canvas, matrix, i12);
                    N.a("Layer#restoreLayer");
                    canvas.restore();
                    N.b("Layer#restoreLayer");
                    N.b("Layer#drawMatte");
                }
                N.a("Layer#restoreLayer");
                canvas.restore();
                N.b("Layer#restoreLayer");
            }
            if (this.f26107z && (paint = this.f26079A) != null) {
                paint.setStyle(Paint.Style.STROKE);
                this.f26079A.setColor(-251901);
                this.f26079A.setStrokeWidth(4.0f);
                canvas.drawRect(this.f26090i, this.f26079A);
                this.f26079A.setStyle(Paint.Style.FILL);
                this.f26079A.setColor(1357638635);
                canvas.drawRect(this.f26090i, this.f26079A);
            }
            G(N.b(this.f26095n));
            return;
        }
        N.b(this.f26095n);
    }

    @Override // e6.f
    public <T> void i(T t10, C1336b<T> c1336b) {
        this.f26105x.c(t10, c1336b);
    }

    public void j(AbstractC0558a<?, ?> abstractC0558a) {
        if (abstractC0558a == null) {
            return;
        }
        this.f26104w.add(abstractC0558a);
    }

    public final void k(Canvas canvas, Matrix matrix, AbstractC0558a<i, Path> abstractC0558a, AbstractC0558a<Integer, Integer> abstractC0558a2) {
        this.f26082a.set(abstractC0558a.h());
        this.f26082a.transform(matrix);
        this.f26085d.setAlpha((int) (abstractC0558a2.h().intValue() * 2.55f));
        canvas.drawPath(this.f26082a, this.f26085d);
    }

    public final void l(Canvas canvas, Matrix matrix, AbstractC0558a<i, Path> abstractC0558a, AbstractC0558a<Integer, Integer> abstractC0558a2) {
        l6.h.n(canvas, this.f26090i, this.f26086e);
        this.f26082a.set(abstractC0558a.h());
        this.f26082a.transform(matrix);
        this.f26085d.setAlpha((int) (abstractC0558a2.h().intValue() * 2.55f));
        canvas.drawPath(this.f26082a, this.f26085d);
        canvas.restore();
    }

    public final void m(Canvas canvas, Matrix matrix, AbstractC0558a<i, Path> abstractC0558a, AbstractC0558a<Integer, Integer> abstractC0558a2) {
        l6.h.n(canvas, this.f26090i, this.f26085d);
        canvas.drawRect(this.f26090i, this.f26085d);
        this.f26082a.set(abstractC0558a.h());
        this.f26082a.transform(matrix);
        this.f26085d.setAlpha((int) (abstractC0558a2.h().intValue() * 2.55f));
        canvas.drawPath(this.f26082a, this.f26087f);
        canvas.restore();
    }

    public final void n(Canvas canvas, Matrix matrix, AbstractC0558a<i, Path> abstractC0558a, AbstractC0558a<Integer, Integer> abstractC0558a2) {
        l6.h.n(canvas, this.f26090i, this.f26086e);
        canvas.drawRect(this.f26090i, this.f26085d);
        this.f26087f.setAlpha((int) (abstractC0558a2.h().intValue() * 2.55f));
        this.f26082a.set(abstractC0558a.h());
        this.f26082a.transform(matrix);
        canvas.drawPath(this.f26082a, this.f26087f);
        canvas.restore();
    }

    public final void o(Canvas canvas, Matrix matrix, AbstractC0558a<i, Path> abstractC0558a, AbstractC0558a<Integer, Integer> abstractC0558a2) {
        l6.h.n(canvas, this.f26090i, this.f26087f);
        canvas.drawRect(this.f26090i, this.f26085d);
        this.f26087f.setAlpha((int) (abstractC0558a2.h().intValue() * 2.55f));
        this.f26082a.set(abstractC0558a.h());
        this.f26082a.transform(matrix);
        canvas.drawPath(this.f26082a, this.f26087f);
        canvas.restore();
    }

    public final void p(Canvas canvas, Matrix matrix) {
        N.a("Layer#saveLayer");
        l6.h.o(canvas, this.f26090i, this.f26086e, 19);
        N.b("Layer#saveLayer");
        for (int i10 = 0; i10 < this.f26099r.b().size(); i10++) {
            Mask mask = this.f26099r.b().get(i10);
            AbstractC0558a<i, Path> abstractC0558a = this.f26099r.a().get(i10);
            AbstractC0558a<Integer, Integer> abstractC0558a2 = this.f26099r.c().get(i10);
            int i11 = C0235a.f26109b[mask.a().ordinal()];
            if (i11 != 1) {
                if (i11 != 2) {
                    if (i11 != 3) {
                        if (i11 == 4) {
                            if (mask.d()) {
                                m(canvas, matrix, abstractC0558a, abstractC0558a2);
                            } else {
                                k(canvas, matrix, abstractC0558a, abstractC0558a2);
                            }
                        }
                    } else if (mask.d()) {
                        n(canvas, matrix, abstractC0558a, abstractC0558a2);
                    } else {
                        l(canvas, matrix, abstractC0558a, abstractC0558a2);
                    }
                } else {
                    if (i10 == 0) {
                        this.f26085d.setColor(-16777216);
                        this.f26085d.setAlpha(255);
                        canvas.drawRect(this.f26090i, this.f26085d);
                    }
                    if (mask.d()) {
                        o(canvas, matrix, abstractC0558a, abstractC0558a2);
                    } else {
                        q(canvas, matrix, abstractC0558a);
                    }
                }
            } else if (r()) {
                this.f26085d.setAlpha(255);
                canvas.drawRect(this.f26090i, this.f26085d);
            }
        }
        N.a("Layer#restoreLayer");
        canvas.restore();
        N.b("Layer#restoreLayer");
    }

    public final void q(Canvas canvas, Matrix matrix, AbstractC0558a<i, Path> abstractC0558a) {
        this.f26082a.set(abstractC0558a.h());
        this.f26082a.transform(matrix);
        canvas.drawPath(this.f26082a, this.f26087f);
    }

    public final boolean r() {
        if (this.f26099r.a().isEmpty()) {
            return false;
        }
        for (int i10 = 0; i10 < this.f26099r.b().size(); i10++) {
            if (this.f26099r.b().get(i10).a() != Mask.MaskMode.MASK_MODE_NONE) {
                return false;
            }
        }
        return true;
    }

    public final void s() {
        if (this.f26103v != null) {
            return;
        }
        if (this.f26102u == null) {
            this.f26103v = Collections.emptyList();
            return;
        }
        this.f26103v = new ArrayList();
        for (a aVar = this.f26102u; aVar != null; aVar = aVar.f26102u) {
            this.f26103v.add(aVar);
        }
    }

    public final void t(Canvas canvas) {
        N.a("Layer#clearLayer");
        RectF rectF = this.f26090i;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.f26089h);
        N.b("Layer#clearLayer");
    }

    public abstract void u(Canvas canvas, Matrix matrix, int i10);

    public C1048a w() {
        return this.f26098q.a();
    }

    public BlurMaskFilter x(float f10) {
        if (this.f26080B == f10) {
            return this.f26081C;
        }
        BlurMaskFilter blurMaskFilter = new BlurMaskFilter(f10 / 2.0f, BlurMaskFilter.Blur.NORMAL);
        this.f26081C = blurMaskFilter;
        this.f26080B = f10;
        return blurMaskFilter;
    }

    public C1182j y() {
        return this.f26098q.c();
    }

    public Layer z() {
        return this.f26098q;
    }

    @Override // b6.c
    public void b(List<b6.c> list, List<b6.c> list2) {
    }

    public void I(e6.e eVar, int i10, List<e6.e> list, e6.e eVar2) {
    }
}
