package com.coui.appcompat.indicator;

import J.d;
import a9.b;
import a9.l;
import a9.m;
import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.PathInterpolator;
import androidx.core.view.K;
import androidx.customview.widget.a;
import androidx.dynamicanimation.animation.f;
import androidx.dynamicanimation.animation.g;
import com.coui.appcompat.animation.COUIEaseInterpolator;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import com.coui.appcompat.log.COUILog;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Deprecated
/* loaded from: classes.dex */
public class COUIPageIndicator2 extends View implements COUIIPagerIndicator {
    private static final ArgbEvaluator COLOR_EVALUATOR;
    private static final float COMPACT_MOVE_FACTOR_THRESHOLD = 0.095f;
    private static final boolean DEBUG;
    private static final float DEFAULT_COLOR_FACTOR_THRESHOLD = 0.05f;
    private static final float DEFAULT_GONE_DOT_SIZE = 0.0f;
    private static final float DEFAULT_HALF_OF_PROGRESS = 0.5f;
    private static final PathInterpolator DEFAULT_INTERPOLATOR;
    private static final int DEFAULT_MAXIMUM_LARGE_DOT_NUMBER = 4;
    private static final int DEFAULT_MAXIMUM_MEDIUM_DOT_NUMBER = 2;
    private static final float DEFAULT_MINIMUM_VISIBLE_CHANGE = 0.005f;
    private static final float DEFAULT_MOVE_FACTOR_THRESHOLD = 0.005f;
    private static final float HALF_OF_PI_IN_DEGREE = 90.0f;
    private static final float INDICATOR_DOT_GONE_LEVEL_SIZE = 9.0f;
    private static final float INDICATOR_DOT_LARGE_LEVEL_SIZE = 3.0f;
    private static final float INDICATOR_DOT_LARGE_LEVEL_SIZE_WHILE_ALL_DOTS_VISIBLE = 5.0f;
    private static final int INDICATOR_DOT_LEVEL = 4;
    private static final float INDICATOR_DOT_MEDIUM_LEVEL_SIZE = 5.0f;
    private static final float INDICATOR_DOT_SMALL_LEVEL_SIZE = 7.0f;
    private static final int INVALID_INDEX = -1;
    private static final int MAX_VISIBLE_DOT_NUMBER = 6;
    private static final float ONE_AND_A_HALF_OF_PI_IN_DEGREE = 270.0f;
    private static final float PI_IN_DEGREE = 180.0f;
    private static final String TAG = "COUIPageIndicator2";
    private final AccessibilityHelper mAccessibilityHelper;
    private Paint mCompatTracePaint;
    private int mDotColor;
    private Paint mDotPaint;
    private float mDotsInterval;
    private long mDownTime;
    private boolean mIsClickable;
    private float mMediumDotSize;
    private PageIndicatorModel mModel;
    private float mMoveFactorThreshold;
    private float mNormalDotSize;
    private OnIndicatorDotClickListener mOnDotClickListener;
    private float mSmallDotSize;
    private final int mStyle;
    private final float[] mTouchPoint;
    private int mTraceColor;
    private Paint mTracePaint;

    /* loaded from: classes.dex */
    public class AccessibilityHelper extends a {
        public AccessibilityHelper(View view) {
            super(view);
        }

        @Override // androidx.customview.widget.a
        public int getVirtualViewAt(float f10, float f11) {
            return COUIPageIndicator2.this.mModel.getClickedDotIndex(f10, f11);
        }

        @Override // androidx.customview.widget.a
        public void getVisibleVirtualViews(List<Integer> list) {
            for (int i10 = 0; i10 < COUIPageIndicator2.this.mModel.getDotsCount(); i10++) {
                list.add(Integer.valueOf(i10));
            }
        }

        @Override // androidx.customview.widget.a
        public boolean onPerformActionForVirtualView(int i10, int i11, Bundle bundle) {
            if (i11 == 16 && i10 != -1 && COUIPageIndicator2.this.mIsClickable && COUIPageIndicator2.this.mOnDotClickListener != null) {
                COUIPageIndicator2.this.mOnDotClickListener.onClick(i10);
                COUIPageIndicator2.this.invalidate();
                invalidateVirtualView(i10);
                return true;
            }
            return false;
        }

        @Override // androidx.customview.widget.a
        public void onPopulateNodeForVirtualView(int i10, d dVar) {
            PageIndicatorDotModel dot;
            if (i10 < 0 || i10 >= COUIPageIndicator2.this.mModel.getDotsCount() || (dot = COUIPageIndicator2.this.mModel.getDot(i10)) == null) {
                return;
            }
            Rect rect = new Rect((int) dot.getBounds().left, (int) dot.getBounds().top, (int) dot.getBounds().right, (int) dot.getBounds().bottom);
            dVar.K0("");
            dVar.l0("");
            dVar.c0(rect);
        }
    }

    /* loaded from: classes.dex */
    public interface OnIndicatorDotClickListener {
        void onClick(int i10);
    }

    /* loaded from: classes.dex */
    public static class PageIndicatorDotModel {
        protected int mFillColor;
        protected int mId;
        protected float mRadius = 0.0f;
        protected float mCenterX = 0.0f;
        protected float mCenterY = 0.0f;
        protected float mOffsetX = 0.0f;
        protected RectF mBounds = new RectF(0.0f, 0.0f, 0.0f, 0.0f);

        public PageIndicatorDotModel(int i10) {
            this.mId = i10;
        }

