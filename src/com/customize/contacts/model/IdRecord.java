package com.customize.contacts.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.contacts.model.Account;

/* loaded from: classes3.dex */
public class IdRecord implements Parcelable, Z3.b {
    public static final Parcelable.Creator<IdRecord> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public String f21713a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f21714b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f21715c;

    /* renamed from: d, reason: collision with root package name */
    public long f21716d;

    /* renamed from: e, reason: collision with root package name */
    public long f21717e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f21718f;

    /* renamed from: g, reason: collision with root package name */
    public String f21719g;

    /* renamed from: h, reason: collision with root package name */
    public String f21720h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f21721i;

    /* renamed from: j, reason: collision with root package name */
    public Account f21722j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f21723k;

    /* loaded from: classes3.dex */
    public class a implements Parcelable.Creator<IdRecord> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public IdRecord createFromParcel(Parcel parcel) {
            return new IdRecord(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public IdRecord[] newArray(int i10) {
            return new IdRecord[i10];
        }
    }

    @Override // Z3.b
    public long b() {
        return this.f21716d;
    }

    public Account d() {
        return this.f21722j;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean f() {
        return this.f21718f;
    }

    public String getName() {
        String str = this.f21720h;
        if (str == null) {
            return "";
        }
        return str;
    }

    public String h() {
        String str = this.f21719g;
        if (str == null) {
            return "";
        }
        return str;
    }

    public long i() {
        return this.f21717e;
    }

    public boolean j() {
        return this.f21723k;
    }

    public boolean k() {
        return this.f21721i;
    }

    public void m(long j10) {
        this.f21716d = j10;
    }

    public void n(boolean z10) {
        this.f21723k = z10;
    }

    public void p(String str) {
        this.f21720h = str;
    }

    public void q(String str) {
        this.f21719g = str;
    }

    public void t(boolean z10) {
        this.f21721i = z10;
    }

    public String toString() {
        return "IdRecord{mLookup='" + this.f21713a + "', mChecked=" + this.f21714b + ", mIsActive=" + this.f21715c + ", mContactId=" + this.f21716d + ", mRawContactId=" + this.f21717e + ", mIsSimContact=" + this.f21718f + ", mNumber='" + H7.a.d(this.f21719g) + "', mIsStar=" + this.f21721i + ", mAccount=" + this.f21722j + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        boolean z10 = !this.f21714b;
        boolean z11 = !this.f21715c;
        boolean z12 = !this.f21718f;
        parcel.writeLong(this.f21717e);
        parcel.writeLong(this.f21716d);
        parcel.writeByte(z10 ? (byte) 1 : (byte) 0);
        parcel.writeByte(z11 ? (byte) 1 : (byte) 0);
        parcel.writeByte(z12 ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f21719g);
        parcel.writeString(this.f21720h);
        parcel.writeString(this.f21713a);
        parcel.writeParcelable(this.f21722j, i10);
    }

    public IdRecord(long j10, long j11, boolean z10, boolean z11) {
        this.f21713a = null;
        this.f21719g = "";
        this.f21720h = "";
        this.f21721i = false;
        this.f21722j = null;
        this.f21723k = false;
        this.f21716d = j10;
        this.f21714b = z10;
        this.f21715c = true;
        this.f21717e = j11;
        this.f21718f = z11;
    }

    public IdRecord(long j10, boolean z10, String str, boolean z11) {
        this.f21717e = -1L;
        this.f21718f = false;
        this.f21719g = "";
        this.f21720h = "";
        this.f21722j = null;
        this.f21723k = false;
        this.f21716d = j10;
        this.f21714b = z10;
        this.f21715c = true;
        this.f21713a = str;
        this.f21721i = z11;
    }

    public IdRecord(long j10, String str, String str2, boolean z10) {
        this.f21713a = null;
        this.f21717e = -1L;
        this.f21718f = false;
        this.f21721i = false;
        this.f21722j = null;
        this.f21723k = false;
        this.f21716d = j10;
        this.f21720h = str;
        this.f21719g = str2;
        this.f21714b = z10;
    }

    public IdRecord(long j10, String str, String str2, boolean z10, boolean z11) {
        this.f21713a = null;
        this.f21717e = -1L;
        this.f21718f = false;
        this.f21721i = false;
        this.f21722j = null;
        this.f21716d = j10;
        this.f21720h = str;
        this.f21719g = str2;
        this.f21714b = z10;
        this.f21723k = z11;
    }

    public IdRecord(long j10, boolean z10) {
        this.f21713a = null;
        this.f21717e = -1L;
        this.f21718f = false;
        this.f21719g = "";
        this.f21720h = "";
        this.f21721i = false;
        this.f21722j = null;
        this.f21723k = false;
        this.f21716d = j10;
        this.f21714b = z10;
        this.f21715c = true;
    }

    public IdRecord(long j10) {
        this.f21713a = null;
        this.f21717e = -1L;
        this.f21718f = false;
        this.f21719g = "";
        this.f21720h = "";
        this.f21721i = false;
        this.f21722j = null;
        this.f21723k = false;
        this.f21716d = j10;
        this.f21714b = false;
        this.f21715c = true;
    }

    public IdRecord(Account account, long j10) {
        this.f21713a = null;
        this.f21718f = false;
        this.f21719g = "";
        this.f21720h = "";
        this.f21721i = false;
        this.f21723k = false;
        this.f21722j = account;
        this.f21717e = j10;
    }

    public IdRecord(Parcel parcel) {
        this.f21713a = null;
        this.f21717e = -1L;
        this.f21718f = false;
        this.f21719g = "";
        this.f21720h = "";
        this.f21721i = false;
        this.f21722j = null;
        this.f21723k = false;
        ClassLoader classLoader = getClass().getClassLoader();
        this.f21717e = parcel.readLong();
        this.f21716d = parcel.readLong();
        this.f21714b = parcel.readByte() == 0;
        this.f21715c = parcel.readByte() == 0;
        this.f21718f = parcel.readByte() == 0;
        this.f21719g = parcel.readString();
        this.f21720h = parcel.readString();
        this.f21713a = parcel.readString();
        this.f21722j = (Account) parcel.readParcelable(classLoader);
    }
}
