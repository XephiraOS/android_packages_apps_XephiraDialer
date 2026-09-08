package K6;

import android.content.pm.UserInfo;
import com.color.inner.content.pm.UserInfoWrapper;
import com.oplus.utils.reflect.RefClass;
import com.oplus.utils.reflect.RefObject;

/* compiled from: UserInfoNativeOplusCompat.java */
/* loaded from: classes3.dex */
public class c {

    /* compiled from: UserInfoNativeOplusCompat.java */
    /* loaded from: classes3.dex */
    public static class a {
        public static RefObject<UserInfo> user;

        static {
            RefClass.load((Class<?>) a.class, (Class<?>) UserInfoWrapper.class);
        }
    }

    public static Object a(Object obj) {
        return a.user.get((UserInfoWrapper) obj);
    }
}
