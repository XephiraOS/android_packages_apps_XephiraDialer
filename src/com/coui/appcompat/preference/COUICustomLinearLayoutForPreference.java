package com.coui.appcompat.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import b9.C0535e;
import b9.l;

/* loaded from: classes.dex */
public class COUICustomLinearLayoutForPreference extends LinearLayout {
    private String TAG;
    private boolean mAHavePriority;
    private boolean mBStickToC;
    private int mDefaultMarginEnd;
    private int mMessageLayoutMarginEndInRight;
    private int mReddotMarginEndInRightHasAssignment;
    private int mReddotMarginEndInRightNoAssignment;
    private boolean mSetMessageLayoutMarginEnd;
    private int mViewLowPriorityMinWidth;
    private View viewA;
    private View viewB;
    private View viewC;

    public COUICustomLinearLayoutForPreference(Context context) {
        this(context, null);
    }

    private void customMeasure(int i10, int i11) {
        int i12;
        int realWidthWithMargin;
        int marginWidth;
        int min;
        int min2;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec((View.MeasureSpec.getSize(i10) - getPaddingLeft()) - getPaddingRight(), View.MeasureSpec.getMode(i10));
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec((View.MeasureSpec.getSize(i11) - getPaddingTop()) - getPaddingBottom(), View.MeasureSpec.getMode(i11));
        if (this.viewA.getVisibility() != 8) {
            measureChildWithMargins(this.viewA, makeMeasureSpec, 0, makeMeasureSpec2, 0);
            i12 = Math.max(this.viewA.getMeasuredHeight(), 0);
        } else {
            measureChild(this.viewA, View.MeasureSpec.makeMeasureSpec(0, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 1073741824));
            i12 = 0;
        }
        if (this.viewB.getVisibility() != 8) {
            measureChildWithMargins(this.viewB, makeMeasureSpec, 0, makeMeasureSpec2, 0);
            i12 = Math.max(this.viewB.getMeasuredHeight(), i12);
        } else {
            measureChild(this.viewB, View.MeasureSpec.makeMeasureSpec(0, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 1073741824));
        }
        if (this.viewC.getVisibility() != 8) {
            measureChildWithMargins(this.viewC, makeMeasureSpec, 0, makeMeasureSpec2, 0);
            i12 = Math.max(this.viewC.getMeasuredHeight(), i12);
        } else {
            measureChild(this.viewC, View.MeasureSpec.makeMeasureSpec(0, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 1073741824));
        }
        int paddingLeft = getPaddingLeft();
        int measuredWidth = getMeasuredWidth() - getPaddingRight();
        int i13 = measuredWidth - paddingLeft;
        if (getRealWidthWithMargin(this.viewA) + getRealWidthWithMargin(this.viewB) + getRealWidthWithMargin(this.viewC) > i13) {
            if (this.mAHavePriority) {
                realWidthWithMargin = getRealWidthWithMargin(this.viewC);
                marginWidth = getMarginWidth(this.viewC);
            } else {
                realWidthWithMargin = getRealWidthWithMargin(this.viewA);
                marginWidth = getMarginWidth(this.viewA);
            }
            int i14 = realWidthWithMargin - marginWidth;
            int i15 = this.mViewLowPriorityMinWidth;
            if (i14 >= i15) {
                i14 = i15;
            }
            if (this.mAHavePriority) {
                min2 = Math.min(getRealWidthWithMargin(this.viewA), (i13 - (i14 + getMarginWidth(this.viewC))) - getRealWidthWithMargin(this.viewB));
                min = measuredWidth - Math.max(measuredWidth - getRealWidthWithMargin(this.viewC), (paddingLeft + min2) + getRealWidthWithMargin(this.viewB));
            } else {
                min = Math.min(getRealWidthWithMargin(this.viewC), (i13 - (i14 + getMarginWidth(this.viewA))) - getRealWidthWithMargin(this.viewB));
                min2 = Math.min(getRealWidthWithMargin(this.viewA), (i13 - min) - getRealWidthWithMargin(this.viewB));
            }
            int realWidthWithMargin2 = getRealWidthWithMargin(this.viewB);
            if (this.viewA.getVisibility() != 8) {
                View view = this.viewA;
                setChildSize(view, min2 - getMarginWidth(view));
                i12 = Math.max(this.viewA.getMeasuredHeight(), i12);
            }
            if (this.viewB.getVisibility() != 8) {
                View view2 = this.viewB;
                setChildSize(view2, realWidthWithMargin2 - getMarginWidth(view2));
                i12 = Math.max(this.viewB.getMeasuredHeight(), i12);
            }
            if (this.viewC.getVisibility() != 8) {
                View view3 = this.viewC;
                setChildSize(view3, min - getMarginWidth(view3));
                i12 = Math.max(this.viewC.getMeasuredHeight(), i12);
            }
            setMeasuredDimension(View.MeasureSpec.getSize(i10), View.MeasureSpec.makeMeasureSpec(i12 + getPaddingTop() + getPaddingBottom(), View.MeasureSpec.getMode(i11)));
        }
    }

