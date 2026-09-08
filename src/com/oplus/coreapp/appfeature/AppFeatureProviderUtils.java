package com.oplus.coreapp.appfeature;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* loaded from: classes3.dex */
public class AppFeatureProviderUtils {

    /* loaded from: classes3.dex */
    public enum CACHE_MODE {
        CACHE_ONLY,
        CACHE_AND_DB
    }

    /* loaded from: classes3.dex */
    public enum FeatureID {
        STATIC_COMPONENT,
        DYNAMIC_SIMSLOT_1,
        DYNAMIC_SIMSLOT_2
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f28112a;

        static {
            int[] iArr = new int[FeatureID.values().length];
            f28112a = iArr;
            try {
                iArr[FeatureID.STATIC_COMPONENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f28112a[FeatureID.DYNAMIC_SIMSLOT_1.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f28112a[FeatureID.DYNAMIC_SIMSLOT_2.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static Cursor a(ContentResolver contentResolver, FeatureID featureID, String str) {
        Cursor b10 = com.oplus.coreapp.appfeature.a.d().b(featureID, str);
        if (b10 == null && com.oplus.coreapp.appfeature.a.a(featureID) != CACHE_MODE.CACHE_ONLY) {
            return contentResolver.query(n(featureID), null, "featurename=?", new String[]{str}, null);
        }
        return b10;
    }

    public static boolean b(ContentResolver contentResolver, FeatureID featureID, String str, boolean z10) {
        String j10 = j(contentResolver, featureID, str, "boolean");
        if (j10 == null) {
            Log.e("AppFeatureProviderUtils", "getBoolean: getStringForFeature return null");
            return z10;
        }
        return Boolean.parseBoolean(j10);
    }

    public static boolean c(ContentResolver contentResolver, String str, boolean z10) {
        return b(contentResolver, FeatureID.STATIC_COMPONENT, str, z10);
    }

    public static float d(ContentResolver contentResolver, FeatureID featureID, String str, float f10) {
        String j10 = j(contentResolver, featureID, str, "float");
        if (j10 == null) {
            Log.e("AppFeatureProviderUtils", "getFloat: getStringForFeature return null");
            return f10;
        }
        return Float.parseFloat(j10);
    }

    public static float e(ContentResolver contentResolver, String str, float f10) {
        return d(contentResolver, FeatureID.STATIC_COMPONENT, str, f10);
    }

    public static int f(ContentResolver contentResolver, FeatureID featureID, String str, int i10) {
        String j10 = j(contentResolver, featureID, str, "int");
        if (j10 == null) {
            Log.e("AppFeatureProviderUtils", "getInt: getStringForFeature return null");
            return i10;
        }
        return Integer.parseInt(j10);
    }

    public static int g(ContentResolver contentResolver, String str, int i10) {
        return f(contentResolver, FeatureID.STATIC_COMPONENT, str, i10);
    }

    public static String h(ContentResolver contentResolver, FeatureID featureID, String str, String str2) {
        String j10 = j(contentResolver, featureID, str, "String");
        if (j10 == null) {
            Log.e("AppFeatureProviderUtils", "getString: getStringForFeature return null");
            return str2;
        }
        return j10;
    }

    public static String i(ContentResolver contentResolver, String str, String str2) {
        return h(contentResolver, FeatureID.STATIC_COMPONENT, str, str2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0017, code lost:
    
        r7 = r6.getString(r6.getColumnIndexOrThrow("parameters"));
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0021, code lost:
    
        if (r7 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0027, code lost:
    
        if (r7.isEmpty() != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
    
        r7 = r7.split(com.oplus.backup.sdk.common.utils.Constants.DataMigration.SPLIT_TAG);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0030, code lost:
    
        if (r7.length <= 0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0032, code lost:
    
        r8 = r7.length;
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0035, code lost:
    
        if (r2 >= r8) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0037, code lost:
    
        r3 = r7[r2];
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0039, code lost:
    
        if (r3 == null) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003f, code lost:
    
        if (r3.isEmpty() != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0041, code lost:
    
        r4 = r3.indexOf(":");
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0047, code lost:
    
        if (r4 <= 0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0051, code lost:
    
        if (r3.substring(0, r4).equals(r9) == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0053, code lost:
    
        r0 = r3.substring(r4 + 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005e, code lost:
    
        if (r0 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005b, code lost:
    
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0065, code lost:
    
        if (r6.moveToNext() != false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0015, code lost:
    
        if (r6.moveToFirst() != false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String j(android.content.ContentResolver r6, com.oplus.coreapp.appfeature.AppFeatureProviderUtils.FeatureID r7, java.lang.String r8, java.lang.String r9) {
        /*
            r0 = 0
            if (r6 == 0) goto L6c
            boolean r1 = android.text.TextUtils.isEmpty(r8)
            if (r1 != 0) goto L6c
            if (r9 == 0) goto L6c
            android.database.Cursor r6 = a(r6, r7, r8)
            if (r6 == 0) goto L67
            boolean r7 = r6.moveToFirst()
            if (r7 == 0) goto L67
        L17:
            java.lang.String r7 = "parameters"
            int r7 = r6.getColumnIndexOrThrow(r7)
            java.lang.String r7 = r6.getString(r7)
            if (r7 == 0) goto L61
            boolean r8 = r7.isEmpty()
            if (r8 != 0) goto L61
            java.lang.String r8 = ";"
            java.lang.String[] r7 = r7.split(r8)
            int r8 = r7.length
            if (r8 <= 0) goto L61
            int r8 = r7.length
            r1 = 0
            r2 = r1
        L35:
            if (r2 >= r8) goto L5e
            r3 = r7[r2]
            if (r3 == 0) goto L5b
            boolean r4 = r3.isEmpty()
            if (r4 != 0) goto L5b
            java.lang.String r4 = ":"
            int r4 = r3.indexOf(r4)
            if (r4 <= 0) goto L5b
            java.lang.String r5 = r3.substring(r1, r4)
            boolean r5 = r5.equals(r9)
            if (r5 == 0) goto L5b
            int r4 = r4 + 1
            java.lang.String r7 = r3.substring(r4)
            r0 = r7
            goto L5e
        L5b:
            int r2 = r2 + 1
            goto L35
        L5e:
            if (r0 == 0) goto L61
            goto L67
        L61:
            boolean r7 = r6.moveToNext()
            if (r7 != 0) goto L17
        L67:
            if (r6 == 0) goto L6c
            r6.close()
        L6c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.coreapp.appfeature.AppFeatureProviderUtils.j(android.content.ContentResolver, com.oplus.coreapp.appfeature.AppFeatureProviderUtils$FeatureID, java.lang.String, java.lang.String):java.lang.String");
    }

    public static List<String> k(ContentResolver contentResolver, FeatureID featureID, String str) {
        return m(contentResolver, featureID, str);
    }

    public static List<String> l(ContentResolver contentResolver, String str) {
        return k(contentResolver, FeatureID.STATIC_COMPONENT, str);
    }

    public static List<String> m(ContentResolver contentResolver, FeatureID featureID, String str) {
        List<String> arrayList = new ArrayList<>();
        if (contentResolver != null && !TextUtils.isEmpty(str)) {
            Cursor a10 = a(contentResolver, featureID, str);
            if (a10 != null && a10.moveToFirst()) {
                try {
                    arrayList = q(a10.getString(a10.getColumnIndexOrThrow("lists")));
                } catch (Exception e10) {
                    Log.e("AppFeatureProviderUtils", "getStringListForFeature error: " + e10.toString());
                }
            }
            if (a10 != null) {
                a10.close();
            }
        }
        return arrayList;
    }

    public static Uri n(FeatureID featureID) {
        Uri parse = Uri.parse("content://com.oplus.customize.coreapp.configmanager.configprovider.AppFeatureProvider");
        int i10 = a.f28112a[featureID.ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 == 3) {
                    return parse.buildUpon().appendPath("app_feature_second").build();
                }
                throw new IllegalArgumentException("getUriBySimSlot simSlot is not support");
            }
            return parse.buildUpon().appendPath("app_feature_first").build();
        }
        return parse.buildUpon().appendPath("app_feature").build();
    }

    public static boolean o(ContentResolver contentResolver, FeatureID featureID, String str) {
        boolean z10;
        Cursor a10 = a(contentResolver, featureID, str);
        if (a10 != null && a10.getCount() > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (a10 != null) {
            a10.close();
        }
        return z10;
    }

    public static boolean p(ContentResolver contentResolver, String str) {
        return o(contentResolver, FeatureID.STATIC_COMPONENT, str);
    }

    public static List<String> q(String str) {
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = new JSONArray(str);
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            arrayList.add(jSONArray.getString(i10));
        }
        return arrayList;
    }

    public static void r(ContentResolver contentResolver, FeatureID featureID, boolean z10, ContentObserver contentObserver) {
        Uri n10 = n(featureID);
        if (contentResolver != null && contentObserver != null) {
            contentResolver.registerContentObserver(n10, z10, contentObserver);
        }
    }

    public static void s(ContentResolver contentResolver, boolean z10, ContentObserver contentObserver) {
        r(contentResolver, FeatureID.STATIC_COMPONENT, z10, contentObserver);
    }
}
