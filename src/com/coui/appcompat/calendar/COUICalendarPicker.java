package com.coui.appcompat.calendar;

import a9.d;
import a9.m;
import android.R;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.autofill.AutofillValue;
import android.widget.FrameLayout;
import java.util.Calendar;
import java.util.Locale;

/* loaded from: classes.dex */
public class COUICalendarPicker extends FrameLayout {
    private static final String LOG_TAG = "COUICalendarPicker";
    private final COUIDatePickerDelegate mDelegate;
    private final int mMaxWidth;

    /* loaded from: classes.dex */
    public interface COUIDatePickerDelegate {
        boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent);

        long getDate();

        int getDayOfMonth();

        int getFirstDayOfWeek();

        Calendar getMaxDate();

        Calendar getMinDate();

        int getMonth();

        int getYear();

        void init(int i10, int i11, int i12, OnDateChangedListener onDateChangedListener);

        boolean isEnabled();

        boolean isYearPickerIsShow();

        void onConfigurationChanged(Configuration configuration);

        void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent);

        void onRestoreInstanceState(Parcelable parcelable);

        Parcelable onSaveInstanceState(Parcelable parcelable);

        void setAutoFillChangeListener(OnDateChangedListener onDateChangedListener);

        void setCurrentItemAnimate(boolean z10);

        void setCurrentYear();

        void setEnabled(boolean z10);

        void setFirstDayOfWeek(int i10);

        void setMaxDate(long j10);

        void setMinDate(long j10);

        void setOnDateChangedListener(OnDateChangedListener onDateChangedListener);

        void setValidationCallback(ValidationCallback validationCallback);

        void updateDate(int i10, int i11, int i12);

        void updateDate(long j10);
    }

    /* loaded from: classes.dex */
    public interface OnDateChangedListener {
        void onDateChanged(COUICalendarPicker cOUICalendarPicker, int i10, int i11, int i12);
    }

    /* loaded from: classes.dex */
    public interface ValidationCallback {
        void onValidationChanged(boolean z10);
    }

    public COUICalendarPicker(Context context) {
        this(context, null);
    }

    private COUIDatePickerDelegate createCalendarUIDelegate(Context context, AttributeSet attributeSet, int i10, int i11) {
        return new COUICalendarPickerDelegate(this, context, attributeSet, i10, i11);
    }

    @Override // android.view.View
    public void autofill(AutofillValue autofillValue) {
        if (!isEnabled()) {
            return;
        }
        if (!autofillValue.isDate()) {
            Log.w(LOG_TAG, autofillValue + " could not be autofilled into " + this);
            return;
        }
        this.mDelegate.updateDate(autofillValue.getDateValue());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return COUICalendarPicker.class.getName();
    }

    @Override // android.view.View
    public int getAutofillType() {
        if (isEnabled()) {
            return 4;
        }
        return 0;
    }

    @Override // android.view.View
    public AutofillValue getAutofillValue() {
        if (isEnabled()) {
            return AutofillValue.forDate(this.mDelegate.getDate());
        }
        return null;
    }

    public int getDayOfMonth() {
        return this.mDelegate.getDayOfMonth();
    }

    public int getFirstDayOfWeek() {
        return this.mDelegate.getFirstDayOfWeek();
    }

    public long getMaxDate() {
        return this.mDelegate.getMaxDate().getTimeInMillis();
    }

    public long getMinDate() {
        return this.mDelegate.getMinDate().getTimeInMillis();
    }

    public int getMonth() {
        return this.mDelegate.getMonth();
    }

    public int getYear() {
        return this.mDelegate.getYear();
    }

    public void init(int i10, int i11, int i12, OnDateChangedListener onDateChangedListener) {
        this.mDelegate.init(i10, i11, i12, onDateChangedListener);
    }

    @Override // android.view.View
    public boolean isEnabled() {
        return this.mDelegate.isEnabled();
    }

    public boolean isYearPickerShowing() {
        return this.mDelegate.isYearPickerIsShow();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mDelegate.onConfigurationChanged(configuration);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i10), this.mMaxWidth), View.MeasureSpec.getMode(i10)), i11);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        View.BaseSavedState baseSavedState = (View.BaseSavedState) parcelable;
        super.onRestoreInstanceState(baseSavedState.getSuperState());
        this.mDelegate.onRestoreInstanceState(baseSavedState);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        return this.mDelegate.onSaveInstanceState(super.onSaveInstanceState());
    }

    public void setCurrentItemAnimate(boolean z10) {
        this.mDelegate.setCurrentItemAnimate(z10);
    }

    public void setCurrentYear() {
        this.mDelegate.setCurrentYear();
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        if (this.mDelegate.isEnabled() == z10) {
            return;
        }
        super.setEnabled(z10);
        this.mDelegate.setEnabled(z10);
    }

    public void setFirstDayOfWeek(int i10) {
        if (i10 >= 1 && i10 <= 7) {
            this.mDelegate.setFirstDayOfWeek(i10);
            return;
        }
        throw new IllegalArgumentException("firstDayOfWeek must be between 1 and 7");
    }

    public void setMaxDate(long j10) {
        this.mDelegate.setMaxDate(j10);
    }

    public void setMinDate(long j10) {
        this.mDelegate.setMinDate(j10);
    }

    public void setOnDateChangedListener(OnDateChangedListener onDateChangedListener) {
        this.mDelegate.setOnDateChangedListener(onDateChangedListener);
    }

    public void setValidationCallback(ValidationCallback validationCallback) {
        this.mDelegate.setValidationCallback(validationCallback);
    }

    public void updateDate(int i10, int i11, int i12) {
        this.mDelegate.updateDate(i10, i11, i12);
    }

    public COUICalendarPicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.datePickerStyle);
    }

    public COUICalendarPicker(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public COUICalendarPicker(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.f6825a, i10, i11);
        int i12 = obtainStyledAttributes.getInt(m.f6830b, 1);
        obtainStyledAttributes.recycle();
        this.mDelegate = createCalendarUIDelegate(context, attributeSet, i10, i11);
        this.mMaxWidth = context.getResources().getDimensionPixelOffset(d.f6570i);
        if (i12 != 0) {
            setFirstDayOfWeek(i12);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class AbstractDatePickerDelegate implements COUIDatePickerDelegate {
        protected OnDateChangedListener mAutoFillChangeListener;
        protected Context mContext;
        protected Calendar mCurrentDate;
        protected Locale mCurrentLocale;
        protected COUICalendarPicker mDelegator;
        protected boolean mIsCurrentItemAnimate = true;
        protected OnDateChangedListener mOnDateChangedListener;
        protected ValidationCallback mValidationCallback;

        /* loaded from: classes.dex */
        public static class SavedState extends View.BaseSavedState {
            public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.coui.appcompat.calendar.COUICalendarPicker.AbstractDatePickerDelegate.SavedState.1
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
            private final long mCurrentTimeMillis;
            private final int mCurrentView;
            private final int mListPosition;
            private final int mListPositionOffset;
            private final long mMaxDate;
            private final long mMinDate;
            private final int mSelectedDay;
            private final int mSelectedMonth;
            private final int mSelectedYear;

            public long getCurrentTimeMillis() {
                return this.mCurrentTimeMillis;
            }

            public int getCurrentView() {
                return this.mCurrentView;
            }

            public int getListPosition() {
                return this.mListPosition;
            }

            public int getListPositionOffset() {
                return this.mListPositionOffset;
            }

            public long getMaxDate() {
                return this.mMaxDate;
            }

            public long getMinDate() {
                return this.mMinDate;
            }

            public int getSelectedDay() {
                return this.mSelectedDay;
            }

            public int getSelectedMonth() {
                return this.mSelectedMonth;
            }

            public int getSelectedYear() {
                return this.mSelectedYear;
            }

            @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i10) {
                super.writeToParcel(parcel, i10);
                parcel.writeInt(this.mSelectedYear);
                parcel.writeInt(this.mSelectedMonth);
                parcel.writeInt(this.mSelectedDay);
                parcel.writeLong(this.mMinDate);
                parcel.writeLong(this.mMaxDate);
                parcel.writeInt(this.mCurrentView);
                parcel.writeInt(this.mListPosition);
                parcel.writeInt(this.mListPositionOffset);
                parcel.writeLong(this.mCurrentTimeMillis);
            }

            public SavedState(Parcelable parcelable, int i10, int i11, int i12, long j10, long j11) {
                this(parcelable, i10, i11, i12, j10, j11, 0, 0, 0, 0L);
            }

            public SavedState(Parcelable parcelable, int i10, int i11, int i12, long j10, long j11, int i13, int i14, int i15, long j12) {
                super(parcelable);
                this.mSelectedYear = i10;
                this.mSelectedMonth = i11;
                this.mSelectedDay = i12;
                this.mMinDate = j10;
                this.mMaxDate = j11;
                this.mCurrentView = i13;
                this.mListPosition = i14;
                this.mListPositionOffset = i15;
                this.mCurrentTimeMillis = j12;
            }

            private SavedState(Parcel parcel) {
                super(parcel);
                this.mSelectedYear = parcel.readInt();
                this.mSelectedMonth = parcel.readInt();
                this.mSelectedDay = parcel.readInt();
                this.mMinDate = parcel.readLong();
                this.mMaxDate = parcel.readLong();
                this.mCurrentView = parcel.readInt();
                this.mListPosition = parcel.readInt();
                this.mListPositionOffset = parcel.readInt();
                this.mCurrentTimeMillis = parcel.readLong();
            }
        }

        public AbstractDatePickerDelegate(COUICalendarPicker cOUICalendarPicker, Context context) {
            this.mDelegator = cOUICalendarPicker;
            this.mContext = context;
            setCurrentLocale(Locale.getDefault());
        }

        @Override // com.coui.appcompat.calendar.COUICalendarPicker.COUIDatePickerDelegate
        public long getDate() {
            return this.mCurrentDate.getTimeInMillis();
        }

        public String getFormattedCurrentDate() {
            return DateUtils.formatDateTime(this.mContext, this.mCurrentDate.getTimeInMillis(), 22);
        }

        @Override // com.coui.appcompat.calendar.COUICalendarPicker.COUIDatePickerDelegate
        public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.getText().add(getFormattedCurrentDate());
        }

        public void onValidationChanged(boolean z10) {
            ValidationCallback validationCallback = this.mValidationCallback;
            if (validationCallback != null) {
                validationCallback.onValidationChanged(z10);
            }
        }

        @Override // com.coui.appcompat.calendar.COUICalendarPicker.COUIDatePickerDelegate
        public void setAutoFillChangeListener(OnDateChangedListener onDateChangedListener) {
            this.mAutoFillChangeListener = onDateChangedListener;
        }

        @Override // com.coui.appcompat.calendar.COUICalendarPicker.COUIDatePickerDelegate
        public void setCurrentItemAnimate(boolean z10) {
            this.mIsCurrentItemAnimate = z10;
        }

        public void setCurrentLocale(Locale locale) {
            if (!locale.equals(this.mCurrentLocale)) {
                this.mCurrentLocale = locale;
                onLocaleChanged(locale);
            }
        }

        @Override // com.coui.appcompat.calendar.COUICalendarPicker.COUIDatePickerDelegate
        public void setOnDateChangedListener(OnDateChangedListener onDateChangedListener) {
            this.mOnDateChangedListener = onDateChangedListener;
        }

        @Override // com.coui.appcompat.calendar.COUICalendarPicker.COUIDatePickerDelegate
        public void setValidationCallback(ValidationCallback validationCallback) {
            this.mValidationCallback = validationCallback;
        }

        @Override // com.coui.appcompat.calendar.COUICalendarPicker.COUIDatePickerDelegate
        public void updateDate(long j10) {
            Calendar calendar = Calendar.getInstance(this.mCurrentLocale);
            calendar.setTimeInMillis(j10);
            updateDate(calendar.get(1), calendar.get(2), calendar.get(5));
        }

        public void onLocaleChanged(Locale locale) {
        }
    }
}
