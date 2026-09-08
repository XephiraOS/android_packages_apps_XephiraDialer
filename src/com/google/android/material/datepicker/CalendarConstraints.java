package com.google.android.material.datepicker;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.coui.appcompat.calendar.COUIDateMonthView;
import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes3.dex */
public final class CalendarConstraints implements Parcelable {
    public static final Parcelable.Creator<CalendarConstraints> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final Month f23097a;

    /* renamed from: b, reason: collision with root package name */
    public final Month f23098b;

    /* renamed from: c, reason: collision with root package name */
    public final DateValidator f23099c;

    /* renamed from: d, reason: collision with root package name */
    public Month f23100d;

    /* renamed from: e, reason: collision with root package name */
    public final int f23101e;

    /* renamed from: f, reason: collision with root package name */
    public final int f23102f;

    /* renamed from: g, reason: collision with root package name */
    public final int f23103g;

    /* loaded from: classes3.dex */
    public interface DateValidator extends Parcelable {
        boolean X(long j10);
    }

    /* loaded from: classes3.dex */
    public class a implements Parcelable.Creator<CalendarConstraints> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CalendarConstraints createFromParcel(Parcel parcel) {
            return new CalendarConstraints((Month) parcel.readParcelable(Month.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), (DateValidator) parcel.readParcelable(DateValidator.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), parcel.readInt(), null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public CalendarConstraints[] newArray(int i10) {
            return new CalendarConstraints[i10];
        }
    }

    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: f, reason: collision with root package name */
        public static final long f23104f = t.a(Month.d(COUIDateMonthView.MIN_YEAR, 0).f23164f);

        /* renamed from: g, reason: collision with root package name */
        public static final long f23105g = t.a(Month.d(COUIDateMonthView.MAX_YEAR, 11).f23164f);

        /* renamed from: a, reason: collision with root package name */
        public long f23106a;

        /* renamed from: b, reason: collision with root package name */
        public long f23107b;

        /* renamed from: c, reason: collision with root package name */
        public Long f23108c;

        /* renamed from: d, reason: collision with root package name */
        public int f23109d;

        /* renamed from: e, reason: collision with root package name */
        public DateValidator f23110e;

        public b(CalendarConstraints calendarConstraints) {
            this.f23106a = f23104f;
            this.f23107b = f23105g;
            this.f23110e = DateValidatorPointForward.b(Long.MIN_VALUE);
            this.f23106a = calendarConstraints.f23097a.f23164f;
            this.f23107b = calendarConstraints.f23098b.f23164f;
            this.f23108c = Long.valueOf(calendarConstraints.f23100d.f23164f);
            this.f23109d = calendarConstraints.f23101e;
            this.f23110e = calendarConstraints.f23099c;
        }

        public CalendarConstraints a() {
            Month f10;
            Bundle bundle = new Bundle();
            bundle.putParcelable("DEEP_COPY_VALIDATOR_KEY", this.f23110e);
            Month f11 = Month.f(this.f23106a);
            Month f12 = Month.f(this.f23107b);
            DateValidator dateValidator = (DateValidator) bundle.getParcelable("DEEP_COPY_VALIDATOR_KEY");
            Long l10 = this.f23108c;
            if (l10 == null) {
                f10 = null;
            } else {
                f10 = Month.f(l10.longValue());
            }
            return new CalendarConstraints(f11, f12, dateValidator, f10, this.f23109d, null);
        }

        public b b(long j10) {
            this.f23108c = Long.valueOf(j10);
            return this;
        }
    }

    public /* synthetic */ CalendarConstraints(Month month, Month month2, DateValidator dateValidator, Month month3, int i10, a aVar) {
        this(month, month2, dateValidator, month3, i10);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CalendarConstraints)) {
            return false;
        }
        CalendarConstraints calendarConstraints = (CalendarConstraints) obj;
        if (this.f23097a.equals(calendarConstraints.f23097a) && this.f23098b.equals(calendarConstraints.f23098b) && I.c.a(this.f23100d, calendarConstraints.f23100d) && this.f23101e == calendarConstraints.f23101e && this.f23099c.equals(calendarConstraints.f23099c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f23097a, this.f23098b, this.f23100d, Integer.valueOf(this.f23101e), this.f23099c});
    }

    public Month j(Month month) {
        if (month.compareTo(this.f23097a) < 0) {
            return this.f23097a;
        }
        if (month.compareTo(this.f23098b) > 0) {
            return this.f23098b;
        }
        return month;
    }

    public DateValidator k() {
        return this.f23099c;
    }

    public Month m() {
        return this.f23098b;
    }

    public int n() {
        return this.f23101e;
    }

    public int p() {
        return this.f23103g;
    }

    public Month q() {
        return this.f23100d;
    }

    public Month t() {
        return this.f23097a;
    }

    public int v() {
        return this.f23102f;
    }

    public boolean w(long j10) {
        if (this.f23097a.j(1) <= j10) {
            Month month = this.f23098b;
            if (j10 <= month.j(month.f23163e)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f23097a, 0);
        parcel.writeParcelable(this.f23098b, 0);
        parcel.writeParcelable(this.f23100d, 0);
        parcel.writeParcelable(this.f23099c, 0);
        parcel.writeInt(this.f23101e);
    }

    public CalendarConstraints(Month month, Month month2, DateValidator dateValidator, Month month3, int i10) {
        Objects.requireNonNull(month, "start cannot be null");
        Objects.requireNonNull(month2, "end cannot be null");
        Objects.requireNonNull(dateValidator, "validator cannot be null");
        this.f23097a = month;
        this.f23098b = month2;
        this.f23100d = month3;
        this.f23101e = i10;
        this.f23099c = dateValidator;
        if (month3 != null && month.compareTo(month3) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if (month3 != null && month3.compareTo(month2) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        if (i10 >= 0 && i10 <= t.m().getMaximum(7)) {
            this.f23103g = month.q(month2) + 1;
            this.f23102f = (month2.f23161c - month.f23161c) + 1;
            return;
        }
        throw new IllegalArgumentException("firstDayOfWeek is not valid");
    }
}
