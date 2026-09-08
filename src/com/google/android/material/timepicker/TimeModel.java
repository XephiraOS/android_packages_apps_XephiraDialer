package com.google.android.material.timepicker;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class TimeModel implements Parcelable {
    public static final Parcelable.Creator<TimeModel> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final b f24228a;

    /* renamed from: b, reason: collision with root package name */
    public final b f24229b;

    /* renamed from: c, reason: collision with root package name */
    public final int f24230c;

    /* renamed from: d, reason: collision with root package name */
    public int f24231d;

    /* renamed from: e, reason: collision with root package name */
    public int f24232e;

    /* renamed from: f, reason: collision with root package name */
    public int f24233f;

    /* renamed from: g, reason: collision with root package name */
    public int f24234g;

    /* loaded from: classes3.dex */
    public class a implements Parcelable.Creator<TimeModel> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TimeModel createFromParcel(Parcel parcel) {
            return new TimeModel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public TimeModel[] newArray(int i10) {
            return new TimeModel[i10];
        }
    }

    public TimeModel() {
        this(0);
    }

    public static String b(Resources resources, CharSequence charSequence) {
        return d(resources, charSequence, "%02d");
    }

    public static String d(Resources resources, CharSequence charSequence, String str) {
        try {
            return String.format(resources.getConfiguration().locale, str, Integer.valueOf(Integer.parseInt(String.valueOf(charSequence))));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static int f(int i10) {
        if (i10 >= 12) {
            return 1;
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimeModel)) {
            return false;
        }
        TimeModel timeModel = (TimeModel) obj;
        if (this.f24231d == timeModel.f24231d && this.f24232e == timeModel.f24232e && this.f24230c == timeModel.f24230c && this.f24233f == timeModel.f24233f) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f24230c), Integer.valueOf(this.f24231d), Integer.valueOf(this.f24232e), Integer.valueOf(this.f24233f)});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f24231d);
        parcel.writeInt(this.f24232e);
        parcel.writeInt(this.f24233f);
        parcel.writeInt(this.f24230c);
    }

    public TimeModel(int i10) {
        this(0, 0, 10, i10);
    }

    public TimeModel(int i10, int i11, int i12, int i13) {
        this.f24231d = i10;
        this.f24232e = i11;
        this.f24233f = i12;
        this.f24230c = i13;
        this.f24234g = f(i10);
        this.f24228a = new b(59);
        this.f24229b = new b(i13 == 1 ? 23 : 12);
    }

    public TimeModel(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
    }
}
