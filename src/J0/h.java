package J0;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.util.Pair;

/* compiled from: DialerNotificationManager.java */
/* loaded from: classes.dex */
public final class h {
    public static void a(Context context, String str, int i10) {
        b.b(context);
        b.a(!TextUtils.isEmpty(str));
        NotificationManager d10 = d(context);
        StatusBarNotification[] activeNotifications = d10.getActiveNotifications();
        String b10 = b(activeNotifications, str, i10);
        if (!TextUtils.isEmpty(b10)) {
            Pair<StatusBarNotification, Integer> c10 = c(activeNotifications, b10);
            if (c10.first != null && ((Integer) c10.second).intValue() <= 1) {
                d10.cancel(((StatusBarNotification) c10.first).getTag(), ((StatusBarNotification) c10.first).getId());
            }
        }
        d10.cancel(str, i10);
    }

    public static String b(StatusBarNotification[] statusBarNotificationArr, String str, int i10) {
        for (StatusBarNotification statusBarNotification : statusBarNotificationArr) {
            if (TextUtils.equals(str, statusBarNotification.getTag()) && i10 == statusBarNotification.getId()) {
                return statusBarNotification.getNotification().getGroup();
            }
        }
        return null;
    }

    public static Pair<StatusBarNotification, Integer> c(StatusBarNotification[] statusBarNotificationArr, String str) {
        StatusBarNotification statusBarNotification = null;
        int i10 = 0;
        for (StatusBarNotification statusBarNotification2 : statusBarNotificationArr) {
            if (TextUtils.equals(str, statusBarNotification2.getNotification().getGroup())) {
                if ((statusBarNotification2.getNotification().flags & 512) != 0) {
                    statusBarNotification = statusBarNotification2;
                } else {
                    i10++;
                }
            }
        }
        return new Pair<>(statusBarNotification, Integer.valueOf(i10));
    }

    public static NotificationManager d(Context context) {
        return (NotificationManager) context.getSystemService(NotificationManager.class);
    }

    public static void e(Context context, String str, int i10, Notification notification) {
        b.b(context);
        b.b(notification);
        b.a(!TextUtils.isEmpty(str));
        if (F.a.a()) {
            b.a(!TextUtils.isEmpty(notification.getChannelId()));
        }
        d(context).notify(str, i10, notification);
    }
}
