package com.android.contacts.voicemail.impl;

import A1.e;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telecom.PhoneAccountHandle;
import android.telephony.TelephonyManager;
import com.android.contacts.voicemail.impl.c;
import com.android.contacts.voicemail.impl.scheduling.BaseTask;
import com.android.contacts.voicemail.impl.scheduling.d;
import com.android.contacts.voicemail.impl.sms.StatusSmsFetcher;
import com.android.contacts.voicemail.impl.sync.SyncTask;
import com.android.contacts.voicemail.proguard.UsedByReflection;
import com.android.incallui.OplusAutoRedial;
import com.android.incallui.OplusPhoneUtils;
import com.oplus.compat.utils.util.UnSupportedApiVersionException;
import java.io.IOException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import t1.C1580a;
import z1.AbstractC1729d;

@UsedByReflection
/* loaded from: classes.dex */
public class ActivationTask extends BaseTask {

    /* renamed from: j, reason: collision with root package name */
    public final d f17944j;

    /* renamed from: k, reason: collision with root package name */
    public Bundle f17945k;

    public ActivationTask() {
        super(3);
        d dVar = new d(4, OplusAutoRedial.DELAY_FIVE_SECOND);
        this.f17944j = dVar;
        g(dVar);
    }

    public static void r(Context context, PhoneAccountHandle phoneAccountHandle) {
        Intent intent = new Intent("com.android.voicemail.VoicemailClient.ACTION_SHOW_LEGACY_VOICEMAIL");
        intent.setPackage(context.getPackageName());
        intent.putExtra("android.telephony.extra.PHONE_ACCOUNT_HANDLE", phoneAccountHandle);
        intent.putExtra("android.telephony.extra.NOTIFICATION_COUNT", 0);
        context.sendBroadcast(intent);
    }

    public static boolean s(Context context, PhoneAccountHandle phoneAccountHandle) {
        if (((TelephonyManager) context.getSystemService(TelephonyManager.class)).createForPhoneAccountHandle(phoneAccountHandle).getServiceState().getState() == 0) {
            return true;
        }
        return false;
    }

    public static boolean t(Context context) {
        if (G0.c.d(context, 1, "device_provisioned", 0) == 1) {
            return true;
        }
        return false;
    }

    public static void u(Context context, PhoneAccountHandle phoneAccountHandle) {
        new b(context, phoneAccountHandle).r(c.c(context, phoneAccountHandle), OmtpEvents.CONFIG_REQUEST_STATUS_SUCCESS);
        r(context, phoneAccountHandle);
        SyncTask.r(context, phoneAccountHandle, "full_sync");
    }

    public static void v(Context context, PhoneAccountHandle phoneAccountHandle, Bundle bundle) {
        if (!t(context)) {
            H7.b.e("VvmActivationTask", "Activation requested while device is not provisioned, postponing");
            DeviceProvisionedJobService.a(context, phoneAccountHandle);
        } else {
            Intent h10 = BaseTask.h(context, ActivationTask.class, phoneAccountHandle);
            if (bundle != null) {
                h10.putExtra("extra_message_data_bundle", bundle);
            }
            context.sendBroadcast(h10);
        }
    }

    public static void w(Context context, PhoneAccountHandle phoneAccountHandle, e eVar) {
        if (OplusPhoneUtils.DeviceState.UNLOCK_DEVICE.equals(eVar.e())) {
            H7.b.c("VvmActivationTask", "updateSource success");
            B1.b.b(context, phoneAccountHandle, eVar);
            u(context, phoneAccountHandle);
            return;
        }
        H7.b.c("VvmActivationTask", "Visual voicemail not available for subscriber.");
    }

