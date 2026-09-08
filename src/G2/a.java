package G2;

import android.content.Context;
import android.view.accessibility.AccessibilityManager;
import com.android.incallui.Log;

/* compiled from: AccessibilityUtil.java */
/* loaded from: classes.dex */
public class a {
    public static boolean a(Context context) {
        if (context == null) {
            Log.d("AccessibilityUtil", "isTalkBackEnabled: context is null, return!");
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        if (accessibilityManager == null || !accessibilityManager.isEnabled() || !accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        return true;
    }
}
