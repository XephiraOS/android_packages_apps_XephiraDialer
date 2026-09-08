package S6;

import android.util.Log;
import com.oplus.os.OplusBuild;

/* compiled from: VersionUtils.java */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final String f3521a = c();

    /* renamed from: b, reason: collision with root package name */
    public static final String f3522b = a();

    public static String a() {
        if (j()) {
            return "com.oplus.appplatform";
        }
        return (String) b();
    }

    public static Object b() {
        return d.a();
    }

    public static String c() {
        if (j()) {
            return "com.oplus.appplatform.dispatcher";
        }
        return (String) d();
    }

    public static Object d() {
        return d.b();
    }

    public static boolean e() {
        return true;
    }

    public static boolean f() {
        return true;
    }

    public static boolean g() {
        return true;
    }

    public static boolean h() {
        return true;
    }

    public static boolean i() {
        return true;
    }

    public static boolean j() {
        try {
            if (OplusBuild.getOplusOSVERSION() < 22) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            Log.d("VersionUtils", "Get OsVersion Exception : " + th.toString());
            return false;
        }
    }

    public static boolean k() {
        return true;
    }

    public static boolean l() {
        return true;
    }

    public static boolean m() {
        return true;
    }

    public static boolean n() {
        return true;
    }

    public static boolean o() {
        return true;
    }
}
