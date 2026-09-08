package com.coui.appcompat.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.preference.CheckBoxPreference;
import androidx.preference.l;
import androidx.recyclerview.widget.COUIRecyclerView;
import b9.C0532b;
import b9.C0535e;
import b9.C0537g;
import b9.k;
import com.coui.appcompat.cardlist.COUICardListHelper;
import com.coui.appcompat.cardlist.COUICardListSelectedItemLayout;
import com.coui.appcompat.checkbox.COUICheckBox;

/* loaded from: classes.dex */
public class COUICheckBoxWithDividerPreference extends CheckBoxPreference implements COUICardSupportInterface, COUIRecyclerView.b {
    private CharSequence mAssignment;
    private int mAssignmentColor;
    private LinearLayout mCheckBoxLayout;
    private OnMainLayoutClickListener mClickListener;
    private int mDividerDefaultHorizontalPadding;
    private boolean mIsSupportCardUse;
    private View mItemView;
    private LinearLayout mMainLayout;
    private TextView mTitleView;

    /* loaded from: classes.dex */
    public interface OnMainLayoutClickListener {
        void onMainLayoutClick();
    }

    public COUICheckBoxWithDividerPreference(Context context) {
        this(context, null);
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public boolean drawDivider() {
        if (!(this.mItemView instanceof COUICardListSelectedItemLayout)) {
            return false;
        }
        int positionInGroup = COUICardListHelper.getPositionInGroup(this);
        if (positionInGroup != 1 && positionInGroup != 2) {
            return false;
        }
        return true;
    }

    public CharSequence getAssignment() {
        return this.mAssignment;
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public /* bridge */ /* synthetic */ View getDividerEndAlignView() {
        return super.getDividerEndAlignView();
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public int getDividerEndInset() {
        return this.mDividerDefaultHorizontalPadding;
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public View getDividerStartAlignView() {
        return this.mTitleView;
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public int getDividerStartInset() {
        return this.mDividerDefaultHorizontalPadding;
    }

    public OnMainLayoutClickListener getOnMainLayoutClickListener() {
        return this.mClickListener;
    }

    @Override // com.coui.appcompat.preference.COUICardSupportInterface
    public boolean isSupportCardUse() {
        return this.mIsSupportCardUse;
    }

    @Override // androidx.preference.CheckBoxPreference, androidx.preference.Preference
    public void onBindViewHolder(l lVar) {
        int i10;
        super.onBindViewHolder(lVar);
        this.mItemView = lVar.itemView;
        View e10 = lVar.e(R.id.checkbox);
        View e11 = lVar.e(R.id.icon);
        View e12 = lVar.e(C0537g.f12496y);
        if (e12 != null) {
            if (e11 != null) {
                e12.setVisibility(e11.getVisibility());
            } else {
                e12.setVisibility(8);
            }
        }
        if (e10 != null && (e10 instanceof COUICheckBox)) {
            COUICheckBox cOUICheckBox = (COUICheckBox) e10;
            if (isChecked()) {
                i10 = 2;
            } else {
                i10 = 0;
            }
            cOUICheckBox.setState(i10);
        }
        this.mTitleView = (TextView) lVar.e(R.id.title);
        LinearLayout linearLayout = (LinearLayout) lVar.itemView.findViewById(C0537g.f12454C);
        this.mMainLayout = linearLayout;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.preference.COUICheckBoxWithDividerPreference.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (COUICheckBoxWithDividerPreference.this.mClickListener != null) {
                        COUICheckBoxWithDividerPreference.this.mClickListener.onMainLayoutClick();
                    }
                }
            });
            this.mMainLayout.setClickable(isSelectable());
        }
        LinearLayout linearLayout2 = (LinearLayout) lVar.itemView.findViewById(C0537g.f12478g);
        this.mCheckBoxLayout = linearLayout2;
        if (linearLayout2 != null) {
            linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.preference.COUICheckBoxWithDividerPreference.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    COUICheckBoxWithDividerPreference.super.onClick();
                }
            });
            this.mCheckBoxLayout.setClickable(isSelectable());
        }
        COUIPreferenceUtils.bindAssignmentView(lVar, this.mAssignment, this.mAssignmentColor);
        COUICardListHelper.setItemCardBackground(lVar.itemView, COUICardListHelper.getPositionInGroup(this));
    }

    public void setAssignment(CharSequence charSequence) {
        if (!TextUtils.equals(this.mAssignment, charSequence)) {
            this.mAssignment = charSequence;
            notifyChanged();
        }
    }

    public void setAssignmentColor(int i10) {
        if (this.mAssignmentColor != i10) {
            this.mAssignmentColor = i10;
            notifyChanged();
        }
    }

    @Override // com.coui.appcompat.preference.COUICardSupportInterface
    public void setIsSupportCardUse(boolean z10) {
        this.mIsSupportCardUse = z10;
    }

    public void setOnMainLayoutListener(OnMainLayoutClickListener onMainLayoutClickListener) {
        this.mClickListener = onMainLayoutClickListener;
    }

    public COUICheckBoxWithDividerPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0532b.f12345d);
    }

    public COUICheckBoxWithDividerPreference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, k.f12526d);
    }

    public COUICheckBoxWithDividerPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.mAssignmentColor = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b9.l.f12655t, i10, i11);
        this.mAssignment = obtainStyledAttributes.getText(b9.l.f12658u);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, b9.l.f12614f0, i10, i11);
        this.mIsSupportCardUse = obtainStyledAttributes2.getBoolean(b9.l.f12546C0, true);
        this.mAssignmentColor = obtainStyledAttributes.getInt(b9.l.f12623i0, 0);
        obtainStyledAttributes2.recycle();
        this.mDividerDefaultHorizontalPadding = getContext().getResources().getDimensionPixelSize(C0535e.f12370B);
    }
}
