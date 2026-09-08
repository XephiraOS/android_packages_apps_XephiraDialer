package com.heytap.accessory.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.heytap.accessory.bean.DeviceInfo;
import com.heytap.accessory.bean.Message;

/* loaded from: classes3.dex */
public interface IDirectPairCallback extends IInterface {

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

    void onPairFailure(DeviceInfo deviceInfo, Message message);

    void onPairSuccess(DeviceInfo deviceInfo, Message message);

    /* loaded from: classes3.dex */
    public static abstract class Stub extends Binder implements IDirectPairCallback {

        /* loaded from: classes3.dex */
        public static class Proxy implements IDirectPairCallback {

            /* renamed from: f, reason: collision with root package name */
            public IBinder f25185f;

            public Proxy(IBinder iBinder) {
                this.f25185f = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f25185f;
            }

            @Override // com.heytap.accessory.api.IDirectPairCallback
            public void onPairFailure(DeviceInfo deviceInfo, Message message) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IDirectPairCallback");
                    a.d(obtain, deviceInfo, 0);
                    a.d(obtain, message, 0);
                    this.f25185f.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IDirectPairCallback
            public void onPairSuccess(DeviceInfo deviceInfo, Message message) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IDirectPairCallback");
                    a.d(obtain, deviceInfo, 0);
                    a.d(obtain, message, 0);
                    this.f25185f.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.heytap.accessory.api.IDirectPairCallback");
        }

        public static IDirectPairCallback N7(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.accessory.api.IDirectPairCallback");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IDirectPairCallback)) {
                return (IDirectPairCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface("com.heytap.accessory.api.IDirectPairCallback");
            }
            if (i10 != 1598968902) {
                if (i10 != 1) {
                    if (i10 != 2) {
                        return super.onTransact(i10, parcel, parcel2, i11);
                    }
                    onPairFailure((DeviceInfo) a.c(parcel, DeviceInfo.CREATOR), (Message) a.c(parcel, Message.CREATOR));
                    parcel2.writeNoException();
                } else {
                    onPairSuccess((DeviceInfo) a.c(parcel, DeviceInfo.CREATOR), (Message) a.c(parcel, Message.CREATOR));
                    parcel2.writeNoException();
                }
                return true;
            }
            parcel2.writeString("com.heytap.accessory.api.IDirectPairCallback");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public static class Default implements IDirectPairCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.heytap.accessory.api.IDirectPairCallback
        public void onPairFailure(DeviceInfo deviceInfo, Message message) {
        }

        @Override // com.heytap.accessory.api.IDirectPairCallback
        public void onPairSuccess(DeviceInfo deviceInfo, Message message) {
        }
    }
}
