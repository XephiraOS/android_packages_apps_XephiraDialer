package com.heytap.accessory.api;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public interface IPeerAgentCallback extends IInterface {

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

    void H7(Bundle bundle);

    void T2(Bundle bundle);

    /* loaded from: classes3.dex */
    public static abstract class Stub extends Binder implements IPeerAgentCallback {

        /* loaded from: classes3.dex */
        public static class Proxy implements IPeerAgentCallback {

            /* renamed from: f, reason: collision with root package name */
            public IBinder f25198f;

            public Proxy(IBinder iBinder) {
                this.f25198f = iBinder;
            }

            @Override // com.heytap.accessory.api.IPeerAgentCallback
            public void H7(Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IPeerAgentCallback");
                    a.d(obtain, bundle, 0);
                    this.f25198f.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IPeerAgentCallback
            public void T2(Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IPeerAgentCallback");
                    a.d(obtain, bundle, 0);
                    this.f25198f.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f25198f;
            }
        }

        public Stub() {
            attachInterface(this, "com.heytap.accessory.api.IPeerAgentCallback");
        }

        public static IPeerAgentCallback N7(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.accessory.api.IPeerAgentCallback");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IPeerAgentCallback)) {
                return (IPeerAgentCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface("com.heytap.accessory.api.IPeerAgentCallback");
            }
            if (i10 != 1598968902) {
                if (i10 != 1) {
                    if (i10 != 2) {
                        return super.onTransact(i10, parcel, parcel2, i11);
                    }
                    H7((Bundle) a.c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                } else {
                    T2((Bundle) a.c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                }
                return true;
            }
            parcel2.writeString("com.heytap.accessory.api.IPeerAgentCallback");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public static class Default implements IPeerAgentCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.heytap.accessory.api.IPeerAgentCallback
        public void H7(Bundle bundle) {
        }

        @Override // com.heytap.accessory.api.IPeerAgentCallback
        public void T2(Bundle bundle) {
        }
    }
}
