package com.ted.number.entrys;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes4.dex */
public class CallerIdItem$IconData implements Parcelable {
    public static final Parcelable.Creator<CallerIdItem$IconData> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public String f29595a;

    /* renamed from: b, reason: collision with root package name */
    public String f29596b;

    /* renamed from: c, reason: collision with root package name */
    public String f29597c;

    /* loaded from: classes4.dex */
    public class a implements Parcelable.Creator<CallerIdItem$IconData> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CallerIdItem$IconData createFromParcel(Parcel parcel) {
            return new CallerIdItem$IconData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public CallerIdItem$IconData[] newArray(int i10) {
            return new CallerIdItem$IconData[i10];
        }
    }

    public CallerIdItem$IconData(Parcel parcel) {
        this.f29595a = parcel.readString();
        this.f29596b = parcel.readString();
        this.f29597c = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f29595a);
        parcel.writeString(this.f29596b);
        parcel.writeString(this.f29597c);
    }
}
