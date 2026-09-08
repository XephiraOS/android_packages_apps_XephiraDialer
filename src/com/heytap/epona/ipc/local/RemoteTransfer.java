package com.heytap.epona.ipc.local;

import H5.a;
import I5.b;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.heytap.epona.IRemoteTransfer;
import com.heytap.epona.ITransferCallback;
import com.heytap.epona.Request;
import com.heytap.epona.Response;
import com.heytap.epona.c;
import com.heytap.epona.ipc.local.RemoteTransfer;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class RemoteTransfer extends IRemoteTransfer.Stub {

    /* renamed from: g, reason: collision with root package name */
    public static volatile RemoteTransfer f25450g;

    /* renamed from: f, reason: collision with root package name */
    public Map<String, IRemoteTransfer> f25451f = new HashMap();

    private RemoteTransfer() {
    }

    public static RemoteTransfer U7() {
        if (f25450g == null) {
            synchronized (RemoteTransfer.class) {
                try {
                    if (f25450g == null) {
                        f25450g = new RemoteTransfer();
                    }
                } finally {
                }
            }
        }
        return f25450g;
    }

    public static /* synthetic */ void V7(ITransferCallback iTransferCallback, Response response) {
        try {
            iTransferCallback.O(response);
        } catch (RemoteException e10) {
            a.c("RemoteTransfer", "failed to asyncCall and exception is %s", e10.toString());
        }
    }

    @Override // com.heytap.epona.IRemoteTransfer
    public Response B2(Request request) {
        if (b.a().c() && !R7(request)) {
            a.c("RemoteTransfer", "Epona Authentication failed, request : " + request.toString(), new Object[0]);
            return Response.f("Epona Authentication failed, request : " + request.toString());
        }
        return c.j(request).d();
    }

    public final boolean R7(Request request) {
        if (request != null && c.e() != null) {
            String packageName = c.e().getPackageName();
            return b.a().d(request.d(), request.b(), packageName);
        }
        a.c("RemoteTransfer", "Request is null.", new Object[0]);
        return true;
    }

    public final boolean S7() {
        Context f10 = c.f();
        if (f10 == null || f10.getPackageManager().resolveContentProvider("com.heytap.appplatform.dispatcher", 131072) == null) {
            return false;
        }
        return true;
    }

    public IRemoteTransfer T7(final String str) {
        IBinder iBinder = null;
        if (!S7()) {
            a.b("RemoteTransfer", "DispatcherProvider is not exist", new Object[0]);
            return null;
        }
        IRemoteTransfer iRemoteTransfer = this.f25451f.get(str);
        if (iRemoteTransfer == null) {
            Context f10 = c.f();
            if ("com.heytap.appplatform".equals(f10.getPackageName())) {
                iBinder = F5.b.c().b(str);
            } else {
                new Bundle().putString("com.heytap.epona.Dispatcher.TRANSFER_KEY", str);
                Bundle a10 = H5.b.a(f10, str);
                if (a10 != null) {
                    iBinder = a10.getBinder("com.heytap.epona.Dispatcher.TRANSFER_VALUE");
                } else {
                    a.c("RemoteTransfer", "Find remote transfer bundle null.", new Object[0]);
                }
            }
            if (iBinder != null) {
                iRemoteTransfer = IRemoteTransfer.Stub.N7(iBinder);
                this.f25451f.put(str, iRemoteTransfer);
                try {
                    iBinder.linkToDeath(new IBinder.DeathRecipient() { // from class: E5.b
                        @Override // android.os.IBinder.DeathRecipient
                        public final void binderDied() {
                            RemoteTransfer.this.W7(str);
                        }
                    }, 0);
                } catch (RemoteException e10) {
                    a.f("RemoteTransfer", e10.toString(), new Object[0]);
                }
            } else {
                a.c("RemoteTransfer", "Get remote binder null. ComponentName : %s", str);
            }
        }
        return iRemoteTransfer;
    }

    @Override // com.heytap.epona.IRemoteTransfer
    public void V3(Request request, final ITransferCallback iTransferCallback) {
        if (b.a().c() && !R7(request)) {
            a.c("RemoteTransfer", "Epona Authentication failed, request : " + request.toString(), new Object[0]);
            iTransferCallback.O(Response.f("Epona Authentication failed, request : " + request.toString()));
            return;
        }
        c.j(request).c(new com.heytap.epona.a() { // from class: E5.a
            @Override // com.heytap.epona.a
            public final void O(Response response) {
                RemoteTransfer.V7(ITransferCallback.this, response);
            }
        });
    }

    public final /* synthetic */ void W7(String str) {
        this.f25451f.remove(str);
    }

    @Override // com.heytap.epona.IRemoteTransfer.Stub, android.os.Binder
    public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
        try {
            return super.onTransact(i10, parcel, parcel2, i11);
        } catch (RuntimeException e10) {
            a.c("RemoteTransfer", "onTransact Exception: " + e10.toString(), new Object[0]);
            throw e10;
        }
    }
}
