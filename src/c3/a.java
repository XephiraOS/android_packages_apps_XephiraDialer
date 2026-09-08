package C3;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.util.Property;
import android.view.View;
import android.view.animation.PathInterpolator;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.n;

/* compiled from: FieldEditorViewController.kt */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: f, reason: collision with root package name */
    public static final C0007a f329f = new C0007a(null);

    /* renamed from: g, reason: collision with root package name */
    public static final PathInterpolator f330g = new PathInterpolator(0.3f, 0.0f, 0.0f, 1.0f);

    /* renamed from: a, reason: collision with root package name */
    public ArrayList<b> f331a;

    /* renamed from: b, reason: collision with root package name */
    public AnimatorSet f332b;

    /* renamed from: c, reason: collision with root package name */
    public AnimatorSet f333c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f334d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f335e;

    /* compiled from: FieldEditorViewController.kt */
    /* renamed from: C3.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0007a {
        public C0007a() {
        }

        public /* synthetic */ C0007a(f fVar) {
            this();
        }
    }

    /* compiled from: FieldEditorViewController.kt */
    /* loaded from: classes3.dex */
    public interface b {
        void onAnimationCancel(Animator animator);

        void onAnimationEnd(Animator animator);

        void onAnimationRepeat(Animator animator);

        void onAnimationStart(Animator animator);
    }

    /* compiled from: FieldEditorViewController.kt */
    /* loaded from: classes3.dex */
    public static final class c implements Animator.AnimatorListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f336a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f337b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f338c;

        public c(View view, a aVar, View view2) {
            this.f336a = view;
            this.f337b = aVar;
            this.f338c = view2;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            i.f(animation, "animation");
            this.f337b.f335e = false;
            this.f337b.m(animation);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            i.f(animation, "animation");
            this.f337b.f335e = false;
            View view = this.f338c;
            if (view != null) {
                view.setVisibility(8);
            }
            this.f337b.n(animation);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
            i.f(animation, "animation");
            this.f337b.o(animation);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            i.f(animation, "animation");
            View view = this.f336a;
            if (view != null) {
                view.setVisibility(0);
            }
            this.f337b.p(animation);
        }
    }

    /* compiled from: FieldEditorViewController.kt */
    /* loaded from: classes3.dex */
    public static final class d implements Animator.AnimatorListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f339a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f340b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a f341c;

        public d(View view, View view2, a aVar) {
            this.f339a = view;
            this.f340b = view2;
            this.f341c = aVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            i.f(animation, "animation");
            this.f341c.f334d = false;
            this.f341c.m(animation);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            i.f(animation, "animation");
            this.f341c.f334d = false;
            View view = this.f340b;
            if (view != null) {
                view.setVisibility(8);
            }
            View view2 = this.f339a;
            if (view2 != null) {
                view2.setVisibility(0);
                view2.setAlpha(1.0f);
            }
            this.f341c.n(animation);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
            i.f(animation, "animation");
            this.f341c.o(animation);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            i.f(animation, "animation");
            View view = this.f339a;
            if (view != null) {
                view.setVisibility(0);
                view.setAlpha(0.0f);
            }
            View view2 = this.f340b;
            if (view2 != null) {
                view2.setVisibility(0);
                view2.setAlpha(1.0f);
            }
            this.f341c.p(animation);
        }
    }

    public final void g(b listener) {
        i.f(listener, "listener");
        if (this.f331a == null) {
            this.f331a = new ArrayList<>();
        }
        ArrayList<b> arrayList = this.f331a;
        if (arrayList != null) {
            arrayList.add(listener);
        }
    }

    public final void h() {
        AnimatorSet animatorSet = this.f333c;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    public final void i() {
        AnimatorSet animatorSet = this.f332b;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    public final void j(View view, View view2) {
        if (this.f334d) {
            i();
            return;
        }
        this.f335e = true;
        Property property = View.ALPHA;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, 1.0f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) property, 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f333c = animatorSet;
        animatorSet.setInterpolator(f330g);
        animatorSet.setDuration(267L);
        animatorSet.addListener(new c(view2, this, view));
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.start();
    }

    public final boolean k() {
        return this.f335e;
    }

    public final boolean l() {
        return this.f334d;
    }

    public final void m(Animator animator) {
        ArrayList<b> arrayList = this.f331a;
        if (arrayList != null && arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                ((b) it.next()).onAnimationCancel(animator);
            }
        }
    }

    public final void n(Animator animator) {
        ArrayList<b> arrayList = this.f331a;
        if (arrayList != null && arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                ((b) it.next()).onAnimationEnd(animator);
            }
        }
    }

    public final void o(Animator animator) {
        ArrayList<b> arrayList = this.f331a;
        if (arrayList != null && arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                ((b) it.next()).onAnimationRepeat(animator);
            }
        }
    }

    public final void p(Animator animator) {
        ArrayList<b> arrayList = this.f331a;
        if (arrayList != null && arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                ((b) it.next()).onAnimationStart(animator);
            }
        }
    }

    public final void q(b bVar) {
        ArrayList<b> arrayList = this.f331a;
        if (arrayList == null) {
            return;
        }
        if (arrayList != null) {
            n.a(arrayList).remove(bVar);
        }
        ArrayList<b> arrayList2 = this.f331a;
        i.c(arrayList2);
        if (arrayList2.size() == 0) {
            this.f331a = null;
        }
    }

    public final void r(View view, View view2) {
        s(view, view2, false);
    }

    public final void s(View view, View view2, boolean z10) {
        long j10;
        if (this.f335e) {
            h();
            return;
        }
        this.f334d = true;
        Property property = View.ALPHA;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) property, 1.0f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f332b = animatorSet;
        animatorSet.setInterpolator(f330g);
        animatorSet.addListener(new d(view, view2, this));
        animatorSet.playTogether(ofFloat, ofFloat2);
        if (z10) {
            j10 = 0;
        } else {
            j10 = 267;
        }
        animatorSet.setDuration(j10);
        animatorSet.start();
    }
}
