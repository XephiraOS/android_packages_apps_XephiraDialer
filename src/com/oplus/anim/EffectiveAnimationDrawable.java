package com.oplus.anim;

import a6.C0423a;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import d6.C0955a;
import e6.C0984c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import m6.C1336b;

/* loaded from: classes3.dex */
public class EffectiveAnimationDrawable extends Drawable implements Drawable.Callback, Animatable {

    /* renamed from: A, reason: collision with root package name */
    public RenderMode f25746A;

    /* renamed from: B, reason: collision with root package name */
    public boolean f25747B;

    /* renamed from: C, reason: collision with root package name */
    public final Matrix f25748C;

    /* renamed from: D, reason: collision with root package name */
    public Bitmap f25749D;

    /* renamed from: E, reason: collision with root package name */
    public Canvas f25750E;

    /* renamed from: F, reason: collision with root package name */
    public Rect f25751F;

    /* renamed from: G, reason: collision with root package name */
    public RectF f25752G;

    /* renamed from: H, reason: collision with root package name */
    public Paint f25753H;

    /* renamed from: I, reason: collision with root package name */
    public Rect f25754I;

    /* renamed from: J, reason: collision with root package name */
    public Rect f25755J;

    /* renamed from: K, reason: collision with root package name */
    public RectF f25756K;

    /* renamed from: L, reason: collision with root package name */
    public RectF f25757L;

    /* renamed from: M, reason: collision with root package name */
    public Matrix f25758M;

    /* renamed from: N, reason: collision with root package name */
    public Matrix f25759N;

    /* renamed from: O, reason: collision with root package name */
    public boolean f25760O;

    /* renamed from: a, reason: collision with root package name */
    public C0820a f25761a;

    /* renamed from: b, reason: collision with root package name */
    public final l6.b f25762b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f25763c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f25764d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f25765e;

    /* renamed from: f, reason: collision with root package name */
    public OnVisibleAction f25766f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList<b> f25767g;

    /* renamed from: h, reason: collision with root package name */
    public final ValueAnimator.AnimatorUpdateListener f25768h;

    /* renamed from: i, reason: collision with root package name */
    public d6.b f25769i;

    /* renamed from: j, reason: collision with root package name */
    public String f25770j;

    /* renamed from: k, reason: collision with root package name */
    public C0955a f25771k;

    /* renamed from: l, reason: collision with root package name */
    public Map<String, Typeface> f25772l;

    /* renamed from: m, reason: collision with root package name */
    public String f25773m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f25774n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f25775o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f25776p;

    /* renamed from: q, reason: collision with root package name */
    public com.oplus.anim.model.layer.b f25777q;

    /* renamed from: r, reason: collision with root package name */
    public int f25778r;

    /* renamed from: x, reason: collision with root package name */
    public boolean f25779x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f25780y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f25781z;

    /* loaded from: classes3.dex */
    public enum OnVisibleAction {
        NONE,
        PLAY,
        RESUME
    }

