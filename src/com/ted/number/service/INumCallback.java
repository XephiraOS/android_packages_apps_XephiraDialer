package com.ted.number.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.ted.number.entrys.RecognitionNumber;

/* loaded from: classes4.dex */
public interface INumCallback extends IInterface {
    void C1(RecognitionNumber recognitionNumber);

    void b();

    /* loaded from: classes4.dex */
    public static abstract class Stub extends Binder implements INumCallback {

        /* loaded from: classes4.dex */
        public static class Proxy implements INumCallback {

            /* renamed from: f, reason: collision with root package name */
            public IBinder f29695f;

            public Proxy(IBinder iBinder) {
                this.f29695f = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f29695f;
            }
        }

        public Stub() {
            attachInterface(this, "com.ted.number.service.INumCallback");
        }

        public static INumCallback N7(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ted.number.service.INumCallback");
            if (queryLocalInterface != null && (queryLocalInterface instanceof INumCallback)) {
                return (INumCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            RecognitionNumber recognitionNumber;
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 1598968902) {
                        return super.onTransact(i10, parcel, parcel2, i11);
                    }
                    parcel2.writeString("com.ted.number.service.INumCallback");
                    return true;
                }
                parcel.enforceInterface("com.ted.number.service.INumCallback");
                b();
                parcel2.writeNoException();
                return true;
            }
            parcel.enforceInterface("com.ted.number.service.INumCallback");
            if (parcel.readInt() != 0) {
                recognitionNumber = RecognitionNumber.CREATOR.createFromParcel(parcel);
            } else {
                recognitionNumber = null;
            }
            C1(recognitionNumber);
            parcel2.writeNoException();
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
