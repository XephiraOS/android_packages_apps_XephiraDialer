package com.oplus.epona.interceptor;

import android.os.RemoteException;
import com.oplus.epona.Call$Callback;
import com.oplus.epona.IRemoteTransfer;
import com.oplus.epona.ITransferCallback;
import com.oplus.epona.Request;
import com.oplus.epona.Response;
import com.oplus.epona.f;
import com.oplus.utils.C0864z;

/* loaded from: classes3.dex */
public class IPCInterceptor implements f {
    @Override // com.oplus.epona.f
    public void a(f.a aVar) {
        Request d10 = aVar.d();
        IRemoteTransfer N72 = IRemoteTransfer.Stub.N7(com.oplus.epona.d.m().a(d10.getComponentName()));
        if (N72 != null) {
            final Call$Callback a10 = aVar.a();
            try {
                if (aVar.c()) {
                    N72.c4(d10, new ITransferCallback.Stub() { // from class: com.oplus.epona.interceptor.IPCInterceptor.1
                        @Override // com.oplus.epona.ITransferCallback
                        public void onReceive(Response response) {
                            a10.onReceive(response);
                        }
                    });
                } else {
                    a10.onReceive(N72.X4(d10));
                }
                return;
            } catch (RemoteException e10) {
                C0864z.d("Epona->IPCInterceptor", "fail to call %s#%s and exception is %s", d10.getComponentName(), d10.getActionName(), e10.toString());
                a10.onReceive(Response.b());
                return;
            }
        }
        aVar.b();
    }
}
