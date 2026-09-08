package M0;

import android.content.Context;
import android.telecom.PhoneAccount;
import android.telecom.PhoneAccountHandle;
import android.telecom.TelecomManager;
import java.util.Iterator;

/* compiled from: CallUtil.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f1738a;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f1739b;

    public static int a(Context context) {
        TelecomManager telecomManager;
        if (context.checkSelfPermission("android.permission.READ_PHONE_STATE") != 0 || (telecomManager = (TelecomManager) context.getSystemService("telecom")) == null) {
            return 0;
        }
        Iterator<PhoneAccountHandle> it = telecomManager.getCallCapablePhoneAccounts().iterator();
        while (it.hasNext()) {
            PhoneAccount phoneAccount = telecomManager.getPhoneAccount(it.next());
            if (phoneAccount != null && phoneAccount.hasCapabilities(8)) {
                if (phoneAccount.hasCapabilities(256)) {
                    return 3;
                }
                return 1;
            }
        }
        return 0;
    }

    public static boolean b(Context context) {
        boolean z10;
        if ((a(context) & 1) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!f1738a) {
            H7.b.e("CallUtil.isVideoEnabled", "isVideoEnabled: " + z10);
            f1738a = true;
            f1739b = z10;
        } else if (f1739b != z10) {
            H7.b.e("CallUtil.isVideoEnabled", "isVideoEnabled changed from " + f1739b + " to " + z10);
            f1739b = z10;
        }
        return z10;
    }
}
