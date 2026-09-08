package A1;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telecom.PhoneAccountHandle;
import android.telephony.TelephonyManager;
import android.telephony.VisualVoicemailSms;

/* compiled from: LegacyModeSmsHandler.java */
/* loaded from: classes.dex */
public class a {
    public static String a(Context context, PhoneAccountHandle phoneAccountHandle) {
        TelephonyManager createForPhoneAccountHandle = ((TelephonyManager) context.getSystemService(TelephonyManager.class)).createForPhoneAccountHandle(phoneAccountHandle);
        if (createForPhoneAccountHandle == null) {
            return null;
        }
        return createForPhoneAccountHandle.getVoiceMailNumber();
    }

    public static void b(Context context, VisualVoicemailSms visualVoicemailSms) {
        H7.b.e("LegacyModeSmsHandler", "processing VVM SMS on legacy mode");
        String prefix = visualVoicemailSms.getPrefix();
        Bundle fields = visualVoicemailSms.getFields();
        PhoneAccountHandle phoneAccountHandle = visualVoicemailSms.getPhoneAccountHandle();
        if (prefix.equals("SYNC")) {
            f fVar = new f(fields);
            H7.b.e("LegacyModeSmsHandler", "Received SYNC sms for " + phoneAccountHandle + " with event " + fVar.f());
            String f10 = fVar.f();
            f10.hashCode();
            if (f10.equals("NM") || f10.equals("MBU")) {
                c(context, phoneAccountHandle, fVar.getNewMessageCount());
            }
        }
    }

    public static void c(Context context, PhoneAccountHandle phoneAccountHandle, int i10) {
        PendingIntent activity;
        H7.b.e("LegacyModeSmsHandler", "sending voicemail notification");
        Intent intent = new Intent("com.android.voicemail.VoicemailClient.ACTION_SHOW_LEGACY_VOICEMAIL");
        intent.setPackage(context.getPackageName());
        intent.putExtra("android.telephony.extra.PHONE_ACCOUNT_HANDLE", phoneAccountHandle);
        intent.putExtra("android.telephony.extra.NOTIFICATION_COUNT", i10);
        String a10 = a(context, phoneAccountHandle);
        PendingIntent pendingIntent = null;
        if (a10 != null) {
            pendingIntent = PendingIntent.getActivity(context, 1, new Intent("android.intent.action.CALL", Uri.fromParts("voicemail", "", null)), 201326592);
            activity = null;
        } else {
            Intent intent2 = new Intent("android.telephony.action.CONFIGURE_VOICEMAIL");
            intent2.putExtra("android.telephony.extra.HIDE_PUBLIC_SETTINGS", true);
            activity = PendingIntent.getActivity(context, 2, intent2, 201326592);
        }
        intent.putExtra("android.telephony.extra.VOICEMAIL_NUMBER", a10);
        intent.putExtra("android.telephony.extra.CALL_VOICEMAIL_INTENT", pendingIntent);
        intent.putExtra("android.telephony.extra.LAUNCH_VOICEMAIL_SETTINGS_INTENT", activity);
        context.sendBroadcast(intent);
    }
}
