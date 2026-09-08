package com.heytap.accessory.api;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.heytap.accessory.api.IDirectPairCallback;
import com.heytap.accessory.api.IDisPairCallback;
import com.heytap.accessory.api.IDisScanCallback;
import com.heytap.accessory.api.ILanCacheIpServiceCallback;
import com.heytap.accessory.api.INsdDevicesCallback;
import com.heytap.accessory.api.IPermissionCallback;
import com.heytap.accessory.api.IQRCodeContentCallback;
import com.heytap.accessory.bean.DeviceInfo;
import com.heytap.accessory.bean.DirectPairInfo;
import com.heytap.accessory.bean.Message;
import com.heytap.accessory.bean.PairSetting;
import com.heytap.accessory.bean.ScanSetting;

/* loaded from: classes3.dex */
public interface ICentralService extends IInterface {

    /* loaded from: classes3.dex */
    public static class a {
        public static <T> T c(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        public static <T extends Parcelable> void d(Parcel parcel, T t10, int i10) {
            if (t10 != null) {
                parcel.writeInt(1);
                t10.writeToParcel(parcel, i10);
            } else {
                parcel.writeInt(0);
            }
        }
    }

    int J0(DeviceInfo deviceInfo);

    int M2(DirectPairInfo directPairInfo, IDirectPairCallback iDirectPairCallback);

    void Q(Bundle bundle);

    String Q0(int i10, String str, String str2);

    Message W5(ScanSetting scanSetting, Bundle bundle, IDisScanCallback iDisScanCallback);

    void Y1(int i10, boolean z10, long j10);

    int Y3(PairSetting pairSetting, DeviceInfo deviceInfo, IDisPairCallback iDisPairCallback);

    void a3(DeviceInfo deviceInfo);

    boolean a6(int i10);

    void a7(IPermissionCallback iPermissionCallback);

    boolean c2(boolean z10);

    int c5(boolean z10, IDisScanCallback iDisScanCallback);

    void d0();

    void i1(Bundle bundle, IQRCodeContentCallback iQRCodeContentCallback);

    void j7(int i10);

    void k0(int i10, boolean z10);

    int l7();

    int m4(ScanSetting scanSetting, Bundle bundle, IDisScanCallback iDisScanCallback);

    void s0(String str, ILanCacheIpServiceCallback iLanCacheIpServiceCallback);

    void w2(INsdDevicesCallback iNsdDevicesCallback);

    /* loaded from: classes3.dex */
    public static class Default implements ICentralService {
        @Override // com.heytap.accessory.api.ICentralService
        public int J0(DeviceInfo deviceInfo) {
            return 0;
        }

        @Override // com.heytap.accessory.api.ICentralService
        public int M2(DirectPairInfo directPairInfo, IDirectPairCallback iDirectPairCallback) {
            return 0;
        }

        @Override // com.heytap.accessory.api.ICentralService
        public String Q0(int i10, String str, String str2) {
            return null;
        }

        @Override // com.heytap.accessory.api.ICentralService
        public Message W5(ScanSetting scanSetting, Bundle bundle, IDisScanCallback iDisScanCallback) {
            return null;
        }

        @Override // com.heytap.accessory.api.ICentralService
        public int Y3(PairSetting pairSetting, DeviceInfo deviceInfo, IDisPairCallback iDisPairCallback) {
            return 0;
        }

