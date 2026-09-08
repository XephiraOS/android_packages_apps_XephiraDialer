package l6;

import android.view.Choreographer;
import com.oplus.anim.C0820a;
import com.oplus.anim.N;
import com.oplus.wrapper.os.Debug;
import com.oplus.wrapper.os.Trace;

/* compiled from: EffectiveValueAnimator.java */
/* loaded from: classes3.dex */
public class b extends AbstractC1295a implements Choreographer.FrameCallback {

    /* renamed from: d, reason: collision with root package name */
    public String f34707d;

    /* renamed from: m, reason: collision with root package name */
    public C0820a f34716m;

    /* renamed from: e, reason: collision with root package name */
    public float f34708e = 1.0f;

    /* renamed from: f, reason: collision with root package name */
    public boolean f34709f = false;

    /* renamed from: g, reason: collision with root package name */
    public long f34710g = 0;

    /* renamed from: h, reason: collision with root package name */
    public float f34711h = 0.0f;

    /* renamed from: i, reason: collision with root package name */
    public float f34712i = 0.0f;

    /* renamed from: j, reason: collision with root package name */
    public int f34713j = 0;

    /* renamed from: k, reason: collision with root package name */
    public float f34714k = -2.14748365E9f;

    /* renamed from: l, reason: collision with root package name */
    public float f34715l = 2.14748365E9f;

    /* renamed from: n, reason: collision with root package name */
    public boolean f34717n = false;

    /* renamed from: o, reason: collision with root package name */
    public boolean f34718o = false;

    public b() {
        this.f34707d = "";
        try {
            this.f34707d = Debug.getCallers(20);
        } catch (Exception | NoClassDefFoundError unused) {
        }
    }

    public void A(float f10) {
        if (this.f34711h == f10) {
            return;
        }
        float b10 = g.b(f10, n(), m());
        this.f34711h = b10;
        if (this.f34718o) {
            b10 = (float) Math.floor(b10);
        }
        this.f34712i = b10;
        this.f34710g = 0L;
        g();
    }

    public void B(float f10) {
        C(this.f34714k, f10);
    }

    public void C(float f10, float f11) {
        float p10;
        float f12;
        if (f10 <= f11) {
            C0820a c0820a = this.f34716m;
            if (c0820a == null) {
                p10 = -3.4028235E38f;
            } else {
                p10 = c0820a.p();
            }
            C0820a c0820a2 = this.f34716m;
            if (c0820a2 == null) {
                f12 = Float.MAX_VALUE;
            } else {
                f12 = c0820a2.f();
            }
            float b10 = g.b(f10, p10, f12);
            float b11 = g.b(f11, p10, f12);
            if (b10 != this.f34714k || b11 != this.f34715l) {
                this.f34714k = b10;
                this.f34715l = b11;
                A((int) g.b(this.f34712i, b10, b11));
                return;
            }
            return;
        }
        throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", Float.valueOf(f10), Float.valueOf(f11)));
    }

    public void D(int i10) {
        C(i10, (int) this.f34715l);
    }

    public void E(float f10) {
        this.f34708e = f10;
    }

    public void F(boolean z10) {
        this.f34718o = z10;
    }

