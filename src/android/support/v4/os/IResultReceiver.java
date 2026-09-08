package android.support.v4.os;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public interface IResultReceiver extends IInterface {

    /* renamed from: c, reason: collision with root package name */
    public static final String f7044c = "android$support$v4$os$IResultReceiver".replace('$', '.');

    /* loaded from: classes.dex */
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

    void Z(int i10, Bundle bundle);

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IResultReceiver {

        /* loaded from: classes.dex */
        public static class Proxy implements IResultReceiver {

            /* renamed from: f, reason: collision with root package name */
            public IBinder f7045f;

            public Proxy(IBinder iBinder) {
                this.f7045f = iBinder;
            }

            @Override // android.support.v4.os.IResultReceiver
            public void Z(int i10, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IResultReceiver.f7044c);
                    obtain.writeInt(i10);
                    a.d(obtain, bundle, 0);
                    this.f7045f.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f7045f;
            }
        }

        public Stub() {
            attachInterface(this, IResultReceiver.f7044c);
        }

        public static IResultReceiver N7(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IResultReceiver.f7044c);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IResultReceiver)) {
                return (IResultReceiver) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            String str = IResultReceiver.f7044c;
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i10 != 1) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            Z(parcel.readInt(), (Bundle) a.c(parcel, Bundle.CREATOR));
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static class Default implements IResultReceiver {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.support.v4.os.IResultReceiver
        public void Z(int i10, Bundle bundle) {
        }
    }
}
