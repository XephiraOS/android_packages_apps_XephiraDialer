package com.internal_dependency;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.Settings;
import java.util.HashSet;
import kotlin.jvm.internal.i;

/* compiled from: SettingsUtils.kt */
/* loaded from: classes3.dex */
public final class SettingsUtils implements ISettingsApi {
    private static final String KEY_SUFFIX = "_store";
    public static final SettingsUtils INSTANCE = new SettingsUtils();
    private static final HashSet<String> renameSettingKeys = new HashSet<>();

    private SettingsUtils() {
    }

    private static final String getStoreSettingsKeyName(String str) {
        if (renameSettingKeys.contains(str)) {
            return str + KEY_SUFFIX;
        }
        return str;
    }

    private static final boolean isT() {
        return true;
    }

    @Override // com.internal_dependency.ISettingsApi
    public float getGlobalSettingsFloat(ContentResolver cr, String name, float f10) {
        i.f(cr, "cr");
        i.f(name, "name");
        return Settings.Global.getFloat(cr, getStoreSettingsKeyName(name), f10);
    }

    @Override // com.internal_dependency.ISettingsApi
    public int getGlobalSettingsInt(ContentResolver cr, String name, int i10) {
        i.f(cr, "cr");
        i.f(name, "name");
        try {
            return Settings.Global.getInt(cr, getStoreSettingsKeyName(name), i10);
        } catch (Settings.SettingNotFoundException unused) {
            return i10;
        }
    }

    @Override // com.internal_dependency.ISettingsApi
    public long getGlobalSettingsLong(ContentResolver cr, String name, long j10) {
        i.f(cr, "cr");
        i.f(name, "name");
        return Settings.Global.getLong(cr, getStoreSettingsKeyName(name), j10);
    }

    @Override // com.internal_dependency.ISettingsApi
    public String getGlobalSettingsString(ContentResolver cr, String name, String def) {
        i.f(cr, "cr");
        i.f(name, "name");
        i.f(def, "def");
        String string = Settings.Global.getString(cr, getStoreSettingsKeyName(name));
        if (string != null) {
            return string;
        }
        return def;
    }

    @Override // com.internal_dependency.ISettingsApi
    public Uri getGlobalUriFor(String name) {
        i.f(name, "name");
        return Settings.Global.getUriFor(getStoreSettingsKeyName(name));
    }

    @Override // com.internal_dependency.ISettingsApi
    public float getSecureSettingsFloat(ContentResolver cr, String name, float f10) {
        i.f(cr, "cr");
        i.f(name, "name");
        return Settings.Secure.getFloat(cr, getStoreSettingsKeyName(name), f10);
    }

    @Override // com.internal_dependency.ISettingsApi
    public int getSecureSettingsInt(ContentResolver cr, String name, int i10) {
        i.f(cr, "cr");
        i.f(name, "name");
        return Settings.Secure.getInt(cr, getStoreSettingsKeyName(name), i10);
    }

    @Override // com.internal_dependency.ISettingsApi
    public long getSecureSettingsLong(ContentResolver cr, String name, long j10) {
        i.f(cr, "cr");
        i.f(name, "name");
        return Settings.Secure.getLong(cr, getStoreSettingsKeyName(name), j10);
    }

    @Override // com.internal_dependency.ISettingsApi
    public String getSecureSettingsString(ContentResolver cr, String name, String def) {
        i.f(cr, "cr");
        i.f(name, "name");
        i.f(def, "def");
        String string = Settings.Secure.getString(cr, getStoreSettingsKeyName(name));
        if (string != null) {
            return string;
        }
        return def;
    }

    @Override // com.internal_dependency.ISettingsApi
    public Uri getSecureUriFor(String name) {
        i.f(name, "name");
        return Settings.Secure.getUriFor(getStoreSettingsKeyName(name));
    }

