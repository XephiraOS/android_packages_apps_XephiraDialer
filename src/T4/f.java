package t4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import f4.C1001b;
import j0.AbstractC1152b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: DrawableWithAnimatedVisibilityChange.java */
/* loaded from: classes3.dex */
public abstract class f extends Drawable implements Animatable {

    /* renamed from: o, reason: collision with root package name */
    public static final Property<f, Float> f37215o = new c(Float.class, "growFraction");

    /* renamed from: a, reason: collision with root package name */
    public final Context f37216a;

    /* renamed from: b, reason: collision with root package name */
    public final AbstractC1591b f37217b;

    /* renamed from: d, reason: collision with root package name */
    public ValueAnimator f37219d;

    /* renamed from: e, reason: collision with root package name */
    public ValueAnimator f37220e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f37221f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f37222g;

    /* renamed from: h, reason: collision with root package name */
    public float f37223h;

    /* renamed from: i, reason: collision with root package name */
    public List<AbstractC1152b> f37224i;

    /* renamed from: j, reason: collision with root package name */
    public AbstractC1152b f37225j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f37226k;

    /* renamed from: l, reason: collision with root package name */
    public float f37227l;

    /* renamed from: n, reason: collision with root package name */
    public int f37229n;

    /* renamed from: m, reason: collision with root package name */
    public final Paint f37228m = new Paint();

    /* renamed from: c, reason: collision with root package name */
    public C1590a f37218c = new C1590a();

