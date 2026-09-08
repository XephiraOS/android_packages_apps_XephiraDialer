package com.coui.appcompat.animation.dynamicanimation;

import com.coui.appcompat.animation.dynamicanimation.COUIDynamicAnimation;

/* loaded from: classes.dex */
public final class COUISpringForce implements COUIForce {
    public static final float DAMPING_RATIO_HIGH_BOUNCY = 0.2f;
    public static final float DAMPING_RATIO_LOW_BOUNCY = 0.75f;
    public static final float DAMPING_RATIO_MEDIUM_BOUNCY = 0.5f;
    public static final float DAMPING_RATIO_NO_BOUNCY = 1.0f;
    public static final float STIFFNESS_HIGH = 10000.0f;
    public static final float STIFFNESS_LOW = 200.0f;
    public static final float STIFFNESS_MEDIUM = 1500.0f;
    public static final float STIFFNESS_VERY_LOW = 50.0f;
    private static final double UNSET = Double.MAX_VALUE;
    private static final double VELOCITY_THRESHOLD_MULTIPLIER = 62.5d;
    private double mDampedFreq;
    double mDampingRatio;
    private double mFinalPosition;
    private double mGammaMinus;
    private double mGammaPlus;
    private boolean mInitialized;
    private final COUIDynamicAnimation.MassState mMassState;
    double mNaturalFreq;
    private double mValueThreshold;
    private double mVelocityThreshold;

    public COUISpringForce() {
        this.mNaturalFreq = Math.sqrt(1500.0d);
        this.mDampingRatio = 0.5d;
        this.mInitialized = false;
        this.mFinalPosition = UNSET;
        this.mMassState = new COUIDynamicAnimation.MassState();
    }

    private void init() {
        if (this.mInitialized) {
            return;
        }
        if (this.mFinalPosition != UNSET) {
            double d10 = this.mDampingRatio;
            if (d10 > 1.0d) {
                double d11 = this.mNaturalFreq;
                this.mGammaPlus = ((-d10) * d11) + (d11 * Math.sqrt((d10 * d10) - 1.0d));
                double d12 = this.mDampingRatio;
                double d13 = this.mNaturalFreq;
                this.mGammaMinus = ((-d12) * d13) - (d13 * Math.sqrt((d12 * d12) - 1.0d));
            } else if (d10 >= 0.0d && d10 < 1.0d) {
                this.mDampedFreq = this.mNaturalFreq * Math.sqrt(1.0d - (d10 * d10));
            }
            this.mInitialized = true;
            return;
        }
        throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
    }

    @Override // com.coui.appcompat.animation.dynamicanimation.COUIForce
    public float getAcceleration(float f10, float f11) {
        float finalPosition = f10 - getFinalPosition();
        double d10 = this.mNaturalFreq;
        return (float) (((-(d10 * d10)) * finalPosition) - (((d10 * 2.0d) * this.mDampingRatio) * f11));
    }

    public float getDampingRatio() {
        return (float) this.mDampingRatio;
    }

    public float getFinalPosition() {
        return (float) this.mFinalPosition;
    }

    public float getStiffness() {
        double d10 = this.mNaturalFreq;
        return (float) (d10 * d10);
    }

    @Override // com.coui.appcompat.animation.dynamicanimation.COUIForce
    public boolean isAtEquilibrium(float f10, float f11) {
        if (Math.abs(f11) < this.mVelocityThreshold && Math.abs(f10 - getFinalPosition()) < this.mValueThreshold) {
            return true;
        }
        return false;
    }

    public COUISpringForce setBounce(float f10) {
        float f11 = 1.0f - f10;
        if (f11 >= 0.0f) {
            return setDampingRatio(f11);
        }
        throw new IllegalArgumentException("Damping ratio must be non-negative");
    }

    public COUISpringForce setDampingRatio(float f10) {
        if (f10 >= 0.0f) {
            this.mDampingRatio = f10;
            this.mInitialized = false;
            return this;
        }
        throw new IllegalArgumentException("Damping ratio must be non-negative");
    }

