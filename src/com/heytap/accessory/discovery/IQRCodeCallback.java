package com.heytap.accessory.discovery;

import com.heytap.accessory.api.IQRCodeContentCallback;

/* loaded from: classes3.dex */
public abstract class IQRCodeCallback extends IQRCodeContentCallback.Stub {
    @Override // com.heytap.accessory.api.IQRCodeContentCallback
    public abstract /* synthetic */ void onFailure(int i10);

    @Override // com.heytap.accessory.api.IQRCodeContentCallback
    public abstract /* synthetic */ void onSuccess(String str);
}
