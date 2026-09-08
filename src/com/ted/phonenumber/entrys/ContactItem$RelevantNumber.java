package com.ted.phonenumber.entrys;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes4.dex */
public class ContactItem$RelevantNumber implements Parcelable {
    public static final Parcelable.Creator<ContactItem$RelevantNumber> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public String f29853a;

    /* renamed from: b, reason: collision with root package name */
    public String f29854b;

    /* renamed from: c, reason: collision with root package name */
    public String f29855c;

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
        return "RelevantNumber{mPhone='" + this.f29853a + "', mName='" + this.f29854b + "', mDesc='" + this.f29855c + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f29853a);
        parcel.writeString(this.f29854b);
        parcel.writeString(this.f29855c);
    }

    public ContactItem$RelevantNumber(Parcel parcel) {
        this.f29853a = parcel.readString();
        this.f29854b = parcel.readString();
        this.f29855c = parcel.readString();
    }
}
