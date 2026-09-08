package com.android.contacts.framework.appstore.missedcall;

import H7.b;
import J0.c;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes.dex */
public final class MissedCallBroadcastReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        b.b("MissedCallBroadcastReceiver", "onReceive");
        new c(context).d(intent);
    }
}
