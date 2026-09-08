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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import com.coui.appcompat.picker.COUINumberPicker;
import java.util.Calendar;
import java.util.Locale;

/* loaded from: classes.dex */
public class COUITimeLimitPicker extends FrameLayout {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final boolean DEFAULT_ENABLED_STATE = true;
    private static final int HOURS_IN_HALF_DAY = 12;
    private static final int LONGPRESS_UPDATE_INTERVAL = 100;
    private static final int MAX_MINUTE = 59;
    private static final int MIN_BACKGROUND_DIVIDER_HEIGHT = 1;
    private static final OnTimeChangedListener NO_OP_CHANGE_LISTENER = new OnTimeChangedListener() { // from class: com.coui.appcompat.picker.COUITimeLimitPicker.1
        @Override // com.coui.appcompat.picker.COUITimeLimitPicker.OnTimeChangedListener
        public void onTimeChanged(COUITimeLimitPicker cOUITimeLimitPicker, int i10, int i11) {
        }
    };
    private final Button mAmPmButton;
    private final String[] mAmPmStrings;
    private int mBackgroundDividerHeight;
    private int mBackgroundLeft;
    private int mBackgroundRadius;
    private final COUINumberPicker mCOUIAmPmSpinner;
    private final COUINumberPicker mCOUIHourSpinner;
    private final COUINumberPicker mCOUIMinuteSpinner;
    private Context mContext;
    private Locale mCurrentLocale;
    private TextView mHourText;
    private boolean mIs24HourView;
    private boolean mIsAm;
    private boolean mIsEnabled;
    int mLeftPickerPosition;
    private int mMaxWidth;
    private TextView mMinuteText;
    private OnTimeChangedListener mOnTimeChangedListener;
    private LinearLayout mPickerLayout;
    int mRightPickerPosition;
    private Calendar mTempCalendar;

    /* loaded from: classes.dex */
    public interface OnTimeChangedListener {
        void onTimeChanged(COUITimeLimitPicker cOUITimeLimitPicker, int i10, int i11);
    }

    public COUITimeLimitPicker(Context context) {
        this(context, null);
    }

    private void measureChildConstrained(View view, int i10, int i11) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i10, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i11, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTimeChanged() {
        OnTimeChangedListener onTimeChangedListener = this.mOnTimeChangedListener;
        if (onTimeChangedListener != null) {
            onTimeChangedListener.onTimeChanged(this, getCurrentHour().intValue(), getCurrentMinute().intValue());
        }
    }

    private void reorderSpinners() {
        COUINumberPicker cOUINumberPicker;
        if (!DateFormat.getBestDateTimePattern(Locale.getDefault(), "hm").startsWith("a") && (cOUINumberPicker = this.mCOUIAmPmSpinner) != null) {
            ViewGroup viewGroup = (ViewGroup) cOUINumberPicker.getParent();
            viewGroup.removeView(this.mCOUIAmPmSpinner);
            viewGroup.addView(this.mCOUIAmPmSpinner);
        }
    }

