package com.oplus.anim.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import c6.AbstractC0558a;
import c6.q;
import com.oplus.anim.C0820a;
import com.oplus.anim.EffectiveAnimationDrawable;
import com.oplus.anim.N;
import com.oplus.anim.model.layer.Layer;
import com.oplus.anim.r;
import e6.e;
import f6.C1015b;
import h6.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import l6.h;
import m6.C1336b;
import p.C1420f;

/* compiled from: CompositionLayer.java */
/* loaded from: classes3.dex */
public class b extends com.oplus.anim.model.layer.a {

    /* renamed from: D, reason: collision with root package name */
    public AbstractC0558a<Float, Float> f26110D;

    /* renamed from: E, reason: collision with root package name */
    public final List<com.oplus.anim.model.layer.a> f26111E;

    /* renamed from: F, reason: collision with root package name */
    public final RectF f26112F;

    /* renamed from: G, reason: collision with root package name */
    public final RectF f26113G;

    /* renamed from: H, reason: collision with root package name */
    public final Paint f26114H;

    /* renamed from: I, reason: collision with root package name */
    public Boolean f26115I;

    /* renamed from: J, reason: collision with root package name */
    public Boolean f26116J;

    /* renamed from: K, reason: collision with root package name */
    public boolean f26117K;

    /* compiled from: CompositionLayer.java */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f26118a;

