package androidx.core.app.unusedapprestrictions;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback;

/* loaded from: classes.dex */
public interface IUnusedAppRestrictionsBackportService extends IInterface {

    /* renamed from: e, reason: collision with root package name */
    public static final String f9397e = "androidx$core$app$unusedapprestrictions$IUnusedAppRestrictionsBackportService".replace('$', '.');

    /* loaded from: classes.dex */
    public static class Default implements IUnusedAppRestrictionsBackportService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    void d2(IUnusedAppRestrictionsBackportCallback iUnusedAppRestrictionsBackportCallback);

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IUnusedAppRestrictionsBackportService {

        /* loaded from: classes.dex */
        public static class Proxy implements IUnusedAppRestrictionsBackportService {

            /* renamed from: f, reason: collision with root package name */
            public IBinder f9398f;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f9398f;
            }
        }

        public Stub() {
            attachInterface(this, IUnusedAppRestrictionsBackportService.f9397e);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            String str = IUnusedAppRestrictionsBackportService.f9397e;
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i10 != 1) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            d2(IUnusedAppRestrictionsBackportCallback.Stub.N7(parcel.readStrongBinder()));
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
