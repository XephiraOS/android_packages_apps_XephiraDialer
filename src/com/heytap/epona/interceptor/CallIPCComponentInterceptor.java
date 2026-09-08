package com.heytap.epona.interceptor;

import android.os.RemoteException;
import com.heytap.epona.IRemoteTransfer;
import com.heytap.epona.ITransferCallback;
import com.heytap.epona.Request;
import com.heytap.epona.Response;
import com.heytap.epona.d;
import com.heytap.epona.ipc.local.RemoteTransfer;

/* loaded from: classes3.dex */
public class CallIPCComponentInterceptor implements com.heytap.epona.d {
    @Override // com.heytap.epona.d
    public void a(d.a aVar) {
        final Request d10 = aVar.d();
        IRemoteTransfer T72 = RemoteTransfer.U7().T7(d10.d());
        if (T72 != null) {
            final com.heytap.epona.a a10 = aVar.a();
            try {
                if (aVar.c()) {
                    T72.V3(d10, new ITransferCallback.Stub() { // from class: com.heytap.epona.interceptor.CallIPCComponentInterceptor.1
                        @Override // com.heytap.epona.ITransferCallback
                        public void O(Response response) {
                            H5.a.b("CallIPCComponentInterceptor", "Component(%s).Action(%s) response : %s", d10.d(), d10.b(), response);
                            a10.O(response);
                        }
                    });
                } else {
                    Response B22 = T72.B2(d10);
                    H5.a.b("CallIPCComponentInterceptor", "Component(%s).Action(%s) response : %s", d10.d(), d10.b(), B22);
                    a10.O(B22);
                }
                return;
            } catch (RemoteException e10) {
                H5.a.c("CallIPCComponentInterceptor", "fail to call %s#%s and exception is %s", d10.d(), d10.b(), e10.toString());
                a10.O(Response.d());
                return;
            }
        }
        aVar.b();
    }
}
