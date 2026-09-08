package com.oua.ocr.bc;

/* compiled from: libBCREngine.java */
/* loaded from: classes4.dex */
enum ItemType {
    Name(0),
    Nickname(11),
    Company(1),
    Phone(3),
    Email(2),
    Address(5),
    SNS(9),
    IM(7),
    Website(6),
    TYPE_ANNIVERSARY(12);

    private final int value;

    ItemType(int i10) {
        this.value = i10;
    }

    public final int getValue() {
        return this.value;
    }
}
