package P6;

import android.content.Intent;
import android.os.Bundle;
import android.telecom.TelecomManager;
import android.util.Log;
import com.oplus.backup.sdk.common.utils.Constants;
import com.oplus.compat.utils.util.UnSupportedApiVersionException;
import com.oplus.epona.Request;
import com.oplus.epona.Response;
import com.oplus.inner.telecom.TelecomManagerWrapper;
import com.oplus.utils.reflect.RefClass;
import com.oplus.utils.reflect.RefMethod;

/* compiled from: TelecomManagerNative.java */
/* loaded from: classes3.dex */
public class c {

    /* compiled from: TelecomManagerNative.java */
    /* loaded from: classes3.dex */
    public static class a {
        private static RefMethod<Void> addNewOutgoingCall;
        private static RefMethod<Void> oplusCancelMissedCallsNotification;

        static {
            RefClass.load((Class<?>) a.class, (Class<?>) TelecomManager.class);
        }
    }

    public static void a(Intent intent) {
        if (S6.c.m()) {
            Response d10 = com.oplus.epona.d.o(new Request.b().c("android.telecom.TelecomManager").b("addNewOutgoingCall").f(Constants.MessagerConstants.INTENT_KEY, intent).a()).d();
            if (!d10.j()) {
                Log.e("TelecomManagerActivity", "response code error:" + d10.i());
                return;
            }
            return;
        }
        if (S6.c.l()) {
            b((TelecomManager) com.oplus.epona.d.g().getSystemService("telecom"), intent);
        } else {
            if (S6.c.h()) {
                a.addNewOutgoingCall.call((TelecomManager) com.oplus.epona.d.g().getSystemService("telecom"), intent);
                return;
            }
            throw new UnSupportedApiVersionException("not supported before N");
        }
    }

    public static void b(TelecomManager telecomManager, Intent intent) {
        d.a(telecomManager, intent);
    }

    public static void c(TelecomManager telecomManager, Bundle bundle) {
        if (S6.c.n()) {
            a.oplusCancelMissedCallsNotification.call(telecomManager, bundle);
            return;
        }
        if (S6.c.j()) {
            TelecomManagerWrapper.oplusCancelMissedCallsNotification(telecomManager, bundle);
        } else if (S6.c.m()) {
            d(telecomManager, bundle);
        } else {
            if (S6.c.l()) {
                e(telecomManager, bundle);
                return;
            }
            throw new UnSupportedApiVersionException();
        }
    }

    public static void d(TelecomManager telecomManager, Bundle bundle) {
        d.b(telecomManager, bundle);
    }

    public static void e(TelecomManager telecomManager, Bundle bundle) {
        d.c(telecomManager, bundle);
    }
}
