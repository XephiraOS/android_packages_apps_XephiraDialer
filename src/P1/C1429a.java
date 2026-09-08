package p1;

import H7.b;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.util.Log;

/* compiled from: SocialWidgetSettings.java */
/* renamed from: p1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1429a {

    /* renamed from: a, reason: collision with root package name */
    public static final C1429a f35989a = new C1429a();

    public static C1429a c() {
        return f35989a;
    }

    public final void a(Context context, SharedPreferences sharedPreferences) {
        if (sharedPreferences.getBoolean("SocialWidgetSettings_settings_migrated", false)) {
            return;
        }
        if (Log.isLoggable("SocialWidgetSettings", 3)) {
            b.e("SocialWidgetSettings", "Migrating widget settings...");
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        SharedPreferences sharedPreferences2 = context.getSharedPreferences("WidgetSettings", 0);
        for (String str : sharedPreferences2.getAll().keySet()) {
            String string = sharedPreferences2.getString(str, null);
            if (string != null) {
                if (Log.isLoggable("SocialWidgetSettings", 3)) {
                    b.e("SocialWidgetSettings", "Found: " + str + ": " + string);
                }
                edit.putString("SocialWidgetSettings_" + str, string);
            }
        }
        edit.apply();
        sharedPreferences.edit().putBoolean("SocialWidgetSettings_settings_migrated", true).apply();
    }

    public Uri b(Context context, int i10) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        a(context, defaultSharedPreferences);
        Uri uri = null;
        String string = defaultSharedPreferences.getString(d(i10), null);
        if (string != null) {
            uri = Uri.parse(string);
        }
        if (Log.isLoggable("SocialWidgetSettings", 3)) {
            b.b("SocialWidgetSettings", "getContactUri(" + i10 + ") --> " + uri);
        }
        return uri;
    }

    public final String d(int i10) {
        return "SocialWidgetSettings_CONTACT_URI_" + Integer.toString(i10);
    }

    public void e(Context context, int[] iArr) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        for (int i10 : iArr) {
            if (Log.isLoggable("SocialWidgetSettings", 3)) {
                b.b("SocialWidgetSettings", "remove(" + i10 + ")");
            }
            edit.remove(d(i10));
        }
        edit.apply();
    }

    public void f(Context context, int i10, Uri uri) {
        if (Log.isLoggable("SocialWidgetSettings", 3)) {
            b.b("SocialWidgetSettings", "setContactUri(" + i10 + ", " + uri + ")");
        }
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        if (uri == null) {
            edit.remove(d(i10));
        } else {
            edit.putString(d(i10), uri.toString());
        }
        edit.apply();
    }
}
