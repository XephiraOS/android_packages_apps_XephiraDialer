package com.google.android.material.internal;

import android.animation.TimeInterpolator;

/* loaded from: classes3.dex */
public class ReversableAnimatedValueInterpolator implements TimeInterpolator {
    private final TimeInterpolator sourceInterpolator;

    public ReversableAnimatedValueInterpolator(TimeInterpolator timeInterpolator) {
        this.sourceInterpolator = timeInterpolator;
    }

    public static TimeInterpolator of(boolean z10, TimeInterpolator timeInterpolator) {
        if (z10) {
            return timeInterpolator;
        }
        return new ReversableAnimatedValueInterpolator(timeInterpolator);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f10) {
        return 1.0f - this.sourceInterpolator.getInterpolation(f10);
    }
}
