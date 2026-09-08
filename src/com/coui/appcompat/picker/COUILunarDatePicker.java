package com.coui.appcompat.picker;

import a9.C0426a;
import a9.b;
import a9.d;
import a9.f;
import a9.h;
import a9.k;
import a9.l;
import a9.m;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.CalendarView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import com.coui.appcompat.lunarutil.COUILunarUtil;
import com.coui.appcompat.picker.COUINumberPicker;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes.dex */
public class COUILunarDatePicker extends FrameLayout {
    private static final int DAY_OF_REFRESH_SPINNER = 27;
    private static final boolean DEFAULT_CALENDAR_VIEW_SHOWN = true;
    private static final boolean DEFAULT_ENABLED_STATE = true;
    private static final int DEFAULT_END_DAY = 31;
    private static final int DEFAULT_END_HOUR = 23;
    private static final int DEFAULT_END_MINUTE = 59;
    private static final int DEFAULT_END_MONTH = 11;
    private static final int DEFAULT_END_YEAR = 2099;
    private static final boolean DEFAULT_SPINNERS_SHOWN = true;
    private static final int DEFAULT_START_YEAR = 1910;
    public static final int IGNORED_YEAR = Integer.MIN_VALUE;
    private static final int IGNORED_YEAR_MONTH_COUNT = 24;
    private static final int LEAPYEAR_MONTH_COUNT = 13;
    private static final int LONGPRESS_UPDATE_INTERVAL = 100;
    private static final int MIN_BACKGROUND_DIVIDER_HEIGHT = 1;
    private static final int MONTH_LONGPRESS_UPDATE_INTERVAL = 200;
    private static final int NORMAL_MONTH_COUNT = 12;
    private static final int PICKER_CHILD_COUNT = 3;
    private static final String TAG = "COUILunarDatePicker";
    private static final int TEN = 10;
    private static final int TWO = 2;
    private static final int ZERO = 0;
    private static String sLeapString;
    private int mBackgroundDividerHeight;
    private int mBackgroundLeft;
    private int mBackgroundRadius;
    private IncompleteDate mCurrentDate;
    private Locale mCurrentLocale;
    private final COUINumberPicker mDaySpinner;
    private boolean mIsEnabled;
    private int mMaxWidth;
    private final COUINumberPicker mMonthSpinner;
    private int mNumberOfMonths;
    private OnDateChangedListener mOnDateChangedListener;
    private String[] mShortMonths;
    private final LinearLayout mSpinners;
    private IncompleteDate mTempDate;
    private boolean mYearIgnorable;
    private final COUINumberPicker mYearSpinner;
    private static final String[] CHINESE_NUMBER = {"一", "二", "三", "四", "五", "六", "七", "八", "九", "十", "十一", "十二"};
    private static Calendar sMinDate = Calendar.getInstance();
    private static Calendar sMaxDate = Calendar.getInstance();

    /* loaded from: classes.dex */
    public interface OnDateChangedListener {
        void onLunarDateChanged(COUILunarDatePicker cOUILunarDatePicker, int i10, int i11, int i12);
    }

    static {
        sMinDate.set(DEFAULT_START_YEAR, 2, 10, 0, 0);
        sMaxDate.set(DEFAULT_END_YEAR, 11, 31, 23, 59);
    }

    public COUILunarDatePicker(Context context) {
        this(context, null);
    }

    private void clampDate() {
        this.mCurrentDate.clampDate(sMinDate, sMaxDate);
    }

    private IncompleteDate getCalendarForLocale(IncompleteDate incompleteDate, Locale locale) {
        if (incompleteDate == null) {
            return new IncompleteDate(locale);
        }
        IncompleteDate incompleteDate2 = new IncompleteDate(locale);
        if (!incompleteDate.mIsIncomplete) {
            incompleteDate2.setTimeInMillis(incompleteDate.getTimeInMillis());
        } else {
            incompleteDate2.setWith(incompleteDate);
        }
        return incompleteDate2;
    }

