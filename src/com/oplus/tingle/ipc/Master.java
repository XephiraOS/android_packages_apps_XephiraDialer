package com.oplus.tingle.ipc;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.system.Os;
import com.oplus.tingle.ipc.IMaster;
import m8.C1346c;

/* loaded from: classes3.dex */
public class Master extends IMaster.Stub {

    /* renamed from: f, reason: collision with root package name */
    public static final Object f29028f = new Object();

    /* renamed from: g, reason: collision with root package name */
    public static volatile Master f29029g;

    private Master() {
    }

    public static Master N7() {
        if (f29029g == null) {
            synchronized (f29028f) {
                try {
                    if (f29029g == null) {
                        f29029g = new Master();
                    }
                } finally {
                }
            }
        }
        return f29029g;
    }

    public final void O7(Parcel parcel, Parcel parcel2, int i10) {
        IBinder readStrongBinder = parcel.readStrongBinder();
        int readInt = parcel.readInt();
        parcel.readStringArray();
        if (C1346c.a().d() && !C1346c.a().e(readStrongBinder.getInterfaceDescriptor(), readInt)) {
            throw new SecurityException("Tingle Authentication Failed.");
        }
        Parcel obtain = Parcel.obtain();
        try {
            obtain.appendFrom(parcel, parcel.dataPosition(), parcel.dataAvail());
            try {
                long clearCallingIdentity = Binder.clearCallingIdentity();
                readStrongBinder.transact(readInt, obtain, parcel2, i10);
                Binder.restoreCallingIdentity(clearCallingIdentity);
            } finally {
                obtain.recycle();
            }
        } catch (Throwable th) {
            L8.a.c("Master", "appendFrom failed: " + th.toString(), new Object[0]);
        }
    }

    @Override // com.oplus.tingle.ipc.IMaster
    public int i() {
        return Os.getuid();
    }

    @Override // com.oplus.tingle.ipc.IMaster.Stub, android.os.Binder
    public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
        if (i10 == 1) {
            parcel.enforceInterface(D8.a.c());
            O7(parcel, parcel2, i11);
            return true;
        }
        return super.onTransact(i10, parcel, parcel2, i11);
    }
}
