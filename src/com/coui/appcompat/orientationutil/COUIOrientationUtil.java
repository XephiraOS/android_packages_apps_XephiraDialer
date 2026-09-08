package com.coui.appcompat.orientationutil;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.view.WindowManager;

/* loaded from: classes.dex */
public class COUIOrientationUtil {
    public static final int ORIENTATION_LANDSCAPE = 2;
    public static final int ORIENTATION_PORTRAIT = 1;

    public static int getRealOrientation(Context context) {
        Point screenSize = getScreenSize(context);
        boolean isInMultiWindowMode = isInMultiWindowMode(context);
        if (screenSize.x > screenSize.y && !isInMultiWindowMode) {
            return 2;
        }
        return 1;
    }

    public static Point getScreenSize(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Point point = new Point();
        windowManager.getDefaultDisplay().getRealSize(point);
        return point;
    }

    public static boolean isInMultiWindowMode(Context context) {
        if (context instanceof Activity) {
            return ((Activity) context).isInMultiWindowMode();
        }
        return false;
    }

    public static boolean isPortrait(int i10) {
        return i10 == 1;
    }

    public static boolean isPortrait(Context context) {
        return getRealOrientation(context) == 1;
    }
}
