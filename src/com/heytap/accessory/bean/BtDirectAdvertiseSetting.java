package com.heytap.accessory.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.heytap.accessory.bean.base.IAdvertiseSetting;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class BtDirectAdvertiseSetting implements IAdvertiseSetting, Parcelable {
    public static final byte FLAG_BT_ADDRESS = 64;
    public static final byte FLAG_DEVICE_BATTERY = 16;
    public static final byte FLAG_DEVICE_STATE = 32;
    public static final byte FLAG_PAIRING_STATE = Byte.MIN_VALUE;
    private static final String KEY_ADV_ADVERTISE_MODE = "key_adv_advertise_mode";
    private static final String KEY_ADV_ADVERTISE_TYPE = "key_adv_advertise_type";
    private static final String KEY_ADV_BT_ADDRESS = "key_adv_bt_address";
    private static final String KEY_ADV_DEVICE_BATTERY = "key_adv_device_battery";
    private static final String KEY_ADV_DEVICE_STATE = "key_adv_device_state";
    private static final String KEY_ADV_DURATION_MILLIS = "key_adv_duration_millis";
    private static final String KEY_ADV_FEATURE = "key_adv_feature";
    private static final String KEY_ADV_IS_CANCEL_ADV = "key_adv_is_cancel_adv";
    private static final String KEY_ADV_KEY_TYPE = "key_adv_key_type";
    private static final String KEY_ADV_MAJOR = "key_adv_major";
    private static final String KEY_ADV_MODEL_ID = "key_adv_model_id";
    private static final String KEY_ADV_PAIR_STATE = "key_adv_pair_state";
    public static final int LENGTH_BATTERY_DESC = 1;
    public static final int LENGTH_BT_ADDRESS = 6;
    public static final int LENGTH_DEVICE_STATE = 1;
    public static final int LENGTH_FEATURE = 2;
    public static final int LENGTH_PAIRING_STATE = 1;
    public static final int OFFSET_BATTERY_LENGTH = 4;
    private final int mAdvertiseMode;
    private final int mAdvertiseType;
    private final byte[] mBtAddress;
    private final byte[] mDeviceBattery;
    private final byte mDeviceState;
    private final int mDurationMillis;
    private final byte[] mFeature;
    private final boolean mIsCancelAdv;
    private final int mKeyType;
    private final int mMajor;
    private final byte[] mModelId;
    private final byte mPairState;
    public static final Parcelable.Creator<BtDirectAdvertiseSetting> CREATOR = new Parcelable.Creator<BtDirectAdvertiseSetting>() { // from class: com.heytap.accessory.bean.BtDirectAdvertiseSetting.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BtDirectAdvertiseSetting createFromParcel(Parcel parcel) {
            return new BtDirectAdvertiseSetting(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BtDirectAdvertiseSetting[] newArray(int i10) {
            return new BtDirectAdvertiseSetting[i10];
        }
    };
    private static final String TAG = BtDirectAdvertiseSetting.class.getSimpleName();

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAdvertiseMode() {
        return this.mAdvertiseMode;
    }

    @Override // com.heytap.accessory.bean.base.IAdvertiseSetting
    public int getAdvertiseType() {
        return this.mAdvertiseType;
    }

    public byte[] getBtAddress() {
        return this.mBtAddress;
    }

    public Bundle getBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_ADV_ADVERTISE_TYPE, this.mAdvertiseType);
        bundle.putInt(KEY_ADV_DURATION_MILLIS, this.mDurationMillis);
        bundle.putInt(KEY_ADV_KEY_TYPE, this.mKeyType);
        bundle.putInt(KEY_ADV_MAJOR, this.mMajor);
        bundle.putInt(KEY_ADV_ADVERTISE_MODE, this.mAdvertiseMode);
        bundle.putByteArray(KEY_ADV_MODEL_ID, this.mModelId);
        bundle.putBoolean(KEY_ADV_IS_CANCEL_ADV, this.mIsCancelAdv);
        bundle.putByteArray(KEY_ADV_FEATURE, this.mFeature);
        bundle.putByte(KEY_ADV_PAIR_STATE, this.mPairState);
        bundle.putByteArray(KEY_ADV_BT_ADDRESS, this.mBtAddress);
        bundle.putByte(KEY_ADV_DEVICE_STATE, this.mDeviceState);
        bundle.putByteArray(KEY_ADV_DEVICE_BATTERY, this.mDeviceBattery);
        return bundle;
    }

    @Override // com.heytap.accessory.bean.base.IAdvertiseSetting
    public int getConnectType() {
        return 1;
    }

    public byte[] getDeviceBattery() {
        return this.mDeviceBattery;
    }

    public byte getDeviceState() {
        return this.mDeviceState;
    }

    public int getDurationMillis() {
        return this.mDurationMillis;
    }

    public byte[] getFeature() {
        return this.mFeature;
    }

    @Override // com.heytap.accessory.bean.base.IAdvertiseSetting
    public int getKeyType() {
        return this.mKeyType;
    }

    public int getMajor() {
        return this.mMajor;
    }

    @Override // com.heytap.accessory.bean.base.IAdvertiseSetting
    public byte[] getModelId() {
        return this.mModelId;
    }

    public byte getPairState() {
        return this.mPairState;
    }

    @Override // com.heytap.accessory.bean.base.IAdvertiseSetting
    public int getScanType() {
        return 1;
    }

    public boolean isCancelAdv() {
        return this.mIsCancelAdv;
    }

    public String toString() {
        return "BtDirectAdvertiseSetting{mAdvertiseType=" + this.mAdvertiseType + ", mDurationMillis=" + this.mDurationMillis + ", mKeyType=" + this.mKeyType + ", mMajor=" + this.mMajor + ", mAdvertiseMode=" + this.mAdvertiseMode + ", mModelId=" + Arrays.toString(this.mModelId) + ", mIsCancelAdv=" + this.mIsCancelAdv + ", mFeature=" + Arrays.toString(this.mFeature) + ", mPairState=" + ((int) this.mPairState) + ", mBtAddress=" + Arrays.toString(this.mBtAddress) + ", mDeviceState=" + ((int) this.mDeviceState) + ", mDeviceBattery=" + Arrays.toString(this.mDeviceBattery) + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeBundle(getBundle());
    }

    private BtDirectAdvertiseSetting(Builder builder) {
        this.mAdvertiseType = builder.mAdvertiseType;
        this.mDurationMillis = builder.mDurationMillis;
        this.mKeyType = builder.mKeyType;
        this.mModelId = builder.mModelId;
        this.mMajor = builder.mMajor;
        this.mAdvertiseMode = builder.mAdvertiseMode;
        this.mIsCancelAdv = builder.mIsCancelAdv;
        this.mFeature = builder.mFeature;
        this.mPairState = builder.mPairState;
        this.mBtAddress = builder.mBtAddress;
        this.mDeviceState = builder.mDeviceState;
        this.mDeviceBattery = builder.mDeviceBattery;
    }

    /* loaded from: classes3.dex */
    public static final class Builder {
        private int mAdvertiseMode;
        private int mAdvertiseType;
        private byte[] mBtAddress;
        private Bundle mBundle;
        private byte[] mDeviceBattery;
        private byte mDeviceState;
        private int mDurationMillis;
        private byte[] mFeature;
        private boolean mIsCancelAdv;
        private int mKeyType;
        private int mMajor;
        private byte[] mModelId;
        private byte mPairState;

        public Builder() {
            this.mAdvertiseType = 1;
            this.mDurationMillis = 0;
            this.mKeyType = 2;
            this.mMajor = 3;
            this.mModelId = null;
            this.mAdvertiseMode = 0;
            this.mFeature = new byte[2];
        }

        public BtDirectAdvertiseSetting build() {
            byte[] bArr;
            Bundle bundle = this.mBundle;
            if (bundle != null) {
                this.mAdvertiseType = bundle.getInt(BtDirectAdvertiseSetting.KEY_ADV_ADVERTISE_TYPE);
                this.mDurationMillis = this.mBundle.getInt(BtDirectAdvertiseSetting.KEY_ADV_DURATION_MILLIS);
                this.mKeyType = this.mBundle.getInt(BtDirectAdvertiseSetting.KEY_ADV_KEY_TYPE);
                this.mMajor = this.mBundle.getInt(BtDirectAdvertiseSetting.KEY_ADV_MAJOR);
                this.mAdvertiseMode = this.mBundle.getInt(BtDirectAdvertiseSetting.KEY_ADV_ADVERTISE_MODE);
                this.mModelId = this.mBundle.getByteArray(BtDirectAdvertiseSetting.KEY_ADV_MODEL_ID);
                this.mIsCancelAdv = this.mBundle.getBoolean(BtDirectAdvertiseSetting.KEY_ADV_IS_CANCEL_ADV);
                this.mFeature = this.mBundle.getByteArray(BtDirectAdvertiseSetting.KEY_ADV_FEATURE);
                this.mPairState = this.mBundle.getByte(BtDirectAdvertiseSetting.KEY_ADV_PAIR_STATE);
                this.mBtAddress = this.mBundle.getByteArray(BtDirectAdvertiseSetting.KEY_ADV_BT_ADDRESS);
                this.mDeviceState = this.mBundle.getByte(BtDirectAdvertiseSetting.KEY_ADV_DEVICE_STATE);
                this.mDeviceBattery = this.mBundle.getByteArray(BtDirectAdvertiseSetting.KEY_ADV_DEVICE_BATTERY);
            }
            if (this.mAdvertiseType == 10 && ((bArr = this.mModelId) == null || bArr.length != 3)) {
                throw new IllegalArgumentException("model id invalid (length must be 3 byte)");
            }
            return new BtDirectAdvertiseSetting(this);
        }

        public Builder setAdvertiseMode(int i10) {
            if (i10 >= 0 && i10 <= 3) {
                this.mAdvertiseMode = i10;
                return this;
            }
            throw new IllegalArgumentException("mode invalid, must be 0-3");
        }

        public Builder setAdvertiseType(int i10) {
            this.mAdvertiseType = i10;
            return this;
        }

        public Builder setBtAddress(byte[] bArr) {
            this.mBtAddress = bArr;
            byte[] bArr2 = this.mFeature;
            bArr2[0] = (byte) (bArr2[0] | BtDirectAdvertiseSetting.FLAG_BT_ADDRESS);
            return this;
        }

        public Builder setDeviceBattery(byte[] bArr) {
            this.mDeviceBattery = bArr;
            byte[] bArr2 = this.mFeature;
            bArr2[0] = (byte) (bArr2[0] | BtDirectAdvertiseSetting.FLAG_DEVICE_BATTERY);
            return this;
        }

        public Builder setDeviceState(byte b10) {
            this.mDeviceState = b10;
            byte[] bArr = this.mFeature;
            bArr[0] = (byte) (bArr[0] | BtDirectAdvertiseSetting.FLAG_DEVICE_STATE);
            return this;
        }

        public Builder setDurationMillis(int i10) {
            if (i10 >= 0 && i10 <= 10800000) {
                this.mDurationMillis = i10;
                return this;
            }
            throw new IllegalArgumentException("timeoutMillis invalid (must be 0-10800000 milliseconds)");
        }

        public Builder setIsCancelAdv(boolean z10) {
            this.mIsCancelAdv = z10;
            return this;
        }

        public Builder setKeyType(int i10) {
            if (i10 >= 1 && i10 <= 2) {
                this.mKeyType = i10;
                return this;
            }
            throw new IllegalArgumentException("keyType invalid");
        }

        public Builder setMajor(int i10) {
            if (i10 >= 1 && i10 <= 10) {
                this.mMajor = i10;
                return this;
            }
            throw new IllegalArgumentException("major invalid, must be 1-10");
        }

        public Builder setModelId(byte[] bArr) {
            if (bArr != null && bArr.length == 3) {
                this.mModelId = bArr;
                return this;
            }
            throw new IllegalArgumentException("model id invalid (length must be 3 byte)");
        }

        public Builder setPairState(byte b10) {
            this.mPairState = b10;
            byte[] bArr = this.mFeature;
            bArr[0] = (byte) (bArr[0] | BtDirectAdvertiseSetting.FLAG_PAIRING_STATE);
            return this;
        }

        public Builder(Bundle bundle) {
            this.mAdvertiseType = 1;
            this.mDurationMillis = 0;
            this.mKeyType = 2;
            this.mMajor = 3;
            this.mModelId = null;
            this.mAdvertiseMode = 0;
            this.mFeature = new byte[2];
            this.mBundle = bundle;
        }
    }

    private BtDirectAdvertiseSetting(Bundle bundle) {
        this.mAdvertiseType = bundle.getInt(KEY_ADV_ADVERTISE_TYPE);
        this.mDurationMillis = bundle.getInt(KEY_ADV_DURATION_MILLIS);
        this.mKeyType = bundle.getInt(KEY_ADV_KEY_TYPE);
        this.mMajor = bundle.getInt(KEY_ADV_MAJOR);
        this.mAdvertiseMode = bundle.getInt(KEY_ADV_ADVERTISE_MODE);
        this.mModelId = bundle.getByteArray(KEY_ADV_MODEL_ID);
        this.mIsCancelAdv = bundle.getBoolean(KEY_ADV_IS_CANCEL_ADV);
        this.mFeature = bundle.getByteArray(KEY_ADV_FEATURE);
        this.mPairState = bundle.getByte(KEY_ADV_PAIR_STATE);
        this.mBtAddress = bundle.getByteArray(KEY_ADV_BT_ADDRESS);
        this.mDeviceState = bundle.getByte(KEY_ADV_DEVICE_STATE);
        this.mDeviceBattery = bundle.getByteArray(KEY_ADV_DEVICE_BATTERY);
    }

    public BtDirectAdvertiseSetting(Parcel parcel) {
        this(parcel.readBundle());
    }
}
