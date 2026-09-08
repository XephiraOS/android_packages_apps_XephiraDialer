package y2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.android.incallui.CallButtonPresenter;
import com.android.incallui.InCallPresenter;
import com.android.incallui.Log;

/* compiled from: Op09VilteAutoTestHelperExt.java */
/* renamed from: y2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1702a {

    /* renamed from: g, reason: collision with root package name */
    public static int f38121g = 3;

    /* renamed from: h, reason: collision with root package name */
    public static C1702a f38122h;

    /* renamed from: a, reason: collision with root package name */
    public Context f38123a;

    /* renamed from: b, reason: collision with root package name */
    public Context f38124b;

    /* renamed from: c, reason: collision with root package name */
    public CallButtonPresenter f38125c;

    /* renamed from: d, reason: collision with root package name */
    public InCallPresenter f38126d;

    /* renamed from: e, reason: collision with root package name */
    public final BroadcastReceiver f38127e = new C0383a();

    /* renamed from: f, reason: collision with root package name */
    public final BroadcastReceiver f38128f = new b();

    /* compiled from: Op09VilteAutoTestHelperExt.java */
    /* renamed from: y2.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0383a extends BroadcastReceiver {
        public C0383a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            C1702a.this.f("action: " + action);
            if (C1702a.this.f38126d == null) {
                return;
            }
            if (action.equals("mediatek.intent.action.ACTION_ACCEPT_UPGRADE")) {
                C1702a.this.f38126d.acceptUpgradeRequest(C1702a.f38121g, C1702a.this.f38124b);
            } else if (action.equals("mediatek.intent.action.ACTION_REJECT_UPGRADE")) {
                C1702a.this.f38126d.declineUpgradeRequest(C1702a.this.f38124b);
            }
        }
    }

    /* compiled from: Op09VilteAutoTestHelperExt.java */
    /* renamed from: y2.a$b */
    /* loaded from: classes.dex */
    public class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            C1702a.this.f("action: " + action);
            if (C1702a.this.f38125c == null) {
                return;
            }
            if (action.equals("mediatek.intent.action.ACTION_UPGRADE_VIDEO")) {
                C1702a.this.f38125c.changeToVideoClicked();
                return;
            }
            if (action.equals("mediatek.intent.action.ACTION_DOWNGRADE_AUDIO")) {
                C1702a.this.f38125c.changeToVoiceClicked();
                return;
            }
            if (action.equals("mediatek.intent.action.ACTION_PAUSE_VIDEO")) {
                C1702a.this.f38125c.pauseVideoClicked(true);
                return;
            }
            if (action.equals("mediatek.intent.action.ACTION_RESTART_VIDEO")) {
                C1702a.this.f38125c.pauseVideoClicked(false);
                return;
            }
            if (action.equals("mediatek.intent.action.ACTION_MERGE")) {
                C1702a.this.f38125c.mergeClicked();
            } else if (action.equals("mediatek.intent.action.ACTION_MUTE")) {
                C1702a.this.f38125c.muteClicked(true);
            } else if (action.equals("mediatek.intent.action.ACTION_UNMUTE")) {
                C1702a.this.f38125c.muteClicked(false);
            }
        }
    }

    public static C1702a e() {
        if (f38122h == null) {
            f38122h = new C1702a();
        }
        return f38122h;
    }

    public void f(String str) {
        Log.d("Op09VilteAutoTestHelperExt", str);
    }

    public void g(Context context, Object obj) {
        if (this.f38124b == null && context != null && obj != null) {
            this.f38124b = context;
            if (obj instanceof InCallPresenter) {
                f("get InCallPresenter");
                this.f38126d = (InCallPresenter) obj;
            }
            IntentFilter intentFilter = new IntentFilter("mediatek.intent.action.ACTION_ACCEPT_UPGRADE");
            intentFilter.addAction("mediatek.intent.action.ACTION_REJECT_UPGRADE");
            this.f38124b.registerReceiver(this.f38127e, intentFilter, 2);
            f("register accept/reject receiver");
        }
    }

    public void h(Context context, Object obj) {
        if (this.f38123a == null && context != null && obj != null) {
            this.f38123a = context;
            if (obj instanceof CallButtonPresenter) {
                f("get CallButtonPresenter");
                this.f38125c = (CallButtonPresenter) obj;
            }
            IntentFilter intentFilter = new IntentFilter("mediatek.intent.action.ACTION_UPGRADE_VIDEO");
            intentFilter.addAction("mediatek.intent.action.ACTION_DOWNGRADE_AUDIO");
            intentFilter.addAction("mediatek.intent.action.ACTION_PAUSE_VIDEO");
            intentFilter.addAction("mediatek.intent.action.ACTION_RESTART_VIDEO");
            intentFilter.addAction("mediatek.intent.action.ACTION_MERGE");
            intentFilter.addAction("mediatek.intent.action.ACTION_MUTE");
            intentFilter.addAction("mediatek.intent.action.ACTION_UNMUTE");
            this.f38123a.registerReceiver(this.f38128f, intentFilter, 2);
            f("register up/down/pause/merge/mute receiver");
        }
    }

    public void i() {
        Context context = this.f38124b;
        if (context != null) {
            context.unregisterReceiver(this.f38127e);
            this.f38124b = null;
            this.f38126d = null;
            f("unregister accept/reject receiver");
        }
    }

    public void j() {
        Context context = this.f38123a;
        if (context != null) {
            context.unregisterReceiver(this.f38128f);
            this.f38123a = null;
            this.f38125c = null;
            f("unregister up/down receiver");
        }
    }
}
