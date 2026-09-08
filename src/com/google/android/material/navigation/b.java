package com.google.android.material.navigation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.view.View;
import androidx.drawerlayout.widget.DrawerLayout;
import f4.C1001b;

/* compiled from: DrawerLayoutUtils.java */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static final int f23501a = Color.alpha(-1728053248);

    /* compiled from: DrawerLayoutUtils.java */
    /* loaded from: classes3.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DrawerLayout f23502a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f23503b;

        public a(DrawerLayout drawerLayout, View view) {
            this.f23502a = drawerLayout;
            this.f23503b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f23502a.closeDrawer(this.f23503b, false);
            this.f23502a.setScrimColor(-1728053248);
        }
    }

    public static Animator.AnimatorListener b(DrawerLayout drawerLayout, View view) {
        return new a(drawerLayout, view);
    }

    public static ValueAnimator.AnimatorUpdateListener c(final DrawerLayout drawerLayout) {
        return new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.navigation.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.d(DrawerLayout.this, valueAnimator);
            }
        };
    }

    public static /* synthetic */ void d(DrawerLayout drawerLayout, ValueAnimator valueAnimator) {
        drawerLayout.setScrimColor(B.a.w(-1728053248, C1001b.c(f23501a, 0, valueAnimator.getAnimatedFraction())));
    }
}
