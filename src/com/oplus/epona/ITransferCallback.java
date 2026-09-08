package com.oplus.epona;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes3.dex */
public interface ITransferCallback extends IInterface {
    void onReceive(Response response);

    /* loaded from: classes3.dex */
    public static abstract class Stub extends Binder implements ITransferCallback {

        /* loaded from: classes3.dex */
        public static class Proxy implements ITransferCallback {

            /* renamed from: g, reason: collision with root package name */
            public static ITransferCallback f28129g;

            /* renamed from: f, reason: collision with root package name */
            public IBinder f28130f;

            public Proxy(IBinder iBinder) {
                this.f28130f = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f28130f;
            }

            @Override // com.oplus.epona.ITransferCallback
            public void onReceive(Response response) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.oplus.epona.ITransferCallback");
                    if (response != null) {
                        obtain.writeInt(1);
                        response.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f28130f.transact(1, obtain, obtain2, 0) && Stub.O7() != null) {
                        Stub.O7().onReceive(response);
                        obtain2.recycle();
                        obtain.recycle();
                    } else {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.oplus.epona.ITransferCallback");
        }

        public static ITransferCallback N7(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.oplus.epona.ITransferCallback");
            if (queryLocalInterface != null && (queryLocalInterface instanceof ITransferCallback)) {
                return (ITransferCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static ITransferCallback O7() {
            return Proxy.f28129g;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            Response response;
            if (i10 != 1598968902) {
                if (i10 != 1) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                parcel.enforceInterface("com.oplus.epona.ITransferCallback");
                if (parcel.readInt() != 0) {
                    response = Response.CREATOR.createFromParcel(parcel);
                } else {
                    response = null;
                }
                onReceive(response);
                parcel2.writeNoException();
                return true;
            }
            parcel2.writeString("com.oplus.epona.ITransferCallback");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public static class Default implements ITransferCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.oplus.epona.ITransferCallback
        public void onReceive(Response response) {
        }
    }
}
