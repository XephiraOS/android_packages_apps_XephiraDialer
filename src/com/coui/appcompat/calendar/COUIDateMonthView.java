package com.coui.appcompat.calendar;

import J.d;
import X8.c;
import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.PathInterpolator;
import androidx.core.view.K;
import androidx.customview.widget.a;
import com.coui.appcompat.animation.COUIEaseInterpolator;
import com.coui.appcompat.animation.COUIMoveEaseInterpolator;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.coui.appcompat.textutil.COUIChangeTextUtil;
import e.j;
import java.math.BigInteger;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import u4.C1607c;

/* loaded from: classes.dex */
public class COUIDateMonthView extends View implements View.OnFocusChangeListener {
    private static final int DAYS_IN_WEEK = 7;
    private static final int DEFAULT_SELECTED_DAY = Integer.MIN_VALUE;
    private static final int DEFAULT_WEEK_START = 1;
    private static final int DURATION_OF_DISMISS_ANIMATOR = 150;
    private static final int DURATION_OF_SELECT_ANIMATOR = 280;
    private static final int MAX_WEEKS_IN_MONTH = 6;
    public static final int MAX_YEAR = 2100;
    private static final int MIN_WEEKS_IN_MONTH = 5;
    public static final int MIN_YEAR = 1900;
    private static final String MONTH_YEAR_FORMAT = "MMMMy";
    private static final int SELECTED_HIGHLIGHT_ALPHA = 176;
    private int mActivatedDay;
    private int mActivatedMonth;
    private final int mBackgroundColor;
    private final Calendar mCalendar;
    private int mCellWidth;
    private ValueAnimator mCircleInAnimator;
    private ValueAnimator mCircleOutAnimator;
    private Paint mCirclePaint;
    private Context mContext;
    private float mCurrentDayStrokeRadius;
    private float mDayCircleRadius;
    private final NumberFormat mDayFormatter;
    private int mDayHeight;
    private final Paint mDayHighlightPaint;
    private final Paint mDayHighlightSelectorPaint;
    private int mDayOfWeekHeight;
    private final String[] mDayOfWeekLabels;
    private final TextPaint mDayOfWeekPaint;
    private int mDayOfWeekStart;
    private final TextPaint mDayPaint;
    private float mDaySelectRadius;
    private final Paint mDaySelectorPaint;
    private ColorStateList mDayTextColor;
    private int mDaysInMonth;
    private final int mDesiredCellWidth;
    private final int mDesiredDayHeight;
    private final int mDesiredDayOfWeekHeight;
    private final int mDesiredDayPadding;
    private final int mDesiredMonthHeight;
    private int mEnabledDayEnd;
    private int mEnabledDayStart;
    private int mHighlightedDay;
    private final int mHintColor;
    private int mInitColor;
    private boolean mIsMaxCol;
    private boolean mIsSelectYear;
    private boolean mIsShowAnimator;
    private boolean mIsTouchHighlighted;
    private final Locale mLocale;
    private int mMonth;
    private int mMonthHeight;
    private final TextPaint mMonthPaint;
    private int mMonthWidth;
    private String mMonthYearLabel;
    private int mOldMonth;
    private int mOldSelectDay;
    private final Paint mOldSelectorPaint;
    private OnDayClickListener mOnDayClickListener;
    private int mPaddedHeight;
    private int mPaddedWidth;
    private int mPaddingStart;
    private int mPreviouslyHighlightedDay;
    private final int mPrimaryColor;
    private int mToday;
    private final MonthViewTouchHelper mTouchHelper;
    private int mWeekStart;
    private int mYear;
    private static final PathInterpolator SELECT_ANIMATOR_INTERPOLATOR = new COUIMoveEaseInterpolator();
    private static final PathInterpolator CIRCLE_OUT_ANIMATOR_INTERPOLATOR = new COUIEaseInterpolator();

    /* loaded from: classes.dex */
    public class MonthViewTouchHelper extends a {
        private static final String CN_DATE_FORMAT = "MMMM dd 日 EE";
        private static final String CN_LOCAL = "CN";
        private static final String DATE_FORMAT = "EE dd MMMM";
        private static final String HK_LOCAL = "HK";
        private static final String TW_LOCAL = "TW";
        private final Calendar mTempCalendar;
        private final Rect mTempRect;

        public MonthViewTouchHelper(View view) {
            super(view);
            this.mTempRect = new Rect();
            this.mTempCalendar = Calendar.getInstance();
        }

        private CharSequence getDayDescription(int i10) {
            String str;
            if (COUIDateMonthView.this.isValidDayOfMonth(i10)) {
                this.mTempCalendar.set(COUIDateMonthView.this.mYear, COUIDateMonthView.this.mMonth, i10);
                if (isChinese()) {
                    str = CN_DATE_FORMAT;
                } else {
                    str = DATE_FORMAT;
                }
                return DateFormat.format(str, this.mTempCalendar.getTimeInMillis());
            }
            return "";
        }

        private CharSequence getDayText(int i10) {
            if (COUIDateMonthView.this.isValidDayOfMonth(i10)) {
                return COUIDateMonthView.this.mDayFormatter.format(i10);
            }
            return null;
        }

        private boolean isChinese() {
            String country = COUIDateMonthView.this.mContext.getResources().getConfiguration().locale.getCountry();
            if (country != null) {
                if (country.equalsIgnoreCase(CN_LOCAL) || country.equalsIgnoreCase(TW_LOCAL) || country.equalsIgnoreCase(HK_LOCAL)) {
                    return true;
                }
                return false;
            }
            return false;
        }

