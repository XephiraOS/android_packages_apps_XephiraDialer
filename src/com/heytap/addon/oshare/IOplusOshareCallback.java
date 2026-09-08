package com.heytap.addon.oshare;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import com.oplus.oshare.IOplusOshareCallback;
import com.oplus.oshare.OplusOshareDevice;
import java.util.ArrayList;
import java.util.List;
import x5.C1680a;

/* loaded from: classes3.dex */
public interface IOplusOshareCallback extends IInterface {
    void onDeviceChanged(List<C1680a> list);

    void onSendSwitchChanged(boolean z10);

    /* loaded from: classes3.dex */
    public static abstract class Stub extends Binder implements IOplusOshareCallback {

        /* loaded from: classes3.dex */
        public static class StubR extends IOplusOshareCallback.Stub {

            /* renamed from: f, reason: collision with root package name */
            public IOplusOshareCallback f25409f;

            public void onDeviceChanged(List<OplusOshareDevice> list) {
                ArrayList arrayList = new ArrayList();
                for (int i10 = 0; i10 < list.size(); i10++) {
                    arrayList.add(new C1680a(list.get(i10)));
                }
                this.f25409f.onDeviceChanged(arrayList);
            }

            public void onSendSwitchChanged(boolean z10) {
                this.f25409f.onSendSwitchChanged(z10);
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.heytap.addon.oshare.IOplusOshareCallback
        public void onDeviceChanged(List<C1680a> list) {
        }

        @Override // com.heytap.addon.oshare.IOplusOshareCallback
        public void onSendSwitchChanged(boolean z10) {
        }
    }
}
