package com.oplus.blacklist.database;

import F6.e;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.provider.BlockedNumberContract;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.util.Log;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.incallui.OplusNumberMarkUtils;
import com.android.incallui.OplusPhoneUtils;
import com.oplus.blacklist.database.BlackListProvider;
import com.oplus.common.data.WashManager;
import com.oplus.utils.C0844e;
import com.oplus.utils.C0848i;
import java.util.HashSet;
import v6.C1629c;

/* compiled from: DatabaseHelper.java */
/* loaded from: classes3.dex */
public class b extends SQLiteOpenHelper {

    /* renamed from: b, reason: collision with root package name */
    public static b f26239b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f26240c = e.I();

    /* renamed from: d, reason: collision with root package name */
    public static final Uri f26241d = Uri.parse("content://" + C1629c.f37421g + "/areano_and_citynames/");

    /* renamed from: e, reason: collision with root package name */
    public static final String[] f26242e = {BreenoCallContract.BaseColumns._ID, "equal_id"};

    /* renamed from: a, reason: collision with root package name */
    public Context f26243a;

    public b(Context context) {
        super(context, "blacklist.db", (SQLiteDatabase.CursorFactory) null, 17);
        this.f26243a = context;
    }

    public static HashSet<String> e(Context context) {
        if (context == null) {
            return null;
        }
        HashSet<String> hashSet = new HashSet<>();
        try {
            Cursor query = context.getContentResolver().query(f26241d, f26242e, null, null, null);
            if (query == null) {
                return null;
            }
            query.moveToPosition(-1);
            while (query.moveToNext()) {
                String[] strArr = f26242e;
                String string = query.getString(query.getColumnIndex(strArr[0]));
                String string2 = query.getString(query.getColumnIndex(strArr[1]));
                if (OplusPhoneUtils.DeviceState.UNLOCK_DEVICE.equals(string2)) {
                    hashSet.add(string);
                } else {
                    hashSet.add(string2);
                }
            }
            query.close();
            hashSet.add(OplusPhoneUtils.DeviceState.INVALID_STATUS);
            hashSet.add("-2");
            hashSet.add("-3");
            hashSet.add("-4");
            return hashSet;
        } catch (Exception e10) {
            Log.e("DatabaseHelper", "e = " + e10);
            return null;
        }
    }

