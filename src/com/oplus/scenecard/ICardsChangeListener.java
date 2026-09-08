package com.oplus.scenecard;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes3.dex */
public interface ICardsChangeListener extends IInterface {

    /* loaded from: classes3.dex */
    public static class Default implements ICardsChangeListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    void C5();

    /* loaded from: classes3.dex */
    public static abstract class Stub extends Binder implements ICardsChangeListener {

        /* loaded from: classes3.dex */
        public static class Proxy implements ICardsChangeListener {

            /* renamed from: f, reason: collision with root package name */
            public IBinder f28918f;

            public Proxy(IBinder iBinder) {
                this.f28918f = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f28918f;
            }
        }

        public Stub() {
            attachInterface(this, "com.oplus.scenecard.ICardsChangeListener");
        }

        public static ICardsChangeListener N7(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.oplus.scenecard.ICardsChangeListener");
            if (queryLocalInterface != null && (queryLocalInterface instanceof ICardsChangeListener)) {
                return (ICardsChangeListener) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 != 1598968902) {
                if (i10 != 1) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                parcel.enforceInterface("com.oplus.scenecard.ICardsChangeListener");
                C5();
                return true;
            }
            parcel2.writeString("com.oplus.scenecard.ICardsChangeListener");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
