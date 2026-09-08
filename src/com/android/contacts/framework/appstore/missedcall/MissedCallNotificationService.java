package com.android.contacts.framework.appstore.missedcall;

import C7.e;
import H7.b;
import J0.k;
import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes.dex */
public class MissedCallNotificationService extends IntentService {
    public MissedCallNotificationService() {
        super("MissedCallNotificationService");
    }

    public static Intent a(Context context, Intent intent) {
        Intent intent2 = new Intent(context, (Class<?>) MissedCallNotificationService.class);
        intent2.setAction("createMissCallNotification");
        intent2.putExtra("extraIntent", intent);
        return intent2;
    }

    @Override // android.app.IntentService
    public void onHandleIntent(Intent intent) {
        if (intent == null) {
            b.b("MissedCallNotificationService", "MissedCallNotificationService onHandleIntent: could not handle null intent");
            return;
        }
        if ("createMissCallNotification".equals(intent.getAction())) {
            Intent intent2 = (Intent) e.j(intent, "extraIntent");
            if (intent2 == null) {
                return;
            }
            k.n(this).s(e.d(intent2, "android.telecom.extra.NOTIFICATION_COUNT", -1), e.l(intent2, "android.telecom.extra.NOTIFICATION_PHONE_NUMBER"));
            return;
        }
        b.b("MissedCallNotificationService", "onHandleIntent: could not handle: " + intent);
    }
}
