package com.coui.appcompat.animation;

import android.view.animation.BaseInterpolator;

/* loaded from: classes.dex */
public class COUISpringInterpolator extends BaseInterpolator {
    private static final double DEFAULT_DAMPINGRATIO = 1.15d;
    private static final double DEFAULT_STIFFNESS = 40.0d;
    private static final float DEFAULT_VELOCITY_UNIT = 15000.0f;
    private static final double VELOCITY_MAX = 20000.0d;
    private double mAngularFreq;
    private final float mCutRatio;
    private final double mDampingRatio;
    private float mFinalValue;
    private final double mImpulse;
    private final double mInitialVel;
    private final double mUnDampedAngularFreq;

    public COUISpringInterpolator(double d10, double d11) {
        this(d10, d11, 0.0d, DEFAULT_VELOCITY_UNIT);
    }

    private float getOriginInterpolation(float f10) {
        double sinh;
        double exp;
        float f11 = 0.0f;
        if (f10 >= 0.0f) {
            f11 = f10;
        }
        double d10 = f11 * this.mCutRatio;
        double exp2 = Math.exp((-this.mDampingRatio) * this.mUnDampedAngularFreq * d10);
        double d11 = this.mDampingRatio;
        if (d11 < 1.0d) {
            sinh = Math.cos(this.mAngularFreq * d10) + (this.mImpulse * Math.sin(this.mAngularFreq * d10));
        } else {
            if (Double.compare(1.0d, d11) == 0) {
                exp = ((this.mImpulse * d10) + 1.0d) * Math.exp((-r0) * this.mUnDampedAngularFreq);
                return (float) (1.0d - exp);
            }
            double d12 = this.mUnDampedAngularFreq;
            double d13 = this.mDampingRatio;
            double sqrt = d12 * Math.sqrt((d13 * d13) - 1.0d);
            exp2 /= sqrt;
            double d14 = (-this.mInitialVel) + (this.mDampingRatio * this.mUnDampedAngularFreq);
            double d15 = f10 * sqrt;
            sinh = (d14 * Math.sinh(d15)) + (sqrt * Math.cosh(d15));
        }
        exp = exp2 * sinh;
        return (float) (1.0d - exp);
    }

    public float getCutRatio() {
        return this.mCutRatio;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f10) {
        if (this.mFinalValue == -1.0f) {
            float f11 = 1.0f;
            float originInterpolation = getOriginInterpolation(1.0f);
            if (originInterpolation != 0.0f) {
                f11 = originInterpolation;
            }
            this.mFinalValue = f11;
        }
        return getOriginInterpolation(f10) / this.mFinalValue;
    }

    public float getSpeed(float f10) {
        double abs;
        float f11 = 0.0f;
        if (f10 >= 0.0f) {
            f11 = f10;
        }
        double d10 = f11;
        double exp = Math.exp((-this.mCutRatio) * this.mDampingRatio * this.mUnDampedAngularFreq * d10);
        double d11 = this.mDampingRatio;
        if (d11 < 1.0d) {
            float f12 = this.mCutRatio;
            double d12 = this.mImpulse;
            double d13 = this.mUnDampedAngularFreq;
            double d14 = this.mAngularFreq;
            abs = Math.abs(exp * (((-f12) * ((d12 * d11 * d13) + d14) * Math.sin(f12 * d14 * d10)) + (f12 * ((d12 * d14) - (d11 * d13)) * Math.cos(this.mCutRatio * this.mAngularFreq * d10))));
        } else if (Double.compare(1.0d, d11) == 0) {
            float f13 = this.mCutRatio;
            double d15 = this.mImpulse;
            double d16 = this.mUnDampedAngularFreq;
            abs = Math.abs(f13 * ((d15 - d16) - (((d15 * f13) * d16) * d10)) * Math.exp((-f13) * d16 * d10));
        } else {
            double d17 = this.mUnDampedAngularFreq;
            double d18 = this.mDampingRatio;
            double sqrt = d17 * Math.sqrt((d18 * d18) - 1.0d);
            float f14 = this.mCutRatio;
            double d19 = this.mInitialVel;
            double d20 = this.mDampingRatio;
            double d21 = this.mUnDampedAngularFreq;
            double d22 = f14 * (((sqrt * sqrt) + ((d19 * d20) * d21)) - (((d20 * d20) * d21) * d21));
            double d23 = (-f14) * d19 * sqrt;
            double d24 = f10;
            abs = Math.abs((exp / sqrt) * ((d22 * Math.sinh(f14 * sqrt * d24)) + (d23 * Math.cosh(this.mCutRatio * sqrt * d24))));
        }
        return (float) abs;
    }

    public COUISpringInterpolator(double d10, double d11, double d12, float f10) {
        this(Math.pow(6.283185307179586d / (d10 == 0.0d ? 1.0d : d10), 2.0d), 1.0d - d11, d12, 1.0f, f10);
    }

    public COUISpringInterpolator(double d10, double d11, double d12, float f10, float f11) {
        this.mFinalValue = -1.0f;
        double sqrt = Math.sqrt(d10 <= 0.0d ? DEFAULT_STIFFNESS : d10);
        this.mUnDampedAngularFreq = sqrt;
        d11 = d11 <= 0.0d ? DEFAULT_DAMPINGRATIO : d11;
        this.mDampingRatio = d11;
        double min = Math.min(Math.abs(d12), VELOCITY_MAX) / (f11 <= 0.0f ? DEFAULT_VELOCITY_UNIT : f11);
        this.mInitialVel = min;
        this.mCutRatio = f10 <= 0.0f ? 1.0f : f10;
        if (d11 < 1.0d) {
            double sqrt2 = Math.sqrt(1.0d - (d11 * d11)) * sqrt;
            this.mAngularFreq = sqrt2;
            this.mImpulse = ((d11 * sqrt) - min) / sqrt2;
        } else if (Double.compare(1.0d, d11) == 0) {
            this.mImpulse = (-min) + sqrt;
        } else {
            this.mImpulse = (-min) + (d11 * sqrt);
        }
    }
}
