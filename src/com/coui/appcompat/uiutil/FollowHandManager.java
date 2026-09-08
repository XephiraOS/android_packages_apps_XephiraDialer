package com.coui.appcompat.uiutil;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;
import android.view.DisplayCutout;
import android.view.View;
import com.coui.appcompat.log.COUILog;

/* loaded from: classes3.dex */
public class FollowHandManager {
    private static final String TAG = "FollowHandManager";
    private static Rect sAnchorRectInWindow;
    private static Rect sDecorViewRectInWindow;
    private static Rect sLimitRectInWindow;
    private static int[] sWindowLocationOnScreen = new int[2];
    private static int[] sTouchPosition = new int[2];
    private static Point sClickLocationInWindow = new Point();
    private static Rect sPaddingRect = new Rect();
    private static Rect sMarginRect = new Rect();
    private static int[] sAnchorLocationInWindow = new int[2];

    public static Point calculatePosition(Context context, int i10, int i11, boolean z10) {
        int i12;
        int i13;
        int i14;
        if (sAnchorRectInWindow == null) {
            Log.e(TAG, "The AnchorRectInWindow is null");
            return null;
        }
        Point point = new Point();
        int i15 = sClickLocationInWindow.x - (i10 / 2);
        if (ifSetOffset()) {
            i12 = sClickLocationInWindow.y;
        } else {
            i12 = sAnchorRectInWindow.bottom;
        }
        if (ifSetOffset()) {
            i13 = sClickLocationInWindow.y;
        } else {
            i13 = sAnchorRectInWindow.top;
        }
        int boundaryBottomInWindow = getBoundaryBottomInWindow() - i12;
        Rect rect = sMarginRect;
        int i16 = rect.top;
        int i17 = rect.bottom;
        if (boundaryBottomInWindow >= i11 + i16 + i17) {
            if (i16 + i12 + i11 < getBoundaryBottomInWindow()) {
                i12 += sMarginRect.top;
            }
        } else {
            i12 = (i13 - i11) - i17;
        }
        int max = Math.max(getBoundaryLeftInWindow() + sMarginRect.left, Math.min(i15, (getBoundaryRightInWindow() - sMarginRect.right) - i10));
        if (z10 && ifWidthDpIsFullScreen(context) && (i14 = sWindowLocationOnScreen[0]) > 0) {
            max += i14;
        }
        point.set(max, Math.max(getBoundaryTopInWindow() + sMarginRect.top, i12));
        return point;
    }

    public static Rect getAnchorRectInWindow() {
        return sAnchorRectInWindow;
    }

    public static int getBoundaryBottomInWindow() {
        int i10;
        Rect rect = sDecorViewRectInWindow;
        if (rect == null) {
            COUILog.e(TAG, "The sDecorViewRectInWindow is null, must calling init() first");
            return 0;
        }
        Rect rect2 = sLimitRectInWindow;
        if (rect2 != null) {
            i10 = rect2.bottom;
        } else {
            i10 = rect.bottom;
        }
        return i10 - sPaddingRect.bottom;
    }

    public static int getBoundaryLeftInWindow() {
        int i10;
        Rect rect = sDecorViewRectInWindow;
        if (rect == null) {
            COUILog.e(TAG, "The sDecorViewRectInWindow is null, must calling init() first");
            return 0;
        }
        Rect rect2 = sLimitRectInWindow;
        if (rect2 != null) {
            i10 = rect2.left;
        } else {
            i10 = rect.left;
        }
        return i10 + sPaddingRect.left;
    }

    public static int getBoundaryRightInWindow() {
        int i10;
        Rect rect = sDecorViewRectInWindow;
        if (rect == null) {
            COUILog.e(TAG, "The sDecorViewRectInWindow is null, must calling init() first");
            return 0;
        }
        Rect rect2 = sLimitRectInWindow;
        if (rect2 != null) {
            i10 = rect2.right;
        } else {
            i10 = rect.right;
        }
        return i10 - sPaddingRect.right;
    }

    public static int getBoundaryTopInWindow() {
        int i10;
        Rect rect = sDecorViewRectInWindow;
        if (rect == null) {
            COUILog.e(TAG, "The sDecorViewRectInWindow is null, must calling init() first");
            return 0;
        }
        Rect rect2 = sLimitRectInWindow;
        if (rect2 != null) {
            i10 = rect2.top;
        } else {
            i10 = rect.top;
        }
        return i10 + sPaddingRect.top;
    }

    public static int getClickPositionXInWindow() {
        if (ifSetOffset()) {
            return sTouchPosition[0] + sAnchorLocationInWindow[0];
        }
        Rect rect = sAnchorRectInWindow;
        if (rect == null) {
            COUILog.e(TAG, "The AnchorRectInWindow is null, must calling init() first");
            return 0;
        }
        return rect.centerX();
    }

