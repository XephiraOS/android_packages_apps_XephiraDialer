package com.ted.number;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

/* compiled from: CharacterSets.java */
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f29570a;

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f29571b = {"*", "us-ascii", "iso-8859-1", "iso-8859-2", "iso-8859-3", "iso-8859-4", "iso-8859-5", "iso-8859-6", "iso-8859-7", "iso-8859-8", "iso-8859-9", "shift_JIS", "utf-8", "big5", "iso-10646-ucs-2", "utf-16"};

    /* renamed from: c, reason: collision with root package name */
    public static final HashMap<Integer, String> f29572c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    public static final HashMap<String, Integer> f29573d = new HashMap<>();

    static {
        int[] iArr = {0, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 17, 106, 2026, 1000, 1015};
        f29570a = iArr;
        int length = iArr.length - 1;
        for (int i10 = 0; i10 <= length; i10++) {
            HashMap<Integer, String> hashMap = f29572c;
            int[] iArr2 = f29570a;
            Integer valueOf = Integer.valueOf(iArr2[i10]);
            String[] strArr = f29571b;
            hashMap.put(valueOf, strArr[i10]);
            f29573d.put(strArr[i10], Integer.valueOf(iArr2[i10]));
        }
    }

    public static String a(int i10) {
        String str = f29572c.get(Integer.valueOf(i10));
        if (str != null) {
            return str;
        }
        throw new UnsupportedEncodingException();
    }
}
