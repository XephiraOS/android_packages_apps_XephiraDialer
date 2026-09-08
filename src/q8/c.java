package q8;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.SystemProperties;
import android.provider.Settings;

/* compiled from: DebugUtils.java */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: c, reason: collision with root package name */
    public static volatile c f36231c = null;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f36232d = true;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f36233e = false;

    /* renamed from: a, reason: collision with root package name */
    public boolean f36234a = false;

    /* renamed from: b, reason: collision with root package name */
    public Context f36235b;

    /* compiled from: DebugUtils.java */
    /* loaded from: classes3.dex */
    public class b extends ContentObserver {
        @Override // android.database.ContentObserver
        public void onChange(boolean z10, Uri uri) {
            boolean unused = c.f36233e = c.this.d();
            d.b("Change MODE to debug mode : " + c.f36233e);
        }

        public b() {
            super(null);
        }
    }

    public static c e() {
        if (f36231c == null) {
            synchronized (c.class) {
                try {
                    if (f36231c == null) {
                        f36231c = new c();
                    }
                } finally {
                }
            }
        }
        return f36231c;
    }

    public final boolean d() {
        if (Settings.Secure.getInt(this.f36235b.getContentResolver(), "oplus_appplatform_debug", 0) != 1) {
            return false;
        }
        return true;
    }

    public void f(Context context) {
        if (this.f36234a) {
            return;
        }
        this.f36234a = true;
        boolean z10 = SystemProperties.getBoolean("ro.build.release_type", true);
        f36232d = z10;
        if (!z10) {
            this.f36235b = context;
            f36233e = d();
            context.getContentResolver().registerContentObserver(Settings.Secure.getUriFor("oplus_appplatform_debug"), false, new b());
            d.c("Current MODE is debug mode : " + f36233e);
        }
    }

    public boolean g() {
        if (!f36232d && f36233e) {
            return true;
        }
        return false;
    }
}
