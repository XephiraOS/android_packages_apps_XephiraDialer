package com.coui.appcompat.baseview.util;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.provider.Settings;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.ImageView;
import androidx.core.view.Y;
import com.coui.appcompat.baseview.util.SystemBarUtil;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import com.coui.appcompat.panel.COUIPanelMultiWindowUtils;
import kotlin.jvm.internal.i;

/* compiled from: SystemBarUtil.kt */
/* loaded from: classes.dex */
public final class SystemBarUtil {
    public static final SystemBarUtil INSTANCE = new SystemBarUtil();
    private static final String NAVIGATION_BAR_KEY = "hide_navigationbar_enable";
    private static final int NAV_STATE_SWIPE_SIDE_GESTURE = 3;
    private static final int NAV_STATE_SWIPE_UP_GESTURE = 2;

    private SystemBarUtil() {
    }

    private static final void fixNavigationBarPadding(Activity activity, WindowInsets windowInsets) {
        int i10 = windowInsets.getInsets(WindowInsets.Type.navigationBars()).bottom;
        if (isGestureNavigation(activity)) {
            i10 = 0;
        }
        activity.findViewById(R.id.content).setPadding(0, 0, 0, i10);
    }

    public static final View getStatusBarView(Context context) {
        i.f(context, "context");
        int statusBarHeight = COUIPanelMultiWindowUtils.getStatusBarHeight(context);
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, statusBarHeight));
        return imageView;
    }

    public static final boolean isGestureNavigation(Context context) {
        i.f(context, "context");
        int i10 = Settings.Secure.getInt(context.getContentResolver(), "hide_navigationbar_enable", 0);
        if (i10 != 2 && i10 != 3) {
            return false;
        }
        return true;
    }

    public static final void setStatusBarTransparentAndBlackFont(final Activity activity) {
        i.f(activity, "activity");
        Window window = activity.getWindow();
        window.setDecorFitsSystemWindows(false);
        window.setNavigationBarContrastEnforced(false);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.layoutInDisplayCutoutMode = 3;
        window.setAttributes(attributes);
        window.getDecorView().setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: w3.a
            @Override // android.view.View.OnApplyWindowInsetsListener
            public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                WindowInsets statusBarTransparentAndBlackFont$lambda$2$lambda$1;
                statusBarTransparentAndBlackFont$lambda$2$lambda$1 = SystemBarUtil.setStatusBarTransparentAndBlackFont$lambda$2$lambda$1(activity, view, windowInsets);
                return statusBarTransparentAndBlackFont$lambda$2$lambda$1;
            }
        });
        window.setStatusBarColor(0);
        window.setNavigationBarColor(0);
        new Y(activity.getWindow(), window.getDecorView()).d(!COUIDarkModeUtil.isNightMode(activity));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsets setStatusBarTransparentAndBlackFont$lambda$2$lambda$1(Activity activity, View view, WindowInsets insets) {
        i.f(activity, "$activity");
        i.e(insets, "insets");
        fixNavigationBarPadding(activity, insets);
        return insets;
    }
}
