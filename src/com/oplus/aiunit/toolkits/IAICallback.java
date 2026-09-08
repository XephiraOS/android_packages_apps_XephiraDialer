package com.oplus.aiunit.toolkits;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public interface IAICallback extends IInterface {

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

    void m7(Bundle bundle);

    /* loaded from: classes3.dex */
    public static abstract class Stub extends Binder implements IAICallback {

        /* loaded from: classes3.dex */
        public static class Proxy implements IAICallback {

            /* renamed from: f, reason: collision with root package name */
            public IBinder f25731f;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f25731f;
            }

            @Override // com.oplus.aiunit.toolkits.IAICallback
            public void m7(Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.oplus.aiunit.toolkits.IAICallback");
                    a.d(obtain, bundle, 0);
                    this.f25731f.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.oplus.aiunit.toolkits.IAICallback");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface("com.oplus.aiunit.toolkits.IAICallback");
            }
            if (i10 != 1598968902) {
                if (i10 != 1) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                m7((Bundle) a.c(parcel, Bundle.CREATOR));
                return true;
            }
            parcel2.writeString("com.oplus.aiunit.toolkits.IAICallback");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public static class Default implements IAICallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.oplus.aiunit.toolkits.IAICallback
        public void m7(Bundle bundle) {
        }
    }
}
