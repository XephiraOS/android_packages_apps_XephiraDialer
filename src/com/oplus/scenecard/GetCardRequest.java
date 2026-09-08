package com.oplus.scenecard;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class GetCardRequest implements Parcelable {
    public static final Parcelable.Creator<GetCardRequest> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public int f28911a;

    /* renamed from: b, reason: collision with root package name */
    public int f28912b;

    /* renamed from: c, reason: collision with root package name */
    public int f28913c;

    /* renamed from: d, reason: collision with root package name */
    public int f28914d;

    /* renamed from: e, reason: collision with root package name */
    public IBinder f28915e;

    /* loaded from: classes3.dex */
    public class a implements Parcelable.Creator<GetCardRequest> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GetCardRequest createFromParcel(Parcel parcel) {
            return new GetCardRequest(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public GetCardRequest[] newArray(int i10) {
            return new GetCardRequest[i10];
        }
    }

    public GetCardRequest(Parcel parcel) {
        this.f28911a = parcel.readInt();
        this.f28912b = parcel.readInt();
        this.f28913c = parcel.readInt();
        this.f28914d = parcel.readInt();
        this.f28915e = parcel.readStrongBinder();
    }

    public int b() {
        return this.f28911a;
    }

    public int d() {
        return this.f28912b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public IBinder f() {
        return this.f28915e;
    }

    public int h() {
        return this.f28914d;
    }

    public int i() {
        return this.f28913c;
    }

    public String toString() {
        return "GetCardRequest{mCardId=" + this.f28911a + ", mDisplayId=" + this.f28912b + ", mRequestWidth=" + this.f28913c + ", mRequestHeight=" + this.f28914d + ", mHostInputToken=" + this.f28915e + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f28911a);
        parcel.writeInt(this.f28912b);
        parcel.writeInt(this.f28913c);
        parcel.writeInt(this.f28914d);
        parcel.writeStrongBinder(this.f28915e);
    }
}
