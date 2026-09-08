package com.coui.appcompat.panel;

import X8.e;
import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import c9.C0572d;
import c9.C0573e;
import c9.C0574f;
import c9.C0575g;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.coui.appcompat.toolbar.COUIToolbar;
import java.io.Serializable;

/* loaded from: classes.dex */
public class COUIPanelFragment extends Fragment implements Serializable {
    private static final long ENTER_MASK_ALPHA_ANIM_DURATION = 350;
    private static final long EXIT_MASK_ALPHA_ANIM_DURATION = 300;
    private static final long MASK_ALPHA = 255;
    private static final String SAVE_IS_IN_TINY_SCREEN_PANEL_KEY = "SAVE_IS_IN_TINY_SCREEN_PANEL_KEY";
    private static final String SAVE_IS_SHOW_IN_FIRST_PANEL_KEY = "SAVE_IS_SHOW_IN_FIRST_PANEL_KEY";
    private View mContentView;
    private DialogInterface.OnKeyListener mDialogOnKeyListener;
    private COUIPanelDragListener mDragPanelListener;
    private View mDragView;
    protected boolean mIsInTinyScreen;
    private Boolean mIsShowOnFirstPanel = Boolean.FALSE;
    private View.OnTouchListener mOutSideViewOnTouchListener;
    private COUIPanelBarView mPanelBarView;
    private PanelFragmentAnimationListener mPanelFragmentAnimationListener;
    private COUIPanelContentLayout mPanelView;
    private View mTitleView;
    private FrameLayout mTitleViewLayout;
    private COUIToolbar mToolbar;
    private static final Interpolator ENTER_MASK_ALPHA_ANIM_INTERPOLATOR = new PathInterpolator(0.3f, 0.26f, 0.4f, 1.0f);
    private static final Interpolator EXIT_MASK_ALPHA_ANIM_INTERPOLATOR = new PathInterpolator(0.3f, 0.15f, 0.3f, 1.0f);

    /* loaded from: classes.dex */
    public interface PanelFragmentAnimationListener {
        void onAnimationEnd();
    }

    private void ensurePanelView() {
        int i10;
        if (this.mPanelView == null) {
            LayoutInflater layoutInflater = getLayoutInflater();
            if (this.mIsInTinyScreen) {
                i10 = C0575g.f12930f;
            } else {
                i10 = C0575g.f12929e;
            }
            this.mPanelView = (COUIPanelContentLayout) layoutInflater.inflate(i10, (ViewGroup) null);
        }
    }

    private void setBottomButtonBar(String str, View.OnClickListener onClickListener, String str2, View.OnClickListener onClickListener2, String str3, View.OnClickListener onClickListener3) {
        ensurePanelView();
        this.mPanelView.setUpBottomBar(true, str, onClickListener, str2, onClickListener2, str3, onClickListener3);
    }

    public Button getCenterButton() {
        COUIPanelContentLayout cOUIPanelContentLayout = this.mPanelView;
        if (cOUIPanelContentLayout != null) {
            return (Button) cOUIPanelContentLayout.findViewById(R.id.button3);
        }
        return null;
    }

    public int getContentResId() {
        return C0574f.f12916j;
    }

    public View getContentView() {
        return this.mContentView;
    }

    public DialogInterface.OnKeyListener getDialogOnKeyListener() {
        return this.mDialogOnKeyListener;
    }

    public COUIPanelDragListener getDragPanelListener() {
        return this.mDragPanelListener;
    }

    public View getDragView() {
        return this.mDragView;
    }

    public int getDragViewHeight() {
        View view = this.mDragView;
        if (view != null) {
            return view.getHeight();
        }
        return 0;
    }

    public COUIPanelContentLayout getDraggableLinearLayout() {
        return this.mPanelView;
    }

    public Button getLeftButton() {
        COUIPanelContentLayout cOUIPanelContentLayout = this.mPanelView;
        if (cOUIPanelContentLayout != null) {
            return (Button) cOUIPanelContentLayout.findViewById(R.id.button2);
        }
        return null;
    }

