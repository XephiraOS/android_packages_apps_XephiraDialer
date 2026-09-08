package com.heytap.accessory.api;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import com.heytap.accessory.api.IDeathCallback;
import com.heytap.accessory.api.IMsgExpCallback;
import com.heytap.accessory.api.IPeerAgentAuthCallback;
import com.heytap.accessory.api.IPeerAgentCallback;
import com.heytap.accessory.api.IServiceChannelCallback;
import com.heytap.accessory.api.IServiceConnectionCallback;
import com.heytap.accessory.api.IServiceConnectionIndicationCallback;
import com.heytap.accessory.bean.PeerAgent;

/* loaded from: classes3.dex */
public interface IFrameworkManager extends IInterface {

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

    int A5(long j10, String str, PeerAgent peerAgent, IPeerAgentAuthCallback iPeerAgentAuthCallback, long j11);

    Bundle D5(long j10, String str);

    ResultReceiver F3(long j10);

    int J3(int i10);

    void L0(long j10, String str, long j11);

    int Q5(long j10, String str, long j11, String str2, long j12, byte[] bArr, boolean z10, int i10, int i11, int i12, boolean z11);

    int S1(long j10, String str, PeerAgent peerAgent, IServiceConnectionCallback iServiceConnectionCallback, IServiceChannelCallback iServiceChannelCallback);

    void U1(long j10, String str, IMsgExpCallback iMsgExpCallback);

    void W1(long j10, long j11, int i10, int i11);

    int Y5(long j10, String str, String str2, long j11, byte[] bArr, boolean z10, int i10, int i11);

    int b7(long j10);

    boolean c(int i10, String str);

    void f5(long j10, String str);

    void g1(long j10, Bundle bundle);

    int getVersion();

    int j5(long j10, long j11, String str, IPeerAgentCallback iPeerAgentCallback);

    void m5(long j10, byte[] bArr);

    int p2(long j10, String str);

    Bundle p5(int i10, String str, IDeathCallback iDeathCallback, int i11, IServiceConnectionIndicationCallback iServiceConnectionIndicationCallback);

    int q0(long j10, String str, PeerAgent peerAgent, long j11);

    void s1(long j10, Bundle bundle);

    int s7(long j10, String str, long j11, byte[] bArr, boolean z10, int i10, int i11, int i12);

    void t0(long j10, String str);

    boolean t6(long j10, String str);

    void u6(long j10, long j11, String str, int i10, int i11);

    Bundle v0(long j10, String str);

    Bundle v2(long j10, String str, PeerAgent peerAgent, long j11, IServiceConnectionCallback iServiceConnectionCallback, IServiceChannelCallback iServiceChannelCallback);

    String x3(long j10, String str, String str2);

    /* loaded from: classes3.dex */
    public static abstract class Stub extends Binder implements IFrameworkManager {

        /* loaded from: classes3.dex */
        public static class Proxy implements IFrameworkManager {

            /* renamed from: f, reason: collision with root package name */
            public IBinder f25189f;

            public Proxy(IBinder iBinder) {
                this.f25189f = iBinder;
            }

