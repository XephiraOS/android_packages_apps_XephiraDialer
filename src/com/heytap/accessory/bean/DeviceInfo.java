package com.heytap.accessory.bean;

import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.heytap.accessory.Initializer;
import com.heytap.accessory.constant.FastPairConstants;
import com.heytap.accessory.type.AdvAdditionDataType;
import java.util.List;
import n5.C1371a;
import r5.f;

/* loaded from: classes3.dex */
public class DeviceInfo implements Parcelable {
    private static final String COMPATIBLE_KEY_ADV_TYPE = "adv_type";
    private static final String COMPATIBLE_KEY_BT_INSECURE_STATE = "bt_insecure_state";
    private static final String COMPATIBLE_KEY_KEY_TYPE = "key_type";
    private static final String COMPATIBLE_KEY_KEY_TYPE_FINAL_USED = "final_used_key_type";
    private static final String COMPATIBLE_KEY_LAN_PAIR_STATE = "lan_pair_state";
    private static final String COMPATIBLE_KEY_SCAN_TYPE = "scan_type";
    public static final Parcelable.Creator<DeviceInfo> CREATOR = new Parcelable.Creator<DeviceInfo>() { // from class: com.heytap.accessory.bean.DeviceInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DeviceInfo createFromParcel(Parcel parcel) {
            return new DeviceInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DeviceInfo[] newArray(int i10) {
            return new DeviceInfo[i10];
        }
    };
    private static final String DEVICE_INFO_RFOMM_PORT = "device_info_rfomm_port";
    public static final int DEVICE_ROLE_BOTH = 3;
    public static final int DEVICE_ROLE_CENTRAL = 1;
    public static final int DEVICE_ROLE_PERIPHERAL = 2;
    public static final int DEVICE_ROLE_UNKNOWN = 0;
    public static final int PAIR_NONE = 0;
    public static final int PAIR_PAIRED = 2;
    public static final int PAIR_PAIRING = 1;
    private static final String TAG = "DeviceInfo";
    private static final String USER_ACTIVE_TRIGGER_NOFEELING = "active_trigger";
    private static final String VERSION_TAG = "DeviceInfo_V1";
    private int mActiveTrigger;
    private byte[] mAdditionData;
    private int mAdvertiseType;
    private byte[] mAlias;
    private BluetoothDevice mBluetoothDevice;
    private String mBluetoothName;
    private int mConnectType;
    private byte[] mDeviceId;
    private int mDeviceRole;
    private int mEvent;
    private int mFinalKeyType;
    private int mLocalSupportKeyType;
    private int mMajor;
    private int mMinor;
    private byte[] mModelId;
    private String mName;
    private byte[] mNickName;
    private int mPairState;
    private int mRfcommPort;
    private int mScanType;
    private int mSignalStrength;
    private String mTag;
    private BlePairState mBlePairState = new BlePairState();
    private BtPairState mBtPairState = new BtPairState();
    private P2pPairState mP2pPairState = new P2pPairState();
    private LANPairState mLANPairState = new LANPairState();
    private BtInsecurePairState mBtInsecurePairState = new BtInsecurePairState();
    private int mOuterSdkVersion = -1;

    public DeviceInfo() {
    }