    @Override // com.android.contacts.voicemail.impl.scheduling.e
    public void a() {
        Bundle bundle;
        C1580a.d();
        PhoneAccountHandle l10 = l();
        if (l10 == null) {
            H7.b.c("VvmActivationTask", "null PhoneAccountHandle");
            return;
        }
        t1.c.a(k(), l10);
        if (!C1.b.c(k(), l10)) {
            H7.b.e("VvmActivationTask", "VVM is disabled");
            return;
        }
        b bVar = new b(k(), l10);
        if (!bVar.w()) {
            H7.b.e("VvmActivationTask", "VVM not supported on phoneAccountHandle " + l10);
            B1.b.g(k(), l10);
            return;
        }
        for (PhoneAccountHandle phoneAccountHandle : B1.b.c(k())) {
            if (C1.b.c(k(), phoneAccountHandle)) {
                try {
                    if (P6.a.a(phoneAccountHandle) == D7.c.p(k())) {
                        H7.b.e("VvmActivationTask", "VVM default data phoneId's Account is already activated " + phoneAccountHandle);
                        return;
                    }
                    continue;
                } catch (UnSupportedApiVersionException e10) {
                    H7.b.c("VvmActivationTask", "UnSupportedApiVersionException e: " + e10);
                }
            }
        }
        if (!c.c(k(), l10).h(bVar.q()).a()) {
            H7.b.c("VvmActivationTask", "Failed to configure content provider - " + bVar.q());
            j();
        }
        H7.b.e("VvmActivationTask", "VVM content provider configured - " + bVar.q());
        if (B1.b.e(k(), l10)) {
            H7.b.e("VvmActivationTask", "Account is already activated");
            u(k(), l10);
            return;
        }
        bVar.r(c.c(k(), l10), OmtpEvents.CONFIG_ACTIVATING);
        if (!s(k(), l10)) {
            H7.b.e("VvmActivationTask", "Service lost during activation, aborting");
            bVar.r(c.c(k(), l10), OmtpEvents.NOTIFICATION_SERVICE_LOST);
            return;
        }
        bVar.a();
        c.b a10 = this.f17944j.a();
        AbstractC1729d l11 = bVar.l();
        if (this.f17945k != null) {
            H7.b.c("VvmActivationTask", "mMessageData != null");
            bundle = this.f17945k;
        } else {
            try {
                try {
                    StatusSmsFetcher statusSmsFetcher = new StatusSmsFetcher(k(), l10);
                    try {
                        l11.e(bVar, statusSmsFetcher.c());
                        Bundle a11 = statusSmsFetcher.a();
                        statusSmsFetcher.close();
                        bundle = a11;
                    } catch (Throwable th) {
                        try {
                            statusSmsFetcher.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } catch (IOException | InterruptedException | ExecutionException e11) {
                    H7.b.c("VvmActivationTask", "can't get future STATUS SMS" + e11);
                    j();
                    return;
                }
            } catch (CancellationException e12) {
                H7.b.c("VvmActivationTask", "Unable to send status request SMS " + e12);
                j();
                return;
            } catch (TimeoutException e13) {
                H7.b.c("VvmActivationTask", "Unable to send status request SMS " + e13);
                bVar.r(a10, OmtpEvents.CONFIG_STATUS_SMS_TIME_OUT);
                j();
                return;
            }
        }
        e eVar = new e(bundle);
        H7.b.b("VvmActivationTask", "StatusMessage " + eVar);
        H7.b.b("VvmActivationTask", "STATUS SMS received: st=" + eVar.d() + ", rc=" + eVar.e());
        if (eVar.d().equals("R")) {
            H7.b.b("VvmActivationTask", "subscriber ready, no activation required");
            w(k(), l10, eVar);
        } else if (bVar.B()) {
            H7.b.e("VvmActivationTask", "Subscriber not ready, start provisioning");
            bVar.A(this, l10, a10, eVar, bundle);
        } else if (eVar.d().equals("N")) {
            H7.b.e("VvmActivationTask", "Subscriber new but provisioning is not supported");
            w(k(), l10, eVar);
        } else {
            H7.b.e("VvmActivationTask", "Subscriber not ready but provisioning is not supported");
            bVar.r(a10, OmtpEvents.CONFIG_SERVICE_NOT_AVAILABLE);
        }
    }

    @Override // com.android.contacts.voicemail.impl.scheduling.BaseTask, com.android.contacts.voicemail.impl.scheduling.e
    public void e(Context context, Bundle bundle) {
        super.e(context, bundle);
        this.f17945k = (Bundle) bundle.getParcelable("extra_message_data_bundle");
    }

    @Override // com.android.contacts.voicemail.impl.scheduling.BaseTask
    public Intent i() {
        return super.i();
    }
}
