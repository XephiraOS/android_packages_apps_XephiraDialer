package com.coui.appcompat.dialog;

import android.content.Context;
import android.provider.Settings;
import android.util.Log;
import com.oplus.content.OplusFeatureConfigManager;

/* loaded from: classes.dex */
public class AppFeatureUtil {
    public static final float DENSITY_160F = 160.0f;
    public static final float DENSITY_360F = 360.0f;
    private static final String FEATURE_FOLD = "oplus.hardware.type.fold";
    private static final String FEATURE_FOLD_REMAP_DISPLAY_DISABLED = "oplus.software.fold_remap_display_disabled";
    private static final String FEATURE_LIGHT_FUNC = "com.android.wallpaper.livepicker.LIGHT_WEIGHT_OS_FUNC";
    private static final String FEATURE_SEPARATE_WALLPAPER_FOR_MULTI_DISPLAY = "oplus.software.wallpaper.separate_wallpaper_for_multi_display";
    private static final String FOLD_MODE_NAME = "oplus_system_folding_mode";
    private static final int FOLD_STATE_CLOSED = 0;
    private static final int FOLD_STATE_NOT = -1;
    private static final int FOLD_STATE_OPEN = 1;
    private static final String TAG = "AppFeatureUtil";

    public static boolean isFlipDisplayFeature(Context context) {
        if (context == null) {
            return false;
        }
        try {
            if (!isFoldDisplayFeature(context)) {
                return false;
            }
            if (!OplusFeatureConfigManager.getInstance().hasFeature(FEATURE_FOLD_REMAP_DISPLAY_DISABLED)) {
                return false;
            }
            return true;
        } catch (Error | Exception e10) {
            Log.d(TAG, "Load feature_fold_remap_display failed : " + e10.getMessage());
            return false;
        }
    }

    public static boolean isFoldDisplayFeature(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return OplusFeatureConfigManager.getInstance().hasFeature(FEATURE_FOLD);
        } catch (Error | Exception e10) {
            Log.d(TAG, "Load feature_fold failed : " + e10.getMessage());
            return false;
        }
    }

    public static boolean isFoldLargeScreen(Context context) {
        if (context == null || Settings.Global.getInt(context.getContentResolver(), "oplus_system_folding_mode", 0) != 1) {
            return false;
        }
        return true;
    }

    public static boolean isFoldSmallScreen(Context context) {
        if (Settings.Global.getInt(context.getContentResolver(), "oplus_system_folding_mode", 0) != 0) {
            return false;
        }
        return true;
    }

    public static boolean isSecondaryScreen(Context context) {
        if (isFoldDisplayFeature(context) && isFoldSmallScreen(context)) {
            return true;
        }
        return false;
    }

    public static boolean isSeparateWallpaperForMultiDisplay(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return OplusFeatureConfigManager.getInstance().hasFeature(FEATURE_SEPARATE_WALLPAPER_FOR_MULTI_DISPLAY);
        } catch (Error | Exception e10) {
            Log.d(TAG, "Load feature_multi_display failed : " + e10.getMessage());
            return false;
        }
    }
}
