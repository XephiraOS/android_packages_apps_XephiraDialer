package com.heytap.accessory.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.heytap.accessory.api.IOOBKAidlCallback;

/* loaded from: classes3.dex */
public interface IOOBKService extends IInterface {
    void J7(byte[] bArr);

    void O2(int i10, byte[] bArr, boolean z10);

    void Q3(int i10, byte[] bArr);

    void Y6(IOOBKAidlCallback iOOBKAidlCallback);

    void d4(IOOBKAidlCallback iOOBKAidlCallback);

    void i2(byte[] bArr, boolean z10);

    /* loaded from: classes3.dex */
    public static abstract class Stub extends Binder implements IOOBKService {

        /* loaded from: classes3.dex */
        public static class Proxy implements IOOBKService {

            /* renamed from: f, reason: collision with root package name */
            public IBinder f25195f;

            public Proxy(IBinder iBinder) {
                this.f25195f = iBinder;
            }

            @Override // com.heytap.accessory.api.IOOBKService
            public void J7(byte[] bArr) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IOOBKService");
                    obtain.writeByteArray(bArr);
                    this.f25195f.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IOOBKService
            public void O2(int i10, byte[] bArr, boolean z10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IOOBKService");
                    obtain.writeInt(i10);
                    obtain.writeByteArray(bArr);
                    obtain.writeInt(z10 ? 1 : 0);
                    this.f25195f.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IOOBKService
            public void Q3(int i10, byte[] bArr) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IOOBKService");
                    obtain.writeInt(i10);
                    obtain.writeByteArray(bArr);
                    this.f25195f.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IOOBKService
            public void Y6(IOOBKAidlCallback iOOBKAidlCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IOOBKService");
                    obtain.writeStrongInterface(iOOBKAidlCallback);
                    this.f25195f.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f25195f;
            }

            @Override // com.heytap.accessory.api.IOOBKService
            public void d4(IOOBKAidlCallback iOOBKAidlCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IOOBKService");
                    obtain.writeStrongInterface(iOOBKAidlCallback);
                    this.f25195f.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IOOBKService
            public void i2(byte[] bArr, boolean z10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IOOBKService");
                    obtain.writeByteArray(bArr);
                    obtain.writeInt(z10 ? 1 : 0);
                    this.f25195f.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.heytap.accessory.api.IOOBKService");
        }

        public static IOOBKService N7(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.accessory.api.IOOBKService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IOOBKService)) {
                return (IOOBKService) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface("com.heytap.accessory.api.IOOBKService");
            }
            if (i10 != 1598968902) {
                boolean z10 = false;
                switch (i10) {
                    case 1:
                        d4(IOOBKAidlCallback.Stub.N7(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        Y6(IOOBKAidlCallback.Stub.N7(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        Q3(parcel.readInt(), parcel.createByteArray());
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        J7(parcel.createByteArray());
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        int readInt = parcel.readInt();
                        byte[] createByteArray = parcel.createByteArray();
                        if (parcel.readInt() != 0) {
                            z10 = true;
                        }
                        O2(readInt, createByteArray, z10);
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        byte[] createByteArray2 = parcel.createByteArray();
                        if (parcel.readInt() != 0) {
                            z10 = true;
                        }
                        i2(createByteArray2, z10);
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i10, parcel, parcel2, i11);
                }
            }
            parcel2.writeString("com.heytap.accessory.api.IOOBKService");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public static class Default implements IOOBKService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.heytap.accessory.api.IOOBKService
        public void J7(byte[] bArr) {
        }

        @Override // com.heytap.accessory.api.IOOBKService
        public void Y6(IOOBKAidlCallback iOOBKAidlCallback) {
        }

        @Override // com.heytap.accessory.api.IOOBKService
        public void d4(IOOBKAidlCallback iOOBKAidlCallback) {
        }

        @Override // com.heytap.accessory.api.IOOBKService
        public void Q3(int i10, byte[] bArr) {
        }

        @Override // com.heytap.accessory.api.IOOBKService
        public void i2(byte[] bArr, boolean z10) {
        }

        @Override // com.heytap.accessory.api.IOOBKService
        public void O2(int i10, byte[] bArr, boolean z10) {
        }
    }
}
