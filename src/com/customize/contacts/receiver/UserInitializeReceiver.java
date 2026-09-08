package com.customize.contacts.receiver;

import J3.b;
import N7.a;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.customize.contacts.receiver.UserInitializeReceiver;
import com.oplus.foundation.util.feature.CommonFeatureOption;

/* loaded from: classes3.dex */
public class UserInitializeReceiver extends BroadcastReceiver {
    public static /* synthetic */ void b(Context context) {
        int c10 = b.c();
        if (c10 != 0) {
            ComponentName componentName = new ComponentName(context, "com.android.contacts.DialtactsActivityAlias");
            try {
                b.a b10 = b.b(context, c10);
                if (b10 == null) {
                    return;
                }
                boolean b11 = b10.b();
                H7.b.e("UserInitializeReceiver", "onReceive: isEnabled = " + b11 + ", " + b10.a());
                if (b11) {
                    context.getPackageManager().setComponentEnabledSetting(componentName, 1, 1);
                } else {
                    context.getPackageManager().setComponentEnabledSetting(componentName, 2, 1);
                }
            } catch (Exception e10) {
                H7.b.c("UserInitializeReceiver", "onReceive: " + e10);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, Intent intent) {
        if (intent != null && CommonFeatureOption.j() && "android.intent.action.USER_INITIALIZE".equals(intent.getAction())) {
            H7.b.b("UserInitializeReceiver", "onReceive --------------------- ");
            a.a().execute(new Runnable() { // from class: T3.a
                @Override // java.lang.Runnable
                public final void run() {
                    UserInitializeReceiver.b(context);
                }
            });
        }
    }
}
