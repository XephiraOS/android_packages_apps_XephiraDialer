package com.android.incallui.anim;

import android.animation.Animator;
import android.animation.ValueAnimator;

/* compiled from: InCallUIAnimatorListener.java */
/* loaded from: classes.dex */
public class d extends a implements ValueAnimator.AnimatorUpdateListener, Animator.AnimatorListener {
    public d(String str, Animator animator) {
        super(str, animator);
        if (animator != null) {
            this.mAnimationDuration = animator.getDuration();
        } else {
            this.mAnimationDuration = 0L;
        }
        LogD("create duration = " + this.mAnimationDuration);
    }

    public void onAnimationEnd(Animator animator) {
        LogD("InCallUIAnimatorListener onAnimationEnd ");
        removeCheckAnimationCompleteMsg();
        setAnimationRunning(false);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        LogD("InCallUIAnimatorListener onAnimationStart ");
        setAnimationRunning(true);
        if (this.mAnimationDuration != 0) {
            sendCheckAnimationCompleteMsg();
        }
    }

    @Override // com.android.incallui.anim.a
    public void onAnimationTimeOut() {
        LogD(" onAnimationTimeOut ");
        Object obj = this.mAnimation;
        if (obj == null) {
            return;
        }
        onAnimationEnd((Animator) obj);
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        LogD("InCallUIAnimatorListener  onAnimationUpdate ");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }
}
