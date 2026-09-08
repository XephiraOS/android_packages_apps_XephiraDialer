package androidx.recyclerview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import androidx.core.view.C0464t;
import androidx.core.view.K;
import androidx.recyclerview.widget.RecyclerView;
import com.coui.appcompat.animation.COUIPhysicalAnimationUtil;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.coui.appcompat.hapticfeedback.COUIHapticFeedbackConstants;
import com.coui.appcompat.log.COUILog;
import com.coui.appcompat.scroll.COUIFlingLocateHelper;
import com.coui.appcompat.scroll.COUIIOverScroller;
import com.coui.appcompat.scroll.COUILocateOverScroller;
import com.coui.appcompat.scroll.SpringOverScroller;
import com.coui.appcompat.scrollbar.COUIScrollBar;
import com.coui.appcompat.uiutil.UIUtil;
import com.coui.appcompat.view.ViewNative;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class COUIRecyclerView extends RecyclerView implements COUIScrollBar.COUIScrollable {
    public static final int CENTER_ALIGN = 2;
    private static final boolean COUI_DEBUG;
    private static final int CUSTOM_TOUCH_SLOP = 2;
    private static final int DEBUG_PAINT_TEXT_OFFSET_Y = 50;
    private static final int DEBUG_PAINT_TEXT_SIZE = 30;
    private static final float DEFAULT_INTERACTING_NESTED_SCROLL_ANGLE = 20.0f;
    private static final int DEFAULT_INTERACTING_NESTED_SCROLL_VELOCITY_THRESHOLD = 2500;
    private static final double DEGREE_TO_ARC_CONSTANT = 0.017453292519943295d;
    private static final int FLING_SCROLL_THRESHOLD = 1000;
    private static final int FLING_SCROLL_THRESHOLD_WHILE_OVER_SCROLLING = 6000;
    private static final float HORIZONTAL_SPRING_BACK_TENSION_MULTIPLE = 3.2f;
    private static final int INVALID_POINTER = -1;
    private static final int OVER_SCROLL_TOUCH_DURATION_THRESHOLD;
    private static final int OVER_SCROLL_TOUCH_OFFSET_THRESHOLD = 10;
    private static final int SLOW_SCROLL_THRESHOLD = 2500;
    public static final int START_ALIGN = 1;
    static final String TAG = "COUIRecyclerView";
    private static final float VERTICAL_SPRING_BACK_TENSION_MULTIPLE = 2.15f;
    final int FLING;
    final int OVER_FLING;
    final int OVER_SCROLLING;
    private final int SCROLLBARS_NONE;
    private final int SCROLLBARS_VERTICAL;
    final int SCROLLING;
    private float mAbortVelocityX;
    private float mAbortVelocityY;
    private boolean mAvoidAccidentalTouch;
    private COUILocateOverScroller mCOUILocateOverScroller;
    private f mCOUIRecyclerDividerManager;
    private COUIScrollBar mCOUIScrollBar;
    private float mClickVelocityX;
    private float mClickVelocityY;
    private float mDebugAbortVelocityX;
    private float mDebugAbortVelocityY;
    private Paint mDebugPaint;
    private int mDispatchEventVelocityThreshold;
    private boolean mEnableDispatchEventWhileOverScrolling;
    private boolean mEnableDispatchEventWhileScrolling;
    private boolean mEnableFlingSpeedIncrease;
    private boolean mEnableOptimizedScroll;
    private boolean mEnablePointerDown;
    private boolean mEnableVibrator;
    private float mEventFilterAngle;
    private float mFastFlingVelocity;
    private boolean mFixScrollTypeForOverScrolling;
    private float mFlingRatio;
    private float mFlingVelocityX;
    private float mFlingVelocityY;
    private boolean mIgnoreMotionEventTillDown;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private RecyclerView.r mInterceptingOnItemTouchListener;
    private boolean mIsOverScrollingReverseFling;
    private boolean mIsTouchDownWhileOverScrolling;
    private boolean mIsTouchDownWhileSlowScrolling;
    private boolean mIsUseNativeOverScroll;
    private boolean mItemClickableWhileOverScrolling;
    private boolean mItemClickableWhileSlowScrolling;
    private int mLastTouchX;
    private int mLastTouchY;
    private COUIFlingLocateHelper mLocateHelper;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private final int[] mNestedOffsets;
    private RecyclerView.q mOnFlingListener;
    private ArrayList<RecyclerView.r> mOnItemTouchListeners;
    boolean mOverScrollEnable;
    private COUIIOverScroller mOverScroller;
    private int mOverflingDistance;
    private int mOverscrollDistance;
    private int mScreenHeight;
    private int mScreenWidth;
    private final int[] mScrollOffset;
    private int mScrollPointerId;
    private int mScrollState;
    private int mScrollType;
    private Drawable mScrollbarThumbVertical;
    private int mScrollbars;
    private int mScrollbarsSize;
    private int mSlowScrollThreshold;
    private boolean mSmoothScrollFlag;
    private SpringOverScroller mSpringOverScroller;
    private int mStyle;
    private int mTouchSlop;
    private long mTouchTime;
    private VelocityTracker mVelocityTracker;
    private float mVerticalSpringOverTension;
    private c mViewFlinger;

    /* loaded from: classes.dex */
    public static class a extends RecyclerView.n {
        private Drawable mDivider;
        private int mDividerColor;
        private int mDividerStrokeWidth;
        private int mOriginAlpha;
        private Paint mPaint;
        private int mPressDividerAlpha;
        private int mPressDividerPos;

        public a(Context context) {
            init(context);
        }

        private void init(Context context) {
            this.mDividerColor = COUIContextUtil.getAttrColor(context, X8.c.f4400q);
            this.mDividerStrokeWidth = context.getResources().getDimensionPixelOffset(X8.f.f4766p2);
            Paint paint = new Paint(1);
            this.mPaint = paint;
            paint.setColor(this.mDividerColor);
            int alpha = this.mPaint.getAlpha();
            this.mOriginAlpha = alpha;
            this.mPressDividerAlpha = alpha;
        }

        public void drawExpandableDivider(Canvas canvas, RecyclerView.B b10) {
            boolean z10;
            int dividerInsetStart;
            int dividerInsetEnd;
            View view = b10.itemView;
            if (view.getLayoutDirection() == 1) {
                z10 = true;
            } else {
                z10 = false;
            }
            int measuredHeight = view.getMeasuredHeight() - Math.max(1, this.mDividerStrokeWidth);
            int measuredHeight2 = view.getMeasuredHeight();
            float x10 = view.getX();
            if (z10) {
                dividerInsetStart = getDividerInsetEnd(b10);
            } else {
                dividerInsetStart = getDividerInsetStart(b10);
            }
            int i10 = (int) (x10 + dividerInsetStart);
            float x11 = view.getX() + view.getWidth();
            if (z10) {
                dividerInsetEnd = getDividerInsetStart(b10);
            } else {
                dividerInsetEnd = getDividerInsetEnd(b10);
            }
            int i11 = (int) (x11 - dividerInsetEnd);
            Drawable drawable = this.mDivider;
            if (drawable == null) {
                canvas.drawRect(i10, measuredHeight, i11, measuredHeight2, this.mPaint);
            } else {
                drawable.setBounds(i10, measuredHeight, i11, measuredHeight2);
                this.mDivider.draw(canvas);
            }
        }

        public Drawable getDivider() {
            return this.mDivider;
        }

        public int getDividerColor() {
            return this.mDividerColor;
        }

        public int getDividerInsetEnd(RecyclerView.B b10) {
            return 0;
        }

        public int getDividerInsetStart(RecyclerView.B b10) {
            return 0;
        }

        public int getDividerStrokeWidth() {
            return this.mDividerStrokeWidth;
        }

        public Paint getPaint() {
            return this.mPaint;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.n
        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.y yVar) {
            boolean z10;
            int dividerInsetStart;
            int dividerInsetEnd;
            int i10;
            int childCount = recyclerView.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = recyclerView.getChildAt(i11);
                if (shouldDrawDivider(recyclerView, i11)) {
                    drawDividerOuterBackground(canvas, recyclerView, childAt);
                    if (childAt.getLayoutDirection() == 1) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    int y10 = (int) (childAt.getY() + childAt.getHeight());
                    int max = Math.max(1, this.mDividerStrokeWidth) + y10;
                    float x10 = childAt.getX();
                    if (z10) {
                        dividerInsetStart = getDividerInsetEnd(recyclerView, i11);
                    } else {
                        dividerInsetStart = getDividerInsetStart(recyclerView, i11);
                    }
                    int i12 = (int) (x10 + dividerInsetStart);
                    float x11 = childAt.getX() + childAt.getWidth();
                    if (z10) {
                        dividerInsetEnd = getDividerInsetStart(recyclerView, i11);
                    } else {
                        dividerInsetEnd = getDividerInsetEnd(recyclerView, i11);
                    }
                    int i13 = (int) (x11 - dividerInsetEnd);
                    int i14 = this.mPressDividerPos;
                    if (i14 != i11 && i14 - 1 != i11) {
                        i10 = this.mOriginAlpha;
                    } else {
                        i10 = this.mPressDividerAlpha;
                    }
                    Drawable drawable = this.mDivider;
                    if (drawable == null) {
                        this.mPaint.setAlpha(i10);
                        canvas.drawRect(i12, y10, i13, max, this.mPaint);
                    } else {
                        drawable.setAlpha(i10);
                        this.mDivider.setBounds(i12, y10, i13, max);
                        this.mDivider.draw(canvas);
                    }
                }
            }
        }

        public void setDivider(RecyclerView recyclerView, Drawable drawable) {
            this.mDivider = drawable;
            if (recyclerView != null) {
                recyclerView.invalidateItemDecorations();
            }
        }

        public void setDividerColor(RecyclerView recyclerView, int i10) {
            this.mDividerColor = i10;
            this.mPaint.setColor(i10);
            if (recyclerView != null) {
                recyclerView.invalidateItemDecorations();
            }
        }

        public void setDividerStrokeWidth(RecyclerView recyclerView, int i10) {
            this.mDividerStrokeWidth = i10;
            this.mPaint.setStrokeWidth(i10);
            if (recyclerView != null) {
                recyclerView.invalidateItemDecorations();
            }
        }

        public void setPressDividerAlpha(int i10) {
            this.mPressDividerAlpha = i10;
        }

        public void setPressDividerPos(int i10) {
            this.mPressDividerPos = i10;
        }

        public boolean shouldDrawDivider(RecyclerView recyclerView, int i10) {
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            if (adapter == null || adapter.getItemCount() - 1 != i10) {
                return true;
            }
            return false;
        }

        public int getDividerInsetEnd(RecyclerView recyclerView, int i10) {
            return 0;
        }

        public int getDividerInsetStart(RecyclerView recyclerView, int i10) {
            return 0;
        }

        public void drawDividerOuterBackground(Canvas canvas, RecyclerView recyclerView, View view) {
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        default boolean drawDivider() {
            return false;
        }

        default View getDividerEndAlignView() {
            return null;
        }

        default int getDividerEndInset() {
            return 0;
        }

        default View getDividerStartAlignView() {
            return null;
        }

        default int getDividerStartInset() {
            return 0;
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public int f10823a;

        /* renamed from: b, reason: collision with root package name */
        public int f10824b;

        /* renamed from: c, reason: collision with root package name */
        public Interpolator f10825c = RecyclerView.sQuinticInterpolator;

        /* renamed from: d, reason: collision with root package name */
        public boolean f10826d = false;

        /* renamed from: e, reason: collision with root package name */
        public boolean f10827e = false;

        public c() {
        }

        public final int a(int i10, int i11, int i12, int i13) {
            boolean z10;
            int height;
            int i14;
            int abs = Math.abs(i10);
            int abs2 = Math.abs(i11);
            if (abs > abs2) {
                z10 = true;
            } else {
                z10 = false;
            }
            int sqrt = (int) Math.sqrt((i12 * i12) + (i13 * i13));
            int sqrt2 = (int) Math.sqrt((i10 * i10) + (i11 * i11));
            COUIRecyclerView cOUIRecyclerView = COUIRecyclerView.this;
            if (z10) {
                height = cOUIRecyclerView.getWidth();
            } else {
                height = cOUIRecyclerView.getHeight();
            }
            int i15 = height / 2;
            float f10 = height;
            float f11 = i15;
            float b10 = f11 + (b(Math.min(1.0f, (sqrt2 * 1.0f) / f10)) * f11);
            if (sqrt > 0) {
                i14 = Math.round(Math.abs(b10 / sqrt) * 1000.0f) * 4;
            } else {
                if (!z10) {
                    abs = abs2;
                }
                i14 = (int) (((abs / f10) + 1.0f) * 300.0f);
            }
            return Math.min(i14, 2000);
        }

        public final float b(float f10) {
            return (float) Math.sin((f10 - 0.5f) * 0.47123894f);
        }

        public void c(int i10, int i11) {
            COUIRecyclerView.this.mFlingVelocityX = i10;
            COUIRecyclerView.this.mFlingVelocityY = i11;
            COUIRecyclerView.this.setScrollState(2);
            this.f10824b = 0;
            this.f10823a = 0;
            Interpolator interpolator = this.f10825c;
            Interpolator interpolator2 = RecyclerView.sQuinticInterpolator;
            if (interpolator != interpolator2) {
                this.f10825c = interpolator2;
                if (COUIRecyclerView.this.mOverScroller != null) {
                    COUIRecyclerView.this.mOverScroller.setInterpolator(interpolator2);
                }
            }
            if (COUIRecyclerView.this.mOverScroller != null) {
                COUIRecyclerView.this.mOverScroller.fling(0, 0, i10, i11, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
                COUIRecyclerView.this.mOverScroller.setFinalX(COUIRecyclerView.this.mLocateHelper.getTargetViewDistance(COUIRecyclerView.this.mOverScroller.getCOUIFinalX()));
            }
            e();
        }

        public final void d() {
            COUIRecyclerView.this.removeCallbacks(this);
            K.a0(COUIRecyclerView.this, this);
        }

        public void e() {
            if (this.f10826d) {
                this.f10827e = true;
            } else {
                d();
            }
        }

        public void f(int i10, int i11, int i12, Interpolator interpolator) {
            if (i12 == Integer.MIN_VALUE) {
                i12 = a(i10, i11, 0, 0);
            }
            int i13 = i12;
            if (interpolator == null) {
                interpolator = RecyclerView.sQuinticInterpolator;
            }
            if (this.f10825c != interpolator) {
                this.f10825c = interpolator;
                if (COUIRecyclerView.this.mOverScroller != null) {
                    COUIRecyclerView.this.mOverScroller.setInterpolator(interpolator);
                }
            }
            this.f10824b = 0;
            this.f10823a = 0;
            COUIRecyclerView.this.setScrollState(2);
            if (COUIRecyclerView.this.mOverScroller != null) {
                COUIRecyclerView.this.mOverScroller.startScroll(0, 0, i10, i11, i13);
            }
            e();
        }

        public void g() {
            float f10;
            COUIRecyclerView.this.removeCallbacks(this);
            COUIRecyclerView cOUIRecyclerView = COUIRecyclerView.this;
            cOUIRecyclerView.initOverScroller(cOUIRecyclerView.getContext());
            COUIRecyclerView cOUIRecyclerView2 = COUIRecyclerView.this;
            float f11 = 0.0f;
            if (cOUIRecyclerView2.mOverScroller != null && COUIRecyclerView.this.mOverScroller.getCurrVelocityX() != 0.0f) {
                f10 = COUIRecyclerView.this.mFlingVelocityX;
            } else {
                f10 = 0.0f;
            }
            cOUIRecyclerView2.mAbortVelocityX = f10;
            COUIRecyclerView cOUIRecyclerView3 = COUIRecyclerView.this;
            if (cOUIRecyclerView3.mOverScroller != null && COUIRecyclerView.this.mOverScroller.getCurrVelocityY() != 0.0f) {
                f11 = COUIRecyclerView.this.mFlingVelocityY;
            }
            cOUIRecyclerView3.mAbortVelocityY = f11;
            if (COUIRecyclerView.this.mOverScroller != null) {
                COUIRecyclerView.this.mOverScroller.abortAnimation();
            }
            if (COUIRecyclerView.this.mSpringOverScroller != null) {
                COUIRecyclerView.this.mSpringOverScroller.abortAnimation();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            int i10;
            int i11;
            int i12;
            boolean z10;
            boolean z11;
            boolean z12;
            COUIRecyclerView cOUIRecyclerView = COUIRecyclerView.this;
            if (cOUIRecyclerView.mLayout == null) {
                g();
                return;
            }
            this.f10827e = false;
            this.f10826d = true;
            cOUIRecyclerView.consumePendingUpdateOperations();
            COUIIOverScroller cOUIIOverScroller = COUIRecyclerView.this.mOverScroller;
            if (cOUIIOverScroller != null && cOUIIOverScroller.computeScrollOffset()) {
                int cOUICurrX = cOUIIOverScroller.getCOUICurrX();
                int cOUICurrY = cOUIIOverScroller.getCOUICurrY();
                int i13 = cOUICurrX - this.f10823a;
                int i14 = cOUICurrY - this.f10824b;
                this.f10823a = cOUICurrX;
                this.f10824b = cOUICurrY;
                COUIRecyclerView cOUIRecyclerView2 = COUIRecyclerView.this;
                int[] iArr = cOUIRecyclerView2.mReusableIntPair;
                iArr[0] = 0;
                iArr[1] = 0;
                if (cOUIRecyclerView2.dispatchNestedPreScroll(i13, i14, iArr, null, 1)) {
                    int[] iArr2 = COUIRecyclerView.this.mReusableIntPair;
                    i13 -= iArr2[0];
                    i14 -= iArr2[1];
                }
                COUIRecyclerView cOUIRecyclerView3 = COUIRecyclerView.this;
                if (cOUIRecyclerView3.mAdapter != null) {
                    int[] iArr3 = cOUIRecyclerView3.mReusableIntPair;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    cOUIRecyclerView3.scrollStep(i13, i14, iArr3);
                    COUIRecyclerView cOUIRecyclerView4 = COUIRecyclerView.this;
                    int[] iArr4 = cOUIRecyclerView4.mReusableIntPair;
                    i11 = iArr4[0];
                    i10 = iArr4[1];
                    i13 -= i11;
                    i14 -= i10;
                    RecyclerView.x xVar = cOUIRecyclerView4.mLayout.mSmoothScroller;
                    if (xVar != null && !xVar.isPendingInitialRun() && xVar.isRunning()) {
                        int b10 = COUIRecyclerView.this.mState.b();
                        if (b10 == 0) {
                            xVar.stop();
                        } else if (xVar.getTargetPosition() >= b10) {
                            xVar.setTargetPosition(b10 - 1);
                            xVar.onAnimation(i11, i10);
                        } else {
                            xVar.onAnimation(i11, i10);
                        }
                    }
                } else {
                    i10 = 0;
                    i11 = 0;
                }
                if (!COUIRecyclerView.this.mItemDecorations.isEmpty()) {
                    COUIRecyclerView.this.invalidate();
                }
                COUIRecyclerView cOUIRecyclerView5 = COUIRecyclerView.this;
                int[] iArr5 = cOUIRecyclerView5.mReusableIntPair;
                iArr5[0] = 0;
                iArr5[1] = 0;
                cOUIRecyclerView5.dispatchNestedScroll(i11, i10, i13, i14, null, 1, iArr5);
                COUIRecyclerView cOUIRecyclerView6 = COUIRecyclerView.this;
                int[] iArr6 = cOUIRecyclerView6.mReusableIntPair;
                int i15 = i13 - iArr6[0];
                int i16 = i14 - iArr6[1];
                if (i11 != 0 || i10 != 0) {
                    cOUIRecyclerView6.dispatchOnScrolled(i11, i10);
                }
                if (COUIRecyclerView.this.mSmoothScrollFlag && (i15 != 0 || i16 != 0)) {
                    cOUIIOverScroller.abortAnimation();
                    COUIRecyclerView.this.mSmoothScrollFlag = false;
                    i12 = 0;
                    i15 = 0;
                } else {
                    i12 = i16;
                }
                if (i12 != 0) {
                    COUIRecyclerView cOUIRecyclerView7 = COUIRecyclerView.this;
                    if (cOUIRecyclerView7.mOverScrollEnable) {
                        cOUIRecyclerView7.mScrollType = 3;
                        COUIRecyclerView.this.performFeedback();
                        COUIRecyclerView cOUIRecyclerView8 = COUIRecyclerView.this;
                        cOUIRecyclerView8.overScrollBy(0, i12, 0, cOUIRecyclerView8.getScrollY(), 0, 0, 0, COUIRecyclerView.this.mOverflingDistance, false);
                        if (COUIRecyclerView.this.mIsUseNativeOverScroll) {
                            if (COUIRecyclerView.this.mSpringOverScroller != null) {
                                COUIRecyclerView.this.mSpringOverScroller.setCurrVelocityY(cOUIIOverScroller.getCurrVelocityY());
                                COUIRecyclerView.this.mSpringOverScroller.notifyVerticalEdgeReached(i12, 0, COUIRecyclerView.this.mOverflingDistance);
                            }
                        } else if (COUIRecyclerView.this.mOverScroller != null) {
                            COUIRecyclerView.this.mOverScroller.notifyVerticalEdgeReached(i12, 0, COUIRecyclerView.this.mOverflingDistance);
                        }
                    }
                }
                if (i15 != 0) {
                    COUIRecyclerView cOUIRecyclerView9 = COUIRecyclerView.this;
                    if (cOUIRecyclerView9.mOverScrollEnable) {
                        cOUIRecyclerView9.mScrollType = 3;
                        COUIRecyclerView.this.performFeedback();
                        COUIRecyclerView cOUIRecyclerView10 = COUIRecyclerView.this;
                        cOUIRecyclerView10.overScrollBy(i15, 0, cOUIRecyclerView10.getScrollX(), 0, 0, 0, COUIRecyclerView.this.mOverflingDistance, 0, false);
                        if (COUIRecyclerView.this.mIsUseNativeOverScroll) {
                            if (COUIRecyclerView.this.mSpringOverScroller != null) {
                                COUIRecyclerView.this.mSpringOverScroller.setCurrVelocityX(cOUIIOverScroller.getCurrVelocityX());
                                COUIRecyclerView.this.mSpringOverScroller.notifyHorizontalEdgeReached(i15, 0, COUIRecyclerView.this.mOverflingDistance);
                            }
                        } else if (COUIRecyclerView.this.mOverScroller != null) {
                            COUIRecyclerView.this.mOverScroller.notifyHorizontalEdgeReached(i15, 0, COUIRecyclerView.this.mOverflingDistance);
                        }
                    }
                }
                if (!COUIRecyclerView.this.awakenScrollBars()) {
                    COUIRecyclerView.this.invalidate();
                }
                if (cOUIIOverScroller.getCOUICurrX() == cOUIIOverScroller.getCOUIFinalX()) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (cOUIIOverScroller.getCOUICurrY() == cOUIIOverScroller.getCOUIFinalY()) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (!cOUIIOverScroller.isCOUIFinished() && ((!z10 && i15 == 0) || (!z11 && i12 == 0))) {
                    z12 = false;
                } else {
                    z12 = true;
                }
                RecyclerView.x xVar2 = COUIRecyclerView.this.mLayout.mSmoothScroller;
                if ((xVar2 == null || !xVar2.isPendingInitialRun()) && z12) {
                    if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                        COUIRecyclerView.this.mPrefetchRegistry.b();
                    }
                } else {
                    e();
                    COUIRecyclerView cOUIRecyclerView11 = COUIRecyclerView.this;
                    l lVar = cOUIRecyclerView11.mGapWorker;
                    if (lVar != null) {
                        lVar.f(cOUIRecyclerView11, i11, i10);
                    }
                }
            }
            RecyclerView.x xVar3 = COUIRecyclerView.this.mLayout.mSmoothScroller;
            if (xVar3 != null && xVar3.isPendingInitialRun()) {
                xVar3.onAnimation(0, 0);
            }
            this.f10826d = false;
            if (this.f10827e) {
                d();
            } else if (COUIRecyclerView.this.mScrollType != 3 || !COUIRecyclerView.this.mOverScrollEnable) {
                COUIRecyclerView.this.setScrollState(0);
                COUIRecyclerView.this.stopNestedScroll(1);
            }
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
        OVER_SCROLL_TOUCH_DURATION_THRESHOLD = ViewConfiguration.getLongPressTimeout();
    }

    public COUIRecyclerView(Context context) {
        this(context, null);
    }

    private void cancelScroll() {
        resetScroll();
        setScrollState(0);
        ViewNative.setScrollX(this, 0);
        ViewNative.setScrollY(this, 0);
    }

    private void changeStateAndVibrate(boolean z10) {
        if (!z10) {
            performFeedback();
        }
        if (this.mScrollState != 0) {
            this.mScrollState = 0;
            dispatchOnScrollStateChanged(0);
        }
    }

    private void createCOUIScrollDelegate(Context context) {
        this.mCOUIScrollBar = new COUIScrollBar.Builder(this).build();
    }

    private boolean dispatchClickEvent(View view, MotionEvent motionEvent) {
        boolean z10 = true;
        int[] iArr = {0, 1};
        for (int i10 = 0; i10 < 2; i10++) {
            motionEvent.setAction(iArr[i10]);
            z10 &= view.dispatchTouchEvent(motionEvent);
        }
        return z10;
    }

    private boolean dispatchToOnItemTouchListeners(MotionEvent motionEvent) {
        RecyclerView.r rVar = this.mInterceptingOnItemTouchListener;
        if (rVar == null) {
            if (motionEvent.getAction() == 0) {
                return false;
            }
            return findInterceptingOnItemTouchListener(motionEvent);
        }
        rVar.a(this, motionEvent);
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.mInterceptingOnItemTouchListener = null;
        }
        return true;
    }

    private boolean findInterceptingOnItemTouchListener(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.mOnItemTouchListeners.size();
        for (int i10 = 0; i10 < size; i10++) {
            RecyclerView.r rVar = this.mOnItemTouchListeners.get(i10);
            if (rVar.b(this, motionEvent) && action != 3) {
                this.mInterceptingOnItemTouchListener = rVar;
                return true;
            }
        }
        return false;
    }

    private View findViewToDispatchClickEvent(MotionEvent motionEvent) {
        ColorDrawable colorDrawable;
        if (!isClickEvent(motionEvent)) {
            return null;
        }
        Rect rect = new Rect();
        View view = null;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() == 0 || childAt.getAnimation() != null) {
                childAt.getHitRect(rect);
                boolean contains = rect.contains(((int) motionEvent.getX()) + getScrollX(), ((int) motionEvent.getY()) + getScrollY());
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.offsetLocation(getScrollX() - childAt.getLeft(), getScrollY() - childAt.getTop());
                if (contains && dispatchClickEvent(childAt, obtain)) {
                    view = childAt;
                }
                obtain.recycle();
                if (COUI_DEBUG) {
                    if (childAt == view) {
                        colorDrawable = new ColorDrawable(Color.parseColor("#80FF0000"));
                    } else {
                        colorDrawable = null;
                    }
                    childAt.setBackground(colorDrawable);
                }
            }
        }
        return view;
    }

    private String getFullClassName(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        }
        if (str.contains(".")) {
            return str;
        }
        return COUIRecyclerView.class.getPackage().getName() + '.' + str;
    }

    private float getVelocityAlongScrollableDirection() {
        COUIIOverScroller cOUIIOverScroller;
        COUIIOverScroller cOUIIOverScroller2;
        RecyclerView.o layoutManager = getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            if (layoutManager.canScrollHorizontally() && (cOUIIOverScroller2 = this.mOverScroller) != null) {
                return cOUIIOverScroller2.getCurrVelocityX();
            }
            if (layoutManager.canScrollVertically() && (cOUIIOverScroller = this.mOverScroller) != null) {
                return cOUIIOverScroller.getCurrVelocityY();
            }
            return 0.0f;
        }
        return 0.0f;
    }

    private boolean hookIfNeedInterceptMoveEvent(float f10, float f11) {
        if ((!this.mEnableDispatchEventWhileScrolling && (!this.mEnableDispatchEventWhileOverScrolling || !isOverScrolling())) || f10 == 0.0f || Math.abs(f11 / f10) > Math.tan(this.mEventFilterAngle * DEGREE_TO_ARC_CONSTANT)) {
            return true;
        }
        return false;
    }

    private void initAttr(Context context, AttributeSet attributeSet, int i10) {
        if (attributeSet != null && attributeSet.getStyleAttribute() != 0) {
            this.mStyle = attributeSet.getStyleAttribute();
        } else {
            this.mStyle = i10;
        }
        if (context != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, X8.o.f5338j4, i10, 0);
            this.mScrollbars = obtainStyledAttributes.getInteger(X8.o.f5370n4, 0);
            this.mScrollbarsSize = obtainStyledAttributes.getDimensionPixelSize(X8.o.f5354l4, 0);
            this.mScrollbarThumbVertical = obtainStyledAttributes.getDrawable(X8.o.f5362m4);
            this.mEnableVibrator = obtainStyledAttributes.getBoolean(X8.o.f5346k4, true);
            obtainStyledAttributes.recycle();
        }
    }

    private void initOnItemTouchListeners() {
        if (this.mOnItemTouchListeners == null) {
            this.mOnItemTouchListeners = new ArrayList<>();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initOverScroller(Context context) {
        if (this.mOverScroller == null) {
            this.mVerticalSpringOverTension = VERTICAL_SPRING_BACK_TENSION_MULTIPLE;
            this.mSpringOverScroller = new SpringOverScroller(context);
            this.mCOUILocateOverScroller = new COUILocateOverScroller(context);
            enableFrameRate(true);
            setIsUseNativeOverScroll(false);
            setEnableFlingSpeedIncrease(this.mEnableFlingSpeedIncrease);
        }
    }

    private void initProperty(Context context) {
        int i10 = context.getResources().getDisplayMetrics().heightPixels;
        this.mOverscrollDistance = i10;
        this.mOverflingDistance = i10;
    }

    private void initViewFlinger() {
        if (this.mViewFlinger == null) {
            this.mViewFlinger = new c();
        }
    }

    private boolean isClickEvent(MotionEvent motionEvent) {
        int x10 = (int) (motionEvent.getX() - this.mInitialTouchX);
        int y10 = (int) (motionEvent.getY() - this.mInitialTouchY);
        int sqrt = (int) Math.sqrt((x10 * x10) + (y10 * y10));
        long currentTimeMillis = System.currentTimeMillis() - this.mTouchTime;
        if (COUI_DEBUG) {
            Log.d(TAG, "onTouchEvent: ACTION_UP. touchDuration = " + currentTimeMillis + ", offset = " + sqrt);
        }
        if (currentTimeMillis < OVER_SCROLL_TOUCH_DURATION_THRESHOLD && sqrt < 10) {
            return true;
        }
        return false;
    }

    private boolean isFastFling(float f10, float f11) {
        if (this.mAvoidAccidentalTouch && Math.abs(f10) <= this.mFastFlingVelocity && Math.abs(f11) <= this.mFastFlingVelocity) {
            return false;
        }
        return true;
    }

    private boolean isOverScrolling() {
        int i10;
        if (this.mOverScrollEnable && (((i10 = this.mScrollType) == 2 || i10 == 3) && isOverScrollingInScrollableDirection())) {
            return true;
        }
        return false;
    }

    private boolean isOverScrollingInScrollableDirection() {
        RecyclerView.o oVar = this.mLayout;
        if (oVar == null) {
            return false;
        }
        if (oVar.canScrollVertically() && this.mLayout.canScrollHorizontally()) {
            if (getScrollY() == 0 || getScrollX() == 0) {
                return false;
            }
            return true;
        }
        if (this.mLayout.canScrollVertically()) {
            if (getScrollY() == 0) {
                return false;
            }
            return true;
        }
        if (!this.mLayout.canScrollHorizontally() || getScrollX() == 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onSizeChanged$0() {
        this.mLocateHelper.trySnapToTargetExistingView();
    }

    private boolean needLocate() {
        if (getLayoutManager() != null && (getLayoutManager() instanceof LinearLayoutManager) && ((LinearLayoutManager) getLayoutManager()).getOrientation() == 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x00f7, code lost:
    
        if (r0 != false) goto L58;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean onInterceptTouchEventInternal(android.view.MotionEvent r15) {
        /*
            Method dump skipped, instructions count: 549
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.COUIRecyclerView.onInterceptTouchEventInternal(android.view.MotionEvent):boolean");
    }

    private void onPointerUp(MotionEvent motionEvent) {
        int i10;
        int adjustmentPointerIndex = UIUtil.getAdjustmentPointerIndex(motionEvent, motionEvent.getActionIndex());
        if (motionEvent.getPointerId(adjustmentPointerIndex) == this.mScrollPointerId) {
            if (adjustmentPointerIndex == 0) {
                i10 = 1;
            } else {
                i10 = 0;
            }
            this.mScrollPointerId = motionEvent.getPointerId(i10);
            int x10 = (int) (motionEvent.getX(i10) + 0.5f);
            this.mLastTouchX = x10;
            this.mInitialTouchX = x10;
            int y10 = (int) (motionEvent.getY(i10) + 0.5f);
            this.mLastTouchY = y10;
            this.mInitialTouchY = y10;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performFeedback() {
        if (this.mEnableVibrator) {
            performHapticFeedback(COUIHapticFeedbackConstants.EDGE_LIST_VIBRATE);
        }
    }

    private void performOverScrollingReverseFling(float f10, float f11) {
        this.mIsOverScrollingReverseFling = true;
        SpringOverScroller springOverScroller = this.mSpringOverScroller;
        if (springOverScroller != null) {
            springOverScroller.fling(getScrollX(), getScrollY(), (int) f10, (int) f11);
        }
        changeStateAndVibrate(false);
    }

    private void performSpringBack(boolean z10) {
        SpringOverScroller springOverScroller = this.mSpringOverScroller;
        if (springOverScroller != null && springOverScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, 0)) {
            changeStateAndVibrate(z10);
        }
    }

    private void resetScroll() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        stopNestedScroll(0);
    }

    private void stopScrollersInternal() {
        initViewFlinger();
        this.mViewFlinger.g();
        RecyclerView.o oVar = this.mLayout;
        if (oVar != null) {
            oVar.stopSmoothScroller();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void addOnItemTouchListener(RecyclerView.r rVar) {
        initOnItemTouchListeners();
        this.mOnItemTouchListeners.add(rVar);
    }

    @Override // android.view.View
    public boolean awakenScrollBars() {
        COUIScrollBar cOUIScrollBar = this.mCOUIScrollBar;
        if (cOUIScrollBar != null) {
            return cOUIScrollBar.awakenScrollBars();
        }
        return super.awakenScrollBars();
    }

    public void cancelHorizontalItemAlign() {
        this.mLocateHelper.cancelHorizontalItemAlign();
    }

    @Override // android.view.View
    public void computeScroll() {
        SpringOverScroller springOverScroller;
        int i10;
        int i11;
        if (this.mIsOverScrollingReverseFling) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            if (scrollX == 0 && scrollY == 0) {
                overScrollBy(-scrollX, -scrollY, scrollX, scrollY, 0, 0, 0, 0, false);
                onScrollChanged(getScrollX(), getScrollY(), scrollX, scrollY);
                this.mIsOverScrollingReverseFling = false;
                SpringOverScroller springOverScroller2 = this.mSpringOverScroller;
                if (springOverScroller2 != null) {
                    i10 = (int) springOverScroller2.getCurrVelocityX();
                } else {
                    i10 = 0;
                }
                SpringOverScroller springOverScroller3 = this.mSpringOverScroller;
                if (springOverScroller3 != null) {
                    i11 = (int) springOverScroller3.getCurrVelocityY();
                } else {
                    i11 = 0;
                }
                SpringOverScroller springOverScroller4 = this.mSpringOverScroller;
                if (springOverScroller4 != null) {
                    springOverScroller4.abortAnimation();
                }
                setScrollState(0);
                fling(i10, i11);
                return;
            }
        }
        if (this.mOverScrollEnable) {
            int i12 = this.mScrollType;
            if ((i12 == 2 || i12 == 3) && (springOverScroller = this.mSpringOverScroller) != null && springOverScroller.computeScrollOffset()) {
                int scrollX2 = getScrollX();
                int scrollY2 = getScrollY();
                int cOUICurrX = springOverScroller.getCOUICurrX();
                int cOUICurrY = springOverScroller.getCOUICurrY();
                if (scrollX2 != cOUICurrX || scrollY2 != cOUICurrY) {
                    int i13 = this.mOverflingDistance;
                    overScrollBy(cOUICurrX - scrollX2, cOUICurrY - scrollY2, scrollX2, scrollY2, 0, 0, i13, i13, false);
                    onScrollChanged(getScrollX(), getScrollY(), scrollX2, scrollY2);
                }
                if (springOverScroller.isCOUIFinished()) {
                    setScrollState(0);
                } else {
                    setScrollState(2);
                }
                if (!awakenScrollBars()) {
                    postInvalidateOnAnimation();
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (COUI_DEBUG) {
            this.mDebugPaint.setTextSize(30.0f);
            this.mDebugPaint.setColor(-65536);
            canvas.drawText("isOverScrolling: " + isOverScrolling(), getWidth() / 2.0f, (getHeight() / 2.0f) - 50.0f, this.mDebugPaint);
            canvas.drawText("X: FlingVX: " + this.mFlingVelocityX + ", ClickVX: " + this.mClickVelocityX, getWidth() / 2.0f, getHeight() / 2.0f, this.mDebugPaint);
            canvas.drawText("Y: FlingVY: " + this.mFlingVelocityY + ", ClickVY: " + this.mClickVelocityY, getWidth() / 2.0f, (getHeight() / 2.0f) + 50.0f, this.mDebugPaint);
            canvas.drawText("AbortVX:" + this.mDebugAbortVelocityX + ", AbortVY:" + this.mDebugAbortVelocityY, getWidth() / 2.0f, (getHeight() / 2.0f) + 100.0f, this.mDebugPaint);
        }
        COUIScrollBar cOUIScrollBar = this.mCOUIScrollBar;
        if (cOUIScrollBar != null) {
            cOUIScrollBar.dispatchDrawOver(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        float f10;
        this.mCOUIRecyclerDividerManager.c(motionEvent);
        if (this.mEnableDispatchEventWhileScrolling || (this.mEnableDispatchEventWhileOverScrolling && isOverScrolling())) {
            float velocityAlongScrollableDirection = getVelocityAlongScrollableDirection();
            if (motionEvent.getActionMasked() == 0 && this.mDispatchEventVelocityThreshold >= Math.abs(velocityAlongScrollableDirection)) {
                COUIIOverScroller cOUIIOverScroller = this.mOverScroller;
                float f11 = 0.0f;
                if (cOUIIOverScroller != null && cOUIIOverScroller.getCurrVelocityX() != 0.0f) {
                    f10 = this.mFlingVelocityX;
                } else {
                    f10 = 0.0f;
                }
                this.mAbortVelocityX = f10;
                COUIIOverScroller cOUIIOverScroller2 = this.mOverScroller;
                if (cOUIIOverScroller2 != null && cOUIIOverScroller2.getCurrVelocityY() != 0.0f) {
                    f11 = this.mFlingVelocityY;
                }
                this.mAbortVelocityY = f11;
                COUIIOverScroller cOUIIOverScroller3 = this.mOverScroller;
                if (cOUIIOverScroller3 != null) {
                    cOUIIOverScroller3.abortAnimation();
                }
                stopScroll();
            }
            if (isOverScrolling() && (motionEvent.getActionMasked() == 1 || motionEvent.getActionMasked() == 3)) {
                performSpringBack(false);
                postInvalidateOnAnimation();
            }
        }
        if (motionEvent.getActionMasked() == 5 && !this.mEnablePointerDown) {
            getParent().requestDisallowInterceptTouchEvent(true);
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void enableFrameRate(boolean z10) {
        this.mSpringOverScroller.enableFrameRate(z10);
        this.mCOUILocateOverScroller.enableFrameRate(z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v5 */
    @Override // androidx.recyclerview.widget.RecyclerView
    public boolean fling(int i10, int i11) {
        boolean z10;
        RecyclerView.o oVar = this.mLayout;
        if (oVar == null) {
            Log.e(TAG, "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        }
        if (this.mLayoutSuppressed) {
            return false;
        }
        int canScrollHorizontally = oVar.canScrollHorizontally();
        boolean canScrollVertically = this.mLayout.canScrollVertically();
        if (canScrollHorizontally == 0 || Math.abs(i10) < this.mMinFlingVelocity) {
            i10 = 0;
        }
        if (!canScrollVertically || Math.abs(i11) < this.mMinFlingVelocity) {
            i11 = 0;
        }
        if (i10 == 0 && i11 == 0) {
            return false;
        }
        float f10 = i10;
        float f11 = i11;
        if (!dispatchNestedPreFling(f10, f11)) {
            this.mScrollType = 1;
            if (canScrollHorizontally == 0 && !canScrollVertically) {
                z10 = false;
            } else {
                z10 = true;
            }
            dispatchNestedFling(f10, f11, z10);
            RecyclerView.q qVar = this.mOnFlingListener;
            if (qVar != null && qVar.onFling(i10, i11)) {
                return true;
            }
            if (z10) {
                if (canScrollVertically) {
                    canScrollHorizontally = (canScrollHorizontally == true ? 1 : 0) | 2;
                }
                startNestedScroll(canScrollHorizontally, 1);
                int i12 = this.mMaxFlingVelocity;
                int max = Math.max(-i12, Math.min(i10, i12));
                int i13 = this.mMaxFlingVelocity;
                this.mViewFlinger.c(max, Math.max(-i13, Math.min(i11, i13)));
                return true;
            }
        }
        return false;
    }

    @Override // com.coui.appcompat.scrollbar.COUIScrollBar.COUIScrollable
    public COUIScrollBar getCOUIScrollDelegate() {
        return this.mCOUIScrollBar;
    }

    public int getHorizontalItemAlign() {
        return this.mLocateHelper.getHorizontalItemAlign();
    }

    public boolean getIsUseNativeOverScroll() {
        return this.mIsUseNativeOverScroll;
    }

    public COUIFlingLocateHelper getLocateHelper() {
        return this.mLocateHelper;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public int getMaxFlingVelocity() {
        return this.mMaxFlingVelocity;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }

    public COUILocateOverScroller getNativeOverScroller() {
        return this.mCOUILocateOverScroller;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public RecyclerView.q getOnFlingListener() {
        return this.mOnFlingListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public int getScrollState() {
        return this.mScrollState;
    }

    public c getViewFlinger() {
        return this.mViewFlinger;
    }

    public void invalidateParentIfNeeded() {
        if (isHardwareAccelerated() && (getParent() instanceof View)) {
            ((View) getParent()).invalidate();
        }
    }

    public boolean isEnableFlingSpeedIncrease() {
        SpringOverScroller springOverScroller = this.mSpringOverScroller;
        if (springOverScroller != null) {
            return springOverScroller.isEnableFlingSpeedIncrease();
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        cancelScroll();
        COUIScrollBar cOUIScrollBar = this.mCOUIScrollBar;
        if (cOUIScrollBar != null) {
            cOUIScrollBar.onAttachedToWindow();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SpringOverScroller springOverScroller = this.mSpringOverScroller;
        if (springOverScroller != null) {
            springOverScroller.cancelCallback();
        }
        COUIScrollBar cOUIScrollBar = this.mCOUIScrollBar;
        if (cOUIScrollBar != null) {
            cOUIScrollBar.release();
            this.mCOUIScrollBar = null;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean onInterceptTouchEventInternal = onInterceptTouchEventInternal(motionEvent);
        if (onInterceptTouchEventInternal) {
            this.mCOUIRecyclerDividerManager.j(motionEvent);
        }
        return onInterceptTouchEventInternal;
    }

    @Override // android.view.View
    public void onOverScrolled(int i10, int i11, boolean z10, boolean z11) {
        if (getScrollY() != i11 || getScrollX() != i10) {
            if (COUI_DEBUG) {
                Log.d(TAG, "onOverScrolled: scrollX: " + i10 + " scrollY: " + i11);
            }
            if (this.mScrollType == 3) {
                i10 = (int) (COUIPhysicalAnimationUtil.calcOverFlingDecelerateDist(0, i10, this.mScreenWidth) * this.mFlingRatio);
                i11 = (int) (COUIPhysicalAnimationUtil.calcOverFlingDecelerateDist(0, i11, this.mScreenHeight) * this.mFlingRatio);
            }
            onScrollChanged(i10, i11, getScrollX(), getScrollY());
            ViewNative.setScrollX(this, i10);
            ViewNative.setScrollY(this, i11);
            invalidateParentIfNeeded();
            awakenScrollBars();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        this.mScreenWidth = displayMetrics.widthPixels;
        this.mScreenHeight = displayMetrics.heightPixels;
        if (this.mLocateHelper != null) {
            post(new Runnable() { // from class: androidx.recyclerview.widget.g
                @Override // java.lang.Runnable
                public final void run() {
                    COUIRecyclerView.this.lambda$onSizeChanged$0();
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:142:0x0257, code lost:
    
        if (r5 == false) goto L190;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:130:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0152  */
    /* JADX WARN: Type inference failed for: r0v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v7 */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r15) {
        /*
            Method dump skipped, instructions count: 721
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.COUIRecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        if (i10 != 0) {
            cancelScroll();
            SpringOverScroller springOverScroller = this.mSpringOverScroller;
            if (springOverScroller != null) {
                springOverScroller.abortAnimation();
            }
        }
        COUIScrollBar cOUIScrollBar = this.mCOUIScrollBar;
        if (cOUIScrollBar != null) {
            cOUIScrollBar.onVisibilityChanged(view, i10);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        COUIScrollBar cOUIScrollBar = this.mCOUIScrollBar;
        if (cOUIScrollBar != null) {
            cOUIScrollBar.onWindowVisibilityChanged(i10);
        }
    }

    @Override // android.view.View
    public boolean overScrollBy(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, boolean z10) {
        int i18 = i10 + i12;
        int i19 = i11 + i13;
        if ((i12 < 0 && i18 > 0) || (i12 > 0 && i18 < 0)) {
            i18 = 0;
        }
        if ((i13 < 0 && i19 > 0) || (i13 > 0 && i19 < 0)) {
            i19 = 0;
        }
        onOverScrolled(i18, i19, false, false);
        return false;
    }

    public void refresh() {
        String resourceTypeName;
        TypedArray typedArray = null;
        if (this.mStyle == 0) {
            resourceTypeName = null;
        } else {
            resourceTypeName = getResources().getResourceTypeName(this.mStyle);
        }
        if (!TextUtils.isEmpty(resourceTypeName) && "style".equals(resourceTypeName)) {
            typedArray = getContext().obtainStyledAttributes(null, X8.o.f5338j4, 0, this.mStyle);
        }
        if (typedArray != null) {
            this.mScrollbarThumbVertical = typedArray.getDrawable(X8.o.f5362m4);
            typedArray.recycle();
        }
        if (this.mScrollbars == 512) {
            Drawable drawable = this.mScrollbarThumbVertical;
            if (drawable != null) {
                this.mCOUIScrollBar.setThumbDrawable(drawable);
            } else {
                this.mCOUIScrollBar.refreshScrollBarColor();
            }
        }
        invalidate();
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void removeOnItemTouchListener(RecyclerView.r rVar) {
        this.mOnItemTouchListeners.remove(rVar);
        if (this.mInterceptingOnItemTouchListener == rVar) {
            this.mInterceptingOnItemTouchListener = null;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z10) {
        int size = this.mOnItemTouchListeners.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.mOnItemTouchListeners.get(i10).c(z10);
        }
        super.requestDisallowInterceptTouchEvent(z10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void scrollBy(int i10, int i11) {
        RecyclerView.o oVar = this.mLayout;
        if (oVar == null) {
            Log.e(TAG, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.mLayoutSuppressed) {
            return;
        }
        boolean canScrollHorizontally = oVar.canScrollHorizontally();
        boolean canScrollVertically = this.mLayout.canScrollVertically();
        if (canScrollHorizontally || canScrollVertically) {
            if (!canScrollHorizontally) {
                i10 = 0;
            }
            if (!canScrollVertically) {
                i11 = 0;
            }
            scrollByInternal(i10, i11, null);
        }
    }

    public boolean scrollByInternal(int i10, int i11, MotionEvent motionEvent) {
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        consumePendingUpdateOperations();
        if (this.mAdapter != null && (i10 != 0 || i11 != 0)) {
            if (this.mOverScrollEnable && ((getScrollY() < 0 && i11 > 0) || ((getScrollY() > 0 && i11 < 0) || ((getScrollX() < 0 && i10 > 0) || (getScrollX() > 0 && i10 < 0))))) {
                i17 = 0;
                i16 = 0;
                i18 = 0;
                i19 = 0;
            } else {
                int[] iArr = this.mReusableIntPair;
                iArr[0] = 0;
                iArr[1] = 0;
                scrollStep(i10, i11, iArr);
                int[] iArr2 = this.mReusableIntPair;
                i16 = iArr2[0];
                i17 = iArr2[1];
                i18 = i10 - i16;
                i19 = i11 - i17;
            }
            if (COUI_DEBUG) {
                Log.d(TAG, "scrollByInternal: y: " + i11 + " consumedY: " + i17 + " unconsumedY: " + i19);
            }
            i12 = i17;
            i13 = i16;
            i14 = i18;
            i15 = i19;
        } else {
            i12 = 0;
            i13 = 0;
            i14 = 0;
            i15 = 0;
        }
        if (!this.mItemDecorations.isEmpty()) {
            invalidate();
        }
        int[] iArr3 = this.mReusableIntPair;
        iArr3[0] = 0;
        iArr3[1] = 0;
        dispatchNestedScroll(i13, i12, i14, i15, this.mScrollOffset, 0, iArr3);
        int[] iArr4 = this.mReusableIntPair;
        int i20 = i14 - iArr4[0];
        int i21 = i15 - iArr4[1];
        int i22 = this.mLastTouchX;
        int[] iArr5 = this.mScrollOffset;
        int i23 = iArr5[0];
        this.mLastTouchX = i22 - i23;
        int i24 = this.mLastTouchY;
        int i25 = iArr5[1];
        this.mLastTouchY = i24 - i25;
        if (motionEvent != null) {
            motionEvent.offsetLocation(i23, i25);
        }
        int[] iArr6 = this.mNestedOffsets;
        int i26 = iArr6[0];
        int[] iArr7 = this.mScrollOffset;
        iArr6[0] = i26 + iArr7[0];
        iArr6[1] = iArr6[1] + iArr7[1];
        if (getOverScrollMode() != 2 && motionEvent != null && this.mOverScrollEnable && (C0464t.b(motionEvent, 4098) || C0464t.b(motionEvent, 8194))) {
            if (i21 != 0 || i20 != 0) {
                this.mScrollType = 2;
            }
            if (Math.abs(i21) == 0 && Math.abs(i12) < 2 && Math.abs(i11) < 2 && Math.abs(getScrollY()) > 2) {
                this.mScrollType = 2;
            }
            if (i21 == 0 && i12 == 0 && Math.abs(i11) > 2) {
                this.mScrollType = 2;
            }
            if (Math.abs(i20) == 0 && Math.abs(i13) < 2 && Math.abs(i10) < 2 && Math.abs(getScrollX()) > 2) {
                this.mScrollType = 2;
            }
            if (i20 == 0 && i13 == 0 && Math.abs(i10) > 2) {
                this.mScrollType = 2;
            }
            if (this.mFixScrollTypeForOverScrolling && (getScrollX() != 0 || getScrollY() != 0)) {
                this.mScrollType = 2;
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int calcRealOverScrollDist = (int) (COUIPhysicalAnimationUtil.calcRealOverScrollDist(i21, scrollY, this.mOverscrollDistance) * this.mFlingRatio);
            int calcRealOverScrollDist2 = (int) (COUIPhysicalAnimationUtil.calcRealOverScrollDist(i20, scrollX, this.mOverscrollDistance) * this.mFlingRatio);
            if ((scrollY < 0 && i11 > 0) || (scrollY > 0 && i11 < 0)) {
                calcRealOverScrollDist = (int) (COUIPhysicalAnimationUtil.calcRealOverScrollDist(i11, scrollX, this.mOverscrollDistance) * this.mFlingRatio);
            }
            int i27 = calcRealOverScrollDist;
            if ((scrollX < 0 && i10 > 0) || (scrollX > 0 && i10 < 0)) {
                calcRealOverScrollDist2 = (int) (COUIPhysicalAnimationUtil.calcRealOverScrollDist(i10, scrollX, this.mOverscrollDistance) * this.mFlingRatio);
            }
            if (i27 != 0 || calcRealOverScrollDist2 != 0) {
                int i28 = this.mOverscrollDistance;
                overScrollBy(calcRealOverScrollDist2, i27, scrollX, scrollY, 0, 0, i28, i28, true);
            }
        }
        if (i13 != 0 || i12 != 0) {
            dispatchOnScrolled(i13, i12);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        if (i13 != 0 || i12 != 0) {
            return true;
        }
        return false;
    }

    public void setAvoidAccidentalTouch(boolean z10) {
        this.mAvoidAccidentalTouch = z10;
    }

    public void setCustomTouchSlop(int i10) {
        Log.w(TAG, "setTouchSlop: set touchSlop from " + this.mTouchSlop + " to " + i10);
        this.mTouchSlop = i10;
    }

    public void setDispatchEventWhileOverScrolling(boolean z10) {
        this.mEnableDispatchEventWhileOverScrolling = z10;
    }

    public void setDispatchEventWhileScrolling(boolean z10) {
        this.mEnableDispatchEventWhileScrolling = z10;
    }

    public void setDispatchEventWhileScrollingThreshold(int i10) {
        this.mDispatchEventVelocityThreshold = i10;
    }

    public void setEnableFlingSpeedIncrease(boolean z10) {
        SpringOverScroller springOverScroller = this.mSpringOverScroller;
        if (springOverScroller != null) {
            springOverScroller.setEnableFlingSpeedIncrease(z10);
        }
    }

    public void setEnablePointerDownAction(boolean z10) {
        this.mEnablePointerDown = z10;
    }

    public void setEnableVibrator(boolean z10) {
        this.mEnableVibrator = z10;
    }

    public void setEventFilterTangent(float f10) {
        this.mEventFilterAngle = f10;
    }

    public void setFastFlingThreshold(float f10) {
        this.mFastFlingVelocity = Math.max(f10, 0.0f);
    }

    public void setFlingRatio(float f10) {
        this.mFlingRatio = f10;
    }

    public void setHorizontalFlingDurationRatio(float f10) {
        this.mCOUILocateOverScroller.setDurationRatio(f10);
    }

    public void setHorizontalFlingFriction(float f10) {
        COUILocateOverScroller cOUILocateOverScroller = this.mCOUILocateOverScroller;
        if (cOUILocateOverScroller != null) {
            cOUILocateOverScroller.setFlingFriction(f10);
        }
    }

    public void setHorizontalFlingVelocityRatio(float f10) {
        this.mCOUILocateOverScroller.setVelocityXRatio(f10);
        this.mCOUILocateOverScroller.setVelocityYRatio(f10);
    }

    public void setHorizontalItemAlign(int i10) {
        if (needLocate()) {
            setIsUseNativeOverScroll(true);
            this.mLocateHelper.setHorizontalItemAlign(i10);
        }
    }

    public void setIsUseNativeOverScroll(boolean z10) {
        this.mIsUseNativeOverScroll = z10;
        if (z10) {
            this.mOverScroller = this.mCOUILocateOverScroller;
        } else {
            this.mOverScroller = this.mSpringOverScroller;
        }
    }

    public void setIsUseOptimizedScroll(boolean z10) {
        this.mEnableOptimizedScroll = z10;
    }

    public void setItemClickableWhileOverScrolling(boolean z10) {
        this.mItemClickableWhileOverScrolling = z10;
    }

    public void setItemClickableWhileSlowScrolling(boolean z10) {
        this.mItemClickableWhileSlowScrolling = z10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setLayoutManager(RecyclerView.o oVar) {
        super.setLayoutManager(oVar);
        if (oVar != null && this.mSpringOverScroller != null) {
            if (oVar.canScrollHorizontally()) {
                this.mSpringOverScroller.setSpringBackTensionMultiple(HORIZONTAL_SPRING_BACK_TENSION_MULTIPLE);
            } else {
                this.mSpringOverScroller.setSpringBackTensionMultiple(this.mVerticalSpringOverTension);
            }
        }
    }

    public void setNativeOverScroller(COUILocateOverScroller cOUILocateOverScroller) {
        this.mCOUILocateOverScroller = cOUILocateOverScroller;
        if (this.mIsUseNativeOverScroll) {
            this.mOverScroller = cOUILocateOverScroller;
        }
    }

    @Override // com.coui.appcompat.scrollbar.COUIScrollBar.COUIScrollable
    public void setNewCOUIScrollDelegate(COUIScrollBar cOUIScrollBar) {
        if (cOUIScrollBar != null) {
            this.mCOUIScrollBar = cOUIScrollBar;
            cOUIScrollBar.onAttachedToWindow();
            return;
        }
        throw new IllegalArgumentException("setNewCOUIScrollDelegate must NOT be NULL.");
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setOnFlingListener(RecyclerView.q qVar) {
        this.mOnFlingListener = qVar;
    }

    public void setOverScrollEnable(boolean z10) {
        this.mOverScrollEnable = z10;
    }

    public void setOverScrollingFixed(boolean z10) {
        this.mFixScrollTypeForOverScrolling = z10;
    }

    public void setPressHideDivider(boolean z10) {
        this.mCOUIRecyclerDividerManager.l(z10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setScrollState(int i10) {
        if (i10 == this.mScrollState) {
            return;
        }
        this.mScrollState = i10;
        if (i10 != 2) {
            stopScrollersInternal();
        }
        super.setScrollState(i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setScrollingTouchSlop(int i10) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i10 != 0) {
            if (i10 != 1) {
                Log.w(TAG, "setScrollingTouchSlop(): bad argument constant " + i10 + "; using default value");
            } else {
                this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
        }
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
    }

    public void setSlowScrollThreshold(int i10) {
        Log.d(TAG, "Slow scroll threshold set to " + i10);
        this.mSlowScrollThreshold = i10;
    }

    public void setSpringBackFriction(float f10) {
        SpringOverScroller springOverScroller = this.mSpringOverScroller;
        if (springOverScroller != null) {
            springOverScroller.setSpringBackFriction(f10);
        }
    }

    public void setSpringBackTension(float f10) {
        this.mVerticalSpringOverTension = f10;
        SpringOverScroller springOverScroller = this.mSpringOverScroller;
        if (springOverScroller != null) {
            springOverScroller.setSpringBackTensionMultiple(f10);
        }
    }

    public void setSpringOverScrollerDebug(boolean z10) {
        SpringOverScroller springOverScroller = this.mSpringOverScroller;
        if (springOverScroller != null) {
            springOverScroller.setDebug(z10);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void smoothScrollBy(int i10, int i11) {
        smoothScrollBy(i10, i11, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void smoothScrollToPosition(int i10) {
        cancelScroll();
        super.smoothScrollToPosition(i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void stopScroll() {
        super.stopScroll();
        setScrollState(0);
        stopScrollersInternal();
    }

    @Override // com.coui.appcompat.scrollbar.COUIScrollBar.COUIScrollable
    public int superComputeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // com.coui.appcompat.scrollbar.COUIScrollBar.COUIScrollable
    public int superComputeVerticalScrollOffset() {
        return super.computeVerticalScrollOffset();
    }

    @Override // com.coui.appcompat.scrollbar.COUIScrollBar.COUIScrollable
    public int superComputeVerticalScrollRange() {
        return super.computeVerticalScrollRange();
    }

    @Override // com.coui.appcompat.scrollbar.COUIScrollBar.COUIScrollable
    public void superOnTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
    }

    public COUIRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void smoothScrollBy(int i10, int i11, Interpolator interpolator) {
        smoothScrollBy(i10, i11, interpolator, Integer.MIN_VALUE);
    }

    public COUIRecyclerView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.SCROLLBARS_NONE = 0;
        this.SCROLLBARS_VERTICAL = 512;
        this.mFixScrollTypeForOverScrolling = true;
        this.mOverScrollEnable = true;
        this.SCROLLING = 0;
        this.FLING = 1;
        this.OVER_SCROLLING = 2;
        this.OVER_FLING = 3;
        this.mIsOverScrollingReverseFling = false;
        this.mScreenHeight = 0;
        this.mScreenWidth = 0;
        this.mItemClickableWhileSlowScrolling = true;
        this.mItemClickableWhileOverScrolling = true;
        this.mFastFlingVelocity = 1000.0f;
        this.mAvoidAccidentalTouch = true;
        this.mDebugPaint = new Paint();
        this.mEnableFlingSpeedIncrease = true;
        this.mEnableOptimizedScroll = true;
        this.mSmoothScrollFlag = false;
        this.mEnableDispatchEventWhileScrolling = false;
        this.mEnableDispatchEventWhileOverScrolling = false;
        this.mDispatchEventVelocityThreshold = 2500;
        this.mEventFilterAngle = DEFAULT_INTERACTING_NESTED_SCROLL_ANGLE;
        this.mScrollbars = 0;
        this.mSlowScrollThreshold = 2500;
        this.mScrollState = 0;
        this.mScrollPointerId = -1;
        this.mScrollOffset = new int[2];
        this.mNestedOffsets = new int[2];
        this.mVerticalSpringOverTension = VERTICAL_SPRING_BACK_TENSION_MULTIPLE;
        this.mEnablePointerDown = true;
        this.mFlingRatio = 1.0f;
        this.mEnableVibrator = true;
        initAttr(context, attributeSet, i10);
        initViewFlinger();
        initOnItemTouchListeners();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        setSlowScrollThreshold(2500);
        initProperty(context);
        if (COUI_DEBUG) {
            Log.d(TAG, "COUIRecyclerView: overscroll_mode: " + getOverScrollMode() + " mOverScrollEnable: " + this.mOverScrollEnable);
        }
        initOverScroller(context);
        COUIFlingLocateHelper cOUIFlingLocateHelper = new COUIFlingLocateHelper();
        this.mLocateHelper = cOUIFlingLocateHelper;
        cOUIFlingLocateHelper.attachToRecyclerView(this);
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        this.mScreenWidth = displayMetrics.widthPixels;
        this.mScreenHeight = displayMetrics.heightPixels;
        this.mCOUIRecyclerDividerManager = new f(this, this.mTouchSlop);
        if (this.mScrollbars == 512) {
            createCOUIScrollDelegate(context);
            int i11 = this.mScrollbarsSize;
            if (i11 != 0) {
                this.mCOUIScrollBar.setThumbSize(i11);
            }
            Drawable drawable = this.mScrollbarThumbVertical;
            if (drawable != null) {
                this.mCOUIScrollBar.setThumbDrawable(drawable);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void smoothScrollBy(int i10, int i11, Interpolator interpolator, int i12) {
        smoothScrollBy(i10, i11, interpolator, i12, false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void smoothScrollBy(int i10, int i11, Interpolator interpolator, int i12, boolean z10) {
        if (isOverScrolling()) {
            cancelScroll();
        }
        this.mSmoothScrollFlag = true;
        RecyclerView.o oVar = this.mLayout;
        if (oVar == null) {
            Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.mLayoutSuppressed) {
            return;
        }
        if (!oVar.canScrollHorizontally()) {
            i10 = 0;
        }
        if (!this.mLayout.canScrollVertically()) {
            i11 = 0;
        }
        if (i10 == 0 && i11 == 0) {
            return;
        }
        this.mScrollType = 0;
        if (i12 != Integer.MIN_VALUE && i12 <= 0) {
            scrollBy(i10, i11);
            return;
        }
        if (z10) {
            int i13 = i10 != 0 ? 1 : 0;
            if (i11 != 0) {
                i13 |= 2;
            }
            startNestedScroll(i13, 1);
        }
        this.mViewFlinger.f(i10, i11, i12, interpolator);
    }

    @Override // com.coui.appcompat.scrollbar.COUIScrollBar.COUIScrollable
    public View getCOUIScrollableView() {
        return this;
    }
}
