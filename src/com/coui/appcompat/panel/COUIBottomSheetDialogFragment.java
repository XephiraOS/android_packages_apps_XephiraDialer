package com.coui.appcompat.panel;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import c9.C0572d;
import c9.C0574f;
import c9.C0575g;
import c9.C0576h;
import com.coui.appcompat.panel.COUIBottomSheetDialog;
import com.coui.appcompat.panel.COUIPanelFragment;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* loaded from: classes.dex */
public class COUIBottomSheetDialogFragment extends com.google.android.material.bottomsheet.b {
    private static final float PHYSICS_UNSET = Float.MIN_VALUE;
    private static final String SAVE_CAN_PULL_UP_KEY = "SAVE_CAN_PULL_UP_KEY_DRAGGABLE_KEY";
    private static final String SAVE_DRAGGABLE_KEY = "SAVE_DRAGGABLE_KEY";
    private static final String SAVE_FINAL_NAV_COLOR_AFTER_DISMISS_KEY = "SAVE_FINAL_NAV_COLOR_AFTER_DISMISS_KEY";
    private static final String SAVE_FIRST_SHOW_COLLAPSED_KEY = "SAVE_FIRST_SHOW_COLLAPSED_KEY";
    private static final String SAVE_FRAME_RATE_KEY = "SAVE_FRAME_RATE_KEY";
    private static final String SAVE_HAS_SET_PEEK_HEIGHT_KEY = "SAVE_HAS_SET_PEEK_HEIGHT_KEY";
    private static final String SAVE_HAS_SET_SKIP_COLLAPSED_KEY = "SAVE_HAS_SET_SKIP_COLLAPSED_KEY";
    private static final String SAVE_IS_EXECUTE_NAV_COLOR_ANIM_AFTER_DISMISS_KEY = "SAVE_IS_EXECUTE_NAV_COLOR_ANIM_AFTER_DISMISS_KEY";
    private static final String SAVE_IS_HANDLE_PANEL_KEY = "SAVE_IS_HANDLE_PANEL_KEY";
    private static final String SAVE_IS_IN_TINY_SCREEN_PANEL_KEY = "SAVE_IS_IN_TINY_SCREEN_PANEL_KEY";
    private static final String SAVE_PANEL_HEIGHT_KEY = "SAVE_PANEL_HEIGHT_KEY";
    private static final String SAVE_PANEL_WIDTH_KEY = "SAVE_PANEL_WIDTH_KEY";
    private static final String SAVE_PEEK_HEIGHT_KEY = "SAVE_PEEK_HEIGHT_KEY";
    private static final String SAVE_REGISTER_CONFIGURATION_KEY = "SAVE_REGISTER_CONFIGURATION_KEY";
    private static final String SAVE_SHOW_IN_MAX_HEIGHT_KEY = "SAVE_SHOW_IN_MAX_HEIGHT_KEY";
    private static final String SAVE_SKIP_COLLAPSED_KEY = "SAVE_SKIP_COLLAPSED_KEY";
    private static final String TAG = "COUIBottomSheetDialogFragment";
    private static final int UNSET_WIDTH = -1;

    @Deprecated
    private long mAlphaAnimDuration;
    private View mAnchorView;
    private BottomSheetBehavior<FrameLayout> mBehavior;
    private COUIBottomSheetDialog mBottomSheetDialog;
    private COUIBottomSheetDialog.BottomSheetDialogAnimatorListener mBottomSheetDialogAnimatorListener;
    private boolean mCanPullUp;
    private COUIPanelFragment mCurrentPanelFragment;
    private int mCurrentPanelHeight;
    private View mDialogFragmentView;
    private boolean mDisableSubExpand;
    private int mFinalNavColorAfterDismiss;
    private boolean mFirstShowCollapsed;
    private boolean mFrameRate;
    private boolean mGlobalDrag;
    private boolean mHasSetPeekHeight;
    private boolean mHasSetSkipCollapsed;
    private int mHideDragViewHeight;
    private InputMethodManager mInputMethodManager;
    private boolean mIsDraggable;
    private boolean mIsExecuteNavColorAnimAfterDismiss;
    private boolean mIsFullScreenInTinyScreen;
    private boolean mIsGestureNavigation;
    private boolean mIsHandlePanel;
    private boolean mIsInTinyScreen;
    private boolean mIsSavedInstanceState;
    private boolean mIsShowInMaxHeight;
    private OnDismissListener mOnDismissListener;
    private View mOutSideView;
    private ViewGroup mPanelContainer;
    private int mPanelHeight;
    private int mPanelWidth;
    private int mPeekHeight;
    private float mPhysicsDampingRatio;
    private float mPhysicsFrequency;
    private int mPreferWidth;
    private boolean mRegisterConfigurationChangeCallBack;
    private boolean mShouldRegisterWindowInsetsListener;
    private boolean mSkipCollapsed;

