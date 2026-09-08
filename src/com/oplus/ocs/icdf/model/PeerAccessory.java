package com.oplus.ocs.icdf.model;

import r5.f;

/* loaded from: classes3.dex */
public class PeerAccessory {
    public static final int DEVICE_TYPE_BRACELET = 7;
    public static final int DEVICE_TYPE_COMPUTER = 6;
    public static final int DEVICE_TYPE_MOBILE_PHONE = 8;
    public static final int DEVICE_TYPE_NECK_MOUNTED_HEADPHONES = 4;
    public static final int DEVICE_TYPE_PAD = 10;
    public static final int DEVICE_TYPE_SMART_TV = 5;
    public static final int DEVICE_TYPE_SMART_WATCH = 1;
    public static final int DEVICE_TYPE_TWS_HEADPHONES = 3;
    public static final int DEVICE_TYPE_UNKNOWN = -1;
    public static final int TRANSPORT_ALL = 255;
    public static final int TRANSPORT_BLE = 4;
    public static final int TRANSPORT_BT = 2;
    public static final int TRANSPORT_NONE = 0;
    public static final int TRANSPORT_WIFI = 1;
    public static final int TRANSPORT_WIFI_LAN = 8;
    private String deviceIpAddress;
    private String deviceName;
    private String deviceOrn;
    private int deviceType;
    private int transportType;

    public PeerAccessory(com.heytap.accessory.bean.PeerAccessory peerAccessory) {
        setDeviceOrn(f.a(peerAccessory.getDeviceId()));
        setDeviceName(peerAccessory.getName());
        setDeviceIpAddress(peerAccessory.getAddress());
        setTransportType(peerAccessory.getTransportType());
        setDeviceType(peerAccessory.getDeviceType());
    }

    public String getDeviceIpAddress() {
        return this.deviceIpAddress;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public String getDeviceOrn() {
        return this.deviceOrn;
    }

    public int getDeviceType() {
        return this.deviceType;
    }

    public int getTransportType() {
        return this.transportType;
    }

    public void setDeviceIpAddress(String str) {
        this.deviceIpAddress = str;
    }

    public void setDeviceName(String str) {
        this.deviceName = str;
    }

    public void setDeviceOrn(String str) {
        this.deviceOrn = str;
    }

    public void setDeviceType(int i10) {
        this.deviceType = i10;
    }

    public void setTransportType(int i10) {
        this.transportType = i10;
    }

    public String toString() {
        return "PeerAccessory: [deviceName: " + f.d(this.deviceName) + ", deviceIP: " + f.g(this.deviceIpAddress) + ", deviceType: " + this.deviceType + "]";
    }
}
