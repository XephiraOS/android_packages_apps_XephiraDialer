package com.coui.appcompat.snackbar;

import X8.c;
import X8.g;
import X8.n;
import a9.d;
import a9.f;
import a9.h;
import a9.m;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Property;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.coui.appcompat.animation.COUIMoveEaseInterpolator;
import com.coui.appcompat.animation.dynamicanimation.COUIDynamicAnimation;
import com.coui.appcompat.animation.dynamicanimation.COUISpringAnimation;
import com.coui.appcompat.button.COUIButton;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.coui.appcompat.roundcorner.RoundCornerUtil;
import com.coui.appcompat.snackbar.COUISnackBar;
import com.coui.appcompat.uiutil.ShadowUtils;
import com.oplus.graphics.OplusOutline;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* loaded from: classes.dex */
public class COUINotificationSnackBar extends COUISnackBar {
    private static final int MAX_DURATION = 10000;
    private static final int MIN_DURATION = 4000;
    private static final PathInterpolator MOVE_EASE_INTERPOLATOR = new COUIMoveEaseInterpolator();
    private static final int SLIDING_LIMIT_VALUE = 8;
    private static final float SLIDING_SPEED = 1.75f;
    private static final int SWIPED_INDEX_X = 1;
    private static final int SWIPED_INDEX_Y = 2;
    private static final String TAG = "COUINotificationSnackBar";
    private View.OnClickListener mButtonClickListener;
    private COUIButton mButtonTv;
    private Drawable mCloseDrawable;
    private ImageView mCloseIv;
    private View.OnClickListener mCloseIvClickListener;
    private COUISpringAnimation mCouiSpringAnimationX;
    private COUISpringAnimation mCouiSpringAnimationY;
    private int mHorizontalImageHeight;
    private int mHorizontalImageWidth;
    private int mInterceptX;
    private int mInterceptY;
    private boolean mIsSupportSmoothRoundCorner;
    private int mLastX;
    private int mLastY;
    private ImageView mNotificationIcon;
    private int mScreenWidth;
    private int mSquareImageWidth;
    private TextView mSubContentTv;
    private int mSwipedIndex;
    private int mVerticalImageHeight;
    private int mVerticalImageWidth;

    @Target({ElementType.TYPE, ElementType.PARAMETER, ElementType.FIELD})
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface ImageType {
        public static final int Horizontal = 2;
        public static final int Square = 0;
        public static final int Vertical = 1;
    }

    public COUINotificationSnackBar(Context context) {
        super(context);
    }

    private boolean checkSwipedFarEnoughByX() {
        if (Math.abs(getTranslationX()) > getMeasuredWidth() / 8) {
            return true;
        }
        return false;
    }

    private boolean checkSwipedFarEnoughByY() {
        float translationY = getTranslationY();
        if (Math.abs(translationY) > getMeasuredWidth() / 8 && translationY > 0.0f) {
            return true;
        }
        return false;
    }

    private ObjectAnimator createTranslationAnimation(View view, float f10, Property<View, Float> property) {
        return ObjectAnimator.ofFloat(view, property, f10);
    }

    private COUISpringAnimation getViewSpringTranslationAnimator(View view, float f10, COUIDynamicAnimation.ViewProperty viewProperty) {
        COUISpringAnimation cOUISpringAnimation = new COUISpringAnimation(view, viewProperty, f10);
        cOUISpringAnimation.getSpring().setBounce(0.0f);
        cOUISpringAnimation.getSpring().setResponse(0.35f);
        return cOUISpringAnimation;
    }

