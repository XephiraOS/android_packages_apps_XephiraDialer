package com.android.contacts.calllog;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import com.android.incallui.OplusPhoneUtils;
import h1.C1072a;
import org.json.JSONException;
import org.json.JSONObject;
import w0.C1641a;

/* compiled from: ContactInfoHelper.java */
/* loaded from: classes.dex */
public class A {

    /* renamed from: a, reason: collision with root package name */
    public final Context f13730a;

    /* renamed from: b, reason: collision with root package name */
    public final String f13731b;

    public A(Context context, String str) {
        this.f13730a = context;
        this.f13731b = str;
    }

    public static Uri c(String str) {
        try {
            return ContactsContract.Contacts.CONTENT_LOOKUP_URI.buildUpon().appendPath("encoded").appendQueryParameter("directory", String.valueOf(Long.MAX_VALUE)).encodedFragment(new JSONObject().put("display_name", str).put("display_name_source", 20).put("vnd.android.cursor.item/contact", new JSONObject().put("vnd.android.cursor.item/phone_v2", new JSONObject().put("data1", str).put("data2", 0))).toString()).build();
        } catch (JSONException unused) {
            return null;
        }
    }

    public static boolean l(String str) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str.trim())) {
            return false;
        }
        return true;
    }

    public final y a(String str, String str2) {
        y yVar = new y();
        yVar.f14061f = str;
        yVar.f14062g = e(str, null, str2);
        yVar.f14063h = PhoneNumberUtils.formatNumberToE164(str, str2);
        yVar.f14057b = c(yVar.f14062g);
        return yVar;
    }

    public final y b(Cursor cursor) {
        y yVar = new y();
        boolean z10 = false;
        long j10 = cursor.getLong(0);
        yVar.f14057b = ContactsContract.Contacts.getLookupUri(j10, cursor.getString(7));
        yVar.f14058c = cursor.getString(1);
        yVar.f14059d = cursor.getInt(2);
        yVar.f14060e = cursor.getString(3);
        yVar.f14061f = cursor.getString(4);
        yVar.f14063h = cursor.getString(5);
        yVar.f14066k = cursor.getLong(6);
        yVar.f14067l = U7.g.b(cursor.getString(8));
        yVar.f14056a = j10;
        yVar.f14062g = null;
        if (cursor.getInt(9) > 0) {
            z10 = true;
        }
        yVar.f14073r = z10;
        return yVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x005f, code lost:
    
        if (r1.isClosed() == false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String d(java.lang.String r9) {
        /*
            r8 = this;
            java.lang.String r0 = ""
            if (r9 == 0) goto L83
            java.lang.String r1 = "0"
            boolean r1 = r9.startsWith(r1)
            if (r1 == 0) goto L83
            r1 = 0
            android.net.Uri r3 = com.android.contacts.framework.baseui.util.LocationUtils.h(r9)     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            android.content.Context r8 = r8.f13730a     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
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
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.calllog.A.d(java.lang.String):java.lang.String");
    }

    public final String e(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (C1072a.f(str)) {
            return str;
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = this.f13731b;
        }
        return PhoneNumberUtils.formatNumber(str, str2, str3);
    }

    public final y f(String str, String str2, String str3, long j10) {
        if (C1072a.f(str)) {
            y n10 = n(str, j10);
            if (n10 == null || n10 == y.f14054B) {
                String b10 = C1072a.b(str);
                if (PhoneNumberUtils.isGlobalPhoneNumber(b10)) {
                    return m(b10, str2, str3, j10);
                }
                return n10;
            }
            return n10;
        }
        return m(str, str2, str3, j10);
    }

    public boolean g(y yVar) {
        if (yVar != null && !TextUtils.isEmpty(yVar.f14058c)) {
            return true;
        }
        return false;
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
    public final com.android.contacts.calllog.y h(android.net.Uri r9) {
        /*
            r8 = this;
            r0 = 0
            if (r9 != 0) goto L4
            return r0
        L4:
            android.content.Context r1 = r8.f13730a     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
            android.content.ContentResolver r2 = r1.getContentResolver()     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
            java.lang.String[] r4 = com.android.contacts.calllog.J.f13855a     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
            r6 = 0
            r7 = 0
            r5 = 0
            r3 = r9
            android.database.Cursor r9 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
            if (r9 == 0) goto L28
            boolean r1 = r9.moveToFirst()     // Catch: java.lang.Throwable -> L21 java.lang.Exception -> L24
            if (r1 == 0) goto L26
            com.android.contacts.calllog.y r0 = r8.b(r9)     // Catch: java.lang.Throwable -> L21 java.lang.Exception -> L24
            goto L28
        L21:
            r8 = move-exception
            r0 = r9
            goto L58
        L24:
            r8 = move-exception
            goto L38
        L26:
            com.android.contacts.calllog.y r0 = com.android.contacts.calllog.y.f14054B     // Catch: java.lang.Throwable -> L21 java.lang.Exception -> L24
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
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.calllog.A.h(android.net.Uri):com.android.contacts.calllog.y");
    }

    public y i(String str) {
        if (l(str)) {
            H7.b.c("ContactInfoHelper", "the number is null");
            return null;
        }
        y f10 = f(str, "CN", null, -1L);
        if (f10 == null) {
            return null;
        }
        if (f10 == y.f14054B) {
            y yVar = new y();
            yVar.f14061f = str;
            yVar.f14062g = str;
            return yVar;
        }
        return f10;
    }

    public y j(String str, String str2, String str3, long j10) {
        if (l(str)) {
            H7.b.c("ContactInfoHelper", "the number is null");
            return null;
        }
        y f10 = f(str, str2, str3, j10);
        if ((f10 == null || f10 == y.f14054B) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
            f10 = f(str, str2, null, j10);
        }
        if (f10 == null) {
            return null;
        }
        if (f10 == y.f14054B) {
            y yVar = new y();
            yVar.f14061f = str;
            yVar.f14062g = str;
            yVar.f14065j = d(str);
            return yVar;
        }
        return f10;
    }

    public y k(String str, String str2, String str3) {
        return a(str, str2);
    }

    public final y m(String str, String str2, String str3, long j10) {
        Uri c10;
        if (!TextUtils.isEmpty(str3)) {
            c10 = R0.d.c(str);
        } else {
            c10 = C1641a.c(str);
        }
        if (!TextUtils.isEmpty(str3)) {
            c10 = Uri.withAppendedPath(c10, str3);
        }
        if (H7.a.b()) {
            H7.b.b("ContactInfoHelper", "queryContactInfoForPhoneNumber, the uri is " + H7.a.e(c10));
        }
        if (j10 != -1) {
            c10 = c10.buildUpon().appendQueryParameter("directory", String.valueOf(j10)).build();
        }
        y h10 = h(c10.buildUpon().appendQueryParameter("query_vip", "true").build().buildUpon().appendQueryParameter("countryISO_for_calllog", str2).build());
        if (h10 != null && h10 != y.f14054B) {
            h10.f14062g = str;
            if (j10 == -1) {
                h10.f14064i = 1;
            } else {
                h10.f14064i = 2;
            }
        }
        return h10;
    }

    public final y n(String str, long j10) {
        Uri.Builder buildUpon = ContactsContract.PhoneLookup.CONTENT_FILTER_URI.buildUpon();
        buildUpon.appendPath(Uri.encode(str));
        buildUpon.appendQueryParameter("sip", OplusPhoneUtils.DeviceState.LOCK_DEVICE);
        if (j10 != -1) {
            buildUpon.appendQueryParameter("directory", String.valueOf(j10));
        }
        return h(buildUpon.build());
    }
}
