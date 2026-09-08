package com.android.contacts.framework.baseui.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.coui.appcompat.animation.COUILinearInterpolator;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;

/* compiled from: FlashProgressBar.kt */
/* loaded from: classes.dex */
public final class FlashProgressBar extends ProgressBar {

    /* renamed from: i, reason: collision with root package name */
    public static final a f16027i = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final Bitmap f16028a;

    /* renamed from: b, reason: collision with root package name */
    public ValueAnimator f16029b;

    /* renamed from: c, reason: collision with root package name */
    public float f16030c;

    /* renamed from: d, reason: collision with root package name */
    public final Paint f16031d;

    /* renamed from: e, reason: collision with root package name */
    public int f16032e;

    /* renamed from: f, reason: collision with root package name */
    public final int f16033f;

    /* renamed from: g, reason: collision with root package name */
    public final Rect f16034g;

    /* renamed from: h, reason: collision with root package name */
    public final Rect f16035h;

    /* compiled from: FlashProgressBar.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: FlashProgressBar.kt */
    /* loaded from: classes.dex */
    public static final class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            kotlin.jvm.internal.i.f(animator, "animator");
            if (FlashProgressBar.this.getProgress() == FlashProgressBar.this.getMax() && FlashProgressBar.this.f16029b != null) {
                ValueAnimator valueAnimator = FlashProgressBar.this.f16029b;
                kotlin.jvm.internal.i.c(valueAnimator);
                valueAnimator.removeAllListeners();
                valueAnimator.removeAllUpdateListeners();
                valueAnimator.cancel();
                FlashProgressBar.this.f16029b = null;
                return;
            }
            if (FlashProgressBar.this.f16029b != null) {
                ValueAnimator valueAnimator2 = FlashProgressBar.this.f16029b;
                kotlin.jvm.internal.i.c(valueAnimator2);
                valueAnimator2.start();
            }
        }
    }

    public FlashProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public static final void e(FlashProgressBar this$0, ValueAnimator valueAnimator) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.f(valueAnimator, "valueAnimator");
        Object animatedValue = valueAnimator.getAnimatedValue();
        kotlin.jvm.internal.i.d(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.f16030c = ((Float) animatedValue).floatValue();
        this$0.invalidate();
    }

    private final int getScreenWidth() {
        if (this.f16032e == 0) {
            this.f16032e = getContext().getResources().getDisplayMetrics().widthPixels;
        }
        return this.f16032e;
    }

    public final void d() {
        ValueAnimator valueAnimator;
        if (this.f16029b == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, getScreenWidth());
            ofFloat.setDuration(800L);
            ofFloat.setInterpolator(new COUILinearInterpolator());
            ofFloat.setStartDelay(200L);
            this.f16029b = ofFloat;
            ofFloat.addListener(new b());
            ValueAnimator valueAnimator2 = this.f16029b;
            if (valueAnimator2 != null) {
                valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.android.contacts.framework.baseui.widget.h
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                        FlashProgressBar.e(FlashProgressBar.this, valueAnimator3);
                    }
                });
            }
        }
        ValueAnimator valueAnimator3 = this.f16029b;
        if (valueAnimator3 != null && !valueAnimator3.isRunning() && (valueAnimator = this.f16029b) != null) {
            valueAnimator.start();
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.f16029b;
        if (valueAnimator != null) {
            if (valueAnimator != null) {
                valueAnimator.removeAllListeners();
                valueAnimator.removeAllUpdateListeners();
                valueAnimator.cancel();
            }
            this.f16029b = null;
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDraw(Canvas canvas) {
        kotlin.jvm.internal.i.f(canvas, "canvas");
        super.onDraw(canvas);
        ValueAnimator valueAnimator = this.f16029b;
        if (valueAnimator != null && valueAnimator != null && valueAnimator.isRunning()) {
            float progress = (getProgress() * getWidth()) / getMax();
            float f10 = this.f16030c;
            if (f10 <= progress) {
                if (this.f16033f + f10 <= progress) {
                    canvas.drawBitmap(this.f16028a, f10, 0.0f, this.f16031d);
                    return;
                }
                Rect rect = this.f16034g;
                rect.left = (int) f10;
                rect.right = (int) progress;
                canvas.drawBitmap(this.f16028a, rect, this.f16035h, this.f16031d);
            }
        }
    }

    @Override // android.widget.ProgressBar
    public void setProgress(int i10) {
        int progress = getProgress();
        super.setProgress(i10);
        if (progress == getProgress()) {
            return;
        }
        d();
    }

    public /* synthetic */ FlashProgressBar(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.f fVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    public FlashProgressBar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        COUIDarkModeUtil.setForceDarkAllow(this, false);
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), N0.g.f1907g);
        kotlin.jvm.internal.i.e(decodeResource, "decodeResource(resources, R.drawable.line)");
        this.f16028a = decodeResource;
        this.f16033f = decodeResource.getWidth();
        int height = decodeResource.getHeight();
        Paint paint = new Paint();
        this.f16031d = paint;
        if (COUIDarkModeUtil.isNightMode(context)) {
            paint.setAlpha(127);
        }
        Rect rect = new Rect();
        rect.left = 0;
        rect.top = 0;
        rect.bottom = height;
        this.f16034g = rect;
        Rect rect2 = new Rect();
        rect2.top = 0;
        rect2.bottom = height;
        this.f16035h = rect2;
    }

    @Override // android.widget.ProgressBar
    public void setProgress(int i10, boolean z10) {
        int progress = getProgress();
        super.setProgress(i10, z10);
        if (progress == getProgress()) {
            return;
        }
        d();
    }
}
