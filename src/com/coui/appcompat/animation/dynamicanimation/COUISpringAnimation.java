package com.coui.appcompat.animation.dynamicanimation;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import androidx.dynamicanimation.animation.d;
import androidx.dynamicanimation.animation.e;
import com.coui.appcompat.animation.dynamicanimation.COUIDynamicAnimation;

/* loaded from: classes.dex */
public final class COUISpringAnimation extends COUIDynamicAnimation<COUISpringAnimation> {
    private static final float UNSET = Float.MAX_VALUE;
    private boolean mEndRequested;
    private float mPendingPosition;
    private COUISpringForce mSpring;

    public COUISpringAnimation(e eVar) {
        super(eVar);
        this.mSpring = null;
        this.mPendingPosition = UNSET;
        this.mEndRequested = false;
    }

    private void sanityCheck() {
        COUISpringForce cOUISpringForce = this.mSpring;
        if (cOUISpringForce != null) {
            double finalPosition = cOUISpringForce.getFinalPosition();
            if (finalPosition <= this.mMaxValue) {
                if (finalPosition >= this.mMinValue) {
                    return;
                } else {
                    throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
                }
            }
            throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
        }
        throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
    }

    public void animateToFinalPosition(float f10) {
        if (isRunning()) {
            this.mPendingPosition = f10;
            return;
        }
        if (this.mSpring == null) {
            this.mSpring = new COUISpringForce(f10);
        }
        this.mSpring.setFinalPosition(f10);
        start();
    }

    public boolean canSkipToEnd() {
        if (this.mSpring.mDampingRatio > 0.0d) {
            return true;
        }
        return false;
    }

    @Override // com.coui.appcompat.animation.dynamicanimation.COUIDynamicAnimation
    public float getAcceleration(float f10, float f11) {
        return this.mSpring.getAcceleration(f10, f11);
    }

    public COUISpringForce getSpring() {
        return this.mSpring;
    }

    @Override // com.coui.appcompat.animation.dynamicanimation.COUIDynamicAnimation
    public boolean isAtEquilibrium(float f10, float f11) {
        return this.mSpring.isAtEquilibrium(f10, f11);
    }

    public void reset() {
        if (canSkipToEnd()) {
            cancel();
            float f10 = this.mPendingPosition;
            if (f10 != UNSET) {
                this.mSpring.setFinalPosition(f10);
                this.mPendingPosition = UNSET;
            }
            this.mValue = this.mSpring.getFinalPosition();
            this.mVelocity = 0.0f;
            this.mEndRequested = false;
            return;
        }
        throw new UnsupportedOperationException("Spring animations can only come to an end when there is damping");
    }

    public COUISpringAnimation setSpring(COUISpringForce cOUISpringForce) {
        this.mSpring = cOUISpringForce;
        return this;
    }

    public void skipToEnd() {
        if (canSkipToEnd()) {
            if (!this.mEnableNonMainThread && Looper.myLooper() != Looper.getMainLooper()) {
                throw new AndroidRuntimeException("Animations may only be started on the main thread");
            }
            if (this.mRunning) {
                this.mEndRequested = true;
                return;
            }
            return;
        }
        throw new UnsupportedOperationException("Spring animations can only come to an end when there is damping");
    }

    @Override // com.coui.appcompat.animation.dynamicanimation.COUIDynamicAnimation
    public void start() {
        sanityCheck();
        this.mSpring.setValueThreshold(getValueThreshold());
        super.start();
    }

    @Override // com.coui.appcompat.animation.dynamicanimation.COUIDynamicAnimation
    public boolean updateValueAndVelocity(long j10) {
        if (this.mEndRequested) {
            float f10 = this.mPendingPosition;
            if (f10 != UNSET) {
                this.mSpring.setFinalPosition(f10);
                this.mPendingPosition = UNSET;
            }
            this.mValue = this.mSpring.getFinalPosition();
            this.mVelocity = 0.0f;
            this.mEndRequested = false;
            return true;
        }
        if (this.mPendingPosition != UNSET) {
            this.mSpring.getFinalPosition();
            long j11 = j10 / 2;
            COUIDynamicAnimation.MassState updateValues = this.mSpring.updateValues(this.mValue, this.mVelocity, j11);
            this.mSpring.setFinalPosition(this.mPendingPosition);
            this.mPendingPosition = UNSET;
            COUIDynamicAnimation.MassState updateValues2 = this.mSpring.updateValues(updateValues.mValue, updateValues.mVelocity, j11);
            this.mValue = updateValues2.mValue;
            this.mVelocity = updateValues2.mVelocity;
        } else {
            COUIDynamicAnimation.MassState updateValues3 = this.mSpring.updateValues(this.mValue, this.mVelocity, j10);
            this.mValue = updateValues3.mValue;
            this.mVelocity = updateValues3.mVelocity;
        }
        float max = Math.max(this.mValue, this.mMinValue);
        this.mValue = max;
        float min = Math.min(max, this.mMaxValue);
        this.mValue = min;
        if (!isAtEquilibrium(min, this.mVelocity)) {
            return false;
        }
        this.mValue = this.mSpring.getFinalPosition();
        this.mVelocity = 0.0f;
        return true;
    }

    public <K> COUISpringAnimation(K k10, d<K> dVar) {
        super(k10, dVar);
        this.mSpring = null;
        this.mPendingPosition = UNSET;
        this.mEndRequested = false;
    }

    public <K> COUISpringAnimation(K k10, d<K> dVar, float f10) {
        super(k10, dVar);
        this.mSpring = null;
        this.mPendingPosition = UNSET;
        this.mEndRequested = false;
        this.mSpring = new COUISpringForce(f10);
    }

    @Override // com.coui.appcompat.animation.dynamicanimation.COUIDynamicAnimation
    public void setValueThreshold(float f10) {
    }
}
