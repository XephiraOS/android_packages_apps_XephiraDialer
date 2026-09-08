package com.customize.contacts.util;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class ContactsPhonesUtils$PhoneItem implements Parcelable {
    public static final Parcelable.Creator<ContactsPhonesUtils$PhoneItem> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public long f21868a;

    /* renamed from: b, reason: collision with root package name */
    public int f21869b;

    /* renamed from: c, reason: collision with root package name */
    public String f21870c;

    /* renamed from: d, reason: collision with root package name */
    public String f21871d;

    /* renamed from: e, reason: collision with root package name */
    public String f21872e;

    /* renamed from: f, reason: collision with root package name */
    public String f21873f;

    /* renamed from: g, reason: collision with root package name */
    public int f21874g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f21875h;

    /* loaded from: classes3.dex */
    public class a implements Parcelable.Creator<ContactsPhonesUtils$PhoneItem> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ContactsPhonesUtils$PhoneItem createFromParcel(Parcel parcel) {
            return new ContactsPhonesUtils$PhoneItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ContactsPhonesUtils$PhoneItem[] newArray(int i10) {
            return new ContactsPhonesUtils$PhoneItem[i10];
        }
    }

    public void b(boolean z10) {
        this.f21875h = z10;
    }

    public void d(String str) {
        this.f21873f = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void f(int i10) {
        this.f21874g = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(this.f21868a);
        parcel.writeInt(this.f21869b);
        parcel.writeString(this.f21870c);
        parcel.writeString(this.f21871d);
        parcel.writeString(this.f21872e);
        parcel.writeString(this.f21873f);
        parcel.writeInt(this.f21874g);
        parcel.writeByte(this.f21875h ? (byte) 1 : (byte) 0);
    }

    public ContactsPhonesUtils$PhoneItem(long j10, String str, String str2, int i10, boolean z10) {
        this.f21868a = j10;
        this.f21872e = str;
        this.f21871d = str2;
        this.f21869b = i10;
        this.f21874g = -1;
        this.f21875h = z10;
    }

    public ContactsPhonesUtils$PhoneItem(Parcel parcel) {
        this.f21875h = false;
        this.f21868a = parcel.readLong();
        this.f21869b = parcel.readInt();
        this.f21870c = parcel.readString();
        this.f21871d = parcel.readString();
        this.f21872e = parcel.readString();
        this.f21873f = parcel.readString();
        this.f21874g = parcel.readInt();
        this.f21875h = parcel.readByte() == 1;
    }
}
