package com.oplus.blacklist.database;

import F6.d;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.provider.BlockedNumberContract;
import android.text.TextUtils;
import android.util.Log;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.incallui.OplusNumberMarkUtils;
import com.android.incallui.OplusPhoneUtils;
import com.coui.appcompat.hapticfeedback.COUIHapticFeedbackConstants;
import com.oplus.backup.sdk.common.utils.Constants;
import com.oplus.media.OplusRecorder;
import com.oplus.utils.C0844e;
import com.oplus.utils.C0846g;
import com.oplus.utils.C0848i;
import com.oplus.utils.StatisticsUtils;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import v6.C1629c;

/* loaded from: classes3.dex */
public class BlackListProvider extends SQLiteContentProvider {

    /* renamed from: n, reason: collision with root package name */
    public static final String[] f26213n = {BreenoCallContract.BaseColumns._ID, "equal_id"};

    /* renamed from: o, reason: collision with root package name */
    public static final UriMatcher f26214o;

    /* renamed from: p, reason: collision with root package name */
    public static final HashMap<String, String> f26215p;

    /* renamed from: f, reason: collision with root package name */
    public Executor f26217f;

    /* renamed from: g, reason: collision with root package name */
    public HashMap<Long, ArrayList<Long>> f26218g;

    /* renamed from: h, reason: collision with root package name */
    public Context f26219h;

    /* renamed from: j, reason: collision with root package name */
    public String f26221j;

    /* renamed from: e, reason: collision with root package name */
    public final Uri f26216e = Uri.parse("content://" + C1629c.f37421g + "/province_and_city/").buildUpon().appendQueryParameter("query_all_data", "true").build();

    /* renamed from: i, reason: collision with root package name */
    public ContentResolver f26220i = null;

    /* renamed from: k, reason: collision with root package name */
    public volatile boolean f26222k = false;

    /* renamed from: l, reason: collision with root package name */
    public c f26223l = null;

