package K6;

import android.content.pm.UserInfo;
import android.os.UserHandle;
import android.util.Log;
import com.oplus.compat.utils.util.UnSupportedApiVersionException;
import com.oplus.inner.content.pm.UserInfoWrapper;
import com.oplus.utils.reflect.RefClass;
import com.oplus.utils.reflect.RefObject;

/* compiled from: UserInfoNative.java */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public Object f1673a;

    /* renamed from: b, reason: collision with root package name */
    public UserInfo f1674b;

    /* compiled from: UserInfoNative.java */
    /* loaded from: classes3.dex */
    public static class a {
        private static RefObject<UserInfo> user;

        static {
            RefClass.load((Class<?>) a.class, (Class<?>) UserInfoWrapper.class);
        }
    }

    public b(UserInfo userInfo) {
        this.f1674b = userInfo;
    }

    public static Object c(Object obj) {
        return c.a(obj);
    }

    public int a() {
        if (S6.c.e()) {
            UserInfo userInfo = this.f1674b;
            if (userInfo != null) {
                return userInfo.id;
            }
            return -1;
        }
        throw new UnSupportedApiVersionException();
    }

    public UserHandle b() {
        if (S6.c.e()) {
            UserInfo userInfo = this.f1674b;
            if (userInfo != null) {
                return userInfo.getUserHandle();
            }
            return null;
        }
        throw new UnSupportedApiVersionException();
    }

    public boolean d() {
        if (S6.c.l()) {
            return this.f1674b.isEnabled();
        }
        throw new UnSupportedApiVersionException();
    }

    public b(Object obj) {
        try {
            if (S6.c.j()) {
                this.f1673a = obj;
                this.f1674b = (UserInfo) a.user.get(this.f1673a);
            } else {
                if (S6.c.l()) {
                    this.f1673a = obj;
                    this.f1674b = (UserInfo) c(obj);
                    return;
                }
                throw new UnSupportedApiVersionException();
            }
        } catch (Throwable th) {
            Log.e("UserInfoNative", th.toString());
        }
    }
}