        private void updateBounds() {
            RectF rectF = this.mBounds;
            float f10 = this.mOffsetX;
            float f11 = this.mCenterX;
            float f12 = this.mRadius;
            float f13 = this.mCenterY;
            rectF.set((f10 + f11) - f12, f13 - f12, f10 + f11 + f12, f13 + f12);
        }

        public void dump() {
            COUILog.d(COUIPageIndicator2.DEBUG, COUIPageIndicator2.TAG, "id = " + this.mId + " dot = (" + this.mCenterX + ", " + this.mCenterY + ", " + this.mRadius + ") bounds = " + this.mBounds + " offsetX = " + this.mOffsetX);
        }

        public RectF getBounds() {
            return this.mBounds;
        }

        public float getCenterX() {
            return this.mCenterX;
        }

        public float getCenterY() {
            return this.mCenterY;
        }

        public int getFillColor() {
            return this.mFillColor;
        }

        public int getId() {
            return this.mId;
        }

        public float getRadius() {
            return this.mRadius;
        }

        public void onDraw(Canvas canvas, Paint paint) {
            paint.setColor(this.mFillColor);
            float f10 = this.mCenterX;
            float f11 = this.mRadius;
            float f12 = this.mCenterY;
            canvas.drawOval(f10 - f11, f12 - f11, f10 + f11, f12 + f11, paint);
        }

        public void setCenterX(float f10) {
            this.mCenterX = f10;
            updateBounds();
        }

        public void setCenterY(float f10) {
            this.mCenterY = f10;
            updateBounds();
        }

        public void setFillColor(int i10) {
            this.mFillColor = i10;
        }

        public void setId(int i10) {
            this.mId = i10;
        }

        public void setOffsetX(float f10) {
            this.mOffsetX = f10;
            updateBounds();
        }

        public void setRadius(float f10) {
            this.mRadius = f10;
            updateBounds();
        }
    }

    /* loaded from: classes.dex */
    public class PageIndicatorModel {
        private int mCurrentIndex;
        private float mCurrentOffset;
        private float mInterval;
        private float mMaskOffset;
        private final float[] mScaleMaskIndex;
        private final float[] mScaleMaskSize;
        private final float[] mScaleSize;
        private f mSpringAnimation;
        private View mViewHost;
        private final LinkedList<PageIndicatorDotModel> mDots = new LinkedList<>();
        private final int mMaxVisibleCount = 6;
        private final Path mTraceRectPath = new Path();
        private final RectF mVisibleRect = new RectF();
        private final float[] mVisibleBounds = new float[2];
        private final Path mPath = new Path();
        private final Path mPathLeft = new Path();
        private final Path mPathRight = new Path();
        private final Path mPathUp = new Path();
        private final Path mPathDown = new Path();
        private final Matrix mMatrix = new Matrix();
        private final Matrix mInvertMatrix = new Matrix();
        private final androidx.dynamicanimation.animation.d<PageIndicatorModel> mCurrentPosition = new androidx.dynamicanimation.animation.d<PageIndicatorModel>("currentPosition") { // from class: com.coui.appcompat.indicator.COUIPageIndicator2.PageIndicatorModel.1
            @Override // androidx.dynamicanimation.animation.d
            public float getValue(PageIndicatorModel pageIndicatorModel) {
                return pageIndicatorModel.getCurrentPosition();
            }

            @Override // androidx.dynamicanimation.animation.d
            public void setValue(PageIndicatorModel pageIndicatorModel, float f10) {
                int floor = (int) Math.floor(f10);
                pageIndicatorModel.setCurrentPositionInternal(floor, f10 - floor);
            }
        };
        private int mIndicatorCount = 0;
        private float mDrawHorizontalOffset = 0.0f;
        private float mVisibleOffset = 0.0f;
        private boolean mMovingToEnd = false;

        public PageIndicatorModel(View view) {
            this.mViewHost = view;
            this.mScaleMaskIndex = r3;
            this.mScaleMaskSize = r4;
            this.mScaleSize = r14;
            float[] fArr = {COUIPageIndicator2.INDICATOR_DOT_LARGE_LEVEL_SIZE, 5.0f, COUIPageIndicator2.INDICATOR_DOT_SMALL_LEVEL_SIZE, COUIPageIndicator2.INDICATOR_DOT_GONE_LEVEL_SIZE};
            float f10 = 0.0f - ((5.0f - fArr[0]) / 2.0f);
            float f11 = f10 - ((COUIPageIndicator2.INDICATOR_DOT_SMALL_LEVEL_SIZE - fArr[1]) / 2.0f);
            float[] fArr2 = {0.0f, f10, f11, f11 - ((COUIPageIndicator2.INDICATOR_DOT_GONE_LEVEL_SIZE - fArr[2]) / 2.0f)};
            float[] fArr3 = {COUIPageIndicator2.this.mNormalDotSize / 2.0f, COUIPageIndicator2.this.mMediumDotSize / 2.0f, COUIPageIndicator2.this.mSmallDotSize / 2.0f, 0.0f};
            this.mMaskOffset = 0.0f;
            this.mInterval = COUIPageIndicator2.this.mDotsInterval * 2.0f;
            initSpring();
        }

