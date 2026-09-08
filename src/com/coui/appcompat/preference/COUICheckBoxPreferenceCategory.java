package com.coui.appcompat.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import b9.C0539i;
import b9.l;
import com.coui.appcompat.checkbox.COUICheckBox;

/* loaded from: classes.dex */
public class COUICheckBoxPreferenceCategory extends COUIPreferenceCategory {
    private static final String TAG = "CheckBoxCategory";
    private int mDefaultCheckboxState;
    private COUICheckBox.OnStateChangeListener mOnStateChangeListener;

    public COUICheckBoxPreferenceCategory(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDefaultCheckboxState = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.f12661v, 0, 0);
        this.mDefaultCheckboxState = obtainStyledAttributes.getInteger(l.f12664w, this.mDefaultCheckboxState);
        obtainStyledAttributes.recycle();
    }

    @Override // com.coui.appcompat.preference.COUIPreferenceCategory, androidx.preference.PreferenceCategory, androidx.preference.Preference
    public void onBindViewHolder(androidx.preference.l lVar) {
        setWidgetLayoutRes(C0539i.f12504f);
        super.onBindViewHolder(lVar);
        COUICheckBox cOUICheckBox = (COUICheckBox) getWidgetLayout().findViewById(R.id.checkbox);
        if (cOUICheckBox != null) {
            int i10 = this.mDefaultCheckboxState;
            if (i10 != 0) {
                cOUICheckBox.setState(i10);
            }
            COUICheckBox.OnStateChangeListener onStateChangeListener = this.mOnStateChangeListener;
            if (onStateChangeListener != null) {
                cOUICheckBox.setOnStateChangeListener(onStateChangeListener);
            }
            cOUICheckBox.setVisibility(0);
        }
    }

    public void setOnStateChangeListener(COUICheckBox.OnStateChangeListener onStateChangeListener) {
        this.mOnStateChangeListener = onStateChangeListener;
    }

    @Override // com.coui.appcompat.preference.COUIPreferenceCategory
    public void setWidgetLayoutClickListener(View.OnClickListener onClickListener) {
        Log.e(TAG, "set Widget Layout Click Listener does not take effect in the COUICheckBoxPreferenceCategory setting, please set setOnStateChangeListener");
    }
}