    /* loaded from: classes.dex */
    public interface OnDismissListener {
        void onDismiss();
    }

    public COUIBottomSheetDialogFragment() {
        this.mAlphaAnimDuration = 100L;
        this.mIsSavedInstanceState = false;
        this.mPeekHeight = 0;
        this.mSkipCollapsed = true;
        this.mFirstShowCollapsed = false;
        this.mIsDraggable = true;
        this.mCanPullUp = true;
        this.mIsShowInMaxHeight = false;
        this.mRegisterConfigurationChangeCallBack = true;
        this.mPhysicsFrequency = PHYSICS_UNSET;
        this.mPhysicsDampingRatio = PHYSICS_UNSET;
        this.mAnchorView = null;
        this.mBottomSheetDialogAnimatorListener = null;
        this.mDisableSubExpand = false;
        this.mShouldRegisterWindowInsetsListener = true;
        this.mPreferWidth = -1;
        this.mHasSetPeekHeight = false;
        this.mHasSetSkipCollapsed = false;
        this.mIsHandlePanel = false;
        this.mHideDragViewHeight = 0;
        this.mFrameRate = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getFragmentHeight(Fragment fragment) {
        if (fragment != null && fragment.getView() != null) {
            return fragment.getView().getHeight();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = this.mInputMethodManager;
        if (inputMethodManager != null && inputMethodManager.isActive()) {
            this.mInputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    private void initBottomSheetDialogSize() {
        int i10 = this.mPanelWidth;
        if (i10 != 0) {
            this.mBottomSheetDialog.setWidth(i10);
        }
        int i11 = this.mPanelHeight;
        if (i11 != 0) {
            this.mBottomSheetDialog.setHeight(i11);
            setCurrentPanelHeight(this.mPanelHeight);
        }
    }

    private void initFragment() {
        if (this.mCurrentPanelFragment != null) {
            if (!this.mIsSavedInstanceState) {
                getChildFragmentManager().p().s(C0574f.f12915i, this.mCurrentPanelFragment).k();
            }
            COUIPanelFragment cOUIPanelFragment = this.mCurrentPanelFragment;
            Boolean bool = Boolean.TRUE;
            cOUIPanelFragment.setShowOnFirstPanel(bool);
            this.mCurrentPanelFragment.onAdd(bool);
            setUpViewHeight(this.mPanelContainer, this.mIsShowInMaxHeight);
        }
        this.mPanelContainer.post(new Runnable() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialogFragment.1
            @Override // java.lang.Runnable
            public void run() {
                if (COUIBottomSheetDialogFragment.this.mCurrentPanelFragment == null) {
                    return;
                }
                COUIBottomSheetDialogFragment cOUIBottomSheetDialogFragment = COUIBottomSheetDialogFragment.this;
                cOUIBottomSheetDialogFragment.mOutSideView = cOUIBottomSheetDialogFragment.mBottomSheetDialog.findViewById(C0574f.f12923q);
                if (COUIBottomSheetDialogFragment.this.mOutSideView != null) {
                    COUIBottomSheetDialogFragment.this.mOutSideView.setOnTouchListener(new View.OnTouchListener() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialogFragment.1.1
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            if (motionEvent != null && motionEvent.getAction() == 1) {
                                COUIBottomSheetDialogFragment.this.mBottomSheetDialog.dismiss();
                            }
                            return true;
                        }
                    });
                }
                COUIBottomSheetDialogFragment.this.mIsSavedInstanceState = false;
                COUIBottomSheetDialogFragment cOUIBottomSheetDialogFragment2 = COUIBottomSheetDialogFragment.this;
                cOUIBottomSheetDialogFragment2.setPanelListener(cOUIBottomSheetDialogFragment2.mCurrentPanelFragment);
                COUIBottomSheetDialogFragment.this.mBottomSheetDialog.setDragableLinearLayout(COUIBottomSheetDialogFragment.this.mCurrentPanelFragment.getDraggableLinearLayout(), false);
                COUIBottomSheetDialogFragment.this.mCurrentPanelFragment.onShow(Boolean.TRUE);
            }
        });
    }

    private void preShowPanel(final COUIPanelFragment cOUIPanelFragment) {
        if (!getChildFragmentManager().y0().contains(cOUIPanelFragment) && !cOUIPanelFragment.isAdded()) {
            getChildFragmentManager().p().v(X8.a.f4326f, X8.a.f4327g, X8.a.f4323c, X8.a.f4324d).p(this.mCurrentPanelFragment).b(C0574f.f12915i, cOUIPanelFragment).i();
            cOUIPanelFragment.onAdd(Boolean.FALSE);
        }
        getChildFragmentManager().p().v(X8.a.f4326f, X8.a.f4327g, X8.a.f4323c, X8.a.f4324d).p(this.mCurrentPanelFragment).y(cOUIPanelFragment).g(null).i();
        if (this.mBottomSheetDialog.getAdjustResizeHelper() != null) {
            this.mBottomSheetDialog.getAdjustResizeHelper().recoveryScrollingParentViewPaddingBottom(this.mCurrentPanelFragment.getDraggableLinearLayout());
        }
        this.mPanelContainer.post(new Runnable() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialogFragment.4
            @Override // java.lang.Runnable
            public void run() {
                COUIBottomSheetDialogFragment.this.mCurrentPanelFragment.onHide(COUIBottomSheetDialogFragment.this.mCurrentPanelFragment.getShowOnFirstPanel());
                COUIBottomSheetDialogFragment.this.mCurrentPanelFragment = cOUIPanelFragment;
                COUIBottomSheetDialogFragment.this.mBottomSheetDialog.setDragableLinearLayout(COUIBottomSheetDialogFragment.this.mCurrentPanelFragment.getDraggableLinearLayout(), true);
                COUIBottomSheetDialogFragment.this.mCurrentPanelFragment.onShow(Boolean.FALSE);
                COUIBottomSheetDialogFragment cOUIBottomSheetDialogFragment = COUIBottomSheetDialogFragment.this;
                cOUIBottomSheetDialogFragment.setPanelListener(cOUIBottomSheetDialogFragment.mCurrentPanelFragment);
            }
        });
    }

