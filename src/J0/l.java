package J0;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.OplusBaseIntent;
import android.os.RemoteException;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.util.Log;
import android.view.OplusWindowManager;
import com.android.incallui.OplusPhoneCapabilities;
import com.oplus.foundation.util.feature.FeatureUtil;
import com.oplus.util.OplusTypeCastingHelper;

/* compiled from: NotificationManagerUtils.java */
/* loaded from: classes.dex */
public final class l {
    public static void a(Context context, String str) {
        b.b(context);
        b.a(!TextUtils.isEmpty(str));
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
        for (StatusBarNotification statusBarNotification : notificationManager.getActiveNotifications()) {
            if (TextUtils.equals(str, statusBarNotification.getNotification().getGroup())) {
                notificationManager.cancel(statusBarNotification.getTag(), statusBarNotification.getId());
            }
        }
    }

    public static void b() {
        try {
            new OplusWindowManager().requestKeyguard("secondaryhome:collapse_panels");
            Log.d("NotificationManagerUtils", "collapseDragonflyKeyguardPanel: ");
        } catch (RemoteException e10) {
            Log.d("NotificationManagerUtils", "collapseDragonflyKeyguardPanel: exception:" + e10.getMessage());
        } catch (NoSuchMethodError e11) {
            Log.d("NotificationManagerUtils", "collapseDragonflyKeyguardPanel: error:" + e11.getMessage());
        }
    }

    public static void c(Intent intent) {
        if (FeatureUtil.N() && FeatureUtil.M()) {
            Log.d("NotificationManagerUtils", "configIntentForContinueRequired: ");
            OplusBaseIntent oplusBaseIntent = (OplusBaseIntent) OplusTypeCastingHelper.typeCasting(OplusBaseIntent.class, intent);
            if (oplusBaseIntent != null) {
                oplusBaseIntent.addOplusFlags(OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE);
            }
        }
    }
}
