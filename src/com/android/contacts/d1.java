package com.android.contacts;

/* compiled from: TypePrecedence.java */
@Deprecated
/* loaded from: classes.dex */
public final class d1 {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f14158a = {0, 12, 2, 1, 3, 7, 5, 4, 6};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f14159b = {0, 1, 2, 3};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f14160c = {0, 1, 2, 3};

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f14161d = {0, 1, 2, 3};

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f14162e = {0, 1, 2};

    @Deprecated
    public static int a(String str, int i10) {
        int[] b10 = b(str);
        if (b10 == null) {
            return -1;
        }
        for (int i11 = 0; i11 < b10.length; i11++) {
            if (b10[i11] == i10) {
                return i11;
            }
        }
        return b10.length;
    }

    @Deprecated
    public static int[] b(String str) {
        if (str.equals("vnd.android.cursor.item/phone_v2")) {
            return f14158a;
        }
        if (str.equals("vnd.android.cursor.item/email_v2")) {
            return f14159b;
        }
        if (str.equals("vnd.android.cursor.item/postal-address_v2")) {
            return f14160c;
        }
        if (str.equals("vnd.android.cursor.item/im")) {
            return f14161d;
        }
        if (str.equals("vnd.android.cursor.item/video-chat-address")) {
            return f14161d;
        }
        if (str.equals("vnd.android.cursor.item/organization")) {
            return f14162e;
        }
        return null;
    }
}
