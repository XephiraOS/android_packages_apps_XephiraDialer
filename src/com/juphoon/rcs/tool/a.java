package com.juphoon.rcs.tool;

import android.os.RemoteException;
import android.util.Log;
import com.juphoon.service.cap.IRcsCapService;
import com.juphoon.service.im.IRcsImService;
import com.juphoon.service.rcs.IRcsService;

/* compiled from: RcsCallWrapper.java */
/* loaded from: classes3.dex */
public class a {
    public static String a() {
        String str;
        Log.d("RcsCallWrapper", "rcsGetAccount");
        synchronized (RcsServiceManager.z()) {
            str = "";
            IRcsService y10 = RcsServiceManager.y();
            if (y10 != null) {
                try {
                    str = y10.K0();
                } catch (RemoteException e10) {
                    e10.printStackTrace();
                }
            }
            if (str == null) {
                str = "";
            }
        }
        return str;
    }

    public static boolean b(String str) {
        boolean z10 = false;
        if (RcsServiceManager.s() == 2) {
            Log.d("RcsCallWrapper", "rcsGetCap off");
            return false;
        }
        Log.d("RcsCallWrapper", "rcsGetCap");
        synchronized (RcsServiceManager.z()) {
            try {
                IRcsCapService w10 = RcsServiceManager.w();
                if (w10 != null) {
                    try {
                        if (w10.h5(str) == 0) {
                            z10 = true;
                        }
                        return z10;
                    } catch (RemoteException e10) {
                        e10.printStackTrace();
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static int c() {
        Log.d("RcsCallWrapper", "rcsGetFileTransMaxSize");
        synchronized (RcsServiceManager.z()) {
            try {
                IRcsImService x10 = RcsServiceManager.x();
                if (x10 != null) {
                    try {
                        return x10.I4();
                    } catch (RemoteException e10) {
                        e10.printStackTrace();
                    }
                }
                return 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static int d() {
        Log.d("RcsCallWrapper", "rcsGetMaxGroupSize");
        synchronized (RcsServiceManager.z()) {
            try {
                IRcsImService x10 = RcsServiceManager.x();
                if (x10 != null) {
                    try {
                        return x10.f7();
                    } catch (RemoteException e10) {
                        e10.printStackTrace();
                    }
                }
                return -1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static int e(String str) {
        Log.d("RcsCallWrapper", "rcsGetMnoConfig");
        synchronized (RcsServiceManager.z()) {
            try {
                IRcsService y10 = RcsServiceManager.y();
                if (y10 != null) {
                    try {
                        return y10.c6(str);
                    } catch (RemoteException e10) {
                        e10.printStackTrace();
                    }
                }
                return -1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static int f() {
        Log.d("RcsCallWrapper", "rcsGetSubId");
        synchronized (RcsServiceManager.z()) {
            try {
                IRcsService y10 = RcsServiceManager.y();
                if (y10 != null) {
                    try {
                        return y10.o6();
                    } catch (RemoteException e10) {
                        e10.printStackTrace();
                    }
                }
                return -1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean g() {
        Log.d("RcsCallWrapper", "rcsGetUseRcs");
        synchronized (RcsServiceManager.z()) {
            try {
                IRcsService y10 = RcsServiceManager.y();
                if (y10 != null) {
                    try {
                        return y10.h2();
                    } catch (RemoteException e10) {
                        e10.printStackTrace();
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static String h() {
        String str;
        Log.d("RcsCallWrapper", "rcsGetUserName");
        synchronized (RcsServiceManager.z()) {
            str = "";
            IRcsService y10 = RcsServiceManager.y();
            if (y10 != null) {
                try {
                    str = y10.U4();
                } catch (RemoteException e10) {
                    e10.printStackTrace();
                }
            }
            if (str == null) {
                str = "";
            }
        }
        return str;
    }

    public static boolean i() {
        Log.d("RcsCallWrapper", "rcsIsLogined");
        synchronized (RcsServiceManager.z()) {
            try {
                IRcsService y10 = RcsServiceManager.y();
                boolean z10 = false;
                if (y10 != null) {
                    try {
                        if (y10.getState() == 4) {
                            z10 = true;
                        }
                        return z10;
                    } catch (RemoteException e10) {
                        e10.printStackTrace();
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
