package com.customize.contacts.receiver;

import C7.e;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.customize.contacts.util.Y;
import java.util.ArrayList;
import r0.C1498a;

/* loaded from: classes3.dex */
public class RomUpdateReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        ArrayList<String> k10;
        if (C1498a.f36248g.equals(intent.getAction()) && (k10 = e.k(intent, "ROM_UPDATE_CONFIG_LIST")) != null && !k10.isEmpty() && k10.contains("comm_contacts_romupdate_values")) {
            Y.b(context);
        }
    }
}
