package com.coui.appcompat.panel;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowInsets;
import c9.C0572d;
import com.android.incallui.OplusPhoneUtils;
import com.coui.appcompat.orientationutil.COUIOrientationUtil;
import com.coui.appcompat.uiutil.FollowHandManager;
import com.coui.appcompat.uiutil.UIUtil;

/* loaded from: classes.dex */
public class COUIPanelMultiWindowUtils {
    private static final int DEFAULT_MARGIN_TOP = 40;
    private static final float LARGEST_SCREEN_HEIGHT_DP_THRESHOLD = 809.0f;
    private static final int NAV_STATE_SWIPE_SIDE_GESTURE = 3;
    private static final int SETTING_CLOSE_FLAG = 0;
    private static final int SETTING_OPEN_FLAG = 1;
    private static final float SMALLEST_SCREEN_WIDTH_DP_THRESHOLD = 600.0f;
    private static final float TWO_THIRDS = 0.66f;

    public static Activity contextToActivity(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    public static int dp2px(Context context, int i10) {
        return Double.valueOf((context.getResources().getDisplayMetrics().density * i10) + 0.5d).intValue();
    }

    public static int getCurrentPanelWindowVisibleHeight(Activity activity, Configuration configuration) {
        Rect currentWindowVisibleRect;
        int i10 = (!isInMultiWindowMode(activity) || (currentWindowVisibleRect = getCurrentWindowVisibleRect(activity)) == null) ? 0 : currentWindowVisibleRect.bottom - currentWindowVisibleRect.top;
        return i10 == 0 ? getPanelNormalVisibleHeight(activity, configuration) : i10;
    }

    public static int getCurrentWindowVisibleHeight(Activity activity, Configuration configuration) {
        int i10;
        Rect currentWindowVisibleRect;
        if (isInMultiWindowMode(activity) && (currentWindowVisibleRect = getCurrentWindowVisibleRect(activity)) != null) {
            i10 = currentWindowVisibleRect.bottom - currentWindowVisibleRect.top;
        } else {
            i10 = 0;
        }
        if (i10 == 0) {
            return getNormalVisibleHeight(activity, configuration);
        }
        return i10;
    }

    public static Rect getCurrentWindowVisibleRect(Activity activity) {
        if (activity != null) {
            View decorView = activity.getWindow().getDecorView();
            Rect rect = new Rect();
            decorView.getGlobalVisibleRect(rect);
            return rect;
        }
        return null;
    }

    public static int getNormalVisibleHeight(Context context, Configuration configuration) {
        int i10 = 0;
        if (context == null) {
            return 0;
        }
        if (configuration == null) {
            configuration = context.getResources().getConfiguration();
        }
        int screenHeightRealSize = UIUtil.getScreenHeightRealSize(context);
        int statusBarHeight = getStatusBarHeight(context);
        if (COUINavigationBarUtil.isNavigationBarShow(context) && (configuration.screenWidthDp >= SMALLEST_SCREEN_WIDTH_DP_THRESHOLD || isPortrait(configuration))) {
            i10 = COUINavigationBarUtil.getNavigationBarHeight(context);
        }
        return (screenHeightRealSize - statusBarHeight) - i10;
    }

    public static int getPanelMarginBottom(Context context, Configuration configuration) {
        if (context == null || configuration == null) {
            return 0;
        }
        int i10 = configuration.screenWidthDp;
        boolean z10 = (configuration.screenLayout & 15) == 1;
        boolean z11 = configuration.orientation == 2;
        if (i10 < SMALLEST_SCREEN_WIDTH_DP_THRESHOLD && (z10 || !z11)) {
            return 0;
        }
        if (getStatusBarHeight(context) == 0) {
            return context.createConfigurationContext(configuration).getResources().getDimensionPixelOffset(C0572d.f12885h);
        }
        return context.createConfigurationContext(configuration).getResources().getDimensionPixelOffset(C0572d.f12882e);
    }

    public static int getPanelMaxHeight(Context context, Configuration configuration) {
        int panelNormalVisibleHeight;
        int panelMarginBottom;
        Activity contextToActivity = contextToActivity(context);
        if (configuration == null) {
            configuration = context.getResources().getConfiguration();
        }
        if (contextToActivity != null) {
            panelNormalVisibleHeight = getCurrentPanelWindowVisibleHeight(contextToActivity, configuration);
            panelMarginBottom = getPanelMarginBottom(context, configuration);
        } else {
            panelNormalVisibleHeight = getPanelNormalVisibleHeight(context, configuration);
            panelMarginBottom = getPanelMarginBottom(context, configuration);
        }
        return Math.min(panelNormalVisibleHeight - panelMarginBottom, getPanelPercentFrameLayoutMaxHeight(context, context.getResources().getDimensionPixelOffset(C0572d.f12900w)));
    }

    public static int getPanelNormalVisibleHeight(Context context, Configuration configuration) {
        int i10 = 0;
        if (context == null) {
            return 0;
        }
        if (configuration == null) {
            configuration = context.getResources().getConfiguration();
        }
        int screenHeightRealSize = UIUtil.getScreenHeightRealSize(context);
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(C0572d.f12902y);
        if (getStatusBarHeight(context) == 0) {
            dimensionPixelOffset = context.getResources().getDimensionPixelOffset(C0572d.f12885h);
        }
        boolean isNavigationBarShow = COUINavigationBarUtil.isNavigationBarShow(context);
        boolean z10 = ((configuration.screenLayout & 15) == 2) && (configuration.orientation == 2);
        if (isNavigationBarShow && ((configuration.screenWidthDp >= SMALLEST_SCREEN_WIDTH_DP_THRESHOLD || isPortrait(configuration)) && isVirtualNavigation(context) && !z10)) {
            i10 = COUINavigationBarUtil.getNavigationBarHeight(context);
        }
        return (screenHeightRealSize - dimensionPixelOffset) - i10;
    }

    public static int getStatusBarHeight(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int getStatusBarHeightAfterR(WindowInsets windowInsets) {
        return Math.abs(windowInsets.getInsets(WindowInsets.Type.statusBars()).bottom - windowInsets.getInsets(WindowInsets.Type.statusBars()).top);
    }

    public static boolean isDisplayInHorizontal(Activity activity) {
        if (activity == null || activity.getResources().getConfiguration().orientation != 2 || !isInMultiWindowMode(activity)) {
            return false;
        }
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(new Rect());
        if (r2.right - r2.left >= UIUtil.getScreenWidthRealSize(activity) * TWO_THIRDS) {
            return false;
        }
        return true;
    }

    public static boolean isDisplayInPrimaryScreen(Activity activity) {
        if (activity == null) {
            return true;
        }
        int statusBarHeight = getStatusBarHeight(activity);
        int[] iArr = new int[2];
        activity.getWindow().getDecorView().getLocationOnScreen(iArr);
        if (iArr[0] <= statusBarHeight && iArr[1] <= statusBarHeight) {
            return true;
        }
        return false;
    }

    public static boolean isDisplayInUpperWindow(Activity activity) {
        if (activity == null) {
            return true;
        }
        int[] iArr = new int[2];
        activity.getWindow().getDecorView().getLocationOnScreen(iArr);
        if (iArr[1] <= getStatusBarHeight(activity)) {
            return true;
        }
        return false;
    }

    public static boolean isInMultiWindowMode(Activity activity) {
        if (activity != null && activity.isInMultiWindowMode()) {
            return true;
        }
        return false;
    }

    public static boolean isLand(Context context) {
        if (context.getResources().getConfiguration().orientation == 2) {
            return true;
        }
        return false;
    }

    public static boolean isLargeHeightScreen(Context context, Configuration configuration) {
        if (configuration == null) {
            configuration = context.getResources().getConfiguration();
        }
        if (configuration.screenHeightDp > LARGEST_SCREEN_HEIGHT_DP_THRESHOLD) {
            return true;
        }
        return false;
    }

    public static boolean isNormalLandScreen(Context context, Configuration configuration) {
        boolean z10;
        boolean z11;
        if (context == null || configuration == null) {
            return false;
        }
        if ((configuration.screenLayout & 15) == 2) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (configuration.orientation == 2) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z10 || !z11) {
            return false;
        }
        return true;
    }

    public static boolean isNormalScreen(Context context, Configuration configuration) {
        if (context == null || configuration == null || (configuration.screenLayout & 15) != 2) {
            return false;
        }
        return true;
    }

    public static boolean isPortrait(Context context) {
        return isPortrait(context.getResources().getConfiguration());
    }

    public static boolean isSmallScreen(Context context, Configuration configuration) {
        if (configuration == null) {
            configuration = context.getResources().getConfiguration();
        }
        if (configuration.screenWidthDp < SMALLEST_SCREEN_WIDTH_DP_THRESHOLD) {
            return true;
        }
        return false;
    }

    public static boolean isTaskBarShowInApp(Context context) {
        if (Settings.System.getInt(context.getContentResolver(), "enable_launcher_taskbar", 0) != 1) {
            return false;
        }
        return true;
    }

    public static boolean isVirtualNavigation(Context context) {
        if (Settings.Secure.getInt(context.getContentResolver(), OplusPhoneUtils.KEY_NAV_STATE, 0) == 3) {
            return false;
        }
        return true;
    }

    public static boolean isPortrait(Configuration configuration) {
        return configuration.orientation == 1;
    }

    public static int getStatusBarHeight(WindowInsets windowInsets, Context context) {
        return getStatusBarHeightAfterR(windowInsets);
    }

    public static int getCurrentPanelWindowVisibleHeight(Activity activity, Configuration configuration, WindowInsets windowInsets) {
        int i10;
        if (isInMultiWindowMode(activity)) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            int dimensionPixelOffset = activity.getResources().getDimensionPixelOffset(C0572d.f12902y);
            if (getStatusBarHeight(windowInsets, activity) == 0) {
                dimensionPixelOffset = activity.getResources().getDimensionPixelOffset(C0572d.f12885h);
            }
            i10 = (displayMetrics.heightPixels - windowInsets.getInsets(WindowInsets.Type.navigationBars()).bottom) - dimensionPixelOffset;
        } else {
            i10 = 0;
        }
        return i10 == 0 ? getPanelNormalVisibleHeight(activity, configuration, windowInsets) : i10;
    }

