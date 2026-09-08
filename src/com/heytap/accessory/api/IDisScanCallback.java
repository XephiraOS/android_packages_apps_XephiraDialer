package com.heytap.accessory.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.heytap.accessory.bean.DeviceInfo;

/* loaded from: classes3.dex */
public interface IDisScanCallback extends IInterface {

    /* loaded from: classes3.dex */
    public static class a {
        public static <T> T c(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        public static <T extends Parcelable> void d(Parcel parcel, T t10, int i10) {
            if (t10 != null) {
                parcel.writeInt(1);
                t10.writeToParcel(parcel, i10);
            } else {
                parcel.writeInt(0);
            }
        }
    }

    void onCancel();

    void onDeviceFound(DeviceInfo deviceInfo);

    void y5(int i10);

    /* loaded from: classes3.dex */
    public static class Default implements IDisScanCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.heytap.accessory.api.IDisScanCallback
        public void onCancel() {
        }

        @Override // com.heytap.accessory.api.IDisScanCallback
        public void onDeviceFound(DeviceInfo deviceInfo) {
        }

        @Override // com.heytap.accessory.api.IDisScanCallback
        public void y5(int i10) {
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class Stub extends Binder implements IDisScanCallback {

        /* loaded from: classes3.dex */
        public static class Proxy implements IDisScanCallback {

            /* renamed from: f, reason: collision with root package name */
            public IBinder f25187f;

            public Proxy(IBinder iBinder) {
                this.f25187f = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f25187f;
            }

            @Override // com.heytap.accessory.api.IDisScanCallback
            public void onCancel() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IDisScanCallback");
                    this.f25187f.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IDisScanCallback
            public void onDeviceFound(DeviceInfo deviceInfo) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IDisScanCallback");
                    a.d(obtain, deviceInfo, 0);
                    this.f25187f.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IDisScanCallback
            public void y5(int i10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IDisScanCallback");
                    obtain.writeInt(i10);
                    this.f25187f.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.heytap.accessory.api.IDisScanCallback");
        }

        public static IDisScanCallback N7(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.accessory.api.IDisScanCallback");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IDisScanCallback)) {
                return (IDisScanCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface("com.heytap.accessory.api.IDisScanCallback");
            }
            if (i10 != 1598968902) {
                if (i10 != 1) {
                    if (i10 != 2) {
                        if (i10 != 3) {
                            return super.onTransact(i10, parcel, parcel2, i11);
                        }
                        y5(parcel.readInt());
                        parcel2.writeNoException();
                    } else {
                        onCancel();
                        parcel2.writeNoException();
                    }
                } else {
                    onDeviceFound((DeviceInfo) a.c(parcel, DeviceInfo.CREATOR));
                    parcel2.writeNoException();
                }
                return true;
            }
            parcel2.writeString("com.heytap.accessory.api.IDisScanCallback");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
