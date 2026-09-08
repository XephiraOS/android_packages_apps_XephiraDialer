package com.coui.component.responsiveui.layoutgrid;

import d9.C0959a;

/* compiled from: LayoutGridSystem.kt */
/* loaded from: classes3.dex */
public enum MarginType {
    MARGIN_SMALL(C0959a.f30072d, C0959a.f30076h, C0959a.f30074f),
    MARGIN_LARGE(C0959a.f30071c, C0959a.f30075g, C0959a.f30073e);

    private final int[] resId;

    MarginType(int i10, int i11, int i12) {
        this.resId = new int[]{i10, i11, i12};
    }

    public final int[] resId() {
        return this.resId;
    }
}
