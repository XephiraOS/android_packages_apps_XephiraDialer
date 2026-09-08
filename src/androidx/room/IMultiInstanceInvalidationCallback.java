package androidx.room;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public interface IMultiInstanceInvalidationCallback extends IInterface {
    void o1(String[] strArr);

    /* loaded from: classes.dex */
    public static class Default implements IMultiInstanceInvalidationCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // androidx.room.IMultiInstanceInvalidationCallback
        public void o1(String[] strArr) {
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IMultiInstanceInvalidationCallback {

        /* loaded from: classes.dex */
        public static class Proxy implements IMultiInstanceInvalidationCallback {

            /* renamed from: g, reason: collision with root package name */
            public static IMultiInstanceInvalidationCallback f11235g;

            /* renamed from: f, reason: collision with root package name */
            public IBinder f11236f;

            public Proxy(IBinder iBinder) {
                this.f11236f = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f11236f;
            }

            @Override // androidx.room.IMultiInstanceInvalidationCallback
            public void o1(String[] strArr) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationCallback");
                    obtain.writeStringArray(strArr);
                    if (!this.f11236f.transact(1, obtain, null, 1) && Stub.O7() != null) {
                        Stub.O7().o1(strArr);
                    }
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "androidx.room.IMultiInstanceInvalidationCallback");
        }

        public static IMultiInstanceInvalidationCallback N7(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("androidx.room.IMultiInstanceInvalidationCallback");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IMultiInstanceInvalidationCallback)) {
                return (IMultiInstanceInvalidationCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static IMultiInstanceInvalidationCallback O7() {
            return Proxy.f11235g;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 != 1) {
                if (i10 != 1598968902) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                parcel2.writeString("androidx.room.IMultiInstanceInvalidationCallback");
                return true;
            }
            parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationCallback");
            o1(parcel.createStringArray());
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
