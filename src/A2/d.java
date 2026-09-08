package A2;

import android.content.res.Configuration;
import android.os.PowerManager;
import android.telecom.PhoneAccountHandle;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.view.WindowManager;
import com.android.incallui.Log;
import com.android.incallui.OplusInCallApp;
import com.internal_dependency.AddOnSdkDepends;
import com.internal_dependency.ApiAdapterDepends;

/* compiled from: OplusCompat.java */
/* loaded from: classes.dex */
public class d {
    public static boolean a(PowerManager powerManager) {
        return ApiAdapterDepends.getSInstance().getDisplayAodStatus(powerManager);
    }

    public static int b(Configuration configuration) {
        return AddOnSdkDepends.getSInstance().getFlipFont(configuration);
    }

    public static int c(PhoneAccountHandle phoneAccountHandle) {
        if (phoneAccountHandle != null) {
            try {
                return SubscriptionManager.getSlotIndex(d(phoneAccountHandle));
            } catch (Exception e10) {
                Log.e("OplusCompat", "getSlotId Exception" + e10.getMessage());
                return -1;
            }
        }
        return -1;
    }

    public static int d(PhoneAccountHandle phoneAccountHandle) {
        if (phoneAccountHandle == null) {
            Log.d(Log.TAG, "getSubId phoneAccountHandle is null");
            return -1;
        }
        TelephonyManager telephonyManager = (TelephonyManager) OplusInCallApp.getAppContext().getSystemService("phone");
        if (telephonyManager == null || androidx.core.content.b.a(OplusInCallApp.getAppContext(), "android.permission.READ_PHONE_STATE") != 0) {
            return -1;
        }
        int subscriptionId = telephonyManager.getSubscriptionId(phoneAccountHandle);
        Log.d(Log.TAG, "getSubId phoneAccountHandle:" + phoneAccountHandle + " subId:" + subscriptionId);
        return subscriptionId;
    }

    public static void e(WindowManager.LayoutParams layoutParams) {
        AddOnSdkDepends.getSInstance().setHomeAndMenuKeyState(layoutParams);
    }
}
