package com.google.common.collect;

/* loaded from: classes3.dex */
public enum BoundType {
    OPEN(false),
    CLOSED(true);

    final boolean inclusive;

    BoundType(boolean z10) {
        this.inclusive = z10;
    }

    public static BoundType b(boolean z10) {
        if (z10) {
            return CLOSED;
        }
        return OPEN;
    }
}
