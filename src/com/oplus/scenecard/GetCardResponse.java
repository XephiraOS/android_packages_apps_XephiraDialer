package com.oplus.scenecard;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.SurfaceControlViewHost;

/* loaded from: classes3.dex */
public class GetCardResponse implements Parcelable {
    public static final Parcelable.Creator<GetCardResponse> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public int f28916a;

    /* renamed from: b, reason: collision with root package name */
    public SurfaceControlViewHost.SurfacePackage f28917b;

    /* loaded from: classes3.dex */
    public class a implements Parcelable.Creator<GetCardResponse> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GetCardResponse createFromParcel(Parcel parcel) {
            return new GetCardResponse(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public GetCardResponse[] newArray(int i10) {
            return new GetCardResponse[i10];
        }
    }

    public GetCardResponse(int i10) {
        this.f28916a = i10;
    }

    public void b(SurfaceControlViewHost.SurfacePackage surfacePackage) {
        this.f28917b = surfacePackage;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f28916a);
        parcel.writeParcelable(this.f28917b, i10);
    }

    public GetCardResponse(Parcel parcel) {
        this.f28916a = parcel.readInt();
        this.f28917b = (SurfaceControlViewHost.SurfacePackage) parcel.readParcelable(SurfaceControlViewHost.SurfacePackage.class.getClassLoader());
    }
}
