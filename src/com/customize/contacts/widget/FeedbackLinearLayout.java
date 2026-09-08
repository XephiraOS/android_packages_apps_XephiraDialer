package com.customize.contacts.widget;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.widget.LinearLayout;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import com.coui.appcompat.roundRect.COUIRoundRectUtil;
import com.oplus.dialer.R;

/* compiled from: FeedbackLinearLayout.kt */
/* loaded from: classes3.dex */
public final class FeedbackLinearLayout extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public final int f22315a;

    /* renamed from: b, reason: collision with root package name */
    public final int f22316b;

    /* renamed from: c, reason: collision with root package name */
    public final int f22317c;

    /* renamed from: d, reason: collision with root package name */
    public final float f22318d;

    /* renamed from: e, reason: collision with root package name */
    public final float f22319e;

    /* renamed from: f, reason: collision with root package name */
    public final float f22320f;

    /* renamed from: g, reason: collision with root package name */
    public final String f22321g;

    /* renamed from: h, reason: collision with root package name */
    public final String f22322h;

    /* renamed from: i, reason: collision with root package name */
    public Interpolator f22323i;

    /* renamed from: j, reason: collision with root package name */
    public ValueAnimator f22324j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f22325k;

    /* renamed from: l, reason: collision with root package name */
    public final Paint f22326l;

    /* renamed from: m, reason: collision with root package name */
    public int f22327m;

    /* renamed from: n, reason: collision with root package name */
    public float f22328n;

    /* renamed from: o, reason: collision with root package name */
    public float f22329o;

    /* renamed from: p, reason: collision with root package name */
    public float f22330p;

    /* renamed from: q, reason: collision with root package name */
    public final Rect f22331q;

    /* renamed from: r, reason: collision with root package name */
    public final float[] f22332r;

    /* renamed from: x, reason: collision with root package name */
    public boolean f22333x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedbackLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(attrs, "attrs");
        this.f22315a = 255;
        this.f22316b = 200;
        this.f22317c = 340;
        this.f22318d = 0.8f;
        this.f22319e = 0.92f;
        this.f22320f = 0.4f;
        this.f22321g = "brightnessHolder";
        this.f22322h = "scaleHolder";
        this.f22326l = new Paint(1);
        this.f22328n = 21.0f;
        this.f22329o = 1.0f;
        this.f22330p = 1.0f;
        this.f22331q = new Rect();
        this.f22332r = new float[3];
        this.f22333x = true;
        COUIDarkModeUtil.setForceDarkAllow(this, true);
        this.f22328n = context.getResources().getDimensionPixelOffset(R.dimen.DP_20);
        this.f22327m = context.getColor(R.color.pb_color_dialpad_call_button_bg);
        f();
    }

    public static final void d(FeedbackLinearLayout this$0, boolean z10, ValueAnimator animator) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.f(animator, "animator");
        Object animatedValue = animator.getAnimatedValue(this$0.f22322h);
        kotlin.jvm.internal.i.d(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.f22330p = ((Float) animatedValue).floatValue();
        if (this$0.f22325k && z10 && ((float) animator.getCurrentPlayTime()) > ((float) animator.getDuration()) * this$0.f22320f) {
            animator.cancel();
            this$0.c(false);
        } else {
            Object animatedValue2 = animator.getAnimatedValue(this$0.f22321g);
            kotlin.jvm.internal.i.d(animatedValue2, "null cannot be cast to non-null type kotlin.Float");
            this$0.f22329o = ((Float) animatedValue2).floatValue();
            this$0.setScale(this$0.f22330p);
        }
    }

    private final void setScale(float f10) {
        float max = Math.max(this.f22319e, Math.min(1.0f, f10));
        setScaleX(max);
        setScaleY(max);
        invalidate();
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003f, code lost:
    
        if (r5 < (((float) r0.longValue()) * r4.f22320f)) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(boolean r5) {
        /*
            r4 = this;
            android.animation.ValueAnimator r0 = r4.f22324j
            if (r0 == 0) goto L4e
            if (r0 == 0) goto L4e
            boolean r0 = r0.isRunning()
            r1 = 1
            if (r0 != r1) goto L4e
            if (r5 != 0) goto L42
            android.animation.ValueAnimator r5 = r4.f22324j
            r0 = 0
            if (r5 == 0) goto L1d
            long r2 = r5.getCurrentPlayTime()
            java.lang.Long r5 = java.lang.Long.valueOf(r2)
            goto L1e
        L1d:
            r5 = r0
        L1e:
            kotlin.jvm.internal.i.c(r5)
            long r2 = r5.longValue()
            float r5 = (float) r2
            android.animation.ValueAnimator r2 = r4.f22324j
            if (r2 == 0) goto L32
            long r2 = r2.getDuration()
            java.lang.Long r0 = java.lang.Long.valueOf(r2)
        L32:
            kotlin.jvm.internal.i.c(r0)
            long r2 = r0.longValue()
            float r0 = (float) r2
            float r2 = r4.f22320f
            float r0 = r0 * r2
            int r5 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r5 >= 0) goto L42
            goto L43
        L42:
            r1 = 0
        L43:
            r4.f22325k = r1
            if (r1 != 0) goto L4e
            android.animation.ValueAnimator r4 = r4.f22324j
            if (r4 == 0) goto L4e
            r4.cancel()
        L4e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.widget.FeedbackLinearLayout.b(boolean):void");
    }

    public final void c(final boolean z10) {
        float f10;
        float f11;
        float f12;
        int i10;
        this.f22325k = false;
        b(z10);
        if (this.f22325k) {
            return;
        }
        String str = this.f22321g;
        float f13 = 1.0f;
        if (z10) {
            f10 = 1.0f;
        } else {
            f10 = this.f22329o;
        }
        if (z10) {
            f11 = this.f22318d;
        } else {
            f11 = 1.0f;
        }
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(str, f10, f11);
        String str2 = this.f22322h;
        if (z10) {
            f12 = 1.0f;
        } else {
            f12 = this.f22330p;
        }
        if (z10) {
            f13 = this.f22319e;
        }
        ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(ofFloat, PropertyValuesHolder.ofFloat(str2, f12, f13));
        this.f22324j = ofPropertyValuesHolder;
        if (ofPropertyValuesHolder != null) {
            ofPropertyValuesHolder.setInterpolator(this.f22323i);
        }
        ValueAnimator valueAnimator = this.f22324j;
        if (valueAnimator != null) {
            if (z10) {
                i10 = this.f22316b;
            } else {
                i10 = this.f22317c;
            }
            valueAnimator.setDuration(i10);
        }
        ValueAnimator valueAnimator2 = this.f22324j;
        if (valueAnimator2 != null) {
            valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.customize.contacts.widget.k
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    FeedbackLinearLayout.d(FeedbackLinearLayout.this, z10, valueAnimator3);
                }
            });
        }
        ValueAnimator valueAnimator3 = this.f22324j;
        if (valueAnimator3 != null) {
            valueAnimator3.start();
        }
    }

    public final int e(int i10) {
        B.a.m(i10, this.f22332r);
        float[] fArr = this.f22332r;
        fArr[2] = fArr[2] * this.f22329o;
        int a10 = B.a.a(fArr);
        return Color.argb(Color.alpha(i10), Math.min(this.f22315a, Color.red(a10)), Math.min(this.f22315a, Color.green(a10)), Math.min(this.f22315a, Color.blue(a10)));
    }

    public final void f() {
        this.f22323i = new PathInterpolator(0.4f, 0.0f, 0.2f, 1.0f);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        kotlin.jvm.internal.i.f(canvas, "canvas");
        if (isEnabled() && this.f22333x) {
            int save = canvas.save();
            canvas.translate(getScrollX(), getScrollY());
            this.f22326l.setColor(e(this.f22327m));
            canvas.drawPath(COUIRoundRectUtil.getInstance().getPath(this.f22331q, this.f22328n), this.f22326l);
            canvas.restoreToCount(save);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        this.f22331q.right = getWidth();
        this.f22331q.bottom = getHeight();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        kotlin.jvm.internal.i.f(event, "event");
        if (isEnabled()) {
            int action = event.getAction();
            if (action != 0) {
                if (action == 1 || action == 3) {
                    c(false);
                }
            } else {
                c(true);
            }
        }
        return super.onTouchEvent(event);
    }

    public final void setColor(int i10) {
        this.f22327m = getContext().getColor(i10);
    }

    public final void setDrawableColor(int i10) {
        this.f22327m = i10;
    }

    public final void setNeedChangeColor(boolean z10) {
        this.f22333x = z10;
    }

    public final void setRadius(float f10) {
        this.f22328n = f10;
    }
}
