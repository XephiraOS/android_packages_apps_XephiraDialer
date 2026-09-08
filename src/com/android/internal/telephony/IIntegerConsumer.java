package com.android.internal.telephony;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public interface IIntegerConsumer extends IInterface {

    /* loaded from: classes.dex */
    public static class Default implements IIntegerConsumer {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IIntegerConsumer {

        /* loaded from: classes.dex */
        public static class Proxy implements IIntegerConsumer {

            /* renamed from: f, reason: collision with root package name */
            public IBinder f19185f;

            public Proxy(IBinder iBinder) {
                this.f19185f = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f19185f;
            }
        }

        public Stub() {
            attachInterface(this, "com.android.internal.telephony.IIntegerConsumer");
        }

        public static IIntegerConsumer N7(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.android.internal.telephony.IIntegerConsumer");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IIntegerConsumer)) {
                return (IIntegerConsumer) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 != 1598968902) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            parcel2.writeString("com.android.internal.telephony.IIntegerConsumer");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
