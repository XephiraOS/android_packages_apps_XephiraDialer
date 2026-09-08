package android.support.v4.app;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public interface INotificationSideChannel extends IInterface {

    /* renamed from: a, reason: collision with root package name */
    public static final String f6934a = "android$support$v4$app$INotificationSideChannel".replace('$', '.');

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

    void Q1(String str);

    void n4(String str, int i10, String str2);

    void o7(String str, int i10, String str2, Notification notification);

    /* loaded from: classes.dex */
    public static class Default implements INotificationSideChannel {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.support.v4.app.INotificationSideChannel
        public void Q1(String str) {
        }

        @Override // android.support.v4.app.INotificationSideChannel
        public void n4(String str, int i10, String str2) {
        }

        @Override // android.support.v4.app.INotificationSideChannel
        public void o7(String str, int i10, String str2, Notification notification) {
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements INotificationSideChannel {

        /* loaded from: classes.dex */
        public static class Proxy implements INotificationSideChannel {

            /* renamed from: f, reason: collision with root package name */
            public IBinder f6935f;

            public Proxy(IBinder iBinder) {
                this.f6935f = iBinder;
            }

            @Override // android.support.v4.app.INotificationSideChannel
            public void Q1(String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(INotificationSideChannel.f6934a);
                    obtain.writeString(str);
                    this.f6935f.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f6935f;
            }

            @Override // android.support.v4.app.INotificationSideChannel
            public void n4(String str, int i10, String str2) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(INotificationSideChannel.f6934a);
                    obtain.writeString(str);
                    obtain.writeInt(i10);
                    obtain.writeString(str2);
                    this.f6935f.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.support.v4.app.INotificationSideChannel
            public void o7(String str, int i10, String str2, Notification notification) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(INotificationSideChannel.f6934a);
                    obtain.writeString(str);
                    obtain.writeInt(i10);
                    obtain.writeString(str2);
                    a.d(obtain, notification, 0);
                    this.f6935f.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, INotificationSideChannel.f6934a);
        }

        public static INotificationSideChannel N7(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(INotificationSideChannel.f6934a);
            if (queryLocalInterface != null && (queryLocalInterface instanceof INotificationSideChannel)) {
                return (INotificationSideChannel) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            String str = INotificationSideChannel.f6934a;
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        return super.onTransact(i10, parcel, parcel2, i11);
                    }
                    Q1(parcel.readString());
                } else {
                    n4(parcel.readString(), parcel.readInt(), parcel.readString());
                }
            } else {
                o7(parcel.readString(), parcel.readInt(), parcel.readString(), (Notification) a.c(parcel, Notification.CREATOR));
            }
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
