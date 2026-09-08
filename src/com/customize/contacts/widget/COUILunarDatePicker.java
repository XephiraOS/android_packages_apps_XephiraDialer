package com.customize.contacts.widget;

import android.R;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Parcel;
import android.os.Parcelable;
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
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import com.coui.appcompat.lunarutil.COUILunarUtil;
import com.coui.appcompat.picker.COUINumberPicker;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes3.dex */
public class COUILunarDatePicker extends FrameLayout {

    /* renamed from: o, reason: collision with root package name */
    public static final String f22248o = "COUILunarDatePicker";

    /* renamed from: q, reason: collision with root package name */
    public static String f22250q;

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f22253a;

    /* renamed from: b, reason: collision with root package name */
    public final COUINumberPicker f22254b;

    /* renamed from: c, reason: collision with root package name */
    public final COUINumberPicker f22255c;

    /* renamed from: d, reason: collision with root package name */
    public final COUINumberPicker f22256d;

    /* renamed from: e, reason: collision with root package name */
    public Locale f22257e;

    /* renamed from: f, reason: collision with root package name */
    public c f22258f;

    /* renamed from: g, reason: collision with root package name */
    public String[] f22259g;

    /* renamed from: h, reason: collision with root package name */
    public int f22260h;

    /* renamed from: i, reason: collision with root package name */
    public b f22261i;

    /* renamed from: j, reason: collision with root package name */
    public b f22262j;

    /* renamed from: k, reason: collision with root package name */
    public int f22263k;

    /* renamed from: l, reason: collision with root package name */
    public int f22264l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f22265m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f22266n;

    /* renamed from: p, reason: collision with root package name */
    public static final String[] f22249p = {"一", "二", "三", "四", "五", "六", "七", "八", "九", "十", "十一", "十二"};

    /* renamed from: r, reason: collision with root package name */
    public static Calendar f22251r = Calendar.getInstance();

    /* renamed from: x, reason: collision with root package name */
    public static Calendar f22252x = Calendar.getInstance();

    /* loaded from: classes3.dex */
    public class a implements COUINumberPicker.OnValueChangeListener {
        public a() {
        }

        @Override // com.coui.appcompat.picker.COUINumberPicker.OnValueChangeListener
        public void onValueChange(COUINumberPicker cOUINumberPicker, int i10, int i11) {
            COUILunarDatePicker.this.f22261i.o(COUILunarDatePicker.this.f22262j);
            COUILunarUtil.calculateLunarByGregorian(COUILunarDatePicker.this.f22261i.i(1), COUILunarDatePicker.this.f22261i.i(2) + 1, COUILunarDatePicker.this.f22261i.i(5));
            if (cOUINumberPicker == COUILunarDatePicker.this.f22254b) {
                COUILunarDatePicker.this.f22261i.f(5, i10, i11);
            } else if (cOUINumberPicker == COUILunarDatePicker.this.f22255c) {
                COUILunarDatePicker.this.f22261i.f(2, i10, i11);
            } else if (cOUINumberPicker == COUILunarDatePicker.this.f22256d) {
                COUILunarDatePicker.this.f22261i.f(1, i10, i11);
            } else {
                throw new IllegalArgumentException();
            }
            COUILunarDatePicker cOUILunarDatePicker = COUILunarDatePicker.this;
            cOUILunarDatePicker.setDate(cOUILunarDatePicker.f22261i);
            COUILunarDatePicker.this.w();
            COUILunarDatePicker.this.v();
            COUILunarDatePicker.this.s();
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(COUILunarDatePicker cOUILunarDatePicker, int i10, int i11, int i12);
    }

    static {
        f22251r.set(1910, 2, 10, 0, 0);
        f22252x.set(2036, 11, 31, 23, 59);
    }

