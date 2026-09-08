package com.oplus.tingle.ipc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes3.dex */
public interface IMaster extends IInterface {

    /* loaded from: classes3.dex */
    public static class Default implements IMaster {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    int i();

    /* loaded from: classes3.dex */
    public static abstract class Stub extends Binder implements IMaster {

        /* loaded from: classes3.dex */
        public static class Proxy implements IMaster {

            /* renamed from: f, reason: collision with root package name */
            public IBinder f29027f;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f29027f;
            }
        }

        public Stub() {
            attachInterface(this, "com.oplus.tingle.ipc.IMaster");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 != 1598968902) {
                if (i10 != 4) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                parcel.enforceInterface("com.oplus.tingle.ipc.IMaster");
                int i12 = i();
                parcel2.writeNoException();
                parcel2.writeInt(i12);
                return true;
            }
            parcel2.writeString("com.oplus.tingle.ipc.IMaster");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
