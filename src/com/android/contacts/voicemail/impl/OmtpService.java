package com.android.contacts.voicemail.impl;

import P7.e;
import android.content.Context;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.telecom.PhoneAccountHandle;
import android.telephony.VisualVoicemailService;
import android.telephony.VisualVoicemailSms;
import s1.C1523a;
import t1.k;
import w0.C1643c;

/* loaded from: classes.dex */
public class OmtpService extends VisualVoicemailService {
    public static boolean c(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("com.android.voicemail.impl.is_shutting_down", false);
    }

    public static boolean d(Context context) {
        return e.d(context);
    }

    public final boolean a() {
        return C1523a.b(getApplicationContext()).a();
    }

    public final boolean b(PhoneAccountHandle phoneAccountHandle) {
        b bVar = new b(this, phoneAccountHandle);
        if (!bVar.w()) {
            H7.b.e("VvmOmtpService", "VVM not supported");
            return false;
        }
        if (!C1.b.c(this, phoneAccountHandle) && !bVar.u()) {
            H7.b.e("VvmOmtpService", "VVM is disabled");
            return false;
        }
        if (!B3.a.W()) {
            return false;
        }
        return true;
    }

    @Override // android.telephony.VisualVoicemailService
    public void onCellServiceConnected(VisualVoicemailService.VisualVoicemailTask visualVoicemailTask, PhoneAccountHandle phoneAccountHandle) {
        H7.b.e("VvmOmtpService", "onCellServiceConnected");
        if (!a()) {
            H7.b.c("VvmOmtpService", "onCellServiceConnected received when module is disabled");
            visualVoicemailTask.finish();
            return;
        }
        if (!d(this)) {
            H7.b.e("VvmOmtpService", "onCellServiceConnected: user locked");
            visualVoicemailTask.finish();
        } else {
            if (!b(phoneAccountHandle)) {
                visualVoicemailTask.finish();
                return;
            }
            if (C1643c.q()) {
                C1643c.H(this, phoneAccountHandle, null);
                k.a("VvmOmtpService", "OPActivationTask");
            } else {
                ActivationTask.v(this, phoneAccountHandle, null);
            }
            visualVoicemailTask.finish();
        }
    }

    @Override // android.telephony.VisualVoicemailService
    public void onSimRemoved(VisualVoicemailService.VisualVoicemailTask visualVoicemailTask, PhoneAccountHandle phoneAccountHandle) {
        H7.b.e("VvmOmtpService", "onSimRemoved");
        if (!a()) {
            H7.b.c("VvmOmtpService", "onSimRemoved called when module is disabled");
            visualVoicemailTask.finish();
            return;
        }
        if (!d(this)) {
            H7.b.e("VvmOmtpService", "onSimRemoved: user locked");
            visualVoicemailTask.finish();
        } else if (c(this)) {
            H7.b.e("VvmOmtpService", "onSimRemoved: system shutting down, ignoring");
            visualVoicemailTask.finish();
        } else {
            if (C1643c.q()) {
                C1643c.A();
            }
            B1.b.g(this, phoneAccountHandle);
            visualVoicemailTask.finish();
        }
    }

    @Override // android.telephony.VisualVoicemailService
    public void onSmsReceived(VisualVoicemailService.VisualVoicemailTask visualVoicemailTask, VisualVoicemailSms visualVoicemailSms) {
        H7.b.e("VvmOmtpService", "onSmsReceived");
        if (C1643c.q()) {
            visualVoicemailTask.finish();
            return;
        }
        if (!a()) {
            H7.b.c("VvmOmtpService", "onSmsReceived received when module is disabled");
            visualVoicemailTask.finish();
            return;
        }
        if (!d(this)) {
            A1.a.b(this, visualVoicemailSms);
            return;
        }
        if (!b(visualVoicemailSms.getPhoneAccountHandle())) {
            visualVoicemailTask.finish();
            return;
        }
        Intent intent = new Intent("com.android.vociemailomtp.sms.sms_received");
        intent.setPackage(getPackageName());
        intent.putExtra("extra_voicemail_sms", visualVoicemailSms);
        sendBroadcast(intent);
        visualVoicemailTask.finish();
    }

    @Override // android.telephony.VisualVoicemailService
    public void onStopped(VisualVoicemailService.VisualVoicemailTask visualVoicemailTask) {
        H7.b.e("VvmOmtpService", "onStopped");
        if (!a()) {
            H7.b.c("VvmOmtpService", "onStopped called when module is disabled");
            visualVoicemailTask.finish();
        } else if (!d(this)) {
            H7.b.e("VvmOmtpService", "onStopped: user locked");
            visualVoicemailTask.finish();
        }
    }
}
