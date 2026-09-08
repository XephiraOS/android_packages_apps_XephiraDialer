package com.coui.appcompat.animation;

import android.view.animation.PathInterpolator;

/* loaded from: classes.dex */
public class COUIInEaseInterpolator extends PathInterpolator {
    private static final float controlX1 = 0.0f;
    private static final float controlX2 = 0.1f;
    private static final float controlY1 = 0.0f;
    private static final float controlY2 = 1.0f;

    public COUIInEaseInterpolator() {
        super(0.0f, 0.0f, 0.1f, 1.0f);
    }
}
