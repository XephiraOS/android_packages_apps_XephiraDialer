package com.heytap.accessory.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class PairSetting implements Parcelable {
    public static final Parcelable.Creator<PairSetting> CREATOR = new Parcelable.Creator<PairSetting>() { // from class: com.heytap.accessory.bean.PairSetting.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PairSetting createFromParcel(Parcel parcel) {
            return new PairSetting(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PairSetting[] newArray(int i10) {
            return new PairSetting[i10];
        }
    };
    public static final int USER_ACTIVE_TRIGGER_NOFEELING_PAIR = 1;
    private int mActiveTrigger;
    private final byte mGoIntent;
    private int mKeyType;
    private final int mPort;

    /* loaded from: classes3.dex */
    public static final class Builder {
        private byte mGoIntent = -1;
        private int mPort = 0;
        private int mKeyType = 2;
        private int mActiveTrigger = 0;

        public PairSetting build() {
            return new PairSetting(this.mGoIntent, this.mPort, this.mKeyType, this.mActiveTrigger);
        }

        public Builder setActiveTrigger(int i10) {
            this.mActiveTrigger = i10;
            return this;
        }

        public Builder setGoIntent(byte b10) {
            if (b10 >= 0 && b10 <= 15) {
                this.mGoIntent = b10;
                return this;
            }
            throw new IllegalArgumentException("unknown go intent " + ((int) b10));
        }

        public Builder setKeyType(int i10) {
            this.mKeyType = i10;
            return this;
        }

        public Builder setPort(int i10) {
            this.mPort = i10;
            return this;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getActiveTrigger() {
        return this.mActiveTrigger;
    }

    public byte getGoIntent() {
        return this.mGoIntent;
    }

    public int getKeyType() {
        return this.mKeyType;
    }

    public int getPort() {
        return this.mPort;
    }

    public void setActiveTrigger(int i10) {
        this.mActiveTrigger = i10;
    }

    public void setKeyType(int i10) {
        this.mKeyType = i10;
    }

    public String toString() {
        return "PairSetting{mGoIntent=" + ((int) this.mGoIntent) + ", mPort=" + this.mPort + ", mKeyType=" + this.mKeyType + ", mActiveTrigger=" + this.mActiveTrigger + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeByte(this.mGoIntent);
        parcel.writeInt(this.mPort);
    }

    public PairSetting(Parcel parcel) {
        this.mGoIntent = parcel.readByte();
        this.mPort = parcel.readInt();
    }

    private PairSetting(byte b10, int i10, int i11, int i12) {
        this.mGoIntent = b10;
        this.mPort = i10;
        this.mKeyType = i11;
        this.mActiveTrigger = i12;
    }
}
