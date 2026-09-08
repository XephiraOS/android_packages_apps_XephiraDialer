package P7;

import android.content.Context;
import android.os.UserManager;
import com.oplus.multiuser.OplusMultiUserManager;
import com.oplus.wrapper.os.UserHandle;
import kotlin.Result;
import kotlin.jvm.internal.i;
import m9.q;

/* compiled from: UserUtils.kt */
/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f2968a = new e();

    /* renamed from: b, reason: collision with root package name */
    public static Boolean f2969b;

    public static final int a() {
        return OplusMultiUserManager.getInstance().getMultiSystemUserId();
    }

    public static final int b() {
        if (C7.b.a(30, 1)) {
            return UserHandle.myUserId();
        }
        return M6.b.f();
    }

    public static final boolean c() {
        int b10 = b();
        if (b10 != -1 && b10 == a()) {
            return true;
        }
        return false;
    }

    public static final boolean d(Context context) {
        Object b10;
        Object obj;
        UserManager userManager;
        try {
            Result.a aVar = Result.f34166a;
            if (!i.b(f2969b, Boolean.TRUE)) {
                Boolean bool = null;
                if (context != null) {
                    obj = context.getSystemService("user");
                } else {
                    obj = null;
                }
                if (obj instanceof UserManager) {
                    userManager = (UserManager) obj;
                } else {
                    userManager = null;
                }
                if (userManager != null) {
                    bool = Boolean.valueOf(userManager.isUserUnlocked());
                }
                f2969b = bool;
                H7.b.e("UserUtils", "isUserUnlocked isUnlocked = " + bool);
            }
            b10 = Result.b(q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c("UserUtils", "e = " + d10);
        }
        Boolean bool2 = f2969b;
        if (bool2 != null) {
            return bool2.booleanValue();
        }
        return false;
    }
}
