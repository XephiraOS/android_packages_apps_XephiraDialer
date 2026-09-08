package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import f4.C1008i;
import java.util.List;

/* compiled from: MotionStrategy.java */
/* loaded from: classes3.dex */
public interface b {
    void a();

    int b();

    void c();

    C1008i d();

    boolean e();

    void f(C1008i c1008i);

    AnimatorSet g();

    List<Animator.AnimatorListener> h();

    void i(ExtendedFloatingActionButton.l lVar);

    void onAnimationEnd();

    void onAnimationStart(Animator animator);
}