    private void setDialogOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        COUIBottomSheetDialog cOUIBottomSheetDialog = this.mBottomSheetDialog;
        if (cOUIBottomSheetDialog != null) {
            cOUIBottomSheetDialog.setOnKeyListener(onKeyListener);
        }
    }

    private void setOnTouchOutSideViewListener(View.OnTouchListener onTouchListener) {
        COUIBottomSheetDialog cOUIBottomSheetDialog = this.mBottomSheetDialog;
        if (cOUIBottomSheetDialog != null) {
            cOUIBottomSheetDialog.setOutSideViewTouchListener(onTouchListener);
        }
    }

    private void setPanelDragListener(COUIPanelDragListener cOUIPanelDragListener) {
        COUIBottomSheetDialog cOUIBottomSheetDialog = this.mBottomSheetDialog;
        if (cOUIBottomSheetDialog != null && (cOUIBottomSheetDialog.getBehavior() instanceof COUIBottomSheetBehavior)) {
            ((COUIBottomSheetBehavior) this.mBottomSheetDialog.getBehavior()).setPanelDragListener(cOUIPanelDragListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPanelListener(COUIPanelFragment cOUIPanelFragment) {
        if (cOUIPanelFragment != null) {
            setPanelDragListener(cOUIPanelFragment.getDragPanelListener());
            setOnTouchOutSideViewListener(cOUIPanelFragment.getOutSideViewOnTouchListener());
            setDialogOnKeyListener(cOUIPanelFragment.getDialogOnKeyListener());
        }
    }

    private void setUpViewHeight(View view, boolean z10) {
        int i10;
        if (view != null) {
            if (!z10 && this.mPanelHeight == 0) {
                i10 = -2;
            } else {
                i10 = -1;
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = i10;
            view.setLayoutParams(layoutParams);
        }
    }

    public void backToFirstPanel() {
        if (this.mCurrentPanelFragment != null) {
            setCancelable(false);
            hideKeyboard(this.mDialogFragmentView);
            final int indexOf = getChildFragmentManager().y0().indexOf(this.mCurrentPanelFragment);
            final COUIPanelFragment cOUIPanelFragment = this.mCurrentPanelFragment;
            if (indexOf > 0) {
                getChildFragmentManager().p().u(X8.a.f4323c, X8.a.f4324d).y((COUIPanelFragment) getChildFragmentManager().y0().get(indexOf - 1)).p(this.mCurrentPanelFragment).k();
            }
            if (this.mBottomSheetDialog.getAdjustResizeHelper() != null) {
                this.mBottomSheetDialog.getAdjustResizeHelper().recoveryScrollingParentViewPaddingBottom(this.mCurrentPanelFragment.getDraggableLinearLayout());
            }
            this.mPanelContainer.post(new Runnable() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialogFragment.2
                @Override // java.lang.Runnable
                public void run() {
                    if (indexOf > 0) {
                        COUIBottomSheetDialogFragment.this.mCurrentPanelFragment.onHide(Boolean.FALSE);
                        COUIBottomSheetDialogFragment cOUIBottomSheetDialogFragment = COUIBottomSheetDialogFragment.this;
                        cOUIBottomSheetDialogFragment.mCurrentPanelFragment = (COUIPanelFragment) cOUIBottomSheetDialogFragment.getChildFragmentManager().y0().get(indexOf - 1);
                        COUIBottomSheetDialogFragment.this.mBottomSheetDialog.setDragableLinearLayout(COUIBottomSheetDialogFragment.this.mCurrentPanelFragment.getDraggableLinearLayout(), true);
                        COUIBottomSheetDialogFragment.this.mCurrentPanelFragment.onShow(COUIBottomSheetDialogFragment.this.mCurrentPanelFragment.getShowOnFirstPanel());
                        COUIBottomSheetDialogFragment cOUIBottomSheetDialogFragment2 = COUIBottomSheetDialogFragment.this;
                        cOUIBottomSheetDialogFragment2.setPanelListener(cOUIBottomSheetDialogFragment2.mCurrentPanelFragment);
                        COUIBottomSheetDialogFragment.this.mCurrentPanelFragment.setPanelFragmentAnimationListener(new COUIPanelFragment.PanelFragmentAnimationListener() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialogFragment.2.1
                            @Override // com.coui.appcompat.panel.COUIPanelFragment.PanelFragmentAnimationListener
                            public void onAnimationEnd() {
                                if (cOUIPanelFragment.isAdded()) {
                                    cOUIPanelFragment.onAbandon(Boolean.FALSE);
                                    COUIBottomSheetDialogFragment.this.getChildFragmentManager().p().r(cOUIPanelFragment).j();
                                }
                            }
                        });
                    }
                }
            });
            this.mPanelContainer.post(new Runnable() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialogFragment.3
                @Override // java.lang.Runnable
                public void run() {
                    COUIBottomSheetDialogFragment.this.setCancelable(true);
                }
            });
        }
    }

    public void delPreferWidth() {
        this.mPreferWidth = -1;
        COUIBottomSheetDialog cOUIBottomSheetDialog = this.mBottomSheetDialog;
        if (cOUIBottomSheetDialog != null) {
            cOUIBottomSheetDialog.delPreferWidth();
        }
        Log.d(TAG, "delPreferWidth");
    }

    @Override // com.google.android.material.bottomsheet.b, androidx.fragment.app.DialogInterfaceOnCancelListenerC0472c
    public void dismiss() {
        COUIBottomSheetDialog cOUIBottomSheetDialog = this.mBottomSheetDialog;
        if (cOUIBottomSheetDialog != null) {
            cOUIBottomSheetDialog.dismiss();
            if (this.mPreferWidth != -1) {
                this.mBottomSheetDialog.delPreferWidth();
                return;
            }
            return;
        }
        try {
            super.dismiss();
        } catch (Exception e10) {
            Log.e(TAG, e10.getMessage(), e10);
        }
    }

    public void doFeedbackAnimation() {
        COUIBottomSheetDialog cOUIBottomSheetDialog = this.mBottomSheetDialog;
        if (cOUIBottomSheetDialog != null) {
            cOUIBottomSheetDialog.doFeedbackAnimation();
        }
    }

    @Deprecated
    public long getAlphaAnimDuration() {
        return this.mAlphaAnimDuration;
    }

    public COUIBottomSheetDialog getBottomSheetDialog() {
        return this.mBottomSheetDialog;
    }

    public int getCurrentPanelHeight() {
        return this.mCurrentPanelHeight;
    }

    public boolean getIsHandlePanel() {
        return this.mIsHandlePanel;
    }

    public int getPeekHeight() {
        return this.mPeekHeight;
    }

    public boolean isFirstShowCollapsed() {
        return this.mFirstShowCollapsed;
    }

    public boolean isSkipCollapsed() {
        return this.mSkipCollapsed;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.mBottomSheetDialog != null && this.mCurrentPanelHeight != 0 && getContext() != null) {
            this.mBottomSheetDialog.setHeight(Math.min(this.mCurrentPanelHeight, COUIPanelMultiWindowUtils.getPanelMaxHeight(getContext(), configuration)));
            this.mBottomSheetDialog.updateLayoutWhileConfigChange(configuration);
        }
    }

    @Override // com.google.android.material.bottomsheet.b, androidx.appcompat.app.j, androidx.fragment.app.DialogInterfaceOnCancelListenerC0472c
    public Dialog onCreateDialog(Bundle bundle) {
        if (bundle != null) {
            this.mIsSavedInstanceState = true;
            this.mIsInTinyScreen = bundle.getBoolean(SAVE_IS_IN_TINY_SCREEN_PANEL_KEY, false);
            this.mIsDraggable = bundle.getBoolean(SAVE_DRAGGABLE_KEY, true);
            this.mPeekHeight = bundle.getInt(SAVE_PEEK_HEIGHT_KEY, 0);
            this.mSkipCollapsed = bundle.getBoolean(SAVE_SKIP_COLLAPSED_KEY, true);
            this.mFirstShowCollapsed = bundle.getBoolean(SAVE_FIRST_SHOW_COLLAPSED_KEY, false);
            this.mCanPullUp = bundle.getBoolean(SAVE_CAN_PULL_UP_KEY, true);
            this.mIsExecuteNavColorAnimAfterDismiss = bundle.getBoolean(SAVE_IS_EXECUTE_NAV_COLOR_ANIM_AFTER_DISMISS_KEY, false);
            this.mFinalNavColorAfterDismiss = bundle.getInt(SAVE_FINAL_NAV_COLOR_AFTER_DISMISS_KEY, 0);
            this.mIsShowInMaxHeight = bundle.getBoolean(SAVE_SHOW_IN_MAX_HEIGHT_KEY, false);
            this.mRegisterConfigurationChangeCallBack = bundle.getBoolean(SAVE_REGISTER_CONFIGURATION_KEY, true);
            this.mIsHandlePanel = bundle.getBoolean(SAVE_IS_HANDLE_PANEL_KEY, false);
            this.mHasSetPeekHeight = bundle.getBoolean(SAVE_HAS_SET_PEEK_HEIGHT_KEY, false);
            this.mHasSetSkipCollapsed = bundle.getBoolean(SAVE_HAS_SET_SKIP_COLLAPSED_KEY, false);
            this.mFrameRate = bundle.getBoolean(SAVE_FRAME_RATE_KEY, true);
        }
        boolean isGestureNavigation = COUINavigationBarUtil.isGestureNavigation(requireContext());
        this.mIsGestureNavigation = isGestureNavigation;
        if (this.mIsHandlePanel) {
            if (!this.mHasSetPeekHeight) {
                if (isGestureNavigation) {
                    this.mPeekHeight = getContext().getResources().getDimensionPixelOffset(C0572d.f12894q);
                } else {
                    this.mPeekHeight = getContext().getResources().getDimensionPixelOffset(C0572d.f12893p);
                }
            }
            if (!this.mHasSetSkipCollapsed) {
                this.mSkipCollapsed = false;
            }
        }
        if (getActivity() != null) {
            COUIBottomSheetDialog cOUIBottomSheetDialog = new COUIBottomSheetDialog(getActivity(), C0576h.f12933c, this.mPhysicsFrequency, this.mPhysicsDampingRatio);
            this.mBottomSheetDialog = cOUIBottomSheetDialog;
            View view = this.mAnchorView;
            if (view != null) {
                cOUIBottomSheetDialog.setAnchorView(view);
            }
            this.mBottomSheetDialog.setIsInTinyScreen(this.mIsInTinyScreen, this.mIsFullScreenInTinyScreen);
            this.mBottomSheetDialog.setDisableSubExpand(this.mDisableSubExpand);
            this.mBottomSheetDialog.setBottomSheetDialogAnimatorListener(this.mBottomSheetDialogAnimatorListener);
        }
        this.mBottomSheetDialog.setShouldRegisterWindowInsetsListener(this.mShouldRegisterWindowInsetsListener);
        this.mBottomSheetDialog.setShowInDialogFragment(true);
        this.mBottomSheetDialog.setPeekHeight(this.mPeekHeight);
        this.mBottomSheetDialog.setIsHandlePanel(this.mIsHandlePanel);
        this.mBottomSheetDialog.setSkipCollapsed(this.mSkipCollapsed);
        this.mBottomSheetDialog.setFirstShowCollapsed(this.mFirstShowCollapsed);
        this.mBottomSheetDialog.setCanPullUp(this.mCanPullUp);
        this.mBottomSheetDialog.setExecuteNavColorAnimAfterDismiss(this.mIsExecuteNavColorAnimAfterDismiss);
        this.mBottomSheetDialog.setFinalNavColorAfterDismiss(this.mFinalNavColorAfterDismiss);
        this.mBottomSheetDialog.setIsShowInMaxHeight(this.mIsShowInMaxHeight);
        this.mBottomSheetDialog.setFrameRate(this.mFrameRate);
        this.mBottomSheetDialog.setRegisterConfigurationChangeCallBack(this.mRegisterConfigurationChangeCallBack);
        this.mBottomSheetDialog.setHideDragViewHeight(this.mHideDragViewHeight);
        int i10 = this.mPreferWidth;
        if (i10 != -1) {
            this.mBottomSheetDialog.setPreferWidth(i10);
        }
        initBottomSheetDialogSize();
        BottomSheetBehavior<FrameLayout> behavior = this.mBottomSheetDialog.getBehavior();
        this.mBehavior = behavior;
        behavior.setDraggable(this.mIsDraggable);
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.mBehavior;
        if (bottomSheetBehavior instanceof COUIBottomSheetBehavior) {
            ((COUIBottomSheetBehavior) bottomSheetBehavior).setGlobalDrag(this.mGlobalDrag);
        }
        return this.mBottomSheetDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mIsShowInMaxHeight) {
            this.mDialogFragmentView = View.inflate(getActivity(), C0575g.f12926b, null);
        } else {
            this.mDialogFragmentView = View.inflate(getActivity(), C0575g.f12925a, null);
        }
        return this.mDialogFragmentView;
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0472c, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        COUIPanelFragment cOUIPanelFragment = this.mCurrentPanelFragment;
        if (cOUIPanelFragment != null) {
            cOUIPanelFragment.onAbandon(cOUIPanelFragment.getShowOnFirstPanel());
        }
        COUIBottomSheetDialog cOUIBottomSheetDialog = this.mBottomSheetDialog;
        if (cOUIBottomSheetDialog != null) {
            cOUIBottomSheetDialog.setOnKeyListener(null);
            this.mBottomSheetDialog.setOutSideViewTouchListener(null);
            OnDismissListener onDismissListener = this.mOnDismissListener;
            if (onDismissListener != null) {
                onDismissListener.onDismiss();
            }
        }
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.mBehavior;
        if (bottomSheetBehavior instanceof COUIBottomSheetBehavior) {
            ((COUIBottomSheetBehavior) bottomSheetBehavior).setPanelDragListener(null);
        }
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0472c, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(SAVE_PANEL_HEIGHT_KEY, this.mPanelHeight);
        bundle.putInt(SAVE_PANEL_WIDTH_KEY, this.mPanelWidth);
        bundle.putBoolean(SAVE_DRAGGABLE_KEY, this.mIsDraggable);
        bundle.putInt(SAVE_PEEK_HEIGHT_KEY, this.mPeekHeight);
        bundle.putBoolean(SAVE_SKIP_COLLAPSED_KEY, this.mSkipCollapsed);
        bundle.putBoolean(SAVE_FIRST_SHOW_COLLAPSED_KEY, this.mFirstShowCollapsed);
        bundle.putBoolean(SAVE_CAN_PULL_UP_KEY, this.mCanPullUp);
        bundle.putBoolean(SAVE_IS_EXECUTE_NAV_COLOR_ANIM_AFTER_DISMISS_KEY, this.mIsExecuteNavColorAnimAfterDismiss);
        bundle.putInt(SAVE_FINAL_NAV_COLOR_AFTER_DISMISS_KEY, this.mFinalNavColorAfterDismiss);
        bundle.putBoolean(SAVE_SHOW_IN_MAX_HEIGHT_KEY, this.mIsShowInMaxHeight);
        bundle.putBoolean(SAVE_IS_IN_TINY_SCREEN_PANEL_KEY, this.mIsInTinyScreen);
        bundle.putBoolean(SAVE_REGISTER_CONFIGURATION_KEY, this.mRegisterConfigurationChangeCallBack);
        bundle.putBoolean(SAVE_IS_HANDLE_PANEL_KEY, this.mIsHandlePanel);
        bundle.putBoolean(SAVE_HAS_SET_PEEK_HEIGHT_KEY, this.mHasSetPeekHeight);
        bundle.putBoolean(SAVE_HAS_SET_SKIP_COLLAPSED_KEY, this.mHasSetSkipCollapsed);
        bundle.putBoolean(SAVE_FRAME_RATE_KEY, this.mFrameRate);
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0472c, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.mBehavior;
        if (bottomSheetBehavior instanceof COUIBottomSheetBehavior) {
            bottomSheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.g() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialogFragment.5
                @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
                public void onStateChanged(View view, int i10) {
                    if (i10 == 5) {
                        COUIBottomSheetDialogFragment.this.dismissAllowingStateLoss();
                    }
                    if (i10 == 2 && ((COUIBottomSheetBehavior) COUIBottomSheetDialogFragment.this.mBehavior).isCanHideKeyboard()) {
                        COUIBottomSheetDialogFragment cOUIBottomSheetDialogFragment = COUIBottomSheetDialogFragment.this;
                        cOUIBottomSheetDialogFragment.hideKeyboard(cOUIBottomSheetDialogFragment.mDialogFragmentView);
                    }
                }

                @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
                public void onSlide(View view, float f10) {
                }
            });
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (getActivity() != null) {
            this.mInputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
        }
        ViewGroup viewGroup = (ViewGroup) this.mDialogFragmentView.findViewById(C0574f.f12915i);
        this.mPanelContainer = viewGroup;
        if (viewGroup == null) {
            return;
        }
        if (bundle != null) {
            this.mIsSavedInstanceState = true;
            this.mPanelHeight = bundle.getInt(SAVE_PANEL_HEIGHT_KEY, 0);
            this.mPanelWidth = bundle.getInt(SAVE_PANEL_WIDTH_KEY, 0);
            initBottomSheetDialogSize();
        }
        initFragment();
    }

    public void replacePanelFragment(COUIPanelFragment cOUIPanelFragment) {
        if (cOUIPanelFragment != null && this.mPanelContainer != null) {
            if (this.mBottomSheetDialog.getAdjustResizeHelper() != null) {
                this.mBottomSheetDialog.getAdjustResizeHelper().setIgnoreHideKeyboardAnim(true);
            }
            hideKeyboard(this.mDialogFragmentView);
            preShowPanel(cOUIPanelFragment);
        }
    }

    @Deprecated
    public void setAlphaAnimDuration(long j10) {
        this.mAlphaAnimDuration = j10;
    }

    public void setAnchorView(View view) {
        this.mAnchorView = view;
        COUIBottomSheetDialog cOUIBottomSheetDialog = this.mBottomSheetDialog;
        if (cOUIBottomSheetDialog != null && view != null) {
            cOUIBottomSheetDialog.setAnchorView(view);
        }
    }

    public void setBottomSheetDialogAnimatorListener(COUIBottomSheetDialog.BottomSheetDialogAnimatorListener bottomSheetDialogAnimatorListener) {
        this.mBottomSheetDialogAnimatorListener = bottomSheetDialogAnimatorListener;
    }

    public void setCanPullUp(boolean z10) {
        this.mCanPullUp = z10;
        COUIBottomSheetDialog cOUIBottomSheetDialog = this.mBottomSheetDialog;
        if (cOUIBottomSheetDialog != null) {
            cOUIBottomSheetDialog.setCanPullUp(z10);
        }
    }

    public void setCurrentPanelHeight(int i10) {
        this.mCurrentPanelHeight = i10;
    }

    public void setDisableSubExpand(boolean z10) {
        this.mDisableSubExpand = z10;
    }

    public void setDraggable(boolean z10) {
        if (this.mIsDraggable != z10) {
            this.mIsDraggable = z10;
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.mBehavior;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.setDraggable(z10);
            }
        }
    }

    public void setExecuteNavColorAnimAfterDismiss(boolean z10) {
        this.mIsExecuteNavColorAnimAfterDismiss = z10;
        if (getDialog() instanceof COUIBottomSheetDialog) {
            ((COUIBottomSheetDialog) getDialog()).setExecuteNavColorAnimAfterDismiss(z10);
        }
    }

    public void setFinalNavColorAfterDismiss(int i10) {
        this.mFinalNavColorAfterDismiss = i10;
        if (getDialog() instanceof COUIBottomSheetDialog) {
            ((COUIBottomSheetDialog) getDialog()).setFinalNavColorAfterDismiss(i10);
        }
    }

    public void setFirstShowCollapsed(boolean z10) {
        this.mFirstShowCollapsed = z10;
    }

    public void setFrameRate(boolean z10) {
        this.mFrameRate = z10;
    }

    public void setGlobalDrag(boolean z10) {
        this.mGlobalDrag = z10;
    }

    public void setHeight(int i10) {
        this.mPanelHeight = i10;
        if (this.mBottomSheetDialog != null) {
            initBottomSheetDialogSize();
        }
        if (this.mCurrentPanelFragment != null) {
            setUpViewHeight(this.mPanelContainer, this.mIsShowInMaxHeight);
        }
    }

    public void setHideDragViewHeight(int i10) {
        this.mHideDragViewHeight = i10;
        COUIBottomSheetDialog cOUIBottomSheetDialog = this.mBottomSheetDialog;
        if (cOUIBottomSheetDialog != null) {
            cOUIBottomSheetDialog.setHideDragViewHeight(i10);
        }
    }

    public void setIsHandlePanel(boolean z10) {
        this.mIsHandlePanel = z10;
    }

    public void setIsInTinyScreen(boolean z10, boolean z11) {
        this.mIsInTinyScreen = z10;
        this.mIsFullScreenInTinyScreen = z11;
        if (z10) {
            setIsShowInMaxHeight(true);
        }
    }

    public void setIsShowInMaxHeight(boolean z10) {
        this.mIsShowInMaxHeight = z10;
    }

    public void setMainPanelFragment(COUIPanelFragment cOUIPanelFragment) {
        this.mCurrentPanelFragment = cOUIPanelFragment;
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void setPanelFragment(final COUIPanelFragment cOUIPanelFragment, Boolean bool) {
        this.mCurrentPanelFragment = cOUIPanelFragment;
        this.mBottomSheetDialog.setDragableLinearLayout(cOUIPanelFragment.getDraggableLinearLayout(), true);
        this.mPanelContainer.post(new Runnable() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialogFragment.6
            @Override // java.lang.Runnable
            public void run() {
                COUIBottomSheetDialogFragment cOUIBottomSheetDialogFragment = COUIBottomSheetDialogFragment.this;
                cOUIBottomSheetDialogFragment.mCurrentPanelHeight = cOUIBottomSheetDialogFragment.getFragmentHeight(cOUIPanelFragment);
            }
        });
        setUpViewHeight(this.mPanelContainer, this.mIsShowInMaxHeight);
    }

    public void setPeekHeight(int i10) {
        this.mPeekHeight = i10;
        this.mHasSetPeekHeight = true;
    }

    public void setPreferWidth(int i10) {
        this.mPreferWidth = i10;
        Log.d(TAG, "setPreferWidth =：" + this.mPreferWidth);
    }

    public void setShouldRegisterWindowInsetsListener(boolean z10) {
        this.mShouldRegisterWindowInsetsListener = z10;
    }

    public void setSkipCollapsed(boolean z10) {
        this.mSkipCollapsed = z10;
        this.mHasSetSkipCollapsed = true;
    }

    public void setWidth(int i10) {
        this.mPanelWidth = i10;
        if (this.mBottomSheetDialog != null) {
            initBottomSheetDialogSize();
        }
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0472c
    public void show(FragmentManager fragmentManager, String str) {
        show(fragmentManager, str, null);
    }

    public boolean updateFollowHandPanelLocation() {
        COUIBottomSheetDialog cOUIBottomSheetDialog = this.mBottomSheetDialog;
        if (cOUIBottomSheetDialog == null) {
            return false;
        }
        return cOUIBottomSheetDialog.updateFollowHandPanelLocation();
    }

    public void show(FragmentManager fragmentManager, String str, View view) {
        COUIBottomSheetDialog cOUIBottomSheetDialog;
        if (isAdded()) {
            return;
        }
        int i10 = this.mPreferWidth;
        if (i10 != -1 && (cOUIBottomSheetDialog = this.mBottomSheetDialog) != null) {
            cOUIBottomSheetDialog.setPreferWidth(i10);
        }
        if (this.mCurrentPanelFragment == null) {
            this.mCurrentPanelFragment = new COUIPanelFragment();
        }
        this.mCurrentPanelFragment.setIsInTinyScreen(this.mIsInTinyScreen);
        this.mAnchorView = view;
        super.show(fragmentManager, str);
    }

    public void dismiss(boolean z10) {
        COUIBottomSheetDialog cOUIBottomSheetDialog = this.mBottomSheetDialog;
        if (cOUIBottomSheetDialog != null) {
            cOUIBottomSheetDialog.dismiss(z10);
            if (this.mPreferWidth != -1) {
                this.mBottomSheetDialog.delPreferWidth();
                return;
            }
            return;
        }
        try {
            super.dismiss();
        } catch (Exception e10) {
            Log.e(TAG, e10.getMessage(), e10);
        }
    }

    public COUIBottomSheetDialogFragment(float f10, float f11) {
        this.mAlphaAnimDuration = 100L;
        this.mIsSavedInstanceState = false;
        this.mPeekHeight = 0;
        this.mSkipCollapsed = true;
        this.mFirstShowCollapsed = false;
        this.mIsDraggable = true;
        this.mCanPullUp = true;
        this.mIsShowInMaxHeight = false;
        this.mRegisterConfigurationChangeCallBack = true;
        this.mAnchorView = null;
        this.mBottomSheetDialogAnimatorListener = null;
        this.mDisableSubExpand = false;
        this.mShouldRegisterWindowInsetsListener = true;
        this.mPreferWidth = -1;
        this.mHasSetPeekHeight = false;
        this.mHasSetSkipCollapsed = false;
        this.mIsHandlePanel = false;
        this.mHideDragViewHeight = 0;
        this.mFrameRate = true;
        this.mPhysicsFrequency = f10;
        this.mPhysicsDampingRatio = f11;
    }
}
