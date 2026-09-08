package com.heytap.accessory.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public final class BlePairState implements Parcelable {
    public static final Parcelable.Creator<BlePairState> CREATOR = new Parcelable.Creator<BlePairState>() { // from class: com.heytap.accessory.bean.BlePairState.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BlePairState createFromParcel(Parcel parcel) {
            return new BlePairState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BlePairState[] newArray(int i10) {
            return new BlePairState[i10];
        }
    };
    private String mMac;
    private PairState mPairState;

    public BlePairState() {
        this.mPairState = new PairState();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getMac() {
        return this.mMac;
    }

    public boolean isPaired() {
        PairState pairState = this.mPairState;
        if (pairState != null) {
            return pairState.isPaired();
        }
        return false;
    }

    public void setMac(String str) {
        this.mMac = str;
    }

    public void setPaired(boolean z10) {
        this.mPairState.setPaired(z10);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.mPairState, i10);
        parcel.writeString(this.mMac);
    }

    public BlePairState(Parcel parcel) {
        this.mPairState = (PairState) parcel.readParcelable(PairState.class.getClassLoader());
        this.mMac = parcel.readString();
    }
}
