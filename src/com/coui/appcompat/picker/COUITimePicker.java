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
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.provider.Settings;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.android.incallui.OplusPhoneUtils;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import com.coui.appcompat.picker.COUINumberPicker;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes.dex */
public class COUITimePicker extends FrameLayout {
    private static final int HOURS_OF_A_DAY = 23;
    private static final int HOURS_OF_HALF_DAY = 12;
    private static final int LEAPYEAR_STEP_FOUR = 4;
    private static final int LEAPYEAR_STEP_FOUR_HUN = 400;
    private static final int LEAPYEAR_STEP_HUN = 100;
    private static final long MILLISECOND_A_DAY = 86400000;
    private static final int MINUTES_OF_A_HOUR = 59;
    private static final int MINUTES_STEP = 5;
    private static final int MIN_BACKGROUND_DIVIDER_HEIGHT = 1;
    private static final int START_YEAR = 1900;
    private static final String TAG = "COUITimePicker";
    private static final int TOTAL_YEAR = 100;
    private static final int YEAR_AMOUNT_LEAP = 366;
    private static final int YEAR_AMOUNT_NOT_LEAP = 365;

    /* renamed from: f, reason: collision with root package name */
    private Format f19833f;
    private int mAmPm;
    private int mBackgroundDividerHeight;
    private int mBackgroundLeft;
    private int mBackgroundRadius;
    private Calendar mCalendar;
    private Context mContext;
    private String[] mDateNamesTemp;
    private Calendar mDefaultCalendar;
    private Date mEndDate;
    private boolean mIsMinuteFiveStep;
    int mLeftPickerPosition;
    private int mMaxWidth;
    private OnTimeChangeListener mOnTimeChangeListener;
    private SimpleDateFormat mOutformatter;
    private COUINumberPicker mPickerAmPm;
    private COUINumberPicker mPickerDate;
    private COUINumberPicker mPickerHour;
    private LinearLayout mPickerLayout;
    private COUINumberPicker mPickerMinute;
    int mRightPickerPosition;
    private long mStartTime;
    private String[] mTextAMPM;
    private String[] mTextDates;
    private String mTextDay;
    private String mTextToday;
    private Calendar mTodayCalendar;
    private int mTodayDate;
    private int mTodayIndex;
    private int mTodayMonth;
    private int mTodayYear;
    private String selectedDateUtterance;

    /* loaded from: classes.dex */
    public class Format implements COUINumberPicker.Formatter {
        public Format() {
        }

        @Override // com.coui.appcompat.picker.COUINumberPicker.Formatter
        public String format(int i10) {
            int i11 = i10 - 1;
            COUITimePicker.this.mDateNamesTemp[i11] = COUITimePicker.this.getDateYMDW(i10);
            if (i10 == COUITimePicker.this.mTodayIndex) {
                COUITimePicker.this.mTextDates[i11] = COUITimePicker.this.mTextToday;
                return COUITimePicker.this.mTextDates[i11];
            }
            if (Locale.getDefault().getLanguage().equals("zh")) {
                return new SimpleDateFormat("MMMdd" + COUITimePicker.this.mTextDay + " E", Locale.getDefault()).format(Long.valueOf(COUITimePicker.this.mEndDate.getTime()));
            }
            return DateUtils.formatDateTime(COUITimePicker.this.getContext(), COUITimePicker.this.mEndDate.getTime(), 524314);
        }
    }

    /* loaded from: classes.dex */
    public interface OnTimeChangeListener {
        void onTimeChange(View view, Calendar calendar);
    }

    public COUITimePicker(Context context) {
        this(context, null);
    }

