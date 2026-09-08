package J0;

import android.content.Context;
import android.content.Intent;
import com.android.incallui.OplusPhoneCapabilities;

/* compiled from: BroadcastIntentProcessor.java */
/* loaded from: classes.dex */
public final class c extends a {

    /* renamed from: a, reason: collision with root package name */
    public final Context f1422a;

    public c(Context context) {
        this.f1422a = context;
    }

    public void d(Intent intent) {
        String action = intent.getAction();
        if ("com.android.server.telecom.ACTION_SEND_SMS_FROM_NOTIFICATION".equals(action) || "com.android.server.telecom.ACTION_CALL_BACK_FROM_NOTIFICATION".equals(action) || "com.android.server.telecom.ACTION_CLEAR_MISSED_CALLS".equals(action)) {
            if ("com.android.server.telecom.ACTION_SEND_SMS_FROM_NOTIFICATION".equals(action)) {
                a(intent, this.f1422a);
                f(intent);
            } else if ("com.android.server.telecom.ACTION_CALL_BACK_FROM_NOTIFICATION".equals(action)) {
                a(intent, this.f1422a);
                e(intent);
            } else if ("com.android.server.telecom.ACTION_CLEAR_MISSED_CALLS".equals(action)) {
                k.a(this.f1422a);
            }
        }
    }

    public final void e(Intent intent) {
        l.b();
        b(intent, this.f1422a);
    }

    public final void f(Intent intent) {
        Intent intent2 = new Intent("android.intent.action.SENDTO", intent.getData());
        intent2.setFlags(OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE);
        l.b();
        l.c(intent2);
        c(this.f1422a, intent2);
    }
}
