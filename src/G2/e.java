package G2;

import android.net.Uri;
import android.telecom.Call;

/* compiled from: TelecomCallUtil.java */
/* loaded from: classes.dex */
public class e {
    public static Uri a(Call call) {
        if (call == null) {
            return null;
        }
        return call.getDetails().getHandle();
    }

    public static String b(Call call) {
        if (call == null) {
            return null;
        }
        if (call.getDetails().getGatewayInfo() != null) {
            return call.getDetails().getGatewayInfo().getOriginalAddress().getSchemeSpecificPart();
        }
        Uri a10 = a(call);
        if (a10 == null) {
            return null;
        }
        return a10.getSchemeSpecificPart();
    }
}
