package com.coui.appcompat.preference;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.preference.Preference;
import androidx.preference.l;
import androidx.preference.m;
import androidx.recyclerview.widget.COUIRecyclerView;
import b9.C0535e;
import b9.C0537g;
import com.coui.appcompat.cardlist.COUICardListHelper;
import com.coui.appcompat.cardlist.COUICardListSelectedItemLayout;
import com.coui.appcompat.imageview.COUIRoundImageView;
import com.coui.appcompat.poplist.PreciseClickHelper;
import com.coui.appcompat.reddot.COUIHintRedDot;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public class COUIPreference extends Preference implements COUICardSupportInterface, COUIRecyclerView.b {
    public static final int CIRCLE = 0;
    static final int DEFAULT_RADIUS = 14;
    static final int DEFAULT_SCALE = 3;
    public static final int FORCE_CLICK = 1;
    public static final int FORCE_UNCLICK = 2;
    static final int MAX_RADIUS = 36;
    static final int MIN_RADIUS = 14;
    public static final int NORMAL = 0;
    static final int NO_ICON_HEIGHT = 0;
    public static final int ROUND = 1;
    public static final int SUMMARY_LINE_DEFAULT = 0;
    public static final int SUMMARY_LINE_ONE = 1;
    public static final int SUMMARY_LINE_TWO = 2;
    private static final String TAG = "COUIPreference-";
    static final int ratio = 6;
    private COUIHintRedDot assignRedDot;
    private COUIRoundImageView assignmentIcon;
    private COUIHintRedDot endRedDot;
    private View iconRedDot;
    private Drawable mAssignIconRes;
    private int mAssignRedDotMode;
    private CharSequence mAssignment;
    private int mAssignmentColor;
    private int mClickStyle;
    private Context mContext;
    private boolean mCouiSetDefaultColor;
    private int mCouiSummaryLineLimit;
    private int mDividerDefaultHorizontalPadding;
    private int mEndRedDotMode;
    private int mEndRedDotNum;
    private boolean mHasBorder;
    private int mIconRedDotMode;
    private int mIconStyle;
    private boolean mIsBackgroundAnimationEnabled;
    private boolean mIsCustom;
    private boolean mIsEnableClickSpan;
    private boolean mIsSelected;
    private boolean mIsSupportCardUse;
    private View mItemView;
    Drawable mJumpRes;
    private PreciseClickHelper mPreciseHelper;
    protected PreciseClickHelper.OnPreciseClickListener mPreciseListener;
    private int mRadius;
    private boolean mShowDivider;
    CharSequence mStatusText1;
    private ColorStateList mSummaryTextColor;
    private TextView mSummaryView;
    private ColorStateList mTitleTextColor;
    private TextView mTitleView;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface SummaryLineType {
    }

    public COUIPreference(Context context) {
        this(context, null);
    }

    private void initPreciseHelper() {
        if (this.mItemView != null && this.mPreciseListener != null) {
            removePreciseClickListener();
            PreciseClickHelper preciseClickHelper = new PreciseClickHelper(this.mItemView, new PreciseClickHelper.OnPreciseClickListener() { // from class: com.coui.appcompat.preference.COUIPreference.1
                @Override // com.coui.appcompat.poplist.PreciseClickHelper.OnPreciseClickListener
                public void onClick(View view, int i10, int i11) {
                    COUIPreference.this.mPreciseListener.onClick(view, i10, i11);
                }
            });
            this.mPreciseHelper = preciseClickHelper;
            preciseClickHelper.setup();
        }
    }

    public void changeEndRedDotNumberWithAnim(int i10) {
        COUIHintRedDot cOUIHintRedDot = this.endRedDot;
        if (cOUIHintRedDot instanceof COUIHintRedDot) {
            this.mEndRedDotNum = i10;
            cOUIHintRedDot.changePointNumber(i10);
            if (i10 > 0) {
                this.endRedDot.setPointNumber(i10);
            }
        }
    }

    public void dismissAssignRedDot() {
        COUIHintRedDot cOUIHintRedDot = this.assignRedDot;
        if ((cOUIHintRedDot instanceof COUIHintRedDot) && cOUIHintRedDot.getVisibility() == 0) {
            this.assignRedDot.executeScaleAnim(false);
            notifyChanged();
        }
    }

    public void dismissEndRedDot() {
        COUIHintRedDot cOUIHintRedDot = this.endRedDot;
        if ((cOUIHintRedDot instanceof COUIHintRedDot) && cOUIHintRedDot.getVisibility() == 0) {
            this.endRedDot.executeScaleAnim(false);
            notifyChanged();
        }
    }

    public void dismissIconRedDot() {
        View view = this.iconRedDot;
        if ((view instanceof COUIHintRedDot) && view.getVisibility() == 0) {
            ((COUIHintRedDot) this.iconRedDot).executeScaleAnim(false);
            notifyChanged();
        }
    }

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

    public int getAssignRedDotMode() {
        return this.mAssignRedDotMode;
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

    public int getClickStyle() {
        return this.mClickStyle;
    }

    public View getDividerEndAlignView() {
        return null;
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public int getDividerEndInset() {
        return this.mDividerDefaultHorizontalPadding;
    }

    public View getDividerStartAlignView() {
        return this.mTitleView;
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public int getDividerStartInset() {
        return this.mDividerDefaultHorizontalPadding;
    }

    public int getEndRedDotMode() {
        return this.mEndRedDotMode;
    }

    public int getEndRedDotNum() {
        return this.mEndRedDotNum;
    }

    public int getIconRedDotMode() {
        return this.mIconRedDotMode;
    }

    public int getIconStyle() {
        return this.mIconStyle;
    }

    public boolean getIsSelected() {
        return this.mIsSelected;
    }

    public CharSequence getStatusText1() {
        return this.mStatusText1;
    }

    public boolean isShowDivider() {
        return this.mShowDivider;
    }

    @Override // com.coui.appcompat.preference.COUICardSupportInterface
    public boolean isSupportCardUse() {
        return this.mIsSupportCardUse;
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(l lVar) {
        super.onBindViewHolder(lVar);
        COUICardListHelper.setItemCardBackground(lVar.itemView, COUICardListHelper.getPositionInGroup(this));
        View view = lVar.itemView;
        if (view instanceof COUICardListSelectedItemLayout) {
            ((COUICardListSelectedItemLayout) view).consumeDispatchingEventForState(false);
        }
        View e10 = lVar.e(C0537g.f12485n);
        if (e10 != null) {
            int i10 = this.mClickStyle;
            if (i10 != 1) {
                if (i10 == 2) {
                    e10.setClickable(true);
                }
            } else {
                e10.setClickable(false);
            }
        }
        this.mItemView = lVar.itemView;
        initPreciseHelper();
        View view2 = this.mItemView;
        if (view2 != null) {
            if (view2 instanceof ListSelectedItemLayout) {
                ((ListSelectedItemLayout) view2).setBackgroundAnimationEnabled(this.mIsBackgroundAnimationEnabled);
            }
            View view3 = this.mItemView;
            if (view3 instanceof COUICardListSelectedItemLayout) {
                ((COUICardListSelectedItemLayout) view3).setIsSelected(this.mIsSelected);
            }
        }
        if (this.mAssignmentColor == 0) {
            COUIPreferenceUtils.bindView(lVar, this.mJumpRes, this.mStatusText1, getAssignment());
        } else {
            COUIPreferenceUtils.bindView(lVar, this.mJumpRes, this.mStatusText1, getAssignment(), this.mAssignmentColor);
        }
        COUIPreferenceUtils.setTitleViewColor(getContext(), lVar, this.mTitleTextColor);
        COUIPreferenceUtils.setIconStyle(lVar, getContext(), this.mRadius, this.mHasBorder, this.mIconStyle, this.mIsCustom);
        COUIPreferenceUtils.setSummaryViewColor(lVar, this.mSummaryTextColor);
        if (this.mIsEnableClickSpan) {
            COUIPreferenceUtils.setSummaryView(getContext(), lVar);
        }
        this.mTitleView = (TextView) lVar.e(R.id.title);
        TextView textView = (TextView) lVar.e(R.id.summary);
        this.mSummaryView = textView;
        if (textView != null) {
            int i11 = this.mCouiSummaryLineLimit;
            if (i11 == 0) {
                textView.setMaxLines(Integer.MAX_VALUE);
                this.mSummaryView.setEllipsize(null);
            } else {
                textView.setMaxLines(i11);
                this.mSummaryView.setEllipsize(TextUtils.TruncateAt.END);
            }
        }
        this.iconRedDot = lVar.e(C0537g.f12497z);
        this.endRedDot = (COUIHintRedDot) lVar.e(C0537g.f12453B);
        this.assignRedDot = (COUIHintRedDot) lVar.e(C0537g.f12476e);
        COUIRoundImageView cOUIRoundImageView = (COUIRoundImageView) lVar.e(C0537g.f12475d);
        this.assignmentIcon = cOUIRoundImageView;
        if (cOUIRoundImageView != null) {
            Drawable drawable = this.mAssignIconRes;
            if (drawable != null) {
                cOUIRoundImageView.setImageDrawable(drawable);
                this.assignmentIcon.setVisibility(0);
            } else {
                cOUIRoundImageView.setVisibility(8);
            }
        }
        View view4 = this.iconRedDot;
        if (view4 instanceof COUIHintRedDot) {
            if (this.mIconRedDotMode != 0) {
                ((COUIHintRedDot) view4).setLaidOut();
                this.iconRedDot.setVisibility(0);
                ((COUIHintRedDot) this.iconRedDot).setPointMode(this.mIconRedDotMode);
                this.iconRedDot.invalidate();
            } else {
                view4.setVisibility(8);
            }
        }
        COUIHintRedDot cOUIHintRedDot = this.endRedDot;
        if (cOUIHintRedDot instanceof COUIHintRedDot) {
            if (this.mEndRedDotMode != 0) {
                cOUIHintRedDot.setLaidOut();
                this.endRedDot.setVisibility(0);
                this.endRedDot.setPointMode(this.mEndRedDotMode);
                this.endRedDot.setPointNumber(this.mEndRedDotNum);
                this.endRedDot.invalidate();
            } else {
                cOUIHintRedDot.setVisibility(8);
            }
        }
        COUIHintRedDot cOUIHintRedDot2 = this.assignRedDot;
        if (cOUIHintRedDot2 instanceof COUIHintRedDot) {
            if (this.mAssignRedDotMode != 0) {
                cOUIHintRedDot2.setLaidOut();
                this.assignRedDot.setVisibility(0);
                this.assignRedDot.setPointMode(this.mAssignRedDotMode);
                this.assignRedDot.invalidate();
                return;
            }
            cOUIHintRedDot2.setVisibility(8);
        }
    }

    @Override // androidx.preference.Preference
    public void onDetached() {
        removePreciseClickListener();
        super.onDetached();
    }

    public void removePreciseClickListener() {
        PreciseClickHelper preciseClickHelper = this.mPreciseHelper;
        if (preciseClickHelper != null) {
            preciseClickHelper.unSet();
            this.mPreciseHelper = null;
        }
    }

    public void setAssignIconRes(Drawable drawable) {
        if (this.mAssignIconRes != drawable) {
            this.mAssignIconRes = drawable;
            notifyChanged();
        }
    }

    public void setAssignRedDotMode(int i10) {
        if (this.mAssignRedDotMode != i10) {
            this.mAssignRedDotMode = i10;
            notifyChanged();
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

    public void setBackgroundAnimationEnabled(boolean z10) {
        if (this.mIsBackgroundAnimationEnabled != z10) {
            this.mIsBackgroundAnimationEnabled = z10;
            notifyChanged();
        }
    }

    public void setBorderRectRadius(int i10) {
        if (this.mRadius != i10) {
            this.mRadius = i10;
            notifyChanged();
        }
    }

    public void setClickStyle(int i10) {
        this.mClickStyle = i10;
    }

    public void setCouiSummaryLine(int i10) {
        if (this.mCouiSummaryLineLimit != i10) {
            this.mCouiSummaryLineLimit = i10;
            notifyChanged();
        }
    }

    public void setEndRedDotMode(int i10) {
        if (this.mEndRedDotMode != i10) {
            this.mEndRedDotMode = i10;
            notifyChanged();
        }
    }

    public void setEndRedDotNum(int i10) {
        if (this.mEndRedDotNum != i10) {
            this.mEndRedDotNum = i10;
            notifyChanged();
        }
    }

    public void setIconRedDotMode(int i10) {
        if (this.mIconRedDotMode != i10) {
            this.mIconRedDotMode = i10;
            notifyChanged();
        }
    }

    public void setIconStyle(int i10) {
        if (i10 == 0 || i10 == 1) {
            this.mIconStyle = i10;
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

    public void setJump(Drawable drawable) {
        if (this.mJumpRes != drawable) {
            this.mJumpRes = drawable;
            notifyChanged();
        }
    }

    public void setOnPreciseClickListener(PreciseClickHelper.OnPreciseClickListener onPreciseClickListener) {
        this.mPreciseListener = onPreciseClickListener;
        initPreciseHelper();
    }

    public void setSelected(boolean z10) {
        if (this.mIsSelected != z10) {
            this.mIsSelected = z10;
            notifyChanged();
        }
    }

    public void setSelectedState(boolean z10) {
        this.mIsSelected = z10;
    }

    public void setShowDivider(boolean z10) {
        if (this.mShowDivider != z10) {
            this.mShowDivider = z10;
            notifyChanged();
        }
    }

    public void setStatusText1(CharSequence charSequence) {
        if ((charSequence == null && this.mStatusText1 != null) || (charSequence != null && !charSequence.equals(this.mStatusText1))) {
            this.mStatusText1 = charSequence;
            notifyChanged();
        }
    }

    public void setSummaryTextColor(ColorStateList colorStateList) {
        this.mSummaryTextColor = colorStateList;
        notifyChanged();
    }

    public void setTitleColor(ColorStateList colorStateList) {
        if (this.mTitleTextColor != colorStateList) {
            this.mTitleTextColor = colorStateList;
            notifyChanged();
        }
    }

    public void showAssignRedDot() {
        COUIHintRedDot cOUIHintRedDot = this.assignRedDot;
        if (cOUIHintRedDot instanceof COUIHintRedDot) {
            cOUIHintRedDot.executeScaleAnim(true);
            notifyChanged();
        }
    }

    public void showEndRedDot() {
        COUIHintRedDot cOUIHintRedDot = this.endRedDot;
        if (cOUIHintRedDot instanceof COUIHintRedDot) {
            cOUIHintRedDot.executeScaleAnim(true);
            notifyChanged();
        }
    }

    public void showIconRedDot() {
        View view = this.iconRedDot;
        if (view instanceof COUIHintRedDot) {
            ((COUIHintRedDot) view).executeScaleAnim(true);
            notifyChanged();
        }
    }

    public COUIPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, m.f10636h);
    }

    public COUIPreference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public COUIPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.mShowDivider = true;
        this.mClickStyle = 0;
        this.mIsSelected = false;
        this.mIsBackgroundAnimationEnabled = true;
        this.mIsCustom = false;
        this.mTitleTextColor = null;
        this.mSummaryTextColor = null;
        this.mCouiSetDefaultColor = false;
        this.mCouiSummaryLineLimit = 0;
        this.mContext = context;
        this.mDividerDefaultHorizontalPadding = context.getResources().getDimensionPixelSize(C0535e.f12370B);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b9.l.f12614f0, i10, i11);
        this.mShowDivider = obtainStyledAttributes.getBoolean(b9.l.f12650r0, this.mShowDivider);
        this.mIsEnableClickSpan = obtainStyledAttributes.getBoolean(b9.l.f12635m0, false);
        this.mJumpRes = obtainStyledAttributes.getDrawable(b9.l.f12662v0);
        this.mAssignIconRes = obtainStyledAttributes.getDrawable(b9.l.f12659u0);
        this.mStatusText1 = obtainStyledAttributes.getText(b9.l.f12665w0);
        this.mClickStyle = obtainStyledAttributes.getInt(b9.l.f12629k0, 0);
        this.mAssignment = obtainStyledAttributes.getText(b9.l.f12620h0);
        this.mAssignmentColor = obtainStyledAttributes.getInt(b9.l.f12623i0, 0);
        this.mIconStyle = obtainStyledAttributes.getInt(b9.l.f12638n0, 1);
        this.mHasBorder = obtainStyledAttributes.getBoolean(b9.l.f12674z0, false);
        this.mRadius = obtainStyledAttributes.getDimensionPixelSize(b9.l.f12549D0, 14);
        this.mIconRedDotMode = obtainStyledAttributes.getInt(b9.l.f12540A0, 0);
        this.mEndRedDotMode = obtainStyledAttributes.getInt(b9.l.f12668x0, 0);
        this.mAssignRedDotMode = obtainStyledAttributes.getInt(b9.l.f12617g0, 0);
        this.mEndRedDotNum = obtainStyledAttributes.getInt(b9.l.f12671y0, 0);
        this.mIsBackgroundAnimationEnabled = obtainStyledAttributes.getBoolean(b9.l.f12543B0, true);
        this.mIsSupportCardUse = obtainStyledAttributes.getBoolean(b9.l.f12546C0, true);
        boolean z10 = obtainStyledAttributes.getBoolean(b9.l.f12647q0, false);
        this.mCouiSetDefaultColor = z10;
        if (z10) {
            this.mTitleTextColor = obtainStyledAttributes.getColorStateList(b9.l.f12552E0);
            this.mSummaryTextColor = obtainStyledAttributes.getColorStateList(b9.l.f12653s0);
        }
        this.mIsCustom = obtainStyledAttributes.getBoolean(b9.l.f12644p0, false);
        this.mCouiSummaryLineLimit = obtainStyledAttributes.getInt(b9.l.f12656t0, 0);
        obtainStyledAttributes.recycle();
    }

    public void setJump(int i10) {
        setJump(this.mContext.getResources().getDrawable(i10));
    }
}
