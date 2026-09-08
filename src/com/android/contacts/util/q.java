package com.android.contacts.util;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import java.util.Map;

/* compiled from: NameConverter.java */
/* loaded from: classes.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f17594a = {"data4", "data2", "data5", "data3", "data6"};

    public static void a(Uri.Builder builder, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            builder.appendQueryParameter(str, str2);
        }
    }

    public static ContentValues b(Context context, String str, ContentValues contentValues) {
        if (contentValues == null) {
            contentValues = new ContentValues();
        }
        for (Map.Entry<String, String> entry : c(context, str).entrySet()) {
            contentValues.put(entry.getKey(), entry.getValue());
        }
        return contentValues;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x005e, code lost:
    
        if (r9 == null) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.Map<java.lang.String, java.lang.String> c(android.content.Context r8, java.lang.String r9) {
        /*
            java.util.TreeMap r0 = new java.util.TreeMap
            r0.<init>()
            android.net.Uri r1 = android.provider.ContactsContract.AUTHORITY_URI
            android.net.Uri$Builder r1 = r1.buildUpon()
            java.lang.String r2 = "complete_name"
            android.net.Uri$Builder r1 = r1.appendPath(r2)
            java.lang.String r2 = "data1"
            a(r1, r2, r9)
            r9 = 0
            android.content.ContentResolver r2 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            android.net.Uri r3 = r1.build()     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            java.lang.String[] r4 = com.android.contacts.util.q.f17594a     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            r6 = 0
            r7 = 0
            r5 = 0
            android.database.Cursor r9 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            boolean r8 = r9.moveToFirst()     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            if (r8 == 0) goto L44
            r8 = 0
        L2f:
            java.lang.String[] r1 = com.android.contacts.util.q.f17594a     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            int r2 = r1.length     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            if (r8 >= r2) goto L44
            r1 = r1[r8]     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            java.lang.String r2 = r9.getString(r8)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            r0.put(r1, r2)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            int r8 = r8 + 1
            goto L2f
        L40:
            r8 = move-exception
            goto L62
        L42:
            r8 = move-exception
            goto L48
        L44:
            r9.close()
            goto L61
        L48:
            java.lang.String r1 = "NameConverter"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L40
            r2.<init>()     // Catch: java.lang.Throwable -> L40
            java.lang.String r3 = "Exception e: "
            r2.append(r3)     // Catch: java.lang.Throwable -> L40
            r2.append(r8)     // Catch: java.lang.Throwable -> L40
            java.lang.String r8 = r2.toString()     // Catch: java.lang.Throwable -> L40
            H7.b.c(r1, r8)     // Catch: java.lang.Throwable -> L40
            if (r9 == 0) goto L61
            goto L44
        L61:
            return r0
        L62:
            if (r9 == 0) goto L67
            r9.close()
        L67:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.util.q.c(android.content.Context, java.lang.String):java.util.Map");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0042, code lost:
    
        if (r7 == null) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String d(android.content.Context r7, android.net.Uri r8) {
        /*
            r0 = 0
            android.content.ContentResolver r1 = r7.getContentResolver()     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2a
            java.lang.String r7 = "data1"
            java.lang.String[] r3 = new java.lang.String[]{r7}     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2a
            r5 = 0
            r6 = 0
            r4 = 0
            r2 = r8
            android.database.Cursor r7 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2a
            boolean r8 = r7.moveToFirst()     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L22
            if (r8 == 0) goto L24
            r8 = 0
            java.lang.String r0 = r7.getString(r8)     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L22
            goto L24
        L1f:
            r8 = move-exception
            r0 = r7
            goto L46
        L22:
            r8 = move-exception
            goto L2c
        L24:
            r7.close()
            goto L45
        L28:
            r8 = move-exception
            goto L46
        L2a:
            r8 = move-exception
            r7 = r0
        L2c:
            java.lang.String r1 = "NameConverter"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1f
            r2.<init>()     // Catch: java.lang.Throwable -> L1f
            java.lang.String r3 = "Exception e: "
            r2.append(r3)     // Catch: java.lang.Throwable -> L1f
            r2.append(r8)     // Catch: java.lang.Throwable -> L1f
            java.lang.String r8 = r2.toString()     // Catch: java.lang.Throwable -> L1f
            H7.b.c(r1, r8)     // Catch: java.lang.Throwable -> L1f
            if (r7 == 0) goto L45
            goto L24
        L45:
            return r0
        L46:
            if (r0 == 0) goto L4b
            r0.close()
        L4b:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.util.q.d(android.content.Context, android.net.Uri):java.lang.String");
    }

    public static String[] e() {
        return f17594a;
    }

    public static String f(Context context, ContentValues contentValues) {
        Uri.Builder appendPath = ContactsContract.AUTHORITY_URI.buildUpon().appendPath("complete_name");
        for (String str : f17594a) {
            if (contentValues.containsKey(str)) {
                a(appendPath, str, contentValues.getAsString(str));
            }
        }
        return d(context, appendPath.build());
    }

    public static String g(Context context, Map<String, String> map) {
        Uri.Builder appendPath = ContactsContract.AUTHORITY_URI.buildUpon().appendPath("complete_name");
        for (String str : f17594a) {
            if (map.containsKey(str)) {
                a(appendPath, str, map.get(str));
            }
        }
        return d(context, appendPath.build());
    }
}
