package com.google.common.base;

import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: Strings.java */
/* loaded from: classes3.dex */
public final class n {
    public static String a(String str) {
        return j.a(str);
    }

    public static boolean b(String str) {
        return j.d(str);
    }

    public static String c(String str, Object... objArr) {
        int indexOf;
        String valueOf = String.valueOf(str);
        int i10 = 0;
        if (objArr == null) {
            objArr = new Object[]{"(Object[])null"};
        } else {
            for (int i11 = 0; i11 < objArr.length; i11++) {
                objArr[i11] = d(objArr[i11]);
            }
        }
        StringBuilder sb = new StringBuilder(valueOf.length() + (objArr.length * 16));
        int i12 = 0;
        while (i10 < objArr.length && (indexOf = valueOf.indexOf("%s", i12)) != -1) {
            sb.append((CharSequence) valueOf, i12, indexOf);
            sb.append(objArr[i10]);
            i12 = indexOf + 2;
            i10++;
        }
        sb.append((CharSequence) valueOf, i12, valueOf.length());
        if (i10 < objArr.length) {
            sb.append(" [");
            sb.append(objArr[i10]);
            for (int i13 = i10 + 1; i13 < objArr.length; i13++) {
                sb.append(", ");
                sb.append(objArr[i13]);
            }
            sb.append(']');
        }
        return sb.toString();
    }

    public static String d(Object obj) {
        if (obj == null) {
            return "null";
        }
        try {
            return obj.toString();
        } catch (Exception e10) {
            String str = obj.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(obj));
            Logger.getLogger("com.google.common.base.Strings").log(Level.WARNING, "Exception during lenientFormat for " + str, (Throwable) e10);
            return "<" + str + " threw " + e10.getClass().getName() + ">";
        }
    }

    public static boolean validSurrogatePairAt(CharSequence charSequence, int i10) {
        if (i10 >= 0 && i10 <= charSequence.length() - 2 && Character.isHighSurrogate(charSequence.charAt(i10)) && Character.isLowSurrogate(charSequence.charAt(i10 + 1))) {
            return true;
        }
        return false;
    }
}
