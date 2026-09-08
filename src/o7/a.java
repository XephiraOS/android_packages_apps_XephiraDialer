package O7;

import D7.c;
import M7.d;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.telephony.UiccCardInfo;
import com.oplus.foundation.util.feature.CommonOSPublicFeature;
import java.util.List;
import kotlin.Result;
import kotlin.b;
import kotlin.jvm.internal.i;
import m9.q;

/* compiled from: CommonSimCardUtils.kt */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f2737a = new a();

    public static final String a(Context context) {
        if (context == null) {
            return "";
        }
        Object systemService = context.getSystemService("phone");
        i.d(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        List<UiccCardInfo> uiccCardsInfo = ((TelephonyManager) systemService).getUiccCardsInfo();
        i.e(uiccCardsInfo, "telephonyManager.uiccCardsInfo");
        for (UiccCardInfo uiccCardInfo : uiccCardsInfo) {
            if (uiccCardInfo.isEuicc()) {
                String eid = uiccCardInfo.getEid();
                if (eid == null) {
                    return "";
                }
                return eid;
            }
        }
        return "";
    }

    public static final String b(Context context, int i10) {
        String str = null;
        if (context == null) {
            return null;
        }
        if (CommonOSPublicFeature.f28307a.g()) {
            try {
                Result.a aVar = Result.f34166a;
                str = c.d(Integer.valueOf(i10));
                Result.b(q.f35511a);
                return str;
            } catch (Throwable th) {
                Result.a aVar2 = Result.f34166a;
                Result.b(b.a(th));
                return str;
            }
        }
        Object systemService = context.getSystemService("phone");
        i.d(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        return ((TelephonyManager) systemService).getSubscriberId();
    }

    public static final boolean c(String feature) {
        i.f(feature, "feature");
        int d10 = d.d(feature, 0);
        if (d10 != 1 && d10 != 2) {
            return false;
        }
        return true;
    }
}