    public static synchronized b f(Context context) {
        b bVar;
        synchronized (b.class) {
            try {
                if (f26239b == null && context != null) {
                    f26239b = new b(context);
                }
                bVar = f26239b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }

    public void a(SQLiteDatabase sQLiteDatabase) {
        HashSet<String> e10 = e(this.f26243a);
        if (e10 == null) {
            return;
        }
        try {
            sQLiteDatabase.delete("area_list", "equal_id NOT IN (" + TextUtils.join(" , ", e10) + ")", null);
        } catch (Exception e11) {
            Log.e("DatabaseHelper", "e = " + e11);
        }
    }

    public void c(SQLiteDatabase sQLiteDatabase) {
        long currentTimeMillis = System.currentTimeMillis();
        for (String str : BlackListProvider.b.f26226a) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("area_id", str);
            contentValues.put("time_stamp", Long.valueOf(currentTimeMillis));
            try {
                sQLiteDatabase.insert("area_list", null, contentValues);
            } catch (Exception e10) {
                Log.e("DatabaseHelper", "e = " + e10);
            }
        }
    }

    public final void g(SQLiteDatabase sQLiteDatabase) {
        if (C0844e.f29134b) {
            return;
        }
        try {
            Cursor query = this.f26243a.getContentResolver().query(BlockedNumberContract.BlockedNumbers.CONTENT_URI, new String[]{"original_number"}, null, null, null, null);
            if (query != null) {
                try {
                    ContentValues contentValues = new ContentValues();
                    while (query.moveToNext()) {
                        String string = query.getString(0);
                        if (!TextUtils.isEmpty(string)) {
                            contentValues.clear();
                            contentValues.put("number", string);
                            contentValues.put(OplusNumberMarkUtils.OplusBlacklist.BLOCK_TYPE, (Integer) 3);
                            contentValues.put(OplusNumberMarkUtils.OplusBlacklist.LIST_TYPE, (Integer) 1);
                            contentValues.put("time_stamp", Long.valueOf(System.currentTimeMillis()));
                            contentValues.put("sync_state", (Integer) 1);
                            String f10 = C0848i.f(this.f26243a, string, null, null);
                            String strippedReversed = PhoneNumberUtils.getStrippedReversed(string);
                            if (strippedReversed != null) {
                                contentValues.put("reverse_number", strippedReversed);
                            }
                            contentValues.put("e164_number", f10);
                            sQLiteDatabase.insert(OplusNumberMarkUtils.OplusBlacklist.BLACKLIST_TABLE, null, contentValues);
                        }
                    }
                } finally {
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Throwable th) {
            Log.w("DatabaseHelper", "loadOriginalBlackList e = " + th);
        }
    }

    public final void l(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE " + OplusNumberMarkUtils.OplusBlacklist.BLACKLIST_TABLE + " ADD function_type INTEGER NOT NULL DEFAULT 0");
            StringBuilder sb = new StringBuilder();
            sb.append("ALTER TABLE ");
            sb.append(OplusNumberMarkUtils.OplusBlacklist.BLACKLIST_TABLE);
            sb.append(" ADD ");
            sb.append("note");
            sb.append(" TEXT");
            sQLiteDatabase.execSQL(sb.toString());
            sQLiteDatabase.execSQL("ALTER TABLE bl_list_delete ADD function_type INTEGER NOT NULL DEFAULT 0");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ALTER TABLE ");
            sb2.append("bl_list_delete");
            sb2.append(" ADD ");
            sb2.append("note");
            sb2.append(" TEXT");
            sQLiteDatabase.execSQL(sb2.toString());
        } catch (Exception e10) {
            Log.w("DatabaseHelper", "updateSyncColumn TABLE_BL_LIST e = " + e10);
        }
    }

    public final void o(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE " + OplusNumberMarkUtils.OplusBlacklist.BLACKLIST_TABLE + " ADD sync_state INTEGER NOT NULL DEFAULT 1");
            StringBuilder sb = new StringBuilder();
            sb.append("ALTER TABLE ");
            sb.append(OplusNumberMarkUtils.OplusBlacklist.BLACKLIST_TABLE);
            sb.append(" ADD ");
            sb.append("time_stamp");
            sb.append(" INTEGER");
            sQLiteDatabase.execSQL(sb.toString());
            sQLiteDatabase.execSQL("ALTER TABLE " + OplusNumberMarkUtils.OplusBlacklist.BLACKLIST_TABLE + " ADD sync_version INTEGER");
            ContentValues contentValues = new ContentValues();
            contentValues.put("time_stamp", Long.valueOf(System.currentTimeMillis()));
            sQLiteDatabase.update(OplusNumberMarkUtils.OplusBlacklist.BLACKLIST_TABLE, contentValues, null, null);
            sQLiteDatabase.execSQL("create table if not exists bl_list_delete (_id INTEGER PRIMARY KEY AUTOINCREMENT,number TEXT,block_type INTEGER,list_type INTEGER,sync_version INTEGER,time_stamp INTEGER,function_type INTEGER NOT NULL DEFAULT 0,note TEXT,CONSTRAINT uniqueitem UNIQUE(number,list_type));");
        } catch (Exception e10) {
            Log.w("DatabaseHelper", "updateSyncColumn TABLE_BL_LIST e = " + e10);
        }
        try {
            sQLiteDatabase.execSQL("ALTER TABLE kw_list ADD sync_state INTEGER NOT NULL DEFAULT 1");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ALTER TABLE ");
            sb2.append("kw_list");
            sb2.append(" ADD ");
            sb2.append("time_stamp");
            sb2.append(" INTEGER");
            sQLiteDatabase.execSQL(sb2.toString());
            sQLiteDatabase.execSQL("ALTER TABLE kw_list ADD sync_version INTEGER");
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("time_stamp", Long.valueOf(System.currentTimeMillis()));
            sQLiteDatabase.update("kw_list", contentValues2, null, null);
            sQLiteDatabase.execSQL("create table if not exists kw_list_delete (_id INTEGER PRIMARY KEY AUTOINCREMENT,keyword TEXT, slot_id INTEGER NOT NULL DEFAULT 0, sync_version INTEGER,time_stamp INTEGER,CONSTRAINT uniqueitem UNIQUE(keyword, slot_id));");
        } catch (Exception e11) {
            Log.w("DatabaseHelper", "updateSyncColumn TABLE_KW_LIST e = " + e11);
        }
        try {
            sQLiteDatabase.execSQL("ALTER TABLE area_list ADD sync_state INTEGER NOT NULL DEFAULT 1");
            StringBuilder sb3 = new StringBuilder();
            sb3.append("ALTER TABLE ");
            sb3.append("area_list");
            sb3.append(" ADD ");
            sb3.append("time_stamp");
            sb3.append(" INTEGER");
            sQLiteDatabase.execSQL(sb3.toString());
            sQLiteDatabase.execSQL("ALTER TABLE area_list ADD sync_version INTEGER");
            ContentValues contentValues3 = new ContentValues();
            contentValues3.put("time_stamp", Long.valueOf(System.currentTimeMillis()));
            sQLiteDatabase.update("area_list", contentValues3, null, null);
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS area_list_delete(_id INTEGER PRIMARY KEY AUTOINCREMENT, area_id INTEGER, equal_id INTEGER, slot_id INTEGER NOT NULL DEFAULT 0, sync_version INTEGER,time_stamp INTEGER,CONSTRAINT uniqueitem UNIQUE(area_id, slot_id));");
        } catch (Exception e12) {
            Log.w("DatabaseHelper", "updateSyncColumn TABLE_AREA_LIST e = " + e12);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table if not exists bl_list (_id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,number TEXT,reverse_number TEXT,block_type INTEGER,photo_id INTEGER,contactID INTEGER,list_type INTEGER,e164_number TEXT,function_type INTEGER NOT NULL DEFAULT 0,note TEXT,sync_state INTEGER NOT NULL DEFAULT 1,sync_version INTEGER,time_stamp INTEGER,CONSTRAINT uniqueitem UNIQUE(number,list_type));");
        sQLiteDatabase.execSQL("create table if not exists bl_list_delete (_id INTEGER PRIMARY KEY AUTOINCREMENT,number TEXT,block_type INTEGER,list_type INTEGER,sync_version INTEGER,time_stamp INTEGER,function_type INTEGER NOT NULL DEFAULT 0,note TEXT,CONSTRAINT uniqueitem UNIQUE(number,list_type));");
        sQLiteDatabase.execSQL("create table if not exists kw_list (_id INTEGER PRIMARY KEY AUTOINCREMENT,keyword TEXT, slot_id INTEGER NOT NULL DEFAULT 0, sync_state INTEGER NOT NULL DEFAULT 1,sync_version INTEGER,time_stamp INTEGER,CONSTRAINT uniqueitem UNIQUE(keyword, slot_id));");
        sQLiteDatabase.execSQL("create table if not exists kw_list_delete (_id INTEGER PRIMARY KEY AUTOINCREMENT,keyword TEXT, slot_id INTEGER NOT NULL DEFAULT 0, sync_version INTEGER,time_stamp INTEGER,CONSTRAINT uniqueitem UNIQUE(keyword, slot_id));");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS area_list(_id INTEGER PRIMARY KEY AUTOINCREMENT, area_id INTEGER, equal_id INTEGER, slot_id INTEGER NOT NULL DEFAULT 0, sync_state INTEGER NOT NULL DEFAULT 1,sync_version INTEGER,time_stamp INTEGER,CONSTRAINT uniqueitem UNIQUE(area_id, slot_id));");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS area_list_delete(_id INTEGER PRIMARY KEY AUTOINCREMENT, area_id INTEGER, equal_id INTEGER, slot_id INTEGER NOT NULL DEFAULT 0, sync_version INTEGER,time_stamp INTEGER,CONSTRAINT uniqueitem UNIQUE(area_id, slot_id));");
        sQLiteDatabase.execSQL("create table if not exists call_record_custom_list (_id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,number TEXT,reverse_number TEXT,e164_number TEXT,photo_id INTEGER,contactID INTEGER DEFAULT '-1');");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS pseudo_base_station(_id INTEGER PRIMARY KEY AUTOINCREMENT, cell_id INTEGER, station_name TEXT, address TEXT, date INTEGER, is_read INTEGER, count INTEGER NOT NULL DEFAULT 0, latitude DOUBLE, longitude DOUBLE);");
        sQLiteDatabase.execSQL("create table if not exists romupdate_bl_list (_id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,number TEXT,reverse_number TEXT,block_type INTEGER,photo_id INTEGER,contactID INTEGER,list_type INTEGER,e164_number TEXT,CONSTRAINT uniqueitem UNIQUE(number,list_type));");
        sQLiteDatabase.execSQL("create table if not exists romupdate_kw_list (_id INTEGER PRIMARY KEY AUTOINCREMENT,keyword TEXT, list_type INTEGER,slot_id INTEGER NOT NULL DEFAULT 0, CONSTRAINT uniqueitem UNIQUE(keyword, slot_id));");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS bl_area_for_country(_id INTEGER PRIMARY KEY AUTOINCREMENT, country_code TEXT, slot_id INTEGER NOT NULL DEFAULT 0 );");
        Context context = this.f26243a;
        String str = f26240c;
        if (z6.b.c(context, 1, str, 0) == 1) {
            c(sQLiteDatabase);
            z6.b.i(this.f26243a, 1, str, 0);
        }
        g(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        Log.w("DatabaseHelper", "onDowngrade() oldVersion = " + i10 + ", newVersion = " + i11);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
        WashManager.h(sQLiteDatabase, this.f26243a);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0284 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01e2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01b8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0193 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0140 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    @Override // android.database.sqlite.SQLiteOpenHelper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onUpgrade(android.database.sqlite.SQLiteDatabase r18, int r19, int r20) {
        /*
            Method dump skipped, instructions count: 668
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.blacklist.database.b.onUpgrade(android.database.sqlite.SQLiteDatabase, int, int):void");
    }
}
