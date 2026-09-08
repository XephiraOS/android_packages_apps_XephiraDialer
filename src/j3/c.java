package J3;

import com.oplus.wrapper.telephony.TelephonyManager;
import kotlin.jvm.internal.i;

/* compiled from: TelephonyManagerCustomize.kt */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f1581a = new c();

    public static final String a(int i10, String property, String defaultVal) {
        String b10;
        i.f(property, "property");
        i.f(defaultVal, "defaultVal");
        try {
            if (C7.b.a(30, 1)) {
                b10 = TelephonyManager.getTelephonyProperty(i10, property, defaultVal);
            } else {
                b10 = Q6.c.b(i10, property, defaultVal);
            }
            i.e(b10, "{\n            if (Compat…)\n            }\n        }");
            return b10;
        } catch (Exception e10) {
            H7.b.c("TelephonyManagerCustomize", "getTelephonyProperty error :" + e10);
            return defaultVal;
        }
    }
}
