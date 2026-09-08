package Q6;

import android.os.PersistableBundle;
import android.telephony.CarrierConfigManager;
import android.util.Log;
import com.oplus.compat.utils.util.UnSupportedApiVersionException;
import com.oplus.utils.reflect.RefClass;
import com.oplus.utils.reflect.RefMethod;
import com.oplus.utils.reflect.RefObject;

/* compiled from: CarrierConfigManagerNative.java */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static String f3127a;

    /* renamed from: b, reason: collision with root package name */
    public static String f3128b;

    /* renamed from: c, reason: collision with root package name */
    public static String f3129c;

    /* renamed from: d, reason: collision with root package name */
    public static String f3130d;

    /* renamed from: e, reason: collision with root package name */
    public static String f3131e;

    /* compiled from: CarrierConfigManagerNative.java */
    /* renamed from: Q6.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0060a {
        private static RefObject<String> KEY_CARRIER_ALLOW_TRANSFER_IMS_CALL_BOOL;
        private static RefObject<String> KEY_CARRIER_SUPPORTS_MULTIANCHOR_CONFERENCE;
        private static RefObject<String> KEY_CARRIER_WFC_SUPPORTS_IMS_PREFERRED_BOOL;
        private static RefObject<String> KEY_CDMA_CW_CF_ENABLED_BOOL;
        private static RefObject<String> KEY_HIDE_ENABLED_5G_BOOL;
        private static RefMethod<PersistableBundle> getDefaultConfig;

        static {
            RefClass.load((Class<?>) C0060a.class, (Class<?>) CarrierConfigManager.class);
        }
    }

    static {
        try {
            if (S6.c.m()) {
                f3127a = (String) C0060a.KEY_CDMA_CW_CF_ENABLED_BOOL.getWithException(null);
                f3128b = (String) C0060a.KEY_CARRIER_ALLOW_TRANSFER_IMS_CALL_BOOL.getWithException(null);
                f3129c = (String) C0060a.KEY_CARRIER_SUPPORTS_MULTIANCHOR_CONFERENCE.getWithException(null);
                f3130d = (String) C0060a.KEY_CARRIER_WFC_SUPPORTS_IMS_PREFERRED_BOOL.getWithException(null);
                f3131e = (String) C0060a.KEY_HIDE_ENABLED_5G_BOOL.getWithException(null);
            } else {
                Log.e("CarrierConfigManagerNative", "not supported before R");
            }
        } catch (Exception e10) {
            Log.e("CarrierConfigManagerNative", e10.toString());
        }
    }

    public static PersistableBundle a() {
        if (S6.c.m()) {
            return (PersistableBundle) C0060a.getDefaultConfig.call(null, new Object[0]);
        }
        if (S6.c.l()) {
            return (PersistableBundle) b();
        }
        throw new UnSupportedApiVersionException("not supported before Q");
    }

    public static Object b() {
        return b.a();
    }
}
