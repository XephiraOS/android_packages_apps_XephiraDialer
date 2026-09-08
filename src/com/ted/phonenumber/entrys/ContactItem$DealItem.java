package com.ted.phonenumber.entrys;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes4.dex */
public class ContactItem$DealItem implements Parcelable {
    public static final Parcelable.Creator<ContactItem$DealItem> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final String f29844a;

    /* renamed from: b, reason: collision with root package name */
    public final String f29845b;

    /* renamed from: c, reason: collision with root package name */
    public final String f29846c;

    /* renamed from: d, reason: collision with root package name */
    public final float f29847d;

    /* renamed from: e, reason: collision with root package name */
    public final float f29848e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f29849f;

    /* renamed from: g, reason: collision with root package name */
    public final String f29850g;

    /* renamed from: h, reason: collision with root package name */
    public int f29851h;

    /* renamed from: i, reason: collision with root package name */
    public int f29852i;

    /* loaded from: classes4.dex */
    public class a implements Parcelable.Creator<ContactItem$DealItem> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ContactItem$DealItem createFromParcel(Parcel parcel) {
            return new ContactItem$DealItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ContactItem$DealItem[] newArray(int i10) {
            return new ContactItem$DealItem[i10];
        }
    }

    public ContactItem$DealItem(Parcel parcel) {
        Bundle readBundle = parcel.readBundle();
        this.f29844a = readBundle.getString("deal_name");
        this.f29845b = readBundle.getString("deal_image");
        this.f29846c = readBundle.getString("description");
        this.f29847d = readBundle.getFloat("orig_price");
        this.f29848e = readBundle.getFloat("curr_price");
        this.f29849f = readBundle.getBoolean("reservation");
        this.f29850g = readBundle.getString("deal_url");
        this.f29851h = readBundle.getInt("deal_start");
        this.f29852i = readBundle.getInt("deal_end");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "DealItem{mDealName='" + this.f29844a + "', mDealImage='" + this.f29845b + "', mDescription='" + this.f29846c + "', mOrigPrice=" + this.f29847d + ", mCurrPrice=" + this.f29848e + ", mReservation=" + this.f29849f + ", mUrl='" + this.f29850g + "', mStart=" + this.f29851h + ", mEnd=" + this.f29852i + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        Bundle bundle = new Bundle();
        bundle.putString("deal_name", this.f29844a);
        bundle.putString("deal_image", this.f29845b);
        bundle.putString("description", this.f29846c);
        bundle.putFloat("orig_price", this.f29847d);
        bundle.putFloat("curr_price", this.f29848e);
        bundle.putBoolean("reservation", this.f29849f);
        bundle.putString("deal_url", this.f29850g);
        bundle.putInt("deal_start", this.f29851h);
        bundle.putInt("deal_end", this.f29852i);
        parcel.writeBundle(bundle);
    }
}
