package com.coui.appcompat.autocomplete;

import A.h;
import X8.a;
import X8.c;
import X8.g;
import X8.i;
import Z8.e;
import Z8.f;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.coui.appcompat.autocomplete.COUIAutoCompleteHelper;
import com.coui.appcompat.autocomplete.COUIAutoCompletePopupAdapter;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import com.coui.appcompat.grid.COUIResponsiveUtils;
import com.coui.appcompat.list.COUIForegroundListView;
import com.coui.appcompat.log.COUILog;
import com.coui.appcompat.poplist.COUIPopupWindow;
import com.coui.appcompat.uiutil.ShadowUtils;
import com.coui.appcompat.uiutil.UIUtil;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class COUIAutoCompletePopupWindow extends COUIPopupWindow implements View.OnLayoutChangeListener {
    private static final float ONE_FLOAT = 1.0f;
    private static final String TAG = "COUIAutoPopup";
    private static final float ZERO_FLOAT = 0.0f;
    private final float BLUR_R_DP;
    private int COLOR;
    private final float ELEVATION_DP;
    private final float LIGHT_R_DP;
    private final float LIGHT_Y_DP;
    private final float LIGHT_Z_DP;
    private BaseAdapter mAdapter;
    private int mAlphaAnimationDuration;
    private Interpolator mAlphaAnimationInterpolator;
    private View mAnchor;
    private Rect mAnchorRect;
    private Animation.AnimationListener mAnimationListener;
    private Rect mBackgroundPaddingRect;
    private int mBottomCanUseArea;
    private ViewGroup mContentView;
    private Context mContext;
    private Point mCoordinate;
    private BaseAdapter mCustomAdapter;
    private Rect mDecorViewRect;
    private COUIAutoCompletePopupAdapter mDefaultAdapter;
    private int mExtraHeight;
    private int mExtraWidth;
    private boolean mHasCheckedTopOfAnchorView;
    private boolean mIsBelowAnchor;
    private boolean mIsDismissing;
    private boolean mIsSetFromItemClick;
    private final AdapterView.OnItemClickListener mItemClickListener;
    private List<COUIAutoCompleteHelper.PopupListData> mItemList;
    private ListView mListView;
    private ListView mListViewUsedToMeasure;
    private int mMaxLines;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private Rect mParentRectOnScreen;
    private float mPivotX;
    private float mPivotY;
    private int mPopupHeight;
    private int mPopupListWindowMinWidth;
    private int[] mPopupWindowOffset;
    private int mScaleAnimationDuration;
    private Interpolator mScaleAnimationInterpolator;
    private int mShadowBottom;
    private int mShadowTop;
    private int[] mTempLocation;
    private int mTopCanUseArea;
    private int[] mWindowLocationOnScreen;
    private int shadowOffset;

    public COUIAutoCompletePopupWindow(Context context) {
        super(context);
        this.mTempLocation = new int[2];
        this.mWindowLocationOnScreen = new int[2];
        this.mPopupWindowOffset = new int[4];
        this.mIsBelowAnchor = false;
        this.mExtraWidth = 0;
        this.mExtraHeight = 0;
        this.mShadowBottom = 0;
        this.mShadowTop = 0;
        this.mCoordinate = new Point();
        this.mTopCanUseArea = 0;
        this.mBottomCanUseArea = 0;
        this.mIsSetFromItemClick = false;
        this.shadowOffset = 0;
        this.ELEVATION_DP = 37.0f;
        this.LIGHT_Y_DP = -116.666664f;
        this.LIGHT_Z_DP = 1166.6666f;
        this.LIGHT_R_DP = 800.0f;
        this.BLUR_R_DP = 23.0f;
        this.COLOR = 35;
        this.mAnimationListener = new Animation.AnimationListener() { // from class: com.coui.appcompat.autocomplete.COUIAutoCompletePopupWindow.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                COUIAutoCompletePopupWindow.this.superDismiss();
                COUIAutoCompletePopupWindow.this.mIsDismissing = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                COUIAutoCompletePopupWindow.this.mIsDismissing = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.mItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.coui.appcompat.autocomplete.COUIAutoCompletePopupWindow.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
                COUIAutoCompletePopupWindow.this.mOnItemClickListener.onItemClick(adapterView, view, i10, j10);
                if (!COUIAutoCompletePopupWindow.this.mItemList.isEmpty()) {
                    COUIAutoCompletePopupWindow.this.mItemList.size();
                }
            }
        };
        this.mMaxLines = 0;
        this.mContext = context;
        this.mItemList = new ArrayList();
        ListView listView = new ListView(context);
        this.mListViewUsedToMeasure = listView;
        listView.setDivider(null);
        this.mListViewUsedToMeasure.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.mContentView = createContentView(context);
        setBackgroundDrawable(new ColorDrawable(0));
        setExitTransition(null);
        setEnterTransition(null);
        Resources resources = context.getResources();
        int i10 = i.f4962a;
        this.mScaleAnimationDuration = resources.getInteger(i10);
        this.mAlphaAnimationDuration = context.getResources().getInteger(i10);
        int i11 = a.f4325e;
        this.mScaleAnimationInterpolator = AnimationUtils.loadInterpolator(context, i11);
        this.mAlphaAnimationInterpolator = AnimationUtils.loadInterpolator(context, i11);
        setAnimationStyle(0);
        setInputMethodMode(2);
    }

    private void animateEnter() {
        if (isCustomerAnimation()) {
            return;
        }
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.9f, 1.0f, 0.9f, 1.0f, 1, this.mPivotX, 1, this.mPivotY);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        scaleAnimation.setDuration(this.mScaleAnimationDuration);
        scaleAnimation.setInterpolator(this.mScaleAnimationInterpolator);
        alphaAnimation.setDuration(this.mAlphaAnimationDuration);
        alphaAnimation.setInterpolator(this.mAlphaAnimationInterpolator);
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation);
        this.mContentView.startAnimation(animationSet);
    }

    private void animateExit() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(this.mAlphaAnimationDuration);
        alphaAnimation.setInterpolator(this.mAlphaAnimationInterpolator);
        alphaAnimation.setAnimationListener(this.mAnimationListener);
        this.mContentView.startAnimation(alphaAnimation);
    }

    private void calculatePivot() {
        Rect rect = this.mAnchorRect;
        int i10 = rect.top;
        if ((rect.centerX() - this.mWindowLocationOnScreen[0]) - this.mCoordinate.x >= getWidth()) {
            this.mPivotX = 1.0f;
        } else {
            this.mPivotX = ((this.mAnchorRect.centerX() - this.mWindowLocationOnScreen[0]) - this.mCoordinate.x) / getWidth();
        }
        if (this.mCoordinate.y >= i10 - this.mWindowLocationOnScreen[1]) {
            this.mPivotY = 0.0f;
            return;
        }
        if (!ifSetOffset()) {
            if (this.mCoordinate.y + getHeight() > (this.mAnchor.getMeasuredHeight() + i10) - this.mWindowLocationOnScreen[1]) {
                this.mPivotY = ((i10 + (this.mAnchor.getMeasuredHeight() / 2)) - this.mCoordinate.y) / getHeight();
                return;
            } else {
                this.mPivotY = 1.0f;
                return;
            }
        }
        this.mPivotY = ((this.mAnchor.getTop() - this.mPopupWindowOffset[1]) - this.mCoordinate.y) / getHeight();
    }

    private void configListView() {
        BaseAdapter baseAdapter = this.mCustomAdapter;
        if (baseAdapter == null) {
            this.mAdapter = this.mDefaultAdapter;
        } else {
            this.mAdapter = baseAdapter;
        }
        this.mListView.setAdapter((ListAdapter) this.mAdapter);
        if (this.mOnItemClickListener != null) {
            this.mListView.setOnItemClickListener(this.mItemClickListener);
        }
    }

    private void configRect(View view) {
        this.mDecorViewRect = new Rect();
        this.mAnchorRect = new Rect();
        this.mParentRectOnScreen = new Rect();
        this.mAnchor = view;
        view.getRootView().removeOnLayoutChangeListener(this);
        this.mAnchor.getRootView().addOnLayoutChangeListener(this);
        this.mAnchor.getWindowVisibleDisplayFrame(this.mDecorViewRect);
        this.mAnchor.getGlobalVisibleRect(this.mAnchorRect);
        this.mAnchor.getRootView().getGlobalVisibleRect(this.mParentRectOnScreen);
        Rect rect = this.mAnchorRect;
        int i10 = rect.left;
        int[] iArr = this.mPopupWindowOffset;
        boolean z10 = false;
        rect.left = i10 - iArr[0];
        rect.top -= iArr[1];
        rect.right += iArr[2];
        rect.bottom += iArr[3];
        this.mAnchor.getRootView().getLocationOnScreen(this.mTempLocation);
        Rect rect2 = this.mAnchorRect;
        int[] iArr2 = this.mTempLocation;
        rect2.offset(iArr2[0], iArr2[1]);
        Rect rect3 = this.mParentRectOnScreen;
        int[] iArr3 = this.mTempLocation;
        rect3.offset(iArr3[0], iArr3[1]);
        Rect rect4 = this.mDecorViewRect;
        rect4.left = Math.max(rect4.left, this.mParentRectOnScreen.left);
        Rect rect5 = this.mDecorViewRect;
        rect5.top = Math.max(rect5.top, this.mParentRectOnScreen.top);
        Rect rect6 = this.mDecorViewRect;
        rect6.right = Math.min(rect6.right, this.mParentRectOnScreen.right);
        Rect rect7 = this.mDecorViewRect;
        rect7.bottom = Math.min(rect7.bottom, this.mParentRectOnScreen.bottom);
        this.mAnchor.getRootView().getLocationOnScreen(this.mTempLocation);
        int[] iArr4 = this.mTempLocation;
        int i11 = iArr4[0];
        int i12 = iArr4[1];
        this.mAnchor.getRootView().getLocationInWindow(this.mTempLocation);
        int[] iArr5 = this.mTempLocation;
        int i13 = iArr5[0];
        int i14 = iArr5[1];
        int[] iArr6 = this.mWindowLocationOnScreen;
        iArr6[0] = i11 - i13;
        iArr6[1] = i12 - i14;
        if (this.mAnchor.getContext() instanceof Activity) {
            this.mTopCanUseArea = this.mAnchorRect.top - this.mDecorViewRect.top;
        } else {
            this.mTopCanUseArea = this.mAnchorRect.top - UIUtil.getStatusBarHeight(this.mAnchor.getContext());
        }
        int i15 = this.mDecorViewRect.bottom - this.mAnchorRect.bottom;
        this.mBottomCanUseArea = i15;
        if (i15 >= this.mTopCanUseArea) {
            z10 = true;
        }
        this.mIsBelowAnchor = z10;
    }

    private ViewGroup createContentView(Context context) {
        int dimensionPixelOffset;
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(context).inflate(f.f6164F, (ViewGroup) null);
        COUIDarkModeUtil.setForceDarkAllow(frameLayout, false);
        this.mListView = (ListView) frameLayout.findViewById(e.f6091K);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{c.f4368a});
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        if (drawable == null) {
            drawable = h.f(context.getResources(), g.f4849b, context.getTheme());
        }
        this.mShadowBottom = context.getResources().getDimensionPixelOffset(Z8.c.f6020h);
        this.mShadowTop = context.getResources().getDimensionPixelOffset(X8.f.f4679e3);
        if (COUIResponsiveUtils.isSmallScreenDp(context.getResources().getConfiguration().screenWidthDp)) {
            dimensionPixelOffset = context.getResources().getDimensionPixelOffset(X8.f.f4615W);
        } else {
            dimensionPixelOffset = context.getResources().getDimensionPixelOffset(X8.f.f4608V);
        }
        this.shadowOffset = context.getResources().getDimensionPixelOffset(Z8.c.f6022i);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mListView.getLayoutParams();
        layoutParams.setMarginStart(dimensionPixelOffset);
        layoutParams.setMarginEnd(dimensionPixelOffset);
        layoutParams.topMargin = this.mShadowTop;
        layoutParams.bottomMargin = this.mShadowBottom;
        this.mListView.setLayoutParams(layoutParams);
        this.mBackgroundPaddingRect = new Rect(dimensionPixelOffset, this.mShadowTop, dimensionPixelOffset, this.mShadowBottom);
        this.mListView.setBackground(drawable);
        ((COUIForegroundListView) this.mListView).setRadius(COUIContextUtil.getAttrDimens(this.mContext, c.f4373c0));
        if (ShadowUtils.checkOPlusViewElevationSDK()) {
            ShadowUtils.setElevationToViewFromOPlusView(this.mListView, UIUtil.dip2px(context, 37.0f), Color.argb(this.COLOR, 0, 0, 0), UIUtil.dip2px(context, -116.666664f), UIUtil.dip2px(context, 1166.6666f), UIUtil.dip2px(context, 800.0f), UIUtil.dip2px(context, 23.0f));
        } else {
            ShadowUtils.setElevationToViewFromLower(this.mListView, context.getResources().getDimensionPixelOffset(X8.f.f4558N5), context.getResources().getColor(X8.e.f4458x), context.getResources().getDimensionPixelOffset(X8.f.f4530J5));
        }
        obtainStyledAttributes.recycle();
        return frameLayout;
    }

    private int getMaxAvailableHeight() {
        Rect rect = this.mDecorViewRect;
        return rect.bottom - rect.top;
    }

    private int getPopupWindowMaxWidth() {
        Rect rect = this.mDecorViewRect;
        int i10 = rect.right - rect.left;
        Rect rect2 = this.mBackgroundPaddingRect;
        return (i10 - rect2.left) - rect2.right;
    }

    private int getStatusBarHeight() {
        Rect rect = this.mDecorViewRect;
        if (rect == null) {
            return 0;
        }
        return rect.top - this.mWindowLocationOnScreen[1];
    }

    private boolean ifSetOffset() {
        int[] iArr = this.mPopupWindowOffset;
        if (iArr[0] == 0 && iArr[1] == 0 && iArr[2] == 0 && iArr[3] == 0) {
            return false;
        }
        return true;
    }

    private boolean isCustomerAnimation() {
        if (getAnimationStyle() != 0) {
            return true;
        }
        return false;
    }

    private void setShowLocation(int i10, int i11) {
        this.mCoordinate.set(i10, i11);
    }

    private void showAsMeasure() {
        int height;
        this.mHasCheckedTopOfAnchorView = false;
        int centerX = this.mAnchorRect.centerX() - (getWidth() / 2);
        if (this.mIsBelowAnchor) {
            height = (this.mAnchorRect.bottom - this.mWindowLocationOnScreen[1]) - this.shadowOffset;
        } else {
            height = ((this.mAnchorRect.top - getHeight()) - this.mWindowLocationOnScreen[1]) + this.shadowOffset;
        }
        if (this.mWindowLocationOnScreen[1] == this.mDecorViewRect.top) {
            int max = Math.max(UIUtil.getStatusBarHeight(this.mAnchor.getContext()) - this.mDecorViewRect.top, height);
            setHeight(getHeight() - (max - height));
            height = max;
        }
        try {
            showAtLocation(this.mAnchor, 0, centerX, height);
        } catch (Exception e10) {
            Log.e(TAG, "super.showAtLocation fail,e:" + e10.getMessage());
        }
    }

    public void configPopupValue(View view) {
        if (view != null) {
            if (this.mDefaultAdapter != null || this.mCustomAdapter != null) {
                configListView();
                configRect(view);
                measurePopupWindow();
                setContentView(this.mContentView);
            }
        }
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        if (!this.mIsDismissing && !isCustomerAnimation()) {
            animateExit();
            return;
        }
        View view = this.mAnchor;
        if (view != null) {
            view.getRootView().removeOnLayoutChangeListener(this);
        }
        superDismiss();
    }

    public ListAdapter getAdapter() {
        ListView listView = this.mListView;
        if (listView != null) {
            return listView.getAdapter();
        }
        return null;
    }

    public View getAnchorView() {
        return this.mAnchor;
    }

    public boolean getIsSetFromItemClick() {
        return this.mIsSetFromItemClick;
    }

    public List<COUIAutoCompleteHelper.PopupListData> getItemList() {
        return this.mItemList;
    }

    public ListView getListView() {
        return this.mListView;
    }

    public int getWindowOffsetBottom() {
        return this.mPopupWindowOffset[3];
    }

    public int getWindowOffsetLeft() {
        return this.mPopupWindowOffset[0];
    }

    public int getWindowOffsetRight() {
        return this.mPopupWindowOffset[2];
    }

    public int getWindowOffsetTop() {
        return this.mPopupWindowOffset[1];
    }

    public void measurePopupWindow() {
        int min;
        int dimensionPixelOffset;
        this.mPopupListWindowMinWidth = this.mAnchor.getWidth();
        Rect rect = this.mBackgroundPaddingRect;
        int i10 = rect.top + rect.bottom;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getPopupWindowMaxWidth(), Integer.MIN_VALUE);
        int i11 = 0;
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int i12 = this.mMaxLines;
        if (i12 == 0) {
            min = this.mAdapter.getCount();
        } else {
            min = Math.min(i12, this.mAdapter.getCount());
        }
        int max = Math.max(this.mTopCanUseArea, this.mBottomCanUseArea);
        int i13 = this.mShadowTop + this.mShadowBottom;
        if (max == this.mTopCanUseArea) {
            dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(Z8.c.f6018g);
        } else {
            dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(Z8.c.f6010c);
        }
        int i14 = i13 - dimensionPixelOffset;
        int i15 = 0;
        int i16 = makeMeasureSpec2;
        int i17 = 0;
        while (true) {
            if (i11 >= min) {
                break;
            }
            View view = this.mAdapter.getView(i11, null, this.mListViewUsedToMeasure);
            int i18 = ((AbsListView.LayoutParams) view.getLayoutParams()).height;
            if (i18 != -2) {
                i16 = View.MeasureSpec.makeMeasureSpec(i18, 1073741824);
            }
            view.measure(makeMeasureSpec, i16);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            if (measuredWidth > i17) {
                i17 = measuredWidth;
            }
            i15 += measuredHeight;
            if (i15 + i10 > max + i14) {
                i15 -= measuredHeight;
                break;
            }
            i11++;
        }
        int i19 = this.mPopupHeight;
        if (i19 != 0) {
            i15 = i19;
        }
        if (this.mAnchor.getContext() instanceof Activity) {
            int maxAvailableHeight = getMaxAvailableHeight();
            if (maxAvailableHeight <= max) {
                max = maxAvailableHeight;
            }
        } else {
            max = i15 + i10;
        }
        int max2 = Math.max(i17, this.mPopupListWindowMinWidth);
        Rect rect2 = this.mBackgroundPaddingRect;
        int i20 = max2 + rect2.left + rect2.right + this.mExtraWidth;
        int min2 = Math.min(max, i15 + i10) + this.mExtraHeight;
        Rect rect3 = this.mDecorViewRect;
        int min3 = Math.min(i20, rect3.right - rect3.left);
        Rect rect4 = this.mDecorViewRect;
        int min4 = Math.min(min2, rect4.bottom - rect4.top);
        setWidth(min3);
        setHeight(min4);
    }

    public void notifyAdapterChange() {
        COUIAutoCompletePopupAdapter cOUIAutoCompletePopupAdapter = this.mDefaultAdapter;
        if (cOUIAutoCompletePopupAdapter != null) {
            cOUIAutoCompletePopupAdapter.notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        Rect rect = new Rect(i10, i11, i12, i13);
        Rect rect2 = new Rect(i14, i15, i16, i17);
        if (isShowing() && !rect.equals(rect2)) {
            dismiss();
        }
    }

    public void refresh() {
        TypedArray obtainStyledAttributes = this.mContext.getTheme().obtainStyledAttributes(new int[]{c.f4365X});
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        if (drawable == null) {
            drawable = h.f(this.mContext.getResources(), g.f4868u, this.mContext.getTheme());
        }
        this.mContentView.setBackground(drawable);
        obtainStyledAttributes.recycle();
    }

    public void resetOffset() {
        setOffset(0, 0, 0, 0);
    }

    public void setAdapter(BaseAdapter baseAdapter) {
        this.mCustomAdapter = baseAdapter;
    }

    public void setAnchorView(View view) {
        this.mAnchor = view;
    }

    public void setContentHeight(int i10) {
        this.mPopupHeight = i10;
    }

    public void setExtraHeight(int i10) {
        this.mExtraHeight = i10;
    }

    public void setExtraWidth(int i10) {
        this.mExtraWidth = i10;
    }

    public boolean setIsSetFromItemClick(boolean z10) {
        this.mIsSetFromItemClick = z10;
        return z10;
    }

    public void setItemList(List<COUIAutoCompleteHelper.PopupListData> list) {
        if (list != null) {
            this.mItemList = list;
            COUIAutoCompletePopupAdapter cOUIAutoCompletePopupAdapter = new COUIAutoCompletePopupAdapter(this.mContext, list);
            this.mDefaultAdapter = cOUIAutoCompletePopupAdapter;
            cOUIAutoCompletePopupAdapter.setOnDeleteViewOnClickCallback(new COUIAutoCompletePopupAdapter.OnDeleteViewOnClickCallback() { // from class: com.coui.appcompat.autocomplete.COUIAutoCompletePopupWindow.3
                @Override // com.coui.appcompat.autocomplete.COUIAutoCompletePopupAdapter.OnDeleteViewOnClickCallback
                public void callback(int i10) {
                    COUIAutoCompletePopupWindow.this.mItemList.remove(i10);
                    COUIAutoCompletePopupWindow.this.notifyAdapterChange();
                    if (COUIAutoCompletePopupWindow.this.isShowing()) {
                        if (COUIAutoCompletePopupWindow.this.mItemList.isEmpty()) {
                            COUIAutoCompletePopupWindow.this.dismiss();
                        } else {
                            COUIAutoCompletePopupWindow cOUIAutoCompletePopupWindow = COUIAutoCompletePopupWindow.this;
                            cOUIAutoCompletePopupWindow.show(cOUIAutoCompletePopupWindow.mAnchor, false);
                        }
                    }
                }
            });
        }
    }

    public void setMaxLines(int i10) {
        this.mMaxLines = i10;
    }

    public void setOffset(int i10, int i11, int i12, int i13) {
        int[] iArr = this.mPopupWindowOffset;
        iArr[0] = i10;
        iArr[1] = i11;
        iArr[2] = i12;
        iArr[3] = i13;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public void show() {
        View view = this.mAnchor;
        if (view != null) {
            show(view);
        }
    }

    @Override // android.widget.PopupWindow
    public void showAtLocation(View view, int i10, int i11, int i12) {
        int max = Math.max(this.mDecorViewRect.left, Math.min(i11, this.mDecorViewRect.right - getWidth())) - this.mWindowLocationOnScreen[0];
        if (this.mAnchor.getTop() < 0 && !this.mHasCheckedTopOfAnchorView) {
            i12 += this.mAnchor.getTop();
        }
        if (this.mAnchor.getContext() instanceof Activity) {
            i12 = Math.max(getStatusBarHeight(), i12);
        }
        setShowLocation(max, i12);
        super.showAtLocation(view, i10, max, i12);
    }

    public void superDismiss() {
        super.setContentView(null);
        super.dismiss();
    }

    public void show(View view) {
        show(view, true);
    }

    public void show(View view, boolean z10) {
        Activity contextToActivity = UIUtil.contextToActivity(this.mContext);
        if (contextToActivity == null || !(contextToActivity.isFinishing() || contextToActivity.isDestroyed())) {
            if (z10) {
                configPopupValue(view);
                showAsMeasure();
                calculatePivot();
                animateEnter();
                return;
            }
            if (this.mAnchor == null) {
                COUILog.e(TAG, "anim is false: mAnchor equals null");
                return;
            }
            int height = getHeight();
            measurePopupWindow();
            if (this.mIsBelowAnchor) {
                update(getWidth(), getHeight());
                return;
            }
            Point point = this.mCoordinate;
            setShowLocation(point.x, (point.y + height) - getHeight());
            Point point2 = this.mCoordinate;
            update(point2.x, point2.y, getWidth(), getHeight());
        }
    }
}
