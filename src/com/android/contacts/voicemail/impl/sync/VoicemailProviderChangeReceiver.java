package com.android.contacts.voicemail.impl.sync;

import B1.b;
import C7.e;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telecom.PhoneAccountHandle;
import android.text.TextUtils;
import s1.C1523a;
import w0.C1643c;

/* loaded from: classes.dex */
public class VoicemailProviderChangeReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null && TextUtils.equals(intent.getAction(), "android.intent.action.PROVIDER_CHANGED") && C1523a.b(context.getApplicationContext()).a() && !e.c(intent, "com.android.voicemail.extra.SELF_CHANGE", false)) {
            for (PhoneAccountHandle phoneAccountHandle : b.c(context)) {
                if (C1.b.c(context, phoneAccountHandle)) {
                    if (C1643c.q()) {
                        C1643c.K(context, phoneAccountHandle);
                    } else {
                        UploadTask.r(context, phoneAccountHandle);
                    }
                }
            }
        }
    }
}
