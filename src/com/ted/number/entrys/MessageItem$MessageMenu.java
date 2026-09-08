package com.ted.number.entrys;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* loaded from: classes4.dex */
public class MessageItem$MessageMenu implements Parcelable {
    public static final Parcelable.Creator<MessageItem$MessageMenu> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final int f29626a;

    /* renamed from: b, reason: collision with root package name */
    public final String f29627b;

    /* renamed from: c, reason: collision with root package name */
    public final int f29628c;

    /* renamed from: d, reason: collision with root package name */
    public final String f29629d;

    /* renamed from: e, reason: collision with root package name */
    public String f29630e;

    /* renamed from: f, reason: collision with root package name */
    public List<MessageItem$SpItem> f29631f;

    /* renamed from: g, reason: collision with root package name */
    public List<MessageItem$MessageMenu> f29632g;

    /* renamed from: h, reason: collision with root package name */
    public String f29633h;

    /* loaded from: classes4.dex */
    public class a implements Parcelable.Creator<MessageItem$MessageMenu> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MessageItem$MessageMenu createFromParcel(Parcel parcel) {
            return new MessageItem$MessageMenu(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public MessageItem$MessageMenu[] newArray(int i10) {
            return new MessageItem$MessageMenu[i10];
        }
    }

    public MessageItem$MessageMenu(Parcel parcel) {
        this.f29626a = parcel.readInt();
        this.f29627b = parcel.readString();
        this.f29628c = parcel.readInt();
        this.f29629d = parcel.readString();
        this.f29630e = parcel.readString();
        this.f29631f = parcel.createTypedArrayList(MessageItem$SpItem.CREATOR);
        this.f29632g = parcel.createTypedArrayList(CREATOR);
        this.f29633h = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "MessageMenu{mLevel=" + this.f29626a + ", mTitle='" + this.f29627b + "', mCmdType=" + this.f29628c + ", mCommand='" + this.f29629d + "', mAlert='" + this.f29630e + "', mSpList=" + this.f29631f + ", mSubMenuList=" + this.f29632g + ", mExtendData='" + this.f29633h + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f29626a);
        parcel.writeString(this.f29627b);
        parcel.writeInt(this.f29628c);
        parcel.writeString(this.f29629d);
        parcel.writeString(this.f29630e);
        parcel.writeTypedList(this.f29631f);
        parcel.writeTypedList(this.f29632g);
        parcel.writeString(this.f29633h);
    }
}
