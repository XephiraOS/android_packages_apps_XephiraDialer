package com.heytap.accessory.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.heytap.accessory.bean.DeviceInfo;
import java.util.List;

/* loaded from: classes3.dex */
public interface INsdDevicesCallback extends IInterface {

    /* loaded from: classes3.dex */
    public static class a {
        public static <T extends Parcelable> void b(Parcel parcel, List<T> list, int i10) {
            if (list == null) {
                parcel.writeInt(-1);
                return;
            }
            int size = list.size();
            parcel.writeInt(size);
            for (int i11 = 0; i11 < size; i11++) {
                c(parcel, list.get(i11), i10);
            }
        }

        public static <T extends Parcelable> void c(Parcel parcel, T t10, int i10) {
            if (t10 != null) {
                parcel.writeInt(1);
                t10.writeToParcel(parcel, i10);
            } else {
                parcel.writeInt(0);
            }
        }
    }

    void L1(List<DeviceInfo> list);

    /* loaded from: classes3.dex */
    public static abstract class Stub extends Binder implements INsdDevicesCallback {

        /* loaded from: classes3.dex */
        public static class Proxy implements INsdDevicesCallback {

            /* renamed from: f, reason: collision with root package name */
            public IBinder f25193f;

            public Proxy(IBinder iBinder) {
                this.f25193f = iBinder;
            }

            @Override // com.heytap.accessory.api.INsdDevicesCallback
            public void L1(List<DeviceInfo> list) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.INsdDevicesCallback");
                    a.b(obtain, list, 0);
                    this.f25193f.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f25193f;
            }
        }

        public Stub() {
            attachInterface(this, "com.heytap.accessory.api.INsdDevicesCallback");
        }

        public static INsdDevicesCallback N7(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.accessory.api.INsdDevicesCallback");
            if (queryLocalInterface != null && (queryLocalInterface instanceof INsdDevicesCallback)) {
                return (INsdDevicesCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface("com.heytap.accessory.api.INsdDevicesCallback");
            }
            if (i10 != 1598968902) {
                if (i10 != 1) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                L1(parcel.createTypedArrayList(DeviceInfo.CREATOR));
                parcel2.writeNoException();
                return true;
            }
            parcel2.writeString("com.heytap.accessory.api.INsdDevicesCallback");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public static class Default implements INsdDevicesCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.heytap.accessory.api.INsdDevicesCallback
        public void L1(List<DeviceInfo> list) {
        }
    }
}
