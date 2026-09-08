package M6;

import android.os.UserHandle;
import android.util.Log;
import com.oplus.compat.utils.util.UnSupportedApiVersionException;
import com.oplus.utils.reflect.RefClass;
import com.oplus.utils.reflect.RefMethod;
import com.oplus.utils.reflect.RefObject;

/* compiled from: UserHandleNative.java */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static UserHandle f1778a;

    /* renamed from: b, reason: collision with root package name */
    public static int f1779b;

    /* renamed from: c, reason: collision with root package name */
    public static int f1780c;

    /* renamed from: d, reason: collision with root package name */
    public static UserHandle f1781d;

    /* renamed from: e, reason: collision with root package name */
    public static UserHandle f1782e;

    /* renamed from: f, reason: collision with root package name */
    public static int f1783f;

    /* compiled from: UserHandleNative.java */
    /* loaded from: classes3.dex */
    public static class a {
        private static RefObject<UserHandle> OWNER;
        private static RefObject<UserHandle> SYSTEM;
        private static RefMethod<Integer> getIdentifier;
        private static RefMethod<Integer> myUserId;

        static {
            RefClass.load((Class<?>) a.class, (Class<?>) UserHandle.class);
        }
    }

    static {
        if (S6.c.m()) {
            f1782e = (UserHandle) a.SYSTEM.get(null);
            f1778a = (UserHandle) a.OWNER.get(null);
            f1779b = -2;
            f1780c = -1;
            f1781d = UserHandle.CURRENT;
            f1783f = 0;
            return;
        }
        if (S6.c.l()) {
            f1778a = (UserHandle) b();
            f1779b = ((Integer) d()).intValue();
            f1780c = ((Integer) c()).intValue();
            f1781d = (UserHandle) a();
            f1783f = ((Integer) e()).intValue();
            return;
        }
        if (S6.c.e()) {
            if (S6.c.k()) {
                f1780c = -1;
            }
            if (S6.c.g()) {
                f1783f = 0;
            }
            f1779b = -2;
            f1781d = UserHandle.CURRENT;
            f1778a = UserHandle.OWNER;
            return;
        }
        Log.e("UserHandleNative", "not supported before R");
    }

    public static Object a() {
        return c.a();
    }

    public static Object b() {
        return c.b();
    }

    public static Object c() {
        return c.c();
    }

    public static Object d() {
        return c.d();
    }

    public static Object e() {
        return c.e();
    }

    public static int f() {
        if (S6.c.m()) {
            return ((Integer) a.myUserId.call(null, new Object[0])).intValue();
        }
        if (S6.c.l()) {
            return ((Integer) g()).intValue();
        }
        if (S6.c.e()) {
            return UserHandle.myUserId();
        }
        throw new UnSupportedApiVersionException("not supported before L");
    }

    public static Object g() {
        return c.f();
    }
}
