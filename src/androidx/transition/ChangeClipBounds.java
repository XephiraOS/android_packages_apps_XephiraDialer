package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;

/* loaded from: classes.dex */
public class ChangeClipBounds extends Transition {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f11563a = {"android:clipBounds:clip"};

    /* renamed from: b, reason: collision with root package name */
    public static final Rect f11564b = new Rect();

    /* loaded from: classes.dex */
    public static class a extends AnimatorListenerAdapter implements Transition.i {

        /* renamed from: a, reason: collision with root package name */
        public final Rect f11565a;

        /* renamed from: b, reason: collision with root package name */
        public final Rect f11566b;

        /* renamed from: c, reason: collision with root package name */
        public final View f11567c;

        public a(View view, Rect rect, Rect rect2) {
            this.f11567c = view;
            this.f11565a = rect;
            this.f11566b = rect2;
        }

        @Override // androidx.transition.Transition.i
        public void b(Transition transition) {
            Rect clipBounds = this.f11567c.getClipBounds();
            if (clipBounds == null) {
                clipBounds = ChangeClipBounds.f11564b;
            }
            this.f11567c.setTag(C0511n.f11729e, clipBounds);
            this.f11567c.setClipBounds(this.f11566b);
        }

        @Override // androidx.transition.Transition.i
        public void g(Transition transition) {
            View view = this.f11567c;
            int i10 = C0511n.f11729e;
            this.f11567c.setClipBounds((Rect) view.getTag(i10));
            this.f11567c.setTag(i10, null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            onAnimationEnd(animator, false);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z10) {
            if (!z10) {
                this.f11567c.setClipBounds(this.f11566b);
            } else {
                this.f11567c.setClipBounds(this.f11565a);
            }
        }

        @Override // androidx.transition.Transition.i
        public void a(Transition transition) {
        }

        @Override // androidx.transition.Transition.i
        public void d(Transition transition) {
        }

        @Override // androidx.transition.Transition.i
        public void e(Transition transition) {
        }
    }

    public ChangeClipBounds() {
    }

    public final void a(C c10, boolean z10) {
        Rect rect;
        View view = c10.f11528b;
        if (view.getVisibility() == 8) {
            return;
        }
        Rect rect2 = null;
        if (z10) {
            rect = (Rect) view.getTag(C0511n.f11729e);
        } else {
            rect = null;
        }
        if (rect == null) {
            rect = view.getClipBounds();
        }
        if (rect != f11564b) {
            rect2 = rect;
        }
        c10.f11527a.put("android:clipBounds:clip", rect2);
        if (rect2 == null) {
            c10.f11527a.put("android:clipBounds:bounds", new Rect(0, 0, view.getWidth(), view.getHeight()));
        }
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(C c10) {
        a(c10, false);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(C c10) {
        a(c10, true);
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(ViewGroup viewGroup, C c10, C c11) {
        Rect rect;
        Rect rect2;
        if (c10 == null || c11 == null || !c10.f11527a.containsKey("android:clipBounds:clip") || !c11.f11527a.containsKey("android:clipBounds:clip")) {
            return null;
        }
        Rect rect3 = (Rect) c10.f11527a.get("android:clipBounds:clip");
        Rect rect4 = (Rect) c11.f11527a.get("android:clipBounds:clip");
        if (rect3 == null && rect4 == null) {
            return null;
        }
        if (rect3 == null) {
            rect = (Rect) c10.f11527a.get("android:clipBounds:bounds");
        } else {
            rect = rect3;
        }
        if (rect4 == null) {
            rect2 = (Rect) c11.f11527a.get("android:clipBounds:bounds");
        } else {
            rect2 = rect4;
        }
        if (rect.equals(rect2)) {
            return null;
        }
        c11.f11528b.setClipBounds(rect3);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(c11.f11528b, (Property<View, V>) H.f11629c, (TypeEvaluator) new o(new Rect()), (Object[]) new Rect[]{rect, rect2});
        a aVar = new a(c11.f11528b, rect3, rect4);
        ofObject.addListener(aVar);
        addListener(aVar);
        return ofObject;
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return f11563a;
    }

    @Override // androidx.transition.Transition
    public boolean isSeekingSupported() {
        return true;
    }

    public ChangeClipBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