        @Override // com.heytap.accessory.api.ICentralService
        public boolean a6(int i10) {
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.heytap.accessory.api.ICentralService
        public boolean c2(boolean z10) {
            return false;
        }

        @Override // com.heytap.accessory.api.ICentralService
        public int c5(boolean z10, IDisScanCallback iDisScanCallback) {
            return 0;
        }

        @Override // com.heytap.accessory.api.ICentralService
        public int l7() {
            return 0;
        }

        @Override // com.heytap.accessory.api.ICentralService
        public int m4(ScanSetting scanSetting, Bundle bundle, IDisScanCallback iDisScanCallback) {
            return 0;
        }

        @Override // com.heytap.accessory.api.ICentralService
        public void d0() {
        }

        @Override // com.heytap.accessory.api.ICentralService
        public void Q(Bundle bundle) {
        }

        @Override // com.heytap.accessory.api.ICentralService
        public void a3(DeviceInfo deviceInfo) {
        }

        @Override // com.heytap.accessory.api.ICentralService
        public void a7(IPermissionCallback iPermissionCallback) {
        }

        @Override // com.heytap.accessory.api.ICentralService
        public void j7(int i10) {
        }

        @Override // com.heytap.accessory.api.ICentralService
        public void w2(INsdDevicesCallback iNsdDevicesCallback) {
        }

        @Override // com.heytap.accessory.api.ICentralService
        public void i1(Bundle bundle, IQRCodeContentCallback iQRCodeContentCallback) {
        }

        @Override // com.heytap.accessory.api.ICentralService
        public void k0(int i10, boolean z10) {
        }

        @Override // com.heytap.accessory.api.ICentralService
        public void s0(String str, ILanCacheIpServiceCallback iLanCacheIpServiceCallback) {
        }

        @Override // com.heytap.accessory.api.ICentralService
        public void Y1(int i10, boolean z10, long j10) {
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class Stub extends Binder implements ICentralService {

        /* loaded from: classes3.dex */
        public static class Proxy implements ICentralService {

            /* renamed from: f, reason: collision with root package name */
            public IBinder f25183f;

            public Proxy(IBinder iBinder) {
                this.f25183f = iBinder;
            }

            @Override // com.heytap.accessory.api.ICentralService
            public int J0(DeviceInfo deviceInfo) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.ICentralService");
                    a.d(obtain, deviceInfo, 0);
                    this.f25183f.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    if (obtain2.readInt() != 0) {
                        deviceInfo.readFromParcel(obtain2);
                    }
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.ICentralService
            public int M2(DirectPairInfo directPairInfo, IDirectPairCallback iDirectPairCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.ICentralService");
                    a.d(obtain, directPairInfo, 0);
                    obtain.writeStrongInterface(iDirectPairCallback);
                    this.f25183f.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.ICentralService
            public void Q(Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.ICentralService");
                    a.d(obtain, bundle, 0);
                    this.f25183f.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.ICentralService
            public String Q0(int i10, String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.ICentralService");
                    obtain.writeInt(i10);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f25183f.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.ICentralService
            public Message W5(ScanSetting scanSetting, Bundle bundle, IDisScanCallback iDisScanCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.ICentralService");
                    a.d(obtain, scanSetting, 0);
                    a.d(obtain, bundle, 0);
                    obtain.writeStrongInterface(iDisScanCallback);
                    this.f25183f.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    return (Message) a.c(obtain2, Message.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.ICentralService
            public void Y1(int i10, boolean z10, long j10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.ICentralService");
                    obtain.writeInt(i10);
                    obtain.writeInt(z10 ? 1 : 0);
                    obtain.writeLong(j10);
                    this.f25183f.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.ICentralService
            public int Y3(PairSetting pairSetting, DeviceInfo deviceInfo, IDisPairCallback iDisPairCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.ICentralService");
                    a.d(obtain, pairSetting, 0);
                    a.d(obtain, deviceInfo, 0);
                    obtain.writeStrongInterface(iDisPairCallback);
                    this.f25183f.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    if (obtain2.readInt() != 0) {
                        deviceInfo.readFromParcel(obtain2);
                    }
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.ICentralService
            public void a3(DeviceInfo deviceInfo) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.ICentralService");
                    a.d(obtain, deviceInfo, 0);
                    this.f25183f.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        deviceInfo.readFromParcel(obtain2);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.ICentralService
            public boolean a6(int i10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.ICentralService");
                    obtain.writeInt(i10);
                    boolean z10 = false;
                    this.f25183f.transact(7, obtain, obtain2, 0);
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

            @Override // com.heytap.accessory.api.ICentralService
            public void a7(IPermissionCallback iPermissionCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.ICentralService");
                    obtain.writeStrongInterface(iPermissionCallback);
                    this.f25183f.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f25183f;
            }

            @Override // com.heytap.accessory.api.ICentralService
            public boolean c2(boolean z10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.ICentralService");
                    obtain.writeInt(z10 ? 1 : 0);
                    boolean z11 = false;
                    this.f25183f.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z11 = true;
                    }
                    return z11;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.ICentralService
            public int c5(boolean z10, IDisScanCallback iDisScanCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.ICentralService");
                    obtain.writeInt(z10 ? 1 : 0);
                    obtain.writeStrongInterface(iDisScanCallback);
                    this.f25183f.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.ICentralService
            public void d0() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.ICentralService");
                    this.f25183f.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.ICentralService
            public void i1(Bundle bundle, IQRCodeContentCallback iQRCodeContentCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.ICentralService");
                    a.d(obtain, bundle, 0);
                    obtain.writeStrongInterface(iQRCodeContentCallback);
                    this.f25183f.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.ICentralService
            public void j7(int i10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.ICentralService");
                    obtain.writeInt(i10);
                    this.f25183f.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.ICentralService
            public void k0(int i10, boolean z10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.ICentralService");
                    obtain.writeInt(i10);
                    obtain.writeInt(z10 ? 1 : 0);
                    this.f25183f.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.ICentralService
            public int l7() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.ICentralService");
                    this.f25183f.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.ICentralService
            public int m4(ScanSetting scanSetting, Bundle bundle, IDisScanCallback iDisScanCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.ICentralService");
                    a.d(obtain, scanSetting, 0);
                    a.d(obtain, bundle, 0);
                    obtain.writeStrongInterface(iDisScanCallback);
                    this.f25183f.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.ICentralService
            public void s0(String str, ILanCacheIpServiceCallback iLanCacheIpServiceCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.ICentralService");
                    obtain.writeString(str);
                    obtain.writeStrongInterface(iLanCacheIpServiceCallback);
                    this.f25183f.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.ICentralService
            public void w2(INsdDevicesCallback iNsdDevicesCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.ICentralService");
                    obtain.writeStrongInterface(iNsdDevicesCallback);
                    this.f25183f.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.heytap.accessory.api.ICentralService");
        }

        public static ICentralService N7(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.accessory.api.ICentralService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof ICentralService)) {
                return (ICentralService) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface("com.heytap.accessory.api.ICentralService");
            }
            if (i10 != 1598968902) {
                boolean z10 = false;
                switch (i10) {
                    case 1:
                        int m42 = m4((ScanSetting) a.c(parcel, ScanSetting.CREATOR), (Bundle) a.c(parcel, Bundle.CREATOR), IDisScanCallback.Stub.N7(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(m42);
                        return true;
                    case 2:
                        d0();
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        PairSetting pairSetting = (PairSetting) a.c(parcel, PairSetting.CREATOR);
                        DeviceInfo deviceInfo = (DeviceInfo) a.c(parcel, DeviceInfo.CREATOR);
                        int Y32 = Y3(pairSetting, deviceInfo, IDisPairCallback.Stub.N7(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(Y32);
                        a.d(parcel2, deviceInfo, 1);
                        return true;
                    case 4:
                        DeviceInfo deviceInfo2 = (DeviceInfo) a.c(parcel, DeviceInfo.CREATOR);
                        a3(deviceInfo2);
                        parcel2.writeNoException();
                        a.d(parcel2, deviceInfo2, 1);
                        return true;
                    case 5:
                        int readInt = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            z10 = true;
                        }
                        k0(readInt, z10);
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        DeviceInfo deviceInfo3 = (DeviceInfo) a.c(parcel, DeviceInfo.CREATOR);
                        int J02 = J0(deviceInfo3);
                        parcel2.writeNoException();
                        parcel2.writeInt(J02);
                        a.d(parcel2, deviceInfo3, 1);
                        return true;
                    case 7:
                        boolean a62 = a6(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(a62 ? 1 : 0);
                        return true;
                    case 8:
                        int M22 = M2((DirectPairInfo) a.c(parcel, DirectPairInfo.CREATOR), IDirectPairCallback.Stub.N7(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(M22);
                        return true;
                    case 9:
                        a7(IPermissionCallback.Stub.N7(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 10:
                        s0(parcel.readString(), ILanCacheIpServiceCallback.Stub.N7(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 11:
                        w2(INsdDevicesCallback.Stub.N7(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 12:
                        Q((Bundle) a.c(parcel, Bundle.CREATOR));
                        parcel2.writeNoException();
                        return true;
                    case 13:
                        if (parcel.readInt() != 0) {
                            z10 = true;
                        }
                        int c52 = c5(z10, IDisScanCallback.Stub.N7(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(c52);
                        return true;
                    case 14:
                        int l72 = l7();
                        parcel2.writeNoException();
                        parcel2.writeInt(l72);
                        return true;
                    case 15:
                        i1((Bundle) a.c(parcel, Bundle.CREATOR), IQRCodeContentCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 16:
                        Message W52 = W5((ScanSetting) a.c(parcel, ScanSetting.CREATOR), (Bundle) a.c(parcel, Bundle.CREATOR), IDisScanCallback.Stub.N7(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        a.d(parcel2, W52, 1);
                        return true;
                    case 17:
                        j7(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 18:
                        if (parcel.readInt() != 0) {
                            z10 = true;
                        }
                        boolean c22 = c2(z10);
                        parcel2.writeNoException();
                        parcel2.writeInt(c22 ? 1 : 0);
                        return true;
                    case 19:
                        int readInt2 = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            z10 = true;
                        }
                        Y1(readInt2, z10, parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 20:
                        String Q02 = Q0(parcel.readInt(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(Q02);
                        return true;
                    default:
                        return super.onTransact(i10, parcel, parcel2, i11);
                }
            }
            parcel2.writeString("com.heytap.accessory.api.ICentralService");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
