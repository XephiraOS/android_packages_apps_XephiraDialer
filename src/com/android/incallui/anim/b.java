package com.android.incallui.anim;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Animation;
import android.view.animation.PathInterpolator;
import android.view.animation.TranslateAnimation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.incallui.Log;
import com.android.incallui.R;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: CommonAnimationManager.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: g, reason: collision with root package name */
    public static b f18283g = new b();

    /* renamed from: h, reason: collision with root package name */
    public static float f18284h = -1.0f;

    /* renamed from: i, reason: collision with root package name */
    public static float f18285i = -1.0f;

    /* renamed from: c, reason: collision with root package name */
    public Context f18288c;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList<ObjectAnimator> f18286a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList<ObjectAnimator> f18287b = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    public PathInterpolator f18289d = new PathInterpolator(0.0f, 0.0f, 0.15f, 1.0f);

    /* renamed from: e, reason: collision with root package name */
    public boolean f18290e = false;

    /* renamed from: f, reason: collision with root package name */
    public PathInterpolator f18291f = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);

    public static b c() {
        return f18283g;
    }

    public final void a(ObjectAnimator objectAnimator) {
        Log.d("CommonAnimationManager", "addToButtonsList");
        this.f18287b.add(objectAnimator);
    }

    public void b(View view, boolean z10, boolean z11, Animator.AnimatorListener animatorListener) {
        RecyclerView recyclerView;
        GridLayoutManager gridLayoutManager;
        if (view == null || (recyclerView = (RecyclerView) view.findViewById(R.id.rv_dialpad_buttons)) == null || (gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager()) == null) {
            return;
        }
        int o10 = gridLayoutManager.o();
        int itemCount = gridLayoutManager.getItemCount();
        int e10 = e(itemCount, o10);
        for (int i10 = 0; i10 < itemCount; i10++) {
            View findViewByPosition = gridLayoutManager.findViewByPosition(i10);
            if (findViewByPosition != null) {
                if (f18284h == -1.0f) {
                    f18284h = findViewByPosition.getPivotX();
                }
                g(findViewByPosition, o10, i10, f18284h);
                int d10 = e10 - d(o10, i10);
                ViewPropertyAnimator animate = findViewByPosition.animate();
                animate.setListener(null);
                animate.cancel();
                if (z10) {
                    if (i10 == 0) {
                        animate.setListener(animatorListener);
                    }
                    if (!z11) {
                        animate.setStartDelay((d10 * 33) + 150);
                    } else {
                        animate.setStartDelay(d10 * 33);
                    }
                    animate.alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(433L).setInterpolator(this.f18291f).start();
                } else {
                    if (i10 == 0) {
                        animate.setListener(animatorListener);
                    }
                    animate.alpha(0.0f).scaleX(0.92f).scaleY(0.92f).setDuration(300L).setInterpolator(this.f18291f).setStartDelay(d10 * 33).start();
                }
            }
        }
    }

    public int d(int i10, int i11) {
        if (i10 == 0) {
            return -1;
        }
        return i11 / i10;
    }

    public int e(int i10, int i11) {
        if (i11 == 0) {
            return -1;
        }
        if (i10 == 0) {
            return 0;
        }
        return ((i10 - 1) / i11) + 1;
    }

    public Animation f(int i10) {
        TranslateAnimation translateAnimation;
        if (i10 != 1) {
            if (i10 != 2) {
                return null;
            }
            translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
            translateAnimation.setDuration(367L);
            translateAnimation.setInterpolator(this.f18289d);
        } else {
            translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
            translateAnimation.setStartOffset(300L);
            translateAnimation.setDuration(367L);
            translateAnimation.setInterpolator(this.f18289d);
        }
        return translateAnimation;
    }

    public void g(View view, int i10, int i11, float f10) {
        if (i10 != 0 && view != null) {
            int i12 = i11 % i10;
            int i13 = i10 / 2;
            if (i12 < i13) {
                view.setPivotX(f10 * 2.0f);
            } else if (i12 > i13) {
                view.setPivotX(0.0f);
            }
        }
    }

    public void h(Context context) {
        if (!this.f18290e && context != null) {
            if (this.f18288c == null) {
                this.f18288c = context;
            }
            this.f18290e = true;
        }
    }

    public final void i() {
        Log.d("CommonAnimationManager", "startButtonsAnimation:  size = " + this.f18287b.size());
        if (this.f18287b.isEmpty()) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        Iterator<ObjectAnimator> it = this.f18287b.iterator();
        AnimatorSet.Builder builder = null;
        while (it.hasNext()) {
            ObjectAnimator next = it.next();
            if (builder == null) {
                builder = animatorSet.play(next);
            } else {
                builder.with(next);
            }
        }
        animatorSet.start();
        this.f18287b.clear();
    }

    public void j(RecyclerView recyclerView, boolean z10, int i10, Animator.AnimatorListener animatorListener) {
        if (recyclerView == null) {
            Log.d("CommonAnimationManager", "startRecyclerViewAnimation recyclerView is null");
            return;
        }
        GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
        if (gridLayoutManager == null) {
            return;
        }
        int o10 = gridLayoutManager.o();
        int itemCount = gridLayoutManager.getItemCount();
        int e10 = e(itemCount, o10);
        for (int i11 = 0; i11 < itemCount; i11++) {
            View findViewByPosition = gridLayoutManager.findViewByPosition(i11);
            if (findViewByPosition != null) {
                if (f18285i == -1.0f) {
                    f18285i = findViewByPosition.getPivotX();
                }
                g(findViewByPosition, o10, i11, f18285i);
                ViewPropertyAnimator animate = findViewByPosition.animate();
                animate.setInterpolator(this.f18291f);
                int d10 = e10 - d(o10, i11);
                if (z10) {
                    if (i10 == 0) {
                        animate.setStartDelay(((d10 - 1) * 33) + 270);
                    } else {
                        animate.setStartDelay(((d10 - 1) * 33) + 50);
                    }
                    animate.setDuration(433L);
                    animate.scaleY(1.0f).scaleX(1.0f).alpha(1.0f);
                    if (i11 == itemCount - 1) {
                        animate.setListener(animatorListener);
                    }
                } else {
                    if (i11 == itemCount - 1) {
                        animate.setListener(animatorListener);
                    }
                    animate.setDuration(300L);
                    long j10 = (d10 - 1) * 33;
                    animate.scaleY(0.92f).scaleX(0.92f).alpha(0.0f).setStartDelay(20 + j10);
                    animate.setStartDelay(j10);
                }
                animate.start();
            }
        }
    }

    public void k(View view, boolean z10) {
        if (view == null) {
            Log.d("CommonAnimationManager", "showButtonsWhenIncoming view is null");
            return;
        }
        Log.d("CommonAnimationManager", "startShowButtonsWhenIncoming shouldStart = " + z10);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(333L);
        ofFloat.setInterpolator(this.f18291f);
        a(ofFloat);
        if (z10) {
            i();
        }
    }

    public void l(View view, Animator.AnimatorListener animatorListener, ObjectAnimator objectAnimator) {
        if (view == null) {
            Log.d("CommonAnimationManager", "startShowDialpadAnimation dialpadView is null");
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        if (animatorListener != null) {
            animatorSet.addListener(animatorListener);
        }
        objectAnimator.setDuration(10L);
        animatorSet.playTogether(objectAnimator);
        animatorSet.start();
    }
}
