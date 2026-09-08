package o6;

import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.oplus.blacklist.database.BlackListProvider;
import com.oplus.utils.C0848i;

/* compiled from: AbstractNumberProcessor.java */
/* renamed from: o6.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC1405a {
    public boolean a(Context context, SQLiteDatabase sQLiteDatabase, String str, int i10) {
        if (l7.b.f34735c) {
            return BlackListProvider.w(context, sQLiteDatabase, str, i10);
        }
        return BlackListProvider.v(context, sQLiteDatabase, str, i10);
    }

    public final String b(Context context, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("(SELECT * FROM bl_list WHERE ");
        if (e()) {
            if (!TextUtils.isEmpty(str2)) {
                sb.append("e164_number = ");
                DatabaseUtils.appendEscapedSQLString(sb, str2);
            } else {
                sb.append("number = ");
                DatabaseUtils.appendEscapedSQLString(sb, str);
            }
        } else {
            sb.append("1=1");
        }
        int a10 = C0848i.a(context);
        if (a10 == 1) {
            sb.append(" AND list_type = 10)");
        } else if (a10 == 2) {
            sb.append(" AND list_type = 20)");
        } else {
            sb.append(")");
        }
        return sb.toString();
    }

    public int c(Uri uri, String str, int i10) {
        String queryParameter = uri.getQueryParameter(str);
        if (queryParameter == null) {
            return i10;
        }
        try {
            return Integer.parseInt(queryParameter);
        } catch (NumberFormatException unused) {
            Log.e("AbstractNumberProcessor", "Integer required for " + str + " parameter but value '" + queryParameter + "' was found instead.");
            return i10;
        }
    }

    public abstract boolean d(Context context, String str, String str2);

    public abstract boolean e();

    /* JADX WARN: Removed duplicated region for block: B:30:0x0126 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0151  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.database.Cursor f(android.net.Uri r21, java.lang.String[] r22, java.lang.String r23, java.lang.String[] r24, java.lang.String r25, android.database.sqlite.SQLiteDatabase r26, android.content.Context r27, int r28) {
        /*
            Method dump skipped, instructions count: 386
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o6.AbstractC1405a.f(android.net.Uri, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String, android.database.sqlite.SQLiteDatabase, android.content.Context, int):android.database.Cursor");
    }
}
