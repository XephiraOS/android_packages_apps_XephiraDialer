package com.heytap.accessory.core;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import com.heytap.accessory.api.IDeathCallback;

/* loaded from: classes3.dex */
public interface IFileManager extends IInterface {

    /* loaded from: classes3.dex */
    public static class Default implements IFileManager {
        @Override // com.heytap.accessory.core.IFileManager
        public Bundle L4(String str) {
            return null;
        }

        @Override // com.heytap.accessory.core.IFileManager
        public boolean X(int i10, ResultReceiver resultReceiver) {
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.heytap.accessory.core.IFileManager
        public boolean c(int i10, String str) {
            return false;
        }

        @Override // com.heytap.accessory.core.IFileManager
        public boolean s5(IDeathCallback iDeathCallback, long j10, long j11) {
            return false;
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

    Bundle L4(String str);

    boolean X(int i10, ResultReceiver resultReceiver);

    boolean c(int i10, String str);

    boolean s5(IDeathCallback iDeathCallback, long j10, long j11);

    /* loaded from: classes3.dex */
    public static abstract class Stub extends Binder implements IFileManager {

        /* loaded from: classes3.dex */
        public static class Proxy implements IFileManager {

            /* renamed from: f, reason: collision with root package name */
            public IBinder f25215f;

            public Proxy(IBinder iBinder) {
                this.f25215f = iBinder;
            }

            @Override // com.heytap.accessory.core.IFileManager
            public Bundle L4(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.core.IFileManager");
                    obtain.writeString(str);
                    this.f25215f.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return (Bundle) a.c(obtain2, Bundle.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.core.IFileManager
            public boolean X(int i10, ResultReceiver resultReceiver) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.core.IFileManager");
                    obtain.writeInt(i10);
                    boolean z10 = false;
                    a.d(obtain, resultReceiver, 0);
                    this.f25215f.transact(1, obtain, obtain2, 0);
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
                return this.f25215f;
            }

            @Override // com.heytap.accessory.core.IFileManager
            public boolean c(int i10, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.core.IFileManager");
                    obtain.writeInt(i10);
                    obtain.writeString(str);
                    boolean z10 = false;
                    this.f25215f.transact(3, obtain, obtain2, 0);
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

            @Override // com.heytap.accessory.core.IFileManager
            public boolean s5(IDeathCallback iDeathCallback, long j10, long j11) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.core.IFileManager");
                    obtain.writeStrongInterface(iDeathCallback);
                    obtain.writeLong(j10);
                    obtain.writeLong(j11);
                    boolean z10 = false;
                    this.f25215f.transact(4, obtain, obtain2, 0);
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
            attachInterface(this, "com.heytap.accessory.core.IFileManager");
        }

        public static IFileManager N7(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.accessory.core.IFileManager");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IFileManager)) {
                return (IFileManager) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface("com.heytap.accessory.core.IFileManager");
            }
            if (i10 != 1598968902) {
                if (i10 != 1) {
                    if (i10 != 2) {
                        if (i10 != 3) {
                            if (i10 != 4) {
                                return super.onTransact(i10, parcel, parcel2, i11);
                            }
                            boolean s52 = s5(IDeathCallback.Stub.N7(parcel.readStrongBinder()), parcel.readLong(), parcel.readLong());
                            parcel2.writeNoException();
                            parcel2.writeInt(s52 ? 1 : 0);
                        } else {
                            boolean c10 = c(parcel.readInt(), parcel.readString());
                            parcel2.writeNoException();
                            parcel2.writeInt(c10 ? 1 : 0);
                        }
                    } else {
                        Bundle L42 = L4(parcel.readString());
                        parcel2.writeNoException();
                        a.d(parcel2, L42, 1);
                    }
                } else {
                    boolean X10 = X(parcel.readInt(), (ResultReceiver) a.c(parcel, ResultReceiver.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(X10 ? 1 : 0);
                }
                return true;
            }
            parcel2.writeString("com.heytap.accessory.core.IFileManager");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
