package R2;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import com.android.store_incallui.ShellInCallApp;
import java.util.List;
import kotlin.collections.o;
import kotlin.jvm.internal.i;

/* compiled from: InCallUIAppUtil.kt */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f3311a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static ShellInCallApp f3312b;

    public static final void a(Context context) {
        i.f(context, "context");
        ShellInCallApp shellInCallApp = f3312b;
        if (shellInCallApp != null) {
            shellInCallApp.attachBaseContext(context);
        }
    }

    public static final List<String> b() {
        List<String> j10;
        j10 = o.j("android.permission.BLUETOOTH_CONNECT", "android.permission.READ_MEDIA_AUDIO");
        return j10;
    }

    public static final void c(Configuration newConfig) {
        i.f(newConfig, "newConfig");
        ShellInCallApp shellInCallApp = f3312b;
        if (shellInCallApp != null) {
            shellInCallApp.onConfigurationChanged(newConfig);
        }
    }

    public static final void d(Application application) {
        i.f(application, "application");
        ShellInCallApp shellInCallApp = new ShellInCallApp(application);
        shellInCallApp.onCreate();
        f3312b = shellInCallApp;
    }
}