        private void configCanvas(Canvas canvas) {
            this.mMatrix.reset();
            if (COUIPageIndicator2.this.isLayoutRtl()) {
                this.mMatrix.setTranslate(this.mVisibleBounds[0] - this.mDrawHorizontalOffset, 0.0f);
                Matrix matrix = this.mMatrix;
                float[] fArr = this.mVisibleBounds;
                float f10 = fArr[0];
                matrix.postRotate(COUIPageIndicator2.PI_IN_DEGREE, f10 + ((fArr[1] - f10) / 2.0f), COUIPageIndicator2.this.mNormalDotSize / 2.0f);
            } else {
                this.mMatrix.setTranslate((-this.mVisibleBounds[0]) + this.mDrawHorizontalOffset, 0.0f);
            }
            canvas.setMatrix(this.mMatrix);
            this.mMatrix.invert(this.mInvertMatrix);
            COUILog.d(COUIPageIndicator2.DEBUG, COUIPageIndicator2.TAG, "draw rect bounds = " + Arrays.toString(this.mVisibleBounds) + " horizontalOffset = " + this.mDrawHorizontalOffset);
        }

        private void drawDots(Canvas canvas) {
            int i10;
            Iterator<PageIndicatorDotModel> it = this.mDots.iterator();
            while (it.hasNext()) {
                PageIndicatorDotModel next = it.next();
                int indexOf = this.mDots.indexOf(next);
                if (this.mCurrentOffset == 0.0f || (indexOf != (i10 = this.mCurrentIndex) && indexOf - 1 != i10)) {
                    float f10 = next.mCenterX;
                    float f11 = next.mRadius;
                    float f12 = f10 + f11;
                    float[] fArr = this.mVisibleBounds;
                    if (f12 >= fArr[0] && f10 - f11 <= fArr[1]) {
                        COUILog.d(COUIPageIndicator2.DEBUG, COUIPageIndicator2.TAG, "drawDots: dot index = " + indexOf + " dot radius = " + next.mRadius + " dot location = (" + next.mCenterX + ", " + next.mCenterY + ") left = " + this.mVisibleBounds[0] + " right = " + this.mVisibleBounds[1]);
                        if (indexOf == this.mCurrentIndex) {
                            next.setFillColor(COUIPageIndicator2.this.mTraceColor);
                        } else {
                            next.setFillColor(COUIPageIndicator2.this.mDotColor);
                        }
                        next.onDraw(canvas, COUIPageIndicator2.this.mDotPaint);
                    }
                }
            }
        }

        private void drawTrace(Canvas canvas) {
            float colorFactor = getColorFactor();
            if (colorFactor == 1.0f) {
                COUIPageIndicator2.this.mTracePaint.setColor(COUIPageIndicator2.this.mTraceColor);
                canvas.drawPath(this.mPath, COUIPageIndicator2.this.mTracePaint);
                return;
            }
            if (this.mCurrentOffset <= 0.5f) {
                COUIPageIndicator2.this.mTracePaint.setColor(COUIPageIndicator2.this.mTraceColor);
                canvas.drawPath(this.mPathLeft, COUIPageIndicator2.this.mTracePaint);
                COUIPageIndicator2.this.mTracePaint.setColor(((Integer) COUIPageIndicator2.COLOR_EVALUATOR.evaluate(colorFactor, Integer.valueOf(COUIPageIndicator2.this.mDotColor), Integer.valueOf(COUIPageIndicator2.this.mTraceColor))).intValue());
            } else {
                COUIPageIndicator2.this.mTracePaint.setColor(((Integer) COUIPageIndicator2.COLOR_EVALUATOR.evaluate(colorFactor, Integer.valueOf(COUIPageIndicator2.this.mDotColor), Integer.valueOf(COUIPageIndicator2.this.mTraceColor))).intValue());
                canvas.drawPath(this.mPathLeft, COUIPageIndicator2.this.mTracePaint);
                COUIPageIndicator2.this.mTracePaint.setColor(COUIPageIndicator2.this.mTraceColor);
            }
            canvas.drawPath(this.mPathRight, COUIPageIndicator2.this.mTracePaint);
        }

        private float getColorFactor() {
            float f10 = this.mCurrentOffset;
            if (f10 <= COUIPageIndicator2.DEFAULT_COLOR_FACTOR_THRESHOLD) {
                return f10 / COUIPageIndicator2.DEFAULT_COLOR_FACTOR_THRESHOLD;
            }
            if (f10 < 0.95f) {
                return 1.0f;
            }
            return (1.0f - f10) / COUIPageIndicator2.DEFAULT_COLOR_FACTOR_THRESHOLD;
        }

