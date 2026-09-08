package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import androidx.core.view.K;
import com.google.android.material.internal.ThemeEnforcement;
import e4.C0977c;
import e4.l;
import e4.m;
import j0.AbstractC1152b;
import java.util.Arrays;
import l4.C1292a;
import t4.AbstractC1591b;
import t4.C1590a;
import t4.e;
import t4.f;
import t4.g;
import t4.i;

/* compiled from: BaseProgressIndicator.java */
/* loaded from: classes3.dex */
public abstract class a<S extends AbstractC1591b> extends ProgressBar {

    /* renamed from: o, reason: collision with root package name */
    public static final int f23524o = l.f31012N;

    /* renamed from: a, reason: collision with root package name */
    public S f23525a;

    /* renamed from: b, reason: collision with root package name */
    public int f23526b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f23527c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f23528d;

    /* renamed from: e, reason: collision with root package name */
    public final int f23529e;

    /* renamed from: f, reason: collision with root package name */
    public final int f23530f;

    /* renamed from: g, reason: collision with root package name */
    public long f23531g;

    /* renamed from: h, reason: collision with root package name */
    public C1590a f23532h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f23533i;

    /* renamed from: j, reason: collision with root package name */
    public int f23534j;

    /* renamed from: k, reason: collision with root package name */
    public final Runnable f23535k;

    /* renamed from: l, reason: collision with root package name */
    public final Runnable f23536l;

    /* renamed from: m, reason: collision with root package name */
    public final AbstractC1152b f23537m;

    /* renamed from: n, reason: collision with root package name */
    public final AbstractC1152b f23538n;

