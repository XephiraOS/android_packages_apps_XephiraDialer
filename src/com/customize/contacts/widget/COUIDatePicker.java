package com.customize.contacts.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.CalendarView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.android.contacts.V0;
import com.coui.appcompat.calendar.COUIDateMonthView;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import com.coui.appcompat.picker.COUINumberPicker;
import com.oplus.dialer.R;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes3.dex */
public class COUIDatePicker extends FrameLayout {

    /* renamed from: D, reason: collision with root package name */
    public static char[] f22214D = {'d', 'M', 'y'};

    /* renamed from: A, reason: collision with root package name */
    public int f22215A;

    /* renamed from: B, reason: collision with root package name */
    public boolean f22216B;

    /* renamed from: C, reason: collision with root package name */
    public Date f22217C;

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f22218a;

    /* renamed from: b, reason: collision with root package name */
    public final COUINumberPicker f22219b;

    /* renamed from: c, reason: collision with root package name */
    public final COUINumberPicker f22220c;

    /* renamed from: d, reason: collision with root package name */
    public final COUINumberPicker f22221d;

    /* renamed from: e, reason: collision with root package name */
    public final DateFormat f22222e;

    /* renamed from: f, reason: collision with root package name */
    public Context f22223f;

    /* renamed from: g, reason: collision with root package name */
    public Locale f22224g;

    /* renamed from: h, reason: collision with root package name */
    public d f22225h;

    /* renamed from: i, reason: collision with root package name */
    public String[] f22226i;

    /* renamed from: j, reason: collision with root package name */
    public int f22227j;

    /* renamed from: k, reason: collision with root package name */
    public c f22228k;

    /* renamed from: l, reason: collision with root package name */
    public Calendar f22229l;

    /* renamed from: m, reason: collision with root package name */
    public Calendar f22230m;

    /* renamed from: n, reason: collision with root package name */
    public c f22231n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f22232o;

    /* renamed from: p, reason: collision with root package name */
    public b f22233p;

    /* renamed from: q, reason: collision with root package name */
    public b f22234q;

    /* renamed from: r, reason: collision with root package name */
    public b f22235r;

    /* renamed from: x, reason: collision with root package name */
    public int f22236x;

    /* renamed from: y, reason: collision with root package name */
    public int f22237y;

    /* renamed from: z, reason: collision with root package name */
    public int f22238z;

    /* loaded from: classes3.dex */
    public class a implements COUINumberPicker.OnValueChangeListener {
        public a() {
        }

