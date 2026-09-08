package com.oplus.utils;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.SystemProperties;
import android.provider.Settings;
import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Logger.java */
/* renamed from: com.oplus.utils.z, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0864z {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f29205a = f();

    /* renamed from: b, reason: collision with root package name */
    public static AtomicBoolean f29206b = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name */
    public static volatile C0864z f29207c;

    /* compiled from: Logger.java */
    /* renamed from: com.oplus.utils.z$b */
    /* loaded from: classes3.dex */
    public static class b extends ContentObserver {
        @Override // android.database.ContentObserver
        public void onChange(boolean z10, Uri uri) {
            boolean unused = C0864z.f29205a = C0864z.b();
        }

        public b() {
            super(null);
        }
    }

    public static /* synthetic */ boolean b() {
        return f();
    }

    public static void c(String str, String str2, Object... objArr) {
        if (f29205a) {
            Log.d(str, e(str2, objArr));
        }
    }

    public static void d(String str, String str2, Object... objArr) {
        if (f29205a) {
            Log.e(str, e(str2, objArr));
        }
    }

    public static String e(String str, Object[] objArr) {
        if (str == null) {
            return "";
        }
        if (objArr.length > 0) {
            return String.format(str, objArr);
        }
        return str;
    }

    public static boolean f() {
        return SystemProperties.getBoolean("persist.sys.assert.panic", false);
    }

    public static C0864z g() {
        if (f29207c == null) {
            synchronized (C0864z.class) {
                try {
                    if (f29207c == null) {
                        f29207c = new C0864z();
                    }
                } finally {
                }
            }
        }
        return f29207c;
    }

    public static void i(String str, String str2, Object... objArr) {
        if (f29205a) {
            Log.w(str, e(str2, objArr));
        }
    }

    public void h(Context context) {
        if (!f29206b.getAndSet(true) && context != null && context.getContentResolver() != null) {
            context.getContentResolver().registerContentObserver(Settings.System.getUriFor("log_switch_type"), false, new b());
        }
    }
}