    private int getMarginHeight(View view) {
        if (view.getVisibility() != 8) {
            return ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).topMargin + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).bottomMargin;
        }
        return 0;
    }

    private int getMarginLeft(View view) {
        if (view.getVisibility() != 8) {
            return ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).leftMargin;
        }
        return 0;
    }

    private int getMarginTop(View view) {
        if (view.getVisibility() != 8) {
            return ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).topMargin;
        }
        return 0;
    }

    private int getMarginWidth(View view) {
        if (view.getVisibility() != 8) {
            return ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).leftMargin + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).rightMargin;
        }
        return 0;
    }

    private int getRealHeight(View view) {
        if (view.getVisibility() != 8) {
            return view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).topMargin + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).bottomMargin;
        }
        return 0;
    }

    private int getRealWidthWithMargin(View view) {
        if (view.getVisibility() != 8) {
            return view.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).leftMargin + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).rightMargin;
        }
        return 0;
    }

    private void init(Context context, AttributeSet attributeSet, int i10) {
        setOrientation(0);
        this.mReddotMarginEndInRightNoAssignment = getContext().getResources().getDimensionPixelSize(C0535e.f12446z0);
        this.mReddotMarginEndInRightHasAssignment = getContext().getResources().getDimensionPixelSize(C0535e.f12444y0);
        this.mMessageLayoutMarginEndInRight = getContext().getResources().getDimensionPixelSize(C0535e.f12369A0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.f12667x, i10, 0);
        this.mDefaultMarginEnd = obtainStyledAttributes.getDimensionPixelOffset(l.f12542B, 0);
        this.mBStickToC = obtainStyledAttributes.getBoolean(l.f12673z, this.mBStickToC);
        this.mAHavePriority = obtainStyledAttributes.getBoolean(l.f12670y, this.mAHavePriority);
        this.mSetMessageLayoutMarginEnd = obtainStyledAttributes.getBoolean(l.f12539A, this.mSetMessageLayoutMarginEnd);
        obtainStyledAttributes.recycle();
        this.mViewLowPriorityMinWidth = context.getResources().getDimensionPixelSize(C0535e.f12395a);
    }

    private boolean isRtlMode() {
        if (getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    private void setChildSize(View view, int i10) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i10, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean setReddotAndMessageLayoutMarginEnd() {
        /*
            r5 = this;
            android.view.View r0 = r5.viewB
            r1 = 1
            if (r0 == 0) goto L41
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L41
            android.view.View r0 = r5.viewB
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r0 = (android.widget.LinearLayout.LayoutParams) r0
            android.view.View r2 = r5.viewC
            if (r2 == 0) goto L30
            int r2 = r2.getVisibility()
            if (r2 == 0) goto L1e
            goto L30
        L1e:
            int r2 = r0.getMarginEnd()
            int r3 = r5.mReddotMarginEndInRightHasAssignment
            if (r2 == r3) goto L41
            r0.setMarginEnd(r3)
            android.view.View r2 = r5.viewB
            r2.setLayoutParams(r0)
        L2e:
            r0 = r1
            goto L42
        L30:
            int r2 = r0.getMarginEnd()
            int r3 = r5.mReddotMarginEndInRightNoAssignment
            if (r2 == r3) goto L41
            r0.setMarginEnd(r3)
            android.view.View r2 = r5.viewB
            r2.setLayoutParams(r0)
            goto L2e
        L41:
            r0 = 0
        L42:
            boolean r2 = r5.mSetMessageLayoutMarginEnd
            if (r2 == 0) goto L97
            android.view.View r2 = r5.viewA
            if (r2 == 0) goto L97
            int r2 = r2.getVisibility()
            if (r2 != 0) goto L97
            android.view.View r2 = r5.viewB
            if (r2 == 0) goto L5a
            int r2 = r2.getVisibility()
            if (r2 == 0) goto L65
        L5a:
            android.view.View r2 = r5.viewC
            if (r2 == 0) goto L7e
            int r2 = r2.getVisibility()
            if (r2 == 0) goto L65
            goto L7e
        L65:
            android.view.View r2 = r5.viewA
            android.view.ViewGroup$LayoutParams r2 = r2.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r2 = (android.widget.LinearLayout.LayoutParams) r2
            int r3 = r2.getMarginEnd()
            int r4 = r5.mMessageLayoutMarginEndInRight
            if (r3 == r4) goto L97
            r2.setMarginEnd(r4)
            android.view.View r5 = r5.viewA
            r5.setLayoutParams(r2)
            goto L98
        L7e:
            android.view.View r2 = r5.viewA
            android.view.ViewGroup$LayoutParams r2 = r2.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r2 = (android.widget.LinearLayout.LayoutParams) r2
            int r3 = r2.getMarginEnd()
            int r4 = r5.mDefaultMarginEnd
            if (r3 == r4) goto L97
            r2.setMarginEnd(r4)
            android.view.View r5 = r5.viewA
            r5.setLayoutParams(r2)
            goto L98
        L97:
            r1 = r0
        L98:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.preference.COUICustomLinearLayoutForPreference.setReddotAndMessageLayoutMarginEnd():boolean");
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int realWidthWithMargin;
        int i14;
        int paddingLeft = getPaddingLeft();
        int measuredWidth = getMeasuredWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int measuredHeight = (getMeasuredHeight() - getPaddingBottom()) - paddingTop;
        int realHeight = ((measuredHeight - getRealHeight(this.viewA)) / 2) + paddingTop;
        int realHeight2 = ((measuredHeight - getRealHeight(this.viewC)) / 2) + paddingTop;
        int realHeight3 = paddingTop + ((measuredHeight - getRealHeight(this.viewB)) / 2);
        if (!isRtlMode()) {
            i14 = measuredWidth - getRealWidthWithMargin(this.viewC);
            if (this.mBStickToC) {
                realWidthWithMargin = i14 - getRealWidthWithMargin(this.viewB);
            } else {
                realWidthWithMargin = getRealWidthWithMargin(this.viewA) + paddingLeft;
            }
        } else {
            int realWidthWithMargin2 = measuredWidth - getRealWidthWithMargin(this.viewA);
            if (this.mBStickToC) {
                realWidthWithMargin = getRealWidthWithMargin(this.viewC) + paddingLeft;
            } else {
                realWidthWithMargin = realWidthWithMargin2 - getRealWidthWithMargin(this.viewB);
            }
            i14 = paddingLeft;
            paddingLeft = realWidthWithMargin2;
        }
        View view = this.viewA;
        view.layout(getMarginLeft(view) + paddingLeft, getMarginTop(this.viewA) + realHeight, ((paddingLeft + getMarginLeft(this.viewA)) + getRealWidthWithMargin(this.viewA)) - getMarginWidth(this.viewA), ((realHeight + getMarginTop(this.viewA)) + getRealHeight(this.viewA)) - getMarginHeight(this.viewA));
        View view2 = this.viewC;
        view2.layout(getMarginLeft(view2) + i14, getMarginTop(this.viewC) + realHeight2, ((i14 + getMarginLeft(this.viewC)) + getRealWidthWithMargin(this.viewC)) - getMarginWidth(this.viewC), ((realHeight2 + getMarginTop(this.viewC)) + getRealHeight(this.viewC)) - getMarginHeight(this.viewC));
        View view3 = this.viewB;
        view3.layout(getMarginLeft(view3) + realWidthWithMargin, getMarginTop(this.viewB) + realHeight3, ((realWidthWithMargin + getMarginLeft(this.viewB)) + getRealWidthWithMargin(this.viewB)) - getMarginWidth(this.viewB), ((realHeight3 + getMarginTop(this.viewB)) + getRealHeight(this.viewB)) - getMarginHeight(this.viewB));
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        this.viewA = getChildAt(0);
        this.viewB = getChildAt(1);
        this.viewC = getChildAt(2);
        if (setReddotAndMessageLayoutMarginEnd()) {
            super.onMeasure(i10, i11);
        }
        customMeasure(i10, i11);
    }

    public COUICustomLinearLayoutForPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public COUICustomLinearLayoutForPreference(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.TAG = "COUICustomLinearLayout";
        this.mBStickToC = true;
        this.mAHavePriority = true;
        this.mSetMessageLayoutMarginEnd = true;
        init(context, attributeSet, i10);
    }
}
