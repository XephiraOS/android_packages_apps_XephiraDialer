package O6;

import android.provider.Settings;
import android.util.Log;
import com.oplus.epona.Request;
import com.oplus.epona.Response;
import com.oplus.epona.d;
import com.oplus.utils.reflect.RefClass;
import com.oplus.utils.reflect.RefInt;
import com.oplus.utils.reflect.RefObject;

/* compiled from: SettingsNative.java */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static String f2731a;

    /* renamed from: b, reason: collision with root package name */
    public static int f2732b;

    /* renamed from: c, reason: collision with root package name */
    public static int f2733c;

    /* compiled from: SettingsNative.java */
    /* renamed from: O6.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0052a {
        private static RefObject<String> NTP_SERVER_2;
        private static RefInt ZEN_MODE_IMPORTANT_INTERRUPTIONS;
        private static RefInt ZEN_MODE_OFF;

        static {
            RefClass.load((Class<?>) C0052a.class, (Class<?>) Settings.Global.class);
        }
    }

    static {
        try {
            if (S6.c.o()) {
                f2732b = C0052a.ZEN_MODE_IMPORTANT_INTERRUPTIONS.getWithException(null);
                f2733c = C0052a.ZEN_MODE_OFF.getWithException(null);
                f2731a = (String) C0052a.NTP_SERVER_2.getWithException(null);
            } else if (S6.c.m()) {
                f2732b = C0052a.ZEN_MODE_IMPORTANT_INTERRUPTIONS.getWithException(null);
                f2733c = C0052a.ZEN_MODE_OFF.getWithException(null);
                f2731a = a();
            } else if (S6.c.l()) {
                f2731a = (String) C0052a.NTP_SERVER_2.getWithException(null);
            } else {
                Log.e("SettingsNative", "Not supported before Q");
            }
        } catch (Exception e10) {
            Log.e("SettingsNative", e10.toString());
        }
    }

    public static String a() {
        if (S6.c.m()) {
            Response d10 = d.o(new Request.b().c("Settings.Global").b("initNtpServer2").a()).d();
            if (d10.j()) {
                return d10.h().getString("result");
            }
            return null;
        }
        return null;
    }

    public static boolean b(String str, int i10) {
        if (S6.c.o()) {
            return Settings.Global.putInt(d.g().getContentResolver(), str, i10);
        }
        if (S6.c.m()) {
            Response d10 = d.o(new Request.b().c("Settings.Global").b("putInt").g("SETTINGS_KEY", str).d("SETTINGS_VALUE", i10).a()).d();
            if (d10.j()) {
                return d10.h().getBoolean("result");
            }
            return false;
        }
        if (S6.c.f()) {
            return Settings.Global.putInt(d.g().getContentResolver(), str, i10);
        }
        Log.e("SettingsNative", "SettingsNative.Global.putInt is not supported before M");
        return false;
    }

    public static boolean c(String str, long j10) {
        if (S6.c.o()) {
            return Settings.Global.putLong(d.g().getContentResolver(), str, j10);
        }
        if (S6.c.m()) {
            Response d10 = d.o(new Request.b().c("Settings.Global").b("putLong").g("SETTINGS_KEY", str).e("SETTINGS_VALUE", j10).a()).d();
            if (d10.j()) {
                return d10.h().getBoolean("result");
            }
            return false;
        }
        if (S6.c.f()) {
            return Settings.Global.putLong(d.g().getContentResolver(), str, j10);
        }
        Log.e("SettingsNative", "SettingsNative.Global.putLong is not supported before M");
        return false;
    }

    public static boolean d(String str, String str2) {
        if (S6.c.o()) {
            return Settings.Global.putString(d.g().getContentResolver(), str, str2);
        }
        if (S6.c.m()) {
            Response d10 = d.o(new Request.b().c("Settings.Global").b("putString").g("SETTINGS_KEY", str).g("SETTINGS_VALUE", str2).a()).d();
            if (d10.j()) {
                return d10.h().getBoolean("result");
            }
            return false;
        }
        if (S6.c.f()) {
            return Settings.Global.putString(d.g().getContentResolver(), str, str2);
        }
        Log.e("SettingsNative", "SettingsNative.Global.putString is not supported before M");
        return false;
    }
}
