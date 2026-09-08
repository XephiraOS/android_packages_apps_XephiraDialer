package com.ted.number.entrys;

import D2.g;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes4.dex */
public class CallerIdItem$MarkerData implements Parcelable {
    public static final Parcelable.Creator<CallerIdItem$MarkerData> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final int f29598a;

    /* renamed from: b, reason: collision with root package name */
    public final int f29599b;

    /* renamed from: c, reason: collision with root package name */
    public final String f29600c;

    /* renamed from: d, reason: collision with root package name */
    public final int f29601d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f29602e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f29603f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f29604g;

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
        this.f29598a = parcel.readInt();
        this.f29599b = parcel.readInt();
        this.f29600c = parcel.readString();
        this.f29601d = parcel.readInt();
        if (parcel.readByte() != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f29602e = z10;
        if (parcel.readByte() != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.f29603f = z11;
        this.f29604g = parcel.readByte() != 0;
    }

    public boolean G() {
        return this.f29602e;
    }

    public boolean a0() {
        return this.f29604g;
    }

    public String b() {
        return this.f29600c;
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
        if (this.f29598a == callerIdItem$MarkerData.f29598a && this.f29601d == callerIdItem$MarkerData.f29601d && RecognitionNumber.i(this.f29600c, callerIdItem$MarkerData.f29600c) && this.f29602e == callerIdItem$MarkerData.f29602e && this.f29604g == callerIdItem$MarkerData.a0()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public int j0() {
        return this.f29598a;
    }

    public String toString() {
        return "MarkerData{mCounter=" + this.f29598a + ", mTypeMark=" + this.f29599b + ", mClassify='" + g.l(this.f29600c) + "', mRiskLevel=" + this.f29601d + ", mIsNoMark=" + this.f29602e + ", mIsUploaded=" + this.f29603f + ", mIsCustomMark=" + this.f29604g + '}';
    }

    public int u() {
        return this.f29599b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f29598a);
        parcel.writeInt(this.f29599b);
        parcel.writeString(this.f29600c);
        parcel.writeInt(this.f29601d);
        parcel.writeByte(this.f29602e ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f29603f ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f29604g ? (byte) 1 : (byte) 0);
    }
}
