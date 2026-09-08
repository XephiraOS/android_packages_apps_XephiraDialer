package com.android.incallui.oplus.answerview.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.android.incallui.R;
import com.android.incallui.oplus.answerview.protocol.VoiceAnswerBtnBehavior;
import com.android.incallui.oplus.answerview.view.j;
import com.android.internal.annotations.VisibleForTesting;
import h2.C1076a;
import kotlin.LazyThreadSafetyMode;
import v9.InterfaceC1637a;

/* compiled from: SwipeAnswerImageView.kt */
/* loaded from: classes.dex */
public class SwipeAnswerImageView extends StaticAnswerImageView implements j.c {

    /* renamed from: C, reason: collision with root package name */
    public static final a f18802C = new a(null);

    /* renamed from: A, reason: collision with root package name */
    public ViewPropertyAnimator f18803A;

    /* renamed from: B, reason: collision with root package name */
    public final m9.d f18804B;

    /* renamed from: h, reason: collision with root package name */
    public com.android.incallui.oplus.answerview.protocol.a f18805h;

    /* renamed from: i, reason: collision with root package name */
    public j f18806i;

    /* renamed from: j, reason: collision with root package name */
    public j.c f18807j;

    /* renamed from: k, reason: collision with root package name */
    public final float f18808k;

    /* renamed from: l, reason: collision with root package name */
    public final float f18809l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f18810m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f18811n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f18812o;

    /* renamed from: p, reason: collision with root package name */
    public Paint f18813p;

    /* renamed from: q, reason: collision with root package name */
    public float f18814q;

    /* renamed from: r, reason: collision with root package name */
    public int f18815r;

    /* renamed from: x, reason: collision with root package name */
    public float f18816x;

    /* renamed from: y, reason: collision with root package name */
    public float f18817y;

    /* renamed from: z, reason: collision with root package name */
    public ViewPropertyAnimator f18818z;

    /* compiled from: SwipeAnswerImageView.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public final void a(SwipeAnswerImageView swipeAnswerImageView) {
            if (swipeAnswerImageView != null) {
                j.f18835l.f(swipeAnswerImageView.getMAnswerImageViewHelper());
            }
        }

        public final void b(SwipeAnswerImageView swipeAnswerImageView, j.c cVar) {
            if (swipeAnswerImageView != null) {
                swipeAnswerImageView.setMProgressListener(cVar);
            }
        }

        public final void c(SwipeAnswerImageView swipeAnswerImageView, boolean z10) {
            if (swipeAnswerImageView != null) {
                j.f18835l.g(swipeAnswerImageView.getMAnswerImageViewHelper(), z10);
            }
        }

        public final void d(SwipeAnswerImageView swipeAnswerImageView) {
            if (swipeAnswerImageView != null) {
                swipeAnswerImageView.setMHasForceStopWaveAnimation(false);
                SwipeAnswerImageView.y(swipeAnswerImageView, 0L, 1, null);
            }
        }

        public final void e(SwipeAnswerImageView swipeAnswerImageView) {
            if (swipeAnswerImageView != null) {
                j.f18835l.h(swipeAnswerImageView.getMAnswerImageViewHelper());
            }
        }

        public final void f(SwipeAnswerImageView swipeAnswerImageView) {
            if (swipeAnswerImageView != null) {
                swipeAnswerImageView.C();
            }
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwipeAnswerImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        m9.d a10;
        kotlin.jvm.internal.i.f(context, "context");
        j.a aVar = j.f18835l;
        this.f18806i = aVar.c();
        a10 = kotlin.a.a(LazyThreadSafetyMode.f34161a, new InterfaceC1637a<ObjectAnimator>() { // from class: com.android.incallui.oplus.answerview.view.SwipeAnswerImageView$mWaveAnimation$2

            /* compiled from: SwipeAnswerImageView.kt */
            /* loaded from: classes.dex */
            public static final class a extends AnimatorListenerAdapter {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ SwipeAnswerImageView f18819a;

