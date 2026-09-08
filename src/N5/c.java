package N5;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.SystemProperties;
import android.provider.Settings;

/* compiled from: DebugUtils.java */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: c, reason: collision with root package name */
    public static volatile c f2366c = null;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f2367d = true;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f2368e = false;

    /* renamed from: a, reason: collision with root package name */
    public boolean f2369a = false;

    /* renamed from: b, reason: collision with root package name */
    public Context f2370b;

    /* compiled from: DebugUtils.java */
    /* loaded from: classes3.dex */
    public class b extends ContentObserver {
        @Override // android.database.ContentObserver
        public void onChange(boolean z10, Uri uri) {
            boolean unused = c.f2368e = c.this.d();
            d.b("Change MODE to debug mode : " + c.f2368e);
        }

        public b() {
            super(null);
        }
    }

    public static c e() {
        if (f2366c == null) {
            synchronized (c.class) {
                try {
                    if (f2366c == null) {
                        f2366c = new c();
                    }
                } finally {
                }
            }
        }
        return f2366c;
    }

    public final boolean d() {
        if (Settings.Secure.getInt(this.f2370b.getContentResolver(), "oplus_appplatform_debug", 0) != 1) {
            return false;
        }
        return true;
    }

    public void f(Context context) {
        if (this.f2369a) {
            return;
        }
        this.f2369a = true;
        boolean z10 = SystemProperties.getBoolean("ro.build.release_type", true);
        f2367d = z10;
        if (!z10) {
            this.f2370b = context;
            f2368e = d();
            context.getContentResolver().registerContentObserver(Settings.Secure.getUriFor("oplus_appplatform_debug"), false, new b());
            d.c("Current MODE is debug mode : " + f2368e);
        }
    }

    public boolean g() {
        if (!f2367d && f2368e) {
            return true;
        }
        return false;
    }
}
