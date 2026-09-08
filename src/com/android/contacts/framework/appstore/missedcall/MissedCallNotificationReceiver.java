package com.android.contacts.framework.appstore.missedcall;

import C7.e;
import H7.b;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.oplus.foundation.util.ui.a;

/* loaded from: classes.dex */
public class MissedCallNotificationReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null && context != null) {
            if (!"android.telecom.action.SHOW_MISSED_CALLS_NOTIFICATION".equals(intent.getAction())) {
                return;
            }
            a.a(context, e.d(intent, "android.telecom.extra.NOTIFICATION_COUNT", -1));
            context.startService(MissedCallNotificationService.a(context, intent));
            return;
        }
        b.e("MissedCallNotificationReceiver", "intent == null || context == null");
    }
}
