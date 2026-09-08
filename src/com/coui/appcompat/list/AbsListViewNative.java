package com.coui.appcompat.list;

import android.util.Log;
import android.widget.AbsListView;
import com.coui.appcompat.version.COUICompatUtil;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public class AbsListViewNative {
    private static final String TAG = "AbsListViewNative";
    public static final int TOUCH_MODE_DONE_WAITING = 2;
    public static final int TOUCH_MODE_DOWN = 0;
    public static final int TOUCH_MODE_FLING = 4;
    public static final int TOUCH_MODE_OVERFLING = 6;
    public static final int TOUCH_MODE_OVERSCROLL = 5;
    public static final int TOUCH_MODE_REST = -1;
    public static final int TOUCH_MODE_SCROLL = 3;
    public static final int TOUCH_MODE_TAP = 1;
    private static final boolean USE_WRAPPER = true;
    private static final String VIEW_WRAPPER_PATH_NEW = "com.oplus.inner.widget.AbsListViewWrapper";
    private static String sAbsListViewWrapperName;

    private static boolean canReachFrameworkWrapper() {
        try {
            Class.forName(VIEW_WRAPPER_PATH_NEW);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static int getTouchMode(AbsListView absListView) {
        String absListViewName;
        int i10;
        if (canReachFrameworkWrapper()) {
            absListViewName = VIEW_WRAPPER_PATH_NEW;
        } else {
            absListViewName = COUICompatUtil.getInstance().getAbsListViewName();
        }
        sAbsListViewWrapperName = absListViewName;
        try {
            if (USE_WRAPPER) {
                i10 = ((Integer) Class.forName(absListViewName).getDeclaredMethod("getTouchMode", AbsListView.class).invoke(null, absListView)).intValue();
            } else {
                Field declaredField = AbsListView.class.getDeclaredField("mTouchMode");
                declaredField.setAccessible(true);
                i10 = declaredField.getInt(absListView);
            }
            return i10;
        } catch (Exception e10) {
            Log.d(TAG, e10.toString());
            return -1;
        }
    }

    public static void setTouchMode(AbsListView absListView, int i10) {
        String absListViewName;
        if (canReachFrameworkWrapper()) {
            absListViewName = VIEW_WRAPPER_PATH_NEW;
        } else {
            absListViewName = COUICompatUtil.getInstance().getAbsListViewName();
        }
        sAbsListViewWrapperName = absListViewName;
        try {
            if (USE_WRAPPER) {
                Class.forName(absListViewName).getDeclaredMethod("setTouchMode", AbsListView.class, Integer.TYPE).invoke(null, absListView, Integer.valueOf(i10));
            } else {
                Field declaredField = AbsListView.class.getDeclaredField("mTouchMode");
                declaredField.setAccessible(true);
                declaredField.setInt(absListView, i10);
            }
        } catch (Exception e10) {
            Log.d(TAG, e10.toString());
        }
    }
}
