package org.codeaurora.ims.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes4.dex */
public interface IQtiImsExtListener extends IInterface {

    /* loaded from: classes4.dex */
    public static class Default implements IQtiImsExtListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    void notifyParticipantStatusInfo(int i10, int i11, int i12, String str, boolean z10);

    void notifySsacStatus(int i10, boolean z10);

    void notifyVopsStatus(int i10, boolean z10);

    void onGetCallForwardUncondTimer(int i10, int i11, int i12, int i13, int i14, int i15, int i16, String str, int i17);

    void onGetHandoverConfig(int i10, int i11, int i12);

    void onGetPacketCount(int i10, int i11, long j10);

    void onGetPacketErrorCount(int i10, int i11, long j10);

    void onSetCallForwardUncondTimer(int i10, int i11);

    void onSetHandoverConfig(int i10, int i11);

    void onUTReqFailed(int i10, int i11, String str);

    void onVoltePreferenceQueried(int i10, int i11, int i12);

    void onVoltePreferenceUpdated(int i10, int i11);

    void receiveCallDeflectResponse(int i10, int i11);

    void receiveCallTransferResponse(int i10, int i11);

    void receiveCancelModifyCallResponse(int i10, int i11);

    /* loaded from: classes4.dex */
    public static abstract class Stub extends Binder implements IQtiImsExtListener {
        private static final String DESCRIPTOR = "org.codeaurora.ims.internal.IQtiImsExtListener";
        static final int TRANSACTION_notifyParticipantStatusInfo = 11;
        static final int TRANSACTION_notifySsacStatus = 10;
        static final int TRANSACTION_notifyVopsStatus = 9;
        static final int TRANSACTION_onGetCallForwardUncondTimer = 2;
        static final int TRANSACTION_onGetHandoverConfig = 15;
        static final int TRANSACTION_onGetPacketCount = 4;
        static final int TRANSACTION_onGetPacketErrorCount = 5;
        static final int TRANSACTION_onSetCallForwardUncondTimer = 1;
        static final int TRANSACTION_onSetHandoverConfig = 14;
        static final int TRANSACTION_onUTReqFailed = 3;
        static final int TRANSACTION_onVoltePreferenceQueried = 13;
        static final int TRANSACTION_onVoltePreferenceUpdated = 12;
        static final int TRANSACTION_receiveCallDeflectResponse = 6;
        static final int TRANSACTION_receiveCallTransferResponse = 7;
        static final int TRANSACTION_receiveCancelModifyCallResponse = 8;

        /* loaded from: classes4.dex */
        public static class Proxy implements IQtiImsExtListener {

            /* renamed from: g, reason: collision with root package name */
            public static IQtiImsExtListener f35876g;

            /* renamed from: f, reason: collision with root package name */
            public IBinder f35877f;

            public Proxy(IBinder iBinder) {
                this.f35877f = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f35877f;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IQtiImsExtListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IQtiImsExtListener)) {
                return (IQtiImsExtListener) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static IQtiImsExtListener getDefaultImpl() {
            return Proxy.f35876g;
        }

        public static boolean setDefaultImpl(IQtiImsExtListener iQtiImsExtListener) {
            if (Proxy.f35876g == null) {
                if (iQtiImsExtListener != null) {
                    Proxy.f35876g = iQtiImsExtListener;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            boolean z10;
            if (i10 != 1598968902) {
                boolean z11 = false;
                switch (i10) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        onSetCallForwardUncondTimer(parcel.readInt(), parcel.readInt());
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        onGetCallForwardUncondTimer(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readInt());
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        onUTReqFailed(parcel.readInt(), parcel.readInt(), parcel.readString());
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        onGetPacketCount(parcel.readInt(), parcel.readInt(), parcel.readLong());
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        onGetPacketErrorCount(parcel.readInt(), parcel.readInt(), parcel.readLong());
                        return true;
                    case 6:
                        parcel.enforceInterface(DESCRIPTOR);
                        receiveCallDeflectResponse(parcel.readInt(), parcel.readInt());
                        return true;
                    case 7:
                        parcel.enforceInterface(DESCRIPTOR);
                        receiveCallTransferResponse(parcel.readInt(), parcel.readInt());
                        return true;
                    case 8:
                        parcel.enforceInterface(DESCRIPTOR);
                        receiveCancelModifyCallResponse(parcel.readInt(), parcel.readInt());
                        return true;
                    case 9:
                        parcel.enforceInterface(DESCRIPTOR);
                        int readInt = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            z11 = true;
                        }
                        notifyVopsStatus(readInt, z11);
                        return true;
                    case 10:
                        parcel.enforceInterface(DESCRIPTOR);
                        int readInt2 = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            z11 = true;
                        }
                        notifySsacStatus(readInt2, z11);
                        return true;
                    case 11:
                        parcel.enforceInterface(DESCRIPTOR);
                        int readInt3 = parcel.readInt();
                        int readInt4 = parcel.readInt();
                        int readInt5 = parcel.readInt();
                        String readString = parcel.readString();
                        if (parcel.readInt() != 0) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        notifyParticipantStatusInfo(readInt3, readInt4, readInt5, readString, z10);
                        return true;
                    case 12:
                        parcel.enforceInterface(DESCRIPTOR);
                        onVoltePreferenceUpdated(parcel.readInt(), parcel.readInt());
                        return true;
                    case 13:
                        parcel.enforceInterface(DESCRIPTOR);
                        onVoltePreferenceQueried(parcel.readInt(), parcel.readInt(), parcel.readInt());
                        return true;
                    case 14:
                        parcel.enforceInterface(DESCRIPTOR);
                        onSetHandoverConfig(parcel.readInt(), parcel.readInt());
                        return true;
                    case 15:
                        parcel.enforceInterface(DESCRIPTOR);
                        onGetHandoverConfig(parcel.readInt(), parcel.readInt(), parcel.readInt());
                        return true;
                    default:
                        return super.onTransact(i10, parcel, parcel2, i11);
                }
            }
            parcel2.writeString(DESCRIPTOR);
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
