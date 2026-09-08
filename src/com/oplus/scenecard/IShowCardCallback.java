package com.oplus.scenecard;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes3.dex */
public interface IShowCardCallback extends IInterface {
    void Z4(GetCardResponse getCardResponse);

    void onError(int i10);

    /* loaded from: classes3.dex */
    public static abstract class Stub extends Binder implements IShowCardCallback {

        /* loaded from: classes3.dex */
        public static class Proxy implements IShowCardCallback {

            /* renamed from: g, reason: collision with root package name */
            public static IShowCardCallback f28921g;

            /* renamed from: f, reason: collision with root package name */
            public IBinder f28922f;

            public Proxy(IBinder iBinder) {
                this.f28922f = iBinder;
            }

            @Override // com.oplus.scenecard.IShowCardCallback
            public void Z4(GetCardResponse getCardResponse) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.oplus.scenecard.IShowCardCallback");
                    if (getCardResponse != null) {
                        obtain.writeInt(1);
                        getCardResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f28922f.transact(1, obtain, obtain2, 0) && Stub.O7() != null) {
                        Stub.O7().Z4(getCardResponse);
                        obtain2.recycle();
                        obtain.recycle();
                    } else {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f28922f;
            }
        }

        public Stub() {
            attachInterface(this, "com.oplus.scenecard.IShowCardCallback");
        }

        public static IShowCardCallback N7(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.oplus.scenecard.IShowCardCallback");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IShowCardCallback)) {
                return (IShowCardCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static IShowCardCallback O7() {
            return Proxy.f28921g;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            GetCardResponse getCardResponse;
            if (i10 != 1598968902) {
                if (i10 != 1) {
                    if (i10 != 2) {
                        return super.onTransact(i10, parcel, parcel2, i11);
                    }
                    parcel.enforceInterface("com.oplus.scenecard.IShowCardCallback");
                    onError(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                }
                parcel.enforceInterface("com.oplus.scenecard.IShowCardCallback");
                if (parcel.readInt() != 0) {
                    getCardResponse = GetCardResponse.CREATOR.createFromParcel(parcel);
                } else {
                    getCardResponse = null;
                }
                Z4(getCardResponse);
                parcel2.writeNoException();
                return true;
            }
            parcel2.writeString("com.oplus.scenecard.IShowCardCallback");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public static class Default implements IShowCardCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.oplus.scenecard.IShowCardCallback
        public void Z4(GetCardResponse getCardResponse) {
        }
    }
}
