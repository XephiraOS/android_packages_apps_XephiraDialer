package com.heytap.accessory.discovery;

import com.heytap.accessory.bean.DeviceInfo;

/* loaded from: classes3.dex */
public interface IScanCallback {
    void onCancel();

    void onCancel(int i10);

    void onDeviceFound(DeviceInfo deviceInfo);
}
