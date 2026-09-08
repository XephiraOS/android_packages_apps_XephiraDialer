package com.heytap.epona;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.heytap.epona.ITransferCallback;

/* loaded from: classes3.dex */
public interface IRemoteTransfer extends IInterface {
    Response B2(Request request);

    void V3(Request request, ITransferCallback iTransferCallback);

    /* loaded from: classes3.dex */
    public static abstract class Stub extends Binder implements IRemoteTransfer {

        /* loaded from: classes3.dex */
        public static class Proxy implements IRemoteTransfer {

            /* renamed from: g, reason: collision with root package name */
            public static IRemoteTransfer f25413g;

            /* renamed from: f, reason: collision with root package name */
            public IBinder f25414f;

            public Proxy(IBinder iBinder) {
                this.f25414f = iBinder;
            }

            @Override // com.heytap.epona.IRemoteTransfer
            public Response B2(Request request) {
                Response response;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.epona.IRemoteTransfer");
                    if (request != null) {
                        obtain.writeInt(1);
                        request.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f25414f.transact(1, obtain, obtain2, 0) && Stub.O7() != null) {
                        Response B22 = Stub.O7().B2(request);
                        obtain2.recycle();
                        obtain.recycle();
                        return B22;
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

            @Override // com.heytap.epona.IRemoteTransfer
            public void V3(Request request, ITransferCallback iTransferCallback) {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.epona.IRemoteTransfer");
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
                    if (!this.f25414f.transact(2, obtain, obtain2, 0) && Stub.O7() != null) {
                        Stub.O7().V3(request, iTransferCallback);
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
                return this.f25414f;
            }
        }

        public Stub() {
            attachInterface(this, "com.heytap.epona.IRemoteTransfer");
        }

        public static IRemoteTransfer N7(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.epona.IRemoteTransfer");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IRemoteTransfer)) {
                return (IRemoteTransfer) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static IRemoteTransfer O7() {
            return Proxy.f25413g;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            Request request = null;
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 1598968902) {
                        return super.onTransact(i10, parcel, parcel2, i11);
                    }
                    parcel2.writeString("com.heytap.epona.IRemoteTransfer");
                    return true;
                }
                parcel.enforceInterface("com.heytap.epona.IRemoteTransfer");
                if (parcel.readInt() != 0) {
                    request = Request.CREATOR.createFromParcel(parcel);
                }
                V3(request, ITransferCallback.Stub.N7(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            parcel.enforceInterface("com.heytap.epona.IRemoteTransfer");
            if (parcel.readInt() != 0) {
                request = Request.CREATOR.createFromParcel(parcel);
            }
            Response B22 = B2(request);
            parcel2.writeNoException();
            if (B22 != null) {
                parcel2.writeInt(1);
                B22.writeToParcel(parcel2, 1);
            } else {
                parcel2.writeInt(0);
            }
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public static class Default implements IRemoteTransfer {
        @Override // com.heytap.epona.IRemoteTransfer
        public Response B2(Request request) {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.heytap.epona.IRemoteTransfer
        public void V3(Request request, ITransferCallback iTransferCallback) {
        }
    }
}