        @Override // com.coui.appcompat.picker.COUINumberPicker.OnValueChangeListener
        public void onValueChange(COUINumberPicker cOUINumberPicker, int i10, int i11) {
            COUIDatePicker.this.f22228k.o(COUIDatePicker.this.f22231n);
            if (cOUINumberPicker == COUIDatePicker.this.f22219b) {
                COUIDatePicker.this.f22228k.l(5, i11);
            } else if (cOUINumberPicker == COUIDatePicker.this.f22220c) {
                COUIDatePicker.this.f22228k.l(2, i11);
            } else if (cOUINumberPicker == COUIDatePicker.this.f22221d) {
                COUIDatePicker.this.f22228k.l(1, i11);
            } else {
                throw new IllegalArgumentException();
            }
            COUIDatePicker cOUIDatePicker = COUIDatePicker.this;
            cOUIDatePicker.setDate(cOUIDatePicker.f22228k);
            COUIDatePicker.this.y();
            COUIDatePicker.this.w();
            COUIDatePicker.this.r();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements COUINumberPicker.Formatter {

        /* renamed from: a, reason: collision with root package name */
        public int f22243a;

        /* renamed from: b, reason: collision with root package name */
        public String f22244b;

        public b(int i10, String str) {
            this.f22243a = i10;
            this.f22244b = str;
        }

        @Override // com.coui.appcompat.picker.COUINumberPicker.Formatter
        public String format(int i10) {
            String language = Locale.getDefault().getLanguage();
            if (this.f22244b.equals("MONTH")) {
                if (language.equals("en")) {
                    return COUIDatePicker.this.f22226i[i10];
                }
                COUIDatePicker.this.f22217C.setMonth(i10);
                return DateUtils.formatDateTime(COUIDatePicker.this.getContext(), COUIDatePicker.this.f22217C.getTime(), 65576);
            }
            if (!language.equals("zh")) {
                if (this.f22244b.equals("YEAR")) {
                    return U7.a.c(i10, COUIDatePicker.this.f22224g);
                }
                if (this.f22244b.equals("DAY")) {
                    return U7.a.a(i10, COUIDatePicker.this.f22224g);
                }
            }
            return i10 + COUIDatePicker.this.getResources().getString(this.f22243a);
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public Calendar f22246a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f22247b;

        public c(Locale locale) {
            this.f22246a = Calendar.getInstance(locale);
        }

        public boolean c(Calendar calendar) {
            if (!this.f22247b) {
                return this.f22246a.after(calendar);
            }
            return false;
        }

        public boolean d(Calendar calendar) {
            if (!this.f22247b) {
                return this.f22246a.before(calendar);
            }
            return false;
        }

        public void e(Calendar calendar, Calendar calendar2) {
            if (!this.f22247b) {
                if (this.f22246a.before(calendar)) {
                    l(1, calendar.get(1));
                    l(2, calendar.get(2));
                    l(5, calendar.get(5));
                } else if (this.f22246a.after(calendar2)) {
                    l(1, calendar2.get(1));
                    l(2, calendar2.get(2));
                    l(5, calendar2.get(5));
                }
            }
        }

        public int f(int i10) {
            int actualMaximum = this.f22246a.getActualMaximum(5);
            if (i10 > actualMaximum) {
                return actualMaximum;
            }
            return i10;
        }

        public void g() {
            this.f22246a.clear();
            this.f22247b = false;
        }

        public int h(int i10) {
            if (!this.f22247b) {
                return this.f22246a.get(i10);
            }
            if (i10 == 5) {
                return this.f22246a.get(i10);
            }
            if (i10 == 2) {
                return this.f22246a.get(i10);
            }
            if (i10 == 1) {
                return Integer.MIN_VALUE;
            }
            return this.f22246a.get(i10);
        }

        public int i(int i10) {
            return this.f22246a.getActualMaximum(i10);
        }

        public int j(int i10) {
            return this.f22246a.getActualMinimum(i10);
        }

        public long k() {
            return this.f22246a.getTimeInMillis();
        }

        public void l(int i10, int i11) {
            if (i10 == 1) {
                if (i11 != Integer.MIN_VALUE) {
                    this.f22247b = false;
                    int i12 = this.f22246a.get(2);
                    int i13 = this.f22246a.get(5);
                    this.f22246a.clear();
                    this.f22246a.set(1, i11);
                    this.f22246a.set(2, i12);
                    this.f22246a.set(5, f(i13));
                    return;
                }
                this.f22247b = true;
                int i14 = this.f22246a.get(2);
                int i15 = this.f22246a.get(5);
                this.f22246a.clear();
                this.f22246a.set(i10, 2020);
                this.f22246a.set(2, i14);
                this.f22246a.set(5, f(i15));
                return;
            }
            if (i10 == 2) {
                int i16 = this.f22246a.get(1);
                int i17 = this.f22246a.get(5);
                this.f22246a.clear();
                this.f22246a.set(1, i16);
                this.f22246a.set(2, i11);
                this.f22246a.set(5, f(i17));
                return;
            }
            if (i10 == 5) {
                this.f22246a.set(5, f(i11));
            }
        }

        public void m(int i10, int i11, int i12) {
            l(1, i10);
            l(2, i11);
            l(5, i12);
        }

        public void n(long j10) {
            this.f22246a.setTimeInMillis(j10);
            this.f22247b = false;
        }

        public void o(c cVar) {
            this.f22246a.setTimeInMillis(cVar.f22246a.getTimeInMillis());
            this.f22247b = cVar.f22247b;
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a(COUIDatePicker cOUIDatePicker, int i10, int i11, int i12);
    }

    public COUIDatePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.couiDatePickerStyle);
    }

    private void setCurrentLocale(Locale locale) {
        if (locale.equals(this.f22224g)) {
            return;
        }
        this.f22224g = locale;
        this.f22228k = o(this.f22228k, locale);
        this.f22229l = p(this.f22229l, locale);
        this.f22230m = p(this.f22230m, locale);
        this.f22231n = o(this.f22231n, locale);
        int i10 = this.f22228k.i(2) + 1;
        this.f22227j = i10;
        this.f22226i = new String[i10];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDate(c cVar) {
        this.f22231n.o(cVar);
        m();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(this.f22219b.getBackgroundColor());
        int i10 = this.f22238z;
        canvas.drawRoundRect(this.f22215A, (getHeight() / 2.0f) - this.f22238z, getWidth() - this.f22215A, i10 + (getHeight() / 2.0f), i10, i10, paint);
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
        return this.f22231n.h(5);
    }

    public long getMaxDate() {
        return this.f22230m.getTimeInMillis();
    }

    public long getMinDate() {
        return this.f22229l.getTimeInMillis();
    }

    public int getMonth() {
        return this.f22231n.h(2);
    }

    public d getOnDateChangedListener() {
        return this.f22225h;
    }

    public boolean getSpinnersShown() {
        return this.f22218a.isShown();
    }

    public int getYear() {
        return this.f22231n.h(1);
    }

    @Override // android.view.View
    public boolean isEnabled() {
        return this.f22232o;
    }

    public final void m() {
        this.f22231n.e(this.f22229l, this.f22230m);
    }

    public final String n() {
        if (!this.f22231n.f22247b) {
            return DateUtils.formatDateTime(this.f22223f, this.f22231n.f22246a.getTimeInMillis(), 20);
        }
        return DateUtils.formatDateTime(this.f22223f, this.f22231n.f22246a.getTimeInMillis(), 24);
    }

    public final c o(c cVar, Locale locale) {
        if (cVar == null) {
            return new c(locale);
        }
        c cVar2 = new c(locale);
        if (!cVar.f22247b) {
            cVar2.n(cVar.k());
        } else {
            cVar2.o(cVar);
        }
        return cVar2;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setCurrentLocale(configuration.locale);
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.getText().add(n());
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        v(savedState.f22239a, savedState.f22240b, savedState.f22241c);
        y();
        w();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), getYear(), getMonth(), getDayOfMonth());
    }

