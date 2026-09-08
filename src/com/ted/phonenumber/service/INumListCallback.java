package com.ted.phonenumber.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.ted.phonenumber.entrys.RecognitionNumber;
import java.util.List;

/* loaded from: classes4.dex */
public interface INumListCallback extends IInterface {

    /* loaded from: classes4.dex */
    public static class Default implements INumListCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    void I(List<RecognitionNumber> list);

    void L();

    void v(List<RecognitionNumber> list);

    /* loaded from: classes4.dex */
    public static abstract class Stub extends Binder implements INumListCallback {

        /* loaded from: classes4.dex */
        public static class Proxy implements INumListCallback {

            /* renamed from: f, reason: collision with root package name */
            public IBinder f29915f;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f29915f;
            }
        }

        public Stub() {
            attachInterface(this, "com.ted.number.service.INumListCallback");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 != 1598968902) {
                if (i10 != 1) {
                    if (i10 != 2) {
                        if (i10 != 3) {
                            return super.onTransact(i10, parcel, parcel2, i11);
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
            parcel2.writeString("com.ted.number.service.INumListCallback");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
