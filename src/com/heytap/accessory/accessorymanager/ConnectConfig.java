package com.heytap.accessory.accessorymanager;

import android.os.Bundle;
import android.text.TextUtils;
import java.io.Serializable;
import n5.C1371a;
import r5.f;

/* loaded from: classes3.dex */
public class ConnectConfig implements Serializable {
    private static final String ADDRESS = "address";
    private static final String CONNECT_DEVICE_CATEGORY = "connect_device_category";
    public static final int CONNECT_UID_TYPE_DEFAULT = 0;
    public static final int CONNECT_UID_TYPE_INSECURE = 2;
    public static final int CONNECT_UID_TYPE_SECONDARY = 1;
    private static final String CONNECT_UUID = "connect_uuid";
    public static final int COUNT_FIELD_CONNECT_CONFIG = 6;
    private static final String DEVICE_ID = "device_id";
    private static final String KSC_ALIAS = "ksc_alias";
    private static final String NETWORK_QUALITY_TYPE = "network_quality_type";
    private static final String RETRY_MODE = "retry_mode";
    private static final String SOCKET_PORT = "socket_port";
    private static final String TAG = "ConnectConfig";
    private static final String TRANSPORT_TYPE = "transport_type";
    private static final long serialVersionUID = 1;
    private String mAddress;
    private String mCallingPackage;
    private byte[] mDeviceId;
    private int mDeviceType;
    private int mInsecureFlag;
    private byte[] mKscAlias;
    private int mNetworkQualityType;
    private int mRetryMode;
    private int mSocketPort;
    private int mTransportType;
    private int mUidType;

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f25162a;

        /* renamed from: b, reason: collision with root package name */
        public int f25163b;

        /* renamed from: c, reason: collision with root package name */
        public byte[] f25164c;

        /* renamed from: d, reason: collision with root package name */
        public byte[] f25165d;

        /* renamed from: e, reason: collision with root package name */
        public int f25166e;

        /* renamed from: f, reason: collision with root package name */
        public int f25167f;

        /* renamed from: g, reason: collision with root package name */
        public int f25168g;

        /* renamed from: h, reason: collision with root package name */
        public int f25169h;

        /* renamed from: i, reason: collision with root package name */
        public int f25170i;

        /* renamed from: j, reason: collision with root package name */
        public int f25171j;