    /* loaded from: classes3.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (EffectiveAnimationDrawable.this.f25777q != null) {
                EffectiveAnimationDrawable.this.f25777q.M(EffectiveAnimationDrawable.this.f25762b.j());
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(C0820a c0820a);
    }

    public EffectiveAnimationDrawable() {
        l6.b bVar = new l6.b();
        this.f25762b = bVar;
        this.f25763c = true;
        this.f25764d = false;
        this.f25765e = false;
        this.f25766f = OnVisibleAction.NONE;
        this.f25767g = new ArrayList<>();
        a aVar = new a();
        this.f25768h = aVar;
        this.f25775o = false;
        this.f25776p = true;
        this.f25778r = 255;
        this.f25746A = RenderMode.AUTOMATIC;
        this.f25747B = false;
        this.f25748C = new Matrix();
        this.f25760O = false;
        bVar.addUpdateListener(aVar);
    }

    public final void A(Rect rect, RectF rectF) {
        rectF.set(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void A0() {
        float T10;
        if (this.f25777q == null) {
            this.f25767g.add(new b() { // from class: com.oplus.anim.m
                @Override // com.oplus.anim.EffectiveAnimationDrawable.b
                public final void a(C0820a c0820a) {
                    EffectiveAnimationDrawable.this.l0(c0820a);
                }
            });
            return;
        }
        z();
        if (v() || Y() == 0) {
            if (isVisible()) {
                this.f25762b.t();
                this.f25766f = OnVisibleAction.NONE;
            } else {
                this.f25766f = OnVisibleAction.PLAY;
            }
        }
        if (!v()) {
            if (a0() < 0.0f) {
                T10 = U();
            } else {
                T10 = T();
            }
            R0((int) T10);
            this.f25762b.i();
            if (!isVisible()) {
                this.f25766f = OnVisibleAction.NONE;
            }
        }
    }

    public final void B(RectF rectF, Rect rect) {
        rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
    }

    public void B0() {
        this.f25762b.removeAllListeners();
    }

    public void C0() {
        this.f25762b.removeAllUpdateListeners();
        this.f25762b.addUpdateListener(this.f25768h);
    }

    public final void D(Canvas canvas) {
        com.oplus.anim.model.layer.b bVar = this.f25777q;
        C0820a c0820a = this.f25761a;
        if (bVar != null && c0820a != null) {
            this.f25748C.reset();
            if (!getBounds().isEmpty()) {
                this.f25748C.preScale(r2.width() / c0820a.b().width(), r2.height() / c0820a.b().height());
                this.f25748C.preTranslate(r2.left, r2.top);
            }
            bVar.h(canvas, this.f25748C, this.f25778r);
        }
    }

    public void D0(Animator.AnimatorListener animatorListener) {
        this.f25762b.removeListener(animatorListener);
    }

    public void E(boolean z10) {
        if (this.f25774n == z10) {
            return;
        }
        this.f25774n = z10;
        if (this.f25761a != null) {
            w();
        }
    }

    public void E0(Animator.AnimatorPauseListener animatorPauseListener) {
        this.f25762b.removePauseListener(animatorPauseListener);
    }

    public boolean F() {
        return this.f25774n;
    }

    public void F0(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f25762b.removeUpdateListener(animatorUpdateListener);
    }

    public void G() {
        this.f25767g.clear();
        this.f25762b.i();
        if (!isVisible()) {
            this.f25766f = OnVisibleAction.NONE;
        }
    }

    public final void G0(Canvas canvas, com.oplus.anim.model.layer.b bVar) {
        if (this.f25761a != null && bVar != null) {
            I();
            canvas.getMatrix(this.f25758M);
            canvas.getClipBounds(this.f25751F);
            A(this.f25751F, this.f25752G);
            this.f25758M.mapRect(this.f25752G);
            B(this.f25752G, this.f25751F);
            if (this.f25776p) {
                this.f25757L.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
            } else {
                bVar.e(this.f25757L, null, false);
            }
            this.f25758M.mapRect(this.f25757L);
            Rect bounds = getBounds();
            float width = bounds.width() / getIntrinsicWidth();
            float height = bounds.height() / getIntrinsicHeight();
            K0(this.f25757L, width, height);
            if (!f0()) {
                RectF rectF = this.f25757L;
                Rect rect = this.f25751F;
                rectF.intersect(rect.left, rect.top, rect.right, rect.bottom);
            }
            int ceil = (int) Math.ceil(this.f25757L.width());
            int ceil2 = (int) Math.ceil(this.f25757L.height());
            if (ceil != 0 && ceil2 != 0) {
                H(ceil, ceil2);
                if (this.f25760O) {
                    this.f25748C.set(this.f25758M);
                    this.f25748C.preScale(width, height);
                    Matrix matrix = this.f25748C;
                    RectF rectF2 = this.f25757L;
                    matrix.postTranslate(-rectF2.left, -rectF2.top);
                    this.f25749D.eraseColor(0);
                    bVar.h(this.f25750E, this.f25748C, this.f25778r);
                    this.f25758M.invert(this.f25759N);
                    this.f25759N.mapRect(this.f25756K, this.f25757L);
                    B(this.f25756K, this.f25755J);
                }
                this.f25754I.set(0, 0, ceil, ceil2);
                canvas.drawBitmap(this.f25749D, this.f25754I, this.f25755J, this.f25753H);
            }
        }
    }

    public final void H(int i10, int i11) {
        Bitmap bitmap = this.f25749D;
        if (bitmap != null && bitmap.getWidth() >= i10 && this.f25749D.getHeight() >= i11) {
            if (this.f25749D.getWidth() > i10 || this.f25749D.getHeight() > i11) {
                Bitmap createBitmap = Bitmap.createBitmap(this.f25749D, 0, 0, i10, i11);
                this.f25749D = createBitmap;
                this.f25750E.setBitmap(createBitmap);
                this.f25760O = true;
                return;
            }
            return;
        }
        Bitmap createBitmap2 = Bitmap.createBitmap(i10, i11, Bitmap.Config.ARGB_8888);
        this.f25749D = createBitmap2;
        this.f25750E.setBitmap(createBitmap2);
        this.f25760O = true;
    }

    public List<e6.e> H0(e6.e eVar) {
        if (this.f25777q == null) {
            l6.e.c("Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.f25777q.g(eVar, 0, arrayList, new e6.e(new String[0]));
        return arrayList;
    }

    public final void I() {
        if (this.f25750E != null) {
            return;
        }
        this.f25750E = new Canvas();
        this.f25757L = new RectF();
        this.f25758M = new Matrix();
        this.f25759N = new Matrix();
        this.f25751F = new Rect();
        this.f25752G = new RectF();
        this.f25753H = new C0423a();
        this.f25754I = new Rect();
        this.f25755J = new Rect();
        this.f25756K = new RectF();
    }

    public void I0() {
        float T10;
        if (this.f25777q == null) {
            this.f25767g.add(new b() { // from class: com.oplus.anim.o
                @Override // com.oplus.anim.EffectiveAnimationDrawable.b
                public final void a(C0820a c0820a) {
                    EffectiveAnimationDrawable.this.m0(c0820a);
                }
            });
            return;
        }
        z();
        if (v() || Y() == 0) {
            if (isVisible()) {
                this.f25762b.x();
                this.f25766f = OnVisibleAction.NONE;
            } else {
                this.f25766f = OnVisibleAction.RESUME;
            }
        }
        if (!v()) {
            if (a0() < 0.0f) {
                T10 = U();
            } else {
                T10 = T();
            }
            R0((int) T10);
            this.f25762b.i();
            if (!isVisible()) {
                this.f25766f = OnVisibleAction.NONE;
            }
        }
    }

    public Bitmap J(String str) {
        d6.b P10 = P();
        if (P10 != null) {
            return P10.a(str);
        }
        return null;
    }

    public void J0() {
        this.f25762b.y();
    }

    public boolean K() {
        return this.f25776p;
    }

    public final void K0(RectF rectF, float f10, float f11) {
        rectF.set(rectF.left * f10, rectF.top * f11, rectF.right * f10, rectF.bottom * f11);
    }

    public C0820a L() {
        return this.f25761a;
    }

    public void L0(boolean z10) {
        this.f25781z = z10;
    }

    public final Context M() {
        Drawable.Callback callback = getCallback();
        if (callback == null || !(callback instanceof View)) {
            return null;
        }
        return ((View) callback).getContext();
    }

    public void M0(boolean z10) {
        if (z10 != this.f25776p) {
            this.f25776p = z10;
            com.oplus.anim.model.layer.b bVar = this.f25777q;
            if (bVar != null) {
                bVar.R(z10);
            }
            invalidateSelf();
        }
    }

    public final C0955a N() {
        if (getCallback() == null) {
            return null;
        }
        if (this.f25771k == null) {
            C0955a c0955a = new C0955a(getCallback(), null);
            this.f25771k = c0955a;
            String str = this.f25773m;
            if (str != null) {
                c0955a.c(str);
            }
        }
        return this.f25771k;
    }

    public boolean N0(C0820a c0820a) {
        if (this.f25761a == c0820a) {
            return false;
        }
        this.f25760O = true;
        y();
        this.f25761a = c0820a;
        w();
        this.f25762b.z(c0820a);
        i1(this.f25762b.getAnimatedFraction());
        Iterator it = new ArrayList(this.f25767g).iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar != null) {
                bVar.a(c0820a);
            }
            it.remove();
        }
        this.f25767g.clear();
        c0820a.v(this.f25779x);
        z();
        Drawable.Callback callback = getCallback();
        if (callback instanceof ImageView) {
            ImageView imageView = (ImageView) callback;
            imageView.setImageDrawable(null);
            imageView.setImageDrawable(this);
        }
        return true;
    }

    public int O() {
        return (int) this.f25762b.k();
    }

    public void O0(String str) {
        this.f25773m = str;
        C0955a N10 = N();
        if (N10 != null) {
            N10.c(str);
        }
    }

    public final d6.b P() {
        d6.b bVar = this.f25769i;
        if (bVar != null && !bVar.b(M())) {
            this.f25769i = null;
        }
        if (this.f25769i == null) {
            this.f25769i = new d6.b(getCallback(), this.f25770j, null, this.f25761a.j());
        }
        return this.f25769i;
    }

    public void P0(L l10) {
        C0955a c0955a = this.f25771k;
        if (c0955a != null) {
            c0955a.d(l10);
        }
    }

    public String Q() {
        return this.f25770j;
    }

    public void Q0(Map<String, Typeface> map) {
        if (map == this.f25772l) {
            return;
        }
        this.f25772l = map;
        invalidateSelf();
    }

    public I R(String str) {
        C0820a c0820a = this.f25761a;
        if (c0820a == null) {
            return null;
        }
        return c0820a.j().get(str);
    }

    public void R0(final int i10) {
        if (this.f25761a == null) {
            this.f25767g.add(new b() { // from class: com.oplus.anim.l
                @Override // com.oplus.anim.EffectiveAnimationDrawable.b
                public final void a(C0820a c0820a) {
                    EffectiveAnimationDrawable.this.n0(i10, c0820a);
                }
            });
        } else {
            this.f25762b.A(i10);
        }
    }

    public boolean S() {
        return this.f25775o;
    }

    public void S0(boolean z10) {
        this.f25764d = z10;
    }

    public float T() {
        return this.f25762b.m();
    }

    public void T0(M m10) {
        d6.b bVar = this.f25769i;
        if (bVar != null) {
            bVar.d(m10);
        }
    }

    public float U() {
        return this.f25762b.n();
    }

    public void U0(String str) {
        this.f25770j = str;
    }

    public O V() {
        C0820a c0820a = this.f25761a;
        if (c0820a != null) {
            return c0820a.n();
        }
        return null;
    }

    public void V0(boolean z10) {
        this.f25775o = z10;
    }

    public float W() {
        return this.f25762b.j();
    }

    public void W0(final int i10) {
        if (this.f25761a == null) {
            this.f25767g.add(new b() { // from class: com.oplus.anim.f
                @Override // com.oplus.anim.EffectiveAnimationDrawable.b
                public final void a(C0820a c0820a) {
                    EffectiveAnimationDrawable.this.o0(i10, c0820a);
                }
            });
        } else {
            this.f25762b.B(i10 + 0.99f);
        }
    }

    public RenderMode X() {
        if (this.f25747B) {
            return RenderMode.SOFTWARE;
        }
        return RenderMode.HARDWARE;
    }

    public void X0(final String str) {
        C0820a c0820a = this.f25761a;
        if (c0820a == null) {
            this.f25767g.add(new b() { // from class: com.oplus.anim.b
                @Override // com.oplus.anim.EffectiveAnimationDrawable.b
                public final void a(C0820a c0820a2) {
                    EffectiveAnimationDrawable.this.p0(str, c0820a2);
                }
            });
            return;
        }
        e6.g l10 = c0820a.l(str);
        if (l10 != null) {
            W0((int) (l10.f31649b + l10.f31650c));
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public int Y() {
        return this.f25762b.getRepeatCount();
    }

    public void Y0(final float f10) {
        C0820a c0820a = this.f25761a;
        if (c0820a == null) {
            this.f25767g.add(new b() { // from class: com.oplus.anim.j
                @Override // com.oplus.anim.EffectiveAnimationDrawable.b
                public final void a(C0820a c0820a2) {
                    EffectiveAnimationDrawable.this.q0(f10, c0820a2);
                }
            });
        } else {
            this.f25762b.B(l6.g.i(c0820a.p(), this.f25761a.f(), f10));
        }
    }

    public int Z() {
        return this.f25762b.getRepeatMode();
    }

    public void Z0(final int i10, final int i11) {
        if (this.f25761a == null) {
            this.f25767g.add(new b() { // from class: com.oplus.anim.g
                @Override // com.oplus.anim.EffectiveAnimationDrawable.b
                public final void a(C0820a c0820a) {
                    EffectiveAnimationDrawable.this.r0(i10, i11, c0820a);
                }
            });
        } else {
            this.f25762b.C(i10, i11 + 0.99f);
        }
    }

    public float a0() {
        return this.f25762b.o();
    }

    public void a1(final String str) {
        C0820a c0820a = this.f25761a;
        if (c0820a == null) {
            this.f25767g.add(new b() { // from class: com.oplus.anim.n
                @Override // com.oplus.anim.EffectiveAnimationDrawable.b
                public final void a(C0820a c0820a2) {
                    EffectiveAnimationDrawable.this.s0(str, c0820a2);
                }
            });
            return;
        }
        e6.g l10 = c0820a.l(str);
        if (l10 != null) {
            int i10 = (int) l10.f31649b;
            Z0(i10, ((int) l10.f31650c) + i10);
        } else {
            throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
    }

    public T b0() {
        return null;
    }

    public void b1(final String str, final String str2, final boolean z10) {
        float f10;
        C0820a c0820a = this.f25761a;
        if (c0820a == null) {
            this.f25767g.add(new b() { // from class: com.oplus.anim.h
                @Override // com.oplus.anim.EffectiveAnimationDrawable.b
                public final void a(C0820a c0820a2) {
                    EffectiveAnimationDrawable.this.t0(str, str2, z10, c0820a2);
                }
            });
            return;
        }
        e6.g l10 = c0820a.l(str);
        if (l10 != null) {
            int i10 = (int) l10.f31649b;
            e6.g l11 = this.f25761a.l(str2);
            if (l11 != null) {
                float f11 = l11.f31649b;
                if (z10) {
                    f10 = 1.0f;
                } else {
                    f10 = 0.0f;
                }
                Z0(i10, (int) (f11 + f10));
                return;
            }
            throw new IllegalArgumentException("Cannot find marker with name " + str2 + ".");
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public Typeface c0(C0984c c0984c) {
        Map<String, Typeface> map = this.f25772l;
        if (map != null) {
            String a10 = c0984c.a();
            if (map.containsKey(a10)) {
                return map.get(a10);
            }
            String b10 = c0984c.b();
            if (map.containsKey(b10)) {
                return map.get(b10);
            }
            String str = c0984c.a() + "-" + c0984c.c();
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        C0955a N10 = N();
        if (N10 != null) {
            return N10.b(c0984c);
        }
        return null;
    }

    public void c1(final float f10, final float f11) {
        C0820a c0820a = this.f25761a;
        if (c0820a == null) {
            this.f25767g.add(new b() { // from class: com.oplus.anim.e
                @Override // com.oplus.anim.EffectiveAnimationDrawable.b
                public final void a(C0820a c0820a2) {
                    EffectiveAnimationDrawable.this.u0(f10, f11, c0820a2);
                }
            });
        } else {
            Z0((int) l6.g.i(c0820a.p(), this.f25761a.f(), f10), (int) l6.g.i(this.f25761a.p(), this.f25761a.f(), f11));
        }
    }

    public boolean d0() {
        com.oplus.anim.model.layer.b bVar = this.f25777q;
        if (bVar != null && bVar.P()) {
            return true;
        }
        return false;
    }

    public void d1(final int i10) {
        if (this.f25761a == null) {
            this.f25767g.add(new b() { // from class: com.oplus.anim.p
                @Override // com.oplus.anim.EffectiveAnimationDrawable.b
                public final void a(C0820a c0820a) {
                    EffectiveAnimationDrawable.this.v0(i10, c0820a);
                }
            });
        } else {
            this.f25762b.D(i10);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        N.a("Drawable#draw");
        if (this.f25765e) {
            try {
                if (this.f25747B) {
                    G0(canvas, this.f25777q);
                } else {
                    D(canvas);
                }
            } catch (Throwable th) {
                l6.e.b("Lottie crashed in draw!", th);
            }
        } else if (this.f25747B) {
            G0(canvas, this.f25777q);
        } else {
            D(canvas);
        }
        this.f25760O = false;
        N.b("Drawable#draw");
    }

    public boolean e0() {
        com.oplus.anim.model.layer.b bVar = this.f25777q;
        if (bVar != null && bVar.Q()) {
            return true;
        }
        return false;
    }

    public void e1(final String str) {
        C0820a c0820a = this.f25761a;
        if (c0820a == null) {
            this.f25767g.add(new b() { // from class: com.oplus.anim.c
                @Override // com.oplus.anim.EffectiveAnimationDrawable.b
                public final void a(C0820a c0820a2) {
                    EffectiveAnimationDrawable.this.w0(str, c0820a2);
                }
            });
            return;
        }
        e6.g l10 = c0820a.l(str);
        if (l10 != null) {
            d1((int) l10.f31649b);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public final boolean f0() {
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof View)) {
            return false;
        }
        if (!(((View) callback).getParent() instanceof ViewGroup)) {
            return false;
        }
        return !((ViewGroup) r2).getClipChildren();
    }

    public void f1(final float f10) {
        C0820a c0820a = this.f25761a;
        if (c0820a == null) {
            this.f25767g.add(new b() { // from class: com.oplus.anim.d
                @Override // com.oplus.anim.EffectiveAnimationDrawable.b
                public final void a(C0820a c0820a2) {
                    EffectiveAnimationDrawable.this.x0(f10, c0820a2);
                }
            });
        } else {
            d1((int) l6.g.i(c0820a.p(), this.f25761a.f(), f10));
        }
    }

    public boolean g0() {
        l6.b bVar = this.f25762b;
        if (bVar == null) {
            return false;
        }
        return bVar.isRunning();
    }

    public void g1(boolean z10) {
        if (this.f25780y == z10) {
            return;
        }
        this.f25780y = z10;
        com.oplus.anim.model.layer.b bVar = this.f25777q;
        if (bVar != null) {
            bVar.K(z10);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f25778r;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        C0820a c0820a = this.f25761a;
        if (c0820a == null) {
            return -1;
        }
        return c0820a.b().height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        C0820a c0820a = this.f25761a;
        if (c0820a == null) {
            return -1;
        }
        return c0820a.b().width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public boolean h0() {
        if (isVisible()) {
            return this.f25762b.isRunning();
        }
        OnVisibleAction onVisibleAction = this.f25766f;
        if (onVisibleAction != OnVisibleAction.PLAY && onVisibleAction != OnVisibleAction.RESUME) {
            return false;
        }
        return true;
    }

    public void h1(boolean z10) {
        this.f25779x = z10;
        C0820a c0820a = this.f25761a;
        if (c0820a != null) {
            c0820a.v(z10);
        }
    }

    public boolean i0() {
        return this.f25781z;
    }

    public void i1(final float f10) {
        if (this.f25761a == null) {
            this.f25767g.add(new b() { // from class: com.oplus.anim.i
                @Override // com.oplus.anim.EffectiveAnimationDrawable.b
                public final void a(C0820a c0820a) {
                    EffectiveAnimationDrawable.this.y0(f10, c0820a);
                }
            });
            return;
        }
        N.a("Drawable#setProgress");
        this.f25762b.A(this.f25761a.h(f10));
        N.b("Drawable#setProgress");
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.f25760O) {
            return;
        }
        this.f25760O = true;
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return g0();
    }

    public boolean j0() {
        return this.f25774n;
    }

    public void j1(RenderMode renderMode) {
        this.f25746A = renderMode;
        z();
    }

    public final /* synthetic */ void k0(e6.e eVar, Object obj, C1336b c1336b, C0820a c0820a) {
        u(eVar, obj, c1336b);
    }

