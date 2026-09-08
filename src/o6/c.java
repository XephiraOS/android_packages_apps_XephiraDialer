package O6;

import android.provider.Settings;
import android.util.Log;
import com.oplus.epona.Request;
import com.oplus.epona.Response;
import com.oplus.epona.d;

/* compiled from: SettingsNative.java */
/* loaded from: classes3.dex */
public class c {
    public static boolean a(String str, int i10) {
        if (S6.c.o()) {
            return Settings.System.putInt(d.g().getContentResolver(), str, i10);
        }
        if (S6.c.m()) {
            Response d10 = d.o(new Request.b().c("Settings.System").b("putInt").g("SETTINGS_KEY", str).d("SETTINGS_VALUE", i10).a()).d();
            if (d10.j()) {
                return d10.h().getBoolean("result");
            }
            return false;
        }
        if (S6.c.f()) {
            return Settings.System.putInt(d.g().getContentResolver(), str, i10);
        }
        Log.e("SettingsNative", "SettingsNative.System.putInt is not supported before M");
        return false;
    }

    public static boolean b(String str, long j10) {
        if (S6.c.o()) {
            return Settings.System.putLong(d.g().getContentResolver(), str, j10);
        }
        if (S6.c.m()) {
            Response d10 = d.o(new Request.b().c("Settings.System").b("putLong").g("SETTINGS_KEY", str).e("SETTINGS_VALUE", j10).a()).d();
            if (d10.j()) {
                return d10.h().getBoolean("result");
            }
            return false;
        }
        if (S6.c.f()) {
            return Settings.System.putLong(d.g().getContentResolver(), str, j10);
        }
        Log.e("SettingsNative", "SettingsNative.System.putLong is not supported before M");
        return false;
    }

    public static boolean c(String str, String str2) {
        if (S6.c.o()) {
            return Settings.System.putString(d.g().getContentResolver(), str, str2);
        }
        if (S6.c.m()) {
            Response d10 = d.o(new Request.b().c("Settings.System").b("putString").g("SETTINGS_KEY", str).g("SETTINGS_VALUE", str2).a()).d();
            if (d10.j()) {
                return d10.h().getBoolean("result");
            }
            return false;
        }
        if (S6.c.f()) {
            return Settings.System.putString(d.g().getContentResolver(), str, str2);
        }
        Log.e("SettingsNative", "SettingsNative.System.putString is not supported before M");
        return false;
    }
}