        private float getMaskedSize(int i10, float f10) {
            if (i10 == 0) {
                return this.mScaleSize[i10];
            }
            float f11 = this.mScaleMaskIndex[0];
            if (f10 < f11) {
                if (this.mMovingToEnd) {
                    float[] fArr = this.mScaleSize;
                    float f12 = fArr[i10];
                    int i11 = i10 - 1;
                    float f13 = fArr[i11];
                    float interpolation = COUIPageIndicator2.DEFAULT_INTERPOLATOR.getInterpolation(f10 - this.mScaleMaskIndex[i10]);
                    float[] fArr2 = this.mScaleMaskIndex;
                    return Math.max(f12, f13 - (((f13 - f12) * 2.0f) * (1.0f - (interpolation / (fArr2[i11] - fArr2[i10])))));
                }
                float[] fArr3 = this.mScaleSize;
                int i12 = i10 - 1;
                float f14 = fArr3[i12];
                float f15 = fArr3[i10];
                float interpolation2 = (f14 - f15) * 2.0f * COUIPageIndicator2.DEFAULT_INTERPOLATOR.getInterpolation(f10 - this.mScaleMaskIndex[i10]);
                float[] fArr4 = this.mScaleMaskIndex;
                return Math.min(f14, f15 + (interpolation2 / (fArr4[i12] - fArr4[i10])));
            }
            if (f10 > f11 + this.mScaleMaskSize[0]) {
                if (this.mMovingToEnd) {
                    float[] fArr5 = this.mScaleSize;
                    int i13 = i10 - 1;
                    float f16 = fArr5[i13];
                    float f17 = fArr5[i10];
                    float interpolation3 = (f16 - f17) * 2.0f * COUIPageIndicator2.DEFAULT_INTERPOLATOR.getInterpolation((this.mScaleMaskIndex[i10] + this.mScaleMaskSize[i10]) - f10);
                    float[] fArr6 = this.mScaleMaskIndex;
                    float f18 = fArr6[i10];
                    float[] fArr7 = this.mScaleMaskSize;
                    return Math.min(f16, f17 + (interpolation3 / (((f18 + fArr7[i10]) - fArr6[i13]) - fArr7[i13])));
                }
                float[] fArr8 = this.mScaleSize;
                float f19 = fArr8[i10];
                int i14 = i10 - 1;
                float f20 = fArr8[i14];
                float interpolation4 = COUIPageIndicator2.DEFAULT_INTERPOLATOR.getInterpolation((this.mScaleMaskIndex[i10] + this.mScaleMaskSize[i10]) - f10);
                float[] fArr9 = this.mScaleMaskIndex;
                float f21 = fArr9[i10];
                float[] fArr10 = this.mScaleMaskSize;
                return Math.max(f19, f20 - (((f20 - f19) * 2.0f) * (1.0f - (interpolation4 / (((f21 + fArr10[i10]) - fArr9[i14]) - fArr10[i14])))));
            }
            return 0.0f;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x004f  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0048  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private float getMoveFactor() {
            /*
                r7 = this;
                float r0 = r7.mCurrentOffset
                r1 = 1028443341(0x3d4ccccd, float:0.05)
                int r2 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                r3 = 1073741824(0x40000000, float:2.0)
                r4 = 1055286886(0x3ee66666, float:0.45)
                r5 = 1056964608(0x3f000000, float:0.5)
                if (r2 <= 0) goto L22
                int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
                if (r2 > 0) goto L22
                android.view.animation.PathInterpolator r0 = com.coui.appcompat.indicator.COUIPageIndicator2.access$900()
                float r2 = r7.mCurrentOffset
                float r2 = r2 - r1
                float r2 = r2 / r4
                float r0 = r0.getInterpolation(r2)
            L20:
                float r0 = r0 / r3
                goto L3e
            L22:
                int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
                if (r2 <= 0) goto L3d
                r2 = 1064514355(0x3f733333, float:0.95)
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r0 >= 0) goto L3d
                android.view.animation.PathInterpolator r0 = com.coui.appcompat.indicator.COUIPageIndicator2.access$900()
                r2 = 1065353216(0x3f800000, float:1.0)
                float r6 = r7.mCurrentOffset
                float r2 = r2 - r6
                float r2 = r2 - r1
                float r2 = r2 / r4
                float r0 = r0.getInterpolation(r2)
                goto L20
            L3d:
                r0 = 0
            L3e:
                com.coui.appcompat.indicator.COUIPageIndicator2 r1 = com.coui.appcompat.indicator.COUIPageIndicator2.this
                float r1 = com.coui.appcompat.indicator.COUIPageIndicator2.access$1000(r1)
                int r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r1 >= 0) goto L4f
                com.coui.appcompat.indicator.COUIPageIndicator2 r7 = com.coui.appcompat.indicator.COUIPageIndicator2.this
                float r0 = com.coui.appcompat.indicator.COUIPageIndicator2.access$1000(r7)
                goto L63
            L4f:
                com.coui.appcompat.indicator.COUIPageIndicator2 r1 = com.coui.appcompat.indicator.COUIPageIndicator2.this
                float r1 = com.coui.appcompat.indicator.COUIPageIndicator2.access$1000(r1)
                float r1 = r5 - r1
                int r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r1 <= 0) goto L63
                com.coui.appcompat.indicator.COUIPageIndicator2 r7 = com.coui.appcompat.indicator.COUIPageIndicator2.this
                float r7 = com.coui.appcompat.indicator.COUIPageIndicator2.access$1000(r7)
                float r0 = r5 - r7
            L63:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.indicator.COUIPageIndicator2.PageIndicatorModel.getMoveFactor():float");
        }

        private float getRadius(int i10) {
            float f10 = i10 - this.mMaskOffset;
            int i11 = 0;
            while (true) {
                float[] fArr = this.mScaleMaskIndex;
                if (i11 < fArr.length) {
                    float f11 = fArr[i11];
                    if (f10 >= f11 && f10 <= f11 + this.mScaleMaskSize[i11]) {
                        float maskedSize = getMaskedSize(i11, f10);
                        COUILog.d(COUIPageIndicator2.DEBUG, COUIPageIndicator2.TAG, "index, mMaskOffset = " + i10 + " " + this.mMaskOffset + " level = " + i11 + " dot position = " + f10 + " size = " + maskedSize + " moving to end = " + this.mMovingToEnd);
                        return maskedSize;
                    }
                    i11++;
                } else {
                    return 0.0f;
                }
            }
        }

        private void initSpring() {
            g gVar = new g();
            gVar.d(1.0f);
            gVar.f(1500.0f);
            f fVar = new f(this, this.mCurrentPosition);
            this.mSpringAnimation = fVar;
            fVar.x(gVar);
            this.mSpringAnimation.k(0.005f);
        }

        private void mapPoints(float[] fArr) {
            this.mInvertMatrix.mapPoints(fArr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0128  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0138  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0203 A[LOOP:0: B:33:0x01fd->B:35:0x0203, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0148  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void setCurrentPositionInternal(int r19, float r20) {
            /*
                Method dump skipped, instructions count: 574
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.indicator.COUIPageIndicator2.PageIndicatorModel.setCurrentPositionInternal(int, float):void");
        }

        private void updatePath() {
            float f10;
            float f11;
            if (this.mCurrentIndex < this.mDots.size() - 1) {
                COUILog.d(COUIPageIndicator2.DEBUG, COUIPageIndicator2.TAG, "updatePath: mCurrentOffset = " + this.mCurrentOffset + " dots size = " + this.mDots.size());
                PageIndicatorDotModel pageIndicatorDotModel = this.mDots.get(this.mCurrentIndex);
                PageIndicatorDotModel pageIndicatorDotModel2 = this.mDots.get(this.mCurrentIndex + 1);
                float centerX = pageIndicatorDotModel.getCenterX();
                float centerY = pageIndicatorDotModel.getCenterY();
                float radius = pageIndicatorDotModel.getRadius();
                float centerX2 = pageIndicatorDotModel2.getCenterX();
                float centerY2 = pageIndicatorDotModel2.getCenterY();
                float radius2 = pageIndicatorDotModel2.getRadius();
                float colorFactor = getColorFactor();
                float moveFactor = getMoveFactor();
                float f12 = this.mCurrentOffset;
                if (f12 <= 0.5f) {
                    f10 = moveFactor * 2.0f * (this.mInterval + radius2 + radius);
                } else {
                    f10 = 0.0f;
                }
                if (f12 > 0.5f) {
                    f11 = moveFactor * 2.0f * (this.mInterval + radius2 + radius);
                } else {
                    f11 = 0.0f;
                }
                float f13 = centerX + f10;
                float f14 = 0.5f - moveFactor;
                float f15 = f13 + (radius * f14 * 2.0f);
                float sqrt = (float) (centerY - Math.sqrt(r20 - (((((radius * 2.0f) * f14) * 2.0f) * radius) * f14)));
                float f16 = centerX2 - f11;
                float f17 = f16 - ((radius2 * f14) * 2.0f);
                float f18 = f11;
                float sqrt2 = (float) (centerY2 - Math.sqrt((radius2 * radius2) - (((((radius2 * 2.0f) * f14) * 2.0f) * radius2) * f14)));
                float f19 = (f15 + f17) / 2.0f;
                float f20 = (((radius * radius) - (((f19 - centerX) - f10) * ((f15 - centerX) - f10))) / (sqrt - centerY)) + centerY;
                float asin = (float) ((Math.asin(f14 * 2.0f) * 180.0d) / 3.141592653589793d);
                COUILog.d(COUIPageIndicator2.DEBUG, COUIPageIndicator2.TAG, "updatePath: mCurrentOffset = " + this.mCurrentOffset + " dots size = " + this.mDots.size() + " startDot = (" + centerX + ", " + centerY + ", " + radius + ") endDot = (" + centerX2 + ", " + centerY2 + ", " + radius2 + ") colorFactor = " + colorFactor + " moveFactor = " + moveFactor + " mDepartOffset = " + f10 + " mPortOffset = " + f18 + ") control1 = (" + f15 + ", " + sqrt + ") control2 = (" + f19 + ", " + f20 + ") control3 = (" + f17 + ", " + sqrt2 + ") snapAngle = " + asin);
                this.mPath.reset();
                Path path = this.mPath;
                float f21 = centerX - radius;
                float f22 = centerX2 + radius2;
                float f23 = COUIPageIndicator2.this.mNormalDotSize;
                Path.Direction direction = Path.Direction.CW;
                path.addRect(f21, 0.0f, f22, f23, direction);
                this.mTraceRectPath.reset();
                this.mTraceRectPath.moveTo(f21, 0.0f);
                this.mTraceRectPath.lineTo(f22, 0.0f);
                this.mTraceRectPath.lineTo(f22, COUIPageIndicator2.this.mNormalDotSize);
                this.mTraceRectPath.lineTo(f21, COUIPageIndicator2.this.mNormalDotSize);
                this.mTraceRectPath.close();
                this.mPathUp.reset();
                this.mPathUp.moveTo(f21, centerY);
                float f24 = centerY - radius;
                float f25 = centerX + radius;
                float f26 = radius + centerY;
                this.mPathUp.arcTo(f21, f24, f25, f26, COUIPageIndicator2.PI_IN_DEGREE, COUIPageIndicator2.HALF_OF_PI_IN_DEGREE, false);
                this.mPathUp.lineTo(f13, f24);
                float f27 = f21 + f10;
                float f28 = f25 + f10;
                this.mPathUp.arcTo(f27, f24, f28, f26, COUIPageIndicator2.ONE_AND_A_HALF_OF_PI_IN_DEGREE, asin, false);
                this.mPathUp.quadTo(f19, f20, f17, sqrt2);
                float f29 = centerX2 - radius2;
                float f30 = f29 - f18;
                float f31 = centerY2 - radius2;
                float f32 = f22 - f18;
                float f33 = centerY2 + radius2;
                this.mPathUp.arcTo(f30, f31, f32, f33, COUIPageIndicator2.ONE_AND_A_HALF_OF_PI_IN_DEGREE - asin, asin, false);
                this.mPathUp.lineTo(centerX2, f31);
                this.mPathUp.arcTo(f29, f31, f22, f33, COUIPageIndicator2.ONE_AND_A_HALF_OF_PI_IN_DEGREE, COUIPageIndicator2.HALF_OF_PI_IN_DEGREE, false);
                this.mPathUp.lineTo(f22, 0.0f);
                this.mPathUp.lineTo(f21, 0.0f);
                this.mPathUp.close();
                this.mPathDown.reset();
                this.mPathDown.moveTo(f22, centerY2);
                this.mPathDown.arcTo(f29, f31, f22, f33, 0.0f, COUIPageIndicator2.HALF_OF_PI_IN_DEGREE, false);
                this.mPathDown.lineTo(f16, f33);
                this.mPathDown.arcTo(f30, f31, f32, f33, COUIPageIndicator2.HALF_OF_PI_IN_DEGREE, asin, false);
                this.mPathDown.quadTo(f19, (centerY2 * 2.0f) - f20, f15, (centerY * 2.0f) - sqrt);
                this.mPathDown.arcTo(f27, f24, f28, f26, COUIPageIndicator2.HALF_OF_PI_IN_DEGREE - asin, asin, false);
                this.mPathDown.lineTo(centerX, f26);
                this.mPathDown.arcTo(f21, f24, f25, f26, COUIPageIndicator2.HALF_OF_PI_IN_DEGREE, COUIPageIndicator2.HALF_OF_PI_IN_DEGREE, false);
                this.mPathDown.lineTo(f21, COUIPageIndicator2.this.mNormalDotSize);
                this.mPathDown.lineTo(f22, COUIPageIndicator2.this.mNormalDotSize);
                this.mPathDown.close();
                Path path2 = this.mPath;
                Path path3 = this.mPathUp;
                Path.Op op = Path.Op.DIFFERENCE;
                path2.op(path3, op);
                this.mPath.op(this.mPathDown, op);
                this.mPathLeft.reset();
                this.mPathRight.reset();
                this.mPathLeft.addRect(f21, 0.0f, f19 + 0.5f, COUIPageIndicator2.this.mNormalDotSize, direction);
                this.mPathRight.addRect(f19, 0.0f, f22, COUIPageIndicator2.this.mNormalDotSize, direction);
                Path path4 = this.mPathLeft;
                Path path5 = this.mPath;
                Path.Op op2 = Path.Op.INTERSECT;
                path4.op(path5, op2);
                this.mPathRight.op(this.mPath, op2);
            }
        }

        private void verifyMask(boolean z10) {
            if (z10) {
                if (this.mIndicatorCount >= 6) {
                    this.mMaskOffset = Math.max(0.0f, this.mMaskOffset - 1.0f);
                } else {
                    this.mMaskOffset = 0.0f;
                }
            }
            if (this.mIndicatorCount < 6) {
                this.mScaleMaskSize[0] = 5.0f;
            } else {
                this.mScaleMaskSize[0] = 3.0f;
            }
        }

        public void addDot(int i10) {
            PageIndicatorDotModel pageIndicatorDotModel = new PageIndicatorDotModel(i10);
            pageIndicatorDotModel.setFillColor(COUIPageIndicator2.this.mDotColor);
            pageIndicatorDotModel.setCenterX(COUIPageIndicator2.this.mNormalDotSize / 2.0f);
            pageIndicatorDotModel.setCenterY(COUIPageIndicator2.this.mNormalDotSize / 2.0f);
            this.mDots.add(pageIndicatorDotModel);
            this.mIndicatorCount = this.mDots.size();
            verifyMask(false);
            setCurrentPositionInternal(this.mCurrentIndex, this.mCurrentOffset);
            this.mViewHost.requestLayout();
            COUILog.d(COUIPageIndicator2.DEBUG, COUIPageIndicator2.TAG, "addDot: current index = " + this.mCurrentIndex + " mCurrentOffset = " + this.mCurrentOffset);
            pageIndicatorDotModel.dump();
        }

        public void dump() {
            COUILog.d(COUIPageIndicator2.DEBUG, COUIPageIndicator2.TAG, "current index = " + this.mCurrentIndex + " offset = " + this.mCurrentOffset + " dots count = " + this.mIndicatorCount + " maskOffset = " + this.mMaskOffset + " visible rect = " + this.mVisibleRect);
            Iterator<PageIndicatorDotModel> it = this.mDots.iterator();
            while (it.hasNext()) {
                it.next().dump();
            }
        }

        public int getClickedDotIndex(float f10, float f11) {
            float[] fArr = {f10, f11};
            mapPoints(fArr);
            Iterator<PageIndicatorDotModel> it = this.mDots.iterator();
            while (it.hasNext()) {
                PageIndicatorDotModel next = it.next();
                if (next.getBounds().contains(fArr[0], fArr[1])) {
                    return this.mDots.indexOf(next);
                }
            }
            return -1;
        }

        public float getCurrentPosition() {
            return this.mCurrentIndex + this.mCurrentOffset;
        }

        public PageIndicatorDotModel getDot(int i10) {
            if (i10 >= 0 && i10 < this.mDots.size()) {
                return this.mDots.get(i10);
            }
            return null;
        }

        public int getDotsCount() {
            return this.mIndicatorCount;
        }

        public RectF getVisibleRect() {
            this.mVisibleRect.set(0.0f, 0.0f, Math.min(6, this.mIndicatorCount) * (this.mInterval + COUIPageIndicator2.this.mNormalDotSize), COUIPageIndicator2.this.mNormalDotSize);
            return this.mVisibleRect;
        }

        public void onDraw(Canvas canvas) {
            canvas.save();
            configCanvas(canvas);
            drawDots(canvas);
            if (this.mCurrentOffset != 0.0f) {
                drawTrace(canvas);
            }
            canvas.restore();
        }

        public void removeDot() {
            this.mDots.removeLast();
            int size = this.mDots.size();
            this.mIndicatorCount = size;
            if (this.mCurrentIndex + this.mCurrentOffset > size - 1) {
                this.mCurrentIndex = size - 1;
                this.mCurrentOffset = 0.0f;
            }
            verifyMask(true);
            setCurrentPositionInternal(this.mCurrentIndex, this.mCurrentOffset);
            this.mViewHost.requestLayout();
            COUILog.d(COUIPageIndicator2.DEBUG, COUIPageIndicator2.TAG, "removeDot: current index = " + this.mCurrentIndex + " currentOffset = " + this.mCurrentOffset + " count = " + this.mIndicatorCount);
        }

        public void setCurrentPosition(int i10, float f10, boolean z10) {
            COUILog.d(COUIPageIndicator2.DEBUG, COUIPageIndicator2.TAG, "setCurrentPosition: position: " + i10 + " offset: " + f10 + " animate: " + z10);
            if (z10) {
                this.mSpringAnimation.m(getCurrentPosition());
                this.mSpringAnimation.s(i10 + f10);
            } else {
                setCurrentPositionInternal(i10, f10);
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
        DEBUG = z10;
        DEFAULT_INTERPOLATOR = new COUIEaseInterpolator();
        COLOR_EVALUATOR = new ArgbEvaluator();
    }

    public COUIPageIndicator2(Context context) {
        this(context, null);
    }

    private void buildModel() {
        this.mModel = new PageIndicatorModel(this);
    }

    private void initPaints() {
        Paint paint = new Paint(1);
        this.mDotPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint(1);
        this.mTracePaint = paint2;
        paint2.setColor(this.mTraceColor);
    }

    public void addDot() {
        PageIndicatorModel pageIndicatorModel = this.mModel;
        pageIndicatorModel.addDot(pageIndicatorModel.getDotsCount());
    }

    @Override // android.view.View
    public boolean callOnClick() {
        OnIndicatorDotClickListener onIndicatorDotClickListener;
        if (this.mIsClickable && (onIndicatorDotClickListener = this.mOnDotClickListener) != null) {
            PageIndicatorModel pageIndicatorModel = this.mModel;
            float[] fArr = this.mTouchPoint;
            onIndicatorDotClickListener.onClick(pageIndicatorModel.getClickedDotIndex(fArr[0], fArr[1]));
        }
        invalidate();
        return super.callOnClick();
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 7) {
            return super.dispatchHoverEvent(motionEvent);
        }
        if (this.mAccessibilityHelper.dispatchHoverEvent(motionEvent) && super.dispatchHoverEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    public int getDotsCount() {
        return this.mModel.getDotsCount();
    }

    public boolean isLayoutRtl() {
        if (getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mModel.onDraw(canvas);
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        RectF visibleRect = this.mModel.getVisibleRect();
        setMeasuredDimension((int) visibleRect.width(), (int) visibleRect.height());
    }

    @Override // com.coui.appcompat.indicator.COUIIPagerIndicator
    public void onPageScrolled(int i10, float f10, int i11) {
        setCurrentPosition(i10, f10);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        IndicatorSavedState indicatorSavedState = (IndicatorSavedState) parcelable;
        super.onRestoreInstanceState(indicatorSavedState.getSuperState());
        setDotsCount(indicatorSavedState.mDotsCount);
        float f10 = indicatorSavedState.mCurrentPosition;
        int i10 = (int) f10;
        setCurrentPosition(i10, f10 - i10);
        if (DEBUG) {
            Log.d(TAG, "onRestoreInstanceState dotsCount = " + indicatorSavedState.mDotsCount + " currentPosition = " + indicatorSavedState.mCurrentPosition);
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        IndicatorSavedState indicatorSavedState = new IndicatorSavedState(super.onSaveInstanceState());
        indicatorSavedState.mDotsCount = this.mModel.getDotsCount();
        indicatorSavedState.mCurrentPosition = this.mModel.getCurrentPosition();
        if (DEBUG) {
            Log.d(TAG, "onSaveInstanceState dotsCount = " + indicatorSavedState.mDotsCount + " currentPosition = " + indicatorSavedState.mCurrentPosition);
        }
        return indicatorSavedState;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1 && System.currentTimeMillis() - this.mDownTime <= ViewConfiguration.getTapTimeout()) {
                this.mTouchPoint[0] = motionEvent.getX();
                this.mTouchPoint[1] = motionEvent.getY();
                callOnClick();
            }
        } else {
            this.mDownTime = System.currentTimeMillis();
        }
        return true;
    }

    public void refresh() {
        String resourceTypeName = getResources().getResourceTypeName(this.mStyle);
        TypedArray typedArray = null;
        if ("attr".equals(resourceTypeName)) {
            typedArray = getContext().obtainStyledAttributes(null, m.f6859h1, this.mStyle, 0);
        } else if ("style".equals(resourceTypeName)) {
            typedArray = getContext().obtainStyledAttributes(null, m.f6859h1, 0, this.mStyle);
        }
        if (typedArray != null) {
            this.mTraceColor = typedArray.getColor(m.f6887o1, 0);
            this.mDotColor = typedArray.getColor(m.f6867j1, 0);
            typedArray.recycle();
        }
        setTraceDotColor(this.mTraceColor);
        setPageIndicatorDotsColor(this.mDotColor);
    }

    public void removeDot() {
        this.mModel.removeDot();
    }

    public void setCurrentPosition(int i10) {
        setCurrentPosition(i10, 0.0f);
    }

    public void setDotsCount(int i10) {
        int dotsCount = i10 - getDotsCount();
        for (int i11 = 0; i11 < Math.abs(dotsCount); i11++) {
            if (dotsCount > 0) {
                addDot();
            } else {
                removeDot();
            }
        }
    }

    public void setIsClickable(boolean z10) {
        this.mIsClickable = z10;
    }

    public void setOnDotClickListener(OnIndicatorDotClickListener onIndicatorDotClickListener) {
        this.mOnDotClickListener = onIndicatorDotClickListener;
    }

    public void setPageIndicatorDotsColor(int i10) {
        this.mDotColor = i10;
        this.mDotPaint.setColor(i10);
        invalidate();
    }

    public void setTraceDotColor(int i10) {
        this.mTraceColor = i10;
        this.mTracePaint.setColor(i10);
        invalidate();
    }

    public COUIPageIndicator2(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.f6469g);
    }

    public void setCurrentPosition(int i10, float f10) {
        setCurrentPosition(i10, f10, false);
    }

    public COUIPageIndicator2(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, COUIContextUtil.isCOUIDarkTheme(context) ? l.f6718x : l.f6717w);
    }

    public void setCurrentPosition(int i10, float f10, boolean z10) {
        this.mModel.setCurrentPosition(i10, f10, z10);
        invalidate();
    }

    /* loaded from: classes.dex */
    public static class IndicatorSavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<IndicatorSavedState> CREATOR = new Parcelable.Creator<IndicatorSavedState>() { // from class: com.coui.appcompat.indicator.COUIPageIndicator2.IndicatorSavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public IndicatorSavedState createFromParcel(Parcel parcel) {
                return new IndicatorSavedState(parcel, IndicatorSavedState.class.getClassLoader());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public IndicatorSavedState[] newArray(int i10) {
                return new IndicatorSavedState[i10];
            }
        };
        float mCurrentPosition;
        int mDotsCount;

        public IndicatorSavedState(Parcel parcel) {
            super(parcel);
            this.mDotsCount = 0;
            this.mCurrentPosition = 0.0f;
            readFromParcel(parcel);
        }

        private void readFromParcel(Parcel parcel) {
            this.mDotsCount = parcel.readInt();
            this.mCurrentPosition = parcel.readFloat();
        }

        public String toString() {
            return "COUIPageIndicator2.IndicatorSavedState{" + Integer.toHexString(System.identityHashCode(this)) + "mDotsCount = " + this.mDotsCount + " mCurrentPosition = " + this.mCurrentPosition + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.mDotsCount);
            parcel.writeFloat(this.mCurrentPosition);
        }

        public IndicatorSavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.mDotsCount = 0;
            this.mCurrentPosition = 0.0f;
            readFromParcel(parcel);
        }

