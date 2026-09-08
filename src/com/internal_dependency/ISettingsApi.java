package com.internal_dependency;

import android.content.ContentResolver;
import android.net.Uri;

/* compiled from: ISettingsApi.kt */
/* loaded from: classes3.dex */
public interface ISettingsApi {
    float getGlobalSettingsFloat(ContentResolver contentResolver, String str, float f10);

    int getGlobalSettingsInt(ContentResolver contentResolver, String str, int i10);

    long getGlobalSettingsLong(ContentResolver contentResolver, String str, long j10);

    String getGlobalSettingsString(ContentResolver contentResolver, String str, String str2);

    Uri getGlobalUriFor(String str);

    float getSecureSettingsFloat(ContentResolver contentResolver, String str, float f10);

    int getSecureSettingsInt(ContentResolver contentResolver, String str, int i10);

    long getSecureSettingsLong(ContentResolver contentResolver, String str, long j10);

    String getSecureSettingsString(ContentResolver contentResolver, String str, String str2);

    Uri getSecureUriFor(String str);

    float getSystemSettingsFloat(ContentResolver contentResolver, String str, float f10);

    int getSystemSettingsInt(ContentResolver contentResolver, String str, int i10);

    long getSystemSettingsLong(ContentResolver contentResolver, String str, long j10);

    String getSystemSettingsString(ContentResolver contentResolver, String str, String str2);

    Uri getSystemUriFor(String str);

    void putGlobalSettingsFloat(ContentResolver contentResolver, String str, float f10);

    void putGlobalSettingsInt(ContentResolver contentResolver, String str, int i10);

    void putGlobalSettingsLong(ContentResolver contentResolver, String str, long j10);

    void putGlobalSettingsString(ContentResolver contentResolver, String str, String str2);

    void putSecureSettingsFloat(ContentResolver contentResolver, String str, float f10);

    void putSecureSettingsInt(ContentResolver contentResolver, String str, int i10);

    void putSecureSettingsLong(ContentResolver contentResolver, String str, long j10);

    void putSecureSettingsString(ContentResolver contentResolver, String str, String str2);

    void putSystemSettingsFloat(ContentResolver contentResolver, String str, float f10);

    void putSystemSettingsInt(ContentResolver contentResolver, String str, int i10);

    void putSystemSettingsLong(ContentResolver contentResolver, String str, long j10);

    void putSystemSettingsString(ContentResolver contentResolver, String str, String str2);
}
