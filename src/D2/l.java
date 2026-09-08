package D2;

import android.content.Context;
import android.telecom.PhoneAccountHandle;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.internal_dependency.AddOnSdkDepends;
import com.internal_dependency.InternalSdkDepends;

/* compiled from: TelephonyManagerUtils.java */
/* loaded from: classes.dex */
public class l {
    public static int a(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getActiveModemCount();
    }

    public static String b(Context context, int i10, int i11) {
        return AddOnSdkDepends.getSInstance().getNetworkOperatorGemini(context, i10, i11);
    }

    public static String c(Context context, int i10, int i11) {
        return AddOnSdkDepends.getSInstance().getSimOperatorGemini(context, i10, i11);
    }

    public static String d(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getVoiceMailAlphaTag();
    }

    public static String e(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (androidx.core.content.b.a(context, "android.permission.READ_PHONE_STATE") != 0) {
            return "";
        }
        return telephonyManager.getVoiceMailNumber();
    }

    public static String f(Context context, int i10, PhoneAccountHandle phoneAccountHandle) {
        if (androidx.core.content.b.a(context, "android.permission.READ_PHONE_STATE") != 0) {
            return "";
        }
        return InternalSdkDepends.getSInstance().getVoiceMailNumber(context, i10, phoneAccountHandle);
    }

    public static int g(Context context, int i10) {
        if (context == null) {
            return 0;
        }
        if (androidx.core.content.b.a(context, "android.permission.READ_PHONE_STATE") != 0) {
            Log.d("TelephonyManagerUtils", "NO READ_PHONE_STATE, return");
            return 0;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (androidx.core.content.b.a(context, "android.permission.READ_PHONE_STATE") != 0) {
            return 0;
        }
        int voiceNetworkType = telephonyManager.getVoiceNetworkType();
        com.android.incallui.Log.d("TelephonyManagerUtils", "voiceNetworkType = " + voiceNetworkType);
        return voiceNetworkType;
    }

    public static boolean h(Context context) {
        int simState;
        if (context == null || (simState = ((TelephonyManager) context.getSystemService("phone")).getSimState()) == 1 || simState == 0) {
            return false;
        }
        return true;
    }

    public static boolean i(Context context) {
        if (((TelephonyManager) context.getSystemService("phone")).getActiveModemCount() > 1) {
            return true;
        }
        return false;
    }

    public static boolean j(Context context) {
        return InternalSdkDepends.getSInstance().isVolteOrWfc(context);
    }
}
