package com.customize.contacts.util;

import android.content.Context;
import com.oplus.foundation.util.OsUtils;

/* compiled from: SauUtils.java */
/* loaded from: classes3.dex */
public class Z {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f21992a = true;

    public static void a(Context context) {
        boolean z10 = true;
        if (!OsUtils.f28275a.j() && B3.a.G()) {
            try {
                if (G0.c.d(context, 1, R0.c.f3194l, 1) <= 0) {
                    z10 = false;
                }
                f21992a = z10;
                return;
            } catch (Exception e10) {
                H7.b.c("SauUtils", "Exception e: " + e10);
                return;
            }
        }
        f21992a = true;
    }

    public static boolean b() {
        return f21992a;
    }
}