    /* compiled from: BaseProgressIndicator.java */
    /* renamed from: com.google.android.material.progressindicator.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0216a implements Runnable {
        public RunnableC0216a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.k();
        }
    }

    /* compiled from: BaseProgressIndicator.java */
    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.j();
            a.this.f23531g = -1L;
        }
    }

    /* compiled from: BaseProgressIndicator.java */
    /* loaded from: classes3.dex */
    public class c extends AbstractC1152b {
        public c() {
        }

        @Override // j0.AbstractC1152b
        public void b(Drawable drawable) {
            a.this.setIndeterminate(false);
            a aVar = a.this;
            aVar.o(aVar.f23526b, a.this.f23527c);
        }
    }

    /* compiled from: BaseProgressIndicator.java */
    /* loaded from: classes3.dex */
    public class d extends AbstractC1152b {
        public d() {
        }

        @Override // j0.AbstractC1152b
        public void b(Drawable drawable) {
            super.b(drawable);
            if (!a.this.f23533i) {
                a aVar = a.this;
                aVar.setVisibility(aVar.f23534j);
            }
        }
    }

    public a(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(B4.a.c(context, attributeSet, i10, f23524o), attributeSet, i10);
        this.f23531g = -1L;
        this.f23533i = false;
        this.f23534j = 4;
        this.f23535k = new RunnableC0216a();
        this.f23536l = new b();
        this.f23537m = new c();
        this.f23538n = new d();
        Context context2 = getContext();
        this.f23525a = i(context2, attributeSet);
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, m.f31406h0, i10, i11, new int[0]);
        this.f23529e = obtainStyledAttributes.getInt(m.f31472n0, -1);
        this.f23530f = Math.min(obtainStyledAttributes.getInt(m.f31450l0, -1), 1000);
        obtainStyledAttributes.recycle();
        this.f23532h = new C1590a();
        this.f23528d = true;
    }

    private g<S> getCurrentDrawingDelegate() {
        if (isIndeterminate()) {
            if (getIndeterminateDrawable() == null) {
                return null;
            }
            return getIndeterminateDrawable().w();
        }
        if (getProgressDrawable() == null) {
            return null;
        }
        return getProgressDrawable().x();
    }

    @Override // android.widget.ProgressBar
    public Drawable getCurrentDrawable() {
        if (isIndeterminate()) {
            return getIndeterminateDrawable();
        }
        return getProgressDrawable();
    }

    public int getHideAnimationBehavior() {
        return this.f23525a.f37187f;
    }

    public int[] getIndicatorColor() {
        return this.f23525a.f37184c;
    }

    public int getIndicatorTrackGapSize() {
        return this.f23525a.f37188g;
    }

    public int getShowAnimationBehavior() {
        return this.f23525a.f37186e;
    }

    public int getTrackColor() {
        return this.f23525a.f37185d;
    }

    public int getTrackCornerRadius() {
        return this.f23525a.f37183b;
    }

    public int getTrackThickness() {
        return this.f23525a.f37182a;
    }

    public void h(boolean z10) {
        if (!this.f23528d) {
            return;
        }
        ((f) getCurrentDrawable()).q(q(), false, z10);
    }

    public abstract S i(Context context, AttributeSet attributeSet);

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        if (getCurrentDrawable() != null) {
            getCurrentDrawable().invalidateSelf();
        }
    }

    public final void j() {
        ((f) getCurrentDrawable()).q(false, false, true);
        if (m()) {
            setVisibility(4);
        }
    }

    public final void k() {
        if (this.f23530f > 0) {
            this.f23531g = SystemClock.uptimeMillis();
        }
        setVisibility(0);
    }

    public boolean l() {
        View view = this;
        while (view.getVisibility() == 0) {
            Object parent = view.getParent();
            if (parent == null) {
                if (getWindowVisibility() != 0) {
                    return false;
                }
                return true;
            }
            if (!(parent instanceof View)) {
                return true;
            }
            view = (View) parent;
        }
        return false;
    }

    public final boolean m() {
        if ((getProgressDrawable() != null && getProgressDrawable().isVisible()) || (getIndeterminateDrawable() != null && getIndeterminateDrawable().isVisible())) {
            return false;
        }
        return true;
    }

    public final void n() {
        if (getProgressDrawable() != null && getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().v().d(this.f23537m);
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().m(this.f23538n);
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().m(this.f23538n);
        }
    }

    public void o(int i10, boolean z10) {
        if (isIndeterminate()) {
            if (getProgressDrawable() != null) {
                this.f23526b = i10;
                this.f23527c = z10;
                this.f23533i = true;
                if (getIndeterminateDrawable().isVisible() && this.f23532h.a(getContext().getContentResolver()) != 0.0f) {
                    getIndeterminateDrawable().v().f();
                    return;
                } else {
                    this.f23537m.b(getIndeterminateDrawable());
                    return;
                }
            }
            return;
        }
        super.setProgress(i10);
        if (getProgressDrawable() != null && !z10) {
            getProgressDrawable().jumpToCurrentState();
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        n();
        if (q()) {
            k();
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.f23536l);
        removeCallbacks(this.f23535k);
        ((f) getCurrentDrawable()).i();
        p();
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(Canvas canvas) {
        try {
            int save = canvas.save();
            if (getPaddingLeft() == 0) {
                if (getPaddingTop() != 0) {
                }
                if (getPaddingRight() == 0 || getPaddingBottom() != 0) {
                    canvas.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));
                }
                getCurrentDrawable().draw(canvas);
                canvas.restoreToCount(save);
            }
            canvas.translate(getPaddingLeft(), getPaddingTop());
            if (getPaddingRight() == 0) {
            }
            canvas.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));
            getCurrentDrawable().draw(canvas);
            canvas.restoreToCount(save);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onMeasure(int i10, int i11) {
        int f10;
        int e10;
        try {
            g<S> currentDrawingDelegate = getCurrentDrawingDelegate();
            if (currentDrawingDelegate == null) {
                return;
            }
            if (currentDrawingDelegate.f() < 0) {
                f10 = View.getDefaultSize(getSuggestedMinimumWidth(), i10);
            } else {
                f10 = currentDrawingDelegate.f() + getPaddingLeft() + getPaddingRight();
            }
            if (currentDrawingDelegate.e() < 0) {
                e10 = View.getDefaultSize(getSuggestedMinimumHeight(), i11);
            } else {
                e10 = currentDrawingDelegate.e() + getPaddingTop() + getPaddingBottom();
            }
            setMeasuredDimension(f10, e10);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i10) {
        boolean z10;
        super.onVisibilityChanged(view, i10);
        if (i10 == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        h(z10);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        h(false);
    }

    public final void p() {
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().s(this.f23538n);
            getIndeterminateDrawable().v().h();
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().s(this.f23538n);
        }
    }

    public boolean q() {
        if (K.N(this) && getWindowVisibility() == 0 && l()) {
            return true;
        }
        return false;
    }

    public void setAnimatorDurationScaleProvider(C1590a c1590a) {
        this.f23532h = c1590a;
        if (getProgressDrawable() != null) {
            getProgressDrawable().f37218c = c1590a;
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().f37218c = c1590a;
        }
    }

    public void setHideAnimationBehavior(int i10) {
        this.f23525a.f37187f = i10;
        invalidate();
    }

    @Override // android.widget.ProgressBar
    public synchronized void setIndeterminate(boolean z10) {
        try {
            if (z10 == isIndeterminate()) {
                return;
            }
            f fVar = (f) getCurrentDrawable();
            if (fVar != null) {
                fVar.i();
            }
            super.setIndeterminate(z10);
            f fVar2 = (f) getCurrentDrawable();
            if (fVar2 != null) {
                fVar2.q(q(), false, false);
            }
            if ((fVar2 instanceof i) && q()) {
                ((i) fVar2).v().g();
            }
            this.f23533i = false;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.widget.ProgressBar
    public void setIndeterminateDrawable(Drawable drawable) {
        if (drawable == null) {
            super.setIndeterminateDrawable(null);
        } else {
            if (drawable instanceof i) {
                ((f) drawable).i();
                super.setIndeterminateDrawable(drawable);
                return;
            }
            throw new IllegalArgumentException("Cannot set framework drawable as indeterminate drawable.");
        }
    }

    public void setIndicatorColor(int... iArr) {
        if (iArr.length == 0) {
            iArr = new int[]{C1292a.b(getContext(), C0977c.f30693t, -1)};
        }
        if (!Arrays.equals(getIndicatorColor(), iArr)) {
            this.f23525a.f37184c = iArr;
            getIndeterminateDrawable().v().c();
            invalidate();
        }
    }

    public void setIndicatorTrackGapSize(int i10) {
        S s10 = this.f23525a;
        if (s10.f37188g != i10) {
            s10.f37188g = i10;
            s10.e();
            invalidate();
        }
    }

    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int i10) {
        if (isIndeterminate()) {
            return;
        }
        o(i10, false);
    }

    @Override // android.widget.ProgressBar
    public void setProgressDrawable(Drawable drawable) {
        if (drawable == null) {
            super.setProgressDrawable(null);
        } else {
            if (drawable instanceof e) {
                e eVar = (e) drawable;
                eVar.i();
                super.setProgressDrawable(eVar);
                eVar.B(getProgress() / getMax());
                return;
            }
            throw new IllegalArgumentException("Cannot set framework drawable as progress drawable.");
        }
    }

    public void setShowAnimationBehavior(int i10) {
        this.f23525a.f37186e = i10;
        invalidate();
    }

    public void setTrackColor(int i10) {
        S s10 = this.f23525a;
        if (s10.f37185d != i10) {
            s10.f37185d = i10;
            invalidate();
        }
    }

    public void setTrackCornerRadius(int i10) {
        S s10 = this.f23525a;
        if (s10.f37183b != i10) {
            s10.f37183b = Math.min(i10, s10.f37182a / 2);
            invalidate();
        }
    }

    public void setTrackThickness(int i10) {
        S s10 = this.f23525a;
        if (s10.f37182a != i10) {
            s10.f37182a = i10;
            requestLayout();
        }
    }

    public void setVisibilityAfterHide(int i10) {
        if (i10 != 0 && i10 != 4 && i10 != 8) {
            throw new IllegalArgumentException("The component's visibility must be one of VISIBLE, INVISIBLE, and GONE defined in View.");
        }
        this.f23534j = i10;
    }

    @Override // android.widget.ProgressBar
    public i<S> getIndeterminateDrawable() {
        return (i) super.getIndeterminateDrawable();
    }

    @Override // android.widget.ProgressBar
    public e<S> getProgressDrawable() {
        return (e) super.getProgressDrawable();
    }
}
