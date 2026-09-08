package com.coui.appcompat.dialog.widget;

import X8.f;
import X8.h;
import X8.o;
import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.coui.appcompat.buttonBar.COUIButtonBarLayout;
import com.coui.appcompat.grid.COUIResponsiveUtils;
import com.coui.appcompat.statement.COUIMaxHeightScrollView;
import com.coui.appcompat.uiutil.UIUtil;

/* loaded from: classes.dex */
public class COUIAlertDialogMaxLinearLayout extends LinearLayout {
    private static final int NO_ID = -1;
    private final String TAG;
    private COUIButtonBarLayout mButtonPanel;
    private View mContentPanelLayout;
    private int mCouiBottomAlertDialogButtonbarMargintop;
    private int mCustomMarginExtra;
    private FrameLayout mCustomPanelLayout;
    private FrameLayout mCustomView;
    private int mDialogContentPanelLayoutMinHeight;
    private int mDialogCustomViewMinHeight;
    private int mDialogLayoutMarginVertical;
    private COUIAlertDialogMessageView mDialogMessage;
    private COUIDialogTitle mDialogTitle;
    private boolean mHasMessageMerge;
    private int mLandscapeMaxHeight;
    private LinearLayout mLinearLayoutTitle;
    private int mMaxHeight;
    private int mMaxWidth;
    private int mMessagePaddingBottomWhenDialogTallDialog;
    private int mMessagePaddingEnd;
    private int mMessagePaddingStart;
    private int mMessagePaddingTopWhenDialogIsTallDialog;
    private int mNeedMinHeight;
    private int mNeedReMeasureLayoutId;
    private boolean mNeedResetButtomBarTopMargin;
    private int mNeedSetPaddingLayoutId;
    private COUIMaxHeightNestedScrollView mScrollViewMessage;
    private COUIMaxHeightScrollView mScrollViewTitle;
    private View mSpacingViewForCustomView;
    private View mSpacingViewForMessage;
    private View mTopPanelLayout;

    /* loaded from: classes.dex */
    public interface OnSizeChangeListener {
        void onSizeChange(int i10, int i11, int i12, int i13);
    }

