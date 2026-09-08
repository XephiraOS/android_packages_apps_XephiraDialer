package com.coui.appcompat.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.preference.EditTextPreference;
import androidx.recyclerview.widget.COUIRecyclerView;
import b9.C0535e;
import b9.k;
import b9.l;
import com.coui.appcompat.cardlist.COUICardListHelper;
import com.coui.appcompat.cardlist.COUICardListSelectedItemLayout;
import com.coui.appcompat.uiutil.AnimLevel;
import com.coui.appcompat.uiutil.UIUtil;

/* loaded from: classes.dex */
public class COUIEditTextPreference extends EditTextPreference implements COUICardSupportInterface, COUIRecyclerView.b {
    private CharSequence mAssignment;
    private boolean mBlurBackground;
    private AnimLevel mBlurMinAnimLevel;
    private Context mContext;
    private int mDividerDefaultHorizontalPadding;
    private boolean mIsSupportCardUse;
    private View mItemView;
    private Drawable mJumpRes;
    private Point mLastTouchPoint;
    private View mPreferenceView;
    private CharSequence mStatusText1;
    private boolean mSupportEmptyInput;
    private TextView mTitleView;

    public COUIEditTextPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLastTouchPoint = new Point();
        this.mBlurBackground = false;
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.f12614f0, 0, k.f12536n);
        this.mAssignment = obtainStyledAttributes.getText(l.f12620h0);
        this.mJumpRes = obtainStyledAttributes.getDrawable(l.f12662v0);
        this.mStatusText1 = obtainStyledAttributes.getText(l.f12665w0);
        this.mIsSupportCardUse = obtainStyledAttributes.getBoolean(l.f12546C0, true);
        this.mBlurBackground = obtainStyledAttributes.getBoolean(l.f12632l0, false);
        this.mBlurMinAnimLevel = AnimLevel.valueOf(obtainStyledAttributes.getInt(l.f12626j0, UIUtil.ANIM_LEVEL_SUPPORT_BLUR_MIN.getIntValue()));
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, l.f12556F1, 0, 0);
        this.mSupportEmptyInput = obtainStyledAttributes2.getBoolean(l.f12559G1, false);
        obtainStyledAttributes2.recycle();
        this.mDividerDefaultHorizontalPadding = getContext().getResources().getDimensionPixelSize(C0535e.f12370B);
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

    public AnimLevel getBlurMinAnimLevel() {
        return this.mBlurMinAnimLevel;
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

    public Drawable getJump() {
        return this.mJumpRes;
    }

    public Point getLastTouchPoint() {
        return this.mLastTouchPoint;
    }

    public View getPreferenceView() {
        return this.mPreferenceView;
    }

    public CharSequence getStatusText1() {
        return this.mStatusText1;
    }

    public boolean isBlurBackground() {
        return this.mBlurBackground;
    }

    @Override // com.coui.appcompat.preference.COUICardSupportInterface
    public boolean isSupportCardUse() {
        return this.mIsSupportCardUse;
    }

    public boolean isSupportEmptyInput() {
        return this.mSupportEmptyInput;
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(androidx.preference.l lVar) {
        super.onBindViewHolder(lVar);
        this.mItemView = lVar.itemView;
        COUIPreferenceUtils.bindView(lVar, this.mJumpRes, this.mStatusText1, getAssignment());
        COUICardListHelper.setItemCardBackground(lVar.itemView, COUICardListHelper.getPositionInGroup(this));
        this.mTitleView = (TextView) lVar.e(R.id.title);
        View view = lVar.itemView;
        this.mPreferenceView = view;
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.coui.appcompat.preference.COUIEditTextPreference.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getActionMasked() == 0) {
                    COUIEditTextPreference.this.mLastTouchPoint.set((int) motionEvent.getX(), (int) motionEvent.getY());
                    return false;
                }
                return false;
            }
        });
    }

    public void setAssignment(CharSequence charSequence) {
        if (!TextUtils.equals(this.mAssignment, charSequence)) {
            this.mAssignment = charSequence;
            notifyChanged();
        }
    }

    public void setBlurBackground(boolean z10) {
        this.mBlurBackground = z10;
    }

    public void setBlurMinAnimLevel(AnimLevel animLevel) {
        this.mBlurMinAnimLevel = animLevel;
    }

    @Override // com.coui.appcompat.preference.COUICardSupportInterface
    public void setIsSupportCardUse(boolean z10) {
        this.mIsSupportCardUse = z10;
    }

    public void setJump(Drawable drawable) {
        if (this.mJumpRes != drawable) {
            this.mJumpRes = drawable;
            notifyChanged();
        }
    }

    public void setStatusText1(CharSequence charSequence) {
        if ((charSequence == null && this.mStatusText1 != null) || (charSequence != null && !charSequence.equals(this.mStatusText1))) {
            this.mStatusText1 = charSequence;
            notifyChanged();
        }
    }

    public void setJump(int i10) {
        setJump(this.mContext.getResources().getDrawable(i10));
    }

    public COUIEditTextPreference(Context context) {
        this(context, null);
    }
}
