package com.coui.appcompat.grid;

import X8.f;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.coui.appcompat.dialog.AppFeatureUtil;
import com.coui.appcompat.log.COUILog;
import com.coui.component.responsiveui.ResponsiveUIModel;
import com.coui.component.responsiveui.layoutgrid.MarginType;
import com.coui.component.responsiveui.unit.Dp;
import com.coui.component.responsiveui.window.WindowSizeClass;
import com.coui.component.responsiveui.window.WindowTotalSizeClass;
import com.coui.component.responsiveui.window.WindowWidthSizeClass;
import java.util.Arrays;

/* loaded from: classes.dex */
public class COUIResponsiveUtils {
    private static final int CARD_LIST_FLAG = 2;
    private static boolean DEBUG = false;
    private static final int DEFAULT_COLUMNS_FOR_CHILD = 8;
    private static final int DEFAULT_FLAG = 0;
    private static final int LARGE_PADDING = 0;
    private static final int LIST_FLAG = 1;
    private static final int MARGIN_LARGE_DP_IN_LARGE_SCREEN = 40;
    private static final int MARGIN_LARGE_DP_IN_NON_LARGE_SCREEN = 24;
    private static final int PADDING_COUNT = 2;
    private static final int PADDING_MODE = 0;
    private static final int REMEASURE_MODE = 1;
    private static final int SMALL_PADDING = 1;
    private static final String TAG = "COUIResponsiveUtils";
    private static int sCouiFoldType;
    private static final Point sPoint;
    private static final Rect sRect;

    static {
        boolean z10;
        if (!COUILog.LOG_DEBUG && !COUILog.isLoggable(TAG, 3)) {
            z10 = false;
        } else {
            z10 = true;
        }
        DEBUG = z10;
        sRect = new Rect();
        sPoint = new Point();
        sCouiFoldType = -1;
    }

    public static void calculatePadding(ResponsiveUIModel responsiveUIModel, int i10, int i11, boolean z10, float[] fArr) {
        int margin = responsiveUIModel.margin();
        int gutter = responsiveUIModel.gutter();
        int columnCount = responsiveUIModel.columnCount();
        int[] columnWidth = responsiveUIModel.columnWidth();
        int i12 = (columnCount - i10) / 2;
        if (z10) {
            margin -= i11;
        }
        float f10 = margin;
        fArr[1] = f10;
        fArr[0] = f10;
        for (int i13 = 0; i13 < i12; i13++) {
            fArr[0] = fArr[0] + columnWidth[i13];
            fArr[1] = fArr[1] + columnWidth[(columnCount - i13) - 1];
        }
        float f11 = i12 * gutter;
        fArr[0] = fArr[0] + f11;
        fArr[1] = fArr[1] + f11;
    }

    public static float calculateWidth(ResponsiveUIModel responsiveUIModel, int i10, int i11, boolean z10) {
        float width = responsiveUIModel.width((responsiveUIModel.columnCount() - i10) / 2, (i10 + r0) - 1);
        if (DEBUG) {
            Log.d(TAG, "calculateWidth: width = " + width);
        }
        if (!z10) {
            i11 = 0;
        }
        return width + (i11 * 2);
    }

    public static int getChildLayerDefaultTypeMargin(Context context, int i10) {
        int i11;
        if (isLargeScreen(context, i10)) {
            i11 = 40;
        } else {
            i11 = 24;
        }
        return (int) (i11 * context.getResources().getDisplayMetrics().density);
    }

    public static int getScreenPhysicalHeight(Activity activity) {
        return activity.getWindowManager().getMaximumWindowMetrics().getBounds().height();
    }

    public static int getScreenPhysicalWidth(Activity activity) {
        return activity.getWindowManager().getMaximumWindowMetrics().getBounds().width();
    }

    @Deprecated
    public static boolean isActivityEmbedded(Context context) {
        return false;
    }

    public static boolean isLargePadWindow(Context context, int i10, int i11) {
        if (sCouiFoldType == -1) {
            sCouiFoldType = AppFeatureUtil.isFoldDisplayFeature(context) ? 1 : 0;
        }
        boolean isLargeScreenDp = isLargeScreenDp(i10, i11);
        boolean isLargeScreenDp2 = isLargeScreenDp(i11, i10);
        if ((isLargeScreenDp || isLargeScreenDp2) && sCouiFoldType != 1) {
            return true;
        }
        return false;
    }

    public static boolean isLargeScreen(Context context, int i10) {
        if (WindowWidthSizeClass.Companion.fromWidth(context, i10) == WindowWidthSizeClass.Expanded) {
            return true;
        }
        return false;
    }

    public static boolean isLargeScreenDp(int i10) {
        return WindowWidthSizeClass.Companion.fromWidth(new Dp((float) i10)) == WindowWidthSizeClass.Expanded;
    }

    public static boolean isMediumScreen(Context context, int i10) {
        if (WindowWidthSizeClass.Companion.fromWidth(context, i10) == WindowWidthSizeClass.Medium) {
            return true;
        }
        return false;
    }

