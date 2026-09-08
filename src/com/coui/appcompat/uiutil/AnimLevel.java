package com.coui.appcompat.uiutil;

/* loaded from: classes3.dex */
public enum AnimLevel {
    HIGN_END(1),
    MID_END(2),
    LOW_END(3),
    ULTRA_LOW_END(4);

    private final int mIntValue;

    AnimLevel(int i10) {
        this.mIntValue = i10;
    }

    public int getIntValue() {
        return this.mIntValue;
    }

    public static AnimLevel valueOf(int i10) {
        for (AnimLevel animLevel : values()) {
            if (animLevel.getIntValue() == i10) {
                return animLevel;
            }
        }
        throw new IllegalArgumentException("AnimLevel Invalid int value");
    }
}
