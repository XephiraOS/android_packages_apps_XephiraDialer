package com.coloros.contacts.common;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ContactParcelable extends CommonInfo implements IContactInfo {
    public static final Parcelable.Creator<ContactParcelable> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public long f19787b;

    /* renamed from: c, reason: collision with root package name */
    public String f19788c;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList<String> f19789d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList<String> f19790e;

    /* renamed from: f, reason: collision with root package name */
    public String f19791f;

    /* renamed from: g, reason: collision with root package name */
    public String f19792g;

    /* loaded from: classes.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ContactParcelable createFromParcel(Parcel parcel) {
            ContactParcelable contactParcelable = new ContactParcelable();
            contactParcelable.q(parcel.readLong());
            contactParcelable.t(parcel.readString());
            contactParcelable.w(parcel.readString());
            contactParcelable.v(parcel.readString());
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
        this.f19791f = null;
        this.f19792g = null;
        this.f19789d = new ArrayList<>();
        this.f19790e = new ArrayList<>();
    }

    @Override // com.coloros.contacts.common.CommonInfo, android.os.Parcelable
    public int describeContents() {
        return super.describeContents();
    }

    public String getName() {
        return this.f19788c;
    }

    public void h(ArrayList<String> arrayList) {
        this.f19790e.addAll(arrayList);
    }

    public void i(ArrayList<String> arrayList) {
        this.f19789d.addAll(arrayList);
    }

    public ArrayList<String> j() {
        return this.f19790e;
    }

    public long k() {
        return this.f19787b;
    }

    public ArrayList<String> m() {
        return this.f19789d;
    }

    public String n() {
        return this.f19792g;
    }

    public String p() {
        return this.f19791f;
    }

    public void q(long j10) {
        this.f19787b = j10;
    }

    public void t(String str) {
        this.f19788c = str;
    }

    public void v(String str) {
        this.f19792g = str;
        if (!this.f19790e.contains(str)) {
            this.f19790e.add(this.f19792g);
        }
    }

    public void w(String str) {
        this.f19791f = str;
        if (!this.f19789d.contains(str)) {
            this.f19789d.add(this.f19791f);
        }
    }

    @Override // com.coloros.contacts.common.CommonInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeLong(this.f19787b);
        parcel.writeString(this.f19788c);
        parcel.writeString(this.f19791f);
        parcel.writeString(this.f19792g);
        parcel.writeStringList(this.f19789d);
        parcel.writeStringList(this.f19790e);
    }
}
