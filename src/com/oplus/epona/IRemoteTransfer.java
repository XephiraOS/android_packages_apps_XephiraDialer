package com.oplus.epona;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.oplus.epona.ITransferCallback;

/* loaded from: classes3.dex */
public interface IRemoteTransfer extends IInterface {
    Response X4(Request request);

    void c4(Request request, ITransferCallback iTransferCallback);

    /* loaded from: classes3.dex */
    public static abstract class Stub extends Binder implements IRemoteTransfer {

        /* loaded from: classes3.dex */
        public static class Proxy implements IRemoteTransfer {

            /* renamed from: g, reason: collision with root package name */
            public static IRemoteTransfer f28127g;

            /* renamed from: f, reason: collision with root package name */
            public IBinder f28128f;

            public Proxy(IBinder iBinder) {
                this.f28128f = iBinder;
            }

            @Override // com.oplus.epona.IRemoteTransfer
            public Response X4(Request request) {
                Response response;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.oplus.epona.IRemoteTransfer");
                    if (request != null) {
                        obtain.writeInt(1);
                        request.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f28128f.transact(1, obtain, obtain2, 0) && Stub.O7() != null) {
                        Response X42 = Stub.O7().X4(request);
                        obtain2.recycle();
                        obtain.recycle();
                        return X42;
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        response = Response.CREATOR.createFromParcel(obtain2);
                    } else {
                        response = null;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return response;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f28128f;
            }

            @Override // com.oplus.epona.IRemoteTransfer
            public void c4(Request request, ITransferCallback iTransferCallback) {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.oplus.epona.IRemoteTransfer");
                    if (request != null) {
                        obtain.writeInt(1);
                        request.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (iTransferCallback != null) {
                        iBinder = iTransferCallback.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!this.f28128f.transact(2, obtain, obtain2, 0) && Stub.O7() != null) {
                        Stub.O7().c4(request, iTransferCallback);
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
            attachInterface(this, "com.oplus.epona.IRemoteTransfer");
        }

        public static IRemoteTransfer N7(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.oplus.epona.IRemoteTransfer");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IRemoteTransfer)) {
                return (IRemoteTransfer) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static IRemoteTransfer O7() {
            return Proxy.f28127g;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 != 1598968902) {
                Request request = null;
                if (i10 != 1) {
                    if (i10 != 2) {
                        return super.onTransact(i10, parcel, parcel2, i11);
                    }
                    parcel.enforceInterface("com.oplus.epona.IRemoteTransfer");
                    if (parcel.readInt() != 0) {
                        request = Request.CREATOR.createFromParcel(parcel);
                    }
                    c4(request, ITransferCallback.Stub.N7(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                }
                parcel.enforceInterface("com.oplus.epona.IRemoteTransfer");
                if (parcel.readInt() != 0) {
                    request = Request.CREATOR.createFromParcel(parcel);
                }
                Response X42 = X4(request);
                parcel2.writeNoException();
                if (X42 != null) {
                    parcel2.writeInt(1);
                    X42.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            }
            parcel2.writeString("com.oplus.epona.IRemoteTransfer");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public static class Default implements IRemoteTransfer {
        @Override // com.oplus.epona.IRemoteTransfer
        public Response X4(Request request) {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.oplus.epona.IRemoteTransfer
        public void c4(Request request, ITransferCallback iTransferCallback) {
        }
    }
}
