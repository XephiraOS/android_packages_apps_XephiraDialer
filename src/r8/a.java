package R8;

import android.util.Log;
import com.internal_dependency.InternalSdkDepends;
import kotlin.jvm.internal.i;

/* compiled from: LogUtil.kt */
/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f3357a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static boolean f3358b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f3359c;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f3360d;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f3361e;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f3362f;

    /* renamed from: g, reason: collision with root package name */
    public static boolean f3363g;

    static {
        boolean booleanSystemProperties = InternalSdkDepends.Companion.getSInstance().getBooleanSystemProperties("persist.sys.assert.panic", false);
        f3358b = booleanSystemProperties;
        f3359c = booleanSystemProperties;
        f3360d = booleanSystemProperties;
        f3361e = booleanSystemProperties;
        f3362f = booleanSystemProperties;
    }

    public final void a(Object obj, String msg) {
        i.f(msg, "msg");
        if (f3360d) {
            Log.d("InCall_Video_Show", e(obj) + msg);
        }
    }

    public final void b(String tag, String msg) {
        i.f(tag, "tag");
        i.f(msg, "msg");
        if (f3360d) {
            Log.d("InCall_Video_Show", c(tag) + msg);
        }
    }

    public final String c(String str) {
        return str + com.android.incallui.Log.TAG_DELIMETER;
    }

    public final void d(String tag, String msg) {
        i.f(tag, "tag");
        i.f(msg, "msg");
        Log.e("InCall_Video_Show", c(tag) + msg);
    }

    public final String e(Object obj) {
        if (obj == null) {
            return "";
        }
        return obj.getClass().getSimpleName() + com.android.incallui.Log.TAG_DELIMETER;
    }

    public final boolean f() {
        return f3360d;
    }

    public final boolean g() {
        return f3363g;
    }

    public final void h(Object obj, String msg) {
        i.f(msg, "msg");
        Log.w("InCall_Video_Show", e(obj) + msg);
    }
}
