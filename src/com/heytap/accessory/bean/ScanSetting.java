package com.heytap.accessory.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import n5.C1371a;

/* loaded from: classes3.dex */
public class ScanSetting implements Parcelable {
    public static final Parcelable.Creator<ScanSetting> CREATOR = new Parcelable.Creator<ScanSetting>() { // from class: com.heytap.accessory.bean.ScanSetting.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ScanSetting createFromParcel(Parcel parcel) {
            return new ScanSetting(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ScanSetting[] newArray(int i10) {
            return new ScanSetting[i10];
        }
    };
    private static final String EXTRA_NDS_DURATION = "nds_duration";
    private static final int LIMITS_BALANCED_MAX_DURATION = 10800000;
    private static final int LIMITS_LOW_LATENCY_MAX_DURATION = 10800000;
    private static final int LIMITS_LOW_POWER_MAX_DURATION = 10800000;
    private static final int LIMITS_NDS_MAX_DURATION = 300000;
    private static final int LIMITS_TOTAL_SCAN_MAX_DURATION = 10800000;
    public static final int SUPPORT_MULTI_SCAN_SETTING_VERSION_CODE = 30003;
    private static final String VERSION_TAG = "ScanSetting_V1";
    private final int mBalancedDuration;
    private final boolean mForcedDiscovery;
    private int mFpCoreVersion;
    private final boolean mHandleByService;
    private final int mLowLatencyDuration;
    private final int mLowPowerDuration;
    private int mNsdDuration;
    private int mScanType;

    /* loaded from: classes3.dex */
    public static final class Builder {
        private int mScanType = 1;
        private int mLowLatencyDuration = 0;
        private int mBalancedDuration = 0;
        private int mLowPowerDuration = 0;
        private boolean mHandleByService = false;
        private boolean mForcedDiscovery = false;
        private int mNsdDuration = 0;

        public ScanSetting build() {
            return new ScanSetting(this.mScanType, this.mLowLatencyDuration, this.mBalancedDuration, this.mLowPowerDuration, this.mHandleByService, this.mForcedDiscovery, this.mNsdDuration);
        }

        public Builder setBalancedDuration(int i10) {
            if (i10 >= 0 && i10 <= 10800000) {
                this.mBalancedDuration = i10;
                return this;
            }
            throw new IllegalArgumentException("balancedDuration invalid (must be 0-10800000 milliseconds)");
        }

        public Builder setForcedDiscovery(boolean z10) {
            this.mForcedDiscovery = z10;
            return this;
        }

        public Builder setHandleByService(boolean z10) {
            this.mHandleByService = z10;
            return this;
        }

        public Builder setLowLatencyDuration(int i10) {
            if (i10 >= 0 && i10 <= 10800000) {
                this.mLowLatencyDuration = i10;
                return this;
            }
            throw new IllegalArgumentException("lowLatencyDuration invalid (must be 0-10800000 milliseconds)");
        }

        public Builder setLowPowerDuration(int i10) {
            if (i10 >= 0 && i10 <= 10800000) {
                this.mLowPowerDuration = i10;
                return this;
            }
            throw new IllegalArgumentException("lowPowerDuration invalid (must be 0-10800000 milliseconds)");
        }

        public Builder setNsdDuration(int i10) {
            if (i10 > 0 && i10 <= ScanSetting.LIMITS_NDS_MAX_DURATION) {
                this.mNsdDuration = i10;
                return this;
            }
            throw new IllegalArgumentException("nsdDuration invalid (must be 0-300000 milliseconds)");
        }

        public Builder setScanType(int i10) {
            if (i10 >= 1 && i10 <= 15) {
                this.mScanType = i10;
                return this;
            }
            throw new IllegalArgumentException("unknown scan type " + i10);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getBalancedDuration() {
        return this.mBalancedDuration;
    }

    public int getLowLatencyDuration() {
        return this.mLowLatencyDuration;
    }

    public int getLowPowerDuration() {
        return this.mLowPowerDuration;
    }

    public int getNsdDuration() {
        return this.mNsdDuration;
    }

    public int getScanDuration(int i10) {
        if (i10 != 1) {
            if (i10 != 4) {
                return 0;
            }
            return this.mNsdDuration;
        }
        return this.mLowPowerDuration + this.mBalancedDuration + this.mLowLatencyDuration;
    }

    public int getScanTotalDuration() {
        return Math.max(getScanDuration(4), getScanDuration(1));
    }

    public int getScanType() {
        return this.mScanType;
    }

    public boolean isForcedDiscovery() {
        return this.mForcedDiscovery;
    }

    public boolean isHandleByService() {
        return this.mHandleByService;
    }

    public void resetScanType(int i10) {
        this.mScanType = i10;
    }

    public void setFpCoreVersion(int i10) {
        this.mFpCoreVersion = i10;
    }

    public String toString() {
        return "ScanSetting{mScanType=" + this.mScanType + ", mLowLatencyDuration=" + this.mLowLatencyDuration + ", mBalancedDuration=" + this.mBalancedDuration + ", mLowPowerDuration=" + this.mLowPowerDuration + ", mHandleByService=" + this.mHandleByService + ", mForcedDiscovery=" + this.mForcedDiscovery + ", mNsdDuration=" + this.mNsdDuration + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.mScanType);
        parcel.writeInt(this.mLowLatencyDuration);
        parcel.writeInt(this.mBalancedDuration);
        parcel.writeInt(this.mLowPowerDuration);
        parcel.writeBoolean(this.mHandleByService);
        parcel.writeBoolean(this.mForcedDiscovery);
        if (this.mFpCoreVersion >= 30003) {
            parcel.writeString(VERSION_TAG);
            Bundle bundle = new Bundle();
            bundle.putInt(EXTRA_NDS_DURATION, this.mNsdDuration);
            parcel.writeBundle(bundle);
        }
    }

    private ScanSetting(int i10, int i11, int i12, int i13, boolean z10, boolean z11, int i14) {
        this.mScanType = i10;
        this.mLowLatencyDuration = i11;
        this.mBalancedDuration = i12;
        this.mLowPowerDuration = i13;
        this.mHandleByService = z10;
        this.mForcedDiscovery = z11;
        this.mNsdDuration = i14;
    }

    public ScanSetting(Parcel parcel) {
        int readInt = parcel.readInt();
        if (readInt == 0) {
            C1371a.b("for compatibility, scanType must be bigger than 0");
            readInt = 1;
        }
        this.mScanType = readInt;
        this.mLowLatencyDuration = parcel.readInt();
        this.mBalancedDuration = parcel.readInt();
        this.mLowPowerDuration = parcel.readInt();
        this.mHandleByService = parcel.readBoolean();
        this.mForcedDiscovery = parcel.readBoolean();
        int dataPosition = parcel.dataPosition();
        try {
            if (!VERSION_TAG.equals(parcel.readString())) {
                parcel.setDataPosition(dataPosition);
                return;
            }
            Bundle readBundle = parcel.readBundle(ScanSetting.class.getClassLoader());
            if (readBundle == null) {
                parcel.setDataPosition(dataPosition);
            } else {
                this.mNsdDuration = readBundle.getInt(EXTRA_NDS_DURATION, 0);
            }
        } catch (Exception unused) {
            parcel.setDataPosition(dataPosition);
        }
    }
}
