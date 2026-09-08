package com.coui.appcompat.animation;

import android.view.animation.PathInterpolator;

/* loaded from: classes.dex */
public class COUIOutEaseInterpolator extends PathInterpolator {
    private static final float controlX1 = 0.3f;
    private static final float controlX2 = 1.0f;
    private static final float controlY1 = 0.0f;
    private static final float controlY2 = 1.0f;

    public COUIOutEaseInterpolator() {
        super(0.3f, 0.0f, 1.0f, 1.0f);
    }
}
