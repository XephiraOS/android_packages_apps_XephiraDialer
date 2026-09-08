package com.heytap.accessory.discovery;

import android.content.Intent;
import com.heytap.accessory.api.IP2pChangeListener;

/* loaded from: classes3.dex */
public abstract class IP2pStateChangeListener extends IP2pChangeListener.Stub {
    @Override // com.heytap.accessory.api.IP2pChangeListener
    public abstract /* synthetic */ void onP2pChange(Intent intent);
}
