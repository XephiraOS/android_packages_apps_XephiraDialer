package com.android.incallui.oplus.answerview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class Tweener {
    private static final boolean DEBUG = false;
    private static final String TAG = "Tweener";
    public ObjectAnimator mAnimator;
    private static HashMap<Object, Tweener> sTweens = new HashMap<>();
    private static Animator.AnimatorListener sCleanupListener = new AnimatorListenerAdapter() { // from class: com.android.incallui.oplus.answerview.Tweener.1
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Tweener.remove(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Tweener.remove(animator);
        }
    };

    public Tweener(ObjectAnimator objectAnimator) {
        this.mAnimator = objectAnimator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void remove(Animator animator) {
        Iterator<Map.Entry<Object, Tweener>> it = sTweens.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue().mAnimator == animator) {
                it.remove();
                return;
            }
        }
    }

    private static void replace(ArrayList<PropertyValuesHolder> arrayList, Object... objArr) {
        for (Object obj : objArr) {
            Tweener tweener = sTweens.get(obj);
            if (tweener != null) {
                tweener.mAnimator.cancel();
                if (arrayList != null) {
                    tweener.mAnimator.setValues((PropertyValuesHolder[]) arrayList.toArray(new PropertyValuesHolder[arrayList.size()]));
                } else {
                    sTweens.remove(tweener);
                }
            }
        }
    }

    public static Tweener to(Object obj, long j10, Object... objArr) {
        Tweener tweener;
        ObjectAnimator objectAnimator;
        ArrayList arrayList = new ArrayList(objArr.length / 2);
        TimeInterpolator timeInterpolator = null;
        long j11 = 0;
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = null;
        Animator.AnimatorListener animatorListener = null;
        for (int i10 = 0; i10 < objArr.length; i10 += 2) {
            Object obj2 = objArr[i10];
            if (obj2 instanceof String) {
                String str = (String) obj2;
                Object obj3 = objArr[i10 + 1];
                if (!"simultaneousTween".equals(str)) {
                    if ("ease".equals(str)) {
                        timeInterpolator = (TimeInterpolator) obj3;
                    } else if (!"onUpdate".equals(str) && !"onUpdateListener".equals(str)) {
                        if (!"onComplete".equals(str) && !"onCompleteListener".equals(str)) {
                            if ("delay".equals(str)) {
                                j11 = ((Number) obj3).longValue();
                            } else if ("syncWith".equals(str)) {
                                continue;
                            } else if (obj3 instanceof float[]) {
                                float[] fArr = (float[]) obj3;
                                arrayList.add(PropertyValuesHolder.ofFloat(str, fArr[0], fArr[1]));
                            } else if (obj3 instanceof int[]) {
                                int[] iArr = (int[]) obj3;
                                arrayList.add(PropertyValuesHolder.ofInt(str, iArr[0], iArr[1]));
                            } else if (obj3 instanceof Number) {
                                arrayList.add(PropertyValuesHolder.ofFloat(str, ((Number) obj3).floatValue()));
                            } else {
                                throw new IllegalArgumentException("Bad argument for key \"" + str + "\" with value " + obj3.getClass());
                            }
                        } else {
                            animatorListener = (Animator.AnimatorListener) obj3;
                        }
                    } else {
                        animatorUpdateListener = (ValueAnimator.AnimatorUpdateListener) obj3;
                    }
                }
            } else {
                throw new IllegalArgumentException("Key must be a string: " + objArr[i10]);
            }
        }
        Tweener tweener2 = sTweens.get(obj);
        if (tweener2 == null) {
            objectAnimator = ObjectAnimator.ofPropertyValuesHolder(obj, (PropertyValuesHolder[]) arrayList.toArray(new PropertyValuesHolder[arrayList.size()]));
            tweener = new Tweener(objectAnimator);
            sTweens.put(obj, tweener);
        } else {
            ObjectAnimator objectAnimator2 = sTweens.get(obj).mAnimator;
            replace(arrayList, obj);
            tweener = tweener2;
            objectAnimator = objectAnimator2;
        }
        if (timeInterpolator != null) {
            objectAnimator.setInterpolator(timeInterpolator);
        }
        objectAnimator.setStartDelay(j11);
        objectAnimator.setDuration(j10);
        if (animatorUpdateListener != null) {
            objectAnimator.removeAllUpdateListeners();
            objectAnimator.addUpdateListener(animatorUpdateListener);
        }
        if (animatorListener != null) {
            objectAnimator.removeAllListeners();
            objectAnimator.addListener(animatorListener);
        }
        objectAnimator.addListener(sCleanupListener);
        return tweener;
    }
}
