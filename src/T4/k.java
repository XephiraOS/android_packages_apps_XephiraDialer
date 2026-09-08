package t4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import com.google.android.material.progressindicator.LinearProgressIndicatorSpec;
import j0.AbstractC1152b;
import t4.g;

/* compiled from: LinearIndeterminateContiguousAnimatorDelegate.java */
/* loaded from: classes3.dex */
public final class k extends h<ObjectAnimator> {

    /* renamed from: i, reason: collision with root package name */
    public static final Property<k, Float> f37247i = new b(Float.class, "animationFraction");

    /* renamed from: c, reason: collision with root package name */
    public ObjectAnimator f37248c;

    /* renamed from: d, reason: collision with root package name */
    public T.b f37249d;

    /* renamed from: e, reason: collision with root package name */
    public final AbstractC1591b f37250e;

    /* renamed from: f, reason: collision with root package name */
    public int f37251f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f37252g;

    /* renamed from: h, reason: collision with root package name */
    public float f37253h;

    /* compiled from: LinearIndeterminateContiguousAnimatorDelegate.java */
    /* loaded from: classes3.dex */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            k kVar = k.this;
            kVar.f37251f = (kVar.f37251f + 1) % k.this.f37250e.f37184c.length;
            k.this.f37252g = true;
        }
    }

    /* compiled from: LinearIndeterminateContiguousAnimatorDelegate.java */
    /* loaded from: classes3.dex */
    public class b extends Property<k, Float> {
        public b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(k kVar) {
            return Float.valueOf(kVar.n());
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(k kVar, Float f10) {
            kVar.r(f10.floatValue());
        }
    }

    public k(LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(3);
        this.f37251f = 1;
        this.f37250e = linearProgressIndicatorSpec;
        this.f37249d = new T.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float n() {
        return this.f37253h;
    }

    private void o() {
        if (this.f37248c == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, f37247i, 0.0f, 1.0f);
            this.f37248c = ofFloat;
            ofFloat.setDuration(333L);
            this.f37248c.setInterpolator(null);
            this.f37248c.setRepeatCount(-1);
            this.f37248c.addListener(new a());
        }
    }

    private void s(int i10) {
        this.f37238b.get(0).f37233a = 0.0f;
        float b10 = b(i10, 0, 667);
        g.a aVar = this.f37238b.get(0);
        g.a aVar2 = this.f37238b.get(1);
        float interpolation = this.f37249d.getInterpolation(b10);
        aVar2.f37233a = interpolation;
        aVar.f37234b = interpolation;
        g.a aVar3 = this.f37238b.get(1);
        g.a aVar4 = this.f37238b.get(2);
        float interpolation2 = this.f37249d.getInterpolation(b10 + 0.49925038f);
        aVar4.f37233a = interpolation2;
        aVar3.f37234b = interpolation2;
        this.f37238b.get(2).f37234b = 1.0f;
    }

    @Override // t4.h
    public void a() {
        ObjectAnimator objectAnimator = this.f37248c;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // t4.h
    public void c() {
        q();
    }

    @Override // t4.h
    public void g() {
        o();
        q();
        this.f37248c.start();
    }

    public final void p() {
        if (this.f37252g && this.f37238b.get(1).f37234b < 1.0f) {
            this.f37238b.get(2).f37235c = this.f37238b.get(1).f37235c;
            this.f37238b.get(1).f37235c = this.f37238b.get(0).f37235c;
            this.f37238b.get(0).f37235c = this.f37250e.f37184c[this.f37251f];
            this.f37252g = false;
        }
    }

    public void q() {
        this.f37252g = true;
        this.f37251f = 1;
        for (g.a aVar : this.f37238b) {
            AbstractC1591b abstractC1591b = this.f37250e;
            aVar.f37235c = abstractC1591b.f37184c[0];
            aVar.f37236d = abstractC1591b.f37188g / 2;
        }
    }

    public void r(float f10) {
        this.f37253h = f10;
        s((int) (f10 * 333.0f));
        p();
        this.f37237a.invalidateSelf();
    }

    @Override // t4.h
    public void f() {
    }

    @Override // t4.h
    public void h() {
    }

    @Override // t4.h
    public void d(AbstractC1152b abstractC1152b) {
    }
}
