package com.coui.appcompat.lockview;

import J.d;
import a9.b;
import a9.e;
import a9.k;
import a9.l;
import a9.m;
import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.core.view.K;
import androidx.customview.widget.a;
import com.coui.appcompat.animation.COUIEaseInterpolator;
import com.coui.appcompat.animation.COUIInEaseInterpolator;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import com.coui.appcompat.hapticfeedback.COUIHapticFeedbackConstants;
import com.coui.appcompat.vibrateutil.VibrateUtils;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class COUILockPatternView extends View {
    public static final long ALPHA_DELAY = 166;
    public static final long ALPHA_DURATION = 167;
    public static final long ALPHA_OFFSET = 16;
    private static final int ASPECT_LOCK_HEIGHT = 2;
    private static final int ASPECT_LOCK_WIDTH = 1;
    private static final int ASPECT_SQUARE = 0;
    public static final boolean DEBUG_A11Y = false;
    private static final float DRAG_THRESHHOLD = 0.0f;
    private static final int FEEDBACK_MIN_SIZE = 1;
    private static final float MAX_ALPHA = 255.0f;
    private static final int MILLIS_PER_CIRCLE_ANIMATING = 700;
    private static final boolean PROFILE_DRAWING = false;
    private static final String TAG = "COUILockPatternView";
    public static final long TRANSLATE_Y_DURATION = 500;
    public static final long TRANSLATE_Y_OFFSET = 16;
    public static final int VIRTUAL_BASE_VIEW_ID = 1;
    private AccessibilityManager mAccessibilityManagerService;
    private Interpolator mAlphaInterpolator;
    private long mAnimatingPeriodStart;
    private final CellState[][] mCellStates;
    private Context mContext;
    private final Path mCurrentPath;
    private int mDefaultHeight;
    private int mDefaultWidth;
    private boolean mDrawingProfilingStarted;
    private boolean mEnableHapticFeedback;
    private int mErrorColor;
    private PatternExploreByTouchHelper mExploreByTouchHelper;
    private final Interpolator mFastOutSlowInInterpolator;
    private float mHitFactor;
    private float mInProgressX;
    private float mInProgressY;
    private boolean mInStealthMode;
    private Drawable mInnerDrawable;
    private boolean mInputEnabled;
    private final Rect mInvalidate;
    private boolean mIsLinearMotorVersion;
    private boolean mIsSetPassword;
    private int mMaxTranslateY;
    private OnPatternListener mOnPatternListener;
    private float mOuterCircleMaxAlpha;
    private Drawable mOuterDrawable;
    private final Paint mPaint;
    private float mPathAlpha;
    private final Paint mPathPaint;
    private final int mPathWidth;
    private final ArrayList<Cell> mPattern;
    private DisplayMode mPatternDisplayMode;
    private final boolean[][] mPatternDrawLookup;
    private boolean mPatternInProgress;
    private int mRegularColor;
    private float mSquareHeight;
    private float mSquareWidth;
    private int mStyle;
    private int mSuccessColor;
    private final Rect mTmpInvalidateRect;
    private Interpolator mTranslateYInterpolator;
    private AnimatorListenerAdapter mWongAnimatorListener;
    private ValueAnimator mWrongAnimator;

    /* loaded from: classes.dex */
    public static final class Cell {
        private static final Cell[][] sCells = createCells();
        private final int column;
        private final int row;

        private Cell(int i10, int i11) {
            checkRange(i10, i11);
            this.row = i10;
            this.column = i11;
        }

        private static void checkRange(int i10, int i11) {
            if (i10 >= 0 && i10 <= 2) {
                if (i11 >= 0 && i11 <= 2) {
                    return;
                } else {
                    throw new IllegalArgumentException("column must be in range 0-2");
                }
            }
            throw new IllegalArgumentException("row must be in range 0-2");
        }

        private static Cell[][] createCells() {
            Cell[][] cellArr = (Cell[][]) Array.newInstance((Class<?>) Cell.class, 3, 3);
            for (int i10 = 0; i10 < 3; i10++) {
                for (int i11 = 0; i11 < 3; i11++) {
                    cellArr[i10][i11] = new Cell(i10, i11);
                }
            }
            return cellArr;
        }

        public static Cell of(int i10, int i11) {
            checkRange(i10, i11);
            return sCells[i10][i11];
        }

        public int getColumn() {
            return this.column;
        }

        public int getRow() {
            return this.row;
        }

        public String toString() {
            return "(row=" + this.row + ",clmn=" + this.column + ")";
        }
    }

    /* loaded from: classes.dex */
    public static class CellState {
        float alpha;
        OnCellDrawListener cellDrawListener;
        int col;
        float innerCircleAlpha;
        float innerCircleScale;
        public ValueAnimator lineAnimator;
        public float lineEndX = Float.MIN_VALUE;
        public float lineEndY = Float.MIN_VALUE;
        boolean needDrawCircle;
        float outerCircleAlpha;
        float outerCircleScale;
        float radius;
        int row;
        float translationX;
        float translationY;

        public void setCellDrawListener(OnCellDrawListener onCellDrawListener) {
            this.cellDrawListener = onCellDrawListener;
        }

        public void setCellNumberAlpha(float f10) {
            this.alpha = f10;
            this.cellDrawListener.drawCell();
        }

        public void setCellNumberTranslateX(int i10) {
            this.translationX = i10;
            this.cellDrawListener.drawCell();
        }

        public void setCellNumberTranslateY(int i10) {
            this.translationY = i10;
            this.cellDrawListener.drawCell();
        }
    }

    /* loaded from: classes.dex */
    public enum DisplayMode {
        Correct,
        Animate,
        Wrong,
        FingerprintMatch,
        FingerprintNoMatch
    }

    /* loaded from: classes.dex */
    public interface OnCellDrawListener {
        void drawCell();
    }

    /* loaded from: classes.dex */
    public interface OnPatternListener {
        void onPatternCellAdded(List<Cell> list);

        void onPatternCleared();

        void onPatternDetected(List<Cell> list);

        void onPatternStart();
    }

    /* loaded from: classes.dex */
    public final class PatternExploreByTouchHelper extends a {
        private final SparseArray<VirtualViewContainer> mItems;
        private Rect mTempRect;

        /* loaded from: classes.dex */
        public class VirtualViewContainer {
            CharSequence description;

            public VirtualViewContainer(CharSequence charSequence) {
                this.description = charSequence;
            }
        }

        public PatternExploreByTouchHelper(View view) {
            super(view);
            this.mTempRect = new Rect();
            this.mItems = new SparseArray<>();
            for (int i10 = 1; i10 < 10; i10++) {
                this.mItems.put(i10, new VirtualViewContainer(getTextForVirtualView(i10)));
            }
        }

        private Rect getBoundsForVirtualView(int i10) {
            int i11 = i10 - 1;
            Rect rect = this.mTempRect;
            int i12 = i11 / 3;
            float centerXForColumn = COUILockPatternView.this.getCenterXForColumn(i11 % 3);
            float centerYForRow = COUILockPatternView.this.getCenterYForRow(i12);
            float f10 = COUILockPatternView.this.mSquareHeight * COUILockPatternView.this.mHitFactor * 0.5f;
            float f11 = COUILockPatternView.this.mSquareWidth * COUILockPatternView.this.mHitFactor * 0.5f;
            rect.left = (int) (centerXForColumn - f11);
            rect.right = (int) (centerXForColumn + f11);
            rect.top = (int) (centerYForRow - f10);
            rect.bottom = (int) (centerYForRow + f10);
            return rect;
        }

        private CharSequence getTextForVirtualView(int i10) {
            return COUILockPatternView.this.getResources().getString(k.f6687m, String.valueOf(i10));
        }

        private int getVirtualViewIdForHit(float f10, float f11) {
            int columnHit;
            int rowHit = COUILockPatternView.this.getRowHit(f11);
            if (rowHit < 0 || (columnHit = COUILockPatternView.this.getColumnHit(f10)) < 0) {
                return Integer.MIN_VALUE;
            }
            boolean z10 = COUILockPatternView.this.mPatternDrawLookup[rowHit][columnHit];
            int i10 = (rowHit * 3) + columnHit + 1;
            if (!z10) {
                return Integer.MIN_VALUE;
            }
            return i10;
        }

        private boolean isClickable(int i10) {
            if (i10 != Integer.MIN_VALUE && i10 != Integer.MAX_VALUE) {
                int i11 = i10 - 1;
                return !COUILockPatternView.this.mPatternDrawLookup[i11 / 3][i11 % 3];
            }
            return false;
        }

        @Override // androidx.customview.widget.a
        public int getVirtualViewAt(float f10, float f11) {
            return getVirtualViewIdForHit(f10, f11);
        }

        @Override // androidx.customview.widget.a
        public void getVisibleVirtualViews(List<Integer> list) {
            if (!COUILockPatternView.this.mPatternInProgress) {
                return;
            }
            for (int i10 = 1; i10 < 10; i10++) {
                list.add(Integer.valueOf(i10));
            }
        }

        public boolean onItemClicked(int i10) {
            invalidateVirtualView(i10);
            sendEventForVirtualView(i10, 1);
            return true;
        }

        @Override // androidx.customview.widget.a
        public boolean onPerformActionForVirtualView(int i10, int i11, Bundle bundle) {
            if (i11 != 16) {
                return false;
            }
            return onItemClicked(i10);
        }

        @Override // androidx.core.view.C0446a
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            if (!COUILockPatternView.this.mPatternInProgress) {
                accessibilityEvent.setContentDescription(COUILockPatternView.this.getContext().getText(k.f6686l));
            }
        }

        @Override // androidx.customview.widget.a
        public void onPopulateEventForVirtualView(int i10, AccessibilityEvent accessibilityEvent) {
            VirtualViewContainer virtualViewContainer = this.mItems.get(i10);
            if (virtualViewContainer != null) {
                accessibilityEvent.getText().add(virtualViewContainer.description);
            }
        }

        @Override // androidx.customview.widget.a
        public void onPopulateNodeForVirtualView(int i10, d dVar) {
            dVar.K0(getTextForVirtualView(i10));
            dVar.l0(getTextForVirtualView(i10));
            if (COUILockPatternView.this.mPatternInProgress) {
                dVar.p0(true);
                if (isClickable(i10)) {
                    dVar.b(d.a.f1394i);
                    dVar.i0(isClickable(i10));
                }
            }
            dVar.c0(getBoundsForVirtualView(i10));
        }
    }

    public COUILockPatternView(Context context) {
        this(context, null);
    }

    private void addCellToPattern(Cell cell) {
        this.mPatternDrawLookup[cell.getRow()][cell.getColumn()] = true;
        this.mPattern.add(cell);
        if (!this.mInStealthMode) {
            startCellActivatedAnimation(cell);
        }
        notifyCellAdded();
    }

    private float calculateLastSegmentAlpha(float f10, float f11, float f12, float f13) {
        float f14 = f10 - f12;
        float f15 = f11 - f13;
        return Math.min(1.0f, Math.max(0.0f, ((((float) Math.sqrt((f14 * f14) + (f15 * f15))) / this.mSquareWidth) - 0.3f) * 4.0f));
    }

    private void cancelLineAnimations() {
        for (int i10 = 0; i10 < 3; i10++) {
            for (int i11 = 0; i11 < 3; i11++) {
                CellState cellState = this.mCellStates[i10][i11];
                ValueAnimator valueAnimator = cellState.lineAnimator;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                    cellState.lineEndX = Float.MIN_VALUE;
                    cellState.lineEndY = Float.MIN_VALUE;
                }
            }
        }
    }

    private Cell checkForNewHit(float f10, float f11) {
        int columnHit;
        int rowHit = getRowHit(f11);
        if (rowHit < 0 || (columnHit = getColumnHit(f10)) < 0 || this.mPatternDrawLookup[rowHit][columnHit]) {
            return null;
        }
        return Cell.of(rowHit, columnHit);
    }

    private void clearPatternDrawLookup() {
        for (int i10 = 0; i10 < 3; i10++) {
            for (int i11 = 0; i11 < 3; i11++) {
                this.mPatternDrawLookup[i10][i11] = false;
            }
        }
    }

    private Cell detectAndAddHit(float f10, float f11) {
        int i10;
        Cell checkForNewHit = checkForNewHit(f10, f11);
        Cell cell = null;
        if (checkForNewHit == null) {
            return null;
        }
        ArrayList<Cell> arrayList = this.mPattern;
        if (!arrayList.isEmpty()) {
            int i11 = 1;
            Cell cell2 = arrayList.get(arrayList.size() - 1);
            int i12 = checkForNewHit.row - cell2.row;
            int i13 = checkForNewHit.column - cell2.column;
            int i14 = cell2.row;
            int i15 = cell2.column;
            if (Math.abs(i12) == 2 && Math.abs(i13) != 1) {
                int i16 = cell2.row;
                if (i12 > 0) {
                    i10 = 1;
                } else {
                    i10 = -1;
                }
                i14 = i16 + i10;
            }
            if (Math.abs(i13) == 2 && Math.abs(i12) != 1) {
                int i17 = cell2.column;
                if (i13 <= 0) {
                    i11 = -1;
                }
                i15 = i17 + i11;
            }
            cell = Cell.of(i14, i15);
        }
        if (cell != null && !this.mPatternDrawLookup[cell.row][cell.column]) {
            addCellToPattern(cell);
        }
        addCellToPattern(checkForNewHit);
        if (this.mEnableHapticFeedback) {
            performHitFeedback();
        }
        return checkForNewHit;
    }

    private void drawCircle(Canvas canvas, float f10, float f11, float f12, boolean z10, float f13) {
        this.mPaint.setColor(this.mRegularColor);
        this.mPaint.setAlpha((int) (f13 * 255.0f));
        canvas.drawCircle(f10, f11, f12, this.mPaint);
    }

    private void drawCircleDrawable(Canvas canvas, float f10, float f11, float f12, float f13, float f14, float f15) {
        canvas.save();
        int intrinsicWidth = this.mInnerDrawable.getIntrinsicWidth();
        float f16 = intrinsicWidth / 2;
        int i10 = (int) (f10 - f16);
        int i11 = (int) (f11 - f16);
        canvas.scale(f12, f12, f10, f11);
        this.mInnerDrawable.setTint(getCurrentColor(true));
        this.mInnerDrawable.setBounds(i10, i11, i10 + intrinsicWidth, intrinsicWidth + i11);
        this.mInnerDrawable.setAlpha((int) (f13 * 255.0f));
        this.mInnerDrawable.draw(canvas);
        canvas.restore();
        canvas.save();
        int intrinsicWidth2 = this.mOuterDrawable.getIntrinsicWidth();
        float f17 = intrinsicWidth2 / 2;
        int i12 = (int) (f10 - f17);
        int i13 = (int) (f11 - f17);
        canvas.scale(f14, f14, f10, f11);
        this.mOuterDrawable.setTint(getCurrentColor(true));
        this.mOuterDrawable.setBounds(i12, i13, i12 + intrinsicWidth2, intrinsicWidth2 + i13);
        this.mOuterDrawable.setAlpha((int) (f15 * 255.0f));
        this.mOuterDrawable.draw(canvas);
        canvas.restore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getCenterXForColumn(int i10) {
        float paddingLeft = getPaddingLeft();
        float f10 = this.mSquareWidth;
        return paddingLeft + (i10 * f10) + (f10 / 2.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getCenterYForRow(int i10) {
        float paddingTop = getPaddingTop();
        float f10 = this.mSquareHeight;
        return paddingTop + (i10 * f10) + (f10 / 2.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getColumnHit(float f10) {
        float f11 = this.mSquareWidth;
        float f12 = this.mHitFactor * f11;
        float paddingLeft = getPaddingLeft() + ((f11 - f12) / 2.0f);
        for (int i10 = 0; i10 < 3; i10++) {
            float f13 = (i10 * f11) + paddingLeft;
            if (f10 >= f13 && f10 <= f13 + f12) {
                return i10;
            }
        }
        return -1;
    }

    private int getCurrentColor(boolean z10) {
        DisplayMode displayMode = this.mPatternDisplayMode;
        if (displayMode != DisplayMode.Wrong && displayMode != DisplayMode.FingerprintNoMatch) {
            if (displayMode != DisplayMode.Correct && displayMode != DisplayMode.Animate && displayMode != DisplayMode.FingerprintMatch) {
                if (z10 && !this.mInStealthMode && !this.mPatternInProgress) {
                    throw new IllegalStateException("unknown display mode " + this.mPatternDisplayMode);
                }
                return this.mRegularColor;
            }
            return this.mSuccessColor;
        }
        return this.mErrorColor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRowHit(float f10) {
        float f11 = this.mSquareHeight;
        float f12 = this.mHitFactor * f11;
        float paddingTop = getPaddingTop() + ((f11 - f12) / 2.0f);
        for (int i10 = 0; i10 < 3; i10++) {
            float f13 = (i10 * f11) + paddingTop;
            if (f10 >= f13 && f10 <= f13 + f12) {
                return i10;
            }
        }
        return -1;
    }

    private void handleActionDown(MotionEvent motionEvent) {
        this.mPathAlpha = 1.0f;
        resetPattern();
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        Cell detectAndAddHit = detectAndAddHit(x10, y10);
        if (detectAndAddHit != null) {
            setPatternInProgress(true);
            this.mPatternDisplayMode = DisplayMode.Correct;
            notifyPatternStarted();
        } else if (this.mPatternInProgress) {
            setPatternInProgress(false);
            notifyPatternCleared();
        }
        if (detectAndAddHit != null) {
            float centerXForColumn = getCenterXForColumn(detectAndAddHit.column);
            float centerYForRow = getCenterYForRow(detectAndAddHit.row);
            float f10 = this.mSquareWidth / 2.0f;
            float f11 = this.mSquareHeight / 2.0f;
            invalidate((int) (centerXForColumn - f10), (int) (centerYForRow - f11), (int) (centerXForColumn + f10), (int) (centerYForRow + f11));
        }
        this.mInProgressX = x10;
        this.mInProgressY = y10;
    }

    private void handleActionMove(MotionEvent motionEvent) {
        float x10;
        float y10;
        float f10 = this.mPathWidth;
        int historySize = motionEvent.getHistorySize();
        this.mTmpInvalidateRect.setEmpty();
        boolean z10 = false;
        for (int i10 = 0; i10 < historySize + 1; i10++) {
            if (i10 < historySize) {
                x10 = motionEvent.getHistoricalX(i10);
            } else {
                x10 = motionEvent.getX();
            }
            if (i10 < historySize) {
                y10 = motionEvent.getHistoricalY(i10);
            } else {
                y10 = motionEvent.getY();
            }
            Cell detectAndAddHit = detectAndAddHit(x10, y10);
            int size = this.mPattern.size();
            if (detectAndAddHit != null && size == 1) {
                setPatternInProgress(true);
                notifyPatternStarted();
            }
            float abs = Math.abs(x10 - this.mInProgressX);
            float abs2 = Math.abs(y10 - this.mInProgressY);
            if (abs > 0.0f || abs2 > 0.0f) {
                z10 = true;
            }
            if (this.mPatternInProgress && size > 0) {
                Cell cell = this.mPattern.get(size - 1);
                float centerXForColumn = getCenterXForColumn(cell.column);
                float centerYForRow = getCenterYForRow(cell.row);
                float min = Math.min(centerXForColumn, x10) - f10;
                float max = Math.max(centerXForColumn, x10) + f10;
                float min2 = Math.min(centerYForRow, y10) - f10;
                float max2 = Math.max(centerYForRow, y10) + f10;
                if (detectAndAddHit != null) {
                    float f11 = this.mSquareWidth * 0.5f;
                    float f12 = this.mSquareHeight * 0.5f;
                    float centerXForColumn2 = getCenterXForColumn(detectAndAddHit.column);
                    float centerYForRow2 = getCenterYForRow(detectAndAddHit.row);
                    min = Math.min(centerXForColumn2 - f11, min);
                    max = Math.max(centerXForColumn2 + f11, max);
                    min2 = Math.min(centerYForRow2 - f12, min2);
                    max2 = Math.max(centerYForRow2 + f12, max2);
                }
                this.mTmpInvalidateRect.union(Math.round(min), Math.round(min2), Math.round(max), Math.round(max2));
            }
        }
        this.mInProgressX = motionEvent.getX();
        this.mInProgressY = motionEvent.getY();
        if (z10) {
            this.mInvalidate.union(this.mTmpInvalidateRect);
            invalidate(this.mInvalidate);
            this.mInvalidate.set(this.mTmpInvalidateRect);
        }
    }

    private void handleActionUp() {
        if (!this.mPattern.isEmpty()) {
            setPatternInProgress(false);
            cancelLineAnimations();
            notifyPatternDetected();
            invalidate();
        }
    }

    private void initCellAnim(CellState cellState, List<Animator> list, int i10) {
        cellState.setCellNumberAlpha(0.0f);
        cellState.setCellNumberTranslateY(this.mMaxTranslateY);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(cellState, "cellNumberAlpha", 0.0f, Color.alpha(this.mRegularColor) / 255.0f);
        long j10 = i10 * 16;
        ofFloat.setStartDelay(166 + j10);
        ofFloat.setDuration(167L);
        ofFloat.setInterpolator(this.mAlphaInterpolator);
        list.add(ofFloat);
        ObjectAnimator ofInt = ObjectAnimator.ofInt(cellState, "cellNumberTranslateY", this.mMaxTranslateY, 0);
        ofInt.setStartDelay(j10);
        ofInt.setDuration(500L);
        ofInt.setInterpolator(this.mTranslateYInterpolator);
        list.add(ofInt);
    }

    private void notifyCellAdded() {
        OnPatternListener onPatternListener = this.mOnPatternListener;
        if (onPatternListener != null) {
            onPatternListener.onPatternCellAdded(this.mPattern);
        }
        this.mExploreByTouchHelper.invalidateRoot();
    }

    private void notifyPatternCleared() {
        sendAccessEvent(k.f6688n);
        OnPatternListener onPatternListener = this.mOnPatternListener;
        if (onPatternListener != null) {
            onPatternListener.onPatternCleared();
        }
    }

    private void notifyPatternDetected() {
        sendAccessEvent(k.f6689o);
        OnPatternListener onPatternListener = this.mOnPatternListener;
        if (onPatternListener != null) {
            onPatternListener.onPatternDetected(this.mPattern);
        }
    }

    private void notifyPatternStarted() {
        sendAccessEvent(k.f6690p);
        OnPatternListener onPatternListener = this.mOnPatternListener;
        if (onPatternListener != null) {
            onPatternListener.onPatternStart();
        }
    }

    private void performHitFeedback() {
        if (this.mIsLinearMotorVersion) {
            performHapticFeedback(COUIHapticFeedbackConstants.GRANULAR_SHORT_VIBRATE);
        } else {
            performHapticFeedback(1);
        }
    }

    private void performWrongModeFeedback() {
        if (!this.mEnableHapticFeedback) {
            return;
        }
        if (this.mIsLinearMotorVersion) {
            performHapticFeedback(304, 3);
        } else {
            performHapticFeedback(300, 3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetPattern() {
        this.mPattern.clear();
        clearPatternDrawLookup();
        this.mPatternDisplayMode = DisplayMode.Correct;
        invalidate();
    }

    private int resolveMeasured(int i10, int i11) {
        int size = View.MeasureSpec.getSize(i10);
        int mode = View.MeasureSpec.getMode(i10);
        if (mode != Integer.MIN_VALUE) {
            if (mode != 0) {
                return size;
            }
            return i11;
        }
        return Math.max(size, i11);
    }

    private void sendAccessEvent(int i10) {
        announceForAccessibility(this.mContext.getString(i10));
    }

    private void setPatternInProgress(boolean z10) {
        this.mPatternInProgress = z10;
        this.mExploreByTouchHelper.invalidateRoot();
    }

    private void startCellActivatedAnimation(Cell cell) {
        CellState cellState = this.mCellStates[cell.row][cell.column];
        startOuterAnimation(cellState);
        startInnerAnimation(cellState);
        startLineEndAnimation(cellState, this.mInProgressX, this.mInProgressY, getCenterXForColumn(cell.column), getCenterYForRow(cell.row));
    }

    private void startFingerprintNoMatchAnimator() {
        ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofKeyframe("pathAlpha", Keyframe.ofFloat(0.0f, 1.0f), Keyframe.ofFloat(0.2f, 0.35f), Keyframe.ofFloat(0.4f, 1.0f), Keyframe.ofFloat(0.6f, 0.15f), Keyframe.ofFloat(0.8f, 0.5f), Keyframe.ofFloat(1.0f, 0.0f)));
        ofPropertyValuesHolder.setDuration(1000L);
        ofPropertyValuesHolder.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.lockview.COUILockPatternView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                boolean z10;
                for (int i10 = 0; i10 < 3; i10++) {
                    for (int i11 = 0; i11 < 3; i11++) {
                        CellState cellState = COUILockPatternView.this.mCellStates[i10][i11];
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        cellState.innerCircleAlpha = floatValue;
                        if (floatValue <= 0.1f) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        cellState.needDrawCircle = z10;
                    }
                }
                COUILockPatternView.this.invalidate();
            }
        });
        ofPropertyValuesHolder.start();
    }

    private void startInnerAnimation(final CellState cellState) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setInterpolator(new COUIEaseInterpolator());
        ofFloat.setDuration(230L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.lockview.COUILockPatternView.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                cellState.innerCircleAlpha = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        ofFloat.start();
    }

    private void startLineEndAnimation(final CellState cellState, final float f10, final float f11, final float f12, final float f13) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.lockview.COUILockPatternView.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CellState cellState2 = cellState;
                float f14 = 1.0f - floatValue;
                cellState2.lineEndX = (f10 * f14) + (f12 * floatValue);
                cellState2.lineEndY = (f14 * f11) + (floatValue * f13);
                COUILockPatternView.this.invalidate();
            }
        });
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.coui.appcompat.lockview.COUILockPatternView.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                cellState.lineAnimator = null;
            }
        });
        ofFloat.setInterpolator(this.mFastOutSlowInInterpolator);
        ofFloat.setDuration(100L);
        ofFloat.start();
        cellState.lineAnimator = ofFloat;
    }

    private void startOuterAnimation(final CellState cellState) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(460L);
        animatorSet.setInterpolator(new COUIInEaseInterpolator());
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 7.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.lockview.COUILockPatternView.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                cellState.outerCircleScale = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                COUILockPatternView.this.invalidate();
            }
        });
        ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofKeyframe("alpha", Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.5f, this.mOuterCircleMaxAlpha), Keyframe.ofFloat(1.0f, 0.0f)));
        ofPropertyValuesHolder.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.lockview.COUILockPatternView.8
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                cellState.outerCircleAlpha = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                COUILockPatternView.this.invalidate();
            }
        });
        animatorSet.play(ofFloat).with(ofPropertyValuesHolder);
        animatorSet.start();
    }

    private void startWrongAnimator() {
        ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofKeyframe("pathAlpha", Keyframe.ofFloat(0.0f, 1.0f), Keyframe.ofFloat(0.2f, 0.35f), Keyframe.ofFloat(0.4f, 1.0f), Keyframe.ofFloat(0.6f, 0.15f), Keyframe.ofFloat(0.8f, 0.5f), Keyframe.ofFloat(1.0f, 0.0f)));
        this.mWrongAnimator = ofPropertyValuesHolder;
        ofPropertyValuesHolder.setDuration(1000L);
        this.mWrongAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.lockview.COUILockPatternView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                boolean z10;
                COUILockPatternView.this.mPathAlpha = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                Iterator it = COUILockPatternView.this.mPattern.iterator();
                while (it.hasNext()) {
                    Cell cell = (Cell) it.next();
                    CellState cellState = COUILockPatternView.this.mCellStates[cell.row][cell.column];
                    cellState.innerCircleAlpha = COUILockPatternView.this.mPathAlpha;
                    if (COUILockPatternView.this.mPathAlpha <= 0.1f) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    cellState.needDrawCircle = z10;
                }
                COUILockPatternView.this.invalidate();
            }
        });
        this.mWrongAnimator.start();
    }

    @Deprecated
    public void clearPattern(boolean z10) {
    }

    public void disableInput() {
        this.mInputEnabled = false;
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return this.mExploreByTouchHelper.dispatchHoverEvent(motionEvent) | super.dispatchHoverEvent(motionEvent);
    }

    public void enableInput() {
        this.mInputEnabled = true;
    }

    public CellState[][] getCellStates() {
        return this.mCellStates;
    }

    public AnimatorSet getEnterAnim() {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < 3; i10++) {
            for (int i11 = 0; i11 < 3; i11++) {
                initCellAnim(this.mCellStates[i10][i11], arrayList, (i10 * 3) + i11);
            }
        }
        animatorSet.playTogether(arrayList);
        return animatorSet;
    }

    @Deprecated
    public Animator getFailAnimator() {
        return ValueAnimator.ofFloat(0.0f, 1.0f);
    }

    @Deprecated
    public Animator getSuccessAnimator() {
        return ValueAnimator.ofInt(255, 0);
    }

    public boolean isInStealthMode() {
        return this.mInStealthMode;
    }

    public boolean isSetLockPassword() {
        return this.mIsSetPassword;
    }

    public boolean isTactileFeedbackEnabled() {
        return this.mEnableHapticFeedback;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.mWrongAnimator;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.mWrongAnimator.removeAllListeners();
            this.mWrongAnimator = null;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float f10;
        float f11;
        float f12;
        CellState cellState;
        COUILockPatternView cOUILockPatternView = this;
        ArrayList<Cell> arrayList = cOUILockPatternView.mPattern;
        int size = arrayList.size();
        boolean[][] zArr = cOUILockPatternView.mPatternDrawLookup;
        if (cOUILockPatternView.mPatternDisplayMode == DisplayMode.Animate) {
            int elapsedRealtime = (((int) (SystemClock.elapsedRealtime() - cOUILockPatternView.mAnimatingPeriodStart)) % ((size + 1) * 700)) / 700;
            clearPatternDrawLookup();
            for (int i10 = 0; i10 < elapsedRealtime; i10++) {
                Cell cell = arrayList.get(i10);
                zArr[cell.getRow()][cell.getColumn()] = true;
            }
            if (elapsedRealtime > 0 && elapsedRealtime < size) {
                float f13 = (r3 % 700) / 700.0f;
                Cell cell2 = arrayList.get(elapsedRealtime - 1);
                float centerXForColumn = cOUILockPatternView.getCenterXForColumn(cell2.column);
                float centerYForRow = cOUILockPatternView.getCenterYForRow(cell2.row);
                Cell cell3 = arrayList.get(elapsedRealtime);
                float centerXForColumn2 = (cOUILockPatternView.getCenterXForColumn(cell3.column) - centerXForColumn) * f13;
                float centerYForRow2 = f13 * (cOUILockPatternView.getCenterYForRow(cell3.row) - centerYForRow);
                cOUILockPatternView.mInProgressX = centerXForColumn + centerXForColumn2;
                cOUILockPatternView.mInProgressY = centerYForRow + centerYForRow2;
            }
            invalidate();
        }
        Path path = cOUILockPatternView.mCurrentPath;
        path.rewind();
        if (!cOUILockPatternView.mInStealthMode) {
            cOUILockPatternView.mPathPaint.setColor(cOUILockPatternView.getCurrentColor(true));
            cOUILockPatternView.mPathPaint.setAlpha((int) (cOUILockPatternView.mPathAlpha * 255.0f));
            float f14 = 0.0f;
            float f15 = 0.0f;
            int i11 = 0;
            boolean z10 = false;
            while (i11 < size) {
                Cell cell4 = arrayList.get(i11);
                if (!zArr[cell4.row][cell4.column]) {
                    break;
                }
                f14 = cOUILockPatternView.getCenterXForColumn(cell4.column);
                f15 = cOUILockPatternView.getCenterYForRow(cell4.row);
                if (i11 == 0) {
                    path.rewind();
                    path.moveTo(f14, f15);
                }
                if (i11 != 0) {
                    CellState cellState2 = cOUILockPatternView.mCellStates[cell4.row][cell4.column];
                    float f16 = cellState2.lineEndX;
                    if (f16 != Float.MIN_VALUE) {
                        float f17 = cellState2.lineEndY;
                        if (f17 != Float.MIN_VALUE) {
                            path.lineTo(f16, f17);
                        }
                    }
                    path.lineTo(f14, f15);
                }
                i11++;
                z10 = true;
            }
            if ((cOUILockPatternView.mPatternInProgress || cOUILockPatternView.mPatternDisplayMode == DisplayMode.Animate) && z10) {
                path.moveTo(f14, f15);
                path.lineTo(cOUILockPatternView.mInProgressX, cOUILockPatternView.mInProgressY);
            }
            canvas.drawPath(path, cOUILockPatternView.mPathPaint);
        }
        int i12 = 0;
        while (true) {
            int i13 = 3;
            if (i12 < 3) {
                float centerYForRow3 = cOUILockPatternView.getCenterYForRow(i12);
                int i14 = 0;
                while (i14 < i13) {
                    CellState cellState3 = cOUILockPatternView.mCellStates[i12][i14];
                    float centerXForColumn3 = cOUILockPatternView.getCenterXForColumn(i14);
                    float f18 = cellState3.translationY;
                    float f19 = cellState3.translationX;
                    boolean z11 = zArr[i12][i14];
                    if (!z11 && cOUILockPatternView.mPatternDisplayMode != DisplayMode.FingerprintNoMatch) {
                        f10 = f19;
                        f11 = f18;
                        f12 = centerXForColumn3;
                        cellState = cellState3;
                    } else {
                        f10 = f19;
                        f11 = f18;
                        f12 = centerXForColumn3;
                        cellState = cellState3;
                        drawCircleDrawable(canvas, ((int) centerXForColumn3) + f19, ((int) centerYForRow3) + f18, cellState3.innerCircleScale, cellState3.innerCircleAlpha, cellState3.outerCircleScale, cellState3.outerCircleAlpha);
                    }
                    if (cellState.needDrawCircle) {
                        drawCircle(canvas, ((int) f12) + f10, ((int) centerYForRow3) + f11, cellState.radius, z11, cellState.alpha);
                    }
                    i14++;
                    i13 = 3;
                    cOUILockPatternView = this;
                }
                i12++;
                cOUILockPatternView = this;
            } else {
                return;
            }
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (this.mAccessibilityManagerService.isTouchExplorationEnabled()) {
            int action = motionEvent.getAction();
            if (action != 7) {
                if (action != 9) {
                    if (action == 10) {
                        motionEvent.setAction(1);
                    }
                } else {
                    motionEvent.setAction(0);
                }
            } else {
                motionEvent.setAction(2);
            }
            onTouchEvent(motionEvent);
            motionEvent.setAction(action);
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int size2 = View.MeasureSpec.getSize(i11);
        if (mode == Integer.MIN_VALUE) {
            size = this.mDefaultWidth;
        }
        if (mode2 == Integer.MIN_VALUE) {
            size2 = this.mDefaultHeight;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setPattern(DisplayMode.Correct, COUILockPatternUtils.stringToPattern(savedState.getSerializedPattern()));
        this.mPatternDisplayMode = DisplayMode.values()[savedState.getDisplayMode()];
        this.mInputEnabled = savedState.isInputEnabled();
        this.mInStealthMode = savedState.isInStealthMode();
        this.mEnableHapticFeedback = savedState.isTactileFeedbackEnabled();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), COUILockPatternUtils.patternToString(this.mPattern), this.mPatternDisplayMode.ordinal(), this.mInputEnabled, this.mInStealthMode, this.mEnableHapticFeedback);
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        this.mSquareWidth = ((i10 - getPaddingLeft()) - getPaddingRight()) / 3.0f;
        this.mSquareHeight = ((i11 - getPaddingTop()) - getPaddingBottom()) / 3.0f;
        this.mExploreByTouchHelper.invalidateRoot();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mInputEnabled || !isEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        return false;
                    }
                    if (this.mPatternInProgress) {
                        setPatternInProgress(false);
                        resetPattern();
                        notifyPatternCleared();
                    }
                    return true;
                }
                handleActionMove(motionEvent);
                return true;
            }
            handleActionUp();
            return true;
        }
        ValueAnimator valueAnimator = this.mWrongAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mWrongAnimator.end();
        }
        handleActionDown(motionEvent);
        return true;
    }

    public void refresh() {
        String resourceTypeName = getResources().getResourceTypeName(this.mStyle);
        TypedArray typedArray = null;
        if ("attr".equals(resourceTypeName)) {
            typedArray = this.mContext.obtainStyledAttributes(null, m.f6874l0, this.mStyle, 0);
        } else if ("style".equals(resourceTypeName)) {
            typedArray = this.mContext.obtainStyledAttributes(null, m.f6874l0, 0, this.mStyle);
        }
        if (typedArray != null) {
            this.mRegularColor = typedArray.getColor(m.f6890p0, 0);
            this.mErrorColor = typedArray.getColor(m.f6878m0, 0);
            this.mSuccessColor = typedArray.getColor(m.f6894q0, 0);
            this.mPathPaint.setColor(typedArray.getColor(m.f6886o0, this.mRegularColor));
            this.mOuterCircleMaxAlpha = typedArray.getFloat(m.f6882n0, 0.0f);
            typedArray.recycle();
        }
    }

    public void setDisplayMode(DisplayMode displayMode) {
        setDisplayMode(displayMode, true);
    }

    public void setErrorColor(int i10) {
        this.mErrorColor = i10;
    }

    public void setInStealthMode(boolean z10) {
        this.mInStealthMode = z10;
    }

    public void setLockPassword(boolean z10) {
        this.mIsSetPassword = z10;
    }

    public void setOnPatternListener(OnPatternListener onPatternListener) {
        this.mOnPatternListener = onPatternListener;
    }

    public void setOuterCircleMaxAlpha(int i10) {
        this.mOuterCircleMaxAlpha = i10;
    }

    public void setPathColor(int i10) {
        this.mPathPaint.setColor(i10);
    }

    public void setPattern(DisplayMode displayMode, List<Cell> list) {
        this.mPattern.clear();
        this.mPattern.addAll(list);
        clearPatternDrawLookup();
        for (Cell cell : list) {
            this.mPatternDrawLookup[cell.getRow()][cell.getColumn()] = true;
        }
        setDisplayMode(displayMode);
    }

    public void setRegularColor(int i10) {
        this.mRegularColor = i10;
    }

    public void setSuccessColor(int i10) {
        this.mSuccessColor = i10;
    }

    public void setTactileFeedbackEnabled(boolean z10) {
        this.mEnableHapticFeedback = z10;
    }

    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.coui.appcompat.lockview.COUILockPatternView.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        };
        private final int mDisplayMode;
        private final boolean mInStealthMode;
        private final boolean mInputEnabled;
        private final String mSerializedPattern;
        private final boolean mTactileFeedbackEnabled;

        public int getDisplayMode() {
            return this.mDisplayMode;
        }

        public String getSerializedPattern() {
            return this.mSerializedPattern;
        }

        public boolean isInStealthMode() {
            return this.mInStealthMode;
        }

        public boolean isInputEnabled() {
            return this.mInputEnabled;
        }

        public boolean isTactileFeedbackEnabled() {
            return this.mTactileFeedbackEnabled;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeString(this.mSerializedPattern);
            parcel.writeInt(this.mDisplayMode);
            parcel.writeValue(Boolean.valueOf(this.mInputEnabled));
            parcel.writeValue(Boolean.valueOf(this.mInStealthMode));
            parcel.writeValue(Boolean.valueOf(this.mTactileFeedbackEnabled));
        }

        private SavedState(Parcelable parcelable, String str, int i10, boolean z10, boolean z11, boolean z12) {
            super(parcelable);
            this.mSerializedPattern = str;
            this.mDisplayMode = i10;
            this.mInputEnabled = z10;
            this.mInStealthMode = z11;
            this.mTactileFeedbackEnabled = z12;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.mSerializedPattern = parcel.readString();
            this.mDisplayMode = parcel.readInt();
            this.mInputEnabled = ((Boolean) parcel.readValue(null)).booleanValue();
            this.mInStealthMode = ((Boolean) parcel.readValue(null)).booleanValue();
            this.mTactileFeedbackEnabled = ((Boolean) parcel.readValue(null)).booleanValue();
        }
    }

    public COUILockPatternView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPathAlpha = 1.0f;
        this.mDrawingProfilingStarted = false;
        Paint paint = new Paint();
        this.mPaint = paint;
        Paint paint2 = new Paint();
        this.mPathPaint = paint2;
        this.mPattern = new ArrayList<>(9);
        this.mPatternDrawLookup = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, 3, 3);
        this.mInProgressX = -1.0f;
        this.mInProgressY = -1.0f;
        this.mPatternDisplayMode = DisplayMode.Correct;
        this.mInputEnabled = true;
        this.mInStealthMode = false;
        this.mEnableHapticFeedback = true;
        this.mPatternInProgress = false;
        this.mHitFactor = 0.6f;
        this.mCurrentPath = new Path();
        this.mInvalidate = new Rect();
        this.mTmpInvalidateRect = new Rect();
        this.mIsSetPassword = false;
        this.mAlphaInterpolator = new COUIEaseInterpolator();
        this.mTranslateYInterpolator = new COUIInEaseInterpolator();
        this.mWongAnimatorListener = new AnimatorListenerAdapter() { // from class: com.coui.appcompat.lockview.COUILockPatternView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                COUILockPatternView.this.resetPattern();
                if (COUILockPatternView.this.mWrongAnimator != null) {
                    COUILockPatternView.this.mWrongAnimator.removeAllListeners();
                }
            }
        };
        if (attributeSet != null && attributeSet.getStyleAttribute() != 0) {
            this.mStyle = attributeSet.getStyleAttribute();
        } else {
            this.mStyle = b.f6466d;
        }
        this.mContext = context;
        COUIDarkModeUtil.setForceDarkAllow(this, false);
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.f6874l0, b.f6466d, COUIContextUtil.isCOUIDarkTheme(context) ? l.f6715u : l.f6714t);
        setClickable(true);
        paint2.setAntiAlias(true);
        paint2.setDither(true);
        this.mRegularColor = obtainStyledAttributes.getColor(m.f6890p0, 0);
        this.mErrorColor = obtainStyledAttributes.getColor(m.f6878m0, 0);
        this.mSuccessColor = obtainStyledAttributes.getColor(m.f6894q0, 0);
        paint2.setColor(obtainStyledAttributes.getColor(m.f6886o0, this.mRegularColor));
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeJoin(Paint.Join.ROUND);
        paint2.setStrokeCap(Paint.Cap.ROUND);
        int dimensionPixelSize = getResources().getDimensionPixelSize(a9.d.f6555c1);
        this.mPathWidth = dimensionPixelSize;
        paint2.setStrokeWidth(dimensionPixelSize);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(a9.d.f6558d1);
        paint.setAntiAlias(true);
        paint.setDither(true);
        this.mMaxTranslateY = getResources().getDimensionPixelSize(a9.d.f6580n);
        this.mCellStates = (CellState[][]) Array.newInstance((Class<?>) CellState.class, 3, 3);
        for (int i10 = 0; i10 < 3; i10++) {
            for (int i11 = 0; i11 < 3; i11++) {
                this.mCellStates[i10][i11] = new CellState();
                CellState cellState = this.mCellStates[i10][i11];
                cellState.radius = dimensionPixelSize2 / 2;
                cellState.row = i10;
                cellState.col = i11;
                cellState.alpha = Color.alpha(this.mRegularColor) / 255.0f;
                CellState cellState2 = this.mCellStates[i10][i11];
                cellState2.innerCircleAlpha = 0.0f;
                cellState2.innerCircleScale = 1.0f;
                cellState2.outerCircleAlpha = 0.0f;
                cellState2.outerCircleScale = 1.0f;
                cellState2.needDrawCircle = true;
                cellState2.setCellDrawListener(new OnCellDrawListener() { // from class: com.coui.appcompat.lockview.COUILockPatternView.1
                    @Override // com.coui.appcompat.lockview.COUILockPatternView.OnCellDrawListener
                    public void drawCell() {
                        COUILockPatternView.this.invalidate();
                    }
                });
            }
        }
        this.mInnerDrawable = getResources().getDrawable(e.f6606a);
        this.mOuterDrawable = getResources().getDrawable(e.f6607b);
        this.mDefaultWidth = getResources().getDimensionPixelSize(a9.d.f6497B);
        this.mDefaultHeight = getResources().getDimensionPixelSize(a9.d.f6495A);
        this.mOuterCircleMaxAlpha = obtainStyledAttributes.getFloat(m.f6882n0, 0.0f);
        this.mFastOutSlowInInterpolator = AnimationUtils.loadInterpolator(context, R.interpolator.fast_out_slow_in);
        PatternExploreByTouchHelper patternExploreByTouchHelper = new PatternExploreByTouchHelper(this);
        this.mExploreByTouchHelper = patternExploreByTouchHelper;
        K.j0(this, patternExploreByTouchHelper);
        this.mAccessibilityManagerService = (AccessibilityManager) this.mContext.getSystemService("accessibility");
        obtainStyledAttributes.recycle();
        this.mIsLinearMotorVersion = VibrateUtils.isLinearMotorVersion(context);
    }

    public void clearPattern() {
        ValueAnimator valueAnimator = this.mWrongAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mWrongAnimator.addListener(this.mWongAnimatorListener);
        } else {
            resetPattern();
        }
    }

    public void setDisplayMode(DisplayMode displayMode, boolean z10) {
        this.mPatternDisplayMode = displayMode;
        if (displayMode == DisplayMode.Animate) {
            if (this.mPattern.size() != 0) {
                this.mAnimatingPeriodStart = SystemClock.elapsedRealtime();
                Cell cell = this.mPattern.get(0);
                this.mInProgressX = getCenterXForColumn(cell.getColumn());
                this.mInProgressY = getCenterYForRow(cell.getRow());
                clearPatternDrawLookup();
            } else {
                throw new IllegalStateException("you must have a pattern to animate if you want to set the display mode to animate");
            }
        }
        if (displayMode == DisplayMode.Wrong) {
            if (z10 && this.mPattern.size() > 1) {
                performWrongModeFeedback();
            }
            startWrongAnimator();
        }
        if (displayMode == DisplayMode.FingerprintNoMatch) {
            startFingerprintNoMatchAnimator();
        }
        invalidate();
    }

    @Deprecated
    public void setSuccessFinger() {
    }
}
