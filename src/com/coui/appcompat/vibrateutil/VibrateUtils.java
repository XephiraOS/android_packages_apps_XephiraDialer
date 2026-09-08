package com.coui.appcompat.vibrateutil;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.os.DynamicEffect;
import android.os.HapticPlayer;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.Log;
import com.oplus.content.OplusFeatureConfigManager;
import com.oplus.os.LinearmotorVibrator;
import com.oplus.os.WaveformEffect;

/* loaded from: classes3.dex */
public class VibrateUtils {
    private static final boolean DEBUG = false;
    private static final String FEATURE_VIBRATOR_LUXUNVIBRATOR_SUPPORT = "oplus.software.vibrator_luxunvibrator";
    public static final int MIN_VIBRATOR_TIME = 25;
    public static final int STRENGTH_MAX_EDGE = 1200;
    public static final int STRENGTH_MAX_GRANULAR = 1600;
    public static final int STRENGTH_MAX_STEP = 2000;
    public static final int STRENGTH_MIN_EDGE = 800;
    public static final int STRENGTH_MIN_GRANULAR = 1200;
    public static final int STRENGTH_MIN_STEP = 200;
    public static final int STRENGTH_OFFSET = 400;
    private static final String TAG = "VibrateUtils";
    public static final int TYPE_GRANULAR_SHORT_MODERATE = 1;
    public static final int TYPE_GRANULAR_SHORT_WEAK = 1;
    public static final int TYPE_GRANULAR_SHORT_WEAKEST = 0;
    public static final int TYPE_STEPABLE_EDGE = 154;
    public static final int TYPE_STEPABLE_REGULATE = 152;
    public static final int VIBRATE_CRISP_LEVEL_CRISP = 0;
    public static final int VIBRATE_CRISP_MAX_FREQUENCY = 90;
    public static final int VIBRATE_CRISP_MAX_INTENSITY = 100;
    public static final int VIBRATE_CRISP_MIN_FREQUENCY = 75;
    public static final int VIBRATE_CRISP_MIN_INTENSITY = 50;
    public static final int VIBRATE_SOFT_LEVEL_CRISP = 1;
    public static final int VIBRATE_SOFT_MAX_FREQUENCY = 55;
    public static final int VIBRATE_SOFT_MAX_INTENSITY = 68;
    public static final int VIBRATE_SOFT_MIN_FREQUENCY = 48;
    public static final int VIBRATE_SOFT_MIN_INTENSITY = 52;
    private static long lastVibratorTime = -1;
    private static final ContentObserver mHapticObserver = new ContentObserver(null) { // from class: com.coui.appcompat.vibrateutil.VibrateUtils.1
        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            super.onChange(z10);
            boolean z11 = false;
            if (Settings.System.getInt(VibrateUtils.sContext.getContentResolver(), "haptic_feedback_enabled", 0) == 1) {
                z11 = true;
            }
            boolean unused = VibrateUtils.sHapticEnable = z11;
        }
    };
    private static Context sContext = null;
    private static boolean sHapticEnable = false;

    private static boolean filterVibrator() {
        if (lastVibratorTime == -1) {
            lastVibratorTime = SystemClock.elapsedRealtime();
            return false;
        }
        if (SystemClock.elapsedRealtime() - lastVibratorTime < 25) {
            return true;
        }
        lastVibratorTime = SystemClock.elapsedRealtime();
        return false;
    }

    private static DynamicEffect getDynamicEffect(int i10, int i11) {
        return DynamicEffect.create("{\n    \"Metadata\": {\n        \"Version\": 2,\n        \"Created\": \"2023-05-12\",\n        \"Description\": \"Exported from RichTap Creator Pro\"\n    },\n    \"PatternList\": [\n        {\n            \"AbsoluteTime\": 0,\n            \"Pattern\": [\n                {\n                    \"Event\": {\n                        \"Type\": \"transient\",\n                        \"RelativeTime\": 0,\n                        \"Parameters\": {\n                            \"Intensity\": " + i11 + ",\n                            \"Frequency\": " + i10 + "\n                        },\n                        \"Index\": 0\n                    }\n                }\n            ]\n        }\n    ]\n}");
    }

    public static LinearmotorVibrator getLinearMotorVibrator(Context context) {
        try {
            if (!OplusFeatureConfigManager.getInstance().hasFeature(FEATURE_VIBRATOR_LUXUNVIBRATOR_SUPPORT)) {
                return null;
            }
            return (LinearmotorVibrator) context.getSystemService("linearmotor");
        } catch (Exception e10) {
            Log.e(TAG, "get linear motor vibrator failed. error = " + e10.getMessage());
            return null;
        }
    }

    private static int getVibratorStrengthWithLimit(int i10, int i11, int i12, int i13) {
        int i14 = (int) ((((i10 * 1.0d) / i11) * (i13 - i12)) + i12);
        if (i12 < i13) {
            return Math.max(i12, Math.min(i14, i13));
        }
        return Math.max(i13, Math.min(i14, i12));
    }

    private static int getVibratorValueWithLimit(int i10, int i11, int i12, int i13) {
        int i14 = (int) ((((i10 * 1.0d) / i11) * (i13 - i12)) + i12);
        if (i12 < i13) {
            return Math.max(i12, Math.min(i14, i13));
        }
        return Math.max(i13, Math.min(i14, i12));
    }

    public static boolean isLinearMotorVersion(Context context) {
        try {
            return OplusFeatureConfigManager.getInstance().hasFeature("oplus.software.vibrator_lmvibrator");
        } catch (Throwable th) {
            Log.e(TAG, "get isLinearMotorVersion failed. error = " + th.getMessage());
            return false;
        }
    }

    public static void registerHapticObserver(Context context) {
        if (sContext == null && context != null) {
            Context applicationContext = context.getApplicationContext();
            sContext = applicationContext;
            ContentResolver contentResolver = applicationContext.getContentResolver();
            boolean z10 = true;
            if (Settings.System.getInt(contentResolver, "haptic_feedback_enabled", 0) != 1) {
                z10 = false;
            }
            sHapticEnable = z10;
            contentResolver.registerContentObserver(Settings.System.getUriFor("haptic_feedback_enabled"), false, mHapticObserver);
        }
    }

    public static void setLinearMotorVibratorStrength(LinearmotorVibrator linearmotorVibrator, int i10, int i11, int i12, int i13, int i14) {
        if (linearmotorVibrator == null || !sHapticEnable) {
            return;
        }
        int vibratorStrengthWithLimit = getVibratorStrengthWithLimit(i11, i12, i13, i14);
        if (i10 == 0) {
            vibratorStrengthWithLimit += STRENGTH_OFFSET;
        }
        linearmotorVibrator.vibrate(new WaveformEffect.Builder().setStrengthSettingEnabled(false).setEffectStrength(vibratorStrengthWithLimit).setEffectType(i10).setAsynchronous(true).build());
    }

    public static void unRegisterHapticObserver() {
        Context context = sContext;
        if (context != null) {
            context.getContentResolver().unregisterContentObserver(mHapticObserver);
            sContext = null;
        }
    }

    public static void setLinearMotorVibratorStrength(LinearmotorVibrator linearmotorVibrator, int i10, int i11, int i12, int i13, int i14, int i15, float f10) {
        if (linearmotorVibrator == null || !sHapticEnable || filterVibrator()) {
            return;
        }
        try {
            DynamicEffect dynamicEffect = getDynamicEffect(getVibratorValueWithLimit(i11, i12, i15 == 0 ? 75 : 48, i15 == 0 ? 90 : 55), Math.round(getVibratorValueWithLimit(i11, i12, i15 == 0 ? 50 : 52, i15 == 0 ? 100 : 68) * f10));
            if (dynamicEffect != null) {
                HapticPlayer hapticPlayer = new HapticPlayer(dynamicEffect);
                if (HapticPlayer.isAvailable()) {
                    hapticPlayer.start(1);
                    return;
                }
            }
        } catch (Exception e10) {
            Log.e(TAG, "get haptic player failed. error = " + e10.getMessage());
        }
        setLinearMotorVibratorStrength(linearmotorVibrator, i10, i11, i12, i13, i14);
    }
}
