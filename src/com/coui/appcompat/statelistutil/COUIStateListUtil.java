package com.coui.appcompat.statelistutil;

import android.content.res.ColorStateList;

/* loaded from: classes.dex */
public class COUIStateListUtil {
    private static final int[] EMPTY_STATE_SET = new int[0];

    public static ColorStateList createColorStateList(int i10, int i11) {
        return new ColorStateList(new int[][]{new int[]{-16842910}, EMPTY_STATE_SET}, new int[]{i11, i10});
    }

    public static ColorStateList createColorStateList(int i10, int i11, int i12, int i13) {
        return new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{16842910, 16842913}, new int[]{16842910, 16842919}, EMPTY_STATE_SET}, new int[]{i11, i12, i13, i10});
    }
}