    public COUILunarDatePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.datePickerStyle);
    }

    public static b j(int i10, int i11, int i12, int i13) {
        boolean z10;
        int[] m10 = m(i10, i11, i13);
        boolean z11 = false;
        int i14 = m10[0];
        if (m10[1] == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        int l10 = l(i10, i14, i12, z10);
        int i15 = m10[0];
        if (m10[1] == 0) {
            z11 = true;
        }
        Date lunarToSolar = COUILunarUtil.lunarToSolar(i10, i15, l10, z11);
        b bVar = new b();
        if (lunarToSolar != null) {
            bVar.n(lunarToSolar.getTime());
        }
        return bVar;
    }

    public static int l(int i10, int i11, int i12, boolean z10) {
        int daysOfLeapMonthInLunarYear;
        if (!z10) {
            daysOfLeapMonthInLunarYear = COUILunarUtil.daysOfALunarMonth(i10, i11);
        } else {
            daysOfLeapMonthInLunarYear = COUILunarUtil.daysOfLeapMonthInLunarYear(i10);
        }
        if (i12 > daysOfLeapMonthInLunarYear) {
            return daysOfLeapMonthInLunarYear;
        }
        return i12;
    }

    public static int[] m(int i10, int i11, int i12) {
        int i13;
        int leapMonth = COUILunarUtil.leapMonth(i10);
        if (i12 == 0 && leapMonth == i11) {
            i13 = 1;
        } else {
            i13 = 0;
        }
        return new int[]{i11, i13 ^ 1};
    }

    public static String p(int i10, int i11, int i12, int i13) {
        String str;
        String str2;
        if (i10 != Integer.MIN_VALUE) {
            StringBuilder sb = new StringBuilder();
            sb.append(i10);
            sb.append("年");
            if (i13 == 0) {
                str2 = f22250q;
            } else {
                str2 = "";
            }
            sb.append(str2);
            sb.append(f22249p[i11 - 1]);
            sb.append("月");
            sb.append(COUILunarUtil.chineseStringOfALunarDay(i12));
            str = sb.toString();
        } else {
            str = f22249p[i11 - 1] + "月" + COUILunarUtil.chineseStringOfALunarDay(i12);
        }
        H7.b.b(f22248o, "getLunarDateString: lunarDateString = " + str);
        return str;
    }

    public static String q(b bVar) {
        int[] calculateLunarByGregorian = COUILunarUtil.calculateLunarByGregorian(bVar.i(1), bVar.i(2) + 1, bVar.i(5));
        return p(calculateLunarByGregorian[0], calculateLunarByGregorian[1], calculateLunarByGregorian[2], calculateLunarByGregorian[3]);
    }

    private void setCurrentLocale(Locale locale) {
        if (locale.equals(this.f22257e)) {
            return;
        }
        this.f22257e = locale;
        this.f22261i = n(this.f22261i, locale);
        f22251r = o(f22251r, locale);
        f22252x = o(f22252x, locale);
        this.f22262j = n(this.f22262j, locale);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDate(b bVar) {
        this.f22262j.o(bVar);
        k();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(this.f22254b.getBackgroundColor());
        int i10 = this.f22263k;
        canvas.drawRoundRect(this.f22264l, (getHeight() / 2.0f) - this.f22263k, getWidth() - this.f22264l, i10 + (getHeight() / 2.0f), i10, i10, paint);
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
        return this.f22262j.i(5);
    }

    public int getLeapMonth() {
        return COUILunarUtil.leapMonth(this.f22262j.i(1));
    }

    public int[] getLunarDate() {
        return COUILunarUtil.calculateLunarByGregorian(this.f22262j.i(1), this.f22262j.i(2) + 1, this.f22262j.i(5));
    }

    public long getMaxDate() {
        return f22252x.getTimeInMillis();
    }

    public long getMinDate() {
        return f22251r.getTimeInMillis();
    }

    public int getMonth() {
        return this.f22262j.i(2);
    }

    public c getOnDateChangedListener() {
        return this.f22258f;
    }

    public boolean getSpinnersShown() {
        return this.f22253a.isShown();
    }

    public int getYear() {
        return this.f22262j.i(1);
    }

    @Override // android.view.View
    public boolean isEnabled() {
        return this.f22265m;
    }

    public final void k() {
        this.f22262j.g(f22251r, f22252x);
    }

    public final b n(b bVar, Locale locale) {
        if (bVar == null) {
            return new b(locale);
        }
        b bVar2 = new b(locale);
        if (!bVar.f22277g) {
            bVar2.n(bVar.j());
        } else {
            bVar2.o(bVar);
        }
        return bVar2;
    }

    public final Calendar o(Calendar calendar, Locale locale) {
        if (calendar == null) {
            return Calendar.getInstance(locale);
        }
        long timeInMillis = calendar.getTimeInMillis();
        Calendar calendar2 = Calendar.getInstance(locale);
        calendar2.setTimeInMillis(timeInMillis);
        return calendar2;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setCurrentLocale(configuration.locale);
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.getText().add(DateUtils.formatDateTime(getContext(), this.f22262j.j(), 20));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        u(savedState.f22267a, savedState.f22268b, savedState.f22269c);
        w();
        v();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), getYear(), getMonth(), getDayOfMonth());
    }

    public void r(int i10, int i11, int i12, c cVar) {
        u(i10, i11, i12);
        w();
        v();
        this.f22258f = cVar;
    }

    public final void s() {
        sendAccessibilityEvent(4);
        c cVar = this.f22258f;
        if (cVar != null) {
            cVar.a(this, getYear(), getMonth(), getDayOfMonth());
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        if (this.f22265m == z10) {
            return;
        }
        super.setEnabled(z10);
        this.f22254b.setEnabled(z10);
        this.f22255c.setEnabled(z10);
        this.f22256d.setEnabled(z10);
        this.f22265m = z10;
    }

    public void setMaxDate(long j10) {
        this.f22261i.n(j10);
        if (this.f22261i.i(1) == f22252x.get(1) && this.f22261i.i(6) != f22252x.get(6)) {
            H7.b.i(f22248o, "setMaxDate failed!:" + this.f22261i.i(1) + "<->" + f22252x.get(1) + ":" + this.f22261i.i(6) + "<->" + f22252x.get(6));
            return;
        }
        f22252x.setTimeInMillis(j10);
        if (this.f22262j.b(f22252x)) {
            this.f22262j.n(f22252x.getTimeInMillis());
            v();
        }
        w();
    }

    public void setMinDate(long j10) {
        this.f22261i.n(j10);
        if (this.f22261i.i(1) == f22251r.get(1) && this.f22261i.i(6) != f22251r.get(6)) {
            H7.b.i(f22248o, "setMinDate failed!:" + this.f22261i.i(1) + "<->" + f22251r.get(1) + ":" + this.f22261i.i(6) + "<->" + f22251r.get(6));
            return;
        }
        f22251r.setTimeInMillis(j10);
        if (this.f22262j.d(f22251r)) {
            this.f22262j.n(f22251r.getTimeInMillis());
            v();
        }
        w();
    }

    public void setOnDateChangedListener(c cVar) {
        this.f22258f = cVar;
    }

    public void setSpinnersShown(boolean z10) {
        int i10;
        LinearLayout linearLayout = this.f22253a;
        if (z10) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        linearLayout.setVisibility(i10);
    }

    public void setYearSpinnerIgnorable(boolean z10) {
        this.f22256d.setIgnorable(z10);
    }

    public void t() {
        COUINumberPicker cOUINumberPicker = this.f22254b;
        if (cOUINumberPicker != null) {
            cOUINumberPicker.scrollForceFinished();
        }
        COUINumberPicker cOUINumberPicker2 = this.f22255c;
        if (cOUINumberPicker2 != null) {
            cOUINumberPicker2.scrollForceFinished();
        }
        COUINumberPicker cOUINumberPicker3 = this.f22256d;
        if (cOUINumberPicker3 != null) {
            cOUINumberPicker3.scrollForceFinished();
        }
    }

    public final void u(int i10, int i11, int i12) {
        this.f22262j.l(i10, i11, i12);
        k();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x019d A[LOOP:1: B:29:0x019b->B:30:0x019d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void w() {
        /*
            Method dump skipped, instructions count: 509
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.widget.COUILunarDatePicker.w():void");
    }

    /* loaded from: classes3.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public final int f22267a;

        /* renamed from: b, reason: collision with root package name */
        public final int f22268b;

        /* renamed from: c, reason: collision with root package name */
        public final int f22269c;

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
            parcel.writeInt(this.f22267a);
            parcel.writeInt(this.f22268b);
            parcel.writeInt(this.f22269c);
        }

        public SavedState(Parcelable parcelable, int i10, int i11, int i12) {
            super(parcelable);
            this.f22267a = i10;
            this.f22268b = i11;
            this.f22269c = i12;
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f22267a = parcel.readInt();
            this.f22268b = parcel.readInt();
            this.f22269c = parcel.readInt();
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public Calendar f22271a;

        /* renamed from: b, reason: collision with root package name */
        public int f22272b;

        /* renamed from: c, reason: collision with root package name */
        public int f22273c;

        /* renamed from: d, reason: collision with root package name */
        public int f22274d;

        /* renamed from: e, reason: collision with root package name */
        public int f22275e;

        /* renamed from: f, reason: collision with root package name */
        public int f22276f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f22277g;

        public b() {
            k(Calendar.getInstance());
        }

        public boolean b(Calendar calendar) {
            if (!this.f22277g) {
                return this.f22271a.after(calendar);
            }
            return false;
        }

        public boolean c(Calendar calendar) {
            if (this.f22277g) {
                return false;
            }
            if (!this.f22271a.after(calendar) && !this.f22271a.equals(calendar)) {
                return false;
            }
            return true;
        }

        public boolean d(Calendar calendar) {
            if (!this.f22277g) {
                return this.f22271a.before(calendar);
            }
            return false;
        }

        public boolean e(Calendar calendar) {
            if (this.f22277g) {
                return false;
            }
            if (!this.f22271a.before(calendar) && !this.f22271a.equals(calendar)) {
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
        public void f(int r7, int r8, int r9) {
            /*
                Method dump skipped, instructions count: 237
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.widget.COUILunarDatePicker.b.f(int, int, int):void");
        }

        public void g(Calendar calendar, Calendar calendar2) {
            if (!this.f22277g) {
                if (this.f22271a.before(calendar)) {
                    n(calendar.getTimeInMillis());
                } else if (this.f22271a.after(calendar2)) {
                    n(calendar2.getTimeInMillis());
                }
            }
        }

        public void h() {
            this.f22271a.clear();
            this.f22272b = 0;
            this.f22273c = 0;
            this.f22274d = 0;
            this.f22275e = 0;
            this.f22276f = 0;
            this.f22277g = false;
        }

        public int i(int i10) {
            if (!this.f22277g) {
                return this.f22271a.get(i10);
            }
            if (i10 == 5) {
                return this.f22274d;
            }
            if (i10 == 2) {
                return this.f22273c;
            }
            if (i10 == 1) {
                return this.f22272b;
            }
            return this.f22271a.get(i10);
        }

        public long j() {
            return this.f22271a.getTimeInMillis();
        }

        public void k(Calendar calendar) {
            this.f22271a = calendar;
            this.f22277g = false;
        }

        public void l(int i10, int i11, int i12) {
            if (i10 != Integer.MIN_VALUE) {
                this.f22271a.set(1, i10);
                this.f22271a.set(2, i11);
                this.f22271a.set(5, i12);
                this.f22277g = false;
                return;
            }
            this.f22272b = Integer.MIN_VALUE;
            this.f22273c = i11;
            this.f22274d = i12;
            this.f22277g = true;
        }

        public void m(int i10, int i11, int i12, int i13, int i14) {
            if (i10 != Integer.MIN_VALUE) {
                this.f22271a.set(1, i10);
                this.f22271a.set(2, i11);
                this.f22271a.set(5, i12);
                this.f22271a.set(11, i13);
                this.f22271a.set(12, i14);
                this.f22277g = false;
                return;
            }
            this.f22272b = Integer.MIN_VALUE;
            this.f22273c = i11;
            this.f22274d = i12;
            this.f22275e = i13;
            this.f22276f = i14;
            this.f22277g = true;
        }

        public void n(long j10) {
            this.f22271a.setTimeInMillis(j10);
            this.f22277g = false;
        }

        public void o(b bVar) {
            this.f22271a.setTimeInMillis(bVar.f22271a.getTimeInMillis());
            this.f22272b = bVar.f22272b;
            this.f22273c = bVar.f22273c;
            this.f22274d = bVar.f22274d;
            this.f22275e = bVar.f22275e;
            this.f22276f = bVar.f22276f;
            this.f22277g = bVar.f22277g;
        }

        public b(Locale locale) {
            k(Calendar.getInstance(locale));
        }
    }

    public COUILunarDatePicker(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f22260h = 12;
        this.f22265m = true;
        COUIDarkModeUtil.setForceDarkAllow(this, false);
        setCurrentLocale(Locale.getDefault());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, V0.f13309N0, i10, 0);
        this.f22266n = false;
        obtainStyledAttributes.recycle();
        this.f22259g = getResources().getStringArray(com.oplus.dialer.R.array.coui_lunar_month);
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(com.oplus.dialer.R.layout.coui_lunar_date_picker, (ViewGroup) this, true);
        f22250q = getResources().getString(com.oplus.dialer.R.string.coui_lunar_leap_string);
        a aVar = new a();
        this.f22253a = (LinearLayout) findViewById(com.oplus.dialer.R.id.pickers);
        COUINumberPicker cOUINumberPicker = (COUINumberPicker) findViewById(com.oplus.dialer.R.id.day);
        this.f22254b = cOUINumberPicker;
        cOUINumberPicker.setOnLongPressUpdateInterval(100L);
        cOUINumberPicker.setOnValueChangedListener(aVar);
        COUINumberPicker cOUINumberPicker2 = (COUINumberPicker) findViewById(com.oplus.dialer.R.id.month);
        this.f22255c = cOUINumberPicker2;
        cOUINumberPicker2.setMinValue(0);
        cOUINumberPicker2.setMaxValue(this.f22260h - 1);
        cOUINumberPicker2.setDisplayedValues(this.f22259g);
        cOUINumberPicker2.setOnLongPressUpdateInterval(200L);
        cOUINumberPicker2.setOnValueChangedListener(aVar);
        COUINumberPicker cOUINumberPicker3 = (COUINumberPicker) findViewById(com.oplus.dialer.R.id.year);
        this.f22256d = cOUINumberPicker3;
        cOUINumberPicker3.setOnLongPressUpdateInterval(100L);
        cOUINumberPicker3.setOnValueChangedListener(aVar);
        cOUINumberPicker3.setIgnorable(this.f22266n);
        setSpinnersShown(true);
        setCalendarViewShown(true);
        this.f22261i.h();
        this.f22261i.l(1910, 0, 1);
        setMinDate(this.f22261i.j());
        this.f22261i.h();
        this.f22261i.m(2036, 11, 31, 23, 59);
        setMaxDate(this.f22261i.j());
        this.f22262j.n(System.currentTimeMillis());
        r(this.f22262j.i(1), this.f22262j.i(2), this.f22262j.i(5), null);
        if (cOUINumberPicker3.isAccessibilityEnable()) {
            String string = context.getResources().getString(com.oplus.dialer.R.string.picker_talkback_tip);
            cOUINumberPicker3.addTalkbackSuffix(string);
            cOUINumberPicker2.addTalkbackSuffix(string);
            cOUINumberPicker.addTalkbackSuffix(string);
        }
        this.f22263k = context.getResources().getDimensionPixelOffset(com.oplus.dialer.R.dimen.coui_selected_background_radius);
        this.f22264l = context.getResources().getDimensionPixelOffset(com.oplus.dialer.R.dimen.coui_selected_background_horizontal_padding) / 2;
    }

    public final void v() {
    }

    public void setCalendarViewShown(boolean z10) {
    }
}
