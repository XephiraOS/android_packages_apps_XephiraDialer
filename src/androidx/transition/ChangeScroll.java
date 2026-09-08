package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class ChangeScroll extends Transition {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f11576a = {"android:changeScroll:x", "android:changeScroll:y"};

    public ChangeScroll() {
    }

    private void captureValues(C c10) {
        c10.f11527a.put("android:changeScroll:x", Integer.valueOf(c10.f11528b.getScrollX()));
        c10.f11527a.put("android:changeScroll:y", Integer.valueOf(c10.f11528b.getScrollY()));
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(C c10) {
        captureValues(c10);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(C c10) {
        captureValues(c10);
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(ViewGroup viewGroup, C c10, C c11) {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2 = null;
        if (c10 == null || c11 == null) {
            return null;
        }
        View view = c11.f11528b;
        int intValue = ((Integer) c10.f11527a.get("android:changeScroll:x")).intValue();
        int intValue2 = ((Integer) c11.f11527a.get("android:changeScroll:x")).intValue();
        int intValue3 = ((Integer) c10.f11527a.get("android:changeScroll:y")).intValue();
        int intValue4 = ((Integer) c11.f11527a.get("android:changeScroll:y")).intValue();
        if (intValue != intValue2) {
            view.setScrollX(intValue);
            objectAnimator = ObjectAnimator.ofInt(view, "scrollX", intValue, intValue2);
        } else {
            objectAnimator = null;
        }
        if (intValue3 != intValue4) {
            view.setScrollY(intValue3);
            objectAnimator2 = ObjectAnimator.ofInt(view, "scrollY", intValue3, intValue4);
        }
        return B.c(objectAnimator, objectAnimator2);
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return f11576a;
    }

    @Override // androidx.transition.Transition
    public boolean isSeekingSupported() {
        return true;
    }

    public ChangeScroll(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