    public void k1(int i10) {
        this.f25762b.setRepeatCount(i10);
    }

    public final /* synthetic */ void l0(C0820a c0820a) {
        A0();
    }

    public void l1(int i10) {
        this.f25762b.setRepeatMode(i10);
    }

    public final /* synthetic */ void m0(C0820a c0820a) {
        I0();
    }

    public void m1(boolean z10) {
        this.f25765e = z10;
    }

    public final /* synthetic */ void n0(int i10, C0820a c0820a) {
        R0(i10);
    }

    public void n1(float f10) {
        this.f25762b.E(f10);
    }

    public final /* synthetic */ void o0(int i10, C0820a c0820a) {
        W0(i10);
    }

    public void o1(Boolean bool) {
        this.f25763c = bool.booleanValue();
    }

    public final /* synthetic */ void p0(String str, C0820a c0820a) {
        X0(str);
    }

    public final /* synthetic */ void q0(float f10, C0820a c0820a) {
        Y0(f10);
    }

    public void q1(boolean z10) {
        this.f25762b.F(z10);
    }

    public void r(Animator.AnimatorListener animatorListener) {
        this.f25762b.addListener(animatorListener);
    }

    public final /* synthetic */ void r0(int i10, int i11, C0820a c0820a) {
        Z0(i10, i11);
    }

