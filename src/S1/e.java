package s1;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.service.notification.StatusBarNotification;
import android.telecom.PhoneAccountHandle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.oplus.dialer.R;
import java.util.regex.Pattern;
import t1.C1580a;

/* compiled from: LegacyVoicemailNotifier.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static Pattern f36628a = Pattern.compile("[^0-9]");

    public static void a(Context context) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        try {
            for (StatusBarNotification statusBarNotification : notificationManager.getActiveNotifications()) {
                String tag = statusBarNotification.getTag();
                if (tag != null && tag.startsWith("LegacyVoicemailNotifier")) {
                    notificationManager.cancel(tag, statusBarNotification.getId());
                }
            }
        } catch (Exception e10) {
            C1.a.b("LegacyVoicemailNotifier", "clearNotification error " + e10);
        }
    }

    public static Notification b(Context context, TelephonyManager telephonyManager, String str, String str2, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
        boolean z10 = telephonyManager.getCarrierConfig().getBoolean("voicemail_notification_persistent_bool");
        if (TextUtils.isEmpty(str) || pendingIntent == null) {
            str = context.getString(R.string.unknown_number);
            pendingIntent = pendingIntent2;
        }
        return new Notification.Builder(context).setSmallIcon(2131232653).setAutoCancel(true).setWhen(System.currentTimeMillis()).setContentTitle(str).setContentText(str2).setStyle(new Notification.BigTextStyle().bigText(str2)).setContentIntent(pendingIntent).setOngoing(z10).setDefaults(-1).setChannelId(f.e(context)).build();
    }

    public static int c(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            String trim = f36628a.matcher(str).replaceAll("").trim();
            if (trim.length() >= 10) {
                trim = trim.substring(trim.length() - 8);
            }
            C1.a.a("LegacyVoicemailNotifier", "getNotificationId " + trim);
            return Integer.parseInt(trim);
        } catch (Exception unused) {
            C1.a.b("LegacyVoicemailNotifier", "The error of formating number");
            return 0;
        }
    }

    public static void d(Context context, PhoneAccountHandle phoneAccountHandle, String str, String str2, String str3, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
        C1580a.a(true);
        TelephonyManager createForPhoneAccountHandle = ((TelephonyManager) context.getSystemService(TelephonyManager.class)).createForPhoneAccountHandle(phoneAccountHandle);
        if (createForPhoneAccountHandle == null) {
            C1.a.b("LegacyVoicemailNotifier", "invalid PhoneAccountHandle");
            return;
        }
        Notification b10 = b(context, createForPhoneAccountHandle, str2, str3, pendingIntent, pendingIntent2);
        if (b10 != null) {
            try {
                ((NotificationManager) context.getSystemService(NotificationManager.class)).notify("LegacyVoicemailNotifier", c(str), b10);
            } catch (Exception e10) {
                H7.b.c("LegacyVoicemailNotifier", "LegacyVoicemailNotifier showNotification error " + e10);
            }
        }
    }
}
