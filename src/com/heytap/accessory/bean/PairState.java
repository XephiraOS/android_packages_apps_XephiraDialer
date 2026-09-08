package com.heytap.accessory.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class PairState implements Parcelable {
    public static final Parcelable.Creator<PairState> CREATOR = new Parcelable.Creator<PairState>() { // from class: com.heytap.accessory.bean.PairState.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PairState createFromParcel(Parcel parcel) {
            return new PairState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PairState[] newArray(int i10) {
            return new PairState[i10];
        }
    };
    private boolean mPaired;

    public PairState() {
        this.mPaired = false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean isPaired() {
        return this.mPaired;
    }

    public void setPaired(boolean z10) {
        this.mPaired = z10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeBoolean(this.mPaired);
    }

    public PairState(Parcel parcel) {
        this.mPaired = false;
        this.mPaired = parcel.readBoolean();
    }
}
