package C1;

import android.content.Context;
import android.telecom.PhoneAccountHandle;
import java.util.Iterator;

/* compiled from: VisualVoicemailSettingsUtil.java */
/* loaded from: classes.dex */
public class b {
    public static boolean a(Context context, PhoneAccountHandle phoneAccountHandle) {
        if (phoneAccountHandle == null || !B3.a.W()) {
            return false;
        }
        return new D1.c(context, phoneAccountHandle).e("archive_is_enabled", false);
    }

    public static boolean b(Context context) {
        try {
            Iterator<PhoneAccountHandle> it = B1.b.c(context).iterator();
            while (it.hasNext()) {
                if (c(context, it.next())) {
                    return true;
                }
            }
            return false;
        } catch (Exception e10) {
            H7.b.c("VisualVoicemailSettingsUtil", "exception in isEnabled " + e10);
            return false;
        }
    }

    public static boolean c(Context context, PhoneAccountHandle phoneAccountHandle) {
        if (phoneAccountHandle == null || !B3.a.W()) {
            return false;
        }
        D1.c cVar = new D1.c(context, phoneAccountHandle);
        if (B3.a.w() && cVar.c("is_setting_enabled") && !cVar.e("is_setting_enabled", false)) {
            return false;
        }
        if (cVar.c("is_enabled")) {
            return cVar.e("is_enabled", false);
        }
        return new com.android.contacts.voicemail.impl.b(context, phoneAccountHandle).t();
    }

    public static void d(Context context, PhoneAccountHandle phoneAccountHandle, boolean z10) {
        H7.b.e("VisualVoicemailSettingsUtil.setEnable", phoneAccountHandle + " enabled:" + z10);
        new D1.c(context, phoneAccountHandle).d().b("is_enabled", z10).a();
        com.android.contacts.voicemail.impl.b bVar = new com.android.contacts.voicemail.impl.b(context, phoneAccountHandle);
        if (z10) {
            bVar.y();
        } else {
            B1.b.g(context, phoneAccountHandle);
            bVar.z();
        }
    }
}
