package com.oplusx.sysapi.app;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes4.dex */
public interface ITaskStackListenerR extends IInterface {

    /* loaded from: classes4.dex */
    public static class Default implements ITaskStackListenerR {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    void B(ActivityManager.RunningTaskInfo runningTaskInfo, int i10);

    void C(int i10, IBinder iBinder);

    void D();

    void E(int i10, int i11);

    void H(int i10, int i11);

    void J(String str, int i10, int i11);

    void K(ActivityManager.RunningTaskInfo runningTaskInfo, boolean z10, boolean z11, boolean z12);

    void M(int i10);

    void N(int i10);

    void O5(int i10, TaskSnapshotNative taskSnapshotNative);

    void P(int i10);

    void R(int i10, int i11);

    void S(int i10);

    void T(boolean z10);

    void U(ActivityManager.RunningTaskInfo runningTaskInfo);

    void W(int i10, ComponentName componentName);

    void f();

    void g(ActivityManager.RunningTaskInfo runningTaskInfo);

    void k(ActivityManager.RunningTaskInfo runningTaskInfo);

    void m(ActivityManager.RunningTaskInfo runningTaskInfo);

    void onActivityPinned(String str, int i10, int i11, int i12);

    void onActivityUnpinned();

    void p(int i10, boolean z10);

    void q(int i10, int i11);

    void r(ActivityManager.RunningTaskInfo runningTaskInfo, int i10);

    void x();

    /* loaded from: classes4.dex */
    public static abstract class Stub extends Binder implements ITaskStackListenerR {

        /* loaded from: classes4.dex */
        public static class Proxy implements ITaskStackListenerR {

            /* renamed from: f, reason: collision with root package name */
            public final IBinder f29351f;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f29351f;
            }
        }

