package J6;

import android.content.Intent;
import com.android.incallui.OplusPhoneUtils;
import com.color.inner.content.IntentWrapper;

/* compiled from: IntentNativeOplusCompat.java */
/* loaded from: classes3.dex */
public class d {
    public static Object a() {
        return OplusPhoneUtils.ACTION_CALL_PRIVILEGED;
    }

    public static Object b() {
        return 1024;
    }

    public static Object c() {
        return 512;
    }

    public static void d(Intent intent, int i10) {
        IntentWrapper.setOppoFlags(intent, i10);
    }
}
