package U8;

import V8.b;
import android.content.Intent;
import android.util.Log;
import com.oplus.backup.sdk.common.utils.Constants;
import com.oplus.epona.Request;
import com.oplus.epona.Response;
import com.oplus.epona.d;

/* compiled from: TelecomManagerNative.java */
/* loaded from: classes4.dex */
public class a {
    public static void a(Intent intent) {
        b.a(22);
        Response d10 = d.o(new Request.b().c("android.telecom.TelecomManager").b("addNewOutgoingCall").f(Constants.MessagerConstants.INTENT_KEY, intent).a()).d();
        if (!d10.j()) {
            Log.e("TelecomManagerActivity", "response code error:" + d10.i());
        }
    }
}
