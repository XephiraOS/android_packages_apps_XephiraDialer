package s1;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.media.AudioAttributes;
import android.provider.Settings;
import android.text.TextUtils;
import com.oplus.dialer.R;

/* compiled from: NotificationChannelManager.java */
/* loaded from: classes.dex */
public final class f {
    public static void a(Context context) {
        try {
            ((NotificationManager) context.getSystemService(NotificationManager.class)).createNotificationChannel(f(context, "phone_voicemail"));
        } catch (Exception e10) {
            C1.a.b("NotificationChannelManager", "createVoicemailChannelForAccount error " + e10);
        }
    }

    public static boolean b(Context context, String str) {
        try {
            if (((NotificationManager) context.getSystemService(NotificationManager.class)).getNotificationChannel(str) == null) {
                return false;
            }
            return true;
        } catch (Exception e10) {
            C1.a.b("NotificationChannelManager", "doesChannelExist error " + e10);
            return false;
        }
    }

    public static String c(Context context) {
        if (!b(context, "phone_voicemail")) {
            C1.a.d("VoicemailChannelUtils.getChannelId", "voicemail channel not found for phone account (possible SIM swap?), creating a new one");
            a(context);
        } else if (!TextUtils.equals(context.getText(R.string.oplus_voicemail_actionbar_title), d(context, "phone_voicemail"))) {
            a(context);
        }
        return "phone_voicemail";
    }

    public static CharSequence d(Context context, String str) {
        try {
            return ((NotificationManager) context.getSystemService(NotificationManager.class)).getNotificationChannel(str).getName();
        } catch (Exception e10) {
            C1.a.b("NotificationChannelManager", "getChannelName error " + e10);
            return "";
        }
    }

    public static String e(Context context) {
        return c(context);
    }

    public static NotificationChannel f(Context context, String str) {
        NotificationChannel notificationChannel = new NotificationChannel(str, context.getText(R.string.oplus_voicemail_actionbar_title), 3);
        notificationChannel.setShowBadge(true);
        notificationChannel.enableLights(true);
        notificationChannel.enableVibration(true);
        notificationChannel.setSound(Settings.System.DEFAULT_NOTIFICATION_URI, new AudioAttributes.Builder().setUsage(5).build());
        return notificationChannel;
    }
}
