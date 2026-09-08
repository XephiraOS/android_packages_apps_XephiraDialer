package com.heytap.accessory.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes3.dex */
public interface IPermissionCallback extends IInterface {
    void P5();

    void e0(int i10);

    /* loaded from: classes3.dex */
    public static class Default implements IPermissionCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.heytap.accessory.api.IPermissionCallback
        public void P5() {
        }

        @Override // com.heytap.accessory.api.IPermissionCallback
        public void e0(int i10) {
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class Stub extends Binder implements IPermissionCallback {

        /* loaded from: classes3.dex */
        public static class Proxy implements IPermissionCallback {

            /* renamed from: f, reason: collision with root package name */
            public IBinder f25201f;

            public Proxy(IBinder iBinder) {
                this.f25201f = iBinder;
            }

            @Override // com.heytap.accessory.api.IPermissionCallback
            public void P5() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IPermissionCallback");
                    this.f25201f.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f25201f;
            }

            @Override // com.heytap.accessory.api.IPermissionCallback
            public void e0(int i10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IPermissionCallback");
                    obtain.writeInt(i10);
                    this.f25201f.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.heytap.accessory.api.IPermissionCallback");
        }

        public static IPermissionCallback N7(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.accessory.api.IPermissionCallback");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IPermissionCallback)) {
                return (IPermissionCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface("com.heytap.accessory.api.IPermissionCallback");
            }
            if (i10 != 1598968902) {
                if (i10 != 1) {
                    if (i10 != 2) {
                        return super.onTransact(i10, parcel, parcel2, i11);
                    }
                    e0(parcel.readInt());
                    parcel2.writeNoException();
                } else {
                    P5();
                    parcel2.writeNoException();
                }
                return true;
            }
            parcel2.writeString("com.heytap.accessory.api.IPermissionCallback");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
