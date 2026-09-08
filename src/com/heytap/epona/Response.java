package com.heytap.epona;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class Response implements Parcelable {
    public static final Parcelable.Creator<Response> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final int f25423a;

    /* renamed from: b, reason: collision with root package name */
    public final String f25424b;

    /* renamed from: c, reason: collision with root package name */
    public Bundle f25425c;

    /* renamed from: d, reason: collision with root package name */
    public ParcelableException f25426d;

    /* loaded from: classes3.dex */
    public static class a implements Parcelable.Creator<Response> {
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

    public static Response d() {
        return new Response(-1, "somethings not yet...");
    }

    public static Response f(String str) {
        return new Response(-1, str);
    }

    public <T extends Throwable> void b(Class<T> cls) {
        Bundle bundle = this.f25425c;
        if (bundle == null) {
            return;
        }
        if (this.f25426d == null) {
            ExceptionInfo exceptionInfo = (ExceptionInfo) bundle.getParcelable("epona_exception_info");
            if (exceptionInfo == null) {
                return;
            } else {
                this.f25426d = ParcelableException.a(exceptionInfo);
            }
        }
        this.f25426d.b(cls);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Bundle h() {
        return this.f25425c;
    }

    public String i() {
        return this.f25424b;
    }

    public boolean j() {
        if (this.f25423a == 1) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "Successful=" + j() + ", Message=" + this.f25424b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f25423a);
        parcel.writeString(this.f25424b);
        parcel.writeBundle(this.f25425c);
    }

    public Response(int i10, String str) {
        this.f25423a = i10;
        this.f25424b = str;
        this.f25425c = new Bundle();
    }

    public Response(Parcel parcel) {
        this.f25423a = parcel.readInt();
        this.f25424b = parcel.readString();
        this.f25425c = parcel.readBundle(getClass().getClassLoader());
    }
}
