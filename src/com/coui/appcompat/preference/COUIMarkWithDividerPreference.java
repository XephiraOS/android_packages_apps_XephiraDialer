package com.coui.appcompat.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.preference.l;
import b9.C0532b;
import b9.C0537g;
import b9.k;

/* loaded from: classes.dex */
public class COUIMarkWithDividerPreference extends COUIMarkPreference {
    private OnMainLayoutClickListener mClickListener;
    private LinearLayout mMainLayout;
    private LinearLayout mRadioLayout;

    /* loaded from: classes.dex */
    public interface OnMainLayoutClickListener {
        void onMainLayoutClick();
    }

    public COUIMarkWithDividerPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
    }

    public OnMainLayoutClickListener getOnMainLayoutClickListener() {
        return this.mClickListener;
    }

    @Override // com.coui.appcompat.preference.COUIMarkPreference, androidx.preference.CheckBoxPreference, androidx.preference.Preference
    public void onBindViewHolder(l lVar) {
        super.onBindViewHolder(lVar);
        LinearLayout linearLayout = (LinearLayout) lVar.itemView.findViewById(C0537g.f12454C);
        this.mMainLayout = linearLayout;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.preference.COUIMarkWithDividerPreference.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (COUIMarkWithDividerPreference.this.mClickListener != null) {
                        COUIMarkWithDividerPreference.this.mClickListener.onMainLayoutClick();
                    }
                }
            });
            this.mMainLayout.setClickable(isSelectable());
        }
        LinearLayout linearLayout2 = (LinearLayout) lVar.itemView.findViewById(C0537g.f12456E);
        this.mRadioLayout = linearLayout2;
        if (linearLayout2 != null) {
            linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.preference.COUIMarkWithDividerPreference.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    COUIMarkWithDividerPreference.super.onClick();
                }
            });
            this.mRadioLayout.setClickable(isSelectable());
        }
    }

    public void setOnMainLayoutListener(OnMainLayoutClickListener onMainLayoutClickListener) {
        this.mClickListener = onMainLayoutClickListener;
    }

    public COUIMarkWithDividerPreference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, k.f12531i);
    }

    public COUIMarkWithDividerPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0532b.f12351j);
    }

    public COUIMarkWithDividerPreference(Context context) {
        this(context, null);
    }
}
