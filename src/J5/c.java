package J5;

import N5.f;
import N5.g;
import N5.h;
import N5.i;
import android.content.Context;
import android.os.UserManager;
import android.text.TextUtils;
import com.heytap.shield.authcode.dao.AuthenticationDb;
import com.oplus.backup.sdk.common.utils.Constants;
import java.util.Calendar;
import java.util.Iterator;
import java.util.concurrent.Executors;

/* compiled from: Authentication.java */
/* loaded from: classes3.dex */
public class c {
    public static L5.a b(Context context, String str, String str2) {
        if (!e(context)) {
            N5.d.b("Not get data from db cause user is locked.");
            return null;
        }
        K5.c a10 = AuthenticationDb.D(context).C().a(N5.e.d(context, str), str, "APP_PLATFORM_CLIENT", str2);
        if (a10 == null) {
            return null;
        }
        return new L5.a(str, 1001, a10.h());
    }

    public static L5.a c(Context context, String str) {
        int d10 = N5.e.d(context, str);
        if (TextUtils.isEmpty(str)) {
            N5.d.c("Get target packageName is empty");
            return new L5.a("", 1004, new byte[0]);
        }
        String b10 = N5.e.b(context, str);
        if (TextUtils.isEmpty(b10)) {
            N5.d.c("Get target application authCode is empty");
            return new L5.a("", 1004, new byte[0]);
        }
        try {
            Iterator<String> it = h.c(b10, Constants.DataMigration.SPLIT_TAG).iterator();
            while (it.hasNext()) {
                byte[][] d11 = d(str, it.next(), context);
                if (d11[0][0] == 1) {
                    byte[] bArr = d11[1];
                    g(context, b10, str, d10, i.a(d11[2]), bArr);
                    N5.d.d("Auth code check ok");
                    return new L5.a(str, 1001, bArr);
                }
            }
            N5.d.c("Signature verify failed, package : " + str);
            return new L5.a(str, 1002, new byte[0]);
        } catch (Exception e10) {
            N5.d.c("Check key get exception " + e10.getMessage());
            return new L5.a(str, 1002, new byte[0]);
        }
    }

    public static byte[][] d(String str, String str2, Context context) {
        byte[][] bArr = {new byte[]{0}};
        try {
            byte[] a10 = N5.a.a(str2);
            byte[] e10 = f.e(a10);
            byte[] bArr2 = {8};
            int b10 = h.b(f.d(a10));
            byte[] c10 = f.c(a10, b10);
            byte[] b11 = f.b(a10, b10);
            if (!g.c(context, str, e10, b10, bArr2, b11, c10, f.a(a10, b10))) {
                N5.d.d("Signature verify failed.");
                return bArr;
            }
            return new byte[][]{new byte[]{1}, c10, b11};
        } catch (Exception e11) {
            N5.d.c("Check key get exception " + e11.getMessage());
            return bArr;
        }
    }

    public static boolean e(Context context) {
        if (context != null) {
            return ((UserManager) context.getSystemService("user")).isUserUnlocked();
        }
        return false;
    }

    public static /* synthetic */ void f(String str, int i10, String str2, Calendar calendar, byte[] bArr, Context context) {
        AuthenticationDb.D(context).C().b(new K5.c(str, true, i10, str2, "APP_PLATFORM_CLIENT", calendar.getTimeInMillis(), bArr, System.currentTimeMillis(), 0L));
    }

    public static void g(final Context context, final String str, final String str2, final int i10, final Calendar calendar, final byte[] bArr) {
        if (!e(context)) {
            N5.d.b("Not save to db cause user is locked.");
        } else {
            if (str2 == null) {
                return;
            }
            Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: J5.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.f(str, i10, str2, calendar, bArr, context);
                }
            });
        }
    }
}
