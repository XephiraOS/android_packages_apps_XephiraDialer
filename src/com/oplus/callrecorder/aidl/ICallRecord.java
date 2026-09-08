package com.oplus.callrecorder.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.oplus.callrecorder.aidl.ICallRecordCallback;

/* loaded from: classes3.dex */
public interface ICallRecord extends IInterface {
    void F1();

    void G7(CallRecordParam callRecordParam);

    void T0(ICallRecordCallback iCallRecordCallback);

    void q3();

    /* loaded from: classes3.dex */
    public static class Default implements ICallRecord {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.oplus.callrecorder.aidl.ICallRecord
        public void q3() {
        }

        @Override // com.oplus.callrecorder.aidl.ICallRecord
        public void G7(CallRecordParam callRecordParam) {
        }

        @Override // com.oplus.callrecorder.aidl.ICallRecord
        public void T0(ICallRecordCallback iCallRecordCallback) {
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class Stub extends Binder implements ICallRecord {

        /* loaded from: classes3.dex */
        public static class Proxy implements ICallRecord {

            /* renamed from: g, reason: collision with root package name */
            public static ICallRecord f27750g;

            /* renamed from: f, reason: collision with root package name */
            public IBinder f27751f;

            public Proxy(IBinder iBinder) {
                this.f27751f = iBinder;
            }

            @Override // com.oplus.callrecorder.aidl.ICallRecord
            public void G7(CallRecordParam callRecordParam) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.oplus.callrecorder.aidl.ICallRecord");
                    if (callRecordParam != null) {
                        obtain.writeInt(1);
                        callRecordParam.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f27751f.transact(1, obtain, obtain2, 0) && Stub.O7() != null) {
                        Stub.O7().G7(callRecordParam);
                        obtain2.recycle();
                        obtain.recycle();
                    } else {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.oplus.callrecorder.aidl.ICallRecord
            public void T0(ICallRecordCallback iCallRecordCallback) {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.oplus.callrecorder.aidl.ICallRecord");
                    if (iCallRecordCallback != null) {
                        iBinder = iCallRecordCallback.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!this.f27751f.transact(3, obtain, obtain2, 0) && Stub.O7() != null) {
                        Stub.O7().T0(iCallRecordCallback);
                        obtain2.recycle();
                        obtain.recycle();
                    } else {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f27751f;
            }

            @Override // com.oplus.callrecorder.aidl.ICallRecord
            public void q3() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.oplus.callrecorder.aidl.ICallRecord");
                    if (!this.f27751f.transact(2, obtain, obtain2, 0) && Stub.O7() != null) {
                        Stub.O7().q3();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.oplus.callrecorder.aidl.ICallRecord");
        }

        public static ICallRecord N7(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.oplus.callrecorder.aidl.ICallRecord");
            if (queryLocalInterface != null && (queryLocalInterface instanceof ICallRecord)) {
                return (ICallRecord) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static ICallRecord O7() {
            return Proxy.f27750g;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            CallRecordParam callRecordParam;
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        if (i10 != 4) {
                            if (i10 != 1598968902) {
                                return super.onTransact(i10, parcel, parcel2, i11);
                            }
                            parcel2.writeString("com.oplus.callrecorder.aidl.ICallRecord");
                            return true;
                        }
                        parcel.enforceInterface("com.oplus.callrecorder.aidl.ICallRecord");
                        F1();
                        parcel2.writeNoException();
                        return true;
                    }
                    parcel.enforceInterface("com.oplus.callrecorder.aidl.ICallRecord");
                    T0(ICallRecordCallback.Stub.N7(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                }
                parcel.enforceInterface("com.oplus.callrecorder.aidl.ICallRecord");
                q3();
                parcel2.writeNoException();
                return true;
            }
            parcel.enforceInterface("com.oplus.callrecorder.aidl.ICallRecord");
            if (parcel.readInt() != 0) {
                callRecordParam = CallRecordParam.CREATOR.createFromParcel(parcel);
            } else {
                callRecordParam = null;
            }
            G7(callRecordParam);
            parcel2.writeNoException();
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
