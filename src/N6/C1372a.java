package n6;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Log;
import com.android.incallui.OplusPhoneCapabilities;

/* compiled from: AppPlatformAvailability.java */
/* renamed from: n6.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1372a {

    /* renamed from: a, reason: collision with root package name */
    public static volatile C1372a f35625a;

    public static C1372a b() {
        if (f35625a == null) {
            synchronized (C1372a.class) {
                try {
                    if (f35625a == null) {
                        f35625a = new C1372a();
                    }
                } finally {
                }
            }
        }
        return f35625a;
    }

    public final ApplicationInfo a(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo("com.oplus.appplatform", 512);
        } catch (PackageManager.NameNotFoundException unused) {
            Log.e("AppPlatformAvailability", "AppPlatform not installed");
            return null;
        }
    }

    public void c(Activity activity) {
        ApplicationInfo a10 = a(activity);
        if (a10 == null) {
            return;
        }
        Intent intent = new Intent();
        intent.addFlags(OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE);
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", a10.packageName, null));
        activity.startActivity(intent);
    }

    public int d(Context context) {
        ApplicationInfo a10 = a(context);
        if (a10 != null) {
            if (a10.enabled) {
                return 0;
            }
            return 1;
        }
        return 2;
    }
}
