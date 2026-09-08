package com.android.contacts.framework.baseui.util;

import R0.c;
import android.content.Context;

/* compiled from: SettingsHolder.java */
/* loaded from: classes.dex */
public class s {
    public static void a(Context context, boolean z10) {
        G0.c.n(context, 0, "number_recognition_experience_improvement_switch", z10 ? 1 : 0);
    }

    public static void b(Context context, boolean z10) {
        G0.c.n(context, 0, "suspicious_number_confirmed_switch", z10 ? 1 : 0);
    }

    public static void c(Context context, boolean z10) {
        G0.c.n(context, 0, "use_data_network_update_switch", z10 ? 1 : 0);
    }

    public static int d(Context context) {
        int d10 = G0.c.d(context, 1, c.a.f3210p, 0);
        int d11 = G0.c.d(context, 1, c.a.f3211q, 0);
        int d12 = G0.c.d(context, 1, c.a.f3212r, 0);
        int d13 = G0.c.d(context, 1, c.a.f3213s, 0);
        H7.b.e("SettingsHolder", "getHarassInterceptMarkNumberSwitchValue: numberFraud = " + d10 + ", numberHarassment = " + d11 + ", numberAdvertising = , numberReal = " + d13);
        return d13 | d10 | d11 | d12;
    }

    public static boolean e(Context context) {
        boolean z10 = false;
        int d10 = G0.c.d(context, 0, "number_recognition_experience_improvement_switch", 0);
        if (d10 == 1) {
            z10 = true;
        }
        H7.b.e("SettingsHolder", "isExperienceImprovementSwitchOn: " + z10 + ", values:" + d10);
        return z10;
    }

    public static boolean f(Context context) {
        boolean z10 = false;
        int d10 = G0.c.d(context, 0, "suspicious_number_confirmed_switch", 1);
        if (d10 == 1) {
            z10 = true;
        }
        H7.b.e("SettingsHolder", "isSuspiciousNumberConfirmedSwitchOn: " + z10 + ", values:" + d10);
        return z10;
    }

    public static boolean g(Context context) {
        boolean z10 = false;
        int d10 = G0.c.d(context, 0, "use_data_network_update_switch", 0);
        if (d10 == 1) {
            z10 = true;
        }
        H7.b.e("SettingsHolder", "isUseDataNetworkUpdateSwitchOn: " + z10 + ", values:" + d10);
        return z10;
    }

    public static boolean h(Context context) {
        boolean z10 = true;
        if (G0.c.d(context, 1, "permission_dialog_showed", 0) != 0) {
            z10 = false;
        }
        H7.b.e("SettingsHolder", "needShow = " + z10);
        return z10;
    }

    public static void i(Context context) {
        G0.c.n(context, 1, "permission_dialog_showed", 1);
    }

    public static void j(Context context, boolean z10) {
        NumberIdentifyUtils.o(context, z10 ? 1 : 0);
        if (h(context)) {
            i(context);
        }
    }
}
