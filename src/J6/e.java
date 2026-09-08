package J6;

import com.oplus.compat.utils.util.UnSupportedApiVersionException;
import com.oplus.content.OplusFeatureConfigManager;

/* compiled from: OplusFeatureConfigManagerNative.java */
/* loaded from: classes3.dex */
public class e {
    public static boolean a(String str) {
        if (S6.c.m()) {
            return OplusFeatureConfigManager.getInstance().hasFeature(str);
        }
        if (S6.c.l()) {
            return com.oplus.epona.d.g().getPackageManager().hasSystemFeature(str);
        }
        throw new UnSupportedApiVersionException("not supported before Q");
    }
}
