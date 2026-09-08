package com.coui.appcompat.lockview;

import J.d;
import a9.C0426a;
import a9.b;
import a9.e;
import a9.g;
import a9.k;
import a9.l;
import a9.m;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.core.view.K;
import androidx.customview.widget.a;
import com.coui.appcompat.animation.COUIEaseInterpolator;
import com.coui.appcompat.animation.COUIInEaseInterpolator;
import com.coui.appcompat.animation.COUIOutEaseInterpolator;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import com.coui.appcompat.hapticfeedback.COUIHapticFeedbackConstants;
import com.coui.appcompat.log.COUILog;
import com.coui.appcompat.vibrateutil.VibrateUtils;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class COUINumericKeyboard extends View {
    public static final long ALPHA_DELAY = 166;
    public static final long ALPHA_DURATION = 167;
    public static final long ALPHA_OFFSET = 16;
    private static final float BLUR_END_SCALE = 2.0f;
    private static final float BLUR_START_SCALE = 1.0f;
    public static final int CELL_COLUMN_COUNT = 3;
    public static final int CELL_ROW_COUNT = 4;
    public static final float DEFAULT_ALPHA_VALUE = 255.0f;
    private static final int ELEVEN = 11;

    @Deprecated
    public static final int EMPTY_NINE_AND_ELEVEN = 1;
    private static final int FADE_ANIMATOR_TIME = 160;
    private static final int FADE_BLUR_ANIMATOR_TIME = 400;
    private static final float FADE_END_SCALE = 2.5f;
    private static final float FADE_START_SCALE = 2.15f;
    public static final int FONT_VARIATION_DEFAULT = 550;
    public static final int FONT_VARIATION_DEFAULT_PLUS = 200;
    public static final String FONT_VARIATION_SETTINGS = "font_variation_settings";
    private static final int KEYCODE_0_COLUMN = 1;
    private static final int KEYCODE_0_ROW = 3;
    private static final int NINE = 9;

    @Deprecated
    public static final int RETAIN_ELEVEN = 3;

    @Deprecated
    public static final int RETAIN_NINE = 2;
    private static final int SHOW_ANIMATOR_TIME = 100;
    private static final float SHOW_END_SCALE = 2.15f;
    private static final float SHOW_START_SCALE = 1.0f;
    public static final int SIDE_TYPE_DELETE = 1;
    public static final int SIDE_TYPE_FINISH = 2;
    public static final int SIDE_TYPE_NONE = 0;
    private static final String TAG = "COUINumericKeyboard";
    private static final int TEN = 10;
    public static final long TRANSLATE_Y_DURATION = 500;
    public static final long TRANSLATE_Y_OFFSET = 16;

    @Deprecated
    public int NUMERIC;

    @Deprecated
    public int WORD;
    private final AccessibilityManager mAccessibilityManagerService;
    private int mAdditionalPressableArea;
    private Interpolator mAlphaInterpolator;
    private int mCellHeight;
    private int mCellWidth;
    private float mCircleMaxAlpha;
    private int mCircleRadius;
    private Context mContext;
    private Typeface mCustomTypeface;
    private int mDefaultHeight;
    private int mDefaultWidth;
    public SideStyle mDeleteStyle;
    private boolean mDownState;
    private float mDrawableAlpha;
    private int mDrawableTranslateX;
    private int mDrawableTranslateY;
    private boolean mEnableHapticFeedback;
    private PatternExploreByTouchHelper mExploreByTouchHelper;
    public final SideStyle mFinishStyle;
    public int mFontVariationDefaultPlus;
    private boolean mHasCustomTypeface;
    private int mHorizontalSpacing;
    private boolean mIsLinearMotorVersion;
    private Drawable mKeyboardDelete;
    private int mKeyboardLineColor;
    private int mKeyboardNumberTextColor;
    private float mKeyboardNumberTextSize;
    private int[] mKeyboardNumbers;
    private SideStyle mLeftStyle;
    private Paint mLinePaint;
    private int mMaxTranslateY;
    private float mNormalAlpha;
    private GradientDrawable mNumberBackground;
    private int mNumberBackgroundColor;
    private int mNumberBackgroundRadius;
    private float mNumberOffsetY;
    private Paint.FontMetrics mNumberTextFontMetrics;
    private TextPaint mNumberTextPaint;
    private OnClickItemListener mOnClickItemListener;
    private Paint mPaint;
    private int mPreVariation;
    private int mPressedColor;
    private SideStyle mRightStyle;
    private int mSideBackgroundColor;
    private int mStyle;
    private float mTextAlpha;
    private int mTextTranslateX;
    private int mTextTranslateY;
    private Cell mTouchCell;
    private Interpolator mTranslateYInterpolator;
    private String mTtfPath;
    private int mVerticalSpacing;
    private int mViewSize;
    private Paint.FontMetricsInt mWordTextFontMetrics;
    private TextPaint mWordTextPaint;
    private Cell[][] sCells;
    private static final Interpolator DEFAULT_OUT_EASE_INTERPOLATOR = new COUIOutEaseInterpolator();
    private static final Interpolator PATH_INTERPOLATOR = new PathInterpolator(0.0f, 0.0f, 0.6f, 1.0f);

    /* loaded from: classes.dex */
    public class Cell {
        float blurAlpha;
        Drawable blurCircle;
        ValueAnimator blurFadeAnimator;
        float blurScale;
        String cellLettersStr;
        float cellNumberAlpha;
        String cellNumberStr;
        int cellNumberTranslateX;
        int cellNumberTranslateY;
        int column;
        ValueAnimator fadeAnimator;
        float normalAlpha;
        Drawable normalCircle;
        float normalScale;
        int pointerId;
        int pressedColor;
        int row;
        ValueAnimator showAnimator;

        public boolean equals(Cell cell) {
            if (cell == null) {
                return false;
            }
            if (this == cell) {
                return true;
            }
            return this.row == cell.row && this.column == cell.column;
        }

        public int getColumn() {
            return this.column;
        }

        public int getRow() {
            return this.row;
        }

        public int hashCode() {
            return (this.row * 31) + this.column;
        }

        public void setCellNumberAlpha(float f10) {
            this.cellNumberAlpha = f10;
            COUINumericKeyboard.this.invalidate();
        }

        public void setCellNumberTranslateX(int i10) {
            this.cellNumberTranslateX = i10;
            COUINumericKeyboard.this.invalidate();
        }

        public void setCellNumberTranslateY(int i10) {
            this.cellNumberTranslateY = i10;
            COUINumericKeyboard.this.invalidate();
        }

        public void setCircleColor(int i10) {
            if (i10 != 0) {
                this.pressedColor = i10;
                Drawable drawable = this.normalCircle;
                if (drawable != null) {
                    drawable.mutate().setTint(i10);
                }
                Drawable drawable2 = this.blurCircle;
                if (drawable2 != null) {
                    drawable2.mutate().setTint(i10);
                }
            }
        }

        public String toString() {
            return "row " + this.row + "column " + this.column;
        }

        private Cell(int i10, int i11) {
            this.cellNumberStr = "";
            this.cellLettersStr = "";
            this.cellNumberAlpha = 1.0f;
            this.normalAlpha = -1.0f;
            this.blurAlpha = -1.0f;
            this.pointerId = -1;
            COUINumericKeyboard.this.checkRange(i10, i11);
            this.row = i10;
            this.column = i11;
            this.normalCircle = COUINumericKeyboard.this.getContext().getDrawable(e.f6609d);
            this.blurCircle = COUINumericKeyboard.this.getContext().getDrawable(e.f6608c);
            this.normalCircle.setTint(COUINumericKeyboard.this.mPressedColor);
            this.blurCircle.setTint(COUINumericKeyboard.this.mPressedColor);
            this.pressedColor = COUINumericKeyboard.this.mPressedColor;
        }

        public boolean equals(Object obj) {
            try {
                return equals((Cell) obj);
            } catch (ClassCastException unused) {
                Log.e(COUINumericKeyboard.TAG, "ClassCastException when equals");
                return false;
            }
        }
    }

    /* loaded from: classes.dex */
    public interface OnClickItemListener {
        void onClickLeft();

        void onClickNumber(int i10);

        void onClickRight();
    }

    @Deprecated
    /* loaded from: classes.dex */
    public interface OnItemTouchListener {
        void OnItemTouch();
    }

    @Deprecated
    /* loaded from: classes.dex */
    public interface OnTouchTextListener {
        void onTouchText(int i10);
    }

    @Deprecated
    /* loaded from: classes.dex */
    public interface OnTouchUpListener {
        void OnTouchUp();
    }

    /* loaded from: classes.dex */
    public final class PatternExploreByTouchHelper extends a {
        private Rect mTempRect;

        public PatternExploreByTouchHelper(View view) {
            super(view);
            this.mTempRect = new Rect();
        }

        private Rect getBoundsForVirtualView(int i10) {
            int i11;
            int i12;
            Rect rect = this.mTempRect;
            if (i10 != -1) {
                Cell of = COUINumericKeyboard.this.of(i10 / 3, i10 % 3);
                i11 = (int) COUINumericKeyboard.this.getCenterXForColumn(of.column);
                i12 = (int) COUINumericKeyboard.this.getCenterYForRow(of.row);
            } else {
                i11 = 0;
                i12 = 0;
            }
            rect.left = i11 - COUINumericKeyboard.this.mCircleRadius;
            rect.right = i11 + COUINumericKeyboard.this.mCircleRadius;
            rect.top = i12 - COUINumericKeyboard.this.mCircleRadius;
            rect.bottom = i12 + COUINumericKeyboard.this.mCircleRadius;
            return rect;
        }

        private int getVirtualViewIdForHit(float f10, float f11) {
            Cell checkForNewHit = COUINumericKeyboard.this.checkForNewHit(f10, f11);
            if (checkForNewHit == null) {
                return -1;
            }
            int row = (checkForNewHit.getRow() * 3) + checkForNewHit.getColumn();
            if (row == 9) {
                COUINumericKeyboard cOUINumericKeyboard = COUINumericKeyboard.this;
                if (cOUINumericKeyboard.isEmptyStyle(cOUINumericKeyboard.mLeftStyle)) {
                    row = -1;
                }
            }
            if (row == 11) {
                COUINumericKeyboard cOUINumericKeyboard2 = COUINumericKeyboard.this;
                if (cOUINumericKeyboard2.isEmptyStyle(cOUINumericKeyboard2.mRightStyle)) {
                    return -1;
                }
            }
            return row;
        }

        public int getItemCounts() {
            return 12;
        }

        public CharSequence getItemDescription(int i10) {
            if (i10 == 9) {
                COUINumericKeyboard cOUINumericKeyboard = COUINumericKeyboard.this;
                if (!cOUINumericKeyboard.isEmptyStyle(cOUINumericKeyboard.mLeftStyle)) {
                    return COUINumericKeyboard.this.mLeftStyle.mDescription;
                }
            }
            if (i10 == 11) {
                COUINumericKeyboard cOUINumericKeyboard2 = COUINumericKeyboard.this;
                if (!cOUINumericKeyboard2.isEmptyStyle(cOUINumericKeyboard2.mRightStyle)) {
                    return COUINumericKeyboard.this.mRightStyle.mDescription;
                }
            }
            if (i10 == -1) {
                return PatternExploreByTouchHelper.class.getSimpleName();
            }
            return COUINumericKeyboard.this.mKeyboardNumbers[i10] + "";
        }

        @Override // androidx.customview.widget.a
        public int getVirtualViewAt(float f10, float f11) {
            return getVirtualViewIdForHit(f10, f11);
        }

        @Override // androidx.customview.widget.a
        public void getVisibleVirtualViews(List<Integer> list) {
            for (int i10 = 0; i10 < getItemCounts(); i10++) {
                if (i10 == 9) {
                    COUINumericKeyboard cOUINumericKeyboard = COUINumericKeyboard.this;
                    if (cOUINumericKeyboard.isEmptyStyle(cOUINumericKeyboard.mLeftStyle)) {
                        list.add(-1);
                    }
                }
                if (i10 == 11) {
                    COUINumericKeyboard cOUINumericKeyboard2 = COUINumericKeyboard.this;
                    if (cOUINumericKeyboard2.isEmptyStyle(cOUINumericKeyboard2.mRightStyle)) {
                        list.add(-1);
                    }
                }
                list.add(Integer.valueOf(i10));
            }
        }

        public boolean onItemClicked(int i10) {
            invalidateVirtualView(i10);
            if (COUINumericKeyboard.this.isEnabled()) {
                COUINumericKeyboard.this.callback(i10);
                COUINumericKeyboard.this.announceForAccessibility(getItemDescription(i10));
            }
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
        }

        @Override // androidx.customview.widget.a
        public void onPopulateEventForVirtualView(int i10, AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.getText().add(getItemDescription(i10));
        }

        @Override // androidx.customview.widget.a
        public void onPopulateNodeForVirtualView(int i10, d dVar) {
            dVar.l0(getItemDescription(i10));
            dVar.b(d.a.f1394i);
            dVar.i0(true);
            dVar.c0(getBoundsForVirtualView(i10));
        }
    }

    /* loaded from: classes.dex */
    public static class SideStyle {
        private String mDescription;
        private Drawable mDrawable;
        private String mText;
        private int mTextColor;
        private float mTextSize;
        private int mType;

        /* loaded from: classes.dex */
        public static class Builder {
            private String mDescription;
            private Drawable mDrawable;
            private String mText;
            private int mTextColor;
            private float mTextSize;
            private int mType = 0;

            public SideStyle build() {
                return new SideStyle(this);
            }

            public Builder description(String str) {
                this.mDescription = str;
                return this;
            }

            public Builder drawable(Drawable drawable) {
                this.mDrawable = drawable;
                return this;
            }

            public Builder text(String str) {
                this.mText = str;
                return this;
            }

            public Builder textColor(int i10) {
                this.mTextColor = i10;
                return this;
            }

            public Builder textSize(float f10) {
                this.mTextSize = f10;
                return this;
            }

            public Builder type(int i10) {
                this.mType = i10;
                return this;
            }
        }

        private SideStyle(Builder builder) {
            this.mDrawable = builder.mDrawable;
            this.mText = builder.mText;
            this.mTextColor = builder.mTextColor;
            this.mTextSize = builder.mTextSize;
            this.mDescription = builder.mDescription;
            this.mType = builder.mType;
        }
    }

    public COUINumericKeyboard(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callback(int i10) {
        OnClickItemListener onClickItemListener = this.mOnClickItemListener;
        if (onClickItemListener != null) {
            if (i10 >= 0 && i10 <= 8) {
                onClickItemListener.onClickNumber(i10 + 1);
            }
            if (i10 == 10) {
                this.mOnClickItemListener.onClickNumber(0);
            }
            if (i10 == 9) {
                this.mOnClickItemListener.onClickLeft();
            }
            if (i10 == 11) {
                this.mOnClickItemListener.onClickRight();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Cell checkForNewHit(float f10, float f11) {
        int columnHit;
        int rowHit = getRowHit(f11);
        if (rowHit < 0 || (columnHit = getColumnHit(f10)) < 0) {
            return null;
        }
        return of(rowHit, columnHit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkRange(int i10, int i11) {
        if (i10 >= 0 && i10 <= 3) {
            if (i11 >= 0 && i11 <= 2) {
                return;
            } else {
                throw new IllegalArgumentException("column must be in range 0-2");
            }
        }
        throw new IllegalArgumentException("row must be in range 0-3");
    }

    private void drawBackground(Canvas canvas, float f10, float f11, int i10, int i11, int i12) {
        int i13 = this.mNumberBackgroundRadius;
        this.mNumberBackground.setBounds(((int) (f10 - i13)) + i11, ((int) (f11 - i13)) + i12, ((int) (f10 + i13)) + i11, ((int) (f11 + i13)) + i12);
        this.mNumberBackground.setAlpha(i10);
        this.mNumberBackground.draw(canvas);
    }

    private void drawCell(Canvas canvas, int i10, int i11) {
        Cell cell = this.sCells[i11][i10];
        float centerXForColumn = getCenterXForColumn(i10);
        float centerYForRow = getCenterYForRow(i11);
        int i12 = (i11 * 3) + i10;
        if (i12 == 9) {
            drawSide(this.mLeftStyle, canvas, centerXForColumn, centerYForRow);
            return;
        }
        if (i12 == 11) {
            drawSide(this.mRightStyle, canvas, centerXForColumn, centerYForRow);
            return;
        }
        if (i12 != -1) {
            float measureText = this.mNumberTextPaint.measureText(cell.cellNumberStr);
            Paint.FontMetrics fontMetrics = this.mNumberTextFontMetrics;
            float f10 = (centerYForRow - ((fontMetrics.descent + fontMetrics.ascent) / 2.0f)) - this.mNumberOffsetY;
            this.mNumberTextPaint.setAlpha((int) (cell.cellNumberAlpha * 255.0f));
            this.mNumberBackground.setColor(this.mNumberBackgroundColor);
            drawBackground(canvas, centerXForColumn, centerYForRow, (int) (cell.cellNumberAlpha * 255.0f), cell.cellNumberTranslateX, cell.cellNumberTranslateY);
            canvas.drawText(cell.cellNumberStr, (centerXForColumn - (measureText / 2.0f)) + cell.cellNumberTranslateX, f10 + cell.cellNumberTranslateY, this.mNumberTextPaint);
        }
    }

    private void drawPressCircle(Canvas canvas, int i10, int i11) {
        Cell cell = this.sCells[i11][i10];
        if (cell != null) {
            float centerXForColumn = getCenterXForColumn(cell.column);
            float centerYForRow = getCenterYForRow(cell.row);
            if (getTouchIndex(cell) != -1) {
                if (cell.normalAlpha >= 0.0f || cell.blurAlpha >= 0.0f) {
                    int i12 = this.mCircleRadius;
                    int i13 = (int) (centerXForColumn - i12);
                    int i14 = (int) (centerYForRow - i12);
                    int i15 = (int) (i12 + centerXForColumn);
                    int i16 = (int) (i12 + centerYForRow);
                    canvas.save();
                    int i17 = this.mPressedColor;
                    if (i17 != cell.pressedColor) {
                        cell.setCircleColor(i17);
                    }
                    float f10 = cell.normalScale;
                    canvas.scale(f10, f10, centerXForColumn, centerYForRow);
                    cell.normalCircle.setAlpha((int) Math.max(0.0f, cell.normalAlpha * 255.0f));
                    cell.normalCircle.setBounds(i13, i14, i15, i16);
                    cell.normalCircle.draw(canvas);
                    canvas.restore();
                    canvas.save();
                    float f11 = cell.blurScale;
                    canvas.scale(f11, f11, centerXForColumn, centerYForRow);
                    cell.blurCircle.setBounds(i13, i14, i15, i16);
                    cell.blurCircle.setAlpha((int) Math.max(0.0f, cell.blurAlpha * 255.0f));
                    cell.blurCircle.draw(canvas);
                    canvas.restore();
                    if (cell.normalAlpha == 0.0f) {
                        cell.normalAlpha = -1.0f;
                    }
                    if (cell.blurAlpha == 0.0f) {
                        cell.blurAlpha = -1.0f;
                    }
                }
            }
        }
    }

    private void drawSide(SideStyle sideStyle, Canvas canvas, float f10, float f11) {
        if (isEmptyStyle(sideStyle)) {
            return;
        }
        this.mNumberBackground.setColor(this.mSideBackgroundColor);
        if (sideStyle.mDrawable != null) {
            int intrinsicWidth = (int) (f10 - (sideStyle.mDrawable.getIntrinsicWidth() / 2));
            int intrinsicWidth2 = intrinsicWidth + sideStyle.mDrawable.getIntrinsicWidth();
            int intrinsicHeight = (int) (f11 - (sideStyle.mDrawable.getIntrinsicHeight() / 2));
            int intrinsicHeight2 = intrinsicHeight + sideStyle.mDrawable.getIntrinsicHeight();
            drawBackground(canvas, f10, f11, (int) (this.mDrawableAlpha * 255.0f), this.mDrawableTranslateX, this.mDrawableTranslateY);
            Drawable drawable = sideStyle.mDrawable;
            int i10 = this.mDrawableTranslateX;
            int i11 = this.mDrawableTranslateY;
            drawable.setBounds(intrinsicWidth + i10, intrinsicHeight + i11, intrinsicWidth2 + i10, intrinsicHeight2 + i11);
            sideStyle.mDrawable.setAlpha((int) (this.mDrawableAlpha * 255.0f));
            sideStyle.mDrawable.draw(canvas);
            return;
        }
        if (!TextUtils.isEmpty(sideStyle.mText)) {
            this.mWordTextPaint.setTextSize(sideStyle.mTextSize);
            this.mWordTextPaint.setColor(sideStyle.mTextColor);
            this.mWordTextPaint.setAlpha((int) (this.mTextAlpha * 255.0f));
            float measureText = this.mWordTextPaint.measureText(sideStyle.mText);
            this.mWordTextFontMetrics = this.mWordTextPaint.getFontMetricsInt();
            drawBackground(canvas, f10, f11, (int) (this.mTextAlpha * 255.0f), this.mTextTranslateX, this.mTextTranslateY);
            canvas.drawText(sideStyle.mText, (f10 - (measureText / 2.0f)) + this.mTextTranslateX, (f11 - ((r1.descent + r1.ascent) / 2)) + this.mTextTranslateY, this.mWordTextPaint);
        }
    }

    private Cell findCellByPointerId(int i10) {
        for (int i11 = 0; i11 < 4; i11++) {
            for (int i12 = 0; i12 < 3; i12++) {
                Cell cell = this.sCells[i11][i12];
                if (cell.pointerId == i10) {
                    return cell;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getCenterXForColumn(int i10) {
        return getPaddingLeft() + (this.mCellWidth / 2.0f) + (r1 * i10) + (this.mHorizontalSpacing * i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getCenterYForRow(int i10) {
        return getPaddingTop() + (this.mCellHeight / 2.0f) + (r1 * i10) + (this.mVerticalSpacing * i10);
    }

    private int getColumnHit(float f10) {
        for (int i10 = 0; i10 < 3; i10++) {
            int centerXForColumn = (int) getCenterXForColumn(i10);
            int max = Math.max(0, Math.min(this.mHorizontalSpacing / 2, this.mAdditionalPressableArea));
            int i11 = this.mCellWidth;
            int i12 = (centerXForColumn - (i11 / 2)) - max;
            int i13 = centerXForColumn + (i11 / 2) + max;
            if (i12 <= f10 && f10 <= i13) {
                return i10;
            }
        }
        return -1;
    }

    private int[] getDeleteCellIndex() {
        SideStyle sideStyle = this.mLeftStyle;
        if (sideStyle != null && sideStyle.mType == 1) {
            return new int[]{0, 3};
        }
        SideStyle sideStyle2 = this.mRightStyle;
        if (sideStyle2 != null && sideStyle2.mType == 1) {
            return new int[]{2, 3};
        }
        return null;
    }

    private int[] getFinishCellIndex() {
        SideStyle sideStyle = this.mLeftStyle;
        if (sideStyle != null && sideStyle.mType == 2) {
            return new int[]{0, 3};
        }
        SideStyle sideStyle2 = this.mRightStyle;
        if (sideStyle2 != null && sideStyle2.mType == 2) {
            return new int[]{2, 3};
        }
        return null;
    }

    private float[] getKeyboardNumberPosition(int i10) {
        int i11;
        int i12 = 3;
        if (i10 >= 8 && i10 <= 16) {
            int i13 = i10 - 8;
            i11 = i13 % 3;
            i12 = i13 / 3;
        } else if (i10 >= 145 && i10 <= 153) {
            int i14 = i10 - 145;
            i11 = i14 % 3;
            i12 = i14 / 3;
        } else if (i10 == 67) {
            int[] deleteCellIndex = getDeleteCellIndex();
            if (deleteCellIndex != null && deleteCellIndex.length == 2) {
                i11 = deleteCellIndex[0];
                i12 = deleteCellIndex[1];
            } else {
                return new float[]{-1.0f, -1.0f};
            }
        } else if (i10 != 7 && i10 != 144) {
            if (i10 != 66 && i10 != FADE_ANIMATOR_TIME) {
                return new float[]{-1.0f, -1.0f};
            }
            int[] finishCellIndex = getFinishCellIndex();
            if (finishCellIndex != null && finishCellIndex.length == 2) {
                i11 = finishCellIndex[0];
                i12 = finishCellIndex[1];
            } else {
                return new float[]{-1.0f, -1.0f};
            }
        } else {
            i11 = 1;
        }
        Cell cell = this.sCells[i12][i11];
        float centerXForColumn = getCenterXForColumn(i11);
        float centerYForRow = getCenterYForRow(i12);
        Paint.FontMetrics fontMetrics = this.mNumberTextFontMetrics;
        return new float[]{centerXForColumn + cell.cellNumberTranslateX, (centerYForRow - ((fontMetrics.descent + fontMetrics.ascent) / 2.0f)) + cell.cellNumberTranslateY};
    }

    private int getRowHit(float f10) {
        for (int i10 = 0; i10 < 4; i10++) {
            int centerYForRow = (int) getCenterYForRow(i10);
            int max = Math.max(0, Math.min(this.mVerticalSpacing / 2, this.mAdditionalPressableArea));
            int i11 = this.mCellHeight;
            int i12 = (centerYForRow - (i11 / 2)) - max;
            int i13 = centerYForRow + (i11 / 2) + max;
            if (i12 <= f10 && f10 <= i13) {
                return i10;
            }
        }
        return -1;
    }

    private Typeface getTypeface(int[] iArr) {
        Typeface typeface = Typeface.DEFAULT;
        if (iArr[0] != 0) {
            return new Typeface.Builder(this.mTtfPath).setFontVariationSettings("'wght' " + (iArr[1] + this.mFontVariationDefaultPlus)).build();
        }
        return new Typeface.Builder(this.mTtfPath).build();
    }

    private synchronized void handleActionCancel(int i10) {
        try {
            Cell findCellByPointerId = findCellByPointerId(i10);
            initFadeAnimator(findCellByPointerId);
            int touchIndex = getTouchIndex(findCellByPointerId);
            if (this.mAccessibilityManagerService.isTouchExplorationEnabled() && findCellByPointerId != null) {
                this.mExploreByTouchHelper.invalidateRoot();
                if (this.mEnableHapticFeedback && touchIndex != -1) {
                    setTouchFeedback();
                }
            }
            invalidate();
        } catch (Throwable th) {
            throw th;
        }
    }

    private void handleActionDown(MotionEvent motionEvent, int i10) {
        handleActionDown(motionEvent.getX(i10), motionEvent.getY(i10), motionEvent.getPointerId(i10));
    }

    private void handleActionUp(MotionEvent motionEvent, int i10) {
        handleActionUp(motionEvent.getX(i10), motionEvent.getY(i10), motionEvent.getPointerId(i10));
    }

    private void handleKeyEvent(int i10, boolean z10) {
        if (!isValidKeyCode(i10)) {
            return;
        }
        float[] keyboardNumberPosition = getKeyboardNumberPosition(i10);
        if (z10) {
            handleActionDown(keyboardNumberPosition[0], keyboardNumberPosition[1], -1);
        } else {
            handleActionUp(keyboardNumberPosition[0], keyboardNumberPosition[1], -1);
        }
    }

    private void initCellAnim(Cell cell, List<Animator> list, int i10) {
        int i11;
        cell.setCellNumberAlpha(0.0f);
        cell.setCellNumberTranslateY(this.mMaxTranslateY);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(cell, "cellNumberAlpha", 0.0f, 1.0f);
        if (i10 == 10 && isEmptyStyle(this.mLeftStyle)) {
            i11 = i10 - 1;
        } else {
            i11 = i10;
        }
        ofFloat.setStartDelay(166 + (i11 * 16));
        ofFloat.setDuration(167L);
        ofFloat.setInterpolator(this.mAlphaInterpolator);
        list.add(ofFloat);
        ObjectAnimator ofInt = ObjectAnimator.ofInt(cell, "cellNumberTranslateY", this.mMaxTranslateY, 0);
        if (i10 == 10 && isEmptyStyle(this.mLeftStyle)) {
            i10--;
        }
        ofInt.setStartDelay(16 * i10);
        ofInt.setDuration(500L);
        ofInt.setInterpolator(this.mTranslateYInterpolator);
        list.add(ofInt);
    }

    private void initFadeAnimator(final Cell cell) {
        if (cell == null) {
            return;
        }
        cell.pointerId = -1;
        if (cell.fadeAnimator == null) {
            ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofFloat("scaleHolder", 2.15f, FADE_END_SCALE), PropertyValuesHolder.ofFloat("alphaHolder", this.mCircleMaxAlpha, 0.0f));
            ofPropertyValuesHolder.setDuration(160L);
            ofPropertyValuesHolder.setInterpolator(PATH_INTERPOLATOR);
            ofPropertyValuesHolder.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.lockview.COUINumericKeyboard.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Cell cell2 = cell;
                    if (cell2 == null) {
                        return;
                    }
                    cell2.normalAlpha = ((Float) valueAnimator.getAnimatedValue("alphaHolder")).floatValue();
                    cell.normalScale = ((Float) valueAnimator.getAnimatedValue("scaleHolder")).floatValue();
                    COUINumericKeyboard.this.invalidate();
                }
            });
            cell.fadeAnimator = ofPropertyValuesHolder;
        }
        if (cell.blurFadeAnimator == null) {
            ValueAnimator ofPropertyValuesHolder2 = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofKeyframe("blurAlpha", Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.5f, this.mCircleMaxAlpha), Keyframe.ofFloat(1.0f, 0.0f)), PropertyValuesHolder.ofFloat("blurScale", 1.0f, 2.0f));
            ofPropertyValuesHolder2.setDuration(400L);
            ofPropertyValuesHolder2.setInterpolator(PATH_INTERPOLATOR);
            ofPropertyValuesHolder2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.lockview.COUINumericKeyboard.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Cell cell2 = cell;
                    if (cell2 == null) {
                        return;
                    }
                    cell2.blurAlpha = ((Float) valueAnimator.getAnimatedValue("blurAlpha")).floatValue();
                    cell.blurScale = ((Float) valueAnimator.getAnimatedValue("blurScale")).floatValue();
                    COUINumericKeyboard.this.invalidate();
                }
            });
            cell.blurFadeAnimator = ofPropertyValuesHolder2;
        }
        ValueAnimator valueAnimator = cell.showAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            cell.showAnimator.end();
        }
        cell.fadeAnimator.start();
        cell.blurFadeAnimator.start();
    }

    private void initPaint() {
        Paint paint = new Paint(5);
        this.mPaint = paint;
        paint.setColor(this.mPressedColor);
        this.mPaint.setMaskFilter(new BlurMaskFilter(20.0f, BlurMaskFilter.Blur.NORMAL));
        this.mPaint.setAlpha(0);
        this.mNumberTextPaint.setTextSize(this.mKeyboardNumberTextSize);
        this.mNumberTextPaint.setColor(this.mKeyboardNumberTextColor);
        this.mNumberTextPaint.setAntiAlias(true);
        if (!this.mHasCustomTypeface) {
            updateNumberTextTypeface();
        } else {
            Typeface typeface = this.mCustomTypeface;
            if (typeface != null) {
                this.mNumberTextPaint.setTypeface(typeface);
                invalidate();
            }
        }
        this.mNumberTextFontMetrics = this.mNumberTextPaint.getFontMetrics();
        this.mLinePaint.setColor(this.mKeyboardLineColor);
        this.mLinePaint.setAntiAlias(true);
        this.mLinePaint.setStyle(Paint.Style.STROKE);
        this.mWordTextPaint.setFakeBoldText(true);
        this.mWordTextPaint.setAntiAlias(true);
    }

    private void initShowAnimator(final Cell cell) {
        if (cell == null) {
            return;
        }
        if (cell.showAnimator == null) {
            ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofFloat("scaleHolder", 1.0f, 2.15f), PropertyValuesHolder.ofFloat("alphaHolder", 0.0f, this.mCircleMaxAlpha));
            ofPropertyValuesHolder.setDuration(100L);
            ofPropertyValuesHolder.setInterpolator(DEFAULT_OUT_EASE_INTERPOLATOR);
            ofPropertyValuesHolder.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.lockview.COUINumericKeyboard.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Cell cell2 = cell;
                    if (cell2 == null) {
                        return;
                    }
                    cell2.normalAlpha = ((Float) valueAnimator.getAnimatedValue("alphaHolder")).floatValue();
                    cell.normalScale = ((Float) valueAnimator.getAnimatedValue("scaleHolder")).floatValue();
                    COUINumericKeyboard.this.invalidate();
                }
            });
            cell.showAnimator = ofPropertyValuesHolder;
        }
        cell.showAnimator.removeAllListeners();
        if (cell.showAnimator.isRunning()) {
            cell.showAnimator.end();
        }
        ValueAnimator valueAnimator = cell.fadeAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            cell.fadeAnimator.end();
        }
        cell.showAnimator.start();
    }

    private void initSideAnim(SideStyle sideStyle, List<Animator> list, int i10) {
        if (!isEmptyStyle(sideStyle)) {
            if (sideStyle.mDrawable != null) {
                setDrawableAlpha(0.0f);
                setDrawableTranslateY(this.mMaxTranslateY);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "drawableAlpha", 0.0f, 1.0f);
                long j10 = i10 * 16;
                ofFloat.setStartDelay(166 + j10);
                ofFloat.setDuration(167L);
                ofFloat.setInterpolator(this.mAlphaInterpolator);
                list.add(ofFloat);
                ObjectAnimator ofInt = ObjectAnimator.ofInt(this, "drawableTranslateY", this.mMaxTranslateY, 0);
                ofInt.setStartDelay(j10);
                ofInt.setDuration(500L);
                ofInt.setInterpolator(this.mTranslateYInterpolator);
                list.add(ofInt);
                return;
            }
            if (!TextUtils.isEmpty(sideStyle.mText)) {
                setTextAlpha(0.0f);
                setTextTranslateY(this.mMaxTranslateY);
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "textAlpha", 0.0f, 1.0f);
                long j11 = i10 * 16;
                ofFloat2.setStartDelay(166 + j11);
                ofFloat2.setDuration(167L);
                ofFloat2.setInterpolator(this.mAlphaInterpolator);
                list.add(ofFloat2);
                ObjectAnimator ofInt2 = ObjectAnimator.ofInt(this, "textTranslateY", this.mMaxTranslateY, 0);
                ofInt2.setStartDelay(j11);
                ofInt2.setDuration(500L);
                ofInt2.setInterpolator(this.mTranslateYInterpolator);
                list.add(ofInt2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isEmptyStyle(SideStyle sideStyle) {
        if (sideStyle != null && (sideStyle.mDrawable != null || !TextUtils.isEmpty(sideStyle.mText))) {
            return false;
        }
        return true;
    }

    private boolean isMultiPointerEvent(MotionEvent motionEvent) {
        if (motionEvent.getPointerId(motionEvent.getActionIndex()) > 0) {
            return true;
        }
        return false;
    }

    private boolean isValidKeyCode(int i10) {
        if ((i10 < 7 || i10 > 16) && ((i10 < 144 || i10 > 153) && i10 != 67 && i10 != 66 && i10 != FADE_ANIMATOR_TIME)) {
            return false;
        }
        return true;
    }

    private boolean needFadeWhenDisabled(int i10) {
        if (this.mNormalAlpha > 0.0f && (1 == i10 || 3 == i10 || i10 == 0)) {
            return true;
        }
        return false;
    }

    private void setTouchFeedback() {
        if (this.mIsLinearMotorVersion) {
            performHapticFeedback(COUIHapticFeedbackConstants.GRANULAR_SHORT_VIBRATE);
        } else {
            performHapticFeedback(COUIHapticFeedbackConstants.KEYBOARD_TOUCH_FEEDBACK);
        }
    }

    private void setTouchSoundFeedBack() {
        playSoundEffect(0);
    }

    private void updateNumberTextTypeface() {
        Typeface typeface;
        int[] statusAndVariation = getStatusAndVariation();
        if (statusAndVariation == null) {
            return;
        }
        try {
            typeface = getTypeface(statusAndVariation);
        } catch (Exception unused) {
            typeface = Typeface.DEFAULT;
        }
        this.mNumberTextPaint.setTypeface(typeface);
        invalidate();
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return this.mExploreByTouchHelper.dispatchHoverEvent(motionEvent) | super.dispatchHoverEvent(motionEvent);
    }

    public AnimatorSet getEnterAnim() {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < 4; i10++) {
            for (int i11 = 0; i11 < 3; i11++) {
                Cell of = of(i10, i11);
                int i12 = (i10 * 3) + i11;
                if (i12 == 9) {
                    initSideAnim(this.mLeftStyle, arrayList, i12);
                } else if (i12 == 11) {
                    SideStyle sideStyle = this.mRightStyle;
                    if (isEmptyStyle(this.mLeftStyle)) {
                        i12--;
                    }
                    initSideAnim(sideStyle, arrayList, i12);
                } else {
                    initCellAnim(of, arrayList, i12);
                }
            }
        }
        animatorSet.playTogether(arrayList);
        return animatorSet;
    }

    public int[] getStatusAndVariation() {
        int i10 = Settings.System.getInt(this.mContext.getContentResolver(), FONT_VARIATION_SETTINGS, FONT_VARIATION_DEFAULT);
        int[] iArr = {(61440 & i10) >> 12, i10 & 4095};
        int i11 = this.mPreVariation;
        int i12 = iArr[1];
        if (i11 == i12) {
            return null;
        }
        this.mPreVariation = i12;
        return iArr;
    }

    @Deprecated
    public int getTouchIndex() {
        return 0;
    }

    public boolean isTactileFeedbackEnabled() {
        return this.mEnableHapticFeedback;
    }

    public synchronized Cell of(int i10, int i11) {
        checkRange(i10, i11);
        return this.sCells[i10][i11];
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!this.mHasCustomTypeface) {
            updateNumberTextTypeface();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mPaint != null) {
            this.mPaint = null;
        }
        if (this.mTouchCell != null) {
            this.mTouchCell = null;
        }
        this.mDownState = false;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i10 = 0; i10 < 4; i10++) {
            for (int i11 = 0; i11 < 3; i11++) {
                drawPressCircle(canvas, i11, i10);
                drawCell(canvas, i11, i10);
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

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() == 0) {
            handleKeyEvent(i10, true);
        }
        return super.onKeyDown(i10, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i10, KeyEvent keyEvent) {
        if (keyEvent.getScanCode() != 0) {
            handleKeyEvent(i10, false);
        }
        return super.onKeyUp(i10, keyEvent);
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
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        int i14 = this.mViewSize;
        this.mCellWidth = i14;
        this.mCellHeight = i14;
        this.mNumberBackgroundRadius = i14 / 2;
        this.mHorizontalSpacing = (((getWidth() - getPaddingLeft()) - getPaddingRight()) - (this.mCellWidth * 3)) / 2;
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int i15 = this.mCellHeight;
        this.mVerticalSpacing = (height - (i15 * 4)) / 3;
        this.mCircleRadius = i15 / 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0033, code lost:
    
        if (r1 != 6) goto L26;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getActionIndex()
            int r1 = r6.getActionMasked()
            boolean r2 = r5.isEnabled()
            r3 = 0
            if (r2 != 0) goto L27
            boolean r0 = r5.needFadeWhenDisabled(r1)
            if (r0 == 0) goto L26
            int r0 = r6.getPointerCount()
            r1 = r3
        L1a:
            if (r1 >= r0) goto L26
            int r2 = r6.getPointerId(r1)
            r5.handleActionCancel(r2)
            int r1 = r1 + 1
            goto L1a
        L26:
            return r3
        L27:
            r2 = 1
            if (r1 == 0) goto L50
            if (r1 == r2) goto L4a
            r4 = 3
            if (r1 == r4) goto L36
            r4 = 5
            if (r1 == r4) goto L50
            r4 = 6
            if (r1 == r4) goto L4a
            goto L55
        L36:
            int r0 = r6.getPointerCount()
            r1 = r3
        L3b:
            if (r1 >= r0) goto L47
            int r4 = r6.getPointerId(r1)
            r5.handleActionCancel(r4)
            int r1 = r1 + 1
            goto L3b
        L47:
            r5.mDownState = r3
            goto L55
        L4a:
            r5.mDownState = r3
            r5.handleActionUp(r6, r0)
            goto L55
        L50:
            r5.mDownState = r2
            r5.handleActionDown(r6, r0)
        L55:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.lockview.COUINumericKeyboard.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void refresh() {
        String resourceTypeName = getResources().getResourceTypeName(this.mStyle);
        TypedArray typedArray = null;
        if ("attr".equals(resourceTypeName)) {
            typedArray = this.mContext.obtainStyledAttributes(null, m.f6774N0, this.mStyle, 0);
        } else if ("style".equals(resourceTypeName)) {
            typedArray = this.mContext.obtainStyledAttributes(null, m.f6774N0, 0, this.mStyle);
        }
        if (typedArray != null) {
            this.mPressedColor = typedArray.getColor(m.f6790R0, 0);
            this.mKeyboardNumberTextColor = typedArray.getColor(m.f6798T0, 0);
            this.mKeyboardLineColor = typedArray.getColor(m.f6786Q0, 0);
            this.mCircleMaxAlpha = typedArray.getFloat(m.f6778O0, 0.0f);
            this.mNumberBackgroundColor = typedArray.getColor(m.f6794S0, 0);
            this.mSideBackgroundColor = typedArray.getColor(m.f6814X0, 0);
            typedArray.recycle();
        }
        this.mKeyboardDelete.setTint(this.mKeyboardNumberTextColor);
        initPaint();
    }

    public void setCellViewSize(int i10) {
        this.mViewSize = i10;
    }

    public void setCircleMaxAlpha(int i10) {
        setCircleMaxAlpha(i10 / 255.0f);
    }

    public void setCustomTypeFace(Typeface typeface) {
        if (this.mHasCustomTypeface) {
            this.mCustomTypeface = typeface;
            this.mNumberTextPaint.setTypeface(typeface);
            invalidate();
        }
    }

    public void setDeleteStyle(Drawable drawable) {
        this.mDeleteStyle = new SideStyle.Builder().drawable(drawable).description(getResources().getString(k.f6680f)).type(1).build();
    }

    public void setDrawableAlpha(float f10) {
        this.mDrawableAlpha = f10;
        invalidate();
    }

    public void setDrawableTranslateX(int i10) {
        this.mDrawableTranslateX = i10;
        invalidate();
    }

    public void setDrawableTranslateY(int i10) {
        this.mDrawableTranslateY = i10;
        invalidate();
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        Paint paint;
        if (!z10 && this.mDownState && (paint = this.mPaint) != null) {
            paint.setAlpha(0);
            this.mDownState = false;
            invalidate();
        }
        super.setEnabled(z10);
    }

    public void setKeyboardLineColor(int i10) {
        this.mKeyboardLineColor = i10;
        initPaint();
    }

    public void setKeyboardNumberTextColor(int i10) {
        this.mKeyboardNumberTextColor = i10;
        this.mKeyboardDelete.setTint(i10);
    }

    public void setLeftStyle(SideStyle sideStyle) {
        this.mLeftStyle = sideStyle;
        this.mExploreByTouchHelper.invalidateVirtualView(9);
        invalidate();
    }

    public void setNumberBackgroundColor(int i10) {
        this.mNumberBackgroundColor = i10;
    }

    public void setNumberOffsetY(float f10) {
        if (this.mNumberOffsetY != f10) {
            this.mNumberOffsetY = f10;
            invalidate();
        }
    }

    public void setOnClickItemListener(OnClickItemListener onClickItemListener) {
        this.mOnClickItemListener = onClickItemListener;
    }

    public void setPressedColor(int i10) {
        this.mPressedColor = i10;
        initPaint();
    }

    public void setRightStyle(SideStyle sideStyle) {
        this.mRightStyle = sideStyle;
        this.mExploreByTouchHelper.invalidateVirtualView(11);
        invalidate();
    }

    public void setSideBackgroundColor(int i10) {
        this.mSideBackgroundColor = i10;
    }

    public void setTactileFeedbackEnabled(boolean z10) {
        this.mEnableHapticFeedback = z10;
    }

    public void setTextAlpha(float f10) {
        this.mTextAlpha = f10;
        invalidate();
    }

    public void setTextTranslateX(int i10) {
        this.mTextTranslateX = i10;
        invalidate();
    }

    public void setTextTranslateY(int i10) {
        this.mTextTranslateY = i10;
        invalidate();
    }

    public void setWordTextNormalColor(int i10) {
        this.mFinishStyle.mTextColor = i10;
    }

    public COUINumericKeyboard(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.f6468f);
    }

    private int getTouchIndex(Cell cell) {
        if (cell == null) {
            return -1;
        }
        int row = (cell.getRow() * 3) + cell.getColumn();
        if (row == 9 && isEmptyStyle(this.mLeftStyle)) {
            row = -1;
        }
        if (row == 11 && isEmptyStyle(this.mRightStyle)) {
            return -1;
        }
        return row;
    }

    private void handleActionDown(float f10, float f11, int i10) {
        if (this.mAccessibilityManagerService.isTouchExplorationEnabled()) {
            return;
        }
        Cell checkForNewHit = checkForNewHit(f10, f11);
        if (checkForNewHit != null) {
            int touchIndex = getTouchIndex(checkForNewHit);
            this.mExploreByTouchHelper.invalidateRoot();
            if (this.mEnableHapticFeedback && touchIndex != -1) {
                setTouchFeedback();
            }
            if (i10 != -1) {
                checkForNewHit.pointerId = i10;
            }
            initShowAnimator(checkForNewHit);
        }
        invalidate();
    }

    private void handleActionUp(float f10, float f11, int i10) {
        int i11;
        Cell checkForNewHit = checkForNewHit(f10, f11);
        int touchIndex = getTouchIndex(checkForNewHit);
        if (this.mAccessibilityManagerService.isTouchExplorationEnabled()) {
            if (checkForNewHit == null || (i11 = checkForNewHit.pointerId) == -1 || i11 != i10) {
                return;
            }
            this.mExploreByTouchHelper.invalidateRoot();
            if (!this.mEnableHapticFeedback || touchIndex == -1) {
                return;
            }
            setTouchFeedback();
            return;
        }
        if (checkForNewHit != null && checkForNewHit.pointerId == i10) {
            callback(touchIndex);
        }
        if (i10 != -1 && (checkForNewHit == null || checkForNewHit.pointerId != i10)) {
            checkForNewHit = findCellByPointerId(i10);
        }
        initFadeAnimator(checkForNewHit);
        if (touchIndex != -1 && isEnabled() && !hasOnClickListeners()) {
            setTouchSoundFeedBack();
        }
        invalidate();
    }

    public void setCircleMaxAlpha(float f10) {
        if (f10 >= 0.0f && f10 <= 1.0f) {
            this.mCircleMaxAlpha = f10;
            for (int i10 = 0; i10 < 4; i10++) {
                for (int i11 = 0; i11 < 3; i11++) {
                    Cell cell = this.sCells[i10][i11];
                    if (cell != null) {
                        ValueAnimator valueAnimator = cell.showAnimator;
                        if (valueAnimator != null && !valueAnimator.isRunning()) {
                            this.sCells[i10][i11].showAnimator = null;
                        }
                        ValueAnimator valueAnimator2 = this.sCells[i10][i11].fadeAnimator;
                        if (valueAnimator2 != null && !valueAnimator2.isRunning()) {
                            this.sCells[i10][i11].fadeAnimator = null;
                        }
                        ValueAnimator valueAnimator3 = this.sCells[i10][i11].blurFadeAnimator;
                        if (valueAnimator3 != null && !valueAnimator3.isRunning()) {
                            this.sCells[i10][i11].blurFadeAnimator = null;
                        }
                    }
                }
            }
            return;
        }
        COUILog.e(TAG, "The alpha value must be greater than or equal to 0 and less than or equal to 1");
    }

    public COUINumericKeyboard(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, l.f6716v);
    }

    public COUINumericKeyboard(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.NUMERIC = 1;
        this.WORD = 2;
        AnonymousClass1 anonymousClass1 = null;
        this.mPaint = null;
        this.mTouchCell = null;
        this.mEnableHapticFeedback = true;
        int i12 = 0;
        this.mDownState = false;
        this.sCells = (Cell[][]) Array.newInstance((Class<?>) Cell.class, 4, 3);
        this.mKeyboardDelete = null;
        this.mKeyboardNumbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, -1, 0, -1};
        this.mNumberTextPaint = new TextPaint();
        this.mNumberTextFontMetrics = null;
        this.mWordTextFontMetrics = null;
        this.mLinePaint = new Paint();
        this.mKeyboardNumberTextSize = -1.0f;
        this.mKeyboardNumberTextColor = -1;
        this.mKeyboardLineColor = -1;
        this.mWordTextPaint = new TextPaint();
        this.mNormalAlpha = 0.12f;
        this.mPreVariation = -1;
        this.mDrawableAlpha = 1.0f;
        this.mTextAlpha = 1.0f;
        this.mAlphaInterpolator = new COUIEaseInterpolator();
        this.mTranslateYInterpolator = new COUIInEaseInterpolator();
        if (attributeSet != null && attributeSet.getStyleAttribute() != 0) {
            this.mStyle = attributeSet.getStyleAttribute();
        } else {
            this.mStyle = i10;
        }
        COUIDarkModeUtil.setForceDarkAllow(this, false);
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.f6774N0, i10, i11);
        this.mPressedColor = obtainStyledAttributes.getColor(m.f6790R0, 0);
        Resources resources = context.getResources();
        this.mDefaultWidth = resources.getDimensionPixelSize(a9.d.f6541X);
        this.mDefaultHeight = resources.getDimensionPixelSize(a9.d.f6537V);
        this.mViewSize = resources.getDimensionPixelSize(a9.d.f6539W);
        this.mAdditionalPressableArea = resources.getDimensionPixelOffset(a9.d.f6584p);
        this.mKeyboardNumberTextSize = obtainStyledAttributes.getDimensionPixelSize(m.f6806V0, resources.getDimensionPixelSize(a9.d.f6561e1));
        this.mMaxTranslateY = resources.getDimensionPixelSize(a9.d.f6533T);
        this.mFontVariationDefaultPlus = resources.getInteger(g.f6657a);
        this.mNumberOffsetY = obtainStyledAttributes.getDimension(m.f6802U0, resources.getDimensionPixelOffset(a9.d.f6535U));
        this.mKeyboardNumberTextColor = obtainStyledAttributes.getColor(m.f6798T0, 0);
        this.mKeyboardLineColor = obtainStyledAttributes.getColor(m.f6786Q0, 0);
        int color = obtainStyledAttributes.getColor(m.f6818Y0, 0);
        this.mCircleMaxAlpha = obtainStyledAttributes.getFloat(m.f6778O0, 0.0f);
        this.mNumberBackgroundColor = obtainStyledAttributes.getColor(m.f6794S0, 0);
        this.mSideBackgroundColor = obtainStyledAttributes.getColor(m.f6814X0, 0);
        this.mKeyboardDelete = obtainStyledAttributes.getDrawable(m.f6782P0);
        this.mHasCustomTypeface = obtainStyledAttributes.getBoolean(m.f6810W0, false);
        obtainStyledAttributes.recycle();
        if (this.mKeyboardDelete == null) {
            this.mKeyboardDelete = context.getDrawable(e.f6610e);
        }
        PatternExploreByTouchHelper patternExploreByTouchHelper = new PatternExploreByTouchHelper(this);
        this.mExploreByTouchHelper = patternExploreByTouchHelper;
        K.j0(this, patternExploreByTouchHelper);
        setImportantForAccessibility(1);
        this.mExploreByTouchHelper.invalidateRoot();
        String[] stringArray = context.getResources().getStringArray(C0426a.f6460b);
        this.mIsLinearMotorVersion = VibrateUtils.isLinearMotorVersion(context);
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.mNumberBackground = gradientDrawable;
        gradientDrawable.setShape(1);
        this.mNumberBackground.setCornerRadius(this.mNumberBackgroundRadius);
        int i13 = 0;
        while (i13 < 4) {
            int i14 = i12;
            while (i14 < 3) {
                this.sCells[i13][i14] = new Cell(i13, i14);
                Cell cell = this.sCells[i13][i14];
                int i15 = (i13 * 3) + i14;
                cell.cellLettersStr = stringArray[i15];
                int i16 = this.mKeyboardNumbers[i15];
                if (i16 > -1) {
                    cell.cellNumberStr = String.format(Locale.getDefault(), "%d", Integer.valueOf(i16));
                }
                i14++;
                anonymousClass1 = null;
            }
            i13++;
            anonymousClass1 = null;
            i12 = 0;
        }
        this.mTtfPath = getResources().getString(k.f6692r);
        String string = getResources().getString(k.f6681g);
        this.mFinishStyle = new SideStyle.Builder().text(string).textColor(color).textSize(resources.getDimensionPixelSize(a9.d.f6509H)).description(string).type(2).build();
        this.mKeyboardDelete.setTint(this.mKeyboardNumberTextColor);
        this.mDeleteStyle = new SideStyle.Builder().drawable(this.mKeyboardDelete).description(getResources().getString(k.f6680f)).type(1).build();
        this.mAccessibilityManagerService = (AccessibilityManager) context.getSystemService("accessibility");
        initPaint();
    }

    @Deprecated
    public void setHasFinishButton(boolean z10) {
    }

    @Deprecated
    public void setItemTouchListener(OnItemTouchListener onItemTouchListener) {
    }

    @Deprecated
    public void setTouchTextListener(OnTouchTextListener onTouchTextListener) {
    }

    @Deprecated
    public void setTouchUpListener(OnTouchUpListener onTouchUpListener) {
    }

    @Deprecated
    public void setType(int i10) {
    }
}
