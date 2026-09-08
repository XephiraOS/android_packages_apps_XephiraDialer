package com.ted.phonenumber.entrys;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* loaded from: classes4.dex */
public class MessageItem$MessageMenu implements Parcelable {
    public static final Parcelable.Creator<MessageItem$MessageMenu> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final int f29856a;

    /* renamed from: b, reason: collision with root package name */
    public final String f29857b;

    /* renamed from: c, reason: collision with root package name */
    public final int f29858c;

    /* renamed from: d, reason: collision with root package name */
    public final String f29859d;

    /* renamed from: e, reason: collision with root package name */
    public String f29860e;

    /* renamed from: f, reason: collision with root package name */
    public List<MessageItem$SpItem> f29861f;

    /* renamed from: g, reason: collision with root package name */
    public List<MessageItem$MessageMenu> f29862g;

    /* renamed from: h, reason: collision with root package name */
    public String f29863h;

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
        this.f29856a = parcel.readInt();
        this.f29857b = parcel.readString();
        this.f29858c = parcel.readInt();
        this.f29859d = parcel.readString();
        this.f29860e = parcel.readString();
        this.f29861f = parcel.createTypedArrayList(MessageItem$SpItem.CREATOR);
        this.f29862g = parcel.createTypedArrayList(CREATOR);
        this.f29863h = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "MessageMenu{mLevel=" + this.f29856a + ", mTitle='" + this.f29857b + "', mCmdType=" + this.f29858c + ", mCommand='" + this.f29859d + "', mAlert='" + this.f29860e + "', mSpList=" + this.f29861f + ", mSubMenuList=" + this.f29862g + ", mExtendData='" + this.f29863h + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f29856a);
        parcel.writeString(this.f29857b);
        parcel.writeInt(this.f29858c);
        parcel.writeString(this.f29859d);
        parcel.writeString(this.f29860e);
        parcel.writeTypedList(this.f29861f);
        parcel.writeTypedList(this.f29862g);
        parcel.writeString(this.f29863h);
    }
}
