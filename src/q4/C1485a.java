package q4;

import android.animation.Animator;

/* compiled from: AnimatorTracker.java */
/* renamed from: q4.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1485a {

    /* renamed from: a, reason: collision with root package name */
    public Animator f36132a;

    public void a() {
        Animator animator = this.f36132a;
        if (animator != null) {
            animator.cancel();
        }
    }

    public void b() {
        this.f36132a = null;
    }

    public void c(Animator animator) {
        a();
        this.f36132a = animator;
    }
}