    public COUIAlertDialogMaxLinearLayout(Context context) {
        super(context);
        this.TAG = "DialogMaxLinearLayout";
        this.mNeedReMeasureLayoutId = -1;
        this.mNeedSetPaddingLayoutId = -1;
        this.mCustomMarginExtra = 5;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x005d, code lost:
    
        if (r1 == false) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void setMarginTop() {
        /*
            r9 = this;
            android.content.Context r0 = r9.getContext()
            android.app.Activity r0 = com.coui.appcompat.uiutil.UIUtil.contextToActivity(r0)
            r1 = 1
            if (r0 == 0) goto L60
            android.view.Window r2 = r0.getWindow()
            android.view.View r2 = r2.getDecorView()
            android.view.WindowInsets r2 = r2.getRootWindowInsets()
            r3 = 0
            if (r2 == 0) goto L36
            android.view.Window r2 = r0.getWindow()
            android.view.View r2 = r2.getDecorView()
            android.view.WindowInsets r2 = r2.getRootWindowInsets()
            int r4 = androidx.core.view.X.k.e()
            android.graphics.Insets r2 = r2.getInsets(r4)
            if (r2 == 0) goto L36
            int r2 = r2.top
            if (r2 != 0) goto L36
            r2 = r1
            goto L37
        L36:
            r2 = r3
        L37:
            android.view.Window r4 = r0.getWindow()
            android.view.WindowManager$LayoutParams r4 = r4.getAttributes()
            int r4 = r4.flags
            r5 = 1024(0x400, float:1.435E-42)
            r4 = r4 & r5
            if (r4 != r5) goto L48
            r4 = r1
            goto L49
        L48:
            r4 = r3
        L49:
            android.view.Window r0 = r0.getWindow()
            android.view.View r0 = r0.getDecorView()
            int r0 = r0.getSystemUiVisibility()
            r5 = 4
            r0 = r0 & r5
            if (r0 != r5) goto L5a
            goto L5b
        L5a:
            r1 = r3
        L5b:
            if (r4 != 0) goto L7e
            if (r1 == 0) goto L7c
            goto L7e
        L60:
            android.view.View r0 = r9.getRootView()
            android.view.WindowInsets r0 = r0.getRootWindowInsets()
            if (r0 == 0) goto Lc0
            android.view.View r0 = r9.getRootView()
            android.view.WindowInsets r0 = r0.getRootWindowInsets()
            int r2 = androidx.core.view.X.k.e()
            boolean r0 = r0.isVisible(r2)
            r2 = r0 ^ 1
        L7c:
            if (r2 == 0) goto Lc0
        L7e:
            android.graphics.drawable.Drawable r0 = r9.getBackground()
            boolean r0 = r0 instanceof android.graphics.drawable.InsetDrawable
            if (r0 == 0) goto Lc0
            android.graphics.drawable.Drawable r0 = r9.getBackground()
            android.graphics.drawable.InsetDrawable r0 = (android.graphics.drawable.InsetDrawable) r0
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>()
            r0.getPadding(r1)
            int r2 = r1.top
            if (r2 <= 0) goto La0
            java.lang.String r9 = "DialogMaxLinearLayout"
            java.lang.String r0 = "The top spacing has already been set and does not need to be reset."
            com.coui.appcompat.log.COUILog.d(r9, r0)
            return
        La0:
            int r2 = r1.bottom
            r1.top = r2
            android.graphics.drawable.Drawable r4 = r0.getDrawable()
            android.graphics.drawable.InsetDrawable r0 = new android.graphics.drawable.InsetDrawable
            int r5 = r1.left
            int r6 = r1.top
            int r7 = r1.right
            int r8 = r1.bottom
            r3 = r0
            r3.<init>(r4, r5, r6, r7, r8)
            r9.setBackground(r0)
            int r0 = r1.top
            int r1 = r1.bottom
            int r0 = r0 + r1
            r9.mDialogLayoutMarginVertical = r0
        Lc0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.dialog.widget.COUIAlertDialogMaxLinearLayout.setMarginTop():void");
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        setMarginTop();
        super.onAttachedToWindow();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int i12;
        int i13;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        View findViewById;
        boolean z14;
        boolean z15;
        COUIAlertDialogMessageView cOUIAlertDialogMessageView;
        FrameLayout frameLayout;
        super.onMeasure(i10, i11);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int i14 = this.mMaxWidth;
        if (i14 != 0 && measuredWidth > i14) {
            i10 = View.MeasureSpec.makeMeasureSpec(i14, 1073741824);
            super.onMeasure(i10, i11);
            measuredHeight = getMeasuredHeight();
        }
        int i15 = this.mMaxHeight;
        if (measuredHeight > i15 && i15 > 0) {
            i11 = View.MeasureSpec.makeMeasureSpec(i15, 1073741824);
            super.onMeasure(i10, i11);
            measuredHeight = getMeasuredHeight();
        }
        if (this.mScrollViewTitle == null) {
            try {
                this.mTopPanelLayout = findViewById(h.f4887G0);
                this.mCustomPanelLayout = (FrameLayout) findViewById(h.f4892J);
                this.mCustomView = (FrameLayout) findViewById(h.f4886G);
                this.mContentPanelLayout = findViewById(h.f4948t);
                this.mDialogTitle = (COUIDialogTitle) findViewById(h.f4910a);
                this.mDialogMessage = (COUIAlertDialogMessageView) findViewById(R.id.message);
                this.mScrollViewMessage = (COUIMaxHeightNestedScrollView) findViewById(h.f4935m0);
                this.mScrollViewTitle = (COUIMaxHeightScrollView) findViewById(h.f4912b);
                this.mButtonPanel = (COUIButtonBarLayout) findViewById(h.f4930k);
            } catch (Exception e10) {
                Log.e("DialogMaxLinearLayout", "Failed to get type conversion. message e:" + e10.getMessage());
                this.mHasMessageMerge = false;
                return;
            }
        }
        COUIAlertDialogMessageView cOUIAlertDialogMessageView2 = this.mDialogMessage;
        if (cOUIAlertDialogMessageView2 instanceof TextView) {
            i12 = cOUIAlertDialogMessageView2.getLineCount();
            i13 = this.mDialogTitle.getLineCount();
        } else {
            i12 = 0;
            i13 = 0;
        }
        int i16 = measuredHeight - this.mDialogLayoutMarginVertical;
        if (i16 < this.mNeedMinHeight && UIUtil.getScreenHeightMetrics(getContext()) > this.mNeedMinHeight) {
            int i17 = this.mNeedReMeasureLayoutId;
            if (i17 != -1) {
                COUIMaxHeightScrollView cOUIMaxHeightScrollView = (COUIMaxHeightScrollView) findViewById(i17);
                int measuredHeight2 = cOUIMaxHeightScrollView.getMeasuredHeight() + (this.mNeedMinHeight - i16);
                if (cOUIMaxHeightScrollView.getMinHeight() != measuredHeight2) {
                    cOUIMaxHeightScrollView.setMinHeight(measuredHeight2);
                    super.onMeasure(i10, i11);
                }
            }
        } else if (this.mNeedSetPaddingLayoutId != -1) {
            if (i13 > 1) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (i12 > 1) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (this.mButtonPanel.getButtonCount() > 1 && this.mButtonPanel.getOrientation() == 1) {
                z12 = true;
            } else {
                z12 = false;
            }
            FrameLayout frameLayout2 = this.mCustomView;
            if (frameLayout2 != null && frameLayout2.getMeasuredHeight() > this.mDialogCustomViewMinHeight) {
                z13 = true;
            } else {
                z13 = false;
            }
            if ((z10 || z11 || z12 || z13) && (findViewById = findViewById(this.mNeedSetPaddingLayoutId)) != null && findViewById.getPaddingTop() != this.mMessagePaddingTopWhenDialogIsTallDialog) {
                findViewById.setPadding(findViewById.getPaddingStart(), this.mMessagePaddingTopWhenDialogIsTallDialog, findViewById.getPaddingEnd(), this.mMessagePaddingBottomWhenDialogTallDialog);
                super.onMeasure(i10, i11);
            }
        }
        COUIAlertDialogMessageView cOUIAlertDialogMessageView3 = this.mDialogMessage;
        if (cOUIAlertDialogMessageView3 != null && !TextUtils.isEmpty(cOUIAlertDialogMessageView3.getText())) {
            z14 = true;
        } else {
            z14 = false;
        }
        FrameLayout frameLayout3 = this.mCustomView;
        if (frameLayout3 != null && frameLayout3.getChildCount() > 0) {
            z15 = true;
        } else {
            z15 = false;
        }
        COUIDialogTitle cOUIDialogTitle = this.mDialogTitle;
        if (cOUIDialogTitle != null && !TextUtils.isEmpty(cOUIDialogTitle.getText())) {
            if ((z14 || z15) && this.mHasMessageMerge) {
                if (this.mLinearLayoutTitle != null && (((cOUIAlertDialogMessageView = this.mDialogMessage) != null && cOUIAlertDialogMessageView.getParent() == this.mLinearLayoutTitle) || ((frameLayout = this.mCustomView) != null && frameLayout.getParent() == this.mLinearLayoutTitle))) {
                    COUIAlertDialogMessageView cOUIAlertDialogMessageView4 = this.mDialogMessage;
                    if (cOUIAlertDialogMessageView4 != null) {
                        ViewParent parent = cOUIAlertDialogMessageView4.getParent();
                        LinearLayout linearLayout = this.mLinearLayoutTitle;
                        if (parent == linearLayout) {
                            linearLayout.removeView(this.mDialogMessage);
                            View view = this.mSpacingViewForMessage;
                            if (view != null) {
                                this.mLinearLayoutTitle.removeView(view);
                            }
                            View view2 = this.mSpacingViewForCustomView;
                            if (view2 != null) {
                                this.mLinearLayoutTitle.removeView(view2);
                            }
                            COUIAlertDialogMessageView cOUIAlertDialogMessageView5 = this.mDialogMessage;
                            cOUIAlertDialogMessageView5.setPaddingRelative(this.mMessagePaddingStart, cOUIAlertDialogMessageView5.getPaddingTop(), this.mMessagePaddingEnd, this.mDialogMessage.getPaddingBottom());
                            this.mScrollViewMessage.addView(this.mDialogMessage);
                        }
                    }
                    FrameLayout frameLayout4 = this.mCustomView;
                    if (frameLayout4 != null) {
                        ViewParent parent2 = frameLayout4.getParent();
                        LinearLayout linearLayout2 = this.mLinearLayoutTitle;
                        if (parent2 == linearLayout2) {
                            linearLayout2.removeView(this.mCustomView);
                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mCustomView.getLayoutParams();
                            marginLayoutParams.setMarginStart(marginLayoutParams.getMarginStart() + (this.mMessagePaddingStart - this.mCustomMarginExtra));
                            this.mCustomPanelLayout.addView(this.mCustomView);
                        }
                    }
                    if (this.mNeedResetButtomBarTopMargin) {
                        COUIButtonBarLayout cOUIButtonBarLayout = this.mButtonPanel;
                        if ((cOUIButtonBarLayout instanceof COUIButtonBarLayout) && (cOUIButtonBarLayout.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                            this.mButtonPanel.setTopMarginFlag(true);
                        }
                    }
                    super.onMeasure(i10, i11);
                }
                if (COUIResponsiveUtils.isSmallScreenDp(UIUtil.px2dip(getContext(), UIUtil.getScreenHeightMetrics(getContext()))) && ((z14 && this.mContentPanelLayout.getMeasuredHeight() < this.mDialogContentPanelLayoutMinHeight) || (z15 && this.mCustomView.getMeasuredHeight() < this.mDialogCustomViewMinHeight))) {
                    if (this.mLinearLayoutTitle == null) {
                        this.mLinearLayoutTitle = new LinearLayout(getContext());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams.gravity = 48;
                        this.mLinearLayoutTitle.setLayoutParams(layoutParams);
                        this.mLinearLayoutTitle.setOrientation(1);
                        this.mScrollViewTitle.removeAllViews();
                        this.mScrollViewTitle.addView(this.mLinearLayoutTitle);
                        this.mLinearLayoutTitle.addView(this.mDialogTitle);
                        if (z14) {
                            this.mSpacingViewForMessage = new View(getContext());
                            this.mSpacingViewForMessage.setLayoutParams(new LinearLayout.LayoutParams(-1, this.mMessagePaddingTopWhenDialogIsTallDialog));
                        }
                        if (z15) {
                            this.mSpacingViewForCustomView = new View(getContext());
                            this.mSpacingViewForCustomView.setLayoutParams(new LinearLayout.LayoutParams(-1, this.mMessagePaddingTopWhenDialogIsTallDialog));
                        }
                    }
                    if (z14 && this.mDialogMessage.getParent() != this.mLinearLayoutTitle) {
                        COUIAlertDialogMessageView cOUIAlertDialogMessageView6 = this.mDialogMessage;
                        cOUIAlertDialogMessageView6.setPaddingRelative(0, cOUIAlertDialogMessageView6.getPaddingTop(), 0, this.mDialogMessage.getPaddingBottom());
                        this.mScrollViewMessage.removeView(this.mDialogMessage);
                        this.mLinearLayoutTitle.addView(this.mSpacingViewForMessage);
                        this.mLinearLayoutTitle.addView(this.mDialogMessage);
                    }
                    if (z15 && this.mCustomView.getParent() != this.mLinearLayoutTitle) {
                        this.mCustomPanelLayout.removeView(this.mCustomView);
                        LinearLayoutCompat.LayoutParams layoutParams2 = new LinearLayoutCompat.LayoutParams(-2, -2);
                        layoutParams2.setMarginStart(layoutParams2.getMarginStart() - (this.mMessagePaddingStart - this.mCustomMarginExtra));
                        this.mLinearLayoutTitle.addView(this.mSpacingViewForCustomView);
                        this.mLinearLayoutTitle.addView(this.mCustomView, layoutParams2);
                    }
                    COUIButtonBarLayout cOUIButtonBarLayout2 = this.mButtonPanel;
                    if ((cOUIButtonBarLayout2 instanceof COUIButtonBarLayout) && (cOUIButtonBarLayout2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mButtonPanel.getLayoutParams();
                        if (marginLayoutParams2.topMargin == this.mCouiBottomAlertDialogButtonbarMargintop) {
                            marginLayoutParams2.topMargin = 0;
                            this.mButtonPanel.setLayoutParams(marginLayoutParams2);
                            this.mNeedResetButtomBarTopMargin = true;
                            this.mButtonPanel.setTopMarginFlag(false);
                        }
                    }
                    super.onMeasure(i10, i11);
                }
                COUIButtonBarLayout cOUIButtonBarLayout3 = this.mButtonPanel;
                if (cOUIButtonBarLayout3 instanceof COUIButtonBarLayout) {
                    COUIMaxHeightNestedScrollView cOUIMaxHeightNestedScrollView = (COUIMaxHeightNestedScrollView) cOUIButtonBarLayout3.getParent();
                    cOUIMaxHeightNestedScrollView.setMaxHeight(-1);
                    super.onMeasure(i10, i11);
                    int measuredHeight3 = this.mTopPanelLayout.getMeasuredHeight() + this.mContentPanelLayout.getMeasuredHeight() + this.mCustomPanelLayout.getMeasuredHeight() + cOUIMaxHeightNestedScrollView.getMeasuredHeight() + this.mDialogLayoutMarginVertical;
                    if (measuredHeight3 > getMeasuredHeight()) {
                        cOUIMaxHeightNestedScrollView.setMaxHeight(getMeasuredHeight() - (measuredHeight3 - cOUIMaxHeightNestedScrollView.getMeasuredHeight()));
                        super.onMeasure(i10, i11);
                    }
                }
            }
        }
    }

    public void setHasMessageMerge(boolean z10) {
        this.mHasMessageMerge = z10;
    }

    public void setMaxHeight(int i10) {
        this.mMaxHeight = i10;
    }

    public void setMaxWidth(int i10) {
        this.mMaxWidth = i10;
    }

    public void setNeedMinHeight(int i10) {
        this.mNeedMinHeight = i10;
    }

    public void setNeedReMeasureLayoutId(int i10) {
        this.mNeedReMeasureLayoutId = i10;
    }

    public void setNeedSetPaddingLayoutId(int i10) {
        this.mNeedSetPaddingLayoutId = i10;
    }

    public COUIAlertDialogMaxLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TAG = "DialogMaxLinearLayout";
        this.mNeedReMeasureLayoutId = -1;
        this.mNeedSetPaddingLayoutId = -1;
        this.mCustomMarginExtra = 5;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o.f5381p);
        this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(o.f5397r, 0);
        this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(o.f5389q, 0);
        obtainStyledAttributes.recycle();
        this.mMessagePaddingTopWhenDialogIsTallDialog = getResources().getDimensionPixelSize(f.f4503G);
        this.mMessagePaddingBottomWhenDialogTallDialog = getResources().getDimensionPixelSize(f.f4489E);
        this.mDialogLayoutMarginVertical = getResources().getDimensionPixelSize(f.f4749n1);
        this.mDialogContentPanelLayoutMinHeight = getResources().getDimensionPixelSize(f.f4733l1);
        this.mDialogCustomViewMinHeight = getResources().getDimensionPixelSize(f.f4741m1);
        Resources resources = getResources();
        int i10 = f.f4482D;
        this.mMessagePaddingStart = resources.getDimensionPixelSize(i10);
        this.mMessagePaddingEnd = getResources().getDimensionPixelSize(i10);
        this.mCouiBottomAlertDialogButtonbarMargintop = getResources().getDimensionPixelSize(f.f4636Z);
    }
}