    public final Calendar p(Calendar calendar, Locale locale) {
        if (calendar == null) {
            return Calendar.getInstance(locale);
        }
        long timeInMillis = calendar.getTimeInMillis();
        Calendar calendar2 = Calendar.getInstance(locale);
        calendar2.setTimeInMillis(timeInMillis);
        return calendar2;
    }

    public void q(int i10, int i11, int i12, d dVar) {
        v(i10, i11, i12);
        y();
        w();
        this.f22225h = dVar;
    }

    public final void r() {
        sendAccessibilityEvent(4);
        d dVar = this.f22225h;
        if (dVar != null) {
            dVar.a(this, getYear(), getMonth(), getDayOfMonth());
        }
    }

    public final boolean s(String str, Calendar calendar) {
        try {
            calendar.setTime(this.f22222e.parse(str));
            return true;
        } catch (ParseException unused) {
            return false;
        }
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        if (this.f22232o == z10) {
            return;
        }
        super.setEnabled(z10);
        this.f22219b.setEnabled(z10);
        this.f22220c.setEnabled(z10);
        this.f22221d.setEnabled(z10);
        this.f22232o = z10;
    }

    public void setFocusColor(int i10) {
        this.f22237y = i10;
        x();
    }

    public void setMaxDate(long j10) {
        this.f22228k.n(j10);
        if (this.f22228k.h(1) == this.f22230m.get(1) && this.f22228k.h(6) != this.f22230m.get(6)) {
            return;
        }
        this.f22230m.setTimeInMillis(j10);
        if (this.f22231n.c(this.f22230m)) {
            this.f22231n.n(this.f22230m.getTimeInMillis());
            w();
        }
        y();
    }

    public void setMinDate(long j10) {
        this.f22228k.n(j10);
        if (this.f22228k.h(1) == this.f22229l.get(1) && this.f22228k.h(6) != this.f22229l.get(6)) {
            return;
        }
        this.f22229l.setTimeInMillis(j10);
        if (this.f22231n.d(this.f22229l)) {
            this.f22231n.n(this.f22229l.getTimeInMillis());
            w();
        }
        y();
    }

