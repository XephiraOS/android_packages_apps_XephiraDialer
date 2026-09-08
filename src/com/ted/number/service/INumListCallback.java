package com.ted.number.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.ted.number.entrys.RecognitionNumber;
import java.util.List;

/* loaded from: classes4.dex */
public interface INumListCallback extends IInterface {
    void I(List<RecognitionNumber> list);

    void L();

    void v(List<RecognitionNumber> list);

    /* loaded from: classes4.dex */
    public static abstract class Stub extends Binder implements INumListCallback {

        /* loaded from: classes4.dex */
        public static class Proxy implements INumListCallback {

            /* renamed from: f, reason: collision with root package name */
            public IBinder f29696f;

            public Proxy(IBinder iBinder) {
                this.f29696f = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f29696f;
            }
        }

        public static INumListCallback N7(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ted.number.service.INumListCallback");
            if (queryLocalInterface != null && (queryLocalInterface instanceof INumListCallback)) {
                return (INumListCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        if (i10 != 1598968902) {
                            return super.onTransact(i10, parcel, parcel2, i11);
                        }
                        parcel2.writeString("com.ted.number.service.INumListCallback");
                        return true;
                    }
                    parcel.enforceInterface("com.ted.number.service.INumListCallback");
                    L();
                    parcel2.writeNoException();
                    return true;
                }
                parcel.enforceInterface("com.ted.number.service.INumListCallback");
                I(parcel.createTypedArrayList(RecognitionNumber.CREATOR));
                parcel2.writeNoException();
                return true;
            }
            parcel.enforceInterface("com.ted.number.service.INumListCallback");
            v(parcel.createTypedArrayList(RecognitionNumber.CREATOR));
            parcel2.writeNoException();
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