    public View.OnTouchListener getOutSideViewOnTouchListener() {
        return this.mOutSideViewOnTouchListener;
    }

    public COUIPanelBarView getPanelBarView() {
        return this.mPanelBarView;
    }

    public Button getRightButton() {
        COUIPanelContentLayout cOUIPanelContentLayout = this.mPanelView;
        if (cOUIPanelContentLayout != null) {
            return (Button) cOUIPanelContentLayout.findViewById(R.id.button1);
        }
        return null;
    }

    public Boolean getShowOnFirstPanel() {
        return this.mIsShowOnFirstPanel;
    }

    public View getTitleView() {
        return this.mTitleView;
    }

    public COUIToolbar getToolbar() {
        return this.mToolbar;
    }

    public int getToolbarHeight() {
        COUIToolbar cOUIToolbar = this.mToolbar;
        if (cOUIToolbar != null) {
            return cOUIToolbar.getHeight();
        }
        return 0;
    }

    public void hideDragView() {
        ViewGroup.LayoutParams layoutParams = getDragView().getLayoutParams();
        layoutParams.height = getDragView().getContext().getResources().getDimensionPixelSize(C0572d.f12897t);
        getDragView().setVisibility(4);
        getDragView().setLayoutParams(layoutParams);
    }

    public void onAbandon(Boolean bool) {
        setPanelDragListener(null);
        setDialogOnKeyListener(null);
        setOutSideViewOnTouchListener(null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (bundle != null) {
            this.mIsShowOnFirstPanel = Boolean.valueOf(bundle.getBoolean(SAVE_IS_SHOW_IN_FIRST_PANEL_KEY, false));
            if (getParentFragment() instanceof COUIBottomSheetDialogFragment) {
                ((COUIBottomSheetDialogFragment) getParentFragment()).setPanelFragment(this, this.mIsShowOnFirstPanel);
            }
        }
        initView(this.mPanelView);
    }

    @Override // androidx.fragment.app.Fragment
    public Animation onCreateAnimation(int i10, boolean z10, int i11) {
        final ValueAnimator valueAnimator;
        Animation animation;
        final Drawable drawable = getContext().getDrawable(C0573e.f12905b);
        drawable.setTint(COUIContextUtil.getColor(getContext(), e.f4444j));
        drawable.setAlpha(0);
        if (i11 == X8.a.f4327g) {
            valueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
            valueAnimator.setDuration(EXIT_MASK_ALPHA_ANIM_DURATION);
            valueAnimator.setInterpolator(EXIT_MASK_ALPHA_ANIM_INTERPOLATOR);
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.panel.COUIPanelFragment.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    drawable.setAlpha((int) (((Float) valueAnimator2.getAnimatedValue()).floatValue() * 255.0f));
                }
            });
            animation = AnimationUtils.loadAnimation(getContext(), i11);
        } else {
            valueAnimator = null;
            animation = null;
        }
        if (i11 == X8.a.f4323c) {
            valueAnimator = ValueAnimator.ofFloat(1.0f, 0.0f);
            valueAnimator.setDuration(ENTER_MASK_ALPHA_ANIM_DURATION);
            valueAnimator.setInterpolator(ENTER_MASK_ALPHA_ANIM_INTERPOLATOR);
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.panel.COUIPanelFragment.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    drawable.setAlpha((int) (((Float) valueAnimator2.getAnimatedValue()).floatValue() * 255.0f));
                }
            });
            valueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.coui.appcompat.panel.COUIPanelFragment.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    if (COUIPanelFragment.this.mPanelFragmentAnimationListener != null) {
                        COUIPanelFragment.this.mPanelFragmentAnimationListener.onAnimationEnd();
                    }
                }
            });
            animation = AnimationUtils.loadAnimation(getContext(), i11);
        }
        if (valueAnimator != null && animation != null) {
            animation.setAnimationListener(new Animation.AnimationListener() { // from class: com.coui.appcompat.panel.COUIPanelFragment.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation2) {
                    COUIPanelFragment.this.mPanelView.setForeground(null);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation2) {
                    COUIPanelFragment.this.mPanelView.setForeground(drawable);
                    valueAnimator.start();
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation2) {
                }
            });
            return animation;
        }
        return super.onCreateAnimation(i10, z10, i11);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i10;
        if (bundle != null) {
            this.mIsInTinyScreen = bundle.getBoolean(SAVE_IS_IN_TINY_SCREEN_PANEL_KEY, false);
        }
        LayoutInflater layoutInflater2 = getLayoutInflater();
        if (this.mIsInTinyScreen) {
            i10 = C0575g.f12930f;
        } else {
            i10 = C0575g.f12929e;
        }
        COUIPanelContentLayout cOUIPanelContentLayout = (COUIPanelContentLayout) layoutInflater2.inflate(i10, (ViewGroup) null);
        this.mPanelView = cOUIPanelContentLayout;
        cOUIPanelContentLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.mDragView = this.mPanelView.getDragView();
        this.mPanelBarView = this.mPanelView.getPanelBarView();
        View inflate = layoutInflater.inflate(C0575g.f12928d, viewGroup, false);
        this.mToolbar = (COUIToolbar) inflate.findViewById(C0574f.f12908b);
        this.mTitleViewLayout = (FrameLayout) inflate.findViewById(C0574f.f12921o);
        this.mContentView = inflate.findViewById(getContentResId());
        this.mPanelView.addContentView(inflate);
        return this.mPanelView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(SAVE_IS_SHOW_IN_FIRST_PANEL_KEY, this.mIsShowOnFirstPanel.booleanValue());
        bundle.putBoolean(SAVE_IS_IN_TINY_SCREEN_PANEL_KEY, this.mIsInTinyScreen);
    }

    public void setContentView(View view) {
        this.mContentView = view;
    }

    public void setDialogOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.mDialogOnKeyListener = onKeyListener;
    }

    public void setIsInTinyScreen(boolean z10) {
        this.mIsInTinyScreen = z10;
    }

    public void setOutSideViewOnTouchListener(View.OnTouchListener onTouchListener) {
        this.mOutSideViewOnTouchListener = onTouchListener;
    }

    public void setPanelDragListener(COUIPanelDragListener cOUIPanelDragListener) {
        this.mDragPanelListener = cOUIPanelDragListener;
    }

    public void setPanelFragmentAnimationListener(PanelFragmentAnimationListener panelFragmentAnimationListener) {
        this.mPanelFragmentAnimationListener = panelFragmentAnimationListener;
    }

    public void setShowOnFirstPanel(Boolean bool) {
        this.mIsShowOnFirstPanel = bool;
    }

    public void setTitleView(int i10) {
        if (i10 > 0) {
            setTitleView(LayoutInflater.from(getContext()).inflate(i10, (ViewGroup) this.mTitleViewLayout, false));
        }
    }

    public void setToolbar(COUIToolbar cOUIToolbar) {
        if (cOUIToolbar != null && this.mToolbar != null) {
            this.mTitleViewLayout.setVisibility(8);
            this.mToolbar.setVisibility(0);
            this.mToolbar = cOUIToolbar;
        }
    }

    public void showDragView() {
        ViewGroup.LayoutParams layoutParams = getDragView().getLayoutParams();
        layoutParams.height = getDragView().getContext().getResources().getDimensionPixelSize(C0572d.f12896s);
        getDragView().setVisibility(0);
        getDragView().setLayoutParams(layoutParams);
    }

    public void setTitleView(View view) {
        this.mTitleView = view;
        if (this.mTitleViewLayout == null || view == null || view.getVisibility() == 8) {
            return;
        }
        this.mToolbar.setVisibility(8);
        this.mTitleViewLayout.setVisibility(0);
        this.mTitleView = view;
        this.mTitleViewLayout.addView(view);
    }

    public void initView(View view) {
    }

    public void onAdd(Boolean bool) {
    }

    public void onHide(Boolean bool) {
    }

    public void onShow(Boolean bool) {
    }
}
