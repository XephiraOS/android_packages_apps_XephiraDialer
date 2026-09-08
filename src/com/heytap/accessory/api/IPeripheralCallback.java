package com.heytap.accessory.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.heytap.accessory.bean.DeviceInfo;
import com.heytap.accessory.bean.Message;

/* loaded from: classes3.dex */
public interface IPeripheralCallback extends IInterface {

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

    void K5(DeviceInfo deviceInfo, Message message);

    void P6();

    void T1(DeviceInfo deviceInfo, Message message);

    void c3(Message message);

    void k6(Message message);

    void onPairFailure(DeviceInfo deviceInfo, Message message);

    void onPairSuccess(DeviceInfo deviceInfo);

    void q1();

    void u3(Message message);

    void x4(int i10);

    /* loaded from: classes3.dex */
    public static class Default implements IPeripheralCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.heytap.accessory.api.IPeripheralCallback
        public void P6() {
        }

        @Override // com.heytap.accessory.api.IPeripheralCallback
        public void q1() {
        }

        @Override // com.heytap.accessory.api.IPeripheralCallback
        public void c3(Message message) {
        }

        @Override // com.heytap.accessory.api.IPeripheralCallback
        public void k6(Message message) {
        }

        @Override // com.heytap.accessory.api.IPeripheralCallback
        public void onPairSuccess(DeviceInfo deviceInfo) {
        }

        @Override // com.heytap.accessory.api.IPeripheralCallback
        public void u3(Message message) {
        }

        @Override // com.heytap.accessory.api.IPeripheralCallback
        public void x4(int i10) {
        }

        @Override // com.heytap.accessory.api.IPeripheralCallback
        public void K5(DeviceInfo deviceInfo, Message message) {
        }

        @Override // com.heytap.accessory.api.IPeripheralCallback
        public void T1(DeviceInfo deviceInfo, Message message) {
        }

        @Override // com.heytap.accessory.api.IPeripheralCallback
        public void onPairFailure(DeviceInfo deviceInfo, Message message) {
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class Stub extends Binder implements IPeripheralCallback {

        /* loaded from: classes3.dex */
        public static class Proxy implements IPeripheralCallback {

            /* renamed from: f, reason: collision with root package name */
            public IBinder f25199f;

            public Proxy(IBinder iBinder) {
                this.f25199f = iBinder;
            }

            @Override // com.heytap.accessory.api.IPeripheralCallback
            public void K5(DeviceInfo deviceInfo, Message message) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IPeripheralCallback");
                    a.d(obtain, deviceInfo, 0);
                    a.d(obtain, message, 0);
                    this.f25199f.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        message.readFromParcel(obtain2);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IPeripheralCallback
            public void P6() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IPeripheralCallback");
                    this.f25199f.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IPeripheralCallback
            public void T1(DeviceInfo deviceInfo, Message message) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IPeripheralCallback");
                    a.d(obtain, deviceInfo, 0);
                    a.d(obtain, message, 0);
                    this.f25199f.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        message.readFromParcel(obtain2);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f25199f;
            }

            @Override // com.heytap.accessory.api.IPeripheralCallback
            public void c3(Message message) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IPeripheralCallback");
                    a.d(obtain, message, 0);
                    this.f25199f.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IPeripheralCallback
            public void k6(Message message) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IPeripheralCallback");
                    a.d(obtain, message, 0);
                    this.f25199f.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IPeripheralCallback
            public void onPairFailure(DeviceInfo deviceInfo, Message message) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IPeripheralCallback");
                    a.d(obtain, deviceInfo, 0);
                    a.d(obtain, message, 0);
                    this.f25199f.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IPeripheralCallback
            public void onPairSuccess(DeviceInfo deviceInfo) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IPeripheralCallback");
                    a.d(obtain, deviceInfo, 0);
                    this.f25199f.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IPeripheralCallback
            public void q1() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IPeripheralCallback");
                    this.f25199f.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IPeripheralCallback
            public void u3(Message message) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IPeripheralCallback");
                    a.d(obtain, message, 0);
                    this.f25199f.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IPeripheralCallback
            public void x4(int i10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IPeripheralCallback");
                    obtain.writeInt(i10);
                    this.f25199f.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.heytap.accessory.api.IPeripheralCallback");
        }

        public static IPeripheralCallback N7(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.accessory.api.IPeripheralCallback");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IPeripheralCallback)) {
                return (IPeripheralCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface("com.heytap.accessory.api.IPeripheralCallback");
            }
            if (i10 != 1598968902) {
                switch (i10) {
                    case 1:
                        q1();
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        x4(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        P6();
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        DeviceInfo deviceInfo = (DeviceInfo) a.c(parcel, DeviceInfo.CREATOR);
                        Message message = (Message) a.c(parcel, Message.CREATOR);
                        K5(deviceInfo, message);
                        parcel2.writeNoException();
                        a.d(parcel2, message, 1);
                        return true;
                    case 5:
                        DeviceInfo deviceInfo2 = (DeviceInfo) a.c(parcel, DeviceInfo.CREATOR);
                        Message message2 = (Message) a.c(parcel, Message.CREATOR);
                        T1(deviceInfo2, message2);
                        parcel2.writeNoException();
                        a.d(parcel2, message2, 1);
                        return true;
                    case 6:
                        onPairSuccess((DeviceInfo) a.c(parcel, DeviceInfo.CREATOR));
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        onPairFailure((DeviceInfo) a.c(parcel, DeviceInfo.CREATOR), (Message) a.c(parcel, Message.CREATOR));
                        parcel2.writeNoException();
                        return true;
                    case 8:
                        u3((Message) a.c(parcel, Message.CREATOR));
                        parcel2.writeNoException();
                        return true;
                    case 9:
                        c3((Message) a.c(parcel, Message.CREATOR));
                        parcel2.writeNoException();
                        return true;
                    case 10:
                        k6((Message) a.c(parcel, Message.CREATOR));
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i10, parcel, parcel2, i11);
                }
            }
            parcel2.writeString("com.heytap.accessory.api.IPeripheralCallback");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
