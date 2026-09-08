package com.coui.appcompat.snackbar;

import X8.c;
import X8.n;
import a9.f;
import a9.h;
import a9.m;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.dynamicanimation.animation.d;
import com.coui.appcompat.animation.dynamicanimation.COUIDynamicAnimation;
import com.coui.appcompat.animation.dynamicanimation.COUISpringAnimation;
import com.coui.appcompat.animation.dynamicanimation.COUISpringForce;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.coui.appcompat.dialog.AppFeatureUtil;
import com.coui.appcompat.log.COUILog;
import com.coui.appcompat.roundcorner.RoundCornerUtil;
import com.coui.appcompat.textviewcompatutil.COUITextViewCompatUtil;
import com.coui.appcompat.uiutil.ShadowUtils;
import com.coui.appcompat.uiutil.UIUtil;
import com.coui.component.responsiveui.ResponsiveUIModel;
import com.coui.component.responsiveui.layoutgrid.MarginType;
import com.oplus.graphics.OplusOutline;

/* loaded from: classes.dex */
public class COUISnackBar extends RelativeLayout {
    private static final float DEFAULT_SNACKBAR_DISMISS_SPRING_RESPONSE = 0.25f;
    private static final float DEFAULT_SNACKBAR_SHOW_SPRING_RESPONSE = 0.3f;
    private static final float DEFAULT_SNACKBAR_SPRING_BOUNCE = 0.0f;
    private static final float DEFAULT_SPRING_FACTOR = 10000.0f;
    private static final int DEFAULT_TRANSLATION_END = 0;
    private static final float ONE = 1.0f;
    private static final float POINT_EIGHT = 0.8f;
    private static final int SINGLE_LINE_NUMBER = 1;
    private static final String TAG = "COUISnackBar";
    private static final float ZERO = 0.0f;
    protected static int mCOUISnackBarBottomMargin;
    private final int DEFAULT_ACTION_MARGIN_HORIZONTAL_END;
    private final int DEFAULT_ACTION_MARGIN_HORIZONTAL_START;
    private final int DEFAULT_ACTION_MARGIN_TOP_HORIZONTAL;
    private final int DEFAULT_ACTION_MARGIN_TOP_HORIZONTAL_TINY;
    private final int DEFAULT_ACTION_MARGIN_VERTICAL;
    private final int DEFAULT_ACTION_TEXT_MAX_WIDTH;
    private final int DEFAULT_CONTENT_MARGIN_HORIZONTAL;
    private final int DEFAULT_CONTENT_MARGIN_VERTICAL;
    private final int DEFAULT_CONTEXT_MARGIN_START_WITH_ICON;
    private final int DEFAULT_ICON_WIDTH;
    protected boolean isAdjustLayout;
    protected TextView mActionView;
    protected Runnable mAutoDismissRunnable;
    private ViewGroup mCOUISnackBarParent;
    private String mContentText;
    private int mContentTextWidth;
    protected TextView mContentView;
    private int mDuration;
    protected ImageView mIconDrawableView;
    private boolean mIsDefaultRadius;
    private boolean mIsEntering;
    private boolean mIsSupportSmoothRoundCorner;
    private boolean mIsTiny;
    private int mLastLayoutType;
    private OnStatusChangeListener mOnStatusChangeListener;
    private Rect mRect;
    private ResponsiveUIModel mResponsiveUIModel;
    protected View mRootView;
    private float mSnackBarAnimationProgress;
    protected ViewGroup mSnackBarLayout;
    private final d<Float> mSnackBarProperty;
    private COUISpringAnimation mSpringAnimation;
    private boolean mWithoutAnima;

