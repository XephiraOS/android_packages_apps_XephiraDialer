package com.android.contacts.framework.rcs;

import C7.e;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.juphoon.helper.RcsBroadcastHelper;
import kotlin.jvm.internal.i;

/* compiled from: RcsWakeupReceiver.kt */
/* loaded from: classes.dex */
public final class RcsWakeupReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        i.f(context, "context");
        i.f(intent, "intent");
        String l10 = e.l(intent, "rcs_json_key");
        if (l10 != null) {
            RcsBroadcastHelper.c(intent.getAction(), l10);
        }
    }
}