        public b() {
            this.f25171j = 0;
        }
    }

    public static b builder() {
        return new b();
    }

    public static ConnectConfig createFromBundle(Bundle bundle) {
        String string = bundle.getString(ADDRESS);
        int i10 = bundle.getInt(TRANSPORT_TYPE);
        byte[] byteArray = bundle.getByteArray(DEVICE_ID);
        byte[] byteArray2 = bundle.getByteArray(KSC_ALIAS);
        int i11 = bundle.getInt(RETRY_MODE);
        int i12 = bundle.getInt(CONNECT_UUID);
        if (byteArray != null && !TextUtils.isEmpty(string) && byteArray2 != null) {
            int i13 = bundle.getInt(CONNECT_DEVICE_CATEGORY, -1);
            int i14 = bundle.getInt(SOCKET_PORT);
            int i15 = bundle.getInt(NETWORK_QUALITY_TYPE);
            ConnectConfig connectConfig = new ConnectConfig(string, i10, byteArray, byteArray2, i11, i12);
            connectConfig.setDeviceType(i13);
            connectConfig.setSocketPort(i14);
            connectConfig.setNetworkQualityType(i15);
            return connectConfig;
        }
        C1371a.k(TAG, "invalid ConnectConfig, deviceId, address, kscAlias cannot be empty.");
        return null;
    }

    public String getAddress() {
        String str = this.mAddress;
        if (str == null) {
            return "";
        }
        return str.toUpperCase();
    }

    public Bundle getBundle() {
        Bundle bundle = new Bundle();
        bundle.putString(ADDRESS, this.mAddress);
        bundle.putInt(TRANSPORT_TYPE, this.mTransportType);
        bundle.putByteArray(DEVICE_ID, this.mDeviceId);
        bundle.putByteArray(KSC_ALIAS, this.mKscAlias);
        bundle.putInt(RETRY_MODE, this.mRetryMode);
        bundle.putInt(CONNECT_UUID, this.mUidType);
        bundle.putInt(CONNECT_DEVICE_CATEGORY, this.mDeviceType);
        bundle.putInt(SOCKET_PORT, this.mSocketPort);
        bundle.putInt(NETWORK_QUALITY_TYPE, this.mNetworkQualityType);
        return bundle;
    }

    public String getCallingPackage() {
        return this.mCallingPackage;
    }

    public byte[] getDeviceId() {
        return this.mDeviceId;
    }

    public int getDeviceType() {
        return this.mDeviceType;
    }

    public int getInsecureFlag() {
        return this.mInsecureFlag;
    }

    public byte[] getKscAlias() {
        return this.mKscAlias;
    }

    public int getNetworkQualityType() {
        return this.mNetworkQualityType;
    }

    public int getRetryMode() {
        return this.mRetryMode;
    }

    public int getSocketPort() {
        return this.mSocketPort;
    }

    public int getTransportType() {
        return this.mTransportType;
    }

    public int getUidType() {
        return this.mUidType;
    }

    public void setAddress(String str) {
        this.mAddress = str;
    }

    public void setCallingPackage(String str) {
        this.mCallingPackage = str;
    }

    public void setDeviceId(byte[] bArr) {
        this.mDeviceId = bArr;
    }

    public void setDeviceType(int i10) {
        this.mDeviceType = i10;
    }

    public void setInsecureFlag(int i10) {
        this.mInsecureFlag = i10;
    }

    public void setKscAlias(byte[] bArr) {
        this.mKscAlias = bArr;
    }

    public void setNetworkQualityType(int i10) {
        this.mNetworkQualityType = i10;
    }

    public void setRetryMode(int i10) {
        this.mRetryMode = i10;
    }

    public void setSocketPort(int i10) {
        this.mSocketPort = i10;
    }

    public void setTransportType(int i10) {
        this.mTransportType = i10;
    }

    public void setUidType(int i10) {
        this.mUidType = i10;
    }

    public String toString() {
        return "ConnectConfig{address='" + f.g(this.mAddress) + "', transportType=" + this.mTransportType + ", deviceId=" + f.f(this.mDeviceId) + ", kscAlias=" + f.f(this.mKscAlias) + ", retryMode=" + this.mRetryMode + ", UUname=" + this.mUidType + ", deviceType=" + this.mDeviceType + ", socketPort=" + this.mSocketPort + ",networkQualityType=" + this.mNetworkQualityType + ", insecureFlag = " + this.mInsecureFlag + '}';
    }

    public ConnectConfig(String str, int i10, byte[] bArr, byte[] bArr2) {
        this(str, i10, bArr, bArr2, 0);
    }

    public ConnectConfig(String str, int i10, byte[] bArr, byte[] bArr2, int i11) {
        this(str, i10, bArr, bArr2, i11, 0);
    }

    public ConnectConfig(String str, int i10, int i11, int i12) {
        this.mDeviceType = -1;
        this.mInsecureFlag = 0;
        this.mAddress = str;
        this.mTransportType = i10;
        this.mRetryMode = i11;
        this.mUidType = i12;
    }

    public ConnectConfig(String str, int i10, byte[] bArr, byte[] bArr2, int i11, int i12) {
        this.mDeviceType = -1;
        this.mInsecureFlag = 0;
        this.mDeviceId = bArr;
        this.mAddress = str;
        this.mKscAlias = bArr2;
        this.mRetryMode = i11;
        this.mTransportType = i10;
        this.mUidType = i12;
    }

    private ConnectConfig(b bVar) {
        this.mDeviceType = -1;
        this.mInsecureFlag = 0;
        this.mAddress = bVar.f25162a;
        this.mTransportType = bVar.f25163b;
        this.mDeviceId = bVar.f25164c;
        this.mKscAlias = bVar.f25165d;
        this.mRetryMode = bVar.f25166e;
        this.mUidType = bVar.f25167f;
        this.mDeviceType = bVar.f25168g;
        this.mSocketPort = bVar.f25169h;
        this.mNetworkQualityType = bVar.f25170i;
        this.mInsecureFlag = builder().f25171j;
    }
}
