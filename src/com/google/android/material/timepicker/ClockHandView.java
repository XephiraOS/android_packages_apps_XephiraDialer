package com.google.android.material.timepicker;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.K;
import com.google.android.material.internal.ViewUtils;
import e4.C0977c;
import e4.C0979e;
import e4.l;
import e4.m;
import f4.C1001b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import r4.C1509a;
import s4.C1550i;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class ClockHandView extends View {

    /* renamed from: a, reason: collision with root package name */
    public final int f24204a;

    /* renamed from: b, reason: collision with root package name */
    public final TimeInterpolator f24205b;

    /* renamed from: c, reason: collision with root package name */
    public final ValueAnimator f24206c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f24207d;

    /* renamed from: e, reason: collision with root package name */
    public float f24208e;

    /* renamed from: f, reason: collision with root package name */
    public float f24209f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f24210g;

    /* renamed from: h, reason: collision with root package name */
    public final int f24211h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f24212i;

    /* renamed from: j, reason: collision with root package name */
    public final List<b> f24213j;

    /* renamed from: k, reason: collision with root package name */
    public final int f24214k;

    /* renamed from: l, reason: collision with root package name */
    public final float f24215l;

    /* renamed from: m, reason: collision with root package name */
    public final Paint f24216m;

    /* renamed from: n, reason: collision with root package name */
    public final RectF f24217n;

    /* renamed from: o, reason: collision with root package name */
    public final int f24218o;

    /* renamed from: p, reason: collision with root package name */
    public float f24219p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f24220q;

    /* renamed from: r, reason: collision with root package name */
    public double f24221r;

    /* renamed from: x, reason: collision with root package name */
    public int f24222x;

    /* renamed from: y, reason: collision with root package name */
    public int f24223y;

    /* loaded from: classes3.dex */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            animator.end();
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void c(float f10, boolean z10);
    }

    public ClockHandView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0977c.f30642N);
    }

    public void b(b bVar) {
        this.f24213j.add(bVar);
    }

    public final void c(float f10, float f11) {
        int i10 = 2;
        if (C1509a.a(getWidth() / 2, getHeight() / 2, f10, f11) > h(2) + ViewUtils.dpToPx(getContext(), 12)) {
            i10 = 1;
        }
        this.f24223y = i10;
    }

    public final void d(Canvas canvas) {
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float f10 = width;
        float h10 = h(this.f24223y);
        float cos = (((float) Math.cos(this.f24221r)) * h10) + f10;
        float f11 = height;
        float sin = (h10 * ((float) Math.sin(this.f24221r))) + f11;
        this.f24216m.setStrokeWidth(0.0f);
        canvas.drawCircle(cos, sin, this.f24214k, this.f24216m);
        double sin2 = Math.sin(this.f24221r);
        double cos2 = Math.cos(this.f24221r);
        this.f24216m.setStrokeWidth(this.f24218o);
        canvas.drawLine(f10, f11, width + ((int) (cos2 * r7)), height + ((int) (r7 * sin2)), this.f24216m);
        canvas.drawCircle(f10, f11, this.f24215l, this.f24216m);
    }

    public RectF e() {
        return this.f24217n;
    }

    public final int f(float f10, float f11) {
        int width = getWidth() / 2;
        int degrees = (int) Math.toDegrees(Math.atan2(f11 - (getHeight() / 2), f10 - width));
        int i10 = degrees + 90;
        if (i10 < 0) {
            return degrees + 450;
        }
        return i10;
    }

    public float g() {
        return this.f24219p;
    }

    public final int h(int i10) {
        int i11 = this.f24222x;
        if (i10 == 2) {
            return Math.round(i11 * 0.66f);
        }
        return i11;
    }

    public int i() {
        return this.f24214k;
    }

    public final Pair<Float, Float> j(float f10) {
        float g10 = g();
        if (Math.abs(g10 - f10) > 180.0f) {
            if (g10 > 180.0f && f10 < 180.0f) {
                f10 += 360.0f;
            }
            if (g10 < 180.0f && f10 > 180.0f) {
                g10 += 360.0f;
            }
        }
        return new Pair<>(Float.valueOf(g10), Float.valueOf(f10));
    }

    public final boolean k(float f10, float f11, boolean z10, boolean z11, boolean z12) {
        boolean z13;
        float f12 = f(f10, f11);
        boolean z14 = false;
        if (g() != f12) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z11 && z13) {
            return true;
        }
        if (!z13 && !z10) {
            return false;
        }
        if (z12 && this.f24207d) {
            z14 = true;
        }
        o(f12, z14);
        return true;
    }

    public final /* synthetic */ void l(ValueAnimator valueAnimator) {
        p(((Float) valueAnimator.getAnimatedValue()).floatValue(), true);
    }

    public void m(int i10) {
        this.f24222x = i10;
        invalidate();
    }

    public void n(float f10) {
        o(f10, false);
    }

    public void o(float f10, boolean z10) {
        ValueAnimator valueAnimator = this.f24206c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (!z10) {
            p(f10, false);
            return;
        }
        Pair<Float, Float> j10 = j(f10);
        this.f24206c.setFloatValues(((Float) j10.first).floatValue(), ((Float) j10.second).floatValue());
        this.f24206c.setDuration(this.f24204a);
        this.f24206c.setInterpolator(this.f24205b);
        this.f24206c.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.timepicker.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                ClockHandView.this.l(valueAnimator2);
            }
        });
        this.f24206c.addListener(new a());
        this.f24206c.start();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        d(canvas);
    }

    @Override // android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (!this.f24206c.isRunning()) {
            n(g());
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        int actionMasked = motionEvent.getActionMasked();
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        if (actionMasked != 0) {
            if (actionMasked != 1 && actionMasked != 2) {
                z11 = false;
                z10 = false;
                z12 = false;
            } else {
                int i10 = (int) (x10 - this.f24208e);
                int i11 = (int) (y10 - this.f24209f);
                if ((i10 * i10) + (i11 * i11) > this.f24211h) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                this.f24210g = z13;
                z11 = this.f24220q;
                if (actionMasked == 1) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                if (this.f24212i) {
                    c(x10, y10);
                }
                z12 = z14;
                z10 = false;
            }
        } else {
            this.f24208e = x10;
            this.f24209f = y10;
            this.f24210g = true;
            this.f24220q = false;
            z10 = true;
            z11 = false;
            z12 = false;
        }
        this.f24220q |= k(x10, y10, z11, z10, z12);
        return true;
    }

    public final void p(float f10, boolean z10) {
        float f11 = f10 % 360.0f;
        this.f24219p = f11;
        this.f24221r = Math.toRadians(f11 - 90.0f);
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float h10 = h(this.f24223y);
        float cos = width + (((float) Math.cos(this.f24221r)) * h10);
        float sin = height + (h10 * ((float) Math.sin(this.f24221r)));
        RectF rectF = this.f24217n;
        int i10 = this.f24214k;
        rectF.set(cos - i10, sin - i10, cos + i10, sin + i10);
        Iterator<b> it = this.f24213j.iterator();
        while (it.hasNext()) {
            it.next().c(f11, z10);
        }
        invalidate();
    }

    public void q(boolean z10) {
        if (this.f24212i && !z10) {
            this.f24223y = 1;
        }
        this.f24212i = z10;
        invalidate();
    }

    public ClockHandView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f24206c = new ValueAnimator();
        this.f24213j = new ArrayList();
        Paint paint = new Paint();
        this.f24216m = paint;
        this.f24217n = new RectF();
        this.f24223y = 1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.f31573w2, i10, l.f31015Q);
        this.f24204a = C1550i.f(context, C0977c.f30648T, 200);
        this.f24205b = C1550i.g(context, C0977c.f30662d0, C1001b.f31703b);
        this.f24222x = obtainStyledAttributes.getDimensionPixelSize(m.f31595y2, 0);
        this.f24214k = obtainStyledAttributes.getDimensionPixelSize(m.f31606z2, 0);
        this.f24218o = getResources().getDimensionPixelSize(C0979e.f30757R);
        this.f24215l = r7.getDimensionPixelSize(C0979e.f30753P);
        int color = obtainStyledAttributes.getColor(m.f31584x2, 0);
        paint.setAntiAlias(true);
        paint.setColor(color);
        n(0.0f);
        this.f24211h = ViewConfiguration.get(context).getScaledTouchSlop();
        K.t0(this, 2);
        obtainStyledAttributes.recycle();
    }
}
