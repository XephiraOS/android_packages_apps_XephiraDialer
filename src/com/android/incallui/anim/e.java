package com.android.incallui.anim;

import android.animation.Animator;
import android.view.ViewPropertyAnimator;
import kotlin.jvm.internal.i;

/* compiled from: InCallUIViewPropertyAnimator.kt */
/* loaded from: classes.dex */
public class e extends a implements Animator.AnimatorListener {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(String name, ViewPropertyAnimator anim) {
        super(name);
        i.f(name, "name");
        i.f(anim, "anim");
        this.mAnimationDuration = anim.getDuration();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        i.f(animator, "animator");
        LogD("onAnimationEnd");
        removeCheckAnimationCompleteMsg();
        setAnimationRunning(false);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        i.f(animator, "animator");
        LogD("onAnimationRepeat");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        i.f(animator, "animator");
        LogD("onAnimationStart");
        setAnimation(animator);
        setAnimationRunning(true);
        if (this.mAnimationDuration != 0) {
            sendCheckAnimationCompleteMsg();
        }
    }

    @Override // com.android.incallui.anim.a
    public void onAnimationTimeOut() {
        Animator animator;
        LogD("onAnimationTimeOut");
        Object obj = this.mAnimation;
        if (obj == null) {
            return;
        }
        if (obj instanceof Animator) {
            animator = (Animator) obj;
        } else {
            animator = null;
        }
        if (animator != null) {
            onAnimationEnd(animator);
        }
    }
}
