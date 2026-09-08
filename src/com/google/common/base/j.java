package com.google.common.base;

import java.util.Locale;
import java.util.logging.Logger;

/* compiled from: Platform.java */
/* loaded from: classes3.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static final Logger f24319a = Logger.getLogger(j.class.getName());

    /* renamed from: b, reason: collision with root package name */
    public static final i f24320b = c();

    /* compiled from: Platform.java */
    /* loaded from: classes3.dex */
    public static final class b implements i {
        public b() {
        }
    }

    public static String a(String str) {
        if (d(str)) {
            return null;
        }
        return str;
    }

    public static String b(double d10) {
        return String.format(Locale.ROOT, "%.4g", Double.valueOf(d10));
    }

    public static i c() {
        return new b();
    }

    public static boolean d(String str) {
        if (str != null && !str.isEmpty()) {
            return false;
        }
        return true;
    }
}