    private void setCurrentLocale(Locale locale) {
        if (locale.equals(this.mCurrentLocale)) {
            return;
        }
        this.mCurrentLocale = locale;
        this.mTempCalendar = Calendar.getInstance(locale);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAmPmControl() {
        if (is24HourView()) {
            COUINumberPicker cOUINumberPicker = this.mCOUIAmPmSpinner;
            if (cOUINumberPicker != null) {
                cOUINumberPicker.setVisibility(8);
                return;
            } else {
                this.mAmPmButton.setVisibility(8);
                return;
            }
        }
        int i10 = !this.mIsAm ? 1 : 0;
        COUINumberPicker cOUINumberPicker2 = this.mCOUIAmPmSpinner;
        if (cOUINumberPicker2 != null) {
            cOUINumberPicker2.setValue(i10);
            this.mCOUIAmPmSpinner.setVisibility(0);
        } else {
            this.mAmPmButton.setText(this.mAmPmStrings[i10]);
            this.mAmPmButton.setVisibility(0);
        }
    }

    private void updateHourControl() {
        if (is24HourView()) {
            this.mCOUIHourSpinner.setMinValue(0);
            this.mCOUIHourSpinner.setMaxValue(23);
            this.mCOUIHourSpinner.setTwoDigitFormatter();
        } else {
            this.mCOUIHourSpinner.setMinValue(1);
            this.mCOUIHourSpinner.setMaxValue(12);
        }
        this.mCOUIHourSpinner.setWrapSelectorWheel(true);
        this.mCOUIMinuteSpinner.setWrapSelectorWheel(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(this.mCOUIHourSpinner.getBackgroundColor());
        canvas.drawRect(this.mBackgroundLeft, (int) ((getHeight() / 2.0f) - this.mBackgroundRadius), getWidth() - this.mBackgroundLeft, r0 + this.mBackgroundDividerHeight, paint);
        canvas.drawRect(this.mBackgroundLeft, (int) ((getHeight() / 2.0f) + this.mBackgroundRadius), getWidth() - this.mBackgroundLeft, r0 + this.mBackgroundDividerHeight, paint);
        super.dispatchDraw(canvas);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    public COUINumberPicker getAmPmSpinner() {
        return this.mCOUIAmPmSpinner;
    }

    @Override // android.view.View
    public int getBaseline() {
        return this.mCOUIHourSpinner.getBaseline();
    }

    public Integer getCurrentHour() {
        int value = this.mCOUIHourSpinner.getValue();
        if (is24HourView()) {
            return Integer.valueOf(value);
        }
        if (this.mIsAm) {
            return Integer.valueOf(value % 12);
        }
        return Integer.valueOf((value % 12) + 12);
    }

    public Integer getCurrentMinute() {
        return Integer.valueOf(this.mCOUIMinuteSpinner.getValue());
    }

    public COUINumberPicker getHourSpinner() {
        return this.mCOUIHourSpinner;
    }

    public COUINumberPicker getMinuteSpinner() {
        return this.mCOUIMinuteSpinner;
    }

    public boolean is24HourView() {
        return this.mIs24HourView;
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
        this.mLeftPickerPosition = -1;
        for (int i13 = 0; i13 < this.mPickerLayout.getChildCount(); i13++) {
            View childAt = this.mPickerLayout.getChildAt(i13);
            if ((childAt instanceof COUINumberPicker) && childAt.getVisibility() == 0) {
                if (this.mLeftPickerPosition == -1) {
                    this.mLeftPickerPosition = i13;
                }
                this.mRightPickerPosition = i13;
                ((COUINumberPicker) childAt).clearNumberPickerPadding();
                measureChildConstrained(childAt, i10, i11);
                size -= childAt.getMeasuredWidth();
            }
        }
        int i14 = size / 2;
        if (isLayoutRtl()) {
            int i15 = this.mLeftPickerPosition;
            this.mLeftPickerPosition = this.mRightPickerPosition;
            this.mRightPickerPosition = i15;
        }
        if (this.mPickerLayout.getChildAt(this.mLeftPickerPosition) instanceof COUINumberPicker) {
            ((COUINumberPicker) this.mPickerLayout.getChildAt(this.mLeftPickerPosition)).setNumberPickerPaddingLeft(i14);
        }
        if (this.mPickerLayout.getChildAt(this.mRightPickerPosition) instanceof COUINumberPicker) {
            ((COUINumberPicker) this.mPickerLayout.getChildAt(this.mRightPickerPosition)).setNumberPickerPaddingRight(i14);
        }
        super.onMeasure(makeMeasureSpec, i11);
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        String str;
        String str2;
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        if (this.mIsAm) {
            str = this.mAmPmStrings[0];
        } else {
            str = this.mAmPmStrings[1];
        }
        if (this.mIs24HourView) {
            str2 = getCurrentHour().toString() + this.mContext.getString(k.f6676b) + getCurrentMinute() + this.mContext.getString(k.f6678d);
        } else {
            str2 = str + this.mCOUIHourSpinner.getValue() + this.mContext.getString(k.f6676b) + getCurrentMinute() + this.mContext.getString(k.f6678d);
        }
        accessibilityEvent.getText().add(str2);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentHour(Integer.valueOf(savedState.getHour()));
        setCurrentMinute(Integer.valueOf(savedState.getMinute()));
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), getCurrentHour().intValue(), getCurrentMinute().intValue());
    }

    public void refresh() {
        COUINumberPicker cOUINumberPicker = this.mCOUIHourSpinner;
        if (cOUINumberPicker != null) {
            cOUINumberPicker.refresh();
        }
        COUINumberPicker cOUINumberPicker2 = this.mCOUIMinuteSpinner;
        if (cOUINumberPicker2 != null) {
            cOUINumberPicker2.refresh();
        }
        COUINumberPicker cOUINumberPicker3 = this.mCOUIAmPmSpinner;
        if (cOUINumberPicker3 != null) {
            cOUINumberPicker3.refresh();
        }
    }

    public void scrollForceFinished() {
        COUINumberPicker cOUINumberPicker = this.mCOUIHourSpinner;
        if (cOUINumberPicker != null) {
            cOUINumberPicker.scrollForceFinished();
        }
        COUINumberPicker cOUINumberPicker2 = this.mCOUIMinuteSpinner;
        if (cOUINumberPicker2 != null) {
            cOUINumberPicker2.scrollForceFinished();
        }
        COUINumberPicker cOUINumberPicker3 = this.mCOUIAmPmSpinner;
        if (cOUINumberPicker3 != null) {
            cOUINumberPicker3.scrollForceFinished();
        }
    }

    public void setCurrentData(Integer num, Integer num2) {
        if (num2.equals(getCurrentMinute()) && num.equals(getCurrentHour())) {
            return;
        }
        int intValue = num.intValue();
        if (!is24HourView()) {
            if (num.intValue() >= 12) {
                this.mIsAm = false;
                if (num.intValue() > 12) {
                    intValue = num.intValue() - 12;
                }
            } else {
                this.mIsAm = true;
                if (num.intValue() == 0) {
                    intValue = 12;
                }
            }
            updateAmPmControl();
        }
        this.mCOUIHourSpinner.setValue(intValue);
        this.mCOUIMinuteSpinner.setValue(num2.intValue());
        onTimeChanged();
    }

    public void setCurrentHour(Integer num) {
        if (num != null && num.intValue() != getCurrentHour().intValue()) {
            if (!is24HourView()) {
                if (num.intValue() >= 12) {
                    this.mIsAm = false;
                    if (num.intValue() > 12) {
                        num = Integer.valueOf(num.intValue() - 12);
                    }
                } else {
                    this.mIsAm = true;
                    if (num.intValue() == 0) {
                        num = 12;
                    }
                }
                updateAmPmControl();
            }
            this.mCOUIHourSpinner.setValue(num.intValue());
            onTimeChanged();
        }
    }

    public void setCurrentMinute(Integer num) {
        if (num.equals(getCurrentMinute())) {
            return;
        }
        this.mCOUIMinuteSpinner.setValue(num.intValue());
        onTimeChanged();
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        if (this.mIsEnabled == z10) {
            return;
        }
        super.setEnabled(z10);
        this.mCOUIMinuteSpinner.setEnabled(z10);
        this.mCOUIHourSpinner.setEnabled(z10);
        COUINumberPicker cOUINumberPicker = this.mCOUIAmPmSpinner;
        if (cOUINumberPicker != null) {
            cOUINumberPicker.setEnabled(z10);
        } else {
            this.mAmPmButton.setEnabled(z10);
        }
        this.mIsEnabled = z10;
    }

    public void setIs24HourView(Boolean bool) {
        if (this.mIs24HourView == bool.booleanValue()) {
            return;
        }
        Integer currentHour = getCurrentHour();
        currentHour.intValue();
        this.mIs24HourView = bool.booleanValue();
        updateHourControl();
        setCurrentHour(currentHour);
        updateAmPmControl();
        this.mCOUIHourSpinner.requestLayout();
    }

    public void setNormalTextColor(int i10) {
        COUINumberPicker cOUINumberPicker = this.mCOUIHourSpinner;
        if (cOUINumberPicker != null) {
            cOUINumberPicker.setNormalTextColor(i10);
        }
        COUINumberPicker cOUINumberPicker2 = this.mCOUIMinuteSpinner;
        if (cOUINumberPicker2 != null) {
            cOUINumberPicker2.setNormalTextColor(i10);
        }
        COUINumberPicker cOUINumberPicker3 = this.mCOUIAmPmSpinner;
        if (cOUINumberPicker3 != null) {
            cOUINumberPicker3.setNormalTextColor(i10);
        }
    }

    public void setOnTimeChangedListener(OnTimeChangedListener onTimeChangedListener) {
        this.mOnTimeChangedListener = onTimeChangedListener;
    }

    public void setRowNumber(int i10) {
        COUINumberPicker cOUINumberPicker;
        if (i10 > 0 && (cOUINumberPicker = this.mCOUIHourSpinner) != null && this.mCOUIMinuteSpinner != null && this.mCOUIAmPmSpinner != null) {
            cOUINumberPicker.setPickerRowNumber(i10);
            this.mCOUIMinuteSpinner.setPickerRowNumber(i10);
            this.mCOUIAmPmSpinner.setPickerRowNumber(i10);
        }
    }

    public void setTextVisibility(boolean z10) {
        if (z10) {
            this.mMinuteText.setVisibility(0);
            this.mHourText.setVisibility(0);
        } else {
            this.mMinuteText.setVisibility(8);
            this.mHourText.setVisibility(8);
        }
    }

    public void setVibrateIntensity(float f10) {
        this.mCOUIHourSpinner.setVibrateIntensity(f10);
        this.mCOUIMinuteSpinner.setVibrateIntensity(f10);
        this.mCOUIAmPmSpinner.setVibrateIntensity(f10);
    }

    public void setVibrateLevel(int i10) {
        this.mCOUIHourSpinner.setVibrateLevel(i10);
        this.mCOUIMinuteSpinner.setVibrateLevel(i10);
        this.mCOUIAmPmSpinner.setVibrateLevel(i10);
    }

    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.coui.appcompat.picker.COUITimeLimitPicker.SavedState.1
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
        private final int mHour;
        private final int mMinute;

        public int getHour() {
            return this.mHour;
        }

        public int getMinute() {
            return this.mMinute;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.mHour);
            parcel.writeInt(this.mMinute);
        }