    public void setNormalColor(int i10) {
        this.f22236x = i10;
        x();
    }

    public void setOnDateChangedListener(d dVar) {
        this.f22225h = dVar;
    }

    public void setSpinnersShown(boolean z10) {
        int i10;
        LinearLayout linearLayout = this.f22218a;
        if (z10) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        linearLayout.setVisibility(i10);
    }

    public void setYearSpinnerIgnorable(boolean z10) {
        this.f22221d.setIgnorable(z10);
    }

    public final void t() {
        int length = android.text.format.DateFormat.getDateFormatOrder(getContext()).length;
        if (Locale.getDefault().getLanguage().equals("en")) {
            char[] cArr = f22214D;
            this.f22218a.removeAllViews();
            for (int i10 = 0; i10 < length; i10++) {
                char c10 = cArr[i10];
                if (c10 != 'M') {
                    if (c10 != 'd') {
                        if (c10 == 'y') {
                            this.f22218a.addView(this.f22221d);
                            this.f22221d.setAlignPosition(1);
                        } else {
                            throw new IllegalArgumentException();
                        }
                    } else {
                        this.f22218a.addView(this.f22219b);
                        this.f22219b.setAlignPosition(2);
                    }
                } else {
                    this.f22218a.addView(this.f22220c);
                }
            }
        }
    }

    public void u() {
        COUINumberPicker cOUINumberPicker = this.f22219b;
        if (cOUINumberPicker != null) {
            cOUINumberPicker.scrollForceFinished();
        }
        COUINumberPicker cOUINumberPicker2 = this.f22220c;
        if (cOUINumberPicker2 != null) {
            cOUINumberPicker2.scrollForceFinished();
        }
        COUINumberPicker cOUINumberPicker3 = this.f22221d;
        if (cOUINumberPicker3 != null) {
            cOUINumberPicker3.scrollForceFinished();
        }
    }

    public final void v(int i10, int i11, int i12) {
        this.f22231n.m(i10, i11, i12);
        m();
    }

    public final void x() {
        int i10 = this.f22236x;
        if (i10 != -1) {
            this.f22219b.setPickerNormalColor(i10);
            this.f22220c.setPickerNormalColor(this.f22236x);
            this.f22221d.setPickerNormalColor(this.f22236x);
        }
        int i11 = this.f22237y;
        if (i11 != -1) {
            this.f22219b.setPickerFocusColor(i11);
            this.f22220c.setPickerFocusColor(this.f22237y);
            this.f22221d.setPickerFocusColor(this.f22237y);
        }
    }