    public static boolean isMediumScreenDp(int i10) {
        return WindowWidthSizeClass.Companion.fromWidth(new Dp((float) i10)) == WindowWidthSizeClass.Medium;
    }

    public static boolean isSmallScreen(Context context, int i10) {
        if (WindowWidthSizeClass.Companion.fromWidth(context, i10) == WindowWidthSizeClass.Compact) {
            return true;
        }
        return false;
    }

    public static boolean isSmallScreenDp(int i10) {
        return WindowWidthSizeClass.Companion.fromWidth(new Dp((float) i10)) == WindowWidthSizeClass.Compact;
    }

    public static void measureChildWithPercent(Context context, View view, int i10, int i11, int i12, int i13, int i14) {
        if (i13 != 0) {
            if (i14 == 0) {
                int size = (View.MeasureSpec.getSize(i10) - ((int) calculateWidth(View.MeasureSpec.getSize(i10), i13, i11, i12, context))) / 2;
                if (view.getPaddingLeft() != size || view.getPaddingRight() != size) {
                    view.setPaddingRelative(size, view.getPaddingTop(), size, view.getPaddingBottom());
                    return;
                }
                return;
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.width = (int) calculateWidth(View.MeasureSpec.getSize(i10), i13, i11, i12, context);
            view.setLayoutParams(layoutParams);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:89:0x02ff, code lost:
    
        if (r17.getPaddingRight() != r5[1]) goto L113;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0325 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x02da  */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int measureLayout(android.view.View r17, int r18, int r19, int r20, int r21, int r22, int r23, int r24, int r25, boolean r26, boolean r27) {
        /*
            Method dump skipped, instructions count: 840
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.grid.COUIResponsiveUtils.measureLayout(android.view.View, int, int, int, int, int, int, int, int, boolean, boolean):int");
    }

    public static void setDebug(boolean z10) {
        DEBUG = z10;
    }

    public static boolean isLargeScreenDp(int i10, int i11) {
        return WindowTotalSizeClass.Companion.fromWidthAndHeight(new Dp((float) i10), new Dp((float) i11)) == WindowTotalSizeClass.Expanded;
    }

    @Deprecated
    public static boolean isMediumScreenDp(Context context, int i10) {
        float f10 = i10;
        return WindowSizeClass.Companion.calculateFromSize(new Dp(f10), new Dp(f10)).getWindowWidthSizeClass() == WindowWidthSizeClass.Medium;
    }

    @Deprecated
    public static boolean isSmallScreenDp(Context context, int i10) {
        float f10 = i10;
        return WindowSizeClass.Companion.calculateFromSize(new Dp(f10), new Dp(f10)).getWindowWidthSizeClass() == WindowWidthSizeClass.Compact;
    }

    @Deprecated
    public static boolean isLargeScreenDp(Context context, int i10) {
        float f10 = i10;
        return WindowSizeClass.Companion.calculateFromSize(new Dp(f10), new Dp(f10)).getWindowWidthSizeClass() == WindowWidthSizeClass.Expanded;
    }

    @Deprecated
    public static float calculateWidth(float f10, int i10, int i11, int i12, Context context) {
        return calculateWidth(f10, context instanceof Activity ? getScreenPhysicalHeight((Activity) context) : 0, i10, i11, i12, context);
    }

    public static float calculateWidth(float f10, float f11, int i10, int i11, int i12, Context context) {
        int i13;
        MarginType marginType = i12 == 1 ? MarginType.MARGIN_SMALL : MarginType.MARGIN_LARGE;
        boolean z10 = i11 == 1 || i11 == 2;
        ResponsiveUIModel chooseMargin = new ResponsiveUIModel(context, (int) f10, (int) f11).chooseMargin(marginType);
        int margin = chooseMargin.margin();
        int columnCount = chooseMargin.columnCount();
        if (DEBUG) {
            Log.d(TAG, "calculateWidth: responsiveUIProxy.columnCount() = " + chooseMargin.columnCount() + " gridNumber = " + i10 + "\nscreenSize = " + f10);
        }
        int min = Math.min(i10, columnCount);
        float calculateGridWidth = chooseMargin.calculateGridWidth(min);
        if (DEBUG) {
            Log.d(TAG, "calculateWidth = " + calculateGridWidth + " gridNumber = " + min + " getColumnsCount = " + chooseMargin.columnCount() + " width = " + calculateGridWidth + " margin = " + margin + " screenWidth = " + f10 + "\n columnWidth = " + Arrays.toString(chooseMargin.columnWidth()) + "\n typeFlag = " + i11 + "isAddPadding = " + z10);
        }
        if (!z10) {
            i13 = 0;
        } else if (i11 == 1) {
            i13 = context.getResources().getDimensionPixelOffset(f.f4488D5);
        } else {
            i13 = context.getResources().getDimensionPixelOffset(f.f4842z5);
        }
        return calculateGridWidth + ((z10 ? i13 : 0) * 2);
    }

    @Deprecated
    public static int measureLayout(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, boolean z10, boolean z11) {
        return measureLayout(view, i10, i12, i13, i14, i15, i16, i17, i18, z10, z11);
    }
}
