package com.android.contacts.voicemail.impl.sms;

import C1.a;
import R0.b;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telecom.PhoneAccountHandle;
import android.telephony.VisualVoicemailSms;
import java.io.Closeable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import t1.C1580a;
import z1.AbstractC1729d;

/* loaded from: classes.dex */
public class StatusSmsFetcher extends BroadcastReceiver implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public CompletableFuture<Bundle> f18190a = new CompletableFuture<>();

    /* renamed from: b, reason: collision with root package name */
    public final Context f18191b;

    /* renamed from: c, reason: collision with root package name */
    public final PhoneAccountHandle f18192c;

    public StatusSmsFetcher(Context context, PhoneAccountHandle phoneAccountHandle) {
        this.f18191b = context;
        this.f18192c = phoneAccountHandle;
        IntentFilter intentFilter = new IntentFilter("com.android.voicemailomtp.sms.REQUEST_SENT");
        intentFilter.addAction("com.android.vociemailomtp.sms.sms_received");
        context.registerReceiver(this, intentFilter, b.f3175i, null, 2);
    }

    public static String e(int i10) {
        if (i10 != -1) {
            if (i10 == 1 || i10 == 2 || i10 == 3 || i10 == 4) {
                return "RESULT_ERROR_GENERIC_FAILURE";
            }
            return "UNKNOWN CODE: " + i10;
        }
        return "OK";
    }

    public Bundle a() {
        C1580a.d();
        return this.f18190a.get(60000L, TimeUnit.MILLISECONDS);
    }

    public PendingIntent c() {
        Intent intent = new Intent("com.android.voicemailomtp.sms.REQUEST_SENT");
        intent.setPackage(this.f18191b.getPackageName());
        return PendingIntent.getBroadcast(this.f18191b, 0, intent, 335544320);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f18191b.unregisterReceiver(this);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Bundle i10;
        C1580a.c();
        if (intent != null && intent.getExtras() != null) {
            a.a("VvmStatusSmsFetcher", "intent " + intent.getAction());
            if ("com.android.voicemailomtp.sms.REQUEST_SENT".equals(intent.getAction())) {
                int resultCode = getResultCode();
                if (resultCode == -1) {
                    H7.b.b("VvmStatusSmsFetcher", "Request SMS successfully sent");
                    return;
                }
                H7.b.c("VvmStatusSmsFetcher", "Request SMS send failed: " + e(resultCode));
                this.f18190a.cancel(true);
                return;
            }
            VisualVoicemailSms visualVoicemailSms = (VisualVoicemailSms) intent.getExtras().getParcelable("extra_voicemail_sms");
            if (visualVoicemailSms != null && this.f18192c.equals(visualVoicemailSms.getPhoneAccountHandle())) {
                String prefix = visualVoicemailSms.getPrefix();
                if (prefix.equals("STATUS")) {
                    this.f18190a.complete(visualVoicemailSms.getFields());
                    return;
                }
                if (prefix.equals("SYNC")) {
                    return;
                }
                H7.b.e("VvmStatusSmsFetcher", "VVM SMS with event " + prefix + " received, attempting to translate to STATUS SMS");
                com.android.contacts.voicemail.impl.b bVar = new com.android.contacts.voicemail.impl.b(context, this.f18192c);
                AbstractC1729d l10 = bVar.l();
                if (l10 != null && (i10 = l10.i(bVar, prefix, visualVoicemailSms.getFields())) != null) {
                    H7.b.e("VvmStatusSmsFetcher", "Translated to STATUS SMS");
                    this.f18190a.complete(i10);
                }
            }
        }
    }
}
