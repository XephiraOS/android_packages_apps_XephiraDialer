package t1;

import android.app.PendingIntent;
import android.content.Context;
import android.telecom.PhoneAccountHandle;
import android.telephony.TelephonyManager;
import android.telephony.VisualVoicemailService;
import android.telephony.VisualVoicemailSmsFilterSettings;
import java.lang.reflect.Method;

/* compiled from: TelephonyMangerCompat.java */
/* loaded from: classes.dex */
public class d {
    public static String a(Context context, PhoneAccountHandle phoneAccountHandle, String str, int i10, String str2, PendingIntent pendingIntent) {
        try {
            Method method = TelephonyManager.class.getMethod("sendVisualVoicemailSms", String.class, Integer.TYPE, String.class, PendingIntent.class);
            try {
                try {
                    C1.a.d("TelephonyMangerCompat.sendVisualVoicemailSms", "using TelephonyManager");
                    return (String) method.invoke(((TelephonyManager) context.getSystemService(TelephonyManager.class)).createForPhoneAccountHandle(phoneAccountHandle), str, Integer.valueOf(i10), str2, pendingIntent);
                } catch (ReflectiveOperationException e10) {
                    throw new RuntimeException(e10);
                }
            } catch (ReflectiveOperationException e11) {
                throw new RuntimeException(e11);
            }
        } catch (NoSuchMethodException unused) {
            C1.a.d("TelephonyMangerCompat.sendVisualVoicemailSms", "using VisualVoicemailService");
            return (String) VisualVoicemailService.class.getMethod("sendVisualVoicemailSms", Context.class, PhoneAccountHandle.class, String.class, Short.TYPE, String.class, PendingIntent.class).invoke(null, context, phoneAccountHandle, str, Short.valueOf((short) i10), str2, pendingIntent);
        }
    }

    public static String b(Context context, PhoneAccountHandle phoneAccountHandle, VisualVoicemailSmsFilterSettings visualVoicemailSmsFilterSettings) {
        try {
            Method method = TelephonyManager.class.getMethod("setVisualVoicemailSmsFilterSettings", VisualVoicemailSmsFilterSettings.class);
            try {
                try {
                    C1.a.d("TelephonyMangerCompat.setVisualVoicemailSmsFilterSettings", "using TelephonyManager");
                    return (String) method.invoke(((TelephonyManager) context.getSystemService(TelephonyManager.class)).createForPhoneAccountHandle(phoneAccountHandle), visualVoicemailSmsFilterSettings);
                } catch (ReflectiveOperationException e10) {
                    throw new RuntimeException(e10);
                }
            } catch (ReflectiveOperationException e11) {
                throw new RuntimeException(e11);
            }
        } catch (NoSuchMethodException unused) {
            C1.a.d("TelephonyMangerCompat.setVisualVoicemailSmsFilterSettings", "using VisualVoicemailService");
            return (String) VisualVoicemailService.class.getMethod("setSmsFilterSettings", Context.class, PhoneAccountHandle.class, VisualVoicemailSmsFilterSettings.class).invoke(null, context, phoneAccountHandle, visualVoicemailSmsFilterSettings);
        }
    }
}
