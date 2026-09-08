package com.ted.number.service;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.android.incallui.Log;
import com.ted.number.entrys.RecognitionNumber;
import com.ted.number.entrys.RequestData;
import com.ted.number.service.INumCallback;
import com.ted.number.service.INumListCallback;
import java.util.List;

/* loaded from: classes4.dex */
public interface INumberService extends IInterface {
    RecognitionNumber D6(RequestData requestData);

    void G(String str, String str2, String str3, String str4, String str5);

    void H1(String str, String str2, String str3, String str4);

    void K6(RequestData requestData, INumCallback iNumCallback);

    void M4(String str, String str2, int i10, int i11, int i12);

    RecognitionNumber R6(RequestData requestData, Bundle bundle, INumCallback iNumCallback);

    byte[] V(String str);

    String Y(String str);

    boolean d(String str);

    List<String> e();

    void e2(RequestData requestData);

    void h(String str, String str2, int i10, int i11);

    RecognitionNumber k2(RequestData requestData, INumCallback iNumCallback);

    void n7(List<RequestData> list, INumListCallback iNumListCallback);

    void s();

    RecognitionNumber s2(RequestData requestData);

    String t(String str);

    void u(String str, List<String> list);

    List<String> w(List<String> list, long j10);

    /* loaded from: classes4.dex */
    public static abstract class Stub extends Binder implements INumberService {

        /* loaded from: classes4.dex */
        public static class Proxy implements INumberService {

            /* renamed from: f, reason: collision with root package name */
            public IBinder f29697f;

            public Proxy(IBinder iBinder) {
                this.f29697f = iBinder;
            }

            @Override // com.ted.number.service.INumberService
            public RecognitionNumber R6(RequestData requestData, Bundle bundle, INumCallback iNumCallback) {
                IBinder iBinder;
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
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    RecognitionNumber recognitionNumber = null;
                    if (iNumCallback != null) {
                        iBinder = iNumCallback.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f29697f.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        recognitionNumber = RecognitionNumber.CREATOR.createFromParcel(obtain2);
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

            @Override // com.ted.number.service.INumberService
            public byte[] V(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ted.number.service.INumberService");
                    obtain.writeString(str);
                    this.f29697f.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createByteArray();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f29697f;
            }
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
            RequestData requestData;
            if (i10 != 1598968902) {
                RequestData requestData2 = null;
                Bundle bundle = null;
                RequestData requestData3 = null;
                RequestData requestData4 = null;
                RequestData requestData5 = null;
                RequestData requestData6 = null;
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
                            requestData2 = RequestData.CREATOR.createFromParcel(parcel);
                        }
                        RecognitionNumber D62 = D6(requestData2);
                        parcel2.writeNoException();
                        if (D62 != null) {
                            parcel2.writeInt(1);
                            D62.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 7:
                        parcel.enforceInterface("com.ted.number.service.INumberService");
                        if (parcel.readInt() != 0) {
                            requestData6 = RequestData.CREATOR.createFromParcel(parcel);
                        }
                        INumCallback N72 = INumCallback.Stub.N7(parcel.readStrongBinder());
                        Log.e("XXX", "query11 -arg1=" + N72);
                        RecognitionNumber k22 = k2(requestData6, N72);
                        parcel2.writeNoException();
                        if (k22 != null) {
                            parcel2.writeInt(1);
                            k22.writeToParcel(parcel2, 1);
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
                            requestData5 = RequestData.CREATOR.createFromParcel(parcel);
                        }
                        e2(requestData5);
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
                            requestData4 = RequestData.CREATOR.createFromParcel(parcel);
                        }
                        RecognitionNumber s22 = s2(requestData4);
                        parcel2.writeNoException();
                        if (s22 != null) {
                            parcel2.writeInt(1);
                            s22.writeToParcel(parcel2, 1);
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
                    case 15:
                        parcel.enforceInterface("com.ted.number.service.INumberService");
                        H1(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 16:
                        parcel.enforceInterface("com.ted.number.service.INumberService");
                        n7(parcel.createTypedArrayList(RequestData.CREATOR), INumListCallback.Stub.N7(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 17:
                        parcel.enforceInterface("com.ted.number.service.INumberService");
                        M4(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 18:
                        parcel.enforceInterface("com.ted.number.service.INumberService");
                        if (parcel.readInt() != 0) {
                            requestData3 = RequestData.CREATOR.createFromParcel(parcel);
                        }
                        K6(requestData3, INumCallback.Stub.N7(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 19:
                        parcel.enforceInterface("com.ted.number.service.INumberService");
                        if (parcel.readInt() != 0) {
                            requestData = RequestData.CREATOR.createFromParcel(parcel);
                        } else {
                            requestData = null;
                        }
                        if (parcel.readInt() != 0) {
                            bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        RecognitionNumber R62 = R6(requestData, bundle, INumCallback.Stub.N7(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        if (R62 != null) {
                            parcel2.writeInt(1);
                            R62.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
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
