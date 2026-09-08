package com.android.contacts.voicemail.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telecom.PhoneAccountHandle;
import com.android.contacts.voicemail.impl.sync.UploadTask;
import s1.C1523a;
import t1.C1580a;
import t1.k;
import w0.C1643c;

/* loaded from: classes.dex */
public class VoicemailClientReceiver extends BroadcastReceiver {
    public static void a(Context context) {
        C1.a.d("VoicemailClientReceiver.onReceive", "ACTION_UPLOAD received");
        for (PhoneAccountHandle phoneAccountHandle : B1.b.c(context)) {
            if (C1643c.q()) {
                C1643c.K(context, phoneAccountHandle);
                k.a("VoicemailClientReceiver.onReceive", "OPUploadTask");
            } else {
                UploadTask.r(context, phoneAccountHandle);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            C1.a.d("VoicemailClientReceiver.onReceive", "intent is null");
            return;
        }
        if (!C1523a.b(context).a()) {
            C1.a.d("VoicemailClientReceiver.onReceive", "module disabled, ignoring " + intent.getAction());
            return;
        }
        String action = intent.getAction();
        action.hashCode();
        if (!action.equals("com.android.voicemail.VoicemailClient.ACTION_UPLOAD")) {
            C1580a.b("Unexpected action " + intent.getAction());
            return;
        }
        a(context);
    }
}
