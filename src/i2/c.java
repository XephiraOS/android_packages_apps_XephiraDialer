package i2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.android.incallui.Log;
import com.android.incallui.OplusFeatureOption;
import com.android.incallui.OplusPhoneCapabilities;
import com.android.incallui.OplusPhoneUtils;
import com.internal_dependency.SettingsUtils;

/* compiled from: OplusAutoRecordGuideUtil.java */
/* loaded from: classes.dex */
public class c {
    public static int a(Context context) {
        if (context == null) {
            return 0;
        }
        int i10 = context.getSharedPreferences("oplus_auto_record_prefs", 0).getInt("oplus_call_audio_record_count", 0);
        Log.d("OplusAutoRecordGuideUtil", "getCallAudioRecordCount count = " + i10);
        return i10;
    }

    public static int b(Context context) {
        if (context == null) {
            return 0;
        }
        int i10 = context.getSharedPreferences("oplus_auto_record_prefs", 0).getInt("oplus_dialog_show_count", 0);
        Log.d("OplusAutoRecordGuideUtil", "getCallAudioRecordCount count = " + i10);
        return i10;
    }

    public static boolean c(Context context) {
        if (context == null || SettingsUtils.INSTANCE.getGlobalSettingsInt(context.getContentResolver(), "oplus_customize_has_enter_auto_record_activity", 0) == 1) {
            return true;
        }
        return false;
    }

    public static void d(Context context) {
        if (context == null) {
            return;
        }
        int a10 = a(context) + 1;
        SharedPreferences.Editor edit = context.getSharedPreferences("oplus_auto_record_prefs", 0).edit();
        edit.putInt("oplus_call_audio_record_count", a10);
        edit.apply();
    }

    public static void e(Context context) {
        if (context == null) {
            return;
        }
        int b10 = b(context) + 1;
        SharedPreferences.Editor edit = context.getSharedPreferences("oplus_auto_record_prefs", 0).edit();
        edit.putInt("oplus_dialog_show_count", b10);
        edit.apply();
    }

    public static boolean f(Context context) {
        boolean z10 = false;
        if (context == null) {
            return false;
        }
        if (OplusFeatureOption.VERSION_STORE && !OplusPhoneUtils.isUserUnlocked(context)) {
            Log.d("OplusAutoRecordGuideUtil", "VERSION_STORE and isUserUnlocked");
            return false;
        }
        if (OplusFeatureOption.OPLUS_VERSION_EXP && !OplusPhoneUtils.isNeedHideRecord(context)) {
            if (c(context)) {
                return false;
            }
            int a10 = a(context);
            int b10 = b(context);
            if ((a10 >= 10 && b10 <= 0) || ((a10 >= 40 && b10 == 1) || (a10 >= 90 && b10 == 2))) {
                z10 = true;
            }
            if (z10) {
                e(context);
            }
            Log.d("OplusAutoRecordGuideUtil", "shouldShowGuide shouldShow = " + z10 + " callAudioRecordCount = " + a10 + " dialogShowCount = " + b10);
        }
        return z10;
    }

    public static void g(Context context) {
        try {
            Intent intent = new Intent("oplus.intent.action.phone.AUTO_AUDIO_RECORD");
            intent.addFlags(OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE);
            context.startActivity(intent);
        } catch (Exception e10) {
            Log.d("OplusAutoRecordGuideUtil", "Exception: " + e10.toString());
            Log.w("OplusAutoRecordGuideUtil", "startGuideActivity catch error");
        }
    }
}
