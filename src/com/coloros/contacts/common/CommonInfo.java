package com.coloros.contacts.common;

import android.os.Parcel;
import u3.InterfaceC1604a;

/* loaded from: classes.dex */
public class CommonInfo implements ItemType {

    /* renamed from: a, reason: collision with root package name */
    public int f19786a;

    public CommonInfo(int i10) {
        f(i10);
        d(null);
    }

    public InterfaceC1604a b() {
        return null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void f(int i10) {
        this.f19786a = i10;
    }

    public String toString() {
        b();
        return "Unknown";
    }

    public void d(InterfaceC1604a interfaceC1604a) {
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
    }
}
