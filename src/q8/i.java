package q8;

import com.oplus.os.OplusBuild;

/* compiled from: VersionUtils.java */
/* loaded from: classes3.dex */
public class i {
    public static boolean a() {
        try {
            if (OplusBuild.getOplusOSVERSION() < 22) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            d.b("Get OsVersion Exception : " + th.toString());
            return false;
        }
    }

    public static boolean b() {
        return true;
    }
}
