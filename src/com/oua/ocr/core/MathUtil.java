package com.oua.ocr.core;

/* loaded from: classes4.dex */
public class MathUtil {
    public static double sigmoid(double d10) {
        return 1.0d / (Math.pow(2.718281828459045d, d10 * (-1.0d)) + 1.0d);
    }
}
