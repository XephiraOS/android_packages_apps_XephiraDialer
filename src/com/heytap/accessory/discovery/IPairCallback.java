package com.heytap.accessory.discovery;

import android.os.Bundle;
import com.heytap.accessory.bean.DeviceInfo;

/* loaded from: classes3.dex */
public interface IPairCallback {
    byte[] onPairData(DeviceInfo deviceInfo, Bundle bundle);

    void onPairFailure(DeviceInfo deviceInfo, Bundle bundle);

    void onPairSuccess(DeviceInfo deviceInfo, Bundle bundle);

    int onPairTypeReceived(DeviceInfo deviceInfo, Bundle bundle);
}
