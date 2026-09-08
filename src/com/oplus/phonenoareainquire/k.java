package com.oplus.phonenoareainquire;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.util.Log;
import com.heytap.accessory.constant.FastPairConstants;
import com.oplus.backup.sdk.common.plugin.BRPluginConfig;
import com.oplus.media.OplusRecorder;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: UpdateDbFileUtils.java */
/* loaded from: classes3.dex */
public class k {

    /* renamed from: e, reason: collision with root package name */
    public static final boolean f28866e = PhoneNumberAreaApplication.f28829a;

    /* renamed from: f, reason: collision with root package name */
    public static final Object f28867f = new Object();

    /* renamed from: a, reason: collision with root package name */
    public Context f28868a;

    /* renamed from: b, reason: collision with root package name */
    public PowerManager.WakeLock f28869b;

    /* renamed from: d, reason: collision with root package name */
    public int f28871d = 0;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList<ContentProviderOperation> f28870c = new ArrayList<>();

    public k(Context context) {
        this.f28868a = context;
    }

    public static int d(ArrayList<String> arrayList) {
        if (arrayList == null) {
            return 0;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next.startsWith("version_")) {
                try {
                    return Integer.parseInt(next.replace("version_", ""));
                } catch (NumberFormatException e10) {
                    Log.e("UpdateDbFileUtils", " " + e10);
                }
            }
        }
        return 0;
    }

    public static ArrayList<String> e(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    Log.d("UpdateDbFileUtils", "file name  = " + file2.getName());
                    arrayList.add(file2.getName());
                }
            }
            return arrayList;
        }
        Log.d("UpdateDbFileUtils", "file is not exist ");
        return arrayList;
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

    public final int b() {
        int i10 = 66;
        Cursor cursor = null;
        try {
            try {
                cursor = this.f28868a.getContentResolver().query(Uri.parse("content://com.oplus.dialer.inquirenoarea/areano_and_citynames/"), new String[]{"areano", "cityname"}, null, null, null);
                int i11 = 67;
                if (cursor != null) {
                    int count = cursor.getCount();
                    if (f28866e) {
                        Log.d("UpdateDbFileUtils", "city count = " + count);
                    }
                    if (count < 375) {
                        cursor.close();
                        return 67;
                    }
                    boolean z10 = true;
                    while (true) {
                        if (cursor.moveToNext()) {
                            String string = cursor.getString(0);
                            int i12 = 0;
                            while (true) {
                                if (i12 >= string.length()) {
                                    break;
                                }
                                if ("0123456789".indexOf(string.charAt(i12)) == -1) {
                                    i10 = 67;
                                    z10 = false;
                                    break;
                                }
                                i12++;
                            }
                            if (!z10) {
                                break;
                            }
                        } else {
                            i11 = i10;
                            break;
                        }
                    }
                }
                if (cursor != null) {
                    cursor.close();
                    return i11;
                }
                return i11;
            } catch (Exception e10) {
                Log.e("UpdateDbFileUtils", "" + e10);
                if (cursor != null) {
                    cursor.close();
                }
                return i10;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x0144 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0127 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c(java.lang.String r7, java.lang.String r8, java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 352
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.phonenoareainquire.k.c(java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    public String f() {
        Cursor cursor = null;
        r1 = null;
        String str = null;
        cursor = null;
        try {
            try {
                Cursor query = this.f28868a.getContentResolver().query(Uri.parse(PhoneNoInquireProvider.f28803r + "/" + BRPluginConfig.VERSION), new String[]{"ver"}, null, null, null);
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            str = query.getString(query.getColumnIndex("ver")).substring(r0.length() - 8);
                        }
                        query.close();
                    } catch (Exception e10) {
                        e = e10;
                        cursor = query;
                        Log.e("UpdateDbFileUtils", "getVersion fail." + e);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return "";
                    } catch (Throwable th) {
                        th = th;
                        cursor = query;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                if (query != null) {
                    query.close();
                }
                return str;
            } catch (Exception e11) {
                e = e11;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final String g(FileInputStream fileInputStream) {
        byte[] bArr = new byte[12];
        int read = fileInputStream.read(bArr);
        String str = new String(bArr, "UTF-8");
        if (read == 12 && str.length() - 8 >= 0) {
            return str;
        }
        return "error";
    }

    public void h(boolean z10) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this.f28868a).edit();
        edit.putBoolean("update_state", z10);
        edit.commit();
    }

    public final void i() {
        PowerManager.WakeLock wakeLock = this.f28869b;
        if (wakeLock != null) {
            wakeLock.release();
        }
        this.f28869b = null;
    }

    public int j() {
        synchronized (f28867f) {
            boolean z10 = f28866e;
            if (z10) {
                Log.d("UpdateDbFileUtils", "revertDbFile ");
            }
            try {
                try {
                    try {
                        PowerManager.WakeLock newWakeLock = ((PowerManager) this.f28868a.getSystemService("power")).newWakeLock(1, "PhoneNumberAttribution:updateDbFile");
                        this.f28869b = newWakeLock;
                        newWakeLock.acquire();
                        File file = new File(PhoneNoInquireProvider.f28792B);
                        File file2 = new File(PhoneNoInquireProvider.f28791A);
                        if (!file.exists()) {
                            file.createNewFile();
                        } else {
                            file.delete();
                            file.createNewFile();
                        }
                        if (z10) {
                            Log.d("UpdateDbFileUtils", "[revertDbFile]revertDbFile.exists()=" + file2.exists());
                        }
                        byte[] bArr = new byte[102400];
                        if (!file2.exists()) {
                            file2.createNewFile();
                            InputStream open = this.f28868a.getResources().getAssets().open("PhoneNumberData_3_1_0.dat");
                            FileOutputStream fileOutputStream = new FileOutputStream(file2);
                            while (true) {
                                int read = open.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                if (f28866e) {
                                    Log.i("UpdateDbFileUtils", "in copySourceFile num=" + read);
                                }
                                fileOutputStream.write(bArr, 0, read);
                            }
                            open.close();
                            fileOutputStream.close();
                        }
                        FileInputStream fileInputStream = new FileInputStream(file2);
                        n(new FileOutputStream(file), fileInputStream, g(fileInputStream));
                        fileInputStream.close();
                        i();
                    } catch (IOException e10) {
                        Log.e("UpdateDbFileUtils", "e = " + e10);
                        i();
                        return 31;
                    }
                } catch (FileNotFoundException e11) {
                    Log.e("UpdateDbFileUtils", "e = " + e11);
                    i();
                    return 30;
                }
            } catch (Throwable th) {
                i();
                throw th;
            }
        }
        return 28;
    }

    public void k(String str, String str2, String str3) {
        File file;
        File file2;
        String str4 = str + str3;
        File file3 = new File(str4);
        if (file3.exists() && file3.isDirectory()) {
            String str5 = str2 + str3;
            ArrayList<String> e10 = e(str4);
            ArrayList<String> e11 = e(str5);
            int d10 = d(e10);
            try {
                if (d10 <= Math.max(d(e11), 2)) {
                    Log.d("UpdateDbFileUtils", "[updateCarrieDataIfNeed] sau version is below current");
                    return;
                }
                try {
                    PowerManager.WakeLock newWakeLock = ((PowerManager) this.f28868a.getSystemService("power")).newWakeLock(1, "PhoneNumberAttribution:updateCarrierDataIfNeed");
                    this.f28869b = newWakeLock;
                    newWakeLock.acquire();
                    String str6 = str2 + "carrier_temp";
                    file = new File(str6);
                    b.b(file);
                    Iterator<String> it = e10.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        StringBuilder sb = new StringBuilder();
                        sb.append(str4);
                        String str7 = File.separator;
                        sb.append(str7);
                        if (!c(sb.toString(), str6 + str7, next)) {
                            Log.d("UpdateDbFileUtils", "[updateCarrieDataIfNeed] sau copyFile failed return, fail File: " + next);
                            return;
                        }
                    }
                    file2 = new File(str5);
                    b.b(file2);
                } catch (Exception e12) {
                    Log.e("UpdateDbFileUtils", "updateCarrierDataIfNeed：" + e12);
                }
                if (file2.exists() && !file2.delete()) {
                    Log.d("UpdateDbFileUtils", "[updateCarrieDataIfNeed] appDataCarrieFile old data delete failed return");
                    return;
                }
                Log.d("UpdateDbFileUtils", "[updateCarrieDataIfNeed] rename : " + file.renameTo(file2));
                com.oplus.phonenoareainquire.utils.d.b(d10);
                return;
            } finally {
                i();
            }
        }
        Log.d("UpdateDbFileUtils", "[updateCarrieDataIfNeed]update file is error return ");
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00ae, code lost:
    
        r12.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b1, code lost:
    
        android.util.Log.w("UpdateDbFileUtils", "the download database file is a error file");
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00db, code lost:
    
        if (r11.compareTo(r5) < 0) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0111, code lost:
    
        h(false);
        r2.delete();
        r2.createNewFile();
        n(new java.io.FileOutputStream(r2), r12, r3);
        r2 = b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0128, code lost:
    
        if (com.oplus.phonenoareainquire.k.f28866e == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x012a, code lost:
    
        android.util.Log.d("UpdateDbFileUtils", "checkResult = " + r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0145, code lost:
    
        if (r2 != 67) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0147, code lost:
    
        r2 = android.net.Uri.withAppendedPath(com.oplus.phonenoareainquire.PhoneNoInquireProvider.f28803r, com.oplus.backup.sdk.common.plugin.BRPluginConfig.VERSION);
        r3 = new android.content.ContentValues();
        r3.put("ver", "0000" + r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x016a, code lost:
    
        r10.f28868a.getContentResolver().update(r2, r3, null, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0175, code lost:
    
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0176, code lost:
    
        android.util.Log.e("UpdateDbFileUtils", "" + r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x019e, code lost:
    
        r12.close();
        h(true);
        i();
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01a8, code lost:
    
        return 26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0141, code lost:
    
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01ab, code lost:
    
        h(true);
        i();
        android.util.Log.e("UpdateDbFileUtils", "database insert failed." + r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x01c8, code lost:
    
        return 27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00dd, code lost:
    
        r12.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00e2, code lost:
    
        if (com.oplus.phonenoareainquire.k.f28866e == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00e4, code lost:
    
        android.util.Log.d("UpdateDbFileUtils", "the current database is latest");
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00eb, code lost:
    
        i();
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x010c, code lost:
    
        return 25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0101, code lost:
    
        if (com.oplus.phonenoareainquire.k.f28866e != false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0103, code lost:
    
        android.util.Log.d("UpdateDbFileUtils", "the current database is latest");
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x00ef, code lost:
    
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x00f2, code lost:
    
        if (com.oplus.phonenoareainquire.k.f28866e != false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x00f4, code lost:
    
        android.util.Log.d("UpdateDbFileUtils", "the current database is latest");
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x00fb, code lost:
    
        i();
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x00fe, code lost:
    
        throw r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int l(java.lang.String r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 488
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.phonenoareainquire.k.l(java.lang.String, java.lang.String):int");
    }

    public synchronized void m(String str, String str2, String str3) {
        try {
            try {
                PowerManager.WakeLock newWakeLock = ((PowerManager) this.f28868a.getSystemService("power")).newWakeLock(1, "PhoneNumberAttribution:updateDbFile");
                this.f28869b = newWakeLock;
                newWakeLock.acquire();
                c(str, str2, str3);
            } catch (Exception e10) {
                Log.e("UpdateDbFileUtils", "updateFromSDToData：" + e10);
            }
        } finally {
        }
    }

    public final void n(FileOutputStream fileOutputStream, FileInputStream fileInputStream, String str) {
        byte[] bArr = new byte[102400];
        fileInputStream.getChannel().position(0L);
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read == -1) {
                break;
            }
            if (f28866e) {
                Log.i("UpdateDbFileUtils", "in copySourceFile num=" + read);
            }
            fileOutputStream.write(bArr, 0, read);
        }
        fileOutputStream.flush();
        fileOutputStream.close();
        fileInputStream.getChannel().position(0L);
        DataInputStream dataInputStream = new DataInputStream(a(fileInputStream));
        int available = dataInputStream.available();
        byte[] bArr2 = new byte[2000];
        byte[] bArr3 = new byte[OplusRecorder.NWAV_SAMPLERATE];
        byte[] bArr4 = new byte[2000];
        dataInputStream.skip(available - 12002);
        dataInputStream.read(new byte[2]);
        dataInputStream.read(bArr2);
        dataInputStream.read(bArr3);
        dataInputStream.read(bArr4);
        dataInputStream.close();
        ContentResolver contentResolver = this.f28868a.getContentResolver();
        if (f28866e) {
            Log.d("UpdateDbFileUtils", "deleting current database...");
        }
        try {
            contentResolver.delete(PhoneNoInquireProvider.f28803r, null, null);
        } catch (Exception e10) {
            Log.e("UpdateDbFileUtils", "" + e10);
        }
        if (f28866e) {
            Log.d("UpdateDbFileUtils", "updating current database...");
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Uri uri = PhoneNoInquireProvider.f28804x;
        int i10 = 0;
        while (i10 < 400) {
            String trim = new String(bArr2, i10 * 5, 5).trim();
            byte[] bArr5 = bArr2;
            String trim2 = new String(bArr3, i10 * 20, 20, "gbk").trim();
            if (trim.equals("") && trim2.equals("")) {
                if (this.f28870c.size() > 0) {
                    try {
                        this.f28868a.getContentResolver().applyBatch("com.oplus.dialer.inquirenoarea", this.f28870c);
                        this.f28870c.clear();
                        this.f28871d = 0;
                    } catch (Exception e11) {
                        h(false);
                        Log.e("UpdateDbFileUtils", "batch insert city failed." + e11);
                    }
                }
            } else {
                ContentValues contentValues = new ContentValues();
                contentValues.put("areano", trim);
                contentValues.put("cityname", trim2);
                ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(uri);
                newInsert.withValues(contentValues);
                this.f28870c.add(newInsert.build());
                int i11 = this.f28871d + 1;
                this.f28871d = i11;
                if (i11 >= 50) {
                    try {
                        this.f28868a.getContentResolver().applyBatch("com.oplus.dialer.inquirenoarea", this.f28870c);
                        this.f28870c.clear();
                        this.f28871d = 0;
                    } catch (Exception e12) {
                        h(false);
                        Log.e("UpdateDbFileUtils", "batch insert city failed." + e12);
                    }
                }
                i10++;
                bArr2 = bArr5;
            }
        }
        try {
            contentResolver.call("com.oplus.dialer.inquirenoarea", "update_city_code", (String) null, (Bundle) null);
        } catch (Throwable th) {
            Log.e("UpdateDbFileUtils", "update city code failed " + th);
        }
        if (f28866e) {
            Log.d("UpdateDbFileUtils", "update time = " + (SystemClock.elapsedRealtime() - elapsedRealtime));
        }
        Uri withAppendedPath = Uri.withAppendedPath(PhoneNoInquireProvider.f28803r, BRPluginConfig.VERSION);
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("ver", str);
        try {
            contentResolver.insert(withAppendedPath, contentValues2);
        } catch (Exception e13) {
            Log.e("UpdateDbFileUtils", "" + e13);
        }
        SharedPreferences.Editor edit = this.f28868a.getSharedPreferences("expand", 0).edit();
        edit.clear();
        for (int i12 = 0; i12 < 1000; i12++) {
            int i13 = i12 * 2;
            int i14 = (bArr4[i13] & FastPairConstants.GO_INTENT_NOT_SET) << 8;
            int i15 = bArr4[i13 + 1] & FastPairConstants.GO_INTENT_NOT_SET;
            if (i14 == 0 && i15 == 0) {
                break;
            }
            edit.putString(Integer.toString(i12), Integer.toString(i14 + i15));
        }
        edit.commit();
        if (f28866e) {
            Log.d("UpdateDbFileUtils", "update the current database end");
        }
    }
}
