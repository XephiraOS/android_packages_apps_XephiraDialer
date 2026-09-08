package com.coui.appcompat.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.preference.SwitchPreferenceCompat;
import androidx.preference.l;
import androidx.recyclerview.widget.COUIRecyclerView;
import b9.C0532b;
import b9.C0535e;
import b9.C0537g;
import b9.k;
import com.coui.appcompat.cardlist.COUICardListHelper;
import com.coui.appcompat.cardlist.COUICardListSelectedItemLayout;
import com.coui.appcompat.couiswitch.COUISwitch;

/* loaded from: classes.dex */
public class COUISwitchLoadingPreference extends SwitchPreferenceCompat implements COUICardSupportInterface, COUIRecyclerView.b {
    private CharSequence mAssignment;
    private int mAssignmentColor;
    View mCheckableView;
    private int mDividerDefaultHorizontalPadding;
    private boolean mIsEnableClickSpan;
    private boolean mIsSupportCardUse;
    private View mItemView;
    private final Listener mListener;
    private COUISwitch.OnLoadingStateChangedListener mOnLoadingStateChangedListener;
    private COUISwitch mSwitchView;
    private TextView mTitleView;

    /* loaded from: classes.dex */
    public class Listener implements CompoundButton.OnCheckedChangeListener {
        private Listener() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
            if (!COUISwitchLoadingPreference.this.callCustomChangeListener(Boolean.valueOf(z10))) {
                compoundButton.setChecked(!z10);
            } else {
                COUISwitchLoadingPreference.this.setChecked(z10);
            }
        }
    }

    public COUISwitchLoadingPreference(Context context) {
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
        return this.mTitleView;
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public int getDividerStartInset() {
        return this.mDividerDefaultHorizontalPadding;
    }

    public View getSwitch() {
        return this.mCheckableView;
    }

    @Override // com.coui.appcompat.preference.COUICardSupportInterface
    public boolean isSupportCardUse() {
        return this.mIsSupportCardUse;
    }

    @Override // androidx.preference.SwitchPreferenceCompat, androidx.preference.Preference
    public void onBindViewHolder(l lVar) {
        this.mItemView = lVar.itemView;
        View e10 = lVar.e(C0537g.f12485n);
        if (e10 != null) {
            e10.setSoundEffectsEnabled(false);
            e10.setHapticFeedbackEnabled(false);
        }
        View e11 = lVar.e(C0537g.f12460I);
        this.mCheckableView = e11;
        if (e11 instanceof COUISwitch) {
            COUISwitch cOUISwitch = (COUISwitch) e11;
            cOUISwitch.setOnCheckedChangeListener(null);
            cOUISwitch.setVerticalScrollBarEnabled(false);
            this.mSwitchView = cOUISwitch;
        }
        super.onBindViewHolder(lVar);
        View view = this.mCheckableView;
        if (view instanceof COUISwitch) {
            COUISwitch cOUISwitch2 = (COUISwitch) view;
            cOUISwitch2.setLoadingStyle(true);
            cOUISwitch2.setOnLoadingStateChangedListener(this.mOnLoadingStateChangedListener);
            cOUISwitch2.setOnCheckedChangeListener(this.mListener);
        }
        if (this.mIsEnableClickSpan) {
            COUIPreferenceUtils.setSummaryView(getContext(), lVar);
        }
        this.mTitleView = (TextView) lVar.e(R.id.title);
        View findViewById = lVar.itemView.findViewById(R.id.icon);
        View e12 = lVar.e(C0537g.f12496y);
        if (e12 != null) {
            if (findViewById != null) {
                e12.setVisibility(findViewById.getVisibility());
            } else {
                e12.setVisibility(8);
            }
        }
        COUIPreferenceUtils.bindAssignmentView(lVar, this.mAssignment, this.mAssignmentColor);
        COUICardListHelper.setItemCardBackground(lVar.itemView, COUICardListHelper.getPositionInGroup(this));
    }

    @Override // androidx.preference.TwoStatePreference, androidx.preference.Preference
    public void onClick() {
        COUISwitch cOUISwitch = this.mSwitchView;
        if (cOUISwitch != null) {
            cOUISwitch.setShouldPlaySound(true);
            this.mSwitchView.setTactileFeedbackEnabled(true);
            this.mSwitchView.startLoading();
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

    public void setIsEnableClickSpan(boolean z10) {
        this.mIsEnableClickSpan = z10;
    }

    @Override // com.coui.appcompat.preference.COUICardSupportInterface
    public void setIsSupportCardUse(boolean z10) {
        this.mIsSupportCardUse = z10;
    }

    public void setOnLoadingStateChangedListener(COUISwitch.OnLoadingStateChangedListener onLoadingStateChangedListener) {
        this.mOnLoadingStateChangedListener = onLoadingStateChangedListener;
        View view = this.mCheckableView;
        if (view instanceof COUISwitch) {
            ((COUISwitch) view).setOnLoadingStateChangedListener(onLoadingStateChangedListener);
        }
    }

    public void startLoading() {
        View view = this.mCheckableView;
        if (view != null && (view instanceof COUISwitch)) {
            ((COUISwitch) view).startLoading();
        }
    }

    public void stopLoading() {
        View view = this.mCheckableView;
        if (view != null && (view instanceof COUISwitch)) {
            ((COUISwitch) view).stopLoading();
        }
    }

    public COUISwitchLoadingPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0532b.f12358q);
    }

    public COUISwitchLoadingPreference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, k.f12537o);
    }

    public COUISwitchLoadingPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.mListener = new Listener();
        this.mAssignmentColor = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b9.l.f12614f0, i10, 0);
        this.mIsEnableClickSpan = obtainStyledAttributes.getBoolean(b9.l.f12635m0, false);
        this.mIsSupportCardUse = obtainStyledAttributes.getBoolean(b9.l.f12546C0, true);
        this.mAssignment = obtainStyledAttributes.getText(b9.l.f12620h0);
        this.mAssignmentColor = obtainStyledAttributes.getInt(b9.l.f12623i0, 0);
        obtainStyledAttributes.recycle();
        this.mDividerDefaultHorizontalPadding = getContext().getResources().getDimensionPixelSize(C0535e.f12370B);
    }
}
