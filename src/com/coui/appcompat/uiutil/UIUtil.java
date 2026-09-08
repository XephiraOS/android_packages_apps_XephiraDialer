package com.coui.appcompat.uiutil;

import X8.f;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import com.coui.appcompat.log.COUILog;
import java.util.List;

/* loaded from: classes3.dex */
public class UIUtil {
    public static final int ANIM_LEVEL_HIGN_END = 1;
    public static final int ANIM_LEVEL_LOW_END = 3;
    public static final int ANIM_LEVEL_MID_END = 2;
    public static final int ANIM_LEVEL_ULTRA_LOW_END = 4;
    public static final int CONSTANT_COLOR_MASK = 16777215;
    public static final int CONSTANT_INT_EIGHT = 8;
    public static final int CONSTANT_INT_EIGHTEEN = 18;
    public static final int CONSTANT_INT_ELEVEN = 11;
    public static final int CONSTANT_INT_FIFTEEN = 15;
    public static final int CONSTANT_INT_FIVE = 5;
    public static final int CONSTANT_INT_FORE = 4;
    public static final int CONSTANT_INT_FOURTEEN = 14;
    public static final int CONSTANT_INT_NINE = 9;
    public static final int CONSTANT_INT_NINETY = 90;
    public static final int CONSTANT_INT_ONE_HUNDRED = 100;
    public static final int CONSTANT_INT_ONE_HUNDRED_TEENTY = 120;
    public static final int CONSTANT_INT_ONE_THOUSAND = 1000;
    public static final int CONSTANT_INT_SEVEN = 7;
    public static final int CONSTANT_INT_SIX = 6;
    public static final int CONSTANT_INT_SIXTEEN = 16;
    public static final int CONSTANT_INT_SIXTY = 60;
    public static final int CONSTANT_INT_TEN = 10;
    public static final int CONSTANT_INT_THIRTEEN = 13;
    public static final int CONSTANT_INT_THIRTY = 30;
    public static final int CONSTANT_INT_THREE = 3;
    public static final int CONSTANT_INT_THREE_HUNDRED = 300;
    public static final int CONSTANT_INT_THTEE_HUNDRED_THIRTY = 330;
    public static final int CONSTANT_INT_TWELVE = 12;
    public static final int CONSTANT_INT_TWO_HUNDRED_SEVENTY = 270;
    public static final boolean DEBUG = false;
    public static final int DIRECTION_BOTTOM = 3;
    public static final int DIRECTION_END = 4;
    public static final int DIRECTION_LEFT = 0;
    public static final int DIRECTION_RIGHT = 2;
    public static final int DIRECTION_START = 5;
    public static final int DIRECTION_TOP = 1;
    public static final int INT_TWENTY_FOUR = 24;
    public static final int LARGE_WIDTH_DP = 840;
    public static final int MEDIUM_WIDTH_DP = 600;
    private static final String TAG = "UIUtil";
    public static final int TWO_FIVE_FIVE = 255;
    private static SparseArray<String> sStringMap;
    public static final AnimLevel ANIM_LEVEL_SUPPORT_BLUR_MIN = AnimLevel.MID_END;
    private static int sCurrentAnimLevel = -1;

    public static int alphaColor(int i10, float f10) {
        return (i10 & CONSTANT_COLOR_MASK) | (((int) (f10 * 255.0f)) << 24);
    }

    public static float[] colorToFloats(int i10) {
        return new float[]{((i10 >> 16) & 255) / 255.0f, ((i10 >> 8) & 255) / 255.0f, (i10 & 255) / 255.0f, ((i10 >> 24) & 255) / 255.0f};
    }

    public static boolean confirmLevelAnim(AnimLevel animLevel) {
        if (sCurrentAnimLevel == -1) {
            sCurrentAnimLevel = getAnimLevelVersion();
        }
        if (sCurrentAnimLevel > animLevel.getIntValue()) {
            return false;
        }
        return true;
    }

    public static Activity contextToActivity(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    public static int dip2px(Context context, float f10) {
        return Math.round(f10 * context.getResources().getDisplayMetrics().density);
    }

    public static int getAdjustmentPointerIndex(MotionEvent motionEvent, int i10) {
        return Math.min(Math.max(0, i10), motionEvent.getPointerCount() - 1);
    }

    public static int getAnimLevelVersion() {
        try {
            String str = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, "persist.sys.oplus.anim_level");
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            return Integer.parseInt(str.trim());
        } catch (Exception e10) {
            COUILog.e(TAG, "getAnimLevelVersion e: " + e10);
            return -1;
        }
    }

    public static ColorStateList getColorStateListCompatNoCache(Context context, int i10) {
        return context.getResources().getColorStateList(i10, context.getTheme());
    }

    public static final float getConvertedFraction(float f10, float f11, float f12) {
        return f10 + ((f11 - f10) * f12);
    }

    public static String getPrice(double d10) {
        return removeZero(d10 + "");
    }

    public static int getPx(Context context, int i10) {
        return context.getResources().getDimensionPixelSize(i10);
    }

