package t1;

import android.content.Context;
import android.telecom.PhoneAccountHandle;
import android.telecom.TelecomManager;
import w0.C1643c;

/* compiled from: VvmPackageInstallHandler.java */
/* loaded from: classes.dex */
public final class l {
    public static void a(Context context, String str) {
        if (!B3.a.W()) {
            return;
        }
        try {
            for (PhoneAccountHandle phoneAccountHandle : ((TelecomManager) context.getSystemService(TelecomManager.class)).getCallCapablePhoneAccounts()) {
                com.android.contacts.voicemail.impl.b bVar = new com.android.contacts.voicemail.impl.b(context, phoneAccountHandle);
                if (bVar.w() && bVar.d() != null && bVar.d().contains(str)) {
                    H7.b.e("VvmPackageInstallHandler.handlePackageInstalled", "Carrier app installed");
                    if (C1643c.w()) {
                        return;
                    }
                    H7.b.e("VvmPackageInstallHandler.handlePackageInstalled", "Carrier VVM package installed, disabling system VVM client");
                    C1.b.d(context, phoneAccountHandle, false);
                }
            }
        } catch (Exception e10) {
            C1.a.b("VvmPackageInstallHandler", "handlePackageInstalled error " + e10);
        }
    }

    public static void b(Context context, String str) {
        if (!B3.a.W()) {
            return;
        }
        try {
            for (PhoneAccountHandle phoneAccountHandle : ((TelecomManager) context.getSystemService(TelecomManager.class)).getCallCapablePhoneAccounts()) {
                com.android.contacts.voicemail.impl.b bVar = new com.android.contacts.voicemail.impl.b(context, phoneAccountHandle);
                if (bVar.w() && bVar.d() != null && bVar.d().contains(str)) {
                    H7.b.e("VvmPackageInstallHandler.handlePackageRemoved", "Carrier app Removed");
                    H7.b.e("VvmPackageInstallHandler.handlePackageRemoved", "Carrier VVM package removed, enable system VVM client");
                    C1.b.d(context, phoneAccountHandle, true);
                }
            }
        } catch (Exception e10) {
            C1.a.b("VvmPackageInstallHandler", "handlePackageRemoved error " + e10);
        }
    }
}
