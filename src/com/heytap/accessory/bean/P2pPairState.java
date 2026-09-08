package com.heytap.accessory.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class P2pPairState implements Parcelable {
    public static final Parcelable.Creator<P2pPairState> CREATOR = new Parcelable.Creator<P2pPairState>() { // from class: com.heytap.accessory.bean.P2pPairState.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public P2pPairState createFromParcel(Parcel parcel) {
            return new P2pPairState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public P2pPairState[] newArray(int i10) {
            return new P2pPairState[i10];
        }
    };
    private String mIp;
    private String mP2pMac;
    private PairState mPairState;

    public P2pPairState() {
        this.mPairState = new PairState();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getIp() {
        return this.mIp;
    }

    public String getP2pMac() {
        return this.mP2pMac;
    }

    public boolean isPaired() {
        return this.mPairState.isPaired();
    }

    public void setIp(String str) {
        this.mIp = str;
    }

    public void setP2pMac(String str) {
        this.mP2pMac = str;
    }

    public void setPaired(boolean z10) {
        this.mPairState.setPaired(z10);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.mPairState, i10);
        parcel.writeString(this.mIp);
        parcel.writeString(this.mP2pMac);
    }

    public P2pPairState(Parcel parcel) {
        this.mPairState = (PairState) parcel.readParcelable(PairState.class.getClassLoader());
        this.mIp = parcel.readString();
        this.mP2pMac = parcel.readString();
    }
}
