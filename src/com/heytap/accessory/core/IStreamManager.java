package com.heytap.accessory.core;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;

/* loaded from: classes3.dex */
public interface IStreamManager extends IInterface {

    /* loaded from: classes3.dex */
    public static class Default implements IStreamManager {
        @Override // com.heytap.accessory.core.IStreamManager
        public Bundle I2(String str, Bundle bundle) {
            return null;
        }

        @Override // com.heytap.accessory.core.IStreamManager
        public boolean X(int i10, ResultReceiver resultReceiver) {
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
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

    Bundle I2(String str, Bundle bundle);

    boolean X(int i10, ResultReceiver resultReceiver);

    /* loaded from: classes3.dex */
    public static abstract class Stub extends Binder implements IStreamManager {

        /* loaded from: classes3.dex */
        public static class Proxy implements IStreamManager {

            /* renamed from: f, reason: collision with root package name */
            public IBinder f25216f;

            public Proxy(IBinder iBinder) {
                this.f25216f = iBinder;
            }

            @Override // com.heytap.accessory.core.IStreamManager
            public Bundle I2(String str, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.core.IStreamManager");
                    obtain.writeString(str);
                    a.d(obtain, bundle, 0);
                    this.f25216f.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return (Bundle) a.c(obtain2, Bundle.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.core.IStreamManager
            public boolean X(int i10, ResultReceiver resultReceiver) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.core.IStreamManager");
                    obtain.writeInt(i10);
                    boolean z10 = false;
                    a.d(obtain, resultReceiver, 0);
                    this.f25216f.transact(1, obtain, obtain2, 0);
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

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f25216f;
            }
        }

        public Stub() {
            attachInterface(this, "com.heytap.accessory.core.IStreamManager");
        }

        public static IStreamManager N7(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.accessory.core.IStreamManager");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IStreamManager)) {
                return (IStreamManager) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface("com.heytap.accessory.core.IStreamManager");
            }
            if (i10 != 1598968902) {
                if (i10 != 1) {
                    if (i10 != 2) {
                        return super.onTransact(i10, parcel, parcel2, i11);
                    }
                    Bundle I22 = I2(parcel.readString(), (Bundle) a.c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    a.d(parcel2, I22, 1);
                } else {
                    boolean X10 = X(parcel.readInt(), (ResultReceiver) a.c(parcel, ResultReceiver.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(X10 ? 1 : 0);
                }
                return true;
            }
            parcel2.writeString("com.heytap.accessory.core.IStreamManager");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
