package com.coui.appcompat.itemview;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.m;
import b9.C0535e;
import b9.C0537g;
import b9.C0539i;
import b9.l;
import com.coui.appcompat.imageview.COUIRoundImageView;
import com.coui.appcompat.preference.COUICustomListSelectedLinearLayout;
import com.coui.appcompat.reddot.COUIHintRedDot;

/* loaded from: classes.dex */
public class COUIBaseListItemView extends RelativeLayout implements m {
    public static final int CIRCLE = 0;
    private static final int DEFAULT_RADIUS = 14;
    private static final int DELAY_TIME = 70;
    public static final int FORCE_CLICKABLE = 1;
    public static final int FORCE_UNCLICKABLE = 2;
    private static final int PER_HEIGHT = 6;
    public static final int ROUND = 1;
    private COUIRoundImageView mAssignIconView;
    private COUIHintRedDot mAssignRedDotView;
    private TextView mAssignView;
    private Context mContext;
    private COUIHintRedDot mEndRedDotView;
    private boolean mHasBorder;
    private COUIHintRedDot mIconRedDotView;
    private int mIconStyle;
    private COUIRoundImageView mIconView;
    private boolean mIsCustom;
    private boolean mItemEnabled;
    private int mRadius;
    private View mRootItemView;
    private TextView mSummaryView;
    private TextView mTitleView;
    private ViewGroup mWidgetFrame;

    public COUIBaseListItemView(Context context) {
        this(context, null);
    }

