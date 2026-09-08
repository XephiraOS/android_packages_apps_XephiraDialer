package com.oplus.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/* compiled from: SharedPreferenceUtils.kt */
/* loaded from: classes3.dex */
public final class S {

    /* renamed from: a, reason: collision with root package name */
    public static final S f29089a = new S();

    public static final ArrayList<String> a(SharedPreferences sharedPreferences, String str, ArrayList<String> arrayList) {
        Set<String> stringSet = sharedPreferences.getStringSet(str, null);
        if (stringSet != null) {
            return new ArrayList<>(stringSet);
        }
        return arrayList;
    }

    public static final Bundle b(Context context, Bundle bundle) {
        Iterator<String> it;
        Set<String> keySet;
        Bundle bundle2 = new Bundle();
        if (bundle != null && (keySet = bundle.keySet()) != null) {
            it = keySet.iterator();
        } else {
            it = null;
        }
        if (it != null && context != null) {
            SharedPreferences sharedPreferences = androidx.preference.j.b(context);
            while (it.hasNext()) {
                String key = it.next();
                if (sharedPreferences.contains(key)) {
                    Object obj = bundle.get(key);
                    if (obj instanceof Long) {
                        bundle2.putLong(key, sharedPreferences.getLong(key, ((Number) obj).longValue()));
                    } else if (obj instanceof Integer) {
                        bundle2.putInt(key, sharedPreferences.getInt(key, ((Number) obj).intValue()));
                    } else if (obj instanceof Boolean) {
                        bundle2.putBoolean(key, sharedPreferences.getBoolean(key, ((Boolean) obj).booleanValue()));
                    } else if (obj instanceof Float) {
                        bundle2.putFloat(key, sharedPreferences.getFloat(key, ((Number) obj).floatValue()));
                    } else if (obj instanceof String) {
                        bundle2.putString(key, sharedPreferences.getString(key, (String) obj));
                    } else if (obj instanceof ArrayList) {
                        kotlin.jvm.internal.i.e(sharedPreferences, "sharedPreferences");
                        kotlin.jvm.internal.i.e(key, "key");
                        bundle2.putStringArrayList(key, a(sharedPreferences, key, (ArrayList) obj));
                    }
                }
            }
        }
        return bundle2;
    }
}
