package com.android.contacts;

/* compiled from: InputContinuationNumberHolder.kt */
/* loaded from: classes.dex */
public final class Q0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Q0 f13202a = new Q0();

    /* renamed from: b, reason: collision with root package name */
    public static String f13203b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f13204c;

    /* renamed from: d, reason: collision with root package name */
    public static Boolean f13205d;

    public static final Boolean a() {
        return f13205d;
    }

    public static final boolean b() {
        return f13204c;
    }

    public static final void c(String str) {
        if (H7.a.b()) {
            H7.b.b("InputContinuationNumberHolder", "put " + H7.a.d(str));
        }
        f13203b = str;
    }

    public static final void d(boolean z10) {
        f13204c = z10;
    }

    public static final void e(Boolean bool) {
        f13205d = bool;
    }

    public static final String f() {
        String str = f13203b;
        if (H7.a.b()) {
            H7.b.b("InputContinuationNumberHolder", "take " + H7.a.d(str));
        }
        f13203b = null;
        return str;
    }
}
