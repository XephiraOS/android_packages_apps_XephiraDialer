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
import android.widget.RelativeLayout;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import com.coui.appcompat.roundRect.COUIRoundRectUtil;
import com.oplus.dialer.R;

/* compiled from: FeedbackRelativeLayout.kt */
/* loaded from: classes3.dex */
public final class FeedbackRelativeLayout extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    public final int f22334a;

    /* renamed from: b, reason: collision with root package name */
    public final int f22335b;

    /* renamed from: c, reason: collision with root package name */
    public final int f22336c;

    /* renamed from: d, reason: collision with root package name */
    public final float f22337d;

    /* renamed from: e, reason: collision with root package name */
    public final float f22338e;

    /* renamed from: f, reason: collision with root package name */
    public final float f22339f;

    /* renamed from: g, reason: collision with root package name */
    public final String f22340g;

    /* renamed from: h, reason: collision with root package name */
    public final String f22341h;

    /* renamed from: i, reason: collision with root package name */
    public Interpolator f22342i;

    /* renamed from: j, reason: collision with root package name */
    public ValueAnimator f22343j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f22344k;

    /* renamed from: l, reason: collision with root package name */
    public final Paint f22345l;

    /* renamed from: m, reason: collision with root package name */
    public int f22346m;

    /* renamed from: n, reason: collision with root package name */
    public float f22347n;

    /* renamed from: o, reason: collision with root package name */
    public float f22348o;

    /* renamed from: p, reason: collision with root package name */
    public float f22349p;

    /* renamed from: q, reason: collision with root package name */
    public final Rect f22350q;

    /* renamed from: r, reason: collision with root package name */
    public final float[] f22351r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedbackRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(attrs, "attrs");
        this.f22334a = 255;
        this.f22335b = 200;
        this.f22336c = 340;
        this.f22337d = 0.8f;
        this.f22338e = 0.92f;
        this.f22339f = 0.4f;
        this.f22340g = "brightnessHolder";
        this.f22341h = "scaleHolder";
        this.f22345l = new Paint(1);
        this.f22347n = 21.0f;
        this.f22348o = 1.0f;
        this.f22349p = 1.0f;
        this.f22350q = new Rect();
        this.f22351r = new float[3];
        COUIDarkModeUtil.setForceDarkAllow(this, false);
        this.f22347n = context.getResources().getDimensionPixelOffset(R.dimen.DP_20);
        this.f22346m = context.getColor(R.color.pb_color_dialpad_call_button_bg);
        f();
    }

    public static final void d(FeedbackRelativeLayout this$0, boolean z10, ValueAnimator animator) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.f(animator, "animator");
        Object animatedValue = animator.getAnimatedValue(this$0.f22341h);
        kotlin.jvm.internal.i.d(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.f22349p = ((Float) animatedValue).floatValue();
        if (this$0.f22344k && z10 && ((float) animator.getCurrentPlayTime()) > ((float) animator.getDuration()) * this$0.f22339f) {
            animator.cancel();
            this$0.c(false);
        } else {
            Object animatedValue2 = animator.getAnimatedValue(this$0.f22340g);
            kotlin.jvm.internal.i.d(animatedValue2, "null cannot be cast to non-null type kotlin.Float");
            this$0.f22348o = ((Float) animatedValue2).floatValue();
            this$0.setScale(this$0.f22349p);
        }
    }

    private final void setScale(float f10) {
        float max = Math.max(this.f22338e, Math.min(1.0f, f10));
        setScaleX(max);
        setScaleY(max);
        invalidate();
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003f, code lost:
    
        if (r5 < (((float) r0.longValue()) * r4.f22339f)) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(boolean r5) {
        /*
            r4 = this;
            android.animation.ValueAnimator r0 = r4.f22343j
            if (r0 == 0) goto L4e
            if (r0 == 0) goto L4e
            boolean r0 = r0.isRunning()
            r1 = 1
            if (r0 != r1) goto L4e
            if (r5 != 0) goto L42
            android.animation.ValueAnimator r5 = r4.f22343j
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
            android.animation.ValueAnimator r2 = r4.f22343j
            if (r2 == 0) goto L32
            long r2 = r2.getDuration()
            java.lang.Long r0 = java.lang.Long.valueOf(r2)
        L32:
            kotlin.jvm.internal.i.c(r0)
            long r2 = r0.longValue()
            float r0 = (float) r2
            float r2 = r4.f22339f
            float r0 = r0 * r2
            int r5 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r5 >= 0) goto L42
            goto L43
        L42:
            r1 = 0
        L43:
            r4.f22344k = r1
            if (r1 != 0) goto L4e
            android.animation.ValueAnimator r4 = r4.f22343j
            if (r4 == 0) goto L4e
            r4.cancel()
        L4e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.widget.FeedbackRelativeLayout.b(boolean):void");
    }

    public final void c(final boolean z10) {
        float f10;
        float f11;
        float f12;
        int i10;
        this.f22344k = false;
        b(z10);
        if (this.f22344k) {
            return;
        }
        String str = this.f22340g;
        float f13 = 1.0f;
        if (z10) {
            f10 = 1.0f;
        } else {
            f10 = this.f22348o;
        }
        if (z10) {
            f11 = this.f22337d;
        } else {
            f11 = 1.0f;
        }
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(str, f10, f11);
        String str2 = this.f22341h;
        if (z10) {
            f12 = 1.0f;
        } else {
            f12 = this.f22349p;
        }
        if (z10) {
            f13 = this.f22338e;
        }
        ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(ofFloat, PropertyValuesHolder.ofFloat(str2, f12, f13));
        this.f22343j = ofPropertyValuesHolder;
        if (ofPropertyValuesHolder != null) {
            ofPropertyValuesHolder.setInterpolator(this.f22342i);
        }
        ValueAnimator valueAnimator = this.f22343j;
        if (valueAnimator != null) {
            if (z10) {
                i10 = this.f22335b;
            } else {
                i10 = this.f22336c;
            }
            valueAnimator.setDuration(i10);
        }
        ValueAnimator valueAnimator2 = this.f22343j;
        if (valueAnimator2 != null) {
            valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.customize.contacts.widget.l
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    FeedbackRelativeLayout.d(FeedbackRelativeLayout.this, z10, valueAnimator3);
                }
            });
        }
        ValueAnimator valueAnimator3 = this.f22343j;
        if (valueAnimator3 != null) {
            valueAnimator3.start();
        }
    }

    public final int e(int i10) {
        B.a.m(i10, this.f22351r);
        float[] fArr = this.f22351r;
        fArr[2] = fArr[2] * this.f22348o;
        int a10 = B.a.a(fArr);
        return Color.argb(Color.alpha(i10), Math.min(this.f22334a, Color.red(a10)), Math.min(this.f22334a, Color.green(a10)), Math.min(this.f22334a, Color.blue(a10)));
    }

    public final void f() {
        this.f22342i = new PathInterpolator(0.4f, 0.0f, 0.2f, 1.0f);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        kotlin.jvm.internal.i.f(canvas, "canvas");
        if (isEnabled()) {
            int save = canvas.save();
            canvas.translate(getScrollX(), getScrollY());
            this.f22345l.setColor(e(this.f22346m));
            canvas.drawPath(COUIRoundRectUtil.getInstance().getPath(this.f22350q, this.f22347n), this.f22345l);
            canvas.restoreToCount(save);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        this.f22350q.right = getWidth();
        this.f22350q.bottom = getHeight();
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

    public final void setDrawableColor(int i10) {
        this.f22346m = i10;
    }

    public final void setRadius(float f10) {
        this.f22347n = f10;
    }
}
