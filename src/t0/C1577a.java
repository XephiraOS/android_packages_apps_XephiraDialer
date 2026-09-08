package t0;

import android.content.Context;
import android.os.PersistableBundle;
import android.telephony.CarrierConfigManager;
import android.telephony.SubscriptionInfo;
import android.util.Log;
import com.android.incallui.OplusPhoneUtils;
import java.util.Iterator;
import kotlin.jvm.internal.i;

/* compiled from: CustSimCardUtils.kt */
/* renamed from: t0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1577a {

    /* renamed from: a, reason: collision with root package name */
    public static final C1577a f37130a = new C1577a();

    /* JADX WARN: Removed duplicated region for block: B:6:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:9:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.util.List<android.telephony.SubscriptionInfo> a(android.content.Context r3) {
        /*
            java.lang.String r0 = "context"
            kotlin.jvm.internal.i.f(r3, r0)
            java.lang.String r0 = "telephony_subscription_service"
            java.lang.Object r3 = r3.getSystemService(r0)
            java.lang.String r0 = "null cannot be cast to non-null type android.telephony.SubscriptionManager"
            kotlin.jvm.internal.i.d(r3, r0)
            android.telephony.SubscriptionManager r3 = (android.telephony.SubscriptionManager) r3
            java.util.List r3 = r3.getActiveSubscriptionInfoList()     // Catch: java.lang.Throwable -> L38
            if (r3 == 0) goto L50
            java.util.Iterator r0 = r3.iterator()     // Catch: java.lang.Throwable -> L36
        L1c:
            boolean r1 = r0.hasNext()     // Catch: java.lang.Throwable -> L36
            if (r1 == 0) goto L50
            java.lang.Object r1 = r0.next()     // Catch: java.lang.Throwable -> L36
            android.telephony.SubscriptionInfo r1 = (android.telephony.SubscriptionInfo) r1     // Catch: java.lang.Throwable -> L36
            int r2 = r1.getSimSlotIndex()     // Catch: java.lang.Throwable -> L36
            boolean r2 = d(r2)     // Catch: java.lang.Throwable -> L36
            if (r2 == 0) goto L1c
            r3.remove(r1)     // Catch: java.lang.Throwable -> L36
            return r3
        L36:
            r0 = move-exception
            goto L3a
        L38:
            r0 = move-exception
            r3 = 0
        L3a:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "colorgetActiveSubInfoList e = "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.String r1 = "CustSimCardUtils"
            H7.b.b(r1, r0)
        L50:
            if (r3 != 0) goto L57
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
        L57:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: t0.C1577a.a(android.content.Context):java.util.List");
    }

    public static final String b(Context context, int i10) {
        if (context == null) {
            return null;
        }
        return c(i10, OplusPhoneUtils.PROPERTY_ICC_OPERATOR_NUMERIC, "");
    }

    public static final String c(int i10, String property, String defaultVal) {
        i.f(property, "property");
        i.f(defaultVal, "defaultVal");
        try {
            String b10 = Q6.c.b(i10, property, defaultVal);
            i.e(b10, "{\n            TelephonyM…y, defaultVal);\n        }");
            return b10;
        } catch (Exception e10) {
            H7.b.c("CustSimCardUtils", "getTelephonyProperty error :" + e10);
            return defaultVal;
        }
    }

    public static final boolean d(int i10) {
        int i11;
        boolean z10;
        try {
            i11 = D7.c.m();
        } catch (Throwable th) {
            Log.e("CustSimCardUtils", "isSoftSimCard throwable = " + th);
            i11 = -1;
        }
        if (i10 == i11) {
            z10 = true;
        } else {
            z10 = false;
        }
        Log.d("CustSimCardUtils", "isSoftSimCard: " + z10 + ", slot " + i10);
        return z10;
    }

    public static final boolean e(Context context) {
        PersistableBundle configForSubId;
        boolean z10 = false;
        if (context != null) {
            Object systemService = context.getSystemService("carrier_config");
            i.d(systemService, "null cannot be cast to non-null type android.telephony.CarrierConfigManager");
            CarrierConfigManager carrierConfigManager = (CarrierConfigManager) systemService;
            Iterator<SubscriptionInfo> it = a(context).iterator();
            while (it.hasNext() && ((configForSubId = carrierConfigManager.getConfigForSubId(it.next().getSubscriptionId())) == null || !(z10 = configForSubId.getBoolean("enable_fixed_dialing_number_phone_lookup")))) {
            }
        }
        return z10;
    }
}
