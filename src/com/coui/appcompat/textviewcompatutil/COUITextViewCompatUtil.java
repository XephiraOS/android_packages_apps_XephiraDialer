package com.coui.appcompat.textviewcompatutil;

import X8.f;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import com.coui.appcompat.state.COUIMaskRippleDrawable;
import com.coui.appcompat.textutil.COUIChangeTextUtil;
import com.coui.appcompat.version.COUICompatUtil;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public class COUITextViewCompatUtil {
    private static final String TAG = "COUITextViewCompatUtil";
    private static final String TEXT_VIEW_WRAPPER = "android.view.OplusBaseView";
    private static String mTextViewCompatName;

    private static boolean canReachFrameworkWrapper() {
        try {
            Class.forName(TEXT_VIEW_WRAPPER);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static float getParaSpacing(TextView textView) {
        String baseViewName;
        if (canReachFrameworkWrapper()) {
            baseViewName = TEXT_VIEW_WRAPPER;
        } else {
            baseViewName = COUICompatUtil.getInstance().getBaseViewName();
        }
        mTextViewCompatName = baseViewName;
        try {
            return reflectGetParaSpacing(textView);
        } catch (Exception e10) {
            Log.e(TAG, e10.getMessage(), e10);
            return 0.0f;
        }
    }

    private static float reflectGetParaSpacing(TextView textView) {
        Method declaredMethod = Class.forName(mTextViewCompatName).getDeclaredMethod("getParaSpacing", null);
        declaredMethod.setAccessible(true);
        return ((Float) declaredMethod.invoke(textView, null)).floatValue();
    }

    private static void reflectSetParaSpacing(TextView textView, float f10) {
        Method declaredMethod = Class.forName(mTextViewCompatName).getDeclaredMethod("setParaSpacing", Float.TYPE);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(textView, Float.valueOf(f10));
    }

    public static void setButtonTextView(TextView textView) {
        setPressRippleDrawable(textView);
        COUIChangeTextUtil.adaptFontSize(textView, 4);
    }

    public static boolean setParaSpacing(TextView textView, float f10) {
        String baseViewName;
        if (canReachFrameworkWrapper()) {
            baseViewName = TEXT_VIEW_WRAPPER;
        } else {
            baseViewName = COUICompatUtil.getInstance().getBaseViewName();
        }
        mTextViewCompatName = baseViewName;
        try {
            reflectSetParaSpacing(textView, f10);
            return true;
        } catch (Exception e10) {
            Log.e(TAG, e10.getMessage(), e10);
            return false;
        }
    }

    public static void setPressRippleDrawable(TextView textView) {
        setPressRippleDrawable(textView, false);
    }

    public static void setPressRippleDrawable(View view, boolean z10) {
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, -2);
        } else {
            layoutParams.width = -2;
            layoutParams.height = -2;
        }
        view.setLayoutParams(layoutParams);
        if (!z10) {
            int dimensionPixelOffset = view.getContext().getResources().getDimensionPixelOffset(f.f4579Q5);
            int dimensionPixelOffset2 = view.getContext().getResources().getDimensionPixelOffset(f.f4572P5);
            view.setPadding(dimensionPixelOffset2, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset);
        }
        COUIMaskRippleDrawable cOUIMaskRippleDrawable = new COUIMaskRippleDrawable(view.getContext());
        cOUIMaskRippleDrawable.setCustomRippleMask();
        view.setBackground(cOUIMaskRippleDrawable);
        COUIDarkModeUtil.setForceDarkAllow(view, false);
    }
}
