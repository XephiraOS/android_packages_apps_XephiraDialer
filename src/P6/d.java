package P6;

import android.content.Intent;
import android.os.Bundle;
import android.telecom.TelecomManager;
import com.color.inner.telecom.TelecomManagerWrapper;
import com.oplus.utils.reflect.RefClass;
import com.oplus.utils.reflect.RefMethod;

/* compiled from: TelecomManagerNativeOplusCompat.java */
/* loaded from: classes3.dex */
public class d {

    /* compiled from: TelecomManagerNativeOplusCompat.java */
    /* loaded from: classes3.dex */
    public static class a {
        public static RefMethod<String> colorInteractWithTelecomService;
        public static RefMethod<Void> oppoCancelMissedCallsNotification;

        static {
            RefClass.load((Class<?>) a.class, (Class<?>) TelecomManagerWrapper.class);
        }
    }

    public static void a(TelecomManager telecomManager, Intent intent) {
        TelecomManagerWrapper.addNewOutgoingCall(telecomManager, intent);
    }

    public static void b(TelecomManager telecomManager, Bundle bundle) {
        TelecomManagerWrapper.oplusCancelMissedCallsNotification(telecomManager, bundle);
    }

    public static void c(TelecomManager telecomManager, Bundle bundle) {
        a.oppoCancelMissedCallsNotification.call(null, telecomManager, bundle);
    }
}
