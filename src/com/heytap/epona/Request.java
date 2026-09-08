package com.heytap.epona;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class Request implements Parcelable {
    public static final Parcelable.Creator<Request> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final String f25417a;

    /* renamed from: b, reason: collision with root package name */
    public final String f25418b;

    /* renamed from: c, reason: collision with root package name */
    public Bundle f25419c;

    /* loaded from: classes3.dex */
    public static class a implements Parcelable.Creator<Request> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Request createFromParcel(Parcel parcel) {
            return new Request(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Request[] newArray(int i10) {
            return new Request[i10];
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f25420a;

        /* renamed from: b, reason: collision with root package name */
        public String f25421b;

        /* renamed from: c, reason: collision with root package name */
        public Bundle f25422c = new Bundle();

        public Request a() {
            return new Request(this.f25420a, this.f25421b, this.f25422c, null);
        }

        public b b(String str) {
            this.f25421b = str;
            return this;
        }

        public b c(String str) {
            this.f25420a = str;
            return this;
        }
    }

    public /* synthetic */ Request(Parcel parcel, a aVar) {
        this(parcel);
    }

    public String b() {
        return this.f25418b;
    }

    public String d() {
        return this.f25417a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void f(Bundle bundle) {
        this.f25419c.putAll(bundle);
    }

    public String toString() {
        return "Request{Component=" + this.f25417a + ",Action=" + this.f25418b + ",Bundle=" + this.f25419c + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f25417a);
        parcel.writeString(this.f25418b);
        parcel.writeBundle(this.f25419c);
    }

    public /* synthetic */ Request(String str, String str2, Bundle bundle, a aVar) {
        this(str, str2, bundle);
    }

    public Request(String str, String str2, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        this.f25419c = bundle2;
        this.f25417a = str;
        this.f25418b = str2;
        bundle2.putAll(bundle);
    }

    public Request(Parcel parcel) {
        this.f25419c = new Bundle();
        this.f25417a = parcel.readString();
        this.f25418b = parcel.readString();
        this.f25419c = parcel.readBundle(getClass().getClassLoader());
    }
}
