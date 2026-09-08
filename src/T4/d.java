package t4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import com.google.android.material.progressindicator.CircularProgressIndicatorSpec;
import f4.C1003d;
import j0.AbstractC1152b;
import t4.g;

/* compiled from: CircularIndeterminateAnimatorDelegate.java */
/* loaded from: classes3.dex */
public final class d extends h<ObjectAnimator> {

    /* renamed from: k, reason: collision with root package name */
    public static final int[] f37194k = {0, 1350, 2700, 4050};

    /* renamed from: l, reason: collision with root package name */
    public static final int[] f37195l = {667, 2017, 3367, 4717};

    /* renamed from: m, reason: collision with root package name */
    public static final int[] f37196m = {1000, 2350, 3700, 5050};

    /* renamed from: n, reason: collision with root package name */
    public static final Property<d, Float> f37197n = new c(Float.class, "animationFraction");

    /* renamed from: o, reason: collision with root package name */
    public static final Property<d, Float> f37198o = new C0364d(Float.class, "completeEndFraction");

    /* renamed from: c, reason: collision with root package name */
    public ObjectAnimator f37199c;

    /* renamed from: d, reason: collision with root package name */
    public ObjectAnimator f37200d;

    /* renamed from: e, reason: collision with root package name */
    public final T.b f37201e;

    /* renamed from: f, reason: collision with root package name */
    public final AbstractC1591b f37202f;

    /* renamed from: g, reason: collision with root package name */
    public int f37203g;

    /* renamed from: h, reason: collision with root package name */
    public float f37204h;

    /* renamed from: i, reason: collision with root package name */
    public float f37205i;

    /* renamed from: j, reason: collision with root package name */
    public AbstractC1152b f37206j;

    /* compiled from: CircularIndeterminateAnimatorDelegate.java */
    /* loaded from: classes3.dex */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            d dVar = d.this;
            dVar.f37203g = (dVar.f37203g + 4) % d.this.f37202f.f37184c.length;
        }
    }

    /* compiled from: CircularIndeterminateAnimatorDelegate.java */
    /* loaded from: classes3.dex */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            d.this.a();
            d dVar = d.this;
            AbstractC1152b abstractC1152b = dVar.f37206j;
            if (abstractC1152b != null) {
                abstractC1152b.b(dVar.f37237a);
            }
        }
    }

    /* compiled from: CircularIndeterminateAnimatorDelegate.java */
    /* loaded from: classes3.dex */
    public class c extends Property<d, Float> {
        public c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(d dVar) {
            return Float.valueOf(dVar.o());
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(d dVar, Float f10) {
            dVar.t(f10.floatValue());
        }
    }

    /* compiled from: CircularIndeterminateAnimatorDelegate.java */
    /* renamed from: t4.d$d, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0364d extends Property<d, Float> {
        public C0364d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(d dVar) {
            return Float.valueOf(dVar.p());
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(d dVar, Float f10) {
            dVar.u(f10.floatValue());
        }
    }

    public d(CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(1);
        this.f37203g = 0;
        this.f37206j = null;
        this.f37202f = circularProgressIndicatorSpec;
        this.f37201e = new T.b();
    }

    @Override // t4.h
    public void a() {
        ObjectAnimator objectAnimator = this.f37199c;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // t4.h
    public void c() {
        s();
    }

    @Override // t4.h
    public void d(AbstractC1152b abstractC1152b) {
        this.f37206j = abstractC1152b;
    }

    @Override // t4.h
    public void f() {
        ObjectAnimator objectAnimator = this.f37200d;
        if (objectAnimator != null && !objectAnimator.isRunning()) {
            if (this.f37237a.isVisible()) {
                this.f37200d.start();
            } else {
                a();
            }
        }
    }

    @Override // t4.h
    public void g() {
        q();
        s();
        this.f37199c.start();
    }

    @Override // t4.h
    public void h() {
        this.f37206j = null;
    }

    public final float o() {
        return this.f37204h;
    }

    public final float p() {
        return this.f37205i;
    }

    public final void q() {
        if (this.f37199c == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, f37197n, 0.0f, 1.0f);
            this.f37199c = ofFloat;
            ofFloat.setDuration(5400L);
            this.f37199c.setInterpolator(null);
            this.f37199c.setRepeatCount(-1);
            this.f37199c.addListener(new a());
        }
        if (this.f37200d == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, f37198o, 0.0f, 1.0f);
            this.f37200d = ofFloat2;
            ofFloat2.setDuration(333L);
            this.f37200d.setInterpolator(this.f37201e);
            this.f37200d.addListener(new b());
        }
    }

    public final void r(int i10) {
        for (int i11 = 0; i11 < 4; i11++) {
            float b10 = b(i10, f37196m[i11], 333);
            if (b10 >= 0.0f && b10 <= 1.0f) {
                int i12 = i11 + this.f37203g;
                int[] iArr = this.f37202f.f37184c;
                int length = i12 % iArr.length;
                int length2 = (length + 1) % iArr.length;
                int i13 = iArr[length];
                int i14 = iArr[length2];
                this.f37238b.get(0).f37235c = C1003d.b().evaluate(this.f37201e.getInterpolation(b10), Integer.valueOf(i13), Integer.valueOf(i14)).intValue();
                return;
            }
        }
    }

    public void s() {
        this.f37203g = 0;
        this.f37238b.get(0).f37235c = this.f37202f.f37184c[0];
        this.f37205i = 0.0f;
    }

    public void t(float f10) {
        this.f37204h = f10;
        int i10 = (int) (f10 * 5400.0f);
        v(i10);
        r(i10);
        this.f37237a.invalidateSelf();
    }

    public final void u(float f10) {
        this.f37205i = f10;
    }

    public final void v(int i10) {
        g.a aVar = this.f37238b.get(0);
        float f10 = this.f37204h;
        aVar.f37233a = (f10 * 1520.0f) - 20.0f;
        aVar.f37234b = f10 * 1520.0f;
        for (int i11 = 0; i11 < 4; i11++) {
            aVar.f37234b += this.f37201e.getInterpolation(b(i10, f37194k[i11], 667)) * 250.0f;
            aVar.f37233a += this.f37201e.getInterpolation(b(i10, f37195l[i11], 667)) * 250.0f;
        }
        float f11 = aVar.f37233a;
        float f12 = aVar.f37234b;
        aVar.f37233a = (f11 + ((f12 - f11) * this.f37205i)) / 360.0f;
        aVar.f37234b = f12 / 360.0f;
    }
}
