package J0;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import com.android.incallui.OplusPhoneUtils;
import h1.C1072a;

/* compiled from: ContactInfoHelper.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public final Context f1460a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1461b;

    public g(Context context, String str) {
        this.f1460a = context;
        this.f1461b = str;
    }

    public static boolean f(String str) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str.trim())) {
            return false;
        }
        return true;
    }

    public final f a(Cursor cursor) {
        f fVar = new f();
        boolean z10 = false;
        long j10 = cursor.getLong(0);
        fVar.f1445b = ContactsContract.Contacts.getLookupUri(j10, cursor.getString(7));
        fVar.f1446c = cursor.getString(1);
        fVar.f1447d = cursor.getInt(2);
        fVar.f1448e = cursor.getString(3);
        fVar.f1449f = cursor.getString(4);
        fVar.f1451h = cursor.getString(5);
        fVar.f1455l = cursor.getLong(6);
        fVar.f1456m = U7.g.b(cursor.getString(8));
        fVar.f1444a = j10;
        fVar.f1450g = null;
        if (cursor.getInt(9) > 0) {
            z10 = true;
        }
        fVar.f1457n = z10;
        return fVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x005f, code lost:
    
        if (r1.isClosed() == false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String b(java.lang.String r9) {
        /*
            r8 = this;
            java.lang.String r0 = ""
            if (r9 == 0) goto L83
            java.lang.String r1 = "0"
            boolean r1 = r9.startsWith(r1)
            if (r1 == 0) goto L83
            r1 = 0
            android.net.Uri r3 = com.android.contacts.framework.baseui.util.LocationUtils.h(r9)     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            android.content.Context r8 = r8.f1460a     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            android.content.ContentResolver r2 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            r6 = 0
            r7 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            if (r1 == 0) goto L37
            boolean r8 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            r2 = 1
            if (r8 != r2) goto L37
            java.lang.String r8 = "areano"
            int r8 = r1.getColumnIndex(r8)     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            java.lang.String r0 = r1.getString(r8)     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            goto L37
        L33:
            r8 = move-exception
            goto L77
        L35:
            r8 = move-exception
            goto L43
        L37:
            if (r1 == 0) goto L62
            boolean r8 = r1.isClosed()
            if (r8 != 0) goto L62
        L3f:
            r1.close()
            goto L62
        L43:
            java.lang.String r2 = "ContactInfoHelper"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L33
            r3.<init>()     // Catch: java.lang.Throwable -> L33
            java.lang.String r4 = "e = "
            r3.append(r4)     // Catch: java.lang.Throwable -> L33
            r3.append(r8)     // Catch: java.lang.Throwable -> L33
            java.lang.String r8 = r3.toString()     // Catch: java.lang.Throwable -> L33
            H7.b.c(r2, r8)     // Catch: java.lang.Throwable -> L33
            if (r1 == 0) goto L62
            boolean r8 = r1.isClosed()
            if (r8 != 0) goto L62
            goto L3f
        L62:
            if (r0 == 0) goto L86
            int r8 = r0.length()
            int r1 = r9.length()
            if (r8 > r1) goto L86
            int r8 = r0.length()
            java.lang.String r9 = r9.substring(r8)
            goto L86
        L77:
            if (r1 == 0) goto L82
            boolean r9 = r1.isClosed()
            if (r9 != 0) goto L82
            r1.close()
        L82:
            throw r8
        L83:
            if (r9 != 0) goto L86
            return r0
        L86:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: J0.g.b(java.lang.String):java.lang.String");
    }

    public final f c(String str, String str2, String str3, long j10) {
        if (C1072a.f(str)) {
            f h10 = h(str, j10);
            if (h10 == null || h10 == f.f1443q) {
                String b10 = C1072a.b(str);
                if (PhoneNumberUtils.isGlobalPhoneNumber(b10)) {
                    return g(b10, str2, str3, j10);
                }
                return h10;
            }
            return h10;
        }
        return g(str, str2, str3, j10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002e, code lost:
    
        if (r9.isClosed() == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0030, code lost:
    
        r9.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0054, code lost:
    
        if (r9.isClosed() == false) goto L18;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final J0.f d(android.net.Uri r9) {
        /*
            r8 = this;
            r0 = 0
            if (r9 != 0) goto L4
            return r0
        L4:
            android.content.Context r1 = r8.f1460a     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
            android.content.ContentResolver r2 = r1.getContentResolver()     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
            java.lang.String[] r4 = J0.m.f1467a     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
            r6 = 0
            r7 = 0
            r5 = 0
            r3 = r9
            android.database.Cursor r9 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
            if (r9 == 0) goto L28
            boolean r1 = r9.moveToFirst()     // Catch: java.lang.Throwable -> L21 java.lang.Exception -> L24
            if (r1 == 0) goto L26
            J0.f r0 = r8.a(r9)     // Catch: java.lang.Throwable -> L21 java.lang.Exception -> L24
            goto L28
        L21:
            r8 = move-exception
            r0 = r9
            goto L58
        L24:
            r8 = move-exception
            goto L38
        L26:
            J0.f r0 = J0.f.f1443q     // Catch: java.lang.Throwable -> L21 java.lang.Exception -> L24
        L28:
            if (r9 == 0) goto L57
            boolean r8 = r9.isClosed()
            if (r8 != 0) goto L57
        L30:
            r9.close()
            goto L57
        L34:
            r8 = move-exception
            goto L58
        L36:
            r8 = move-exception
            r9 = r0
        L38:
            java.lang.String r1 = "ContactInfoHelper"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L21
            r2.<init>()     // Catch: java.lang.Throwable -> L21
            java.lang.String r3 = "Exception: "
            r2.append(r3)     // Catch: java.lang.Throwable -> L21
            r2.append(r8)     // Catch: java.lang.Throwable -> L21
            java.lang.String r8 = r2.toString()     // Catch: java.lang.Throwable -> L21
            H7.b.i(r1, r8)     // Catch: java.lang.Throwable -> L21
            if (r9 == 0) goto L57
            boolean r8 = r9.isClosed()
            if (r8 != 0) goto L57
            goto L30
        L57:
            return r0
        L58:
            if (r0 == 0) goto L63
            boolean r9 = r0.isClosed()
            if (r9 != 0) goto L63
            r0.close()
        L63:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: J0.g.d(android.net.Uri):J0.f");
    }

    public f e(String str, String str2, String str3, long j10) {
        if (f(str)) {
            H7.b.c("ContactInfoHelper", "the number is null");
            return null;
        }
        f c10 = c(str, str2, str3, j10);
        if ((c10 == null || c10 == f.f1443q) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
            c10 = c(str, str2, null, j10);
        }
        if (c10 == null) {
            return null;
        }
        if (c10 == f.f1443q) {
            f fVar = new f();
            fVar.f1449f = str;
            fVar.f1450g = str;
            fVar.f1454k = b(str);
            return fVar;
        }
        return c10;
    }

    public final f g(String str, String str2, String str3, long j10) {
        Uri c10 = R0.d.c(str);
        if (!TextUtils.isEmpty(str3)) {
            c10 = Uri.withAppendedPath(c10, str3);
        }
        if (H7.a.b()) {
            H7.b.b("ContactInfoHelper", "queryContactInfoForPhoneNumber, the uri is " + H7.a.e(c10));
        }
        if (j10 != -1) {
            c10 = c10.buildUpon().appendQueryParameter("directory", String.valueOf(j10)).build();
        }
        f d10 = d(c10.buildUpon().appendQueryParameter("query_vip", "true").build().buildUpon().appendQueryParameter("countryISO_for_calllog", str2).build());
        if (d10 != null && d10 != f.f1443q) {
            d10.f1450g = str;
            if (j10 == -1) {
                d10.f1452i = 1;
            } else {
                d10.f1452i = 2;
            }
        }
        return d10;
    }

    public final f h(String str, long j10) {
        Uri.Builder buildUpon = ContactsContract.PhoneLookup.CONTENT_FILTER_URI.buildUpon();
        buildUpon.appendPath(Uri.encode(str));
        buildUpon.appendQueryParameter("sip", OplusPhoneUtils.DeviceState.LOCK_DEVICE);
        if (j10 != -1) {
            buildUpon.appendQueryParameter("directory", String.valueOf(j10));
        }
        return d(buildUpon.build());
    }
}
