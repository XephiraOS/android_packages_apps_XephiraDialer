package F;

import android.os.ext.SdkExtensions;

/* compiled from: BuildCompat.kt */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f770a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final int f771b;

    /* renamed from: c, reason: collision with root package name */
    public static final int f772c;

    /* renamed from: d, reason: collision with root package name */
    public static final int f773d;

    /* renamed from: e, reason: collision with root package name */
    public static final int f774e;

    /* compiled from: BuildCompat.kt */
    /* renamed from: F.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0012a {

        /* renamed from: a, reason: collision with root package name */
        public static final C0012a f775a = new C0012a();

        public final int a(int i10) {
            return SdkExtensions.getExtensionVersion(i10);
        }
    }

    static {
        C0012a c0012a = C0012a.f775a;
        f771b = c0012a.a(30);
        f772c = c0012a.a(31);
        f773d = c0012a.a(33);
        f774e = c0012a.a(1000000);
    }

    public static final boolean a() {
        return true;
    }

    public static final boolean b() {
        return true;
    }
}
