package com.heytap.accessory.type;

/* loaded from: classes3.dex */
public enum AdvAdditionDataType {
    TRANSPARENT(1),
    ABILITY(2),
    ACCOUNT(3);

    private final int type;

    AdvAdditionDataType(int i10) {
        this.type = i10;
    }

    public int a() {
        return this.type;
    }
}
