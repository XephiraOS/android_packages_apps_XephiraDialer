package P6;

import android.telecom.PhoneAccountHandle;
import com.oplus.compat.utils.util.UnSupportedApiVersionException;
import com.oplus.inner.telecom.PhoneAccountHandleWrapper;
import com.oplus.utils.reflect.RefClass;
import com.oplus.utils.reflect.RefInt;

/* compiled from: PhoneAccountHandleNative.java */
/* loaded from: classes3.dex */
public class a {

    /* compiled from: PhoneAccountHandleNative.java */
    /* renamed from: P6.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0055a {
        private static RefInt mSlotId;
        private static RefInt mSubId;

        static {
            RefClass.load((Class<?>) C0055a.class, (Class<?>) PhoneAccountHandle.class);
        }
    }

    public static int a(PhoneAccountHandle phoneAccountHandle) {
        if (S6.c.n()) {
            return C0055a.mSlotId.get(phoneAccountHandle);
        }
        if (S6.c.j()) {
            return PhoneAccountHandleWrapper.getSlotId(phoneAccountHandle);
        }
        if (S6.c.l()) {
            return ((Integer) b(phoneAccountHandle)).intValue();
        }
        throw new UnSupportedApiVersionException();
    }

    public static Object b(PhoneAccountHandle phoneAccountHandle) {
        return b.a(phoneAccountHandle);
    }

    public static int c(PhoneAccountHandle phoneAccountHandle) {
        if (S6.c.n()) {
            return C0055a.mSubId.get(phoneAccountHandle);
        }
        if (S6.c.j()) {
            return PhoneAccountHandleWrapper.getSubId(phoneAccountHandle);
        }
        if (S6.c.l()) {
            return ((Integer) d(phoneAccountHandle)).intValue();
        }
        throw new UnSupportedApiVersionException();
    }

    public static Object d(PhoneAccountHandle phoneAccountHandle) {
        return b.b(phoneAccountHandle);
    }
}
