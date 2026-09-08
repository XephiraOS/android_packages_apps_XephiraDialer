package com.ted.phonenumber.entrys;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes4.dex */
public class CallerIdItem$MarkerData implements Parcelable {
    public static final Parcelable.Creator<CallerIdItem$MarkerData> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final int f29828a;

    /* renamed from: b, reason: collision with root package name */
    public final int f29829b;

    /* renamed from: c, reason: collision with root package name */
    public final String f29830c;

    /* renamed from: d, reason: collision with root package name */
    public final int f29831d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f29832e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f29833f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f29834g;

    /* loaded from: classes4.dex */
    public class a implements Parcelable.Creator<CallerIdItem$MarkerData> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CallerIdItem$MarkerData createFromParcel(Parcel parcel) {
            return new CallerIdItem$MarkerData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public CallerIdItem$MarkerData[] newArray(int i10) {
            return new CallerIdItem$MarkerData[i10];
        }
    }

    public CallerIdItem$MarkerData(Parcel parcel) {
        boolean z10;
        boolean z11;
        this.f29828a = parcel.readInt();
        this.f29829b = parcel.readInt();
        this.f29830c = parcel.readString();
        this.f29831d = parcel.readInt();
        if (parcel.readByte() != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f29832e = z10;
        if (parcel.readByte() != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.f29833f = z11;
        this.f29834g = parcel.readByte() != 0;
    }

    public boolean G() {
        return this.f29832e;
    }

    public boolean a0() {
        return this.f29834g;
    }

    public String b() {
        return this.f29830c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CallerIdItem$MarkerData)) {
            return false;
        }
        CallerIdItem$MarkerData callerIdItem$MarkerData = (CallerIdItem$MarkerData) obj;
        if (this.f29828a == callerIdItem$MarkerData.f29828a && this.f29831d == callerIdItem$MarkerData.f29831d && RecognitionNumber.h(this.f29830c, callerIdItem$MarkerData.f29830c) && this.f29832e == callerIdItem$MarkerData.f29832e && this.f29834g == callerIdItem$MarkerData.a0()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public int j0() {
        return this.f29828a;
    }

    public String toString() {
        return "MarkerData{mCounter=" + this.f29828a + ", mTypeMark=" + this.f29829b + ", mClassify='" + this.f29830c + "', mRiskLevel=" + this.f29831d + ", mIsNoMark=" + this.f29832e + ", mIsUploaded=" + this.f29833f + ", mIsCustomMark=" + this.f29834g + '}';
    }

    public int u() {
        return this.f29829b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f29828a);
        parcel.writeInt(this.f29829b);
        parcel.writeString(this.f29830c);
        parcel.writeInt(this.f29831d);
        parcel.writeByte(this.f29832e ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f29833f ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f29834g ? (byte) 1 : (byte) 0);
    }
}