    public static int getClickPositionYInWindow() {
        if (ifSetOffset()) {
            return sTouchPosition[1] + sAnchorLocationInWindow[1];
        }
        Rect rect = sAnchorRectInWindow;
        if (rect == null) {
            COUILog.e(TAG, "The AnchorRectInWindow is null, must calling init() first");
            return 0;
        }
        return rect.centerY();
    }

    public static Rect getDecorViewRectInWindow() {
        return sDecorViewRectInWindow;
    }

    public static Rect getLimitRectInWindow() {
        return sLimitRectInWindow;
    }

    public static Rect getMarginRect() {
        return sMarginRect;
    }

    public static Rect getPaddingRect() {
        return sPaddingRect;
    }

    public static int[] getWindowLocationOnScreen() {
        return sWindowLocationOnScreen;
    }

    public static boolean ifSetOffset() {
        int[] iArr = sTouchPosition;
        if (iArr[0] == 0 && iArr[1] == 0) {
            return false;
        }
        return true;
    }

    public static boolean ifWidthDpIsFullScreen(Context context) {
        double d10 = context.getResources().getConfiguration().screenWidthDp;
        double screenWidthRealSize = UIUtil.getScreenWidthRealSize(context) / context.getResources().getDisplayMetrics().density;
        if (d10 != Math.floor(screenWidthRealSize) && d10 != Math.ceil(screenWidthRealSize)) {
            return false;
        }
        return true;
    }

    public static void init(View view) {
        init(view, 0, 0);
    }

    private static void reset() {
        setOffset(0, 0);
        setLimitRectInWindow(null);
        sPaddingRect.set(0, 0, 0, 0);
        sMarginRect.set(0, 0, 0, 0);
    }

    public static void setLimitRectInWindow(Rect rect) {
        sLimitRectInWindow = rect;
    }

    public static void setMargin(Rect rect) {
        sMarginRect = rect;
    }

    public static void setOffset(int i10, int i11) {
        int[] iArr = sTouchPosition;
        iArr[0] = i10;
        iArr[1] = i11;
    }

    public static void setPadding(Rect rect) {
        sPaddingRect = rect;
    }

    public static void init(View view, int i10, int i11) {
        DisplayCutout displayCutout;
        reset();
        if (i10 != 0 || i11 != 0) {
            setOffset(i10, i11);
        }
        int[] iArr = new int[2];
        sDecorViewRectInWindow = new Rect();
        sAnchorRectInWindow = new Rect();
        view.getWindowVisibleDisplayFrame(sDecorViewRectInWindow);
        view.getGlobalVisibleRect(sAnchorRectInWindow);
        Rect rect = new Rect();
        view.getRootView().getGlobalVisibleRect(rect);
        view.getRootView().getLocationOnScreen(iArr);
        rect.offset(iArr[0], iArr[1]);
        Rect rect2 = sDecorViewRectInWindow;
        rect2.left = Math.max(rect2.left, rect.left);
        Rect rect3 = sDecorViewRectInWindow;
        rect3.top = Math.max(rect3.top, rect.top);
        Rect rect4 = sDecorViewRectInWindow;
        rect4.right = Math.min(rect4.right, rect.right);
        Rect rect5 = sDecorViewRectInWindow;
        rect5.bottom = Math.min(rect5.bottom, rect.bottom);
        view.getRootView().getLocationOnScreen(iArr);
        int i12 = iArr[0];
        int i13 = iArr[1];
        view.getRootView().getLocationInWindow(iArr);
        int i14 = iArr[0];
        int i15 = iArr[1];
        int[] iArr2 = sWindowLocationOnScreen;
        int i16 = i12 - i14;
        iArr2[0] = i16;
        int i17 = i13 - i15;
        iArr2[1] = i17;
        sDecorViewRectInWindow.offset(-i16, -i17);
        view.getLocationInWindow(sAnchorLocationInWindow);
        sClickLocationInWindow.x = getClickPositionXInWindow();
        sClickLocationInWindow.y = getClickPositionYInWindow();
        if (view.getRootWindowInsets() == null || (displayCutout = view.getRootWindowInsets().getDisplayCutout()) == null) {
            return;
        }
        for (Rect rect6 : displayCutout.getBoundingRects()) {
            int i18 = rect6.top;
            if (i18 == 0) {
                Rect rect7 = sDecorViewRectInWindow;
                rect7.top = Math.max(rect7.top, rect6.bottom);
            } else {
                int i19 = rect6.bottom;
                Rect rect8 = sDecorViewRectInWindow;
                int i20 = rect8.bottom;
                if (i19 == i20) {
                    rect8.bottom = Math.min(i20, i18);
                } else {
                    int i21 = rect6.left;
                    if (i21 == 0) {
                        rect8.left = Math.max(rect8.left, rect6.right);
                    } else {
                        int i22 = rect6.right;
                        int i23 = rect8.right;
                        if (i22 == i23) {
                            rect8.right = Math.min(i23, i21);
                        }
                    }
                }
            }
        }
    }
}
