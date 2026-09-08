package com.ted.phonenumber.entrys;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class ContactItem$ContactMenu implements Parcelable {
    public static final Parcelable.Creator<ContactItem$ContactMenu> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final int f29835a;

    /* renamed from: b, reason: collision with root package name */
    public final String f29836b;

    /* renamed from: c, reason: collision with root package name */
    public final String f29837c;

    /* renamed from: d, reason: collision with root package name */
    public final String f29838d;

    /* renamed from: e, reason: collision with root package name */
    public final int f29839e;

    /* renamed from: f, reason: collision with root package name */
    public final String f29840f;

    /* renamed from: g, reason: collision with root package name */
    public ArrayList<ContactItem$ContactMenu> f29841g;

    /* renamed from: h, reason: collision with root package name */
    public String f29842h;

    /* renamed from: i, reason: collision with root package name */
    public ArrayList<MessageItem$SpItem> f29843i;

    /* loaded from: classes4.dex */
    public class a implements Parcelable.Creator<ContactItem$ContactMenu> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ContactItem$ContactMenu createFromParcel(Parcel parcel) {
            return new ContactItem$ContactMenu(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ContactItem$ContactMenu[] newArray(int i10) {
            return new ContactItem$ContactMenu[i10];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ContactMenu{mLevel=" + this.f29835a + ", mTitle='" + this.f29836b + "', mSummary='" + this.f29837c + "', mLogoUrl='" + this.f29838d + "', mCmdType=" + this.f29839e + ", mCommand='" + this.f29840f + "', mSubMenuList=" + this.f29841g + ", mExtendData='" + this.f29842h + "', mSpList=" + this.f29843i + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f29835a);
        parcel.writeInt(this.f29839e);
        Bundle bundle = new Bundle();
        bundle.putString("title", this.f29836b);
        bundle.putString("summary", this.f29837c);
        bundle.putString("logo_uri", this.f29838d);
        bundle.putString("command", this.f29840f);
        bundle.putString("extend_data", this.f29842h);
        parcel.writeBundle(bundle);
        parcel.writeTypedList(this.f29841g);
        parcel.writeTypedList(this.f29843i);
    }

    public ContactItem$ContactMenu(Parcel parcel) {
        this.f29843i = new ArrayList<>();
        this.f29835a = parcel.readInt();
        this.f29839e = parcel.readInt();
        Bundle readBundle = parcel.readBundle();
        this.f29836b = readBundle.getString("title");
        this.f29837c = readBundle.getString("summary");
        this.f29838d = readBundle.getString("logo_uri");
        this.f29840f = readBundle.getString("command");
        this.f29842h = readBundle.getString("extend_data");
        this.f29841g = parcel.createTypedArrayList(CREATOR);
        this.f29843i = parcel.createTypedArrayList(MessageItem$SpItem.CREATOR);
    }
}
