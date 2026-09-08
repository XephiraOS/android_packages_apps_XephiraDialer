package com.coui.appcompat.dialog;

import X8.c;
import X8.d;
import X8.e;
import X8.f;
import X8.h;
import X8.n;
import X8.o;
import android.R;
import android.app.Dialog;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.b;
import com.coui.appcompat.buttonBar.COUIButtonBarLayout;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import com.coui.appcompat.dialog.adapter.COUIListDialogAdapter;
import com.coui.appcompat.dialog.adapter.ChoiceListAdapter;
import com.coui.appcompat.dialog.adapter.SummaryAdapter;
import com.coui.appcompat.dialog.widget.COUIAlertDialogClipCornerLinearLayout;
import com.coui.appcompat.dialog.widget.COUIAlertDialogMaxLinearLayout;
import com.coui.appcompat.dialog.widget.COUIAlertDialogMaxScrollView;
import com.coui.appcompat.dialog.widget.COUIMaxHeightNestedScrollView;
import com.coui.appcompat.grid.COUIResponsiveUtils;
import com.coui.appcompat.imageview.COUIRoundImageView;
import com.coui.appcompat.log.COUILog;
import com.coui.appcompat.roundcorner.RoundCornerUtil;
import com.coui.appcompat.statement.COUIMaxHeightScrollView;
import com.coui.appcompat.uiutil.AnimLevel;
import com.coui.appcompat.uiutil.ShadowUtils;
import com.coui.appcompat.uiutil.UIUtil;
import com.oplus.graphics.OplusBlurParam;
import com.oplus.view.ViewRootManager;
import e.C0961a;
import java.util.function.Consumer;

/* loaded from: classes.dex */
public class COUIAlertDialogBuilder extends b.a {
    private static final int DEF_STYLE_ATTR = C0961a.f30115n;
    private static final int DEF_STYLE_RES = n.f5029a;
    private static final int DEF_WINDOW_ANIM = n.f5030b;
    private static final int DEF_WINDOW_GRAVITY = 17;
    private static final String TAG = "COUIAlertDialogBuilder";
    private static final int UNSET_WIDTH = -1;
    private boolean hasAdapter;
    private boolean hasMessage;
    private boolean hasSetButton;
    private boolean hasSetView;
    private boolean hasTitle;
    private boolean isAssignMentLayout;
    private boolean mAlwaysFollowHand;
    private View mAnchorView;
    private Point mAnchorViewTouchPoint;
    private boolean mBlurBackgroundWindow;
    private boolean mButtonLayoutDynamicLayout;
    private COUIListDialogAdapter mCOUIListDialogAdapter;
    private ChoiceListAdapter mChoiceListAdapter;
    private ComponentCallbacks mComponentCallbacks;
    private Configuration mConfiguration;
    private int mContentMaxHeight;
    private int mContentMaxWidth;
    private View mContentView;
    private Consumer<Boolean> mCrossWindowBlurEnabledListener;
    private int mCustomContentLayoutRes;
    private Drawable mCustomDrawable;
    private CharSequence mCustomMessage;
    private String mCustomTitle;
    private androidx.appcompat.app.b mDialog;
    private int mDialogStyle;
    private int mDialogWindowType;
    private Point mExtraOffsetPoint;
    private boolean mForcePhysicalDimensions;
    private int mGravity;
    private boolean mHasLoading;
    private boolean mHasMessageMerge;
    private boolean mIsBlurEnable;
    private boolean mIsCOUIDarkTheme;
    private boolean mIsCustomStyle;
    private boolean mIsForceCenterInLargeScreen;
    private boolean mIsForceCenterStyleStatus;
    private boolean mIsNeedToAdaptMessageAndList;
    private boolean mIsTinyStyle;
    private DialogInterface.OnClickListener mItemClickListener;
    private CharSequence[] mItems;
    private int mOldConfigurationHeightDP;
    private int mOldConfigurationWidthDP;
    private int mOriginWidth;
    private int mRecommendButtonId;
    private boolean mRegisterConfigurationChangeCallBack;
    private View mRootView;
    private CharSequence[] mSummaryItems;
    public int[] mTextColor;
    private ViewRootManager mViewManager;
    private int mWindowAnimStyleRes;
    private int parentPanelMinHeight;

    /* loaded from: classes.dex */
    public static class OutsideTouchListener implements View.OnTouchListener {
        private final Dialog dialog;
        private final int prePieSlop;

        public OutsideTouchListener(Dialog dialog) {
            this.dialog = dialog;
            this.prePieSlop = ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (view.findViewById(h.f4907X) == null) {
                COUILog.e(COUIAlertDialogBuilder.TAG, "parentPanel is null; Need to check whether the application has a layout that covers the coui's");
                return this.dialog.onTouchEvent(motionEvent);
            }
            if (new RectF(r0.getLeft() + r0.getPaddingLeft(), r0.getTop() + r0.getPaddingTop(), r0.getRight() - r0.getPaddingRight(), r0.getBottom() - r0.getPaddingBottom()).contains(motionEvent.getX(), motionEvent.getY())) {
                return false;
            }
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            if (motionEvent.getAction() == 1) {
                obtain.setAction(4);
            }
            view.performClick();
            boolean onTouchEvent = this.dialog.onTouchEvent(obtain);
            obtain.recycle();
            return onTouchEvent;
        }
    }

    public COUIAlertDialogBuilder(Context context) {
        this(context, n.f5034f);
    }

