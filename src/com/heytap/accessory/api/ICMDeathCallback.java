package com.heytap.accessory.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes3.dex */
public interface ICMDeathCallback extends IInterface {

    /* loaded from: classes3.dex */
    public static class Default implements ICMDeathCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.heytap.accessory.api.ICMDeathCallback
        public String y() {
            return null;
        }
    }

    String y();

    /* loaded from: classes3.dex */
    public static abstract class Stub extends Binder implements ICMDeathCallback {

        /* loaded from: classes3.dex */
        public static class Proxy implements ICMDeathCallback {

            /* renamed from: f, reason: collision with root package name */
            public IBinder f25182f;

            public Proxy(IBinder iBinder) {
                this.f25182f = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f25182f;
            }

            @Override // com.heytap.accessory.api.ICMDeathCallback
            public String y() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.ICMDeathCallback");
                    this.f25182f.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.heytap.accessory.api.ICMDeathCallback");
        }

        public static ICMDeathCallback N7(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.accessory.api.ICMDeathCallback");
            if (queryLocalInterface != null && (queryLocalInterface instanceof ICMDeathCallback)) {
                return (ICMDeathCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface("com.heytap.accessory.api.ICMDeathCallback");
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
            parcel2.writeString("com.heytap.accessory.api.ICMDeathCallback");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