    public COUISpringForce setFinalPosition(float f10) {
        this.mFinalPosition = f10;
        return this;
    }

    public COUISpringForce setResponse(float f10) {
        if (f10 == 0.0f) {
            f10 = 1.0f;
        }
        float pow = (float) Math.pow(6.283185307179586d / f10, 2.0d);
        if (pow > 0.0f) {
            return setStiffness(pow);
        }
        throw new IllegalArgumentException("Spring stiffness constant must be positive.");
    }

    public COUISpringForce setStiffness(float f10) {
        if (f10 > 0.0f) {
            this.mNaturalFreq = Math.sqrt(f10);
            this.mInitialized = false;
            return this;
        }
        throw new IllegalArgumentException("Spring stiffness constant must be positive.");
    }

    public void setValueThreshold(double d10) {
        double abs = Math.abs(d10);
        this.mValueThreshold = abs;
        this.mVelocityThreshold = abs * VELOCITY_THRESHOLD_MULTIPLIER;
    }

    public COUIDynamicAnimation.MassState updateValues(double d10, double d11, long j10) {
        double cos;
        double d12;
        init();
        double d13 = j10 / 1000.0d;
        double d14 = d10 - this.mFinalPosition;
        double d15 = this.mDampingRatio;
        if (d15 > 1.0d) {
            double d16 = this.mGammaMinus;
            double d17 = this.mGammaPlus;
            double d18 = d14 - (((d16 * d14) - d11) / (d16 - d17));
            double d19 = ((d14 * d16) - d11) / (d16 - d17);
            d12 = (Math.pow(2.718281828459045d, d16 * d13) * d18) + (Math.pow(2.718281828459045d, this.mGammaPlus * d13) * d19);
            double d20 = this.mGammaMinus;
            double pow = d18 * d20 * Math.pow(2.718281828459045d, d20 * d13);
            double d21 = this.mGammaPlus;
            cos = pow + (d19 * d21 * Math.pow(2.718281828459045d, d21 * d13));
        } else if (d15 == 1.0d) {
            double d22 = this.mNaturalFreq;
            double d23 = d11 + (d22 * d14);
            double d24 = d14 + (d23 * d13);
            d12 = Math.pow(2.718281828459045d, (-d22) * d13) * d24;
            double pow2 = d24 * Math.pow(2.718281828459045d, (-this.mNaturalFreq) * d13);
            double d25 = this.mNaturalFreq;
            cos = (d23 * Math.pow(2.718281828459045d, (-d25) * d13)) + (pow2 * (-d25));
        } else {
            double d26 = 1.0d / this.mDampedFreq;
            double d27 = this.mNaturalFreq;
            double d28 = d26 * ((d15 * d27 * d14) + d11);
            double pow3 = Math.pow(2.718281828459045d, (-d15) * d27 * d13) * ((Math.cos(this.mDampedFreq * d13) * d14) + (Math.sin(this.mDampedFreq * d13) * d28));
            double d29 = this.mNaturalFreq;
            double d30 = this.mDampingRatio;
            double d31 = (-d29) * pow3 * d30;
            double pow4 = Math.pow(2.718281828459045d, (-d30) * d29 * d13);
            double d32 = this.mDampedFreq;
            double sin = (-d32) * d14 * Math.sin(d32 * d13);
            double d33 = this.mDampedFreq;
            cos = d31 + (pow4 * (sin + (d28 * d33 * Math.cos(d33 * d13))));
            d12 = pow3;
        }
        COUIDynamicAnimation.MassState massState = this.mMassState;
        massState.mValue = (float) (d12 + this.mFinalPosition);
        massState.mVelocity = (float) cos;
        return massState;
    }

    public COUISpringForce(float f10) {
        this.mNaturalFreq = Math.sqrt(1500.0d);
        this.mDampingRatio = 0.5d;
        this.mInitialized = false;
        this.mFinalPosition = UNSET;
        this.mMassState = new COUIDynamicAnimation.MassState();
        this.mFinalPosition = f10;
    }
}
