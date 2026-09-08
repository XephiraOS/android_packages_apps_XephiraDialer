package com.coui.appcompat.scanview;

import kotlin.jvm.internal.FunctionReferenceImpl;
import v9.l;

/* compiled from: ScanViewRotateHelper.kt */
/* loaded from: classes.dex */
public /* synthetic */ class ScanViewRotateHelper$updateFinderViewLp$finderHolderWidth$1 extends FunctionReferenceImpl implements l<Integer, Integer> {
    public ScanViewRotateHelper$updateFinderViewLp$finderHolderWidth$1(Object obj) {
        super(1, obj, ScanViewRotateHelper.class, "getFinderViewGridNumber", "getFinderViewGridNumber(I)I", 0);
    }

    public final Integer invoke(int i10) {
        int finderViewGridNumber;
        finderViewGridNumber = ((ScanViewRotateHelper) this.receiver).getFinderViewGridNumber(i10);
        return Integer.valueOf(finderViewGridNumber);
    }

    @Override // v9.l
    public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
        return invoke(num.intValue());
    }
}
