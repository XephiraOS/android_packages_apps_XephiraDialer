package com.coui.appcompat.view;

import android.R;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.coui.component.responsiveui.layoutgrid.MarginType;

/* loaded from: classes3.dex */
public class COUIGridMaskUtils {
    private static final String TAG = "COUIGridMaskUtils";

    public static void injectMask(Activity activity, MarginType marginType) {
        if (isMaskAlreadyExist(activity)) {
            return;
        }
        COUIResponsiveGridMaskView cOUIResponsiveGridMaskView = new COUIResponsiveGridMaskView(activity);
        cOUIResponsiveGridMaskView.setMarginType(marginType);
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(R.id.content);
        if (viewGroup != null) {
            viewGroup.addView(cOUIResponsiveGridMaskView);
        }
    }

    public static boolean isMaskAlreadyExist(Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(R.id.content);
        if (viewGroup != null) {
            for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                if (viewGroup.getChildAt(i10) instanceof COUIResponsiveGridMaskView) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void removeMask(Activity activity) {
        if (!isMaskAlreadyExist(activity)) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(R.id.content);
        if (viewGroup == null) {
            Log.w(TAG, "removeMask: content is null!");
            return;
        }
        View view = null;
        for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
            if (viewGroup.getChildAt(i10) instanceof COUIResponsiveGridMaskView) {
                view = viewGroup.getChildAt(i10);
            }
        }
        viewGroup.removeView(view);
    }

    public static void injectMask(Activity activity) {
        injectMask(activity, MarginType.MARGIN_LARGE);
    }
}