    public void addLANPairedBssid(String str) {
        this.mLANPairState.addPairedBssid(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getActiveTrigger() {
        return this.mActiveTrigger;
    }

    public byte[] getAdditionData() {
        return this.mAdditionData;
    }

    public int getAdvertiseType() {
        return this.mAdvertiseType;
    }

    public byte[] getAlias() {
        return this.mAlias;
    }

    public String getBleMac() {
        return this.mBlePairState.getMac();
    }

    public BluetoothDevice getBluetoothDevice() {
        return this.mBluetoothDevice;
    }

    public String getBluetoothName() {
        return this.mBluetoothName;
    }

    public String getBtInsecureMac() {
        return this.mBtInsecurePairState.getMac();
    }

    public String getBtMac() {
        return this.mBtPairState.getMac();
    }

    public int getConnectType() {
        return this.mConnectType;
    }

    public byte[] getDeviceId() {
        return this.mDeviceId;
    }

    public int getDeviceRole() {
        return this.mDeviceRole;
    }

    public int getEvent() {
        return this.mEvent;
    }

    public int getFinalKeyType() {
        return this.mFinalKeyType;
    }

    public String getLANIp() {
        return this.mLANPairState.getIp();
    }

    public List<String> getLANPairedBssids() {
        return this.mLANPairState.getPairedBssidList();
    }

    public int getLocalSupportKeyType() {
        return this.mLocalSupportKeyType;
    }

    public int getMajor() {
        return this.mMajor;
    }

    public int getMinor() {
        return this.mMinor;
    }

    public byte[] getModelId() {
        return this.mModelId;
    }

    public String getName() {
        return this.mName;
    }

    public byte[] getNickName() {
        return this.mNickName;
    }

    public int getOuterSdkVersion() {
        return this.mOuterSdkVersion;
    }

    public String getP2pIp() {
        return this.mP2pPairState.getIp();
    }

    public String getP2pMac() {
        return this.mP2pPairState.getP2pMac();
    }

    public int getPairState() {
        return this.mPairState;
    }

    public int getPairedType() {
        int i10;
        int i11;
        int i12;
        int i13 = 0;
        if (this.mBlePairState.isPaired()) {
            i10 = 4;
        } else {
            i10 = 0;
        }
        int i14 = i10 + (this.mBtPairState.isPaired() ? 1 : 0);
        if (this.mP2pPairState.isPaired()) {
            i11 = 2;
        } else {
            i11 = 0;
        }
        int i15 = i14 + i11;
        if (this.mLANPairState.isPaired()) {
            i12 = 16;
        } else {
            i12 = 0;
        }
        int i16 = i15 + i12;
        if (this.mBtInsecurePairState.isPaired()) {
            i13 = 32;
        }
        return i16 + i13;
    }

    public int getRfcommPort() {
        return this.mRfcommPort;
    }

    public int getScanType() {
        return this.mScanType;
    }

    public int getSignalStrength() {
        return this.mSignalStrength;
    }

    public String getTag() {
        return this.mTag;
    }

    public boolean isPaired() {
        if (getPairedType() != 0) {
            return true;
        }
        return false;
    }

    public void readFromParcel(Parcel parcel) {
        this.mTag = parcel.readString();
        this.mBluetoothName = parcel.readString();
        this.mName = parcel.readString();
        this.mNickName = parcel.createByteArray();
        this.mPairState = parcel.readInt();
        this.mDeviceRole = parcel.readInt();
        this.mConnectType = parcel.readInt();
        this.mEvent = parcel.readInt();
        this.mMajor = parcel.readInt();
        this.mMinor = parcel.readInt();
        this.mSignalStrength = parcel.readInt();
        this.mDeviceId = parcel.createByteArray();
        this.mModelId = parcel.createByteArray();
        this.mAdditionData = parcel.createByteArray();
        this.mAlias = parcel.createByteArray();
        this.mBluetoothDevice = (BluetoothDevice) parcel.readParcelable(BluetoothDevice.class.getClassLoader());
        this.mBlePairState = (BlePairState) parcel.readParcelable(BlePairState.class.getClassLoader());
        this.mBtPairState = (BtPairState) parcel.readParcelable(BtPairState.class.getClassLoader());
        this.mP2pPairState = (P2pPairState) parcel.readParcelable(P2pPairState.class.getClassLoader());
        int dataPosition = parcel.dataPosition();
        try {
            if (!VERSION_TAG.equals(parcel.readString())) {
                C1371a.g(TAG, "DeviceInfo: VERSION_TAG check error, ignore lan info");
                parcel.setDataPosition(dataPosition);
                return;
            }
            Bundle readBundle = parcel.readBundle(LANPairState.class.getClassLoader());
            if (readBundle == null) {
                C1371a.c(TAG, "DeviceInfo: tag is not correct, reset position");
                parcel.setDataPosition(dataPosition);
                return;
            }
            this.mLANPairState = (LANPairState) readBundle.getParcelable(COMPATIBLE_KEY_LAN_PAIR_STATE);
            this.mScanType = readBundle.getInt(COMPATIBLE_KEY_SCAN_TYPE);
            this.mAdvertiseType = readBundle.getInt(COMPATIBLE_KEY_ADV_TYPE);
            this.mActiveTrigger = readBundle.getInt(USER_ACTIVE_TRIGGER_NOFEELING);
            if (readBundle.containsKey(COMPATIBLE_KEY_BT_INSECURE_STATE)) {
                this.mBtInsecurePairState.setPaired(true);
                String string = readBundle.getString(COMPATIBLE_KEY_BT_INSECURE_STATE);
                if (!TextUtils.isEmpty(string)) {
                    this.mBtInsecurePairState.setMac(string);
                }
            }
            this.mLocalSupportKeyType = readBundle.getInt(COMPATIBLE_KEY_KEY_TYPE);
            this.mFinalKeyType = readBundle.getInt(COMPATIBLE_KEY_KEY_TYPE_FINAL_USED);
            this.mRfcommPort = readBundle.getInt(DEVICE_INFO_RFOMM_PORT);
        } catch (Exception unused) {
            parcel.setDataPosition(dataPosition);
        }
    }

    public void setActiveTrigger(int i10) {
        this.mActiveTrigger = i10;
    }

    public void setAdditionData(byte[] bArr) {
        this.mAdditionData = bArr;
    }

    public void setAdvertiseType(int i10) {
        this.mAdvertiseType = i10;
    }

    public void setAlias(byte[] bArr) {
        this.mAlias = bArr;
    }

    public void setBleMac(String str) {
        this.mBlePairState.setMac(str);
    }

    public void setBlePaired(boolean z10) {
        this.mBlePairState.setPaired(z10);
    }

    public void setBluetoothDevice(BluetoothDevice bluetoothDevice) {
        this.mBluetoothDevice = bluetoothDevice;
    }

    public void setBluetoothName(String str) {
        this.mBluetoothName = str;
    }

    public void setBtInsecureMac(String str) {
        this.mBtInsecurePairState.setMac(str);
        this.mBtInsecurePairState.setPaired(true);
    }

    public void setBtMac(String str) {
        this.mBtPairState.setMac(str);
    }

    public void setBtPaired(boolean z10) {
        this.mBtPairState.setPaired(z10);
    }

    public void setConnectType(int i10) {
        if (i10 >= 1 && i10 <= 63) {
            this.mConnectType = i10;
        } else {
            C1371a.f(TAG, new IllegalArgumentException("invalid argument, connectType must be set 1-63"));
        }
    }

    public void setConnectTypeFromAdvertiseType(int i10) {
        this.mConnectType = FastPairConstants.convertPairTypeAdvToSdk(i10);
    }

    public void setDeviceId(byte[] bArr) {
        this.mDeviceId = bArr;
    }

    public void setDeviceRole(int i10) {
        if (i10 >= 1 && i10 <= 2) {
            this.mDeviceRole = i10;
        } else {
            C1371a.f(TAG, new IllegalArgumentException("invalid argument, deviceRole must be set 1-2"));
        }
    }

    public void setEvent(int i10) {
        this.mEvent = i10;
    }

    public void setFinalKeyType(int i10) {
        this.mFinalKeyType = i10;
    }

    public void setInsecurePaired(boolean z10) {
        this.mBtInsecurePairState.setPaired(z10);
    }

    public void setLANIp(String str) {
        this.mLANPairState.setIp(str);
    }

    public void setLANPaired(boolean z10) {
        this.mLANPairState.setPaired(z10);
    }

    public void setLocalSupportKeyType(int i10) {
        this.mLocalSupportKeyType = i10;
    }

    public void setMajor(int i10) {
        this.mMajor = i10;
    }

    public void setMinor(int i10) {
        this.mMinor = i10;
    }

    public void setModelId(byte[] bArr) {
        this.mModelId = bArr;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setNickName(byte[] bArr) {
        this.mNickName = bArr;
    }

    public void setOuterSdkVersion(int i10) {
        this.mOuterSdkVersion = i10;
    }

    public void setP2pIp(String str) {
        this.mP2pPairState.setIp(str);
    }

    public void setP2pMac(String str) {
        this.mP2pPairState.setP2pMac(str);
    }

    public void setP2pPaired(boolean z10) {
        this.mP2pPairState.setPaired(z10);
    }

    public void setPairState(int i10) {
        if (i10 >= 0 && i10 <= 2) {
            this.mPairState = i10;
        } else {
            C1371a.f(TAG, new IllegalArgumentException("invalid argument, pairState must be set 0-2"));
        }
    }

    public void setRfcommPort(int i10) {
        this.mRfcommPort = i10;
    }

    public void setScanType(int i10) {
        this.mScanType = i10;
    }

    public void setSignalStrength(int i10) {
        this.mSignalStrength = i10;
    }

    public void setTag(String str) {
        this.mTag = str;
    }

    public String toString() {
        return "DeviceInfo{ modelId=" + f.a(this.mModelId) + ", deviceId=" + f.f(this.mDeviceId) + ", tag=" + f.d(this.mTag) + ", name=" + f.d(this.mName) + ", major=" + this.mMajor + ", minor=" + this.mMinor + ", scanType=" + this.mScanType + ", advType=" + this.mAdvertiseType + ", getPairedType=" + getPairedType() + ", connectType=" + this.mConnectType + ", finalKeyType=" + this.mFinalKeyType + ", activeTrigger=" + this.mActiveTrigger + ", rfcommPort=" + this.mRfcommPort + " }";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.mTag);
        parcel.writeString(this.mBluetoothName);
        parcel.writeString(this.mName);
        parcel.writeByteArray(this.mNickName);
        parcel.writeInt(this.mPairState);
        parcel.writeInt(this.mDeviceRole);
        parcel.writeInt(this.mConnectType);
        parcel.writeInt(this.mEvent);
        parcel.writeInt(this.mMajor);
        parcel.writeInt(this.mMinor);
        parcel.writeInt(this.mSignalStrength);
        parcel.writeByteArray(this.mDeviceId);
        parcel.writeByteArray(this.mModelId);
        parcel.writeByteArray(this.mAdditionData);
        parcel.writeByteArray(this.mAlias);
        parcel.writeParcelable(this.mBluetoothDevice, 0);
        parcel.writeParcelable(this.mBlePairState, 0);
        parcel.writeParcelable(this.mBtPairState, 0);
        parcel.writeParcelable(this.mP2pPairState, 0);
        if (Initializer.getSdkIntegratorRole() == 0 && Initializer.getOAFVersion() < 20403) {
            C1371a.g(TAG, "writeToParcel, oaf version doesn't support lan, " + Initializer.getOAFVersion());
            return;
        }
        if (Initializer.getSdkIntegratorRole() == 1 && getOuterSdkVersion() < 30005) {
            C1371a.g(TAG, "writeToParcel, outer sdk version is less than oaf lan version, current:30005, outer: " + getOuterSdkVersion());
            return;
        }
        parcel.writeString(VERSION_TAG);
        Bundle bundle = new Bundle();
        bundle.putParcelable(COMPATIBLE_KEY_LAN_PAIR_STATE, this.mLANPairState);
        bundle.putInt(COMPATIBLE_KEY_SCAN_TYPE, this.mScanType);
        bundle.putInt(COMPATIBLE_KEY_ADV_TYPE, this.mAdvertiseType);
        bundle.putInt(USER_ACTIVE_TRIGGER_NOFEELING, this.mActiveTrigger);
        if (this.mBtInsecurePairState.isPaired()) {
            bundle.putString(COMPATIBLE_KEY_BT_INSECURE_STATE, this.mBtInsecurePairState.getMac());
        }
        bundle.putInt(COMPATIBLE_KEY_KEY_TYPE, this.mLocalSupportKeyType);
        bundle.putInt(COMPATIBLE_KEY_KEY_TYPE_FINAL_USED, this.mFinalKeyType);
        bundle.putInt(COMPATIBLE_KEY_KEY_TYPE_FINAL_USED, this.mFinalKeyType);
        bundle.putInt(DEVICE_INFO_RFOMM_PORT, this.mRfcommPort);
        parcel.writeBundle(bundle);
    }

    public byte[] getAdditionData(AdvAdditionDataType advAdditionDataType) {
        return AdditionDataInfo.getAdditionData(advAdditionDataType, this.mAdditionData);
    }

    public void setAdditionData(AdvAdditionDataType advAdditionDataType, byte[] bArr) {
        this.mAdditionData = AdditionDataInfo.setAdditionData(advAdditionDataType, bArr, this.mAdditionData);
    }

    public DeviceInfo(Parcel parcel) {
        readFromParcel(parcel);
    }
}