        private SavedState(Parcelable parcelable, int i10, int i11) {
            super(parcelable);
            this.mHour = i10;
            this.mMinute = i11;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.mHour = parcel.readInt();
            this.mMinute = parcel.readInt();
        }
    }

    public COUITimeLimitPicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.f6473k);
    }

    public COUITimeLimitPicker(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, l.f6713s);
    }

    public COUITimeLimitPicker(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.mLeftPickerPosition = -1;
        this.mRightPickerPosition = -1;
        this.mIsEnabled = true;
        COUIDarkModeUtil.setForceDarkAllow(this, false);
        setCurrentLocale(Locale.getDefault());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.f6891p1, i10, i11);
        this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(m.f6895q1, 0);
        obtainStyledAttributes.recycle();
        this.mBackgroundDividerHeight = Math.max(getResources().getDimensionPixelOffset(d.f6511I), 1);
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(h.f6669l, (ViewGroup) this, true);
        this.mMinuteText = (TextView) findViewById(f.f6646p);
        this.mHourText = (TextView) findViewById(f.f6645o);
        COUINumberPicker cOUINumberPicker = (COUINumberPicker) findViewById(f.f6656z);
        this.mCOUIHourSpinner = cOUINumberPicker;
        cOUINumberPicker.setOnValueChangedListener(new COUINumberPicker.OnValueChangeListener() { // from class: com.coui.appcompat.picker.COUITimeLimitPicker.2
            @Override // com.coui.appcompat.picker.COUINumberPicker.OnValueChangeListener
            public void onValueChange(COUINumberPicker cOUINumberPicker2, int i12, int i13) {
                COUITimeLimitPicker.this.onTimeChanged();
            }
        });
        cOUINumberPicker.setOnScrollingStopListener(new COUINumberPicker.OnScrollingStopListener() { // from class: com.coui.appcompat.picker.COUITimeLimitPicker.3
            @Override // com.coui.appcompat.picker.COUINumberPicker.OnScrollingStopListener
            public void onScrollingStop() {
                COUITimeLimitPicker.this.sendAccessibilityEvent(4);
            }
        });
        cOUINumberPicker.setUnitText("");
        this.mMinuteText.setTextAlignment(5);
        this.mHourText.setTextAlignment(5);
        this.mPickerLayout = (LinearLayout) findViewById(f.f6624N);
        COUINumberPicker cOUINumberPicker2 = (COUINumberPicker) findViewById(f.f6616F);
        this.mCOUIMinuteSpinner = cOUINumberPicker2;
        cOUINumberPicker2.setTwoDigitFormatter();
        cOUINumberPicker2.setMinValue(0);
        cOUINumberPicker2.setMaxValue(59);
        cOUINumberPicker2.setUnitText("");
        cOUINumberPicker2.setOnLongPressUpdateInterval(100L);
        cOUINumberPicker2.setOnValueChangedListener(new COUINumberPicker.OnValueChangeListener() { // from class: com.coui.appcompat.picker.COUITimeLimitPicker.4
            @Override // com.coui.appcompat.picker.COUINumberPicker.OnValueChangeListener
            public void onValueChange(COUINumberPicker cOUINumberPicker3, int i12, int i13) {
                COUITimeLimitPicker.this.onTimeChanged();
            }
        });
        cOUINumberPicker2.setOnScrollingStopListener(new COUINumberPicker.OnScrollingStopListener() { // from class: com.coui.appcompat.picker.COUITimeLimitPicker.5
            @Override // com.coui.appcompat.picker.COUINumberPicker.OnScrollingStopListener
            public void onScrollingStop() {
                COUITimeLimitPicker.this.sendAccessibilityEvent(4);
            }
        });
        String[] stringArray = getContext().getResources().getStringArray(C0426a.f6462d);
        this.mAmPmStrings = stringArray;
        View findViewById = findViewById(f.f6632b);
        if (findViewById instanceof Button) {
            this.mCOUIAmPmSpinner = null;
            Button button = (Button) findViewById;
            this.mAmPmButton = button;
            button.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.picker.COUITimeLimitPicker.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    view.requestFocus();
                    COUITimeLimitPicker.this.mIsAm = !r2.mIsAm;
                    COUITimeLimitPicker.this.updateAmPmControl();
                }
            });
        } else {
            this.mAmPmButton = null;
            COUINumberPicker cOUINumberPicker3 = (COUINumberPicker) findViewById;
            this.mCOUIAmPmSpinner = cOUINumberPicker3;
            cOUINumberPicker3.setMinValue(0);
            cOUINumberPicker3.setMaxValue(1);
            cOUINumberPicker3.setDisplayedValues(stringArray);
            cOUINumberPicker3.setOnValueChangedListener(new COUINumberPicker.OnValueChangeListener() { // from class: com.coui.appcompat.picker.COUITimeLimitPicker.7
                @Override // com.coui.appcompat.picker.COUINumberPicker.OnValueChangeListener
                public void onValueChange(COUINumberPicker cOUINumberPicker4, int i12, int i13) {
                    cOUINumberPicker4.requestFocus();
                    COUITimeLimitPicker.this.mIsAm = !r1.mIsAm;
                    COUITimeLimitPicker.this.updateAmPmControl();
                    COUITimeLimitPicker.this.onTimeChanged();
                }
            });
            cOUINumberPicker3.setOnScrollingStopListener(new COUINumberPicker.OnScrollingStopListener() { // from class: com.coui.appcompat.picker.COUITimeLimitPicker.8
                @Override // com.coui.appcompat.picker.COUINumberPicker.OnScrollingStopListener
                public void onScrollingStop() {
                    COUITimeLimitPicker.this.sendAccessibilityEvent(4);
                }
            });
        }
        updateHourControl();
        updateAmPmControl();
        setOnTimeChangedListener(NO_OP_CHANGE_LISTENER);
        setCurrentHour(Integer.valueOf(this.mTempCalendar.get(11)));
        setCurrentMinute(Integer.valueOf(this.mTempCalendar.get(12)));
        if (!isEnabled()) {
            setEnabled(false);
        }
        reorderSpinners();
        if (cOUINumberPicker.isAccessibilityEnable()) {
            String string = context.getResources().getString(k.f6691q);
            cOUINumberPicker.addTalkbackSuffix(context.getString(k.f6676b) + string);
            cOUINumberPicker2.addTalkbackSuffix(context.getString(k.f6678d) + string);
            COUINumberPicker cOUINumberPicker4 = this.mCOUIAmPmSpinner;
            if (cOUINumberPicker4 != null) {
                cOUINumberPicker4.addTalkbackSuffix(string);
            }
        }
        this.mBackgroundRadius = context.getResources().getDimensionPixelOffset(d.f6581n0);
        this.mBackgroundLeft = context.getResources().getDimensionPixelOffset(d.f6579m0);
        setImportantForAccessibility(1);
        this.mContext = context;
    }
}
