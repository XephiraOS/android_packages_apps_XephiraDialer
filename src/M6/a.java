package M6;

import android.os.SystemProperties;
import com.oplus.compat.utils.util.UnSupportedApiVersionException;

/* compiled from: SystemPropertiesNative.java */
/* loaded from: classes3.dex */
public class a {
    public static String a(String str) {
        if (S6.c.e()) {
            return SystemProperties.get(str);
        }
        throw new UnSupportedApiVersionException("not supported before L");
    }

    public static String b(String str, String str2) {
        if (S6.c.e()) {
            return SystemProperties.get(str, str2);
        }
        throw new UnSupportedApiVersionException("not supported before L");
    }

    public static boolean c(String str, boolean z10) {
        if (S6.c.e()) {
            return SystemProperties.getBoolean(str, z10);
        }
        throw new UnSupportedApiVersionException("not supported before L");
    }

    public static int d(String str, int i10) {
        if (S6.c.e()) {
            return SystemProperties.getInt(str, i10);
        }
        throw new UnSupportedApiVersionException("not supported before L");
    }
}
