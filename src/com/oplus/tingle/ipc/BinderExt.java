package com.oplus.tingle.ipc;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class BinderExt implements Parcelable {
    public static final Parcelable.Creator<BinderExt> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public IBinder f29024a;

    /* renamed from: b, reason: collision with root package name */
    public String f29025b;

    /* renamed from: c, reason: collision with root package name */
    public int f29026c;

    /* loaded from: classes3.dex */
    public static class a implements Parcelable.Creator<BinderExt> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BinderExt createFromParcel(Parcel parcel) {
            return new BinderExt(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public BinderExt[] newArray(int i10) {
            return new BinderExt[i10];
        }
    }

    public BinderExt(Parcel parcel) {
        this.f29024a = parcel.readStrongBinder();
        this.f29025b = parcel.readString();
        this.f29026c = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeStrongBinder(this.f29024a);
        parcel.writeString(this.f29025b);
        parcel.writeInt(this.f29026c);
    }
}
