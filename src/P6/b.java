package P6;

import android.telecom.PhoneAccountHandle;
import com.color.inner.telecom.PhoneAccountHandleWrapper;

/* compiled from: PhoneAccountHandleNativeOplusCompat.java */
/* loaded from: classes3.dex */
public class b {
    public static Object a(PhoneAccountHandle phoneAccountHandle) {
        return Integer.valueOf(PhoneAccountHandleWrapper.getSlotId(phoneAccountHandle));
    }

    public static Object b(PhoneAccountHandle phoneAccountHandle) {
        return Integer.valueOf(PhoneAccountHandleWrapper.getSubId(phoneAccountHandle));
    }
}
