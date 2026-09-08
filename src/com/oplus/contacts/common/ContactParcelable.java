package com.oplus.contacts.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.coloros.contacts.common.CommonInfo;
import com.coloros.contacts.common.IContactInfo;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class ContactParcelable extends CommonInfo implements IContactInfo {
    public static final Parcelable.Creator<ContactParcelable> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public long f27794b;

    /* renamed from: c, reason: collision with root package name */
    public String f27795c;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList<String> f27796d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList<String> f27797e;

    /* renamed from: f, reason: collision with root package name */
    public String f27798f;

    /* renamed from: g, reason: collision with root package name */
    public String f27799g;

    /* loaded from: classes3.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ContactParcelable createFromParcel(Parcel parcel) {
            ContactParcelable contactParcelable = new ContactParcelable();
            contactParcelable.m(parcel.readLong());
            contactParcelable.n(parcel.readString());
            contactParcelable.q(parcel.readString());
            contactParcelable.p(parcel.readString());
            contactParcelable.i(parcel.createStringArrayList());
            contactParcelable.h(parcel.createStringArrayList());
            return contactParcelable;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ContactParcelable[] newArray(int i10) {
            return new ContactParcelable[i10];
        }
    }

    public ContactParcelable() {
        super(0);
        this.f27798f = null;
        this.f27799g = null;
        this.f27796d = new ArrayList<>();
        this.f27797e = new ArrayList<>();
    }

    @Override // com.coloros.contacts.common.CommonInfo, android.os.Parcelable
    public int describeContents() {
        return super.describeContents();
    }

    public void h(ArrayList<String> arrayList) {
        this.f27797e.addAll(arrayList);
    }

    public void i(ArrayList<String> arrayList) {
        this.f27796d.addAll(arrayList);
    }

    public long j() {
        return this.f27794b;
    }

    public String k() {
        return this.f27798f;
    }

    public void m(long j10) {
        this.f27794b = j10;
    }

    public void n(String str) {
        this.f27795c = str;
    }

    public void p(String str) {
        this.f27799g = str;
        if (!this.f27797e.contains(str)) {
            this.f27797e.add(this.f27799g);
        }
    }

    public void q(String str) {
        this.f27798f = str;
        if (!this.f27796d.contains(str)) {
            this.f27796d.add(this.f27798f);
        }
    }

    @Override // com.coloros.contacts.common.CommonInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeLong(this.f27794b);
        parcel.writeString(this.f27795c);
        parcel.writeString(this.f27798f);
        parcel.writeString(this.f27799g);
        parcel.writeStringList(this.f27796d);
        parcel.writeStringList(this.f27797e);
    }
}
