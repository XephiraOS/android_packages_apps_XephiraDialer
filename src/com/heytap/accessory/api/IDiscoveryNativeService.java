package com.heytap.accessory.api;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.heytap.accessory.api.ICentralService;
import com.heytap.accessory.api.IDeathCallback;
import com.heytap.accessory.api.IOOBKService;
import com.heytap.accessory.api.IPeripheralService;
import com.heytap.accessory.api.IServiceConnectionIndicationCallback;
import com.heytap.accessory.api.IWifiP2pService;

/* loaded from: classes3.dex */
public interface IDiscoveryNativeService extends IInterface {

    /* loaded from: classes3.dex */
    public static class Default implements IDiscoveryNativeService {
        @Override // com.heytap.accessory.api.IDiscoveryNativeService
        public IOOBKService A7() {
            return null;
        }

        @Override // com.heytap.accessory.api.IDiscoveryNativeService
        public IWifiP2pService B5() {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.heytap.accessory.api.IDiscoveryNativeService
        public Bundle n5(int i10, String str, IDeathCallback iDeathCallback, int i11, IServiceConnectionIndicationCallback iServiceConnectionIndicationCallback) {
            return null;
        }

        @Override // com.heytap.accessory.api.IDiscoveryNativeService
        public IPeripheralService v3() {
            return null;
        }

        @Override // com.heytap.accessory.api.IDiscoveryNativeService
        public ICentralService v4() {
            return null;
        }
    }

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

    IOOBKService A7();

    IWifiP2pService B5();

    Bundle n5(int i10, String str, IDeathCallback iDeathCallback, int i11, IServiceConnectionIndicationCallback iServiceConnectionIndicationCallback);

    IPeripheralService v3();

    ICentralService v4();

    /* loaded from: classes3.dex */
    public static abstract class Stub extends Binder implements IDiscoveryNativeService {

        /* loaded from: classes3.dex */
        public static class Proxy implements IDiscoveryNativeService {

            /* renamed from: f, reason: collision with root package name */
            public IBinder f25188f;

            public Proxy(IBinder iBinder) {
                this.f25188f = iBinder;
            }

            @Override // com.heytap.accessory.api.IDiscoveryNativeService
            public IOOBKService A7() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IDiscoveryNativeService");
                    this.f25188f.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return IOOBKService.Stub.N7(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IDiscoveryNativeService
            public IWifiP2pService B5() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IDiscoveryNativeService");
                    this.f25188f.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return IWifiP2pService.Stub.N7(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f25188f;
            }

            @Override // com.heytap.accessory.api.IDiscoveryNativeService
            public Bundle n5(int i10, String str, IDeathCallback iDeathCallback, int i11, IServiceConnectionIndicationCallback iServiceConnectionIndicationCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IDiscoveryNativeService");
                    obtain.writeInt(i10);
                    obtain.writeString(str);
                    obtain.writeStrongInterface(iDeathCallback);
                    obtain.writeInt(i11);
                    obtain.writeStrongInterface(iServiceConnectionIndicationCallback);
                    this.f25188f.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return (Bundle) a.c(obtain2, Bundle.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IDiscoveryNativeService
            public IPeripheralService v3() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IDiscoveryNativeService");
                    this.f25188f.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return IPeripheralService.Stub.N7(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IDiscoveryNativeService
            public ICentralService v4() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IDiscoveryNativeService");
                    this.f25188f.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return ICentralService.Stub.N7(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.heytap.accessory.api.IDiscoveryNativeService");
        }

        public static IDiscoveryNativeService N7(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.accessory.api.IDiscoveryNativeService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IDiscoveryNativeService)) {
                return (IDiscoveryNativeService) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface("com.heytap.accessory.api.IDiscoveryNativeService");
            }
            if (i10 != 1598968902) {
                if (i10 != 1) {
                    if (i10 != 2) {
                        if (i10 != 3) {
                            if (i10 != 4) {
                                if (i10 != 5) {
                                    return super.onTransact(i10, parcel, parcel2, i11);
                                }
                                IOOBKService A72 = A7();
                                parcel2.writeNoException();
                                parcel2.writeStrongInterface(A72);
                            } else {
                                Bundle n52 = n5(parcel.readInt(), parcel.readString(), IDeathCallback.Stub.N7(parcel.readStrongBinder()), parcel.readInt(), IServiceConnectionIndicationCallback.Stub.N7(parcel.readStrongBinder()));
                                parcel2.writeNoException();
                                a.d(parcel2, n52, 1);
                            }
                        } else {
                            IWifiP2pService B52 = B5();
                            parcel2.writeNoException();
                            parcel2.writeStrongInterface(B52);
                        }
                    } else {
                        IPeripheralService v32 = v3();
                        parcel2.writeNoException();
                        parcel2.writeStrongInterface(v32);
                    }
                } else {
                    ICentralService v42 = v4();
                    parcel2.writeNoException();
                    parcel2.writeStrongInterface(v42);
                }
                return true;
            }
            parcel2.writeString("com.heytap.accessory.api.IDiscoveryNativeService");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
