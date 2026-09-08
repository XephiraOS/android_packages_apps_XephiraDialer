package com.oplus.epona.ipc.local;

import android.os.Parcel;
import android.os.RemoteException;
import com.oplus.epona.Call$Callback;
import com.oplus.epona.IRemoteTransfer;
import com.oplus.epona.ITransferCallback;
import com.oplus.epona.Request;
import com.oplus.epona.Response;
import com.oplus.epona.d;
import com.oplus.epona.ipc.local.RemoteTransfer;
import com.oplus.utils.C0864z;

/* loaded from: classes3.dex */
public class RemoteTransfer extends IRemoteTransfer.Stub {

    /* renamed from: f, reason: collision with root package name */
    public static volatile RemoteTransfer f28174f;

    private RemoteTransfer() {
    }

    public static RemoteTransfer Q7() {
        if (f28174f == null) {
            synchronized (RemoteTransfer.class) {
                try {
                    if (f28174f == null) {
                        f28174f = new RemoteTransfer();
                    }
                } finally {
                }
            }
        }
        return f28174f;
    }

    public static /* synthetic */ void R7(ITransferCallback iTransferCallback, Response response) {
        try {
            iTransferCallback.onReceive(response);
        } catch (RemoteException e10) {
            C0864z.d("Epona->RemoteTransfer", "failed to asyncCall and exception is %s", e10.toString());
        }
    }

    @Override // com.oplus.epona.IRemoteTransfer
    public Response X4(Request request) {
        return d.o(request).d();
    }

    @Override // com.oplus.epona.IRemoteTransfer
    public void c4(Request request, final ITransferCallback iTransferCallback) {
        d.o(request).c(new Call$Callback() { // from class: h7.b
            @Override // com.oplus.epona.Call$Callback
            public final void onReceive(Response response) {
                RemoteTransfer.R7(ITransferCallback.this, response);
            }
        });
    }

    @Override // com.oplus.epona.IRemoteTransfer.Stub, android.os.Binder
    public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
        try {
            return super.onTransact(i10, parcel, parcel2, i11);
        } catch (RuntimeException e10) {
            C0864z.d("Epona->RemoteTransfer", "onTransact Exception: " + e10.toString(), new Object[0]);
            throw e10;
        }
    }
}
