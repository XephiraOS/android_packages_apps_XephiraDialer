package com.ted.number.entrys;

import D2.g;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes4.dex */
public class ContactItem$DealItem implements Parcelable {
    public static final Parcelable.Creator<ContactItem$DealItem> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final String f29614a;

    /* renamed from: b, reason: collision with root package name */
    public final String f29615b;

    /* renamed from: c, reason: collision with root package name */
    public final String f29616c;

    /* renamed from: d, reason: collision with root package name */
    public final float f29617d;

    /* renamed from: e, reason: collision with root package name */
    public final float f29618e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f29619f;

    /* renamed from: g, reason: collision with root package name */
    public final String f29620g;

    /* renamed from: h, reason: collision with root package name */
    public int f29621h;

    /* renamed from: i, reason: collision with root package name */
    public int f29622i;

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
        this.f29614a = readBundle.getString("deal_name");
        this.f29615b = readBundle.getString("deal_image");
        this.f29616c = readBundle.getString("description");
        this.f29617d = readBundle.getFloat("orig_price");
        this.f29618e = readBundle.getFloat("curr_price");
        this.f29619f = readBundle.getBoolean("reservation");
        this.f29620g = readBundle.getString("deal_url");
        this.f29621h = readBundle.getInt("deal_start");
        this.f29622i = readBundle.getInt("deal_end");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "DealItem{mDealName='" + g.l(this.f29614a) + "', mDealImage='" + this.f29615b + "', mDescription='" + g.l(this.f29616c) + "', mOrigPrice=" + this.f29617d + ", mCurrPrice=" + this.f29618e + ", mReservation=" + this.f29619f + ", mUrl='" + g.l(this.f29620g) + "', mStart=" + this.f29621h + ", mEnd=" + this.f29622i + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        Bundle bundle = new Bundle();
        bundle.putString("deal_name", this.f29614a);
        bundle.putString("deal_image", this.f29615b);
        bundle.putString("description", this.f29616c);
        bundle.putFloat("orig_price", this.f29617d);
        bundle.putFloat("curr_price", this.f29618e);
        bundle.putBoolean("reservation", this.f29619f);
        bundle.putString("deal_url", this.f29620g);
        bundle.putInt("deal_start", this.f29621h);
        bundle.putInt("deal_end", this.f29622i);
        parcel.writeBundle(bundle);
    }
}
