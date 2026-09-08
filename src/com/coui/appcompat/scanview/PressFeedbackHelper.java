package com.coui.appcompat.scanview;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.util.Property;
import android.view.View;
import android.view.animation.PathInterpolator;
import kotlin.jvm.internal.i;
import m9.q;
import v9.InterfaceC1637a;

/* compiled from: PressFeedbackHelper.kt */
/* loaded from: classes.dex */
public final class PressFeedbackHelper {
    private static final float ANIM_DOWN_PATH_X1 = 0.4f;
    private static final float ANIM_DOWN_PATH_X2 = 0.2f;
    private static final float ANIM_DOWN_PATH_Y1 = 0.0f;
    private static final float ANIM_DOWN_PATH_Y2 = 1.0f;
    private static final float ANIM_UP_PATH_X1 = 0.0f;
    private static final float ANIM_UP_PATH_X2 = 0.2f;
    private static final float ANIM_UP_PATH_Y1 = 0.0f;
    private static final float ANIM_UP_PATH_Y2 = 1.0f;
    public static final Companion Companion = new Companion(null);
    public static final long DOWN_ANIMATION_TIME = 200;
    private static final float SCALE_ANIM_VALUE_MAX = 1.0f;
    private static final float SCALE_ANIM_VALUE_MIN = 0.92f;
    private static final float SCALE_INIT_VALUE = 0.0f;
    public static final long UP_ANIMATION_TIME = 340;
    private float currentScale;
    private final PathInterpolator downPathInterpolator;
    private boolean isNeedToDelayCancelScaleAnim;
    private ObjectAnimator scaleAnimator;
    private final PathInterpolator upPathInterpolator;

    /* compiled from: PressFeedbackHelper.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public final PathInterpolator getDownPathInterpolator() {
            return new PathInterpolator(PressFeedbackHelper.ANIM_DOWN_PATH_X1, 0.0f, 0.2f, 1.0f);
        }

        public final PathInterpolator getUpPathInterpolator() {
            return new PathInterpolator(0.0f, 0.0f, 0.2f, 1.0f);
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: PressFeedbackHelper.kt */
    /* loaded from: classes.dex */
    public static final class ScaleAnimParam {
        private final long duration;
        private final PathInterpolator interpolator;
        private final float scaleXEnd;
        private final float scaleXStart;
        private final float scaleYEnd;
        private final float scaleYStart;

        public ScaleAnimParam(float f10, float f11, float f12, float f13, PathInterpolator interpolator, long j10) {
            i.f(interpolator, "interpolator");
            this.scaleXStart = f10;
            this.scaleXEnd = f11;
            this.scaleYStart = f12;
            this.scaleYEnd = f13;
            this.interpolator = interpolator;
            this.duration = j10;
        }

        public static /* synthetic */ ScaleAnimParam copy$default(ScaleAnimParam scaleAnimParam, float f10, float f11, float f12, float f13, PathInterpolator pathInterpolator, long j10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                f10 = scaleAnimParam.scaleXStart;
            }
            if ((i10 & 2) != 0) {
                f11 = scaleAnimParam.scaleXEnd;
            }
            float f14 = f11;
            if ((i10 & 4) != 0) {
                f12 = scaleAnimParam.scaleYStart;
            }
            float f15 = f12;
            if ((i10 & 8) != 0) {
                f13 = scaleAnimParam.scaleYEnd;
            }
            float f16 = f13;
            if ((i10 & 16) != 0) {
                pathInterpolator = scaleAnimParam.interpolator;
            }
            PathInterpolator pathInterpolator2 = pathInterpolator;
            if ((i10 & 32) != 0) {
                j10 = scaleAnimParam.duration;
            }
            return scaleAnimParam.copy(f10, f14, f15, f16, pathInterpolator2, j10);
        }

        public final float component1() {
            return this.scaleXStart;
        }

        public final float component2() {
            return this.scaleXEnd;
        }

        public final float component3() {
            return this.scaleYStart;
        }

        public final float component4() {
            return this.scaleYEnd;
        }

        public final PathInterpolator component5() {
            return this.interpolator;
        }

        public final long component6() {
            return this.duration;
        }

