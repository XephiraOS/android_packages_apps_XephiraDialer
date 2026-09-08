package com.google.zxing.qrcode.decoder;

/* loaded from: classes3.dex */
public enum ErrorCorrectionLevel {
    L(1),
    M(0),
    Q(3),
    H(2);


    /* renamed from: e, reason: collision with root package name */
    public static final ErrorCorrectionLevel[] f25107e;
    private final int bits;

    static {
        ErrorCorrectionLevel errorCorrectionLevel = L;
        ErrorCorrectionLevel errorCorrectionLevel2 = M;
        ErrorCorrectionLevel errorCorrectionLevel3 = Q;
        f25107e = new ErrorCorrectionLevel[]{errorCorrectionLevel2, errorCorrectionLevel, H, errorCorrectionLevel3};
    }

    ErrorCorrectionLevel(int i10) {
        this.bits = i10;
    }

    public static ErrorCorrectionLevel a(int i10) {
        if (i10 >= 0) {
            ErrorCorrectionLevel[] errorCorrectionLevelArr = f25107e;
            if (i10 < errorCorrectionLevelArr.length) {
                return errorCorrectionLevelArr[i10];
            }
        }
        throw new IllegalArgumentException();
    }

    public int b() {
        return this.bits;
    }
}