    public static int getScreenHeightMetrics(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int getScreenHeightRealSize(Context context) {
        return getScreenSize(context).y;
    }

    public static Point getScreenSize(Context context) {
        WindowManager windowManager;
        Display defaultDisplay;
        Point point = new Point();
        if (context != null && (windowManager = (WindowManager) context.getSystemService("window")) != null && (defaultDisplay = windowManager.getDefaultDisplay()) != null) {
            defaultDisplay.getRealSize(point);
        }
        return point;
    }

    public static int getScreenWidthMetrics(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int getScreenWidthRealSize(Context context) {
        return getScreenSize(context).x;
    }

    public static int getStatusBarHeight(Context context) {
        int identifier = context.getApplicationContext().getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            try {
                return context.getApplicationContext().getResources().getDimensionPixelSize(identifier);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        return -1;
    }

    public static String getString(Context context, int i10) {
        if (sStringMap == null) {
            sStringMap = new SparseArray<>();
        }
        String str = sStringMap.get(i10);
        if (str == null) {
            String string = context.getString(i10);
            sStringMap.put(i10, string);
            return string;
        }
        return str;
    }

    public static void initEditViewCursor(TextView textView, int i10) {
        if (textView == null) {
            return;
        }
        CharSequence text = textView.getText();
        if (text instanceof Spannable) {
            Spannable spannable = (Spannable) text;
            if (i10 <= text.length()) {
                Selection.setSelection(spannable, i10);
                return;
            }
            try {
                throw new Exception("the cursor of EditText is indexOutOfBoundException!!!!!");
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public static boolean isInMarketStack(Context context) {
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) context.getApplicationContext().getSystemService("activity")).getRunningTasks(1);
        if (runningTasks == null || runningTasks.isEmpty()) {
            return false;
        }
        return context.getPackageName().equals(runningTasks.get(0).baseActivity.getPackageName());
    }

    public static boolean isInVisibleRect(View view) {
        boolean localVisibleRect = view.getLocalVisibleRect(new Rect());
        int visibility = view.getVisibility();
        boolean isShown = view.isShown();
        if (localVisibleRect && visibility == 0 && isShown) {
            return true;
        }
        return false;
    }

    public static boolean isLargeScreenBaseOnRealSize(Context context) {
        if (px2dip(context, getScreenWidthRealSize(context)) >= 840) {
            return true;
        }
        return false;
    }

    public static boolean isSmallScreenBaseOnRealSize(Context context) {
        if (px2dip(context, getScreenWidthRealSize(context)) < 600) {
            return true;
        }
        return false;
    }

    public static GradientDrawable makeGradientDrawable(int i10, int i11) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColors(new int[]{i10, i11});
        return gradientDrawable;
    }

    public static StateListDrawable makeSelector(Drawable drawable, Drawable drawable2) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{-16842908, -16842913, -16842919}, drawable);
        stateListDrawable.addState(new int[]{-16842908, 16842913, -16842919}, drawable2);
        stateListDrawable.addState(new int[]{16842908, -16842913, -16842919}, drawable2);
        stateListDrawable.addState(new int[]{16842908, 16842913, -16842919}, drawable2);
        stateListDrawable.addState(new int[]{16842913, 16842919}, drawable2);
        stateListDrawable.addState(new int[]{16842919}, drawable2);
        return stateListDrawable;
    }

    public static GradientDrawable makeShapeDrawable(float f10, int i10, int i11, int i12) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i12);
        if (f10 > 0.0f) {
            gradientDrawable.setCornerRadius(f10);
        }
        if (i10 > 0) {
            gradientDrawable.setStroke(i10, i11);
        }
        return gradientDrawable;
    }

    public static int px2dip(Context context, int i10) {
        return Math.round(i10 / context.getResources().getDisplayMetrics().density);
    }

    public static String removeZero(String str) {
        if (str.indexOf(".") > 0) {
            return str.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str;
    }

    public static void safeForceHasOverlappingRendering(View view, boolean z10) {
        if (view == null) {
            return;
        }
        view.forceHasOverlappingRendering(z10);
    }

    public static void safeSetOutlineAmbientShadowColor(View view, int i10) {
        if (view == null) {
            return;
        }
        view.setOutlineAmbientShadowColor(i10);
    }

    public static void safeSetOutlineSpotShadowColor(View view, int i10) {
        if (view == null) {
            return;
        }
        view.setOutlineSpotShadowColor(i10);
    }

    public static void setElevationToView(View view, int i10, int i11) {
        setElevationToView(view, i10, i11, view.getResources().getDimensionPixelOffset(f.f4530J5));
    }

    public static void setMargin(View view, int i10, int i11) {
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                if (i10 != 0) {
                    if (i10 != 1) {
                        if (i10 != 2) {
                            if (i10 != 3) {
                                if (i10 != 4) {
                                    if (i10 == 5) {
                                        ((ViewGroup.MarginLayoutParams) layoutParams).setMarginStart(i11);
                                    }
                                } else {
                                    ((ViewGroup.MarginLayoutParams) layoutParams).setMarginEnd(i11);
                                }
                            } else {
                                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = i11;
                            }
                        } else {
                            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = i11;
                        }
                    } else {
                        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = i11;
                    }
                } else {
                    ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = i11;
                }
                view.setLayoutParams(layoutParams);
            }
        }
    }

    public static void setElevationToView(View view, int i10, int i11, int i12) {
        if (view == null) {
            return;
        }
        view.setOutlineSpotShadowColor(i11);
        view.setElevation(i10);
    }

    public static StateListDrawable makeSelector(int i10, int i11) {
        return makeSelector(new ColorDrawable(i10), new ColorDrawable(i11));
    }
}
