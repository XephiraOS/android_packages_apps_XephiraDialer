package com.customize.contacts.receiver;

import H7.b;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.customize.contacts.util.C0801l;
import r0.C1498a;

/* loaded from: classes3.dex */
public class OtaUpgradeReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null && context != null) {
            String action = intent.getAction();
            b.b("ContatcsOtaUpgradeReceiver", "--onReceive--action = " + action);
            if (C1498a.f36257p.equals(action) || C1498a.f36258q.equals(action)) {
                b.b("ContatcsOtaUpgradeReceiver", "receive ota broadcast to update call record table");
                C0801l.t(context);
            }
        }
    }
}
