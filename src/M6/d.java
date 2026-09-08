package M6;

import android.content.Context;
import android.content.pm.UserInfo;
import android.os.UserManager;
import com.oplus.compat.utils.util.UnSupportedApiVersionException;
import com.oplus.epona.Request;
import com.oplus.epona.Response;

/* compiled from: UserManagerNative.java */
/* loaded from: classes3.dex */
public class d {
    public static K6.b a(Context context, int i10, int i11) {
        if (S6.c.m()) {
            Response d10 = com.oplus.epona.d.o(new Request.b().c("android.os.UserManager").b("getUserInfo").d("userId", i10).a()).d();
            if (d10.j()) {
                return new K6.b(d10.h().getParcelable("result"));
            }
            return null;
        }
        if (S6.c.l()) {
            Object b10 = b((UserManager) context.getSystemService("user"), i11);
            if (b10 != null) {
                return new K6.b(b10);
            }
            return null;
        }
        if (S6.c.e()) {
            UserInfo userInfo = ((UserManager) context.getSystemService("user")).getUserInfo(i11);
            if (userInfo != null) {
                return new K6.b(userInfo);
            }
            return null;
        }
        throw new UnSupportedApiVersionException("Not Supported Before L");
    }

    public static Object b(UserManager userManager, int i10) {
        return e.a(userManager, i10);
    }
}
