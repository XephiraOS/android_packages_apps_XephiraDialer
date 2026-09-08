package com.customize.contacts.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.customize.contacts.feature.OSPublicFeature;
import r0.C1498a;

/* loaded from: classes3.dex */
public class RegionChangeReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (C1498a.f36267z.equals(intent.getAction())) {
            OSPublicFeature.H();
        }
    }
}
