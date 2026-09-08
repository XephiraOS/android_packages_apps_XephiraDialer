package com.google.common.base;

/* compiled from: Ascii.java */
/* loaded from: classes3.dex */
public final class a {
    public static boolean a(char c10) {
        if (c10 >= 'A' && c10 <= 'Z') {
            return true;
        }
        return false;
    }

    public static String b(String str) {
        int length = str.length();
        int i10 = 0;
        while (i10 < length) {
            if (a(str.charAt(i10))) {
                char[] charArray = str.toCharArray();
                while (i10 < length) {
                    char c10 = charArray[i10];
                    if (a(c10)) {
                        charArray[i10] = (char) (c10 ^ ' ');
                    }
                    i10++;
                }
                return String.valueOf(charArray);
            }
            i10++;
        }
        return str;
    }
}
