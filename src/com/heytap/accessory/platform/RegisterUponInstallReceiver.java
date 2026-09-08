package com.heytap.accessory.platform;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.concurrent.Executors;

/* loaded from: classes3.dex */
public final class RegisterUponInstallReceiver extends BroadcastReceiver {
    private static String TAG = "RegisterUponInstallReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.heytap.accessory.platform.RegisterUponInstallReceiver.1
            @Override // java.lang.Runnable
            public void run() {
            }
        });
    }
}
