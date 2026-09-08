package com.android.contacts.voicemail.impl.sms;

import A1.f;
import B1.a;
import C1.c;
import H7.b;
import P7.e;
import android.content.BroadcastReceiver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telecom.PhoneAccountHandle;
import android.telephony.VisualVoicemailSms;
import android.text.TextUtils;
import com.android.contacts.voicemail.impl.ActivationTask;
import com.android.contacts.voicemail.impl.Voicemail;
import com.android.contacts.voicemail.impl.sync.SyncOneTask;
import com.android.contacts.voicemail.impl.sync.SyncTask;
import s1.v;

/* loaded from: classes.dex */
public class OmtpMessageReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public Context f18189a;

    public final void a(PhoneAccountHandle phoneAccountHandle, f fVar) {
        Uri b10;
        String f10 = fVar.f();
        f10.hashCode();
        char c10 = 65535;
        switch (f10.hashCode()) {
            case 2286:
                if (f10.equals("GU")) {
                    c10 = 0;
                    break;
                }
                break;
            case 2495:
                if (f10.equals("NM")) {
                    c10 = 1;
                    break;
                }
                break;
            case 76128:
                if (f10.equals("MBU")) {
                    c10 = 2;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                return;
            case 1:
                if (!v.f36673e.equals(fVar.getContentType())) {
                    b.e("OmtpMessageReceiver", "Non-voice message of type '" + fVar.getContentType() + "' received, ignoring");
                    return;
                }
                Voicemail.b h10 = Voicemail.b(fVar.g(), fVar.d()).f(phoneAccountHandle).g(fVar.a()).b(fVar.c()).h(this.f18189a.getPackageName());
                Voicemail a10 = h10.a();
                if (new a(this.f18189a).g(a10) && (b10 = c.b(this.f18189a, a10)) != null) {
                    C1.a.a("OmtpMessageReceiver", "uri " + b10);
                    SyncOneTask.r(this.f18189a, phoneAccountHandle, h10.c(ContentUris.parseId(b10)).k(b10).a());
                    return;
                }
                return;
            case 2:
                SyncTask.r(this.f18189a, phoneAccountHandle, "download_only");
                return;
            default:
                b.c("OmtpMessageReceiver", "Unrecognized sync trigger event: " + fVar.f());
                return;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            if (!TextUtils.equals(intent.getAction(), "com.android.vociemailomtp.sms.sms_received")) {
                return;
            }
            this.f18189a = context;
            VisualVoicemailSms visualVoicemailSms = (VisualVoicemailSms) intent.getExtras().getParcelable("extra_voicemail_sms");
            PhoneAccountHandle phoneAccountHandle = visualVoicemailSms.getPhoneAccountHandle();
            if (phoneAccountHandle == null) {
                b.e("OmtpMessageReceiver", "Received message for null phone account");
                return;
            }
            if (!e.d(context)) {
                b.e("OmtpMessageReceiver", "Received message on locked device");
                A1.a.b(context, visualVoicemailSms);
                return;
            }
            com.android.contacts.voicemail.impl.b bVar = new com.android.contacts.voicemail.impl.b(this.f18189a, phoneAccountHandle);
            if (!bVar.w()) {
                b.c("OmtpMessageReceiver", "vvm config no longer valid");
                return;
            }
            if (!C1.b.c(this.f18189a, phoneAccountHandle)) {
                if (bVar.u()) {
                    A1.a.b(context, visualVoicemailSms);
                    return;
                } else {
                    b.e("OmtpMessageReceiver", "Received vvm message for disabled vvm source.");
                    return;
                }
            }
            String prefix = visualVoicemailSms.getPrefix();
            Bundle fields = visualVoicemailSms.getFields();
            if (prefix != null && fields != null) {
                if (prefix.equals("SYNC")) {
                    f fVar = new f(fields);
                    b.h("OmtpMessageReceiver", "Received SYNC sms for " + phoneAccountHandle + " with event " + fVar.f());
                    a(phoneAccountHandle, fVar);
                    return;
                }
                if (prefix.equals("STATUS")) {
                    b.h("OmtpMessageReceiver", "Received Status sms for " + phoneAccountHandle);
                    ActivationTask.v(context, phoneAccountHandle, fields);
                    return;
                }
                b.i("OmtpMessageReceiver", "Unknown prefix: " + prefix);
                if (bVar.l() != null && bVar.l().i(bVar, prefix, fields) != null) {
                    b.e("OmtpMessageReceiver", "Protocol recognized the SMS as STATUS, activating");
                    ActivationTask.v(context, phoneAccountHandle, fields);
                    return;
                }
                return;
            }
            b.c("OmtpMessageReceiver", "Unparsable VVM SMS received, ignoring");
        } catch (Exception e10) {
            C1.a.b("OmtpMessageReceiver", "OmtpMessageReceiver onReceive error " + e10);
        }
    }
}
