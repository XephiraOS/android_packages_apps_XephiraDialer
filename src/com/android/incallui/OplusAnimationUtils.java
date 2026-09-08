package com.android.incallui;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.widget.TextView;

/* loaded from: classes.dex */
public class OplusAnimationUtils {
    private static final long ANIMATION_MESSAGE_TRANSLATE_DURATION = 100;
    private static final int ANIMATION_MOVIE_FADE_IN_DURATION = 50;
    public static final int DURATION_FADE_ANIM = 267;
    private static final int FLOATING_WINDOW_DURATION = 417;
    private static final int LONG_ANIMATOR_DURATION = 500;
    private static final int NORMAL_ANIMATOR_DURATION = 340;
    private static final float OPAQUE = 1.0f;
    public static final int SMALL_PHOTO_RANGE = 150;
    public static final Interpolator EASE_OUT_EASE_IN = new PathInterpolator(0.4f, 0.0f, 0.2f, 1.0f);
    private static final String LOG_TAG = OplusAnimationUtils.class.getSimpleName();
    private static final PathInterpolator FLOATING_WINDOW_INTERPOLATOR = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
    private static final Interpolator PATH_INTERPOLATOR = new PathInterpolator(0.3f, 0.0f, 0.0f, 1.0f);
    private static Interpolator mScaleAnimationInterpolatorNormal = new PathInterpolator(0.0f, 0.0f, 0.2f, 1.0f);

    /* loaded from: classes.dex */
    public static class Fade {
        public static void show(View view) {
            if (Log.sDebug) {
                OplusAnimationUtils.log("Fade: SHOW view = " + view + "   visibility = " + view.getVisibility());
            }
            if (view.getVisibility() != 0) {
                view.animate().cancel();
                view.setAlpha(0.0f);
                view.setVisibility(0);
                view.animate().setDuration(50L);
                view.animate().alpha(1.0f);
                view.animate().setInterpolator(new DecelerateInterpolator(1.5f));
            }
        }
    }

    public static void cancelViewAnimation(View view) {
        if (view != null) {
            Animation animation = view.getAnimation();
            if (animation != null) {
                if (Log.sDebug) {
                    log("cancelViewAnimation");
                }
                animation.cancel();
                animation.reset();
            }
            view.setAnimation(null);
        }
    }

