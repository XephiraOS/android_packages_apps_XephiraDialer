package com.customize.contacts.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.android.contacts.ContactsApplication;
import com.android.contacts.V0;

/* loaded from: classes3.dex */
public class AutoWrapLinearLayout extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public int[] f22209a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f22210b;

    /* loaded from: classes3.dex */
    public enum Position {
        START(0),
        MIDDLE(1);

        private int mValue;

        Position(int i10) {
            this.mValue = i10;
        }
    }

    public AutoWrapLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void a(Context context, AttributeSet attributeSet, int i10, int i11) {
        boolean z10 = false;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, V0.f13542x, i10, 0);
        if (obtainStyledAttributes.getInt(0, Position.START.mValue) == Position.MIDDLE.mValue) {
            z10 = true;
        }
        this.f22210b = z10;
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f22209a = new int[getChildCount()];
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        int i16;
        boolean z11;
        boolean z12;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        boolean z13 = ContactsApplication.f13094j;
        int childCount = getChildCount();
        int paddingStart = getPaddingStart();
        int paddingEnd = getPaddingEnd();
        if (z13) {
            i14 = getMeasuredWidth() - paddingStart;
        } else {
            i14 = paddingStart;
        }
        int i28 = 0;
        int i29 = 0;
        int i30 = 0;
        int i31 = 0;
        boolean z14 = false;
        boolean z15 = false;
        while (i28 < childCount) {
            View childAt = getChildAt(i28);
            if (childAt.getVisibility() == 8) {
                i22 = childCount;
                i23 = paddingStart;
                i25 = i28;
            } else {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                int i32 = this.f22209a[i30] + i29;
                if (z13) {
                    int marginStart = i14 - marginLayoutParams.getMarginStart();
                    i19 = (marginStart - measuredWidth) - marginLayoutParams.getMarginEnd();
                    if (i19 < paddingStart) {
                        i30++;
                        int measuredWidth2 = getMeasuredWidth() - paddingStart;
                        int marginEnd = (measuredWidth2 - measuredWidth) - marginLayoutParams.getMarginEnd();
                        if (marginEnd < paddingStart) {
                            i26 = this.f22209a[i30] + i31;
                            marginEnd = paddingStart;
                        } else {
                            i26 = this.f22209a[i30] + i31;
                            if (this.f22210b && i28 == childCount - 1) {
                                z15 = true;
                            } else {
                                z15 = false;
                            }
                        }
                        if (this.f22210b && i28 > 0) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        int i33 = marginEnd;
                        i27 = measuredWidth2;
                        i19 = i33;
                    } else {
                        i31 = i29;
                        i26 = i32;
                        i27 = marginStart;
                    }
                    z11 = z15;
                    z12 = z14;
                    i17 = i26;
                    i18 = i27;
                    i20 = i19;
                } else {
                    int marginStart2 = i14 + marginLayoutParams.getMarginStart();
                    int marginEnd2 = marginStart2 + measuredWidth + marginLayoutParams.getMarginEnd();
                    if (marginEnd2 > getMeasuredWidth() - paddingEnd) {
                        i30++;
                        marginEnd2 = paddingStart + measuredWidth + marginLayoutParams.getMarginEnd();
                        if (marginEnd2 > getMeasuredWidth() - paddingEnd) {
                            marginEnd2 = getMeasuredWidth() - paddingEnd;
                            i21 = this.f22209a[i30] + i31;
                        } else {
                            i21 = this.f22209a[i30] + i31;
                            if (this.f22210b && i28 == childCount - 1) {
                                z15 = true;
                            } else {
                                z15 = false;
                            }
                        }
                        if (this.f22210b && i28 > 0) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        i16 = i21;
                        i15 = paddingStart;
                    } else {
                        i15 = marginStart2;
                        i31 = i29;
                        i16 = i32;
                    }
                    z11 = z15;
                    z12 = z14;
                    i17 = i16;
                    i18 = marginEnd2;
                    i19 = i15;
                    i20 = i18;
                }
                if (z12) {
                    View childAt2 = getChildAt(i28 - 1);
                    i22 = childCount;
                    int measuredWidth3 = (getMeasuredWidth() - childAt2.getWidth()) / 2;
                    i23 = paddingStart;
                    i24 = i20;
                    i25 = i28;
                    childAt2.layout(measuredWidth3, childAt2.getTop(), measuredWidth3 + childAt2.getWidth(), childAt2.getBottom());
                    z12 = false;
                } else {
                    i22 = childCount;
                    i23 = paddingStart;
                    i24 = i20;
                    i25 = i28;
                }
                int i34 = (this.f22209a[i30] - measuredHeight) / 2;
                if (z11) {
                    int measuredWidth4 = (getMeasuredWidth() - childAt.getMeasuredWidth()) / 2;
                    childAt.layout(measuredWidth4, i31 + i34, childAt.getMeasuredWidth() + measuredWidth4, i17 - i34);
                    i14 = i24;
                    i29 = i31;
                    i31 = i17;
                    z14 = z12;
                    z15 = false;
                } else {
                    if (z13) {
                        int i35 = i18 - measuredWidth;
                        if (i35 < paddingEnd) {
                            i35 = paddingEnd;
                        }
                        childAt.layout(i35, i31 + i34, i18, i17 - i34);
                    } else {
                        int i36 = measuredWidth + i19;
                        if (i36 > getMeasuredWidth() - paddingEnd) {
                            i36 = getMeasuredWidth() - paddingEnd;
                        }
                        childAt.layout(i19, i31 + i34, i36, i17 - i34);
                    }
                    i14 = i24;
                    i29 = i31;
                    i31 = i17;
                    z14 = z12;
                    z15 = z11;
                }
            }
            i28 = i25 + 1;
            childCount = i22;
            paddingStart = i23;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int paddingStart;
        int[] iArr = this.f22209a;
        if (iArr == null || iArr.length != getChildCount()) {
            this.f22209a = new int[getChildCount()];
        }
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        int mode2 = View.MeasureSpec.getMode(i10);
        int size2 = View.MeasureSpec.getSize(i10);
        int paddingStart2 = (size2 - getPaddingStart()) - getPaddingEnd();
        int childCount = getChildCount();
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt = getChildAt(i17);
            if (childAt.getVisibility() != 8) {
                int i18 = i12;
                int i19 = i13;
                measureChildWithMargins(childAt, i10, 0, i11, 0);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight() + marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
                int measuredWidth = i16 + childAt.getMeasuredWidth() + marginLayoutParams.getMarginStart() + marginLayoutParams.getMarginEnd();
                if (measuredWidth > paddingStart2) {
                    if (i19 > 0) {
                        i14 += i19;
                        this.f22209a[i15] = i19;
                        i15++;
                    }
                    if (childAt.getMeasuredWidth() + marginLayoutParams.getMarginEnd() > paddingStart2) {
                        childAt.measure(View.MeasureSpec.makeMeasureSpec(paddingStart2, 1073741824), i11);
                        int measuredHeight2 = childAt.getMeasuredHeight();
                        i14 += measuredHeight2;
                        this.f22209a[i15] = measuredHeight2;
                        i15++;
                        i12 = size2;
                        i13 = 0;
                        i16 = 0;
                    } else {
                        childAt.measure(View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredWidth() + marginLayoutParams.getMarginEnd(), 1073741824), i11);
                        i16 = childAt.getMeasuredWidth();
                        i13 = childAt.getMeasuredHeight() + marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
                        i12 = size2;
                    }
                } else {
                    i13 = Math.max(i19, measuredHeight);
                    i16 = measuredWidth;
                    i12 = i18;
                }
            }
        }
        int i20 = i12;
        int i21 = i13;
        if (i21 > 0) {
            i14 += i21;
            this.f22209a[i15] = i21;
        }
        if (i20 == size2) {
            paddingStart = i20;
        } else {
            paddingStart = i16 + getPaddingStart() + getPaddingEnd();
        }
        if (mode2 != 1073741824) {
            size2 = paddingStart;
        }
        if (mode != 1073741824) {
            size = i14;
        }
        setMeasuredDimension(size2, size);
    }

    public AutoWrapLinearLayout(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public AutoWrapLinearLayout(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        a(context, attributeSet, i10, i11);
    }
}
