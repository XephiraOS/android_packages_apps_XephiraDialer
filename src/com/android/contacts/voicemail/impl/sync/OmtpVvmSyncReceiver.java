package com.android.contacts.voicemail.impl.sync;

import C7.e;
import H7.b;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telecom.PhoneAccountHandle;
import android.telecom.TelecomManager;
import com.android.contacts.voicemail.impl.ActivationTask;
import s1.C1523a;
import w0.C1643c;

/* loaded from: classes.dex */
public class OmtpVvmSyncReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (C1523a.b(context.getApplicationContext()).a() && "android.provider.action.SYNC_VOICEMAIL".equals(intent.getAction())) {
            b.h("OmtpVvmSyncReceiver", "Sync intent received");
            for (PhoneAccountHandle phoneAccountHandle : ((TelecomManager) context.getSystemService(TelecomManager.class)).getCallCapablePhoneAccounts()) {
                if (C1.b.c(context, phoneAccountHandle)) {
                    if (C1643c.q()) {
                        boolean c10 = e.c(intent, "fullSync", false);
                        boolean c11 = e.c(intent, "should_show_toast", false);
                        if (!B1.b.e(context, phoneAccountHandle)) {
                            b.e("OmtpVvmSyncReceiver", "Unactivated account " + phoneAccountHandle + " found, activating");
                            C1643c.H(context, phoneAccountHandle, null);
                        } else if (c10) {
                            C1643c.J(context, phoneAccountHandle, c10);
                        } else {
                            C1643c.I(context, phoneAccountHandle, c10, c11);
                        }
                    } else if (!B1.b.e(context, phoneAccountHandle)) {
                        b.e("OmtpVvmSyncReceiver", "Unactivated account " + phoneAccountHandle + " found, activating");
                        ActivationTask.v(context, phoneAccountHandle, null);
                    } else {
                        SyncTask.r(context, phoneAccountHandle, "full_sync");
                    }
                }
            }
        }
    }
}
