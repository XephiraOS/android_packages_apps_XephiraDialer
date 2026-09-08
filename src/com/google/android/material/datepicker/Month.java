package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class Month implements Comparable<Month>, Parcelable {
    public static final Parcelable.Creator<Month> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final Calendar f23159a;

    /* renamed from: b, reason: collision with root package name */
    public final int f23160b;

    /* renamed from: c, reason: collision with root package name */
    public final int f23161c;

    /* renamed from: d, reason: collision with root package name */
    public final int f23162d;

    /* renamed from: e, reason: collision with root package name */
    public final int f23163e;

    /* renamed from: f, reason: collision with root package name */
    public final long f23164f;

    /* renamed from: g, reason: collision with root package name */
    public String f23165g;

    /* loaded from: classes3.dex */
    public class a implements Parcelable.Creator<Month> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Month createFromParcel(Parcel parcel) {
            return Month.d(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Month[] newArray(int i10) {
            return new Month[i10];
        }
    }

    public Month(Calendar calendar) {
        calendar.set(5, 1);
        Calendar e10 = t.e(calendar);
        this.f23159a = e10;
        this.f23160b = e10.get(2);
        this.f23161c = e10.get(1);
        this.f23162d = e10.getMaximum(7);
        this.f23163e = e10.getActualMaximum(5);
        this.f23164f = e10.getTimeInMillis();
    }

    public static Month d(int i10, int i11) {
        Calendar m10 = t.m();
        m10.set(1, i10);
        m10.set(2, i11);
        return new Month(m10);
    }

    public static Month f(long j10) {
        Calendar m10 = t.m();
        m10.setTimeInMillis(j10);
        return new Month(m10);
    }

    public static Month h() {
        return new Month(t.k());
    }

    @Override // java.lang.Comparable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(Month month) {
        return this.f23159a.compareTo(month.f23159a);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Month)) {
            return false;
        }
        Month month = (Month) obj;
        if (this.f23160b == month.f23160b && this.f23161c == month.f23161c) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f23160b), Integer.valueOf(this.f23161c)});
    }

    public int i(int i10) {
        int i11 = this.f23159a.get(7);
        if (i10 <= 0) {
            i10 = this.f23159a.getFirstDayOfWeek();
        }
        int i12 = i11 - i10;
        if (i12 < 0) {
            return i12 + this.f23162d;
        }
        return i12;
    }

    public long j(int i10) {
        Calendar e10 = t.e(this.f23159a);
        e10.set(5, i10);
        return e10.getTimeInMillis();
    }

    public int k(long j10) {
        Calendar e10 = t.e(this.f23159a);
        e10.setTimeInMillis(j10);
        return e10.get(5);
    }

    public String m() {
        if (this.f23165g == null) {
            this.f23165g = h.l(this.f23159a.getTimeInMillis());
        }
        return this.f23165g;
    }

    public long n() {
        return this.f23159a.getTimeInMillis();
    }

    public Month p(int i10) {
        Calendar e10 = t.e(this.f23159a);
        e10.add(2, i10);
        return new Month(e10);
    }

    public int q(Month month) {
        if (this.f23159a instanceof GregorianCalendar) {
            return ((month.f23161c - this.f23161c) * 12) + (month.f23160b - this.f23160b);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f23161c);
        parcel.writeInt(this.f23160b);
    }
}
