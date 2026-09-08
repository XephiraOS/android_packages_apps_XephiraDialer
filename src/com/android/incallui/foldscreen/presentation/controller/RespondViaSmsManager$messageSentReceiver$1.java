package com.android.incallui.foldscreen.presentation.controller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.android.incallui.Log;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: RespondViaSmsManager.kt */
/* loaded from: classes.dex */
public final class RespondViaSmsManager$messageSentReceiver$1 extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f18421a = new AtomicBoolean(false);

    public final void a(Context context) {
        if (context == null) {
            Log.d("RespondViaSmsManager", "messageSentReceiver registerReceiver: context is null, ignore");
        } else if (!this.f18421a.compareAndSet(false, true)) {
            Log.d("RespondViaSmsManager", "messageSentReceiver registerReceiver: receiver has registered, ignore");
        } else {
            Log.d("RespondViaSmsManager", "messageSentReceiver registerReceiver: ");
            context.registerReceiver(this, new IntentFilter("com.android.server.telecom.MESSAGE_SENT"), 2);
        }
    }

    public final void b(Context context) {
        if (context == null) {
            Log.d("RespondViaSmsManager", "messageSentReceiver unregisterReceiver: context is null, ignore");
        } else if (!this.f18421a.compareAndSet(true, false)) {
            Log.d("RespondViaSmsManager", "messageSentReceiver unregisterReceiver: receiver has unregistered, ignore");
        } else {
            Log.d("RespondViaSmsManager", "messageSentReceiver unregisterReceiver: ");
            context.unregisterReceiver(this);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        b(context);
        RespondViaSmsManager.f18413a.e(getResultCode());
    }
}
