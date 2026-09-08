package K2;

import com.android.incallui.Log;
import kotlin.jvm.internal.i;

/* compiled from: OplusLog.kt */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f1625a = new a();

    public static final void b(String objTag, String msg) {
        i.f(objTag, "objTag");
        i.f(msg, "msg");
        f1625a.a("INCOMING_RINGING", objTag, msg);
    }

    public static final void c(String objTag, String msg) {
        i.f(objTag, "objTag");
        i.f(msg, "msg");
        f1625a.a("MOCALL: ", objTag, msg);
    }

    public static final void d(String objTag, String msg) {
        i.f(objTag, "objTag");
        i.f(msg, "msg");
        f1625a.a("RIDE_DRIVER: ", objTag, msg);
    }

    public static final void e(String objTag, String msg) {
        i.f(objTag, "objTag");
        i.f(msg, "msg");
        f1625a.a("SMART_DRIVER: ", objTag, msg);
    }

    public static final void f(String objTag, String msg) {
        i.f(objTag, "objTag");
        i.f(msg, "msg");
        f1625a.j("SMART_DRIVER: ", objTag, msg);
    }

    public static final void g(String objTag, String msg) {
        i.f(objTag, "objTag");
        i.f(msg, "msg");
        f1625a.a("VIDEOCALL: ", objTag, msg);
    }

    public static final void h(String objTag, String msg) {
        i.f(objTag, "objTag");
        i.f(msg, "msg");
        f1625a.j("VIDEOCALL: ", objTag, msg);
    }

    public static final void i(String objTag, String msg) {
        i.f(objTag, "objTag");
        i.f(msg, "msg");
        f1625a.a("P_SENSOR", objTag, msg);
    }

    public final void a(String str, String str2, String str3) {
        if (Log.sDebug) {
            b.f1626a.a(str, str2, str3);
        }
    }

    public final void j(String str, String str2, String str3) {
        if (Log.sDebug) {
            b.f1626a.b(str, str2, str3);
        }
    }
}
