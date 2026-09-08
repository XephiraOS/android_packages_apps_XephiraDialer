package com.customize.contacts.util;

import R0.c;
import android.content.Context;
import android.text.TextUtils;
import com.oplus.dialer.R;

/* compiled from: PhotoSwitchUtils.java */
/* loaded from: classes3.dex */
public class U {

    /* renamed from: a, reason: collision with root package name */
    public static Boolean f21967a;

    /* renamed from: b, reason: collision with root package name */
    public static int f21968b;

    /* renamed from: c, reason: collision with root package name */
    public static int f21969c;

    public static int a() {
        if (f21969c == 0) {
            c(P7.a.f2962b);
        }
        return f21969c;
    }

    public static int b() {
        if (f21968b == 0) {
            c(P7.a.f2962b);
        }
        return f21968b;
    }

    public static void c(Context context) {
        f21967a = Boolean.valueOf(e(context));
        g(context);
    }

    public static boolean d() {
        if (f21967a == null) {
            c(P7.a.f2962b);
        }
        return f21967a.booleanValue();
    }

    public static boolean e(Context context) {
        boolean z10;
        String j10 = G0.c.j(context, 0, c.a.f3197c);
        if (!TextUtils.isEmpty(j10)) {
            z10 = TextUtils.equals(j10, "true");
        } else {
            z10 = true;
        }
        if (H7.a.b()) {
            H7.b.b("ContactsUtils", "checkValue = " + j10 + ", isPhotoSwitchChecked = " + z10);
        }
        return z10;
    }

    public static void f(Context context, boolean z10) {
        f21967a = Boolean.valueOf(z10);
        g(context);
    }

    public static void g(Context context) {
        f21968b = context.getResources().getDimensionPixelOffset(R.dimen.DP_12);
        if (d()) {
            f21969c = context.getResources().getDimensionPixelOffset(R.dimen.DP_18);
        } else {
            f21969c = context.getResources().getDimensionPixelOffset(R.dimen.DP_16);
        }
    }
}