    public final void G() {
        if (this.f34716m == null) {
            return;
        }
        float f10 = this.f34712i;
        if (f10 >= this.f34714k && f10 <= this.f34715l) {
        } else {
            throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.f34714k), Float.valueOf(this.f34715l), Float.valueOf(this.f34712i)));
        }
    }

    @Override // l6.AbstractC1295a
    public void a() {
        super.a();
        b(p());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void cancel() {
        q();
        a();
        v();
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j10) {
        float n10;
        float m10;
        u();
        if (this.f34716m != null && isRunning()) {
            N.a("LottieValueAnimator#doFrame");
            long j11 = this.f34710g;
            long j12 = 0;
            if (j11 != 0) {
                j12 = j10 - j11;
            }
            float l10 = ((float) j12) / l();
            float f10 = this.f34711h;
            if (p()) {
                l10 = -l10;
            }
            float f11 = f10 + l10;
            boolean z10 = !g.d(f11, n(), m());
            float f12 = this.f34711h;
            float b10 = g.b(f11, n(), m());
            this.f34711h = b10;
            if (this.f34718o) {
                b10 = (float) Math.floor(b10);
            }
            this.f34712i = b10;
            this.f34710g = j10;
            if (!this.f34718o || this.f34711h != f12) {
                g();
            }
            if (z10) {
                if (getRepeatCount() != -1 && this.f34713j >= getRepeatCount()) {
                    if (this.f34708e < 0.0f) {
                        m10 = n();
                    } else {
                        m10 = m();
                    }
                    this.f34711h = m10;
                    this.f34712i = m10;
                    v();
                    q();
                    b(p());
                } else {
                    r();
                    d();
                    this.f34713j++;
                    if (getRepeatMode() == 2) {
                        this.f34709f = !this.f34709f;
                        y();
                    } else {
                        if (p()) {
                            n10 = m();
                        } else {
                            n10 = n();
                        }
                        this.f34711h = n10;
                        this.f34712i = n10;
                    }
                    this.f34710g = j10;
                }
            }
            G();
            N.b("LottieValueAnimator#doFrame");
        }
    }

    @Override // android.animation.ValueAnimator
    public float getAnimatedFraction() {
        float n10;
        float m10;
        float n11;
        if (this.f34716m == null) {
            return 0.0f;
        }
        if (p()) {
            n10 = m() - this.f34712i;
            m10 = m();
            n11 = n();
        } else {
            n10 = this.f34712i - n();
            m10 = m();
            n11 = n();
        }
        return n10 / (m10 - n11);
    }

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(j());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        if (this.f34716m == null) {
            return 0L;
        }
        return r2.d();
    }

    public void h() {
        this.f34716m = null;
        this.f34714k = -2.14748365E9f;
        this.f34715l = 2.14748365E9f;
    }

    public void i() {
        v();
        q();
        b(p());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.f34717n;
    }

    public float j() {
        C0820a c0820a = this.f34716m;
        if (c0820a == null) {
            return 0.0f;
        }
        return (this.f34712i - c0820a.p()) / (this.f34716m.f() - this.f34716m.p());
    }

    public float k() {
        return this.f34712i;
    }

    public final float l() {
        C0820a c0820a = this.f34716m;
        if (c0820a == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / c0820a.i()) / Math.abs(this.f34708e);
    }

    public float m() {
        C0820a c0820a = this.f34716m;
        if (c0820a == null) {
            return 0.0f;
        }
        float f10 = this.f34715l;
        if (f10 == 2.14748365E9f) {
            return c0820a.f();
        }
        return f10;
    }

    public float n() {
        C0820a c0820a = this.f34716m;
        if (c0820a == null) {
            return 0.0f;
        }
        float f10 = this.f34714k;
        if (f10 == -2.14748365E9f) {
            return c0820a.p();
        }
        return f10;
    }

    public float o() {
        return this.f34708e;
    }

    public final boolean p() {
        if (o() < 0.0f) {
            return true;
        }
        return false;
    }

    public final void q() {
        try {
            Trace.asyncTraceEnd(Trace.TRACE_TAG_VIEW, "lottie_animator", System.identityHashCode(this));
        } catch (Error | Exception unused) {
        }
    }

    public final void r() {
        try {
            long j10 = Trace.TRACE_TAG_VIEW;
            Trace.traceBegin(j10, "AnimatorStart " + this.f34707d);
            Trace.traceEnd(j10);
            Trace.asyncTraceBegin(j10, "lottie_animator", System.identityHashCode(this));
        } catch (Error | Exception unused) {
        }
    }

    public void s() {
        v();
        q();
        c();
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i10) {
        super.setRepeatMode(i10);
        if (i10 != 2 && this.f34709f) {
            this.f34709f = false;
            y();
        }
    }

    public void t() {
        float n10;
        this.f34717n = true;
        r();
        f(p());
        if (p()) {
            n10 = m();
        } else {
            n10 = n();
        }
        A((int) n10);
        this.f34710g = 0L;
        this.f34713j = 0;
        u();
    }

    public void u() {
        if (isRunning()) {
            w(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    public void v() {
        w(true);
    }

    public void w(boolean z10) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z10) {
            this.f34717n = false;
        }
    }

    public void x() {
        this.f34717n = true;
        u();
        this.f34710g = 0L;
        if (p() && k() == n()) {
            A(m());
        } else if (!p() && k() == m()) {
            A(n());
        }
        r();
        e();
    }

    public void y() {
        E(-o());
    }

    public void z(C0820a c0820a) {
        boolean z10;
        if (this.f34716m == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f34716m = c0820a;
        if (z10) {
            C(Math.max(this.f34714k, c0820a.p()), Math.min(this.f34715l, c0820a.f()));
        } else {
            C((int) c0820a.p(), (int) c0820a.f());
        }
        float f10 = this.f34712i;
        this.f34712i = 0.0f;
        this.f34711h = 0.0f;
        A((int) f10);
        g();
    }
}
