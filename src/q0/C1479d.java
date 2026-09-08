package q0;

import android.content.Context;
import android.preference.PreferenceManager;
import android.telephony.TelephonyManager;

/* compiled from: ConcreteCreator.java */
/* renamed from: q0.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1479d {
    public static InterfaceC1476a a(TelephonyManager telephonyManager, Context context, String str) {
        s1.d.a(context);
        if (telephonyManager != null) {
            if (context != null) {
                if (!P7.e.d(context)) {
                    H7.b.e("ConcreteCreator", "createNewAssistedDialingMediator: user is locked");
                    return new C1478c();
                }
                if (!PreferenceManager.getDefaultSharedPreferences(context).getBoolean("assisted_dialing_setting_toggle_key", true)) {
                    H7.b.e("ConcreteCreator", "createNewAssistedDialingMediator: disabled by local setting");
                    return new C1478c();
                }
                return new C1477b(new g(telephonyManager, str), new com.android.contacts.assisteddialing.a(new e(context, b(context))));
            }
            H7.b.e("ConcreteCreator", "createNewAssistedDialingMediator: provided context was null");
            throw new NullPointerException("Provided context was null");
        }
        H7.b.e("ConcreteCreator", "createNewAssistedDialingMediator: provided TelephonyManager was null");
        throw new NullPointerException("Provided TelephonyManager was null");
    }

    public static f b(Context context) {
        return new f(context);
    }
}
