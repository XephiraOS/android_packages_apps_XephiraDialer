package com.coui.appcompat.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import android.widget.TextView;
import androidx.preference.CheckBoxPreference;
import androidx.recyclerview.widget.COUIRecyclerView;
import b9.C0532b;
import b9.C0535e;
import b9.C0537g;
import b9.k;
import b9.l;
import com.coui.appcompat.cardlist.COUICardListHelper;
import com.coui.appcompat.cardlist.COUICardListSelectedItemLayout;

/* loaded from: classes.dex */
public class COUIMarkPreference extends CheckBoxPreference implements COUICardSupportInterface, COUIRecyclerView.b {
    public static final int CIRCLE = 0;
    static final int DEFAULT_RADIUS = 14;
    public static final int HEAD_MARK = 1;
    public static final int ROUND = 1;
    public static final int TAIL_MARK = 0;
    private CharSequence mAssignment;
    private int mAssignmentColor;
    private int mDividerDefaultHorizontalPadding;
    private boolean mHasBorder;
    private int mIconStyle;
    private boolean mIsCustom;
    private boolean mIsEnableClickSpan;
    private boolean mIsSupportCardUse;
    private View mItemView;
    int mMarkStyle;
    private int mRadius;
    private boolean mShowDivider;
    private TextView mTitleView;

    public COUIMarkPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.mMarkStyle = 0;
        this.mShowDivider = true;
        this.mAssignmentColor = 0;
        this.mIsCustom = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.f12586U, i10, i11);
        this.mMarkStyle = obtainStyledAttributes.getInt(l.f12590W, 0);
        this.mAssignment = obtainStyledAttributes.getText(l.f12588V);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, l.f12614f0, i10, i11);
        this.mShowDivider = obtainStyledAttributes2.getBoolean(l.f12650r0, this.mShowDivider);
        this.mIsEnableClickSpan = obtainStyledAttributes2.getBoolean(l.f12635m0, false);
        this.mIsSupportCardUse = obtainStyledAttributes2.getBoolean(l.f12546C0, true);
        this.mIconStyle = obtainStyledAttributes2.getInt(l.f12638n0, 1);
        this.mHasBorder = obtainStyledAttributes2.getBoolean(l.f12674z0, false);
        this.mRadius = obtainStyledAttributes2.getDimensionPixelSize(l.f12549D0, 14);
        this.mAssignmentColor = obtainStyledAttributes2.getInt(l.f12623i0, 0);
        obtainStyledAttributes2.recycle();
        this.mDividerDefaultHorizontalPadding = getContext().getResources().getDimensionPixelSize(C0535e.f12370B);
        setChecked(true);
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

    public int getBorderRectRadius(int i10) {
        if (i10 == 1 || i10 == 2 || i10 != 3) {
            return 14;
        }
        return 16;
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public View getDividerEndAlignView() {
        return null;
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

    public int getMarkStyle() {
        return this.mMarkStyle;
    }

    @Override // com.coui.appcompat.preference.COUICardSupportInterface
    public boolean isSupportCardUse() {
        return this.mIsSupportCardUse;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.preference.CheckBoxPreference, androidx.preference.Preference
    public void onBindViewHolder(androidx.preference.l lVar) {
        super.onBindViewHolder(lVar);
        this.mItemView = lVar.itemView;
        View e10 = lVar.e(C0537g.f12490s);
        if (e10 != 0 && (e10 instanceof Checkable)) {
            if (this.mMarkStyle == 0) {
                e10.setVisibility(0);
                ((Checkable) e10).setChecked(isChecked());
            } else {
                e10.setVisibility(8);
            }
        }
        View e11 = lVar.e(C0537g.f12482k);
        if (e11 != 0 && (e11 instanceof Checkable)) {
            if (this.mMarkStyle == 1) {
                e11.setVisibility(0);
                ((Checkable) e11).setChecked(isChecked());
            } else {
                e11.setVisibility(8);
            }
        }
        COUIPreferenceUtils.setIconStyle(lVar, getContext(), this.mRadius, this.mHasBorder, this.mIconStyle, this.mIsCustom);
        this.mTitleView = (TextView) lVar.e(R.id.title);
        View e12 = lVar.e(C0537g.f12496y);
        View e13 = lVar.e(R.id.icon);
        if (e12 != null) {
            if (e13 != null) {
                e12.setVisibility(e13.getVisibility());
            } else {
                e12.setVisibility(8);
            }
        }
        if (this.mIsEnableClickSpan) {
            COUIPreferenceUtils.setSummaryView(getContext(), lVar);
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

    public void setBorderRectRadius(int i10) {
        if (this.mRadius != i10) {
            this.mRadius = i10;
            notifyChanged();
        }
    }

    public void setIsCustomIconRadius(boolean z10) {
        this.mIsCustom = z10;
    }

    public void setIsEnableClickSpan(boolean z10) {
        this.mIsEnableClickSpan = z10;
    }

    @Override // com.coui.appcompat.preference.COUICardSupportInterface
    public void setIsSupportCardUse(boolean z10) {
        this.mIsSupportCardUse = z10;
    }

    public void setMarkStyle(int i10) {
        this.mMarkStyle = i10;
    }

    public COUIMarkPreference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, k.f12530h);
    }

    public COUIMarkPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0532b.f12349h);
    }

    public COUIMarkPreference(Context context) {
        this(context, null);
    }
}
