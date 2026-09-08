package h1;

import U7.f;
import android.text.TextUtils;

/* compiled from: PhoneNumberFormatUtils.java */
/* renamed from: h1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1073b {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f32036a = {"17951", "12593", "17910", "17911", "10193", "10131", "96531", "17900", "17901", "17909", "11808"};

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f32037b = {"+86"};

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String b10 = b(str);
        if (TextUtils.isEmpty(b10)) {
            return b10;
        }
        if (b10.length() >= 6 && b10.length() <= 11) {
            int i10 = 0;
            int i11 = 0;
            while (true) {
                String[] strArr = f32036a;
                if (i11 >= strArr.length) {
                    while (true) {
                        String[] strArr2 = f32037b;
                        if (i10 < strArr2.length) {
                            if (b10.startsWith(strArr2[i10])) {
                                return b10.substring(strArr2[i10].length());
                            }
                            i10++;
                        } else {
                            return b10;
                        }
                    }
                } else {
                    if (b10.startsWith(strArr[i11])) {
                        return b10.substring(strArr[i11].length());
                    }
                    i11++;
                }
            }
        } else {
            if (b10.length() > 11) {
                return b10.substring(b10.length() - 11);
            }
            return b10;
        }
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (str.contains(" ")) {
            str = f.f(str);
        }
        if (!TextUtils.isEmpty(str) && str.contains("-")) {
            return f.e(str);
        }
        return str;
    }

    public static String[] c() {
        return f32036a;
    }
}
