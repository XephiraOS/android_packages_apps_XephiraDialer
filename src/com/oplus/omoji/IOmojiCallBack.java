package com.oplus.omoji;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes3.dex */
public interface IOmojiCallBack extends IInterface {
    public static final String DESCRIPTOR = "com.oplus.omoji.IOmojiCallBack";

    void onCall(String str);

    /* loaded from: classes3.dex */
    public static abstract class Stub extends Binder implements IOmojiCallBack {
        static final int TRANSACTION_onCall = 1;

        /* loaded from: classes3.dex */
        public static class Proxy implements IOmojiCallBack {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IOmojiCallBack.DESCRIPTOR;
            }

            @Override // com.oplus.omoji.IOmojiCallBack
            public void onCall(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOmojiCallBack.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IOmojiCallBack.DESCRIPTOR);
        }

        public static IOmojiCallBack asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IOmojiCallBack.DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IOmojiCallBack)) {
                return (IOmojiCallBack) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(IOmojiCallBack.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(IOmojiCallBack.DESCRIPTOR);
                return true;
            }
            if (i10 != 1) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            onCall(parcel.readString());
            parcel2.writeNoException();
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public static class Default implements IOmojiCallBack {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.oplus.omoji.IOmojiCallBack
        public void onCall(String str) {
        }
    }
}
