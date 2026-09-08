package com.ted.phonenumber.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.ted.phonenumber.entrys.RecognitionNumber;
import com.ted.phonenumber.entrys.RequestData;
import com.ted.phonenumber.service.INumCallback;
import java.util.List;

/* loaded from: classes4.dex */
public interface INumberService extends IInterface {
    RecognitionNumber C6(RequestData requestData);

    void G(String str, String str2, String str3, String str4, String str5);

    byte[] V(String str);

    void W2(RequestData requestData);

    String Y(String str);

    boolean d(String str);

    List<String> e();

    void h(String str, String str2, int i10, int i11);

    void i0(List<RequestData> list, INumListCallback iNumListCallback);

    RecognitionNumber p3(RequestData requestData);

    void s();

    String t(String str);

    void u(String str, List<String> list);

    List<String> w(List<String> list, long j10);

    RecognitionNumber y6(RequestData requestData, INumCallback iNumCallback);

    /* loaded from: classes4.dex */
    public static abstract class Stub extends Binder implements INumberService {

        /* loaded from: classes4.dex */
        public static class Proxy implements INumberService {

            /* renamed from: f, reason: collision with root package name */
            public IBinder f29916f;

            public Proxy(IBinder iBinder) {
                this.f29916f = iBinder;
            }

            @Override // com.ted.phonenumber.service.INumberService
            public RecognitionNumber C6(RequestData requestData) {
                RecognitionNumber recognitionNumber;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ted.number.service.INumberService");
                    if (requestData != null) {
                        obtain.writeInt(1);
                        requestData.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f29916f.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        recognitionNumber = RecognitionNumber.CREATOR.createFromParcel(obtain2);
                    } else {
                        recognitionNumber = null;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return recognitionNumber;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.ted.phonenumber.service.INumberService
            public byte[] V(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ted.number.service.INumberService");
                    obtain.writeString(str);
                    this.f29916f.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createByteArray();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f29916f;
            }

            @Override // com.ted.phonenumber.service.INumberService
            public void i0(List<RequestData> list, INumListCallback iNumListCallback) {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ted.number.service.INumberService");
                    obtain.writeTypedList(list);
                    if (iNumListCallback != null) {
                        iBinder = iNumListCallback.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f29916f.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    obtain2.recycle();
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.ted.number.service.INumberService");
        }

        public static INumberService N7(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ted.number.service.INumberService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof INumberService)) {
                return (INumberService) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 != 1598968902) {
                RequestData requestData = null;
                switch (i10) {
                    case 1:
                        parcel.enforceInterface("com.ted.number.service.INumberService");
                        boolean d10 = d(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(d10 ? 1 : 0);
                        return true;
                    case 2:
                        parcel.enforceInterface("com.ted.number.service.INumberService");
                        String Y9 = Y(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(Y9);
                        return true;
                    case 3:
                        parcel.enforceInterface("com.ted.number.service.INumberService");
                        List<String> e10 = e();
                        parcel2.writeNoException();
                        parcel2.writeStringList(e10);
                        return true;
                    case 4:
                        parcel.enforceInterface("com.ted.number.service.INumberService");
                        h(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("com.ted.number.service.INumberService");
                        G(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface("com.ted.number.service.INumberService");
                        if (parcel.readInt() != 0) {
                            requestData = RequestData.CREATOR.createFromParcel(parcel);
                        }
                        RecognitionNumber C62 = C6(requestData);
                        parcel2.writeNoException();
                        if (C62 != null) {
                            parcel2.writeInt(1);
                            C62.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 7:
                        parcel.enforceInterface("com.ted.number.service.INumberService");
                        if (parcel.readInt() != 0) {
                            requestData = RequestData.CREATOR.createFromParcel(parcel);
                        }
                        RecognitionNumber y62 = y6(requestData, INumCallback.Stub.N7(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        if (y62 != null) {
                            parcel2.writeInt(1);
                            y62.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 8:
                        parcel.enforceInterface("com.ted.number.service.INumberService");
                        s();
                        parcel2.writeNoException();
                        return true;
                    case 9:
                        parcel.enforceInterface("com.ted.number.service.INumberService");
                        if (parcel.readInt() != 0) {
                            requestData = RequestData.CREATOR.createFromParcel(parcel);
                        }
                        W2(requestData);
                        parcel2.writeNoException();
                        return true;
                    case 10:
                        parcel.enforceInterface("com.ted.number.service.INumberService");
                        String t10 = t(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(t10);
                        return true;
                    case 11:
                        parcel.enforceInterface("com.ted.number.service.INumberService");
                        List<String> w10 = w(parcel.createStringArrayList(), parcel.readLong());
                        parcel2.writeNoException();
                        parcel2.writeStringList(w10);
                        return true;
                    case 12:
                        parcel.enforceInterface("com.ted.number.service.INumberService");
                        if (parcel.readInt() != 0) {
                            requestData = RequestData.CREATOR.createFromParcel(parcel);
                        }
                        RecognitionNumber p32 = p3(requestData);
                        parcel2.writeNoException();
                        if (p32 != null) {
                            parcel2.writeInt(1);
                            p32.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 13:
                        parcel.enforceInterface("com.ted.number.service.INumberService");
                        u(parcel.readString(), parcel.createStringArrayList());
                        parcel2.writeNoException();
                        return true;
                    case 14:
                        parcel.enforceInterface("com.ted.number.service.INumberService");
                        byte[] V10 = V(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeByteArray(V10);
                        return true;
                    default:
                        return super.onTransact(i10, parcel, parcel2, i11);
                }
            }
            parcel2.writeString("com.ted.number.service.INumberService");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