    public final void y() {
        boolean z10;
        boolean z11;
        boolean z12;
        this.f22220c.setFormatter(this.f22234q);
        boolean z13 = false;
        if (this.f22231n.h(1) == this.f22229l.get(1) && this.f22231n.h(1) != this.f22230m.get(1)) {
            this.f22220c.setMinValue(this.f22229l.get(2));
            this.f22220c.setMaxValue(this.f22229l.getActualMaximum(2));
            COUINumberPicker cOUINumberPicker = this.f22220c;
            if (this.f22229l.get(2) == 0) {
                z12 = true;
            } else {
                z12 = false;
            }
            cOUINumberPicker.setWrapSelectorWheel(z12);
        } else if (this.f22231n.h(1) != this.f22229l.get(1) && this.f22231n.h(1) == this.f22230m.get(1)) {
            this.f22220c.setMinValue(0);
            this.f22220c.setMaxValue(this.f22230m.get(2));
            COUINumberPicker cOUINumberPicker2 = this.f22220c;
            if (this.f22230m.get(2) == this.f22230m.getActualMaximum(2)) {
                z11 = true;
            } else {
                z11 = false;
            }
            cOUINumberPicker2.setWrapSelectorWheel(z11);
        } else if (this.f22231n.h(1) == this.f22229l.get(1) && this.f22231n.h(1) == this.f22230m.get(1)) {
            this.f22220c.setMinValue(this.f22229l.get(2));
            this.f22220c.setMaxValue(this.f22230m.get(2));
            COUINumberPicker cOUINumberPicker3 = this.f22220c;
            if (this.f22230m.get(2) == this.f22230m.getActualMaximum(2) && this.f22229l.get(2) == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            cOUINumberPicker3.setWrapSelectorWheel(z10);
        } else {
            this.f22220c.setMinValue(this.f22231n.j(2));
            this.f22220c.setMaxValue(this.f22231n.i(2));
            this.f22220c.setWrapSelectorWheel(true);
        }
        if (this.f22231n.h(1) == this.f22229l.get(1) && this.f22231n.h(2) == this.f22229l.get(2) && (this.f22231n.h(1) != this.f22230m.get(1) || this.f22231n.h(2) != this.f22230m.get(2))) {
            this.f22219b.setMinValue(this.f22229l.get(5));
            this.f22219b.setMaxValue(this.f22229l.getActualMaximum(5));
            COUINumberPicker cOUINumberPicker4 = this.f22219b;
            if (this.f22229l.get(5) == 1) {
                z13 = true;
            }
            cOUINumberPicker4.setWrapSelectorWheel(z13);
        } else if ((this.f22231n.h(1) != this.f22229l.get(1) || this.f22231n.h(2) != this.f22229l.get(2)) && this.f22231n.h(1) == this.f22230m.get(1) && this.f22231n.h(2) == this.f22230m.get(2)) {
            this.f22219b.setMinValue(1);
            this.f22219b.setMaxValue(this.f22230m.get(5));
            COUINumberPicker cOUINumberPicker5 = this.f22219b;
            if (this.f22230m.get(5) == this.f22230m.getActualMaximum(5)) {
                z13 = true;
            }
            cOUINumberPicker5.setWrapSelectorWheel(z13);
        } else if (this.f22231n.h(1) == this.f22229l.get(1) && this.f22231n.h(2) == this.f22229l.get(2) && this.f22231n.h(1) == this.f22230m.get(1) && this.f22231n.h(2) == this.f22230m.get(2)) {
            this.f22219b.setMinValue(this.f22229l.get(5));
            this.f22219b.setMaxValue(this.f22230m.get(5));
            COUINumberPicker cOUINumberPicker6 = this.f22219b;
            if (this.f22230m.get(5) == this.f22230m.getActualMaximum(5) && this.f22229l.get(5) == 1) {
                z13 = true;
            }
            cOUINumberPicker6.setWrapSelectorWheel(z13);
        } else {
            this.f22219b.setMinValue(this.f22231n.j(5));
            this.f22219b.setMaxValue(this.f22231n.i(5));
            this.f22219b.setWrapSelectorWheel(true);
        }
        this.f22221d.setMinValue(this.f22229l.get(1));
        this.f22221d.setMaxValue(this.f22230m.get(1));
        this.f22221d.setWrapSelectorWheel(true);
        this.f22221d.setFormatter(this.f22233p);
        this.f22221d.setValue(this.f22231n.h(1));
        this.f22220c.setValue(this.f22231n.h(2));
        this.f22219b.setValue(this.f22231n.h(5));
        this.f22219b.setFormatter(this.f22235r);
        if (this.f22219b.getValue() > 27) {
            this.f22219b.invalidate();
        }
    }

    /* loaded from: classes3.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public final int f22239a;

        /* renamed from: b, reason: collision with root package name */
        public final int f22240b;

        /* renamed from: c, reason: collision with root package name */
        public final int f22241c;

        /* loaded from: classes3.dex */
        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f22239a);
            parcel.writeInt(this.f22240b);
            parcel.writeInt(this.f22241c);
        }

