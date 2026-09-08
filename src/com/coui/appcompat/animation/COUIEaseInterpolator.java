package com.coui.appcompat.animation;

import android.view.animation.PathInterpolator;

/* loaded from: classes.dex */
public class COUIEaseInterpolator extends PathInterpolator {
    private static final float controlX1 = 0.33f;
    private static final float controlX2 = 0.67f;
    private static final float controlY1 = 0.0f;
    private static final float controlY2 = 1.0f;

    public COUIEaseInterpolator() {
        super(controlX1, 0.0f, controlX2, 1.0f);
    }
}
