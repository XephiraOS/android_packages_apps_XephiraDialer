package com.coui.appcompat.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.preference.Preference;
import b9.C0535e;
import b9.C0539i;
import b9.l;

/* loaded from: classes.dex */
public class COUIPagerFooterPreference extends Preference {
    private boolean mWithExtraMarginBottom;

    public COUIPagerFooterPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mWithExtraMarginBottom = true;
        setLayoutResource(C0539i.f12499a);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.f12608d0, 0, 0);
        this.mWithExtraMarginBottom = obtainStyledAttributes.getBoolean(l.f12611e0, this.mWithExtraMarginBottom);
        obtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(androidx.preference.l lVar) {
        super.onBindViewHolder(lVar);
        if (lVar.itemView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) lVar.itemView.getLayoutParams();
            if (this.mWithExtraMarginBottom) {
                marginLayoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(C0535e.f12440w0);
            } else {
                marginLayoutParams.bottomMargin = 0;
            }
            lVar.itemView.setLayoutParams(marginLayoutParams);
        }
    }
}
