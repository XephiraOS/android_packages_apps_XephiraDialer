package c7;

import android.util.Log;
import com.oplus.utils.C0854o;
import com.oplus.wrapper.os.SystemProperties;
import kotlin.jvm.internal.i;

/* compiled from: SystemPropertiesCustomize.kt */
/* renamed from: c7.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0566b {

    /* renamed from: a, reason: collision with root package name */
    public static final C0566b f12861a = new C0566b();

    public static final String a(String key) {
        String a10;
        i.f(key, "key");
        try {
            if (C0854o.c(0, 0, 3, null)) {
                a10 = SystemProperties.get(key);
                i.e(a10, "{\n                System…es.get(key)\n            }");
            } else {
                a10 = M6.a.a(key);
                i.e(a10, "{\n                System…ve.get(key)\n            }");
            }
            return a10;
        } catch (Exception e10) {
            Log.e("SystemPropertiesCustomize", "get error :" + e10);
            return "";
        }
    }

    public static final String b(String key, String str) {
        String b10;
        i.f(key, "key");
        i.f(str, "default");
        try {
            if (C0854o.c(0, 0, 3, null)) {
                b10 = SystemProperties.get(key, str);
            } else {
                b10 = M6.a.b(key, str);
            }
            i.e(b10, "{\n            if (Compat…)\n            }\n        }");
            return b10;
        } catch (Exception e10) {
            Log.e("SystemPropertiesCustomize", "get error :" + e10);
            return str;
        }
    }

    public static final boolean c(String key, boolean z10) {
        boolean c10;
        i.f(key, "key");
        try {
            if (C0854o.c(0, 0, 3, null)) {
                c10 = SystemProperties.getBoolean(key, z10);
            } else {
                c10 = M6.a.c(key, z10);
            }
            return c10;
        } catch (Exception e10) {
            Log.e("SystemPropertiesCustomize", "getBoolean error :" + e10);
            return z10;
        }
    }
}