    private Animator getViewTranslationAnimator(View view, float f10, int i10, Property<View, Float> property) {
        ObjectAnimator createTranslationAnimation = createTranslationAnimation(view, f10, property);
        createTranslationAnimation.addListener(new Animator.AnimatorListener() { // from class: com.coui.appcompat.snackbar.COUINotificationSnackBar.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                COUINotificationSnackBar.this.dismiss();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        createTranslationAnimation.setDuration(i10);
        createTranslationAnimation.setInterpolator(MOVE_EASE_INTERPOLATOR);
        return createTranslationAnimation;
    }

    private void initResource() {
        this.mScreenWidth = getContext().getResources().getDisplayMetrics().widthPixels;
        this.mSquareImageWidth = getContext().getResources().getDimensionPixelSize(d.f6503E);
        this.mHorizontalImageWidth = getContext().getResources().getDimensionPixelSize(d.f6501D);
        this.mHorizontalImageHeight = getContext().getResources().getDimensionPixelSize(d.f6499C);
        this.mVerticalImageWidth = getContext().getResources().getDimensionPixelSize(d.f6507G);
        this.mVerticalImageHeight = getContext().getResources().getDimensionPixelSize(d.f6505F);
        Drawable drawable = getContext().getResources().getDrawable(g.f4865r, getContext().getTheme());
        this.mCloseDrawable = drawable;
        drawable.setColorFilter(COUIContextUtil.getAttrColor(getContext(), c.f4341A, 0), PorterDuff.Mode.SRC_IN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setOnClick$0(View view) {
        View.OnClickListener onClickListener = this.mCloseIvClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(this.mCloseIv);
        }
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setOnClick$1(View view) {
        View.OnClickListener onClickListener = this.mButtonClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(this.mButtonTv);
        }
    }

    public static COUINotificationSnackBar make(View view, String str, String str2, int i10) {
        return make(view.getContext(), view, str, str2, i10);
    }

    private void setButtonText(String str) {
        if (this.mButtonTv != null && !TextUtils.isEmpty(str)) {
            this.mButtonTv.setText(str);
            this.mButtonTv.setVisibility(0);
        }
    }

    private void setCloseIcon() {
        ImageView imageView = this.mCloseIv;
        if (imageView == null) {
            return;
        }
        imageView.setImageDrawable(this.mCloseDrawable);
        this.mCloseIv.setVisibility(0);
    }

    private void setOnClick() {
        ImageView imageView = this.mCloseIv;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.snackbar.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    COUINotificationSnackBar.this.lambda$setOnClick$0(view);
                }
            });
        }
        COUIButton cOUIButton = this.mButtonTv;
        if (cOUIButton != null) {
            cOUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.snackbar.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    COUINotificationSnackBar.this.lambda$setOnClick$1(view);
                }
            });
        }
    }

    private void startDismissAnimationX() {
        float translationX = getTranslationX();
        int measuredWidth = ((this.mScreenWidth - getMeasuredWidth()) / 2) + getMeasuredWidth();
        float f10 = measuredWidth;
        int abs = (int) ((f10 - Math.abs(translationX)) / SLIDING_SPEED);
        if (translationX < 0.0f) {
            f10 = -measuredWidth;
        }
        ((ObjectAnimator) getViewTranslationAnimator(this, f10, abs, View.TRANSLATION_X)).start();
    }

    private void startDismissAnimationY() {
        float bottom = getBottom() + getMeasuredHeight();
        ((ObjectAnimator) getViewTranslationAnimator(this, bottom, (int) (bottom / SLIDING_SPEED), View.TRANSLATION_Y)).start();
    }

    private void startOriginalAnimationX() {
        if (this.mCouiSpringAnimationX == null) {
            this.mCouiSpringAnimationX = getViewSpringTranslationAnimator(this, 0.0f, COUIDynamicAnimation.TRANSLATION_X);
        }
        this.mCouiSpringAnimationX.start();
    }

    private void startOriginalAnimationY() {
        if (this.mCouiSpringAnimationY == null) {
            this.mCouiSpringAnimationY = getViewSpringTranslationAnimator(this, 0.0f, COUIDynamicAnimation.TRANSLATION_Y);
        }
        this.mCouiSpringAnimationY.start();
    }

    public COUIButton getNotificationButton() {
        return this.mButtonTv;
    }

    public ViewGroup getSnackBarLayout() {
        return this.mSnackBarLayout;
    }

    public TextView getSubContentView() {
        return this.mSubContentTv;
    }

    @Override // com.coui.appcompat.snackbar.COUISnackBar
    public void initCOUISnackBar(final Context context, AttributeSet attributeSet) {
        initResource();
        View inflate = View.inflate(context, h.f6665h, this);
        this.mRootView = inflate;
        this.mSnackBarLayout = (ViewGroup) inflate.findViewById(f.f6623M);
        this.mContentView = (TextView) this.mRootView.findViewById(f.f6627Q);
        this.mActionView = (TextView) this.mRootView.findViewById(f.f6626P);
        this.mIconDrawableView = (ImageView) this.mRootView.findViewById(f.f6615E);
        this.mCloseIv = (ImageView) this.mRootView.findViewById(f.f6613C);
        this.mButtonTv = (COUIButton) this.mRootView.findViewById(f.f6634d);
        this.mNotificationIcon = (ImageView) this.mRootView.findViewById(f.f6614D);
        this.mSubContentTv = (TextView) this.mRootView.findViewById(f.f6628R);
        COUISnackBar.mCOUISnackBarBottomMargin = new ViewGroup.MarginLayoutParams(context, attributeSet).bottomMargin;
        setVisibility(8);
        this.mAutoDismissRunnable = new COUISnackBar.AutoDismissRunnable();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.f6843d2, 0, 0);
        try {
            try {
                int i10 = m.f6852f2;
                if (obtainStyledAttributes.getString(i10) != null) {
                    setContentText(obtainStyledAttributes.getString(i10));
                    setDuration(obtainStyledAttributes.getInt(m.f6856g2, 0));
                }
            } catch (Exception e10) {
                Log.e(TAG, "Failure setting COUINotificationSnackBar " + e10.getMessage());
            }
            this.mIsSupportSmoothRoundCorner = RoundCornerUtil.isVersionSupport();
            ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() { // from class: com.coui.appcompat.snackbar.COUINotificationSnackBar.1
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view, Outline outline) {
                    if (COUINotificationSnackBar.this.mIsSupportSmoothRoundCorner) {
                        new OplusOutline(outline).setSmoothRoundRect(0, 0, view.getWidth(), view.getHeight(), COUIContextUtil.getAttrDimens(context, c.f4369a0), COUIContextUtil.getAttrFloat(context, c.f4371b0));
                    } else {
                        outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), COUIContextUtil.getAttrDimens(context, c.f4367Z));
                    }
                }
            };
            setOnClick();
            this.mSnackBarLayout.setOutlineProvider(viewOutlineProvider);
            this.mSnackBarLayout.setClipToOutline(true);
            ShadowUtils.setElevationToView(this.mSnackBarLayout, 2, COUIContextUtil.getAttrDimens(context, c.f4367Z), context.getResources().getDimensionPixelOffset(X8.f.f4544L5), getContext().getResources().getColor(a9.c.f6493q));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int rawY = (int) motionEvent.getRawY();
        int rawX = (int) motionEvent.getRawX();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2) {
                this.mLastX = rawX;
                this.mLastY = rawY;
                if (Math.abs(rawX - this.mInterceptX) > 0 || Math.abs(this.mLastY - this.mInterceptY) > 0) {
                    this.mSwipedIndex = -1;
                    return true;
                }
                return false;
            }
            return false;
        }
        this.mInterceptX = rawX;
        this.mInterceptY = rawY;
        return false;
    }

    @Override // com.coui.appcompat.snackbar.COUISnackBar, android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        this.isAdjustLayout = false;
        super.onLayout(z10, i10, i11, i12, i13);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0020, code lost:
    
        if (r4 != 3) goto L38;
     */
    @Override // com.coui.appcompat.snackbar.COUISnackBar, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r10) {
        /*
            r9 = this;
            float r0 = r10.getRawX()
            int r0 = (int) r0
            float r1 = r10.getRawY()
            int r1 = (int) r1
            int r2 = r9.mLastX
            int r2 = r0 - r2
            int r3 = r9.mLastY
            int r3 = r1 - r3
            int r4 = r10.getAction()
            r5 = -1
            if (r4 == 0) goto L83
            r6 = 1
            if (r4 == r6) goto L63
            r7 = 2
            if (r4 == r7) goto L23
            r2 = 3
            if (r4 == r2) goto L63
            goto L85
        L23:
            int r4 = r9.mSwipedIndex
            if (r4 != r5) goto L38
            if (r2 != 0) goto L2b
            if (r3 == 0) goto L38
        L2b:
            int r4 = java.lang.Math.abs(r2)
            int r8 = java.lang.Math.abs(r3)
            if (r4 <= r8) goto L36
            r7 = r6
        L36:
            r9.mSwipedIndex = r7
        L38:
            int r4 = r9.mSwipedIndex
            if (r4 == r5) goto L85
            if (r4 != r6) goto L48
            float r3 = r9.getTranslationX()
            float r2 = (float) r2
            float r3 = r3 + r2
            r9.setTranslationX(r3)
            goto L85
        L48:
            float r2 = r9.getTranslationY()
            float r3 = (float) r3
            float r2 = r2 + r3
            int r3 = r9.getMeasuredWidth()
            int r3 = r3 / 8
            r4 = 0
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 >= 0) goto L5f
            int r3 = -r3
            float r3 = (float) r3
            float r2 = java.lang.Math.max(r3, r2)
        L5f:
            r9.setTranslationY(r2)
            goto L85
        L63:
            int r2 = r9.mSwipedIndex
            if (r2 != r6) goto L75
            boolean r2 = r9.checkSwipedFarEnoughByX()
            if (r2 == 0) goto L71
            r9.startDismissAnimationX()
            goto L85
        L71:
            r9.startOriginalAnimationX()
            goto L85
        L75:
            boolean r2 = r9.checkSwipedFarEnoughByY()
            if (r2 == 0) goto L7f
            r9.startDismissAnimationY()
            goto L85
        L7f:
            r9.startOriginalAnimationY()
            goto L85
        L83:
            r9.mSwipedIndex = r5
        L85:
            r9.mLastX = r0
            r9.mLastY = r1
            boolean r9 = super.onTouchEvent(r10)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.snackbar.COUINotificationSnackBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setButtonClickListener(View.OnClickListener onClickListener) {
        this.mButtonClickListener = onClickListener;
    }

    public void setCloseButtonClickListener(View.OnClickListener onClickListener) {
        this.mCloseIvClickListener = onClickListener;
    }

    public void setNotificationIcon(Drawable drawable, int i10) {
        ImageView imageView = this.mNotificationIcon;
        if (imageView == null || drawable == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (i10 == 0) {
            int i11 = this.mSquareImageWidth;
            layoutParams.width = i11;
            layoutParams.height = i11;
        } else if (i10 == 1) {
            layoutParams.width = this.mVerticalImageWidth;
            layoutParams.height = this.mVerticalImageHeight;
        } else if (i10 == 2) {
            layoutParams.width = this.mHorizontalImageWidth;
            layoutParams.height = this.mHorizontalImageHeight;
        }
        this.mNotificationIcon.setLayoutParams(layoutParams);
        this.mNotificationIcon.setImageDrawable(drawable);
        this.mNotificationIcon.setVisibility(0);
    }

    public void setSubContent(String str) {
        if (this.mSubContentTv != null && !TextUtils.isEmpty(str)) {
            this.mSubContentTv.setText(str);
            this.mSubContentTv.setVisibility(0);
        }
    }

    public COUINotificationSnackBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public static COUINotificationSnackBar make(Context context, View view, String str, String str2, int i10) {
        return make(context, view, str, str2, i10, context.getResources().getDimensionPixelSize(d.f6508G0));
    }

    public static COUINotificationSnackBar make(View view, String str, String str2, int i10, int i11) {
        return make(view.getContext(), view, str, str2, i10, i11);
    }

    public static COUINotificationSnackBar make(Context context, View view, String str, String str2, int i10, int i11) {
        ViewGroup findSuitableParent = COUISnackBar.findSuitableParent(view);
        if (findSuitableParent != null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                int min = Math.min(Math.max(i10, MIN_DURATION), MAX_DURATION);
                TypedValue typedValue = new TypedValue();
                if (!context.getTheme().resolveAttribute(c.f4354M, typedValue, true) || !context.getTheme().resolveAttribute(c.f4348G, typedValue, true)) {
                    context = new ContextThemeWrapper(context, n.f5043o);
                }
                COUINotificationSnackBar cOUINotificationSnackBar = (COUINotificationSnackBar) LayoutInflater.from(context).inflate(h.f6666i, findSuitableParent, false);
                cOUINotificationSnackBar.setContentText(str);
                cOUINotificationSnackBar.setDuration(min);
                cOUINotificationSnackBar.setParent(findSuitableParent);
                cOUINotificationSnackBar.setButtonText(str2);
                cOUINotificationSnackBar.setCloseIcon();
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) cOUINotificationSnackBar.getLayoutParams();
                marginLayoutParams.bottomMargin = i11;
                cOUINotificationSnackBar.setTranslationY(cOUINotificationSnackBar.getHeight() + i11);
                boolean z10 = false;
                for (int i12 = 0; i12 < findSuitableParent.getChildCount(); i12++) {
                    if (findSuitableParent.getChildAt(i12) instanceof COUISnackBar) {
                        z10 = findSuitableParent.getChildAt(i12).getVisibility() != 8;
                    }
                }
                if (!z10) {
                    findSuitableParent.addView(cOUINotificationSnackBar, marginLayoutParams);
                }
                return cOUINotificationSnackBar;
            }
            throw new IllegalArgumentException("Content text and button text can not be empty");
        }
        throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
    }

    public void setNotificationIcon(int i10, int i11) {
        setNotificationIcon(getResources().getDrawable(i10, getContext().getTheme()), i11);
    }
}
