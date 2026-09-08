package V8;

import com.oplus.os.OplusBuild;
import com.oplusx.sysapi.utils.exception.UnSupportedOsVersionException;

/* compiled from: OsCheck.java */
/* loaded from: classes4.dex */
public class b {
    public static void a(int i10) {
        if (OplusBuild.getOplusOSVERSION() >= i10) {
        } else {
            throw new UnSupportedOsVersionException();
        }
    }
}
