package com.oplus.callrecorder.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes3.dex */
public interface ICallRecordCallback extends IInterface {

    /* loaded from: classes3.dex */
    public static class Default implements ICallRecordCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    void I1(int i10, int i11, String str, String str2);

    void O6(String str);

    void i4(int i10);

    void u4(String str);

    /* loaded from: classes3.dex */
    public static abstract class Stub extends Binder implements ICallRecordCallback {

        /* loaded from: classes3.dex */
        public static class Proxy implements ICallRecordCallback {

            /* renamed from: f, reason: collision with root package name */
            public IBinder f27752f;

            public Proxy(IBinder iBinder) {
                this.f27752f = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f27752f;
            }
        }

        public Stub() {
            attachInterface(this, "com.oplus.callrecorder.aidl.ICallRecordCallback");
        }

        public static ICallRecordCallback N7(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.oplus.callrecorder.aidl.ICallRecordCallback");
            if (queryLocalInterface != null && (queryLocalInterface instanceof ICallRecordCallback)) {
                return (ICallRecordCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        if (i10 != 4) {
                            if (i10 != 1598968902) {
                                return super.onTransact(i10, parcel, parcel2, i11);
                            }
                            parcel2.writeString("com.oplus.callrecorder.aidl.ICallRecordCallback");
                            return true;
                        }
                        parcel.enforceInterface("com.oplus.callrecorder.aidl.ICallRecordCallback");
                        I1(parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    }
                    parcel.enforceInterface("com.oplus.callrecorder.aidl.ICallRecordCallback");
                    i4(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                }
                parcel.enforceInterface("com.oplus.callrecorder.aidl.ICallRecordCallback");
                O6(parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            parcel.enforceInterface("com.oplus.callrecorder.aidl.ICallRecordCallback");
            u4(parcel.readString());
            parcel2.writeNoException();
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
