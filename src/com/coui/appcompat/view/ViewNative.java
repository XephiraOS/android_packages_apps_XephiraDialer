package com.coui.appcompat.view;

import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;

/* loaded from: classes3.dex */
public class ViewNative {
    private static final String TAG = "ViewNative";
    private static final boolean USE_WRAPPER = true;
    private static final String VIEW_WRAPPER_PATH_NEW = "com.oplus.inner.view.ViewWrapper";
    private static String sViewNativeWrapperName;

    private static boolean canReachFrameworkWrapper() {
        try {
            Class.forName(VIEW_WRAPPER_PATH_NEW);
            return true;
        } catch (Exception e10) {
            Log.d(TAG, e10.toString());
            return false;
        }
    }

    public static void setScrollX(View view, int i10) {
        String viewNativeName;
        if (canReachFrameworkWrapper()) {
            viewNativeName = VIEW_WRAPPER_PATH_NEW;
        } else {
            viewNativeName = COUICompatUtil.getInstance().getViewNativeName();
        }
        sViewNativeWrapperName = viewNativeName;
        try {
            if (USE_WRAPPER) {
                Class.forName(viewNativeName).getDeclaredMethod("setScrollXForColor", View.class, Integer.TYPE).invoke(null, view, Integer.valueOf(i10));
            } else {
                Field declaredField = View.class.getDeclaredField("mScrollX");
                declaredField.setAccessible(true);
                declaredField.setInt(view, i10);
            }
        } catch (Exception e10) {
            Log.d(TAG, e10.toString());
        }
    }

    public static void setScrollY(View view, int i10) {
        String viewNativeName;
        if (canReachFrameworkWrapper()) {
            viewNativeName = VIEW_WRAPPER_PATH_NEW;
        } else {
            viewNativeName = COUICompatUtil.getInstance().getViewNativeName();
        }
        sViewNativeWrapperName = viewNativeName;
        try {
            if (USE_WRAPPER) {
                Class.forName(viewNativeName).getDeclaredMethod("setScrollYForColor", View.class, Integer.TYPE).invoke(null, view, Integer.valueOf(i10));
            } else {
                Field declaredField = View.class.getDeclaredField("mScrollY");
                declaredField.setAccessible(true);
                declaredField.setInt(view, i10);
            }
        } catch (Exception e10) {
            Log.d(TAG, e10.toString());
        }
    }
}
