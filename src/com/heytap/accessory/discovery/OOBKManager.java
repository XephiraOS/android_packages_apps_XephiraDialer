package com.heytap.accessory.discovery;

import com.heytap.accessory.api.IOOBKAidlCallback;
import n5.C1371a;

/* loaded from: classes3.dex */
public class OOBKManager extends BaseManager {

    /* loaded from: classes3.dex */
    public class OOBKAidlCallbackStub extends IOOBKAidlCallback.Stub {
        @Override // com.heytap.accessory.api.IOOBKAidlCallback
        public void C0() {
            OOBKManager.e(null);
            C1371a.k("OOBKManager", "onOOBKReady failed, IOOBKCallback is null");
        }

        @Override // com.heytap.accessory.api.IOOBKAidlCallback
        public void E4(boolean z10) {
            OOBKManager.e(null);
            C1371a.k("OOBKManager", "onOOBKReady failed, IOOBKCallback is null");
        }

        @Override // com.heytap.accessory.api.IOOBKAidlCallback
        public void Z6(byte[] bArr, boolean z10) {
            OOBKManager.e(null);
            C1371a.k("OOBKManager", "onOOBKNegoReceived failed, IOOBKCallback is null");
        }

        @Override // com.heytap.accessory.api.IOOBKAidlCallback
        public void i7(byte[] bArr) {
            OOBKManager.e(null);
            C1371a.k("OOBKManager", "onOOBKNegoReceived failed, IOOBKCallback is null");
        }
    }

    public static /* synthetic */ m e(OOBKManager oOBKManager) {
        throw null;
    }
}