    /* compiled from: DrawableWithAnimatedVisibilityChange.java */
    /* loaded from: classes3.dex */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            f.this.f();
        }
    }

    /* compiled from: DrawableWithAnimatedVisibilityChange.java */
    /* loaded from: classes3.dex */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            f.super.setVisible(false, false);
            f.this.e();
        }
    }

    /* compiled from: DrawableWithAnimatedVisibilityChange.java */
    /* loaded from: classes3.dex */
    public class c extends Property<f, Float> {
        public c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(f fVar) {
            return Float.valueOf(fVar.h());
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(f fVar, Float f10) {
            fVar.n(f10.floatValue());
        }
    }

    public f(Context context, AbstractC1591b abstractC1591b) {
        this.f37216a = context;
        this.f37217b = abstractC1591b;
        setAlpha(255);
    }

    public final void d(ValueAnimator... valueAnimatorArr) {
        boolean z10 = this.f37226k;
        this.f37226k = true;
        for (ValueAnimator valueAnimator : valueAnimatorArr) {
            valueAnimator.cancel();
        }
        this.f37226k = z10;
    }

    public final void e() {
        AbstractC1152b abstractC1152b = this.f37225j;
        if (abstractC1152b != null) {
            abstractC1152b.b(this);
        }
        List<AbstractC1152b> list = this.f37224i;
        if (list != null && !this.f37226k) {
            Iterator<AbstractC1152b> it = list.iterator();
            while (it.hasNext()) {
                it.next().b(this);
            }
        }
    }

    public final void f() {
        AbstractC1152b abstractC1152b = this.f37225j;
        if (abstractC1152b != null) {
            abstractC1152b.c(this);
        }
        List<AbstractC1152b> list = this.f37224i;
        if (list != null && !this.f37226k) {
            Iterator<AbstractC1152b> it = list.iterator();
            while (it.hasNext()) {
                it.next().c(this);
            }
        }
    }

    public final void g(ValueAnimator... valueAnimatorArr) {
        boolean z10 = this.f37226k;
        this.f37226k = true;
        for (ValueAnimator valueAnimator : valueAnimatorArr) {
            valueAnimator.end();
        }
        this.f37226k = z10;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f37229n;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public float h() {
        if (!this.f37217b.b() && !this.f37217b.a()) {
            return 1.0f;
        }
        if (!this.f37222g && !this.f37221f) {
            return this.f37227l;
        }
        return this.f37223h;
    }

    public boolean i() {
        return q(false, false, false);
    }

    public boolean isRunning() {
        if (!k() && !j()) {
            return false;
        }
        return true;
    }

    public boolean j() {
        ValueAnimator valueAnimator = this.f37220e;
        if ((valueAnimator != null && valueAnimator.isRunning()) || this.f37222g) {
            return true;
        }
        return false;
    }

    public boolean k() {
        ValueAnimator valueAnimator = this.f37219d;
        if ((valueAnimator != null && valueAnimator.isRunning()) || this.f37221f) {
            return true;
        }
        return false;
    }

    public final void l() {
        if (this.f37219d == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, f37215o, 0.0f, 1.0f);
            this.f37219d = ofFloat;
            ofFloat.setDuration(500L);
            this.f37219d.setInterpolator(C1001b.f31703b);
            p(this.f37219d);
        }
        if (this.f37220e == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, f37215o, 1.0f, 0.0f);
            this.f37220e = ofFloat2;
            ofFloat2.setDuration(500L);
            this.f37220e.setInterpolator(C1001b.f31703b);
            o(this.f37220e);
        }
    }

    public void m(AbstractC1152b abstractC1152b) {
        if (this.f37224i == null) {
            this.f37224i = new ArrayList();
        }
        if (!this.f37224i.contains(abstractC1152b)) {
            this.f37224i.add(abstractC1152b);
        }
    }

    public void n(float f10) {
        if (this.f37227l != f10) {
            this.f37227l = f10;
            invalidateSelf();
        }
    }

    public final void o(ValueAnimator valueAnimator) {
        ValueAnimator valueAnimator2 = this.f37220e;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            throw new IllegalArgumentException("Cannot set hideAnimator while the current hideAnimator is running.");
        }
        this.f37220e = valueAnimator;
        valueAnimator.addListener(new b());
    }

    public final void p(ValueAnimator valueAnimator) {
        ValueAnimator valueAnimator2 = this.f37219d;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            throw new IllegalArgumentException("Cannot set showAnimator while the current showAnimator is running.");
        }
        this.f37219d = valueAnimator;
        valueAnimator.addListener(new a());
    }

    public boolean q(boolean z10, boolean z11, boolean z12) {
        boolean z13;
        float a10 = this.f37218c.a(this.f37216a.getContentResolver());
        if (z12 && a10 > 0.0f) {
            z13 = true;
        } else {
            z13 = false;
        }
        return r(z10, z11, z13);
    }

    public boolean r(boolean z10, boolean z11, boolean z12) {
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2;
        boolean a10;
        l();
        boolean z13 = false;
        if (!isVisible() && !z10) {
            return false;
        }
        if (z10) {
            valueAnimator = this.f37219d;
        } else {
            valueAnimator = this.f37220e;
        }
        if (z10) {
            valueAnimator2 = this.f37220e;
        } else {
            valueAnimator2 = this.f37219d;
        }
        if (!z12) {
            if (valueAnimator2.isRunning()) {
                d(valueAnimator2);
            }
            if (valueAnimator.isRunning()) {
                valueAnimator.end();
            } else {
                g(valueAnimator);
            }
            return super.setVisible(z10, false);
        }
        if (valueAnimator.isRunning()) {
            return false;
        }
        if (!z10 || super.setVisible(z10, false)) {
            z13 = true;
        }
        if (z10) {
            a10 = this.f37217b.b();
        } else {
            a10 = this.f37217b.a();
        }
        if (!a10) {
            g(valueAnimator);
            return z13;
        }
        if (!z11 && valueAnimator.isPaused()) {
            valueAnimator.resume();
        } else {
            valueAnimator.start();
        }
        return z13;
    }

    public boolean s(AbstractC1152b abstractC1152b) {
        List<AbstractC1152b> list = this.f37224i;
        if (list != null && list.contains(abstractC1152b)) {
            this.f37224i.remove(abstractC1152b);
            if (this.f37224i.isEmpty()) {
                this.f37224i = null;
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f37229n = i10;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f37228m.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        return q(z10, z11, true);
    }

    public void start() {
        r(true, true, false);
    }

    public void stop() {
        r(false, true, false);
    }
}
