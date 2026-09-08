package com.oplus.ocs.icdf.commonchannel;

import com.heytap.accessory.constant.FastPairConstants;

/* loaded from: classes3.dex */
public class d {
    public static byte[] a(int i10, int i11, byte[] bArr) {
        byte[] bArr2 = new byte[78];
        bArr2[0] = 105;
        bArr2[1] = 99;
        bArr2[2] = 100;
        bArr2[3] = 102;
        bArr2[4] = 0;
        bArr2[5] = 0;
        bArr2[6] = 0;
        bArr2[7] = 10;
        bArr2[8] = (byte) i10;
        bArr2[9] = 1;
        System.arraycopy(bArr, 0, bArr2, 10, 64);
        bArr2[74] = (byte) ((i11 >> 24) & 255);
        bArr2[75] = (byte) ((i11 >> 16) & 255);
        bArr2[76] = (byte) ((i11 >> 8) & 255);
        bArr2[77] = (byte) (i11 & 255);
        return bArr2;
    }

    public static byte[] b(int i10, int i11, byte[] bArr) {
        byte[] bArr2 = new byte[78];
        bArr2[0] = 105;
        bArr2[1] = 99;
        bArr2[2] = 100;
        bArr2[3] = 102;
        bArr2[4] = 0;
        bArr2[5] = 0;
        bArr2[6] = 0;
        bArr2[7] = 11;
        bArr2[8] = (byte) ((i10 >> 24) & 255);
        bArr2[9] = (byte) ((i10 >> 16) & 255);
        bArr2[10] = (byte) ((i10 >> 8) & 255);
        bArr2[11] = (byte) (i10 & 255);
        bArr2[12] = (byte) (i11 >> 8);
        bArr2[13] = (byte) i11;
        if (bArr != null) {
            System.arraycopy(bArr, 0, bArr2, 14, 64);
        }
        return bArr2;
    }

    public static int a(byte[] bArr) {
        return ((bArr[12] & FastPairConstants.GO_INTENT_NOT_SET) << 8) + (bArr[13] & FastPairConstants.GO_INTENT_NOT_SET);
    }

    public static boolean b(byte[] bArr) {
        return bArr.length == 78 && ((((bArr[0] & FastPairConstants.GO_INTENT_NOT_SET) << 24) + ((bArr[1] & FastPairConstants.GO_INTENT_NOT_SET) << 16)) + ((bArr[2] & FastPairConstants.GO_INTENT_NOT_SET) << 8)) + (bArr[3] & FastPairConstants.GO_INTENT_NOT_SET) == 1768121446 && ((((bArr[4] & FastPairConstants.GO_INTENT_NOT_SET) << 24) + ((bArr[5] & FastPairConstants.GO_INTENT_NOT_SET) << 16)) + ((bArr[6] & FastPairConstants.GO_INTENT_NOT_SET) << 8)) + (bArr[7] & FastPairConstants.GO_INTENT_NOT_SET) == 11;
    }
}
