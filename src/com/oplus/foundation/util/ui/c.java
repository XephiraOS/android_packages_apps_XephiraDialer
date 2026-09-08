package com.oplus.foundation.util.ui;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

/* compiled from: ToastManager.java */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static long f28369a;

    /* renamed from: b, reason: collision with root package name */
    public static Toast f28370b;

    /* renamed from: c, reason: collision with root package name */
    public static CharSequence f28371c;

    public static boolean a(CharSequence charSequence) {
        boolean z10;
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - f28369a) < 500 && TextUtils.equals(f28371c, charSequence)) {
            z10 = true;
        } else {
            z10 = false;
        }
        f28369a = currentTimeMillis;
        return z10;
    }

    public static void b(Context context, int i10) {
        f(context, i10, 1);
    }

    public static void c(Context context, String str) {
        g(context, str, 1);
    }

    public static void d(Context context, int i10) {
        f(context, i10, 0);
    }

    public static void e(Context context, String str) {
        g(context, str, 0);
    }

    public static void f(Context context, int i10, int i11) {
        if (context == null) {
            return;
        }
        g(context, context.getResources().getText(i10), i11);
    }

    public static void g(Context context, CharSequence charSequence, int i10) {
        Context applicationContext;
        if (context == null || (applicationContext = context.getApplicationContext()) == null || a(charSequence)) {
            return;
        }
        Toast toast = f28370b;
        if (toast != null) {
            toast.cancel();
        }
        Toast makeText = Toast.makeText(applicationContext, charSequence, i10);
        f28370b = makeText;
        f28371c = charSequence;
        makeText.show();
    }
}
