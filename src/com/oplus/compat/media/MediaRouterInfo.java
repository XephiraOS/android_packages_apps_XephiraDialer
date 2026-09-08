package com.oplus.compat.media;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class MediaRouterInfo implements Parcelable {
    public static final Parcelable.Creator<MediaRouterInfo> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public String f27785a;

    /* renamed from: b, reason: collision with root package name */
    public int f27786b;

    /* renamed from: c, reason: collision with root package name */
    public String f27787c;

    /* renamed from: d, reason: collision with root package name */
    public int f27788d;

    /* renamed from: e, reason: collision with root package name */
    public int f27789e;

    /* renamed from: f, reason: collision with root package name */
    public int f27790f;

    /* renamed from: g, reason: collision with root package name */
    public String f27791g;

    /* renamed from: h, reason: collision with root package name */
    public String f27792h;

    /* renamed from: i, reason: collision with root package name */
    public int f27793i;

    /* loaded from: classes3.dex */
    public class a implements Parcelable.Creator<MediaRouterInfo> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MediaRouterInfo createFromParcel(Parcel parcel) {
            return new MediaRouterInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public MediaRouterInfo[] newArray(int i10) {
            return new MediaRouterInfo[i10];
        }
    }

    public MediaRouterInfo() {
        this.f27790f = -1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MediaRouterInfo mediaRouterInfo = (MediaRouterInfo) obj;
        String str = this.f27785a;
        if (str != null && !str.equals(mediaRouterInfo.f27785a)) {
            return false;
        }
        String str2 = this.f27791g;
        if (str2 != null && !str2.equals(mediaRouterInfo.f27791g)) {
            return false;
        }
        String str3 = this.f27792h;
        if (str3 == null || str3.equals(mediaRouterInfo.f27792h)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f27785a, this.f27791g, this.f27792h, Integer.valueOf(this.f27789e)});
    }

    public String toString() {
        return "MediaRouterInfo{mName='" + this.f27785a + "', mNameResId=" + this.f27786b + ", mDescription='" + this.f27787c + "', mSupportedTypes=" + this.f27788d + ", mDeviceType=" + this.f27789e + ", mPresentationDisplayId=" + this.f27790f + ", mDeviceAddress='" + this.f27791g + "', mGlobalRouteId='" + this.f27792h + "', mResolvedStatusCode=" + this.f27793i + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f27785a);
        parcel.writeInt(this.f27786b);
        parcel.writeString(this.f27787c);
        parcel.writeInt(this.f27788d);
        parcel.writeInt(this.f27789e);
        parcel.writeInt(this.f27790f);
        parcel.writeString(this.f27791g);
        parcel.writeString(this.f27792h);
        parcel.writeInt(this.f27793i);
    }

    public MediaRouterInfo(Parcel parcel) {
        this.f27790f = -1;
        this.f27785a = parcel.readString();
        this.f27786b = parcel.readInt();
        this.f27787c = parcel.readString();
        this.f27788d = parcel.readInt();
        this.f27789e = parcel.readInt();
        this.f27790f = parcel.readInt();
        this.f27791g = parcel.readString();
        this.f27792h = parcel.readString();
        this.f27793i = parcel.readInt();
    }
}
