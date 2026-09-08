package com.coui.appcompat.progressbar;

import X8.m;
import X8.o;
import android.animation.Animator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import com.oplus.anim.EffectiveAnimationView;

/* loaded from: classes.dex */
public class COUILottieLoadingView extends FrameLayout {
    private final EffectiveAnimationView mLoadingView;

    public COUILottieLoadingView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pauseAnimation() {
        EffectiveAnimationView effectiveAnimationView = this.mLoadingView;
        if (effectiveAnimationView != null && effectiveAnimationView.isAnimating()) {
            this.mLoadingView.pauseAnimation();
        }
    }

    private void resumeAnimation() {
        EffectiveAnimationView effectiveAnimationView = this.mLoadingView;
        if (effectiveAnimationView != null && !effectiveAnimationView.isAnimating()) {
            this.mLoadingView.resumeAnimation();
        }
    }

    public EffectiveAnimationView getLoadingView() {
        return this.mLoadingView;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        resumeAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        pauseAnimation();
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        if (getVisibility() == 0) {
            resumeAnimation();
        } else {
            pauseAnimation();
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        if (i10 == 0) {
            resumeAnimation();
        } else {
            pauseAnimation();
        }
    }

    public COUILottieLoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, X8.c.f4363V);
    }

    public COUILottieLoadingView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        COUIDarkModeUtil.setForceDarkAllow(this, false);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o.f5297e3, i10, 0);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(o.f5321h3, getResources().getDimensionPixelOffset(X8.f.f4506G2));
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(o.f5313g3, getResources().getDimensionPixelOffset(X8.f.f4499F2));
        String string = obtainStyledAttributes.getString(o.f5305f3);
        string = string == null ? getResources().getString(m.f5008g) : string;
        obtainStyledAttributes.recycle();
        EffectiveAnimationView effectiveAnimationView = new EffectiveAnimationView(context);
        this.mLoadingView = effectiveAnimationView;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize2);
        layoutParams.gravity = 17;
        effectiveAnimationView.setLayoutParams(layoutParams);
        effectiveAnimationView.setRepeatCount(-1);
        effectiveAnimationView.setAnimation(string);
        effectiveAnimationView.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.coui.appcompat.progressbar.COUILottieLoadingView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                if (COUILottieLoadingView.this.getVisibility() != 0 || COUILottieLoadingView.this.mLoadingView.getVisibility() != 0 || COUILottieLoadingView.this.getWindowVisibility() != 0) {
                    COUILottieLoadingView.this.pauseAnimation();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        addView(effectiveAnimationView);
    }
}