    public static int getPanelMarginBottom(Context context, Configuration configuration, WindowInsets windowInsets, boolean z10) {
        if (context == null || configuration == null || z10) {
            return 0;
        }
        int i10 = configuration.screenWidthDp;
        boolean z11 = (configuration.screenLayout & 15) == 1;
        boolean z12 = configuration.orientation == 2;
        if (i10 < SMALLEST_SCREEN_WIDTH_DP_THRESHOLD && (z11 || !z12)) {
            return 0;
        }
        int i11 = windowInsets.getInsets(WindowInsets.Type.navigationBars()).bottom;
        if ((context.getResources().getConfiguration().screenLayout & 48) == 32) {
            return Math.max(0, context.createConfigurationContext(configuration).getResources().getDimensionPixelOffset(C0572d.f12883f) - i11);
        }
        int dimensionPixelOffset = context.createConfigurationContext(configuration).getResources().getDimensionPixelOffset(C0572d.f12882e);
        return Math.max(0, (FollowHandManager.ifWidthDpIsFullScreen(context) && COUIOrientationUtil.isInMultiWindowMode(contextToActivity(context)) && !isVirtualNavigation(context) && isTaskBarShowInApp(context)) ? Math.max(dimensionPixelOffset, i11) : dimensionPixelOffset - i11);
    }

