package com.oplus.blacklistapp.callintercept.settings;

import android.content.Context;
import android.content.SharedPreferences;
import com.oplus.utils.C0846g;

/* compiled from: HarassInterceptSettingUtils.java */
/* loaded from: classes3.dex */
public class u {
    public static boolean a(int i10, int i11) {
        boolean z10 = false;
        if (i10 != 0 ? (i11 & 2) == 2 : (i11 & 1) == 1) {
            z10 = true;
        }
        b("isHarassIntercepOpen " + z10);
        return z10;
    }

    public static void b(String str) {
        C0846g.i("HarassInterceptSettingUtils", str);
    }

    public static void c(Context context, int i10, String str, boolean z10, int i11) {
        int i12;
        int c10 = z6.b.c(context, 1, str, i11);
        if (i10 == 1) {
            i12 = 2;
        } else {
            i12 = 1;
        }
        int a10 = com.oplus.blacklistapp.callintercept.a.a(c10, i12, z10);
        b("putIntHarassInterceptkeyValue " + str + " =  " + c10 + "  newKeyValue = " + a10);
        z6.b.i(context, 1, str, a10);
    }

    public static void d(SharedPreferences sharedPreferences, int i10, String str, boolean z10, int i11) {
        int i12 = sharedPreferences.getInt(str, i11);
        int i13 = 1;
        if (i10 == 1) {
            i13 = 2;
        }
        int a10 = com.oplus.blacklistapp.callintercept.a.a(i12, i13, z10);
        b("putIntHarassInterceptkeyValue " + str + " =  " + i12 + "  newKeyValue = " + a10);
        sharedPreferences.edit().putInt(str, a10).apply();
    }
}
