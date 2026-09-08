package com.ted.phonenumber.entrys;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes4.dex */
public class MessageItem$SpItem implements Parcelable {
    public static final Parcelable.Creator<MessageItem$SpItem> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public SpType f29864a;

    /* renamed from: b, reason: collision with root package name */
    public String f29865b;

    /* renamed from: c, reason: collision with root package name */
    public String f29866c;

    /* renamed from: d, reason: collision with root package name */
    public Bundle f29867d;

    /* loaded from: classes4.dex */
    public enum SpType {
        NONE,
        CM,
        CU,
        CE
    }

    /* loaded from: classes4.dex */
    public class a implements Parcelable.Creator<MessageItem$SpItem> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MessageItem$SpItem createFromParcel(Parcel parcel) {
            return new MessageItem$SpItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public MessageItem$SpItem[] newArray(int i10) {
            return new MessageItem$SpItem[i10];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f29865b);
        parcel.writeString(this.f29866c);
        parcel.writeBundle(this.f29867d);
        parcel.writeInt(this.f29864a.ordinal());
    }

    public MessageItem$SpItem(Parcel parcel) {
        this.f29867d = new Bundle();
        this.f29865b = parcel.readString();
        this.f29866c = parcel.readString();
        this.f29867d = parcel.readBundle();
        this.f29864a = SpType.values()[parcel.readInt()];
    }
}