    /* loaded from: classes.dex */
    public class AutoDismissRunnable implements Runnable {
        public AutoDismissRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            COUISnackBar.this.dismiss();
        }
    }

    /* loaded from: classes.dex */
    public interface OnStatusChangeListener {
        void onDismissed(COUISnackBar cOUISnackBar);

        void onShown(COUISnackBar cOUISnackBar);
    }

    public COUISnackBar(Context context) {
        super(context);
        this.DEFAULT_ACTION_TEXT_MAX_WIDTH = getResources().getDimensionPixelSize(a9.d.f6599w0);
        this.DEFAULT_CONTENT_MARGIN_VERTICAL = getResources().getDimensionPixelSize(a9.d.f6496A0);
        this.DEFAULT_CONTENT_MARGIN_HORIZONTAL = getResources().getDimensionPixelSize(a9.d.f6605z0);
        this.DEFAULT_ACTION_MARGIN_VERTICAL = getResources().getDimensionPixelSize(a9.d.f6597v0);
        this.DEFAULT_CONTEXT_MARGIN_START_WITH_ICON = getResources().getDimensionPixelSize(a9.d.f6500C0);
        this.DEFAULT_ICON_WIDTH = getResources().getDimensionPixelSize(a9.d.f6504E0);
        this.DEFAULT_ACTION_MARGIN_TOP_HORIZONTAL = getResources().getDimensionPixelSize(a9.d.f6593t0);
        this.DEFAULT_ACTION_MARGIN_TOP_HORIZONTAL_TINY = getResources().getDimensionPixelSize(a9.d.f6595u0);
        this.DEFAULT_ACTION_MARGIN_HORIZONTAL_START = getResources().getDimensionPixelSize(a9.d.f6591s0);
        this.DEFAULT_ACTION_MARGIN_HORIZONTAL_END = getResources().getDimensionPixelSize(a9.d.f6589r0);
        this.mWithoutAnima = false;
        this.mRect = new Rect();
        this.mResponsiveUIModel = new ResponsiveUIModel(getContext(), 0, 0);
        this.mIsDefaultRadius = true;
        this.isAdjustLayout = true;
        this.mIsSupportSmoothRoundCorner = false;
        this.mSnackBarAnimationProgress = 0.0f;
        this.mLastLayoutType = -1;
        this.mSnackBarProperty = new d<Float>("snackBarProperty") { // from class: com.coui.appcompat.snackbar.COUISnackBar.2
            @Override // androidx.dynamicanimation.animation.d
            public float getValue(Float f10) {
                return COUISnackBar.this.mSnackBarAnimationProgress;
            }

            @Override // androidx.dynamicanimation.animation.d
            public void setValue(Float f10, float f11) {
                COUISnackBar.this.setSnackBarProgress(f11);
            }
        };
        initCOUISnackBar(context, null);
    }

    private void alignCenter(View view, int i10) {
        if (view != null && getViewTotalHeight(view) != i10) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
            int measuredHeight = (i10 - view.getMeasuredHeight()) / 2;
            if (this.mLastLayoutType != 0) {
                view.offsetTopAndBottom(measuredHeight - layoutParams.topMargin);
            }
            layoutParams.topMargin = measuredHeight;
            layoutParams.bottomMargin = measuredHeight;
        }
    }

    private void animateSpring(final boolean z10) {
        this.mIsEntering = z10;
        this.mSpringAnimation = new COUISpringAnimation(Float.valueOf(this.mSnackBarAnimationProgress), this.mSnackBarProperty);
        COUISpringForce cOUISpringForce = new COUISpringForce();
        cOUISpringForce.setBounce(0.0f);
        if (z10) {
            cOUISpringForce.setResponse(0.3f);
        } else {
            cOUISpringForce.setResponse(DEFAULT_SNACKBAR_DISMISS_SPRING_RESPONSE);
        }
        this.mSpringAnimation.setSpring(cOUISpringForce);
        this.mSpringAnimation.addEndListener(new COUIDynamicAnimation.OnAnimationEndListener() { // from class: com.coui.appcompat.snackbar.COUISnackBar.1
            @Override // com.coui.appcompat.animation.dynamicanimation.COUIDynamicAnimation.OnAnimationEndListener
            public void onAnimationEnd(COUIDynamicAnimation cOUIDynamicAnimation, boolean z11, float f10, float f11) {
                if (!z10) {
                    COUISnackBar.this.dismissView();
                }
            }
        });
        this.mSpringAnimation.setStartValue(0.0f);
        this.mSpringAnimation.animateToFinalPosition(10000.0f);
    }

    private void animationIn() {
        setVisibility(0);
        setTranslationY(0.0f);
        animateSpring(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissView() {
        ViewGroup viewGroup = this.mSnackBarLayout;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        ViewGroup viewGroup2 = this.mCOUISnackBarParent;
        if (viewGroup2 != null) {
            viewGroup2.removeView(this.mRootView);
        }
        OnStatusChangeListener onStatusChangeListener = this.mOnStatusChangeListener;
        if (onStatusChangeListener != null) {
            onStatusChangeListener.onDismissed(this);
        }
    }

    public static ViewGroup findSuitableParent(View view) {
        ViewGroup viewGroup = null;
        while (!(view instanceof CoordinatorLayout)) {
            if (view instanceof FrameLayout) {
                if (view.getId() == 16908290) {
                    return (ViewGroup) view;
                }
                viewGroup = (ViewGroup) view;
            }
            if (view != null) {
                Object parent = view.getParent();
                if (parent instanceof View) {
                    view = (View) parent;
                } else {
                    view = null;
                }
            }
            if (view == null) {
                return viewGroup;
            }
        }
        return (ViewGroup) view;
    }

    private int getContainerWidth() {
        int paddingLeft = this.mContentTextWidth + this.mSnackBarLayout.getPaddingLeft() + this.mSnackBarLayout.getPaddingRight();
        if (this.mActionView.getVisibility() == 0) {
            paddingLeft += this.mActionView.getMeasuredWidth() + this.DEFAULT_ACTION_MARGIN_HORIZONTAL_END;
        }
        if (isCOUISnackBarHasIcon()) {
            return paddingLeft + this.DEFAULT_ICON_WIDTH + this.DEFAULT_CONTEXT_MARGIN_START_WITH_ICON;
        }
        return paddingLeft;
    }

    private int getMaxWidth() {
        getWindowVisibleDisplayFrame(this.mRect);
        this.mResponsiveUIModel.rebuild(Math.max(0, this.mRect.width()), Math.max(0, this.mRect.height())).chooseMargin(MarginType.MARGIN_SMALL);
        return this.mResponsiveUIModel.calculateGridWidth(6);
    }

    private int getViewTotalHeight(View view) {
        if (view != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
            return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
        }
        return 0;
    }

    private boolean isCOUISnackBarHasIcon() {
        if (this.mIconDrawableView.getDrawable() != null) {
            return true;
        }
        return false;
    }

    private boolean isInSecondaryDisplay(Context context) {
        try {
            if (context.getDisplay().getDisplayId() == 1) {
                return true;
            }
            return false;
        } catch (UnsupportedOperationException e10) {
            Log.w(TAG, e10.toString());
            return AppFeatureUtil.isSecondaryScreen(context);
        } catch (RuntimeException e11) {
            Log.w(TAG, e11.toString());
            return AppFeatureUtil.isSecondaryScreen(context);
        }
    }

    private boolean isVertical() {
        boolean z10;
        if (getContainerWidth() > this.mSnackBarLayout.getMeasuredWidth()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (this.mContentView.getLineCount() <= 1 && !z10) {
            return false;
        }
        return true;
    }

    private void layoutHorizontally() {
        int max = Math.max(getViewTotalHeight(this.mContentView), getViewTotalHeight(this.mActionView));
        if (this.mIsTiny) {
            setTinyParams(this.mContentView);
            setTinyParams(this.mActionView);
            return;
        }
        if (isCOUISnackBarHasIcon()) {
            max = Math.max(getViewTotalHeight(this.mIconDrawableView), max);
            alignCenter(this.mIconDrawableView, max);
        }
        alignCenter(this.mContentView, max);
        alignCenter(this.mActionView, max);
    }

    private void layoutVertically() {
        int i10;
        Resources resources;
        int i11;
        if (isCOUISnackBarHasIcon()) {
            ((RelativeLayout.LayoutParams) this.mIconDrawableView.getLayoutParams()).topMargin = ((this.mContentView.getMeasuredHeight() - this.mIconDrawableView.getMeasuredHeight()) / 2) + this.DEFAULT_CONTENT_MARGIN_VERTICAL;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mContentView.getLayoutParams();
        Resources resources2 = getResources();
        int i12 = a9.d.f6498B0;
        marginLayoutParams.topMargin = resources2.getDimensionPixelSize(i12);
        this.mContentView.setLayoutParams(marginLayoutParams);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mActionView.getLayoutParams();
        if (this.mIsTiny) {
            i10 = this.DEFAULT_ACTION_MARGIN_TOP_HORIZONTAL_TINY;
        } else {
            i10 = this.DEFAULT_ACTION_MARGIN_TOP_HORIZONTAL;
        }
        layoutParams.topMargin = getResources().getDimensionPixelSize(i12) + this.mContentView.getMeasuredHeight() + i10;
        if (this.mIsTiny) {
            resources = getResources();
            i11 = a9.d.f6585p0;
        } else {
            resources = getResources();
            i11 = a9.d.f6583o0;
        }
        layoutParams.bottomMargin = resources.getDimensionPixelSize(i11);
        this.mActionView.setLayoutParams(layoutParams);
        if (this.mIsTiny) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(a9.d.f6601x0);
            TextView textView = this.mActionView;
            textView.setPadding(textView.getPaddingLeft(), dimensionPixelSize, this.mActionView.getPaddingRight(), dimensionPixelSize);
        }
    }

    public static COUISnackBar make(View view, String str, int i10) {
        return make(view.getContext(), view, str, i10);
    }

    private void resetMarginHorizontal() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mIconDrawableView.getLayoutParams();
        Resources resources = getResources();
        int i10 = a9.d.f6502D0;
        layoutParams.topMargin = resources.getDimensionPixelSize(i10);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(i10);
        this.mIconDrawableView.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mContentView.getLayoutParams();
        Resources resources2 = getResources();
        int i11 = a9.d.f6496A0;
        layoutParams2.topMargin = resources2.getDimensionPixelSize(i11);
        layoutParams2.bottomMargin = getResources().getDimensionPixelSize(i11);
        this.mContentView.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mActionView.getLayoutParams();
        Resources resources3 = getResources();
        int i12 = a9.d.f6597v0;
        layoutParams3.topMargin = resources3.getDimensionPixelSize(i12);
        layoutParams3.bottomMargin = getResources().getDimensionPixelSize(i12);
        this.mActionView.setLayoutParams(layoutParams3);
    }

    private void setActionText(String str) {
        this.mActionView.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSnackBarProgress(float f10) {
        float f11;
        this.mSnackBarAnimationProgress = f10;
        float f12 = f10 / 10000.0f;
        boolean z10 = this.mIsEntering;
        float f13 = POINT_EIGHT;
        float f14 = 0.0f;
        float f15 = 1.0f;
        if (z10) {
            f11 = 1.0f;
        } else {
            f11 = 0.0f;
            f14 = 1.0f;
            f15 = 0.8f;
            f13 = 1.0f;
        }
        this.mSnackBarLayout.setScaleX(UIUtil.getConvertedFraction(f13, f15, f12));
        this.mSnackBarLayout.setScaleY(UIUtil.getConvertedFraction(f13, f15, f12));
        this.mSnackBarLayout.setAlpha(UIUtil.getConvertedFraction(f14, f11, f12));
    }

    private void setTinyParams(TextView textView) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
        Resources resources = getResources();
        int i10 = a9.d.f6587q0;
        marginLayoutParams.topMargin = resources.getDimensionPixelSize(i10);
        marginLayoutParams.bottomMargin = getResources().getDimensionPixelSize(i10);
        textView.setLayoutParams(marginLayoutParams);
        textView.setPadding(textView.getPaddingStart(), 0, textView.getPaddingEnd(), 0);
    }

    public void adjustLayout() {
        if (isVertical()) {
            this.mIsDefaultRadius = false;
            layoutVertically();
            this.mLastLayoutType = 1;
        } else {
            this.mIsDefaultRadius = true;
            layoutHorizontally();
            this.mLastLayoutType = 0;
        }
    }

    public void dismiss() {
        COUISpringAnimation cOUISpringAnimation = this.mSpringAnimation;
        if (cOUISpringAnimation != null && cOUISpringAnimation.isRunning() && !this.mIsEntering) {
            COUILog.d(TAG, "is in dismissing");
            return;
        }
        Runnable runnable = this.mAutoDismissRunnable;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        animateSpring(false);
    }

    public String getActionText() {
        return String.valueOf(this.mActionView.getText());
    }

    public TextView getActionView() {
        return this.mActionView;
    }

    public String getContentText() {
        return String.valueOf(this.mContentView.getText());
    }

    public TextView getContentView() {
        return this.mContentView;
    }

    public int getDuration() {
        return this.mDuration;
    }

    public void initCOUISnackBar(final Context context, AttributeSet attributeSet) {
        View inflate = View.inflate(context, h.f6667j, this);
        this.mRootView = inflate;
        this.mSnackBarLayout = (ViewGroup) inflate.findViewById(f.f6623M);
        this.mContentView = (TextView) this.mRootView.findViewById(f.f6627Q);
        this.mActionView = (TextView) this.mRootView.findViewById(f.f6626P);
        this.mIconDrawableView = (ImageView) this.mRootView.findViewById(f.f6615E);
        this.mIsTiny = isInSecondaryDisplay(getContext());
        mCOUISnackBarBottomMargin = new ViewGroup.MarginLayoutParams(context, attributeSet).bottomMargin;
        setVisibility(8);
        this.mAutoDismissRunnable = new AutoDismissRunnable();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.f6843d2, 0, 0);
        try {
            try {
                int i10 = m.f6852f2;
                if (obtainStyledAttributes.getString(i10) != null) {
                    setContentText(obtainStyledAttributes.getString(i10));
                    setDuration(obtainStyledAttributes.getInt(m.f6856g2, 0));
                }
                setIconDrawable(obtainStyledAttributes.getDrawable(m.f6848e2));
            } catch (Exception e10) {
                Log.e(TAG, "Failure setting COUISnackBar " + e10.getMessage());
            }
            obtainStyledAttributes.recycle();
            this.mIsSupportSmoothRoundCorner = RoundCornerUtil.isVersionSupport();
            final int attrDimens = COUIContextUtil.getAttrDimens(context, c.f4389k0);
            this.mSnackBarLayout.setOutlineProvider(new ViewOutlineProvider() { // from class: com.coui.appcompat.snackbar.COUISnackBar.4
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view, Outline outline) {
                    int i11 = attrDimens;
                    if (!COUISnackBar.this.mIsDefaultRadius) {
                        if (COUISnackBar.this.mIsSupportSmoothRoundCorner) {
                            new OplusOutline(outline).setSmoothRoundRect(0, 0, view.getWidth(), view.getHeight(), COUIContextUtil.getAttrDimens(context, c.f4369a0), COUIContextUtil.getAttrFloat(context, c.f4371b0));
                            return;
                        }
                        i11 = COUIContextUtil.getAttrDimens(context, c.f4367Z);
                    }
                    outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), i11);
                }
            });
            this.mSnackBarLayout.setClipToOutline(true);
            ShadowUtils.setElevationToView(this.mSnackBarLayout, 2, getContext().getResources().getDimensionPixelOffset(a9.d.f6510H0), context.getResources().getDimensionPixelOffset(X8.f.f4551M5), getContext().getResources().getColor(a9.c.f6493q));
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.mAutoDismissRunnable);
        this.mCOUISnackBarParent = null;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (z10 && this.isAdjustLayout) {
            adjustLayout();
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        if (!isVertical() && this.mLastLayoutType == 1) {
            resetMarginHorizontal();
        }
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        this.mContentTextWidth = ((int) this.mContentView.getPaint().measureText(this.mContentText)) + (this.DEFAULT_CONTENT_MARGIN_HORIZONTAL << 1);
        int maxWidth = getMaxWidth() + this.mSnackBarLayout.getPaddingLeft() + this.mSnackBarLayout.getPaddingRight();
        if (maxWidth > size) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mSnackBarLayout.getLayoutParams();
            Resources resources = getResources();
            int i12 = X8.f.f4467A5;
            layoutParams.setMarginStart(resources.getDimensionPixelOffset(i12) - this.mSnackBarLayout.getPaddingStart());
            layoutParams.setMarginEnd(getResources().getDimensionPixelOffset(i12) - this.mSnackBarLayout.getPaddingEnd());
            this.mSnackBarLayout.setLayoutParams(layoutParams);
        }
        if (maxWidth > 0 && mode != 0) {
            i10 = View.MeasureSpec.makeMeasureSpec(Math.min(maxWidth, size), mode);
        }
        if (this.mIsTiny) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mSnackBarLayout.getLayoutParams();
            Resources resources2 = getResources();
            int i13 = a9.d.f6506F0;
            layoutParams2.setMarginStart(resources2.getDimensionPixelOffset(i13));
            layoutParams2.setMarginEnd(getResources().getDimensionPixelOffset(i13));
            this.mSnackBarLayout.setLayoutParams(layoutParams2);
        }
        super.onMeasure(i10, i11);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000d, code lost:
    
        if (r4 != 3) goto L18;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r4) {
        /*
            r3 = this;
            int r4 = r4.getAction()
            r0 = 1
            if (r4 == 0) goto L2a
            if (r4 == r0) goto L10
            r1 = 2
            if (r4 == r1) goto L2a
            r1 = 3
            if (r4 == r1) goto L10
            goto L31
        L10:
            java.lang.Runnable r4 = r3.mAutoDismissRunnable
            if (r4 == 0) goto L31
            int r4 = r3.getDuration()
            if (r4 == 0) goto L31
            java.lang.Runnable r4 = r3.mAutoDismissRunnable
            r3.removeCallbacks(r4)
            java.lang.Runnable r4 = r3.mAutoDismissRunnable
            int r1 = r3.getDuration()
            long r1 = (long) r1
            r3.postDelayed(r4, r1)
            goto L31
        L2a:
            java.lang.Runnable r4 = r3.mAutoDismissRunnable
            if (r4 == 0) goto L31
            r3.removeCallbacks(r4)
        L31:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.snackbar.COUISnackBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setContentText(int i10) {
        setContentText(getResources().getString(i10));
    }

    public void setDismissWithoutAnimate(boolean z10) {
        this.mWithoutAnima = z10;
    }

    public void setDuration(int i10) {
        this.mDuration = i10;
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        Runnable runnable;
        super.setEnabled(z10);
        this.mActionView.setEnabled(z10);
        this.mContentView.setEnabled(z10);
        this.mIconDrawableView.setEnabled(z10);
        if (getDuration() != 0 && (runnable = this.mAutoDismissRunnable) != null) {
            removeCallbacks(runnable);
            postDelayed(this.mAutoDismissRunnable, getDuration());
        }
    }

    public void setIconDrawable(int i10) {
        setIconDrawable(getResources().getDrawable(i10, getContext().getTheme()));
    }

    public void setOnAction(int i10, View.OnClickListener onClickListener) {
        setOnAction(getResources().getString(i10), onClickListener);
    }

    public void setOnStatusChangeListener(OnStatusChangeListener onStatusChangeListener) {
        this.mOnStatusChangeListener = onStatusChangeListener;
    }

    public void setParent(ViewGroup viewGroup) {
        this.mCOUISnackBarParent = viewGroup;
    }

    public void show() {
        Runnable runnable;
        if (getDuration() != 0 && (runnable = this.mAutoDismissRunnable) != null) {
            removeCallbacks(runnable);
            postDelayed(this.mAutoDismissRunnable, getDuration());
        }
        OnStatusChangeListener onStatusChangeListener = this.mOnStatusChangeListener;
        if (onStatusChangeListener != null) {
            onStatusChangeListener.onShown(this);
        }
        animationIn();
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).setClipChildren(false);
        }
    }

    public static COUISnackBar make(Context context, View view, String str, int i10) {
        return make(context, view, str, i10, context.getResources().getDimensionPixelSize(a9.d.f6508G0));
    }

    public void setContentText(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mContentView.setVisibility(8);
            Runnable runnable = this.mAutoDismissRunnable;
            if (runnable != null) {
                removeCallbacks(runnable);
                return;
            }
            return;
        }
        this.mContentView.setText(str);
        this.mContentText = str;
    }

    public void setIconDrawable(Drawable drawable) {
        if (drawable == null) {
            this.mIconDrawableView.setVisibility(8);
            ((ViewGroup.MarginLayoutParams) this.mContentView.getLayoutParams()).setMarginStart(getContext().getResources().getDimensionPixelSize(a9.d.f6603y0));
        } else {
            this.mIconDrawableView.setVisibility(0);
            this.mIconDrawableView.setImageDrawable(drawable);
            ((ViewGroup.MarginLayoutParams) this.mContentView.getLayoutParams()).setMarginStart(this.DEFAULT_CONTENT_MARGIN_HORIZONTAL);
        }
    }

    public void setOnAction(String str, final View.OnClickListener onClickListener) {
        if (TextUtils.isEmpty(str)) {
            this.mActionView.setVisibility(8);
            this.mActionView.setOnClickListener(null);
            Runnable runnable = this.mAutoDismissRunnable;
            if (runnable != null) {
                removeCallbacks(runnable);
                return;
            }
            return;
        }
        this.mActionView.setVisibility(0);
        setActionText(str);
        if (onClickListener != null) {
            COUITextViewCompatUtil.setPressRippleDrawable(this.mActionView);
            this.mActionView.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.snackbar.COUISnackBar.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    onClickListener.onClick(view);
                    COUISnackBar cOUISnackBar = COUISnackBar.this;
                    cOUISnackBar.dismiss(cOUISnackBar.mWithoutAnima);
                }
            });
        }
    }

    public static COUISnackBar make(View view, String str, int i10, int i11) {
        return make(view.getContext(), view, str, i10, i11);
    }

    public static COUISnackBar make(Context context, View view, String str, int i10, int i11) {
        ViewGroup findSuitableParent = findSuitableParent(view);
        if (findSuitableParent != null) {
            TypedValue typedValue = new TypedValue();
            if (!context.getTheme().resolveAttribute(c.f4354M, typedValue, true) || !context.getTheme().resolveAttribute(c.f4348G, typedValue, true)) {
                ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, n.f5043o);
                Log.e(TAG, "Expected theme to define couiColorSurfaceTop and couiColorPrimaryNeutral.");
                context = contextThemeWrapper;
            }
            COUISnackBar cOUISnackBar = (COUISnackBar) LayoutInflater.from(context).inflate(h.f6668k, findSuitableParent, false);
            cOUISnackBar.setContentText(str);
            cOUISnackBar.setDuration(i10);
            cOUISnackBar.setParent(findSuitableParent);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) cOUISnackBar.getLayoutParams();
            marginLayoutParams.bottomMargin = i11;
            mCOUISnackBarBottomMargin = i11;
            cOUISnackBar.setTranslationY(cOUISnackBar.getHeight() + i11);
            boolean z10 = false;
            for (int i12 = 0; i12 < findSuitableParent.getChildCount(); i12++) {
                if (findSuitableParent.getChildAt(i12) instanceof COUISnackBar) {
                    z10 = findSuitableParent.getChildAt(i12).getVisibility() != 8;
                }
            }
            if (!z10) {
                findSuitableParent.addView(cOUISnackBar, marginLayoutParams);
            }
            return cOUISnackBar;
        }
        throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
    }

    public void dismiss(boolean z10) {
        if (z10) {
            COUISpringAnimation cOUISpringAnimation = this.mSpringAnimation;
            if (cOUISpringAnimation != null && cOUISpringAnimation.isRunning() && !this.mIsEntering) {
                this.mSpringAnimation.cancel();
            }
            Runnable runnable = this.mAutoDismissRunnable;
            if (runnable != null) {
                removeCallbacks(runnable);
            }
            dismissView();
            return;
        }
        dismiss();
    }

    public COUISnackBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.DEFAULT_ACTION_TEXT_MAX_WIDTH = getResources().getDimensionPixelSize(a9.d.f6599w0);
        this.DEFAULT_CONTENT_MARGIN_VERTICAL = getResources().getDimensionPixelSize(a9.d.f6496A0);
        this.DEFAULT_CONTENT_MARGIN_HORIZONTAL = getResources().getDimensionPixelSize(a9.d.f6605z0);
        this.DEFAULT_ACTION_MARGIN_VERTICAL = getResources().getDimensionPixelSize(a9.d.f6597v0);
        this.DEFAULT_CONTEXT_MARGIN_START_WITH_ICON = getResources().getDimensionPixelSize(a9.d.f6500C0);
        this.DEFAULT_ICON_WIDTH = getResources().getDimensionPixelSize(a9.d.f6504E0);
        this.DEFAULT_ACTION_MARGIN_TOP_HORIZONTAL = getResources().getDimensionPixelSize(a9.d.f6593t0);
        this.DEFAULT_ACTION_MARGIN_TOP_HORIZONTAL_TINY = getResources().getDimensionPixelSize(a9.d.f6595u0);
        this.DEFAULT_ACTION_MARGIN_HORIZONTAL_START = getResources().getDimensionPixelSize(a9.d.f6591s0);
        this.DEFAULT_ACTION_MARGIN_HORIZONTAL_END = getResources().getDimensionPixelSize(a9.d.f6589r0);
        this.mWithoutAnima = false;
        this.mRect = new Rect();
        this.mResponsiveUIModel = new ResponsiveUIModel(getContext(), 0, 0);
        this.mIsDefaultRadius = true;
        this.isAdjustLayout = true;
        this.mIsSupportSmoothRoundCorner = false;
        this.mSnackBarAnimationProgress = 0.0f;
        this.mLastLayoutType = -1;
        this.mSnackBarProperty = new d<Float>("snackBarProperty") { // from class: com.coui.appcompat.snackbar.COUISnackBar.2
            @Override // androidx.dynamicanimation.animation.d
            public float getValue(Float f10) {
                return COUISnackBar.this.mSnackBarAnimationProgress;
            }

            @Override // androidx.dynamicanimation.animation.d
            public void setValue(Float f10, float f11) {
                COUISnackBar.this.setSnackBarProgress(f11);
            }
        };
        initCOUISnackBar(context, attributeSet);
    }
}
