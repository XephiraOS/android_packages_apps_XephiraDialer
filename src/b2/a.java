package B2;

import android.net.Uri;
import com.android.incallui.ConfigurationConstants;
import com.android.incallui.Log;
import com.android.incallui.OplusNumberMarkUtils;
import com.oplus.backup.sdk.common.utils.Constants;
import kotlin.jvm.internal.i;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.n;

/* compiled from: OplusBlackListUtils.kt */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f240a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final Uri f241b;

    /* renamed from: c, reason: collision with root package name */
    public static final Uri f242c;

    /* renamed from: d, reason: collision with root package name */
    public static final Uri f243d;

    static {
        Uri parse = Uri.parse("content://" + ConfigurationConstants.getBlackListAuthority());
        f241b = parse;
        Uri withAppendedPath = Uri.withAppendedPath(parse, OplusNumberMarkUtils.OplusBlacklist.BLACKLIST_TABLE);
        f242c = withAppendedPath;
        f243d = Uri.withAppendedPath(withAppendedPath, "black_or_area");
    }

    public static final String a(String phoneNumber) {
        String t10;
        int J10;
        int J11;
        i.f(phoneNumber, "phoneNumber");
        t10 = n.t(phoneNumber, " ", "", false, 4, null);
        try {
            int length = t10.length();
            J10 = StringsKt__StringsKt.J(t10, ",", 0, false, 6, null);
            J11 = StringsKt__StringsKt.J(t10, Constants.DataMigration.SPLIT_TAG, 0, false, 6, null);
            if (J10 == -1 || J11 != -1) {
                if (J10 == -1 && J11 != -1) {
                    J10 = J11;
                } else if (J10 != -1 && J11 != -1) {
                    J10 = Math.min(J10, J11);
                } else {
                    J10 = -1;
                }
            }
            if (J10 != -1 && J10 < length) {
                String substring = t10.substring(0, J10);
                i.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                return substring;
            }
            return t10;
        } catch (StringIndexOutOfBoundsException e10) {
            Log.e("OplusBlackListUtils", "exception: " + e10.getMessage());
            return t10;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00d9, code lost:
    
        if (r2.isClosed() == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0096, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0094, code lost:
    
        if (r2.isClosed() == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00b8, code lost:
    
        if (r2.isClosed() == false) goto L40;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00f8 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean b(android.content.Context r10, java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 263
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: B2.a.b(android.content.Context, java.lang.String):boolean");
    }
}
