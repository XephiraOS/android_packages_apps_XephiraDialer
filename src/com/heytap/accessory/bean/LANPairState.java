package com.heytap.accessory.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class LANPairState implements Parcelable {
    public static final Parcelable.Creator<LANPairState> CREATOR = new Parcelable.Creator<LANPairState>() { // from class: com.heytap.accessory.bean.LANPairState.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LANPairState createFromParcel(Parcel parcel) {
            return new LANPairState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LANPairState[] newArray(int i10) {
            return new LANPairState[i10];
        }
    };
    private String mIp;
    private PairState mPairState;
    private List<String> mPairedBssidList;

    public LANPairState() {
        this.mPairState = new PairState();
        this.mPairedBssidList = new ArrayList();
    }

    public void addPairedBssid(String str) {
        if (!this.mPairedBssidList.contains(str)) {
            this.mPairedBssidList.add(str);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getIp() {
        return this.mIp;
    }

    public List<String> getPairedBssidList() {
        return this.mPairedBssidList;
    }

    public boolean isPaired() {
        return this.mPairState.isPaired();
    }

    public void setIp(String str) {
        this.mIp = str;
    }

    public void setPaired(boolean z10) {
        this.mPairState.setPaired(z10);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.mPairState, i10);
        parcel.writeString(this.mIp);
    }

    public LANPairState(Parcel parcel) {
        this.mPairState = (PairState) parcel.readParcelable(PairState.class.getClassLoader());
        this.mIp = parcel.readString();
    }
}