        static {
            int[] iArr = new int[Layer.MatteType.values().length];
            f26118a = iArr;
            try {
                iArr[Layer.MatteType.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f26118a[Layer.MatteType.INVERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public b(EffectiveAnimationDrawable effectiveAnimationDrawable, Layer layer, List<Layer> list, C0820a c0820a) {
        super(effectiveAnimationDrawable, layer);
        int i10;
        com.oplus.anim.model.layer.a aVar;
        this.f26111E = new ArrayList();
        this.f26112F = new RectF();
        this.f26113G = new RectF();
        this.f26114H = new Paint();
        this.f26117K = true;
        C1015b u10 = layer.u();
        if (u10 != null) {
            AbstractC0558a<Float, Float> a10 = u10.a();
            this.f26110D = a10;
            j(a10);
            this.f26110D.a(this);
        } else {
            this.f26110D = null;
        }
        C1420f c1420f = new C1420f(c0820a.k().size());
        int size = list.size() - 1;
        com.oplus.anim.model.layer.a aVar2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            Layer layer2 = list.get(size);
            com.oplus.anim.model.layer.a v10 = com.oplus.anim.model.layer.a.v(this, layer2, effectiveAnimationDrawable, c0820a);
            if (v10 != null) {
                c1420f.h(v10.z().d(), v10);
                if (aVar2 != null) {
                    aVar2.J(v10);
                    aVar2 = null;
                } else {
                    this.f26111E.add(0, v10);
                    int i11 = a.f26118a[layer2.h().ordinal()];
                    if (i11 == 1 || i11 == 2) {
                        aVar2 = v10;
                    }
                }
            }
            size--;
        }
        for (i10 = 0; i10 < c1420f.k(); i10++) {
            com.oplus.anim.model.layer.a aVar3 = (com.oplus.anim.model.layer.a) c1420f.d(c1420f.g(i10));
            if (aVar3 != null && (aVar = (com.oplus.anim.model.layer.a) c1420f.d(aVar3.z().j())) != null) {
                aVar3.L(aVar);
            }
        }
    }

    @Override // com.oplus.anim.model.layer.a
    public void I(e eVar, int i10, List<e> list, e eVar2) {
        for (int i11 = 0; i11 < this.f26111E.size(); i11++) {
            this.f26111E.get(i11).g(eVar, i10, list, eVar2);
        }
    }

    @Override // com.oplus.anim.model.layer.a
    public void K(boolean z10) {
        super.K(z10);
        Iterator<com.oplus.anim.model.layer.a> it = this.f26111E.iterator();
        while (it.hasNext()) {
            it.next().K(z10);
        }
    }

    @Override // com.oplus.anim.model.layer.a
    public void M(float f10) {
        super.M(f10);
        if (this.f26110D != null) {
            f10 = ((this.f26110D.h().floatValue() * this.f26098q.b().i()) - this.f26098q.b().p()) / (this.f26097p.L().e() + 0.01f);
        }
        if (this.f26110D == null) {
            f10 -= this.f26098q.r();
        }
        if (this.f26098q.v() != 0.0f && !"__container".equals(this.f26098q.i())) {
            f10 /= this.f26098q.v();
        }
        for (int size = this.f26111E.size() - 1; size >= 0; size--) {
            this.f26111E.get(size).M(f10);
        }
    }

    public boolean P() {
        if (this.f26116J == null) {
            for (int size = this.f26111E.size() - 1; size >= 0; size--) {
                com.oplus.anim.model.layer.a aVar = this.f26111E.get(size);
                if (aVar instanceof d) {
                    if (aVar.A()) {
                        this.f26116J = Boolean.TRUE;
                        return true;
                    }
                } else if ((aVar instanceof b) && ((b) aVar).P()) {
                    this.f26116J = Boolean.TRUE;
                    return true;
                }
            }
            this.f26116J = Boolean.FALSE;
        }
        return this.f26116J.booleanValue();
    }

    public boolean Q() {
        if (this.f26115I == null) {
            if (B()) {
                this.f26115I = Boolean.TRUE;
                return true;
            }
            for (int size = this.f26111E.size() - 1; size >= 0; size--) {
                if (this.f26111E.get(size).B()) {
                    this.f26115I = Boolean.TRUE;
                    return true;
                }
            }
            this.f26115I = Boolean.FALSE;
        }
        return this.f26115I.booleanValue();
    }

    public void R(boolean z10) {
        this.f26117K = z10;
    }

    @Override // com.oplus.anim.model.layer.a, b6.e
    public void e(RectF rectF, Matrix matrix, boolean z10) {
        super.e(rectF, matrix, z10);
        for (int size = this.f26111E.size() - 1; size >= 0; size--) {
            this.f26112F.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.f26111E.get(size).e(this.f26112F, this.f26096o, true);
            rectF.union(this.f26112F);
        }
    }

    @Override // com.oplus.anim.model.layer.a, e6.f
    public <T> void i(T t10, C1336b<T> c1336b) {
        super.i(t10, c1336b);
        if (t10 == r.f26162E) {
            if (c1336b == null) {
                AbstractC0558a<Float, Float> abstractC0558a = this.f26110D;
                if (abstractC0558a != null) {
                    abstractC0558a.n(null);
                    return;
                }
                return;
            }
            q qVar = new q(c1336b);
            this.f26110D = qVar;
            qVar.a(this);
            j(this.f26110D);
        }
    }

    @Override // com.oplus.anim.model.layer.a
    public void u(Canvas canvas, Matrix matrix, int i10) {
        boolean z10;
        N.a("CompositionLayer#draw");
        this.f26113G.set(0.0f, 0.0f, this.f26098q.l(), this.f26098q.k());
        matrix.mapRect(this.f26113G);
        if (this.f26097p.i0() && this.f26111E.size() > 1 && i10 != 255) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            this.f26114H.setAlpha(i10);
            h.n(canvas, this.f26113G, this.f26114H);
        } else {
            canvas.save();
        }
        if (z10) {
            i10 = 255;
        }
        for (int size = this.f26111E.size() - 1; size >= 0; size--) {
            if ((!this.f26117K && "__container".equals(this.f26098q.i())) || this.f26113G.isEmpty() || canvas.clipRect(this.f26113G)) {
                this.f26111E.get(size).h(canvas, matrix, i10);
            }
        }
        canvas.restore();
        N.b("CompositionLayer#draw");
    }
}
