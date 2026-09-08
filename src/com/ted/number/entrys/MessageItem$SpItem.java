package com.ted.number.entrys;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes4.dex */
public class MessageItem$SpItem implements Parcelable {
    public static final Parcelable.Creator<MessageItem$SpItem> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public SpType f29634a;

    /* renamed from: b, reason: collision with root package name */
    public String f29635b;

    /* renamed from: c, reason: collision with root package name */
    public String f29636c;

    /* renamed from: d, reason: collision with root package name */
    public Bundle f29637d;

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
        parcel.writeString(this.f29635b);
        parcel.writeString(this.f29636c);
        parcel.writeBundle(this.f29637d);
        parcel.writeInt(this.f29634a.ordinal());
    }

    public MessageItem$SpItem(Parcel parcel) {
        this.f29637d = new Bundle();
        this.f29635b = parcel.readString();
        this.f29636c = parcel.readString();
        this.f29637d = parcel.readBundle();
        this.f29634a = SpType.values()[parcel.readInt()];
    }
}
