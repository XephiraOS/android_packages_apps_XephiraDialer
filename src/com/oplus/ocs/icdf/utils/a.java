package com.oplus.ocs.icdf.utils;

import android.content.Context;
import com.oplus.ocs.icdf.utils.logging.ICDFLog;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    private static a f28767c;

    /* renamed from: a, reason: collision with root package name */
    private Object f28768a;

    /* renamed from: b, reason: collision with root package name */
    private volatile int f28769b = 0;

    private a(Context context) {
        this.f28768a = null;
        ICDFLog.d("ICDF.WifiManager", "init WifiManager");
        try {
            this.f28768a = Class.forName("android.net.wifi.OplusWifiManager").getConstructor(Context.class).newInstance(context);
        } catch (Exception e10) {
            ICDFLog.e("ICDF.WifiManager", e10.toString());
        }
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            try {
                if (f28767c == null) {
                    f28767c = new a(context);
                }
                aVar = f28767c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    private synchronized void b(boolean z10) {
        ICDFLog.d("ICDF.WifiManager", "setP2pPowerSaveInner " + z10);
        Object obj = this.f28768a;
        try {
            obj.getClass().getMethod("setP2pPowerSave", Boolean.TYPE).invoke(obj, Boolean.valueOf(z10));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public synchronized void a(boolean z10) {
        if (this.f28768a == null) {
            ICDFLog.d("ICDF.WifiManager", "OplusWifiManager is null ");
            return;
        }
        ICDFLog.d("ICDF.WifiManager", "setP2pPowerSave " + z10 + ", P2pRefCount = " + this.f28769b);
        if (!z10) {
            if (this.f28769b == 0) {
                b(false);
            }
            this.f28769b++;
        } else {
            this.f28769b--;
            if (this.f28769b == 0) {
                b(true);
            }
        }
    }
}
