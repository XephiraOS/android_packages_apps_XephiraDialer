package com.android.contacts.voicemail.impl;

import C7.e;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import t1.l;

/* loaded from: classes.dex */
public class CarrierVvmPackageInstalledReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String l10 = e.l(intent, "android.intent.extra.PACKAGE_NAME");
            H7.b.e("CarrierVvmPackageInstalledReceiver.onReceive", "package installed: " + l10);
            if (!TextUtils.isEmpty(l10)) {
                l.a(context, l10);
            }
        }
    }
}
