package org.codeaurora.ims.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import org.codeaurora.ims.internal.IQtiImsExtListener;

/* loaded from: classes4.dex */
public interface IQtiImsExt extends IInterface {

    /* loaded from: classes4.dex */
    public static class Default implements IQtiImsExt {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    void B6(int i10, int i11, String str, IQtiImsExtListener iQtiImsExtListener);

    int H3(int i10, int i11);

    void M1(int i10, IQtiImsExtListener iQtiImsExtListener);

    int P1(int i10);

    int S0(int i10);

    void U3(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, String str, IQtiImsExtListener iQtiImsExtListener);

    void Y2(int i10, IQtiImsExtListener iQtiImsExtListener);

    int b6(int i10, int i11);

    void e7(int i10, int i11, IQtiImsExtListener iQtiImsExtListener);

    void g6(int i10, int i11, int i12, IQtiImsExtListener iQtiImsExtListener);

    void k1(int i10, IQtiImsExtListener iQtiImsExtListener);

    void o2(int i10, IQtiImsExtListener iQtiImsExtListener);

    void p6(int i10, int i11, IQtiImsExtListener iQtiImsExtListener);

    void t1(int i10, IQtiImsExtListener iQtiImsExtListener);

    void t4(int i10, int i11);

    void u5(int i10, IQtiImsExtListener iQtiImsExtListener);

    void u7(int i10, IQtiImsExtListener iQtiImsExtListener);

    void z4(int i10, IQtiImsExtListener iQtiImsExtListener);

    void z7(int i10, String str, IQtiImsExtListener iQtiImsExtListener);

    /* loaded from: classes4.dex */
    public static abstract class Stub extends Binder implements IQtiImsExt {

        /* loaded from: classes4.dex */
        public static class Proxy implements IQtiImsExt {

            /* renamed from: f, reason: collision with root package name */
            public IBinder f35875f;

            public Proxy(IBinder iBinder) {
                this.f35875f = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f35875f;
            }
        }

        public Stub() {
            attachInterface(this, "org.codeaurora.ims.internal.IQtiImsExt");
        }

        public static IQtiImsExt N7(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("org.codeaurora.ims.internal.IQtiImsExt");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IQtiImsExt)) {
                return (IQtiImsExt) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 != 1598968902) {
                switch (i10) {
                    case 1:
                        parcel.enforceInterface("org.codeaurora.ims.internal.IQtiImsExt");
                        U3(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString(), IQtiImsExtListener.Stub.asInterface(parcel.readStrongBinder()));
                        return true;
                    case 2:
                        parcel.enforceInterface("org.codeaurora.ims.internal.IQtiImsExt");
                        g6(parcel.readInt(), parcel.readInt(), parcel.readInt(), IQtiImsExtListener.Stub.asInterface(parcel.readStrongBinder()));
                        return true;
                    case 3:
                        parcel.enforceInterface("org.codeaurora.ims.internal.IQtiImsExt");
                        z4(parcel.readInt(), IQtiImsExtListener.Stub.asInterface(parcel.readStrongBinder()));
                        return true;
                    case 4:
                        parcel.enforceInterface("org.codeaurora.ims.internal.IQtiImsExt");
                        u7(parcel.readInt(), IQtiImsExtListener.Stub.asInterface(parcel.readStrongBinder()));
                        return true;
                    case 5:
                        parcel.enforceInterface("org.codeaurora.ims.internal.IQtiImsExt");
                        z7(parcel.readInt(), parcel.readString(), IQtiImsExtListener.Stub.asInterface(parcel.readStrongBinder()));
                        return true;
                    case 6:
                        parcel.enforceInterface("org.codeaurora.ims.internal.IQtiImsExt");
                        B6(parcel.readInt(), parcel.readInt(), parcel.readString(), IQtiImsExtListener.Stub.asInterface(parcel.readStrongBinder()));
                        return true;
                    case 7:
                        parcel.enforceInterface("org.codeaurora.ims.internal.IQtiImsExt");
                        Y2(parcel.readInt(), IQtiImsExtListener.Stub.asInterface(parcel.readStrongBinder()));
                        return true;
                    case 8:
                        parcel.enforceInterface("org.codeaurora.ims.internal.IQtiImsExt");
                        M1(parcel.readInt(), IQtiImsExtListener.Stub.asInterface(parcel.readStrongBinder()));
                        return true;
                    case 9:
                        parcel.enforceInterface("org.codeaurora.ims.internal.IQtiImsExt");
                        t1(parcel.readInt(), IQtiImsExtListener.Stub.asInterface(parcel.readStrongBinder()));
                        return true;
                    case 10:
                        parcel.enforceInterface("org.codeaurora.ims.internal.IQtiImsExt");
                        t4(parcel.readInt(), parcel.readInt());
                        return true;
                    case 11:
                        parcel.enforceInterface("org.codeaurora.ims.internal.IQtiImsExt");
                        u5(parcel.readInt(), IQtiImsExtListener.Stub.asInterface(parcel.readStrongBinder()));
                        return true;
                    case 12:
                        parcel.enforceInterface("org.codeaurora.ims.internal.IQtiImsExt");
                        p6(parcel.readInt(), parcel.readInt(), IQtiImsExtListener.Stub.asInterface(parcel.readStrongBinder()));
                        return true;
                    case 13:
                        parcel.enforceInterface("org.codeaurora.ims.internal.IQtiImsExt");
                        k1(parcel.readInt(), IQtiImsExtListener.Stub.asInterface(parcel.readStrongBinder()));
                        return true;
                    case 14:
                        parcel.enforceInterface("org.codeaurora.ims.internal.IQtiImsExt");
                        o2(parcel.readInt(), IQtiImsExtListener.Stub.asInterface(parcel.readStrongBinder()));
                        return true;
                    case 15:
                        parcel.enforceInterface("org.codeaurora.ims.internal.IQtiImsExt");
                        e7(parcel.readInt(), parcel.readInt(), IQtiImsExtListener.Stub.asInterface(parcel.readStrongBinder()));
                        return true;
                    case 16:
                        parcel.enforceInterface("org.codeaurora.ims.internal.IQtiImsExt");
                        int P12 = P1(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(P12);
                        return true;
                    case 17:
                        parcel.enforceInterface("org.codeaurora.ims.internal.IQtiImsExt");
                        int H32 = H3(parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(H32);
                        return true;
                    case 18:
                        parcel.enforceInterface("org.codeaurora.ims.internal.IQtiImsExt");
                        int S02 = S0(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(S02);
                        return true;
                    case 19:
                        parcel.enforceInterface("org.codeaurora.ims.internal.IQtiImsExt");
                        int b62 = b6(parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(b62);
                        return true;
                    default:
                        return super.onTransact(i10, parcel, parcel2, i11);
                }
            }
            parcel2.writeString("org.codeaurora.ims.internal.IQtiImsExt");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
