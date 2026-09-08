package com.juphoon.service.rcs;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes3.dex */
public interface IRcsCallback extends IInterface {
    void m1(String str, String str2);

    /* loaded from: classes3.dex */
    public static abstract class Stub extends Binder implements IRcsCallback {

        /* loaded from: classes3.dex */
        public static class Proxy implements IRcsCallback {

            /* renamed from: f, reason: collision with root package name */
            public IBinder f25574f;

            public Proxy(IBinder iBinder) {
                this.f25574f = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f25574f;
            }
        }

        public Stub() {
            attachInterface(this, "com.juphoon.service.rcs.IRcsCallback");
        }

        public static IRcsCallback N7(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.juphoon.service.rcs.IRcsCallback");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IRcsCallback)) {
                return (IRcsCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 != 1) {
                if (i10 != 1598968902) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                parcel2.writeString("com.juphoon.service.rcs.IRcsCallback");
                return true;
            }
            parcel.enforceInterface("com.juphoon.service.rcs.IRcsCallback");
            m1(parcel.readString(), parcel.readString());
            parcel2.writeNoException();
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
