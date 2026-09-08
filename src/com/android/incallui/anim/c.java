package com.android.incallui.anim;

import android.view.animation.Animation;

/* compiled from: InCallUIAnimationListener.java */
/* loaded from: classes.dex */
public class c extends a implements Animation.AnimationListener {
    public c(String str, Animation animation) {
        super(str, animation);
        if (animation != null) {
            this.mAnimationDuration = animation.getDuration();
        }
        LogD("create duration = " + this.mAnimationDuration);
    }

    public void onAnimationEnd(Animation animation) {
        LogD(" onAnimationEnd");
        removeCheckAnimationCompleteMsg();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
        LogD(" onAnimationRepeat");
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        LogD(" onAnimationStart");
        sendCheckAnimationCompleteMsg();
    }

    @Override // com.android.incallui.anim.a
    public void onAnimationTimeOut() {
        LogD(" onAnimationTimeOut ");
        Object obj = this.mAnimation;
        if (obj == null) {
            return;
        }
        onAnimationEnd((Animation) obj);
    }
}
