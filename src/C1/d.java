package C1;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/* compiled from: VvmUtils.java */
/* loaded from: classes.dex */
public final class d {
    public static SharedPreferences a(Context context) {
        Context createDeviceProtectedStorageContext;
        if (context.isDeviceProtectedStorage()) {
            createDeviceProtectedStorageContext = context;
        } else {
            createDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
        }
        if (createDeviceProtectedStorageContext != null) {
            context = createDeviceProtectedStorageContext;
        }
        return PreferenceManager.getDefaultSharedPreferences(context);
    }
}
