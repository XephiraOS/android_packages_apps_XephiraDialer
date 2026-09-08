package f4;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

/* compiled from: MotionTiming.java */
/* renamed from: f4.j, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1009j {

    /* renamed from: a, reason: collision with root package name */
    public long f31717a;

    /* renamed from: b, reason: collision with root package name */
    public long f31718b;

    /* renamed from: c, reason: collision with root package name */
    public TimeInterpolator f31719c;

    /* renamed from: d, reason: collision with root package name */
    public int f31720d;

    /* renamed from: e, reason: collision with root package name */
    public int f31721e;

    public C1009j(long j10, long j11) {
        this.f31719c = null;
        this.f31720d = 0;
        this.f31721e = 1;
        this.f31717a = j10;
        this.f31718b = j11;
    }

    public static C1009j b(ValueAnimator valueAnimator) {
        C1009j c1009j = new C1009j(valueAnimator.getStartDelay(), valueAnimator.getDuration(), f(valueAnimator));
        c1009j.f31720d = valueAnimator.getRepeatCount();
        c1009j.f31721e = valueAnimator.getRepeatMode();
        return c1009j;
    }

    public static TimeInterpolator f(ValueAnimator valueAnimator) {
        TimeInterpolator interpolator = valueAnimator.getInterpolator();
        if (!(interpolator instanceof AccelerateDecelerateInterpolator) && interpolator != null) {
            if (interpolator instanceof AccelerateInterpolator) {
                return C1001b.f31704c;
            }
            if (interpolator instanceof DecelerateInterpolator) {
                return C1001b.f31705d;
            }
            return interpolator;
        }
        return C1001b.f31703b;
    }

    public void a(Animator animator) {
        animator.setStartDelay(c());
        animator.setDuration(d());
        animator.setInterpolator(e());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(g());
            valueAnimator.setRepeatMode(h());
        }
    }

    public long c() {
        return this.f31717a;
    }

    public long d() {
        return this.f31718b;
    }

    public TimeInterpolator e() {
        TimeInterpolator timeInterpolator = this.f31719c;
        if (timeInterpolator == null) {
            return C1001b.f31703b;
        }
        return timeInterpolator;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1009j)) {
            return false;
        }
        C1009j c1009j = (C1009j) obj;
        if (c() != c1009j.c() || d() != c1009j.d() || g() != c1009j.g() || h() != c1009j.h()) {
            return false;
        }
        return e().getClass().equals(c1009j.e().getClass());
    }

    public int g() {
        return this.f31720d;
    }

    public int h() {
        return this.f31721e;
    }

    public int hashCode() {
        return (((((((((int) (c() ^ (c() >>> 32))) * 31) + ((int) (d() ^ (d() >>> 32)))) * 31) + e().getClass().hashCode()) * 31) + g()) * 31) + h();
    }

    public String toString() {
        return '\n' + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + c() + " duration: " + d() + " interpolator: " + e().getClass() + " repeatCount: " + g() + " repeatMode: " + h() + "}\n";
    }

    public C1009j(long j10, long j11, TimeInterpolator timeInterpolator) {
        this.f31720d = 0;
        this.f31721e = 1;
        this.f31717a = j10;
        this.f31718b = j11;
        this.f31719c = timeInterpolator;
    }
}
