package com.oplus.phonenoareainquire;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.oplus.phonenoareainquire.utils.LogUtil;

/* compiled from: DebugStatusChangeReceiver.kt */
/* loaded from: classes3.dex */
public final class DebugStatusChangeReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static final a f28785a = new a(null);

    /* compiled from: DebugStatusChangeReceiver.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(intent, "intent");
        LogUtil.c("DebugStatusChangeReceiver", "action = " + intent.getAction());
        if (kotlin.jvm.internal.i.b("phonenumberattribution.log.switch.broadcast", intent.getAction())) {
            Context applicationContext = context.getApplicationContext();
            kotlin.jvm.internal.i.e(applicationContext, "getApplicationContext(...)");
            LogUtil.d(applicationContext);
        }
    }
}
