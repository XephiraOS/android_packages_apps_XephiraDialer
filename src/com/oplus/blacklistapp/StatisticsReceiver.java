package com.oplus.blacklistapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/* loaded from: classes3.dex */
public class StatisticsReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        Log.i("StatisticsReceiver", "onReceive--------------action = " + intent.getAction());
        try {
            context.startService(new Intent(context, (Class<?>) StatisticsService.class));
        } catch (Exception e10) {
            Log.e("StatisticsReceiver", "start StatisticsService error " + e10);
        }
    }
}
