package com.appaac.haptic.sync;

import U2.a;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public String f19274a;

    /* renamed from: b, reason: collision with root package name */
    public int f19275b;

    /* renamed from: c, reason: collision with root package name */
    public int f19276c;

    public b(Parcel parcel) {
        this.f19274a = parcel.readString();
        this.f19275b = parcel.readInt();
        this.f19276c = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "loop='" + this.f19275b + "',interval='" + this.f19276c + "'," + this.f19274a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f19274a);
        parcel.writeInt(this.f19275b);
        parcel.writeInt(this.f19276c);
    }
}
