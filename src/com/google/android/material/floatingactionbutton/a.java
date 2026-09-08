package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.util.Property;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.core.view.K;
import com.google.android.material.internal.StateListAnimator;
import e4.C0977c;
import f4.C1001b;
import f4.C1002c;
import f4.C1006g;
import f4.C1007h;
import f4.C1008i;
import java.util.ArrayList;
import java.util.Iterator;
import s4.C1550i;
import w4.InterfaceC1650b;
import x4.n;
import x4.r;

/* compiled from: FloatingActionButtonImpl.java */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: D, reason: collision with root package name */
    public static final TimeInterpolator f23364D = C1001b.f31704c;

    /* renamed from: E, reason: collision with root package name */
    public static final int f23365E = C0977c.f30648T;

    /* renamed from: F, reason: collision with root package name */
    public static final int f23366F = C0977c.f30662d0;

    /* renamed from: G, reason: collision with root package name */
    public static final int f23367G = C0977c.f30649U;

    /* renamed from: H, reason: collision with root package name */
    public static final int f23368H = C0977c.f30658b0;

    /* renamed from: I, reason: collision with root package name */
    public static final int[] f23369I = {16842919, 16842910};

    /* renamed from: J, reason: collision with root package name */
    public static final int[] f23370J = {16843623, 16842908, 16842910};

    /* renamed from: K, reason: collision with root package name */
    public static final int[] f23371K = {16842908, 16842910};

    /* renamed from: L, reason: collision with root package name */
    public static final int[] f23372L = {16843623, 16842910};

    /* renamed from: M, reason: collision with root package name */
    public static final int[] f23373M = {16842910};

    /* renamed from: N, reason: collision with root package name */
    public static final int[] f23374N = new int[0];

    /* renamed from: C, reason: collision with root package name */
    public ViewTreeObserver.OnPreDrawListener f23377C;

    /* renamed from: a, reason: collision with root package name */
    public n f23378a;

    /* renamed from: b, reason: collision with root package name */
    public x4.i f23379b;

    /* renamed from: c, reason: collision with root package name */
    public Drawable f23380c;

    /* renamed from: d, reason: collision with root package name */
    public q4.c f23381d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f23382e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f23383f;

    /* renamed from: h, reason: collision with root package name */
    public float f23385h;

    /* renamed from: i, reason: collision with root package name */
    public float f23386i;

    /* renamed from: j, reason: collision with root package name */
    public float f23387j;

    /* renamed from: k, reason: collision with root package name */
    public int f23388k;

    /* renamed from: l, reason: collision with root package name */
    public final StateListAnimator f23389l;

    /* renamed from: m, reason: collision with root package name */
    public Animator f23390m;

    /* renamed from: n, reason: collision with root package name */
    public C1008i f23391n;

    /* renamed from: o, reason: collision with root package name */
    public C1008i f23392o;

    /* renamed from: p, reason: collision with root package name */
    public float f23393p;

    /* renamed from: r, reason: collision with root package name */
    public int f23395r;

    /* renamed from: t, reason: collision with root package name */
    public ArrayList<Animator.AnimatorListener> f23397t;

    /* renamed from: u, reason: collision with root package name */
    public ArrayList<Animator.AnimatorListener> f23398u;

    /* renamed from: v, reason: collision with root package name */
    public ArrayList<i> f23399v;

    /* renamed from: w, reason: collision with root package name */
    public final FloatingActionButton f23400w;

    /* renamed from: x, reason: collision with root package name */
    public final InterfaceC1650b f23401x;

    /* renamed from: g, reason: collision with root package name */
    public boolean f23384g = true;

    /* renamed from: q, reason: collision with root package name */
    public float f23394q = 1.0f;

    /* renamed from: s, reason: collision with root package name */
    public int f23396s = 0;

    /* renamed from: y, reason: collision with root package name */
    public final Rect f23402y = new Rect();

    /* renamed from: z, reason: collision with root package name */
    public final RectF f23403z = new RectF();

    /* renamed from: A, reason: collision with root package name */
    public final RectF f23375A = new RectF();

    /* renamed from: B, reason: collision with root package name */
    public final Matrix f23376B = new Matrix();

    /* compiled from: FloatingActionButtonImpl.java */
    /* renamed from: com.google.android.material.floatingactionbutton.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0214a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public boolean f23404a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f23405b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ j f23406c;

        public C0214a(boolean z10, j jVar) {
            this.f23405b = z10;
            this.f23406c = jVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f23404a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            int i10;
            a.this.f23396s = 0;
            a.this.f23390m = null;
            if (!this.f23404a) {
                FloatingActionButton floatingActionButton = a.this.f23400w;
                boolean z10 = this.f23405b;
                if (z10) {
                    i10 = 8;
                } else {
                    i10 = 4;
                }
                floatingActionButton.internalSetVisibility(i10, z10);
                j jVar = this.f23406c;
                if (jVar != null) {
                    jVar.b();
                }
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            a.this.f23400w.internalSetVisibility(0, this.f23405b);
            a.this.f23396s = 1;
            a.this.f23390m = animator;
            this.f23404a = false;
        }
    }

    /* compiled from: FloatingActionButtonImpl.java */
    /* loaded from: classes3.dex */
    public class b extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f23408a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j f23409b;

        public b(boolean z10, j jVar) {
            this.f23408a = z10;
            this.f23409b = jVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.f23396s = 0;
            a.this.f23390m = null;
            j jVar = this.f23409b;
            if (jVar != null) {
                jVar.a();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            a.this.f23400w.internalSetVisibility(0, this.f23408a);
            a.this.f23396s = 2;
            a.this.f23390m = animator;
        }
    }

    /* compiled from: FloatingActionButtonImpl.java */
    /* loaded from: classes3.dex */
    public class c extends C1007h {
        public c() {
        }

        @Override // android.animation.TypeEvaluator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Matrix evaluate(float f10, Matrix matrix, Matrix matrix2) {
            a.this.f23394q = f10;
            return super.evaluate(f10, matrix, matrix2);
        }
    }

    /* compiled from: FloatingActionButtonImpl.java */
    /* loaded from: classes3.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f23412a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f23413b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ float f23414c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ float f23415d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ float f23416e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ float f23417f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ float f23418g;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ Matrix f23419h;

        public d(float f10, float f11, float f12, float f13, float f14, float f15, float f16, Matrix matrix) {
            this.f23412a = f10;
            this.f23413b = f11;
            this.f23414c = f12;
            this.f23415d = f13;
            this.f23416e = f14;
            this.f23417f = f15;
            this.f23418g = f16;
            this.f23419h = matrix;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            a.this.f23400w.setAlpha(C1001b.b(this.f23412a, this.f23413b, 0.0f, 0.2f, floatValue));
            a.this.f23400w.setScaleX(C1001b.a(this.f23414c, this.f23415d, floatValue));
            a.this.f23400w.setScaleY(C1001b.a(this.f23416e, this.f23415d, floatValue));
            a.this.f23394q = C1001b.a(this.f23417f, this.f23418g, floatValue);
            a.this.h(C1001b.a(this.f23417f, this.f23418g, floatValue), this.f23419h);
            a.this.f23400w.setImageMatrix(this.f23419h);
        }
    }

    /* compiled from: FloatingActionButtonImpl.java */
    /* loaded from: classes3.dex */
    public class e implements ViewTreeObserver.OnPreDrawListener {
        public e() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            a.this.H();
            return true;
        }
    }

    /* compiled from: FloatingActionButtonImpl.java */
    /* loaded from: classes3.dex */
    public class f extends l {
        public f() {
            super(a.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.a.l
        public float a() {
            return 0.0f;
        }
    }

    /* compiled from: FloatingActionButtonImpl.java */
    /* loaded from: classes3.dex */
    public class g extends l {
        public g() {
            super(a.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.a.l
        public float a() {
            a aVar = a.this;
            return aVar.f23385h + aVar.f23386i;
        }
    }

    /* compiled from: FloatingActionButtonImpl.java */
    /* loaded from: classes3.dex */
    public class h extends l {
        public h() {
            super(a.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.a.l
        public float a() {
            a aVar = a.this;
            return aVar.f23385h + aVar.f23387j;
        }
    }

    /* compiled from: FloatingActionButtonImpl.java */
    /* loaded from: classes3.dex */
    public interface i {
        void a();

        void b();
    }

    /* compiled from: FloatingActionButtonImpl.java */
    /* loaded from: classes3.dex */
    public interface j {
        void a();

        void b();
    }

    /* compiled from: FloatingActionButtonImpl.java */
    /* loaded from: classes3.dex */
    public class k extends l {
        public k() {
            super(a.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.a.l
        public float a() {
            return a.this.f23385h;
        }
    }

    /* compiled from: FloatingActionButtonImpl.java */
    /* loaded from: classes3.dex */
    public abstract class l extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        public boolean f23426a;

        /* renamed from: b, reason: collision with root package name */
        public float f23427b;

        /* renamed from: c, reason: collision with root package name */
        public float f23428c;

        public l() {
        }

        public abstract float a();

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.g0((int) this.f23428c);
            this.f23426a = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float elevation;
            if (!this.f23426a) {
                x4.i iVar = a.this.f23379b;
                if (iVar == null) {
                    elevation = 0.0f;
                } else {
                    elevation = iVar.getElevation();
                }
                this.f23427b = elevation;
                this.f23428c = a();
                this.f23426a = true;
            }
            a aVar = a.this;
            float f10 = this.f23427b;
            aVar.g0((int) (f10 + ((this.f23428c - f10) * valueAnimator.getAnimatedFraction())));
        }

        public /* synthetic */ l(a aVar, C0214a c0214a) {
            this();
        }
    }

    public a(FloatingActionButton floatingActionButton, InterfaceC1650b interfaceC1650b) {
        this.f23400w = floatingActionButton;
        this.f23401x = interfaceC1650b;
        StateListAnimator stateListAnimator = new StateListAnimator();
        this.f23389l = stateListAnimator;
        stateListAnimator.addState(f23369I, k(new h()));
        stateListAnimator.addState(f23370J, k(new g()));
        stateListAnimator.addState(f23371K, k(new g()));
        stateListAnimator.addState(f23372L, k(new g()));
        stateListAnimator.addState(f23373M, k(new k()));
        stateListAnimator.addState(f23374N, k(new f()));
        this.f23393p = floatingActionButton.getRotation();
    }

    public void A() {
        throw null;
    }

    public void B() {
        x4.i iVar = this.f23379b;
        if (iVar != null) {
            x4.j.f(this.f23400w, iVar);
        }
        if (K()) {
            this.f23400w.getViewTreeObserver().addOnPreDrawListener(q());
        }
    }

    public void C() {
        throw null;
    }

    public void D() {
        ViewTreeObserver viewTreeObserver = this.f23400w.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.f23377C;
        if (onPreDrawListener != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            this.f23377C = null;
        }
    }

    public void E(int[] iArr) {
        throw null;
    }

    public void F(float f10, float f11, float f12) {
        throw null;
    }

    public void G(Rect rect) {
        I.h.f(this.f23382e, "Didn't initialize content background");
        if (Z()) {
            this.f23401x.a(new InsetDrawable(this.f23382e, rect.left, rect.top, rect.right, rect.bottom));
        } else {
            this.f23401x.a(this.f23382e);
        }
    }

    public void H() {
        float rotation = this.f23400w.getRotation();
        if (this.f23393p != rotation) {
            this.f23393p = rotation;
            d0();
        }
    }

    public void I() {
        ArrayList<i> arrayList = this.f23399v;
        if (arrayList != null) {
            Iterator<i> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }
    }

    public void J() {
        ArrayList<i> arrayList = this.f23399v;
        if (arrayList != null) {
            Iterator<i> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    public boolean K() {
        throw null;
    }

    public void L(ColorStateList colorStateList) {
        x4.i iVar = this.f23379b;
        if (iVar != null) {
            iVar.setTintList(colorStateList);
        }
        q4.c cVar = this.f23381d;
        if (cVar != null) {
            cVar.c(colorStateList);
        }
    }

    public void M(PorterDuff.Mode mode) {
        x4.i iVar = this.f23379b;
        if (iVar != null) {
            iVar.setTintMode(mode);
        }
    }

    public final void N(float f10) {
        if (this.f23385h != f10) {
            this.f23385h = f10;
            F(f10, this.f23386i, this.f23387j);
        }
    }

    public void O(boolean z10) {
        this.f23383f = z10;
    }

    public final void P(C1008i c1008i) {
        this.f23392o = c1008i;
    }

    public final void Q(float f10) {
        if (this.f23386i != f10) {
            this.f23386i = f10;
            F(this.f23385h, f10, this.f23387j);
        }
    }

    public final void R(float f10) {
        this.f23394q = f10;
        Matrix matrix = this.f23376B;
        h(f10, matrix);
        this.f23400w.setImageMatrix(matrix);
    }

    public final void S(int i10) {
        if (this.f23395r != i10) {
            this.f23395r = i10;
            e0();
        }
    }

    public void T(int i10) {
        this.f23388k = i10;
    }

    public final void U(float f10) {
        if (this.f23387j != f10) {
            this.f23387j = f10;
            F(this.f23385h, this.f23386i, f10);
        }
    }

    public void V(ColorStateList colorStateList) {
        Drawable drawable = this.f23380c;
        if (drawable != null) {
            C.a.o(drawable, v4.b.d(colorStateList));
        }
    }

    public void W(boolean z10) {
        this.f23384g = z10;
        f0();
    }

    public final void X(n nVar) {
        this.f23378a = nVar;
        x4.i iVar = this.f23379b;
        if (iVar != null) {
            iVar.setShapeAppearanceModel(nVar);
        }
        Object obj = this.f23380c;
        if (obj instanceof r) {
            ((r) obj).setShapeAppearanceModel(nVar);
        }
        q4.c cVar = this.f23381d;
        if (cVar != null) {
            cVar.f(nVar);
        }
    }

    public final void Y(C1008i c1008i) {
        this.f23391n = c1008i;
    }

    public boolean Z() {
        throw null;
    }

    public final boolean a0() {
        if (K.O(this.f23400w) && !this.f23400w.isInEditMode()) {
            return true;
        }
        return false;
    }

    public final boolean b0() {
        if (this.f23383f && this.f23400w.getSizeDimension() < this.f23388k) {
            return false;
        }
        return true;
    }

    public void c0(j jVar, boolean z10) {
        boolean z11;
        AnimatorSet j10;
        float f10;
        float f11;
        if (z()) {
            return;
        }
        Animator animator = this.f23390m;
        if (animator != null) {
            animator.cancel();
        }
        if (this.f23391n == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (a0()) {
            if (this.f23400w.getVisibility() != 0) {
                float f12 = 0.0f;
                this.f23400w.setAlpha(0.0f);
                FloatingActionButton floatingActionButton = this.f23400w;
                if (z11) {
                    f10 = 0.4f;
                } else {
                    f10 = 0.0f;
                }
                floatingActionButton.setScaleY(f10);
                FloatingActionButton floatingActionButton2 = this.f23400w;
                if (z11) {
                    f11 = 0.4f;
                } else {
                    f11 = 0.0f;
                }
                floatingActionButton2.setScaleX(f11);
                if (z11) {
                    f12 = 0.4f;
                }
                R(f12);
            }
            C1008i c1008i = this.f23391n;
            if (c1008i != null) {
                j10 = i(c1008i, 1.0f, 1.0f, 1.0f);
            } else {
                j10 = j(1.0f, 1.0f, 1.0f, f23365E, f23366F);
            }
            j10.addListener(new b(z10, jVar));
            ArrayList<Animator.AnimatorListener> arrayList = this.f23397t;
            if (arrayList != null) {
                Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    j10.addListener(it.next());
                }
            }
            j10.start();
            return;
        }
        this.f23400w.internalSetVisibility(0, z10);
        this.f23400w.setAlpha(1.0f);
        this.f23400w.setScaleY(1.0f);
        this.f23400w.setScaleX(1.0f);
        R(1.0f);
        if (jVar != null) {
            jVar.a();
        }
    }

    public void d0() {
        throw null;
    }

    public void e(Animator.AnimatorListener animatorListener) {
        if (this.f23398u == null) {
            this.f23398u = new ArrayList<>();
        }
        this.f23398u.add(animatorListener);
    }

    public final void e0() {
        R(this.f23394q);
    }

    public void f(Animator.AnimatorListener animatorListener) {
        if (this.f23397t == null) {
            this.f23397t = new ArrayList<>();
        }
        this.f23397t.add(animatorListener);
    }

    public final void f0() {
        Rect rect = this.f23402y;
        r(rect);
        G(rect);
        this.f23401x.setShadowPadding(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void g(i iVar) {
        if (this.f23399v == null) {
            this.f23399v = new ArrayList<>();
        }
        this.f23399v.add(iVar);
    }

    public void g0(float f10) {
        x4.i iVar = this.f23379b;
        if (iVar != null) {
            iVar.setElevation(f10);
        }
    }

    public final void h(float f10, Matrix matrix) {
        matrix.reset();
        if (this.f23400w.getDrawable() != null && this.f23395r != 0) {
            RectF rectF = this.f23403z;
            RectF rectF2 = this.f23375A;
            rectF.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
            int i10 = this.f23395r;
            rectF2.set(0.0f, 0.0f, i10, i10);
            matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            int i11 = this.f23395r;
            matrix.postScale(f10, f10, i11 / 2.0f, i11 / 2.0f);
        }
    }

    public final AnimatorSet i(C1008i c1008i, float f10, float f11, float f12) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f23400w, (Property<FloatingActionButton, Float>) View.ALPHA, f10);
        c1008i.h("opacity").a(ofFloat);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f23400w, (Property<FloatingActionButton, Float>) View.SCALE_X, f11);
        c1008i.h("scale").a(ofFloat2);
        h0(ofFloat2);
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f23400w, (Property<FloatingActionButton, Float>) View.SCALE_Y, f11);
        c1008i.h("scale").a(ofFloat3);
        h0(ofFloat3);
        arrayList.add(ofFloat3);
        h(f12, this.f23376B);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.f23400w, new C1006g(), new c(), new Matrix(this.f23376B));
        c1008i.h("iconScale").a(ofObject);
        arrayList.add(ofObject);
        AnimatorSet animatorSet = new AnimatorSet();
        C1002c.a(animatorSet, arrayList);
        return animatorSet;
    }

    public final AnimatorSet j(float f10, float f11, float f12, int i10, int i11) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new d(this.f23400w.getAlpha(), f10, this.f23400w.getScaleX(), f11, this.f23400w.getScaleY(), this.f23394q, f12, new Matrix(this.f23376B)));
        arrayList.add(ofFloat);
        C1002c.a(animatorSet, arrayList);
        animatorSet.setDuration(C1550i.f(this.f23400w.getContext(), i10, this.f23400w.getContext().getResources().getInteger(e4.h.f30913b)));
        animatorSet.setInterpolator(C1550i.g(this.f23400w.getContext(), i11, C1001b.f31703b));
        return animatorSet;
    }

    public final ValueAnimator k(l lVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(f23364D);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(lVar);
        valueAnimator.addUpdateListener(lVar);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }

    public final Drawable l() {
        return this.f23382e;
    }

    public float m() {
        throw null;
    }

    public boolean n() {
        return this.f23383f;
    }

    public final C1008i o() {
        return this.f23392o;
    }

    public float p() {
        return this.f23386i;
    }

    public final ViewTreeObserver.OnPreDrawListener q() {
        if (this.f23377C == null) {
            this.f23377C = new e();
        }
        return this.f23377C;
    }

    public void r(Rect rect) {
        float f10;
        int v10 = v();
        if (this.f23384g) {
            f10 = m() + this.f23387j;
        } else {
            f10 = 0.0f;
        }
        int max = Math.max(v10, (int) Math.ceil(f10));
        int max2 = Math.max(v10, (int) Math.ceil(f10 * 1.5f));
        rect.set(max, max2, max, max2);
    }

    public float s() {
        return this.f23387j;
    }

    public final n t() {
        return this.f23378a;
    }

    public final C1008i u() {
        return this.f23391n;
    }

    public int v() {
        if (!this.f23383f) {
            return 0;
        }
        return Math.max((this.f23388k - this.f23400w.getSizeDimension()) / 2, 0);
    }

    public void w(j jVar, boolean z10) {
        int i10;
        AnimatorSet j10;
        if (y()) {
            return;
        }
        Animator animator = this.f23390m;
        if (animator != null) {
            animator.cancel();
        }
        if (a0()) {
            C1008i c1008i = this.f23392o;
            if (c1008i != null) {
                j10 = i(c1008i, 0.0f, 0.0f, 0.0f);
            } else {
                j10 = j(0.0f, 0.4f, 0.4f, f23367G, f23368H);
            }
            j10.addListener(new C0214a(z10, jVar));
            ArrayList<Animator.AnimatorListener> arrayList = this.f23398u;
            if (arrayList != null) {
                Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    j10.addListener(it.next());
                }
            }
            j10.start();
            return;
        }
        FloatingActionButton floatingActionButton = this.f23400w;
        if (z10) {
            i10 = 8;
        } else {
            i10 = 4;
        }
        floatingActionButton.internalSetVisibility(i10, z10);
        if (jVar != null) {
            jVar.b();
        }
    }

    public void x(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i10) {
        throw null;
    }

    public boolean y() {
        if (this.f23400w.getVisibility() == 0) {
            if (this.f23396s != 1) {
                return false;
            }
            return true;
        }
        if (this.f23396s == 2) {
            return false;
        }
        return true;
    }

    public boolean z() {
        if (this.f23400w.getVisibility() != 0) {
            if (this.f23396s != 2) {
                return false;
            }
            return true;
        }
        if (this.f23396s == 1) {
            return false;
        }
        return true;
    }

    public final void h0(ObjectAnimator objectAnimator) {
    }
}