            @Override // com.heytap.accessory.api.IFrameworkManager
            public int A5(long j10, String str, PeerAgent peerAgent, IPeerAgentAuthCallback iPeerAgentAuthCallback, long j11) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IFrameworkManager");
                    obtain.writeLong(j10);
                    obtain.writeString(str);
                    a.d(obtain, peerAgent, 0);
                    obtain.writeStrongInterface(iPeerAgentAuthCallback);
                    obtain.writeLong(j11);
                    this.f25189f.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IFrameworkManager
            public Bundle D5(long j10, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IFrameworkManager");
                    obtain.writeLong(j10);
                    obtain.writeString(str);
                    this.f25189f.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return (Bundle) a.c(obtain2, Bundle.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IFrameworkManager
            public ResultReceiver F3(long j10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IFrameworkManager");
                    obtain.writeLong(j10);
                    this.f25189f.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                    return (ResultReceiver) a.c(obtain2, ResultReceiver.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IFrameworkManager
            public int J3(int i10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IFrameworkManager");
                    obtain.writeInt(i10);
                    this.f25189f.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IFrameworkManager
            public void L0(long j10, String str, long j11) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IFrameworkManager");
                    obtain.writeLong(j10);
                    obtain.writeString(str);
                    obtain.writeLong(j11);
                    this.f25189f.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IFrameworkManager
            public int Q5(long j10, String str, long j11, String str2, long j12, byte[] bArr, boolean z10, int i10, int i11, int i12, boolean z11) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IFrameworkManager");
                    obtain.writeLong(j10);
                    obtain.writeString(str);
                    obtain.writeLong(j11);
                    obtain.writeString(str2);
                    obtain.writeLong(j12);
                    obtain.writeByteArray(bArr);
                    obtain.writeInt(z10 ? 1 : 0);
                    obtain.writeInt(i10);
                    obtain.writeInt(i11);
                    obtain.writeInt(i12);
                    obtain.writeInt(z11 ? 1 : 0);
                    this.f25189f.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IFrameworkManager
            public int S1(long j10, String str, PeerAgent peerAgent, IServiceConnectionCallback iServiceConnectionCallback, IServiceChannelCallback iServiceChannelCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IFrameworkManager");
                    obtain.writeLong(j10);
                    obtain.writeString(str);
                    a.d(obtain, peerAgent, 0);
                    obtain.writeStrongInterface(iServiceConnectionCallback);
                    obtain.writeStrongInterface(iServiceChannelCallback);
                    this.f25189f.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IFrameworkManager
            public void U1(long j10, String str, IMsgExpCallback iMsgExpCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IFrameworkManager");
                    obtain.writeLong(j10);
                    obtain.writeString(str);
                    obtain.writeStrongInterface(iMsgExpCallback);
                    this.f25189f.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IFrameworkManager
            public void W1(long j10, long j11, int i10, int i11) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IFrameworkManager");
                    obtain.writeLong(j10);
                    obtain.writeLong(j11);
                    obtain.writeInt(i10);
                    obtain.writeInt(i11);
                    this.f25189f.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IFrameworkManager
            public int Y5(long j10, String str, String str2, long j11, byte[] bArr, boolean z10, int i10, int i11) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IFrameworkManager");
                    obtain.writeLong(j10);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeLong(j11);
                    obtain.writeByteArray(bArr);
                    obtain.writeInt(z10 ? 1 : 0);
                    obtain.writeInt(i10);
                    obtain.writeInt(i11);
                    this.f25189f.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f25189f;
            }

            @Override // com.heytap.accessory.api.IFrameworkManager
            public int b7(long j10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IFrameworkManager");
                    obtain.writeLong(j10);
                    this.f25189f.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IFrameworkManager
            public boolean c(int i10, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IFrameworkManager");
                    obtain.writeInt(i10);
                    obtain.writeString(str);
                    boolean z10 = false;
                    this.f25189f.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z10 = true;
                    }
                    return z10;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IFrameworkManager
            public void f5(long j10, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IFrameworkManager");
                    obtain.writeLong(j10);
                    obtain.writeString(str);
                    this.f25189f.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IFrameworkManager
            public void g1(long j10, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IFrameworkManager");
                    obtain.writeLong(j10);
                    a.d(obtain, bundle, 0);
                    this.f25189f.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IFrameworkManager
            public int getVersion() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IFrameworkManager");
                    this.f25189f.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IFrameworkManager
            public int j5(long j10, long j11, String str, IPeerAgentCallback iPeerAgentCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IFrameworkManager");
                    obtain.writeLong(j10);
                    obtain.writeLong(j11);
                    obtain.writeString(str);
                    obtain.writeStrongInterface(iPeerAgentCallback);
                    this.f25189f.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IFrameworkManager
            public void m5(long j10, byte[] bArr) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IFrameworkManager");
                    obtain.writeLong(j10);
                    obtain.writeByteArray(bArr);
                    this.f25189f.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IFrameworkManager
            public int p2(long j10, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IFrameworkManager");
                    obtain.writeLong(j10);
                    obtain.writeString(str);
                    this.f25189f.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IFrameworkManager
            public Bundle p5(int i10, String str, IDeathCallback iDeathCallback, int i11, IServiceConnectionIndicationCallback iServiceConnectionIndicationCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IFrameworkManager");
                    obtain.writeInt(i10);
                    obtain.writeString(str);
                    obtain.writeStrongInterface(iDeathCallback);
                    obtain.writeInt(i11);
                    obtain.writeStrongInterface(iServiceConnectionIndicationCallback);
                    this.f25189f.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return (Bundle) a.c(obtain2, Bundle.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IFrameworkManager
            public int q0(long j10, String str, PeerAgent peerAgent, long j11) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IFrameworkManager");
                    obtain.writeLong(j10);
                    obtain.writeString(str);
                    a.d(obtain, peerAgent, 0);
                    obtain.writeLong(j11);
                    this.f25189f.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IFrameworkManager
            public void s1(long j10, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IFrameworkManager");
                    obtain.writeLong(j10);
                    a.d(obtain, bundle, 0);
                    this.f25189f.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IFrameworkManager
            public int s7(long j10, String str, long j11, byte[] bArr, boolean z10, int i10, int i11, int i12) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IFrameworkManager");
                    obtain.writeLong(j10);
                    obtain.writeString(str);
                    obtain.writeLong(j11);
                    obtain.writeByteArray(bArr);
                    obtain.writeInt(z10 ? 1 : 0);
                    obtain.writeInt(i10);
                    obtain.writeInt(i11);
                    obtain.writeInt(i12);
                    this.f25189f.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IFrameworkManager
            public void t0(long j10, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IFrameworkManager");
                    obtain.writeLong(j10);
                    obtain.writeString(str);
                    this.f25189f.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IFrameworkManager
            public boolean t6(long j10, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IFrameworkManager");
                    obtain.writeLong(j10);
                    obtain.writeString(str);
                    boolean z10 = false;
                    this.f25189f.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z10 = true;
                    }
                    return z10;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IFrameworkManager
            public void u6(long j10, long j11, String str, int i10, int i11) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IFrameworkManager");
                    obtain.writeLong(j10);
                    obtain.writeLong(j11);
                    obtain.writeString(str);
                    obtain.writeInt(i10);
                    obtain.writeInt(i11);
                    this.f25189f.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IFrameworkManager
            public Bundle v0(long j10, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IFrameworkManager");
                    obtain.writeLong(j10);
                    obtain.writeString(str);
                    this.f25189f.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return (Bundle) a.c(obtain2, Bundle.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IFrameworkManager
            public Bundle v2(long j10, String str, PeerAgent peerAgent, long j11, IServiceConnectionCallback iServiceConnectionCallback, IServiceChannelCallback iServiceChannelCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IFrameworkManager");
                    obtain.writeLong(j10);
                    obtain.writeString(str);
                    a.d(obtain, peerAgent, 0);
                    obtain.writeLong(j11);
                    obtain.writeStrongInterface(iServiceConnectionCallback);
                    obtain.writeStrongInterface(iServiceChannelCallback);
                    this.f25189f.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return (Bundle) a.c(obtain2, Bundle.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IFrameworkManager
            public String x3(long j10, String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.accessory.api.IFrameworkManager");
                    obtain.writeLong(j10);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f25189f.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.heytap.accessory.api.IFrameworkManager");
        }

        public static IFrameworkManager N7(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.accessory.api.IFrameworkManager");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IFrameworkManager)) {
                return (IFrameworkManager) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:9:0x001b. Please report as an issue. */
        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            boolean z10;
            boolean z11;
            boolean z12;
            boolean z13;
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface("com.heytap.accessory.api.IFrameworkManager");
            }
            if (i10 != 1598968902) {
                switch (i10) {
                    case 1:
                        Bundle p52 = p5(parcel.readInt(), parcel.readString(), IDeathCallback.Stub.N7(parcel.readStrongBinder()), parcel.readInt(), IServiceConnectionIndicationCallback.Stub.N7(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        a.d(parcel2, p52, 1);
                        return true;
                    case 2:
                        m5(parcel.readLong(), parcel.createByteArray());
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        Bundle D52 = D5(parcel.readLong(), parcel.readString());
                        parcel2.writeNoException();
                        a.d(parcel2, D52, 1);
                        return true;
                    case 4:
                        int j52 = j5(parcel.readLong(), parcel.readLong(), parcel.readString(), IPeerAgentCallback.Stub.N7(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(j52);
                        return true;
                    case 5:
                        int A52 = A5(parcel.readLong(), parcel.readString(), (PeerAgent) a.c(parcel, PeerAgent.CREATOR), IPeerAgentAuthCallback.Stub.N7(parcel.readStrongBinder()), parcel.readLong());
                        parcel2.writeNoException();
                        parcel2.writeInt(A52);
                        return true;
                    case 6:
                        int S12 = S1(parcel.readLong(), parcel.readString(), (PeerAgent) a.c(parcel, PeerAgent.CREATOR), IServiceConnectionCallback.Stub.N7(parcel.readStrongBinder()), IServiceChannelCallback.Stub.N7(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(S12);
                        return true;
                    case 7:
                        Bundle v22 = v2(parcel.readLong(), parcel.readString(), (PeerAgent) a.c(parcel, PeerAgent.CREATOR), parcel.readLong(), IServiceConnectionCallback.Stub.N7(parcel.readStrongBinder()), IServiceChannelCallback.Stub.N7(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        a.d(parcel2, v22, 1);
                        return true;
                    case 8:
                        int q02 = q0(parcel.readLong(), parcel.readString(), (PeerAgent) a.c(parcel, PeerAgent.CREATOR), parcel.readLong());
                        parcel2.writeNoException();
                        parcel2.writeInt(q02);
                        return true;
                    case 9:
                        int p22 = p2(parcel.readLong(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(p22);
                        return true;
                    case 10:
                        Bundle v02 = v0(parcel.readLong(), parcel.readString());
                        parcel2.writeNoException();
                        a.d(parcel2, v02, 1);
                        return true;
                    case 11:
                        int b72 = b7(parcel.readLong());
                        parcel2.writeNoException();
                        parcel2.writeInt(b72);
                        return true;
                    case 12:
                        boolean t62 = t6(parcel.readLong(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(t62 ? 1 : 0);
                        return true;
                    case 13:
                        ResultReceiver F32 = F3(parcel.readLong());
                        parcel2.writeNoException();
                        a.d(parcel2, F32, 1);
                        return true;
                    case 14:
                        U1(parcel.readLong(), parcel.readString(), IMsgExpCallback.Stub.N7(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 15:
                        t0(parcel.readLong(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 16:
                        long readLong = parcel.readLong();
                        String readString = parcel.readString();
                        String readString2 = parcel.readString();
                        long readLong2 = parcel.readLong();
                        byte[] createByteArray = parcel.createByteArray();
                        if (parcel.readInt() != 0) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        int Y52 = Y5(readLong, readString, readString2, readLong2, createByteArray, z10, parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(Y52);
                        return true;
                    case 17:
                        W1(parcel.readLong(), parcel.readLong(), parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 18:
                        f5(parcel.readLong(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 19:
                        String x32 = x3(parcel.readLong(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(x32);
                        return true;
                    case 20:
                        long readLong3 = parcel.readLong();
                        String readString3 = parcel.readString();
                        long readLong4 = parcel.readLong();
                        byte[] createByteArray2 = parcel.createByteArray();
                        if (parcel.readInt() != 0) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        int s72 = s7(readLong3, readString3, readLong4, createByteArray2, z11, parcel.readInt(), parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(s72);
                        return true;
                    case 21:
                        int version = getVersion();
                        parcel2.writeNoException();
                        parcel2.writeInt(version);
                        return true;
                    case 22:
                        int J32 = J3(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(J32);
                        return true;
                    case 23:
                        boolean c10 = c(parcel.readInt(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(c10 ? 1 : 0);
                        return true;
                    case 24:
                        long readLong5 = parcel.readLong();
                        String readString4 = parcel.readString();
                        long readLong6 = parcel.readLong();
                        String readString5 = parcel.readString();
                        long readLong7 = parcel.readLong();
                        byte[] createByteArray3 = parcel.createByteArray();
                        if (parcel.readInt() != 0) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        int readInt = parcel.readInt();
                        int readInt2 = parcel.readInt();
                        int readInt3 = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            z13 = true;
                        } else {
                            z13 = false;
                        }
                        int Q52 = Q5(readLong5, readString4, readLong6, readString5, readLong7, createByteArray3, z12, readInt, readInt2, readInt3, z13);
                        parcel2.writeNoException();
                        parcel2.writeInt(Q52);
                        return true;
                    case 25:
                        u6(parcel.readLong(), parcel.readLong(), parcel.readString(), parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 26:
                        L0(parcel.readLong(), parcel.readString(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 27:
                        g1(parcel.readLong(), (Bundle) a.c(parcel, Bundle.CREATOR));
                        parcel2.writeNoException();
                        return true;
                    case 28:
                        s1(parcel.readLong(), (Bundle) a.c(parcel, Bundle.CREATOR));
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i10, parcel, parcel2, i11);
                }
            }
            parcel2.writeString("com.heytap.accessory.api.IFrameworkManager");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public static class Default implements IFrameworkManager {
        @Override // com.heytap.accessory.api.IFrameworkManager
        public int A5(long j10, String str, PeerAgent peerAgent, IPeerAgentAuthCallback iPeerAgentAuthCallback, long j11) {
            return 0;
        }

        @Override // com.heytap.accessory.api.IFrameworkManager
        public Bundle D5(long j10, String str) {
            return null;
        }

        @Override // com.heytap.accessory.api.IFrameworkManager
        public ResultReceiver F3(long j10) {
            return null;
        }

        @Override // com.heytap.accessory.api.IFrameworkManager
        public int J3(int i10) {
            return 0;
        }

        @Override // com.heytap.accessory.api.IFrameworkManager
        public int Q5(long j10, String str, long j11, String str2, long j12, byte[] bArr, boolean z10, int i10, int i11, int i12, boolean z11) {
            return 0;
        }

        @Override // com.heytap.accessory.api.IFrameworkManager
        public int S1(long j10, String str, PeerAgent peerAgent, IServiceConnectionCallback iServiceConnectionCallback, IServiceChannelCallback iServiceChannelCallback) {
            return 0;
        }

        @Override // com.heytap.accessory.api.IFrameworkManager
        public int Y5(long j10, String str, String str2, long j11, byte[] bArr, boolean z10, int i10, int i11) {
            return 0;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.heytap.accessory.api.IFrameworkManager
        public int b7(long j10) {
            return 0;
        }

        @Override // com.heytap.accessory.api.IFrameworkManager
        public boolean c(int i10, String str) {
            return false;
        }

        @Override // com.heytap.accessory.api.IFrameworkManager
        public int getVersion() {
            return 0;
        }

        @Override // com.heytap.accessory.api.IFrameworkManager
        public int j5(long j10, long j11, String str, IPeerAgentCallback iPeerAgentCallback) {
            return 0;
        }

        @Override // com.heytap.accessory.api.IFrameworkManager
        public int p2(long j10, String str) {
            return 0;
        }

        @Override // com.heytap.accessory.api.IFrameworkManager
        public Bundle p5(int i10, String str, IDeathCallback iDeathCallback, int i11, IServiceConnectionIndicationCallback iServiceConnectionIndicationCallback) {
            return null;
        }

        @Override // com.heytap.accessory.api.IFrameworkManager
        public int q0(long j10, String str, PeerAgent peerAgent, long j11) {
            return 0;
        }

        @Override // com.heytap.accessory.api.IFrameworkManager
        public int s7(long j10, String str, long j11, byte[] bArr, boolean z10, int i10, int i11, int i12) {
            return 0;
        }

        @Override // com.heytap.accessory.api.IFrameworkManager
        public boolean t6(long j10, String str) {
            return false;
        }

        @Override // com.heytap.accessory.api.IFrameworkManager
        public Bundle v0(long j10, String str) {
            return null;
        }

        @Override // com.heytap.accessory.api.IFrameworkManager
        public Bundle v2(long j10, String str, PeerAgent peerAgent, long j11, IServiceConnectionCallback iServiceConnectionCallback, IServiceChannelCallback iServiceChannelCallback) {
            return null;
        }

        @Override // com.heytap.accessory.api.IFrameworkManager
        public String x3(long j10, String str, String str2) {
            return null;
        }

        @Override // com.heytap.accessory.api.IFrameworkManager
        public void f5(long j10, String str) {
        }

        @Override // com.heytap.accessory.api.IFrameworkManager
        public void g1(long j10, Bundle bundle) {
        }

        @Override // com.heytap.accessory.api.IFrameworkManager
        public void m5(long j10, byte[] bArr) {
        }

        @Override // com.heytap.accessory.api.IFrameworkManager
        public void s1(long j10, Bundle bundle) {
        }

        @Override // com.heytap.accessory.api.IFrameworkManager
        public void t0(long j10, String str) {
        }

        @Override // com.heytap.accessory.api.IFrameworkManager
        public void L0(long j10, String str, long j11) {
        }

        @Override // com.heytap.accessory.api.IFrameworkManager
        public void U1(long j10, String str, IMsgExpCallback iMsgExpCallback) {
        }

        @Override // com.heytap.accessory.api.IFrameworkManager
        public void W1(long j10, long j11, int i10, int i11) {
        }

        @Override // com.heytap.accessory.api.IFrameworkManager
        public void u6(long j10, long j11, String str, int i10, int i11) {
        }
    }
}
