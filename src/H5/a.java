package H5;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemProperties;
import android.provider.Settings;
import android.util.Log;

/* compiled from: Logger.java */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f1286a = SystemProperties.getBoolean("persist.sys.assert.panic", false);

    /* compiled from: Logger.java */
    /* loaded from: classes3.dex */
    public static class b extends ContentObserver {
        @Override // android.database.ContentObserver
        public void onChange(boolean z10, Uri uri) {
            boolean unused = a.f1286a = SystemProperties.getBoolean("persist.sys.assert.panic", false);
        }

        public b(Handler handler) {
            super(null);
        }
    }

    public static void b(String str, String str2, Object... objArr) {
        if (f1286a) {
            Log.d("Epona->" + str, d(str2, objArr));
        }
    }

    public static void c(String str, String str2, Object... objArr) {
        if (f1286a) {
            Log.e("Epona->" + str, d(str2, objArr));
        }
    }

    public static String d(String str, Object[] objArr) {
        if (str != null && objArr != null && objArr.length > 0) {
            return String.format(str, objArr);
        }
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void e(Context context) {
        if (context != null && context.getContentResolver() != null && "com.heytap.appplatform".equals(context.getPackageName())) {
            context.getContentResolver().registerContentObserver(Settings.System.getUriFor("log_switch_type"), false, new b(null));
        }
    }

    public static void f(String str, String str2, Object... objArr) {
        if (f1286a) {
            Log.w("Epona->" + str, d(str2, objArr));
        }
    }
}
