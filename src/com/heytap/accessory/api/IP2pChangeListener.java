package com.heytap.accessory.api;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public interface IP2pChangeListener extends IInterface {

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

    void onP2pChange(Intent intent);

    /* loaded from: classes3.dex */
    public static abstract class Stub extends Binder implements IP2pChangeListener {
        static final int TRANSACTION_onP2pChange = 1;

        /* loaded from: classes3.dex */
        public static class Proxy implements IP2pChangeListener {

            /* renamed from: f, reason: collision with root package name */
            public IBinder f25196f;

            public Proxy(IBinder iBinder) {
                this.f25196f = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f25196f;
            }

            @Override // com.heytap.accessory.api.IP2pChangeListener
            public void onP2pChange(Intent intent) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IP2pChangeListener");
                    a.d(obtain, intent, 0);
                    this.f25196f.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.heytap.accessory.api.IP2pChangeListener");
        }

        public static IP2pChangeListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.accessory.api.IP2pChangeListener");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IP2pChangeListener)) {
                return (IP2pChangeListener) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface("com.heytap.accessory.api.IP2pChangeListener");
            }
            if (i10 != 1598968902) {
                if (i10 != 1) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                onP2pChange((Intent) a.c(parcel, Intent.CREATOR));
                parcel2.writeNoException();
                return true;
            }
            parcel2.writeString("com.heytap.accessory.api.IP2pChangeListener");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public static class Default implements IP2pChangeListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.heytap.accessory.api.IP2pChangeListener
        public void onP2pChange(Intent intent) {
        }
    }
}
