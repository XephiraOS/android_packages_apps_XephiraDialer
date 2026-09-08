package O6;

import android.provider.Settings;
import android.util.Log;
import com.oplus.epona.Request;
import com.oplus.epona.Response;
import com.oplus.epona.d;
import com.oplus.utils.reflect.RefClass;
import com.oplus.utils.reflect.RefObject;

/* compiled from: SettingsNative.java */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static String f2734a;

    /* renamed from: b, reason: collision with root package name */
    public static int f2735b;

    /* renamed from: c, reason: collision with root package name */
    public static String f2736c;

    /* compiled from: SettingsNative.java */
    /* loaded from: classes3.dex */
    public static class a {
        private static RefObject<String> WIFI_DISCONNECT_DELAY_DURATION;

        static {
            RefClass.load((Class<?>) a.class, (Class<?>) Settings.Secure.class);
        }
    }

    static {
        try {
            if (S6.c.n()) {
                f2736c = "location_changer";
                f2735b = 1;
            } else if (S6.c.m()) {
                Response d10 = d.o(new Request.b().c("Settings.Secure").b("getConstant").a()).d();
                if (d10.j()) {
                    f2736c = d10.h().getString("LOCATION_CHANGER");
                    f2735b = d10.h().getInt("LOCATION_CHANGER_SYSTEM_SETTINGS");
                } else {
                    Log.e("SettingsNative", "Epona Communication failed, static initializer failed.");
                }
            } else if (S6.c.l()) {
                f2734a = (String) a.WIFI_DISCONNECT_DELAY_DURATION.getWithException(null);
            } else {
                Log.e("SettingsNative", "Not supported before Q");
            }
        } catch (Throwable th) {
            Log.e("SettingsNative", th.toString());
        }
    }

    public static boolean a(String str, int i10) {
        if (S6.c.o()) {
            return Settings.Secure.putInt(d.g().getContentResolver(), str, i10);
        }
        if (S6.c.m()) {
            Response d10 = d.o(new Request.b().c("Settings.Secure").b("putInt").g("SETTINGS_KEY", str).d("SETTINGS_VALUE", i10).a()).d();
            if (d10.j()) {
                return d10.h().getBoolean("result");
            }
            return false;
        }
        if (S6.c.f()) {
            return Settings.Secure.putInt(d.g().getContentResolver(), str, i10);
        }
        Log.e("SettingsNative", "SettingsNative.Secure.putInt is not supported before M");
        return false;
    }

    public static boolean b(String str, long j10) {
        if (S6.c.o()) {
            return Settings.Secure.putLong(d.g().getContentResolver(), str, j10);
        }
        if (S6.c.m()) {
            Response d10 = d.o(new Request.b().c("Settings.Secure").b("putLong").g("SETTINGS_KEY", str).e("SETTINGS_VALUE", j10).a()).d();
            if (d10.j()) {
                return d10.h().getBoolean("result");
            }
            return false;
        }
        if (S6.c.f()) {
            return Settings.Secure.putLong(d.g().getContentResolver(), str, j10);
        }
        Log.e("SettingsNative", "SettingsNative.Secure.putLong is not supported before M");
        return false;
    }

    public static boolean c(String str, String str2) {
        if (S6.c.o()) {
            return Settings.Secure.putString(d.g().getContentResolver(), str, str2);
        }
        if (S6.c.m()) {
            Response d10 = d.o(new Request.b().c("Settings.Secure").b("putString").g("SETTINGS_KEY", str).g("SETTINGS_VALUE", str2).a()).d();
            if (d10.j()) {
                return d10.h().getBoolean("result");
            }
            return false;
        }
        if (S6.c.f()) {
            return Settings.Secure.putString(d.g().getContentResolver(), str, str2);
        }
        Log.e("SettingsNative", "SettingsNative.Secure.putString is not supported before M");
        return false;
    }
}
