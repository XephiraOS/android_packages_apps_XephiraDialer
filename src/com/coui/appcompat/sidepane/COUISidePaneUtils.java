package com.coui.appcompat.sidepane;

import Y8.d;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class COUISidePaneUtils {
    private static final int LARGE_SCREEN_HEIGHT_DP_THRESHOLD = 900;
    private static final int LARGE_SCREEN_WIDTH_DP_THRESHOLD = 600;
    private static final int SMALLEST_SCREEN_HEIGHT_DP_THRESHOLD = 480;
    private static final int SMALLEST_SCREEN_WIDTH_DP_THRESHOLD = 600;
    private static final float START_EDIT_ICON_ALPHA_OFFSET = 0.9f;

    public static boolean isInMultiWindowMode(Activity activity) {
        if (activity != null && activity.isInMultiWindowMode()) {
            return true;
        }
        return false;
    }

    public static boolean isLargeScreenStyle(Context context) {
        if (context.getResources().getConfiguration().screenWidthDp >= 600 && context.getResources().getConfiguration().screenHeightDp >= LARGE_SCREEN_HEIGHT_DP_THRESHOLD) {
            return true;
        }
        return false;
    }

    public static boolean isMediumScreenStyle(Activity activity) {
        if (activity.getResources().getConfiguration().screenWidthDp >= 600 && (activity.getResources().getConfiguration().screenHeightDp >= 480 || isInMultiWindowMode(activity))) {
            return true;
        }
        return false;
    }

    public static void makeFirstEditIconAnim(float f10, View view, Context context) {
        if (f10 <= 1.0f && f10 >= 0.0f) {
            if (f10 >= 0.9f) {
                view.setAlpha((f10 - 0.9f) / 0.100000024f);
                view.setVisibility(0);
            } else {
                view.setAlpha(0.0f);
                view.setVisibility(8);
            }
        }
    }

    public static void makeSecToolbarAnim(float f10, View view, Context context) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).setMarginStart((int) (context.getResources().getDimensionPixelOffset(d.f5617I) * (1.0f - f10)));
        }
    }

    public static void restoreInstanceToolbar(View view, Context context) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).setMarginStart(context.getResources().getDimensionPixelOffset(d.f5617I));
        }
    }
}
