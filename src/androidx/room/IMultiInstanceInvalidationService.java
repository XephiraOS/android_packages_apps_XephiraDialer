package androidx.room;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.room.IMultiInstanceInvalidationCallback;

/* loaded from: classes.dex */
public interface IMultiInstanceInvalidationService extends IInterface {
    void B7(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, int i10);

    int Z1(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, String str);

    void c7(int i10, String[] strArr);

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IMultiInstanceInvalidationService {

        /* loaded from: classes.dex */
        public static class Proxy implements IMultiInstanceInvalidationService {

            /* renamed from: g, reason: collision with root package name */
            public static IMultiInstanceInvalidationService f11237g;

            /* renamed from: f, reason: collision with root package name */
            public IBinder f11238f;

            public Proxy(IBinder iBinder) {
                this.f11238f = iBinder;
            }

            @Override // androidx.room.IMultiInstanceInvalidationService
            public int Z1(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, String str) {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationService");
                    if (iMultiInstanceInvalidationCallback != null) {
                        iBinder = iMultiInstanceInvalidationCallback.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    if (!this.f11238f.transact(1, obtain, obtain2, 0) && Stub.O7() != null) {
                        int Z12 = Stub.O7().Z1(iMultiInstanceInvalidationCallback, str);
                        obtain2.recycle();
                        obtain.recycle();
                        return Z12;
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f11238f;
            }

            @Override // androidx.room.IMultiInstanceInvalidationService
            public void c7(int i10, String[] strArr) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationService");
                    obtain.writeInt(i10);
                    obtain.writeStringArray(strArr);
                    if (!this.f11238f.transact(3, obtain, null, 1) && Stub.O7() != null) {
                        Stub.O7().c7(i10, strArr);
                    }
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "androidx.room.IMultiInstanceInvalidationService");
        }

        public static IMultiInstanceInvalidationService N7(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("androidx.room.IMultiInstanceInvalidationService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IMultiInstanceInvalidationService)) {
                return (IMultiInstanceInvalidationService) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static IMultiInstanceInvalidationService O7() {
            return Proxy.f11237g;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        if (i10 != 1598968902) {
                            return super.onTransact(i10, parcel, parcel2, i11);
                        }
                        parcel2.writeString("androidx.room.IMultiInstanceInvalidationService");
                        return true;
                    }
                    parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
                    c7(parcel.readInt(), parcel.createStringArray());
                    return true;
                }
                parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
                B7(IMultiInstanceInvalidationCallback.Stub.N7(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
            parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
            int Z12 = Z1(IMultiInstanceInvalidationCallback.Stub.N7(parcel.readStrongBinder()), parcel.readString());
            parcel2.writeNoException();
            parcel2.writeInt(Z12);
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static class Default implements IMultiInstanceInvalidationService {
        @Override // androidx.room.IMultiInstanceInvalidationService
        public int Z1(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, String str) {
            return 0;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // androidx.room.IMultiInstanceInvalidationService
        public void c7(int i10, String[] strArr) {
        }
    }
}
