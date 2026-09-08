package com.customize.contacts.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Xml;
import com.customize.contacts.FeatureOption;
import com.oplus.foundation.util.OsUtils;
import java.io.StringReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: RomUpdateUtils.java */
/* loaded from: classes3.dex */
public class Y {

    /* compiled from: RomUpdateUtils.java */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final Uri f21991a;

        static {
            String str;
            if (OsUtils.l()) {
                str = "content://com.nearme.romupdate.provider.db/update_list";
            } else {
                str = "content://com.oplus.romupdate.provider.db/update_list";
            }
            f21991a = Uri.parse(str);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0049  */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r9v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10, types: [android.content.ContentProviderClient, java.lang.AutoCloseable] */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.lang.AutoCloseable] */
    /* JADX WARN: Type inference failed for: r9v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(android.content.Context r9) {
        /*
            java.lang.String r0 = "RomUpdateUtils"
            java.lang.String r1 = "xml"
            java.lang.String[] r4 = new java.lang.String[]{r1}
            r1 = 0
            android.content.ContentResolver r9 = r9.getContentResolver()     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5c
            android.net.Uri r3 = com.customize.contacts.util.Y.a.f21991a     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5c
            android.content.ContentProviderClient r9 = r9.acquireUnstableContentProviderClient(r3)     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5c
            if (r9 != 0) goto L1d
            java.lang.AutoCloseable[] r9 = new java.lang.AutoCloseable[]{r9}
            com.oplus.foundation.util.io.CloseableUtils.a(r9)
            return r1
        L1d:
            java.lang.String r5 = "filterName=\"comm_contacts_romupdate_values\""
            r6 = 0
            r7 = 0
            r2 = r9
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            if (r2 == 0) goto L42
            int r3 = r2.getCount()     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3d
            if (r3 <= 0) goto L42
        L2e:
            boolean r3 = r2.moveToNext()     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3d
            if (r3 == 0) goto L47
            r3 = 0
            java.lang.String r1 = r2.getString(r3)     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3d
            goto L2e
        L3a:
            r0 = move-exception
            r1 = r2
            goto L81
        L3d:
            r3 = move-exception
            r8 = r2
            r2 = r1
            r1 = r8
            goto L5f
        L42:
            java.lang.String r3 = "cursor is null"
            H7.b.b(r0, r3)     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3d
        L47:
            if (r2 == 0) goto L4c
            r2.close()
        L4c:
            java.lang.AutoCloseable[] r9 = new java.lang.AutoCloseable[]{r9}
            com.oplus.foundation.util.io.CloseableUtils.a(r9)
            goto L80
        L54:
            r0 = move-exception
            goto L81
        L56:
            r3 = move-exception
            r2 = r1
            goto L5f
        L59:
            r0 = move-exception
            r9 = r1
            goto L81
        L5c:
            r3 = move-exception
            r9 = r1
            r2 = r9
        L5f:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L54
            r4.<init>()     // Catch: java.lang.Throwable -> L54
            java.lang.String r5 = "Exception"
            r4.append(r5)     // Catch: java.lang.Throwable -> L54
            r4.append(r3)     // Catch: java.lang.Throwable -> L54
            java.lang.String r3 = r4.toString()     // Catch: java.lang.Throwable -> L54
            H7.b.c(r0, r3)     // Catch: java.lang.Throwable -> L54
            if (r1 == 0) goto L78
            r1.close()
        L78:
            java.lang.AutoCloseable[] r9 = new java.lang.AutoCloseable[]{r9}
            com.oplus.foundation.util.io.CloseableUtils.a(r9)
            r1 = r2
        L80:
            return r1
        L81:
            if (r1 == 0) goto L86
            r1.close()
        L86:
            java.lang.AutoCloseable[] r9 = new java.lang.AutoCloseable[]{r9}
            com.oplus.foundation.util.io.CloseableUtils.a(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.util.Y.a(android.content.Context):java.lang.String");
    }

    public static void b(Context context) {
        c(context, false);
    }

    public static void c(Context context, boolean z10) {
        try {
            XmlPullParser newPullParser = Xml.newPullParser();
            String a10 = a(context);
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            if (TextUtils.isEmpty(a10)) {
                H7.b.b("RomUpdateUtils", "get from local assets fromOnCreate = " + z10);
                if (z10) {
                    return;
                } else {
                    newPullParser.setInput(context.getResources().getAssets().open("comm_contacts_romupdate_values.xml"), "UTF-8");
                }
            } else {
                H7.b.b("RomUpdateUtils", "get from nearme database");
                newPullParser.setInput(new StringReader(a10));
            }
            C1.e.a(newPullParser, "romupdateValues");
            while (true) {
                C1.e.b(newPullParser);
                if ("romupdateValue".equals(newPullParser.getName())) {
                    String attributeValue = newPullParser.getAttributeValue(null, "valueName");
                    int parseInt = Integer.parseInt(newPullParser.getAttributeValue(null, "value"));
                    H7.b.b("RomUpdateUtils", "loadXmlValues::valueName:" + attributeValue + ",VALUE: " + parseInt);
                    if (TextUtils.equals(attributeValue, "count_for_mark_info") && parseInt >= 0) {
                        G0.c.n(context, 1, R0.c.f3192j, parseInt);
                        FeatureOption.s(parseInt);
                    }
                    if (TextUtils.equals(attributeValue, "count_for_stranger") && parseInt >= 0) {
                        G0.c.n(context, 1, R0.c.f3193k, parseInt);
                        FeatureOption.t(parseInt);
                    }
                    if (TextUtils.equals(attributeValue, "count_for_number_call_summary") && parseInt >= 0) {
                        defaultSharedPreferences.edit().putInt("count_for_number_call_summary", parseInt).apply();
                    }
                    if (TextUtils.equals(attributeValue, "business_hall_disable") && parseInt >= 0) {
                        defaultSharedPreferences.edit().putInt("business_hall_disable", parseInt).apply();
                    }
                } else {
                    return;
                }
            }
        } catch (XmlPullParserException e10) {
            H7.b.c("RomUpdateUtils", "Exception in app-comm_contacts_romupdate_values.xml parser e = " + e10);
        } catch (Exception e11) {
            H7.b.c("RomUpdateUtils", "Exception in app-comm_contacts_romupdate_values.xml parser e = " + e11);
        }
    }
}
