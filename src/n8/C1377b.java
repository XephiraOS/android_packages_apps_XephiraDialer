package n8;

import android.content.Context;
import android.text.TextUtils;
import com.oplus.backup.sdk.common.utils.Constants;
import java.util.Iterator;
import o8.C1409a;
import q8.C1495a;
import q8.e;
import q8.f;
import q8.g;
import q8.h;

/* compiled from: Authentication.java */
/* renamed from: n8.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1377b {
    public static C1409a a(Context context, String str) {
        String b10 = e.b(context, str);
        if (f(str) && e(b10)) {
            try {
                Iterator<String> it = h.c(b10, Constants.DataMigration.SPLIT_TAG).iterator();
                while (it.hasNext()) {
                    byte[][] b11 = b(str, it.next(), context);
                    if (b11[0][0] == 1) {
                        return new C1409a(str, 1001, b11[1], b10);
                    }
                }
                return new C1409a(str, 1002, new byte[0], null);
            } catch (Exception e10) {
                q8.d.c("Check key get exception " + e10.getMessage());
                return new C1409a(str, 1002, new byte[0], null);
            }
        }
        return new C1409a("", 1004, new byte[0], null);
    }

    public static byte[][] b(String str, String str2, Context context) {
        byte[][] bArr = {new byte[]{0}};
        try {
            if (!g(str, str2, context)) {
                q8.d.d("Signature verify failed.");
                return bArr;
            }
            return new byte[][]{new byte[]{1}, d(str2), c(str2)};
        } catch (Exception e10) {
            q8.d.c("Check key get exception " + e10.getMessage());
            return bArr;
        }
    }

    public static byte[] c(String str) {
        byte[] a10 = C1495a.a(str);
        return f.b(a10, h.b(f.d(a10)));
    }

    public static byte[] d(String str) {
        byte[] a10 = C1495a.a(str);
        return f.c(a10, h.b(f.d(a10)));
    }

    public static boolean e(String str) {
        if (TextUtils.isEmpty(str)) {
            q8.d.c("Get target application authCode is empty");
            return false;
        }
        return true;
    }

    public static boolean f(String str) {
        if (TextUtils.isEmpty(str)) {
            q8.d.c("Get target packageName is empty");
            return false;
        }
        return true;
    }

    public static boolean g(String str, String str2, Context context) {
        byte[] a10 = C1495a.a(str2);
        byte[] e10 = f.e(a10);
        byte[] bArr = {8};
        int b10 = h.b(f.d(a10));
        return g.e(context, str, e10, b10, bArr, f.b(a10, b10), f.c(a10, b10), f.a(a10, b10));
    }
}
