package com.coui.appcompat.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import androidx.preference.SwitchPreferenceCompat;
import androidx.preference.l;
import androidx.preference.m;
import androidx.recyclerview.widget.COUIRecyclerView;
import b9.C0535e;
import b9.C0537g;
import com.coui.appcompat.cardlist.COUICardListHelper;
import com.coui.appcompat.cardlist.COUICardListSelectedItemLayout;
import com.coui.appcompat.couiswitch.COUISwitch;

/* loaded from: classes.dex */
public class COUISwitchPreferenceCompat extends SwitchPreferenceCompat implements COUIRecyclerView.b {
    private CharSequence mAssignment;
    private int mAssignmentColor;
    private int mDividerDefaultHorizontalPadding;
    private boolean mIsEnableClickSpan;
    private View mItemView;
    private final Listener mListener;
    private COUISwitch mSwitchView;

    /* loaded from: classes.dex */
    public class Listener implements CompoundButton.OnCheckedChangeListener {
        private Listener() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
            if (COUISwitchPreferenceCompat.this.isChecked() == z10) {
                return;
            }
            if (!COUISwitchPreferenceCompat.this.callCustomChangeListener(Boolean.valueOf(z10))) {
                compoundButton.setChecked(!z10);
            } else {
                COUISwitchPreferenceCompat.this.setChecked(z10);
            }
        }
    }

    public COUISwitchPreferenceCompat(Context context) {
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
        return this.mItemView;
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public int getDividerStartInset() {
        return this.mDividerDefaultHorizontalPadding;
    }

    @Override // androidx.preference.SwitchPreferenceCompat, androidx.preference.Preference
    public void onBindViewHolder(l lVar) {
        this.mItemView = lVar.itemView;
        View e10 = lVar.e(C0537g.f12485n);
        if (e10 != null) {
            e10.setSoundEffectsEnabled(false);
        }
        View e11 = lVar.e(C0537g.f12460I);
        boolean z10 = e11 instanceof COUISwitch;
        if (z10) {
            COUISwitch cOUISwitch = (COUISwitch) e11;
            cOUISwitch.setOnCheckedChangeListener(null);
            cOUISwitch.setVerticalScrollBarEnabled(false);
            this.mSwitchView = cOUISwitch;
        }
        super.onBindViewHolder(lVar);
        if (z10) {
            ((COUISwitch) e11).setOnCheckedChangeListener(this.mListener);
        }
        if (this.mIsEnableClickSpan) {
            COUIPreferenceUtils.setSummaryView(getContext(), lVar);
        }
        COUIPreferenceUtils.bindAssignmentView(lVar, this.mAssignment, this.mAssignmentColor);
        COUICardListHelper.setItemCardBackground(lVar.itemView, COUICardListHelper.getPositionInGroup(this));
    }

    @Override // androidx.preference.TwoStatePreference, androidx.preference.Preference
    public void onClick() {
        COUISwitch cOUISwitch = this.mSwitchView;
        if (cOUISwitch != null) {
            cOUISwitch.setShouldPlaySound(true);
        }
        super.onClick();
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

    public void setIsEnableClickSpan(boolean z10) {
        this.mIsEnableClickSpan = z10;
    }

    public COUISwitchPreferenceCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, m.f10639k);
    }

    public COUISwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public COUISwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10);
        this.mListener = new Listener();
        this.mAssignmentColor = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b9.l.f12614f0, i10, 0);
        this.mIsEnableClickSpan = obtainStyledAttributes.getBoolean(b9.l.f12635m0, false);
        this.mAssignment = obtainStyledAttributes.getText(b9.l.f12620h0);
        this.mAssignmentColor = obtainStyledAttributes.getInt(b9.l.f12623i0, 0);
        obtainStyledAttributes.recycle();
        this.mDividerDefaultHorizontalPadding = getContext().getResources().getDimensionPixelSize(C0535e.f12370B);
    }
}