        @Override // androidx.customview.widget.a
        public int getVirtualViewAt(float f10, float f11) {
            int dayAtLocation = COUIDateMonthView.this.getDayAtLocation((int) (f10 + 0.5f), (int) (f11 + 0.5f));
            if (dayAtLocation == Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            return dayAtLocation;
        }

        @Override // androidx.customview.widget.a
        public void getVisibleVirtualViews(List<Integer> list) {
            for (int i10 = 1; i10 <= COUIDateMonthView.this.mDaysInMonth; i10++) {
                list.add(Integer.valueOf(i10));
            }
        }

        @Override // androidx.customview.widget.a
        public boolean onPerformActionForVirtualView(int i10, int i11, Bundle bundle) {
            if (i11 == 16) {
                return COUIDateMonthView.this.onDayClicked(i10);
            }
            return false;
        }

        @Override // androidx.customview.widget.a
        public void onPopulateEventForVirtualView(int i10, AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.setContentDescription(getDayDescription(i10));
        }

        @Override // androidx.customview.widget.a
        public void onPopulateNodeForVirtualView(int i10, d dVar) {
            if (!COUIDateMonthView.this.getBoundsForDay(i10, this.mTempRect)) {
                this.mTempRect.setEmpty();
                dVar.l0("");
                dVar.c0(this.mTempRect);
                dVar.M0(false);
                return;
            }
            dVar.K0(getDayText(i10));
            dVar.l0(getDayDescription(i10));
            dVar.c0(this.mTempRect);
            boolean isDayEnabled = COUIDateMonthView.this.isDayEnabled(i10);
            if (isDayEnabled) {
                dVar.a(16);
            }
            dVar.n0(isDayEnabled);
            if (i10 == COUIDateMonthView.this.mActivatedDay) {
                dVar.g0(true);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface OnDayClickListener {
        void onDayClick(COUIDateMonthView cOUIDateMonthView, Calendar calendar);
    }

    /* loaded from: classes.dex */
    public interface OnMonthChangeListener {
        void onMonthChange(String str);
    }

    public COUIDateMonthView(Context context) {
        this(context, null);
    }

    private ColorStateList applyTextAppearance(Paint paint, int i10) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(null, j.f30428c3, 0, i10);
        String string = obtainStyledAttributes.getString(j.f30454h3);
        if (string != null) {
            paint.setTypeface(Typeface.create(string, 0));
        }
        paint.setTextSize((int) COUIChangeTextUtil.getG3FontSize(obtainStyledAttributes.getDimensionPixelSize(j.f30434d3, (int) paint.getTextSize()), getContext().getResources().getConfiguration().fontScale));
        ColorStateList a10 = C1607c.a(getContext(), obtainStyledAttributes, j.f30449g3);
        if (a10 != null) {
            paint.setColor(a10.getColorForState(View.ENABLED_STATE_SET, 0));
        }
        obtainStyledAttributes.recycle();
        return a10;
    }

    private void configAnimator() {
        ValueAnimator valueAnimator = new ValueAnimator();
        this.mCircleInAnimator = valueAnimator;
        valueAnimator.setFloatValues(0.0f, 1.0f);
        this.mCircleInAnimator.setDuration(280L);
        this.mCircleInAnimator.setInterpolator(SELECT_ANIMATOR_INTERPOLATOR);
        this.mCircleInAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.calendar.COUIDateMonthView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                float animatedFraction = valueAnimator2.getAnimatedFraction();
                COUIDateMonthView.this.mDaySelectorPaint.setAlpha((int) (255.0f * animatedFraction));
                COUIDateMonthView cOUIDateMonthView = COUIDateMonthView.this;
                cOUIDateMonthView.mDaySelectRadius = (cOUIDateMonthView.mDayCircleRadius * 0.8f) + (0.2f * animatedFraction * COUIDateMonthView.this.mDayCircleRadius);
                COUIDateMonthView.this.invalidate();
                if (animatedFraction == 1.0f) {
                    COUIDateMonthView.this.mIsShowAnimator = false;
                }
            }
        });
        ValueAnimator valueAnimator2 = new ValueAnimator();
        this.mCircleOutAnimator = valueAnimator2;
        valueAnimator2.setFloatValues(0.0f, 1.0f);
        this.mCircleOutAnimator.setDuration(150L);
        this.mCircleOutAnimator.setInterpolator(CIRCLE_OUT_ANIMATOR_INTERPOLATOR);
        this.mCircleOutAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.calendar.COUIDateMonthView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator3) {
                COUIDateMonthView.this.mOldSelectorPaint.setAlpha((int) ((1.0f - valueAnimator3.getAnimatedFraction()) * 255.0f));
            }
        });
    }

    private void drawDays(Canvas canvas) {
        boolean z10;
        int i10;
        int i11;
        int i12;
        int i13;
        boolean z11;
        boolean z12;
        boolean z13;
        int colorForState;
        Paint paint;
        int daysInMonth;
        TextPaint textPaint = this.mDayPaint;
        int i14 = this.mMonthHeight + this.mDayOfWeekHeight;
        int findDayOffset = findDayOffset();
        boolean z14 = false;
        int i15 = 1;
        if (getDaysInMonth(this.mMonth, this.mYear) + findDayOffset > 35) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.mIsMaxCol = z10;
        int i16 = this.mDayHeight;
        if (z10) {
            i10 = 0;
        } else {
            i10 = this.mDesiredDayPadding;
        }
        int i17 = i16 + i10;
        int i18 = this.mCellWidth;
        float ascent = (textPaint.ascent() + textPaint.descent()) / 2.0f;
        int i19 = i14 + (i17 / 2);
        int i20 = 7;
        if (findDayOffset >= 1) {
            int i21 = 1;
            while (i21 <= findDayOffset) {
                int i22 = (i18 / 2) + ((i21 - 1) * i18);
                if (COUIPickerMathUtils.isLayoutRtl(this)) {
                    i22 = (this.mCellWidth * 7) - i22;
                }
                textPaint.setFakeBoldText(z14);
                textPaint.setColor(this.mHintColor);
                int i23 = this.mMonth;
                if (i23 == 0) {
                    daysInMonth = getDaysInMonth(11, this.mYear - i15);
                } else {
                    daysInMonth = getDaysInMonth(i23 - 1, this.mYear);
                }
                canvas.drawText(this.mDayFormatter.format((daysInMonth - findDayOffset) + i21), i22, i19 - ascent, textPaint);
                i21++;
                z14 = false;
                i15 = 1;
            }
        }
        if (this.mIsMaxCol) {
            i11 = 6;
        } else {
            i11 = 5;
        }
        int daysInMonth2 = ((i11 * 7) - getDaysInMonth(this.mMonth, this.mYear)) - findDayOffset;
        int i24 = (i17 * 4) + i19;
        boolean z15 = this.mIsMaxCol;
        if (z15) {
            i12 = i17;
        } else {
            i12 = 0;
        }
        int i25 = i24 + i12;
        int findEndDayOffset = findEndDayOffset(z15);
        int i26 = 1;
        while (i26 <= daysInMonth2) {
            int i27 = (i18 / 2) + (i18 * findEndDayOffset);
            if (COUIPickerMathUtils.isLayoutRtl(this)) {
                i27 = (this.mCellWidth * i20) - i27;
            }
            textPaint.setColor(this.mHintColor);
            canvas.drawText(this.mDayFormatter.format(i26), i27, i25 - ascent, textPaint);
            findEndDayOffset++;
            if (findEndDayOffset == 7) {
                i25 += i17;
                findEndDayOffset = 0;
            }
            i26++;
            i20 = 7;
        }
        for (int i28 = 1; i28 <= this.mDaysInMonth; i28++) {
            int i29 = (i18 * findDayOffset) + (i18 / 2);
            if (COUIPickerMathUtils.isLayoutRtl(this)) {
                i29 = (this.mCellWidth * 7) - i29;
            }
            boolean isDayEnabled = isDayEnabled(i28);
            if (isDayEnabled) {
                i13 = 8;
            } else {
                i13 = 0;
            }
            if (this.mActivatedDay == i28 && this.mIsSelectYear) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (this.mOldSelectDay == i28 && this.mActivatedMonth == this.mOldMonth && this.mIsShowAnimator) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (this.mHighlightedDay == i28) {
                z13 = true;
            } else {
                z13 = false;
            }
            if (z11) {
                i13 |= 32;
                if (z13) {
                    paint = this.mDayHighlightSelectorPaint;
                } else {
                    paint = this.mDaySelectorPaint;
                }
                canvas.drawCircle(i29, i19, this.mDaySelectRadius / 2.0f, paint);
            } else if (z13) {
                i13 |= 16;
                if (isDayEnabled) {
                    canvas.drawCircle(i29, i19, this.mDayCircleRadius / 2.0f, this.mDayHighlightPaint);
                }
            } else if (z12 && isDayEnabled) {
                canvas.drawCircle(i29, i19, this.mDayCircleRadius / 2.0f, this.mOldSelectorPaint);
            }
            if (this.mToday == i28 && !z11) {
                colorForState = this.mPrimaryColor;
                this.mCirclePaint.setColor(colorForState);
                canvas.drawCircle(i29, i19, this.mDayCircleRadius / 2.0f, this.mCirclePaint);
            } else {
                colorForState = this.mDayTextColor.getColorForState(COUIPickerMathUtils.getViewState(i13), 0);
            }
            textPaint.setColor(colorForState);
            canvas.drawText(this.mDayFormatter.format(i28), i29, i19 - ascent, textPaint);
            findDayOffset++;
            if (findDayOffset == 7) {
                i19 += i17;
                findDayOffset = 0;
            }
        }
    }

    private void drawDaysOfWeek(Canvas canvas) {
        TextPaint textPaint = this.mDayOfWeekPaint;
        int i10 = this.mMonthHeight;
        int i11 = this.mDayOfWeekHeight;
        int i12 = this.mCellWidth;
        float ascent = (textPaint.ascent() + textPaint.descent()) / 2.0f;
        int i13 = i10 + (i11 / 2);
        for (int i14 = 0; i14 < 7; i14++) {
            int i15 = (i12 * i14) + (i12 / 2);
            if (COUIPickerMathUtils.isLayoutRtl(this)) {
                i15 = (this.mCellWidth * 7) - i15;
            }
            canvas.drawText(this.mDayOfWeekLabels[i14], i15, i13 - ascent, textPaint);
        }
    }

    private void drawMonth(Canvas canvas) {
        canvas.drawText(this.mMonthYearLabel, this.mPaddingStart * 2, (this.mMonthHeight - (this.mMonthPaint.ascent() + this.mMonthPaint.descent())) / 2.0f, this.mMonthPaint);
    }

    private void ensureFocusedDay() {
        if (this.mHighlightedDay != Integer.MIN_VALUE) {
            return;
        }
        int i10 = this.mPreviouslyHighlightedDay;
        if (i10 != Integer.MIN_VALUE) {
            this.mHighlightedDay = i10;
            return;
        }
        int i11 = this.mActivatedDay;
        if (i11 != Integer.MIN_VALUE) {
            this.mHighlightedDay = i11;
        } else {
            this.mHighlightedDay = 1;
        }
    }

    private int findClosestColumn(Rect rect) {
        if (rect == null) {
            return 3;
        }
        int centerX = rect.centerX() - getPaddingLeft();
        int i10 = this.mCellWidth;
        if (i10 == 0) {
            return 3;
        }
        int constrain = COUIPickerMathUtils.constrain(centerX / i10, 0, 6);
        if (COUIPickerMathUtils.isLayoutRtl(this)) {
            return 6 - constrain;
        }
        return constrain;
    }

    private int findClosestRow(Rect rect) {
        int i10;
        if (rect == null) {
            return 3;
        }
        int centerY = rect.centerY();
        TextPaint textPaint = this.mDayPaint;
        int i11 = this.mMonthHeight + this.mDayOfWeekHeight;
        int round = Math.round(((int) (centerY - ((i11 + (r2 / 2)) - ((textPaint.ascent() + textPaint.descent()) / 2.0f)))) / this.mDayHeight);
        int findDayOffset = findDayOffset() + this.mDaysInMonth;
        int i12 = findDayOffset / 7;
        if (findDayOffset % 7 == 0) {
            i10 = 1;
        } else {
            i10 = 0;
        }
        return COUIPickerMathUtils.constrain(round, 0, i12 - i10);
    }

    private int findDayOffset() {
        int i10 = this.mDayOfWeekStart;
        int i11 = this.mWeekStart;
        int i12 = i10 - i11;
        if (i10 < i11) {
            return i12 + 7;
        }
        return i12;
    }

    private int findEndDayOffset(boolean z10) {
        int i10;
        int daysInMonth = getDaysInMonth(this.mMonth, this.mYear) + findDayOffset();
        if (z10) {
            i10 = 6;
        } else {
            i10 = 5;
        }
        int i11 = (i10 * 7) - daysInMonth;
        if (i11 > 7) {
            return Math.abs(i11 - 14);
        }
        return Math.abs(i11 - 7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getDayAtLocation(int i10, int i11) {
        int i12;
        int paddingTop;
        int i13;
        int paddingLeft = i10 - getPaddingLeft();
        if (paddingLeft < 0 || paddingLeft >= this.mCellWidth * 7 || (paddingTop = i11 - getPaddingTop()) < (i12 = this.mMonthHeight + this.mDayOfWeekHeight) || paddingTop >= this.mPaddedHeight) {
            return Integer.MIN_VALUE;
        }
        if (COUIPickerMathUtils.isLayoutRtl(this)) {
            paddingLeft = (this.mCellWidth * 7) - paddingLeft;
        }
        int i14 = paddingTop - i12;
        int i15 = this.mDayHeight;
        if (this.mIsMaxCol) {
            i13 = 0;
        } else {
            i13 = this.mDesiredDayPadding;
        }
        return (((paddingLeft / this.mCellWidth) + ((i14 / (i15 + i13)) * 7)) + 1) - findDayOffset();
    }

    private static int getDaysInMonth(int i10, int i11) {
        switch (i10) {
            case 0:
            case 2:
            case 4:
            case 6:
            case 7:
            case 9:
            case 11:
                return 31;
            case 1:
                if (i11 % 4 == 0) {
                    return 29;
                }
                return 28;
            case 3:
            case 5:
            case 8:
            case 10:
                return 30;
            default:
                throw new IllegalArgumentException("Invalid Month");
        }
    }

    private void initPaints(Resources resources) {
        int dimensionPixelSize = resources.getDimensionPixelSize(a9.d.f6576l);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(a9.d.f6562f);
        int dimensionPixelSize3 = resources.getDimensionPixelSize(a9.d.f6565g);
        int g3FontSize = (int) COUIChangeTextUtil.getG3FontSize(dimensionPixelSize, getContext().getResources().getConfiguration().fontScale);
        int g3FontSize2 = (int) COUIChangeTextUtil.getG3FontSize(dimensionPixelSize2, getContext().getResources().getConfiguration().fontScale);
        int g3FontSize3 = (int) COUIChangeTextUtil.getG3FontSize(dimensionPixelSize3, getContext().getResources().getConfiguration().fontScale);
        this.mMonthPaint.setAntiAlias(true);
        this.mMonthPaint.setTextSize(g3FontSize);
        TextPaint textPaint = this.mMonthPaint;
        Typeface typeface = Typeface.DEFAULT;
        textPaint.setTypeface(Typeface.create(typeface, 1));
        TextPaint textPaint2 = this.mMonthPaint;
        Paint.Align align = Paint.Align.CENTER;
        textPaint2.setTextAlign(align);
        TextPaint textPaint3 = this.mMonthPaint;
        Paint.Style style = Paint.Style.FILL;
        textPaint3.setStyle(style);
        this.mDayOfWeekPaint.setAntiAlias(true);
        this.mDayOfWeekPaint.setTextSize(g3FontSize2);
        this.mDayOfWeekPaint.setTypeface(Typeface.create(typeface, 1));
        this.mDayOfWeekPaint.setTextAlign(align);
        this.mDayOfWeekPaint.setStyle(style);
        this.mDaySelectorPaint.setAntiAlias(true);
        this.mDaySelectorPaint.setStyle(style);
        this.mOldSelectorPaint.setAntiAlias(true);
        this.mOldSelectorPaint.setStyle(style);
        this.mDayHighlightPaint.setAntiAlias(true);
        this.mDayHighlightPaint.setStyle(style);
        this.mDayHighlightSelectorPaint.setAntiAlias(true);
        this.mDayHighlightSelectorPaint.setStyle(style);
        this.mDayPaint.setAntiAlias(true);
        this.mDayPaint.setTextSize(g3FontSize3);
        this.mDayPaint.setTypeface(Typeface.create(typeface, 1));
        this.mDayPaint.setTextAlign(align);
        this.mDayPaint.setStyle(style);
        Paint paint = new Paint();
        this.mCirclePaint = paint;
        paint.setAntiAlias(true);
        this.mCirclePaint.setStyle(Paint.Style.STROKE);
        this.mCirclePaint.setStrokeWidth(this.mCurrentDayStrokeRadius);
        configAnimator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDayEnabled(int i10) {
        if (i10 >= this.mEnabledDayStart && i10 <= this.mEnabledDayEnd) {
            return true;
        }
        return false;
    }

    private boolean isFirstDayOfWeek(int i10) {
        if (((findDayOffset() + i10) - 1) % 7 == 0) {
            return true;
        }
        return false;
    }

    private boolean isLastDayOfWeek(int i10) {
        if ((findDayOffset() + i10) % 7 == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isValidDayOfMonth(int i10) {
        if (i10 >= 1 && i10 <= this.mDaysInMonth) {
            return true;
        }
        return false;
    }

    private static boolean isValidDayOfWeek(int i10) {
        if (i10 >= 1 && i10 <= 7) {
            return true;
        }
        return false;
    }

    private static boolean isValidMonth(int i10) {
        if (i10 >= 0 && i10 <= 11) {
            return true;
        }
        return false;
    }

    private boolean moveOneDay(boolean z10) {
        int i10;
        int i11;
        ensureFocusedDay();
        if (z10) {
            if (!isLastDayOfWeek(this.mHighlightedDay) && (i11 = this.mHighlightedDay) < this.mDaysInMonth) {
                this.mHighlightedDay = i11 + 1;
                return true;
            }
        } else if (!isFirstDayOfWeek(this.mHighlightedDay) && (i10 = this.mHighlightedDay) > 1) {
            this.mHighlightedDay = i10 - 1;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean onDayClicked(int i10) {
        if (i10 == this.mActivatedDay) {
            return false;
        }
        this.mIsShowAnimator = true;
        if (this.mOnDayClickListener != null) {
            Calendar calendar = Calendar.getInstance();
            if (i10 <= 0) {
                int i11 = this.mMonth;
                if (i11 > 0) {
                    int i12 = this.mYear;
                    calendar.set(i12, i11 - 1, getDaysInMonth(i11 - 1, i12) + i10);
                } else {
                    int i13 = this.mYear;
                    calendar.set(i13 - 1, 11, getDaysInMonth(i11, i13 - 1) + i10);
                }
            } else if (i10 > getDaysInMonth(this.mMonth, this.mYear)) {
                int i14 = this.mMonth;
                if (i14 < 11) {
                    int i15 = this.mYear;
                    calendar.set(i15, i14 + 1, i10 - getDaysInMonth(i14, i15));
                } else {
                    int i16 = this.mYear;
                    calendar.set(i16 + 1, 0, i10 - getDaysInMonth(i14, i16));
                }
            } else {
                calendar.set(this.mYear, this.mMonth, i10);
            }
            if (calendar.get(1) < 1900 || calendar.get(1) > 2100) {
                return false;
            }
            this.mOnDayClickListener.onDayClick(this, calendar);
        }
        this.mTouchHelper.sendEventForVirtualView(i10, 1);
        return true;
    }

    private boolean sameDay(int i10, Calendar calendar) {
        if (this.mYear == calendar.get(1) && this.mMonth == calendar.get(2) && i10 == calendar.get(5)) {
            return true;
        }
        return false;
    }

    private void updateDayOfWeekLabels() {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 1; i10 < 8; i10++) {
            arrayList.add(DateUtils.getDayOfWeekString(i10, 50));
        }
        for (int i11 = 0; i11 < 7; i11++) {
            this.mDayOfWeekLabels[i11] = (String) arrayList.get(((this.mWeekStart + i11) - 1) % 7);
        }
    }

    private void updateMonthYearLabel() {
        this.mMonthYearLabel = new SimpleDateFormat(DateFormat.getBestDateTimePattern(this.mLocale, MONTH_YEAR_FORMAT), this.mLocale).format(this.mCalendar.getTime());
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (!this.mTouchHelper.dispatchHoverEvent(motionEvent) && !super.dispatchHoverEvent(motionEvent)) {
            return false;
        }
        return true;
    }

    public boolean getBoundsForDay(int i10, Rect rect) {
        int paddingLeft;
        int i11 = 0;
        if (!isValidDayOfMonth(i10)) {
            return false;
        }
        int findDayOffset = (i10 - 1) + findDayOffset();
        int i12 = findDayOffset % 7;
        int i13 = this.mCellWidth;
        if (COUIPickerMathUtils.isLayoutRtl(this)) {
            paddingLeft = (getWidth() - getPaddingRight()) - ((i12 + 1) * i13);
        } else {
            paddingLeft = getPaddingLeft() + (i12 * i13);
        }
        int i14 = findDayOffset / 7;
        int i15 = this.mDayHeight;
        if (!this.mIsMaxCol) {
            i11 = this.mDesiredDayPadding;
        }
        int i16 = i15 + i11;
        int paddingTop = getPaddingTop() + this.mMonthHeight + this.mDayOfWeekHeight + (i14 * i16);
        rect.set(paddingLeft, paddingTop, i13 + paddingLeft, i16 + paddingTop);
        return true;
    }

    public int getCellWidth() {
        return this.mCellWidth;
    }

    @Override // android.view.View
    public void getFocusedRect(Rect rect) {
        int i10 = this.mHighlightedDay;
        if (i10 > 0) {
            getBoundsForDay(i10, rect);
        } else {
            super.getFocusedRect(rect);
        }
    }

    public int getMonthHeight() {
        return this.mMonthHeight;
    }

    public int getMonthWidth() {
        return this.mMonthWidth;
    }

    public String getMonthYearLabel() {
        return this.mMonthYearLabel;
    }

    public long getTimeMillis() {
        return this.mCalendar.getTimeInMillis();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.translate(getPaddingLeft(), getPaddingTop());
        drawDaysOfWeek(canvas);
        drawDays(canvas);
        canvas.translate(-r0, -r1);
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z10) {
        if (!z10 && !this.mIsTouchHighlighted) {
            this.mPreviouslyHighlightedDay = this.mHighlightedDay;
            this.mHighlightedDay = Integer.MIN_VALUE;
            invalidate();
        }
    }

    @Override // android.view.View
    public void onFocusChanged(boolean z10, int i10, Rect rect) {
        if (z10) {
            int findDayOffset = findDayOffset();
            int i11 = 1;
            if (i10 != 17) {
                if (i10 != 33) {
                    if (i10 != 66) {
                        if (i10 == 130) {
                            int findClosestColumn = findClosestColumn(rect) - findDayOffset;
                            int i12 = findClosestColumn + 1;
                            if (i12 < 1) {
                                i12 = findClosestColumn + 8;
                            }
                            this.mHighlightedDay = i12;
                        }
                    } else {
                        int findClosestRow = findClosestRow(rect);
                        if (findClosestRow != 0) {
                            i11 = 1 + ((findClosestRow * 7) - findDayOffset);
                        }
                        this.mHighlightedDay = i11;
                    }
                } else {
                    int findClosestColumn2 = findClosestColumn(rect);
                    int i13 = this.mDaysInMonth;
                    int i14 = (findClosestColumn2 - findDayOffset) + (((findDayOffset + i13) / 7) * 7);
                    int i15 = i14 + 1;
                    if (i15 > i13) {
                        i15 = i14 - 6;
                    }
                    this.mHighlightedDay = i15;
                }
            } else {
                this.mHighlightedDay = Math.min(this.mDaysInMonth, ((findClosestRow(rect) + 1) * 7) - findDayOffset);
            }
            ensureFocusedDay();
            invalidate();
        }
        super.onFocusChanged(z10, i10, rect);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0031, code lost:
    
        if (r0 == false) goto L50;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x000e. Please report as an issue. */
    @Override // android.view.View, android.view.KeyEvent.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onKeyDown(int r6, android.view.KeyEvent r7) {
        /*
            r5 = this;
            int r0 = r7.getKeyCode()
            r1 = 61
            r2 = 1
            if (r0 == r1) goto L66
            r1 = 66
            if (r0 == r1) goto L5c
            r1 = 7
            switch(r0) {
                case 19: goto L48;
                case 20: goto L34;
                case 21: goto L23;
                case 22: goto L13;
                case 23: goto L5c;
                default: goto L11;
            }
        L11:
            goto L92
        L13:
            boolean r0 = r7.hasNoModifiers()
            if (r0 == 0) goto L92
            boolean r0 = com.coui.appcompat.calendar.COUIPickerMathUtils.isLayoutRtl(r5)
            r0 = r0 ^ r2
            boolean r0 = r5.moveOneDay(r0)
            goto L31
        L23:
            boolean r0 = r7.hasNoModifiers()
            if (r0 == 0) goto L92
            boolean r0 = com.coui.appcompat.calendar.COUIPickerMathUtils.isLayoutRtl(r5)
            boolean r0 = r5.moveOneDay(r0)
        L31:
            if (r0 == 0) goto L92
            goto L58
        L34:
            boolean r0 = r7.hasNoModifiers()
            if (r0 == 0) goto L92
            r5.ensureFocusedDay()
            int r0 = r5.mHighlightedDay
            int r3 = r5.mDaysInMonth
            int r3 = r3 - r1
            if (r0 > r3) goto L92
            int r0 = r0 + r1
            r5.mHighlightedDay = r0
            goto L58
        L48:
            boolean r0 = r7.hasNoModifiers()
            if (r0 == 0) goto L92
            r5.ensureFocusedDay()
            int r0 = r5.mHighlightedDay
            if (r0 <= r1) goto L92
            int r0 = r0 - r1
            r5.mHighlightedDay = r0
        L58:
            r5.invalidate()
            return r2
        L5c:
            int r0 = r5.mHighlightedDay
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 == r1) goto L92
            r5.onDayClicked(r0)
            return r2
        L66:
            boolean r0 = r7.hasNoModifiers()
            if (r0 == 0) goto L6e
            r0 = 2
            goto L77
        L6e:
            boolean r0 = r7.hasModifiers(r2)
            if (r0 == 0) goto L76
            r0 = r2
            goto L77
        L76:
            r0 = 0
        L77:
            if (r0 == 0) goto L92
            android.view.ViewParent r1 = r5.getParent()
            r3 = r5
        L7e:
            android.view.View r3 = r3.focusSearch(r0)
            if (r3 == 0) goto L8c
            if (r3 == r5) goto L8c
            android.view.ViewParent r4 = r3.getParent()
            if (r4 == r1) goto L7e
        L8c:
            if (r3 == 0) goto L92
            r3.requestFocus()
            return r2
        L92:
            boolean r5 = super.onKeyDown(r6, r7)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.calendar.COUIDateMonthView.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    @Override // android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        if (!z10) {
            return;
        }
        int i14 = i12 - i10;
        int i15 = i13 - i11;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int i16 = (i14 - paddingRight) - paddingLeft;
        int paddingBottom = (i15 - getPaddingBottom()) - paddingTop;
        if (i16 != this.mPaddedWidth && paddingBottom != this.mPaddedHeight && i16 >= 0 && paddingBottom >= 0) {
            this.mPaddedWidth = i16;
            this.mPaddedHeight = paddingBottom;
            float measuredHeight = paddingBottom / ((getMeasuredHeight() - paddingTop) - r0);
            this.mMonthHeight = 0;
            this.mMonthWidth = (int) this.mMonthPaint.measureText(this.mMonthYearLabel);
            this.mDayOfWeekHeight = (int) (this.mDesiredDayOfWeekHeight * measuredHeight);
            this.mDayHeight = (int) (this.mDesiredDayHeight * measuredHeight);
            this.mTouchHelper.invalidateRoot();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int paddingTop = (this.mDesiredDayHeight * 6) + this.mDesiredDayOfWeekHeight + this.mDesiredMonthHeight + getPaddingTop() + getPaddingBottom();
        int resolveSize = View.resolveSize((this.mDesiredCellWidth * 7) + getPaddingStart() + getPaddingEnd(), i10);
        int resolveSize2 = View.resolveSize(paddingTop, i11);
        this.mCellWidth = ((resolveSize - getPaddingRight()) - getPaddingLeft()) / 7;
        setMeasuredDimension(resolveSize, resolveSize2);
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i10) {
        super.onRtlPropertiesChanged(i10);
        requestLayout();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001e, code lost:
    
        if (r7 != 3) goto L20;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            float r0 = r7.getX()
            r1 = 1056964608(0x3f000000, float:0.5)
            float r0 = r0 + r1
            int r0 = (int) r0
            float r2 = r7.getY()
            float r2 = r2 + r1
            int r1 = (int) r2
            int r7 = r7.getAction()
            r2 = 0
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = 1
            if (r7 == 0) goto L32
            if (r7 == r4) goto L21
            r5 = 2
            if (r7 == r5) goto L32
            r0 = 3
            if (r7 == r0) goto L2a
            goto L48
        L21:
            int r7 = r6.getDayAtLocation(r0, r1)
            if (r7 == r3) goto L2a
            r6.onDayClicked(r7)
        L2a:
            r6.mHighlightedDay = r3
            r6.mIsTouchHighlighted = r2
            r6.invalidate()
            goto L48
        L32:
            int r0 = r6.getDayAtLocation(r0, r1)
            r6.mIsTouchHighlighted = r4
            int r1 = r6.mHighlightedDay
            if (r1 == r0) goto L43
            r6.mHighlightedDay = r0
            r6.mPreviouslyHighlightedDay = r0
            r6.invalidate()
        L43:
            if (r7 != 0) goto L48
            if (r0 != r3) goto L48
            return r2
        L48:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.calendar.COUIDateMonthView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setDayHighlightColor(ColorStateList colorStateList) {
        this.mDayHighlightPaint.setColor(colorStateList.getColorForState(COUIPickerMathUtils.getViewState(24), 0));
        invalidate();
    }

    public void setDayOfWeekTextAppearance(int i10) {
        applyTextAppearance(this.mDayOfWeekPaint, i10);
        invalidate();
    }

    public void setDayOfWeekTextColor(ColorStateList colorStateList) {
        this.mDayOfWeekPaint.setColor(colorStateList.getColorForState(View.ENABLED_STATE_SET, 0));
        invalidate();
    }

    public void setDaySelectorColor(int i10) {
        this.mDaySelectorPaint.setColor(i10);
        this.mOldSelectorPaint.setColor(i10);
        this.mDayHighlightSelectorPaint.setColor(i10);
        this.mDayHighlightSelectorPaint.setAlpha(SELECTED_HIGHLIGHT_ALPHA);
        invalidate();
    }

    public void setDayTextAppearance(int i10) {
        ColorStateList applyTextAppearance = applyTextAppearance(this.mDayPaint, i10);
        if (applyTextAppearance != null) {
            this.mDayTextColor = applyTextAppearance;
        }
        invalidate();
    }

    public void setDayTextColor(ColorStateList colorStateList) {
        this.mDayTextColor = colorStateList;
        invalidate();
    }

    public void setFirstDayOfWeek(int i10) {
        if (isValidDayOfWeek(i10)) {
            this.mWeekStart = i10;
        } else {
            this.mWeekStart = this.mCalendar.getFirstDayOfWeek();
        }
        updateDayOfWeekLabels();
        this.mTouchHelper.invalidateRoot();
        invalidate();
    }

    public void setMonthParams(int i10, int i11, int i12, int i13, int i14, int i15, boolean z10) {
        this.mActivatedDay = i10;
        if (isValidMonth(i11)) {
            this.mMonth = i11;
        }
        this.mYear = i12;
        this.mIsSelectYear = z10;
        this.mCalendar.set(2, this.mMonth);
        this.mCalendar.set(1, this.mYear);
        this.mCalendar.set(5, 1);
        this.mDayOfWeekStart = this.mCalendar.get(7);
        if (isValidDayOfWeek(i13)) {
            this.mWeekStart = i13;
        } else {
            this.mWeekStart = this.mCalendar.getFirstDayOfWeek();
        }
        Calendar calendar = Calendar.getInstance();
        this.mToday = Integer.MIN_VALUE;
        this.mDaysInMonth = getDaysInMonth(this.mMonth, this.mYear);
        int i16 = 0;
        while (true) {
            int i17 = this.mDaysInMonth;
            if (i16 < i17) {
                i16++;
                if (sameDay(i16, calendar)) {
                    this.mToday = i16;
                }
            } else {
                int constrain = COUIPickerMathUtils.constrain(i14, 1, i17);
                this.mEnabledDayStart = constrain;
                this.mEnabledDayEnd = COUIPickerMathUtils.constrain(i15, constrain, this.mDaysInMonth);
                updateMonthYearLabel();
                updateDayOfWeekLabels();
                this.mTouchHelper.invalidateRoot();
                invalidate();
                return;
            }
        }
    }

    public void setMonthTextAlpha(int i10) {
        int i11 = this.mInitColor;
        if (Integer.toHexString(i11).length() > 2) {
            this.mMonthPaint.setColor(new ColorStateList(new int[][]{new int[]{16842910}, new int[0]}, new int[]{new BigInteger(Integer.toHexString((i10 * new BigInteger(Integer.toHexString(i11).substring(0, 2), 16).intValue()) / 255) + Integer.toHexString(i11).substring(2), 16).intValue(), i11}).getColorForState(View.ENABLED_STATE_SET, 0));
            invalidate();
        }
    }

    public void setMonthTextAppearance(int i10) {
        applyTextAppearance(this.mMonthPaint, i10);
        this.mInitColor = this.mMonthPaint.getColor();
        invalidate();
    }

    public void setMonthTextColor(ColorStateList colorStateList) {
        this.mMonthPaint.setColor(COUIContextUtil.getAttrColor(getContext(), c.f4347F));
        invalidate();
    }

    public void setOldDay(int i10, int i11) {
        int i12 = this.mActivatedDay;
        if (i12 != Integer.MIN_VALUE && i12 != i10) {
            this.mOldSelectDay = i10;
            this.mOldMonth = i11;
        }
    }

    public void setOnDayClickListener(OnDayClickListener onDayClickListener) {
        this.mOnDayClickListener = onDayClickListener;
    }

    public void setSelectedDay(int i10, int i11, int i12) {
        boolean z10;
        this.mActivatedDay = i10;
        this.mActivatedMonth = i11;
        if (this.mYear == i12) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.mIsSelectYear = z10;
        this.mTouchHelper.invalidateRoot();
        this.mCircleInAnimator.start();
        this.mCircleOutAnimator.start();
    }

    public COUIDateMonthView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.datePickerStyle);
    }

    public COUIDateMonthView(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public COUIDateMonthView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.mMonthPaint = new TextPaint();
        this.mDayOfWeekPaint = new TextPaint();
        this.mDayPaint = new TextPaint();
        this.mDaySelectorPaint = new Paint();
        this.mOldSelectorPaint = new Paint();
        this.mDayHighlightPaint = new Paint();
        this.mDayHighlightSelectorPaint = new Paint();
        this.mDayOfWeekLabels = new String[7];
        this.mActivatedDay = Integer.MIN_VALUE;
        this.mActivatedMonth = Integer.MIN_VALUE;
        this.mOldSelectDay = Integer.MIN_VALUE;
        this.mOldMonth = Integer.MIN_VALUE;
        this.mToday = Integer.MIN_VALUE;
        this.mWeekStart = 1;
        this.mEnabledDayStart = 1;
        this.mEnabledDayEnd = 31;
        this.mHighlightedDay = Integer.MIN_VALUE;
        this.mPreviouslyHighlightedDay = Integer.MIN_VALUE;
        this.mIsTouchHighlighted = false;
        this.mContext = context;
        Resources resources = context.getResources();
        this.mDesiredMonthHeight = resources.getDimensionPixelSize(a9.d.f6572j);
        this.mPaddingStart = resources.getDimensionPixelSize(a9.d.f6574k);
        this.mDesiredDayOfWeekHeight = resources.getDimensionPixelSize(a9.d.f6559e);
        this.mDesiredDayHeight = resources.getDimensionPixelSize(a9.d.f6553c);
        this.mDesiredDayPadding = resources.getDimensionPixelSize(a9.d.f6556d);
        this.mDesiredCellWidth = resources.getDimensionPixelSize(a9.d.f6568h);
        this.mDayCircleRadius = resources.getDimensionPixelSize(a9.d.f6547a);
        this.mCurrentDayStrokeRadius = resources.getDimensionPixelSize(a9.d.f6550b);
        this.mDaySelectRadius = this.mDayCircleRadius;
        this.mHintColor = COUIContextUtil.getAttrColor(context, c.f4398p);
        this.mPrimaryColor = COUIContextUtil.getAttrColor(context, c.f4347F);
        this.mBackgroundColor = COUIContextUtil.getAttrColor(context, c.f4380g);
        MonthViewTouchHelper monthViewTouchHelper = new MonthViewTouchHelper(this);
        this.mTouchHelper = monthViewTouchHelper;
        K.j0(this, monthViewTouchHelper);
        setImportantForAccessibility(1);
        Locale locale = resources.getConfiguration().locale;
        this.mLocale = locale;
        this.mCalendar = Calendar.getInstance(locale);
        this.mDayFormatter = NumberFormat.getIntegerInstance(locale);
        updateMonthYearLabel();
        updateDayOfWeekLabels();
        initPaints(resources);
    }
}
