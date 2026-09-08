package com.juphoon.service.rcs;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.juphoon.service.rcs.IRcsCallback;

/* loaded from: classes3.dex */
public interface IRcsService extends IInterface {
    String A6();

    void D0(int i10);

    String D7();

    void I5(String str);

    String K0();

    void L6(IRcsCallback iRcsCallback);

    void M0(boolean z10);

    boolean M3();

    void S6(String str);

    String U4();

    String V2();

    void V6(int i10);

    void c1(boolean z10);

    int c6(String str);

    String d3();

    void e5(String str);

    int getState();

    boolean h2();

    void m0(IRcsCallback iRcsCallback);

    int o6();

    boolean w4(String str);

    void x0();

    void y3();

    int z3(String str);

    /* loaded from: classes3.dex */
    public static abstract class Stub extends Binder implements IRcsService {

        /* loaded from: classes3.dex */
        public static class Proxy implements IRcsService {

            /* renamed from: f, reason: collision with root package name */
            public IBinder f25575f;

            public Proxy(IBinder iBinder) {
                this.f25575f = iBinder;
            }

            @Override // com.juphoon.service.rcs.IRcsService
            public String K0() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.juphoon.service.rcs.IRcsService");
                    this.f25575f.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.juphoon.service.rcs.IRcsService
            public String U4() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.juphoon.service.rcs.IRcsService");
                    this.f25575f.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f25575f;
            }

            @Override // com.juphoon.service.rcs.IRcsService
            public int c6(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.juphoon.service.rcs.IRcsService");
                    obtain.writeString(str);
                    this.f25575f.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.juphoon.service.rcs.IRcsService
            public int getState() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.juphoon.service.rcs.IRcsService");
                    this.f25575f.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.juphoon.service.rcs.IRcsService
            public boolean h2() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.juphoon.service.rcs.IRcsService");
                    boolean z10 = false;
                    this.f25575f.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z10 = true;
                    }
                    return z10;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.juphoon.service.rcs.IRcsService
            public void m0(IRcsCallback iRcsCallback) {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.juphoon.service.rcs.IRcsService");
                    if (iRcsCallback != null) {
                        iBinder = iRcsCallback.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f25575f.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    obtain2.recycle();
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.juphoon.service.rcs.IRcsService
            public int o6() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.juphoon.service.rcs.IRcsService");
                    this.f25575f.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.juphoon.service.rcs.IRcsService");
        }

        public static IRcsService N7(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.juphoon.service.rcs.IRcsService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IRcsService)) {
                return (IRcsService) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 != 1598968902) {
                boolean z10 = false;
                switch (i10) {
                    case 1:
                        parcel.enforceInterface("com.juphoon.service.rcs.IRcsService");
                        String U42 = U4();
                        parcel2.writeNoException();
                        parcel2.writeString(U42);
                        return true;
                    case 2:
                        parcel.enforceInterface("com.juphoon.service.rcs.IRcsService");
                        String K02 = K0();
                        parcel2.writeNoException();
                        parcel2.writeString(K02);
                        return true;
                    case 3:
                        parcel.enforceInterface("com.juphoon.service.rcs.IRcsService");
                        int state = getState();
                        parcel2.writeNoException();
                        parcel2.writeInt(state);
                        return true;
                    case 4:
                        parcel.enforceInterface("com.juphoon.service.rcs.IRcsService");
                        boolean h22 = h2();
                        parcel2.writeNoException();
                        parcel2.writeInt(h22 ? 1 : 0);
                        return true;
                    case 5:
                        parcel.enforceInterface("com.juphoon.service.rcs.IRcsService");
                        boolean M32 = M3();
                        parcel2.writeNoException();
                        parcel2.writeInt(M32 ? 1 : 0);
                        return true;
                    case 6:
                        parcel.enforceInterface("com.juphoon.service.rcs.IRcsService");
                        if (parcel.readInt() != 0) {
                            z10 = true;
                        }
                        c1(z10);
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface("com.juphoon.service.rcs.IRcsService");
                        if (parcel.readInt() != 0) {
                            z10 = true;
                        }
                        M0(z10);
                        parcel2.writeNoException();
                        return true;
                    case 8:
                        parcel.enforceInterface("com.juphoon.service.rcs.IRcsService");
                        String D72 = D7();
                        parcel2.writeNoException();
                        parcel2.writeString(D72);
                        return true;
                    case 9:
                        parcel.enforceInterface("com.juphoon.service.rcs.IRcsService");
                        m0(IRcsCallback.Stub.N7(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 10:
                        parcel.enforceInterface("com.juphoon.service.rcs.IRcsService");
                        L6(IRcsCallback.Stub.N7(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 11:
                        parcel.enforceInterface("com.juphoon.service.rcs.IRcsService");
                        int o62 = o6();
                        parcel2.writeNoException();
                        parcel2.writeInt(o62);
                        return true;
                    case 12:
                        parcel.enforceInterface("com.juphoon.service.rcs.IRcsService");
                        y3();
                        parcel2.writeNoException();
                        return true;
                    case 13:
                        parcel.enforceInterface("com.juphoon.service.rcs.IRcsService");
                        boolean w42 = w4(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(w42 ? 1 : 0);
                        return true;
                    case 14:
                        parcel.enforceInterface("com.juphoon.service.rcs.IRcsService");
                        V6(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 15:
                        parcel.enforceInterface("com.juphoon.service.rcs.IRcsService");
                        S6(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 16:
                        parcel.enforceInterface("com.juphoon.service.rcs.IRcsService");
                        D0(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 17:
                        parcel.enforceInterface("com.juphoon.service.rcs.IRcsService");
                        int c62 = c6(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(c62);
                        return true;
                    case 18:
                        parcel.enforceInterface("com.juphoon.service.rcs.IRcsService");
                        e5(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 19:
                        parcel.enforceInterface("com.juphoon.service.rcs.IRcsService");
                        String A62 = A6();
                        parcel2.writeNoException();
                        parcel2.writeString(A62);
                        return true;
                    case 20:
                        parcel.enforceInterface("com.juphoon.service.rcs.IRcsService");
                        x0();
                        parcel2.writeNoException();
                        return true;
                    case 21:
                        parcel.enforceInterface("com.juphoon.service.rcs.IRcsService");
                        int z32 = z3(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(z32);
                        return true;
                    case 22:
                        parcel.enforceInterface("com.juphoon.service.rcs.IRcsService");
                        String d32 = d3();
                        parcel2.writeNoException();
                        parcel2.writeString(d32);
                        return true;
                    case 23:
                        parcel.enforceInterface("com.juphoon.service.rcs.IRcsService");
                        I5(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 24:
                        parcel.enforceInterface("com.juphoon.service.rcs.IRcsService");
                        String V22 = V2();
                        parcel2.writeNoException();
                        parcel2.writeString(V22);
                        return true;
                    default:
                        return super.onTransact(i10, parcel, parcel2, i11);
                }
            }
            parcel2.writeString("com.juphoon.service.rcs.IRcsService");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
