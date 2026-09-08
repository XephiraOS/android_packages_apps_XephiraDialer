package k8;

import android.util.Log;
import com.oplus.os.OplusBuild;

/* compiled from: OplusVersionUtils.java */
/* renamed from: k8.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1218a {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f34160a = a();

    public static boolean a() {
        try {
            if (OplusBuild.getOplusOSVERSION() >= ((Integer) Class.forName("com.oplus.os.OplusBuild").getField("OplusOS_11_3").get(null)).intValue()) {
                return true;
            }
            return false;
        } catch (Exception e10) {
            Log.w("OplusVersionUtils", "isOsVersion_11_3: " + e10.toString());
            return false;
        }
    }
}
