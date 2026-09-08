package com.oplus.blacklistapp.callintercept;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.ArraySet;
import android.util.Log;
import com.android.incallui.OplusPhoneUtils;
import com.oplus.blacklistapp.callintercept.a;
import com.oplus.blacklistapp.callintercept.policy.d;
import com.oplus.blacklistapp.callintercept.policy.e;
import com.oplus.utils.C0844e;
import com.oplus.utils.C0863y;
import java.util.Iterator;
import java.util.Set;
import v6.C1627a;
import v6.C1629c;

/* loaded from: classes3.dex */
public class CallInterceptController {

    /* renamed from: g, reason: collision with root package name */
    public static final CallInterceptController f26548g = new CallInterceptController();

    /* renamed from: b, reason: collision with root package name */
    public e f26550b;

    /* renamed from: d, reason: collision with root package name */
    public d f26552d;

    /* renamed from: a, reason: collision with root package name */
    public final Set<b> f26549a = new ArraySet();

    /* renamed from: c, reason: collision with root package name */
    public boolean f26551c = false;

    /* renamed from: e, reason: collision with root package name */
    public final BroadcastReceiver f26553e = new HotPlugBroadcastReceiver();

    /* renamed from: f, reason: collision with root package name */
    public final Handler f26554f = new a(Looper.getMainLooper());

    /* loaded from: classes3.dex */
    public class HotPlugBroadcastReceiver extends BroadcastReceiver {
        public HotPlugBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            C1627a.c("CallInterceptController", "Action intent received:" + action);
            if (C1629c.f37415a.equals(action)) {
                CallInterceptController.this.f26554f.sendMessage(CallInterceptController.this.f26554f.obtainMessage(1004, intent));
            } else if ("android.intent.action.SIM_STATE_CHANGED".equals(action)) {
                CallInterceptController.this.f26554f.sendMessage(CallInterceptController.this.f26554f.obtainMessage(1005, intent));
            } else if (C1629c.f37416b.equals(action)) {
                CallInterceptController.this.f26554f.sendMessage(CallInterceptController.this.f26554f.obtainMessage(1004, intent));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (C1627a.f37411c) {
                C1627a.o("CallInterceptController", "event=" + message.what);
            }
            int i10 = message.what;
            if (i10 == 1004) {
                CallInterceptController.this.j(message);
            } else if (i10 == 1005) {
                CallInterceptController.this.i(message);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void P0(int i10);

        void u(int i10);
    }

    public static CallInterceptController e() {
        return f26548g;
    }

    public void d(b bVar) {
        C1627a.c("CallInterceptController", "addHotPlugOutListener listener = " + bVar);
        if (bVar == null) {
            return;
        }
        this.f26549a.add(bVar);
    }

    public d f() {
        d dVar;
        synchronized (this) {
            dVar = this.f26552d;
        }
        return dVar;
    }

    public e g() {
        return this.f26550b;
    }

    public final void h(String str, String str2, int i10) {
        if (!"PLUGOUT".equals(str) && !"ABSENT".equals(str2)) {
            if ("PLUGIN".equals(str) || "CARDTYPE".equals(str) || "LOADED".equals(str2)) {
                Iterator<b> it = this.f26549a.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().P0(i10);
                    } catch (Exception e10) {
                        Log.e("CallInterceptController", "e = " + e10);
                    }
                }
                return;
            }
            return;
        }
        C1627a.c("CallInterceptController", "handleHotPlugOut begin!");
        Iterator<b> it2 = this.f26549a.iterator();
        while (it2.hasNext()) {
            try {
                it2.next().u(i10);
            } catch (Exception e11) {
                Log.e("CallInterceptController", "e = " + e11);
            }
        }
        C1627a.c("CallInterceptController", "handleHotPlugOut end!");
    }

    public final void i(Message message) {
        Object obj;
        String str;
        if (message != null && (obj = message.obj) != null) {
            Intent intent = (Intent) obj;
            String str2 = null;
            int i10 = 0;
            try {
                i10 = C0863y.b(intent, "slot", 0);
                str = C0863y.d(intent, "reason");
                try {
                    str2 = C0863y.d(intent, "ss");
                } catch (Exception e10) {
                    e = e10;
                    C1627a.h("CallInterceptController", "This exception e:" + e);
                    C1627a.c("CallInterceptController", "onSimStateChanged simReason = " + str + " simState = " + str2 + " slotId = " + i10);
                    h(str, str2, i10);
                    return;
                }
            } catch (Exception e11) {
                e = e11;
                str = null;
            }
            C1627a.c("CallInterceptController", "onSimStateChanged simReason = " + str + " simState = " + str2 + " slotId = " + i10);
            h(str, str2, i10);
            return;
        }
        C1627a.q("CallInterceptController", "onSimStateChanged msg is null or mgs.obj is null, return!");
    }

    public final void j(Message message) {
        Object obj;
        if (message != null && (obj = message.obj) != null) {
            Intent intent = (Intent) obj;
            String d10 = C0863y.d(intent, "slotid");
            int i10 = -1;
            try {
                if (!TextUtils.isEmpty(d10)) {
                    i10 = Integer.parseInt(d10);
                }
            } catch (Exception e10) {
                Log.e("CallInterceptController", "e = " + e10);
            }
            String d11 = C0863y.d(intent, "simstate");
            C1627a.c("CallInterceptController", "onSubInfoStateChanged Qcom simstate:" + d11);
            if (TextUtils.isEmpty(d11)) {
                d11 = C0863y.d(intent, "reason");
            }
            C1627a.c("CallInterceptController", "onSubInfoStateChanged simState = " + d11 + " slotId = " + i10);
            h(d11, null, i10);
            return;
        }
        C1627a.q("CallInterceptController", "onSubInfoStateChanged msg is null or mgs.obj is null, return!");
    }

    public a.C0237a k(Context context, String str, int i10) {
        if (f() != null) {
            f().N();
        }
        d dVar = new d(context, str, i10);
        n(dVar);
        a.C0237a f02 = dVar.f0();
        n(null);
        C1627a.l("CallInterceptController", "queryDoneIncomingCallInterceptTactics = " + f02);
        return f02;
    }

    public a.C0237a l(Context context, String str, int i10, int i11) {
        if (f() != null) {
            f().N();
        }
        d dVar = new d(context, str, i10, i11);
        n(dVar);
        a.C0237a f02 = dVar.f0();
        n(null);
        C1627a.l("CallInterceptController", "queryDoneIncomingCallInterceptTactics = " + f02);
        return f02;
    }

    public void m(b bVar) {
        C1627a.c("CallInterceptController", "removeHotPlugOutListener listener = " + bVar);
        if (bVar == null) {
            return;
        }
        this.f26549a.remove(bVar);
    }

    public void n(d dVar) {
        synchronized (this) {
            this.f26552d = dVar;
        }
    }

    public void o(Context context) {
        if (!this.f26551c && context != null) {
            this.f26550b = new e(context);
            IntentFilter intentFilter = new IntentFilter();
            C0844e.n(context, this.f26553e, intentFilter, "android.intent.action.SIM_STATE_CHANGED");
            intentFilter.addAction(C1629c.f37415a);
            intentFilter.addAction(C1629c.f37416b);
            context.registerReceiver(this.f26553e, intentFilter, OplusPhoneUtils.PERMISSION_OPLUS_COMPONENT_SAFE, null, 2);
            this.f26551c = true;
        }
    }
}
