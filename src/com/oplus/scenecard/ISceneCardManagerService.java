package com.oplus.scenecard;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.oplus.scenecard.ICardsChangeListener;
import java.util.List;

/* loaded from: classes3.dex */
public interface ISceneCardManagerService extends IInterface {

    /* loaded from: classes3.dex */
    public static class Default implements ISceneCardManagerService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    List<SceneCardInfo> B3(int i10);

    void C7(ICardsChangeListener iCardsChangeListener);

    void G4(ICardsChangeListener iCardsChangeListener, int i10);

    boolean N6(int i10);

    boolean P0(int i10, int i11);

    void Q4(int i10, boolean z10);

    boolean g5(int i10);

    /* loaded from: classes3.dex */
    public static abstract class Stub extends Binder implements ISceneCardManagerService {

        /* loaded from: classes3.dex */
        public static class Proxy implements ISceneCardManagerService {

            /* renamed from: f, reason: collision with root package name */
            public IBinder f28919f;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f28919f;
            }
        }

        public Stub() {
            attachInterface(this, "com.oplus.scenecard.ISceneCardManagerService");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            boolean z10;
            if (i10 != 1598968902) {
                switch (i10) {
                    case 1:
                        parcel.enforceInterface("com.oplus.scenecard.ISceneCardManagerService");
                        boolean g52 = g5(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(g52 ? 1 : 0);
                        return true;
                    case 2:
                        parcel.enforceInterface("com.oplus.scenecard.ISceneCardManagerService");
                        boolean N62 = N6(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(N62 ? 1 : 0);
                        return true;
                    case 3:
                        parcel.enforceInterface("com.oplus.scenecard.ISceneCardManagerService");
                        boolean P02 = P0(parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(P02 ? 1 : 0);
                        return true;
                    case 4:
                        parcel.enforceInterface("com.oplus.scenecard.ISceneCardManagerService");
                        List<SceneCardInfo> B32 = B3(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeTypedList(B32);
                        return true;
                    case 5:
                        parcel.enforceInterface("com.oplus.scenecard.ISceneCardManagerService");
                        G4(ICardsChangeListener.Stub.N7(parcel.readStrongBinder()), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface("com.oplus.scenecard.ISceneCardManagerService");
                        C7(ICardsChangeListener.Stub.N7(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface("com.oplus.scenecard.ISceneCardManagerService");
                        int readInt = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        Q4(readInt, z10);
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i10, parcel, parcel2, i11);
                }
            }
            parcel2.writeString("com.oplus.scenecard.ISceneCardManagerService");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
