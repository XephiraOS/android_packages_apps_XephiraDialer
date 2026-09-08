package com.oplus.epona.interceptors;

import android.os.IBinder;
import android.os.RemoteException;
import com.heytap.epona.IRemoteTransfer;
import com.heytap.epona.ITransferCallback;
import com.heytap.epona.Response;
import com.heytap.epona.ipc.local.RemoteTransfer;
import com.oplus.epona.Call$Callback;
import com.oplus.epona.IRemoteTransfer;
import com.oplus.epona.ITransferCallback;
import com.oplus.epona.Request;
import com.oplus.epona.d;
import com.oplus.epona.f;
import com.oplus.utils.C0864z;
import e7.C0986b;
import e7.C0987c;
import e7.InterfaceC0985a;

/* loaded from: classes3.dex */
public class CompatIPCInterceptor implements f {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0985a<Request, com.heytap.epona.Request> f28168a = new C0987c();

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC0985a<Response, com.oplus.epona.Response> f28169b = new C0986b();

    @Override // com.oplus.epona.f
    public void a(f.a aVar) {
        String componentName = aVar.d().getComponentName();
        IBinder a10 = d.m().a(componentName);
        if (a10 != null) {
            try {
                String interfaceDescriptor = a10.getInterfaceDescriptor();
                String interfaceDescriptor2 = RemoteTransfer.U7().getInterfaceDescriptor();
                String interfaceDescriptor3 = com.oplus.epona.ipc.local.RemoteTransfer.Q7().getInterfaceDescriptor();
                if (interfaceDescriptor2.equals(interfaceDescriptor)) {
                    c(aVar, IRemoteTransfer.Stub.N7(a10));
                } else if (interfaceDescriptor3.equals(interfaceDescriptor)) {
                    d(aVar, IRemoteTransfer.Stub.N7(a10));
                }
            } catch (RemoteException e10) {
                String str = "failed to process binder for " + componentName;
                C0864z.d("Epona->CompatIPCInterceptor", str + " " + e10.getMessage(), new Object[0]);
                aVar.a().onReceive(com.oplus.epona.Response.f(str));
            }
        }
    }

    public final void c(f.a aVar, com.heytap.epona.IRemoteTransfer iRemoteTransfer) {
        final Call$Callback a10 = aVar.a();
        com.heytap.epona.Request convert = this.f28168a.convert(aVar.d());
        try {
            if (aVar.c()) {
                iRemoteTransfer.V3(convert, new ITransferCallback.Stub() { // from class: com.oplus.epona.interceptors.CompatIPCInterceptor.1
                    @Override // com.heytap.epona.ITransferCallback
                    public void O(Response response) {
                        a10.onReceive((com.oplus.epona.Response) CompatIPCInterceptor.this.f28169b.convert(response));
                    }
                });
            } else {
                a10.onReceive(this.f28169b.convert(iRemoteTransfer.B2(convert)));
            }
        } catch (RemoteException e10) {
            C0864z.d("Epona->CompatIPCInterceptor", "Failed to proceed to heytap, message: " + e10.getMessage(), new Object[0]);
            a10.onReceive(com.oplus.epona.Response.f("Failed to proceed to heytap, message: " + e10.getMessage()));
        }
    }

    public final void d(f.a aVar, com.oplus.epona.IRemoteTransfer iRemoteTransfer) {
        final Call$Callback a10 = aVar.a();
        try {
            if (aVar.c()) {
                iRemoteTransfer.c4(aVar.d(), new ITransferCallback.Stub() { // from class: com.oplus.epona.interceptors.CompatIPCInterceptor.2
                    @Override // com.oplus.epona.ITransferCallback
                    public void onReceive(com.oplus.epona.Response response) {
                        a10.onReceive(response);
                    }
                });
            } else {
                a10.onReceive(iRemoteTransfer.X4(aVar.d()));
            }
        } catch (RemoteException e10) {
            C0864z.d("Epona->CompatIPCInterceptor", "Failed to proceed to oplus, message: " + e10.getMessage(), new Object[0]);
            a10.onReceive(com.oplus.epona.Response.f("Failed to proceed to oplus, message: " + e10.getMessage()));
        }
    }
}
