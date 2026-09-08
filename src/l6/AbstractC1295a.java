package l6;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: BaseAnimator.java */
/* renamed from: l6.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC1295a extends ValueAnimator {

    /* renamed from: a, reason: collision with root package name */
    public final Set<ValueAnimator.AnimatorUpdateListener> f34704a = new CopyOnWriteArraySet();

    /* renamed from: b, reason: collision with root package name */
    public final Set<Animator.AnimatorListener> f34705b = new CopyOnWriteArraySet();

    /* renamed from: c, reason: collision with root package name */
    public final Set<Animator.AnimatorPauseListener> f34706c = new CopyOnWriteArraySet();

    public void a() {
        Iterator<Animator.AnimatorListener> it = this.f34705b.iterator();
        while (it.hasNext()) {
            it.next().onAnimationCancel(this);
        }
    }

    @Override // android.animation.Animator
    public void addListener(Animator.AnimatorListener animatorListener) {
        this.f34705b.add(animatorListener);
    }

    @Override // android.animation.Animator
    public void addPauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.f34706c.add(animatorPauseListener);
    }

    @Override // android.animation.ValueAnimator
    public void addUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f34704a.add(animatorUpdateListener);
    }

    public void b(boolean z10) {
        Iterator<Animator.AnimatorListener> it = this.f34705b.iterator();
        while (it.hasNext()) {
            it.next().onAnimationEnd(this, z10);
        }
    }

    public void c() {
        Iterator<Animator.AnimatorPauseListener> it = this.f34706c.iterator();
        while (it.hasNext()) {
            it.next().onAnimationPause(this);
        }
    }

    public void d() {
        Iterator<Animator.AnimatorListener> it = this.f34705b.iterator();
        while (it.hasNext()) {
            it.next().onAnimationRepeat(this);
        }
    }

    public void e() {
        Iterator<Animator.AnimatorPauseListener> it = this.f34706c.iterator();
        while (it.hasNext()) {
            it.next().onAnimationResume(this);
        }
    }

    public void f(boolean z10) {
        Iterator<Animator.AnimatorListener> it = this.f34705b.iterator();
        while (it.hasNext()) {
            it.next().onAnimationStart(this, z10);
        }
    }

    public void g() {
        Iterator<ValueAnimator.AnimatorUpdateListener> it = this.f34704a.iterator();
        while (it.hasNext()) {
            it.next().onAnimationUpdate(this);
        }
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getStartDelay() {
        throw new UnsupportedOperationException("EffectiveAnimator does not support getStartDelay.");
    }

    @Override // android.animation.Animator
    public void removeAllListeners() {
        this.f34705b.clear();
    }

    @Override // android.animation.ValueAnimator
    public void removeAllUpdateListeners() {
        this.f34704a.clear();
    }

    @Override // android.animation.Animator
    public void removeListener(Animator.AnimatorListener animatorListener) {
        this.f34705b.remove(animatorListener);
    }

    @Override // android.animation.Animator
    public void removePauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.f34706c.remove(animatorPauseListener);
    }

    @Override // android.animation.ValueAnimator
    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f34704a.remove(animatorUpdateListener);
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void setInterpolator(TimeInterpolator timeInterpolator) {
        throw new UnsupportedOperationException("EffectiveAnimator does not support setInterpolator.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void setStartDelay(long j10) {
        throw new UnsupportedOperationException("EffectiveAnimator does not support setStartDelay.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public ValueAnimator setDuration(long j10) {
        throw new UnsupportedOperationException("EffectiveAnimator does not support setDuration.");
    }
}
