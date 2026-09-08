package com.coui.appcompat.panel;

import android.content.Context;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.net.Uri;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import com.android.incallui.OplusPhoneUtils;

/* loaded from: classes.dex */
public class COUINavigationBarUtil {
    private static final String HIDE_NAVIGATION_BAR_ENABLE = "hide_navigationbar_enable";
    private static final String MANUAL_HIDE_NAVIGATION_BAR = "manual_hide_navigationbar";
    private static final String NAVIGATION_BAR_HEIGHT = "navigation_bar_height";
    private static final String NAVIGATION_BAR_IMMERSIVE = "nav_bar_immersive";
    private static final Uri NAVIGATION_BAR_IMMERSIVE_URI = Settings.Secure.getUriFor(NAVIGATION_BAR_IMMERSIVE);
    private static final int NAV_STATE_SWIPE_SIDE_GESTURE = 3;
    private static final int NAV_STATE_SWIPE_UP_GESTURE = 2;
    private static final int NAV_STATE_VIRTUAL_KEY = 0;
    private static final int NAV_STATE_VIRTUAL_KEY_AND_HIDE = 1;
    private static final String TAG = "NavigationBarUtils";

    /* loaded from: classes.dex */
    public interface NavigationBarChangeListener {
        void onNavigationBarChange(boolean z10);
    }

    /* loaded from: classes.dex */
    public static class NavigationBarContentObserver extends ContentObserver {
        private Context mContext;
        private NavigationBarChangeListener mListener;

        public NavigationBarContentObserver(Context context, NavigationBarChangeListener navigationBarChangeListener) {
            super(null);
            this.mContext = context;
            this.mListener = navigationBarChangeListener;
        }

        public void clearListener() {
            if (this.mListener != null) {
                this.mListener = null;
            }
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            super.onChange(z10);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10, Uri uri) {
            Context context;
            super.onChange(z10, uri);
            if (COUINavigationBarUtil.NAVIGATION_BAR_IMMERSIVE_URI == null || !COUINavigationBarUtil.NAVIGATION_BAR_IMMERSIVE_URI.equals(uri) || (context = this.mContext) == null || this.mListener == null) {
                return;
            }
            this.mListener.onNavigationBarChange(Settings.Secure.getInt(context.getContentResolver(), COUINavigationBarUtil.NAVIGATION_BAR_IMMERSIVE, 0) == 0);
        }
    }

    public static int getNavigationBarHeight(Context context) {
        if (context == null) {
            return 0;
        }
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(resources.getIdentifier(NAVIGATION_BAR_HEIGHT, "dimen", "android"));
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics2);
        float f10 = displayMetrics2.density;
        float f11 = displayMetrics.density;
        if (f10 != f11) {
            return (int) ((dimensionPixelSize * (f10 / f11)) + 0.5f);
        }
        return dimensionPixelSize;
    }

    public static boolean isGestureNavigation(Context context) {
        if (Settings.Secure.getInt(context.getContentResolver(), "hide_navigationbar_enable", 0) != 3) {
            return false;
        }
        return true;
    }

    public static boolean isNavigationBarShow(Context context) {
        if (!isSupportNavigationBar(context)) {
            return false;
        }
        Settings.Secure.getInt(context.getContentResolver(), "hide_navigationbar_enable", 0);
        Settings.Secure.getInt(context.getContentResolver(), MANUAL_HIDE_NAVIGATION_BAR, 0);
        return true;
    }

    public static boolean isSupportNavigationBar(Context context) {
        boolean z10;
        boolean z11 = false;
        if (context == null) {
            return false;
        }
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        if (identifier > 0) {
            z10 = resources.getBoolean(identifier);
        } else {
            z10 = false;
        }
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getMethod("get", String.class).invoke(cls, "qemu.hw.mainkeys");
            if (!OplusPhoneUtils.DeviceState.LOCK_DEVICE.equals(str)) {
                if (OplusPhoneUtils.DeviceState.UNLOCK_DEVICE.equals(str)) {
                    z11 = true;
                } else {
                    z11 = z10;
                }
            }
            return z11;
        } catch (Exception e10) {
            Log.d(TAG, "fail to get navigation bar status message is " + e10.getMessage());
            return z10;
        }
    }

    public static NavigationBarContentObserver registerObserver(Context context, NavigationBarChangeListener navigationBarChangeListener) {
        if (context == null) {
            return null;
        }
        NavigationBarContentObserver navigationBarContentObserver = new NavigationBarContentObserver(context, navigationBarChangeListener);
        context.getContentResolver().registerContentObserver(NAVIGATION_BAR_IMMERSIVE_URI, false, navigationBarContentObserver);
        return navigationBarContentObserver;
    }

    public static void unregisterObserver(Context context, NavigationBarContentObserver navigationBarContentObserver) {
        if (context != null && navigationBarContentObserver != null) {
            navigationBarContentObserver.clearListener();
            context.getContentResolver().unregisterContentObserver(navigationBarContentObserver);
        }
    }
}
