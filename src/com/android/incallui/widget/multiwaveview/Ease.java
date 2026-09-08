package com.android.incallui.widget.multiwaveview;

import android.animation.TimeInterpolator;

/* loaded from: classes.dex */
class Ease {
    private static final float DOMAIN = 1.0f;
    private static final float DURATION = 1.0f;
    private static final float START = 0.0f;

    /* loaded from: classes.dex */
    public static class Cubic {
        public static final TimeInterpolator easeIn = new TimeInterpolator() { // from class: com.android.incallui.widget.multiwaveview.Ease.Cubic.1
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f10) {
                float f11 = f10 / 1.0f;
                return (1.0f * f11 * f11 * f11) + 0.0f;
            }
        };
        public static final TimeInterpolator easeOut = new TimeInterpolator() { // from class: com.android.incallui.widget.multiwaveview.Ease.Cubic.2
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f10) {
                float f11 = (f10 / 1.0f) - 1.0f;
                return (((f11 * f11 * f11) + 1.0f) * 1.0f) + 0.0f;
            }
        };
        public static final TimeInterpolator easeInOut = new TimeInterpolator() { // from class: com.android.incallui.widget.multiwaveview.Ease.Cubic.3
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f10) {
                float f11 = f10 / 0.5f;
                if (f11 < 1.0f) {
                    return (0.5f * f11 * f11 * f11) + 0.0f;
                }
                float f12 = f11 - 2.0f;
                return (((f12 * f12 * f12) + 2.0f) * 0.5f) + 0.0f;
            }
        };
    }

    /* loaded from: classes.dex */
    public static class Linear {
        public static final TimeInterpolator easeNone = new TimeInterpolator() { // from class: com.android.incallui.widget.multiwaveview.Ease.Linear.1
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f10) {
                return f10;
            }
        };
    }

    /* loaded from: classes.dex */
    public static class Quad {
        public static final TimeInterpolator easeIn = new TimeInterpolator() { // from class: com.android.incallui.widget.multiwaveview.Ease.Quad.1
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f10) {
                float f11 = f10 / 1.0f;
                return (1.0f * f11 * f11) + 0.0f;
            }
        };
        public static final TimeInterpolator easeOut = new TimeInterpolator() { // from class: com.android.incallui.widget.multiwaveview.Ease.Quad.2
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f10) {
                float f11 = f10 / 1.0f;
                return ((-1.0f) * f11 * (f11 - 2.0f)) + 0.0f;
            }
        };
        public static final TimeInterpolator easeInOut = new TimeInterpolator() { // from class: com.android.incallui.widget.multiwaveview.Ease.Quad.3
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f10) {
                float f11 = f10 / 0.5f;
                if (f11 < 1.0f) {
                    return (0.5f * f11 * f11) + 0.0f;
                }
                float f12 = f11 - 1.0f;
                return (((f12 * (f12 - 2.0f)) - 1.0f) * (-0.5f)) + 0.0f;
            }
        };
    }

    /* loaded from: classes.dex */
    public static class Quart {
        public static final TimeInterpolator easeIn = new TimeInterpolator() { // from class: com.android.incallui.widget.multiwaveview.Ease.Quart.1
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f10) {
                float f11 = f10 / 1.0f;
                return (1.0f * f11 * f11 * f11 * f11) + 0.0f;
            }
        };
        public static final TimeInterpolator easeOut = new TimeInterpolator() { // from class: com.android.incallui.widget.multiwaveview.Ease.Quart.2
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f10) {
                float f11 = (f10 / 1.0f) - 1.0f;
                return (((((f11 * f11) * f11) * f11) - 1.0f) * (-1.0f)) + 0.0f;
            }
        };
        public static final TimeInterpolator easeInOut = new TimeInterpolator() { // from class: com.android.incallui.widget.multiwaveview.Ease.Quart.3
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f10) {
                float f11 = f10 / 0.5f;
                if (f11 < 1.0f) {
                    return (0.5f * f11 * f11 * f11 * f11) + 0.0f;
                }
                float f12 = f11 - 2.0f;
                return (((((f12 * f12) * f12) * f12) - 2.0f) * (-0.5f)) + 0.0f;
            }
        };
    }

    /* loaded from: classes.dex */
    public static class Quint {
        public static final TimeInterpolator easeIn = new TimeInterpolator() { // from class: com.android.incallui.widget.multiwaveview.Ease.Quint.1
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f10) {
                float f11 = f10 / 1.0f;
                return (1.0f * f11 * f11 * f11 * f11 * f11) + 0.0f;
            }
        };
        public static final TimeInterpolator easeOut = new TimeInterpolator() { // from class: com.android.incallui.widget.multiwaveview.Ease.Quint.2
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f10) {
                float f11 = (f10 / 1.0f) - 1.0f;
                return (((f11 * f11 * f11 * f11 * f11) + 1.0f) * 1.0f) + 0.0f;
            }
        };
        public static final TimeInterpolator easeInOut = new TimeInterpolator() { // from class: com.android.incallui.widget.multiwaveview.Ease.Quint.3
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f10) {
                float f11 = f10 / 0.5f;
                if (f11 < 1.0f) {
                    return (0.5f * f11 * f11 * f11 * f11 * f11) + 0.0f;
                }
                float f12 = f11 - 2.0f;
                return (((f12 * f12 * f12 * f12 * f12) + 2.0f) * 0.5f) + 0.0f;
            }
        };
    }

    /* loaded from: classes.dex */
    public static class Sine {
        public static final TimeInterpolator easeIn = new TimeInterpolator() { // from class: com.android.incallui.widget.multiwaveview.Ease.Sine.1
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f10) {
                return (((float) Math.cos((f10 / 1.0f) * 1.5707963267948966d)) * (-1.0f)) + 1.0f + 0.0f;
            }
        };
        public static final TimeInterpolator easeOut = new TimeInterpolator() { // from class: com.android.incallui.widget.multiwaveview.Ease.Sine.2
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f10) {
                return (((float) Math.sin((f10 / 1.0f) * 1.5707963267948966d)) * 1.0f) + 0.0f;
            }
        };
        public static final TimeInterpolator easeInOut = new TimeInterpolator() { // from class: com.android.incallui.widget.multiwaveview.Ease.Sine.3
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f10) {
                return ((((float) Math.cos((f10 * 3.141592653589793d) / 1.0d)) - 1.0f) * (-0.5f)) + 0.0f;
            }
        };
    }
}
