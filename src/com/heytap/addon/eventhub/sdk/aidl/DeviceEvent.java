package com.heytap.addon.eventhub.sdk.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class DeviceEvent implements Parcelable {
    public static final Parcelable.Creator<DeviceEvent> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public com.oplus.eventhub.sdk.aidl.DeviceEvent f25360a;

    /* renamed from: b, reason: collision with root package name */
    public com.coloros.eventhub.sdk.aidl.DeviceEvent f25361b;

    /* loaded from: classes3.dex */
    public static class a implements Parcelable.Creator<DeviceEvent> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DeviceEvent createFromParcel(Parcel parcel) {
            return new DeviceEvent(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public DeviceEvent[] newArray(int i10) {
            return new DeviceEvent[i10];
        }
    }

    public DeviceEvent(Parcel parcel) {
        if (A5.a.b()) {
            this.f25360a = new com.oplus.eventhub.sdk.aidl.DeviceEvent(parcel);
        } else {
            this.f25361b = new com.coloros.eventhub.sdk.aidl.DeviceEvent(parcel);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
    }
}
