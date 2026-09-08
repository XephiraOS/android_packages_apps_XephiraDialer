package com.coui.appcompat.reddot;

import X8.f;
import X8.o;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class COUIRedDotFrameLayout extends FrameLayout {
    public static final int CIRCLE_TYPE = 1;
    public static final int RECTANGLE_TYPE = 0;
    String TAG;
    private View mAnchorView;
    private int mAnchorViewShapeType;
    private int mAnchorViewSize;
    private int mCouiDotDiameter;
    private int mCouiDotViewHeight;
    private int mMarginTopAndLeftOfAnchorView;
    private int mMarginTopAndLeftOfReddot;
    private int mRedDotMode;
    private String mRedDotText;
    private COUIHintRedDot mRedDotView;
    private final Runnable mRequestLayoutRunnable;

    public COUIRedDotFrameLayout(Context context) {
        this(context, null);
    }

    private void addRedDot() {
        if (this.mRedDotMode != 0) {
            final COUIHintRedDot cOUIHintRedDot = new COUIHintRedDot(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            cOUIHintRedDot.setLayoutParams(layoutParams);
            layoutParams.gravity = 8388661;
            cOUIHintRedDot.setPointMode(this.mRedDotMode);
            int i10 = this.mRedDotMode;
            if (i10 != 2 && i10 != 5) {
                cOUIHintRedDot.setDotDiameter(this.mCouiDotDiameter);
            } else {
                cOUIHintRedDot.setViewHeight(this.mCouiDotViewHeight);
                cOUIHintRedDot.setPointText(this.mRedDotText);
            }
            post(new Runnable() { // from class: com.coui.appcompat.reddot.b
                @Override // java.lang.Runnable
                public final void run() {
                    COUIRedDotFrameLayout.this.lambda$addRedDot$0(cOUIHintRedDot);
                }
            });
            refresh();
        }
    }

    private void init(AttributeSet attributeSet, int i10) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(f.f4505G1);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(f.f4470B1);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, o.f5378o4, i10, 0);
            this.mRedDotMode = obtainStyledAttributes.getInt(o.f5402r4, 0);
            this.mRedDotText = obtainStyledAttributes.getString(o.f5410s4);
            this.mAnchorViewShapeType = obtainStyledAttributes.getInt(o.f5394q4, 0);
            this.mAnchorViewSize = obtainStyledAttributes.getDimensionPixelSize(o.f5386p4, dimensionPixelSize);
            obtainStyledAttributes.recycle();
        }
        int i11 = this.mRedDotMode;
        if (i11 == 0) {
            return;
        }
        int i12 = this.mAnchorViewSize;
        if (i12 < dimensionPixelSize) {
            if (i11 == 1 || i11 == 4) {
                this.mCouiDotDiameter = getResources().getDimensionPixelSize(f.f4582R1);
            }
            if (this.mAnchorViewShapeType == 0) {
                int i13 = this.mRedDotMode;
                if (i13 != 2 && i13 != 5) {
                    this.mMarginTopAndLeftOfAnchorView = getResources().getDimensionPixelSize(f.f4568P1);
                } else {
                    this.mMarginTopAndLeftOfAnchorView = getResources().getDimensionPixelSize(f.f4575Q1);
                }
            } else {
                int i14 = this.mRedDotMode;
                if (i14 == 1 || i14 == 4) {
                    this.mMarginTopAndLeftOfReddot = getResources().getDimensionPixelSize(f.f4561O1);
                }
            }
        } else if (i12 >= dimensionPixelSize2) {
            if (i11 != 2 && i11 != 5) {
                this.mCouiDotDiameter = getResources().getDimensionPixelSize(f.f4498F1);
            } else {
                this.mCouiDotViewHeight = getResources().getDimensionPixelSize(f.f4838z1);
            }
            if (this.mAnchorViewShapeType == 0) {
                int i15 = this.mRedDotMode;
                if (i15 != 2 && i15 != 5) {
                    this.mMarginTopAndLeftOfAnchorView = getResources().getDimensionPixelSize(f.f4484D1);
                } else {
                    this.mMarginTopAndLeftOfAnchorView = getResources().getDimensionPixelSize(f.f4491E1);
                }
            } else {
                int i16 = this.mRedDotMode;
                if (i16 == 1 || i16 == 4) {
                    this.mMarginTopAndLeftOfReddot = getResources().getDimensionPixelSize(f.f4477C1);
                }
            }
        } else {
            if (i11 == 1 || i11 == 4) {
                this.mCouiDotDiameter = getResources().getDimensionPixelSize(f.f4533K1);
            }
            if (this.mAnchorViewShapeType == 0) {
                int i17 = this.mRedDotMode;
                if (i17 != 2 && i17 != 5) {
                    this.mMarginTopAndLeftOfAnchorView = getResources().getDimensionPixelSize(f.f4519I1);
                } else {
                    this.mMarginTopAndLeftOfAnchorView = getResources().getDimensionPixelSize(f.f4526J1);
                }
            } else {
                int i18 = this.mRedDotMode;
                if (i18 == 1 || i18 == 4) {
                    this.mMarginTopAndLeftOfReddot = getResources().getDimensionPixelSize(f.f4512H1);
                }
            }
        }
        if (this.mRedDotMode == 4) {
            this.mCouiDotDiameter += getResources().getDimensionPixelSize(f.f4540L1);
        }
        if (this.mRedDotMode == 5) {
            this.mCouiDotViewHeight += getResources().getDimensionPixelSize(f.f4540L1);
        }
    }

    private boolean isRtlMode() {
        if (getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addRedDot$0(COUIHintRedDot cOUIHintRedDot) {
        addView(cOUIHintRedDot);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1() {
        requestLayout();
    }

    private void refresh() {
        removeCallbacks(this.mRequestLayoutRunnable);
        post(this.mRequestLayoutRunnable);
    }

    private void setChildView() {
        if (this.mRedDotView == null || this.mAnchorView == null) {
            for (int i10 = 0; i10 < getChildCount(); i10++) {
                View childAt = getChildAt(i10);
                if (childAt instanceof COUIHintRedDot) {
                    this.mRedDotView = (COUIHintRedDot) childAt;
                } else {
                    this.mAnchorView = childAt;
                }
            }
        }
    }

    public COUIHintRedDot getRedDotView() {
        return this.mRedDotView;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (this.mRedDotMode == 0) {
            return;
        }
        View view = this.mAnchorView;
        if (view != null && this.mRedDotView != null) {
            if (!isRtlMode()) {
                View view2 = this.mAnchorView;
                view2.layout(0, this.mMarginTopAndLeftOfAnchorView, view2.getMeasuredWidth(), this.mMarginTopAndLeftOfAnchorView + this.mAnchorView.getMeasuredHeight());
                COUIHintRedDot cOUIHintRedDot = this.mRedDotView;
                int width = getWidth() - this.mRedDotView.getWidth();
                int i14 = this.mMarginTopAndLeftOfReddot;
                int width2 = getWidth();
                int i15 = this.mMarginTopAndLeftOfReddot;
                cOUIHintRedDot.layout(width - i14, i14, width2 - i15, i15 + this.mRedDotView.getHeight());
                return;
            }
            View view3 = this.mAnchorView;
            int i16 = this.mMarginTopAndLeftOfAnchorView;
            view3.layout(i16, i16, view3.getMeasuredWidth() + i16, this.mMarginTopAndLeftOfAnchorView + this.mAnchorView.getMeasuredHeight());
            COUIHintRedDot cOUIHintRedDot2 = this.mRedDotView;
            int i17 = this.mMarginTopAndLeftOfReddot;
            cOUIHintRedDot2.layout(i17, i17, cOUIHintRedDot2.getWidth() + i17, this.mMarginTopAndLeftOfReddot + this.mRedDotView.getHeight());
            return;
        }
        if (view != null && this.mRedDotView == null) {
            view.layout(0, 0, view.getMeasuredWidth(), this.mAnchorView.getMeasuredHeight());
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (this.mRedDotMode == 0) {
            return;
        }
        setChildView();
        View view = this.mAnchorView;
        if (view != null && this.mRedDotView != null) {
            setMeasuredDimension(getMeasuredWidth() + this.mMarginTopAndLeftOfAnchorView, getMeasuredHeight() + this.mMarginTopAndLeftOfAnchorView);
        } else if (view != null && this.mRedDotView == null) {
            setMeasuredDimension(view.getWidth(), this.mAnchorView.getHeight());
        }
    }

    public void removeRedDot() {
        COUIHintRedDot cOUIHintRedDot = this.mRedDotView;
        if (cOUIHintRedDot != null) {
            removeView(cOUIHintRedDot);
            this.mRedDotView = null;
            refresh();
        }
    }

    public void showReddot(int i10, String str) {
        showReddot(i10, str, getResources().getDimensionPixelSize(f.f4505G1), 0);
    }

    public COUIRedDotFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public COUIRedDotFrameLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.TAG = "COUIRedDotFrameLayout";
        this.mRedDotMode = 0;
        this.mAnchorViewShapeType = 0;
        this.mCouiDotViewHeight = getResources().getDimensionPixelSize(f.f4831y1);
        this.mRequestLayoutRunnable = new Runnable() { // from class: com.coui.appcompat.reddot.a
            @Override // java.lang.Runnable
            public final void run() {
                COUIRedDotFrameLayout.this.lambda$new$1();
            }
        };
        init(attributeSet, i10);
        addRedDot();
    }

    public void showReddot(int i10, String str, int i11, int i12) {
        this.mAnchorViewShapeType = i12;
        this.mAnchorViewSize = i11;
        this.mRedDotMode = i10;
        this.mRedDotText = str;
        init(null, 0);
        addRedDot();
    }
}
