package com.coui.appcompat.contextutil;

import B.a;
import X8.c;
import X8.n;
import X8.o;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import com.coui.appcompat.log.COUILog;

/* loaded from: classes.dex */
public class COUIContextUtil {
    private static final String METADATA_STYLE_TITLE = "coui.appcompat.options";
    private static final String METADATA_STYLE_VALUE = "true";
    private static final String TAG = "COUIContextUtil";
    private Context mContext;

    public COUIContextUtil(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public static int getAttrColor(Context context, int i10) {
        if (i10 != c.f4408u && i10 != c.f4396o) {
            if (i10 == c.f4410v) {
                return makeColorAlpha(getAttrColor(context, i10, 0), getAttrColor(context, c.f4343B, 0));
            }
            return getAttrColor(context, i10, 0);
        }
        return makeColorAlpha(getAttrColor(context, i10, 0), getAttrColor(context, c.f4392m, 0));
    }

    public static int getAttrDimens(Context context, int i10) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i10});
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
        return dimensionPixelSize;
    }

    public static float getAttrFloat(Context context, int i10) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i10});
        float f10 = obtainStyledAttributes.getFloat(0, 0.0f);
        obtainStyledAttributes.recycle();
        return f10;
    }

    public static int getAttrId(Context context, int i10, int i11) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i10});
        int resourceId = obtainStyledAttributes.getResourceId(0, i11);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    public static String getAttrString(Context context, int i10) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i10});
        String string = obtainStyledAttributes.getString(0);
        obtainStyledAttributes.recycle();
        return string;
    }

    public static Context getCOUIThemeContext(Context context) {
        if (!isCOUITheme(context)) {
            return new ContextThemeWrapper(context, n.f5041m);
        }
        return context;
    }

    public static int getColor(Context context, int i10) {
        return context.getColor(i10);
    }

    public static float getFloat(Context context, int i10) {
        TypedValue typedValue = new TypedValue();
        try {
            context.getResources().getValue(i10, typedValue, true);
            return typedValue.getFloat();
        } catch (Resources.NotFoundException | NumberFormatException e10) {
            Log.e(TAG, "getFloat: failed error=" + e10);
            return 0.0f;
        }
    }

    public static int getResId(Context context, int i10) {
        TypedValue typedValue = new TypedValue();
        context.getResources().getValue(i10, typedValue, true);
        return typedValue.resourceId;
    }

    public static boolean isCOUIDarkTheme(Context context) {
        if (context == null) {
            return false;
        }
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(o.f5372n6);
        boolean z10 = obtainStyledAttributes.getBoolean(o.f5380o6, false);
        obtainStyledAttributes.recycle();
        return z10;
    }

    public static boolean isCOUIStyle(Context context) {
        Bundle bundle;
        try {
            if ((context instanceof Activity) && (bundle = context.getPackageManager().getActivityInfo(((Activity) context).getComponentName(), 128).metaData) != null) {
                if (METADATA_STYLE_VALUE.equals(bundle.getString(METADATA_STYLE_TITLE))) {
                    return true;
                }
            }
        } catch (Exception e10) {
            COUILog.e(TAG, e10.toString());
        }
        return isCOUITheme(context);
    }

    private static int makeColorAlpha(int i10, int i11) {
        return a.w(i11, Color.alpha(i10));
    }

    public boolean isCOUITheme() {
        return isCOUITheme(this.mContext);
    }

    public void setContext(Context context) {
        if (context != null) {
            this.mContext = context;
        }
    }

    public static boolean isCOUITheme(Context context) {
        if (context == null) {
            return false;
        }
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(o.f5372n6);
        boolean z10 = obtainStyledAttributes.getBoolean(o.f5388p6, false);
        obtainStyledAttributes.recycle();
        return z10;
    }

    public static int getAttrColor(Context context, int i10, int i11) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i10});
        int color = obtainStyledAttributes.getColor(0, i11);
        obtainStyledAttributes.recycle();
        return color;
    }
}
