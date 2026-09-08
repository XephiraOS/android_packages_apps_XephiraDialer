package com.heytap.addon.eventhub.sdk.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class EventRequestConfig implements Parcelable {
    public static final Parcelable.Creator<EventRequestConfig> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public com.oplus.eventhub.sdk.aidl.EventRequestConfig f25362a;

    /* renamed from: b, reason: collision with root package name */
    public com.coloros.eventhub.sdk.aidl.EventRequestConfig f25363b;

    /* loaded from: classes3.dex */
    public static class a implements Parcelable.Creator<EventRequestConfig> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public EventRequestConfig createFromParcel(Parcel parcel) {
            return new EventRequestConfig(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EventRequestConfig[] newArray(int i10) {
            return new EventRequestConfig[i10];
        }
    }

    public EventRequestConfig(Parcel parcel) {
        if (A5.a.b()) {
            this.f25362a = new com.oplus.eventhub.sdk.aidl.EventRequestConfig(parcel);
        } else {
            this.f25363b = new com.coloros.eventhub.sdk.aidl.EventRequestConfig(parcel);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        if (A5.a.b()) {
            return this.f25362a.describeContents();
        }
        return this.f25363b.describeContents();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        if (A5.a.b()) {
            this.f25362a.writeToParcel(parcel, i10);
        } else {
            this.f25363b.writeToParcel(parcel, i10);
        }
    }
}
