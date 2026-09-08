package com.oplus.utils;

import android.content.Intent;
import android.os.Parcelable;
import android.util.Log;
import java.util.ArrayList;

/* compiled from: IntentUtils.java */
/* renamed from: com.oplus.utils.y, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0863y {
    public static boolean a(Intent intent, String str, boolean z10) {
        if (intent == null) {
            return z10;
        }
        try {
            return intent.getBooleanExtra(str, z10);
        } catch (Exception e10) {
            Log.e("IntentUtils", e10.toString());
            return z10;
        }
    }

    public static int b(Intent intent, String str, int i10) {
        if (intent == null) {
            return i10;
        }
        try {
            return intent.getIntExtra(str, i10);
        } catch (Exception e10) {
            Log.e("IntentUtils", e10.toString());
            return i10;
        }
    }

    public static <T extends Parcelable> ArrayList<T> c(Intent intent, String str) {
        if (intent == null) {
            return null;
        }
        try {
            return intent.getParcelableArrayListExtra(str);
        } catch (Exception e10) {
            Log.e("IntentUtils", e10.toString());
            return null;
        }
    }

    public static String d(Intent intent, String str) {
        if (intent == null) {
            return "";
        }
        try {
            return intent.getStringExtra(str);
        } catch (Exception e10) {
            Log.e("IntentUtils", e10.toString());
            return "";
        }
    }
}
