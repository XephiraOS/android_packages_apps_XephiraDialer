package B1;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Handler;
import android.os.Looper;
import android.telecom.PhoneAccountHandle;
import android.telephony.TelephonyManager;
import com.android.contacts.voicemail.impl.OmtpEvents;
import com.android.contacts.voicemail.impl.c;

/* compiled from: VvmNetworkRequestCallback.java */
/* loaded from: classes.dex */
public abstract class e extends ConnectivityManager.NetworkCallback {

    /* renamed from: a, reason: collision with root package name */
    public Context f231a;

    /* renamed from: b, reason: collision with root package name */
    public PhoneAccountHandle f232b;

    /* renamed from: d, reason: collision with root package name */
    public ConnectivityManager f234d;

    /* renamed from: e, reason: collision with root package name */
    public final com.android.contacts.voicemail.impl.b f235e;

    /* renamed from: f, reason: collision with root package name */
    public final c.b f236f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f237g = false;

    /* renamed from: h, reason: collision with root package name */
    public boolean f238h = false;

    /* renamed from: c, reason: collision with root package name */
    public NetworkRequest f233c = b();

    /* compiled from: VvmNetworkRequestCallback.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!e.this.f238h) {
                e.this.f("timeout");
            }
        }
    }

    public e(Context context, PhoneAccountHandle phoneAccountHandle, c.b bVar) {
        this.f231a = context;
        this.f232b = phoneAccountHandle;
        this.f236f = bVar;
        this.f235e = new com.android.contacts.voicemail.impl.b(context, phoneAccountHandle);
    }

    public final NetworkRequest b() {
        NetworkRequest.Builder addCapability = new NetworkRequest.Builder().addCapability(12);
        TelephonyManager createForPhoneAccountHandle = ((TelephonyManager) this.f231a.getSystemService(TelephonyManager.class)).createForPhoneAccountHandle(this.f232b);
        if (createForPhoneAccountHandle != null && this.f235e.s()) {
            H7.b.b("VvmNetworkRequest", "Transport type: CELLULAR");
            addCapability.addTransportType(0).setNetworkSpecifier(createForPhoneAccountHandle.getNetworkSpecifier());
        } else {
            H7.b.b("VvmNetworkRequest", "Transport type: ANY");
        }
        return addCapability.build();
    }

    public ConnectivityManager c() {
        if (this.f234d == null) {
            this.f234d = J7.a.a();
        }
        return this.f234d;
    }

    public NetworkRequest d() {
        return this.f233c;
    }

    public c.b e() {
        return this.f236f;
    }

    public void f(String str) {
        H7.b.b("VvmNetworkRequest", "onFailed: " + str);
        if (this.f235e.s()) {
            this.f235e.r(this.f236f, OmtpEvents.DATA_NO_CONNECTION_CELLULAR_REQUIRED);
        } else {
            this.f235e.r(this.f236f, OmtpEvents.DATA_NO_CONNECTION);
        }
        g();
    }

    public void g() {
        H7.b.b("VvmNetworkRequest", "releaseNetwork");
        c().unregisterNetworkCallback(this);
    }

    public void h() {
        if (this.f237g) {
            H7.b.c("VvmNetworkRequest", "requestNetwork() called twice");
            return;
        }
        this.f237g = true;
        c().requestNetwork(d(), this);
        new Handler(Looper.getMainLooper()).postDelayed(new a(), 60000L);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onAvailable(Network network) {
        super.onAvailable(network);
        this.f238h = true;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLost(Network network) {
        H7.b.b("VvmNetworkRequest", "onLost");
        this.f238h = true;
        f("lost");
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onUnavailable() {
        this.f238h = true;
        f("timeout");
    }

    public e(com.android.contacts.voicemail.impl.b bVar, PhoneAccountHandle phoneAccountHandle, c.b bVar2) {
        this.f231a = bVar.g();
        this.f232b = phoneAccountHandle;
        this.f236f = bVar2;
        this.f235e = bVar;
    }
}
