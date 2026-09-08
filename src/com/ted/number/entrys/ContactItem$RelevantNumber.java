package com.ted.number.entrys;

import D2.g;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes4.dex */
public class ContactItem$RelevantNumber implements Parcelable {
    public static final Parcelable.Creator<ContactItem$RelevantNumber> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public String f29623a;

    /* renamed from: b, reason: collision with root package name */
    public String f29624b;

    /* renamed from: c, reason: collision with root package name */
    public String f29625c;

    /* loaded from: classes4.dex */
    public class a implements Parcelable.Creator<ContactItem$RelevantNumber> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ContactItem$RelevantNumber createFromParcel(Parcel parcel) {
            return new ContactItem$RelevantNumber(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ContactItem$RelevantNumber[] newArray(int i10) {
            return new ContactItem$RelevantNumber[i10];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "RelevantNumber{mPhone='" + g.l(this.f29623a) + "', mName='" + g.l(this.f29624b) + "', mDesc='" + g.l(this.f29625c) + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f29623a);
        parcel.writeString(this.f29624b);
        parcel.writeString(this.f29625c);
    }

    public ContactItem$RelevantNumber(Parcel parcel) {
        this.f29623a = parcel.readString();
        this.f29624b = parcel.readString();
        this.f29625c = parcel.readString();
    }
}
