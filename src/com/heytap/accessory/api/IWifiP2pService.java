package com.heytap.accessory.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.heytap.accessory.api.IP2pChangeListener;
import com.heytap.accessory.api.IWifiP2pChangeReceiver;
import com.heytap.accessory.bean.DeviceInfo;
import java.util.List;

/* loaded from: classes3.dex */
public interface IWifiP2pService extends IInterface {

    /* loaded from: classes3.dex */
    public static class a {
        public static <T> T d(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        public static <T extends Parcelable> void e(Parcel parcel, List<T> list, int i10) {
            if (list == null) {
                parcel.writeInt(-1);
                return;
            }
            int size = list.size();
            parcel.writeInt(size);
            for (int i11 = 0; i11 < size; i11++) {
                f(parcel, list.get(i11), i10);
            }
        }

        public static <T extends Parcelable> void f(Parcel parcel, T t10, int i10) {
            if (t10 != null) {
                parcel.writeInt(1);
                t10.writeToParcel(parcel, i10);
            } else {
                parcel.writeInt(0);
            }
        }
    }

    boolean K7(IWifiP2pChangeReceiver iWifiP2pChangeReceiver);

    void V4(DeviceInfo deviceInfo);

    List<DeviceInfo> X5();

    void Z2(String str, IP2pChangeListener iP2pChangeListener);

    String i5(DeviceInfo deviceInfo);

    void l3(String str);

    boolean z2(IWifiP2pChangeReceiver iWifiP2pChangeReceiver);

    /* loaded from: classes3.dex */
    public static abstract class Stub extends Binder implements IWifiP2pService {

        /* loaded from: classes3.dex */
        public static class Proxy implements IWifiP2pService {

            /* renamed from: f, reason: collision with root package name */
            public IBinder f25207f;

            public Proxy(IBinder iBinder) {
                this.f25207f = iBinder;
            }

            @Override // com.heytap.accessory.api.IWifiP2pService
            public boolean K7(IWifiP2pChangeReceiver iWifiP2pChangeReceiver) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IWifiP2pService");
                    obtain.writeStrongInterface(iWifiP2pChangeReceiver);
                    boolean z10 = false;
                    this.f25207f.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z10 = true;
                    }
                    return z10;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IWifiP2pService
            public void V4(DeviceInfo deviceInfo) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IWifiP2pService");
                    a.f(obtain, deviceInfo, 0);
                    this.f25207f.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IWifiP2pService
            public List<DeviceInfo> X5() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IWifiP2pService");
                    this.f25207f.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DeviceInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IWifiP2pService
            public void Z2(String str, IP2pChangeListener iP2pChangeListener) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IWifiP2pService");
                    obtain.writeString(str);
                    obtain.writeStrongInterface(iP2pChangeListener);
                    this.f25207f.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f25207f;
            }

            @Override // com.heytap.accessory.api.IWifiP2pService
            public String i5(DeviceInfo deviceInfo) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IWifiP2pService");
                    a.f(obtain, deviceInfo, 0);
                    this.f25207f.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IWifiP2pService
            public void l3(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IWifiP2pService");
                    obtain.writeString(str);
                    this.f25207f.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IWifiP2pService
            public boolean z2(IWifiP2pChangeReceiver iWifiP2pChangeReceiver) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IWifiP2pService");
                    obtain.writeStrongInterface(iWifiP2pChangeReceiver);
                    boolean z10 = false;
                    this.f25207f.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z10 = true;
                    }
                    return z10;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.heytap.accessory.api.IWifiP2pService");
        }

        public static IWifiP2pService N7(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.accessory.api.IWifiP2pService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IWifiP2pService)) {
                return (IWifiP2pService) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface("com.heytap.accessory.api.IWifiP2pService");
            }
            if (i10 != 1598968902) {
                switch (i10) {
                    case 1:
                        List<DeviceInfo> X52 = X5();
                        parcel2.writeNoException();
                        a.e(parcel2, X52, 1);
                        return true;
                    case 2:
                        String i52 = i5((DeviceInfo) a.d(parcel, DeviceInfo.CREATOR));
                        parcel2.writeNoException();
                        parcel2.writeString(i52);
                        return true;
                    case 3:
                        V4((DeviceInfo) a.d(parcel, DeviceInfo.CREATOR));
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        boolean z22 = z2(IWifiP2pChangeReceiver.Stub.N7(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(z22 ? 1 : 0);
                        return true;
                    case 5:
                        boolean K72 = K7(IWifiP2pChangeReceiver.Stub.N7(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(K72 ? 1 : 0);
                        return true;
                    case 6:
                        Z2(parcel.readString(), IP2pChangeListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        l3(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i10, parcel, parcel2, i11);
                }
            }
            parcel2.writeString("com.heytap.accessory.api.IWifiP2pService");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public static class Default implements IWifiP2pService {
        @Override // com.heytap.accessory.api.IWifiP2pService
        public boolean K7(IWifiP2pChangeReceiver iWifiP2pChangeReceiver) {
            return false;
        }

        @Override // com.heytap.accessory.api.IWifiP2pService
        public List<DeviceInfo> X5() {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.heytap.accessory.api.IWifiP2pService
        public String i5(DeviceInfo deviceInfo) {
            return null;
        }

        @Override // com.heytap.accessory.api.IWifiP2pService
        public boolean z2(IWifiP2pChangeReceiver iWifiP2pChangeReceiver) {
            return false;
        }

        @Override // com.heytap.accessory.api.IWifiP2pService
        public void V4(DeviceInfo deviceInfo) {
        }

        @Override // com.heytap.accessory.api.IWifiP2pService
        public void l3(String str) {
        }

        @Override // com.heytap.accessory.api.IWifiP2pService
        public void Z2(String str, IP2pChangeListener iP2pChangeListener) {
        }
    }
}