    public static void cardFold(final View view) {
        if (view != null && view.getVisibility() != 8) {
            final int height = view.getHeight();
            ValueAnimator ofInt = ValueAnimator.ofInt(height, 0);
            ofInt.setDuration(417L);
            ofInt.setInterpolator(FLOATING_WINDOW_INTERPOLATOR);
            String str = "cardFold";
            ofInt.addUpdateListener(new com.android.incallui.anim.d(str, ofInt) { // from class: com.android.incallui.OplusAnimationUtils.4
                @Override // com.android.incallui.anim.d, android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (valueAnimator.getAnimatedValue() != null) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                        layoutParams.height = intValue;
                        view.setLayoutParams(layoutParams);
                    }
                }
            });
            ofInt.addListener(new com.android.incallui.anim.d(str, ofInt) { // from class: com.android.incallui.OplusAnimationUtils.5
                @Override // com.android.incallui.anim.d, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    view.setVisibility(8);
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    layoutParams.height = height;
                    view.setLayoutParams(layoutParams);
                    view.setAlpha(1.0f);
                }
            });
            ofInt.start();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f);
            ofFloat.setDuration(100L);
            ofFloat.start();
        }
    }

    public static void changeTextViewAlphaAnimation(final TextView textView, final TextView textView2, String str) {
        if (textView != null && str != null) {
            String str2 = (String) textView.getText();
            if (TextUtils.equals(str, str2)) {
                return;
            }
            if (!TextUtils.isEmpty(str2) && textView2 != null) {
                textView2.setVisibility(0);
                textView2.setText(textView.getText());
                textView.setText(str);
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(340L);
                alphaAnimation.setInterpolator(mScaleAnimationInterpolatorNormal);
                alphaAnimation.setAnimationListener(new com.android.incallui.anim.c("text_fade_out", alphaAnimation) { // from class: com.android.incallui.OplusAnimationUtils.2
                    @Override // com.android.incallui.anim.c, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        super.onAnimationEnd(animation);
                        TextView textView3 = textView2;
                        if (textView3 != null) {
                            textView3.setText("");
                        }
                    }
                });
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation2.setDuration(340L);
                alphaAnimation2.setInterpolator(mScaleAnimationInterpolatorNormal);
                alphaAnimation2.setAnimationListener(new com.android.incallui.anim.c("text_fade_in", alphaAnimation2) { // from class: com.android.incallui.OplusAnimationUtils.3
                    @Override // com.android.incallui.anim.c, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        super.onAnimationEnd(animation);
                        TextView textView3 = textView;
                        if (textView3 != null) {
                            textView3.setAlpha(1.0f);
                        }
                    }
                });
                textView.startAnimation(alphaAnimation2);
                textView2.startAnimation(alphaAnimation);
                return;
            }
            textView.setText(str);
        }
    }

    public static ViewPropertyAnimator fadeIn(View view) {
        return view.animate().setDuration((1.0f - view.getAlpha()) * 267.0f).alpha(1.0f).withLayer().setInterpolator(PATH_INTERPOLATOR);
    }

    public static ViewPropertyAnimator fadeOut(View view) {
        return view.animate().setDuration(view.getAlpha() * 267.0f).alpha(0.0f).withLayer().setInterpolator(PATH_INTERPOLATOR);
    }

    public static boolean isInSmallRange(float f10, int i10, int i11) {
        if (f10 > 0.0f) {
            i10 = (int) (i10 / f10);
            i11 = (int) (i11 / f10);
        }
        log("isInSmallRange intrinsicWidth: " + i10 + ", intrinsicHeight: " + i11 + ", DisplayMetrics.density: " + f10);
        if (i10 > 150 && i11 > 150) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void log(String str) {
        Log.d(LOG_TAG, str);
    }

    public static void playActivityAnimationUpDownEnter(Activity activity) {
        if (activity == null) {
            log("playActivityAnimationUpDownEnter activity is null!");
        } else {
            activity.overridePendingTransition(R.anim.coui_push_up_enter_activitydialog, R.anim.oplus_rounded_corners_anim_zoom_fade_exit);
        }
    }

    public static void playFloatingWindowDisplayAnim(View view, Context context, int i10) {
        Animation loadAnimation;
        if (Log.sDebug) {
            log("playAnswerViewAnimation");
        }
        if (context != null && (loadAnimation = AnimationUtils.loadAnimation(context, i10)) != null) {
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.android.incallui.OplusAnimationUtils.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (Log.sDebug) {
                        OplusAnimationUtils.log("playAnswerViewAnimation animation end...");
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (Log.sDebug) {
                        OplusAnimationUtils.log("playAnswerViewAnimation repeat...");
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (Log.sDebug) {
                        OplusAnimationUtils.log("playAnswerViewAnimation start...");
                    }
                }
            });
            view.startAnimation(loadAnimation);
        }
    }

    public static void startRotationAnim(View view, float f10) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "rotation", f10);
        ofFloat.setInterpolator(FLOATING_WINDOW_INTERPOLATOR);
        ofFloat.setDuration(500L);
        ofFloat.start();
    }

    public static void startViewVisibilityAnimation(View view, Animation animation) {
        boolean z10;
        StringBuilder sb = new StringBuilder();
        sb.append("startViewVisiable view = ");
        sb.append(view);
        sb.append(" animation is null = ");
        if (animation == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        sb.append(z10);
        log(sb.toString());
        if (view == null || animation == null) {
            return;
        }
        cancelViewAnimation(view);
        view.startAnimation(animation);
    }
}
