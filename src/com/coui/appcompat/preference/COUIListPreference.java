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
import androidx.preference.ListPreference;
import androidx.preference.l;
import androidx.recyclerview.widget.COUIRecyclerView;
import b9.C0535e;
import b9.k;
import com.coui.appcompat.cardlist.COUICardListHelper;
import com.coui.appcompat.cardlist.COUICardListSelectedItemLayout;
import com.coui.appcompat.uiutil.AnimLevel;
import com.coui.appcompat.uiutil.UIUtil;

/* loaded from: classes.dex */
public class COUIListPreference extends ListPreference implements COUICardSupportInterface, COUIRecyclerView.b {
    private CharSequence mAssignment;
    private boolean mBlurBackground;
    private AnimLevel mBlurMinAnimLevel;
    private int mDividerDefaultHorizontalPadding;
    private boolean mIfFollowHand;
    private boolean mIsSupportCardUse;
    private View mItemView;
    Drawable mJumpRes;
    private Point mLastTouchPoint;
    private View mPreferenceView;
    CharSequence mStatusText1;
    CharSequence[] mSummaries;
    private TextView mTitleView;

    public COUIListPreference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, k.f12536n);
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

    public CharSequence[] getSummaries() {
        return this.mSummaries;
    }

    public boolean isBlurBackground() {
        return this.mBlurBackground;
    }

    public boolean isIfFollowHand() {
        return this.mIfFollowHand;
    }

    @Override // com.coui.appcompat.preference.COUICardSupportInterface
    public boolean isSupportCardUse() {
        return this.mIsSupportCardUse;
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(l lVar) {
        super.onBindViewHolder(lVar);
        this.mItemView = lVar.itemView;
        COUIPreferenceUtils.bindView(lVar, this.mJumpRes, this.mStatusText1, getAssignment());
        COUICardListHelper.setItemCardBackground(lVar.itemView, COUICardListHelper.getPositionInGroup(this));
        this.mTitleView = (TextView) lVar.e(R.id.title);
        View view = lVar.itemView;
        this.mPreferenceView = view;
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.coui.appcompat.preference.COUIListPreference.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getActionMasked() == 0) {
                    COUIListPreference.this.mLastTouchPoint.set((int) motionEvent.getX(), (int) motionEvent.getY());
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

    public void setIfFollowHand(boolean z10) {
        this.mIfFollowHand = z10;
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

    public void setSummaries(CharSequence[] charSequenceArr) {
        this.mSummaries = charSequenceArr;
    }

    public COUIListPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet);
        this.mLastTouchPoint = new Point();
        this.mIfFollowHand = true;
        this.mBlurBackground = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b9.l.f12614f0, i10, i11);
        this.mIsSupportCardUse = obtainStyledAttributes.getBoolean(b9.l.f12546C0, true);
        this.mAssignment = obtainStyledAttributes.getText(b9.l.f12620h0);
        this.mJumpRes = obtainStyledAttributes.getDrawable(b9.l.f12662v0);
        this.mStatusText1 = obtainStyledAttributes.getText(b9.l.f12665w0);
        this.mIfFollowHand = obtainStyledAttributes.getBoolean(b9.l.f12641o0, true);
        this.mBlurBackground = obtainStyledAttributes.getBoolean(b9.l.f12632l0, false);
        this.mBlurMinAnimLevel = AnimLevel.valueOf(obtainStyledAttributes.getInt(b9.l.f12626j0, UIUtil.ANIM_LEVEL_SUPPORT_BLUR_MIN.getIntValue()));
        obtainStyledAttributes.recycle();
        this.mDividerDefaultHorizontalPadding = getContext().getResources().getDimensionPixelSize(C0535e.f12370B);
    }

    public void setJump(int i10) {
        setJump(getContext().getResources().getDrawable(i10));
    }

    public COUIListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public COUIListPreference(Context context) {
        this(context, null);
    }
}
