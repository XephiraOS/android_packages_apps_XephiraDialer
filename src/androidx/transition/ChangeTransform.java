package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public class ChangeTransform extends Transition {

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f11577d = {"android:changeTransform:matrix", "android:changeTransform:transforms", "android:changeTransform:parentMatrix"};

    /* renamed from: e, reason: collision with root package name */
    public static final Property<e, float[]> f11578e = new a(float[].class, "nonTranslations");

    /* renamed from: f, reason: collision with root package name */
    public static final Property<e, PointF> f11579f = new b(PointF.class, "translations");

    /* renamed from: g, reason: collision with root package name */
    public static final boolean f11580g = true;

    /* renamed from: a, reason: collision with root package name */
    public boolean f11581a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f11582b;

    /* renamed from: c, reason: collision with root package name */
    public Matrix f11583c;

    /* loaded from: classes.dex */
    public class a extends Property<e, float[]> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public float[] get(e eVar) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(e eVar, float[] fArr) {
            eVar.d(fArr);
        }
    }

    /* loaded from: classes.dex */
    public class b extends Property<e, PointF> {
        public b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(e eVar) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(e eVar, PointF pointF) {
            eVar.c(pointF);
        }
    }

    /* loaded from: classes.dex */
    public static class c extends x {

        /* renamed from: a, reason: collision with root package name */
        public View f11584a;

        /* renamed from: b, reason: collision with root package name */
        public InterfaceC0503f f11585b;

        public c(View view, InterfaceC0503f interfaceC0503f) {
            this.f11584a = view;
            this.f11585b = interfaceC0503f;
        }

        @Override // androidx.transition.x, androidx.transition.Transition.i
        public void b(Transition transition) {
            this.f11585b.setVisibility(4);
        }

        @Override // androidx.transition.x, androidx.transition.Transition.i
        public void d(Transition transition) {
            transition.removeListener(this);
            C0506i.b(this.f11584a);
            this.f11584a.setTag(C0511n.f11734j, null);
            this.f11584a.setTag(C0511n.f11727c, null);
        }

        @Override // androidx.transition.x, androidx.transition.Transition.i
        public void g(Transition transition) {
            this.f11585b.setVisibility(0);
        }
    }

    /* loaded from: classes.dex */
    public static class d extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public boolean f11586a;

        /* renamed from: b, reason: collision with root package name */
        public final Matrix f11587b = new Matrix();

        /* renamed from: c, reason: collision with root package name */
        public final boolean f11588c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f11589d;

        /* renamed from: e, reason: collision with root package name */
        public final View f11590e;

        /* renamed from: f, reason: collision with root package name */
        public final f f11591f;

        /* renamed from: g, reason: collision with root package name */
        public final e f11592g;

        /* renamed from: h, reason: collision with root package name */
        public final Matrix f11593h;

        public d(View view, f fVar, e eVar, Matrix matrix, boolean z10, boolean z11) {
            this.f11588c = z10;
            this.f11589d = z11;
            this.f11590e = view;
            this.f11591f = fVar;
            this.f11592g = eVar;
            this.f11593h = matrix;
        }

        public final void a(Matrix matrix) {
            this.f11587b.set(matrix);
            this.f11590e.setTag(C0511n.f11734j, this.f11587b);
            this.f11591f.a(this.f11590e);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f11586a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.f11586a) {
                if (this.f11588c && this.f11589d) {
                    a(this.f11593h);
                } else {
                    this.f11590e.setTag(C0511n.f11734j, null);
                    this.f11590e.setTag(C0511n.f11727c, null);
                }
            }
            H.d(this.f11590e, null);
            this.f11591f.a(this.f11590e);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            a(this.f11592g.a());
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            ChangeTransform.d(this.f11590e);
        }
    }

    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public final Matrix f11594a = new Matrix();

        /* renamed from: b, reason: collision with root package name */
        public final View f11595b;

        /* renamed from: c, reason: collision with root package name */
        public final float[] f11596c;

        /* renamed from: d, reason: collision with root package name */
        public float f11597d;

        /* renamed from: e, reason: collision with root package name */
        public float f11598e;

        public e(View view, float[] fArr) {
            this.f11595b = view;
            float[] fArr2 = (float[]) fArr.clone();
            this.f11596c = fArr2;
            this.f11597d = fArr2[2];
            this.f11598e = fArr2[5];
            b();
        }

        public Matrix a() {
            return this.f11594a;
        }

        public final void b() {
            float[] fArr = this.f11596c;
            fArr[2] = this.f11597d;
            fArr[5] = this.f11598e;
            this.f11594a.setValues(fArr);
            H.d(this.f11595b, this.f11594a);
        }

        public void c(PointF pointF) {
            this.f11597d = pointF.x;
            this.f11598e = pointF.y;
            b();
        }

        public void d(float[] fArr) {
            System.arraycopy(fArr, 0, this.f11596c, 0, fArr.length);
            b();
        }
    }

    /* loaded from: classes.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public final float f11599a;

        /* renamed from: b, reason: collision with root package name */
        public final float f11600b;

        /* renamed from: c, reason: collision with root package name */
        public final float f11601c;

        /* renamed from: d, reason: collision with root package name */
        public final float f11602d;

        /* renamed from: e, reason: collision with root package name */
        public final float f11603e;

        /* renamed from: f, reason: collision with root package name */
        public final float f11604f;

        /* renamed from: g, reason: collision with root package name */
        public final float f11605g;

        /* renamed from: h, reason: collision with root package name */
        public final float f11606h;

        public f(View view) {
            this.f11599a = view.getTranslationX();
            this.f11600b = view.getTranslationY();
            this.f11601c = androidx.core.view.K.F(view);
            this.f11602d = view.getScaleX();
            this.f11603e = view.getScaleY();
            this.f11604f = view.getRotationX();
            this.f11605g = view.getRotationY();
            this.f11606h = view.getRotation();
        }

        public void a(View view) {
            ChangeTransform.f(view, this.f11599a, this.f11600b, this.f11601c, this.f11602d, this.f11603e, this.f11604f, this.f11605g, this.f11606h);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            if (fVar.f11599a != this.f11599a || fVar.f11600b != this.f11600b || fVar.f11601c != this.f11601c || fVar.f11602d != this.f11602d || fVar.f11603e != this.f11603e || fVar.f11604f != this.f11604f || fVar.f11605g != this.f11605g || fVar.f11606h != this.f11606h) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i10;
            int i11;
            int i12;
            int i13;
            int i14;
            int i15;
            int i16;
            float f10 = this.f11599a;
            int i17 = 0;
            if (f10 != 0.0f) {
                i10 = Float.floatToIntBits(f10);
            } else {
                i10 = 0;
            }
            int i18 = i10 * 31;
            float f11 = this.f11600b;
            if (f11 != 0.0f) {
                i11 = Float.floatToIntBits(f11);
            } else {
                i11 = 0;
            }
            int i19 = (i18 + i11) * 31;
            float f12 = this.f11601c;
            if (f12 != 0.0f) {
                i12 = Float.floatToIntBits(f12);
            } else {
                i12 = 0;
            }
            int i20 = (i19 + i12) * 31;
            float f13 = this.f11602d;
            if (f13 != 0.0f) {
                i13 = Float.floatToIntBits(f13);
            } else {
                i13 = 0;
            }
            int i21 = (i20 + i13) * 31;
            float f14 = this.f11603e;
            if (f14 != 0.0f) {
                i14 = Float.floatToIntBits(f14);
            } else {
                i14 = 0;
            }
            int i22 = (i21 + i14) * 31;
            float f15 = this.f11604f;
            if (f15 != 0.0f) {
                i15 = Float.floatToIntBits(f15);
            } else {
                i15 = 0;
            }
            int i23 = (i22 + i15) * 31;
            float f16 = this.f11605g;
            if (f16 != 0.0f) {
                i16 = Float.floatToIntBits(f16);
            } else {
                i16 = 0;
            }
            int i24 = (i23 + i16) * 31;
            float f17 = this.f11606h;
            if (f17 != 0.0f) {
                i17 = Float.floatToIntBits(f17);
            }
            return i24 + i17;
        }
    }

    public ChangeTransform() {
        this.f11581a = true;
        this.f11582b = true;
        this.f11583c = new Matrix();
    }

    private void captureValues(C c10) {
        Matrix matrix;
        View view = c10.f11528b;
        if (view.getVisibility() == 8) {
            return;
        }
        c10.f11527a.put("android:changeTransform:parent", view.getParent());
        c10.f11527a.put("android:changeTransform:transforms", new f(view));
        Matrix matrix2 = view.getMatrix();
        if (matrix2 != null && !matrix2.isIdentity()) {
            matrix = new Matrix(matrix2);
        } else {
            matrix = null;
        }
        c10.f11527a.put("android:changeTransform:matrix", matrix);
        if (this.f11582b) {
            Matrix matrix3 = new Matrix();
            H.h((ViewGroup) view.getParent(), matrix3);
            matrix3.preTranslate(-r1.getScrollX(), -r1.getScrollY());
            c10.f11527a.put("android:changeTransform:parentMatrix", matrix3);
            c10.f11527a.put("android:changeTransform:intermediateMatrix", view.getTag(C0511n.f11734j));
            c10.f11527a.put("android:changeTransform:intermediateParentMatrix", view.getTag(C0511n.f11727c));
        }
    }

    public static void d(View view) {
        f(view, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
    }

    public static void f(View view, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) {
        view.setTranslationX(f10);
        view.setTranslationY(f11);
        androidx.core.view.K.F0(view, f12);
        view.setScaleX(f13);
        view.setScaleY(f14);
        view.setRotationX(f15);
        view.setRotationY(f16);
        view.setRotation(f17);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v6, types: [androidx.transition.TransitionSet] */
    public final void a(ViewGroup viewGroup, C c10, C c11) {
        View view = c11.f11528b;
        Matrix matrix = new Matrix((Matrix) c11.f11527a.get("android:changeTransform:parentMatrix"));
        H.i(viewGroup, matrix);
        InterfaceC0503f a10 = C0506i.a(view, viewGroup, matrix);
        if (a10 == null) {
            return;
        }
        a10.a((ViewGroup) c10.f11527a.get("android:changeTransform:parent"), c10.f11528b);
        while (true) {
            ?? r12 = this.mParent;
            if (r12 == 0) {
                break;
            } else {
                this = r12;
            }
        }
        this.addListener(new c(view, a10));
        if (f11580g) {
            View view2 = c10.f11528b;
            if (view2 != c11.f11528b) {
                H.f(view2, 0.0f);
            }
            H.f(view, 1.0f);
        }
    }

    public final ObjectAnimator b(C c10, C c11, boolean z10) {
        Matrix matrix = (Matrix) c10.f11527a.get("android:changeTransform:matrix");
        Matrix matrix2 = (Matrix) c11.f11527a.get("android:changeTransform:matrix");
        if (matrix == null) {
            matrix = C0508k.f11724a;
        }
        if (matrix2 == null) {
            matrix2 = C0508k.f11724a;
        }
        Matrix matrix3 = matrix2;
        if (matrix.equals(matrix3)) {
            return null;
        }
        f fVar = (f) c11.f11527a.get("android:changeTransform:transforms");
        View view = c11.f11528b;
        d(view);
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        float[] fArr2 = new float[9];
        matrix3.getValues(fArr2);
        e eVar = new e(view, fArr);
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(eVar, PropertyValuesHolder.ofObject(f11578e, new C0500c(new float[9]), fArr, fArr2), C0510m.a(f11579f, getPathMotion().a(fArr[2], fArr[5], fArr2[2], fArr2[5])));
        d dVar = new d(view, fVar, eVar, matrix3, z10, this.f11581a);
        ofPropertyValuesHolder.addListener(dVar);
        ofPropertyValuesHolder.addPauseListener(dVar);
        return ofPropertyValuesHolder;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:?, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x001d, code lost:
    
        if (r4 == r5) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0017, code lost:
    
        if (r5 == r3.f11528b) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001a, code lost:
    
        r1 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c(android.view.ViewGroup r4, android.view.ViewGroup r5) {
        /*
            r3 = this;
            boolean r0 = r3.isValidTarget(r4)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L1d
            boolean r0 = r3.isValidTarget(r5)
            if (r0 != 0) goto Lf
            goto L1d
        Lf:
            androidx.transition.C r3 = r3.getMatchedTransitionValues(r4, r1)
            if (r3 == 0) goto L20
            android.view.View r3 = r3.f11528b
            if (r5 != r3) goto L1a
            goto L1b
        L1a:
            r1 = r2
        L1b:
            r2 = r1
            goto L20
        L1d:
            if (r4 != r5) goto L1a
            goto L1b
        L20:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.ChangeTransform.c(android.view.ViewGroup, android.view.ViewGroup):boolean");
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(C c10) {
        captureValues(c10);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(C c10) {
        captureValues(c10);
        if (!f11580g) {
            ((ViewGroup) c10.f11528b.getParent()).startViewTransition(c10.f11528b);
        }
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(ViewGroup viewGroup, C c10, C c11) {
        boolean z10;
        if (c10 != null && c11 != null && c10.f11527a.containsKey("android:changeTransform:parent") && c11.f11527a.containsKey("android:changeTransform:parent")) {
            ViewGroup viewGroup2 = (ViewGroup) c10.f11527a.get("android:changeTransform:parent");
            ViewGroup viewGroup3 = (ViewGroup) c11.f11527a.get("android:changeTransform:parent");
            if (this.f11582b && !c(viewGroup2, viewGroup3)) {
                z10 = true;
            } else {
                z10 = false;
            }
            Matrix matrix = (Matrix) c10.f11527a.get("android:changeTransform:intermediateMatrix");
            if (matrix != null) {
                c10.f11527a.put("android:changeTransform:matrix", matrix);
            }
            Matrix matrix2 = (Matrix) c10.f11527a.get("android:changeTransform:intermediateParentMatrix");
            if (matrix2 != null) {
                c10.f11527a.put("android:changeTransform:parentMatrix", matrix2);
            }
            if (z10) {
                e(c10, c11);
            }
            ObjectAnimator b10 = b(c10, c11, z10);
            if (z10 && b10 != null && this.f11581a) {
                a(viewGroup, c10, c11);
            } else if (!f11580g) {
                viewGroup2.endViewTransition(c10.f11528b);
            }
            return b10;
        }
        return null;
    }

    public final void e(C c10, C c11) {
        Matrix matrix = (Matrix) c11.f11527a.get("android:changeTransform:parentMatrix");
        c11.f11528b.setTag(C0511n.f11727c, matrix);
        Matrix matrix2 = this.f11583c;
        matrix2.reset();
        matrix.invert(matrix2);
        Matrix matrix3 = (Matrix) c10.f11527a.get("android:changeTransform:matrix");
        if (matrix3 == null) {
            matrix3 = new Matrix();
            c10.f11527a.put("android:changeTransform:matrix", matrix3);
        }
        matrix3.postConcat((Matrix) c10.f11527a.get("android:changeTransform:parentMatrix"));
        matrix3.postConcat(matrix2);
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return f11577d;
    }

    public ChangeTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11581a = true;
        this.f11582b = true;
        this.f11583c = new Matrix();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r.f11746g);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        this.f11581a = A.k.e(obtainStyledAttributes, xmlPullParser, "reparentWithOverlay", 1, true);
        this.f11582b = A.k.e(obtainStyledAttributes, xmlPullParser, "reparent", 0, true);
        obtainStyledAttributes.recycle();
    }
}