    private String deduplicate(String str) {
        String valueOf = String.valueOf(str.charAt(0));
        for (int i10 = 1; i10 < str.length(); i10++) {
            char charAt = str.charAt(i10);
            if (charAt != str.charAt(i10 - 1)) {
                valueOf = valueOf + charAt;
            }
        }
        return valueOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Date getDateFromValue(int i10) {
        try {
            return this.mOutformatter.parse(this.mDateNamesTemp[i10 - 1]);
        } catch (ParseException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getDateYMDW(int i10) {
        this.mEndDate.setTime(this.mStartTime + (i10 * MILLISECOND_A_DAY));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.mEndDate);
        if (isToday(calendar.get(1), calendar.get(2), calendar.get(5))) {
            this.mTodayIndex = i10;
        } else {
            this.mTodayIndex = -1;
        }
        return this.mOutformatter.format(Long.valueOf(this.mEndDate.getTime()));
    }

    private int getDaysAmountOfYear(int i10) {
        if (isLeapYear(i10)) {
            return YEAR_AMOUNT_LEAP;
        }
        return YEAR_AMOUNT_NOT_LEAP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean is24Hours() {
        String string = Settings.System.getString(this.mContext.getContentResolver(), "time_12_24");
        if (string != null && string.equals("24")) {
            return true;
        }
        return false;
    }

    private boolean isLeapYear(int i10) {
        if ((i10 % 4 == 0 && i10 % 100 != 0) || i10 % 400 == 0) {
            return true;
        }
        return false;
    }

    private boolean isToday(int i10, int i11, int i12) {
        if (i10 == this.mTodayYear && i11 == this.mTodayMonth && i12 == this.mTodayDate) {
            return true;
        }
        return false;
    }

    private void measureChildConstrained(View view, int i10, int i11, float f10) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (f10 < 1.0f) {
            marginLayoutParams.width = (int) (marginLayoutParams.width * f10);
        }
        view.measure(ViewGroup.getChildMeasureSpec(i10, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i11, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height));
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0046, code lost:
    
        if (r5 != 'y') goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void reorderSpinners() {
        /*
            r9 = this;
            java.util.Locale r0 = java.util.Locale.getDefault()
            java.lang.String r1 = "yyyyMMMddhm"
            java.lang.String r0 = android.text.format.DateFormat.getBestDateTimePattern(r0, r1)
            java.lang.String r0 = r9.deduplicate(r0)
            com.coui.appcompat.picker.COUINumberPicker r1 = r9.mPickerDate
            android.view.ViewParent r1 = r1.getParent()
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            r1.removeAllViews()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r3 = 0
            r4 = r3
        L21:
            int r5 = r0.length()
            if (r3 >= r5) goto Lb4
            char r5 = r0.charAt(r3)
            r6 = 75
            r7 = 1
            if (r5 == r6) goto L6d
            r6 = 77
            if (r5 == r6) goto L5f
            r6 = 97
            if (r5 == r6) goto L54
            r6 = 100
            if (r5 == r6) goto L5f
            r6 = 104(0x68, float:1.46E-43)
            if (r5 == r6) goto L6d
            r6 = 109(0x6d, float:1.53E-43)
            if (r5 == r6) goto L49
            r6 = 121(0x79, float:1.7E-43)
            if (r5 == r6) goto L5f
            goto L77
        L49:
            com.coui.appcompat.picker.COUINumberPicker r5 = r9.mPickerMinute
            r1.addView(r5)
            java.lang.String r5 = "m"
            r2.add(r5)
            goto L77
        L54:
            com.coui.appcompat.picker.COUINumberPicker r5 = r9.mPickerAmPm
            r1.addView(r5)
            java.lang.String r5 = "a"
            r2.add(r5)
            goto L77
        L5f:
            if (r4 != 0) goto L77
            com.coui.appcompat.picker.COUINumberPicker r4 = r9.mPickerDate
            r1.addView(r4)
            java.lang.String r4 = "D"
            r2.add(r4)
            r4 = r7
            goto L77
        L6d:
            com.coui.appcompat.picker.COUINumberPicker r5 = r9.mPickerHour
            r1.addView(r5)
            java.lang.String r5 = "h"
            r2.add(r5)
        L77:
            boolean r5 = r9.is24Hours()
            r6 = -1
            if (r5 != 0) goto L91
            int r5 = r9.mLeftPickerPosition
            if (r5 != r6) goto L89
            int r5 = r1.getChildCount()
            int r5 = r5 - r7
            r9.mLeftPickerPosition = r5
        L89:
            int r5 = r1.getChildCount()
            int r5 = r5 - r7
            r9.mRightPickerPosition = r5
            goto Lb0
        L91:
            int r5 = r1.getChildCount()
            int r5 = r5 - r7
            android.view.View r5 = r1.getChildAt(r5)
            com.coui.appcompat.picker.COUINumberPicker r8 = r9.mPickerAmPm
            if (r5 == r8) goto Lb0
            int r5 = r9.mLeftPickerPosition
            if (r5 != r6) goto La9
            int r5 = r1.getChildCount()
            int r5 = r5 - r7
            r9.mLeftPickerPosition = r5
        La9:
            int r5 = r1.getChildCount()
            int r5 = r5 - r7
            r9.mRightPickerPosition = r5
        Lb0:
            int r3 = r3 + 1
            goto L21
        Lb4:
            boolean r0 = r9.isLayoutRtl()
            if (r0 == 0) goto Lc2
            int r0 = r9.mLeftPickerPosition
            int r1 = r9.mRightPickerPosition
            r9.mLeftPickerPosition = r1
            r9.mRightPickerPosition = r0
        Lc2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.picker.COUITimePicker.reorderSpinners():void");
    }

    private void reorderUtterance() {
        String str;
        this.selectedDateUtterance = "";
        String deduplicate = deduplicate(DateFormat.getBestDateTimePattern(Locale.getDefault(), "yyyyMMMddhm"));
        boolean z10 = false;
        for (int i10 = 0; i10 < deduplicate.length(); i10++) {
            char charAt = deduplicate.charAt(i10);
            if (charAt != 'K') {
                if (charAt != 'M') {
                    if (charAt != 'a') {
                        if (charAt != 'd') {
                            if (charAt != 'h') {
                                if (charAt == 'm') {
                                    this.selectedDateUtterance += this.mPickerMinute.getValue() + this.mContext.getString(k.f6678d);
                                } else if (charAt != 'y') {
                                }
                            }
                        }
                    } else if (!is24Hours()) {
                        if (is24Hours()) {
                            str = this.mTextAMPM[0];
                        } else {
                            str = this.mTextAMPM[1];
                        }
                        this.selectedDateUtterance += str;
                    }
                }
                if (!z10) {
                    this.selectedDateUtterance += this.f19833f.format(this.mPickerDate.getValue());
                    z10 = true;
                }
            }
            this.selectedDateUtterance += this.mPickerHour.getValue() + this.mContext.getString(k.f6676b);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        if (!is24Hours()) {
            this.mBackgroundLeft = 0;
        }
        Paint paint = new Paint();
        paint.setColor(this.mPickerDate.getBackgroundColor());
        canvas.drawRect(this.mBackgroundLeft, (int) ((getHeight() / 2.0f) - this.mBackgroundRadius), getWidth() - this.mBackgroundLeft, r1 + this.mBackgroundDividerHeight, paint);
        canvas.drawRect(this.mBackgroundLeft, (int) ((getHeight() / 2.0f) + this.mBackgroundRadius), getWidth() - this.mBackgroundLeft, r1 + this.mBackgroundDividerHeight, paint);
        super.dispatchDraw(canvas);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    public COUINumberPicker getPickerAmPm() {
        return this.mPickerAmPm;
    }

    public COUINumberPicker getPickerDate() {
        return this.mPickerDate;
    }

    public COUINumberPicker getPickerHour() {
        return this.mPickerHour;
    }

    public COUINumberPicker getPickerMinute() {
        return this.mPickerMinute;
    }

    public View getTimePicker() {
        int i10;
        StringBuilder sb;
        Calendar calendar = this.mDefaultCalendar;
        if (calendar != null) {
            i10 = calendar.get(1);
        } else {
            calendar = this.mTodayCalendar;
            i10 = calendar.get(1);
        }
        int i11 = i10;
        int i12 = calendar.get(2);
        int i13 = i12 + 1;
        int i14 = calendar.get(5);
        int i15 = calendar.get(11);
        int i16 = calendar.get(9);
        int i17 = calendar.get(12);
        this.mCalendar.setTimeZone(calendar.getTimeZone());
        this.mOutformatter.setTimeZone(calendar.getTimeZone());
        this.mCalendar.set(i11, i12, i14, i15, i17);
        int i18 = 36500;
        for (int i19 = 0; i19 < 100; i19++) {
            i18 += getDaysAmountOfYear((i11 - 50) + i19);
        }
        int i20 = 0;
        for (int i21 = 0; i21 < 50; i21++) {
            i20 += getDaysAmountOfYear((i11 - 50) + i21);
        }
        String[] strArr = new String[i18];
        this.mTextDates = strArr;
        this.mDateNamesTemp = (String[]) strArr.clone();
        if (i13 > 2 && !isLeapYear(i11 - 50) && isLeapYear(i11)) {
            i20++;
        }
        if (i13 > 2 && isLeapYear(i11 - 50)) {
            i20--;
        }
        int i22 = i20;
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeZone(calendar.getTimeZone());
        int i23 = i18;
        calendar2.set(i11, i12, i14, i15, i17);
        if (isLeapYear(i11) && i13 == 2 && i14 == 29) {
            calendar2.add(5, 1);
        }
        calendar2.add(1, -50);
        this.mStartTime = calendar2.getTimeInMillis();
        this.mEndDate = new Date();
        if (is24Hours()) {
            this.mPickerHour.setMaxValue(23);
            this.mPickerHour.setMinValue(0);
            this.mPickerHour.setTwoDigitFormatter();
            this.mPickerAmPm.setVisibility(8);
        } else {
            this.mPickerHour.setMaxValue(12);
            this.mPickerHour.setMinValue(1);
            this.mPickerAmPm.setMaxValue(this.mTextAMPM.length - 1);
            this.mPickerAmPm.setMinValue(0);
            this.mPickerAmPm.setDisplayedValues(this.mTextAMPM);
            this.mPickerAmPm.setVisibility(0);
            this.mPickerAmPm.setWrapSelectorWheel(false);
        }
        this.mPickerHour.setWrapSelectorWheel(true);
        if (is24Hours()) {
            this.mPickerHour.setValue(i15);
        } else {
            if (i16 > 0) {
                this.mPickerHour.setValue(i15 - 12);
            } else {
                this.mPickerHour.setValue(i15);
            }
            this.mPickerAmPm.setValue(i16);
            this.mAmPm = i16;
        }
        this.mPickerAmPm.setOnValueChangedListener(new COUINumberPicker.OnValueChangeListener() { // from class: com.coui.appcompat.picker.COUITimePicker.1
            @Override // com.coui.appcompat.picker.COUINumberPicker.OnValueChangeListener
            public void onValueChange(COUINumberPicker cOUINumberPicker, int i24, int i25) {
                COUITimePicker.this.mAmPm = cOUINumberPicker.getValue();
                COUITimePicker.this.mCalendar.set(9, cOUINumberPicker.getValue());
                if (COUITimePicker.this.mOnTimeChangeListener != null) {
                    OnTimeChangeListener onTimeChangeListener = COUITimePicker.this.mOnTimeChangeListener;
                    COUITimePicker cOUITimePicker = COUITimePicker.this;
                    onTimeChangeListener.onTimeChange(cOUITimePicker, cOUITimePicker.mCalendar);
                }
            }
        });
        this.mPickerAmPm.setOnScrollingStopListener(new COUINumberPicker.OnScrollingStopListener() { // from class: com.coui.appcompat.picker.COUITimePicker.2
            @Override // com.coui.appcompat.picker.COUINumberPicker.OnScrollingStopListener
            public void onScrollingStop() {
                COUITimePicker.this.sendAccessibilityEvent(4);
            }
        });
        this.mPickerHour.setOnValueChangedListener(new COUINumberPicker.OnValueChangeListener() { // from class: com.coui.appcompat.picker.COUITimePicker.3
            @Override // com.coui.appcompat.picker.COUINumberPicker.OnValueChangeListener
            public void onValueChange(COUINumberPicker cOUINumberPicker, int i24, int i25) {
                if (!COUITimePicker.this.is24Hours() && COUITimePicker.this.mAmPm != 0) {
                    if (COUITimePicker.this.mAmPm == 1) {
                        if (cOUINumberPicker.getValue() != 12) {
                            COUITimePicker.this.mCalendar.set(11, cOUINumberPicker.getValue() + 12);
                        } else {
                            COUITimePicker.this.mCalendar.set(11, 0);
                        }
                    }
                } else {
                    COUITimePicker.this.mCalendar.set(11, cOUINumberPicker.getValue());
                }
                if (!COUITimePicker.this.is24Hours() && cOUINumberPicker.getValue() == 12) {
                    COUITimePicker cOUITimePicker = COUITimePicker.this;
                    cOUITimePicker.mAmPm = 1 - cOUITimePicker.mAmPm;
                    COUITimePicker.this.mPickerAmPm.setValue(COUITimePicker.this.mAmPm);
                }
                if (COUITimePicker.this.mOnTimeChangeListener != null) {
                    OnTimeChangeListener onTimeChangeListener = COUITimePicker.this.mOnTimeChangeListener;
                    COUITimePicker cOUITimePicker2 = COUITimePicker.this;
                    onTimeChangeListener.onTimeChange(cOUITimePicker2, cOUITimePicker2.mCalendar);
                }
            }
        });
        this.mPickerHour.setOnScrollingStopListener(new COUINumberPicker.OnScrollingStopListener() { // from class: com.coui.appcompat.picker.COUITimePicker.4
            @Override // com.coui.appcompat.picker.COUINumberPicker.OnScrollingStopListener
            public void onScrollingStop() {
                COUITimePicker.this.sendAccessibilityEvent(4);
            }
        });
        this.mPickerMinute.setMinValue(0);
        if (this.mIsMinuteFiveStep) {
            this.mPickerMinute.setMinValue(0);
            this.mPickerMinute.setMaxValue(11);
            String[] strArr2 = new String[12];
            int i24 = 0;
            for (int i25 = 12; i24 < i25; i25 = 12) {
                int i26 = i24 * 5;
                if (i26 < 10) {
                    sb = new StringBuilder();
                    sb.append(OplusPhoneUtils.DeviceState.UNLOCK_DEVICE);
                    sb.append(i26);
                } else {
                    sb = new StringBuilder();
                    sb.append(i26);
                    sb.append("");
                }
                strArr2[i24] = sb.toString();
                i24++;
            }
            this.mPickerMinute.setDisplayedValues(strArr2);
            int i27 = i17 / 5;
            this.mPickerMinute.setValue(i27);
            this.mCalendar.set(12, Integer.parseInt(strArr2[i27]));
        } else {
            this.mPickerMinute.setMaxValue(59);
            this.mPickerMinute.setValue(i17);
        }
        this.mPickerMinute.setTwoDigitFormatter();
        this.mPickerMinute.setWrapSelectorWheel(true);
        this.mPickerMinute.setOnValueChangedListener(new COUINumberPicker.OnValueChangeListener() { // from class: com.coui.appcompat.picker.COUITimePicker.5
            @Override // com.coui.appcompat.picker.COUINumberPicker.OnValueChangeListener
            public void onValueChange(COUINumberPicker cOUINumberPicker, int i28, int i29) {
                if (COUITimePicker.this.mIsMinuteFiveStep) {
                    COUITimePicker.this.mCalendar.set(12, cOUINumberPicker.getValue() * 5);
                } else {
                    COUITimePicker.this.mCalendar.set(12, cOUINumberPicker.getValue());
                }
                if (COUITimePicker.this.mOnTimeChangeListener != null) {
                    OnTimeChangeListener onTimeChangeListener = COUITimePicker.this.mOnTimeChangeListener;
                    COUITimePicker cOUITimePicker = COUITimePicker.this;
                    onTimeChangeListener.onTimeChange(cOUITimePicker, cOUITimePicker.mCalendar);
                }
            }
        });
        this.mPickerMinute.setOnScrollingStopListener(new COUINumberPicker.OnScrollingStopListener() { // from class: com.coui.appcompat.picker.COUITimePicker.6
            @Override // com.coui.appcompat.picker.COUINumberPicker.OnScrollingStopListener
            public void onScrollingStop() {
                COUITimePicker.this.sendAccessibilityEvent(4);
            }
        });
        this.mPickerDate.setMinValue(1);
        this.mPickerDate.setMaxValue(i23);
        this.mPickerDate.setWrapSelectorWheel(false);
        this.mPickerDate.setValue(i22);
        Format format = new Format();
        this.f19833f = format;
        this.mPickerDate.setFormatter(format);
        this.mPickerDate.setOnValueChangedListener(new COUINumberPicker.OnValueChangeListener() { // from class: com.coui.appcompat.picker.COUITimePicker.7
            @Override // com.coui.appcompat.picker.COUINumberPicker.OnValueChangeListener
            public void onValueChange(COUINumberPicker cOUINumberPicker, int i28, int i29) {
                Date dateFromValue = COUITimePicker.this.getDateFromValue(cOUINumberPicker.getValue());
                if (dateFromValue != null) {
                    COUITimePicker.this.mCalendar.set(2, dateFromValue.getMonth());
                    COUITimePicker.this.mCalendar.set(5, dateFromValue.getDate());
                    COUITimePicker.this.mCalendar.set(1, dateFromValue.getYear() + 1900);
                    if (COUITimePicker.this.mOnTimeChangeListener != null) {
                        OnTimeChangeListener onTimeChangeListener = COUITimePicker.this.mOnTimeChangeListener;
                        COUITimePicker cOUITimePicker = COUITimePicker.this;
                        onTimeChangeListener.onTimeChange(cOUITimePicker, cOUITimePicker.mCalendar);
                    }
                }
            }
        });
        this.mPickerDate.setOnScrollingStopListener(new COUINumberPicker.OnScrollingStopListener() { // from class: com.coui.appcompat.picker.COUITimePicker.8
            @Override // com.coui.appcompat.picker.COUINumberPicker.OnScrollingStopListener
            public void onScrollingStop() {
                COUITimePicker.this.sendAccessibilityEvent(4);
            }
        });
        return this;
    }

    public boolean isLayoutRtl() {
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
            return true;
        }
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int measuredWidth;
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        int i12 = this.mMaxWidth;
        if (i12 > 0 && size > i12) {
            size = i12;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, mode);
        this.mPickerMinute.clearNumberPickerPadding();
        this.mPickerHour.clearNumberPickerPadding();
        this.mPickerDate.clearNumberPickerPadding();
        this.mPickerAmPm.clearNumberPickerPadding();
        float f10 = size / (((this.mPickerMinute.getLayoutParams().width + this.mPickerHour.getLayoutParams().width) + this.mPickerDate.getLayoutParams().width) + this.mPickerAmPm.getLayoutParams().width);
        measureChildConstrained(this.mPickerMinute, i10, i11, f10);
        measureChildConstrained(this.mPickerHour, i10, i11, f10);
        measureChildConstrained(this.mPickerDate, i10, i11, f10);
        measureChildConstrained(this.mPickerAmPm, i10, i11, f10);
        int measuredWidth2 = ((size - this.mPickerMinute.getMeasuredWidth()) - this.mPickerHour.getMeasuredWidth()) - this.mPickerDate.getMeasuredWidth();
        if (is24Hours()) {
            measuredWidth = 0;
        } else {
            measuredWidth = this.mPickerAmPm.getMeasuredWidth();
        }
        int i13 = (measuredWidth2 - measuredWidth) / 2;
        if (this.mPickerLayout.getChildAt(this.mLeftPickerPosition) instanceof COUINumberPicker) {
            ((COUINumberPicker) this.mPickerLayout.getChildAt(this.mLeftPickerPosition)).setNumberPickerPaddingLeft(i13);
        }
        if (this.mPickerLayout.getChildAt(this.mRightPickerPosition) instanceof COUINumberPicker) {
            ((COUINumberPicker) this.mPickerLayout.getChildAt(this.mRightPickerPosition)).setNumberPickerPaddingRight(i13);
        }
        super.onMeasure(makeMeasureSpec, i11);
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        reorderUtterance();
        accessibilityEvent.getText().add(this.selectedDateUtterance);
    }

    public void refresh() {
        COUINumberPicker cOUINumberPicker = this.mPickerDate;
        if (cOUINumberPicker != null) {
            cOUINumberPicker.refresh();
        }
        COUINumberPicker cOUINumberPicker2 = this.mPickerHour;
        if (cOUINumberPicker2 != null) {
            cOUINumberPicker2.refresh();
        }
        COUINumberPicker cOUINumberPicker3 = this.mPickerMinute;
        if (cOUINumberPicker3 != null) {
            cOUINumberPicker3.refresh();
        }
        COUINumberPicker cOUINumberPicker4 = this.mPickerAmPm;
        if (cOUINumberPicker4 != null) {
            cOUINumberPicker4.refresh();
        }
    }

    public void scrollForceFinished() {
        COUINumberPicker cOUINumberPicker = this.mPickerDate;
        if (cOUINumberPicker != null) {
            cOUINumberPicker.scrollForceFinished();
        }
        COUINumberPicker cOUINumberPicker2 = this.mPickerHour;
        if (cOUINumberPicker2 != null) {
            cOUINumberPicker2.scrollForceFinished();
        }
        COUINumberPicker cOUINumberPicker3 = this.mPickerMinute;
        if (cOUINumberPicker3 != null) {
            cOUINumberPicker3.scrollForceFinished();
        }
        if (this.mPickerAmPm != null && !is24Hours()) {
            this.mPickerAmPm.scrollForceFinished();
        }
    }

    public void setMinuteStepToFive() {
        this.mIsMinuteFiveStep = true;
    }

    public void setNormalTextColor(int i10) {
        COUINumberPicker cOUINumberPicker = this.mPickerDate;
        if (cOUINumberPicker != null) {
            cOUINumberPicker.setNormalTextColor(i10);
        }
        COUINumberPicker cOUINumberPicker2 = this.mPickerHour;
        if (cOUINumberPicker2 != null) {
            cOUINumberPicker2.setNormalTextColor(i10);
        }
        COUINumberPicker cOUINumberPicker3 = this.mPickerMinute;
        if (cOUINumberPicker3 != null) {
            cOUINumberPicker3.setNormalTextColor(i10);
        }
        COUINumberPicker cOUINumberPicker4 = this.mPickerAmPm;
        if (cOUINumberPicker4 != null) {
            cOUINumberPicker4.setNormalTextColor(i10);
        }
    }

    public void setOnTimeChangeListener(OnTimeChangeListener onTimeChangeListener) {
        this.mOnTimeChangeListener = onTimeChangeListener;
    }

    @Deprecated
    public void setTimePicker(int i10, Calendar calendar) {
        this.mDefaultCalendar = calendar;
        getTimePicker();
    }

    public void setVibrateIntensity(float f10) {
        this.mPickerDate.setVibrateIntensity(f10);
        this.mPickerHour.setVibrateIntensity(f10);
        this.mPickerMinute.setVibrateIntensity(f10);
        this.mPickerAmPm.setVibrateIntensity(f10);
    }

    public void setVibrateLevel(int i10) {
        this.mPickerDate.setVibrateLevel(i10);
        this.mPickerHour.setVibrateLevel(i10);
        this.mPickerMinute.setVibrateLevel(i10);
        this.mPickerAmPm.setVibrateLevel(i10);
    }

    public COUITimePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.f6473k);
    }

    public COUITimePicker(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, l.f6713s);
    }

    public void setTimePicker(Calendar calendar) {
        this.mDefaultCalendar = calendar;
        getTimePicker();
    }

    public COUITimePicker(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.mTodayIndex = -1;
        this.mAmPm = -1;
        this.selectedDateUtterance = "";
        this.mLeftPickerPosition = -1;
        this.mRightPickerPosition = -1;
        COUIDarkModeUtil.setForceDarkAllow(this, false);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.f6891p1, i10, i11);
        this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(m.f6895q1, 0);
        obtainStyledAttributes.recycle();
        this.mContext = context;
        this.mTextAMPM = context.getResources().getStringArray(C0426a.f6462d);
        this.mTextToday = this.mContext.getResources().getString(k.f6684j);
        this.mTextDay = this.mContext.getResources().getString(k.f6683i);
        this.mCalendar = Calendar.getInstance();
        Calendar calendar = Calendar.getInstance();
        this.mTodayCalendar = calendar;
        this.mTodayYear = calendar.get(1);
        this.mTodayMonth = this.mTodayCalendar.get(2);
        this.mTodayDate = this.mTodayCalendar.get(5);
        this.mOutformatter = new SimpleDateFormat("yyyy MMM dd" + this.mTextDay + " E", Locale.getDefault());
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext).inflate(h.f6670m, (ViewGroup) this, true);
        this.mPickerDate = (COUINumberPicker) viewGroup.findViewById(f.f6642l);
        this.mPickerHour = (COUINumberPicker) viewGroup.findViewById(f.f6643m);
        this.mPickerMinute = (COUINumberPicker) viewGroup.findViewById(f.f6644n);
        this.mPickerAmPm = (COUINumberPicker) viewGroup.findViewById(f.f6641k);
        this.mPickerLayout = (LinearLayout) viewGroup.findViewById(f.f6620J);
        this.mBackgroundRadius = context.getResources().getDimensionPixelOffset(d.f6581n0);
        this.mBackgroundLeft = context.getResources().getDimensionPixelOffset(d.f6579m0);
        this.mBackgroundDividerHeight = Math.max(getResources().getDimensionPixelOffset(d.f6511I), 1);
        if (!Locale.getDefault().getLanguage().equals("zh") && !Locale.getDefault().getLanguage().equals("en")) {
            this.mPickerDate.getLayoutParams().width = getResources().getDimensionPixelOffset(d.f6519M);
        }
        reorderSpinners();
        COUINumberPicker cOUINumberPicker = this.mPickerHour;
        if (cOUINumberPicker != null && cOUINumberPicker.isAccessibilityEnable()) {
            String string = context.getResources().getString(k.f6691q);
            COUINumberPicker cOUINumberPicker2 = this.mPickerDate;
            if (cOUINumberPicker2 != null) {
                cOUINumberPicker2.addTalkbackSuffix(string);
            }
            this.mPickerHour.addTalkbackSuffix(context.getResources().getString(k.f6676b) + string);
            COUINumberPicker cOUINumberPicker3 = this.mPickerMinute;
            if (cOUINumberPicker3 != null) {
                cOUINumberPicker3.addTalkbackSuffix(context.getResources().getString(k.f6678d) + string);
            }
            COUINumberPicker cOUINumberPicker4 = this.mPickerAmPm;
            if (cOUINumberPicker4 != null) {
                cOUINumberPicker4.addTalkbackSuffix(context.getResources().getString(k.f6678d) + string);
            }
        }
        setImportantForAccessibility(1);
    }
}
