package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.datepicker.CalendarConstraints;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public final class CompositeDateValidator implements CalendarConstraints.DateValidator {

    /* renamed from: a, reason: collision with root package name */
    public final d f23113a;

    /* renamed from: b, reason: collision with root package name */
    public final List<CalendarConstraints.DateValidator> f23114b;

    /* renamed from: c, reason: collision with root package name */
    public static final d f23111c = new a();

    /* renamed from: d, reason: collision with root package name */
    public static final d f23112d = new b();
    public static final Parcelable.Creator<CompositeDateValidator> CREATOR = new c();

    /* loaded from: classes3.dex */
    public class a implements d {
        @Override // com.google.android.material.datepicker.CompositeDateValidator.d
        public boolean a(List<CalendarConstraints.DateValidator> list, long j10) {
            for (CalendarConstraints.DateValidator dateValidator : list) {
                if (dateValidator != null && dateValidator.X(j10)) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.android.material.datepicker.CompositeDateValidator.d
        public int getId() {
            return 1;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d {
        @Override // com.google.android.material.datepicker.CompositeDateValidator.d
        public boolean a(List<CalendarConstraints.DateValidator> list, long j10) {
            for (CalendarConstraints.DateValidator dateValidator : list) {
                if (dateValidator != null && !dateValidator.X(j10)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.android.material.datepicker.CompositeDateValidator.d
        public int getId() {
            return 2;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Parcelable.Creator<CompositeDateValidator> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CompositeDateValidator createFromParcel(Parcel parcel) {
            d dVar;
            ArrayList readArrayList = parcel.readArrayList(CalendarConstraints.DateValidator.class.getClassLoader());
            int readInt = parcel.readInt();
            if (readInt == 2) {
                dVar = CompositeDateValidator.f23112d;
            } else {
                dVar = readInt == 1 ? CompositeDateValidator.f23111c : CompositeDateValidator.f23112d;
            }
            return new CompositeDateValidator((List) I.h.e(readArrayList), dVar, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public CompositeDateValidator[] newArray(int i10) {
            return new CompositeDateValidator[i10];
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        boolean a(List<CalendarConstraints.DateValidator> list, long j10);

        int getId();
    }

    public /* synthetic */ CompositeDateValidator(List list, d dVar, a aVar) {
        this(list, dVar);
    }

    @Override // com.google.android.material.datepicker.CalendarConstraints.DateValidator
    public boolean X(long j10) {
        return this.f23113a.a(this.f23114b, j10);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CompositeDateValidator)) {
            return false;
        }
        CompositeDateValidator compositeDateValidator = (CompositeDateValidator) obj;
        if (this.f23114b.equals(compositeDateValidator.f23114b) && this.f23113a.getId() == compositeDateValidator.f23113a.getId()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f23114b.hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeList(this.f23114b);
        parcel.writeInt(this.f23113a.getId());
    }

    public CompositeDateValidator(List<CalendarConstraints.DateValidator> list, d dVar) {
        this.f23114b = list;
        this.f23113a = dVar;
    }
}