    private void setEnableState(View view, boolean z10) {
        view.setEnabled(z10);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                setEnableState(viewGroup.getChildAt(childCount), z10);
            }
        }
    }

    private void setIconMarginDependOnImageView(boolean z10) {
        View view = this.mRootItemView;
        if (view instanceof COUICustomListSelectedLinearLayout) {
            ((COUICustomListSelectedLinearLayout) view).setIconMarginDependOnImageView(z10);
        }
    }

    public ImageView getAssignIconView() {
        return this.mAssignIconView;
    }

    public ImageView getIconView() {
        return this.mIconView;
    }

    @Override // androidx.recyclerview.widget.m
    public boolean getItemEnabled() {
        return this.mItemEnabled;
    }

    public final View getRootItemView() {
        return this.mRootItemView;
    }

    public final void setAssignIcon(Drawable drawable) {
        COUIRoundImageView cOUIRoundImageView = this.mAssignIconView;
        if (cOUIRoundImageView != null) {
            if (drawable != null) {
                cOUIRoundImageView.setImageDrawable(drawable);
                this.mAssignIconView.setVisibility(0);
            } else {
                cOUIRoundImageView.setVisibility(8);
            }
        }
    }

    public void setAssignRedDotMode(int i10) {
        COUIHintRedDot cOUIHintRedDot = this.mAssignRedDotView;
        if (cOUIHintRedDot != null) {
            if (i10 != 0) {
                cOUIHintRedDot.setLaidOut();
                this.mAssignRedDotView.setVisibility(0);
                this.mAssignRedDotView.setPointMode(i10);
                this.mAssignRedDotView.invalidate();
                return;
            }
            cOUIHintRedDot.setVisibility(8);
        }
    }

    public final void setAssignment(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.mAssignView.setText(charSequence);
            this.mAssignView.setVisibility(0);
        } else {
            this.mAssignView.setVisibility(8);
        }
    }

    public void setAssignmentColor(int i10) {
        if (i10 != 0) {
            this.mAssignView.setTextColor(i10);
        }
    }

    public void setClickableStyle(int i10) {
        if (i10 != 1) {
            if (i10 == 2) {
                this.mRootItemView.setClickable(true);
                return;
            }
            return;
        }
        this.mRootItemView.setClickable(false);
    }

    public void setCustomIconRadius(boolean z10) {
        this.mIsCustom = z10;
        setIconStyle(this.mRadius, this.mHasBorder, this.mIconStyle, z10);
    }

    @Deprecated
    public final void setEnable(boolean z10) {
        setEnableState(this, z10);
    }

    public void setEndRedDotMode(int i10, int i11) {
        if (i10 != 0) {
            this.mEndRedDotView.setLaidOut();
            this.mEndRedDotView.setVisibility(0);
            this.mEndRedDotView.setPointMode(i10);
            this.mEndRedDotView.setPointNumber(i11);
            this.mEndRedDotView.invalidate();
            return;
        }
        this.mEndRedDotView.setVisibility(8);
    }

    public final void setIcon(Drawable drawable) {
        if (drawable != null) {
            this.mIconView.setImageDrawable(drawable);
            this.mIconView.setVisibility(0);
        } else {
            this.mIconView.setVisibility(8);
        }
    }

    public void setIconBorderRadius(int i10) {
        this.mRadius = i10;
        setIconStyle(i10, this.mHasBorder, this.mIconStyle, this.mIsCustom);
    }

    public void setIconHasBorder(boolean z10) {
        this.mHasBorder = z10;
        setIconStyle(this.mRadius, z10, this.mIconStyle, this.mIsCustom);
    }

    public void setIconRedDotMode(int i10) {
        if (i10 != 0) {
            this.mIconRedDotView.setLaidOut();
            this.mIconRedDotView.setVisibility(0);
            this.mIconRedDotView.setPointMode(i10);
            this.mIconRedDotView.invalidate();
            return;
        }
        this.mIconRedDotView.setVisibility(8);
    }

    public void setIconStyle(int i10) {
        if (i10 == 0 || i10 == 1) {
            this.mIconStyle = i10;
            setIconStyle(this.mRadius, this.mHasBorder, i10, this.mIsCustom);
        }
    }

    public final void setItemBackground(Drawable drawable) {
        this.mRootItemView.setBackground(drawable);
    }

    public void setItemEnabled(boolean z10) {
        if (this.mItemEnabled != z10) {
            this.mItemEnabled = z10;
            setEnableState(this, z10);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mRootItemView.setOnClickListener(onClickListener);
    }

    public void setPaddingEnd(int i10) {
        View view = this.mRootItemView;
        view.setPaddingRelative(view.getPaddingStart(), this.mRootItemView.getPaddingTop(), i10, this.mRootItemView.getPaddingBottom());
    }

    public void setPaddingStart(int i10) {
        View view = this.mRootItemView;
        view.setPaddingRelative(i10, view.getPaddingTop(), this.mRootItemView.getPaddingEnd(), this.mRootItemView.getPaddingBottom());
    }

    public void setPaddingStartAndEnd(int i10, int i11) {
        View view = this.mRootItemView;
        view.setPaddingRelative(i10, view.getPaddingTop(), i11, this.mRootItemView.getPaddingBottom());
    }

    public final void setSummary(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.mSummaryView.setText(charSequence);
            this.mSummaryView.setVisibility(0);
        } else {
            this.mSummaryView.setVisibility(8);
        }
    }

    public void setSummaryClickSpan() {
        this.mSummaryView.setHighlightColor(getContext().getResources().getColor(R.color.transparent));
        this.mSummaryView.setMovementMethod(LinkMovementMethod.getInstance());
        this.mSummaryView.setOnTouchListener(new View.OnTouchListener() { // from class: com.coui.appcompat.itemview.COUIBaseListItemView.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                boolean z10;
                int actionMasked = motionEvent.getActionMasked();
                int selectionStart = COUIBaseListItemView.this.mSummaryView.getSelectionStart();
                int selectionEnd = COUIBaseListItemView.this.mSummaryView.getSelectionEnd();
                int offsetForPosition = COUIBaseListItemView.this.mSummaryView.getOffsetForPosition(motionEvent.getX(), motionEvent.getY());
                if (selectionStart != selectionEnd && offsetForPosition > selectionStart && offsetForPosition < selectionEnd) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                if (actionMasked != 0) {
                    if (actionMasked == 1 || actionMasked == 3) {
                        COUIBaseListItemView.this.mSummaryView.setPressed(false);
                        COUIBaseListItemView.this.mSummaryView.postInvalidateDelayed(70L);
                    }
                } else {
                    if (z10) {
                        return false;
                    }
                    COUIBaseListItemView.this.mSummaryView.setPressed(true);
                    COUIBaseListItemView.this.mSummaryView.invalidate();
                }
                return false;
            }
        });
    }

    public void setSummaryColor(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.mSummaryView.setTextColor(colorStateList);
        }
    }

    public final void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.mTitleView.setText(charSequence);
            this.mTitleView.setVisibility(0);
        } else {
            this.mTitleView.setVisibility(8);
        }
    }

    public void setTitleColor(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.mTitleView.setTextColor(colorStateList);
        }
    }

    public final void setWidgetView(int i10) {
        ViewGroup viewGroup = this.mWidgetFrame;
        if (viewGroup != null) {
            if (i10 != 0) {
                viewGroup.setVisibility(0);
                this.mWidgetFrame.removeAllViews();
                View.inflate(this.mContext, i10, this.mWidgetFrame);
                return;
            }
            viewGroup.setVisibility(8);
        }
    }

    public COUIBaseListItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public COUIBaseListItemView(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public final void setIconStyle(int i10, boolean z10, int i11, boolean z11) {
        if (z11) {
            this.mIconView.setHasBorder(z10);
            this.mIconView.setBorderRectRadius(0);
            this.mIconView.setType(i11);
            return;
        }
        Drawable drawable = this.mIconView.getDrawable();
        if (drawable != null && i10 == 14) {
            i10 = drawable.getIntrinsicHeight() / 6;
            Resources resources = getContext().getResources();
            int i12 = C0535e.f12373E;
            if (i10 < resources.getDimensionPixelOffset(i12)) {
                i10 = getContext().getResources().getDimensionPixelOffset(i12);
            } else {
                Resources resources2 = getContext().getResources();
                int i13 = C0535e.f12372D;
                if (i10 > resources2.getDimensionPixelOffset(i13)) {
                    i10 = getContext().getResources().getDimensionPixelOffset(i13);
                }
            }
        }
        this.mIconView.setHasBorder(z10);
        this.mIconView.setBorderRectRadius(i10);
        this.mIconView.setType(i11);
    }

    public COUIBaseListItemView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.mItemEnabled = true;
        this.mRadius = 14;
        this.mIconStyle = 1;
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.f12598a, i10, i11);
        boolean z10 = obtainStyledAttributes.getBoolean(l.f12601b, true);
        boolean z11 = obtainStyledAttributes.getBoolean(l.f12613f, false);
        this.mItemEnabled = obtainStyledAttributes.getBoolean(l.f12616g, true);
        CharSequence text = obtainStyledAttributes.getText(l.f12622i);
        CharSequence text2 = obtainStyledAttributes.getText(l.f12619h);
        Drawable drawable = obtainStyledAttributes.getDrawable(l.f12610e);
        CharSequence text3 = obtainStyledAttributes.getText(l.f12604c);
        Drawable drawable2 = obtainStyledAttributes.getDrawable(l.f12607d);
        int resourceId = obtainStyledAttributes.getResourceId(l.f12625j, 0);
        obtainStyledAttributes.recycle();
        View inflate = View.inflate(context, z10 ? C0539i.f12502d : C0539i.f12501c, this);
        this.mRootItemView = inflate.findViewById(C0537g.f12485n);
        View findViewById = inflate.findViewById(C0537g.f12496y);
        this.mIconView = (COUIRoundImageView) inflate.findViewById(R.id.icon);
        this.mIconRedDotView = (COUIHintRedDot) inflate.findViewById(C0537g.f12497z);
        this.mTitleView = (TextView) inflate.findViewById(R.id.title);
        this.mSummaryView = (TextView) inflate.findViewById(R.id.summary);
        this.mEndRedDotView = (COUIHintRedDot) inflate.findViewById(C0537g.f12453B);
        this.mAssignRedDotView = (COUIHintRedDot) inflate.findViewById(C0537g.f12476e);
        this.mAssignIconView = (COUIRoundImageView) inflate.findViewById(C0537g.f12475d);
        this.mAssignView = (TextView) inflate.findViewById(C0537g.f12474c);
        this.mWidgetFrame = (ViewGroup) inflate.findViewById(R.id.widget_frame);
        this.mRootItemView.setClickable(true);
        setIconMarginDependOnImageView(z11);
        findViewById.setVisibility(0);
        setTitle(text);
        setSummary(text2);
        setIcon(drawable);
        setAssignment(text3);
        setAssignIcon(drawable2);
        setWidgetView(resourceId);
        setIconStyle(this.mRadius, this.mHasBorder, this.mIconStyle, this.mIsCustom);
        setEnableState(this, this.mItemEnabled);
    }

    public void setWidgetView(View view) {
        ViewGroup viewGroup = this.mWidgetFrame;
        if (viewGroup != null) {
            if (view != null) {
                viewGroup.setVisibility(0);
                this.mWidgetFrame.removeAllViews();
                this.mWidgetFrame.addView(view);
                return;
            }
            viewGroup.setVisibility(8);
        }
    }
}
