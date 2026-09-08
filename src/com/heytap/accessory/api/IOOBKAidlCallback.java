package com.heytap.accessory.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes3.dex */
public interface IOOBKAidlCallback extends IInterface {
    void C0();

    void E4(boolean z10);

    void Z6(byte[] bArr, boolean z10);

    void i7(byte[] bArr);

    /* loaded from: classes3.dex */
    public static class Default implements IOOBKAidlCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.heytap.accessory.api.IOOBKAidlCallback
        public void C0() {
        }

        @Override // com.heytap.accessory.api.IOOBKAidlCallback
        public void E4(boolean z10) {
        }

        @Override // com.heytap.accessory.api.IOOBKAidlCallback
        public void i7(byte[] bArr) {
        }

        @Override // com.heytap.accessory.api.IOOBKAidlCallback
        public void Z6(byte[] bArr, boolean z10) {
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class Stub extends Binder implements IOOBKAidlCallback {

        /* loaded from: classes3.dex */
        public static class Proxy implements IOOBKAidlCallback {

            /* renamed from: f, reason: collision with root package name */
            public IBinder f25194f;

            public Proxy(IBinder iBinder) {
                this.f25194f = iBinder;
            }

            @Override // com.heytap.accessory.api.IOOBKAidlCallback
            public void C0() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IOOBKAidlCallback");
                    this.f25194f.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IOOBKAidlCallback
            public void E4(boolean z10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IOOBKAidlCallback");
                    obtain.writeInt(z10 ? 1 : 0);
                    this.f25194f.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IOOBKAidlCallback
            public void Z6(byte[] bArr, boolean z10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IOOBKAidlCallback");
                    obtain.writeByteArray(bArr);
                    obtain.writeInt(z10 ? 1 : 0);
                    this.f25194f.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f25194f;
            }

            @Override // com.heytap.accessory.api.IOOBKAidlCallback
            public void i7(byte[] bArr) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IOOBKAidlCallback");
                    obtain.writeByteArray(bArr);
                    this.f25194f.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.heytap.accessory.api.IOOBKAidlCallback");
        }

        public static IOOBKAidlCallback N7(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.accessory.api.IOOBKAidlCallback");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IOOBKAidlCallback)) {
                return (IOOBKAidlCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface("com.heytap.accessory.api.IOOBKAidlCallback");
            }
            if (i10 != 1598968902) {
                if (i10 != 1) {
                    if (i10 != 2) {
                        boolean z10 = false;
                        if (i10 != 3) {
                            if (i10 != 4) {
                                return super.onTransact(i10, parcel, parcel2, i11);
                            }
                            byte[] createByteArray = parcel.createByteArray();
                            if (parcel.readInt() != 0) {
                                z10 = true;
                            }
                            Z6(createByteArray, z10);
                            parcel2.writeNoException();
                        } else {
                            if (parcel.readInt() != 0) {
                                z10 = true;
                            }
                            E4(z10);
                            parcel2.writeNoException();
                        }
                    } else {
                        i7(parcel.createByteArray());
                        parcel2.writeNoException();
                    }
                } else {
                    C0();
                    parcel2.writeNoException();
                }
                return true;
            }
            parcel2.writeString("com.heytap.accessory.api.IOOBKAidlCallback");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
