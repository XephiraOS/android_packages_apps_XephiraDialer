package Q6;

import android.util.Log;
import com.oplus.compat.utils.util.UnSupportedApiVersionException;
import com.oplus.epona.Request;
import com.oplus.epona.Response;
import com.oplus.inner.telephony.TelephonyManagerWrapper;
import com.oplus.utils.reflect.MethodName;
import com.oplus.utils.reflect.RefClass;
import com.oplus.utils.reflect.RefInt;
import com.oplus.utils.reflect.RefMethod;

/* compiled from: TelephonyManagerNative.java */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static int f3132a;

    /* renamed from: b, reason: collision with root package name */
    public static int f3133b;

    /* renamed from: c, reason: collision with root package name */
    public static int f3134c;

    /* renamed from: d, reason: collision with root package name */
    public static int f3135d;

    /* compiled from: TelephonyManagerNative.java */
    /* loaded from: classes3.dex */
    public static class a {
        private static RefMethod<Integer> getCurrentPhoneTypeForSlot;
        private static RefMethod<Integer> getIntAtIndex;
        private static RefMethod<String> getNetworkOperatorForPhone;
        private static RefMethod<Integer> getSimCount;

        @MethodName(name = "getSimCountryIso", params = {int.class})
        private static RefMethod<String> getSimCountryIso;
        private static RefMethod<String> getSimOperatorNameForPhone;
        private static RefMethod<String> getSimOperatorNumericForPhone;

        @MethodName(name = "getTelephonyProperty", params = {int.class, String.class, String.class})
        private static RefMethod<String> getTelephonyProperty;

        @MethodName(name = "hasIccCard", params = {int.class})
        private static RefMethod<Boolean> hasIccCard;
        private static RefMethod<Boolean> isMultiSimEnabled;

        static {
            RefClass.load((Class<?>) a.class, "android.telephony.TelephonyManager");
        }
    }

    /* compiled from: TelephonyManagerNative.java */
    /* loaded from: classes3.dex */
    public static class b {
        private static RefInt NETWORK_CLASS_2_G;
        private static RefInt NETWORK_CLASS_3_G;
        private static RefInt NETWORK_CLASS_4_G;
        private static RefInt NETWORK_CLASS_5_G;

        /* renamed from: a, reason: collision with root package name */
        public static Class<?> f3136a = RefClass.load((Class<?>) b.class, "com.oplus.internal.telephony.utils.OemTelephonyUtils");
    }

    static {
        try {
            if (S6.c.n()) {
                f3132a = b.NETWORK_CLASS_2_G.get(null);
                f3133b = b.NETWORK_CLASS_3_G.get(null);
                f3134c = b.NETWORK_CLASS_4_G.get(null);
                f3135d = b.NETWORK_CLASS_5_G.get(null);
            } else if (S6.c.j()) {
                f3132a = TelephonyManagerWrapper.NETWORK_CLASS_2_G;
                f3133b = TelephonyManagerWrapper.NETWORK_CLASS_3_G;
                f3134c = TelephonyManagerWrapper.NETWORK_CLASS_4_G;
            } else if (S6.c.l()) {
                f3132a = ((Integer) c()).intValue();
                f3133b = ((Integer) d()).intValue();
                f3134c = ((Integer) e()).intValue();
            } else {
                Log.e("TelephonyManagerNative", "not supported before Q");
            }
        } catch (Throwable th) {
            Log.e("TelephonyManagerNative", th.toString());
        }
    }

    public static String a(int i10) {
        if (S6.c.n()) {
            return (String) a.getSimCountryIso.call(null, Integer.valueOf(i10));
        }
        if (S6.c.m()) {
            Response d10 = com.oplus.epona.d.o(new Request.b().c("android.telephony.TelephonyManager").b("getSimCountryIso").d("subId", i10).a()).d();
            if (d10.j()) {
                return d10.h().getString("result");
            }
            Log.e("TelephonyManagerNative", "response error:" + d10.i());
            return "";
        }
        throw new UnSupportedApiVersionException("not supported before R");
    }

    public static String b(int i10, String str, String str2) {
        if (S6.c.l()) {
            return (String) a.getTelephonyProperty.call(null, Integer.valueOf(i10), str, str2);
        }
        throw new UnSupportedApiVersionException("not supported before R");
    }

    public static Object c() {
        return d.a();
    }

    public static Object d() {
        return d.b();
    }

    public static Object e() {
        return d.c();
    }
}
