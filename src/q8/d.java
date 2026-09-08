package q8;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.SystemProperties;
import android.provider.Settings;
import android.util.Log;

/* compiled from: PLog.java */
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f36237a = false;

    /* compiled from: PLog.java */
    /* loaded from: classes3.dex */
    public static class b extends ContentObserver {
        @Override // android.database.ContentObserver
        public void onChange(boolean z10, Uri uri) {
            boolean unused = d.f36237a = SystemProperties.getBoolean("persist.sys.assert.panic", false);
        }

        public b() {
            super(null);
        }
    }

    public static void b(String str) {
        if (f36237a) {
            Log.d("AppPlatform.Shield", str);
        }
    }

    public static void c(String str) {
        Log.e("AppPlatform.Shield", str);
    }

    public static void d(String str) {
        if (f36237a) {
            Log.i("AppPlatform.Shield", str);
        }
    }

    public static void e(Context context) {
        f36237a = SystemProperties.getBoolean("persist.sys.assert.panic", false);
        context.getContentResolver().registerContentObserver(Settings.System.getUriFor("log_switch_type"), false, new b());
    }
}
