package com.oplus.networklib;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.util.Log;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.i;
import m9.q;

/* compiled from: NetworkMonitor.kt */
/* loaded from: classes3.dex */
public final class NetworkMonitor {

    /* renamed from: a, reason: collision with root package name */
    public static final NetworkMonitor f28381a = new NetworkMonitor();

    /* renamed from: b, reason: collision with root package name */
    public static final HashSet<a> f28382b = new HashSet<>();

    /* renamed from: c, reason: collision with root package name */
    public static NetworkType f28383c = NetworkType.NO_NETWORK;

    /* renamed from: d, reason: collision with root package name */
    public static final ConnectivityManager.NetworkCallback f28384d = new b();

    /* compiled from: NetworkMonitor.kt */
    /* loaded from: classes3.dex */
    public enum NetworkType {
        NO_NETWORK,
        WIFI,
        MOBILE,
        OTHER
    }

    /* compiled from: NetworkMonitor.kt */
    /* loaded from: classes3.dex */
    public interface a {
        void a(NetworkType networkType);
    }

    /* compiled from: NetworkMonitor.kt */
    /* loaded from: classes3.dex */
    public static final class b extends ConnectivityManager.NetworkCallback {
        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            i.f(network, "network");
            i.f(networkCapabilities, "networkCapabilities");
            super.onCapabilitiesChanged(network, networkCapabilities);
            NetworkMonitor networkMonitor = NetworkMonitor.f28381a;
            networkMonitor.e(networkMonitor.c(networkCapabilities));
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            i.f(network, "network");
            super.onLost(network);
            NetworkMonitor.f28381a.e(NetworkType.NO_NETWORK);
        }
    }

    public static final boolean d(Context context) {
        NetworkCapabilities networkCapabilities;
        i.f(context, "context");
        Object systemService = context.getSystemService("connectivity");
        if (systemService != null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
            Network activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null || !networkCapabilities.hasCapability(12) || !networkCapabilities.hasCapability(16)) {
                return false;
            }
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
    }

    public final NetworkType c(NetworkCapabilities networkCapabilities) {
        if (!networkCapabilities.hasCapability(16)) {
            return NetworkType.NO_NETWORK;
        }
        if (networkCapabilities.hasTransport(0)) {
            return NetworkType.MOBILE;
        }
        if (networkCapabilities.hasTransport(1)) {
            return NetworkType.WIFI;
        }
        return NetworkType.OTHER;
    }

    public final void e(NetworkType networkType) {
        List M10;
        Log.d("NetWorkMonitor", "postOnNetStateChange : old state =" + f28383c + ",new state =" + networkType);
        synchronized (f28383c) {
            try {
                if (f28383c != networkType) {
                    f28383c = networkType;
                    M10 = CollectionsKt___CollectionsKt.M(f28382b);
                    Iterator it = M10.iterator();
                    while (it.hasNext()) {
                        ((a) it.next()).a(networkType);
                    }
                }
                q qVar = q.f35511a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
