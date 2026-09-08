package com.heytap.accessory.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.heytap.accessory.bean.AdvertiseSetting;
import com.heytap.accessory.bean.base.IAdvertiseSetting;
import com.heytap.accessory.type.AdvAdditionDataType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import n5.C1371a;
import r5.f;

/* loaded from: classes3.dex */
public class AdvertiseSetting implements Parcelable, IAdvertiseSetting {
    public static final int ADVERTISE_MODE_BALANCED = 1;
    public static final int ADVERTISE_MODE_LOW_LATENCY = 2;
    public static final int ADVERTISE_MODE_LOW_POWER = 0;
    public static final int ADVERTISE_MODE_ULTRA_LOW_LATENCY = 3;
    public static final int ADVERTISE_TYPE_FASTDISCOVERY = 0;
    public static final int ADVERTISE_TYPE_FASTPAIR_ACCOUNT = 2;
    public static final int ADVERTISE_TYPE_FASTPAIR_DEVICEID = 4;
    public static final int ADVERTISE_TYPE_FASTPAIR_MODELID = 1;
    public static final int ADVERTISE_TYPE_SERVER_BT_DIRECT_ACCOUNT_KEY = 11;
    public static final int ADVERTISE_TYPE_SERVER_BT_DIRECT_MODEL_ID = 10;
    public static final int ADVERTISE_TYPE_SERVER_CUSTOM_MODELID = 5;
    public static final int ADVERTISE_TYPE_SERVER_MODEL_ID_CUSTOM = 3;
    public static final int ADVERTISE_TYPE_SERVER_NO_FEELING = 20;
    public static final int ADVERTISE_TYPE_UNKNOWN = -1;
    public static final Parcelable.Creator<AdvertiseSetting> CREATOR = new Parcelable.Creator<AdvertiseSetting>() { // from class: com.heytap.accessory.bean.AdvertiseSetting.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AdvertiseSetting createFromParcel(Parcel parcel) {
            return new AdvertiseSetting(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AdvertiseSetting[] newArray(int i10) {
            return new AdvertiseSetting[i10];
        }
    };
    private static final String EXTRA_IS_CANCEL_ADV = "is_cancel_adv";
    private static final String EXTRA_IS_SLOW_GATT = "extra_is_slow_gatt";
    private static final String EXTRA_KEY_TYPE = "key_type";
    private static final String EXTRA_OLD_VERSION_CONNECT_TYPE = "old_version_connect_type";
    private static final String EXTRA_RDI = "rdi";
    private static final String EXTRA_RECONNECTION_MODE = "reconnection_mode";
    private static final String EXTRA_RECONNECT_DEVICE_ID = "reconnect_device_id";
    private static final String EXTRA_SCAN_TYPE = "scan_type";
    public static final int FAST_PAIR_RECONNECTION_MODE_DIALOG_ALL = 0;
    public static final int FAST_PAIR_RECONNECTION_MODE_DIALOG_CUSTOM = 4;
    public static final int FAST_PAIR_RECONNECTION_MODE_DIALOG_RECENT = 1;
    public static final int FAST_PAIR_RECONNECTION_MODE_SILENT_ALL = 2;
    public static final int FAST_PAIR_RECONNECTION_MODE_SILENT_CUSTOM = 5;
    public static final int FAST_PAIR_RECONNECTION_MODE_SILENT_RECENT = 3;
    private static final int IS_CANCEL_ADV_BYTE = 1;
    private static final int IS_NOT_CANCEL_ADV_TYPE = 0;
    public static final int LIMITED_ADVETISING_INFINITE = -1;
    public static final int LIMITED_ADVETISING_MAX_MILLIS = 10800000;
    private static final int LIMITED_IS_CANCEL_BYTE_LENGTH = 1;
    public static final int LIMITED_MODELID_LENGTH = 3;
    public static final int LIMITED_NICKNAME_LENGTH = 9;
    private static final int LIMITED_RDI_LENGTH = 6;
    public static final int SECURE_KEY_TYPE_ACCOUNT_KEY = 8;
    public static final int SECURE_KEY_TYPE_IDENTIFY = 32;
    public static final int SECURE_KEY_TYPE_MAX = 63;
    public static final int SECURE_KEY_TYPE_OOB = 16;
    public static final int SECURE_KEY_TYPE_PRESET = 1;
    public static final int SECURE_KEY_TYPE_UKEY2_INVISIBLE = 2;
    public static final int SECURE_KEY_TYPE_UKEY2_SHOW_AUTH_CODE = 4;
    public static final int SUPPORT_CANCEL_ADV_VERSION_CODE = 30003;
    private static final String TAG = "AdvertiseSetting";
    public static final int TYPE_FAST_CANCEL = 6;
    public static final int TYPE_FAST_NETWORK_CONNECTING = 6;
    private static final String VERSION_TAG = "newAS_V1";
    private byte[] mAdditionData;
    private final int mAdvertiseMode;
    private final int mAdvertiseType;
    private final int mConnectType;
    private final int mDurationMillis;
    private int mFpCoreVersion;
    private final byte mGoIntent;
    private boolean mIsCancelAdv;
    private boolean mIsSlowGatt;
    private int mKeyType;
    private final int mMajor;
    private byte[] mModelId;
    private byte[] mNickName;
    private int mOldVersionConnectType;
    private final int mPort;
    private byte[] mRdi;
    private List<byte[]> mReconnectDeviceList;
    private int mReconnectionMode;
    private int mScanType;

    /* loaded from: classes3.dex */
    public static final class Builder {
        private boolean mIsCancelAdv;
        private byte[] mRdi;
        private final ArrayList<byte[]> mReconnectDeviceIdList = new ArrayList<>();
        private int mAdvertiseType = 1;
        private int mConnectType = 0;
        private int mOldVersionConnectType = 0;
        private int mDurationMillis = 0;
        private int mKeyType = 2;
        private byte[] mModelId = null;
        private byte[] mNickName = null;
        private byte[] mAdditionData = null;
        private byte mGoIntent = -1;
        private int mPort = 0;
        private int mMajor = 3;
        private int mAdvertiseMode = 0;
        private int mReconnectionMode = 0;
        private int mScanType = 1;
        private boolean mIsSlowGatt = false;

        private boolean isValidAdvType(int i10) {
            if (i10 == 0 || i10 == 1 || i10 == 2 || i10 == 4 || i10 == 20) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$setModelId$0(byte[] bArr) {
            if (bArr.length == 3) {
            } else {
                throw new IllegalArgumentException("model id invalid (length must be 3 byte)");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$setNickName$1(byte[] bArr) {
            if (bArr.length <= 9) {
            } else {
                throw new IllegalArgumentException("nickName invalid (length must be 0-9 byte)");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$setRdi$2(byte[] bArr) {
            if (bArr.length == 6) {
            } else {
                throw new IllegalArgumentException("rdi invalid (length must be 6 byte)");
            }
        }

        public AdvertiseSetting build() {
            byte[] bArr;
            int i10 = this.mAdvertiseType;
            if ((i10 != 0 && i10 != 1) || ((bArr = this.mModelId) != null && bArr.length == 3)) {
                return new AdvertiseSetting(this);
            }
            throw new IllegalArgumentException("model id invalid (length must be 3 byte)");
        }

        public Builder setAdditionData(byte[] bArr) {
            this.mAdditionData = bArr;
            return this;
        }

        public Builder setAdvertiseMode(int i10) {
            if (i10 >= 0 && i10 <= 3) {
                this.mAdvertiseMode = i10;
                return this;
            }
            throw new IllegalArgumentException("mode invalid, must be 0-3");
        }

        public Builder setAdvertiseType(int i10) {
            if (isValidAdvType(i10)) {
                this.mAdvertiseType = i10;
                return this;
            }
            throw new IllegalArgumentException("unknown advertise type: " + i10);
        }

        public Builder setConnectType(int i10) {
            if (i10 >= 1 && i10 <= 63) {
                this.mConnectType = i10;
                return this;
            }
            throw new IllegalArgumentException("unknown connect type " + i10);
        }

        public Builder setDurationMillis(int i10) {
            if (i10 <= 10800000) {
                this.mDurationMillis = i10;
                return this;
            }
            throw new IllegalArgumentException("timeoutMillis invalid (must be 0-10800000 milliseconds)");
        }

        public Builder setGoIntent(byte b10) {
            if (b10 >= -1 && b10 <= 15) {
                this.mGoIntent = b10;
                return this;
            }
            throw new IllegalArgumentException("unknown go intent " + ((int) b10));
        }

        public Builder setIsCancelAdv(boolean z10) {
            this.mIsCancelAdv = z10;
            return this;
        }

        public Builder setIsSlowGatt(boolean z10) {
            C1371a.k(AdvertiseSetting.TAG, "slow gatt just for test or for PC adv! Do not set slow gatt if you are not testing");
            this.mIsSlowGatt = z10;
            return this;
        }

        public Builder setKeyType(int i10) {
            if (i10 >= 1 && i10 <= 63) {
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
            Optional.ofNullable(bArr).ifPresent(new Consumer() { // from class: com.heytap.accessory.bean.a
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    AdvertiseSetting.Builder.lambda$setModelId$0((byte[]) obj);
                }
            });
            this.mModelId = bArr;
            return this;
        }

        public Builder setNickName(byte[] bArr) {
            Optional.ofNullable(bArr).ifPresent(new Consumer() { // from class: com.heytap.accessory.bean.b
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    AdvertiseSetting.Builder.lambda$setNickName$1((byte[]) obj);
                }
            });
            this.mNickName = bArr;
            return this;
        }

        public Builder setOldVersionConnectType(int i10) {
            if (i10 >= 1 && i10 <= 63) {
                this.mOldVersionConnectType = i10;
                return this;
            }
            throw new IllegalArgumentException("unknown old version connect type " + i10);
        }

        public Builder setPort(int i10) {
            this.mPort = i10;
            return this;
        }

        public Builder setRdi(byte[] bArr) {
            Optional.ofNullable(bArr).ifPresent(new Consumer() { // from class: com.heytap.accessory.bean.c
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    AdvertiseSetting.Builder.lambda$setRdi$2((byte[]) obj);
                }
            });
            this.mRdi = bArr;
            return this;
        }

        public Builder setReconnectionMode(int i10) {
            this.mReconnectionMode = i10;
            return this;
        }

        public Builder setScanType(int i10) {
            if (i10 >= 1 && i10 <= 15) {
                this.mScanType = i10;
                return this;
            }
            throw new IllegalArgumentException("unknown scan type " + i10);
        }

        public Builder setAdditionData(AdvAdditionDataType advAdditionDataType, byte[] bArr) {
            this.mAdditionData = AdditionDataInfo.setAdditionData(advAdditionDataType, bArr, this.mAdditionData);
            return this;
        }

        public Builder setReconnectionMode(int i10, byte[]... bArr) {
            this.mReconnectionMode = i10;
            this.mReconnectDeviceIdList.clear();
            this.mReconnectDeviceIdList.addAll(new ArrayList(Arrays.asList(bArr)));
            return this;
        }

        public Builder setReconnectionMode(int i10, List<byte[]> list) {
            this.mReconnectionMode = i10;
            this.mReconnectDeviceIdList.clear();
            this.mReconnectDeviceIdList.addAll(new ArrayList(list));
            return this;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public byte[] getAdditionData() {
        return this.mAdditionData;
    }

    public int getAdvertiseMode() {
        return this.mAdvertiseMode;
    }

    @Override // com.heytap.accessory.bean.base.IAdvertiseSetting
    public int getAdvertiseType() {
        return this.mAdvertiseType;
    }

    @Override // com.heytap.accessory.bean.base.IAdvertiseSetting
    public int getConnectType() {
        return this.mConnectType;
    }

    public int getDurationMillis() {
        return this.mDurationMillis;
    }

    public byte getGoIntent() {
        return this.mGoIntent;
    }

    public boolean getIsCancelAdv() {
        return this.mIsCancelAdv;
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

    public byte[] getNickName() {
        return this.mNickName;
    }

    public int getOldVersionConnectType() {
        return this.mOldVersionConnectType;
    }

    public int getPort() {
        return this.mPort;
    }

    public byte[] getRdi() {
        return this.mRdi;
    }

    public List<byte[]> getReconnectDeviceList() {
        return this.mReconnectDeviceList;
    }

    public int getReconnectionMode() {
        return this.mReconnectionMode;
    }

    @Override // com.heytap.accessory.bean.base.IAdvertiseSetting
    public int getScanType() {
        return this.mScanType;
    }

    public boolean isSlowGatt() {
        return this.mIsSlowGatt;
    }

    public void resetRdi(byte[] bArr) {
        this.mRdi = bArr;
    }

    public void setFpCoreVersion(int i10) {
        this.mFpCoreVersion = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.mAdvertiseType);
        parcel.writeInt(this.mConnectType);
        parcel.writeInt(this.mDurationMillis);
        parcel.writeInt(this.mKeyType);
        parcel.writeByteArray(this.mModelId);
        parcel.writeByteArray(this.mNickName);
        parcel.writeByteArray(this.mAdditionData);
        parcel.writeByte(this.mGoIntent);
        parcel.writeInt(this.mPort);
        parcel.writeInt(this.mMajor);
        parcel.writeInt(this.mAdvertiseMode);
        if (this.mFpCoreVersion >= 30003) {
            parcel.writeString(VERSION_TAG);
            Bundle bundle = new Bundle();
            bundle.putBoolean(EXTRA_IS_CANCEL_ADV, this.mIsCancelAdv);
            bundle.putByteArray(EXTRA_RDI, this.mRdi);
            bundle.putInt(EXTRA_RECONNECTION_MODE, this.mReconnectionMode);
            bundle.putInt(EXTRA_SCAN_TYPE, this.mScanType);
            bundle.putInt(EXTRA_OLD_VERSION_CONNECT_TYPE, this.mOldVersionConnectType);
            bundle.putStringArrayList(EXTRA_RECONNECT_DEVICE_ID, f.j(this.mReconnectDeviceList));
            bundle.putBoolean(EXTRA_IS_SLOW_GATT, this.mIsSlowGatt);
            parcel.writeBundle(bundle);
        }
    }

    private AdvertiseSetting(Builder builder) {
        this.mScanType = 1;
        this.mIsSlowGatt = false;
        this.mAdvertiseType = builder.mAdvertiseType;
        this.mConnectType = builder.mConnectType;
        this.mDurationMillis = builder.mDurationMillis;
        this.mKeyType = builder.mKeyType;
        this.mModelId = builder.mModelId;
        this.mNickName = builder.mNickName;
        this.mAdditionData = builder.mAdditionData;
        this.mGoIntent = builder.mGoIntent;
        this.mPort = builder.mPort;
        this.mMajor = builder.mMajor;
        this.mAdvertiseMode = builder.mAdvertiseMode;
        this.mIsCancelAdv = builder.mIsCancelAdv;
        this.mRdi = builder.mRdi;
        this.mReconnectionMode = builder.mReconnectionMode;
        this.mScanType = builder.mScanType;
        this.mOldVersionConnectType = builder.mOldVersionConnectType;
        this.mReconnectDeviceList = builder.mReconnectDeviceIdList;
        this.mIsSlowGatt = builder.mIsSlowGatt;
    }

    public byte[] getAdditionData(AdvAdditionDataType advAdditionDataType) {
        return AdditionDataInfo.getAdditionData(advAdditionDataType, this.mAdditionData);
    }

    public AdvertiseSetting(Parcel parcel) {
        this.mScanType = 1;
        this.mIsSlowGatt = false;
        this.mAdvertiseType = parcel.readInt();
        this.mConnectType = parcel.readInt();
        this.mDurationMillis = parcel.readInt();
        this.mKeyType = parcel.readInt();
        this.mModelId = parcel.createByteArray();
        this.mNickName = parcel.createByteArray();
        this.mAdditionData = parcel.createByteArray();
        this.mGoIntent = parcel.readByte();
        this.mPort = parcel.readInt();
        this.mMajor = parcel.readInt();
        this.mAdvertiseMode = parcel.readInt();
        int dataPosition = parcel.dataPosition();
        try {
            if (!VERSION_TAG.equals(parcel.readString())) {
                parcel.setDataPosition(dataPosition);
                return;
            }
            Bundle readBundle = parcel.readBundle(AdvertiseSetting.class.getClassLoader());
            if (readBundle == null) {
                parcel.setDataPosition(dataPosition);
                return;
            }
            this.mIsCancelAdv = readBundle.getBoolean(EXTRA_IS_CANCEL_ADV, false);
            this.mRdi = readBundle.getByteArray(EXTRA_RDI);
            this.mReconnectionMode = readBundle.getInt(EXTRA_RECONNECTION_MODE);
            this.mScanType = readBundle.getInt(EXTRA_SCAN_TYPE, 1);
            this.mOldVersionConnectType = readBundle.getInt(EXTRA_OLD_VERSION_CONNECT_TYPE);
            this.mReconnectDeviceList = f.i(readBundle.getStringArrayList(EXTRA_RECONNECT_DEVICE_ID));
            this.mIsSlowGatt = readBundle.getBoolean(EXTRA_IS_SLOW_GATT, false);
        } catch (Exception unused) {
            parcel.setDataPosition(dataPosition);
        }
    }
}
