package com.android.contacts.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* compiled from: Account.kt */
/* loaded from: classes.dex */
public class Account implements Parcelable {
    public static final a CREATOR = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final String f16941a;

    /* renamed from: b, reason: collision with root package name */
    public final String f16942b;

    /* compiled from: Account.kt */
    /* loaded from: classes.dex */
    public static final class a implements Parcelable.Creator<Account> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Account createFromParcel(Parcel parcel) {
            kotlin.jvm.internal.i.f(parcel, "parcel");
            return new Account(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Account[] newArray(int i10) {
            return new Account[i10];
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public Account(String str, String str2) {
        this.f16941a = b(str);
        this.f16942b = b(str2);
    }

    public final String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str;
    }

    public boolean d() {
        if (this.f16941a == null && this.f16942b == null) {
            return true;
        }
        return false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Account)) {
            return false;
        }
        Account account = (Account) obj;
        if (!com.google.common.base.h.a(this.f16941a, account.f16941a) || !com.google.common.base.h.a(this.f16942b, account.f16942b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i10;
        String str = this.f16941a;
        int i11 = 0;
        if (str != null) {
            i10 = str.hashCode();
        } else {
            i10 = 0;
        }
        int i12 = (527 + i10) * 31;
        String str2 = this.f16942b;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return i12 + i11;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        kotlin.jvm.internal.i.f(parcel, "parcel");
        parcel.writeString(this.f16941a);
        parcel.writeString(this.f16942b);
    }

    public Account(Parcel parcel) {
        kotlin.jvm.internal.i.f(parcel, "parcel");
        this.f16941a = parcel.readString();
        this.f16942b = parcel.readString();
    }
}
