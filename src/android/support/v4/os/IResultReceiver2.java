package android.support.v4.os;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public interface IResultReceiver2 extends IInterface {

    /* renamed from: b, reason: collision with root package name */
    public static final String f7046b = "android$support$v4$os$IResultReceiver2".replace('$', '.');

    /* loaded from: classes.dex */
    public static class Default implements IResultReceiver2 {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public static <T> T b(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }
    }

    void Z(int i10, Bundle bundle);

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IResultReceiver2 {

        /* loaded from: classes.dex */
        public static class Proxy implements IResultReceiver2 {

            /* renamed from: f, reason: collision with root package name */
            public IBinder f7047f;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f7047f;
            }
        }

        public Stub() {
            attachInterface(this, IResultReceiver2.f7046b);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            String str = IResultReceiver2.f7046b;
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
            Z(parcel.readInt(), (Bundle) a.b(parcel, Bundle.CREATOR));
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
