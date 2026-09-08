package com.oplus.epona;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class Response implements Parcelable {
    public static final Parcelable.Creator<Response> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final int f28134a;

    /* renamed from: b, reason: collision with root package name */
    public final String f28135b;

    /* renamed from: c, reason: collision with root package name */
    public Bundle f28136c;

    /* loaded from: classes3.dex */
    public class a implements Parcelable.Creator<Response> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Response createFromParcel(Parcel parcel) {
            return new Response(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Response[] newArray(int i10) {
            return new Response[i10];
        }
    }

    public /* synthetic */ Response(Parcel parcel, a aVar) {
        this(parcel);
    }

    public static Response b() {
        return new Response(ResponseCode.FAILED.a(), "somethings not yet...");
    }

    public static Response d(Exception exc) {
        Response response = new Response(ResponseCode.FAILED.a(), "response has exception");
        response.h().putParcelable("epona_exception_info", new ExceptionInfo(exc));
        return response;
    }

    public static Response f(String str) {
        return new Response(ResponseCode.FAILED.a(), str);
    }

    public static Response k(Bundle bundle) {
        Response response = new Response(ResponseCode.SUCCESS.a(), "");
        response.m(bundle);
        return response;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Bundle h() {
        return this.f28136c;
    }

    public String i() {
        return this.f28135b;
    }

    public boolean j() {
        if (this.f28134a == ResponseCode.SUCCESS.a()) {
            return true;
        }
        return false;
    }

    public final void m(Bundle bundle) {
        this.f28136c = bundle;
    }

    public String toString() {
        return "Successful=" + j() + ", Message=" + this.f28135b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f28134a);
        parcel.writeString(this.f28135b);
        parcel.writeBundle(this.f28136c);
    }

    public Response(int i10, String str) {
        this.f28134a = i10;
        this.f28135b = str;
        this.f28136c = new Bundle();
    }

    public Response(Parcel parcel) {
        this.f28134a = parcel.readInt();
        this.f28135b = parcel.readString();
        this.f28136c = parcel.readBundle(getClass().getClassLoader());
    }
}
