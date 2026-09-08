package com.ted.number;

import android.text.TextUtils;

/* compiled from: XmlUtils.java */
/* loaded from: classes4.dex */
public class u {
    public static final int a(CharSequence charSequence, int i10) {
        int i11;
        int i12;
        if (TextUtils.isEmpty(charSequence)) {
            return i10;
        }
        String charSequence2 = charSequence.toString();
        int length = charSequence2.length();
        if ('-' == charSequence2.charAt(0)) {
            i12 = -1;
            i11 = 1;
        } else {
            i11 = 0;
            i12 = 1;
        }
        int i13 = 16;
        if ('0' == charSequence2.charAt(i11)) {
            if (i11 == length - 1) {
                return 0;
            }
            int i14 = i11 + 1;
            char charAt = charSequence2.charAt(i14);
            if ('x' != charAt && 'X' != charAt) {
                i13 = 8;
                i11 = i14;
            } else {
                i11 += 2;
            }
        } else if ('#' == charSequence2.charAt(i11)) {
            i11++;
        } else {
            i13 = 10;
        }
        return Integer.parseInt(charSequence2.substring(i11), i13) * i12;
    }
}