    private void disabledTitleScroll(androidx.appcompat.app.b bVar) {
        View findViewById = bVar.findViewById(h.f4912b);
        if (findViewById instanceof COUIMaxHeightScrollView) {
            final COUIMaxHeightScrollView cOUIMaxHeightScrollView = (COUIMaxHeightScrollView) findViewById;
            cOUIMaxHeightScrollView.setOnTouchListener(new View.OnTouchListener() { // from class: com.coui.appcompat.dialog.COUIAlertDialogBuilder.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (cOUIMaxHeightScrollView.getHeight() < cOUIMaxHeightScrollView.getMaxHeight()) {
                        return true;
                    }
                    return false;
                }
            });
        } else {
            COUILog.e(TAG, "alert_title_scroll_view is error; Need to check whether the application has a layout that covers the coui's");
        }
    }

    private void initAttrs() {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, o.f5269b, DEF_STYLE_ATTR, DEF_STYLE_RES);
        this.mGravity = obtainStyledAttributes.getInt(o.f5277c, 17);
        this.mWindowAnimStyleRes = obtainStyledAttributes.getResourceId(o.f5357m, DEF_WINDOW_ANIM);
        this.mContentMaxWidth = obtainStyledAttributes.getDimensionPixelOffset(o.f5293e, 0);
        this.mContentMaxHeight = obtainStyledAttributes.getDimensionPixelOffset(o.f5285d, 0);
        this.mCustomContentLayoutRes = obtainStyledAttributes.getResourceId(o.f5301f, 0);
        this.mIsNeedToAdaptMessageAndList = obtainStyledAttributes.getBoolean(o.f5341k, false);
        this.mIsTinyStyle = obtainStyledAttributes.getBoolean(o.f5349l, false);
        this.mHasLoading = obtainStyledAttributes.getBoolean(o.f5309g, false);
        this.isAssignMentLayout = obtainStyledAttributes.getBoolean(o.f5317h, false);
        this.mIsForceCenterInLargeScreen = obtainStyledAttributes.getBoolean(o.f5333j, false);
        this.mIsCustomStyle = obtainStyledAttributes.getBoolean(o.f5325i, false);
        obtainStyledAttributes.recycle();
        this.mIsCOUIDarkTheme = COUIContextUtil.isCOUIDarkTheme(getContext());
        this.mIsBlurEnable = getContext().getResources().getBoolean(d.f4420a);
    }

    private void initBlurListener() {
        this.mRootView = this.mDialog.getWindow().findViewById(h.f4933l0);
        this.mDialog.getWindow().getDecorView().addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.coui.appcompat.dialog.COUIAlertDialogBuilder.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                COUIAlertDialogBuilder.this.registerApplicationConfigChangeListener();
                try {
                    COUIAlertDialogBuilder.this.operateBlur(view);
                } catch (Exception e10) {
                    Log.e(COUIAlertDialogBuilder.TAG, "operateBlur error message:" + e10.getMessage());
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                COUIAlertDialogBuilder.this.releaseApplicationConfigChangeListener();
                if (COUIAlertDialogBuilder.this.mBlurBackgroundWindow && COUIAlertDialogBuilder.this.mCrossWindowBlurEnabledListener != null) {
                    COUIAlertDialogBuilder.this.mDialog.getWindow().getWindowManager().removeCrossWindowBlurEnabledListener(COUIAlertDialogBuilder.this.mCrossWindowBlurEnabledListener);
                }
                view.removeOnAttachStateChangeListener(this);
            }
        });
    }

    private void initCOUIDialogTitle(View view) {
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = -1;
        view.setLayoutParams(layoutParams);
    }

    private void initContentMaxHeight(Window window) {
        if (this.mContentMaxHeight <= 0) {
            return;
        }
        View findViewById = window.findViewById(h.f4907X);
        if (findViewById instanceof COUIAlertDialogMaxLinearLayout) {
            ((COUIAlertDialogMaxLinearLayout) findViewById).setMaxHeight(this.mContentMaxHeight);
        } else if (findViewById instanceof COUIAlertDialogMaxScrollView) {
            ((COUIAlertDialogMaxScrollView) findViewById).setMaxHeight(this.mContentMaxHeight);
        } else {
            COUILog.e(TAG, "parentPanel is error; Need to check whether the application has a layout that covers the coui's");
        }
    }

    private void initContentMaxWidth(Window window) {
        if (this.mContentMaxWidth <= 0) {
            return;
        }
        View findViewById = window.findViewById(h.f4907X);
        if (findViewById instanceof COUIAlertDialogMaxLinearLayout) {
            ((COUIAlertDialogMaxLinearLayout) findViewById).setMaxWidth(this.mContentMaxWidth);
        } else if (findViewById instanceof COUIAlertDialogMaxScrollView) {
            ((COUIAlertDialogMaxScrollView) findViewById).setMaxWidth(this.mContentMaxWidth);
        } else {
            COUILog.e(TAG, "parentPanel is error; Need to check whether the application has a layout that covers the coui's");
        }
    }

    private void initCustomPanel() {
        int i10;
        if (!this.hasSetView && (i10 = this.mCustomContentLayoutRes) != 0) {
            setView(i10);
        }
    }

    private void initCustomPanelVisibility(Window window) {
        int i10;
        if (this.hasSetView) {
            View findViewById = window.findViewById(h.f4892J);
            int i11 = 0;
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
            View findViewById2 = window.findViewById(h.f4886G);
            if (findViewById2 != null) {
                findViewById2.setVisibility(0);
            }
            if (!this.mHasLoading && !this.hasMessage) {
                if (!this.hasTitle) {
                    i10 = getContext().getResources().getDimensionPixelOffset(f.f4763p);
                } else if (!this.isAssignMentLayout) {
                    i10 = getContext().getResources().getDimensionPixelOffset(f.f4468B);
                } else {
                    i10 = 0;
                }
                if (this.isAssignMentLayout) {
                    i11 = getContext().getResources().getDimensionPixelOffset(f.f4461A);
                }
                findViewById2.setPaddingRelative(findViewById2.getPaddingStart(), i10, findViewById2.getPaddingEnd(), i11);
            }
        }
    }

    private void initListPanel(Window window) {
        ListView listView;
        boolean z10;
        View findViewById = window.findViewById(h.f4903T);
        if (findViewById instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) findViewById;
            androidx.appcompat.app.b bVar = this.mDialog;
            if (bVar != null) {
                listView = bVar.c();
            } else {
                listView = null;
            }
            if (listView != null) {
                listView.setScrollIndicators(0);
            }
            if (viewGroup != null && listView != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                if (listView.getParent() != null && (listView.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) listView.getParent()).removeView(listView);
                }
                viewGroup.addView(listView, new ViewGroup.LayoutParams(-1, -1));
            }
            final ViewGroup viewGroup2 = (ViewGroup) window.findViewById(h.f4935m0);
            if (viewGroup2 != null) {
                viewGroup2.setScrollIndicators(0);
                if (this.mIsNeedToAdaptMessageAndList && z10) {
                    setViewHorizontalWeight(viewGroup2, 1);
                    setViewHorizontalWeight(viewGroup, 1);
                }
                if (viewGroup2 instanceof COUIMaxHeightNestedScrollView) {
                    boolean isSecondaryScreen = AppFeatureUtil.isSecondaryScreen(getContext());
                    if (this.hasAdapter && !isSecondaryScreen) {
                        ((COUIMaxHeightNestedScrollView) viewGroup2).setMaxHeight(getContext().getResources().getDimensionPixelOffset(f.f4755o));
                    }
                    if (window.getAttributes().gravity == 80 && this.hasMessage) {
                        if (this.mHasLoading || this.mIsTinyStyle) {
                            ((COUIMaxHeightNestedScrollView) viewGroup2).setConfigChangeListener(new COUIMaxHeightNestedScrollView.ConfigChangeListener() { // from class: com.coui.appcompat.dialog.COUIAlertDialogBuilder.2
                                @Override // com.coui.appcompat.dialog.widget.COUIMaxHeightNestedScrollView.ConfigChangeListener
                                public void onChange() {
                                    viewGroup2.setPadding(0, COUIAlertDialogBuilder.this.getContext().getResources().getDimensionPixelOffset(f.f4683f), 0, COUIAlertDialogBuilder.this.getContext().getResources().getDimensionPixelOffset(f.f4675e));
                                }
                            });
                            return;
                        }
                        return;
                    }
                    return;
                }
                COUILog.e(TAG, "scrollView isn't instanceof COUIMaxHeightNestedScrollView; Need to check whether the application has a layout that covers the coui's");
                return;
            }
            return;
        }
        COUILog.e(TAG, "listPanel is error; Need to check whether the application has a layout that covers the coui's");
    }

    private void initMessagePadding() {
        androidx.appcompat.app.b bVar = this.mDialog;
        if (bVar == null) {
            return;
        }
        int i10 = h.f4935m0;
        View findViewById = bVar.findViewById(i10);
        if (!this.mIsTinyStyle && !this.mHasLoading && this.hasMessage && findViewById != null) {
            if (this.hasTitle && this.isAssignMentLayout) {
                findViewById.setPadding(findViewById.getPaddingLeft(), 0, findViewById.getPaddingRight(), getContext().getResources().getDimensionPixelOffset(f.f4496F));
            }
            View findViewById2 = this.mDialog.getWindow().findViewById(h.f4907X);
            if (!(findViewById2 instanceof COUIAlertDialogMaxLinearLayout)) {
                COUILog.e(TAG, "parentPanel is error; Need to check whether the application has a layout that covers the coui's");
                return;
            }
            COUIAlertDialogMaxLinearLayout cOUIAlertDialogMaxLinearLayout = (COUIAlertDialogMaxLinearLayout) findViewById2;
            cOUIAlertDialogMaxLinearLayout.setHasMessageMerge(this.mHasMessageMerge);
            if (!this.mIsTinyStyle && !this.isAssignMentLayout) {
                cOUIAlertDialogMaxLinearLayout.setNeedSetPaddingLayoutId(i10);
            }
        }
    }

    private void initSingleContentPadding(Window window) {
        boolean z10;
        boolean z11;
        View findViewById = window.findViewById(h.f4930k);
        CharSequence[] charSequenceArr = this.mItems;
        boolean z12 = false;
        if (charSequenceArr != null && charSequenceArr.length > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!this.hasTitle && !this.hasMessage && !this.hasSetView && !this.hasAdapter && !z10) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (this.mIsTinyStyle) {
            if (findViewById != null && !z11) {
                findViewById.setPadding(findViewById.getPaddingLeft(), getContext().getResources().getDimensionPixelOffset(f.f4681e5), findViewById.getPaddingRight(), findViewById.getPaddingBottom());
                return;
            }
            return;
        }
        if (findViewById instanceof COUIButtonBarLayout) {
            COUIButtonBarLayout cOUIButtonBarLayout = (COUIButtonBarLayout) findViewById;
            cOUIButtonBarLayout.setRecommendButtonId(this.mRecommendButtonId);
            cOUIButtonBarLayout.setDynamicLayout(this.mButtonLayoutDynamicLayout);
            if (this.mItems != null) {
                z12 = true;
            }
            cOUIButtonBarLayout.setShowDividerWhenHasItems(z12);
            return;
        }
        COUILog.e(TAG, "buttonPanel is error; Need to check whether the application has a layout that covers the coui's");
    }

    private void initTitle(Window window) {
        if (!this.mIsTinyStyle && !this.mHasLoading) {
            View findViewById = window.findViewById(h.f4885F0);
            if (findViewById != null && (findViewById instanceof LinearLayout)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams.topMargin = getContext().getResources().getDimensionPixelOffset(f.f4569P2);
                layoutParams.bottomMargin = getContext().getResources().getDimensionPixelOffset(f.f4562O2);
                findViewById.setLayoutParams(layoutParams);
                initTitleScrollView(window, window.findViewById(h.f4912b));
                initCOUIDialogTitle(window.findViewById(h.f4910a));
                return;
            }
            COUILog.e(TAG, "title_template is error; Need to check whether the application has a layout that covers the coui's");
        }
    }

    private void initTitleScrollView(Window window, View view) {
        if (view != null && (view instanceof COUIMaxHeightScrollView)) {
            COUIMaxHeightScrollView cOUIMaxHeightScrollView = (COUIMaxHeightScrollView) view;
            cOUIMaxHeightScrollView.setMinHeight((window.getContext().getResources().getDimensionPixelOffset(f.f4794t) - getContext().getResources().getDimensionPixelOffset(f.f4569P2)) - getContext().getResources().getDimensionPixelOffset(f.f4562O2));
            cOUIMaxHeightScrollView.setFillViewport(true);
            View findViewById = window.findViewById(h.f4907X);
            if (!(findViewById instanceof COUIAlertDialogMaxLinearLayout)) {
                COUILog.e(TAG, "parentPanelView is error; Need to check whether the application has a layout that covers the coui's");
                return;
            }
            COUIAlertDialogMaxLinearLayout cOUIAlertDialogMaxLinearLayout = (COUIAlertDialogMaxLinearLayout) findViewById;
            if (!this.hasMessage) {
                cOUIAlertDialogMaxLinearLayout.setNeedMinHeight(window.getContext().getResources().getDimensionPixelOffset(f.f4779r));
            }
            cOUIAlertDialogMaxLinearLayout.setNeedReMeasureLayoutId(cOUIMaxHeightScrollView.getId());
            return;
        }
        COUILog.e(TAG, "alert_title_scroll_view is error; Need to check whether the application has a layout that covers the coui's");
    }

    private void initWindow(Window window) {
        int i10;
        if (isFollowHandMode()) {
            COUIBottomAlertDialogAdjustUtil.adjustToFree(window, this.mAnchorView, this.mAnchorViewTouchPoint, this.mExtraOffsetPoint);
            window.getDecorView().setVisibility(4);
        } else {
            Configuration configuration = this.mConfiguration;
            if (configuration == null) {
                configuration = window.getContext().getResources().getConfiguration();
            }
            updateGravityAndAnimation(configuration);
        }
        window.getDecorView().setOnTouchListener(new OutsideTouchListener(this.mDialog));
        WindowManager.LayoutParams attributes = window.getAttributes();
        int i11 = this.mDialogWindowType;
        if (i11 > 0) {
            attributes.type = i11;
        }
        if (isFollowHandMode()) {
            i10 = -2;
        } else {
            i10 = -1;
        }
        attributes.width = i10;
        window.setAttributes(attributes);
    }

    private boolean isFollowHandMode() {
        if (this.mAnchorView == null && this.mAnchorViewTouchPoint == null) {
            return false;
        }
        return true;
    }

    private boolean isForceCenterStyleInLargeScreen(Configuration configuration) {
        if (isLargeScreen(configuration) && this.mIsForceCenterInLargeScreen) {
            return true;
        }
        return false;
    }

    private boolean isLargeScreen(Configuration configuration) {
        int i10 = configuration.screenWidthDp;
        int i11 = configuration.screenHeightDp;
        if (this.mForcePhysicalDimensions) {
            i10 = UIUtil.px2dip(getContext(), UIUtil.getScreenWidthRealSize(getContext()));
            i11 = UIUtil.px2dip(getContext(), UIUtil.getScreenHeightRealSize(getContext()));
        }
        return COUIResponsiveUtils.isLargePadWindow(getContext(), i10, i11);
    }

    private boolean isMiddleAndLargeScreen(Configuration configuration) {
        if (this.mAlwaysFollowHand) {
            return true;
        }
        return !COUIResponsiveUtils.isSmallScreenDp(configuration.screenWidthDp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$operateBlur$0(Boolean bool) {
        int color = COUIContextUtil.getColor(getContext(), e.f4449o);
        int color2 = COUIContextUtil.getColor(getContext(), e.f4450p);
        ViewRootManager viewRootManager = this.mViewManager;
        if (!bool.booleanValue()) {
            color = color2;
        }
        viewRootManager.setColor(color);
        View view = this.mRootView;
        if (view != null) {
            view.invalidate();
        } else {
            COUILog.e(TAG, "mCrossWindowBlurEnabledListener mRootView is null; Need to check whether the application has a layout that covers the coui's");
        }
        COUILog.i(TAG, "WindowBlurEnabled = " + bool);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void operateBlur(View view) {
        int i10;
        float[] colorToFloats;
        float[] colorToFloats2;
        if (!view.isHardwareAccelerated()) {
            COUILog.e(TAG, "Hardware accelerate is disabled! Set background blur failed.");
            return;
        }
        if (this.mBlurBackgroundWindow) {
            boolean isSupportRoundCornerWhenBlur = RoundCornerUtil.isSupportRoundCornerWhenBlur();
            View view2 = this.mRootView;
            if (view2 instanceof COUIAlertDialogClipCornerLinearLayout) {
                ((COUIAlertDialogClipCornerLinearLayout) view2).setBlurBackgroundWindow(this.mBlurBackgroundWindow);
                ((COUIAlertDialogClipCornerLinearLayout) this.mRootView).setIsSupportRoundCornerWhenBlur(isSupportRoundCornerWhenBlur);
            } else {
                COUILog.e(TAG, "onViewAttachedToWindow: mRootView is not COUIAlertDialogClipCornerLinearLayout");
            }
            if (this.mCrossWindowBlurEnabledListener == null) {
                this.mCrossWindowBlurEnabledListener = new Consumer() { // from class: com.coui.appcompat.dialog.a
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        COUIAlertDialogBuilder.this.lambda$operateBlur$0((Boolean) obj);
                    }
                };
            }
            this.mDialog.getWindow().getWindowManager().addCrossWindowBlurEnabledListener(this.mCrossWindowBlurEnabledListener);
            ViewRootManager viewRootManager = new ViewRootManager(view);
            this.mViewManager = viewRootManager;
            Drawable backgroundBlurDrawable = viewRootManager.getBackgroundBlurDrawable();
            OplusBlurParam oplusBlurParam = new OplusBlurParam();
            oplusBlurParam.setBlurType(0);
            if (!COUIDarkModeUtil.isNightMode(getContext()) && !this.mIsCOUIDarkTheme) {
                i10 = 3;
            } else {
                i10 = 2;
            }
            if (this.mIsCOUIDarkTheme) {
                colorToFloats = UIUtil.colorToFloats(COUIContextUtil.getColor(getContext(), e.f4452r));
                colorToFloats2 = UIUtil.colorToFloats(COUIContextUtil.getColor(getContext(), e.f4455u));
            } else {
                colorToFloats = UIUtil.colorToFloats(COUIContextUtil.getColor(getContext(), e.f4451q));
                colorToFloats2 = UIUtil.colorToFloats(COUIContextUtil.getColor(getContext(), e.f4454t));
            }
            oplusBlurParam.setMaterialParams(i10, colorToFloats, colorToFloats2);
            if (isSupportRoundCornerWhenBlur) {
                int i11 = c.f4385i0;
                if (this.mHasLoading) {
                    i11 = c.f4377e0;
                }
                oplusBlurParam.setSmoothCornerWeight(COUIContextUtil.getAttrFloat(getContext(), i11));
                COUILog.i(TAG, "current version support roundCorner when use blur");
            }
            this.mViewManager.setBlurParams(oplusBlurParam);
            int i12 = c.f4383h0;
            if (this.mHasLoading) {
                i12 = c.f4375d0;
            }
            float attrDimens = COUIContextUtil.getAttrDimens(getContext(), i12);
            if (this.mIsTinyStyle) {
                this.mViewManager.setCornerRadius(attrDimens, attrDimens, 0.0f, 0.0f);
            } else {
                this.mViewManager.setCornerRadius(attrDimens);
            }
            this.mViewManager.setBlurRadius(getContext().getResources().getDimensionPixelSize(f.f4611V2));
            View view3 = this.mRootView;
            if (view3 != null) {
                view3.setBackground(backgroundBlurDrawable);
            } else {
                COUILog.e(TAG, "mRootView is null; Need to check whether the application has a layout that covers the coui's");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerApplicationConfigChangeListener() {
        getContext().registerComponentCallbacks(this.mComponentCallbacks);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseApplicationConfigChangeListener() {
        if (this.mComponentCallbacks != null) {
            getContext().unregisterComponentCallbacks(this.mComponentCallbacks);
        }
    }

    private void setCustomLayout() {
        if (this.mIsCustomStyle) {
            if (this.mCustomDrawable != null) {
                View findViewById = this.mDialog.findViewById(h.f4888H);
                if (findViewById instanceof COUIRoundImageView) {
                    COUIRoundImageView cOUIRoundImageView = (COUIRoundImageView) findViewById;
                    if (cOUIRoundImageView != null) {
                        cOUIRoundImageView.setImageDrawable(this.mCustomDrawable);
                        cOUIRoundImageView.setVisibility(0);
                    }
                } else {
                    COUILog.e(TAG, "customImageview is error; Need to check whether the application has a layout that covers the coui's");
                }
            }
            if (this.mCustomTitle != null) {
                View findViewById2 = this.mDialog.findViewById(h.f4894K);
                if (findViewById2 instanceof TextView) {
                    TextView textView = (TextView) findViewById2;
                    if (textView != null) {
                        textView.setText(this.mCustomTitle);
                        textView.setVisibility(0);
                    }
                } else {
                    COUILog.e(TAG, "customTitle is error; Need to check whether the application has a layout that covers the coui's");
                }
            }
            if (this.mCustomMessage != null) {
                View findViewById3 = this.mDialog.findViewById(h.f4890I);
                if (findViewById3 instanceof TextView) {
                    TextView textView2 = (TextView) findViewById3;
                    if (textView2 != null) {
                        textView2.setText(this.mCustomMessage);
                        textView2.setVisibility(0);
                        return;
                    }
                    return;
                }
                COUILog.e(TAG, "customMessage is error; Need to check whether the application has a layout that covers the coui's");
            }
        }
    }

    private void setViewHorizontalWeight(View view, int i10) {
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LinearLayout.LayoutParams)) {
            return;
        }
        layoutParams.height = 0;
        ((LinearLayout.LayoutParams) layoutParams).weight = i10;
        view.setLayoutParams(layoutParams);
    }

    private void updateGravityAndAnimation(Configuration configuration) {
        if (isForceCenterStyleInLargeScreen(configuration)) {
            this.mIsForceCenterStyleStatus = true;
            this.mDialog.getWindow().setGravity(17);
            this.mDialog.getWindow().setWindowAnimations(DEF_WINDOW_ANIM);
        } else {
            this.mIsForceCenterStyleStatus = false;
            this.mDialog.getWindow().setGravity(this.mGravity);
            this.mDialog.getWindow().setWindowAnimations(this.mWindowAnimStyleRes);
        }
    }

    public static Context wrapColorContext(Context context, int i10, int i11) {
        return new ContextThemeWrapper(new ContextThemeWrapper(context, i10), i11);
    }

    @Override // androidx.appcompat.app.b.a
    public androidx.appcompat.app.b create() {
        initCustomPanel();
        initAdapter();
        androidx.appcompat.app.b create = super.create();
        this.mDialog = create;
        initWindow(create.getWindow());
        return this.mDialog;
    }

    public androidx.appcompat.app.b createWithExtraOffset(View view, int i10, int i11) {
        return createWithExtraOffset(view, 0, 0, i10, i11);
    }

    public void enforceChangeScreenWidth(int i10) {
        if (i10 < 0) {
            Log.d(TAG, "enforceChangeScreenWidth : given value not satisfy : preferWidth =" + i10);
            return;
        }
        try {
            Resources resources = getContext().getResources();
            Configuration configuration = resources.getConfiguration();
            this.mOriginWidth = configuration.screenWidthDp;
            configuration.screenWidthDp = i10;
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
            Log.d(TAG, "enforceChangeScreenWidth : OriginWidth=" + this.mOriginWidth + " ,PreferWidth:" + i10);
        } catch (Exception unused) {
            Log.d(TAG, "enforceChangeScreenWidth : failed to updateConfiguration");
        }
    }

    public View getAnchorView() {
        return this.mAnchorView;
    }

    public int getBottomAlertDialogWindowAnimStyle(Context context) {
        if (isMiddleAndLargeScreen(context.getResources().getConfiguration()) && isFollowHandMode()) {
            return n.f5031c;
        }
        return this.mWindowAnimStyleRes;
    }

    public int getBottomAlertDialogWindowGravity(Context context) {
        if (isMiddleAndLargeScreen(context.getResources().getConfiguration()) && isFollowHandMode()) {
            return 51;
        }
        return this.mGravity;
    }

    public void initAdapter() {
        CharSequence[] charSequenceArr;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        COUIListDialogAdapter cOUIListDialogAdapter = this.mCOUIListDialogAdapter;
        if (cOUIListDialogAdapter != null) {
            if (!this.hasTitle && !this.hasMessage) {
                z14 = true;
            } else {
                z14 = false;
            }
            cOUIListDialogAdapter.setIsTop(z14);
            COUIListDialogAdapter cOUIListDialogAdapter2 = this.mCOUIListDialogAdapter;
            if (!this.hasSetView && !this.hasSetButton) {
                z15 = true;
            } else {
                z15 = false;
            }
            cOUIListDialogAdapter2.setIsBottom(z15);
        }
        ChoiceListAdapter choiceListAdapter = this.mChoiceListAdapter;
        if (choiceListAdapter != null) {
            if (!this.hasTitle && !this.hasMessage) {
                z12 = true;
            } else {
                z12 = false;
            }
            choiceListAdapter.setIsTop(z12);
            ChoiceListAdapter choiceListAdapter2 = this.mChoiceListAdapter;
            if (!this.hasSetView && !this.hasSetButton) {
                z13 = true;
            } else {
                z13 = false;
            }
            choiceListAdapter2.setIsBottom(z13);
        }
        if (!this.hasAdapter && (charSequenceArr = this.mItems) != null && charSequenceArr.length > 0) {
            Context context = getContext();
            if (!this.hasTitle && !this.hasMessage) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!this.hasSetView && !this.hasSetButton) {
                z11 = true;
            } else {
                z11 = false;
            }
            setAdapter((ListAdapter) new SummaryAdapter(context, z10, z11, this.mItems, this.mSummaryItems, this.mTextColor), this.mItemClickListener);
        }
    }

    public void restoreScreenWidth() {
        if (this.mOriginWidth == -1) {
            return;
        }
        try {
            Resources resources = getContext().getResources();
            Configuration configuration = resources.getConfiguration();
            configuration.screenWidthDp = this.mOriginWidth;
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
            Log.d(TAG, "restoreScreenWidth : OriginWidth=" + this.mOriginWidth);
            this.mOriginWidth = -1;
        } catch (Exception unused) {
            Log.d(TAG, "restoreScreenWidth : failed to updateConfiguration");
        }
    }

    public COUIAlertDialogBuilder setAlwaysFollowHand(boolean z10) {
        this.mAlwaysFollowHand = z10;
        return this;
    }

    public COUIAlertDialogBuilder setAnchorView(View view) {
        this.mAnchorView = view;
        return this;
    }

    public COUIAlertDialogBuilder setAnchorViewTouchPoint(Point point) {
        this.mAnchorViewTouchPoint = point;
        return this;
    }

    public COUIAlertDialogBuilder setBlurBackgroundDrawable(boolean z10) {
        setBlurBackgroundDrawable(z10, UIUtil.ANIM_LEVEL_SUPPORT_BLUR_MIN);
        return this;
    }

    public COUIAlertDialogBuilder setButtonLayoutDynamicLayout(boolean z10) {
        this.mButtonLayoutDynamicLayout = z10;
        return this;
    }

    public COUIAlertDialogBuilder setCustomDrawable(Drawable drawable) {
        this.mCustomDrawable = drawable;
        return this;
    }

    public COUIAlertDialogBuilder setCustomMessage(CharSequence charSequence) {
        this.mCustomMessage = charSequence;
        return this;
    }

    public COUIAlertDialogBuilder setCustomTitle(String str) {
        this.mCustomTitle = str;
        return this;
    }

    public COUIAlertDialogBuilder setExtraOffsetPoint(Point point) {
        this.mExtraOffsetPoint = point;
        return this;
    }

    public COUIAlertDialogBuilder setForcePhysicalDimensions(boolean z10) {
        this.mForcePhysicalDimensions = z10;
        return this;
    }

    public COUIAlertDialogBuilder setHasMessageMerge(boolean z10) {
        this.mHasMessageMerge = z10;
        return this;
    }

    public void setHasSetButton(boolean z10) {
        this.hasSetButton = z10;
    }

    public COUIAlertDialogBuilder setIsForceCenterInLargeScreen(boolean z10) {
        this.mIsForceCenterInLargeScreen = z10;
        return this;
    }

    public COUIAlertDialogBuilder setNeedToAdaptMessageAndList(boolean z10) {
        this.mIsNeedToAdaptMessageAndList = z10;
        return this;
    }

    public COUIAlertDialogBuilder setRegisterConfigurationChangeCallBack(boolean z10) {
        this.mRegisterConfigurationChangeCallBack = z10;
        return this;
    }

    public COUIAlertDialogBuilder setSummaryItems(int i10) {
        this.mSummaryItems = getContext().getResources().getTextArray(i10);
        return this;
    }

    @Override // androidx.appcompat.app.b.a
    public b.a setView(int i10) {
        this.hasSetView = true;
        return super.setView(i10);
    }

    public COUIAlertDialogBuilder setWindowAnimStyle(int i10) {
        this.mWindowAnimStyleRes = i10;
        return this;
    }

    public COUIAlertDialogBuilder setWindowGravity(int i10) {
        this.mGravity = i10;
        return this;
    }

    public COUIAlertDialogBuilder setWindowType(int i10) {
        this.mDialogWindowType = i10;
        return this;
    }

    @Override // androidx.appcompat.app.b.a
    public androidx.appcompat.app.b show() {
        androidx.appcompat.app.b show = super.show();
        disabledTitleScroll(show);
        updateViewAfterShown();
        return show;
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0032, code lost:
    
        if (r1 == r4.mDialog.getContext().getResources().getConfiguration().screenHeightDp) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void updateGravityWhileConfigChange(android.content.res.Configuration r5) {
        /*
            r4 = this;
            androidx.appcompat.app.b r0 = r4.mDialog
            if (r0 == 0) goto Lda
            int r1 = r4.mOldConfigurationWidthDP
            int r2 = r5.screenWidthDp
            java.lang.String r3 = "COUIAlertDialogBuilder"
            if (r1 == r2) goto L1c
            android.content.Context r0 = r0.getContext()
            android.content.res.Resources r0 = r0.getResources()
            android.content.res.Configuration r0 = r0.getConfiguration()
            int r0 = r0.screenWidthDp
            if (r2 == r0) goto L34
        L1c:
            int r0 = r4.mOldConfigurationHeightDP
            int r1 = r5.screenHeightDp
            if (r0 == r1) goto L86
            androidx.appcompat.app.b r0 = r4.mDialog
            android.content.Context r0 = r0.getContext()
            android.content.res.Resources r0 = r0.getResources()
            android.content.res.Configuration r0 = r0.getConfiguration()
            int r0 = r0.screenHeightDp
            if (r1 != r0) goto L86
        L34:
            boolean r0 = r4.hasTitle
            if (r0 == 0) goto L5d
            androidx.appcompat.app.b r0 = r4.mDialog
            int r1 = X8.h.f4912b
            android.view.View r0 = r0.findViewById(r1)
            boolean r1 = r0 instanceof com.coui.appcompat.statement.COUIMaxHeightScrollView
            if (r1 == 0) goto L58
            com.coui.appcompat.statement.COUIMaxHeightScrollView r0 = (com.coui.appcompat.statement.COUIMaxHeightScrollView) r0
            android.content.Context r1 = r4.getContext()
            android.content.res.Resources r1 = r1.getResources()
            int r2 = X8.f.f4787s
            int r1 = r1.getDimensionPixelSize(r2)
            r0.setMaxHeight(r1)
            goto L5d
        L58:
            java.lang.String r0 = "alert_title_scroll_view is error; Need to check whether the application has a layout that covers the coui's"
            com.coui.appcompat.log.COUILog.e(r3, r0)
        L5d:
            boolean r0 = r4.hasMessage
            if (r0 == 0) goto L86
            androidx.appcompat.app.b r0 = r4.mDialog
            int r1 = X8.h.f4935m0
            android.view.View r0 = r0.findViewById(r1)
            boolean r1 = r0 instanceof com.coui.appcompat.dialog.widget.COUIMaxHeightNestedScrollView
            if (r1 == 0) goto L81
            com.coui.appcompat.dialog.widget.COUIMaxHeightNestedScrollView r0 = (com.coui.appcompat.dialog.widget.COUIMaxHeightNestedScrollView) r0
            android.content.Context r1 = r4.getContext()
            android.content.res.Resources r1 = r1.getResources()
            int r2 = X8.f.f4747n
            int r1 = r1.getDimensionPixelSize(r2)
            r0.setMaxHeight(r1)
            goto L86
        L81:
            java.lang.String r0 = "scrollView is error; Need to check whether the application has a layout that covers the coui's"
            com.coui.appcompat.log.COUILog.e(r3, r0)
        L86:
            int r0 = r5.screenWidthDp
            r4.mOldConfigurationWidthDP = r0
            int r0 = r5.screenHeightDp
            r4.mOldConfigurationHeightDP = r0
            boolean r0 = r4.isFollowHandMode()
            if (r0 != 0) goto La0
            boolean r0 = r4.mIsForceCenterStyleStatus
            boolean r1 = r4.isForceCenterStyleInLargeScreen(r5)
            if (r0 == r1) goto La0
            r4.updateGravityAndAnimation(r5)
            goto Lda
        La0:
            boolean r0 = r4.isFollowHandMode()
            if (r0 == 0) goto Lda
            boolean r5 = r4.isLargeScreen(r5)
            if (r5 != 0) goto Lda
            r5 = 0
            r4.mAnchorViewTouchPoint = r5
            r4.mAnchorView = r5
            android.view.View r5 = r4.mContentView
            if (r5 == 0) goto Ld2
            androidx.appcompat.app.b r5 = r4.mDialog
            android.view.Window r5 = r5.getWindow()
            int r0 = X8.h.f4886G
            android.view.View r5 = r5.findViewById(r0)
            boolean r0 = r5 instanceof android.widget.FrameLayout
            if (r0 == 0) goto Lcd
            android.widget.FrameLayout r5 = (android.widget.FrameLayout) r5
            android.view.View r0 = r4.mContentView
            r5.removeView(r0)
            goto Ld2
        Lcd:
            java.lang.String r5 = "custom is error; Need to check whether the application has a layout that covers the coui's"
            com.coui.appcompat.log.COUILog.e(r3, r5)
        Ld2:
            androidx.appcompat.app.b r5 = r4.mDialog
            r5.dismiss()
            r4.show()
        Lda:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.dialog.COUIAlertDialogBuilder.updateGravityWhileConfigChange(android.content.res.Configuration):void");
    }

    public void updateViewAfterShown() {
        androidx.appcompat.app.b bVar = this.mDialog;
        if (bVar == null) {
            return;
        }
        initTitle(bVar.getWindow());
        initMessagePadding();
        initCustomPanelVisibility(this.mDialog.getWindow());
        initListPanel(this.mDialog.getWindow());
        initContentMaxWidth(this.mDialog.getWindow());
        initContentMaxHeight(this.mDialog.getWindow());
        initSingleContentPadding(this.mDialog.getWindow());
        setCustomLayout();
        initBlurListener();
    }

    public COUIAlertDialogBuilder(Context context, int i10) {
        super(new ContextThemeWrapper(context, i10));
        this.hasTitle = false;
        this.hasMessage = false;
        this.hasAdapter = false;
        this.mHasLoading = false;
        this.isAssignMentLayout = false;
        this.mCOUIListDialogAdapter = null;
        this.hasSetView = false;
        this.mDialogWindowType = 0;
        this.mChoiceListAdapter = null;
        this.hasSetButton = false;
        this.mAnchorView = null;
        this.mAnchorViewTouchPoint = null;
        this.mExtraOffsetPoint = null;
        this.mOriginWidth = -1;
        this.mButtonLayoutDynamicLayout = true;
        this.mIsTinyStyle = false;
        this.mRegisterConfigurationChangeCallBack = true;
        this.mIsForceCenterInLargeScreen = false;
        this.mForcePhysicalDimensions = false;
        this.mRecommendButtonId = -1;
        this.mIsCustomStyle = false;
        this.mHasMessageMerge = false;
        this.mBlurBackgroundWindow = false;
        this.mIsCOUIDarkTheme = true;
        this.mIsBlurEnable = true;
        this.mComponentCallbacks = new ComponentCallbacks() { // from class: com.coui.appcompat.dialog.COUIAlertDialogBuilder.4
            @Override // android.content.ComponentCallbacks
            public void onConfigurationChanged(Configuration configuration) {
                if (COUIAlertDialogBuilder.this.mRegisterConfigurationChangeCallBack) {
                    COUIAlertDialogBuilder.this.mConfiguration = configuration;
                    COUIAlertDialogBuilder.this.updateGravityWhileConfigChange(configuration);
                }
            }

            @Override // android.content.ComponentCallbacks
            public void onLowMemory() {
            }
        };
        this.mDialogStyle = i10;
        initAttrs();
    }

    public androidx.appcompat.app.b createWithExtraOffset(View view, int i10, int i11, int i12, int i13) {
        if (isMiddleAndLargeScreen(getContext().getResources().getConfiguration())) {
            this.mAnchorView = view;
            if (i10 != 0 || i11 != 0) {
                Point point = new Point();
                this.mAnchorViewTouchPoint = point;
                point.set(i10, i11);
            }
            if (i12 != 0 || i13 != 0) {
                Point point2 = new Point();
                this.mExtraOffsetPoint = point2;
                point2.set(i12, i13);
            }
        }
        return create();
    }

    @Override // androidx.appcompat.app.b.a
    public COUIAlertDialogBuilder setAdapter(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
        this.hasAdapter = listAdapter != null;
        if (listAdapter instanceof COUIListDialogAdapter) {
            this.mCOUIListDialogAdapter = (COUIListDialogAdapter) listAdapter;
        }
        super.setAdapter(listAdapter, onClickListener);
        return this;
    }

    public COUIAlertDialogBuilder setBlurBackgroundDrawable(boolean z10, AnimLevel animLevel) {
        if (ShadowUtils.checkOPlusViewElevationSDK() && UIUtil.confirmLevelAnim(animLevel) && this.mIsBlurEnable) {
            this.mBlurBackgroundWindow = z10;
        } else {
            Log.e(TAG, "Machines below V do not support setting blurred backgrounds or current animLevel is too low or is in third party theme");
            this.mBlurBackgroundWindow = false;
        }
        return this;
    }

    @Override // androidx.appcompat.app.b.a
    public COUIAlertDialogBuilder setSingleChoiceItems(ListAdapter listAdapter, int i10, DialogInterface.OnClickListener onClickListener) {
        this.hasAdapter = listAdapter != null;
        super.setSingleChoiceItems(listAdapter, i10, onClickListener);
        return this;
    }

    public COUIAlertDialogBuilder setSummaryItems(CharSequence[] charSequenceArr) {
        this.mSummaryItems = charSequenceArr;
        return this;
    }

    @Override // androidx.appcompat.app.b.a
    public COUIAlertDialogBuilder setItems(int i10, DialogInterface.OnClickListener onClickListener) {
        this.mItems = getContext().getResources().getTextArray(i10);
        this.mItemClickListener = onClickListener;
        super.setItems(i10, onClickListener);
        return this;
    }

    @Override // androidx.appcompat.app.b.a
    public COUIAlertDialogBuilder setMessage(CharSequence charSequence) {
        this.hasMessage = !TextUtils.isEmpty(charSequence);
        super.setMessage(charSequence);
        return this;
    }

    @Override // androidx.appcompat.app.b.a
    public COUIAlertDialogBuilder setNegativeButton(int i10, DialogInterface.OnClickListener onClickListener) {
        super.setNegativeButton(i10, onClickListener);
        setHasSetButton(true);
        return this;
    }

    @Override // androidx.appcompat.app.b.a
    public COUIAlertDialogBuilder setNeutralButton(int i10, DialogInterface.OnClickListener onClickListener) {
        super.setNeutralButton(i10, onClickListener);
        setHasSetButton(true);
        return this;
    }

    @Override // androidx.appcompat.app.b.a
    public COUIAlertDialogBuilder setPositiveButton(int i10, DialogInterface.OnClickListener onClickListener) {
        super.setPositiveButton(i10, onClickListener);
        setHasSetButton(true);
        return this;
    }

    @Override // androidx.appcompat.app.b.a
    public COUIAlertDialogBuilder setTitle(CharSequence charSequence) {
        this.hasTitle = !TextUtils.isEmpty(charSequence);
        super.setTitle(charSequence);
        return this;
    }

    @Override // androidx.appcompat.app.b.a
    public b.a setView(View view) {
        this.hasSetView = true;
        this.mContentView = view;
        return super.setView(view);
    }

    public androidx.appcompat.app.b show(View view) {
        if (!isMiddleAndLargeScreen(getContext().getResources().getConfiguration())) {
            view = null;
        }
        this.mAnchorView = view;
        return show();
    }

    @Override // androidx.appcompat.app.b.a
    public COUIAlertDialogBuilder setMessage(int i10) {
        this.hasMessage = !TextUtils.isEmpty(getContext().getString(i10));
        super.setMessage(i10);
        return this;
    }

    @Override // androidx.appcompat.app.b.a
    public COUIAlertDialogBuilder setNegativeButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        super.setNegativeButton(charSequence, onClickListener);
        setHasSetButton(true);
        return this;
    }

    @Override // androidx.appcompat.app.b.a
    public COUIAlertDialogBuilder setNeutralButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        super.setNeutralButton(charSequence, onClickListener);
        setHasSetButton(true);
        return this;
    }

    @Override // androidx.appcompat.app.b.a
    public COUIAlertDialogBuilder setPositiveButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        super.setPositiveButton(charSequence, onClickListener);
        setHasSetButton(true);
        return this;
    }

    @Override // androidx.appcompat.app.b.a
    public COUIAlertDialogBuilder setTitle(int i10) {
        this.hasTitle = !TextUtils.isEmpty(getContext().getString(i10));
        super.setTitle(i10);
        return this;
    }

    public androidx.appcompat.app.b create(View view) {
        if (!isMiddleAndLargeScreen(getContext().getResources().getConfiguration())) {
            view = null;
        }
        this.mAnchorView = view;
        return create();
    }

    public COUIAlertDialogBuilder setItems(int i10, DialogInterface.OnClickListener onClickListener, int[] iArr) {
        this.mItems = getContext().getResources().getTextArray(i10);
        this.mItemClickListener = onClickListener;
        this.mTextColor = iArr;
        super.setItems(i10, onClickListener);
        return this;
    }

    public COUIAlertDialogBuilder setNegativeButton(int i10, DialogInterface.OnClickListener onClickListener, boolean z10) {
        super.setNegativeButton(i10, onClickListener);
        setHasSetButton(true);
        if (z10) {
            this.mRecommendButtonId = R.id.button2;
        }
        return this;
    }

    public COUIAlertDialogBuilder setNeutralButton(int i10, DialogInterface.OnClickListener onClickListener, boolean z10) {
        super.setNeutralButton(i10, onClickListener);
        setHasSetButton(true);
        if (z10) {
            this.mRecommendButtonId = R.id.button3;
        }
        return this;
    }

    public COUIAlertDialogBuilder setPositiveButton(int i10, DialogInterface.OnClickListener onClickListener, boolean z10) {
        super.setPositiveButton(i10, onClickListener);
        setHasSetButton(true);
        if (z10) {
            this.mRecommendButtonId = R.id.button1;
        }
        return this;
    }

    public androidx.appcompat.app.b create(View view, Point point) {
        return create(view, point.x, point.y);
    }

    public androidx.appcompat.app.b create(View view, int i10, int i11) {
        return createWithExtraOffset(view, i10, i11, 0, 0);
    }

    @Override // androidx.appcompat.app.b.a
    public COUIAlertDialogBuilder setItems(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
        this.mItems = charSequenceArr;
        this.mItemClickListener = onClickListener;
        super.setItems(charSequenceArr, onClickListener);
        return this;
    }

    public COUIAlertDialogBuilder setNegativeButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener, boolean z10) {
        super.setNegativeButton(charSequence, onClickListener);
        setHasSetButton(true);
        if (z10) {
            this.mRecommendButtonId = R.id.button2;
        }
        return this;
    }

    public COUIAlertDialogBuilder setNeutralButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener, boolean z10) {
        super.setNeutralButton(charSequence, onClickListener);
        setHasSetButton(true);
        if (z10) {
            this.mRecommendButtonId = R.id.button3;
        }
        return this;
    }

    public COUIAlertDialogBuilder setPositiveButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener, boolean z10) {
        super.setPositiveButton(charSequence, onClickListener);
        setHasSetButton(true);
        if (z10) {
            this.mRecommendButtonId = R.id.button1;
        }
        return this;
    }

    public COUIAlertDialogBuilder(Context context, int i10, int i11) {
        super(wrapColorContext(context, i10, i11));
        this.hasTitle = false;
        this.hasMessage = false;
        this.hasAdapter = false;
        this.mHasLoading = false;
        this.isAssignMentLayout = false;
        this.mCOUIListDialogAdapter = null;
        this.hasSetView = false;
        this.mDialogWindowType = 0;
        this.mChoiceListAdapter = null;
        this.hasSetButton = false;
        this.mAnchorView = null;
        this.mAnchorViewTouchPoint = null;
        this.mExtraOffsetPoint = null;
        this.mOriginWidth = -1;
        this.mButtonLayoutDynamicLayout = true;
        this.mIsTinyStyle = false;
        this.mRegisterConfigurationChangeCallBack = true;
        this.mIsForceCenterInLargeScreen = false;
        this.mForcePhysicalDimensions = false;
        this.mRecommendButtonId = -1;
        this.mIsCustomStyle = false;
        this.mHasMessageMerge = false;
        this.mBlurBackgroundWindow = false;
        this.mIsCOUIDarkTheme = true;
        this.mIsBlurEnable = true;
        this.mComponentCallbacks = new ComponentCallbacks() { // from class: com.coui.appcompat.dialog.COUIAlertDialogBuilder.4
            @Override // android.content.ComponentCallbacks
            public void onConfigurationChanged(Configuration configuration) {
                if (COUIAlertDialogBuilder.this.mRegisterConfigurationChangeCallBack) {
                    COUIAlertDialogBuilder.this.mConfiguration = configuration;
                    COUIAlertDialogBuilder.this.updateGravityWhileConfigChange(configuration);
                }
            }

            @Override // android.content.ComponentCallbacks
            public void onLowMemory() {
            }
        };
        initAttrs();
    }
}
