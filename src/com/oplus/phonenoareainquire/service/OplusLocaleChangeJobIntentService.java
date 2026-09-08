package com.oplus.phonenoareainquire.service;

import android.content.ContentProvider;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.preference.PreferenceManager;
import androidx.core.app.JobIntentService;
import com.android.incallui.Log;
import com.oplus.phonenoareainquire.PhoneNoInquireProvider;
import com.oplus.phonenoareainquire.PhoneNumberAreaApplication;
import com.oplus.phonenoareainquire.d;
import com.oplus.phonenoareainquire.e;
import com.oplus.phonenoareainquire.utils.LogUtil;
import com.oplus.phonenoareainquire.utils.c;
import e8.C0988a;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Locale;
import kotlin.Result;
import kotlin.b;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.n;
import m9.q;

/* compiled from: OplusLocaleChangeJobIntentService.kt */
/* loaded from: classes3.dex */
public final class OplusLocaleChangeJobIntentService extends JobIntentService {

    /* renamed from: j, reason: collision with root package name */
    public static final a f28872j = new a(null);

    /* renamed from: k, reason: collision with root package name */
    public static Context f28873k;

    /* compiled from: OplusLocaleChangeJobIntentService.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public final void a() {
            Object b10;
            try {
                Result.a aVar = Result.f34166a;
                PhoneNumberAreaApplication c10 = PhoneNumberAreaApplication.c();
                String string = PreferenceManager.getDefaultSharedPreferences(c10).getString("multi_language_tab_country", "");
                String a10 = c.a();
                LogUtil.c("OplusLocaleChangeJobIntentService", "savedCountry: " + string + ", currentCountry: " + a10);
                if (!i.b(string, a10)) {
                    FileInputStream fileInputStream = new FileInputStream(PhoneNoInquireProvider.f28795E);
                    try {
                        f(fileInputStream, OplusLocaleChangeJobIntentService.f28873k, e.g(c10).getWritableDatabase(), "checkMultiLanguage");
                        q qVar = q.f35511a;
                        kotlin.io.a.a(fileInputStream, null);
                    } finally {
                    }
                }
                b10 = Result.b(q.f35511a);
            } catch (Throwable th) {
                Result.a aVar2 = Result.f34166a;
                b10 = Result.b(b.a(th));
            }
            Throwable d10 = Result.d(b10);
            if (d10 != null) {
                LogUtil.b("OplusLocaleChangeJobIntentService", "checkMultiLanguage failed " + d10 + " " + d10.getMessage());
            }
        }

        public final void b(Context context, Intent work) {
            i.f(context, "context");
            i.f(work, "work");
            OplusLocaleChangeJobIntentService.f28873k = context;
            JobIntentService.d(context, OplusLocaleChangeJobIntentService.class, 0, work);
        }

        public final void c(String str) {
            try {
                Result.a aVar = Result.f34166a;
                String languageTag = Locale.getDefault().toLanguageTag();
                String a10 = c.a();
                C0988a.b(PhoneNumberAreaApplication.c().getApplicationContext(), "update_language_table", str + Log.TAG_DELIMETER + languageTag + Log.TAG_DELIMETER + a10);
                Result.b(q.f35511a);
            } catch (Throwable th) {
                Result.a aVar2 = Result.f34166a;
                Result.b(b.a(th));
            }
        }

        public final void d(String str) {
            Object b10;
            try {
                Result.a aVar = Result.f34166a;
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(PhoneNumberAreaApplication.c());
                i.e(defaultSharedPreferences, "getDefaultSharedPreferences(...)");
                SharedPreferences.Editor edit = defaultSharedPreferences.edit();
                edit.putString("multi_language_tab_country", str);
                edit.commit();
                b10 = Result.b(q.f35511a);
            } catch (Throwable th) {
                Result.a aVar2 = Result.f34166a;
                b10 = Result.b(b.a(th));
            }
            Throwable d10 = Result.d(b10);
            if (d10 != null) {
                android.util.Log.e("OplusLocaleChangeJobIntentService", "saveUpdateCountryToSP failed " + d10 + " " + d10.getMessage());
            }
        }

        public final void e(SQLiteDatabase sQLiteDatabase, String[] strArr, int i10) {
            try {
                sQLiteDatabase.execSQL("update areano_and_citynames set cityname = '" + strArr[i10] + "' where _id = '" + strArr[0] + "';");
                int i11 = i10 + 2;
                if (!i.b(strArr[i11], "null")) {
                    sQLiteDatabase.execSQL("update province_and_city_relation set province = '" + strArr[i10 + 1] + "', city = '" + strArr[i11] + "' where _id = '" + strArr[0] + "';");
                } else {
                    sQLiteDatabase.execSQL("update province_and_city_relation set province = '" + strArr[i10 + 1] + "', city = null where _id = '" + strArr[0] + "';");
                }
            } catch (SQLiteException e10) {
                android.util.Log.e("OplusLocaleChangeJobIntentService", "e = " + e10);
            }
        }

        public final synchronized void f(InputStream inputStream, Context context, SQLiteDatabase sQLiteDatabase, String str) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                LogUtil.a("OplusLocaleChangeJobIntentService", "enter updateMultiLanguageTag , start to update table");
                PhoneNoInquireProvider h10 = PhoneNoInquireProvider.h();
                if (h10 != null) {
                    h10.L();
                }
                c(str);
                d.c().a();
                String a10 = c.a();
                if (c.c(a10)) {
                    a10 = "US";
                }
                if (inputStream == null) {
                    if (PhoneNumberAreaApplication.b("Multi_Language_Table.txt", PhoneNoInquireProvider.f28795E) != null) {
                        android.util.Log.d("OplusLocaleChangeJobIntentService", "inputStream is null");
                        return;
                    }
                    inputStream = null;
                }
                if (sQLiteDatabase == null && context == null) {
                    return;
                }
                if (sQLiteDatabase == null) {
                    sQLiteDatabase = e.g(context).getWritableDatabase();
                }
                g(sQLiteDatabase, inputStream, a10);
                android.util.Log.i("OplusLocaleChangeJobIntentService", "updateMultiLanguageTab success " + a10 + " " + str + ", cost: " + (System.currentTimeMillis() - currentTimeMillis));
            } catch (Throwable th) {
                throw th;
            }
        }

        public final void g(SQLiteDatabase sQLiteDatabase, InputStream inputStream, String str) {
            List Y9;
            List Y10;
            String t10;
            int i10;
            boolean z10;
            if (sQLiteDatabase == null) {
                LogUtil.b("OplusLocaleChangeJobIntentService", "updateMultiLanguageTabInternal db is null");
                return;
            }
            sQLiteDatabase.beginTransaction();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            boolean z11 = false;
            int i11 = 1;
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null || readLine.length() == 0) {
                    break;
                }
                i.c(readLine);
                int length = readLine.length() - 1;
                int i12 = 0;
                boolean z12 = false;
                while (i12 <= length) {
                    if (!z12) {
                        i10 = i12;
                    } else {
                        i10 = length;
                    }
                    if (i.g(readLine.charAt(i10), 32) <= 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (!z12) {
                        if (!z10) {
                            z12 = true;
                        } else {
                            i12++;
                        }
                    } else if (!z10) {
                        break;
                    } else {
                        length--;
                    }
                }
                String obj = readLine.subSequence(i12, length + 1).toString();
                if (!z11) {
                    i.c(obj);
                    Y9 = StringsKt__StringsKt.Y(obj, new String[]{"\t"}, false, 0, 6, null);
                    String[] strArr = (String[]) Y9.toArray(new String[0]);
                    int length2 = strArr.length;
                    for (int i13 = 1; i13 < length2; i13++) {
                        if (i.b(strArr[i13], str)) {
                            i11 = i13;
                        }
                    }
                    z11 = true;
                } else {
                    i.c(obj);
                    Y10 = StringsKt__StringsKt.Y(obj, new String[]{"\t"}, false, 0, 6, null);
                    String[] strArr2 = (String[]) Y10.toArray(new String[0]);
                    int length3 = strArr2.length;
                    for (int i14 = 0; i14 < length3; i14++) {
                        t10 = n.t(strArr2[i14], "'", "''", false, 4, null);
                        strArr2[i14] = t10;
                    }
                    e(sQLiteDatabase, strArr2, i11);
                }
            }
            bufferedReader.close();
            inputStreamReader.close();
            sQLiteDatabase.setTransactionSuccessful();
            sQLiteDatabase.endTransaction();
            d(str);
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public static final void l() {
        f28872j.a();
    }

    public static final synchronized void n(InputStream inputStream, Context context, SQLiteDatabase sQLiteDatabase, String str) {
        synchronized (OplusLocaleChangeJobIntentService.class) {
            f28872j.f(inputStream, context, sQLiteDatabase, str);
        }
    }

    @Override // androidx.core.app.JobIntentService
    public void g(Intent intent) {
        ContentProviderClient contentProviderClient;
        ContentProvider localContentProvider;
        ContentResolver contentResolver;
        i.f(intent, "intent");
        if (f28873k == null) {
            return;
        }
        m();
        Context context = f28873k;
        if (context != null && (contentResolver = context.getContentResolver()) != null) {
            contentProviderClient = contentResolver.acquireContentProviderClient("com.oplus.dialer.inquirenoarea");
        } else {
            contentProviderClient = null;
        }
        if (contentProviderClient != null && (localContentProvider = contentProviderClient.getLocalContentProvider()) != null && (localContentProvider instanceof PhoneNoInquireProvider)) {
            LogUtil.a("OplusLocaleChangeJobIntentService", "start ot run onLocaleChanged");
            ((PhoneNoInquireProvider) localContentProvider).H();
        }
        if (contentProviderClient != null) {
            contentProviderClient.close();
        }
    }

    public final void m() {
        SQLiteDatabase writableDatabase = e.g(getApplicationContext()).getWritableDatabase();
        try {
            FileInputStream fileInputStream = new FileInputStream(PhoneNoInquireProvider.f28795E);
            try {
                f28872j.f(fileInputStream, f28873k, writableDatabase, "ChangeLanguage");
                q qVar = q.f35511a;
                kotlin.io.a.a(fileInputStream, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    kotlin.io.a.a(fileInputStream, th);
                    throw th2;
                }
            }
        } catch (SQLiteException e10) {
            android.util.Log.e("OplusLocaleChangeJobIntentService", "e = " + e10);
        } catch (IOException e11) {
            try {
                f28872j.f(null, f28873k, writableDatabase, "ChangeLanguage-Exception");
            } catch (SQLiteException e12) {
                android.util.Log.e("OplusLocaleChangeJobIntentService", "e = " + e12);
            }
            android.util.Log.e("OplusLocaleChangeJobIntentService", "e = " + e11);
        }
    }
}