        public SavedState(Parcelable parcelable, int i10, int i11, int i12) {
            super(parcelable);
            this.f22239a = i10;
            this.f22240b = i11;
            this.f22241c = i12;
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f22239a = parcel.readInt();
            this.f22240b = parcel.readInt();
            this.f22241c = parcel.readInt();
        }
    }

    public COUIDatePicker(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f22222e = new SimpleDateFormat("MM/dd/yyyy");
        this.f22232o = true;
        COUIDarkModeUtil.setForceDarkAllow(this, false);
        this.f22223f = context;
        setCurrentLocale(Locale.getDefault());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, V0.f13457k0, i10, 0);
        boolean z10 = obtainStyledAttributes.getBoolean(15, true);
        boolean z11 = obtainStyledAttributes.getBoolean(3, true);
        int i11 = obtainStyledAttributes.getInt(0, COUIDateMonthView.MIN_YEAR);
        int i12 = obtainStyledAttributes.getInt(8, COUIDateMonthView.MAX_YEAR);
        String string = obtainStyledAttributes.getString(14);
        String string2 = obtainStyledAttributes.getString(13);
        try {
            this.f22226i = getResources().getStringArray(R.array.coui_solor_mounth);
        } catch (Exception unused) {
            H7.b.c("COUIDatePicker", "COUIDatePicker init error");
        }
        this.f22236x = obtainStyledAttributes.getColor(2, -1);
        this.f22237y = obtainStyledAttributes.getColor(1, -1);
        this.f22216B = obtainStyledAttributes.getBoolean(4, false);
        obtainStyledAttributes.recycle();
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.coui_date_picker, (ViewGroup) this, true);
        a aVar = new a();
        this.f22218a = (LinearLayout) findViewById(R.id.pickers);
        this.f22233p = new b(R.string.coui_year, "YEAR");
        this.f22234q = new b(R.string.coui_month, "MONTH");
        this.f22235r = new b(R.string.coui_day, "DAY");
        this.f22217C = new Date();
        COUINumberPicker cOUINumberPicker = (COUINumberPicker) findViewById(R.id.day);
        this.f22219b = cOUINumberPicker;
        cOUINumberPicker.setOnLongPressUpdateInterval(100L);
        cOUINumberPicker.setOnValueChangedListener(aVar);
        COUINumberPicker cOUINumberPicker2 = (COUINumberPicker) findViewById(R.id.month);
        this.f22220c = cOUINumberPicker2;
        cOUINumberPicker2.setMinValue(0);
        cOUINumberPicker2.setMaxValue(this.f22227j - 1);
        cOUINumberPicker2.setOnLongPressUpdateInterval(200L);
        cOUINumberPicker2.setOnValueChangedListener(aVar);
        COUINumberPicker cOUINumberPicker3 = (COUINumberPicker) findViewById(R.id.year);
        this.f22221d = cOUINumberPicker3;
        cOUINumberPicker3.setOnLongPressUpdateInterval(100L);
        cOUINumberPicker3.setOnValueChangedListener(aVar);
        cOUINumberPicker3.setIgnorable(this.f22216B);
        x();
        if (!z10 && !z11) {
            setSpinnersShown(true);
        } else {
            setSpinnersShown(z10);
            setCalendarViewShown(z11);
        }
        this.f22228k.g();
        if (!TextUtils.isEmpty(string)) {
            if (!s(string, this.f22228k.f22246a)) {
                this.f22228k.m(i11, 0, 1);
            }
        } else {
            this.f22228k.m(i11, 0, 1);
        }
        setMinDate(this.f22228k.f22246a.getTimeInMillis());
        this.f22228k.g();
        if (!TextUtils.isEmpty(string2)) {
            if (!s(string2, this.f22228k.f22246a)) {
                this.f22228k.m(i12, 11, 31);
            }
        } else {
            this.f22228k.m(i12, 11, 31);
        }
        setMaxDate(this.f22228k.f22246a.getTimeInMillis());
        this.f22231n.n(System.currentTimeMillis());
        q(this.f22231n.h(1), this.f22231n.h(2), this.f22231n.h(5), null);
        t();
        if (cOUINumberPicker3.isAccessibilityEnable()) {
            String string3 = context.getResources().getString(R.string.picker_talkback_tip);
            cOUINumberPicker3.addTalkbackSuffix(string3);
            cOUINumberPicker2.addTalkbackSuffix(string3);
            cOUINumberPicker.addTalkbackSuffix(string3);
        }
        this.f22238z = context.getResources().getDimensionPixelOffset(R.dimen.coui_selected_background_radius);
        this.f22215A = context.getResources().getDimensionPixelOffset(R.dimen.coui_selected_background_horizontal_padding) / 2;
    }

    public void setBackground(int i10) {
        setBackgroundDrawable(getContext().getResources().getDrawable(i10));
    }

    public final void w() {
    }

    public void setCalendarViewShown(boolean z10) {
    }
}
