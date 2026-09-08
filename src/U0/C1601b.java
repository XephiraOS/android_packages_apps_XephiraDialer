package u0;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.android.incallui.OplusPhoneUtils;
import java.util.ArrayList;

/* compiled from: FdnUtils.java */
/* renamed from: u0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1601b {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f37300a = {OplusPhoneUtils.PREFIX_MX_COUNTRY};

    /* renamed from: b, reason: collision with root package name */
    public static final Uri f37301b = Uri.parse("content://icc/fdn");

    public static boolean a(String str, String str2) {
        String d10 = d(str);
        String d11 = d(str2);
        if (H7.a.b()) {
            H7.b.e("FdnUtils", "checkFdnNumberSame removePrefixNumberA:" + H7.a.d(d10) + " removePrefixNumberB:" + H7.a.d(d11));
        }
        return TextUtils.equals(d10, d11);
    }

    public static String b(Context context, ArrayList<String> arrayList, String str) {
        if (arrayList != null) {
            boolean z10 = false;
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                if (a(str, arrayList.get(i10))) {
                    z10 = true;
                }
            }
            if (z10) {
                return c(context, str);
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0078, code lost:
    
        if (r0.moveToFirst() != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x007a, code lost:
    
        r9 = r0.getString(r0.getColumnIndex("number"));
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0088, code lost:
    
        if (H7.a.b() == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x008a, code lost:
    
        H7.b.e("FdnUtils", "fdn name from db number:" + H7.a.d(r9));
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00ab, code lost:
    
        if (a(r10, r9) == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00d6, code lost:
    
        if (r0.moveToNext() != false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00ad, code lost:
    
        r2 = r0.getString(r0.getColumnIndex("name"));
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00bb, code lost:
    
        if (H7.a.b() == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00bd, code lost:
    
        H7.b.e("FdnUtils", "get fdn name:" + r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00d8, code lost:
    
        if (r0 != null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00da, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00e6, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00e3, code lost:
    
        if (r0 == null) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String c(android.content.Context r9, java.lang.String r10) {
        /*
            boolean r0 = H7.a.b()
            java.lang.String r1 = "FdnUtils"
            if (r0 == 0) goto L20
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "fdn name number:"
            r0.append(r2)
            java.lang.String r2 = H7.a.d(r10)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            H7.b.e(r1, r0)
        L20:
            boolean r0 = android.text.TextUtils.isEmpty(r10)
            java.lang.String r2 = ""
            if (r0 != 0) goto Led
            if (r9 != 0) goto L2c
            goto Led
        L2c:
            java.lang.String r0 = d(r10)
            boolean r3 = H7.a.b()
            if (r3 == 0) goto L4e
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "fdn name removePrefixNumber:"
            r3.append(r4)
            java.lang.String r4 = H7.a.d(r0)
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            H7.b.e(r1, r3)
        L4e:
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L55
            return r2
        L55:
            r0 = 0
            java.lang.String r6 = "number = ?"
            java.lang.String r3 = java.lang.String.valueOf(r10)     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            java.lang.String[] r7 = new java.lang.String[]{r3}     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            android.content.ContentResolver r3 = r9.getContentResolver()     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            android.net.Uri r4 = u0.C1601b.f37301b     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            r5 = 0
            r8 = 0
            android.database.Cursor r0 = r3.query(r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            if (r0 == 0) goto Ld8
            int r9 = r0.getCount()     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            if (r9 == 0) goto Ld8
            boolean r9 = r0.moveToFirst()     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            if (r9 == 0) goto Ld8
        L7a:
            java.lang.String r9 = "number"
            int r9 = r0.getColumnIndex(r9)     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            java.lang.String r9 = r0.getString(r9)     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            boolean r3 = H7.a.b()     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            if (r3 == 0) goto La7
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            r3.<init>()     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            java.lang.String r4 = "fdn name from db number:"
            r3.append(r4)     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            java.lang.String r4 = H7.a.d(r9)     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            r3.append(r4)     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            H7.b.e(r1, r3)     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            goto La7
        La3:
            r9 = move-exception
            goto Le7
        La5:
            r9 = move-exception
            goto Lde
        La7:
            boolean r9 = a(r10, r9)     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            if (r9 == 0) goto Ld2
            java.lang.String r9 = "name"
            int r9 = r0.getColumnIndex(r9)     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            java.lang.String r2 = r0.getString(r9)     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            boolean r9 = H7.a.b()     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            if (r9 == 0) goto Ld8
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            r9.<init>()     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            java.lang.String r10 = "get fdn name:"
            r9.append(r10)     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            r9.append(r2)     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            H7.b.e(r1, r9)     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            goto Ld8
        Ld2:
            boolean r9 = r0.moveToNext()     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            if (r9 != 0) goto L7a
        Ld8:
            if (r0 == 0) goto Le6
        Lda:
            r0.close()
            goto Le6
        Lde:
            java.lang.String r10 = "fdn error"
            H7.b.d(r1, r10, r9)     // Catch: java.lang.Throwable -> La3
            if (r0 == 0) goto Le6
            goto Lda
        Le6:
            return r2
        Le7:
            if (r0 == 0) goto Lec
            r0.close()
        Lec:
            throw r9
        Led:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: u0.C1601b.c(android.content.Context, java.lang.String):java.lang.String");
    }

    public static String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        for (String str2 : f37300a) {
            if (str.startsWith(str2)) {
                return str.substring(str2.length());
            }
        }
        return str;
    }
}
