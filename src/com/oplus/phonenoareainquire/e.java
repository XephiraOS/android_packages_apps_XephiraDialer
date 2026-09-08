package com.oplus.phonenoareainquire;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import c8.C0568b;
import com.heytap.accessory.constant.FastPairConstants;
import com.oplus.backup.sdk.common.plugin.BRPluginConfig;
import com.oplus.media.OplusRecorder;
import com.oplus.phonenoareainquire.service.OplusLocaleChangeJobIntentService;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* compiled from: PhoneNoInquireDatabaseHelper.java */
/* loaded from: classes3.dex */
public class e extends SQLiteOpenHelper {

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f28855b = PhoneNumberAreaApplication.f28829a;

    /* renamed from: c, reason: collision with root package name */
    public static e f28856c;

    /* renamed from: a, reason: collision with root package name */
    public Context f28857a;

    public e(Context context) {
        super(context, "inquirenoarea.db", (SQLiteDatabase.CursorFactory) null, 44);
        this.f28857a = context;
        C0568b.b(context);
    }

    public static synchronized e g(Context context) {
        e eVar;
        synchronized (e.class) {
            try {
                if (f28856c == null) {
                    f28856c = new e(context);
                }
                eVar = f28856c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return eVar;
    }

    public final InputStream a(InputStream inputStream) {
        int available = inputStream.available();
        byte[] bArr = new byte[available];
        int i10 = 0;
        while (i10 < available) {
            i10 += inputStream.read(bArr, i10, available - i10);
        }
        return new ByteArrayInputStream(bArr);
    }

    public void c() {
        try {
            this.f28857a.getContentResolver().call(Uri.parse("content://com.oplus.provider.BlackListProvider"), "update_area_list_method", (String) null, (Bundle) null);
        } catch (Exception e10) {
            Log.e("PhoneNoDbHelper", "callBlacklistUpdateArealist error " + e10);
        }
    }

    public void e(SQLiteDatabase sQLiteDatabase, String str) {
        File a10 = b.a(PhoneNoInquireProvider.f28792B);
        InputStream open = this.f28857a.getResources().getAssets().open("PhoneNumberData_3_1_0.dat");
        FileOutputStream fileOutputStream = new FileOutputStream(a10);
        byte[] bArr = new byte[102400];
        Log.i("PhoneNoDbHelper", "copy PhoneNumberData.dat to /data/data/");
        while (true) {
            int read = open.read(bArr);
            if (read == -1) {
                break;
            } else {
                fileOutputStream.write(bArr, 0, read);
            }
        }
        open.close();
        fileOutputStream.close();
        FileInputStream fileInputStream = new FileInputStream(a10);
        DataInputStream dataInputStream = new DataInputStream(a(fileInputStream));
        byte[] bArr2 = new byte[12];
        int read2 = dataInputStream.read(bArr2, 0, 12);
        String str2 = new String(bArr2, "UTF-8");
        Log.i("PhoneNoDbHelper", "version =" + str2 + ", versionLength = " + read2);
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("ver", str2);
            sQLiteDatabase.insert(BRPluginConfig.VERSION, null, contentValues);
        } catch (Exception e10) {
            Log.e("PhoneNoDbHelper", "" + e10);
        }
        File a11 = b.a(PhoneNoInquireProvider.f28793C);
        InputStream open2 = this.f28857a.getResources().getAssets().open("ExtendNumber.dat");
        FileOutputStream fileOutputStream2 = new FileOutputStream(a11);
        while (true) {
            int read3 = open2.read(bArr);
            if (read3 == -1) {
                break;
            } else {
                fileOutputStream2.write(bArr, 0, read3);
            }
        }
        open2.close();
        fileOutputStream2.close();
        l(dataInputStream, sQLiteDatabase);
        File a12 = b.a(PhoneNoInquireProvider.f28794D);
        InputStream open3 = this.f28857a.getResources().getAssets().open("city_name_table.txt");
        FileOutputStream fileOutputStream3 = new FileOutputStream(a12);
        while (true) {
            int read4 = open3.read(bArr);
            if (read4 == -1) {
                break;
            } else {
                fileOutputStream3.write(bArr, 0, read4);
            }
        }
        open3.close();
        fileOutputStream3.close();
        f(sQLiteDatabase);
        try {
            r(sQLiteDatabase);
        } catch (Exception e11) {
            Log.e("PhoneNoDbHelper", "updateCityCode fail " + e11);
        }
        try {
            b.b(new File(PhoneNoInquireProvider.f28795E));
            OplusLocaleChangeJobIntentService.n(PhoneNumberAreaApplication.b("Multi_Language_Table.txt", PhoneNoInquireProvider.f28795E), this.f28857a, sQLiteDatabase, str);
        } catch (Exception e12) {
            try {
                OplusLocaleChangeJobIntentService.n(null, this.f28857a, sQLiteDatabase, str + "-Exception");
            } catch (Exception e13) {
                Log.e("PhoneNoDbHelper", "e = " + e13);
            }
            Log.e("PhoneNoDbHelper", "e = " + e12);
        }
        fileInputStream.close();
    }

    public void f(SQLiteDatabase sQLiteDatabase) {
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(PhoneNoInquireProvider.f28794D));
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        while (true) {
            try {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null || readLine.trim().length() <= 0) {
                        break;
                    }
                    String trim = readLine.trim();
                    if (trim.length() <= 0) {
                        break;
                    }
                    int indexOf = trim.indexOf(" ");
                    if (indexOf > 0) {
                        sQLiteDatabase.execSQL("insert into province_and_city_relation(province,city) values ('" + trim.substring(0, indexOf) + "','" + trim.substring(indexOf) + "');");
                    } else {
                        sQLiteDatabase.execSQL("insert into province_and_city_relation(province) values ('" + trim + "');");
                    }
                } catch (Exception e10) {
                    Log.e("PhoneNoDbHelper", "the file may have encounter error try to self heal the file, e = " + e10);
                }
            } finally {
                inputStreamReader.close();
                bufferedReader.close();
            }
        }
    }

    public final void l(DataInputStream dataInputStream, SQLiteDatabase sQLiteDatabase) {
        int available = dataInputStream.available();
        byte[] bArr = new byte[2];
        byte[] bArr2 = new byte[2000];
        byte[] bArr3 = new byte[OplusRecorder.NWAV_SAMPLERATE];
        byte[] bArr4 = new byte[2000];
        dataInputStream.skip(available - 12002);
        dataInputStream.read(bArr);
        dataInputStream.read(bArr2);
        dataInputStream.read(bArr3);
        dataInputStream.read(bArr4);
        if (f28855b) {
            Log.d("PhoneNoDbHelper", "cityNum:" + ((bArr[1] & FastPairConstants.GO_INTENT_NOT_SET) | (bArr[0] << 8)));
        }
        Log.d("PhoneNoDbHelper", "start insert areano_and_citynames table");
        for (int i10 = 0; i10 < 400; i10++) {
            try {
                String trim = new String(bArr2, i10 * 5, 5).trim();
                String trim2 = new String(bArr3, i10 * 20, 20, "gbk").trim();
                if (trim.equals("") && trim2.equals("")) {
                    break;
                }
                sQLiteDatabase.execSQL("insert into areano_and_citynames(areano,cityname) values ('" + trim + "','" + trim2 + "');");
            } catch (Exception unused) {
                Log.e("PhoneNoDbHelper", "init database failed");
                return;
            }
        }
        SharedPreferences.Editor edit = this.f28857a.getSharedPreferences("expand", 0).edit();
        edit.clear();
        for (int i11 = 0; i11 < 1000; i11++) {
            int i12 = i11 * 2;
            int i13 = (bArr4[i12] & FastPairConstants.GO_INTENT_NOT_SET) << 8;
            int i14 = bArr4[i12 + 1] & FastPairConstants.GO_INTENT_NOT_SET;
            if (i13 == 0 && i14 == 0) {
                break;
            }
            edit.putString(Integer.toString(i11), Integer.toString(i13 + i14));
        }
        edit.commit();
        dataInputStream.close();
        Log.d("PhoneNoDbHelper", "init database sucess");
    }

    public void o(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS province_and_city_relation");
        sQLiteDatabase.execSQL("CREATE TABLE province_and_city_relation (_id INTEGER PRIMARY KEY ,province TEXT NOT NULL, city TEXT);");
        try {
            f(sQLiteDatabase);
        } catch (IOException e10) {
            Log.e("PhoneNoDbHelper", "e = " + e10);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS areano_and_citynames (_id INTEGER PRIMARY KEY ,areano TEXT NOT NULL, cityname TEXT NOT NULL, equal_id INTEGER DEFAULT 0 );");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS version (_id INTEGER ,ver TEXT);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS province_and_city_relation (_id INTEGER PRIMARY KEY ,province TEXT NOT NULL, city TEXT);");
        try {
            e(sQLiteDatabase, "DatabaseHelperOnCreate");
        } catch (IOException e10) {
            Log.e("PhoneNoDbHelper", "e = " + e10);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        Log.d("PhoneNoDbHelper", "------onDowngrade------");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS areano_and_citynames");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS version");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS specialnumber");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS internationalcode");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS province_and_city_relation");
        onCreate(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ATTACH DATABASE ':memory:' AS area_presence_db;");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS area_presence_db.presence_numbers_table (_id TEXT,display_name TEXT,data1 TEXT,phonebook_bucket INTEGER DEFAULT 0,_index INTEGER,cityname TEXT,areano TEXT,photo_id TEXT,UNIQUE(_id, data1));");
        super.onOpen(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        Log.d("PhoneNoDbHelper", "------onUpgrade------");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS areano_and_citynames");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS version");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS specialnumber");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS internationalcode");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS province_and_city_relation");
        onCreate(sQLiteDatabase);
        if (i10 < 41) {
            c();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void r(android.database.sqlite.SQLiteDatabase r10) {
        /*
            r9 = this;
            java.lang.String r0 = "PhoneNoDbHelper"
            r1 = 0
            android.content.Context r9 = r9.f28857a     // Catch: java.lang.Throwable -> La5 java.lang.Exception -> La8
            android.content.res.AssetManager r9 = r9.getAssets()     // Catch: java.lang.Throwable -> La5 java.lang.Exception -> La8
            java.lang.String r2 = "Multi_Areano_Table.txt"
            java.io.InputStream r9 = r9.open(r2)     // Catch: java.lang.Throwable -> La5 java.lang.Exception -> La8
            if (r9 == 0) goto L9a
            if (r10 != 0) goto L15
            goto L9a
        L15:
            long r2 = android.os.SystemClock.elapsedRealtime()     // Catch: java.lang.Throwable -> L95 java.lang.Exception -> L98
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L95 java.lang.Exception -> L98
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L95 java.lang.Exception -> L98
            r5.<init>(r9)     // Catch: java.lang.Throwable -> L95 java.lang.Exception -> L98
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L95 java.lang.Exception -> L98
            r1 = 1
        L24:
            java.lang.String r5 = r4.readLine()     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5d
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5d
            if (r6 == 0) goto L2f
            goto L39
        L2f:
            java.lang.String r5 = r5.trim()     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5d
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5d
            if (r6 == 0) goto L5f
        L39:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5d
            r10.<init>()     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5d
            java.lang.String r1 = "updateCityCode use "
            r10.append(r1)     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5d
            long r5 = android.os.SystemClock.elapsedRealtime()     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5d
            long r5 = r5 - r2
            r10.append(r5)     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5d
            java.lang.String r10 = r10.toString()     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5d
            android.util.Log.d(r0, r10)     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5d
            r9.close()
        L55:
            r4.close()
            goto Lb6
        L5a:
            r10 = move-exception
        L5b:
            r1 = r9
            goto Lb8
        L5d:
            r1 = r9
            goto La9
        L5f:
            r6 = 0
            if (r1 == 0) goto L64
            r1 = r6
            goto L24
        L64:
            java.lang.String r7 = "\t"
            java.lang.String[] r5 = r5.split(r7)     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5d
            int r7 = r5.length     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5d
            r8 = 4
            if (r7 != r8) goto L24
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5d
            r7.<init>()     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5d
            java.lang.String r8 = "UPDATE areano_and_citynames SET equal_id = '"
            r7.append(r8)     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5d
            r8 = 2
            r8 = r5[r8]     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5d
            r7.append(r8)     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5d
            java.lang.String r8 = "' WHERE _id = '"
            r7.append(r8)     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5d
            r5 = r5[r6]     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5d
            r7.append(r5)     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5d
            java.lang.String r5 = "';"
            r7.append(r5)     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5d
            java.lang.String r5 = r7.toString()     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5d
            r10.execSQL(r5)     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5d
            goto L24
        L95:
            r10 = move-exception
            r4 = r1
            goto L5b
        L98:
            r4 = r1
            goto L5d
        L9a:
            java.lang.String r10 = "updateCityCode inputStream or db is null"
            android.util.Log.d(r0, r10)     // Catch: java.lang.Throwable -> L95 java.lang.Exception -> L98
            if (r9 == 0) goto La4
            r9.close()
        La4:
            return
        La5:
            r10 = move-exception
            r4 = r1
            goto Lb8
        La8:
            r4 = r1
        La9:
            java.lang.String r9 = "update city code error"
            android.util.Log.e(r0, r9)     // Catch: java.lang.Throwable -> Lb7
            if (r1 == 0) goto Lb3
            r1.close()
        Lb3:
            if (r4 == 0) goto Lb6
            goto L55
        Lb6:
            return
        Lb7:
            r10 = move-exception
        Lb8:
            if (r1 == 0) goto Lbd
            r1.close()
        Lbd:
            if (r4 == 0) goto Lc2
            r4.close()
        Lc2:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.phonenoareainquire.e.r(android.database.sqlite.SQLiteDatabase):void");
    }
}
