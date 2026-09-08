package i2;

import android.content.Context;
import com.android.incallui.Log;
import com.internal_dependency.SettingsUtils;

/* compiled from: OplusThirdRecordUtils.java */
/* loaded from: classes.dex */
public class d {
    public static boolean a(Context context) {
        if (context == null) {
            Log.w("OplusThirdRecordUtils", "isPolicyStatusOn context is null!");
            return false;
        }
        int systemSettingsInt = SettingsUtils.INSTANCE.getSystemSettingsInt(context.getContentResolver(), "oplus_third_record_policy_status", 0);
        if (Log.sOplusDebug) {
            Log.d("OplusThirdRecordUtils", "isPolicyStatusOn value = " + systemSettingsInt);
        }
        if (systemSettingsInt != 1) {
            return false;
        }
        return true;
    }
}
