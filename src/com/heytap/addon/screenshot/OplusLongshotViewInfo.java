package com.heytap.addon.screenshot;

import android.os.Parcel;
import android.os.Parcelable;
import com.color.screenshot.ColorLongshotViewInfo;

/* loaded from: classes3.dex */
public class OplusLongshotViewInfo implements Parcelable {
    public static final Parcelable.Creator<OplusLongshotViewInfo> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public com.oplus.screenshot.OplusLongshotViewInfo f25411a;

    /* renamed from: b, reason: collision with root package name */
    public ColorLongshotViewInfo f25412b;

    /* loaded from: classes3.dex */
    public static class a implements Parcelable.Creator<OplusLongshotViewInfo> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public OplusLongshotViewInfo createFromParcel(Parcel parcel) {
            return new OplusLongshotViewInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public OplusLongshotViewInfo[] newArray(int i10) {
            return new OplusLongshotViewInfo[i10];
        }
    }

    public OplusLongshotViewInfo() {
        if (A5.a.b()) {
            this.f25411a = new com.oplus.screenshot.OplusLongshotViewInfo();
        } else {
            this.f25412b = new ColorLongshotViewInfo();
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        if (A5.a.b()) {
            return this.f25411a.describeContents();
        }
        return this.f25412b.describeContents();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        if (A5.a.b()) {
            this.f25411a.writeToParcel(parcel, i10);
        } else {
            this.f25412b.writeToParcel(parcel, i10);
        }
    }

    public OplusLongshotViewInfo(Parcel parcel) {
        if (A5.a.b()) {
            this.f25411a = new com.oplus.screenshot.OplusLongshotViewInfo(parcel);
        } else {
            this.f25412b = new ColorLongshotViewInfo(parcel);
        }
    }
}
