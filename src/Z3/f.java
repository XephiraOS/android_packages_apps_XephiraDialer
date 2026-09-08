package Z3;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.Property;
import android.view.View;
import android.view.animation.PathInterpolator;
import androidx.appcompat.widget.AppCompatImageView;
import com.coui.appcompat.floatingactionbutton.COUIFloatingButton;
import com.oplus.dialer.R;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: CustomizeAnimationHelper.java */
/* loaded from: classes3.dex */
public class f {

    /* renamed from: e, reason: collision with root package name */
    public static final PathInterpolator f5905e = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);

    /* renamed from: f, reason: collision with root package name */
    public static final PathInterpolator f5906f = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);

    /* renamed from: g, reason: collision with root package name */
    public static final PathInterpolator f5907g = new PathInterpolator(0.133f, 0.0f, 0.3f, 1.0f);

    /* renamed from: h, reason: collision with root package name */
    public static final PathInterpolator f5908h = new PathInterpolator(0.3f, 0.0f, 0.0f, 1.0f);

    /* renamed from: i, reason: collision with root package name */
    public static final PathInterpolator f5909i = new PathInterpolator(0.3f, 0.0f, 1.0f, 1.0f);

    /* renamed from: j, reason: collision with root package name */
    public static final PathInterpolator f5910j = new PathInterpolator(0.0f, 0.0f, 0.1f, 1.0f);

    /* renamed from: k, reason: collision with root package name */
    public static final PathInterpolator f5911k = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);

    /* renamed from: a, reason: collision with root package name */
    public boolean f5912a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList<e> f5913b;

    /* renamed from: c, reason: collision with root package name */
    public Context f5914c;

    /* renamed from: d, reason: collision with root package name */
    public final int f5915d;

    /* compiled from: CustomizeAnimationHelper.java */
    /* loaded from: classes3.dex */
    public class a implements Animator.AnimatorListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ COUIFloatingButton f5916a;

        public a(COUIFloatingButton cOUIFloatingButton) {
            this.f5916a = cOUIFloatingButton;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            COUIFloatingButton cOUIFloatingButton = this.f5916a;
            if (cOUIFloatingButton != null) {
                cOUIFloatingButton.setVisibility(0);
                this.f5916a.setScaleX(1.0f);
                this.f5916a.setScaleY(1.0f);
            }
            f.this.f5912a = false;
            f.this.q(animator, 2);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f.this.f5912a = false;
            f.this.q(animator, 1);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            f.this.r(animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            f.this.f5912a = true;
            f.this.s(animator);
        }
    }

    /* compiled from: CustomizeAnimationHelper.java */
    /* loaded from: classes3.dex */
    public class b implements Animator.AnimatorListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ COUIFloatingButton f5918a;

        public b(COUIFloatingButton cOUIFloatingButton) {
            this.f5918a = cOUIFloatingButton;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            COUIFloatingButton cOUIFloatingButton = this.f5918a;
            if (cOUIFloatingButton != null) {
                cOUIFloatingButton.setVisibility(8);
                this.f5918a.setScaleX(0.0f);
                this.f5918a.setScaleY(0.0f);
            }
            f.this.f5912a = false;
            f.this.q(animator, 2);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f.this.f5912a = false;
            f.this.q(animator, 1);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            f.this.r(animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            f.this.f5912a = true;
            f.this.s(animator);
        }
    }

    /* compiled from: CustomizeAnimationHelper.java */
    /* loaded from: classes3.dex */
    public class c extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f5920a;

        public c(View view) {
            this.f5920a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f5920a.setVisibility(4);
        }
    }

    /* compiled from: CustomizeAnimationHelper.java */
    /* loaded from: classes3.dex */
    public class d extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f5921a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f5922b;

        public d(Runnable runnable, View view) {
            this.f5921a = runnable;
            this.f5922b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            onAnimationEnd(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Runnable runnable = this.f5921a;
            if (runnable != null) {
                runnable.run();
            }
            this.f5922b.setAlpha(1.0f);
            this.f5922b.setVisibility(8);
        }
    }

    public f(Context context) {
        this(context, R.dimen.new_dialpad_container_empty_height);
    }

    public static ObjectAnimator h(View view, int i10, float f10, float f11) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", f10, f11);
        ofFloat.setDuration(i10);
        ofFloat.addListener(new c(view));
        return ofFloat;
    }

    public static ObjectAnimator j(final V3.b bVar, int i10, int i11, int i12) {
        ObjectAnimator ofInt = ObjectAnimator.ofInt(bVar, "height", i11, i12);
        ofInt.setDuration(i10);
        ofInt.setInterpolator(f5905e);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: Z3.d
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.o(V3.b.this, valueAnimator);
            }
        });
        return ofInt;
    }

    public static ObjectAnimator k(final V3.c cVar, int i10, int i11, int i12) {
        ObjectAnimator ofInt = ObjectAnimator.ofInt(cVar, "topMargin", i11, i12);
        ofInt.setDuration(i10);
        ofInt.setInterpolator(f5905e);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: Z3.e
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.p(V3.c.this, valueAnimator);
            }
        });
        return ofInt;
    }

    public static void m(View view, Runnable runnable) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, 1.0f, 0.0f);
        ofFloat.setInterpolator(f5911k);
        ofFloat.addListener(new d(runnable, view));
        ofFloat.setDuration(180L);
        ofFloat.start();
    }

    public static /* synthetic */ void o(V3.b bVar, ValueAnimator valueAnimator) {
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue != null) {
            bVar.b(((Integer) animatedValue).intValue());
        }
    }

    public static /* synthetic */ void p(V3.c cVar, ValueAnimator valueAnimator) {
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue != null) {
            cVar.c(((Integer) animatedValue).intValue());
        }
    }

    public static void t(View view) {
        view.setScaleX(0.6f);
        view.setScaleY(0.6f);
        view.setAlpha(0.0f);
    }

    public void g(e eVar) {
        if (this.f5913b == null) {
            this.f5913b = new ArrayList<>();
        }
        this.f5913b.add(eVar);
    }

    public final int i(View view) {
        int i10;
        if (view != null) {
            i10 = view.getHeight();
        } else {
            i10 = 0;
        }
        if (i10 == 0) {
            return this.f5914c.getResources().getDimensionPixelSize(this.f5915d);
        }
        return i10;
    }

    public void l(View view, View view2, COUIFloatingButton cOUIFloatingButton, boolean z10, boolean z11) {
        if (this.f5912a) {
            H7.b.b("CustomizeAnimationHelper", "HideDialPad animation is running");
            return;
        }
        ArrayList arrayList = new ArrayList(5);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_Y, 0.0f, i(view));
        ofFloat.setInterpolator(f5909i);
        ofFloat.setDuration(250L);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(cOUIFloatingButton, (Property<COUIFloatingButton, Float>) View.SCALE_X, 0.6f, 1.0f);
        PathInterpolator pathInterpolator = f5908h;
        ofFloat2.setInterpolator(pathInterpolator);
        ofFloat2.setDuration(350L);
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(cOUIFloatingButton, (Property<COUIFloatingButton, Float>) View.SCALE_Y, 0.6f, 1.0f);
        ofFloat3.setInterpolator(pathInterpolator);
        ofFloat3.setDuration(350L);
        arrayList.add(ofFloat3);
        AppCompatImageView mainFloatingButton = cOUIFloatingButton.getMainFloatingButton();
        Property property = View.ALPHA;
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(mainFloatingButton, (Property<AppCompatImageView, Float>) property, 0.0f, 1.0f);
        ofFloat4.setInterpolator(pathInterpolator);
        ofFloat4.setDuration(350L);
        arrayList.add(ofFloat4);
        if (z11) {
            if (view2 != null) {
                ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) property, 0.0f, 1.0f);
                ofFloat5.setInterpolator(pathInterpolator);
                ofFloat5.setDuration(350L);
                arrayList.add(ofFloat5);
            }
            cOUIFloatingButton.setVisibility(0);
            cOUIFloatingButton.getMainFloatingButton().setVisibility(0);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.addListener(new a(cOUIFloatingButton));
        if (z10) {
            animatorSet.setDuration(0L);
        }
        animatorSet.start();
    }

    public boolean n() {
        return this.f5912a;
    }

    public final void q(Animator animator, int i10) {
        ArrayList<e> arrayList = this.f5913b;
        if (arrayList == null) {
            return;
        }
        Iterator<e> it = arrayList.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next != null) {
                if (i10 == 1) {
                    next.onAnimationEnd(animator);
                } else if (i10 == 2) {
                    next.onAnimationCancel(animator);
                }
                it.remove();
            }
        }
        if (this.f5913b.size() == 0) {
            this.f5913b = null;
        }
    }

    public final void r(Animator animator) {
        ArrayList<e> arrayList = this.f5913b;
        if (arrayList == null) {
            return;
        }
        Iterator<e> it = arrayList.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next != null) {
                next.onAnimationRepeat(animator);
            }
        }
    }

    public final void s(Animator animator) {
        ArrayList<e> arrayList = this.f5913b;
        if (arrayList == null) {
            return;
        }
        Iterator<e> it = arrayList.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next != null) {
                next.onAnimationStart(animator);
            }
        }
    }

    public void u(View view, View view2, COUIFloatingButton cOUIFloatingButton, boolean z10, boolean z11) {
        if (this.f5912a) {
            H7.b.b("CustomizeAnimationHelper", "ShowDialPad animation is running");
            return;
        }
        ArrayList arrayList = new ArrayList(5);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_Y, i(view), 0.0f);
        ofFloat.setInterpolator(f5910j);
        ofFloat.setDuration(300L);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(cOUIFloatingButton, (Property<COUIFloatingButton, Float>) View.SCALE_X, 0.6f, 1.0f);
        PathInterpolator pathInterpolator = f5908h;
        ofFloat2.setInterpolator(pathInterpolator);
        ofFloat2.setDuration(350L);
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(cOUIFloatingButton, (Property<COUIFloatingButton, Float>) View.SCALE_Y, 0.6f, 1.0f);
        ofFloat3.setInterpolator(pathInterpolator);
        ofFloat3.setDuration(350L);
        arrayList.add(ofFloat3);
        AppCompatImageView mainFloatingButton = cOUIFloatingButton.getMainFloatingButton();
        Property property = View.ALPHA;
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(mainFloatingButton, (Property<AppCompatImageView, Float>) property, 0.0f, 1.0f);
        ofFloat4.setInterpolator(pathInterpolator);
        ofFloat4.setDuration(350L);
        arrayList.add(ofFloat4);
        if (z11) {
            if (view2 != null) {
                ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) property, 1.0f, 0.0f);
                ofFloat5.setInterpolator(pathInterpolator);
                ofFloat5.setDuration(350L);
                arrayList.add(ofFloat5);
            }
            cOUIFloatingButton.setVisibility(8);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.addListener(new b(cOUIFloatingButton));
        if (z10) {
            animatorSet.setDuration(0L);
        }
        animatorSet.start();
    }

    public f(Context context, int i10) {
        this.f5914c = context;
        this.f5915d = i10;
    }

    /* compiled from: CustomizeAnimationHelper.java */
    /* loaded from: classes3.dex */
    public interface e {
        default void onAnimationCancel(Animator animator) {
        }

        default void onAnimationEnd(Animator animator) {
        }

        default void onAnimationRepeat(Animator animator) {
        }

        default void onAnimationStart(Animator animator) {
        }
    }
}
