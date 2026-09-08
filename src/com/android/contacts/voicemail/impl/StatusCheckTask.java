package com.android.contacts.voicemail.impl;

import A1.e;
import android.content.Context;
import android.os.Bundle;
import android.telecom.PhoneAccountHandle;
import android.telephony.TelephonyManager;
import com.android.contacts.voicemail.impl.scheduling.BaseTask;
import com.android.contacts.voicemail.impl.sms.StatusSmsFetcher;
import com.android.contacts.voicemail.proguard.UsedByReflection;
import java.io.IOException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

@UsedByReflection
/* loaded from: classes.dex */
public class StatusCheckTask extends BaseTask {
    public StatusCheckTask() {
        super(4);
    }

    public static void r(Context context, PhoneAccountHandle phoneAccountHandle) {
        context.sendBroadcast(BaseTask.h(context, StatusCheckTask.class, phoneAccountHandle));
    }

    @Override // com.android.contacts.voicemail.impl.scheduling.e
    public void a() {
        TelephonyManager createForPhoneAccountHandle = ((TelephonyManager) k().getSystemService(TelephonyManager.class)).createForPhoneAccountHandle(l());
        if (createForPhoneAccountHandle == null) {
            H7.b.i("StatusCheckTask.onExecuteInBackgroundThread", l() + " no longer valid");
            return;
        }
        if (createForPhoneAccountHandle.getServiceState().getState() != 0) {
            H7.b.e("StatusCheckTask.onExecuteInBackgroundThread", l() + " not in service");
            return;
        }
        b bVar = new b(k(), l());
        if (!bVar.w()) {
            H7.b.c("StatusCheckTask.onExecuteInBackgroundThread", "config no longer valid for " + l());
            B1.b.g(k(), l());
            return;
        }
        try {
            try {
                StatusSmsFetcher statusSmsFetcher = new StatusSmsFetcher(k(), l());
                try {
                    bVar.l().d(bVar, statusSmsFetcher.c());
                    Bundle a10 = statusSmsFetcher.a();
                    statusSmsFetcher.close();
                    e eVar = new e(a10);
                    H7.b.e("StatusCheckTask.onExecuteInBackgroundThread", "STATUS SMS received: st=" + eVar.d() + ", rc=" + eVar.e());
                    if (eVar.d().equals("R")) {
                        H7.b.e("StatusCheckTask.onExecuteInBackgroundThread", "subscriber ready, no activation required");
                        B1.b.b(k(), l(), eVar);
                    } else {
                        H7.b.e("StatusCheckTask.onExecuteInBackgroundThread", "subscriber not ready, attempting reactivation");
                        B1.b.g(k(), l());
                        ActivationTask.v(k(), l(), a10);
                    }
                } catch (Throwable th) {
                    try {
                        statusSmsFetcher.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException | InterruptedException | ExecutionException e10) {
                H7.b.c("StatusCheckTask.onExecuteInBackgroundThread", "can't get future STATUS SMS" + e10);
            }
        } catch (CancellationException unused) {
            H7.b.c("StatusCheckTask.onExecuteInBackgroundThread", "Unable to send status request SMS");
        } catch (TimeoutException unused2) {
            H7.b.c("StatusCheckTask.onExecuteInBackgroundThread", "timeout requesting status");
        }
    }
}
