package org.codeaurora.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import org.codeaurora.internal.IDepersoResCallback;
import org.codeaurora.internal.IDsda;

/* loaded from: classes4.dex */
public interface IExtTelephony extends IInterface {

    /* loaded from: classes4.dex */
    public static class Default implements IExtTelephony {
        @Override // org.codeaurora.internal.IExtTelephony
        public boolean Q2(String str) {
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    int A3(int i10);

    boolean D3();

    void F(int i10);

    void F0(IDsda iDsda);

    boolean H6();

    boolean Q2(String str);

    int S3();

    boolean S5();

    boolean W4(String str);

    int X6(int i10);

    boolean b0(String str);

    void b4(boolean z10);

    boolean f6();

    int j();

    int m6(int i10);

    int n3();

    void o0(String str, String str2, IDepersoResCallback iDepersoResCallback, int i10);

    boolean q5(int i10, boolean z10);

    int t2(int i10);

    void v6(int i10);

    boolean x5(String str);

    /* loaded from: classes4.dex */
    public static abstract class Stub extends Binder implements IExtTelephony {

        /* loaded from: classes4.dex */
        public static class Proxy implements IExtTelephony {

            /* renamed from: g, reason: collision with root package name */
            public static IExtTelephony f35880g;

            /* renamed from: f, reason: collision with root package name */
            public IBinder f35881f;

            public Proxy(IBinder iBinder) {
                this.f35881f = iBinder;
            }

            @Override // org.codeaurora.internal.IExtTelephony
            public boolean Q2(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("org.codeaurora.internal.IExtTelephony");
                    obtain.writeString(str);
                    boolean z10 = false;
                    if (!this.f35881f.transact(11, obtain, obtain2, 0) && Stub.O7() != null) {
                        return Stub.O7().Q2(str);
                    }
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

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f35881f;
            }
        }

        public Stub() {
            attachInterface(this, "org.codeaurora.internal.IExtTelephony");
        }

        public static IExtTelephony N7(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("org.codeaurora.internal.IExtTelephony");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IExtTelephony)) {
                return (IExtTelephony) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static IExtTelephony O7() {
            return Proxy.f35880g;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 != 1598968902) {
                boolean z10 = false;
                switch (i10) {
                    case 1:
                        parcel.enforceInterface("org.codeaurora.internal.IExtTelephony");
                        int t22 = t2(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(t22);
                        return true;
                    case 2:
                        parcel.enforceInterface("org.codeaurora.internal.IExtTelephony");
                        int A32 = A3(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(A32);
                        return true;
                    case 3:
                        parcel.enforceInterface("org.codeaurora.internal.IExtTelephony");
                        int X62 = X6(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(X62);
                        return true;
                    case 4:
                        parcel.enforceInterface("org.codeaurora.internal.IExtTelephony");
                        int m62 = m6(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(m62);
                        return true;
                    case 5:
                        parcel.enforceInterface("org.codeaurora.internal.IExtTelephony");
                        boolean H62 = H6();
                        parcel2.writeNoException();
                        parcel2.writeInt(H62 ? 1 : 0);
                        return true;
                    case 6:
                        parcel.enforceInterface("org.codeaurora.internal.IExtTelephony");
                        if (parcel.readInt() != 0) {
                            z10 = true;
                        }
                        b4(z10);
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface("org.codeaurora.internal.IExtTelephony");
                        int n32 = n3();
                        parcel2.writeNoException();
                        parcel2.writeInt(n32);
                        return true;
                    case 8:
                        parcel.enforceInterface("org.codeaurora.internal.IExtTelephony");
                        v6(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 9:
                        parcel.enforceInterface("org.codeaurora.internal.IExtTelephony");
                        boolean S52 = S5();
                        parcel2.writeNoException();
                        parcel2.writeInt(S52 ? 1 : 0);
                        return true;
                    case 10:
                        parcel.enforceInterface("org.codeaurora.internal.IExtTelephony");
                        int S32 = S3();
                        parcel2.writeNoException();
                        parcel2.writeInt(S32);
                        return true;
                    case 11:
                        parcel.enforceInterface("org.codeaurora.internal.IExtTelephony");
                        boolean Q22 = Q2(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(Q22 ? 1 : 0);
                        return true;
                    case 12:
                        parcel.enforceInterface("org.codeaurora.internal.IExtTelephony");
                        boolean x52 = x5(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(x52 ? 1 : 0);
                        return true;
                    case 13:
                        parcel.enforceInterface("org.codeaurora.internal.IExtTelephony");
                        boolean W42 = W4(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(W42 ? 1 : 0);
                        return true;
                    case 14:
                        parcel.enforceInterface("org.codeaurora.internal.IExtTelephony");
                        boolean b02 = b0(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(b02 ? 1 : 0);
                        return true;
                    case 15:
                        parcel.enforceInterface("org.codeaurora.internal.IExtTelephony");
                        boolean f62 = f6();
                        parcel2.writeNoException();
                        parcel2.writeInt(f62 ? 1 : 0);
                        return true;
                    case 16:
                        parcel.enforceInterface("org.codeaurora.internal.IExtTelephony");
                        int readInt = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            z10 = true;
                        }
                        boolean q52 = q5(readInt, z10);
                        parcel2.writeNoException();
                        parcel2.writeInt(q52 ? 1 : 0);
                        return true;
                    case 17:
                        parcel.enforceInterface("org.codeaurora.internal.IExtTelephony");
                        F(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 18:
                        parcel.enforceInterface("org.codeaurora.internal.IExtTelephony");
                        F0(IDsda.Stub.N7(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 19:
                        parcel.enforceInterface("org.codeaurora.internal.IExtTelephony");
                        int j10 = j();
                        parcel2.writeNoException();
                        parcel2.writeInt(j10);
                        return true;
                    case 20:
                        parcel.enforceInterface("org.codeaurora.internal.IExtTelephony");
                        boolean D32 = D3();
                        parcel2.writeNoException();
                        parcel2.writeInt(D32 ? 1 : 0);
                        return true;
                    case 21:
                        parcel.enforceInterface("org.codeaurora.internal.IExtTelephony");
                        o0(parcel.readString(), parcel.readString(), IDepersoResCallback.Stub.N7(parcel.readStrongBinder()), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i10, parcel, parcel2, i11);
                }
            }
            parcel2.writeString("org.codeaurora.internal.IExtTelephony");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
