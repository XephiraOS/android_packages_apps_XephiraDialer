package com.coui.appcompat.rippleutil;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.view.View;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import com.coui.appcompat.state.COUIMaskRippleDrawable;
import com.coui.appcompat.state.COUIStateEffectDrawable;

/* loaded from: classes.dex */
public class COUIRippleDrawableUtil {
    public static Drawable getRippleDrawable(Context context, int i10, int i11) {
        return context.getDrawable(i10);
    }

    public static void setIconPressRippleDrawable(View view, int i10) {
        if (view == null) {
            return;
        }
        COUIMaskRippleDrawable cOUIMaskRippleDrawable = new COUIMaskRippleDrawable(view.getContext());
        cOUIMaskRippleDrawable.setCircleRippleMask(i10);
        view.setBackground(new COUIStateEffectDrawable(new Drawable[]{cOUIMaskRippleDrawable}));
        COUIDarkModeUtil.setForceDarkAllow(view, false);
    }

    public static void setPressRippleDrawable(View view, int i10) {
        if (view == null) {
            return;
        }
        view.setBackground(new COUIPressRippleDrawable(view.getContext(), i10));
    }

    public static void setRadiusAdaptation(RippleDrawable rippleDrawable, int i10) {
        rippleDrawable.setRadius(i10);
    }

    public static void setPressRippleDrawable(View view, int i10, boolean z10) {
        if (view == null) {
            return;
        }
        view.setBackground(new COUIPressRippleDrawable(view.getContext(), i10, z10));
    }
}
