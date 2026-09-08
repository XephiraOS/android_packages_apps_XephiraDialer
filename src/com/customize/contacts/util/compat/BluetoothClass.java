package com.customize.contacts.util.compat;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public final class BluetoothClass implements Parcelable {
    public static final Parcelable.Creator<BluetoothClass> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final int f22059a;

    /* loaded from: classes3.dex */
    public class a implements Parcelable.Creator<BluetoothClass> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BluetoothClass createFromParcel(Parcel parcel) {
            return new BluetoothClass(parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public BluetoothClass[] newArray(int i10) {
            return new BluetoothClass[i10];
        }
    }

    public BluetoothClass(int i10) {
        this.f22059a = i10;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BluetoothClass) || this.f22059a != ((BluetoothClass) obj).f22059a) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f22059a;
    }

    public String toString() {
        return Integer.toHexString(this.f22059a);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f22059a);
    }
}
