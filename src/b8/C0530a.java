package b8;

import android.util.Log;
import com.oplus.compat.utils.util.UnSupportedApiVersionException;
import com.oplus.wrapper.os.SystemProperties;
import kotlin.jvm.internal.i;

/* compiled from: SystemPropertiesCustomize.kt */
/* renamed from: b8.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0530a {

    /* renamed from: a, reason: collision with root package name */
    public static final C0530a f12339a = new C0530a();

    public static final String a(String key, String str) {
        String b10;
        i.f(key, "key");
        i.f(str, "default");
        try {
            if (com.oplus.phonenoareainquire.utils.a.a(30, 1)) {
                b10 = SystemProperties.get(key, str);
            } else {
                b10 = M6.a.b(key, str);
            }
            i.c(b10);
            return b10;
        } catch (UnSupportedApiVersionException e10) {
            Log.e("SystemPropertiesCustomize", "get error :" + e10);
            return str;
        }
    }

    public static final boolean b(String key, boolean z10) {
        boolean c10;
        i.f(key, "key");
        try {
            if (com.oplus.phonenoareainquire.utils.a.a(30, 1)) {
                c10 = SystemProperties.getBoolean(key, z10);
            } else {
                c10 = M6.a.c(key, z10);
            }
            return c10;
        } catch (UnSupportedApiVersionException e10) {
            Log.e("SystemPropertiesCustomize", "getBoolean error :" + e10);
            return z10;
        }
    }
}
