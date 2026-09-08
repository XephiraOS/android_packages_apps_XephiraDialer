package com.customize.contacts.manager;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.android.contacts.model.Account;
import com.customize.contacts.util.C0814z;
import com.customize.contacts.util.K;
import com.customize.contacts.util.S;
import com.oplus.backup.sdk.common.utils.ApplicationFileInfo;
import com.oplus.foundation.util.OsUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import r0.C1498a;
import r0.C1502e;

/* compiled from: CustomizeRingtoneManager.java */
/* loaded from: classes3.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final String f21551a = C1498a.f36241D;

    /* renamed from: b, reason: collision with root package name */
    public static final String f21552b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f21553c;

    /* renamed from: d, reason: collision with root package name */
    public static Map<String, String> f21554d;

    /* renamed from: e, reason: collision with root package name */
    public static Map<String, String> f21555e;

    /* renamed from: f, reason: collision with root package name */
    public static String f21556f;

    static {
        String str;
        if (OsUtils.l()) {
            str = "color_ringtone_type";
        } else {
            str = "oplus_ringtone_type";
        }
        f21552b = str;
        f21553c = M7.a.h(P7.a.f2962b, "com.android.settings", "support_ringtone_uri_null", "true");
        f21554d = new ConcurrentHashMap();
        f21555e = new ConcurrentHashMap();
        f21556f = K.a();
        i(P7.a.f2962b);
    }

    public static Intent a(Context context, String str) {
        Uri uri;
        Intent intent = new Intent();
        intent.setAction(f21551a);
        intent.putExtra("android.intent.extra.ringtone.TYPE", 1);
        intent.putExtra(ApplicationFileInfo.PACKAGE_NAME, context.getPackageName());
        intent.putExtra("android.intent.extra.ringtone.SHOW_SILENT", false);
        if (H7.a.b()) {
            H7.b.b("CustomizeRingtoneManager", "buildRingtonePickIntent(), ringtone = " + str);
        }
        if (str != null && g(context, str) != null) {
            if (RingtoneManager.isDefault(Uri.parse(str))) {
                uri = RingtoneManager.getActualDefaultRingtoneUri(context, 1);
            } else {
                uri = Uri.parse(str);
            }
        } else if (!f21553c) {
            uri = RingtoneManager.getActualDefaultRingtoneUri(context, 1);
        } else {
            uri = null;
        }
        if (H7.a.b()) {
            H7.b.b("CustomizeRingtoneManager", "buildRingtonePickIntent(), ringtoneUri = " + uri);
        }
        n(intent, str);
        intent.putExtra("android.intent.extra.ringtone.EXISTING_URI", uri);
        intent.putExtra(f21552b, 1);
        intent.putExtra("directly_uri", true);
        intent.putExtra("from", "CONTACT");
        intent.putExtra("needFinishSettingsPage", true);
        return intent;
    }

    public static void b(Activity activity, String str, String str2) {
        Intent a10 = a(activity, str);
        S.a(a10, str2);
        Q7.b.b(activity, a10, 889, 0);
    }

    public static String c(Context context) {
        try {
            return G0.c.j(context, 0, "ringtone");
        } catch (Exception e10) {
            H7.b.c("CustomizeRingtoneManager", "e =" + e10);
            return null;
        }
    }

    public static synchronized String d(String str) {
        String orDefault;
        synchronized (i.class) {
            try {
                String a10 = K.a();
                String str2 = f21556f;
                if (str2 != null) {
                    if (!str2.equals(a10)) {
                    }
                    orDefault = f21554d.getOrDefault(str, str);
                }
                f21556f = a10;
                f21554d.clear();
                i(P7.a.f2962b);
                orDefault = f21554d.getOrDefault(str, str);
            } catch (Throwable th) {
                throw th;
            }
        }
        return orDefault;
    }

    public static String e(Context context, String str) {
        if (str == null) {
            return null;
        }
        return f(context, Uri.parse(str));
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x008c, code lost:
    
        if (r2 == null) goto L40;
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String f(android.content.Context r9, android.net.Uri r10) {
        /*
            java.lang.String r0 = "."
            r1 = 0
            if (r10 == 0) goto La4
            boolean r2 = android.media.RingtoneManager.isDefault(r10)
            if (r2 == 0) goto Ld
            goto La4
        Ld:
            android.content.ContentResolver r3 = r9.getContentResolver()     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
            java.lang.String r2 = "title"
            java.lang.String r4 = "_data"
            java.lang.String[] r5 = new java.lang.String[]{r2, r4}     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
            r7 = 0
            r8 = 0
            r6 = 0
            r4 = r10
            android.database.Cursor r2 = r3.query(r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
            if (r2 == 0) goto L6b
            int r3 = r2.getCount()     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L63
            if (r3 != 0) goto L2a
            goto L6b
        L2a:
            java.lang.String r3 = r10.toString()     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L63
            java.lang.String r4 = "content://media/external/"
            boolean r3 = r3.startsWith(r4)     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L63
            if (r3 == 0) goto L66
            r2.moveToFirst()     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L63
            r3 = 1
            java.lang.String r3 = r2.getString(r3)     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L63
            if (r3 == 0) goto L67
            android.net.Uri r4 = android.net.Uri.parse(r3)     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L61
            java.lang.String r3 = r4.getLastPathSegment()     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L61
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L61
            if (r4 != 0) goto L67
            boolean r4 = r3.contains(r0)     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L61
            if (r4 == 0) goto L67
            int r0 = r3.lastIndexOf(r0)     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L61
            r4 = 0
            java.lang.String r3 = r3.substring(r4, r0)     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L61
            goto L67
        L5e:
            r9 = move-exception
            r1 = r2
            goto L9e
        L61:
            r0 = move-exception
            goto L76
        L63:
            r0 = move-exception
            r3 = r1
            goto L76
        L66:
            r3 = r1
        L67:
            r2.close()
            goto L8f
        L6b:
            if (r2 == 0) goto L70
            r2.close()
        L70:
            return r1
        L71:
            r9 = move-exception
            goto L9e
        L73:
            r0 = move-exception
            r2 = r1
            r3 = r2
        L76:
            java.lang.String r4 = "CustomizeRingtoneManager"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5e
            r5.<init>()     // Catch: java.lang.Throwable -> L5e
            java.lang.String r6 = "Exception e: "
            r5.append(r6)     // Catch: java.lang.Throwable -> L5e
            r5.append(r0)     // Catch: java.lang.Throwable -> L5e
            java.lang.String r0 = r5.toString()     // Catch: java.lang.Throwable -> L5e
            H7.b.c(r4, r0)     // Catch: java.lang.Throwable -> L5e
            if (r2 == 0) goto L8f
            goto L67
        L8f:
            if (r3 == 0) goto L92
            return r3
        L92:
            android.media.Ringtone r10 = android.media.RingtoneManager.getRingtone(r9, r10)
            if (r10 != 0) goto L99
            return r1
        L99:
            java.lang.String r9 = r10.getTitle(r9)
            return r9
        L9e:
            if (r1 == 0) goto La3
            r1.close()
        La3:
            throw r9
        La4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.manager.i.f(android.content.Context, android.net.Uri):java.lang.String");
    }

    public static String g(Context context, String str) {
        if (str == null) {
            return null;
        }
        String f10 = f(context, Uri.parse(str));
        if (TextUtils.isEmpty(f10)) {
            return null;
        }
        String d10 = d(f10);
        f21555e.put(str, d10);
        return d10;
    }

    public static Uri h(Uri uri, Context context) {
        Uri parse;
        String str;
        if (!f21553c) {
            String c10 = c(context);
            if (TextUtils.isEmpty(c10)) {
                parse = null;
            } else {
                parse = Uri.parse(c10);
            }
            if (H7.a.b()) {
                StringBuilder sb = new StringBuilder();
                sb.append("pickUri = ");
                if (uri != null) {
                    str = uri.toString();
                } else {
                    str = null;
                }
                sb.append(str);
                sb.append(", uri = ");
                sb.append(parse);
                H7.b.b("CustomizeRingtoneManager", sb.toString());
            }
            if (uri != null && uri.getPath() != null && parse != null && parse.getPath() != null && (TextUtils.equals(parse.toString(), uri.toString()) || uri.getPath().equals(parse.getPath()))) {
                uri = null;
            }
        }
        if (H7.a.b()) {
            H7.b.b("CustomizeRingtoneManager", "pickUri = " + uri);
        }
        return uri;
    }

    public static void i(Context context) {
        m(C1502e.g(context), C1502e.d(context));
        if (OsUtils.f28279e) {
            if (H7.a.b()) {
                H7.b.b("CustomizeRingtoneManager", "init aquatic ringtone.");
            }
            m(C1502e.e(context), C1502e.b(context));
            m(C1502e.f(context), C1502e.c(context));
        }
    }

    public static boolean j(Uri uri) {
        if (!f21553c) {
            return RingtoneManager.isDefault(uri);
        }
        return false;
    }

    public static boolean k(String str) {
        if (!TextUtils.isEmpty(str)) {
            return TextUtils.isEmpty(Uri.parse(str).getQueryParameter("title"));
        }
        return false;
    }

    public static boolean l(Intent intent) {
        if (intent == null || !intent.getBooleanExtra("isFromOnlineRingtone", false)) {
            return false;
        }
        return true;
    }

    public static void m(String[] strArr, String[] strArr2) {
        if (strArr != null && strArr2 != null) {
            int min = Math.min(strArr.length, strArr2.length);
            for (int i10 = 0; i10 < min; i10++) {
                f21554d.put(strArr[i10], strArr2[i10]);
            }
        }
    }

    public static void n(Intent intent, String str) {
        boolean z10;
        if (str != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (H7.a.b()) {
            H7.b.b("CustomizeRingtoneManager", "needDefaultItem = " + z10);
        }
        if (z10) {
            if (RingtoneManager.isDefault(Uri.parse(str))) {
                intent.putExtra("isHasDefaultItem", false);
            } else {
                intent.putExtra("isHasDefaultItem", true);
            }
        }
    }

    public static boolean o(Context context, long j10, Uri uri) {
        String uri2;
        if (j10 <= 0) {
            H7.b.i("CustomizeRingtoneManager", "getGroupRingtone(), groupId invalidate, = " + j10);
            return false;
        }
        Uri h10 = h(uri, context);
        if (h10 == null) {
            uri2 = null;
        } else {
            uri2 = h10.toString();
        }
        return p(context, j10, uri2);
    }

    public static boolean p(Context context, long j10, String str) {
        if (j10 <= 0) {
            H7.b.i("CustomizeRingtoneManager", "saveGroupRingtone(), groupId invalidate, = " + j10);
            return false;
        }
        ContentValues contentValues = new ContentValues(1);
        contentValues.put(C0814z.a.f22206a, str);
        int g10 = G7.c.g(context.getContentResolver(), R0.d.a(ContactsContract.Groups.CONTENT_URI), contentValues, "deleted=0 AND _id=" + j10, null);
        contentValues.clear();
        if (1 != g10) {
            return false;
        }
        return true;
    }

    public static boolean q(Context context, HashMap<Account, Long> hashMap, Uri uri) {
        String uri2;
        if (hashMap == null || hashMap.isEmpty()) {
            return false;
        }
        Uri h10 = h(uri, context);
        boolean z10 = true;
        for (Map.Entry<Account, Long> entry : hashMap.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                long longValue = entry.getValue().longValue();
                if (h10 == null) {
                    uri2 = null;
                } else {
                    uri2 = h10.toString();
                }
                if (!p(context, longValue, uri2)) {
                    z10 = false;
                }
            }
        }
        return z10;
    }
}
