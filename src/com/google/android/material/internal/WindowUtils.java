package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public class WindowUtils {
    private static final String TAG = "WindowUtils";

    /* loaded from: classes3.dex */
    public static class Api14Impl {
        private Api14Impl() {
        }

        public static Rect getCurrentWindowBounds(WindowManager windowManager) {
            int i10;
            Display defaultDisplay = windowManager.getDefaultDisplay();
            Point realSizeForDisplay = getRealSizeForDisplay(defaultDisplay);
            Rect rect = new Rect();
            int i11 = realSizeForDisplay.x;
            if (i11 != 0 && (i10 = realSizeForDisplay.y) != 0) {
                rect.right = i11;
                rect.bottom = i10;
            } else {
                defaultDisplay.getRectSize(rect);
            }
            return rect;
        }

        private static Point getRealSizeForDisplay(Display display) {
            Point point = new Point();
            try {
                Method declaredMethod = Display.class.getDeclaredMethod("getRealSize", Point.class);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(display, point);
            } catch (IllegalAccessException e10) {
                Log.w(WindowUtils.TAG, e10);
            } catch (NoSuchMethodException e11) {
                Log.w(WindowUtils.TAG, e11);
            } catch (InvocationTargetException e12) {
                Log.w(WindowUtils.TAG, e12);
            }
            return point;
        }
    }

    /* loaded from: classes3.dex */
    public static class Api17Impl {
        private Api17Impl() {
        }

        public static Rect getCurrentWindowBounds(WindowManager windowManager) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            Rect rect = new Rect();
            rect.right = point.x;
            rect.bottom = point.y;
            return rect;
        }
    }

    /* loaded from: classes3.dex */
    public static class Api30Impl {
        private Api30Impl() {
        }

        public static Rect getCurrentWindowBounds(WindowManager windowManager) {
            return windowManager.getCurrentWindowMetrics().getBounds();
        }
    }

    private WindowUtils() {
    }

    public static Rect getCurrentWindowBounds(Context context) {
        return Api30Impl.getCurrentWindowBounds((WindowManager) context.getSystemService("window"));
    }
}
