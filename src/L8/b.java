package L8;

import com.oplus.os.OplusBuild;

/* compiled from: VersionUtils.java */
/* loaded from: classes3.dex */
public class b {
    public static synchronized boolean a() {
        boolean z10;
        synchronized (b.class) {
            z10 = false;
            try {
                if (OplusBuild.getOplusOSVERSION() >= 22) {
                    z10 = true;
                }
            } catch (Throwable th) {
                a.b("VersionUtils", "Get OsVersion Exception : " + th.toString(), new Object[0]);
                return false;
            }
        }
        return z10;
    }
}
