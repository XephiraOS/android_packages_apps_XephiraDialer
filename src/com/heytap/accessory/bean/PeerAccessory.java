package com.heytap.accessory.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.heytap.accessory.constant.AFConstants;
import java.util.ArrayList;
import java.util.List;
import n5.C1371a;
import r5.f;
import r5.h;

/* loaded from: classes3.dex */
public class PeerAccessory implements Parcelable {
    public static final Parcelable.Creator<PeerAccessory> CREATOR = new Parcelable.Creator<PeerAccessory>() { // from class: com.heytap.accessory.bean.PeerAccessory.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PeerAccessory createFromParcel(Parcel parcel) {
            return new PeerAccessory(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PeerAccessory[] newArray(int i10) {
            return new PeerAccessory[i10];
        }
    };
    static final int DEFAULT_APDU_SIZE = 1048576;
    static final int DEFAULT_ENCRYPTION_PADDING_LENGTH = 0;
    static final int DEFAULT_MXDU_SIZE = 65524;
    static final int DEFAULT_SSDU_SIZE = 65530;
    public static final String TAG = "PeerAccessory";
    public static final String VERSION_TAG = "newPA_V1";
    private final String mAddress;
    private final int mApduSize;
    private byte[] mDeviceId;
    private int mDeviceType;
    private final int mEncryptionPaddingLength;
    private final long mId;
    private int mInsecureFlag;
    private final int mMxduSize;
    private final String mName;
    private final String mPeerId;
    private final String mProductId;
    private final int mSsduSize;
    private int mStatus;
    private final boolean mSupportCompression;
    private final boolean mSupportFile;
    private final boolean mSupportMessage;
    private final boolean mSupportStream;
    private final int mTransportType;
    private int mUUIDType;
    private final String mVendorId;
    private final int mVersion;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Deprecated
    public String getAccessoryId() {
        return this.mPeerId;
    }

    public String getAddress() {
        return this.mAddress;
    }

    public int getApduSize() {
        return this.mApduSize;
    }

    public List<String> getContent() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.toString(this.mVersion));
        arrayList.add(Long.toString(this.mId));
        arrayList.add(this.mAddress);
        arrayList.add(this.mName);
        arrayList.add(Integer.toString(this.mTransportType));
        arrayList.add(this.mProductId);
        arrayList.add(this.mVendorId);
        arrayList.add(Integer.toString(this.mSsduSize));
        arrayList.add(this.mPeerId);
        arrayList.add(Integer.toString(this.mMxduSize));
        arrayList.add(Integer.toString(this.mApduSize));
        arrayList.add(Integer.toString(this.mEncryptionPaddingLength));
        arrayList.add(Boolean.toString(this.mSupportMessage));
        arrayList.add(Boolean.toString(this.mSupportFile));
        arrayList.add(Boolean.toString(this.mSupportCompression));
        arrayList.add(Boolean.toString(this.mSupportStream));
        arrayList.add(Integer.toString(this.mUUIDType));
        arrayList.add(Integer.toString(this.mStatus));
        arrayList.add(f.a(this.mDeviceId));
        arrayList.add(String.valueOf(this.mDeviceType));
        arrayList.add(String.valueOf(this.mInsecureFlag));
        return arrayList;
    }

    public byte[] getDeviceId() {
        return this.mDeviceId;
    }

    public int getDeviceType() {
        return this.mDeviceType;
    }

    public int getEncryptionPaddingLength() {
        return this.mEncryptionPaddingLength;
    }

    public long getId() {
        return this.mId;
    }

    public int getInsecureFlag() {
        return this.mInsecureFlag;
    }

    public int getMxduSize() {
        return this.mMxduSize;
    }

    public String getName() {
        return this.mName;
    }

    public String getPeerId() {
        return this.mPeerId;
    }

    public String getProductId() {
        return this.mProductId;
    }

    public int getSsduSize() {
        return this.mSsduSize;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public int getTransportType() {
        return this.mTransportType;
    }

    public int getUUIDType() {
        return this.mUUIDType;
    }

    public String getVendorId() {
        return this.mVendorId;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public void setStatus(int i10) {
        this.mStatus = i10;
    }

    public boolean supportCompression() {
        return this.mSupportCompression;
    }

    public boolean supportFile() {
        return this.mSupportFile;
    }

    public boolean supportMessage() {
        return this.mSupportMessage;
    }

    public boolean supportStream() {
        return this.mSupportStream;
    }

    public String toShortString() {
        return "PeerAccessory{, mAddress='" + f.g(this.mAddress) + "', fraVer='" + h.b() + "', mName='" + f.d(this.mName) + "', mTransportType=" + this.mTransportType + ", mDeviceId=" + f.f(this.mDeviceId) + ", mDeviceType=" + this.mDeviceType + ", mInsecureFlag=" + this.mInsecureFlag + '}';
    }

    public String toString() {
        return "PeerAccessory{mVersion=" + this.mVersion + ", mId=" + this.mId + ", mAddress='" + f.g(this.mAddress) + "', mName='" + f.d(this.mName) + "', mTransportType=" + this.mTransportType + ", mUUnameType=" + this.mUUIDType + ", mProductId='" + f.d(this.mProductId) + "', mVendorId='" + f.d(this.mVendorId) + "', mApduSize=" + this.mApduSize + ", mSsduSize=" + this.mSsduSize + ", mMxduSize=" + this.mMxduSize + ", mEncryptionPaddingLength=" + this.mEncryptionPaddingLength + ", mPeerId='" + this.mPeerId + "', mSupportMessage=" + this.mSupportMessage + ", mSupportFile=" + this.mSupportFile + ", mSupportCompression=" + this.mSupportCompression + ", mSupportStream=" + this.mSupportStream + ", mStatus=" + this.mStatus + ", mDeviceId=" + f.f(this.mDeviceId) + ", mDeviceType=" + this.mDeviceType + ", mInsecureFlag=" + this.mInsecureFlag + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.mVersion);
        parcel.writeLong(this.mId);
        parcel.writeString(this.mAddress);
        parcel.writeString(this.mName);
        parcel.writeInt(this.mTransportType);
        parcel.writeString(this.mProductId);
        parcel.writeString(this.mVendorId);
        parcel.writeInt(this.mSsduSize);
        parcel.writeString(this.mPeerId);
        parcel.writeInt(this.mMxduSize);
        parcel.writeInt(this.mApduSize);
        parcel.writeInt(this.mEncryptionPaddingLength);
        parcel.writeInt(this.mSupportMessage ? 1 : 0);
        parcel.writeInt(this.mSupportFile ? 1 : 0);
        parcel.writeInt(this.mSupportCompression ? 1 : 0);
        parcel.writeInt(this.mSupportStream ? 1 : 0);
        if (h.b() >= 1) {
            parcel.writeString(VERSION_TAG);
            Bundle bundle = new Bundle();
            bundle.putInt(AFConstants.EXTRA_UUID, this.mUUIDType);
            bundle.putInt(AFConstants.EXTRA_STATUS, this.mStatus);
            bundle.putByteArray(AFConstants.EXTRA_DEVICE_ID, this.mDeviceId);
            bundle.putInt("deviceType", this.mDeviceType);
            bundle.putInt(AFConstants.EXTRA_INSECURE_FLAG, this.mInsecureFlag);
            parcel.writeBundle(bundle);
        }
    }

    private PeerAccessory(Parcel parcel) {
        this.mVersion = parcel.readInt();
        this.mId = parcel.readLong();
        this.mAddress = parcel.readString();
        this.mName = parcel.readString();
        this.mTransportType = parcel.readInt();
        this.mProductId = parcel.readString();
        this.mVendorId = parcel.readString();
        this.mSsduSize = parcel.readInt();
        this.mPeerId = parcel.readString();
        this.mMxduSize = parcel.readInt();
        this.mApduSize = parcel.readInt();
        this.mEncryptionPaddingLength = parcel.readInt();
        this.mSupportMessage = parcel.readInt() == 1;
        this.mSupportFile = parcel.readInt() == 1;
        this.mSupportCompression = parcel.readInt() == 1;
        this.mSupportStream = parcel.readInt() == 1;
        int dataPosition = parcel.dataPosition();
        try {
            String readString = parcel.readString();
            if (!VERSION_TAG.equals(readString)) {
                C1371a.c(TAG, "PeerAccessory: tag is not correct, reset position");
                parcel.setDataPosition(dataPosition);
                return;
            }
            String str = TAG;
            C1371a.c(str, "PeerAccessory: tag not empty:" + readString);
            Bundle readBundle = parcel.readBundle(PeerAccessory.class.getClassLoader());
            if (readBundle == null) {
                C1371a.c(str, "PeerAccessory: tag is not correct, reset position");
                parcel.setDataPosition(dataPosition);
                return;
            }
            this.mUUIDType = readBundle.getInt(AFConstants.EXTRA_UUID, 0);
            this.mStatus = readBundle.getInt(AFConstants.EXTRA_STATUS, 0);
            this.mDeviceId = readBundle.getByteArray(AFConstants.EXTRA_DEVICE_ID);
            this.mDeviceType = readBundle.getInt("deviceType", 0);
            this.mInsecureFlag = readBundle.getInt(AFConstants.EXTRA_INSECURE_FLAG, 0);
        } catch (Exception e10) {
            C1371a.c(TAG, "PeerAccessory:  get tag exception," + e10.getMessage());
            parcel.setDataPosition(dataPosition);
        }
    }

    public PeerAccessory(List<String> list) {
        this.mVersion = Integer.parseInt(list.get(0));
        this.mId = Integer.parseInt(list.get(1));
        this.mAddress = list.get(2);
        this.mName = list.get(3);
        this.mTransportType = Integer.parseInt(list.get(4));
        this.mProductId = list.get(5);
        this.mVendorId = list.get(6);
        this.mSsduSize = Integer.parseInt(list.get(7));
        this.mPeerId = list.get(8);
        this.mMxduSize = Integer.parseInt(list.get(9));
        this.mApduSize = Integer.parseInt(list.get(10));
        this.mEncryptionPaddingLength = Integer.parseInt(list.get(11));
        this.mSupportMessage = Boolean.parseBoolean(list.get(12));
        this.mSupportFile = Boolean.parseBoolean(list.get(13));
        this.mSupportCompression = Boolean.parseBoolean(list.get(14));
        this.mSupportStream = Boolean.parseBoolean(list.get(15));
        this.mUUIDType = Integer.parseInt(list.get(16));
        this.mStatus = Integer.parseInt(list.get(17));
        this.mDeviceId = f.c(list.get(18));
        this.mDeviceType = Integer.parseInt(list.get(19));
        this.mInsecureFlag = Integer.parseInt(list.get(20));
    }

    public PeerAccessory(int i10, long j10, String str, String str2, int i11, int i12, String str3, String str4, int i13, int i14, int i15, int i16, String str5, boolean z10, boolean z11, boolean z12, boolean z13, int i17, byte[] bArr, int i18, int i19) {
        this.mVersion = i10;
        this.mId = j10;
        this.mAddress = str;
        this.mName = str2;
        this.mTransportType = i11;
        this.mUUIDType = i12;
        this.mProductId = str3;
        this.mVendorId = str4;
        this.mSsduSize = i13;
        this.mApduSize = i14;
        this.mMxduSize = i15;
        this.mEncryptionPaddingLength = i16;
        this.mPeerId = str5;
        this.mSupportMessage = z10;
        this.mSupportFile = z11;
        this.mSupportCompression = z12;
        this.mSupportStream = z13;
        this.mStatus = i17;
        this.mDeviceId = bArr;
        this.mDeviceType = i18;
        this.mInsecureFlag = i19;
    }
}
