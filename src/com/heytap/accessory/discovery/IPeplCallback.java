package com.heytap.accessory.discovery;

import com.heytap.accessory.bean.AuthenticateMessage;
import com.heytap.accessory.bean.ConnectMessage;
import com.heytap.accessory.bean.DeviceInfo;
import com.heytap.accessory.bean.Message;

/* loaded from: classes3.dex */
public interface IPeplCallback {
    void onAdvertiseFailure(Message message);

    void onAdvertiseStopped(Message message);

    void onAdvertiseSuccess(Message message);

    void onPairFailure(DeviceInfo deviceInfo, int i10);

    void onPairSuccess(DeviceInfo deviceInfo);

    int onRequestAuthenticate(DeviceInfo deviceInfo, AuthenticateMessage authenticateMessage);

    int onRequestConnect(DeviceInfo deviceInfo, ConnectMessage connectMessage);
}
