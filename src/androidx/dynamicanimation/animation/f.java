package androidx.dynamicanimation.animation;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import androidx.dynamicanimation.animation.c;

/* compiled from: SpringAnimation.java */
/* loaded from: classes.dex */
public final class f extends c<f> {

    /* renamed from: A, reason: collision with root package name */
    public g f9728A;

    /* renamed from: B, reason: collision with root package name */
    public float f9729B;

    /* renamed from: C, reason: collision with root package name */
    public boolean f9730C;

    public f(e eVar) {
        super(eVar);
        this.f9728A = null;
        this.f9729B = Float.MAX_VALUE;
        this.f9730C = false;
    }

    @Override // androidx.dynamicanimation.animation.c
    public void p() {
        w();
        this.f9728A.g(f());
        super.p();
    }

    @Override // androidx.dynamicanimation.animation.c
    public boolean r(long j10) {
        if (this.f9730C) {
            float f10 = this.f9729B;
            if (f10 != Float.MAX_VALUE) {
                this.f9728A.e(f10);
                this.f9729B = Float.MAX_VALUE;
            }
            this.f9711b = this.f9728A.a();
            this.f9710a = 0.0f;
            this.f9730C = false;
            return true;
        }
        if (this.f9729B != Float.MAX_VALUE) {
            this.f9728A.a();
            long j11 = j10 / 2;
            c.p h10 = this.f9728A.h(this.f9711b, this.f9710a, j11);
            this.f9728A.e(this.f9729B);
            this.f9729B = Float.MAX_VALUE;
            c.p h11 = this.f9728A.h(h10.f9724a, h10.f9725b, j11);
            this.f9711b = h11.f9724a;
            this.f9710a = h11.f9725b;
        } else {
            c.p h12 = this.f9728A.h(this.f9711b, this.f9710a, j10);
            this.f9711b = h12.f9724a;
            this.f9710a = h12.f9725b;
        }
        float max = Math.max(this.f9711b, this.f9717h);
        this.f9711b = max;
        float min = Math.min(max, this.f9716g);
        this.f9711b = min;
        if (!v(min, this.f9710a)) {
            return false;
        }
        this.f9711b = this.f9728A.a();
        this.f9710a = 0.0f;
        return true;
    }

    public void s(float f10) {
        if (g()) {
            this.f9729B = f10;
            return;
        }
        if (this.f9728A == null) {
            this.f9728A = new g(f10);
        }
        this.f9728A.e(f10);
        p();
    }

    public boolean t() {
        if (this.f9728A.f9732b > 0.0d) {
            return true;
        }
        return false;
    }

    public g u() {
        return this.f9728A;
    }

    public boolean v(float f10, float f11) {
        return this.f9728A.c(f10, f11);
    }

    public final void w() {
        g gVar = this.f9728A;
        if (gVar != null) {
            double a10 = gVar.a();
            if (a10 <= this.f9716g) {
                if (a10 >= this.f9717h) {
                    return;
                } else {
                    throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
                }
            }
            throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
        }
        throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
    }

    public f x(g gVar) {
        this.f9728A = gVar;
        return this;
    }

    public void y() {
        if (t()) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                if (this.f9715f) {
                    this.f9730C = true;
                    return;
                }
                return;
            }
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        }
        throw new UnsupportedOperationException("Spring animations can only come to an end when there is damping");
    }

    public <K> f(K k10, d<K> dVar) {
        super(k10, dVar);
        this.f9728A = null;
        this.f9729B = Float.MAX_VALUE;
        this.f9730C = false;
    }

    public <K> f(K k10, d<K> dVar, float f10) {
        super(k10, dVar);
        this.f9728A = null;
        this.f9729B = Float.MAX_VALUE;
        this.f9730C = false;
        this.f9728A = new g(f10);
    }

    @Override // androidx.dynamicanimation.animation.c
    public void o(float f10) {
    }
}