    @Deprecated
    public static String getLunarDateString(Calendar calendar) {
        int[] calculateLunarByGregorian = COUILunarUtil.calculateLunarByGregorian(calendar.get(1), calendar.get(2) + 1, calendar.get(5));
        return getLunarDateString(calculateLunarByGregorian[0], calculateLunarByGregorian[1], calculateLunarByGregorian[2], calculateLunarByGregorian[3]);
    }

    private static String getLunarDateString2(IncompleteDate incompleteDate) {
        int[] calculateLunarByGregorian = COUILunarUtil.calculateLunarByGregorian(incompleteDate.get(1), incompleteDate.get(2) + 1, incompleteDate.get(5));
        return getLunarDateString(calculateLunarByGregorian[0], calculateLunarByGregorian[1], calculateLunarByGregorian[2], calculateLunarByGregorian[3]);
    }

    private boolean isNewDate(int i10, int i11, int i12) {
        if (this.mCurrentDate.get(1) != i10 || this.mCurrentDate.get(2) != i12 || this.mCurrentDate.get(5) != i11) {
            return true;
        }
        return false;
    }

    private void measureChildConstrained(View view, int i10, int i11) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i10, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i11, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyDateChanged() {
        OnDateChangedListener onDateChangedListener = this.mOnDateChangedListener;
        if (onDateChangedListener != null) {
            onDateChangedListener.onLunarDateChanged(this, getYear(), getMonth(), getDayOfMonth());
        }
    }

