package com.heytap.accessory.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes3.dex */
public interface IDeathCallback extends IInterface {

    /* loaded from: classes3.dex */
    public static class Default implements IDeathCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.heytap.accessory.api.IDeathCallback
        public String y() {
            return null;
        }
    }

    String y();

    /* loaded from: classes3.dex */
    public static abstract class Stub extends Binder implements IDeathCallback {

        /* loaded from: classes3.dex */
        public static class Proxy implements IDeathCallback {

            /* renamed from: f, reason: collision with root package name */
            public IBinder f25184f;

            public Proxy(IBinder iBinder) {
                this.f25184f = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f25184f;
            }

            @Override // com.heytap.accessory.api.IDeathCallback
            public String y() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IDeathCallback");
                    this.f25184f.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.heytap.accessory.api.IDeathCallback");
        }

        public static IDeathCallback N7(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.accessory.api.IDeathCallback");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IDeathCallback)) {
                return (IDeathCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface("com.heytap.accessory.api.IDeathCallback");
            }
            if (i10 != 1598968902) {
                if (i10 != 1) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                String y10 = y();
                parcel2.writeNoException();
                parcel2.writeString(y10);
                return true;
            }
            parcel2.writeString("com.heytap.accessory.api.IDeathCallback");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
