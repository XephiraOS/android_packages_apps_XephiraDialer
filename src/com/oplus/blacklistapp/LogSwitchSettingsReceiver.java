package com.oplus.blacklistapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.oplus.utils.C0846g;

/* loaded from: classes3.dex */
public class LogSwitchSettingsReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("blacklist.log.switch.broadcast".equals(intent.getAction())) {
            C0846g.l(context);
        }
    }
}
