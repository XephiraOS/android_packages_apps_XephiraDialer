package com.coui.appcompat.scanview;

import kotlin.jvm.internal.FunctionReferenceImpl;
import v9.l;

/* compiled from: ScanViewRotateHelper.kt */
/* loaded from: classes.dex */
public /* synthetic */ class ScanViewRotateHelper$updateTorchTipGroupLp$1$torchTipMaxWidth$1 extends FunctionReferenceImpl implements l<Integer, Integer> {
    public ScanViewRotateHelper$updateTorchTipGroupLp$1$torchTipMaxWidth$1(Object obj) {
        super(1, obj, ScanViewRotateHelper.class, "getTorchTipGridNumber", "getTorchTipGridNumber(I)I", 0);
    }

    public final Integer invoke(int i10) {
        int torchTipGridNumber;
        torchTipGridNumber = ((ScanViewRotateHelper) this.receiver).getTorchTipGridNumber(i10);
        return Integer.valueOf(torchTipGridNumber);
    }

    @Override // v9.l
    public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
        return invoke(num.intValue());
    }
}
