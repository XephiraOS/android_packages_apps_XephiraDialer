package s1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;

/* compiled from: WiredHeadsetManager.java */
/* loaded from: classes.dex */
public class v {

    /* renamed from: e, reason: collision with root package name */
    public static final String f36673e = "v";

    /* renamed from: a, reason: collision with root package name */
    public final b f36674a = new b();

    /* renamed from: b, reason: collision with root package name */
    public boolean f36675b;

    /* renamed from: c, reason: collision with root package name */
    public a f36676c;

    /* renamed from: d, reason: collision with root package name */
    public Context f36677d;

    /* compiled from: WiredHeadsetManager.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z10, boolean z11);
    }

    /* compiled from: WiredHeadsetManager.java */
    /* loaded from: classes.dex */
    public class b extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.HEADSET_PLUG".equals(intent.getAction())) {
                boolean z10 = false;
                if (C7.e.d(intent, "state", 0) == 1) {
                    z10 = true;
                }
                H7.b.h(v.f36673e, "ACTION_HEADSET_PLUG event, plugged in: " + z10);
                v.this.d(z10);
            }
        }

        public b() {
        }
    }

    public v(Context context) {
        this.f36677d = context;
        this.f36675b = ((AudioManager) context.getSystemService("audio")).isWiredHeadsetOn();
    }

    public boolean c() {
        return this.f36675b;
    }

    public final void d(boolean z10) {
        if (this.f36675b != z10) {
            H7.b.h(f36673e, "onHeadsetPluggedInChanged, mIsPluggedIn: " + this.f36675b + " -> " + z10);
            boolean z11 = this.f36675b;
            this.f36675b = z10;
            a aVar = this.f36676c;
            if (aVar != null) {
                aVar.a(z11, z10);
            }
        }
    }

    public void e() {
        this.f36677d.registerReceiver(this.f36674a, new IntentFilter("android.intent.action.HEADSET_PLUG"), 2);
    }

    public void f(a aVar) {
        this.f36676c = aVar;
    }

    public void g() {
        this.f36677d.unregisterReceiver(this.f36674a);
    }
}
