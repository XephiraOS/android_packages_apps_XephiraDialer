package com.android.contacts.voicemail;

import C7.e;
import D1.c;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telecom.PhoneAccountHandle;
import android.text.TextUtils;

/* loaded from: classes.dex */
public class VvmStatusReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        PhoneAccountHandle phoneAccountHandle;
        if (intent != null && TextUtils.equals(intent.getAction(), "oplus.intent.action.vvm_switch_status") && B3.a.W()) {
            try {
                phoneAccountHandle = (PhoneAccountHandle) e.j(intent, "phoneAccountHandle");
            } catch (Exception e10) {
                H7.b.c("VvmStatusReceiver", "" + e10);
                phoneAccountHandle = null;
            }
            boolean c10 = e.c(intent, "isCheck", true);
            C1.a.a("VvmStatusReceiver", "phoneAccountHandle " + phoneAccountHandle + " isChecked " + c10);
            if (phoneAccountHandle != null) {
                new c(context, phoneAccountHandle).d().b("is_setting_enabled", c10).a();
                C1.b.d(context, phoneAccountHandle, c10);
            }
        }
    }
}
