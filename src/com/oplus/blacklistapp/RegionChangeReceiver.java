package com.oplus.blacklistapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.oplus.utils.C0846g;

/* loaded from: classes3.dex */
public class RegionChangeReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C0846g.i("RegionChangeReceiver", "RegionChangeReceiver");
        if (F6.a.q(intent.getAction())) {
            l7.b.n(context);
        }
    }
}
