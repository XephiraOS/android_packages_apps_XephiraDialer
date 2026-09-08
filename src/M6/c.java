package M6;

import com.color.inner.os.UserHandleWrapper;

/* compiled from: UserHandleNativeOplusCompat.java */
/* loaded from: classes3.dex */
public class c {
    public static Object a() {
        return UserHandleWrapper.CURRENT;
    }

    public static Object b() {
        return UserHandleWrapper.OWNER;
    }

    public static Object c() {
        return -1;
    }

    public static Object d() {
        return -2;
    }

    public static Object e() {
        return 0;
    }

    public static Object f() {
        return Integer.valueOf(UserHandleWrapper.myUserId());
    }
}
