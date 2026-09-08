package com.coui.appcompat.slideview;

import A.h;
import J.d;
import X8.c;
import X8.g;
import X8.m;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.Scroller;
import androidx.core.view.K;
import androidx.customview.widget.a;
import androidx.dynamicanimation.animation.c;
import androidx.dynamicanimation.animation.f;
import b9.C0532b;
import b9.C0534d;
import b9.C0535e;
import b9.C0536f;
import b9.l;
import com.coui.appcompat.animation.COUILinearInterpolator;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.coui.appcompat.roundRect.COUIShapePath;
import com.coui.appcompat.textutil.COUIChangeTextUtil;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class COUISlideView extends LinearLayout {
    private static final int ANIM_DURATION = 200;
    private static final int APPEAR_DURATION = 150;
    private static final int BIT_NUMBER_24 = 24;
    private static final int BIT_NUMBER_32 = 32;
    private static final int COLOR_MASK = 16777215;
    private static final float DAMPING_1 = 0.42857143f;
    private static final float DAMPING_2 = 0.5714286f;
    private static final int DEGREE_180 = 180;
    private static final int DEGREE_270 = 270;
    private static final int DEGREE_360 = 360;
    private static final int DEGREE_90 = 90;
    private static final int DELETAY_VALUE = 4;
    private static final int DISAPPEAR_DURATION = 367;
    private static final int EIGHT = 8;
    private static final int FADE_ANIM_DURATION = 210;
    private static final int FOUR = 4;
    private static final int INVALID_POINTER = -1;
    private static final int LISTVIEW_TOUCH_MODE_SCROLL = 3;
    public static final int MENU_ITEM_NORMAL_RECT_STYLE = 0;
    public static final int MENU_ITEM_ROUND_RECT_STYLE = 1;
    private static final float ONE = 1.0f;
    private static final int ONLY_ONE_ITEM_BACKGROUND_COLOR = 1;
    private static final float POINT_133 = 0.133f;
    private static final float POINT_EIGHT = 0.8f;
    private static final float POINT_FIVE = 0.5f;
    private static final float POINT_THREE = 0.3f;
    private static final int SEVEN = 7;
    private static final int SIX = 6;
    private static final int STATE_BACKGROUND_APPEAR = 1;
    private static final int STATE_BACKGROUND_DISAPPEAR = 2;
    private static final String TAG = "COUISlideView";
    private static final int THREE = 3;
    private static final int VELOCITY_SCALE = 1000;
    private static final int VERTICAL_LINE_WIDTH = 1;
    private static final float ZERO = 0.0f;
    private static Rect sTempRect = new Rect();
    private AccessibilityTouchHelper mAccessibilityTouchHelper;
    private int mActivePointerId;
    private int mAlpha;
    private Interpolator mAppearInterpolator;
    private Paint mBackGroundPaint;
    private ValueAnimator mBackgroundAppearAnimator;
    private ValueAnimator mBackgroundDisappearAnimator;
    private int mBackgroundPadding;
    private boolean mCanCopy;
    private boolean mCanDelete;
    private boolean mCanRename;
    private Context mContext;
    private int mCurColor;
    private int mCurrStatus;
    private int mCurrentTranslateX;
    private boolean mDisableBackgroundAnimator;
    private Interpolator mDisappearInterpolator;
    private Drawable mDiver;
    private boolean mDiverEnable;
    private boolean mDrawItemEnable;
    private boolean mEnableFastDelete;
    private ValueAnimator mFadeAnim;
    private int mFastDelHolderWidth;
    private int mGroupStyle;
    private int mHolderWidth;
    private int mIconCount;
    private int mInitialHeight;
    private int mInitialMotionX;
    private int mInitialMotionY;
    private Interpolator mInterpolator;
    private boolean mIsBeingDragged;
    private boolean mIsMenuRoundStyle;
    private boolean mIsUnableToDrag;
    private int mItemBackgroundColor;
    private int mItemCount;
    private ArrayList<COUISlideMenuItem> mItems;
    private List<Integer> mItemsBackgroundColors;
    private ArrayList<Rect> mItemsRect;
    private int mLastMotionX;
    private int mLastMotionY;
    private int mLastX;
    private int mLastY;
    private Layout mLayout;
    private Paint mLinePaint;
    private int mMaximumVelocity;
    private boolean mMenuDividerEnable;
    private boolean mNeedAutoStartDisAppear;
    private OnDeleteItemClickListener mOnDeleteItemClickListener;
    private OnSlideListener mOnSlideListener;
    private OnSlideMenuItemClickListener mOnSlideMenuItemClickListener;
    private OnSmoothScrollListener mOnSmoothScrollListener;
    private int mOverSlideDeleteSlop;
    private int mPaddingRight;
    private Paint mPaint;
    private Path mPath;
    private Path mPath1;
    private Path mPathArc;
    private int mQuickDeleteSlop;
    private int mRadius;
    int mRefreshStyle;
    private int mRoundRectMenuItemGap;
    private int mRoundRectMenuItemRadius;
    private int mRoundRectMenuLeftMargin;
    private int mRoundRectMenuRightMargin;
    private boolean mScrollAll;
    private Scroller mScroller;
    private int mSlideBackColor;
    private Drawable mSlideColorDrawable;
    private boolean mSlideDelete;
    private boolean mSlideDeleteInRoundMode;
    private boolean mSlideEnable;
    private int mSlideItemPadding;
    private int mSlideTextColor;
    private int mSlideTouchSlop;
    private View mSlideView;
    private Runnable mSmoothScrollRunnable;
    private f mSpringAnimation;
    private boolean mStartDeleteAnimation;
    private int mState;
    private String mStringDelete;
    private int mTargetTranslateX;
    private int mTextPadding;
    private boolean mTouchAllRound;
    private int mTouchSlop;
    private int mUpScrollX;
    private boolean mUseDefaultBackGround;
    private VelocityTracker mVelocityTracker;
    private LinearLayout mViewContent;
    private boolean mhasStartAnimation;

    /* loaded from: classes.dex */
    public class AccessibilityTouchHelper extends a {
        public AccessibilityTouchHelper(View view) {
            super(view);
        }

        @Override // androidx.customview.widget.a
        public int getVirtualViewAt(float f10, float f11) {
            int i10 = (int) f10;
            int i11 = (int) f11;
            for (int i12 = 0; i12 < COUISlideView.this.mItemsRect.size(); i12++) {
                if (((Rect) COUISlideView.this.mItemsRect.get(i12)).contains(i10, i11)) {
                    return i12;
                }
            }
            return Integer.MIN_VALUE;
        }

        @Override // androidx.customview.widget.a
        public void getVisibleVirtualViews(List<Integer> list) {
            for (int i10 = 0; i10 < COUISlideView.this.mItems.size(); i10++) {
                list.add(Integer.valueOf(i10));
            }
        }

        @Override // androidx.customview.widget.a
        public boolean onPerformActionForVirtualView(int i10, int i11, Bundle bundle) {
            if (i11 == 16) {
                if (i10 == 0 && COUISlideView.this.mOnSlideMenuItemClickListener == null) {
                    COUISlideView cOUISlideView = COUISlideView.this;
                    cOUISlideView.startDeleteAnimation(cOUISlideView.mSlideView);
                    return true;
                }
                if (COUISlideView.this.mOnSlideMenuItemClickListener != null) {
                    COUISlideView.this.mOnSlideMenuItemClickListener.onSlideMenuItemClick((COUISlideMenuItem) COUISlideView.this.mItems.get(i10), i10);
                    return true;
                }
                return true;
            }
            return false;
        }

        @Override // androidx.customview.widget.a
        public void onPopulateEventForVirtualView(int i10, AccessibilityEvent accessibilityEvent) {
            String str = (String) ((COUISlideMenuItem) COUISlideView.this.mItems.get(i10)).getText();
            if (str == null) {
                str = "菜单";
            }
            accessibilityEvent.setContentDescription(str);
        }

        @Override // androidx.customview.widget.a
        public void onPopulateNodeForVirtualView(int i10, d dVar) {
            if (i10 < COUISlideView.this.mItemsRect.size()) {
                String str = (String) ((COUISlideMenuItem) COUISlideView.this.mItems.get(i10)).getText();
                if (str == null) {
                    str = "菜单";
                }
                dVar.l0(str);
                dVar.c0((Rect) COUISlideView.this.mItemsRect.get(i10));
                dVar.a(16);
                return;
            }
            dVar.l0("");
            dVar.c0(new Rect());
            dVar.a(16);
        }
    }

    /* loaded from: classes.dex */
    public interface OnDeleteItemClickListener {
        void onDeleteItemClick();
    }

    /* loaded from: classes.dex */
    public interface OnSlideListener {
        public static final int SLIDE_STATUS_OFF = 0;
        public static final int SLIDE_STATUS_ON = 2;
        public static final int SLIDE_STATUS_START_SCROLL = 1;

        void onSlide(View view, int i10);
    }

    /* loaded from: classes.dex */
    public interface OnSlideMenuItemClickListener {
        void onSlideMenuItemClick(COUISlideMenuItem cOUISlideMenuItem, int i10);
    }

    /* loaded from: classes.dex */
    public interface OnSmoothScrollListener {
        void onSmoothScroll(View view);
    }

    public COUISlideView(Context context) {
        this(context, null);
    }

    private RectF checkRect(RectF rectF) {
        float f10 = rectF.left;
        float f11 = rectF.right;
        if (f10 > f11) {
            rectF.left = f11;
            rectF.right = f10;
        }
        return rectF;
    }

    private void clipBottomRound(Canvas canvas) {
        Path path = this.mPath1;
        if (path == null) {
            this.mPath1 = new Path();
        } else {
            path.reset();
        }
        if (isLayoutRtl()) {
            this.mPath1.moveTo(0.0f, getHeight() - (this.mRadius / 2));
            this.mPath1.lineTo(0.0f, getHeight());
            this.mPath1.lineTo(this.mRadius / 2, getHeight());
        } else {
            this.mPath1.moveTo(this.mHolderWidth, getHeight() - (this.mRadius / 2));
            this.mPath1.lineTo(this.mHolderWidth, getHeight());
            this.mPath1.lineTo(this.mHolderWidth - (this.mRadius / 2), getHeight());
        }
        this.mPath1.close();
        canvas.clipPath(this.mPath1, Region.Op.DIFFERENCE);
        Path path2 = this.mPathArc;
        if (path2 == null) {
            this.mPathArc = new Path();
        } else {
            path2.reset();
        }
        if (isLayoutRtl()) {
            int height = getHeight();
            this.mPathArc.addArc(new RectF(0.0f, height - r4, this.mRadius, getHeight()), 90.0f, 180.0f);
        } else {
            this.mPathArc.addArc(new RectF(this.mHolderWidth - this.mRadius, getHeight() - this.mRadius, this.mHolderWidth, getHeight()), 0.0f, 90.0f);
        }
        canvas.clipPath(this.mPathArc, Region.Op.UNION);
    }

    private void clipTopRound(Canvas canvas) {
        Path path = this.mPath1;
        if (path == null) {
            this.mPath1 = new Path();
        } else {
            path.reset();
        }
        if (isLayoutRtl()) {
            this.mPath1.moveTo(this.mRadius / 2, 0.0f);
            this.mPath1.lineTo(0.0f, 0.0f);
            this.mPath1.lineTo(0.0f, this.mRadius / 2);
        } else {
            this.mPath1.moveTo(this.mHolderWidth, this.mRadius / 2);
            this.mPath1.lineTo(this.mHolderWidth, 0.0f);
            this.mPath1.lineTo(this.mHolderWidth - (this.mRadius / 2), 0.0f);
        }
        this.mPath1.close();
        canvas.clipPath(this.mPath1, Region.Op.DIFFERENCE);
        Path path2 = this.mPathArc;
        if (path2 == null) {
            this.mPathArc = new Path();
        } else {
            path2.reset();
        }
        if (isLayoutRtl()) {
            int i10 = this.mRadius;
            this.mPathArc.addArc(new RectF(0.0f, 0.0f, i10, i10), -90.0f, -180.0f);
        } else {
            this.mPathArc.addArc(new RectF(r3 - r4, 0.0f, this.mHolderWidth, this.mRadius), 0.0f, -90.0f);
        }
        canvas.clipPath(this.mPathArc, Region.Op.UNION);
    }

    private void drawBackGround(Canvas canvas) {
        int slideViewScrollX;
        int width;
        boolean z10;
        boolean z11;
        if (this.mIsMenuRoundStyle) {
            this.mBackGroundPaint.setColor(this.mCurColor);
            if (!isLayoutRtl() && !this.mTouchAllRound) {
                slideViewScrollX = 0;
            } else {
                slideViewScrollX = (-this.mBackgroundPadding) - getSlideViewScrollX();
            }
            if (isLayoutRtl() && !this.mTouchAllRound) {
                width = getWidth();
            } else {
                width = (getWidth() + this.mBackgroundPadding) - getSlideViewScrollX();
            }
            RectF rectF = new RectF(slideViewScrollX, 0.0f, width, getHeight());
            boolean isLayoutRtl = isLayoutRtl();
            boolean z12 = !isLayoutRtl();
            if (this.mTouchAllRound) {
                z10 = true;
                z11 = true;
            } else {
                z10 = isLayoutRtl;
                z11 = z12;
            }
            Path roundRectPath = COUIShapePath.getRoundRectPath(this.mPath, rectF, Math.min(getHeight() / 2, this.mRoundRectMenuItemRadius), z10, z11, z10, z11);
            this.mPath = roundRectPath;
            canvas.drawPath(roundRectPath, this.mBackGroundPaint);
        }
    }

    private void drawDiver(Canvas canvas) {
        canvas.save();
        this.mDiver.setBounds(0, getHeight() - this.mDiver.getIntrinsicHeight(), getWidth(), getHeight());
        this.mDiver.draw(canvas);
        canvas.restore();
    }

    private void drawItemBackground(Canvas canvas) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        boolean z10;
        float f10;
        int i15;
        float f11;
        int i16;
        int i17;
        if (this.mItemCount <= 0) {
            return;
        }
        canvas.save();
        int i18 = this.mAlpha;
        if (i18 > 0) {
            canvas.drawColor((i18 << 24) | this.mSlideBackColor);
        }
        int i19 = 1;
        if (isLayoutRtl()) {
            i10 = -1;
        } else {
            i10 = 1;
        }
        if (isLayoutRtl()) {
            canvas.translate(getWidth(), 0.0f);
        }
        if (this.mLayout == null) {
            this.mLayout = new StaticLayout(this.mStringDelete, (TextPaint) this.mPaint, this.mHolderWidth, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
        }
        int unpackRangeStartFromLong = unpackRangeStartFromLong(getLineRangeForDraw(canvas));
        if (unpackRangeStartFromLong < 0) {
            canvas.restore();
            return;
        }
        Paint paint = new Paint();
        int i20 = this.mItemBackgroundColor;
        int i21 = this.mAlpha;
        if (i21 > 0) {
            paint.setColor((i20 & 16777215) | (i21 << 24));
        } else {
            paint.setColor(i20);
        }
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        int width = getWidth() - (getSlideViewScrollX() * i10);
        int i22 = 0;
        if (this.mItemsBackgroundColors.size() == 1) {
            RectF rectF = new RectF(width * i10, 0.0f, getWidth() * i10, getHeight());
            if (this.mIsMenuRoundStyle) {
                float f12 = rectF.left + (this.mRoundRectMenuLeftMargin * i10);
                rectF.left = f12;
                if (this.mSlideDeleteInRoundMode || this.mSlideDelete) {
                    rectF.right -= this.mRoundRectMenuRightMargin * i10;
                } else {
                    rectF.right = f12 + (this.mItems.get(0).getWidth() * i10);
                }
                Path roundRectPath = COUIShapePath.getRoundRectPath(this.mPath, checkRect(rectF), Math.min(getHeight() / 2, this.mRoundRectMenuItemRadius));
                this.mPath = roundRectPath;
                canvas.drawPath(roundRectPath, paint);
            } else {
                canvas.drawRect(rectF, paint);
            }
        }
        int lineTop = this.mLayout.getLineTop(unpackRangeStartFromLong + 1) - this.mLayout.getLineDescent(unpackRangeStartFromLong);
        Paint.FontMetrics fontMetrics = this.mPaint.getFontMetrics();
        int ceil = ((int) Math.ceil(fontMetrics.descent)) - ((int) Math.ceil(fontMetrics.ascent));
        int i23 = 0;
        while (i23 < this.mItemCount) {
            this.mItems.get(i23).getBackground();
            Drawable icon = this.mItems.get(i23).getIcon();
            if (!this.mIsMenuRoundStyle && getSlideViewScrollX() * i10 > this.mHolderWidth && !this.mhasStartAnimation) {
                i11 = (getSlideViewScrollX() * i10) - this.mHolderWidth;
            } else {
                i11 = i22;
            }
            if (getSlideViewScrollX() * i10 > this.mHolderWidth && this.mhasStartAnimation) {
                i12 = (getSlideViewScrollX() * i10) - this.mHolderWidth;
            } else {
                i12 = i22;
            }
            if (this.mEnableFastDelete && this.mSlideDelete) {
                if (this.mItemCount + i19 != 0 && getWidth() - (this.mUpScrollX * i10) != 0) {
                    int width2 = getWidth();
                    int i24 = this.mUpScrollX;
                    int i25 = this.mItemCount;
                    int i26 = this.mHolderWidth;
                    i13 = (width2 - (i24 * i10)) + (((i25 - i23) * ((i24 * i10) - i26)) / (i25 + 1)) + ((((((i25 - i23) * ((i24 * i10) - i26)) / (i25 + i19)) * (getSlideViewScrollX() - this.mUpScrollX)) * i10) / (getWidth() - (this.mUpScrollX * i10)));
                } else {
                    i13 = i22;
                }
            } else {
                int width3 = getWidth() - (getSlideViewScrollX() * i10);
                int i27 = this.mItemCount;
                i13 = i12 + width3 + (((i27 - i23) * i11) / (i27 + i19));
            }
            int i28 = i13 * i10;
            for (int i29 = this.mItemCount - i19; i29 > i23; i29--) {
                i28 += this.mItems.get(i29).getWidth() * i10;
            }
            int height = getHeight();
            int width4 = this.mItems.get(i23).getWidth() + i28;
            if (this.mItems.get(i23).getText() != null) {
                canvas.drawText((String) this.mItems.get(i23).getText(), ((this.mItems.get(i23).getWidth() * i10) / 2) + i28, (lineTop + (height / 2)) - (ceil / 2), this.mPaint);
            }
            if (this.mItemsRect.size() != this.mItems.size()) {
                this.mItemsRect = new ArrayList<>();
                for (int i30 = 0; i30 < this.mItems.size(); i30++) {
                    this.mItemsRect.add(i30, new Rect());
                }
            }
            if (this.mItemsRect.size() > 0) {
                this.mItemsRect.get(i23).set(i28, 0, width4, height);
            }
            if (icon != null) {
                if (this.mIsMenuRoundStyle) {
                    i28 += (this.mRoundRectMenuLeftMargin + (((this.mItemCount - 1) - i23) * this.mRoundRectMenuItemGap)) * i10;
                }
                int intrinsicWidth = icon.getIntrinsicWidth();
                int intrinsicHeight = icon.getIntrinsicHeight();
                int width5 = (((this.mItems.get(i23).getWidth() - intrinsicWidth) * i10) / 2) + i28;
                int i31 = (height - intrinsicHeight) / 2;
                int i32 = (intrinsicWidth * i10) + width5;
                if (width5 > i32) {
                    width5 = i32;
                    i32 = width5;
                }
                if (this.mItemsBackgroundColors.size() != 1 && this.mItemsBackgroundColors.size() == this.mItems.size() && i23 < this.mItemsBackgroundColors.size()) {
                    paint.setColor(this.mItemsBackgroundColors.get(i23).intValue());
                    int width6 = (this.mItems.get(i23).getWidth() * i10) + i28;
                    float round = Math.round(i11 / (this.mItemCount + 1.0f));
                    if (i23 == 0) {
                        i17 = (int) (i28 - ((round / 2.0f) * i10));
                        i16 = getWidth() * i10;
                    } else {
                        if (i23 == this.mItems.size() - 1) {
                            float f13 = i10;
                            i15 = (int) (i28 - (round * f13));
                            f11 = width6;
                            f10 = (round / 2.0f) * f13;
                        } else {
                            f10 = (round / 2.0f) * i10;
                            i15 = (int) (i28 - f10);
                            f11 = width6;
                        }
                        i16 = (int) (f11 + f10);
                        i17 = i15;
                    }
                    i14 = lineTop;
                    z10 = false;
                    RectF rectF2 = new RectF(i17, 0.0f, i16, getHeight());
                    if (this.mIsMenuRoundStyle) {
                        rectF2.right = rectF2.left + (this.mItems.get(i23).getWidth() * i10);
                        COUIShapePath.getRoundRectPath(this.mPath, checkRect(rectF2), Math.min(getHeight() / 2, this.mRoundRectMenuItemRadius));
                        canvas.drawPath(this.mPath, paint);
                    } else {
                        canvas.drawRect(rectF2, paint);
                    }
                } else {
                    i14 = lineTop;
                    z10 = false;
                }
                icon.setBounds(width5, i31, i32, intrinsicHeight + i31);
                icon.draw(canvas);
            } else {
                i14 = lineTop;
                z10 = false;
            }
            i23++;
            lineTop = i14;
            i19 = 1;
            i22 = 0;
        }
        canvas.restore();
        if (K.j(this) == null) {
            K.j0(this, this.mAccessibilityTouchHelper);
            K.t0(this, 1);
        }
    }

    private void endDrag() {
        recycleVelocityTracker();
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
    }

    private void initAnimation(Context context) {
        final int attrColor = COUIContextUtil.getAttrColor(context, c.f4346E);
        int alpha = Color.alpha(attrColor);
        ValueAnimator ofInt = ValueAnimator.ofInt(0, alpha);
        this.mBackgroundAppearAnimator = ofInt;
        ofInt.setDuration(150L);
        this.mBackgroundAppearAnimator.setInterpolator(this.mAppearInterpolator);
        this.mBackgroundAppearAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.slideview.COUISlideView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                COUISlideView.this.mCurColor = Color.argb(((Integer) valueAnimator.getAnimatedValue()).intValue(), Color.red(attrColor), Color.green(attrColor), Color.blue(attrColor));
                COUISlideView.this.invalidate();
            }
        });
        this.mBackgroundAppearAnimator.addListener(new Animator.AnimatorListener() { // from class: com.coui.appcompat.slideview.COUISlideView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                COUISlideView.this.mState = 1;
                if (COUISlideView.this.mNeedAutoStartDisAppear) {
                    COUISlideView.this.mNeedAutoStartDisAppear = false;
                    COUISlideView.this.mBackgroundDisappearAnimator.start();
                }
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
        ValueAnimator ofInt2 = ValueAnimator.ofInt(alpha, 0);
        this.mBackgroundDisappearAnimator = ofInt2;
        ofInt2.setDuration(367L);
        this.mBackgroundDisappearAnimator.setInterpolator(this.mDisappearInterpolator);
        this.mBackgroundDisappearAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.slideview.COUISlideView.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                COUISlideView.this.mCurColor = Color.argb(((Integer) valueAnimator.getAnimatedValue()).intValue(), Color.red(attrColor), Color.green(attrColor), Color.blue(attrColor));
                COUISlideView.this.invalidate();
            }
        });
        this.mBackgroundDisappearAnimator.addListener(new Animator.AnimatorListener() { // from class: com.coui.appcompat.slideview.COUISlideView.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                COUISlideView.this.mState = 2;
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
    }

    private void initOrResetVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void initVelocityTrackerIfNotExists() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private void initView() {
        this.mContext = getContext();
        int suitableFontSize = (int) COUIChangeTextUtil.getSuitableFontSize(getResources().getDimensionPixelSize(C0535e.f12382N), getResources().getConfiguration().fontScale, 2);
        this.mSlideTouchSlop = getResources().getDimensionPixelSize(C0535e.f12387S);
        this.mOverSlideDeleteSlop = getResources().getDimensionPixelSize(C0535e.f12385Q);
        this.mQuickDeleteSlop = getResources().getDimensionPixelSize(C0535e.f12386R);
        TextPaint textPaint = new TextPaint();
        this.mPaint = textPaint;
        textPaint.setColor(this.mSlideTextColor);
        this.mPaint.setTextSize(suitableFontSize);
        this.mTextPadding = this.mContext.getResources().getDimensionPixelSize(C0535e.f12381M);
        this.mPaddingRight = this.mContext.getResources().getDimensionPixelSize(C0535e.f12380L);
        this.mRadius = this.mContext.getResources().getDimensionPixelSize(C0535e.f12383O);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setTextAlign(Paint.Align.CENTER);
        this.mItems = new ArrayList<>();
        this.mItemsRect = new ArrayList<>();
        this.mAccessibilityTouchHelper = new AccessibilityTouchHelper(this);
        this.mMaximumVelocity = ViewConfiguration.get(this.mContext).getScaledMaximumFlingVelocity();
        setDeleteEnable(true);
        TextPaint textPaint2 = new TextPaint();
        this.mLinePaint = textPaint2;
        textPaint2.setStrokeWidth(1.0f);
        this.mLinePaint.setColor(this.mContext.getResources().getColor(C0534d.f12365c));
        this.mLinePaint.setAntiAlias(true);
        this.mDiver = getContext().getResources().getDrawable(g.f4858k);
        this.mInterpolator = K.a.a(POINT_133, 0.0f, 0.3f, 1.0f);
        this.mScroller = new Scroller(this.mContext, this.mInterpolator);
        setOrientation(0);
        setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        itemWidthChange();
        this.mStringDelete = this.mContext.getString(m.f5015n);
        this.mSlideBackColor = this.mContext.getResources().getColor(C0534d.f12364b);
        ColorDrawable colorDrawable = new ColorDrawable(this.mSlideBackColor);
        this.mSlideColorDrawable = colorDrawable;
        this.mSlideBackColor &= 16777215;
        ObjectAnimator ofInt = ObjectAnimator.ofInt(colorDrawable, "Alpha", 0, FADE_ANIM_DURATION);
        this.mFadeAnim = ofInt;
        ofInt.setInterpolator(this.mInterpolator);
        this.mFadeAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.slideview.COUISlideView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                COUISlideView.this.mAlpha = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            }
        });
        this.mSlideItemPadding = getResources().getDimensionPixelSize(C0535e.f12376H);
        setWillNotDraw(false);
    }

    private void itemWidthChange() {
        int i10;
        int i11 = 0;
        this.mHolderWidth = 0;
        this.mItemCount = this.mItems.size();
        while (true) {
            i10 = this.mItemCount;
            if (i11 >= i10) {
                break;
            }
            this.mHolderWidth += this.mItems.get(i11).getWidth();
            i11++;
        }
        int i12 = this.mHolderWidth;
        this.mFastDelHolderWidth = i12;
        if (this.mIsMenuRoundStyle) {
            this.mHolderWidth = i12 + ((i10 - 1) * this.mRoundRectMenuItemGap) + this.mRoundRectMenuLeftMargin + this.mRoundRectMenuRightMargin;
        }
    }

    public static long packRangeInLong(int i10, int i11) {
        return i11 | (i10 << 32);
    }

    private void recycleVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private void requestParentDisallowInterceptTouchEvent(boolean z10) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z10);
        }
    }

    public static int unpackRangeStartFromLong(long j10) {
        return (int) (j10 >>> 32);
    }

    public void addColor(int i10) {
        addColor(-1, i10);
    }

    public void addItem(COUISlideMenuItem cOUISlideMenuItem) {
        addItem(-1, cOUISlideMenuItem);
    }

    public void animationScrollTo(int i10, int i11) {
        f x10 = new f(this.mSlideView, androidx.dynamicanimation.animation.c.f9708y).x(new androidx.dynamicanimation.animation.g(i10).d(1.0f).f(200.0f));
        this.mSpringAnimation = x10;
        x10.p();
        this.mSpringAnimation.a(new c.q() { // from class: com.coui.appcompat.slideview.COUISlideView.10
            @Override // androidx.dynamicanimation.animation.c.q
            public void onAnimationEnd(androidx.dynamicanimation.animation.c cVar, boolean z10, float f10, float f11) {
            }
        });
    }

    public void cancelBackgroundAnimators() {
        if (this.mBackgroundDisappearAnimator.isRunning()) {
            this.mBackgroundDisappearAnimator.cancel();
        }
        if (this.mBackgroundAppearAnimator.isRunning()) {
            this.mNeedAutoStartDisAppear = false;
            this.mBackgroundAppearAnimator.cancel();
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            if (this.mScrollAll) {
                scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
            } else {
                this.mSlideView.scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
            }
            postInvalidate();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        AccessibilityTouchHelper accessibilityTouchHelper = this.mAccessibilityTouchHelper;
        if (accessibilityTouchHelper != null && accessibilityTouchHelper.dispatchHoverEvent(motionEvent)) {
            return true;
        }
        return super.dispatchHoverEvent(motionEvent);
    }

    public void enableFastDelete(boolean z10) {
        this.mEnableFastDelete = z10;
    }

    public View getContentView() {
        return this.mSlideView;
    }

    public CharSequence getDeleteItemText() {
        if (this.mCanDelete) {
            return this.mItems.get(0).getText();
        }
        return null;
    }

    public Drawable getDiver() {
        return this.mDiver;
    }

    public boolean getDiverEnable() {
        return this.mDiverEnable;
    }

    public boolean getDrawItemEnable() {
        return this.mDrawItemEnable;
    }

    public int getHolderWidth() {
        return this.mHolderWidth;
    }

    public int getLineForVertical(int i10) {
        int lineCount = this.mLayout.getLineCount();
        int i11 = -1;
        while (lineCount - i11 > 1) {
            int i12 = (lineCount + i11) / 2;
            if (this.mLayout.getLineTop(i12) > i10) {
                lineCount = i12;
            } else {
                i11 = i12;
            }
        }
        if (i11 < 0) {
            return 0;
        }
        return i11;
    }

    public long getLineRangeForDraw(Canvas canvas) {
        synchronized (sTempRect) {
            try {
                if (!canvas.getClipBounds(sTempRect)) {
                    return packRangeInLong(0, -1);
                }
                Rect rect = sTempRect;
                int i10 = rect.top;
                int i11 = rect.bottom;
                int max = Math.max(i10, 0);
                Layout layout = this.mLayout;
                int min = Math.min(layout.getLineTop(layout.getLineCount()), i11);
                if (max >= min) {
                    return packRangeInLong(0, -1);
                }
                return packRangeInLong(getLineForVertical(max), getLineForVertical(min));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Scroller getScroll() {
        return this.mScroller;
    }

    public boolean getSlideEnable() {
        return this.mSlideEnable;
    }

    public int getSlideViewScrollX() {
        if (this.mScrollAll) {
            return getScrollX();
        }
        return this.mSlideView.getScrollX();
    }

    @Override // android.view.View
    public boolean hasFocusable() {
        if (getVisibility() != 0 || !isFocusable()) {
            return false;
        }
        return true;
    }

    public boolean isLayoutRtl() {
        if (getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    public boolean isSliding() {
        return this.mhasStartAnimation;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mSlideEnable || this.mDrawItemEnable) {
            drawBackGround(canvas);
            drawItemBackground(canvas);
        }
        if (this.mDiverEnable) {
            drawDiver(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int scrollX;
        int i10;
        int i11;
        int i12;
        int i13;
        if (!this.mSlideEnable) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        if (action != 3 && action != 1) {
            if (action != 0) {
                if (this.mIsBeingDragged) {
                    return true;
                }
                if (this.mIsUnableToDrag) {
                    return false;
                }
            }
            if (this.mScrollAll) {
                scrollX = getScrollX();
            } else {
                scrollX = this.mSlideView.getScrollX();
            }
            if (action != 0) {
                if (action == 2 && (i10 = this.mActivePointerId) != -1) {
                    int findPointerIndex = motionEvent.findPointerIndex(i10);
                    if (findPointerIndex == -1) {
                        Log.e(TAG, "Invalid pointerId=" + this.mActivePointerId + " in onInterceptTouchEvent ACTION_MOVE");
                        return false;
                    }
                    int x10 = (int) motionEvent.getX(findPointerIndex);
                    int i14 = x10 - this.mLastMotionX;
                    int abs = Math.abs(i14);
                    int y10 = (int) motionEvent.getY(findPointerIndex);
                    int abs2 = Math.abs(y10 - this.mInitialMotionY);
                    this.mLastMotionX = x10;
                    this.mLastMotionY = y10;
                    int i15 = this.mTouchSlop;
                    if (abs > i15 && abs * 0.5f > abs2) {
                        this.mIsBeingDragged = true;
                        requestParentDisallowInterceptTouchEvent(true);
                        if (i14 > 0) {
                            i13 = this.mInitialMotionX + this.mTouchSlop;
                        } else {
                            i13 = this.mInitialMotionX - this.mTouchSlop;
                        }
                        this.mLastMotionX = i13;
                        this.mLastMotionY = y10;
                    } else if (abs2 > i15) {
                        this.mIsUnableToDrag = true;
                    }
                    if (this.mIsBeingDragged) {
                        initVelocityTrackerIfNotExists();
                        this.mVelocityTracker.addMovement(motionEvent);
                        if (Math.abs(scrollX) < this.mHolderWidth && this.mItemCount != 1) {
                            i11 = (i14 * 4) / 7;
                        } else {
                            i11 = (i14 * 3) / 7;
                        }
                        int i16 = scrollX - i11;
                        if ((getLayoutDirection() != 1 && i16 < 0) || (getLayoutDirection() == 1 && i16 > 0)) {
                            i16 = 0;
                        } else if (Math.abs(i16) > this.mHolderWidth) {
                            if (getLayoutDirection() == 1) {
                                i12 = -this.mHolderWidth;
                            } else {
                                i12 = this.mHolderWidth;
                            }
                            i16 = i12;
                        }
                        if (this.mScrollAll) {
                            scrollTo(i16, 0);
                        } else {
                            this.mSlideView.scrollTo(i16, 0);
                        }
                    }
                }
            } else {
                this.mActivePointerId = motionEvent.getPointerId(0);
                initOrResetVelocityTracker();
                this.mVelocityTracker.addMovement(motionEvent);
                int x11 = (int) motionEvent.getX();
                this.mLastMotionX = x11;
                this.mInitialMotionX = x11;
                int y11 = (int) motionEvent.getY();
                this.mLastMotionY = y11;
                this.mInitialMotionY = y11;
                this.mIsUnableToDrag = false;
                OnSlideListener onSlideListener = this.mOnSlideListener;
                if (onSlideListener != null) {
                    onSlideListener.onSlide(this, 1);
                }
            }
            return this.mIsBeingDragged;
        }
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        this.mActivePointerId = -1;
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:124:0x02eb, code lost:
    
        if (r0 < r4) goto L187;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0302, code lost:
    
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0305, code lost:
    
        if (r3 >= r14.mItemCount) goto L270;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0307, code lost:
    
        r4 = 0;
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0309, code lost:
    
        if (r4 >= r3) goto L277;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x030b, code lost:
    
        r7 = r7 + r14.mItems.get(r4).getWidth();
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x031f, code lost:
    
        if (isLayoutRtl() == false) goto L200;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0330, code lost:
    
        if (r14.mInitialMotionX >= (r14.mItems.get(r3).getWidth() + r7)) goto L273;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x033f, code lost:
    
        if (r0 >= (r7 + r14.mItems.get(r3).getWidth())) goto L274;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x036e, code lost:
    
        if (r14.mCanDelete == false) goto L212;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x0370, code lost:
    
        if (r3 != 0) goto L212;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0374, code lost:
    
        if (r14.mhasStartAnimation != false) goto L212;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x0378, code lost:
    
        if (r14.mStartDeleteAnimation == false) goto L212;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x037a, code lost:
    
        r14.mhasStartAnimation = true;
        startDeleteAnimation(r14.mSlideView);
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x0381, code lost:
    
        playSoundEffect(0);
        r2 = r14.mOnSlideMenuItemClickListener;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x0386, code lost:
    
        if (r2 == null) goto L233;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x0388, code lost:
    
        r2.onSlideMenuItemClick(r14.mItems.get(r3), r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0394, code lost:
    
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x0356, code lost:
    
        if (r14.mInitialMotionX <= ((getWidth() - r7) - r14.mItems.get(r3).getWidth())) goto L275;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x036a, code lost:
    
        if (r0 <= ((getWidth() - r7) - r14.mItems.get(r3).getWidth())) goto L276;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0032, code lost:
    
        if (r0 < (getWidth() - getSlideViewScrollX())) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x0300, code lost:
    
        if (r0 > (getWidth() - r14.mHolderWidth)) goto L187;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:163:0x03a3  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x02d0  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r15) {
        /*
            Method dump skipped, instructions count: 1165
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.slideview.COUISlideView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void refresh() {
        String resourceTypeName = getResources().getResourceTypeName(this.mRefreshStyle);
        TypedArray typedArray = null;
        if (TextUtils.equals(resourceTypeName, "attr")) {
            typedArray = getContext().getTheme().obtainStyledAttributes(null, l.f12589V0, this.mRefreshStyle, 0);
        } else if (TextUtils.equals(resourceTypeName, "style")) {
            typedArray = getContext().getTheme().obtainStyledAttributes(null, l.f12589V0, 0, this.mRefreshStyle);
        }
        if (typedArray != null) {
            int color = typedArray.getColor(l.f12595Y0, this.mItemBackgroundColor);
            this.mItemBackgroundColor = color;
            this.mItemsBackgroundColors.set(0, Integer.valueOf(color));
            this.mSlideTextColor = typedArray.getColor(l.f12597Z0, getContext().getResources().getColor(C0534d.f12366d));
            invalidate();
            typedArray.recycle();
        }
    }

    public void removeColor(int i10) {
        if (i10 >= 0 && !this.mItemsBackgroundColors.isEmpty() && i10 < this.mItemsBackgroundColors.size()) {
            this.mItemsBackgroundColors.remove(i10);
            postInvalidate();
        }
    }

    public void removeItem(int i10) {
        if (i10 >= 0 && i10 < this.mItems.size()) {
            this.mItems.remove(i10);
            itemWidthChange();
        }
    }

    public void restoreLayout() {
        this.mAlpha = 0;
        this.mSlideView.setTranslationX(0.0f);
        getContentView().getLayoutParams().height = this.mInitialHeight;
        setVisibility(0);
        clearAnimation();
        this.mhasStartAnimation = false;
    }

    public void setBackgroundPadding(int i10) {
        this.mBackgroundPadding = i10;
    }

    public void setCanStartDeleteAnimation(boolean z10) {
        this.mStartDeleteAnimation = z10;
    }

    public void setContentView(View view) {
        if (this.mScrollAll) {
            this.mViewContent.addView(view, new LinearLayout.LayoutParams(-1, -1));
            this.mSlideView = this;
        } else {
            addView(view, new LinearLayout.LayoutParams(-1, -1));
            this.mSlideView = view;
        }
    }

    public void setDeleteEnable(boolean z10) {
        if (this.mCanDelete == z10) {
            return;
        }
        this.mCanDelete = z10;
        int i10 = 0;
        if (z10) {
            ArrayList<COUISlideMenuItem> arrayList = this.mItems;
            Context context = this.mContext;
            arrayList.add(0, new COUISlideMenuItem(context, context.getDrawable(C0536f.f12450d)));
            if (this.mPaint != null) {
                COUISlideMenuItem cOUISlideMenuItem = this.mItems.get(0);
                if (cOUISlideMenuItem.getText() != null) {
                    i10 = ((int) this.mPaint.measureText((String) cOUISlideMenuItem.getText())) + (this.mTextPadding * 2);
                }
                if (i10 > cOUISlideMenuItem.getWidth()) {
                    cOUISlideMenuItem.setWidth(i10);
                }
            }
        } else {
            this.mItems.remove(0);
        }
        itemWidthChange();
    }

    public void setDeleteItemIcon(int i10) {
        if (this.mCanDelete) {
            this.mItems.get(0).setIcon(i10);
        }
    }

    public void setDeleteItemText(CharSequence charSequence) {
        int measureText;
        if (this.mCanDelete) {
            COUISlideMenuItem cOUISlideMenuItem = this.mItems.get(0);
            cOUISlideMenuItem.setText(charSequence);
            Paint paint = this.mPaint;
            if (paint == null || (measureText = ((int) paint.measureText((String) cOUISlideMenuItem.getText())) + (this.mTextPadding * 2)) <= cOUISlideMenuItem.getWidth()) {
                return;
            }
            cOUISlideMenuItem.setWidth(measureText);
            itemWidthChange();
        }
    }

    public void setDisableBackgroundAnimator(boolean z10) {
        this.mDisableBackgroundAnimator = z10;
    }

    public void setDiver(int i10) {
        setDiver(getContext().getResources().getDrawable(i10));
    }

    public void setDiverEnable(boolean z10) {
        this.mDiverEnable = z10;
        invalidate();
    }

    public void setDrawItemEnable(boolean z10) {
        this.mDrawItemEnable = z10;
    }

    public void setGroupOffset(int i10) {
        this.mPaddingRight = i10;
    }

    public void setItemBackgroundColor(int i10) {
        if (this.mItemBackgroundColor != i10) {
            this.mItemBackgroundColor = i10;
            this.mItemsBackgroundColors.set(0, Integer.valueOf(i10));
            invalidate();
        }
    }

    public void setMenuDividerEnable(boolean z10) {
        this.mMenuDividerEnable = z10;
    }

    public void setMenuItemStyle(int i10) {
        if (i10 == 1) {
            this.mIsMenuRoundStyle = true;
        } else {
            this.mIsMenuRoundStyle = false;
        }
        itemWidthChange();
        initAnimation(getContext());
    }

    public void setOnDeleteItemClickListener(OnDeleteItemClickListener onDeleteItemClickListener) {
        this.mOnDeleteItemClickListener = onDeleteItemClickListener;
    }

    public void setOnSlideListener(OnSlideListener onSlideListener) {
        this.mOnSlideListener = onSlideListener;
    }

    public void setOnSlideMenuItemClickListener(OnSlideMenuItemClickListener onSlideMenuItemClickListener) {
        this.mOnSlideMenuItemClickListener = onSlideMenuItemClickListener;
    }

    public void setOnSmoothScrollListener(OnSmoothScrollListener onSmoothScrollListener) {
        this.mOnSmoothScrollListener = onSmoothScrollListener;
    }

    public void setRoundRectMenuLeftMargin(int i10) {
        this.mRoundRectMenuLeftMargin = i10;
    }

    public void setRoundRectMenuRightMargin(int i10) {
        this.mRoundRectMenuRightMargin = i10;
    }

    public void setSlideEnable(boolean z10) {
        this.mSlideEnable = z10;
    }

    public void setSlideTextColor(int i10) {
        if (this.mSlideTextColor != i10) {
            this.mSlideTextColor = i10;
            this.mPaint.setColor(i10);
            invalidate();
        }
    }

    public void setSlideViewScrollX(int i10) {
        if (this.mScrollAll) {
            scrollTo(i10, getScrollY());
        } else {
            View view = this.mSlideView;
            view.scrollTo(i10, view.getScrollY());
        }
    }

    public void setTouchAllRound(boolean z10) {
        this.mTouchAllRound = z10;
    }

    public void setUseDefaultBackground(boolean z10) {
        this.mUseDefaultBackGround = z10;
    }

    public void shrink() {
        f fVar = this.mSpringAnimation;
        if (fVar != null) {
            fVar.y();
        }
        if (getSlideViewScrollX() != 0) {
            if (this.mOnSmoothScrollListener != null) {
                Runnable runnable = this.mSmoothScrollRunnable;
                if (runnable != null) {
                    removeCallbacks(runnable);
                }
                Runnable runnable2 = new Runnable() { // from class: com.coui.appcompat.slideview.COUISlideView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        COUISlideView.this.mSmoothScrollRunnable = null;
                        if (COUISlideView.this.mOnSmoothScrollListener != null) {
                            COUISlideView.this.mOnSmoothScrollListener.onSmoothScroll(COUISlideView.this);
                        }
                    }
                };
                this.mSmoothScrollRunnable = runnable2;
                postDelayed(runnable2, 200L);
            }
            smoothScrollTo(0, 0);
            this.mCurrStatus = 0;
            OnSlideListener onSlideListener = this.mOnSlideListener;
            if (onSlideListener != null) {
                onSlideListener.onSlide(this, 0);
            }
            startDisAppearAnimationOrNot();
        }
    }

    public void smoothScrollTo(int i10, int i11) {
        int i12;
        int slideViewScrollX = getSlideViewScrollX();
        int i13 = i10 - slideViewScrollX;
        int abs = Math.abs(i13) * 3;
        if (abs > 200) {
            i12 = 200;
        } else {
            i12 = abs;
        }
        this.mScroller.startScroll(slideViewScrollX, 0, i13, 0, i12);
        invalidate();
    }

    public void startAppearAnimation() {
        startAppearAnimation(this.mDisableBackgroundAnimator);
    }

    public void startDeleteAnimation(View view) {
        if (this.mIsMenuRoundStyle) {
            this.mSlideDeleteInRoundMode = true;
        }
        int i10 = getLayoutDirection() == 1 ? -this.mHolderWidth : this.mHolderWidth;
        int width = getLayoutDirection() == 1 ? -getWidth() : getWidth();
        this.mInitialHeight = getMeasuredHeight();
        new COUISlideDeleteAnimation(view, this, i10, width, getHeight(), 0) { // from class: com.coui.appcompat.slideview.COUISlideView.7
            @Override // com.coui.appcompat.slideview.COUISlideDeleteAnimation
            public void itemViewDelete() {
                if (COUISlideView.this.mOnDeleteItemClickListener != null) {
                    COUISlideView.this.mhasStartAnimation = false;
                    COUISlideView.this.mOnDeleteItemClickListener.onDeleteItemClick();
                }
            }
        }.startAnimation();
    }

    public void startDeleteSlideAnimation(View view) {
        int width;
        this.mSlideDelete = true;
        this.mCurrentTranslateX = getSlideViewScrollX();
        if (getLayoutDirection() == 1) {
            width = -getWidth();
        } else {
            width = getWidth();
        }
        this.mTargetTranslateX = width;
        this.mInitialHeight = getMeasuredHeight();
        new COUISlideDeleteAnimation(view, this, this.mCurrentTranslateX, this.mTargetTranslateX, getHeight(), 0) { // from class: com.coui.appcompat.slideview.COUISlideView.8
            @Override // com.coui.appcompat.slideview.COUISlideDeleteAnimation
            public void itemViewDelete() {
                if (COUISlideView.this.mOnDeleteItemClickListener != null) {
                    COUISlideView.this.mhasStartAnimation = false;
                    COUISlideView.this.mOnDeleteItemClickListener.onDeleteItemClick();
                }
            }
        }.startAnimation();
    }

    public void startDisAppearAnimationOrNot() {
        startDisAppearAnimationOrNot(this.mDisableBackgroundAnimator);
    }

    public COUISlideView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0532b.f12354m);
    }

    public void addColor(int i10, int i11) {
        if (i10 < 0) {
            this.mItemsBackgroundColors.add(Integer.valueOf(i11));
        } else {
            this.mItemsBackgroundColors.add(i10, Integer.valueOf(i11));
        }
        postInvalidate();
    }

    public void addItem(int i10, COUISlideMenuItem cOUISlideMenuItem) {
        if (this.mPaint != null) {
            int measureText = cOUISlideMenuItem.getText() != null ? ((int) this.mPaint.measureText((String) cOUISlideMenuItem.getText())) + (this.mTextPadding * 2) : 0;
            if (measureText > cOUISlideMenuItem.getWidth()) {
                cOUISlideMenuItem.setWidth(measureText);
            }
        }
        if (i10 < 0) {
            this.mItems.add(cOUISlideMenuItem);
        } else {
            this.mItems.add(i10, cOUISlideMenuItem);
        }
        itemWidthChange();
        postInvalidate();
    }

    public void setDiver(Drawable drawable) {
        if (drawable != null) {
            this.mDiverEnable = true;
        } else {
            this.mDiverEnable = false;
        }
        if (this.mDiver != drawable) {
            this.mDiver = drawable;
            invalidate();
        }
    }

    public void startAppearAnimation(boolean z10) {
        if (this.mIsMenuRoundStyle && this.mCurrStatus == 0) {
            cancelBackgroundAnimators();
            if (z10) {
                this.mCurColor = COUIContextUtil.getAttrColor(getContext(), X8.c.f4346E);
                this.mState = 1;
                invalidate();
                return;
            }
            this.mBackgroundAppearAnimator.start();
        }
    }

    public void startDisAppearAnimationOrNot(boolean z10) {
        if (this.mIsMenuRoundStyle) {
            if (z10) {
                cancelBackgroundAnimators();
                int attrColor = COUIContextUtil.getAttrColor(getContext(), X8.c.f4346E);
                this.mCurColor = Color.argb(0, Color.red(attrColor), Color.green(attrColor), Color.blue(attrColor));
                this.mState = 2;
                invalidate();
                return;
            }
            if (this.mBackgroundAppearAnimator.isRunning()) {
                this.mNeedAutoStartDisAppear = true;
            } else {
                if (this.mBackgroundDisappearAnimator.isRunning() || this.mState != 1) {
                    return;
                }
                this.mBackgroundDisappearAnimator.start();
            }
        }
    }

    public COUISlideView(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public void setDeleteItemIcon(Drawable drawable) {
        if (this.mCanDelete) {
            this.mItems.get(0).setIcon(drawable);
        }
    }

    public COUISlideView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.mHolderWidth = 0;
        this.mFastDelHolderWidth = 0;
        this.mCanDelete = false;
        this.mCanCopy = true;
        this.mCanRename = false;
        this.mSlideEnable = true;
        this.mDrawItemEnable = false;
        this.mDiverEnable = false;
        this.mIconCount = 0;
        this.mItemCount = 0;
        this.mAlpha = 0;
        this.mTextPadding = 0;
        this.mLayout = null;
        this.mLastX = 0;
        this.mLastY = 0;
        this.mSlideTouchSlop = 8;
        this.mVelocityTracker = null;
        this.mActivePointerId = -1;
        this.mScrollAll = false;
        this.mIsUnableToDrag = false;
        this.mIsBeingDragged = false;
        this.mhasStartAnimation = false;
        this.mStartDeleteAnimation = true;
        this.mCurrStatus = 0;
        this.mGroupStyle = -1;
        this.mPaddingRight = 18;
        this.mRadius = 20;
        this.mUseDefaultBackGround = true;
        this.mMenuDividerEnable = true;
        this.mRoundRectMenuItemRadius = COUIContextUtil.getAttrDimens(getContext(), X8.c.f4373c0);
        this.mRoundRectMenuItemGap = getResources().getDimensionPixelSize(C0535e.f12378J);
        this.mRoundRectMenuLeftMargin = getResources().getDimensionPixelSize(C0535e.f12379K);
        this.mRoundRectMenuRightMargin = getResources().getDimensionPixelSize(C0535e.f12377I);
        this.mBackGroundPaint = new Paint();
        this.mPath = new Path();
        this.mIsMenuRoundStyle = false;
        this.mAppearInterpolator = new COUILinearInterpolator();
        this.mNeedAutoStartDisAppear = false;
        this.mState = 2;
        this.mCurColor = 0;
        this.mDisappearInterpolator = new PathInterpolator(0.17f, 0.17f, 0.67f, 1.0f);
        this.mTouchAllRound = false;
        this.mBackgroundPadding = this.mRoundRectMenuItemRadius;
        this.mDisableBackgroundAnimator = false;
        if (attributeSet != null) {
            this.mRefreshStyle = attributeSet.getStyleAttribute();
        }
        if (this.mRefreshStyle == 0) {
            this.mRefreshStyle = i10;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.f12589V0, i10, 0);
        this.mItemBackgroundColor = obtainStyledAttributes.getColor(l.f12595Y0, COUIContextUtil.getAttrColor(context, X8.c.f4402r));
        this.mSlideTextColor = obtainStyledAttributes.getColor(l.f12597Z0, h.d(context.getResources(), C0534d.f12366d, context.getTheme()));
        this.mTouchAllRound = obtainStyledAttributes.getBoolean(l.f12600a1, false);
        this.mBackgroundPadding = obtainStyledAttributes.getDimensionPixelOffset(l.f12591W0, this.mRoundRectMenuItemRadius);
        this.mDisableBackgroundAnimator = obtainStyledAttributes.getBoolean(l.f12593X0, false);
        obtainStyledAttributes.recycle();
        ArrayList arrayList = new ArrayList();
        this.mItemsBackgroundColors = arrayList;
        arrayList.add(Integer.valueOf(this.mItemBackgroundColor));
        initView();
    }

    public void startDeleteAnimation(View view, float f10, float f11, float f12, float f13) {
        if (this.mhasStartAnimation) {
            return;
        }
        this.mhasStartAnimation = true;
        COUIDeleteAnimation cOUIDeleteAnimation = new COUIDeleteAnimation(view, f10, f11, f12, f13) { // from class: com.coui.appcompat.slideview.COUISlideView.9
            @Override // com.coui.appcompat.slideview.COUIDeleteAnimation, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (COUISlideView.this.mOnDeleteItemClickListener != null) {
                    COUISlideView cOUISlideView = COUISlideView.this;
                    cOUISlideView.mInitialHeight = cOUISlideView.getMeasuredHeight();
                    COUISlideView.this.mFadeAnim.setDuration(200L);
                    COUISlideView.this.mFadeAnim.start();
                    COUISlideView.this.startAnimation(new COUISlideCollapseAnimation(COUISlideView.this) { // from class: com.coui.appcompat.slideview.COUISlideView.9.1
                        @Override // com.coui.appcompat.slideview.COUISlideCollapseAnimation
                        public void onItemDelete() {
                            COUISlideView.this.mhasStartAnimation = false;
                            COUISlideView.this.mOnDeleteItemClickListener.onDeleteItemClick();
                        }
                    });
                }
            }
        };
        cOUIDeleteAnimation.setDuration(200L);
        cOUIDeleteAnimation.start();
    }

    public void setDeleteItemText(int i10) {
        setDeleteItemText(this.mContext.getText(i10));
    }
}
