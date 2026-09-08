package J7;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import kotlin.jvm.internal.i;

/* compiled from: NetworkStatusUtils.kt */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f1603a = new a();

    public static final ConnectivityManager a() {
        Object systemService = P7.a.f2961a.a().getSystemService("connectivity");
        if (systemService instanceof ConnectivityManager) {
            return (ConnectivityManager) systemService;
        }
        return null;
    }

    public static final String b() {
        Object systemService = P7.a.f2961a.a().getSystemService("phone");
        i.d(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        String networkCountryIso = ((TelephonyManager) systemService).getNetworkCountryIso();
        i.e(networkCountryIso, "telephonyManager.networkCountryIso");
        return networkCountryIso;
    }

    public static final boolean c() {
        NetworkInfo networkInfo;
        ConnectivityManager a10 = a();
        if (a10 != null) {
            networkInfo = a10.getNetworkInfo(0);
        } else {
            networkInfo = null;
        }
        if (networkInfo == null) {
            return false;
        }
        return networkInfo.isConnected();
    }

    public static final boolean d() {
        NetworkInfo[] networkInfoArr;
        ConnectivityManager a10 = a();
        if (a10 != null) {
            networkInfoArr = a10.getAllNetworkInfo();
        } else {
            networkInfoArr = null;
        }
        if (networkInfoArr != null) {
            for (NetworkInfo networkInfo : networkInfoArr) {
                if (networkInfo.isConnected()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final boolean e() {
        Object systemService = P7.a.f2961a.a().getSystemService("phone");
        i.d(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        return ((TelephonyManager) systemService).isNetworkRoaming();
    }

    public static final boolean f() {
        NetworkInfo networkInfo;
        ConnectivityManager a10 = a();
        if (a10 != null) {
            networkInfo = a10.getNetworkInfo(1);
        } else {
            networkInfo = null;
        }
        if (networkInfo != null) {
            return networkInfo.isConnected();
        }
        return false;
    }
}
