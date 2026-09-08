package com.coui.appcompat.calendar;

import a9.b;
import a9.f;
import a9.h;
import a9.l;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.coui.appcompat.picker.COUIDatePicker;
import java.util.Calendar;

/* loaded from: classes.dex */
public class COUICalendarYearView extends FrameLayout {
    private static final int ITEM_LAYOUT = h.f6672o;
    private OnYearSelectedListener mOnYearSelectedListener;
    private COUIDatePicker mPicker;

    /* loaded from: classes.dex */
    public interface OnYearSelectedListener {
        void onYearChanged(COUICalendarYearView cOUICalendarYearView, int i10, int i11, int i12);
    }

    public COUICalendarYearView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.f6464b);
    }

    public void setCurrentYear() {
        OnYearSelectedListener onYearSelectedListener = this.mOnYearSelectedListener;
        if (onYearSelectedListener != null) {
            onYearSelectedListener.onYearChanged(this, this.mPicker.getYear(), this.mPicker.getMonth(), this.mPicker.getDayOfMonth());
        }
    }

    public void setDate(Calendar calendar) {
        this.mPicker.updateDate(calendar.get(1), calendar.get(2), calendar.get(5));
    }

    public void setOnYearSelectedListener(OnYearSelectedListener onYearSelectedListener) {
        this.mOnYearSelectedListener = onYearSelectedListener;
    }

    public void setRange(Calendar calendar, Calendar calendar2) {
        this.mPicker.setMinDate(calendar.getTimeInMillis());
        this.mPicker.setMaxDate(calendar2.getTimeInMillis());
    }

    public COUICalendarYearView(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, l.f6709o);
    }

    public COUICalendarYearView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        LayoutInflater.from(context).inflate(ITEM_LAYOUT, (ViewGroup) this, true);
        COUIDatePicker cOUIDatePicker = (COUIDatePicker) findViewById(f.f6630T);
        this.mPicker = cOUIDatePicker;
        cOUIDatePicker.setOnDateChangedListener(new COUIDatePicker.OnDateChangedListener() { // from class: com.coui.appcompat.calendar.COUICalendarYearView.1
            @Override // com.coui.appcompat.picker.COUIDatePicker.OnDateChangedListener
            public void onDateChanged(COUIDatePicker cOUIDatePicker2, int i12, int i13, int i14) {
                COUICalendarYearView.this.setCurrentYear();
            }
        });
    }
}
