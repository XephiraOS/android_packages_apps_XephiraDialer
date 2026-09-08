package com.heytap.accessory.bean;

import com.heytap.accessory.type.AdvAdditionDataType;
import java.util.Arrays;
import n5.C1371a;
import r5.j;

/* loaded from: classes3.dex */
public class AdditionDataInfo {
    private static final String TAG = "AdditionDataInfo";
    public static final int TLV_LEN_BITS = 5;
    public static final int TLV_MAX_VALUE_LEN = 31;
    private static final int TLV_TYPE_BITS = 3;

    public static byte[] getAdditionData(AdvAdditionDataType advAdditionDataType, byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            if (!isAdditionDataValid(bArr)) {
                C1371a.k(TAG, "old addition data is not in TLV format");
                return new byte[0];
            }
            int i10 = 0;
            while (i10 < bArr.length) {
                byte b10 = bArr[i10];
                int i11 = b10 >>> 5;
                int i12 = b10 & 31;
                int i13 = i10 + i12 + 1;
                if (i13 > bArr.length) {
                    C1371a.k(TAG, "getAdditionData out of range, index=" + i10 + ",len=" + i12 + ",totol=" + bArr.length);
                    return new byte[0];
                }
                if (i11 == advAdditionDataType.a()) {
                    return Arrays.copyOfRange(bArr, i10 + 1, i13);
                }
                i10 += i12 + 1;
            }
            return new byte[0];
        }
        C1371a.c(TAG, "additionData is empty");
        return new byte[0];
    }

    private static boolean isAdditionDataValid(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            int i10 = 0;
            while (i10 < bArr.length) {
                int i11 = bArr[i10] & 31;
                if (i10 + i11 + 1 > bArr.length) {
                    C1371a.k(TAG, "addition data is invalid, index=" + i10 + ",len=" + i11 + ",totol=" + bArr.length);
                    return false;
                }
                i10 += i11 + 1;
            }
        }
        return true;
    }

    private static boolean isContainsType(AdvAdditionDataType advAdditionDataType, byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            int i10 = 0;
            while (i10 < bArr.length) {
                if ((bArr[i10] >>> 5) == advAdditionDataType.a()) {
                    return true;
                }
                int i11 = bArr[i10] & 31;
                if (i10 + i11 + 1 > bArr.length) {
                    C1371a.k(TAG, "addition data is invalid, index=" + i10 + ",len=" + i11 + ",totol=" + bArr.length);
                    return false;
                }
                i10 += i11 + 1;
            }
        }
        return false;
    }

    public static byte[] setAdditionData(AdvAdditionDataType advAdditionDataType, byte[] bArr, byte[] bArr2) {
        Object valueOf;
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("setAdditionData type=");
        sb.append(advAdditionDataType.a());
        sb.append(", len");
        if (bArr == null) {
            valueOf = "null";
        } else {
            valueOf = Integer.valueOf(bArr.length);
        }
        sb.append(valueOf);
        C1371a.c(str, sb.toString());
        if (bArr != null && bArr.length != 0) {
            if (!isAdditionDataValid(bArr2)) {
                C1371a.k(str, "old addition data is not in TLV format");
                return bArr2;
            }
            if (isContainsType(advAdditionDataType, bArr2)) {
                C1371a.k(str, "addition data already contains type " + advAdditionDataType.a());
                return bArr2;
            }
            int length = bArr.length + 1;
            byte[] bArr3 = new byte[length];
            bArr3[0] = (byte) ((advAdditionDataType.a() << 5) + (bArr.length & 31));
            j.a(bArr, 0, bArr3, 1, bArr.length);
            if (bArr2 != null && bArr2.length != 0) {
                byte[] bArr4 = new byte[bArr2.length + length];
                j.a(bArr2, 0, bArr4, 0, bArr2.length);
                j.a(bArr3, 0, bArr4, bArr2.length, length);
                return bArr4;
            }
            if (length > 31) {
                C1371a.k(str, "additionData is too long");
                return bArr2;
            }
            return bArr3;
        }
        C1371a.k(str, "additionData is empty");
        return bArr2;
    }
}
