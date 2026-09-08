package com.android.contacts.calllog;

import android.app.IntentService;
import android.content.Intent;
import android.net.Uri;

/* loaded from: classes.dex */
public class CallLogNotificationsService extends IntentService {

    /* renamed from: a, reason: collision with root package name */
    public r f13765a;

    public CallLogNotificationsService() {
        super("CallLogNotificationsService");
    }

    @Override // android.app.IntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f13765a = new r(getContentResolver(), null);
    }

    @Override // android.app.IntentService
    public void onHandleIntent(Intent intent) {
        if (intent == null) {
            H7.b.b("CallLogNotifications", "onHandleIntent: could not handle null intent");
            return;
        }
        if ("com.android.contacts.calllog.ACTION_MARK_NEW_VOICEMAILS_AS_OLD".equals(intent.getAction())) {
            this.f13765a.q();
            return;
        }
        if ("com.android.contacts.calllog.UPDATE_NOTIFICATIONS".equals(intent.getAction())) {
            D.f(this).h((Uri) C7.e.j(intent, "NEW_VOICEMAIL_URI"));
        } else {
            H7.b.b("CallLogNotifications", "onHandleIntent: could not handle: " + intent);
        }
    }
}
