package t1;

import android.content.Context;
import android.os.Bundle;
import android.telecom.PhoneAccountHandle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

/* compiled from: PreOMigrationHandler.java */
/* loaded from: classes.dex */
public final class c {
    public static void a(Context context, PhoneAccountHandle phoneAccountHandle) {
        C1580a.d();
        D1.c cVar = new D1.c(context, phoneAccountHandle);
        if (cVar.e("pre_o_migration_finished", false)) {
            H7.b.e("PreOMigrationHandler", phoneAccountHandle + " already migrated");
            return;
        }
        H7.b.e("PreOMigrationHandler", "migrating " + phoneAccountHandle);
        b(context, phoneAccountHandle);
        cVar.d().b("pre_o_migration_finished", true).a();
    }

    public static void b(Context context, PhoneAccountHandle phoneAccountHandle) {
        H7.b.e("PreOMigrationHandler.migrateSettings", "migrating settings");
        TelephonyManager createForPhoneAccountHandle = ((TelephonyManager) context.getSystemService(TelephonyManager.class)).createForPhoneAccountHandle(phoneAccountHandle);
        if (createForPhoneAccountHandle == null) {
            H7.b.c("PreOMigrationHandler.migrateSettings", "invalid PhoneAccountHandle");
            return;
        }
        try {
            Bundle bundle = (Bundle) TelephonyManager.class.getMethod("getVisualVoicemailSettings", null).invoke(createForPhoneAccountHandle, null);
            if (bundle.containsKey("android.telephony.extra.VISUAL_VOICEMAIL_ENABLED_BY_USER_BOOL")) {
                boolean z10 = bundle.getBoolean("android.telephony.extra.VISUAL_VOICEMAIL_ENABLED_BY_USER_BOOL");
                H7.b.e("PreOMigrationHandler.migrateSettings", "setting VVM enabled to " + z10);
                C1.b.d(context, phoneAccountHandle, z10);
            }
            if (bundle.containsKey("android.telephony.extra.VOICEMAIL_SCRAMBLED_PIN_STRING")) {
                String string = bundle.getString("android.telephony.extra.VOICEMAIL_SCRAMBLED_PIN_STRING");
                if (!TextUtils.isEmpty(string)) {
                    H7.b.e("PreOMigrationHandler.migrateSettings", "migrating scrambled PIN");
                    c(context, phoneAccountHandle, string);
                }
            }
        } catch (ClassCastException | ReflectiveOperationException unused) {
            H7.b.e("PreOMigrationHandler.migrateSettings", "unable to retrieve settings from system");
        }
    }

    public static void c(Context context, PhoneAccountHandle phoneAccountHandle, String str) {
        new D1.c(context, phoneAccountHandle).d().c("default_old_pin", str).a();
    }
}
