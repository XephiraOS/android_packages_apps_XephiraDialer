package com.heytap.accessory.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.heytap.accessory.bean.DeviceInfo;

/* loaded from: classes3.dex */
public interface IWifiP2pChangeReceiver extends IInterface {

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

    void onStateChange(DeviceInfo deviceInfo, int i10, int i11);

    /* loaded from: classes3.dex */
    public static abstract class Stub extends Binder implements IWifiP2pChangeReceiver {

        /* loaded from: classes3.dex */
        public static class Proxy implements IWifiP2pChangeReceiver {

            /* renamed from: f, reason: collision with root package name */
            public IBinder f25206f;

            public Proxy(IBinder iBinder) {
                this.f25206f = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f25206f;
            }

            @Override // com.heytap.accessory.api.IWifiP2pChangeReceiver
            public void onStateChange(DeviceInfo deviceInfo, int i10, int i11) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IWifiP2pChangeReceiver");
                    a.d(obtain, deviceInfo, 0);
                    obtain.writeInt(i10);
                    obtain.writeInt(i11);
                    this.f25206f.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.heytap.accessory.api.IWifiP2pChangeReceiver");
        }

        public static IWifiP2pChangeReceiver N7(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.accessory.api.IWifiP2pChangeReceiver");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IWifiP2pChangeReceiver)) {
                return (IWifiP2pChangeReceiver) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface("com.heytap.accessory.api.IWifiP2pChangeReceiver");
            }
            if (i10 != 1598968902) {
                if (i10 != 1) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                onStateChange((DeviceInfo) a.c(parcel, DeviceInfo.CREATOR), parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
            parcel2.writeString("com.heytap.accessory.api.IWifiP2pChangeReceiver");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public static class Default implements IWifiP2pChangeReceiver {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.heytap.accessory.api.IWifiP2pChangeReceiver
        public void onStateChange(DeviceInfo deviceInfo, int i10, int i11) {
        }
    }
}
