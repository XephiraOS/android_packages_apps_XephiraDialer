package Z5;

import android.util.Log;
import kotlin.jvm.internal.i;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f5952a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static String f5953b = "";

    /* renamed from: c, reason: collision with root package name */
    public static volatile boolean f5954c;

    public static final void a(String tag, String msg) {
        i.f(tag, "tag");
        i.f(msg, "msg");
        if (!f5954c) {
            return;
        }
        Log.d(f5953b + '-' + tag, msg);
    }

    public static final void b(String tag, String msg) {
        i.f(tag, "tag");
        i.f(msg, "msg");
        Log.e(f5953b + '-' + tag, msg);
    }

    public static final void c(String tag, String msg) {
        i.f(tag, "tag");
        i.f(msg, "msg");
        Log.i(f5953b + '-' + tag, msg);
    }

    public static final void d(String tag, String msg) {
        i.f(tag, "tag");
        i.f(msg, "msg");
        Log.w(f5953b + '-' + tag, msg);
    }
}
