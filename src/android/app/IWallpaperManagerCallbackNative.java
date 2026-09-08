package android.app;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public interface IWallpaperManagerCallbackNative extends IInterface {

    /* loaded from: classes.dex */
    public static class Default implements IWallpaperManagerCallbackNative {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    void X2(WallpaperColors wallpaperColors, int i10, int i11);

    void f0();

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IWallpaperManagerCallbackNative {

        /* loaded from: classes.dex */
        public static class Proxy implements IWallpaperManagerCallbackNative {

            /* renamed from: f, reason: collision with root package name */
            public IBinder f6933f;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f6933f;
            }
        }

        public Stub() {
            attachInterface(this, "android.app.IWallpaperManagerCallbackNative");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            WallpaperColors wallpaperColors;
            if (i10 != 1598968902) {
                if (i10 != 1) {
                    if (i10 != 2) {
                        return super.onTransact(i10, parcel, parcel2, i11);
                    }
                    parcel.enforceInterface("android.app.IWallpaperManagerCallbackNative");
                    if (parcel.readInt() != 0) {
                        wallpaperColors = (WallpaperColors) WallpaperColors.CREATOR.createFromParcel(parcel);
                    } else {
                        wallpaperColors = null;
                    }
                    X2(wallpaperColors, parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                }
                parcel.enforceInterface("android.app.IWallpaperManagerCallbackNative");
                f0();
                parcel2.writeNoException();
                return true;
            }
            parcel2.writeString("android.app.IWallpaperManagerCallbackNative");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
