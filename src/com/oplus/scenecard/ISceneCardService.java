package com.oplus.scenecard;

import android.content.res.Configuration;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.oplus.scenecard.IShowCardCallback;

/* loaded from: classes3.dex */
public interface ISceneCardService extends IInterface {

    /* loaded from: classes3.dex */
    public static class Default implements ISceneCardService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    void B4(GetCardRequest getCardRequest, IShowCardCallback iShowCardCallback);

    void G0(int i10);

    void N0(int i10);

    void V0(Bundle bundle);

    void e6(boolean z10);

    void w0(Configuration configuration);

    void x6(int i10);

    void x7(int i10);

    void z6(int i10);

    /* loaded from: classes3.dex */
    public static abstract class Stub extends Binder implements ISceneCardService {

        /* loaded from: classes3.dex */
        public static class Proxy implements ISceneCardService {

            /* renamed from: f, reason: collision with root package name */
            public IBinder f28920f;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f28920f;
            }
        }

        public Stub() {
            attachInterface(this, "com.oplus.scenecard.ISceneCardService");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            boolean z10;
            if (i10 != 1598968902) {
                GetCardRequest getCardRequest = null;
                Bundle bundle = null;
                Configuration configuration = null;
                switch (i10) {
                    case 1:
                        parcel.enforceInterface("com.oplus.scenecard.ISceneCardService");
                        z6(parcel.readInt());
                        return true;
                    case 2:
                        parcel.enforceInterface("com.oplus.scenecard.ISceneCardService");
                        x6(parcel.readInt());
                        return true;
                    case 3:
                        parcel.enforceInterface("com.oplus.scenecard.ISceneCardService");
                        G0(parcel.readInt());
                        return true;
                    case 4:
                        parcel.enforceInterface("com.oplus.scenecard.ISceneCardService");
                        x7(parcel.readInt());
                        return true;
                    case 5:
                        parcel.enforceInterface("com.oplus.scenecard.ISceneCardService");
                        N0(parcel.readInt());
                        return true;
                    case 6:
                        parcel.enforceInterface("com.oplus.scenecard.ISceneCardService");
                        if (parcel.readInt() != 0) {
                            getCardRequest = GetCardRequest.CREATOR.createFromParcel(parcel);
                        }
                        B4(getCardRequest, IShowCardCallback.Stub.N7(parcel.readStrongBinder()));
                        return true;
                    case 7:
                        parcel.enforceInterface("com.oplus.scenecard.ISceneCardService");
                        if (parcel.readInt() != 0) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        e6(z10);
                        return true;
                    case 8:
                        parcel.enforceInterface("com.oplus.scenecard.ISceneCardService");
                        if (parcel.readInt() != 0) {
                            configuration = (Configuration) Configuration.CREATOR.createFromParcel(parcel);
                        }
                        w0(configuration);
                        return true;
                    case 9:
                        parcel.enforceInterface("com.oplus.scenecard.ISceneCardService");
                        if (parcel.readInt() != 0) {
                            bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        V0(bundle);
                        return true;
                    default:
                        return super.onTransact(i10, parcel, parcel2, i11);
                }
            }
            parcel2.writeString("com.oplus.scenecard.ISceneCardService");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
