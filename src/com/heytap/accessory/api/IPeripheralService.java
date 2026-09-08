package com.heytap.accessory.api;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.heytap.accessory.api.IPeripheralCallback;
import com.heytap.accessory.bean.AdvertiseSetting;
import com.heytap.accessory.bean.BtDirectAdvertiseSetting;
import com.heytap.accessory.bean.DeviceInfo;

/* loaded from: classes3.dex */
public interface IPeripheralService extends IInterface {

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

    void E1(IPeripheralCallback iPeripheralCallback);

    void H4(DeviceInfo deviceInfo, int i10);

    void J4(DeviceInfo deviceInfo, boolean z10);

    void Q(Bundle bundle);

    void b2(BtDirectAdvertiseSetting btDirectAdvertiseSetting, IPeripheralCallback iPeripheralCallback);

    void t3();

    String v1();

    void w5(AdvertiseSetting advertiseSetting, IPeripheralCallback iPeripheralCallback);

    void x1(long j10, boolean z10);

    /* loaded from: classes3.dex */
    public static class Default implements IPeripheralService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.heytap.accessory.api.IPeripheralService
        public String v1() {
            return null;
        }

        @Override // com.heytap.accessory.api.IPeripheralService
        public void t3() {
        }

        @Override // com.heytap.accessory.api.IPeripheralService
        public void E1(IPeripheralCallback iPeripheralCallback) {
        }

        @Override // com.heytap.accessory.api.IPeripheralService
        public void Q(Bundle bundle) {
        }

        @Override // com.heytap.accessory.api.IPeripheralService
        public void H4(DeviceInfo deviceInfo, int i10) {
        }

        @Override // com.heytap.accessory.api.IPeripheralService
        public void J4(DeviceInfo deviceInfo, boolean z10) {
        }

        @Override // com.heytap.accessory.api.IPeripheralService
        public void b2(BtDirectAdvertiseSetting btDirectAdvertiseSetting, IPeripheralCallback iPeripheralCallback) {
        }

        @Override // com.heytap.accessory.api.IPeripheralService
        public void w5(AdvertiseSetting advertiseSetting, IPeripheralCallback iPeripheralCallback) {
        }

        @Override // com.heytap.accessory.api.IPeripheralService
        public void x1(long j10, boolean z10) {
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class Stub extends Binder implements IPeripheralService {

        /* loaded from: classes3.dex */
        public static class Proxy implements IPeripheralService {

            /* renamed from: f, reason: collision with root package name */
            public IBinder f25200f;

            public Proxy(IBinder iBinder) {
                this.f25200f = iBinder;
            }

            @Override // com.heytap.accessory.api.IPeripheralService
            public void E1(IPeripheralCallback iPeripheralCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IPeripheralService");
                    obtain.writeStrongInterface(iPeripheralCallback);
                    this.f25200f.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IPeripheralService
            public void H4(DeviceInfo deviceInfo, int i10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IPeripheralService");
                    a.d(obtain, deviceInfo, 0);
                    obtain.writeInt(i10);
                    this.f25200f.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IPeripheralService
            public void J4(DeviceInfo deviceInfo, boolean z10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IPeripheralService");
                    a.d(obtain, deviceInfo, 0);
                    obtain.writeInt(z10 ? 1 : 0);
                    this.f25200f.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IPeripheralService
            public void Q(Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IPeripheralService");
                    a.d(obtain, bundle, 0);
                    this.f25200f.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f25200f;
            }

            @Override // com.heytap.accessory.api.IPeripheralService
            public void b2(BtDirectAdvertiseSetting btDirectAdvertiseSetting, IPeripheralCallback iPeripheralCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IPeripheralService");
                    a.d(obtain, btDirectAdvertiseSetting, 0);
                    obtain.writeStrongInterface(iPeripheralCallback);
                    this.f25200f.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IPeripheralService
            public void t3() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IPeripheralService");
                    this.f25200f.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IPeripheralService
            public String v1() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IPeripheralService");
                    this.f25200f.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IPeripheralService
            public void w5(AdvertiseSetting advertiseSetting, IPeripheralCallback iPeripheralCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IPeripheralService");
                    a.d(obtain, advertiseSetting, 0);
                    obtain.writeStrongInterface(iPeripheralCallback);
                    this.f25200f.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IPeripheralService
            public void x1(long j10, boolean z10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IPeripheralService");
                    obtain.writeLong(j10);
                    obtain.writeInt(z10 ? 1 : 0);
                    this.f25200f.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.heytap.accessory.api.IPeripheralService");
        }

        public static IPeripheralService N7(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.accessory.api.IPeripheralService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IPeripheralService)) {
                return (IPeripheralService) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface("com.heytap.accessory.api.IPeripheralService");
            }
            if (i10 != 1598968902) {
                boolean z10 = false;
                switch (i10) {
                    case 1:
                        w5((AdvertiseSetting) a.c(parcel, AdvertiseSetting.CREATOR), IPeripheralCallback.Stub.N7(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        t3();
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        H4((DeviceInfo) a.c(parcel, DeviceInfo.CREATOR), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        DeviceInfo deviceInfo = (DeviceInfo) a.c(parcel, DeviceInfo.CREATOR);
                        if (parcel.readInt() != 0) {
                            z10 = true;
                        }
                        J4(deviceInfo, z10);
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        E1(IPeripheralCallback.Stub.N7(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        Q((Bundle) a.c(parcel, Bundle.CREATOR));
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        b2((BtDirectAdvertiseSetting) a.c(parcel, BtDirectAdvertiseSetting.CREATOR), IPeripheralCallback.Stub.N7(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 8:
                        long readLong = parcel.readLong();
                        if (parcel.readInt() != 0) {
                            z10 = true;
                        }
                        x1(readLong, z10);
                        parcel2.writeNoException();
                        return true;
                    case 9:
                        String v12 = v1();
                        parcel2.writeNoException();
                        parcel2.writeString(v12);
                        return true;
                    default:
                        return super.onTransact(i10, parcel, parcel2, i11);
                }
            }
            parcel2.writeString("com.heytap.accessory.api.IPeripheralService");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
