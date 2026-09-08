package com.customize.contacts.util;

import android.icu.text.Transliterator;
import android.text.TextUtils;

/* compiled from: TransliteratorUtils.java */
/* loaded from: classes3.dex */
public class j0 {

    /* renamed from: a, reason: collision with root package name */
    public static Transliterator f22134a;

    public static String a(String str) {
        if (f22134a == null || TextUtils.isEmpty(str) || str.length() != 1) {
            return null;
        }
        char charAt = str.charAt(0);
        if (charAt >= 592 && (7680 > charAt || charAt >= 7935)) {
            return null;
        }
        return f22134a.transliterate(Character.toString(charAt));
    }

    public static void b() {
        if (f22134a == null) {
            synchronized (j0.class) {
                try {
                    if (f22134a == null) {
                        f22134a = Transliterator.getInstance("Latin-Ascii");
                    }
                } finally {
                }
            }
        }
    }
}