        public final ScaleAnimParam copy(float f10, float f11, float f12, float f13, PathInterpolator interpolator, long j10) {
            i.f(interpolator, "interpolator");
            return new ScaleAnimParam(f10, f11, f12, f13, interpolator, j10);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ScaleAnimParam)) {
                return false;
            }
            ScaleAnimParam scaleAnimParam = (ScaleAnimParam) obj;
            if (Float.compare(this.scaleXStart, scaleAnimParam.scaleXStart) == 0 && Float.compare(this.scaleXEnd, scaleAnimParam.scaleXEnd) == 0 && Float.compare(this.scaleYStart, scaleAnimParam.scaleYStart) == 0 && Float.compare(this.scaleYEnd, scaleAnimParam.scaleYEnd) == 0 && i.b(this.interpolator, scaleAnimParam.interpolator) && this.duration == scaleAnimParam.duration) {
                return true;
            }
            return false;
        }

        public final long getDuration() {
            return this.duration;
        }

        public final PathInterpolator getInterpolator() {
            return this.interpolator;
        }

        public final float getScaleXEnd() {
            return this.scaleXEnd;
        }

        public final float getScaleXStart() {
            return this.scaleXStart;
        }

        public final float getScaleYEnd() {
            return this.scaleYEnd;
        }

        public final float getScaleYStart() {
            return this.scaleYStart;
        }

        public int hashCode() {
            return (((((((((Float.hashCode(this.scaleXStart) * 31) + Float.hashCode(this.scaleXEnd)) * 31) + Float.hashCode(this.scaleYStart)) * 31) + Float.hashCode(this.scaleYEnd)) * 31) + this.interpolator.hashCode()) * 31) + Long.hashCode(this.duration);
        }

        public String toString() {
            return "ScaleAnimParam(scaleXStart=" + this.scaleXStart + ", scaleXEnd=" + this.scaleXEnd + ", scaleYStart=" + this.scaleYStart + ", scaleYEnd=" + this.scaleYEnd + ", interpolator=" + this.interpolator + ", duration=" + this.duration + ')';
        }
    }

    public PressFeedbackHelper() {
        Companion companion = Companion;
        this.downPathInterpolator = companion.getDownPathInterpolator();
        this.upPathInterpolator = companion.getUpPathInterpolator();
    }

    private final void cancelAnimator(boolean z10) {
        boolean z11;
        ObjectAnimator objectAnimator = this.scaleAnimator;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            float currentPlayTime = (float) objectAnimator.getCurrentPlayTime();
            float duration = ((float) objectAnimator.getDuration()) * ANIM_DOWN_PATH_X1;
            if (!z10 && currentPlayTime < duration) {
                z11 = true;
            } else {
                z11 = false;
            }
            this.isNeedToDelayCancelScaleAnim = z11;
            if (!z11) {
                objectAnimator.cancel();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void executeScaleAnimator$default(PressFeedbackHelper pressFeedbackHelper, boolean z10, View view, InterfaceC1637a interfaceC1637a, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            interfaceC1637a = new InterfaceC1637a<q>() { // from class: com.coui.appcompat.scanview.PressFeedbackHelper$executeScaleAnimator$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // v9.InterfaceC1637a
                public /* bridge */ /* synthetic */ q invoke() {
                    invoke2();
                    return q.f35511a;
                }
            };
        }
        pressFeedbackHelper.executeScaleAnimator(z10, view, interfaceC1637a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void executeScaleAnimator$lambda$2$lambda$0(PressFeedbackHelper this$0, boolean z10, View view, ValueAnimator valueAnimator) {
        i.f(this$0, "this$0");
        i.f(view, "$view");
        Object animatedValue = valueAnimator.getAnimatedValue("scaleX");
        i.d(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.currentScale = ((Float) animatedValue).floatValue();
        if (this$0.isNeedToDelayCancelScaleAnim && z10 && ((float) valueAnimator.getCurrentPlayTime()) > ((float) valueAnimator.getDuration()) * ANIM_DOWN_PATH_X1) {
            valueAnimator.cancel();
            executeScaleAnimator$default(this$0, false, view, null, 4, null);
        } else {
            this$0.setScaleLayout(this$0.currentScale, view);
        }
    }

    private final ScaleAnimParam getScaleAnimParma(boolean z10) {
        if (z10) {
            return new ScaleAnimParam(1.0f, SCALE_ANIM_VALUE_MIN, 1.0f, SCALE_ANIM_VALUE_MIN, this.downPathInterpolator, 200L);
        }
        float f10 = this.currentScale;
        return new ScaleAnimParam(f10, 1.0f, f10, 1.0f, this.upPathInterpolator, 340L);
    }

    private final void setScaleLayout(float f10, View view) {
        float d10;
        float a10;
        d10 = B9.i.d(1.0f, f10);
        a10 = B9.i.a(SCALE_ANIM_VALUE_MIN, d10);
        view.setScaleX(a10);
        view.setScaleY(a10);
        view.invalidate();
    }

    public final void executeScaleAnimator(final boolean z10, final View view, final InterfaceC1637a<q> onAnimEnd) {
        i.f(view, "view");
        i.f(onAnimEnd, "onAnimEnd");
        this.isNeedToDelayCancelScaleAnim = false;
        cancelAnimator(z10);
        if (!this.isNeedToDelayCancelScaleAnim) {
            ScaleAnimParam scaleAnimParma = getScaleAnimParma(z10);
            ObjectAnimator executeScaleAnimator$lambda$2 = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_X, scaleAnimParma.getScaleXStart(), scaleAnimParma.getScaleXEnd()), PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_Y, scaleAnimParma.getScaleYStart(), scaleAnimParma.getScaleYEnd()));
            this.scaleAnimator = executeScaleAnimator$lambda$2;
            executeScaleAnimator$lambda$2.setInterpolator(scaleAnimParma.getInterpolator());
            executeScaleAnimator$lambda$2.setDuration(scaleAnimParma.getDuration());
            executeScaleAnimator$lambda$2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.scanview.d
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    PressFeedbackHelper.executeScaleAnimator$lambda$2$lambda$0(PressFeedbackHelper.this, z10, view, valueAnimator);
                }
            });
            i.e(executeScaleAnimator$lambda$2, "executeScaleAnimator$lambda$2");
            executeScaleAnimator$lambda$2.addListener(new Animator.AnimatorListener() { // from class: com.coui.appcompat.scanview.PressFeedbackHelper$executeScaleAnimator$lambda$2$$inlined$doOnEnd$1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    i.f(animator, "animator");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    i.f(animator, "animator");
                    InterfaceC1637a.this.invoke();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                    i.f(animator, "animator");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    i.f(animator, "animator");
                }
            });
            executeScaleAnimator$lambda$2.start();
        }
    }
}
