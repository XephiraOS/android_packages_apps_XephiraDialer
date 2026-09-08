package com.juphoon.service.cap;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.List;

/* loaded from: classes3.dex */
public interface IRcsCapService extends IInterface {
    int h5(String str);

    int l2(List<String> list);

    /* loaded from: classes3.dex */
    public static abstract class Stub extends Binder implements IRcsCapService {

        /* loaded from: classes3.dex */
        public static class Proxy implements IRcsCapService {

            /* renamed from: f, reason: collision with root package name */
            public IBinder f25571f;

            public Proxy(IBinder iBinder) {
                this.f25571f = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f25571f;
            }

            @Override // com.juphoon.service.cap.IRcsCapService
            public int h5(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.juphoon.service.cap.IRcsCapService");
                    obtain.writeString(str);
                    this.f25571f.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.juphoon.service.cap.IRcsCapService");
        }

        public static IRcsCapService N7(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.juphoon.service.cap.IRcsCapService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IRcsCapService)) {
                return (IRcsCapService) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 1598968902) {
                        return super.onTransact(i10, parcel, parcel2, i11);
                    }
                    parcel2.writeString("com.juphoon.service.cap.IRcsCapService");
                    return true;
                }
                parcel.enforceInterface("com.juphoon.service.cap.IRcsCapService");
                int l22 = l2(parcel.createStringArrayList());
                parcel2.writeNoException();
                parcel2.writeInt(l22);
                return true;
            }
            parcel.enforceInterface("com.juphoon.service.cap.IRcsCapService");
            int h52 = h5(parcel.readString());
            parcel2.writeNoException();
            parcel2.writeInt(h52);
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
