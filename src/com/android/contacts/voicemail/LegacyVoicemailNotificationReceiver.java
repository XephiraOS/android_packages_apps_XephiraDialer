package com.android.contacts.voicemail;

import C7.e;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telecom.PhoneAccountHandle;
import com.android.contacts.voicemail.impl.LegacyVoicemailService;
import com.android.contacts.voicemail.impl.OmtpService;
import s1.C1523a;
import t1.k;
import w0.C1643c;

/* loaded from: classes.dex */
public class LegacyVoicemailNotificationReceiver extends BroadcastReceiver {
    public static D1.b a(Context context, PhoneAccountHandle phoneAccountHandle) {
        return new D1.b(context, phoneAccountHandle, C1523a.c(context));
    }

    public static void b(Context context, PhoneAccountHandle phoneAccountHandle, boolean z10) {
        a(context, phoneAccountHandle).d().b("legacy_voicemail_dismissed", z10).a();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C1.a.d("LegacyVoicemailNotificationReceiver", "received legacy voicemail notification");
        if (intent != null && context != null) {
            if (!"android.telephony.action.SHOW_VOICEMAIL_NOTIFICATION".equals(intent.getAction()) && !"com.android.voicemail.VoicemailClient.ACTION_SHOW_LEGACY_VOICEMAIL".equals(intent.getAction())) {
                return;
            }
            PhoneAccountHandle phoneAccountHandle = (PhoneAccountHandle) e.j(intent, "android.telephony.extra.PHONE_ACCOUNT_HANDLE");
            if (phoneAccountHandle == null) {
                C1.a.d("LegacyVoicemailNotificationReceiver.onReceive", "phoneAccountHandle == null");
                return;
            }
            boolean c10 = e.c(intent, "android.telephony.extra.IS_REFRESH", false);
            C1.a.d("LegacyVoicemailNotificationReceiver.onReceive", "isRefresh: " + c10);
            D1.b a10 = a(context, phoneAccountHandle);
            if (c10) {
                if (a10.e("legacy_voicemail_dismissed", false)) {
                    C1.a.d("LegacyVoicemailNotificationReceiver", "notification dismissed, ignoring refresh");
                    return;
                }
            } else {
                b(context, phoneAccountHandle, false);
            }
            int d10 = e.d(intent, "android.telephony.extra.NOTIFICATION_COUNT", -1);
            if (d10 != -1 && d10 == 0) {
                C1.a.d("LegacyVoicemailNotificationReceiver", "clearing notification");
                s1.e.a(context);
                return;
            }
            if (C1643c.q()) {
                k.a("LegacyVoicemailNotificationReceiver", "syncByLegacyVoicemailNotification");
                if (C1643c.L(intent, context, phoneAccountHandle)) {
                    return;
                }
            } else if (!e.c(intent, "is_legacy_mode", false) && OmtpService.d(context) && C1523a.b(context.getApplicationContext()).d(context, phoneAccountHandle)) {
                C1.a.d("LegacyVoicemailNotificationReceiver", "visual voicemail is activated, ignoring notification");
                return;
            }
            C1.a.d("LegacyVoicemailNotificationReceiver", "sending notification");
            context.startService(LegacyVoicemailService.a(context, intent));
            return;
        }
        C1.a.d("LegacyVoicemailNotificationReceiver", "intent == null || context == null");
    }
}