    public Bitmap r1(String str, Bitmap bitmap) {
        d6.b P10 = P();
        if (P10 == null) {
            l6.e.c("Cannot update bitmap. Most likely the drawable is not added to a View which prevents EffectiveAnimation from getting a Context.");
            return null;
        }
        Bitmap e10 = P10.e(str, bitmap);
        invalidateSelf();
        return e10;
    }

    public void s(Animator.AnimatorPauseListener animatorPauseListener) {
        this.f25762b.addPauseListener(animatorPauseListener);
    }

    public final /* synthetic */ void s0(String str, C0820a c0820a) {
        a1(str);
    }

    public boolean s1() {
        if (this.f25772l == null && this.f25761a.c().i() > 0) {
            return true;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f25778r = i10;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        l6.e.c("Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        boolean z12 = !isVisible();
        boolean visible = super.setVisible(z10, z11);
        if (z10) {
            OnVisibleAction onVisibleAction = this.f25766f;
            if (onVisibleAction == OnVisibleAction.PLAY) {
                A0();
            } else if (onVisibleAction == OnVisibleAction.RESUME) {
                I0();
            }
        } else if (this.f25762b.isRunning()) {
            z0();
            this.f25766f = OnVisibleAction.RESUME;
        } else if (!z12) {
            this.f25766f = OnVisibleAction.NONE;
        }
        return visible;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable.Callback callback = getCallback();
        if ((callback instanceof View) && ((View) callback).isInEditMode()) {
            return;
        }
        A0();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        G();
    }

    public void t(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f25762b.addUpdateListener(animatorUpdateListener);
    }

    public final /* synthetic */ void t0(String str, String str2, boolean z10, C0820a c0820a) {
        b1(str, str2, z10);
    }

    public <T> void u(final e6.e eVar, final T t10, final C1336b<T> c1336b) {
        com.oplus.anim.model.layer.b bVar = this.f25777q;
        if (bVar == null) {
            this.f25767g.add(new b() { // from class: com.oplus.anim.k
                @Override // com.oplus.anim.EffectiveAnimationDrawable.b
                public final void a(C0820a c0820a) {
                    EffectiveAnimationDrawable.this.k0(eVar, t10, c1336b, c0820a);
                }
            });
            return;
        }
        if (eVar == e6.e.f31645c) {
            bVar.i(t10, c1336b);
        } else if (eVar.d() != null) {
            eVar.d().i(t10, c1336b);
        } else {
            List<e6.e> H02 = H0(eVar);
            for (int i10 = 0; i10 < H02.size(); i10++) {
                H02.get(i10).d().i(t10, c1336b);
            }
            if (!(!H02.isEmpty())) {
                return;
            }
        }
        invalidateSelf();
        if (t10 == r.f26162E) {
            i1(W());
        }
    }

    public final /* synthetic */ void u0(float f10, float f11, C0820a c0820a) {
        c1(f10, f11);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    public final boolean v() {
        if (!this.f25763c && !this.f25764d) {
            return false;
        }
        return true;
    }

    public final /* synthetic */ void v0(int i10, C0820a c0820a) {
        d1(i10);
    }

    public final void w() {
        C0820a c0820a = this.f25761a;
        if (c0820a == null) {
            return;
        }
        com.oplus.anim.model.layer.b bVar = new com.oplus.anim.model.layer.b(this, j6.w.a(c0820a), c0820a.k(), c0820a);
        this.f25777q = bVar;
        if (this.f25780y) {
            bVar.K(true);
        }
        this.f25777q.R(this.f25776p);
    }

    public final /* synthetic */ void w0(String str, C0820a c0820a) {
        e1(str);
    }

    public void x() {
        this.f25767g.clear();
        this.f25762b.cancel();
        if (!isVisible()) {
            this.f25766f = OnVisibleAction.NONE;
        }
    }

    public final /* synthetic */ void x0(float f10, C0820a c0820a) {
        f1(f10);
    }

    public void y() {
        if (this.f25762b.isRunning()) {
            this.f25762b.cancel();
            if (!isVisible()) {
                this.f25766f = OnVisibleAction.NONE;
            }
        }
        this.f25761a = null;
        this.f25777q = null;
        this.f25769i = null;
        this.f25762b.h();
        invalidateSelf();
    }

    public final /* synthetic */ void y0(float f10, C0820a c0820a) {
        i1(f10);
    }

    public final void z() {
        C0820a c0820a = this.f25761a;
        if (c0820a == null) {
            return;
        }
        this.f25747B = this.f25746A.a(Build.VERSION.SDK_INT, c0820a.q(), c0820a.m());
    }

    public void z0() {
        this.f25767g.clear();
        this.f25762b.s();
        if (!isVisible()) {
            this.f25766f = OnVisibleAction.NONE;
        }
    }

    @Deprecated
    public void C() {
    }

    public void p1(T t10) {
    }
}
