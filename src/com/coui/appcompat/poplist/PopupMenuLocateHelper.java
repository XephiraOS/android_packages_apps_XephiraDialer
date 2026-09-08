package com.coui.appcompat.poplist;

import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.DisplayCutout;
import android.view.View;
import android.view.ViewGroup;
import com.coui.appcompat.log.COUILog;
import com.coui.component.responsiveui.ResponsiveUIModel;
import com.coui.component.responsiveui.layoutgrid.MarginType;
import com.coui.component.responsiveui.window.WindowWidthSizeClass;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class PopupMenuLocateHelper {
    private static final boolean COUI_DEBUG;
    private static final Rect DEFAULT_ANCHOR_OUTSETS;
    private static final Rect EMPTY_OUTSETS;
    private static final String TAG = "PopupMenuLocateHelper";
    private PopupMenuConfigRule mContextAnchorConfigRule;
    private PopupMenuConfigRule mDefaultAnchorConfigRule;
    private DisplayCutout mDisplayCutout;
    private int mHorizontalOverlapBetweenMainAndSubMenu;
    private boolean mIgnoreBarrier;
    private PopupMenuControlRule mMainMenuCenterLocateXRule;
    private PopupMenuControlRule mMainMenuCenterLocateYRule;
    private PopupMenuControlRule mMainMenuGlobalOffsetRule;
    private int mMainMenuHeight;
    private PopupMenuControlRule mMainMenuLocateXRule;
    private PopupMenuControlRule mMainMenuLocateYRule;
    private PopupMenuControlRule mMainMenuRelocateRule;
    private int mMainMenuShrinkWidth;
    private int mMainMenuWidth;
    private int mMinGapBetweenMainAndSubMenu;
    private int mNavigationBarMargin;
    private ResponsiveUIModel mResponsiveUIModel;
    private int mStatusBarMargin;
    private int mSubMenuHeight;
    private PopupMenuControlRule mSubMenuLocateRule;
    private int mSubMenuWidth;
    private PopupMenuConfigRule mSubmenuAnchorConfigRule;
    private int mVerticalOverlapBetweenMainAndSubMenu;
    private PopupMenuConfigRule mWindowBottomBarrierRule;
    private PopupMenuConfigRule mWindowConfigRule;
    private PopupMenuConfigRule mWindowCutoutBarrierRule;
    private PopupMenuConfigRule mWindowLeftBarrierRule;
    private PopupMenuConfigRule mWindowRightBarrierRule;
    private PopupMenuConfigRule mWindowTopBarrierRule;
    final Rect mApplicationWindow = new Rect();
    private final Rect mContentVisibleBounds = new Rect();
    private final Rect mAnchorBounds = new Rect();
    private final Rect mAvailableBounds = new Rect();
    private final Rect mSubmenuAnchorBounds = new Rect();
    private final Rect mTempContentVisibleBounds = new Rect();
    private final int[] mOffset = new int[2];
    private final int[] mAnchorOffset = new int[2];
    private final int[] mAnchorLocationInWindow = new int[2];
    private int mGlobalOffsetX = 0;
    private int mGlobalOffsetY = 0;
    private boolean mLocateFromAboveAnchorToBelow = false;
    private boolean mIsRtl = false;
    private boolean mUseWindowBarrier = true;
    private boolean mCenterAlign = false;
    private final PopupMenuDomain mDomain = new PopupMenuDomain();
    private final PopupMenuRuleExecutor mExecutor = new PopupMenuRuleExecutor();

    /* loaded from: classes.dex */
    public static class DefaultPopupMenuConfigRule implements PopupMenuConfigRule {
        private boolean mEnabled;

        private DefaultPopupMenuConfigRule() {
            this.mEnabled = true;
        }

        @Override // com.coui.appcompat.poplist.PopupMenuConfigRule
        public int getBarrierDirection() {
            return -1;
        }

        @Override // com.coui.appcompat.poplist.PopupMenuConfigRule
        public Rect getDisplayFrame() {
            return PopupMenuLocateHelper.EMPTY_OUTSETS;
        }

        @Override // com.coui.appcompat.poplist.PopupMenuConfigRule
        public Rect getOutsets() {
            return PopupMenuLocateHelper.EMPTY_OUTSETS;
        }

        @Override // com.coui.appcompat.poplist.PopupMenuConfigRule
        public boolean getPopupMenuRuleEnabled() {
            return this.mEnabled;
        }

        @Override // com.coui.appcompat.poplist.PopupMenuConfigRule
        public int getType() {
            return 2;
        }

        @Override // com.coui.appcompat.poplist.PopupMenuConfigRule
        public void setPopupMenuRuleEnabled(boolean z10) {
            this.mEnabled = z10;
        }
    }

    static {
        boolean z10;
        if (!COUILog.LOG_DEBUG && !COUILog.isLoggable(TAG, 3)) {
            z10 = false;
        } else {
            z10 = true;
        }
        COUI_DEBUG = z10;
        EMPTY_OUTSETS = new Rect();
        DEFAULT_ANCHOR_OUTSETS = new Rect();
    }

    public PopupMenuLocateHelper(Context context) {
        this.mStatusBarMargin = 0;
        this.mNavigationBarMargin = 0;
        this.mMinGapBetweenMainAndSubMenu = 0;
        this.mHorizontalOverlapBetweenMainAndSubMenu = 0;
        this.mVerticalOverlapBetweenMainAndSubMenu = 0;
        this.mMainMenuShrinkWidth = 0;
        this.mStatusBarMargin = context.getResources().getDimensionPixelOffset(X8.f.f4727k3);
        this.mNavigationBarMargin = context.getResources().getDimensionPixelOffset(X8.f.f4618W2);
        this.mMinGapBetweenMainAndSubMenu = context.getResources().getDimensionPixelOffset(X8.f.f4695g3);
        this.mMainMenuShrinkWidth = context.getResources().getDimensionPixelOffset(X8.f.f4671d3);
        this.mHorizontalOverlapBetweenMainAndSubMenu = context.getResources().getDimensionPixelOffset(X8.f.f4647a3);
        this.mVerticalOverlapBetweenMainAndSubMenu = context.getResources().getDimensionPixelOffset(X8.f.f4735l3);
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(X8.f.f4625X2);
        DEFAULT_ANCHOR_OUTSETS.set(0, dimensionPixelOffset, 0, dimensionPixelOffset);
        setupRules();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void executeConfigRules(View view, int i10, int i11) {
        this.mDomain.reset();
        this.mExecutor.execute((PopupMenuRule) this.mWindowConfigRule, this.mDomain);
        if (!this.mIgnoreBarrier && this.mUseWindowBarrier) {
            this.mExecutor.execute((PopupMenuRule) this.mWindowLeftBarrierRule, this.mDomain).execute(this.mWindowTopBarrierRule, this.mDomain).execute(this.mWindowRightBarrierRule, this.mDomain).execute(this.mWindowBottomBarrierRule, this.mDomain).execute(this.mWindowCutoutBarrierRule, this.mDomain);
        }
        if (view instanceof PopupMenuConfigRule) {
            PopupMenuConfigRule popupMenuConfigRule = (PopupMenuConfigRule) view;
            if (popupMenuConfigRule.getType() == 1) {
                this.mExecutor.execute((PopupMenuRule) popupMenuConfigRule, this.mDomain);
                return;
            }
        }
        if (i10 != Integer.MIN_VALUE && i11 != Integer.MIN_VALUE) {
            this.mExecutor.execute((PopupMenuRule) this.mContextAnchorConfigRule, this.mDomain);
        } else {
            this.mExecutor.execute((PopupMenuRule) this.mDefaultAnchorConfigRule, this.mDomain);
        }
    }

    private void executeShowMainMenu() {
        if (this.mCenterAlign) {
            this.mExecutor.execute((PopupMenuRule) this.mMainMenuCenterLocateXRule, this.mDomain).execute(this.mMainMenuCenterLocateYRule, this.mDomain);
        } else {
            this.mExecutor.execute((PopupMenuRule) this.mMainMenuLocateXRule, this.mDomain).execute(this.mMainMenuLocateYRule, this.mDomain);
        }
        this.mExecutor.execute((PopupMenuRule) this.mMainMenuGlobalOffsetRule, this.mDomain);
    }

    private void executeShowSubMenu() {
        this.mExecutor.execute((PopupMenuRule) this.mSubmenuAnchorConfigRule, this.mDomain).execute(this.mMainMenuRelocateRule, this.mDomain).execute(this.mSubMenuLocateRule, this.mDomain);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void findAllBarrierRulesAndExecute(View view) {
        if (view.getVisibility() != 0) {
            return;
        }
        if (view instanceof PopupMenuConfigRule) {
            PopupMenuConfigRule popupMenuConfigRule = (PopupMenuConfigRule) view;
            if (popupMenuConfigRule.getType() == 2) {
                this.mExecutor.execute((PopupMenuRule) popupMenuConfigRule, this.mDomain);
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                findAllBarrierRulesAndExecute(viewGroup.getChildAt(i10));
            }
        }
    }

    private void getGlobalVisibleRectWithoutTransformation(View view, Rect rect) {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        view.getLocationInWindow(this.mAnchorLocationInWindow);
        int[] iArr = this.mAnchorLocationInWindow;
        rect.offset(iArr[0], iArr[1]);
        float width = rect.width() / view.getScaleX();
        int width2 = (int) ((width - rect.width()) * (view.getPivotX() / width));
        float height = rect.height() / view.getScaleY();
        int height2 = (int) ((height - rect.height()) * (view.getPivotY() / height));
        if (COUI_DEBUG) {
            Log.d(TAG, "bounds with scale transform = " + rect + " origin width = " + width + " origin height = " + height + " offset x = " + width2 + " offset y = " + height2);
        }
        rect.set(rect.left - width2, rect.top - height2, rect.right + width2, rect.bottom + height2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupMainMenuGlobalOffsetRule$0(PopupMenuDomain popupMenuDomain) {
        int i10 = this.mGlobalOffsetX;
        popupMenuDomain.mGlobalOffsetX = i10;
        popupMenuDomain.mGlobalOffsetY = this.mGlobalOffsetY;
        int min = Math.min(Math.max(this.mAvailableBounds.left, popupMenuDomain.mMainMenu.left + i10), this.mAvailableBounds.right - popupMenuDomain.mMainMenu.width());
        int min2 = Math.min(Math.max(this.mAvailableBounds.top, popupMenuDomain.mMainMenu.top + this.mGlobalOffsetY), this.mAvailableBounds.bottom - popupMenuDomain.mMainMenu.height());
        Rect rect = popupMenuDomain.mMainMenu;
        rect.set(min, min2, rect.width() + min, popupMenuDomain.mMainMenu.height() + min2);
    }

    private void setAnchor(View view, int i10, int i11, View view2) {
        getGlobalVisibleRectWithoutTransformation(view, this.mAnchorBounds);
        if (i10 != Integer.MIN_VALUE && i11 != Integer.MIN_VALUE) {
            Rect rect = this.mAnchorBounds;
            int i12 = rect.left;
            int i13 = rect.top;
            rect.set(i12 + i10, i13 + i11, i12 + i10, i13 + i11);
        }
        Rect rect2 = this.mContentVisibleBounds;
        int[] iArr = this.mOffset;
        rect2.offset(-iArr[0], -iArr[1]);
        Rect rect3 = this.mContentVisibleBounds;
        rect3.bottom = Math.min(rect3.bottom, this.mApplicationWindow.bottom);
        ResponsiveUIModel responsiveUIModel = this.mResponsiveUIModel;
        if (responsiveUIModel == null) {
            ResponsiveUIModel responsiveUIModel2 = new ResponsiveUIModel(view.getContext(), Math.abs(this.mApplicationWindow.width()), Math.abs(this.mApplicationWindow.height()));
            this.mResponsiveUIModel = responsiveUIModel2;
            responsiveUIModel2.chooseMargin(MarginType.MARGIN_SMALL);
        } else {
            responsiveUIModel.rebuild(Math.abs(this.mApplicationWindow.width()), Math.abs(this.mApplicationWindow.height()));
        }
        if (!view.getRootView().isAttachedToWindow()) {
            Log.d(TAG, "Detected an unattached anchor, could be a dummy anchor");
            this.mIgnoreBarrier = true;
        }
    }

    private void setSubmenuAnchor(View view) {
        view.getGlobalVisibleRect(this.mSubmenuAnchorBounds);
    }

    private void setupContextAnchorConfigRule() {
        this.mContextAnchorConfigRule = new DefaultPopupMenuConfigRule() { // from class: com.coui.appcompat.poplist.PopupMenuLocateHelper.7
            @Override // com.coui.appcompat.poplist.PopupMenuLocateHelper.DefaultPopupMenuConfigRule, com.coui.appcompat.poplist.PopupMenuConfigRule
            public int getBarrierDirection() {
                return -1;
            }

            @Override // com.coui.appcompat.poplist.PopupMenuLocateHelper.DefaultPopupMenuConfigRule, com.coui.appcompat.poplist.PopupMenuConfigRule
            public Rect getDisplayFrame() {
                return PopupMenuLocateHelper.this.mAnchorBounds;
            }

            @Override // com.coui.appcompat.poplist.PopupMenuLocateHelper.DefaultPopupMenuConfigRule, com.coui.appcompat.poplist.PopupMenuConfigRule
            public Rect getOutsets() {
                return PopupMenuLocateHelper.EMPTY_OUTSETS;
            }

            @Override // com.coui.appcompat.poplist.PopupMenuLocateHelper.DefaultPopupMenuConfigRule, com.coui.appcompat.poplist.PopupMenuConfigRule
            public int getType() {
                return 1;
            }
        };
    }

    private void setupDefaultAnchorConfigRule() {
        this.mDefaultAnchorConfigRule = new DefaultPopupMenuConfigRule() { // from class: com.coui.appcompat.poplist.PopupMenuLocateHelper.8
            @Override // com.coui.appcompat.poplist.PopupMenuLocateHelper.DefaultPopupMenuConfigRule, com.coui.appcompat.poplist.PopupMenuConfigRule
            public int getBarrierDirection() {
                return -1;
            }

            @Override // com.coui.appcompat.poplist.PopupMenuLocateHelper.DefaultPopupMenuConfigRule, com.coui.appcompat.poplist.PopupMenuConfigRule
            public Rect getDisplayFrame() {
                return PopupMenuLocateHelper.this.mAnchorBounds;
            }

            @Override // com.coui.appcompat.poplist.PopupMenuLocateHelper.DefaultPopupMenuConfigRule, com.coui.appcompat.poplist.PopupMenuConfigRule
            public Rect getOutsets() {
                return PopupMenuLocateHelper.DEFAULT_ANCHOR_OUTSETS;
            }

            @Override // com.coui.appcompat.poplist.PopupMenuLocateHelper.DefaultPopupMenuConfigRule, com.coui.appcompat.poplist.PopupMenuConfigRule
            public int getType() {
                return 1;
            }
        };
    }

    private void setupMainMenuCenterLocateXRule() {
        this.mMainMenuCenterLocateXRule = new PopupMenuControlRule() { // from class: com.coui.appcompat.poplist.PopupMenuLocateHelper.10
            @Override // com.coui.appcompat.poplist.PopupMenuControlRule
            public void operation(PopupMenuDomain popupMenuDomain) {
                int centerX = popupMenuDomain.mAnchor.centerX() - (PopupMenuLocateHelper.this.mMainMenuWidth / 2);
                if (PopupMenuLocateHelper.this.mAvailableBounds.right - PopupMenuLocateHelper.this.mAvailableBounds.left >= PopupMenuLocateHelper.this.mMainMenuWidth) {
                    centerX = Math.min(Math.max(centerX, PopupMenuLocateHelper.this.mAvailableBounds.left), PopupMenuLocateHelper.this.mAvailableBounds.right - PopupMenuLocateHelper.this.mMainMenuWidth);
                }
                Rect rect = popupMenuDomain.mMainMenu;
                rect.set(centerX, rect.top, PopupMenuLocateHelper.this.mMainMenuWidth + centerX, popupMenuDomain.mMainMenu.bottom);
            }
        };
    }

    private void setupMainMenuCenterLocateYRule() {
        this.mMainMenuCenterLocateYRule = new PopupMenuControlRule() { // from class: com.coui.appcompat.poplist.PopupMenuLocateHelper.11
            @Override // com.coui.appcompat.poplist.PopupMenuControlRule
            public void operation(PopupMenuDomain popupMenuDomain) {
                int centerY = popupMenuDomain.mAnchor.centerY() - (PopupMenuLocateHelper.this.mMainMenuHeight / 2);
                if (PopupMenuLocateHelper.this.mAvailableBounds.bottom - PopupMenuLocateHelper.this.mAvailableBounds.top >= PopupMenuLocateHelper.this.mMainMenuHeight) {
                    centerY = Math.min(Math.max(centerY, PopupMenuLocateHelper.this.mAvailableBounds.top), PopupMenuLocateHelper.this.mAvailableBounds.bottom - PopupMenuLocateHelper.this.mMainMenuHeight);
                }
                Rect rect = popupMenuDomain.mMainMenu;
                rect.set(rect.left, centerY, rect.right, PopupMenuLocateHelper.this.mMainMenuHeight + centerY);
            }
        };
    }

    private void setupMainMenuGlobalOffsetRule() {
        this.mMainMenuGlobalOffsetRule = new PopupMenuControlRule() { // from class: com.coui.appcompat.poplist.j
            @Override // com.coui.appcompat.poplist.PopupMenuControlRule
            public final void operation(PopupMenuDomain popupMenuDomain) {
                PopupMenuLocateHelper.this.lambda$setupMainMenuGlobalOffsetRule$0(popupMenuDomain);
            }
        };
    }

    private void setupMainMenuLocateXRule() {
        this.mMainMenuLocateXRule = new PopupMenuControlRule() { // from class: com.coui.appcompat.poplist.PopupMenuLocateHelper.12
            private int locateX() {
                int centerX = PopupMenuLocateHelper.this.mDomain.mAnchor.centerX() - (PopupMenuLocateHelper.this.mMainMenuWidth / 2);
                if (centerX < PopupMenuLocateHelper.this.mAvailableBounds.left) {
                    centerX = PopupMenuLocateHelper.this.mAvailableBounds.left;
                }
                if (PopupMenuLocateHelper.this.mMainMenuWidth + centerX > PopupMenuLocateHelper.this.mAvailableBounds.right) {
                    centerX = PopupMenuLocateHelper.this.mAvailableBounds.right - PopupMenuLocateHelper.this.mMainMenuWidth;
                }
                if (centerX < PopupMenuLocateHelper.this.mAvailableBounds.left) {
                    centerX = PopupMenuLocateHelper.this.mAvailableBounds.centerX() - (PopupMenuLocateHelper.this.mMainMenuWidth / 2);
                }
                if (PopupMenuLocateHelper.COUI_DEBUG) {
                    Log.d(PopupMenuLocateHelper.TAG, "mMainMenuLocateXRule mAnchor [left " + PopupMenuLocateHelper.this.mDomain.mAnchor.left + " top " + PopupMenuLocateHelper.this.mDomain.mAnchor.top + " right " + PopupMenuLocateHelper.this.mDomain.mAnchor.right + " bottom " + PopupMenuLocateHelper.this.mDomain.mAnchor.bottom + "] mMainMenuWidth " + PopupMenuLocateHelper.this.mMainMenuWidth + " mAvailableBounds [left " + PopupMenuLocateHelper.this.mAvailableBounds.left + " top " + PopupMenuLocateHelper.this.mAvailableBounds.top + " right " + PopupMenuLocateHelper.this.mAvailableBounds.right + " bottom " + PopupMenuLocateHelper.this.mAvailableBounds.bottom + "] result x = " + centerX);
                }
                return centerX;
            }

            @Override // com.coui.appcompat.poplist.PopupMenuControlRule
            public void operation(PopupMenuDomain popupMenuDomain) {
                int locateX = locateX();
                Rect rect = popupMenuDomain.mMainMenu;
                rect.set(locateX, rect.top, PopupMenuLocateHelper.this.mMainMenuWidth + locateX, popupMenuDomain.mMainMenu.bottom);
            }
        };
    }

    private void setupMainMenuLocateYRule() {
        this.mMainMenuLocateYRule = new PopupMenuControlRule() { // from class: com.coui.appcompat.poplist.PopupMenuLocateHelper.13

            /* renamed from: y, reason: collision with root package name */
            int f19834y = 0;

            private void locateY(Rect rect) {
                int max = Math.max(rect.bottom, PopupMenuLocateHelper.this.mAvailableBounds.top);
                int min = Math.min(rect.top, PopupMenuLocateHelper.this.mAvailableBounds.bottom);
                if (PopupMenuLocateHelper.this.mLocateFromAboveAnchorToBelow) {
                    if (!tryLocateAboveAnchor(min)) {
                        tryLocateBelowAnchor(max);
                    }
                } else if (!tryLocateBelowAnchor(max)) {
                    tryLocateAboveAnchor(min);
                }
                if (PopupMenuLocateHelper.COUI_DEBUG) {
                    Log.d(PopupMenuLocateHelper.TAG, "mMainMenuLocateYRule anchorBounds [left " + rect.left + " top " + rect.top + " right " + rect.right + " bottom " + rect.bottom + "] mMainMenuHeight " + PopupMenuLocateHelper.this.mMainMenuHeight + " mAvailableBounds [left " + PopupMenuLocateHelper.this.mAvailableBounds.left + " top " + PopupMenuLocateHelper.this.mAvailableBounds.top + " right " + PopupMenuLocateHelper.this.mAvailableBounds.right + " bottom " + PopupMenuLocateHelper.this.mAvailableBounds.bottom + "] result y = " + this.f19834y);
                }
            }

            private boolean tryLocateAboveAnchor(int i10) {
                if (i10 - PopupMenuLocateHelper.this.mAvailableBounds.top >= PopupMenuLocateHelper.this.mMainMenuHeight) {
                    this.f19834y = i10 - PopupMenuLocateHelper.this.mMainMenuHeight;
                    return true;
                }
                return false;
            }

            private boolean tryLocateBelowAnchor(int i10) {
                if (PopupMenuLocateHelper.this.mAvailableBounds.bottom - i10 >= PopupMenuLocateHelper.this.mMainMenuHeight) {
                    this.f19834y = i10;
                    return true;
                }
                return false;
            }

            @Override // com.coui.appcompat.poplist.PopupMenuControlRule
            public void operation(PopupMenuDomain popupMenuDomain) {
                Rect rect = new Rect();
                popupMenuDomain.getAnchorRealRect(rect);
                this.f19834y = PopupMenuLocateHelper.this.mAvailableBounds.top;
                locateY(rect);
                Rect rect2 = popupMenuDomain.mMainMenu;
                int i10 = rect2.left;
                int i11 = this.f19834y;
                rect2.set(i10, i11, rect2.right, PopupMenuLocateHelper.this.mMainMenuHeight + i11);
            }
        };
    }

    private void setupMainMenuRelocateRule() {
        this.mMainMenuRelocateRule = new PopupMenuControlRule() { // from class: com.coui.appcompat.poplist.PopupMenuLocateHelper.14
            private int getOffsetX(PopupMenuDomain popupMenuDomain) {
                int centerX = popupMenuDomain.mAnchor.centerX();
                int centerX2 = popupMenuDomain.mMainMenu.centerX();
                if (centerX < centerX2 - 1) {
                    return 0;
                }
                if (centerX > centerX2 + 1) {
                    return PopupMenuLocateHelper.this.mMainMenuShrinkWidth;
                }
                return PopupMenuLocateHelper.this.mMainMenuShrinkWidth / 2;
            }

            private int getOffsetY(PopupMenuDomain popupMenuDomain) {
                if (popupMenuDomain.mMainMenu.top + PopupMenuLocateHelper.this.mMinGapBetweenMainAndSubMenu + PopupMenuLocateHelper.this.mSubMenuHeight < PopupMenuLocateHelper.this.mAvailableBounds.bottom) {
                    return 0;
                }
                return ((PopupMenuLocateHelper.this.mAvailableBounds.bottom - PopupMenuLocateHelper.this.mSubMenuHeight) - PopupMenuLocateHelper.this.mMinGapBetweenMainAndSubMenu) - popupMenuDomain.mMainMenu.top;
            }

            @Override // com.coui.appcompat.poplist.PopupMenuControlRule
            public void operation(PopupMenuDomain popupMenuDomain) {
                if (PopupMenuLocateHelper.this.isCurrentContainerSmallScreen()) {
                    Rect rect = popupMenuDomain.mMainMenuRelocated;
                    Rect rect2 = popupMenuDomain.mMainMenu;
                    rect.set(rect2.left, rect2.top, rect2.right - PopupMenuLocateHelper.this.mMainMenuShrinkWidth, popupMenuDomain.mMainMenu.bottom - ((int) ((PopupMenuLocateHelper.this.mMainMenuShrinkWidth / popupMenuDomain.mMainMenu.width()) * popupMenuDomain.mMainMenu.height())));
                    popupMenuDomain.mMainMenuRelocated.offset(getOffsetX(popupMenuDomain), getOffsetY(popupMenuDomain));
                    return;
                }
                popupMenuDomain.mMainMenuRelocated.set(popupMenuDomain.mMainMenu);
            }
        };
    }

    private void setupRules() {
        setupWindowConfigRule();
        setupWindowLeftBarrierRule();
        setupWindowRightBarrierRule();
        setupWindowTopBarrierRule();
        setupWindowBottomBarrierRule();
        setupWindowCutoutBarrierRule();
        setupContextAnchorConfigRule();
        setupDefaultAnchorConfigRule();
        setupSubmenuAnchorConfigRule();
        setupMainMenuLocateXRule();
        setupMainMenuLocateYRule();
        setupMainMenuGlobalOffsetRule();
        setupMainMenuRelocateRule();
        setupSubMenuLocateRule();
        setupMainMenuCenterLocateXRule();
        setupMainMenuCenterLocateYRule();
    }

    private void setupSubMenuLocateRule() {
        this.mSubMenuLocateRule = new PopupMenuControlRule() { // from class: com.coui.appcompat.poplist.PopupMenuLocateHelper.15
            private int getOffsetX(PopupMenuDomain popupMenuDomain) {
                int i10;
                int i11;
                if (PopupMenuLocateHelper.this.isCurrentContainerSmallScreen()) {
                    return popupMenuDomain.mMainMenu.left;
                }
                if (PopupMenuLocateHelper.this.mIsRtl) {
                    if ((popupMenuDomain.mMainMenuRelocated.right - PopupMenuLocateHelper.this.mHorizontalOverlapBetweenMainAndSubMenu) + PopupMenuLocateHelper.this.mSubMenuWidth < PopupMenuLocateHelper.this.mAvailableBounds.right) {
                        i10 = popupMenuDomain.mMainMenuRelocated.right;
                        i11 = PopupMenuLocateHelper.this.mHorizontalOverlapBetweenMainAndSubMenu;
                    } else {
                        i10 = popupMenuDomain.mMainMenuRelocated.left + PopupMenuLocateHelper.this.mHorizontalOverlapBetweenMainAndSubMenu;
                        i11 = PopupMenuLocateHelper.this.mSubMenuWidth;
                    }
                } else if ((popupMenuDomain.mMainMenuRelocated.left + PopupMenuLocateHelper.this.mHorizontalOverlapBetweenMainAndSubMenu) - PopupMenuLocateHelper.this.mSubMenuWidth > PopupMenuLocateHelper.this.mAvailableBounds.left) {
                    i10 = popupMenuDomain.mMainMenuRelocated.left + PopupMenuLocateHelper.this.mHorizontalOverlapBetweenMainAndSubMenu;
                    i11 = PopupMenuLocateHelper.this.mSubMenuWidth;
                } else {
                    i10 = popupMenuDomain.mMainMenuRelocated.right;
                    i11 = PopupMenuLocateHelper.this.mHorizontalOverlapBetweenMainAndSubMenu;
                }
                return i10 - i11;
            }

            private int getOffsetY(PopupMenuDomain popupMenuDomain) {
                int i10;
                int i11;
                if (PopupMenuLocateHelper.this.isCurrentContainerSmallScreen()) {
                    i10 = getSubMenuAnchorTopAfterMainMenuRelocated(popupMenuDomain);
                    if ((i10 - PopupMenuLocateHelper.this.mVerticalOverlapBetweenMainAndSubMenu) + PopupMenuLocateHelper.this.mSubMenuHeight < PopupMenuLocateHelper.this.mAvailableBounds.bottom) {
                        i11 = PopupMenuLocateHelper.this.mVerticalOverlapBetweenMainAndSubMenu;
                    } else {
                        i10 = PopupMenuLocateHelper.this.mAvailableBounds.bottom;
                        i11 = PopupMenuLocateHelper.this.mSubMenuHeight;
                    }
                } else {
                    if (PopupMenuLocateHelper.this.mSubmenuAnchorBounds.top + PopupMenuLocateHelper.this.mSubMenuHeight < PopupMenuLocateHelper.this.mAvailableBounds.bottom) {
                        return PopupMenuLocateHelper.this.mSubmenuAnchorBounds.top;
                    }
                    i10 = PopupMenuLocateHelper.this.mAvailableBounds.bottom;
                    i11 = PopupMenuLocateHelper.this.mSubMenuHeight;
                }
                return i10 - i11;
            }

            private int getSubMenuAnchorTopAfterMainMenuRelocated(PopupMenuDomain popupMenuDomain) {
                float f10;
                int i10 = PopupMenuLocateHelper.this.mSubmenuAnchorBounds.top;
                Rect rect = popupMenuDomain.mMainMenu;
                int i11 = i10 - rect.top;
                if (rect.height() > 0) {
                    f10 = popupMenuDomain.mMainMenuRelocated.height() / popupMenuDomain.mMainMenu.height();
                } else {
                    f10 = 1.0f;
                }
                return (int) (popupMenuDomain.mMainMenuRelocated.top + (f10 * i11));
            }

            @Override // com.coui.appcompat.poplist.PopupMenuControlRule
            public void operation(PopupMenuDomain popupMenuDomain) {
                popupMenuDomain.mSubMenu.set(0, 0, PopupMenuLocateHelper.this.mSubMenuWidth, PopupMenuLocateHelper.this.mSubMenuHeight);
                popupMenuDomain.mSubMenu.offset(getOffsetX(popupMenuDomain), getOffsetY(popupMenuDomain));
            }
        };
    }

    private void setupSubmenuAnchorConfigRule() {
        this.mSubmenuAnchorConfigRule = new DefaultPopupMenuConfigRule() { // from class: com.coui.appcompat.poplist.PopupMenuLocateHelper.9
            @Override // com.coui.appcompat.poplist.PopupMenuLocateHelper.DefaultPopupMenuConfigRule, com.coui.appcompat.poplist.PopupMenuConfigRule
            public int getBarrierDirection() {
                return -1;
            }

            @Override // com.coui.appcompat.poplist.PopupMenuLocateHelper.DefaultPopupMenuConfigRule, com.coui.appcompat.poplist.PopupMenuConfigRule
            public Rect getDisplayFrame() {
                return PopupMenuLocateHelper.this.mSubmenuAnchorBounds;
            }

            @Override // com.coui.appcompat.poplist.PopupMenuLocateHelper.DefaultPopupMenuConfigRule, com.coui.appcompat.poplist.PopupMenuConfigRule
            public Rect getOutsets() {
                return PopupMenuLocateHelper.EMPTY_OUTSETS;
            }

            @Override // com.coui.appcompat.poplist.PopupMenuLocateHelper.DefaultPopupMenuConfigRule, com.coui.appcompat.poplist.PopupMenuConfigRule
            public int getType() {
                return 3;
            }
        };
    }

    private void setupWindowBottomBarrierRule() {
        this.mWindowBottomBarrierRule = new DefaultPopupMenuConfigRule() { // from class: com.coui.appcompat.poplist.PopupMenuLocateHelper.6
            private final Rect mDisplayFrame = new Rect();
            private final Rect mDisplayFrameOutsets;

            {
                this.mDisplayFrameOutsets = new Rect(0, PopupMenuLocateHelper.this.mNavigationBarMargin, 0, 0);
            }

            @Override // com.coui.appcompat.poplist.PopupMenuLocateHelper.DefaultPopupMenuConfigRule, com.coui.appcompat.poplist.PopupMenuConfigRule
            public int getBarrierDirection() {
                return 3;
            }

            @Override // com.coui.appcompat.poplist.PopupMenuLocateHelper.DefaultPopupMenuConfigRule, com.coui.appcompat.poplist.PopupMenuConfigRule
            public Rect getDisplayFrame() {
                PopupMenuLocateHelper popupMenuLocateHelper = PopupMenuLocateHelper.this;
                int i10 = popupMenuLocateHelper.mApplicationWindow.bottom - popupMenuLocateHelper.mContentVisibleBounds.bottom;
                Rect rect = this.mDisplayFrame;
                Rect rect2 = PopupMenuLocateHelper.this.mApplicationWindow;
                rect.set(0, rect2.bottom - i10, Math.abs(rect2.width()), PopupMenuLocateHelper.this.mApplicationWindow.bottom);
                return this.mDisplayFrame;
            }

            @Override // com.coui.appcompat.poplist.PopupMenuLocateHelper.DefaultPopupMenuConfigRule, com.coui.appcompat.poplist.PopupMenuConfigRule
            public Rect getOutsets() {
                return this.mDisplayFrameOutsets;
            }

            @Override // com.coui.appcompat.poplist.PopupMenuLocateHelper.DefaultPopupMenuConfigRule, com.coui.appcompat.poplist.PopupMenuConfigRule
            public int getType() {
                return 2;
            }
        };
    }

    private void setupWindowConfigRule() {
        this.mWindowConfigRule = new DefaultPopupMenuConfigRule() { // from class: com.coui.appcompat.poplist.PopupMenuLocateHelper.1
            @Override // com.coui.appcompat.poplist.PopupMenuLocateHelper.DefaultPopupMenuConfigRule, com.coui.appcompat.poplist.PopupMenuConfigRule
            public int getBarrierDirection() {
                return -1;
            }

            @Override // com.coui.appcompat.poplist.PopupMenuLocateHelper.DefaultPopupMenuConfigRule, com.coui.appcompat.poplist.PopupMenuConfigRule
            public Rect getDisplayFrame() {
                return PopupMenuLocateHelper.this.mApplicationWindow;
            }

            @Override // com.coui.appcompat.poplist.PopupMenuLocateHelper.DefaultPopupMenuConfigRule, com.coui.appcompat.poplist.PopupMenuConfigRule
            public Rect getOutsets() {
                return PopupMenuLocateHelper.EMPTY_OUTSETS;
            }

            @Override // com.coui.appcompat.poplist.PopupMenuLocateHelper.DefaultPopupMenuConfigRule, com.coui.appcompat.poplist.PopupMenuConfigRule
            public int getType() {
                return 0;
            }
        };
    }

    private void setupWindowCutoutBarrierRule() {
        this.mWindowCutoutBarrierRule = new DefaultPopupMenuConfigRule() { // from class: com.coui.appcompat.poplist.PopupMenuLocateHelper.5
            private final Rect mDisplayFrame = new Rect();

            @Override // com.coui.appcompat.poplist.PopupMenuLocateHelper.DefaultPopupMenuConfigRule, com.coui.appcompat.poplist.PopupMenuConfigRule
            public int getBarrierDirection() {
                if (PopupMenuLocateHelper.this.mDisplayCutout == null) {
                    return -1;
                }
                for (Rect rect : PopupMenuLocateHelper.this.mDisplayCutout.getBoundingRects()) {
                    if (rect.top == 0) {
                        return 1;
                    }
                    if (rect.bottom == PopupMenuLocateHelper.this.mContentVisibleBounds.bottom) {
                        return 3;
                    }
                    if (rect.left == 0) {
                        return 0;
                    }
                    if (rect.right == PopupMenuLocateHelper.this.mContentVisibleBounds.right) {
                        return 2;
                    }
                }
                return 1;
            }

            @Override // com.coui.appcompat.poplist.PopupMenuLocateHelper.DefaultPopupMenuConfigRule, com.coui.appcompat.poplist.PopupMenuConfigRule
            public Rect getDisplayFrame() {
                if (PopupMenuLocateHelper.this.mDisplayCutout == null) {
                    return this.mDisplayFrame;
                }
                for (Rect rect : PopupMenuLocateHelper.this.mDisplayCutout.getBoundingRects()) {
                    if (rect.top == 0) {
                        this.mDisplayFrame.set(0, 0, PopupMenuLocateHelper.this.mApplicationWindow.width(), PopupMenuLocateHelper.this.mContentVisibleBounds.top + rect.bottom);
                    } else if (rect.bottom == PopupMenuLocateHelper.this.mContentVisibleBounds.bottom) {
                        this.mDisplayFrame.set(0, rect.top, Math.abs(PopupMenuLocateHelper.this.mApplicationWindow.width()), PopupMenuLocateHelper.this.mApplicationWindow.bottom);
                    } else if (rect.left == 0) {
                        this.mDisplayFrame.set(0, 0, rect.right, Math.abs(PopupMenuLocateHelper.this.mApplicationWindow.height()));
                    } else if (rect.right == PopupMenuLocateHelper.this.mContentVisibleBounds.right) {
                        Rect rect2 = this.mDisplayFrame;
                        int i10 = rect.left;
                        Rect rect3 = PopupMenuLocateHelper.this.mApplicationWindow;
                        rect2.set(i10, 0, rect3.right, Math.abs(rect3.height()));
                    }
                }
                return this.mDisplayFrame;
            }

            @Override // com.coui.appcompat.poplist.PopupMenuLocateHelper.DefaultPopupMenuConfigRule, com.coui.appcompat.poplist.PopupMenuConfigRule
            public Rect getOutsets() {
                return PopupMenuLocateHelper.EMPTY_OUTSETS;
            }

            @Override // com.coui.appcompat.poplist.PopupMenuLocateHelper.DefaultPopupMenuConfigRule, com.coui.appcompat.poplist.PopupMenuConfigRule
            public int getType() {
                return 2;
            }
        };
    }

    private void setupWindowLeftBarrierRule() {
        this.mWindowLeftBarrierRule = new DefaultPopupMenuConfigRule() { // from class: com.coui.appcompat.poplist.PopupMenuLocateHelper.2
            private final Rect mDisplayFrame = new Rect();

            @Override // com.coui.appcompat.poplist.PopupMenuLocateHelper.DefaultPopupMenuConfigRule, com.coui.appcompat.poplist.PopupMenuConfigRule
            public int getBarrierDirection() {
                return 0;
            }

            @Override // com.coui.appcompat.poplist.PopupMenuLocateHelper.DefaultPopupMenuConfigRule, com.coui.appcompat.poplist.PopupMenuConfigRule
            public Rect getDisplayFrame() {
                this.mDisplayFrame.set(0, 0, Math.max(PopupMenuLocateHelper.this.mResponsiveUIModel.margin(), PopupMenuLocateHelper.this.mContentVisibleBounds.left), Math.abs(PopupMenuLocateHelper.this.mApplicationWindow.height()));
                return this.mDisplayFrame;
            }

            @Override // com.coui.appcompat.poplist.PopupMenuLocateHelper.DefaultPopupMenuConfigRule, com.coui.appcompat.poplist.PopupMenuConfigRule
            public Rect getOutsets() {
                return PopupMenuLocateHelper.EMPTY_OUTSETS;
            }

            @Override // com.coui.appcompat.poplist.PopupMenuLocateHelper.DefaultPopupMenuConfigRule, com.coui.appcompat.poplist.PopupMenuConfigRule
            public int getType() {
                return 2;
            }
        };
    }

    private void setupWindowRightBarrierRule() {
        this.mWindowRightBarrierRule = new DefaultPopupMenuConfigRule() { // from class: com.coui.appcompat.poplist.PopupMenuLocateHelper.3
            private final Rect mDisplayFrame = new Rect();

            @Override // com.coui.appcompat.poplist.PopupMenuLocateHelper.DefaultPopupMenuConfigRule, com.coui.appcompat.poplist.PopupMenuConfigRule
            public int getBarrierDirection() {
                return 2;
            }

            @Override // com.coui.appcompat.poplist.PopupMenuLocateHelper.DefaultPopupMenuConfigRule, com.coui.appcompat.poplist.PopupMenuConfigRule
            public Rect getDisplayFrame() {
                int margin = PopupMenuLocateHelper.this.mResponsiveUIModel.margin();
                PopupMenuLocateHelper popupMenuLocateHelper = PopupMenuLocateHelper.this;
                int max = Math.max(margin, popupMenuLocateHelper.mApplicationWindow.right - popupMenuLocateHelper.mContentVisibleBounds.right);
                Rect rect = this.mDisplayFrame;
                Rect rect2 = PopupMenuLocateHelper.this.mApplicationWindow;
                int i10 = rect2.right;
                rect.set(i10 - max, 0, i10, Math.abs(rect2.height()));
                return this.mDisplayFrame;
            }

            @Override // com.coui.appcompat.poplist.PopupMenuLocateHelper.DefaultPopupMenuConfigRule, com.coui.appcompat.poplist.PopupMenuConfigRule
            public Rect getOutsets() {
                return PopupMenuLocateHelper.EMPTY_OUTSETS;
            }

            @Override // com.coui.appcompat.poplist.PopupMenuLocateHelper.DefaultPopupMenuConfigRule, com.coui.appcompat.poplist.PopupMenuConfigRule
            public int getType() {
                return 2;
            }
        };
    }

    private void setupWindowTopBarrierRule() {
        this.mWindowTopBarrierRule = new DefaultPopupMenuConfigRule() { // from class: com.coui.appcompat.poplist.PopupMenuLocateHelper.4
            private final Rect mDisplayFrame = new Rect();

            @Override // com.coui.appcompat.poplist.PopupMenuLocateHelper.DefaultPopupMenuConfigRule, com.coui.appcompat.poplist.PopupMenuConfigRule
            public int getBarrierDirection() {
                return 1;
            }

            @Override // com.coui.appcompat.poplist.PopupMenuLocateHelper.DefaultPopupMenuConfigRule, com.coui.appcompat.poplist.PopupMenuConfigRule
            public Rect getDisplayFrame() {
                this.mDisplayFrame.set(0, 0, Math.abs(PopupMenuLocateHelper.this.mApplicationWindow.width()), PopupMenuLocateHelper.this.mContentVisibleBounds.top + PopupMenuLocateHelper.this.mStatusBarMargin);
                return this.mDisplayFrame;
            }

            @Override // com.coui.appcompat.poplist.PopupMenuLocateHelper.DefaultPopupMenuConfigRule, com.coui.appcompat.poplist.PopupMenuConfigRule
            public Rect getOutsets() {
                return PopupMenuLocateHelper.EMPTY_OUTSETS;
            }

            @Override // com.coui.appcompat.poplist.PopupMenuLocateHelper.DefaultPopupMenuConfigRule, com.coui.appcompat.poplist.PopupMenuConfigRule
            public int getType() {
                return 2;
            }
        };
    }

    public boolean checkIfLimitedWindowOrAnchorResized(View view, int i10, int i11, View view2) {
        boolean z10 = true;
        if (view == null) {
            COUILog.e(TAG, "Anchor is null!");
            return true;
        }
        if (view2 == null) {
            view2 = view.getRootView();
        }
        view2.getWindowVisibleDisplayFrame(this.mTempContentVisibleBounds);
        if (this.mTempContentVisibleBounds.width() == this.mContentVisibleBounds.width() && this.mTempContentVisibleBounds.height() == this.mContentVisibleBounds.height()) {
            z10 = false;
        } else {
            COUILog.w(TAG, "Visible bounds changed!");
        }
        COUILog.d(TAG, " old content visible bounds = " + this.mContentVisibleBounds + " new content visible bounds = " + this.mTempContentVisibleBounds);
        this.mContentVisibleBounds.set(this.mTempContentVisibleBounds);
        return z10;
    }

    public PopupMenuDomain getDomain() {
        return this.mDomain;
    }

    public int getMaxMainMenuHeight() {
        return this.mDomain.getAvailableRectHeight();
    }

    public int getMaxSubMenuHeight() {
        if (isCurrentContainerSmallScreen()) {
            return this.mDomain.getAvailableRectHeight();
        }
        return this.mDomain.getAvailableRectHeight() - this.mMinGapBetweenMainAndSubMenu;
    }

    public boolean isCurrentContainerSmallScreen() {
        ResponsiveUIModel responsiveUIModel = this.mResponsiveUIModel;
        if (responsiveUIModel == null || responsiveUIModel.windowSizeClass().getWindowWidthSizeClass() != WindowWidthSizeClass.Compact) {
            return false;
        }
        return true;
    }

    public void prepareShowMainMenu(int i10, int i11, boolean z10, int i12, int i13) {
        this.mLocateFromAboveAnchorToBelow = z10;
        this.mGlobalOffsetX = i12;
        this.mGlobalOffsetY = i13;
        this.mDomain.getAvailableRect(this.mAvailableBounds);
        this.mMainMenuWidth = Math.min(i10, Math.abs(this.mAvailableBounds.width()));
        this.mMainMenuHeight = Math.min(i11, Math.abs(this.mAvailableBounds.height()));
        executeShowMainMenu();
        this.mDomain.dump();
    }

    public void prepareShowSubMenu(View view, int i10, int i11, boolean z10) {
        int i12;
        this.mIsRtl = z10;
        boolean isCurrentContainerSmallScreen = isCurrentContainerSmallScreen();
        setSubmenuAnchor(view);
        this.mSubMenuWidth = Math.min(i10, Math.abs(this.mAvailableBounds.width()));
        int abs = Math.abs(this.mAvailableBounds.height());
        if (isCurrentContainerSmallScreen) {
            i12 = this.mMinGapBetweenMainAndSubMenu;
        } else {
            i12 = 0;
        }
        this.mSubMenuHeight = Math.min(i11, abs - i12);
        executeShowSubMenu();
        this.mDomain.dump();
    }

    public void prepareWindowAndAnchor(View view, int i10, int i11, View view2) {
        View rootView;
        if (view2 != null) {
            rootView = view2;
        } else {
            rootView = view.getRootView();
        }
        rootView.getLocationOnScreen(this.mOffset);
        rootView.getGlobalVisibleRect(this.mApplicationWindow);
        rootView.getWindowVisibleDisplayFrame(this.mContentVisibleBounds);
        if (COUI_DEBUG) {
            Log.d(TAG, "limited window = " + rootView + " anchor = " + view + " window location = (" + this.mOffset[0] + ", " + this.mOffset[1] + ") anchor location = (" + this.mAnchorOffset[0] + ", " + this.mAnchorOffset[1] + ") final offset = (" + i10 + ", " + i11 + ") use window barrier = " + this.mUseWindowBarrier + " center align = " + this.mCenterAlign + " mApplicationWindow [left " + this.mApplicationWindow.left + " top " + this.mApplicationWindow.top + " right " + this.mApplicationWindow.right + " bottom " + this.mApplicationWindow.bottom + "]");
        }
        setAnchor(view, i10, i11, view2);
        if (view.getRootWindowInsets() != null) {
            this.mDisplayCutout = view.getRootWindowInsets().getDisplayCutout();
        }
        executeConfigRules(view, i10, i11);
        findAllBarrierRulesAndExecute(view.getRootView());
    }

    public void setCenterAlign(boolean z10) {
        this.mCenterAlign = z10;
        this.mDomain.mMainMenuCenterAlign = z10;
    }

    public void setSubMenuAnchorIsFirstItem(boolean z10) {
        this.mDomain.mSubMenuAnchorIsFirstItem = z10;
    }

    public void useWindowBarrier(boolean z10) {
        this.mUseWindowBarrier = z10;
    }
}
