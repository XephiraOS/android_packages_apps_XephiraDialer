package com.oplusx.sysapi.media;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* loaded from: classes4.dex */
public class MediaRouterInfo implements Parcelable {
    public static final Parcelable.Creator<MediaRouterInfo> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public String f29365a;

    /* renamed from: b, reason: collision with root package name */
    public int f29366b;

    /* renamed from: c, reason: collision with root package name */
    public String f29367c;

    /* renamed from: d, reason: collision with root package name */
    public int f29368d;

    /* renamed from: e, reason: collision with root package name */
    public int f29369e;

    /* renamed from: f, reason: collision with root package name */
    public int f29370f;

    /* renamed from: g, reason: collision with root package name */
    public String f29371g;

    /* renamed from: h, reason: collision with root package name */
    public String f29372h;

    /* renamed from: i, reason: collision with root package name */
    public int f29373i;

    /* loaded from: classes4.dex */
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
        this.f29370f = -1;
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
        String str = this.f29365a;
        if (str != null && !str.equals(mediaRouterInfo.f29365a)) {
            return false;
        }
        String str2 = this.f29371g;
        if (str2 != null && !str2.equals(mediaRouterInfo.f29371g)) {
            return false;
        }
        String str3 = this.f29372h;
        if (str3 == null || str3.equals(mediaRouterInfo.f29372h)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f29365a, this.f29371g, this.f29372h, Integer.valueOf(this.f29369e)});
    }

    public String toString() {
        return "MediaRouterInfo{mName='" + this.f29365a + "', mNameResId=" + this.f29366b + ", mDescription='" + this.f29367c + "', mSupportedTypes=" + this.f29368d + ", mDeviceType=" + this.f29369e + ", mPresentationDisplayId=" + this.f29370f + ", mDeviceAddress='" + this.f29371g + "', mGlobalRouteId='" + this.f29372h + "', mResolvedStatusCode=" + this.f29373i + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f29365a);
        parcel.writeInt(this.f29366b);
        parcel.writeString(this.f29367c);
        parcel.writeInt(this.f29368d);
        parcel.writeInt(this.f29369e);
        parcel.writeInt(this.f29370f);
        parcel.writeString(this.f29371g);
        parcel.writeString(this.f29372h);
        parcel.writeInt(this.f29373i);
    }

    public MediaRouterInfo(Parcel parcel) {
        this.f29370f = -1;
        this.f29365a = parcel.readString();
        this.f29366b = parcel.readInt();
        this.f29367c = parcel.readString();
        this.f29368d = parcel.readInt();
        this.f29369e = parcel.readInt();
        this.f29370f = parcel.readInt();
        this.f29371g = parcel.readString();
        this.f29372h = parcel.readString();
        this.f29373i = parcel.readInt();
    }
}
