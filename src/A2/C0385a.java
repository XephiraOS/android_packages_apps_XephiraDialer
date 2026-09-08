package A2;

import android.app.ActivityManager;
import android.content.Context;
import com.android.incallui.Log;
import com.internal_dependency.InternalSdkDepends;

/* compiled from: FocusModeUtils.java */
/* renamed from: A2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0385a {
    public static boolean a(Context context) {
        if (context == null || !b(context) || InternalSdkDepends.getSInstance().getSecureSettingsIntForCurrentUser(context.getContentResolver(), "focusmode_switch", 0) != 1) {
            return false;
        }
        Log.d("FocusModeUtils", "isFocusMode = true");
        return true;
    }

    public static boolean b(Context context) {
        ActivityManager activityManager;
        if (context == null || (activityManager = (ActivityManager) context.getSystemService("activity")) == null) {
            return false;
        }
        int lockTaskModeState = activityManager.getLockTaskModeState();
        if (lockTaskModeState != 1 && lockTaskModeState != 2) {
            return false;
        }
        return true;
    }
}