    public static int getPanelMaxHeight(Context context, Configuration configuration, WindowInsets windowInsets, boolean z10) {
        int panelNormalVisibleHeight;
        int panelMarginBottom;
        Activity contextToActivity = contextToActivity(context);
        if (configuration == null) {
            configuration = context.getResources().getConfiguration();
        }
        if (contextToActivity != null) {
            panelNormalVisibleHeight = getCurrentPanelWindowVisibleHeight(contextToActivity, configuration, windowInsets);
            panelMarginBottom = getPanelMarginBottom(context, configuration, windowInsets, z10);
        } else {
            panelNormalVisibleHeight = getPanelNormalVisibleHeight(context, configuration, windowInsets);
            panelMarginBottom = getPanelMarginBottom(context, configuration, windowInsets, z10);
        }
        return Math.min(panelNormalVisibleHeight - panelMarginBottom, getPanelPercentFrameLayoutMaxHeight(context, context.getResources().getDimensionPixelOffset(C0572d.f12900w)));
    }

    public static int getPanelNormalVisibleHeight(Context context, Configuration configuration, WindowInsets windowInsets) {
        int i10 = 0;
        if (context == null) {
            return 0;
        }
        if (configuration == null) {
            configuration = context.getResources().getConfiguration();
        }
        int screenHeightRealSize = UIUtil.getScreenHeightRealSize(context);
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(C0572d.f12902y);
        if (getStatusBarHeight(windowInsets, context) == 0) {
            dimensionPixelOffset = context.getResources().getDimensionPixelOffset(C0572d.f12885h);
        }
        boolean isNavigationBarShow = COUINavigationBarUtil.isNavigationBarShow(context);
        boolean z10 = ((configuration.screenLayout & 15) == 2) && (configuration.orientation == 2);
        if (isNavigationBarShow && ((configuration.screenWidthDp >= SMALLEST_SCREEN_WIDTH_DP_THRESHOLD || isPortrait(configuration)) && isVirtualNavigation(context) && !z10)) {
            i10 = COUINavigationBarUtil.getNavigationBarHeight(context);
        }
        return (screenHeightRealSize - dimensionPixelOffset) - i10;
    }

    public static int getPanelPercentFrameLayoutMaxHeight(Context context, int i10) {
        return i10;
    }
}
