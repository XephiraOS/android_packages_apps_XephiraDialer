package com.android.internal.telephony;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.android.internal.telephony.IIntegerConsumer;

/* loaded from: classes.dex */
public interface ITelephony extends IInterface {

    /* loaded from: classes.dex */
    public static class Default implements ITelephony {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    void E2(String str, int i10, String str2, int i11, String str3, PendingIntent pendingIntent);

    boolean a();

    void n0(String str, IIntegerConsumer iIntegerConsumer);

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements ITelephony {

        /* loaded from: classes.dex */
        public static class Proxy implements ITelephony {

            /* renamed from: f, reason: collision with root package name */
            public IBinder f19186f;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f19186f;
            }
        }

        public Stub() {
            attachInterface(this, "com.android.internal.telephony.ITelephony");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            PendingIntent pendingIntent;
            if (i10 != 1598968902) {
                if (i10 != 1) {
                    if (i10 != 2) {
                        if (i10 != 3) {
                            return super.onTransact(i10, parcel, parcel2, i11);
                        }
                        parcel.enforceInterface("com.android.internal.telephony.ITelephony");
                        boolean a10 = a();
                        parcel2.writeNoException();
                        parcel2.writeInt(a10 ? 1 : 0);
                        return true;
                    }
                    parcel.enforceInterface("com.android.internal.telephony.ITelephony");
                    String readString = parcel.readString();
                    int readInt = parcel.readInt();
                    String readString2 = parcel.readString();
                    int readInt2 = parcel.readInt();
                    String readString3 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        pendingIntent = (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel);
                    } else {
                        pendingIntent = null;
                    }
                    E2(readString, readInt, readString2, readInt2, readString3, pendingIntent);
                    parcel2.writeNoException();
                    return true;
                }
                parcel.enforceInterface("com.android.internal.telephony.ITelephony");
                n0(parcel.readString(), IIntegerConsumer.Stub.N7(parcel.readStrongBinder()));
                return true;
            }
            parcel2.writeString("com.android.internal.telephony.ITelephony");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