        public Stub() {
            attachInterface(this, "android.app.ITaskStackListener");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            boolean z10;
            boolean z11;
            if (i10 != 1598968902) {
                boolean z12 = false;
                ActivityManager.RunningTaskInfo runningTaskInfo = null;
                ActivityManager.RunningTaskInfo runningTaskInfo2 = null;
                TaskSnapshotNative taskSnapshotNative = null;
                ActivityManager.RunningTaskInfo runningTaskInfo3 = null;
                ActivityManager.RunningTaskInfo runningTaskInfo4 = null;
                ActivityManager.RunningTaskInfo runningTaskInfo5 = null;
                ComponentName componentName = null;
                ActivityManager.RunningTaskInfo runningTaskInfo6 = null;
                ActivityManager.RunningTaskInfo runningTaskInfo7 = null;
                switch (i10) {
                    case 1:
                        parcel.enforceInterface("android.app.ITaskStackListener");
                        f();
                        return true;
                    case 2:
                        parcel.enforceInterface("android.app.ITaskStackListener");
                        onActivityPinned(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                        return true;
                    case 3:
                        parcel.enforceInterface("android.app.ITaskStackListener");
                        onActivityUnpinned();
                        return true;
                    case 4:
                        parcel.enforceInterface("android.app.ITaskStackListener");
                        if (parcel.readInt() != 0) {
                            runningTaskInfo = (ActivityManager.RunningTaskInfo) ActivityManager.RunningTaskInfo.CREATOR.createFromParcel(parcel);
                        }
                        if (parcel.readInt() != 0) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        if (parcel.readInt() != 0) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (parcel.readInt() != 0) {
                            z12 = true;
                        }
                        K(runningTaskInfo, z10, z11, z12);
                        return true;
                    case 5:
                        parcel.enforceInterface("android.app.ITaskStackListener");
                        J(parcel.readString(), parcel.readInt(), parcel.readInt());
                        return true;
                    case 6:
                        parcel.enforceInterface("android.app.ITaskStackListener");
                        x();
                        return true;
                    case 7:
                        parcel.enforceInterface("android.app.ITaskStackListener");
                        if (parcel.readInt() != 0) {
                            runningTaskInfo7 = (ActivityManager.RunningTaskInfo) ActivityManager.RunningTaskInfo.CREATOR.createFromParcel(parcel);
                        }
                        r(runningTaskInfo7, parcel.readInt());
                        return true;
                    case 8:
                        parcel.enforceInterface("android.app.ITaskStackListener");
                        if (parcel.readInt() != 0) {
                            runningTaskInfo6 = (ActivityManager.RunningTaskInfo) ActivityManager.RunningTaskInfo.CREATOR.createFromParcel(parcel);
                        }
                        B(runningTaskInfo6, parcel.readInt());
                        return true;
                    case 9:
                        parcel.enforceInterface("android.app.ITaskStackListener");
                        int readInt = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            componentName = (ComponentName) ComponentName.CREATOR.createFromParcel(parcel);
                        }
                        W(readInt, componentName);
                        return true;
                    case 10:
                        parcel.enforceInterface("android.app.ITaskStackListener");
                        S(parcel.readInt());
                        return true;
                    case 11:
                        parcel.enforceInterface("android.app.ITaskStackListener");
                        if (parcel.readInt() != 0) {
                            runningTaskInfo5 = (ActivityManager.RunningTaskInfo) ActivityManager.RunningTaskInfo.CREATOR.createFromParcel(parcel);
                        }
                        U(runningTaskInfo5);
                        return true;
                    case 12:
                        parcel.enforceInterface("android.app.ITaskStackListener");
                        if (parcel.readInt() != 0) {
                            runningTaskInfo4 = (ActivityManager.RunningTaskInfo) ActivityManager.RunningTaskInfo.CREATOR.createFromParcel(parcel);
                        }
                        m(runningTaskInfo4);
                        return true;
                    case 13:
                        parcel.enforceInterface("android.app.ITaskStackListener");
                        R(parcel.readInt(), parcel.readInt());
                        return true;
                    case 14:
                        parcel.enforceInterface("android.app.ITaskStackListener");
                        if (parcel.readInt() != 0) {
                            runningTaskInfo3 = (ActivityManager.RunningTaskInfo) ActivityManager.RunningTaskInfo.CREATOR.createFromParcel(parcel);
                        }
                        g(runningTaskInfo3);
                        return true;
                    case 15:
                        parcel.enforceInterface("android.app.ITaskStackListener");
                        E(parcel.readInt(), parcel.readInt());
                        return true;
                    case 16:
                        parcel.enforceInterface("android.app.ITaskStackListener");
                        int readInt2 = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            taskSnapshotNative = TaskSnapshotNative.CREATOR.createFromParcel(parcel);
                        }
                        O5(readInt2, taskSnapshotNative);
                        return true;
                    case 17:
                        parcel.enforceInterface("android.app.ITaskStackListener");
                        C(parcel.readInt(), parcel.readStrongBinder());
                        return true;
                    case 18:
                        parcel.enforceInterface("android.app.ITaskStackListener");
                        if (parcel.readInt() != 0) {
                            runningTaskInfo2 = (ActivityManager.RunningTaskInfo) ActivityManager.RunningTaskInfo.CREATOR.createFromParcel(parcel);
                        }
                        k(runningTaskInfo2);
                        return true;
                    case 19:
                        parcel.enforceInterface("android.app.ITaskStackListener");
                        N(parcel.readInt());
                        return true;
                    case 20:
                        parcel.enforceInterface("android.app.ITaskStackListener");
                        P(parcel.readInt());
                        return true;
                    case 21:
                        parcel.enforceInterface("android.app.ITaskStackListener");
                        q(parcel.readInt(), parcel.readInt());
                        return true;
                    case 22:
                        parcel.enforceInterface("android.app.ITaskStackListener");
                        D();
                        return true;
                    case 23:
                        parcel.enforceInterface("android.app.ITaskStackListener");
                        if (parcel.readInt() != 0) {
                            z12 = true;
                        }
                        T(z12);
                        return true;
                    case 24:
                        parcel.enforceInterface("android.app.ITaskStackListener");
                        int readInt3 = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            z12 = true;
                        }
                        p(readInt3, z12);
                        return true;
                    case 25:
                        parcel.enforceInterface("android.app.ITaskStackListener");
                        H(parcel.readInt(), parcel.readInt());
                        return true;
                    case 26:
                        parcel.enforceInterface("android.app.ITaskStackListener");
                        M(parcel.readInt());
                        return true;
                    default:
                        return super.onTransact(i10, parcel, parcel2, i11);
                }
            }
            parcel2.writeString("android.app.ITaskStackListener");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