        public IndicatorSavedState(Parcelable parcelable) {
            super(parcelable);
            this.mDotsCount = 0;
            this.mCurrentPosition = 0.0f;
        }
    }

    public COUIPageIndicator2(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.mTouchPoint = new float[2];
        AccessibilityHelper accessibilityHelper = new AccessibilityHelper(this);
        this.mAccessibilityHelper = accessibilityHelper;
        this.mMoveFactorThreshold = 0.005f;
        this.mDownTime = 0L;
        if (attributeSet != null && attributeSet.getStyleAttribute() != 0) {
            this.mStyle = attributeSet.getStyleAttribute();
        } else {
            this.mStyle = i10;
        }
        COUIDarkModeUtil.setForceDarkAllow(this, false);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.f6859h1, i10, i11);
            this.mTraceColor = obtainStyledAttributes.getColor(m.f6887o1, 0);
            this.mDotColor = obtainStyledAttributes.getColor(m.f6867j1, 0);
            this.mNormalDotSize = obtainStyledAttributes.getDimension(m.f6871k1, 0.0f);
            this.mMediumDotSize = obtainStyledAttributes.getDimension(m.f6875l1, 0.0f);
            this.mSmallDotSize = obtainStyledAttributes.getDimension(m.f6879m1, 0.0f);
            this.mDotsInterval = obtainStyledAttributes.getDimension(m.f6883n1, 0.0f);
            this.mIsClickable = obtainStyledAttributes.getBoolean(m.f6863i1, true);
            obtainStyledAttributes.recycle();
        }
        buildModel();
        initPaints();
        K.j0(this, accessibilityHelper);
    }

    @Override // com.coui.appcompat.indicator.COUIIPagerIndicator
    public void onPageScrollStateChanged(int i10) {
    }

    @Override // com.coui.appcompat.indicator.COUIIPagerIndicator
    public void onPageSelected(int i10) {
    }
}