    @Override // com.internal_dependency.ISettingsApi
    public float getSystemSettingsFloat(ContentResolver cr, String name, float f10) {
        i.f(cr, "cr");
        i.f(name, "name");
        return Settings.System.getFloat(cr, getStoreSettingsKeyName(name), f10);
    }

    @Override // com.internal_dependency.ISettingsApi
    public int getSystemSettingsInt(ContentResolver cr, String name, int i10) {
        i.f(cr, "cr");
        i.f(name, "name");
        return Settings.System.getInt(cr, getStoreSettingsKeyName(name), i10);
    }

    @Override // com.internal_dependency.ISettingsApi
    public long getSystemSettingsLong(ContentResolver cr, String name, long j10) {
        i.f(cr, "cr");
        i.f(name, "name");
        return Settings.System.getLong(cr, getStoreSettingsKeyName(name), j10);
    }

    @Override // com.internal_dependency.ISettingsApi
    public String getSystemSettingsString(ContentResolver cr, String name, String def) {
        i.f(cr, "cr");
        i.f(name, "name");
        i.f(def, "def");
        String string = Settings.System.getString(cr, getStoreSettingsKeyName(name));
        if (string != null) {
            return string;
        }
        return def;
    }

    @Override // com.internal_dependency.ISettingsApi
    public Uri getSystemUriFor(String name) {
        i.f(name, "name");
        return Settings.System.getUriFor(getStoreSettingsKeyName(name));
    }

    @Override // com.internal_dependency.ISettingsApi
    public void putGlobalSettingsFloat(ContentResolver cr, String name, float f10) {
        i.f(cr, "cr");
        i.f(name, "name");
    }

    @Override // com.internal_dependency.ISettingsApi
    public void putGlobalSettingsInt(ContentResolver cr, String name, int i10) {
        i.f(cr, "cr");
        i.f(name, "name");
        if (isT()) {
            Settings.Global.putInt(cr, getStoreSettingsKeyName(name), i10);
        }
    }

    @Override // com.internal_dependency.ISettingsApi
    public void putGlobalSettingsLong(ContentResolver cr, String name, long j10) {
        i.f(cr, "cr");
        i.f(name, "name");
    }

    @Override // com.internal_dependency.ISettingsApi
    public void putGlobalSettingsString(ContentResolver cr, String name, String value) {
        i.f(cr, "cr");
        i.f(name, "name");
        i.f(value, "value");
    }

    @Override // com.internal_dependency.ISettingsApi
    public void putSecureSettingsFloat(ContentResolver cr, String name, float f10) {
        i.f(cr, "cr");
        i.f(name, "name");
    }

    @Override // com.internal_dependency.ISettingsApi
    public void putSecureSettingsInt(ContentResolver cr, String name, int i10) {
        i.f(cr, "cr");
        i.f(name, "name");
    }

    @Override // com.internal_dependency.ISettingsApi
    public void putSecureSettingsLong(ContentResolver cr, String name, long j10) {
        i.f(cr, "cr");
        i.f(name, "name");
    }

    @Override // com.internal_dependency.ISettingsApi
    public void putSecureSettingsString(ContentResolver cr, String name, String value) {
        i.f(cr, "cr");
        i.f(name, "name");
        i.f(value, "value");
    }

    @Override // com.internal_dependency.ISettingsApi
    public void putSystemSettingsFloat(ContentResolver cr, String name, float f10) {
        i.f(cr, "cr");
        i.f(name, "name");
    }

    @Override // com.internal_dependency.ISettingsApi
    public void putSystemSettingsInt(ContentResolver cr, String name, int i10) {
        i.f(cr, "cr");
        i.f(name, "name");
    }

    @Override // com.internal_dependency.ISettingsApi
    public void putSystemSettingsLong(ContentResolver cr, String name, long j10) {
        i.f(cr, "cr");
        i.f(name, "name");
    }

    @Override // com.internal_dependency.ISettingsApi
    public void putSystemSettingsString(ContentResolver cr, String name, String value) {
        i.f(cr, "cr");
        i.f(name, "name");
        i.f(value, "value");
    }
}