                public a(SwipeAnswerImageView swipeAnswerImageView) {
                    this.f18819a = swipeAnswerImageView;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    this.f18819a.x(750L);
                }
            }

            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final ObjectAnimator invoke() {
                ObjectAnimator c10 = C1076a.f32047a.c(SwipeAnswerImageView.this);
                c10.addListener(new a(SwipeAnswerImageView.this));
                return c10;
            }
        });
        this.f18804B = a10;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SwipeButtonViewStyle, i10, 0);
        float dimension = obtainStyledAttributes.getDimension(R.styleable.SwipeButtonViewStyle_swipeRegionMaxTransY, context.getResources().getDimension(R.dimen.fling_up_answer_method_swipe_view_max_translation_y));
        this.f18808k = dimension;
        float f10 = (3 * dimension) / 4;
        this.f18809l = f10;
        this.f18816x = obtainStyledAttributes.getDimension(R.styleable.SwipeButtonViewStyle_swipeViewWidth, context.getResources().getDimension(R.dimen.fling_up_answer_method_swipe_view_width));
        this.f18817y = obtainStyledAttributes.getDimension(R.styleable.SwipeButtonViewStyle_swipeBtnViewSize, context.getResources().getDimension(R.dimen.incall_answer_method_swipe_btn_size));
        obtainStyledAttributes.recycle();
        aVar.d(this.f18806i, f10, dimension);
        Log.d("SwipeAnswerImageView", "init: mMaxTranslationY = " + dimension + ", mMinTriggerTranslationY = " + f10 + ", mSwipeViewSize = " + this.f18816x + ", mSwipeViewIconSize = " + this.f18817y);
    }

    public static final void r(SwipeAnswerImageView this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        j.c cVar = this$0.f18807j;
        if (cVar != null) {
            cVar.a();
        }
    }

    public static /* synthetic */ void t(SwipeAnswerImageView swipeAnswerImageView, Runnable runnable, int i10, Object obj) {
        if (obj == null) {
            if ((i10 & 1) != 0) {
                runnable = null;
            }
            swipeAnswerImageView.s(runnable);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startFallBackAnimation");
    }

    public static final void u(SwipeAnswerImageView this$0, ValueAnimator valueAnimator) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.e(j.f18835l.e(this$0.getTranslationY(), this$0.f18809l));
    }

    public static final void w(SwipeAnswerImageView this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        t(this$0, null, 1, null);
    }

    public static /* synthetic */ void y(SwipeAnswerImageView swipeAnswerImageView, long j10, int i10, Object obj) {
        if (obj == null) {
            if ((i10 & 1) != 0) {
                j10 = 0;
            }
            swipeAnswerImageView.x(j10);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startWaveAnimation");
    }

    @VisibleForTesting
    public final void A() {
        ViewPropertyAnimator updateListener;
        ViewPropertyAnimator listener;
        ViewPropertyAnimator viewPropertyAnimator = this.f18818z;
        if (viewPropertyAnimator != null && (updateListener = viewPropertyAnimator.setUpdateListener(null)) != null && (listener = updateListener.setListener(null)) != null) {
            listener.cancel();
        }
        this.f18818z = null;
    }

    @VisibleForTesting
    public final void B() {
        ViewPropertyAnimator updateListener;
        ViewPropertyAnimator listener;
        ViewPropertyAnimator viewPropertyAnimator = this.f18803A;
        if (viewPropertyAnimator != null && (updateListener = viewPropertyAnimator.setUpdateListener(null)) != null && (listener = updateListener.setListener(null)) != null) {
            listener.cancel();
        }
        this.f18803A = null;
    }

    @VisibleForTesting
    public final void C() {
        this.f18812o = true;
        ObjectAnimator mWaveAnimation = getMWaveAnimation();
        if (mWaveAnimation != null) {
            mWaveAnimation.cancel();
        }
    }

    @VisibleForTesting
    public final void D(float f10) {
        Paint paint = this.f18813p;
        if (paint != null) {
            float f11 = this.f18817y;
            float f12 = 2;
            this.f18814q = (f11 / f12) + (((this.f18816x / f12) - (f11 / f12)) * f10);
            if (f10 <= 0.1f) {
                this.f18815r = (int) ((76 * f10) / 0.1f);
            } else {
                this.f18815r = 76;
            }
            paint.setAlpha(this.f18815r);
            invalidate();
        }
    }

    @Override // com.android.incallui.oplus.answerview.view.j.c
    @VisibleForTesting
    public void a() {
        s(new Runnable() { // from class: com.android.incallui.oplus.answerview.view.g
            @Override // java.lang.Runnable
            public final void run() {
                SwipeAnswerImageView.r(SwipeAnswerImageView.this);
            }
        });
    }

    @Override // com.android.incallui.oplus.answerview.view.j.c
    @VisibleForTesting
    public void b(View view, int i10) {
        v();
        j.c cVar = this.f18807j;
        if (cVar != null) {
            cVar.b(this, i10);
        }
    }

    @Override // com.android.incallui.oplus.answerview.view.j.c
    @VisibleForTesting
    public void d() {
        j.c cVar = this.f18807j;
        if (cVar != null) {
            cVar.d();
        }
    }

    @Override // com.android.incallui.oplus.answerview.view.j.c
    @VisibleForTesting
    public void e(float f10) {
        float d10;
        if (this.f18810m) {
            d10 = B9.i.d(Math.abs(f10 * 135.0f), 135.0f);
            setRotation(d10);
        }
        D(f10);
        j.c cVar = this.f18807j;
        if (cVar != null) {
            cVar.e(f10);
        }
    }

    @Override // com.android.incallui.oplus.answerview.view.j.c
    @VisibleForTesting
    public void f() {
        j.c cVar = this.f18807j;
        if (cVar != null) {
            cVar.f();
        }
    }

    public final j getMAnswerImageViewHelper() {
        return this.f18806i;
    }

    public final int getMDiffuseCircleAlpha() {
        return this.f18815r;
    }

    public final Paint getMDiffuseCirclePaint() {
        return this.f18813p;
    }

    public final float getMDiffuseCircleRadius() {
        return this.f18814q;
    }

    public final ViewPropertyAnimator getMFallBackAnimation() {
        return this.f18818z;
    }

    public final boolean getMHasForceStopWaveAnimation() {
        return this.f18812o;
    }

    public final ViewPropertyAnimator getMHideAnimation() {
        return this.f18803A;
    }

    public final boolean getMIsNeedRotation() {
        return this.f18810m;
    }

    public final boolean getMIsNeedWaveAnimation() {
        return this.f18811n;
    }

    public final j.c getMProgressListener() {
        return this.f18807j;
    }

    public final float getMSwipeViewIconSize() {
        return this.f18817y;
    }

    public final float getMSwipeViewSize() {
        return this.f18816x;
    }

    @Override // com.android.incallui.oplus.answerview.view.StaticAnswerImageView, g2.InterfaceC1038e
    public com.android.incallui.oplus.answerview.protocol.a getMViewUserAction() {
        return this.f18805h;
    }

    public final ObjectAnimator getMWaveAnimation() {
        return (ObjectAnimator) this.f18804B.getValue();
    }

    @VisibleForTesting
    public final void o(Canvas canvas) {
        kotlin.jvm.internal.i.f(canvas, "canvas");
        if (this.f18813p != null && getTranslationY() != 0.0f) {
            float f10 = this.f18816x;
            float f11 = 2;
            canvas.drawCircle(f10 / f11, f10 / f11, this.f18814q, this.f18813p);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        f18802C.a(this);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        j.f18835l.b(this, this.f18806i);
        z();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        kotlin.jvm.internal.i.f(canvas, "canvas");
        o(canvas);
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        j.f18835l.a(this.f18806i, this, this);
    }

    public final void p(int i10) {
        try {
            q(getContext().getResources().getColor(i10, null));
        } catch (Resources.NotFoundException e10) {
            Log.d("SwipeAnswerImageView", "init: e = " + e10.getMessage());
        }
    }

    @VisibleForTesting
    public final void q(int i10) {
        Paint paint = new Paint(1);
        this.f18813p = paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setAlpha(0);
        paint.setColor(i10);
    }

    @VisibleForTesting
    public final void s(Runnable runnable) {
        A();
        this.f18818z = C1076a.f32047a.a(this).setUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.android.incallui.oplus.answerview.view.i
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SwipeAnswerImageView.u(SwipeAnswerImageView.this, valueAnimator);
            }
        }).withEndAction(runnable);
    }

    @Override // android.view.View
    @VisibleForTesting
    public void setAlpha(float f10) {
        if (getTranslationY() == 0.0f) {
            super.setAlpha(f10);
        }
    }

    public final void setMAnswerImageViewHelper(j jVar) {
        kotlin.jvm.internal.i.f(jVar, "<set-?>");
        this.f18806i = jVar;
    }

    public final void setMDiffuseCircleAlpha(int i10) {
        this.f18815r = i10;
    }

    public final void setMDiffuseCirclePaint(Paint paint) {
        this.f18813p = paint;
    }

    public final void setMDiffuseCircleRadius(float f10) {
        this.f18814q = f10;
    }

    public final void setMFallBackAnimation(ViewPropertyAnimator viewPropertyAnimator) {
        this.f18818z = viewPropertyAnimator;
    }

    public final void setMHasForceStopWaveAnimation(boolean z10) {
        this.f18812o = z10;
    }

    public final void setMHideAnimation(ViewPropertyAnimator viewPropertyAnimator) {
        this.f18803A = viewPropertyAnimator;
    }

    public final void setMIsNeedRotation(boolean z10) {
        this.f18810m = z10;
    }

    public final void setMIsNeedWaveAnimation(boolean z10) {
        this.f18811n = z10;
    }

    public final void setMProgressListener(j.c cVar) {
        this.f18807j = cVar;
    }

    public final void setMSwipeViewIconSize(float f10) {
        this.f18817y = f10;
    }

    public final void setMSwipeViewSize(float f10) {
        this.f18816x = f10;
    }

    @Override // com.android.incallui.oplus.answerview.view.StaticAnswerImageView, g2.InterfaceC1038e
    public void setMViewUserAction(com.android.incallui.oplus.answerview.protocol.a aVar) {
        VoiceAnswerBtnBehavior voiceAnswerBtnBehavior;
        this.f18805h = aVar;
        if (aVar instanceof VoiceAnswerBtnBehavior) {
            voiceAnswerBtnBehavior = (VoiceAnswerBtnBehavior) aVar;
        } else {
            voiceAnswerBtnBehavior = null;
        }
        if (voiceAnswerBtnBehavior != null) {
            this.f18811n = voiceAnswerBtnBehavior.e();
            this.f18810m = voiceAnswerBtnBehavior.d();
        }
    }

    @VisibleForTesting
    public final void v() {
        B();
        this.f18803A = C1076a.f32047a.b(this).withEndAction(new Runnable() { // from class: com.android.incallui.oplus.answerview.view.h
            @Override // java.lang.Runnable
            public final void run() {
                SwipeAnswerImageView.w(SwipeAnswerImageView.this);
            }
        });
    }

    @VisibleForTesting
    public final void x(long j10) {
        if (this.f18811n && !this.f18812o) {
            ObjectAnimator mWaveAnimation = getMWaveAnimation();
            if (mWaveAnimation != null) {
                mWaveAnimation.setStartDelay(j10);
            }
            ObjectAnimator mWaveAnimation2 = getMWaveAnimation();
            if (mWaveAnimation2 != null) {
                mWaveAnimation2.start();
            }
        }
    }

    @VisibleForTesting
    public final void z() {
        A();
        B();
        C();
    }

    @VisibleForTesting
    public static /* synthetic */ void getMAnswerImageViewHelper$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getMDiffuseCircleAlpha$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getMDiffuseCirclePaint$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getMDiffuseCircleRadius$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getMFallBackAnimation$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getMHasForceStopWaveAnimation$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getMHideAnimation$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getMIsNeedRotation$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getMIsNeedWaveAnimation$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getMProgressListener$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getMSwipeViewIconSize$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getMSwipeViewSize$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getMWaveAnimation$annotations() {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SwipeAnswerImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        kotlin.jvm.internal.i.f(context, "context");
    }
}
