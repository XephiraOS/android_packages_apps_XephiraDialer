package t4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.Property;
import android.view.animation.Interpolator;
import com.google.android.material.progressindicator.LinearProgressIndicatorSpec;
import e4.C0975a;
import j0.AbstractC1152b;
import j0.C1154d;
import java.util.Iterator;
import t4.g;

/* compiled from: LinearIndeterminateDisjointAnimatorDelegate.java */
/* loaded from: classes3.dex */
public final class l extends h<ObjectAnimator> {

    /* renamed from: k, reason: collision with root package name */
    public static final int[] f37255k = {533, 567, 850, 750};

    /* renamed from: l, reason: collision with root package name */
    public static final int[] f37256l = {1267, 1000, 333, 0};

    /* renamed from: m, reason: collision with root package name */
    public static final Property<l, Float> f37257m = new c(Float.class, "animationFraction");

    /* renamed from: c, reason: collision with root package name */
    public ObjectAnimator f37258c;

    /* renamed from: d, reason: collision with root package name */
    public ObjectAnimator f37259d;

    /* renamed from: e, reason: collision with root package name */
    public final Interpolator[] f37260e;

    /* renamed from: f, reason: collision with root package name */
    public final AbstractC1591b f37261f;

    /* renamed from: g, reason: collision with root package name */
    public int f37262g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f37263h;

    /* renamed from: i, reason: collision with root package name */
    public float f37264i;

    /* renamed from: j, reason: collision with root package name */
    public AbstractC1152b f37265j;

    /* compiled from: LinearIndeterminateDisjointAnimatorDelegate.java */
    /* loaded from: classes3.dex */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            l lVar = l.this;
            lVar.f37262g = (lVar.f37262g + 1) % l.this.f37261f.f37184c.length;
            l.this.f37263h = true;
        }
    }

    /* compiled from: LinearIndeterminateDisjointAnimatorDelegate.java */
    /* loaded from: classes3.dex */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            l.this.a();
            l lVar = l.this;
            AbstractC1152b abstractC1152b = lVar.f37265j;
            if (abstractC1152b != null) {
                abstractC1152b.b(lVar.f37237a);
            }
        }
    }

    /* compiled from: LinearIndeterminateDisjointAnimatorDelegate.java */
    /* loaded from: classes3.dex */
    public class c extends Property<l, Float> {
        public c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(l lVar) {
            return Float.valueOf(lVar.n());
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(l lVar, Float f10) {
            lVar.r(f10.floatValue());
        }
    }

    public l(Context context, LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(2);
        this.f37262g = 0;
        this.f37265j = null;
        this.f37261f = linearProgressIndicatorSpec;
        this.f37260e = new Interpolator[]{C1154d.a(context, C0975a.f30612a), C1154d.a(context, C0975a.f30613b), C1154d.a(context, C0975a.f30614c), C1154d.a(context, C0975a.f30615d)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float n() {
        return this.f37264i;
    }

    private void o() {
        if (this.f37258c == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, f37257m, 0.0f, 1.0f);
            this.f37258c = ofFloat;
            ofFloat.setDuration(1800L);
            this.f37258c.setInterpolator(null);
            this.f37258c.setRepeatCount(-1);
            this.f37258c.addListener(new a());
        }
        if (this.f37259d == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, f37257m, 1.0f);
            this.f37259d = ofFloat2;
            ofFloat2.setDuration(1800L);
            this.f37259d.setInterpolator(null);
            this.f37259d.addListener(new b());
        }
    }

    private void p() {
        if (this.f37263h) {
            Iterator<g.a> it = this.f37238b.iterator();
            while (it.hasNext()) {
                it.next().f37235c = this.f37261f.f37184c[this.f37262g];
            }
            this.f37263h = false;
        }
    }

    private void s(int i10) {
        for (int i11 = 0; i11 < this.f37238b.size(); i11++) {
            g.a aVar = this.f37238b.get(i11);
            int[] iArr = f37256l;
            int i12 = i11 * 2;
            int i13 = iArr[i12];
            int[] iArr2 = f37255k;
            aVar.f37233a = E.a.a(this.f37260e[i12].getInterpolation(b(i10, i13, iArr2[i12])), 0.0f, 1.0f);
            int i14 = i12 + 1;
            aVar.f37234b = E.a.a(this.f37260e[i14].getInterpolation(b(i10, iArr[i14], iArr2[i14])), 0.0f, 1.0f);
        }
    }

    @Override // t4.h
    public void a() {
        ObjectAnimator objectAnimator = this.f37258c;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // t4.h
    public void c() {
        q();
    }

    @Override // t4.h
    public void d(AbstractC1152b abstractC1152b) {
        this.f37265j = abstractC1152b;
    }

    @Override // t4.h
    public void f() {
        ObjectAnimator objectAnimator = this.f37259d;
        if (objectAnimator != null && !objectAnimator.isRunning()) {
            a();
            if (this.f37237a.isVisible()) {
                this.f37259d.setFloatValues(this.f37264i, 1.0f);
                this.f37259d.setDuration((1.0f - this.f37264i) * 1800.0f);
                this.f37259d.start();
            }
        }
    }

    @Override // t4.h
    public void g() {
        o();
        q();
        this.f37258c.start();
    }

    @Override // t4.h
    public void h() {
        this.f37265j = null;
    }

    public void q() {
        this.f37262g = 0;
        Iterator<g.a> it = this.f37238b.iterator();
        while (it.hasNext()) {
            it.next().f37235c = this.f37261f.f37184c[0];
        }
    }

    public void r(float f10) {
        this.f37264i = f10;
        s((int) (f10 * 1800.0f));
        p();
        this.f37237a.invalidateSelf();
    }
}
