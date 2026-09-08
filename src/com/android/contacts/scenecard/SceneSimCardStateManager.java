package com.android.contacts.scenecard;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.preference.PreferenceManager;
import androidx.lifecycle.InterfaceC0480c;
import androidx.lifecycle.InterfaceC0492o;
import com.android.contacts.dialpad.SimInfoManager;
import com.android.contacts.scenecard.SceneSimCardStateManager;
import com.customize.contacts.FeatureOption;
import com.customize.contacts.manager.B;
import com.customize.contacts.util.C0811w;
import com.customize.contacts.util.b0;
import kotlin.Result;
import kotlinx.coroutines.C1248i;
import r0.C1498a;

/* compiled from: SceneSimCardStateManager.kt */
/* loaded from: classes.dex */
public final class SceneSimCardStateManager implements InterfaceC0480c {

    /* renamed from: j, reason: collision with root package name */
    public static final a f17232j = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final Context f17233a;

    /* renamed from: b, reason: collision with root package name */
    public final kotlinx.coroutines.E f17234b;

    /* renamed from: c, reason: collision with root package name */
    public final SimInfoManager f17235c;

    /* renamed from: d, reason: collision with root package name */
    public final kotlinx.coroutines.flow.i<Y> f17236d;

    /* renamed from: e, reason: collision with root package name */
    public final com.customize.contacts.manager.B f17237e;

    /* renamed from: f, reason: collision with root package name */
    public final kotlinx.coroutines.flow.m<Y> f17238f;

    /* renamed from: g, reason: collision with root package name */
    public final SceneSimCardStateManager$simStateReceiver$1 f17239g;

    /* renamed from: h, reason: collision with root package name */
    public final b f17240h;

    /* renamed from: i, reason: collision with root package name */
    public final SceneSimCardStateManager$wifiCallingStatusChangedListener$1 f17241i;

