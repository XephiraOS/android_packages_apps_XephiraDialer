package J3;

import android.content.Context;
import android.os.UserHandle;
import com.oplus.foundation.util.OsUtils;
import com.oplus.multiuser.OplusMultiUserManager;
import com.oplus.os.OplusBuild;
import com.oplus.wrapper.content.pm.UserInfo;
import com.oplus.wrapper.os.UserManager;
import kotlin.jvm.internal.i;

/* compiled from: LocalUserManager.kt */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f1577a = new b();

    /* compiled from: LocalUserManager.kt */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f1578a;

        /* renamed from: b, reason: collision with root package name */
        public final UserHandle f1579b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f1580c;

        public a(int i10, UserHandle userHandle, boolean z10) {
            i.f(userHandle, "userHandle");
            this.f1578a = i10;
            this.f1579b = userHandle;
            this.f1580c = z10;
        }

        public final int a() {
            return this.f1578a;
        }

        public final boolean b() {
            return this.f1580c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f1578a == aVar.f1578a && i.b(this.f1579b, aVar.f1579b) && this.f1580c == aVar.f1580c) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((Integer.hashCode(this.f1578a) * 31) + this.f1579b.hashCode()) * 31;
            boolean z10 = this.f1580c;
            int i10 = z10;
            if (z10 != 0) {
                i10 = 1;
            }
            return hashCode + i10;
        }

        public String toString() {
            return "MyUserInfo(id=" + this.f1578a + ", userHandle=" + this.f1579b + ", isEnabled=" + this.f1580c + ")";
        }
    }

    public static final boolean a(int i10) {
        if (OplusBuild.getOplusOSVERSION() >= i10) {
            return true;
        }
        return false;
    }

    public static final a b(Context context, int i10) {
        a aVar;
        i.f(context, "context");
        try {
            if (a(27)) {
                Object systemService = context.getSystemService("user");
                i.d(systemService, "null cannot be cast to non-null type android.os.UserManager");
                UserInfo userInfo = new UserManager((android.os.UserManager) systemService).getUserInfo(i10);
                int id = userInfo.getId();
                UserHandle userHandle = userInfo.getUserHandle();
                i.e(userHandle, "userInfo.userHandle");
                aVar = new a(id, userHandle, userInfo.isEnabled());
            } else if (OsUtils.h() && com.android.contacts.framework.api.appstore.appinfo.a.k()) {
                UserInfo userInfo2 = OplusMultiUserManager.getInstance().getUserInfo(i10);
                int id2 = userInfo2.getId();
                UserHandle userHandle2 = userInfo2.getUserHandle();
                i.e(userHandle2, "userInfo.userHandle");
                aVar = new a(id2, userHandle2, userInfo2.isEnabled());
            } else {
                K6.b a10 = M6.d.a(context, i10, i10);
                int a11 = a10.a();
                UserHandle b10 = a10.b();
                i.e(b10, "userInfo.userHandle");
                aVar = new a(a11, b10, a10.d());
            }
            return aVar;
        } catch (Exception unused) {
            return null;
        }
    }

    public static final int c() {
        int i10;
        try {
            if (C7.b.a(30, 1)) {
                i10 = com.oplus.wrapper.os.UserHandle.myUserId();
            } else {
                i10 = M6.b.f();
            }
        } catch (Exception e10) {
            H7.b.c("LocalUserManager", "e = " + e10);
            i10 = -1;
        }
        H7.b.e("LocalUserManager", "userId = " + i10);
        return i10;
    }
}
