package org.codeaurora.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes4.dex */
public interface IDepersoResCallback extends IInterface {

    /* loaded from: classes4.dex */
    public static class Default implements IDepersoResCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    void D4(int i10, int i11);

    /* loaded from: classes4.dex */
    public static abstract class Stub extends Binder implements IDepersoResCallback {

        /* loaded from: classes4.dex */
        public static class Proxy implements IDepersoResCallback {

            /* renamed from: f, reason: collision with root package name */
            public IBinder f35878f;

            public Proxy(IBinder iBinder) {
                this.f35878f = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f35878f;
            }
        }

        public Stub() {
            attachInterface(this, "org.codeaurora.internal.IDepersoResCallback");
        }

        public static IDepersoResCallback N7(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("org.codeaurora.internal.IDepersoResCallback");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IDepersoResCallback)) {
                return (IDepersoResCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 != 1) {
                if (i10 != 1598968902) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                parcel2.writeString("org.codeaurora.internal.IDepersoResCallback");
                return true;
            }
            parcel.enforceInterface("org.codeaurora.internal.IDepersoResCallback");
            D4(parcel.readInt(), parcel.readInt());
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
