package com.coui.appcompat.tips;

import X8.c;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.coui.appcompat.cardview.COUICardView;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import com.coui.appcompat.roundcorner.RoundCornerUtil;

/* loaded from: classes3.dex */
public abstract class COUICustomTopTips extends COUICardView {
    private Animator.AnimatorListener mAnimatorDismissListener;
    private AnimatorSet mAnimatorSetDismiss;
    private AnimatorSet mAnimatorSetShow;
    private Animator.AnimatorListener mAnimatorShowListener;
    private View mView;

    public COUICustomTopTips(Context context) {
        this(context, null);
    }

    public void dismissWithAnim() {
        if (this.mAnimatorSetDismiss == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "scaleY", 1.0f, 0.0f);
            ofFloat.setDuration(250L);
            AnimatorSet animatorSet = new AnimatorSet();
            this.mAnimatorSetDismiss = animatorSet;
            animatorSet.play(ofFloat);
        }
        this.mAnimatorSetDismiss.addListener(new Animator.AnimatorListener() { // from class: com.coui.appcompat.tips.COUICustomTopTips.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (COUICustomTopTips.this.mAnimatorDismissListener != null) {
                    COUICustomTopTips.this.mAnimatorDismissListener.onAnimationCancel(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (COUICustomTopTips.this.mAnimatorDismissListener != null) {
                    COUICustomTopTips.this.mAnimatorDismissListener.onAnimationEnd(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                if (COUICustomTopTips.this.mAnimatorDismissListener != null) {
                    COUICustomTopTips.this.mAnimatorDismissListener.onAnimationRepeat(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (COUICustomTopTips.this.mAnimatorDismissListener != null) {
                    COUICustomTopTips.this.mAnimatorDismissListener.onAnimationStart(animator);
                }
            }
        });
        this.mAnimatorSetDismiss.start();
    }

    public AnimatorSet getAnimatorSetDismiss() {
        return this.mAnimatorSetDismiss;
    }

    public AnimatorSet getAnimatorSetShow() {
        return this.mAnimatorSetShow;
    }

    public View getContentView() {
        return this.mView;
    }

    public abstract int getContentViewId();

    public void init() {
        COUIDarkModeUtil.setForceDarkAllow(this, false);
        setContentView(getContentViewId());
        if (RoundCornerUtil.isVersionSupport()) {
            setRadius(COUIContextUtil.getAttrDimens(getContext(), c.f4375d0));
            setWeight(COUIContextUtil.getAttrFloat(getContext(), c.f4377e0));
        } else {
            setRadius(COUIContextUtil.getAttrDimens(getContext(), c.f4373c0));
        }
        setCardBackgroundColor(ColorStateList.valueOf(COUIContextUtil.getAttrColor(getContext(), c.f4406t)));
    }

    public void setAnimatorDismissListener(Animator.AnimatorListener animatorListener) {
        this.mAnimatorDismissListener = animatorListener;
    }

    public void setAnimatorSetDismiss(AnimatorSet animatorSet) {
        this.mAnimatorSetDismiss = animatorSet;
    }

    public void setAnimatorSetShow(AnimatorSet animatorSet) {
        this.mAnimatorSetShow = animatorSet;
    }

    public void setAnimatorShowListener(Animator.AnimatorListener animatorListener) {
        this.mAnimatorShowListener = animatorListener;
    }

    public void setContentView(View view) {
        if (this.mView == null) {
            this.mView = view;
            addView(view);
            return;
        }
        throw new RuntimeException("Repeat calls are not allowed!!");
    }

    public void showWithAnim() {
        if (this.mAnimatorSetShow == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "scaleY", 0.0f, 1.0f);
            ofFloat.setDuration(250L);
            AnimatorSet animatorSet = new AnimatorSet();
            this.mAnimatorSetShow = animatorSet;
            animatorSet.play(ofFloat);
        }
        this.mAnimatorSetShow.addListener(new Animator.AnimatorListener() { // from class: com.coui.appcompat.tips.COUICustomTopTips.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (COUICustomTopTips.this.mAnimatorShowListener != null) {
                    COUICustomTopTips.this.mAnimatorShowListener.onAnimationCancel(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (COUICustomTopTips.this.mAnimatorShowListener != null) {
                    COUICustomTopTips.this.mAnimatorShowListener.onAnimationEnd(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                if (COUICustomTopTips.this.mAnimatorShowListener != null) {
                    COUICustomTopTips.this.mAnimatorShowListener.onAnimationRepeat(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (COUICustomTopTips.this.mAnimatorShowListener != null) {
                    COUICustomTopTips.this.mAnimatorShowListener.onAnimationStart(animator);
                }
            }
        });
        this.mAnimatorSetShow.start();
    }

    public COUICustomTopTips(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public COUICustomTopTips(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        init();
    }

    public void setContentView(int i10) {
        if (i10 == 0) {
            return;
        }
        setContentView(LayoutInflater.from(getContext()).inflate(i10, (ViewGroup) this, false));
    }
}
