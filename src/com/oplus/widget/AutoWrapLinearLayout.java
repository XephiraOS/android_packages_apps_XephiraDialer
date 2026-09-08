package com.oplus.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.oplus.blacklistapp.p;
import com.oplus.blacklistapp.v;

/* loaded from: classes4.dex */
public class AutoWrapLinearLayout extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public int[] f29208a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f29209b;

    /* loaded from: classes4.dex */
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
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, v.f27724a, i10, 0);
        if (obtainStyledAttributes.getInt(v.f27725b, Position.START.mValue) == Position.MIDDLE.mValue) {
            z10 = true;
        }
        this.f29209b = z10;
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f29208a = new int[getChildCount()];
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        boolean z11;
        int i14;
        boolean z12;
        int i15;
        int i16;
        int marginEnd;
        int i17;
        int i18;
        int i19;
        int i20;
        if (getLayoutDirection() == 1) {
            z11 = true;
        } else {
            z11 = false;
        }
        int childCount = getChildCount();
        int paddingStart = getPaddingStart();
        int paddingEnd = getPaddingEnd();
        if (z11) {
            i14 = getMeasuredWidth() - paddingStart;
        } else {
            i14 = paddingStart;
        }
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        boolean z13 = false;
        boolean z14 = false;
        while (i21 < childCount) {
            View childAt = getChildAt(i21);
            if (childAt.getVisibility() == 8) {
                z12 = z11;
                i18 = childCount;
                i19 = paddingStart;
                i20 = paddingEnd;
            } else {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                int i25 = this.f29208a[i23] + i22;
                if (z11) {
                    i15 = i14 - marginLayoutParams.getMarginStart();
                    z12 = z11;
                    i16 = i15 - measuredWidth;
                    if (i16 < paddingStart) {
                        if (childAt.getId() == p.f27409q0) {
                            i15 = paddingStart;
                        } else {
                            i23++;
                            int measuredWidth2 = getMeasuredWidth() - paddingEnd;
                            int i26 = measuredWidth2 - measuredWidth;
                            if (i26 < paddingStart) {
                                i25 = i24 + this.f29208a[i23];
                                i15 = measuredWidth2;
                                i16 = paddingStart;
                            } else {
                                i25 = this.f29208a[i23] + i24;
                                if (this.f29209b && i21 == childCount - 1) {
                                    z14 = true;
                                } else {
                                    z14 = false;
                                }
                                i15 = measuredWidth2;
                                i16 = i26;
                            }
                            i22 = i24;
                        }
                        if (this.f29209b && i21 > 0) {
                            z13 = true;
                        } else {
                            z13 = false;
                        }
                    }
                    marginEnd = i16 - marginLayoutParams.getMarginEnd();
                    i24 = Math.max(i24, i25);
                } else {
                    z12 = z11;
                    int marginStart = i14 + marginLayoutParams.getMarginStart();
                    int i27 = marginStart + measuredWidth;
                    if (i27 > getMeasuredWidth() - paddingEnd) {
                        if (childAt.getId() == p.f27409q0) {
                            i27 = getMeasuredWidth() - paddingEnd;
                            i25 = i25;
                        } else {
                            i23++;
                            i27 = paddingStart + measuredWidth;
                            if (i27 > getMeasuredWidth() - paddingEnd) {
                                i27 = getMeasuredWidth() - paddingEnd;
                                i25 = i24 + this.f29208a[i23];
                            } else {
                                i25 = i24 + this.f29208a[i23];
                                if (this.f29209b && i21 == childCount - 1) {
                                    z14 = true;
                                } else {
                                    z14 = false;
                                }
                            }
                            marginStart = paddingStart;
                            i22 = i24;
                        }
                        if (this.f29209b && i21 > 0) {
                            z13 = true;
                        } else {
                            z13 = false;
                        }
                    } else {
                        i25 = i25;
                    }
                    int i28 = marginStart;
                    i15 = i27;
                    i16 = i28;
                    marginEnd = marginLayoutParams.getMarginEnd() + i15;
                    i24 = Math.max(i24, i25);
                }
                if (z13) {
                    View childAt2 = getChildAt(i21 - 1);
                    i17 = marginEnd;
                    int measuredWidth3 = (getMeasuredWidth() - childAt2.getWidth()) / 2;
                    i18 = childCount;
                    i19 = paddingStart;
                    i20 = paddingEnd;
                    childAt2.layout(measuredWidth3, childAt2.getTop(), measuredWidth3 + childAt2.getWidth(), childAt2.getBottom());
                    z13 = false;
                } else {
                    i17 = marginEnd;
                    i18 = childCount;
                    i19 = paddingStart;
                    i20 = paddingEnd;
                }
                int i29 = (this.f29208a[i23] - measuredHeight) / 2;
                if (z14) {
                    int measuredWidth4 = (getMeasuredWidth() - childAt.getMeasuredWidth()) / 2;
                    childAt.layout(measuredWidth4, i22 + i29, childAt.getMeasuredWidth() + measuredWidth4, i25 - i29);
                    i14 = i17;
                    z14 = false;
                } else {
                    childAt.layout(i16, i22 + i29, i15, i25 - i29);
                    i14 = i17;
                }
            }
            i21++;
            z11 = z12;
            childCount = i18;
            paddingEnd = i20;
            paddingStart = i19;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        int mode2 = View.MeasureSpec.getMode(i10);
        int size2 = View.MeasureSpec.getSize(i10);
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
                measureChildWithMargins(childAt, i10, 0, i11, 0);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                i12 = childAt.getMeasuredHeight() + marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
                int measuredWidth = childAt.getMeasuredWidth() + marginLayoutParams.getMarginStart() + marginLayoutParams.getMarginEnd();
                i14 += measuredWidth;
                if (i14 > size2) {
                    if (childAt.getId() == p.f27409q0) {
                        i13 = size2;
                    } else {
                        i15 += i18;
                        this.f29208a[i16] = i18;
                        i12 *= (int) Math.ceil(measuredWidth / size2);
                        i16++;
                        i13 = size2;
                        i14 = 0;
                    }
                } else {
                    i12 = Math.max(i18, i12);
                }
            }
        }
        int i19 = i12;
        if (i13 != size2) {
            i13 = i14;
        }
        int i20 = i15 + i19;
        this.f29208a[i16] = i19;
        if (mode2 != 1073741824) {
            size2 = i13;
        }
        if (mode != 1073741824) {
            size = i20;
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