    /* compiled from: SceneSimCardStateManager.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: SceneSimCardStateManager.kt */
    /* loaded from: classes.dex */
    public static final class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            kotlin.jvm.internal.i.f(msg, "msg");
            int i10 = msg.what;
            H7.b.e("SceneSimCardStateManager", "mainThreadHandler : msgId");
            if (i10 != 1) {
                if (i10 == 2) {
                    SceneSimCardStateManager.this.k();
                }
            } else {
                H7.b.e("SceneSimCardStateManager", "registerSIMStateChangeReceiver");
                SceneSimCardStateManager.this.l();
            }
        }
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.android.contacts.scenecard.SceneSimCardStateManager$simStateReceiver$1] */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.android.contacts.scenecard.SceneSimCardStateManager$wifiCallingStatusChangedListener$1] */
    public SceneSimCardStateManager(Context context, kotlinx.coroutines.E coroutineScope) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(coroutineScope, "coroutineScope");
        this.f17233a = context;
        this.f17234b = coroutineScope;
        this.f17235c = new SimInfoManager();
        this.f17237e = new com.customize.contacts.manager.B(context);
        kotlinx.coroutines.flow.i<Y> a10 = kotlinx.coroutines.flow.n.a(g());
        this.f17236d = a10;
        this.f17238f = a10;
        this.f17239g = new BroadcastReceiver() { // from class: com.android.contacts.scenecard.SceneSimCardStateManager$simStateReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                SceneSimCardStateManager.b bVar;
                SceneSimCardStateManager.b bVar2;
                kotlin.jvm.internal.i.f(context2, "context");
                kotlin.jvm.internal.i.f(intent, "intent");
                H7.b.e("SceneSimCardStateManager", "simStateReceiver action : " + intent.getAction());
                bVar = SceneSimCardStateManager.this.f17240h;
                bVar.removeMessages(2);
                bVar2 = SceneSimCardStateManager.this.f17240h;
                bVar2.sendEmptyMessageDelayed(2, 1000L);
            }
        };
        b bVar = new b(Looper.getMainLooper());
        this.f17240h = bVar;
        this.f17241i = new B.b() { // from class: com.android.contacts.scenecard.SceneSimCardStateManager$wifiCallingStatusChangedListener$1
            @Override // com.customize.contacts.manager.B.b
            public void y0(int i10, boolean z10, boolean z11, boolean z12, int i11) {
                kotlinx.coroutines.E e10;
                e10 = SceneSimCardStateManager.this.f17234b;
                C1248i.d(e10, null, null, new SceneSimCardStateManager$wifiCallingStatusChangedListener$1$updateWifiCallingStatus$1(i10, z10, z11, z12, i11, SceneSimCardStateManager.this, null), 3, null);
            }
        };
        H7.b.e("SceneSimCardStateManager", "init");
        bVar.sendEmptyMessage(1);
    }

    public final int f() {
        if (!b0.B0(this.f17233a)) {
            return b0.k(this.f17233a);
        }
        return -1;
    }

    public final Y g() {
        String str;
        String str2;
        b0.P(PreferenceManager.getDefaultSharedPreferences(this.f17233a));
        int j10 = b0.j();
        String B10 = b0.B();
        if (B10 == null) {
            str = "";
        } else {
            str = B10;
        }
        long A10 = b0.A();
        String E10 = b0.E();
        if (E10 == null) {
            str2 = "";
        } else {
            str2 = E10;
        }
        return new Y(j10, str, A10, str2, b0.D(), f(), false, false, 192, null);
    }

    public final kotlinx.coroutines.flow.m<Y> h() {
        return this.f17238f;
    }

    public final int i() {
        return this.f17235c.c();
    }

    public final boolean j() {
        Y value = this.f17238f.getValue();
        if (value.c() > 1 && value.d() != -1) {
            return true;
        }
        return false;
    }

    public final void k() {
        String str;
        String str2;
        this.f17235c.h(this.f17233a, null);
        this.f17235c.a();
        int j10 = b0.j();
        String B10 = b0.B();
        if (B10 == null) {
            str = "";
        } else {
            str = B10;
        }
        long A10 = b0.A();
        String E10 = b0.E();
        if (E10 == null) {
            str2 = "";
        } else {
            str2 = E10;
        }
        Y y10 = new Y(j10, str, A10, str2, b0.D(), f(), this.f17238f.getValue().g(), this.f17238f.getValue().j());
        H7.b.e("SceneSimCardStateManager", "refreshSimInfo " + y10);
        C1248i.d(this.f17234b, null, null, new SceneSimCardStateManager$refreshSimInfo$1(this, y10, null), 3, null);
        if (FeatureOption.o()) {
            this.f17237e.o(this.f17233a, true, b0.j(), this.f17235c.d(), true);
        }
    }

    public final void l() {
        IntentFilter intentFilter = new IntentFilter();
        C0811w.j(this.f17233a, this.f17239g, intentFilter, "android.intent.action.SIM_STATE_CHANGED");
        intentFilter.addAction("android.intent.action.SIM_SETTING_INFO_CHANGED");
        intentFilter.addAction(C1498a.f36264w);
        intentFilter.addAction("android.intent.action.ACTION_SUBINFO_CONTENT_CHANGE");
        intentFilter.addAction("android.telephony.action.CARRIER_CONFIG_CHANGED");
        intentFilter.addAction(C1498a.f36265x);
        intentFilter.addAction("android.intent.action.ACTION_DEFAULT_VOICE_SUBSCRIPTION_CHANGED");
        this.f17233a.registerReceiver(this.f17239g, intentFilter, R0.b.f3175i, null, 2);
        if (FeatureOption.o()) {
            this.f17237e.m(this.f17241i);
        }
    }

    @Override // androidx.lifecycle.InterfaceC0480c
    public void onDestroy(InterfaceC0492o owner) {
        Object b10;
        kotlin.jvm.internal.i.f(owner, "owner");
        super.onDestroy(owner);
        H7.b.e("SceneSimCardStateManager", "onDestroy");
        try {
            Result.a aVar = Result.f34166a;
            this.f17233a.unregisterReceiver(this.f17239g);
            this.f17237e.n();
            b10 = Result.b(m9.q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        if (Result.d(b10) != null) {
            H7.b.c("SceneSimCardStateManager", "unregisterReceiver error");
        }
    }
}
