package com.customize.contacts.util;

import android.content.ComponentName;
import android.content.ContentProviderOperation;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.net.Uri;
import android.text.TextUtils;
import android.util.ArraySet;
import com.android.incallui.OplusNumberMarkUtils;
import com.customize.contacts.FeatureOption;
import com.oplus.foundation.util.systemcore.PrimaryUserUtils;
import h1.C1074c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.C1241e0;
import kotlinx.coroutines.C1248i;
import r0.C1498a;
import v9.InterfaceC1637a;

/* compiled from: BlackListUtils.kt */
/* loaded from: classes3.dex */
public final class BlackListUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final BlackListUtils f21862a = new BlackListUtils();

    /* renamed from: b, reason: collision with root package name */
    public static final m9.d f21863b;

    static {
        m9.d b10;
        b10 = kotlin.a.b(new InterfaceC1637a<Boolean>() { // from class: com.customize.contacts.util.BlackListUtils$blockSpecialNameNumberSupported$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                boolean i10;
                i10 = BlackListUtils.i();
                return Boolean.valueOf(i10);
            }
        });
        f21863b = b10;
    }

    public static final String c(Context context, ArrayList<String> arrayList) {
        String str;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        int size = arrayList.size();
        StringBuilder sb = new StringBuilder();
        if (size <= 0 || (str = arrayList.get(0)) == null) {
            return null;
        }
        String c10 = C1074c.c(context, str, null, null);
        kotlin.jvm.internal.i.e(c10, "getE164Number(context, number, null, null)");
        if (!TextUtils.isEmpty(c10)) {
            sb.append("e164_number");
            sb.append(" = ");
            DatabaseUtils.appendEscapedSQLString(sb, c10);
        } else {
            sb.append("number = ");
            DatabaseUtils.appendEscapedSQLString(sb, str);
        }
        if (size > 1) {
            for (int i10 = 1; i10 < size; i10++) {
                String str2 = arrayList.get(i10);
                if (str2 == null) {
                    return null;
                }
                String c11 = C1074c.c(context, str2, null, null);
                kotlin.jvm.internal.i.e(c11, "getE164Number(context, number, null, null)");
                if (!TextUtils.isEmpty(c11)) {
                    sb.append(" OR ");
                    sb.append("e164_number");
                    sb.append(" = ");
                    DatabaseUtils.appendEscapedSQLString(sb, c11);
                } else {
                    sb.append(" OR ");
                    sb.append("number = ");
                    DatabaseUtils.appendEscapedSQLString(sb, str2);
                }
            }
        }
        return "(" + ((Object) sb) + ")";
    }

    public static final HashMap<String, Boolean> d(Context context, ArrayList<String> numbers) {
        String str;
        Object b10;
        kotlin.jvm.internal.i.f(numbers, "numbers");
        if (context == null) {
            context = P7.a.f2961a.a();
        }
        HashMap<String, Boolean> hashMap = new HashMap<>();
        Boolean bool = Boolean.FALSE;
        hashMap.put("isBlackList", bool);
        hashMap.put("isWhiteList", bool);
        try {
            str = c(context, numbers);
        } catch (Exception e10) {
            H7.b.c("BlackListUtils", "Exception e: " + e10);
            str = null;
        }
        if (str != null) {
            try {
                Result.a aVar = Result.f34166a;
                Cursor query = context.getContentResolver().query(R0.d.f3220g, new String[]{OplusNumberMarkUtils.OplusBlacklist.LIST_TYPE}, str, null, null);
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            while (!query.isAfterLast()) {
                                int i10 = query.getInt(0);
                                if (1 == i10) {
                                    hashMap.put("isBlackList", Boolean.TRUE);
                                } else if (2 == i10) {
                                    hashMap.put("isWhiteList", Boolean.TRUE);
                                }
                                query.moveToNext();
                            }
                        }
                    } finally {
                    }
                }
                m9.q qVar = m9.q.f35511a;
                kotlin.io.a.a(query, null);
                b10 = Result.b(m9.q.f35511a);
            } catch (Throwable th) {
                Result.a aVar2 = Result.f34166a;
                b10 = Result.b(kotlin.b.a(th));
            }
            Throwable d10 = Result.d(b10);
            if (d10 != null) {
                H7.b.c("BlackListUtils", "Exception e: " + d10);
            }
        }
        return hashMap;
    }

    public static final Intent e(ArrayList<String> arrayList, boolean z10) {
        Intent intent = new Intent(C1498a.f36249h);
        intent.putStringArrayListExtra("number_list", arrayList);
        intent.putExtra("is_insert_blacklist", z10);
        if (!z10) {
            intent.putExtra("need_restore_intercept_record", true);
        }
        return intent;
    }

    public static final List<ComponentName> g(Context context, String intentAction) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(intentAction, "intentAction");
        Intent intent = new Intent(intentAction);
        ArrayList arrayList = new ArrayList();
        Iterator<ResolveInfo> it = context.getPackageManager().queryBroadcastReceivers(intent, 0).iterator();
        while (it.hasNext()) {
            ActivityInfo activityInfo = it.next().activityInfo;
            arrayList.add(new ComponentName(activityInfo.packageName, activityInfo.name));
        }
        return arrayList;
    }

    public static final boolean i() {
        if (!FeatureOption.i()) {
            H7.b.e("BlackListUtils", "VERSION_EXP not support Block Special Name Number");
            return false;
        }
        String[] strArr = {"com.oplus.blacklistapp", "com.android.phone"};
        for (int i10 = 0; i10 < 2; i10++) {
            String str = strArr[i10];
            if (!M7.a.h(P7.a.f2961a.a(), str, "block_special_name", "true")) {
                H7.b.e("BlackListUtils", str + "not support high risk number");
                return false;
            }
        }
        return true;
    }

    public static final boolean j(Context context, String str) {
        String str2;
        int count;
        boolean z10;
        if (context == null) {
            context = P7.a.f2961a.a();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str != null) {
            str2 = kotlin.text.n.t(str, " ", "", false, 4, null);
        } else {
            str2 = null;
        }
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        Uri withAppendedPath = Uri.withAppendedPath(R0.d.f3222i, str2);
        try {
            Result.a aVar = Result.f34166a;
            Cursor query = context.getContentResolver().query(withAppendedPath, null, "list_type=?", new String[]{"2"}, null);
            if (query != null) {
                try {
                    count = query.getCount();
                } finally {
                }
            } else {
                count = 0;
            }
            H7.b.e("BlackListUtils", "isInWhiteListOrNot : count = " + count);
            if (count > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            kotlin.io.a.a(query, null);
            return z10;
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            Throwable d10 = Result.d(Result.b(kotlin.b.a(th)));
            if (d10 != null) {
                H7.b.c("BlackListUtils", "Exception:" + d10);
            }
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0041 A[Catch: all -> 0x003c, TryCatch #0 {all -> 0x003c, blocks: (B:10:0x0015, B:12:0x001d, B:16:0x0041, B:17:0x0044), top: B:9:0x0015 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean k(android.content.Context r7, java.util.ArrayList<java.lang.String> r8) {
        /*
            java.lang.String r0 = "BlackListUtils"
            r1 = 0
            if (r7 != 0) goto L6
            return r1
        L6:
            if (r8 == 0) goto L7d
            boolean r2 = r8.isEmpty()
            if (r2 == 0) goto Lf
            goto L7d
        Lf:
            java.lang.String r2 = "1"
            java.lang.String[] r2 = new java.lang.String[]{r2}
            kotlin.Result$a r3 = kotlin.Result.f34166a     // Catch: java.lang.Throwable -> L3c
            java.lang.String r3 = c(r7, r8)     // Catch: java.lang.Throwable -> L3c
            if (r3 == 0) goto L3e
            android.content.ContentResolver r4 = r7.getContentResolver()     // Catch: java.lang.Throwable -> L3c
            android.net.Uri r5 = R0.d.f3220g     // Catch: java.lang.Throwable -> L3c
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3c
            r6.<init>()     // Catch: java.lang.Throwable -> L3c
            r6.append(r3)     // Catch: java.lang.Throwable -> L3c
            java.lang.String r3 = " AND list_type = ? "
            r6.append(r3)     // Catch: java.lang.Throwable -> L3c
            java.lang.String r3 = r6.toString()     // Catch: java.lang.Throwable -> L3c
            int r2 = G7.c.c(r4, r5, r3, r2)     // Catch: java.lang.Throwable -> L3c
            r3 = 1
            if (r2 < r3) goto L3e
            goto L3f
        L3c:
            r7 = move-exception
            goto L59
        L3e:
            r3 = r1
        L3f:
            if (r3 == 0) goto L44
            n(r7, r8, r1)     // Catch: java.lang.Throwable -> L3c
        L44:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3c
            r7.<init>()     // Catch: java.lang.Throwable -> L3c
            java.lang.String r8 = "removeBlacklist success:"
            r7.append(r8)     // Catch: java.lang.Throwable -> L3c
            r7.append(r3)     // Catch: java.lang.Throwable -> L3c
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L3c
            H7.b.e(r0, r7)     // Catch: java.lang.Throwable -> L3c
            return r3
        L59:
            kotlin.Result$a r8 = kotlin.Result.f34166a
            java.lang.Object r7 = kotlin.b.a(r7)
            java.lang.Object r7 = kotlin.Result.b(r7)
            java.lang.Throwable r7 = kotlin.Result.d(r7)
            if (r7 == 0) goto L7d
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r2 = "removeBlacklist error:"
            r8.append(r2)
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            H7.b.c(r0, r7)
        L7d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.util.BlackListUtils.k(android.content.Context, java.util.ArrayList):boolean");
    }

    public static final boolean l(Context context, ArraySet<String> arraySet) {
        if (context == null || arraySet == null || arraySet.isEmpty()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = arraySet.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!TextUtils.isEmpty(next)) {
                arrayList.add(next);
            }
        }
        return k(context, arrayList);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0041 A[Catch: all -> 0x003c, TryCatch #0 {all -> 0x003c, blocks: (B:10:0x0015, B:12:0x001d, B:16:0x0041, B:17:0x0044), top: B:9:0x0015 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean m(android.content.Context r7, java.util.ArrayList<java.lang.String> r8) {
        /*
            java.lang.String r0 = "BlackListUtils"
            r1 = 0
            if (r7 != 0) goto L6
            return r1
        L6:
            if (r8 == 0) goto L7d
            boolean r2 = r8.isEmpty()
            if (r2 == 0) goto Lf
            goto L7d
        Lf:
            java.lang.String r2 = "2"
            java.lang.String[] r2 = new java.lang.String[]{r2}
            kotlin.Result$a r3 = kotlin.Result.f34166a     // Catch: java.lang.Throwable -> L3c
            java.lang.String r3 = c(r7, r8)     // Catch: java.lang.Throwable -> L3c
            if (r3 == 0) goto L3e
            android.content.ContentResolver r4 = r7.getContentResolver()     // Catch: java.lang.Throwable -> L3c
            android.net.Uri r5 = R0.d.f3220g     // Catch: java.lang.Throwable -> L3c
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3c
            r6.<init>()     // Catch: java.lang.Throwable -> L3c
            r6.append(r3)     // Catch: java.lang.Throwable -> L3c
            java.lang.String r3 = " AND list_type = ? "
            r6.append(r3)     // Catch: java.lang.Throwable -> L3c
            java.lang.String r3 = r6.toString()     // Catch: java.lang.Throwable -> L3c
            int r2 = G7.c.c(r4, r5, r3, r2)     // Catch: java.lang.Throwable -> L3c
            r3 = 1
            if (r2 < r3) goto L3e
            goto L3f
        L3c:
            r7 = move-exception
            goto L59
        L3e:
            r3 = r1
        L3f:
            if (r3 == 0) goto L44
            n(r7, r8, r1)     // Catch: java.lang.Throwable -> L3c
        L44:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3c
            r7.<init>()     // Catch: java.lang.Throwable -> L3c
            java.lang.String r8 = "removeWhitelist success: "
            r7.append(r8)     // Catch: java.lang.Throwable -> L3c
            r7.append(r3)     // Catch: java.lang.Throwable -> L3c
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L3c
            H7.b.e(r0, r7)     // Catch: java.lang.Throwable -> L3c
            return r3
        L59:
            kotlin.Result$a r8 = kotlin.Result.f34166a
            java.lang.Object r7 = kotlin.b.a(r7)
            java.lang.Object r7 = kotlin.Result.b(r7)
            java.lang.Throwable r7 = kotlin.Result.d(r7)
            if (r7 == 0) goto L7d
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r2 = "removeWhitelist error:"
            r8.append(r2)
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            H7.b.c(r0, r7)
        L7d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.util.BlackListUtils.m(android.content.Context, java.util.ArrayList):boolean");
    }

    public static final void n(Context context, ArrayList<String> phoneList, boolean z10) {
        kotlin.jvm.internal.i.f(phoneList, "phoneList");
        if (context == null || phoneList.isEmpty()) {
            return;
        }
        for (ComponentName componentName : g(context, C1498a.f36249h)) {
            Intent e10 = e(phoneList, z10);
            e10.setComponent(componentName);
            if (H7.a.b()) {
                H7.b.b("BlackListUtils", "componentName = " + componentName);
            }
            context.sendBroadcast(e10, R0.b.f3175i);
        }
        context.sendBroadcast(e(phoneList, z10), R0.b.f3175i);
    }

    public static final void o(Context context, long j10, ArrayList<String> arrayList, boolean z10, boolean z11, boolean z12) {
        if (context == null) {
            return;
        }
        Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        Ref$BooleanRef ref$BooleanRef2 = new Ref$BooleanRef();
        Intent intent = new Intent("com.oplus.contacts.DETAIL_UPDATE_DONE");
        C1248i.d(C1241e0.f34422a, kotlinx.coroutines.S.b(), null, new BlackListUtils$setBlackList$1(z10, arrayList, j10, context, new Ref$BooleanRef(), intent, ref$BooleanRef, ref$BooleanRef2, z12, z11, null), 2, null);
    }

    public static final void p(Context context, long j10, ArrayList<String> arrayList, boolean z10, boolean z11) {
        if (context == null) {
            return;
        }
        C1248i.d(C1241e0.f34422a, kotlinx.coroutines.S.b(), null, new BlackListUtils$setWhiteList$1(z10, arrayList, new Ref$BooleanRef(), context, j10, new Ref$BooleanRef(), new Intent("com.oplus.contacts.DETAIL_UPDATE_DONE"), z11, null), 2, null);
    }

    public static final boolean q() {
        BlackListUtils blackListUtils = f21862a;
        H7.b.e("BlackListUtils", "blockSpecialNameNumberSupported :" + blackListUtils.f());
        if (!b0.l0(P7.a.f2961a.a()) || !PrimaryUserUtils.a() || !blackListUtils.f()) {
            return false;
        }
        return true;
    }

    public final boolean f() {
        return ((Boolean) f21863b.getValue()).booleanValue();
    }

    public final boolean h(Context context, long j10, ArrayList<String> arrayList, int i10) {
        Object b10;
        String str;
        CharSequence j02;
        if (arrayList == null || arrayList.isEmpty()) {
            return false;
        }
        ArrayList<ContentProviderOperation> arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(R0.d.f3220g);
            kotlin.jvm.internal.i.e(newInsert, "newInsert(ContactsUris.BLACKLIST_CONTENT_URI)");
            String str2 = arrayList.get(i11);
            if (!TextUtils.isEmpty(str2)) {
                if (str2 != null) {
                    j02 = StringsKt__StringsKt.j0(str2);
                    str = j02.toString();
                } else {
                    str = null;
                }
                if (!TextUtils.isEmpty(str)) {
                    ContentValues contentValues = new ContentValues(4);
                    contentValues.put(OplusNumberMarkUtils.OplusBlacklist.CONTACTID, Long.valueOf(j10));
                    contentValues.put("number", arrayList.get(i11));
                    if (i10 == 1) {
                        contentValues.put(OplusNumberMarkUtils.OplusBlacklist.BLOCK_TYPE, (Integer) 3);
                    } else {
                        contentValues.put(OplusNumberMarkUtils.OplusBlacklist.BLOCK_TYPE, (Integer) 0);
                    }
                    contentValues.put(OplusNumberMarkUtils.OplusBlacklist.LIST_TYPE, Integer.valueOf(i10));
                    newInsert.withValues(contentValues);
                    arrayList2.add(newInsert.build());
                    if (H7.a.b()) {
                        H7.b.b("BlackListUtils", "contactId = " + j10 + ",  phoneList.get(i) = " + H7.a.d(arrayList.get(i11)));
                    }
                }
            }
        }
        try {
            Result.a aVar = Result.f34166a;
            b10 = Result.b(context.getContentResolver().applyBatch(R0.d.f3218e, arrayList2));
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 == null) {
            return true;
        }
        H7.b.c("BlackListUtils", "Exception e: " + d10);
        return false;
    }
}
