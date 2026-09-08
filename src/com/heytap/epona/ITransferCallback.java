package com.heytap.epona;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes3.dex */
public interface ITransferCallback extends IInterface {
    void O(Response response);

    /* loaded from: classes3.dex */
    public static abstract class Stub extends Binder implements ITransferCallback {

        /* loaded from: classes3.dex */
        public static class Proxy implements ITransferCallback {

            /* renamed from: g, reason: collision with root package name */
            public static ITransferCallback f25415g;

            /* renamed from: f, reason: collision with root package name */
            public IBinder f25416f;

            public Proxy(IBinder iBinder) {
                this.f25416f = iBinder;
            }

            @Override // com.heytap.epona.ITransferCallback
            public void O(Response response) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.epona.ITransferCallback");
                    if (response != null) {
                        obtain.writeInt(1);
                        response.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f25416f.transact(1, obtain, obtain2, 0) && Stub.O7() != null) {
                        Stub.O7().O(response);
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

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f25416f;
            }
        }

        public Stub() {
            attachInterface(this, "com.heytap.epona.ITransferCallback");
        }

        public static ITransferCallback N7(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.epona.ITransferCallback");
            if (queryLocalInterface != null && (queryLocalInterface instanceof ITransferCallback)) {
                return (ITransferCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static ITransferCallback O7() {
            return Proxy.f25415g;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            Response response;
            if (i10 != 1) {
                if (i10 != 1598968902) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                parcel2.writeString("com.heytap.epona.ITransferCallback");
                return true;
            }
            parcel.enforceInterface("com.heytap.epona.ITransferCallback");
            if (parcel.readInt() != 0) {
                response = Response.CREATOR.createFromParcel(parcel);
            } else {
                response = null;
            }
            O(response);
            parcel2.writeNoException();
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

        @Override // com.heytap.epona.ITransferCallback
        public void O(Response response) {
        }
    }
}
