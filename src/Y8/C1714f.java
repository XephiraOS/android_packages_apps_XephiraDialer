package y8;

import android.util.Log;

/* compiled from: LogUtil.java */
/* renamed from: y8.f, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1714f {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f38155a = false;

    public static void a(String str, InterfaceC1715g<String> interfaceC1715g) {
        if (f38155a) {
            Log.d("OplusTrack-" + str, interfaceC1715g.get());
        }
    }

    public static void b(String str, InterfaceC1715g<String> interfaceC1715g) {
        Log.e("OplusTrack-" + str, interfaceC1715g.get());
    }

    public static void c(String str, InterfaceC1715g<String> interfaceC1715g) {
        if (f38155a) {
            Log.i("OplusTrack-" + str, interfaceC1715g.get());
        }
    }

    public static void d(boolean z10) {
        f38155a = z10;
    }

    public static void e(String str, InterfaceC1715g<String> interfaceC1715g) {
        if (f38155a) {
            Log.v("OplusTrack-" + str, interfaceC1715g.get());
        }
    }

    public static void f(String str, InterfaceC1715g<String> interfaceC1715g) {
        Log.w("OplusTrack-" + str, interfaceC1715g.get());
    }
}
