package com.ted.number.entrys;

import D2.g;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class ContactItem$ContactMenu implements Parcelable {
    public static final Parcelable.Creator<ContactItem$ContactMenu> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final int f29605a;

    /* renamed from: b, reason: collision with root package name */
    public final String f29606b;

    /* renamed from: c, reason: collision with root package name */
    public final String f29607c;

    /* renamed from: d, reason: collision with root package name */
    public final String f29608d;

    /* renamed from: e, reason: collision with root package name */
    public final int f29609e;

    /* renamed from: f, reason: collision with root package name */
    public final String f29610f;

    /* renamed from: g, reason: collision with root package name */
    public ArrayList<ContactItem$ContactMenu> f29611g;

    /* renamed from: h, reason: collision with root package name */
    public String f29612h;

    /* renamed from: i, reason: collision with root package name */
    public ArrayList<MessageItem$SpItem> f29613i;

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
        return "ContactMenu{mLevel=" + this.f29605a + ", mTitle='" + g.l(this.f29606b) + "', mSummary='" + g.l(this.f29607c) + "', mLogoUrl='" + this.f29608d + "', mCmdType=" + this.f29609e + ", mCommand='" + this.f29610f + "', mSubMenuList=" + this.f29611g + ", mExtendData='" + this.f29612h + "', mSpList=" + this.f29613i + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f29605a);
        parcel.writeInt(this.f29609e);
        Bundle bundle = new Bundle();
        bundle.putString("title", this.f29606b);
        bundle.putString("summary", this.f29607c);
        bundle.putString("logo_uri", this.f29608d);
        bundle.putString("command", this.f29610f);
        bundle.putString("extend_data", this.f29612h);
        parcel.writeBundle(bundle);
        parcel.writeTypedList(this.f29611g);
        parcel.writeTypedList(this.f29613i);
    }

    public ContactItem$ContactMenu(Parcel parcel) {
        this.f29613i = new ArrayList<>();
        this.f29605a = parcel.readInt();
        this.f29609e = parcel.readInt();
        Bundle readBundle = parcel.readBundle();
        this.f29606b = readBundle.getString("title");
        this.f29607c = readBundle.getString("summary");
        this.f29608d = readBundle.getString("logo_uri");
        this.f29610f = readBundle.getString("command");
        this.f29612h = readBundle.getString("extend_data");
        this.f29611g = parcel.createTypedArrayList(CREATOR);
        this.f29613i = parcel.createTypedArrayList(MessageItem$SpItem.CREATOR);
    }
}
