package com.heytap.accessory.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes3.dex */
public interface IQRCodeContentCallback extends IInterface {
    void onFailure(int i10);

    void onSuccess(String str);

    /* loaded from: classes3.dex */
    public static abstract class Stub extends Binder implements IQRCodeContentCallback {
        static final int TRANSACTION_onFailure = 2;
        static final int TRANSACTION_onSuccess = 1;

        /* loaded from: classes3.dex */
        public static class Proxy implements IQRCodeContentCallback {

            /* renamed from: f, reason: collision with root package name */
            public IBinder f25202f;

            public Proxy(IBinder iBinder) {
                this.f25202f = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f25202f;
            }

            @Override // com.heytap.accessory.api.IQRCodeContentCallback
            public void onFailure(int i10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IQRCodeContentCallback");
                    obtain.writeInt(i10);
                    this.f25202f.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IQRCodeContentCallback
            public void onSuccess(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IQRCodeContentCallback");
                    obtain.writeString(str);
                    this.f25202f.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.heytap.accessory.api.IQRCodeContentCallback");
        }

        public static IQRCodeContentCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.accessory.api.IQRCodeContentCallback");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IQRCodeContentCallback)) {
                return (IQRCodeContentCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface("com.heytap.accessory.api.IQRCodeContentCallback");
            }
            if (i10 != 1598968902) {
                if (i10 != 1) {
                    if (i10 != 2) {
                        return super.onTransact(i10, parcel, parcel2, i11);
                    }
                    onFailure(parcel.readInt());
                    parcel2.writeNoException();
                } else {
                    onSuccess(parcel.readString());
                    parcel2.writeNoException();
                }
                return true;
            }
            parcel2.writeString("com.heytap.accessory.api.IQRCodeContentCallback");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public static class Default implements IQRCodeContentCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.heytap.accessory.api.IQRCodeContentCallback
        public void onFailure(int i10) {
        }

        @Override // com.heytap.accessory.api.IQRCodeContentCallback
        public void onSuccess(String str) {
        }
    }
}
