package com.coui.appcompat.preference;

import X8.f;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.preference.SwitchPreference;
import androidx.preference.l;
import androidx.preference.m;
import androidx.recyclerview.widget.COUIRecyclerView;
import b9.C0535e;
import b9.C0537g;
import com.coui.appcompat.cardlist.COUICardListHelper;
import com.coui.appcompat.cardlist.COUICardListSelectedItemLayout;
import com.coui.appcompat.couiswitch.COUISwitch;
import com.coui.appcompat.reddot.COUIHintRedDot;

/* loaded from: classes.dex */
public class COUISwitchPreference extends SwitchPreference implements COUICardSupportInterface, COUIRecyclerView.b {
    public static final int CIRCLE = 0;
    static final int DEFAULT_RADIUS = 14;
    public static final int ROUND = 1;
    private CharSequence mAssignment;
    private int mAssignmentColor;
    private int mDividerDefaultHorizontalPadding;
    private boolean mHasBorder;
    private boolean mHasRedDot;
    private int mIconStyle;
    private boolean mIsCustom;
    private boolean mIsEnableClickSpan;
    private boolean mIsSupportCardUse;
    private View mItemView;
    private final Listener mListener;
    private int mRadius;
    private int mRedDotDiameter;
    private int mRedDotMarginStart;
    private int mSwitchBarCheckedColor;
    private COUISwitch mSwitchView;
    private CharSequence mTitle;
    private TextView mTitleView;

    /* loaded from: classes.dex */
    public class Listener implements CompoundButton.OnCheckedChangeListener {
        private Listener() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
            if (COUISwitchPreference.this.isChecked() == z10) {
                return;
            }
            if (!COUISwitchPreference.this.callCustomChangeListener(Boolean.valueOf(z10))) {
                compoundButton.setChecked(!z10);
            } else {
                COUISwitchPreference.this.setChecked(z10);
            }
        }
    }

    public COUISwitchPreference(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean callCustomChangeListener(Object obj) {
        if (getOnPreferenceChangeListener() == null) {
            return true;
        }
        return getOnPreferenceChangeListener().k0(this, obj);
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

    @Override // com.coui.appcompat.preference.COUICardSupportInterface
    public boolean isSupportCardUse() {
        return this.mIsSupportCardUse;
    }

    @Override // androidx.preference.SwitchPreference, androidx.preference.Preference
    public void onBindViewHolder(l lVar) {
        this.mItemView = lVar.itemView;
        View e10 = lVar.e(C0537g.f12485n);
        if (e10 != null) {
            e10.setSoundEffectsEnabled(false);
            e10.setHapticFeedbackEnabled(false);
        }
        View e11 = lVar.e(R.id.switch_widget);
        View e12 = lVar.e(C0537g.f12453B);
        if (e11 instanceof COUISwitch) {
            COUISwitch cOUISwitch = (COUISwitch) e11;
            cOUISwitch.setOnCheckedChangeListener(this.mListener);
            cOUISwitch.setVerticalScrollBarEnabled(false);
            this.mSwitchView = cOUISwitch;
            int i10 = this.mSwitchBarCheckedColor;
            if (i10 != -1) {
                cOUISwitch.setBarCheckedColor(i10);
            }
        }
        super.onBindViewHolder(lVar);
        if (this.mIsEnableClickSpan) {
            COUIPreferenceUtils.setSummaryView(getContext(), lVar);
        }
        COUIPreferenceUtils.setIconStyle(lVar, getContext(), this.mRadius, this.mHasBorder, this.mIconStyle, this.mIsCustom);
        View e13 = lVar.e(C0537g.f12496y);
        View findViewById = lVar.itemView.findViewById(R.id.icon);
        if (e13 != null) {
            if (findViewById != null) {
                e13.setVisibility(findViewById.getVisibility());
            } else {
                e13.setVisibility(8);
            }
        }
        TextView textView = (TextView) lVar.e(R.id.title);
        this.mTitleView = textView;
        textView.setText(this.mTitle);
        if (e12 != null) {
            if (this.mHasRedDot) {
                COUIHintRedDot cOUIHintRedDot = (COUIHintRedDot) e12;
                cOUIHintRedDot.setLaidOut();
                e12.setVisibility(0);
                cOUIHintRedDot.setPointMode(1);
            } else {
                e12.setVisibility(8);
            }
            e12.invalidate();
        }
        COUIPreferenceUtils.bindAssignmentView(lVar, this.mAssignment, this.mAssignmentColor);
        COUICardListHelper.setItemCardBackground(lVar.itemView, COUICardListHelper.getPositionInGroup(this));
    }

    @Override // androidx.preference.TwoStatePreference, androidx.preference.Preference
    public void onClick() {
        setPlaySound(true);
        setPerformFeedBack(true);
        super.onClick();
    }

    public void refresh() {
        COUISwitch cOUISwitch = this.mSwitchView;
        if (cOUISwitch != null) {
            cOUISwitch.refresh();
        }
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

    public void setHasRedDot(boolean z10) {
        if (this.mHasRedDot != z10) {
            this.mHasRedDot = z10;
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

    public void setPerformFeedBack(boolean z10) {
        COUISwitch cOUISwitch = this.mSwitchView;
        if (cOUISwitch != null) {
            cOUISwitch.setTactileFeedbackEnabled(z10);
        }
    }

    public void setPlaySound(boolean z10) {
        COUISwitch cOUISwitch = this.mSwitchView;
        if (cOUISwitch != null) {
            cOUISwitch.setShouldPlaySound(z10);
        }
    }

    public final void setSwitchBarCheckedColor(int i10) {
        this.mSwitchBarCheckedColor = i10;
    }

    @Override // androidx.preference.Preference
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.mTitle = getTitle();
    }

    public COUISwitchPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, m.f10640l);
    }

    public COUISwitchPreference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public COUISwitchPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.mListener = new Listener();
        this.mAssignmentColor = 0;
        this.mIsCustom = false;
        this.mSwitchBarCheckedColor = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b9.l.f12614f0, i10, i11);
        this.mIsEnableClickSpan = obtainStyledAttributes.getBoolean(b9.l.f12635m0, false);
        this.mAssignment = obtainStyledAttributes.getText(b9.l.f12620h0);
        this.mAssignmentColor = obtainStyledAttributes.getInt(b9.l.f12623i0, 0);
        this.mIsSupportCardUse = obtainStyledAttributes.getBoolean(b9.l.f12546C0, true);
        this.mIconStyle = obtainStyledAttributes.getInt(b9.l.f12638n0, 1);
        this.mHasBorder = obtainStyledAttributes.getBoolean(b9.l.f12674z0, false);
        this.mRadius = obtainStyledAttributes.getDimensionPixelSize(b9.l.f12549D0, 14);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, b9.l.f12618g1, i10, i11);
        this.mHasRedDot = obtainStyledAttributes2.getBoolean(b9.l.f12621h1, false);
        obtainStyledAttributes2.recycle();
        this.mDividerDefaultHorizontalPadding = getContext().getResources().getDimensionPixelSize(C0535e.f12370B);
        this.mTitle = getTitle();
        this.mRedDotDiameter = context.getResources().getDimensionPixelOffset(f.f4765p1);
        this.mRedDotMarginStart = context.getResources().getDimensionPixelOffset(f.f4634Y4);
    }
}
