package com.android.contacts;

import android.text.TextUtils;

/* compiled from: HighLightInfo.java */
/* loaded from: classes.dex */
public class O0 {

    /* renamed from: a, reason: collision with root package name */
    public final int f13160a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f13161b;

    /* renamed from: c, reason: collision with root package name */
    public final int f13162c;

    /* renamed from: d, reason: collision with root package name */
    public final int f13163d;

    /* renamed from: e, reason: collision with root package name */
    public final int f13164e;

    public O0(int i10, int[] iArr, int i11, int i12, int i13) {
        this.f13160a = i10;
        this.f13161b = iArr;
        this.f13162c = i11;
        this.f13163d = i12;
        this.f13164e = i13;
    }

    public static int[] a(String str) {
        if (str == null || str.length() < 12 || str.startsWith("999")) {
            return null;
        }
        int length = str.length();
        if (length % 3 != 0) {
            return null;
        }
        int[] iArr = new int[(length / 3) - 3];
        int i10 = 0;
        int i11 = 9;
        while (i11 < length) {
            if ('0' <= str.charAt(i11) && str.charAt(i11) <= '9') {
                int i12 = i11 + 1;
                if ('0' <= str.charAt(i12) && str.charAt(i12) <= '9') {
                    int i13 = i11 + 2;
                    if ('0' <= str.charAt(i13) && str.charAt(i13) <= '9') {
                        iArr[i10] = ((str.charAt(i11) - '0') * 100) + ((str.charAt(i12) - '0') * 10) + (str.charAt(i13) - '0');
                        i11 += 3;
                        i10++;
                    }
                }
            }
            return null;
        }
        return iArr;
    }

    public static int b(String str) {
        if (str == null || str.length() < 12 || str.startsWith("999") || '0' > str.charAt(4) || str.charAt(4) > '9' || '0' > str.charAt(5) || str.charAt(5) > '9' || '0' > str.charAt(6) || str.charAt(6) > '9') {
            return 0;
        }
        return ((str.charAt(4) - '0') * 100) + ((str.charAt(5) - '0') * 10) + (str.charAt(6) - '0');
    }

    public static int c(String str) {
        if (!TextUtils.isEmpty(str) && str.length() >= 9) {
            int charAt = str.charAt(8) - '0';
            if (charAt != 1 && charAt != 2) {
                return 0;
            }
            return charAt;
        }
        return -1;
    }

    public static O0 d(String str) {
        int i10;
        int i11;
        Exception e10;
        int i12;
        int[] iArr;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int[] iArr2 = null;
        int i18 = -1;
        try {
            i12 = c(str);
            try {
                i10 = b(str);
                try {
                    iArr2 = a(str);
                    if (iArr2 != null && iArr2.length > 0) {
                        if (str.charAt(0) == '0') {
                            i11 = 1;
                        } else {
                            i11 = 0;
                        }
                        try {
                            i17 = iArr2[0];
                            i18 = i11;
                        } catch (Exception e11) {
                            e10 = e11;
                            H7.b.c("HighLightInfo", "Parse HighLightInfo: " + str + ", exception: " + e10);
                            iArr = iArr2;
                            i13 = -1;
                            i14 = i12;
                            i15 = i10;
                            i16 = i11;
                            return new O0(i14, iArr, i16, i13, i15);
                        }
                    } else {
                        i17 = -1;
                    }
                    i13 = i17;
                    iArr = iArr2;
                    i16 = i18;
                    i14 = i12;
                    i15 = i10;
                } catch (Exception e12) {
                    e10 = e12;
                    i11 = -1;
                }
            } catch (Exception e13) {
                i11 = -1;
                i10 = 0;
                e10 = e13;
            }
        } catch (Exception e14) {
            i10 = 0;
            i11 = -1;
            e10 = e14;
            i12 = 0;
        }
        return new O0(i14, iArr, i16, i13, i15);
    }
}