    /* renamed from: m, reason: collision with root package name */
    public final Object f26224m = new Object();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BlackListProvider.this.C("call update_area_list_method");
            BlackListProvider blackListProvider = BlackListProvider.this;
            blackListProvider.K(blackListProvider.f26228a.getWritableDatabase());
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static final String[] f26226a = {OplusPhoneUtils.DeviceState.INVALID_STATUS, "-2", "-3", "-4"};
    }

    /* loaded from: classes3.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public Object f26227a;
    }

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f26214o = uriMatcher;
        String str = com.oplus.blacklist.database.a.f26232a;
        uriMatcher.addURI(str, OplusNumberMarkUtils.OplusBlacklist.BLACKLIST_TABLE, 300);
        uriMatcher.addURI(str, "bl_list/#", COUIHapticFeedbackConstants.STEPPING_SHORT_VIBRATE);
        uriMatcher.addURI(str, "bl_list/prefixblacknumber", 613);
        uriMatcher.addURI(str, "bl_list/prefixblacknumber/#", 614);
        uriMatcher.addURI(str, "bl_list/sms_and_call_block/*", COUIHapticFeedbackConstants.KEYBOARD_TOUCH_FEEDBACK);
        uriMatcher.addURI(str, "bl_list/black_or_area/*", 603);
        uriMatcher.addURI(str, "bl_list/list_type_white", COUIHapticFeedbackConstants.GRANULAR_SHORT_VIBRATE);
        uriMatcher.addURI(str, "bl_list/number/*", COUIHapticFeedbackConstants.SHORT_VIBRATE);
        uriMatcher.addURI(str, "bl_list/defaultnumber/*", 304);
        uriMatcher.addURI(str, "bl_list/*", 311);
        uriMatcher.addURI(str, "query_blacklist_as_selection", 314);
        uriMatcher.addURI(str, "query_whitelist_as_selection", 607);
        uriMatcher.addURI(str, "kw_list", 601);
        uriMatcher.addURI(str, "area_list", 602);
        uriMatcher.addURI(str, "bl_area_for_country", 612);
        uriMatcher.addURI(str, "call_record_custom_list", 604);
        uriMatcher.addURI(str, "call_record_custom_list/number/*", 605);
        uriMatcher.addURI(str, "pseudo_base_station", 606);
        uriMatcher.addURI(str, "romupdate_bl_list", 609);
        uriMatcher.addURI(str, "romupdate_kw_list", 611);
        uriMatcher.addURI(str, "call_filter", 615);
        uriMatcher.addURI(str, "bl_list_delete", OplusRecorder.NAMR_BYTES_P_SEC);
        uriMatcher.addURI(str, "kw_list_delete", 701);
        uriMatcher.addURI(str, "area_list_delete", 702);
        d.a(uriMatcher);
        HashMap<String, String> hashMap = new HashMap<>();
        f26215p = hashMap;
        hashMap.put(BreenoCallContract.BaseColumns._ID, BreenoCallContract.BaseColumns._ID);
        hashMap.put("name", "name");
        hashMap.put("number", "number");
        hashMap.put("reverse_number", "reverse_number");
        hashMap.put("photo_id", "photo_id");
        hashMap.put(OplusNumberMarkUtils.OplusBlacklist.CONTACTID, OplusNumberMarkUtils.OplusBlacklist.CONTACTID);
    }

    public static String q(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("(SELECT * FROM bl_list WHERE ");
        if (!TextUtils.isEmpty(str2)) {
            sb.append("e164_number = ");
            DatabaseUtils.appendEscapedSQLString(sb, str2);
        } else {
            sb.append("number = ");
            DatabaseUtils.appendEscapedSQLString(sb, str);
        }
        sb.append(" AND (list_type = 1");
        sb.append(" OR list_type = 2");
        sb.append("))");
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x020a, code lost:
    
        if (r5.equals(r10) != false) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01a6, code lost:
    
        if (r5.equals(r13) != false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01cc, code lost:
    
        I9.a.a(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x01d0, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x01b2, code lost:
    
        if (r5.equals(r14) != false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01be, code lost:
    
        if (r5.equals(r10) != false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01ca, code lost:
    
        if (r5.equals(r11) != false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01e5, code lost:
    
        if (r5.equals(r14) != false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01f1, code lost:
    
        if (r5.equals(r11) != false) goto L64;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean v(android.content.Context r18, android.database.sqlite.SQLiteDatabase r19, java.lang.String r20, int r21) {
        /*
            Method dump skipped, instructions count: 704
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.blacklist.database.BlackListProvider.v(android.content.Context, android.database.sqlite.SQLiteDatabase, java.lang.String, int):boolean");
    }

    public static boolean w(Context context, SQLiteDatabase sQLiteDatabase, String str, int i10) {
        Cursor cursor;
        Cursor rawQuery;
        boolean z10 = false;
        Cursor cursor2 = null;
        try {
            String a10 = I6.a.b(context).a();
            Uri parse = Uri.parse("content://" + C1629c.f37421g + "/phoneno/" + str);
            if (!TextUtils.isEmpty(a10)) {
                parse = parse.buildUpon().appendQueryParameter("countryiso", a10).build();
            }
            Cursor query = context.getContentResolver().query(parse, null, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        String string = query.getString(query.getColumnIndex("areano"));
                        query.getString(query.getColumnIndex("cityname"));
                        long j10 = query.getLong(query.getColumnIndex(BreenoCallContract.BaseColumns._ID));
                        if (string != null) {
                            if (!string.equals(OplusPhoneUtils.DeviceState.INVALID_STATUS)) {
                                if (!string.equals("-2")) {
                                    if (!string.equals("-3")) {
                                        if (string.equals("-4")) {
                                        }
                                    }
                                }
                            }
                            j10 = Long.parseLong(string);
                        }
                        int columnIndex = query.getColumnIndex("equal_id");
                        if (columnIndex > 0) {
                            j10 = query.getLong(columnIndex);
                        }
                        C0846g.i("BlackListProvider", "getPhoneLocationIfShouldBlock id " + j10);
                        if (i10 != -1) {
                            rawQuery = sQLiteDatabase.rawQuery("SELECT _id FROM area_list WHERE (area_id ='" + j10 + "' OR equal_id ='" + j10 + "') AND slot_id ='" + i10 + "'", null);
                        } else {
                            rawQuery = sQLiteDatabase.rawQuery("SELECT _id FROM area_list WHERE area_id ='" + j10 + "' OR equal_id ='" + j10 + "'", null);
                        }
                        cursor2 = rawQuery;
                        if (cursor2.getCount() > 0) {
                            z10 = true;
                        }
                    }
                } catch (Exception e10) {
                    Cursor cursor3 = cursor2;
                    cursor2 = query;
                    e = e10;
                    cursor = cursor3;
                    try {
                        Log.e("BlackListProvider", "query location Exception: " + e);
                        I9.a.a(cursor2);
                        I9.a.a(cursor);
                        C0846g.i("BlackListProvider", "shouldBlock = " + z10);
                        return z10;
                    } catch (Throwable th) {
                        th = th;
                        I9.a.a(cursor2);
                        I9.a.a(cursor);
                        throw th;
                    }
                } catch (Throwable th2) {
                    Cursor cursor4 = cursor2;
                    cursor2 = query;
                    th = th2;
                    cursor = cursor4;
                    I9.a.a(cursor2);
                    I9.a.a(cursor);
                    throw th;
                }
            }
            I9.a.a(query);
            I9.a.a(cursor2);
        } catch (Exception e11) {
            e = e11;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
        C0846g.i("BlackListProvider", "shouldBlock = " + z10);
        return z10;
    }

    public Uri A(SQLiteDatabase sQLiteDatabase, String str, Uri uri, ContentValues contentValues) {
        String asString = contentValues.getAsString("number");
        String f10 = C0848i.f(getContext(), asString, null, null);
        if (TextUtils.isEmpty(asString)) {
            return null;
        }
        C("insert : e164_number is " + C0846g.f(f10));
        contentValues.put("e164_number", f10);
        contentValues.put("number", asString);
        sQLiteDatabase.delete("call_record_custom_list", "number=? AND e164_number=?", new String[]{asString, f10});
        long insert = sQLiteDatabase.insert(str, null, contentValues);
        C("insert: table = " + str + ", iResult = " + insert);
        if (insert == -1) {
            if (!TextUtils.isEmpty(f10)) {
                insert = sQLiteDatabase.update(str, contentValues, "e164_number = '" + f10 + "'", null);
                if (insert == -1) {
                    C("update values failure!");
                    return null;
                }
                C("update values success!");
            } else {
                C("insert values failure!");
                return null;
            }
        }
        return ContentUris.withAppendedId(uri, insert);
    }

    public final boolean B(String str) {
        if (str == null) {
            return false;
        }
        return str.contains("list_type = '2'");
    }

    public final void C(String str) {
        if (C0846g.c()) {
            Log.d("BlackListProvider", "info:" + str);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0291 A[Catch: all -> 0x011f, Exception -> 0x0122, TRY_LEAVE, TryCatch #2 {Exception -> 0x0122, blocks: (B:21:0x00de, B:23:0x00e4, B:24:0x00f1, B:26:0x00f7, B:40:0x028b, B:42:0x0291, B:46:0x014e, B:47:0x01b2, B:49:0x020a, B:50:0x0117, B:53:0x0125, B:56:0x012d), top: B:20:0x00de }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0294 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x020a A[Catch: all -> 0x011f, Exception -> 0x0122, TryCatch #2 {Exception -> 0x0122, blocks: (B:21:0x00de, B:23:0x00e4, B:24:0x00f1, B:26:0x00f7, B:40:0x028b, B:42:0x0291, B:46:0x014e, B:47:0x01b2, B:49:0x020a, B:50:0x0117, B:53:0x0125, B:56:0x012d), top: B:20:0x00de }] */
    /* JADX WARN: Type inference failed for: r3v15, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r8v12, types: [java.lang.String[], java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v23 */
    /* JADX WARN: Type inference failed for: r8v25 */
    /* JADX WARN: Type inference failed for: r8v26 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void D(android.database.sqlite.SQLiteDatabase r32, java.lang.String r33, java.lang.String r34, java.lang.String[] r35) {
        /*
            Method dump skipped, instructions count: 736
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.blacklist.database.BlackListProvider.D(android.database.sqlite.SQLiteDatabase, java.lang.String, java.lang.String, java.lang.String[]):void");
    }

    public final int E(SQLiteDatabase sQLiteDatabase, String str, String str2, String[] strArr) {
        D(sQLiteDatabase, str, str2, strArr);
        return sQLiteDatabase.delete(str, str2, strArr);
    }

    public final void F() {
        com.oplus.blacklistapp.framework.api.sync.a.a();
        C("notify to sync");
    }

    public final Cursor G(SQLiteDatabase sQLiteDatabase, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        String str3;
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables(y(uri));
        sQLiteQueryBuilder.setProjectionMap(f26215p);
        sQLiteQueryBuilder.setStrict(true);
        if (f26214o.match(uri) == 605) {
            C("CODE_CALL_RECORD_CUSTOM_NUMBER uri = " + C0846g.h(uri));
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments.size() > 2) {
                str3 = pathSegments.get(2);
            } else {
                str3 = null;
            }
            C("CODE_CALL_RECORD_CUSTOM_NUMBER phoneNumber = " + C0846g.f(str3));
            if (!TextUtils.isEmpty(str3)) {
                String f10 = C0848i.f(getContext(), str3, null, null);
                C("getSmsWhiteListTableNumberLookUp : e164_number is " + C0846g.f(f10));
                if (!TextUtils.isEmpty(f10)) {
                    sQLiteQueryBuilder.appendWhere("e164_number = ");
                    sQLiteQueryBuilder.appendWhereEscapeString(f10);
                } else {
                    sQLiteQueryBuilder.appendWhere("number = ");
                    sQLiteQueryBuilder.appendWhereEscapeString(str3);
                }
            }
        }
        Cursor query = sQLiteQueryBuilder.query(sQLiteDatabase, strArr, str, strArr2, null, null, str2, null);
        if (query != null) {
            query.setNotificationUri(this.f26220i, uri);
        }
        return query;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:15:0x0090. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:16:0x0093. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0324 A[Catch: all -> 0x02f3, TryCatch #2 {all -> 0x02f3, blocks: (B:81:0x02dd, B:83:0x02e3, B:85:0x02e9, B:90:0x02f7, B:92:0x02fc, B:94:0x0300, B:96:0x0313, B:97:0x0309, B:100:0x0324, B:102:0x0330, B:103:0x0342), top: B:80:0x02dd }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x02e3 A[Catch: all -> 0x02f3, TryCatch #2 {all -> 0x02f3, blocks: (B:81:0x02dd, B:83:0x02e3, B:85:0x02e9, B:90:0x02f7, B:92:0x02fc, B:94:0x0300, B:96:0x0313, B:97:0x0309, B:100:0x0324, B:102:0x0330, B:103:0x0342), top: B:80:0x02dd }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.database.Cursor H(android.net.Uri r22, java.lang.String[] r23, java.lang.String r24, java.lang.String[] r25, java.lang.String r26) {
        /*
            Method dump skipped, instructions count: 1876
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.blacklist.database.BlackListProvider.H(android.net.Uri, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String):android.database.Cursor");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x009a, code lost:
    
        if (r12.moveToFirst() != false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x009c, code lost:
    
        r14 = r12.getString(0);
        r2 = com.oplus.utils.C0848i.t(r14, I6.a.b(r10.f26219h).a());
        C("number  = " + com.oplus.utils.C0846g.f(r11) + "numberFromDB  = " + com.oplus.utils.C0846g.f(r14));
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x00d6, code lost:
    
        if (r11.startsWith(r14) != false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00dc, code lost:
    
        if (r1.startsWith(r14) != false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00e2, code lost:
    
        if (r11.startsWith(r2) != false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00e8, code lost:
    
        if (r1.startsWith(r2) != false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00ff, code lost:
    
        if (("+" + r13).equals(r14) != false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0116, code lost:
    
        if (("00" + r13).equals(r14) == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x012b, code lost:
    
        if (r12.moveToNext() != false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x011b, code lost:
    
        r0.addRow(new java.lang.String[]{java.lang.String.valueOf(1), null});
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.database.MatrixCursor I(java.lang.String r11, android.database.sqlite.SQLiteDatabase r12, boolean r13, boolean r14) {
        /*
            Method dump skipped, instructions count: 334
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.blacklist.database.BlackListProvider.I(java.lang.String, android.database.sqlite.SQLiteDatabase, boolean, boolean):android.database.MatrixCursor");
    }

    public final Cursor J(SQLiteDatabase sQLiteDatabase, Uri uri, String str) {
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables(OplusNumberMarkUtils.OplusBlacklist.BLACKLIST_TABLE);
        Cursor rawQuery = sQLiteDatabase.rawQuery(sQLiteQueryBuilder.buildUnionQuery(new String[]{sQLiteQueryBuilder.buildQuery(null, "contactID = -1 AND list_type = 2", null, null, null, null), sQLiteQueryBuilder.buildQuery(null, "contactID <> -1 AND list_type = 2", OplusNumberMarkUtils.OplusBlacklist.CONTACTID, null, null, null)}, str, null), null);
        if (rawQuery != null) {
            rawQuery.setNotificationUri(getContext().getContentResolver(), uri);
        }
        if (rawQuery != null) {
            C("smsWhiteListMergeQuery cursor.getCount()" + rawQuery.getCount());
        }
        return rawQuery;
    }

    public final void K(SQLiteDatabase sQLiteDatabase) {
        Cursor query;
        int i10;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        Cursor cursor = null;
        try {
            try {
                query = getContext().getContentResolver().query(this.f26216e, f26213n, null, null, null);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e10) {
            e = e10;
        }
        if (query == null) {
            I9.a.a(query);
            return;
        }
        while (true) {
            try {
                i10 = 0;
                if (!query.moveToNext()) {
                    break;
                }
                long j10 = query.getLong(1);
                if (j10 != 0) {
                    long j11 = query.getLong(0);
                    hashMap2.put(Long.valueOf(j11), Long.valueOf(j10));
                    if (hashMap.containsKey(Long.valueOf(j10))) {
                        ((ArrayList) hashMap.get(Long.valueOf(j10))).add(Long.valueOf(j11));
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(Long.valueOf(j11));
                        hashMap.put(Long.valueOf(j10), arrayList);
                    }
                }
            } catch (Exception e11) {
                e = e11;
                cursor = query;
                Log.e("BlackListProvider", "updateArealistTable error " + e);
                I9.a.a(cursor);
            } catch (Throwable th2) {
                th = th2;
                cursor = query;
                I9.a.a(cursor);
                throw th;
            }
        }
        I9.a.a(query);
        cursor = sQLiteDatabase.rawQuery("SELECT area_id FROM area_list", null);
        if (cursor != null) {
            long currentTimeMillis = System.currentTimeMillis();
            while (cursor.moveToNext()) {
                long j12 = cursor.getLong(i10);
                if (hashMap2.containsKey(Long.valueOf(j12))) {
                    sQLiteDatabase.execSQL("UPDATE area_list SET area_id = " + hashMap2.get(Long.valueOf(j12)) + ",sync_state = 1,time_stamp = " + currentTimeMillis + " WHERE area_id = " + j12 + Constants.DataMigration.SPLIT_TAG);
                }
                if (hashMap.containsKey(Long.valueOf(j12))) {
                    Iterator it = ((ArrayList) hashMap.get(Long.valueOf(j12))).iterator();
                    while (it.hasNext()) {
                        sQLiteDatabase.execSQL("INSERT OR REPLACE INTO area_list(area_id,equal_id,time_stamp) values (" + ((Long) it.next()).longValue() + "," + j12 + "," + currentTimeMillis + ");");
                    }
                }
                i10 = 0;
            }
        }
        hashMap.clear();
        hashMap2.clear();
        I9.a.a(cursor);
    }

    @Override // com.oplus.blacklist.database.SQLiteContentProvider
    public int c(Uri uri, String str, String[] strArr) {
        String str2;
        String str3;
        Cursor cursor;
        String str4;
        String str5;
        String str6 = str;
        String[] strArr2 = strArr;
        SQLiteDatabase writableDatabase = this.f26228a.getWritableDatabase();
        int match = f26214o.match(uri);
        boolean booleanQueryParameter = uri.getBooleanQueryParameter("caller_is_sync_adapter", false);
        C("delete match = " + match + ";callerIsSyncAdapter = " + booleanQueryParameter);
        String str7 = "kw_list";
        if (match != 300) {
            if (match != 302) {
                if (match == 601) {
                    str3 = "kw_list";
                } else {
                    if (match != 609) {
                        if (match != 611) {
                            switch (match) {
                                case OplusRecorder.NAMR_BYTES_P_SEC /* 700 */:
                                    str5 = "bl_list_delete";
                                    break;
                                case 701:
                                    str5 = "kw_list_delete";
                                    break;
                                case 702:
                                    str5 = "area_list_delete";
                                    break;
                                default:
                                    str5 = y(uri);
                                    break;
                            }
                        } else {
                            str5 = "romupdate_kw_list";
                        }
                    } else {
                        str5 = "romupdate_bl_list";
                    }
                    str3 = "kw_list";
                    str7 = str5;
                }
            } else {
                C("smswhitelisttable ");
                if (str6 != null) {
                    str4 = str6 + " AND " + OplusNumberMarkUtils.OplusBlacklist.LIST_TYPE + "=?";
                } else {
                    str4 = "list_type=?";
                }
                if (strArr2 != null) {
                    ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
                    arrayList.add(String.valueOf(2));
                    str6 = str4;
                    strArr2 = (String[]) arrayList.toArray(new String[0]);
                } else {
                    str6 = str4;
                    strArr2 = new String[]{String.valueOf(2)};
                }
                str3 = "kw_list";
                str7 = OplusNumberMarkUtils.OplusBlacklist.BLACKLIST_TABLE;
            }
        } else {
            if (l7.b.c(this.f26219h)) {
                return writableDatabase.delete(OplusNumberMarkUtils.OplusBlacklist.BLACKLIST_TABLE, str6, strArr2);
            }
            if (!B(str6)) {
                String queryParameter = uri.getQueryParameter("is_from_blocked_number");
                C("delete qp = " + queryParameter + " ,selection = " + C0846g.g(str));
                if (queryParameter == null || !queryParameter.equals("true")) {
                    str2 = OplusNumberMarkUtils.OplusBlacklist.BLACKLIST_TABLE;
                    str3 = "kw_list";
                    try {
                        cursor = writableDatabase.query(OplusNumberMarkUtils.OplusBlacklist.BLACKLIST_TABLE, null, str, strArr, null, null, null);
                        try {
                            if (!p(cursor)) {
                                HashMap hashMap = new HashMap();
                                hashMap.put("deleteBlockedNumber", C0846g.g(str));
                                StatisticsUtils.a(getContext(), 2010802, 201080020, hashMap, false);
                                I9.a.a(cursor);
                                return 0;
                            }
                            I9.a.a(cursor);
                            str7 = str2;
                        } catch (Throwable th) {
                            th = th;
                            I9.a.a(cursor);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = null;
                    }
                }
            }
            str2 = OplusNumberMarkUtils.OplusBlacklist.BLACKLIST_TABLE;
            str3 = "kw_list";
            str7 = str2;
        }
        if (!booleanQueryParameter && (OplusNumberMarkUtils.OplusBlacklist.BLACKLIST_TABLE.equals(str7) || str3.equals(str7) || "area_list".equals(str7))) {
            int E10 = E(writableDatabase, str7, str6, strArr2);
            if (E10 > 0) {
                this.f26220i.notifyChange(uri, null);
                F();
            }
            return E10;
        }
        if (str7 == null) {
            return -1;
        }
        try {
            int delete = writableDatabase.delete(str7, str6, strArr2);
            this.f26220i.notifyChange(uri, null);
            return delete;
        } catch (SQLException unused) {
            C("delete entry error!");
            return 0;
        }
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        o(getContext(), OplusPhoneUtils.PERMISSION_OPLUS_COMPONENT_SAFE);
        if ("insert_overseas_area".equals(str)) {
            this.f26228a.c(this.f26228a.getWritableDatabase());
            return new Bundle();
        }
        if ("update_area_list_method".equals(str)) {
            if (com.oplus.blacklistapp.framework.api.appstore.appinfo.a.e(getContext().getPackageManager().getNameForUid(Binder.getCallingUid()))) {
                this.f26217f.execute(new a());
                return new Bundle();
            }
        } else if ("update_block_setting_value".equals(str)) {
            F();
        }
        return super.call(str, str2, bundle);
    }

    @Override // com.oplus.blacklist.database.SQLiteContentProvider
    public com.oplus.blacklist.database.b d(Context context) {
        return com.oplus.blacklist.database.b.f(context);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x0059. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:12:0x005c. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0360  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0465 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:208:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0450  */
    @Override // com.oplus.blacklist.database.SQLiteContentProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.net.Uri f(android.net.Uri r23, android.content.ContentValues r24) {
        /*
            Method dump skipped, instructions count: 1174
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.blacklist.database.BlackListProvider.f(android.net.Uri, android.content.ContentValues):android.net.Uri");
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:110:0x025c A[Catch: all -> 0x0273, TRY_LEAVE, TryCatch #13 {all -> 0x0273, blocks: (B:110:0x025c, B:198:0x0257), top: B:197:0x0257 }] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02eb A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x03c2  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x029e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:186:? A[Catch: Exception -> 0x029a, SYNTHETIC, TRY_LEAVE, TryCatch #16 {Exception -> 0x029a, blocks: (B:116:0x0292, B:185:0x02a7, B:184:0x02a4, B:179:0x029e), top: B:81:0x020a, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0509 A[ADDED_TO_REGION] */
    /* JADX WARN: Type inference failed for: r10v17, types: [int] */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v21 */
    /* JADX WARN: Type inference failed for: r12v27 */
    /* JADX WARN: Type inference failed for: r12v28 */
    /* JADX WARN: Type inference failed for: r12v29 */
    /* JADX WARN: Type inference failed for: r12v32 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v13 */
    /* JADX WARN: Type inference failed for: r14v14 */
    /* JADX WARN: Type inference failed for: r14v22 */
    /* JADX WARN: Type inference failed for: r14v48 */
    /* JADX WARN: Type inference failed for: r14v49 */
    /* JADX WARN: Type inference failed for: r40v0, types: [com.oplus.blacklist.database.SQLiteContentProvider, com.oplus.blacklist.database.BlackListProvider, android.content.ContentProvider] */
    /* JADX WARN: Type inference failed for: r5v1, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r9v20, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v22 */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v25 */
    /* JADX WARN: Type inference failed for: r9v26 */
    /* JADX WARN: Type inference failed for: r9v29, types: [java.lang.String] */
    @Override // com.oplus.blacklist.database.SQLiteContentProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int j(android.net.Uri r41, android.content.ContentValues r42, java.lang.String r43, java.lang.String[] r44) {
        /*
            Method dump skipped, instructions count: 1300
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.blacklist.database.BlackListProvider.j(android.net.Uri, android.content.ContentValues, java.lang.String, java.lang.String[]):int");
    }

    public boolean m(String str) {
        try {
            if (BlockedNumberContract.isBlocked(getContext(), str)) {
                return true;
            }
            ContentResolver contentResolver = getContext().getContentResolver();
            ContentValues contentValues = new ContentValues();
            if (!C0844e.f29134b) {
                contentValues.put("is_from_black_list", Boolean.TRUE);
            }
            contentValues.put("original_number", str);
            contentResolver.insert(BlockedNumberContract.BlockedNumbers.CONTENT_URI, contentValues);
            return true;
        } catch (Exception e10) {
            Log.e("BlackListProvider", "blockIfNeeded: " + e10);
            return false;
        }
    }

    public final void n() {
        try {
            this.f26219h.getContentResolver().call(Uri.parse("content://" + C1629c.f37421g + "/"), "update_area_list_method", (String) null, (Bundle) null);
        } catch (Exception e10) {
            Log.e("BlackListProvider", "callBlacklistUpdateArealist error " + e10);
        }
    }

    public final void o(Context context, String str) {
        boolean z10;
        if (context.checkCallingPermission(str) == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        C("checkCallingPermission:  permission = " + str + " caller = " + Binder.getCallingPid() + " hasPermission = " + z10);
        if (z10) {
        } else {
            throw new SecurityException(String.format("The caller must have the %s permission.", str));
        }
    }

    @Override // com.oplus.blacklist.database.SQLiteContentProvider, android.content.ContentProvider
    public boolean onCreate() {
        super.onCreate();
        Context context = getContext();
        this.f26219h = context;
        this.f26220i = context.getContentResolver();
        this.f26217f = Executors.newSingleThreadExecutor();
        C0846g.k("BlackListProvider", "onCreate");
        return false;
    }

    public boolean p(Cursor cursor) {
        if (cursor == null || cursor.getCount() <= 0) {
            return true;
        }
        int columnIndex = cursor.getColumnIndex("number");
        cursor.moveToPosition(-1);
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        Uri build = BlockedNumberContract.BlockedNumbers.CONTENT_URI.buildUpon().appendQueryParameter("is_from_black_list", "true").build();
        while (cursor.moveToNext()) {
            arrayList.add(ContentProviderOperation.newDelete(build).withSelection("original_number=?", new String[]{cursor.getString(columnIndex)}).build());
        }
        try {
            getContext().getContentResolver().applyBatch("com.android.blockednumber", arrayList);
            return true;
        } catch (Exception e10) {
            Log.e("BlackListProvider", "deleteBlock: " + e10);
            return false;
        }
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        try {
            C0846g.k("BlackListProvider", "start query: CPid=" + Binder.getCallingPid() + ";package = " + getCallingPackage());
            return H(uri, strArr, str, strArr2, str2);
        } finally {
            C0846g.k("BlackListProvider", "query end");
        }
    }

    public String r(String str) {
        C0848i.s(str);
        StringBuilder sb = new StringBuilder("(SELECT * FROM bl_list WHERE ");
        String f10 = C0848i.f(getContext(), str, null, null);
        C("getSmsWhiteListTableNumberLookUp : e164_number is " + C0846g.f(f10));
        if (!TextUtils.isEmpty(f10)) {
            sb.append("e164_number = ");
            DatabaseUtils.appendEscapedSQLString(sb, f10);
        } else {
            sb.append("number = ");
            DatabaseUtils.appendEscapedSQLString(sb, str);
        }
        sb.append(" AND list_type = 3");
        sb.append(")");
        return sb.toString();
    }

    public final int s(ContentValues contentValues, String str, int i10) {
        if (contentValues == null) {
            return i10;
        }
        try {
            Integer asInteger = contentValues.getAsInteger(str);
            if (asInteger != null) {
                return asInteger.intValue();
            }
            return i10;
        } catch (Throwable th) {
            Log.e("BlackListProvider", "getIntFromValue error!" + th);
            return i10;
        }
    }

    public final int t(Uri uri, String str, int i10) {
        String queryParameter = uri.getQueryParameter(str);
        if (queryParameter == null) {
            return i10;
        }
        try {
            return Integer.parseInt(queryParameter);
        } catch (NumberFormatException unused) {
            Log.e("BlackListProvider", "Integer required for " + str + " parameter but value '" + queryParameter + "' was found instead.");
            return i10;
        }
    }

    public final long u(ContentValues contentValues, String str, long j10) {
        if (contentValues == null) {
            return j10;
        }
        try {
            Long asLong = contentValues.getAsLong(str);
            if (asLong != null) {
                return asLong.longValue();
            }
        } catch (Exception e10) {
            Log.e("BlackListProvider", "getLongFromValue error!" + e10);
        }
        return j10;
    }

    public String x(String str) {
        StringBuilder sb = new StringBuilder("(SELECT * FROM bl_list WHERE ");
        String f10 = C0848i.f(getContext(), str, null, null);
        C("getSmsWhiteListTableNumberLookUp : e164_number is " + C0846g.f(f10));
        if (!TextUtils.isEmpty(f10)) {
            sb.append("e164_number = ");
            DatabaseUtils.appendEscapedSQLString(sb, f10);
        } else {
            sb.append("number = ");
            DatabaseUtils.appendEscapedSQLString(sb, str);
        }
        sb.append(" AND list_type = 2");
        sb.append(")");
        return sb.toString();
    }

    public final String y(Uri uri) {
        int match = f26214o.match(uri);
        if (match != 311 && match != 314) {
            if (match != 601) {
                if (match != 602) {
                    if (match != 612) {
                        if (match != 613) {
                            switch (match) {
                                default:
                                    switch (match) {
                                        case 604:
                                        case 605:
                                            return "call_record_custom_list";
                                        case 606:
                                            return "pseudo_base_station";
                                        case 607:
                                            break;
                                        default:
                                            throw new IllegalArgumentException("Error Uri: " + C0846g.h(uri));
                                    }
                                case 300:
                                case COUIHapticFeedbackConstants.KEYBOARD_TOUCH_FEEDBACK /* 301 */:
                                case COUIHapticFeedbackConstants.GRANULAR_SHORT_VIBRATE /* 302 */:
                                case COUIHapticFeedbackConstants.SHORT_VIBRATE /* 303 */:
                                case 304:
                                    return OplusNumberMarkUtils.OplusBlacklist.BLACKLIST_TABLE;
                            }
                        }
                    } else {
                        return "bl_area_for_country";
                    }
                } else {
                    return "area_list";
                }
            } else {
                return "kw_list";
            }
        }
        return OplusNumberMarkUtils.OplusBlacklist.BLACKLIST_TABLE;
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0057: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]) (LINE:88), block:B:43:0x0057 */
    public final synchronized HashMap<Long, ArrayList<Long>> z() {
        Cursor cursor;
        Closeable closeable;
        HashMap<Long, ArrayList<Long>> hashMap = new HashMap<>();
        Closeable closeable2 = null;
        try {
            try {
                cursor = getContext().getContentResolver().query(this.f26216e, f26213n, null, null, null);
                if (cursor == null) {
                    I9.a.a(cursor);
                    return null;
                }
                while (cursor.moveToNext()) {
                    try {
                        long j10 = cursor.getLong(1);
                        if (j10 != 0) {
                            long j11 = cursor.getLong(0);
                            if (hashMap.containsKey(Long.valueOf(j10))) {
                                hashMap.get(Long.valueOf(j10)).add(Long.valueOf(j11));
                            } else {
                                ArrayList<Long> arrayList = new ArrayList<>();
                                arrayList.add(Long.valueOf(j11));
                                hashMap.put(Long.valueOf(j10), arrayList);
                            }
                        }
                    } catch (Exception e10) {
                        e = e10;
                        Log.e("BlackListProvider", "initEqualIdsMap error " + e);
                        I9.a.a(cursor);
                        return null;
                    }
                }
                I9.a.a(cursor);
                if (hashMap.size() == 0) {
                    n();
                }
                return hashMap;
            } catch (Throwable th) {
                th = th;
                closeable2 = closeable;
                I9.a.a(closeable2);
                throw th;
            }
        } catch (Exception e11) {
            e = e11;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            I9.a.a(closeable2);
            throw th;
        }
    }

    @Override // com.oplus.blacklist.database.SQLiteContentProvider
    public void g() {
    }
}
