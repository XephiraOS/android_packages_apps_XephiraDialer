package com.heytap.accessory.api;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.heytap.accessory.api.ICMDeathCallback;

/* loaded from: classes3.dex */
public interface IGenFrameworkManager extends IInterface {

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

    void F4(long j10, ICMDeathCallback iCMDeathCallback);

    boolean c(int i10, String str);

    Bundle s4(long j10, int i10, Bundle bundle);

    /* loaded from: classes3.dex */
    public static abstract class Stub extends Binder implements IGenFrameworkManager {

        /* loaded from: classes3.dex */
        public static class Proxy implements IGenFrameworkManager {

            /* renamed from: f, reason: collision with root package name */
            public IBinder f25190f;

            public Proxy(IBinder iBinder) {
                this.f25190f = iBinder;
            }

            @Override // com.heytap.accessory.api.IGenFrameworkManager
            public void F4(long j10, ICMDeathCallback iCMDeathCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IGenFrameworkManager");
                    obtain.writeLong(j10);
                    obtain.writeStrongInterface(iCMDeathCallback);
                    this.f25190f.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f25190f;
            }

            @Override // com.heytap.accessory.api.IGenFrameworkManager
            public boolean c(int i10, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IGenFrameworkManager");
                    obtain.writeInt(i10);
                    obtain.writeString(str);
                    boolean z10 = false;
                    this.f25190f.transact(3, obtain, obtain2, 0);
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

            @Override // com.heytap.accessory.api.IGenFrameworkManager
            public Bundle s4(long j10, int i10, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IGenFrameworkManager");
                    obtain.writeLong(j10);
                    obtain.writeInt(i10);
                    a.d(obtain, bundle, 0);
                    this.f25190f.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return (Bundle) a.c(obtain2, Bundle.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.heytap.accessory.api.IGenFrameworkManager");
        }

        public static IGenFrameworkManager N7(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.accessory.api.IGenFrameworkManager");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IGenFrameworkManager)) {
                return (IGenFrameworkManager) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface("com.heytap.accessory.api.IGenFrameworkManager");
            }
            if (i10 != 1598968902) {
                if (i10 != 1) {
                    if (i10 != 2) {
                        if (i10 != 3) {
                            return super.onTransact(i10, parcel, parcel2, i11);
                        }
                        boolean c10 = c(parcel.readInt(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(c10 ? 1 : 0);
                    } else {
                        Bundle s42 = s4(parcel.readLong(), parcel.readInt(), (Bundle) a.c(parcel, Bundle.CREATOR));
                        parcel2.writeNoException();
                        a.d(parcel2, s42, 1);
                    }
                } else {
                    F4(parcel.readLong(), ICMDeathCallback.Stub.N7(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                }
                return true;
            }
            parcel2.writeString("com.heytap.accessory.api.IGenFrameworkManager");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public static class Default implements IGenFrameworkManager {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.heytap.accessory.api.IGenFrameworkManager
        public boolean c(int i10, String str) {
            return false;
        }

        @Override // com.heytap.accessory.api.IGenFrameworkManager
        public Bundle s4(long j10, int i10, Bundle bundle) {
            return null;
        }

        @Override // com.heytap.accessory.api.IGenFrameworkManager
        public void F4(long j10, ICMDeathCallback iCMDeathCallback) {
        }
    }
}