    private void reorderSpinners() {
        this.mSpinners.removeAllViews();
        char[] dateFormatOrder = DateFormat.getDateFormatOrder(getContext());
        int length = dateFormatOrder.length;
        for (int i10 = 0; i10 < length; i10++) {
            char c10 = dateFormatOrder[i10];
            if (c10 != 'M') {
                if (c10 != 'd') {
                    if (c10 == 'y') {
                        this.mSpinners.addView(this.mYearSpinner);
                        setImeOptions(this.mYearSpinner, length, i10);
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    this.mSpinners.addView(this.mDaySpinner);
                    setImeOptions(this.mDaySpinner, length, i10);
                }
            } else {
                this.mSpinners.addView(this.mMonthSpinner);
                setImeOptions(this.mMonthSpinner, length, i10);
            }
        }
    }

    private void setCurrentLocale(Locale locale) {
        if (locale.equals(this.mCurrentLocale)) {
            return;
        }
        this.mCurrentLocale = locale;
        this.mTempDate = getCalendarForLocale(this.mTempDate, locale);
        sMinDate = getCalendarForLocale(sMinDate, locale);
        sMaxDate = getCalendarForLocale(sMaxDate, locale);
        this.mCurrentDate = getCalendarForLocale(this.mCurrentDate, locale);
    }

    private void setDate(int i10, int i11, int i12) {
        this.mCurrentDate.set(i10, i11, i12);
        clampDate();
    }

    private void setImeOptions(COUINumberPicker cOUINumberPicker, int i10, int i11) {
        int i12;
        if (i11 < i10 - 1) {
            i12 = 5;
        } else {
            i12 = 6;
        }
        if (cOUINumberPicker.getChildCount() != 3) {
            Log.e(TAG, "spinner.getChildCount() != 3,It isn't init ok.return");
        } else {
            ((TextView) cOUINumberPicker.getChildAt(1)).setImeOptions(i12);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01bd A[LOOP:1: B:34:0x01bb->B:35:0x01bd, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void updateSpinners() {
        /*
            Method dump skipped, instructions count: 541
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.picker.COUILunarDatePicker.updateSpinners():void");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(this.mDaySpinner.getBackgroundColor());
        canvas.drawRect(this.mBackgroundLeft, (int) ((getHeight() / 2.0f) - this.mBackgroundRadius), getWidth() - this.mBackgroundLeft, r0 + this.mBackgroundDividerHeight, paint);
        canvas.drawRect(this.mBackgroundLeft, (int) ((getHeight() / 2.0f) + this.mBackgroundRadius), getWidth() - this.mBackgroundLeft, r0 + this.mBackgroundDividerHeight, paint);
        super.dispatchDraw(canvas);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    public CalendarView getCalendarView() {
        return null;
    }

    public boolean getCalendarViewShown() {
        return false;
    }

    public int getDayOfMonth() {
        return this.mCurrentDate.get(5);
    }

    public COUINumberPicker getDaySpinner() {
        return this.mDaySpinner;
    }

    public int getLeapMonth() {
        return COUILunarUtil.leapMonth(this.mCurrentDate.get(1));
    }

    public int[] getLunarDate() {
        return COUILunarUtil.calculateLunarByGregorian(this.mCurrentDate.get(1), this.mCurrentDate.get(2) + 1, this.mCurrentDate.get(5));
    }

    public long getMaxDate() {
        return sMaxDate.getTimeInMillis();
    }

    public long getMinDate() {
        return sMinDate.getTimeInMillis();
    }

    public int getMonth() {
        return this.mCurrentDate.get(2);
    }

    public COUINumberPicker getMonthSpinner() {
        return this.mMonthSpinner;
    }

    public OnDateChangedListener getOnDateChangedListener() {
        return this.mOnDateChangedListener;
    }

    public boolean getSpinnersShown() {
        return this.mSpinners.isShown();
    }

    public int getYear() {
        return this.mCurrentDate.get(1);
    }

    public COUINumberPicker getYearSpinner() {
        return this.mYearSpinner;
    }

    public void init(int i10, int i11, int i12, OnDateChangedListener onDateChangedListener) {
        setDate(i10, i11, i12);
        updateSpinners();
        updateCalendarView();
        this.mOnDateChangedListener = onDateChangedListener;
    }

    @Override // android.view.View
    public boolean isEnabled() {
        return this.mIsEnabled;
    }

    public boolean isLayoutRtl() {
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
            return true;
        }
        return false;
    }

    public boolean isLeapMonth(int i10) {
        if (i10 == COUILunarUtil.leapMonth(this.mCurrentDate.get(1))) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setCurrentLocale(configuration.locale);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        int i12 = this.mMaxWidth;
        if (i12 > 0 && size > i12) {
            size = i12;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, mode);
        this.mDaySpinner.clearNumberPickerPadding();
        this.mMonthSpinner.clearNumberPickerPadding();
        this.mYearSpinner.clearNumberPickerPadding();
        measureChildConstrained(this.mDaySpinner, i10, i11);
        measureChildConstrained(this.mMonthSpinner, i10, i11);
        measureChildConstrained(this.mYearSpinner, i10, i11);
        int measuredWidth = (((size - this.mDaySpinner.getMeasuredWidth()) - this.mMonthSpinner.getMeasuredWidth()) - this.mYearSpinner.getMeasuredWidth()) / 2;
        int childCount = this.mSpinners.getChildCount() - 1;
        if (this.mSpinners.getChildAt(0) instanceof COUINumberPicker) {
            ((COUINumberPicker) this.mSpinners.getChildAt(0)).setNumberPickerPaddingLeft(measuredWidth);
        }
        if (this.mSpinners.getChildAt(childCount) instanceof COUINumberPicker) {
            ((COUINumberPicker) this.mSpinners.getChildAt(childCount)).setNumberPickerPaddingRight(measuredWidth);
        }
        super.onMeasure(makeMeasureSpec, i11);
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.getText().add(getLunarDateString2(this.mCurrentDate));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setDate(savedState.mYear, savedState.mMonth, savedState.mDay);
        updateSpinners();
        updateCalendarView();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), getYear(), getMonth(), getDayOfMonth());
    }

    public void refresh() {
        COUINumberPicker cOUINumberPicker = this.mDaySpinner;
        if (cOUINumberPicker != null) {
            cOUINumberPicker.refresh();
        }
        COUINumberPicker cOUINumberPicker2 = this.mMonthSpinner;
        if (cOUINumberPicker2 != null) {
            cOUINumberPicker2.refresh();
        }
        COUINumberPicker cOUINumberPicker3 = this.mYearSpinner;
        if (cOUINumberPicker3 != null) {
            cOUINumberPicker3.refresh();
        }
    }

    public void scrollForceFinished() {
        COUINumberPicker cOUINumberPicker = this.mDaySpinner;
        if (cOUINumberPicker != null) {
            cOUINumberPicker.scrollForceFinished();
        }
        COUINumberPicker cOUINumberPicker2 = this.mMonthSpinner;
        if (cOUINumberPicker2 != null) {
            cOUINumberPicker2.scrollForceFinished();
        }
        COUINumberPicker cOUINumberPicker3 = this.mYearSpinner;
        if (cOUINumberPicker3 != null) {
            cOUINumberPicker3.scrollForceFinished();
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        if (this.mIsEnabled == z10) {
            return;
        }
        super.setEnabled(z10);
        this.mDaySpinner.setEnabled(z10);
        this.mMonthSpinner.setEnabled(z10);
        this.mYearSpinner.setEnabled(z10);
        this.mIsEnabled = z10;
    }

    public void setMaxDate(long j10) {
        this.mTempDate.setTimeInMillis(j10);
        if (this.mTempDate.get(1) == sMaxDate.get(1) && this.mTempDate.get(6) != sMaxDate.get(6)) {
            Log.w(TAG, "setMaxDate failed!:" + this.mTempDate.get(1) + "<->" + sMaxDate.get(1) + ":" + this.mTempDate.get(6) + "<->" + sMaxDate.get(6));
            return;
        }
        sMaxDate.setTimeInMillis(j10);
        if (this.mCurrentDate.after(sMaxDate)) {
            this.mCurrentDate.setTimeInMillis(sMaxDate.getTimeInMillis());
            updateCalendarView();
        }
        updateSpinners();
    }

    public void setMinDate(long j10) {
        this.mTempDate.setTimeInMillis(j10);
        if (this.mTempDate.get(1) == sMinDate.get(1) && this.mTempDate.get(6) != sMinDate.get(6)) {
            Log.w(TAG, "setMinDate failed!:" + this.mTempDate.get(1) + "<->" + sMinDate.get(1) + ":" + this.mTempDate.get(6) + "<->" + sMinDate.get(6));
            return;
        }
        sMinDate.setTimeInMillis(j10);
        if (this.mCurrentDate.before(sMinDate)) {
            this.mCurrentDate.setTimeInMillis(sMinDate.getTimeInMillis());
            updateCalendarView();
        }
        updateSpinners();
    }

    public void setNormalTextColor(int i10) {
        COUINumberPicker cOUINumberPicker = this.mDaySpinner;
        if (cOUINumberPicker != null) {
            cOUINumberPicker.setNormalTextColor(i10);
        }
        COUINumberPicker cOUINumberPicker2 = this.mMonthSpinner;
        if (cOUINumberPicker2 != null) {
            cOUINumberPicker2.setNormalTextColor(i10);
        }
        COUINumberPicker cOUINumberPicker3 = this.mYearSpinner;
        if (cOUINumberPicker3 != null) {
            cOUINumberPicker3.setNormalTextColor(i10);
        }
    }

    public void setOnDateChangedListener(OnDateChangedListener onDateChangedListener) {
        this.mOnDateChangedListener = onDateChangedListener;
    }

    public void setSpinnersShown(boolean z10) {
        int i10;
        LinearLayout linearLayout = this.mSpinners;
        if (z10) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        linearLayout.setVisibility(i10);
    }

    public void setVibrateIntensity(float f10) {
        this.mDaySpinner.setVibrateIntensity(f10);
        this.mMonthSpinner.setVibrateIntensity(f10);
        this.mYearSpinner.setVibrateIntensity(f10);
    }

    public void setVibrateLevel(int i10) {
        this.mDaySpinner.setVibrateLevel(i10);
        this.mMonthSpinner.setVibrateLevel(i10);
        this.mYearSpinner.setVibrateLevel(i10);
    }

    public void updateDate(int i10, int i11, int i12) {
        if (!isNewDate(i10, i11, i12)) {
            return;
        }
        setDate(i10, i11, i12);
        updateSpinners();
        updateCalendarView();
        notifyDateChanged();
    }

    /* loaded from: classes.dex */
    public static class IncompleteDate {
        public static final int LEAP_MONTH_ADDED_VALUE = 12;
        private Calendar mDate;
        private int mDay;
        private int mHour;
        private boolean mIsIncomplete;
        private int mMinute;
        private int mMonth;
        private int mYear;

        public IncompleteDate() {
            init(Calendar.getInstance());
        }

        public void add(int i10, int i11) {
            if (!this.mIsIncomplete) {
                this.mDate.add(i10, i11);
            } else if (i10 == 5) {
                this.mDay += i11;
            } else if (i10 == 2) {
                this.mMonth += i11;
            }
        }

        public boolean after(Calendar calendar) {
            if (!this.mIsIncomplete) {
                return this.mDate.after(calendar);
            }
            return false;
        }

        public boolean afterOrEqual(Calendar calendar) {
            if (this.mIsIncomplete) {
                return false;
            }
            if (!this.mDate.after(calendar) && !this.mDate.equals(calendar)) {
                return false;
            }
            return true;
        }

        public boolean before(Calendar calendar) {
            if (!this.mIsIncomplete) {
                return this.mDate.before(calendar);
            }
            return false;
        }

        public boolean beforeOrEqual(Calendar calendar) {
            if (this.mIsIncomplete) {
                return false;
            }
            if (!this.mDate.before(calendar) && !this.mDate.equals(calendar)) {
                return false;
            }
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x006c  */
        /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void change(int r7, int r8, int r9) {
            /*
                Method dump skipped, instructions count: 244
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.picker.COUILunarDatePicker.IncompleteDate.change(int, int, int):void");
        }

        public void clampDate(Calendar calendar, Calendar calendar2) {
            if (!this.mIsIncomplete) {
                if (this.mDate.before(calendar)) {
                    setTimeInMillis(calendar.getTimeInMillis());
                } else if (this.mDate.after(calendar2)) {
                    setTimeInMillis(calendar2.getTimeInMillis());
                }
            }
        }

        public void clear() {
            this.mDate.clear();
            this.mYear = 0;
            this.mMonth = 0;
            this.mDay = 0;
            this.mHour = 0;
            this.mMinute = 0;
            this.mIsIncomplete = false;
        }

        public int get(int i10) {
            if (!this.mIsIncomplete) {
                return this.mDate.get(i10);
            }
            if (i10 == 5) {
                return this.mDay;
            }
            if (i10 == 2) {
                return this.mMonth;
            }
            if (i10 == 1) {
                return this.mYear;
            }
            return this.mDate.get(i10);
        }

        public int getActualMaximum(int i10) {
            return this.mDate.getActualMaximum(i10);
        }

        public int getActualMinimum(int i10) {
            return this.mDate.getActualMinimum(i10);
        }

        public Date getTime() {
            return this.mDate.getTime();
        }

        public long getTimeInMillis() {
            return this.mDate.getTimeInMillis();
        }

        public void init(Calendar calendar) {
            this.mDate = calendar;
            this.mIsIncomplete = false;
        }

        public void set(int i10, int i11, int i12) {
            if (i10 != Integer.MIN_VALUE) {
                this.mDate.set(1, i10);
                this.mDate.set(2, i11);
                this.mDate.set(5, i12);
                this.mIsIncomplete = false;
                return;
            }
            this.mYear = Integer.MIN_VALUE;
            this.mMonth = i11;
            this.mDay = i12;
            this.mIsIncomplete = true;
        }

        public void setTimeInMillis(long j10) {
            this.mDate.setTimeInMillis(j10);
            this.mIsIncomplete = false;
        }

        public void setWith(IncompleteDate incompleteDate) {
            this.mDate.setTimeInMillis(incompleteDate.mDate.getTimeInMillis());
            this.mYear = incompleteDate.mYear;
            this.mMonth = incompleteDate.mMonth;
            this.mDay = incompleteDate.mDay;
            this.mHour = incompleteDate.mHour;
            this.mMinute = incompleteDate.mMinute;
            this.mIsIncomplete = incompleteDate.mIsIncomplete;
        }

        public IncompleteDate(Locale locale) {
            init(Calendar.getInstance(locale));
        }

        public void set(int i10, int i11, int i12, int i13, int i14) {
            if (i10 != Integer.MIN_VALUE) {
                this.mDate.set(1, i10);
                this.mDate.set(2, i11);
                this.mDate.set(5, i12);
                this.mDate.set(11, i13);
                this.mDate.set(12, i14);
                this.mIsIncomplete = false;
                return;
            }
            this.mYear = Integer.MIN_VALUE;
            this.mMonth = i11;
            this.mDay = i12;
            this.mHour = i13;
            this.mMinute = i14;
            this.mIsIncomplete = true;
        }
    }

    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.coui.appcompat.picker.COUILunarDatePicker.SavedState.1
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
        private final int mDay;
        private final int mMonth;
        private final int mYear;

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.mYear);
            parcel.writeInt(this.mMonth);
            parcel.writeInt(this.mDay);
        }

        private SavedState(Parcelable parcelable, int i10, int i11, int i12) {
            super(parcelable);
            this.mYear = i10;
            this.mMonth = i11;
            this.mDay = i12;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.mYear = parcel.readInt();
            this.mMonth = parcel.readInt();
            this.mDay = parcel.readInt();
        }
    }

    public COUILunarDatePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.f6464b);
    }

    public COUILunarDatePicker(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, l.f6709o);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDate(IncompleteDate incompleteDate) {
        this.mCurrentDate.setWith(incompleteDate);
        clampDate();
    }

    public COUILunarDatePicker(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.mNumberOfMonths = 12;
        this.mIsEnabled = true;
        COUIDarkModeUtil.setForceDarkAllow(this, false);
        setCurrentLocale(Locale.getDefault());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.f6898r0, i10, i11);
        this.mYearIgnorable = obtainStyledAttributes.getBoolean(m.f6902s0, false);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, m.f6891p1, i10, i11);
        this.mMaxWidth = obtainStyledAttributes2.getDimensionPixelSize(m.f6895q1, 0);
        obtainStyledAttributes2.recycle();
        this.mBackgroundDividerHeight = Math.max(getResources().getDimensionPixelOffset(d.f6511I), 1);
        int i12 = h.f6664g;
        this.mShortMonths = getResources().getStringArray(C0426a.f6459a);
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(i12, (ViewGroup) this, true);
        sLeapString = getResources().getString(k.f6677c);
        COUINumberPicker.OnValueChangeListener onValueChangeListener = new COUINumberPicker.OnValueChangeListener() { // from class: com.coui.appcompat.picker.COUILunarDatePicker.1
            @Override // com.coui.appcompat.picker.COUINumberPicker.OnValueChangeListener
            public void onValueChange(COUINumberPicker cOUINumberPicker, int i13, int i14) {
                COUILunarDatePicker.this.mTempDate.setWith(COUILunarDatePicker.this.mCurrentDate);
                COUILunarUtil.calculateLunarByGregorian(COUILunarDatePicker.this.mTempDate.get(1), COUILunarDatePicker.this.mTempDate.get(2) + 1, COUILunarDatePicker.this.mTempDate.get(5));
                if (cOUINumberPicker == COUILunarDatePicker.this.mDaySpinner) {
                    COUILunarDatePicker.this.mTempDate.change(5, i13, i14);
                } else if (cOUINumberPicker == COUILunarDatePicker.this.mMonthSpinner) {
                    COUILunarDatePicker.this.mTempDate.change(2, i13, i14);
                } else if (cOUINumberPicker == COUILunarDatePicker.this.mYearSpinner) {
                    COUILunarDatePicker.this.mTempDate.change(1, i13, i14);
                } else {
                    throw new IllegalArgumentException();
                }
                COUILunarDatePicker cOUILunarDatePicker = COUILunarDatePicker.this;
                cOUILunarDatePicker.setDate(cOUILunarDatePicker.mTempDate);
                COUILunarDatePicker.this.updateSpinners();
                COUILunarDatePicker.this.updateCalendarView();
                COUILunarDatePicker.this.notifyDateChanged();
            }
        };
        COUINumberPicker.OnScrollingStopListener onScrollingStopListener = new COUINumberPicker.OnScrollingStopListener() { // from class: com.coui.appcompat.picker.COUILunarDatePicker.2
            @Override // com.coui.appcompat.picker.COUINumberPicker.OnScrollingStopListener
            public void onScrollingStop() {
                COUILunarDatePicker.this.sendAccessibilityEvent(4);
            }
        };
        this.mSpinners = (LinearLayout) findViewById(f.f6620J);
        COUINumberPicker cOUINumberPicker = (COUINumberPicker) findViewById(f.f6652v);
        this.mDaySpinner = cOUINumberPicker;
        cOUINumberPicker.setOnLongPressUpdateInterval(100L);
        cOUINumberPicker.setOnValueChangedListener(onValueChangeListener);
        cOUINumberPicker.setOnScrollingStopListener(onScrollingStopListener);
        COUINumberPicker cOUINumberPicker2 = (COUINumberPicker) findViewById(f.f6617G);
        this.mMonthSpinner = cOUINumberPicker2;
        cOUINumberPicker2.setMinValue(0);
        cOUINumberPicker2.setMaxValue(this.mNumberOfMonths - 1);
        cOUINumberPicker2.setDisplayedValues(this.mShortMonths);
        cOUINumberPicker2.setOnLongPressUpdateInterval(200L);
        cOUINumberPicker2.setOnValueChangedListener(onValueChangeListener);
        cOUINumberPicker2.setOnScrollingStopListener(onScrollingStopListener);
        COUINumberPicker cOUINumberPicker3 = (COUINumberPicker) findViewById(f.f6629S);
        this.mYearSpinner = cOUINumberPicker3;
        cOUINumberPicker3.setOnLongPressUpdateInterval(100L);
        cOUINumberPicker3.setOnValueChangedListener(onValueChangeListener);
        cOUINumberPicker3.setOnScrollingStopListener(onScrollingStopListener);
        cOUINumberPicker3.setIgnorable(this.mYearIgnorable);
        setSpinnersShown(true);
        setCalendarViewShown(true);
        this.mTempDate.clear();
        this.mTempDate.set(DEFAULT_START_YEAR, 0, 1);
        setMinDate(this.mTempDate.getTimeInMillis());
        this.mTempDate.clear();
        this.mTempDate.set(DEFAULT_END_YEAR, 11, 31, 23, 59);
        setMaxDate(this.mTempDate.getTimeInMillis());
        this.mCurrentDate.setTimeInMillis(System.currentTimeMillis());
        init(this.mCurrentDate.get(1), this.mCurrentDate.get(2), this.mCurrentDate.get(5), null);
        if (cOUINumberPicker3.isAccessibilityEnable()) {
            String string = context.getResources().getString(k.f6691q);
            cOUINumberPicker3.addTalkbackSuffix(string);
            cOUINumberPicker2.addTalkbackSuffix(string);
            cOUINumberPicker.addTalkbackSuffix(string);
        }
        this.mBackgroundRadius = context.getResources().getDimensionPixelOffset(d.f6581n0);
        this.mBackgroundLeft = context.getResources().getDimensionPixelOffset(d.f6579m0);
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    private static String getLunarDateString(int i10, int i11, int i12, int i13) {
        if (i11 <= 0) {
            return "";
        }
        if (i10 != Integer.MIN_VALUE) {
            StringBuilder sb = new StringBuilder();
            sb.append(i10);
            sb.append("年");
            sb.append(i13 == 0 ? sLeapString : "");
            sb.append(CHINESE_NUMBER[i11 - 1]);
            sb.append("月");
            sb.append(COUILunarUtil.chineseStringOfALunarDay(i12));
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i13 == 0 ? sLeapString : "");
        sb2.append(CHINESE_NUMBER[i11 - 1]);
        sb2.append("月");
        sb2.append(COUILunarUtil.chineseStringOfALunarDay(i12));
        return sb2.toString();
    }

    private Calendar getCalendarForLocale(Calendar calendar, Locale locale) {
        if (calendar == null) {
            return Calendar.getInstance(locale);
        }
        long timeInMillis = calendar.getTimeInMillis();
        Calendar calendar2 = Calendar.getInstance(locale);
        calendar2.setTimeInMillis(timeInMillis);
        return calendar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCalendarView() {
    }

    public void setCalendarViewShown(boolean z10) {
    }
}
