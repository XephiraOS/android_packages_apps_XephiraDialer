package com.oplus.phonenoareainquire.utils;

import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.util.Log;
import com.oplus.phonenoareainquire.PhoneNoInquireProvider;
import com.oplus.phonenoareainquire.PhoneNumberAreaApplication;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.i;
import kotlin.text.StringsKt__StringsKt;
import m9.q;

/* compiled from: CountryListUtil.kt */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f28881a = new b();

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f28882b = Pattern.compile("country_([A-Z]){2}");

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f28883c = Pattern.compile("\\W*([A-Z]{2})\\W*");

    /* renamed from: d, reason: collision with root package name */
    public static final Pattern f28884d = Pattern.compile("[\\d\\/]+");

    /* renamed from: e, reason: collision with root package name */
    public static final Pattern f28885e = Pattern.compile("^country_[A-Z]{2}_in_([a-z]{2,4}_[A-Z]{2})(_CN)?");

    /* renamed from: f, reason: collision with root package name */
    public static HashMap<String, String> f28886f = new HashMap<>();

    /* renamed from: g, reason: collision with root package name */
    public static HashMap<String, String> f28887g = new HashMap<>();

    /* renamed from: h, reason: collision with root package name */
    public static HashMap<String, String> f28888h = new HashMap<>();

    /* renamed from: i, reason: collision with root package name */
    public static ArrayList<String> f28889i;

    /* renamed from: j, reason: collision with root package name */
    public static Cursor f28890j;

    /* compiled from: CountryListUtil.kt */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f28891a;

        /* renamed from: b, reason: collision with root package name */
        public final String f28892b;

        /* renamed from: c, reason: collision with root package name */
        public final String f28893c;

        public a(String mCountryName, String mCountryIso, String mCountryCode) {
            i.f(mCountryName, "mCountryName");
            i.f(mCountryIso, "mCountryIso");
            i.f(mCountryCode, "mCountryCode");
            this.f28891a = mCountryName;
            this.f28892b = mCountryIso;
            this.f28893c = mCountryCode;
        }

        public final String a() {
            return this.f28893c;
        }

        public final String b() {
            return this.f28892b;
        }

        public final String c() {
            return this.f28891a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (i.b(this.f28891a, aVar.f28891a) && i.b(this.f28892b, aVar.f28892b) && i.b(this.f28893c, aVar.f28893c)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.f28891a.hashCode() * 31) + this.f28892b.hashCode()) * 31) + this.f28893c.hashCode();
        }

        public String toString() {
            return "CountryInfo(mCountryName=" + this.f28891a + ", mCountryIso=" + this.f28892b + ", mCountryCode=" + this.f28893c + ")";
        }
    }

    public static final void a(InputStream inputStream) {
        boolean z10;
        try {
            Log.d("CountryListUtil", "start to copy the mapping file to dir");
            File file = new File(PhoneNoInquireProvider.f28797G);
            if (!file.exists()) {
                String sNameMappingFile = PhoneNoInquireProvider.f28797G;
                i.e(sNameMappingFile, "sNameMappingFile");
                f.a("CountryNameMappingFile.dat", sNameMappingFile);
                return;
            }
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
            try {
                dataInputStream = new DataInputStream(inputStream);
                try {
                    int readInt = dataInputStream.readInt();
                    int readInt2 = dataInputStream.readInt();
                    Log.d("CountryListUtil", "the current version is : " + readInt2 + " ,the file version in assets is " + readInt);
                    if (readInt2 >= readInt) {
                        z10 = false;
                    } else {
                        z10 = true;
                    }
                    q qVar = q.f35511a;
                    kotlin.io.a.a(dataInputStream, null);
                    kotlin.io.a.a(dataInputStream, null);
                    if (z10) {
                        String sNameMappingFile2 = PhoneNoInquireProvider.f28797G;
                        i.e(sNameMappingFile2, "sNameMappingFile");
                        f.a("CountryNameMappingFile.dat", sNameMappingFile2);
                    }
                } finally {
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } finally {
                }
            }
        } catch (IOException e10) {
            Log.e("CountryListUtil", "Exception when copy file to data file directory : " + e10);
        }
    }

    public static final Cursor b(Context context, boolean z10, String str) {
        List Y9;
        int identifier;
        String string;
        List<String> Y10;
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"country_iso", "country_name", "country_code"});
        ArrayList<String> arrayList = f28889i;
        if (arrayList != null) {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                i.c(next);
                Y9 = StringsKt__StringsKt.Y(next, new String[]{"|"}, false, 0, 6, null);
                if (Y9.size() != 2) {
                    LogUtil.a("CountryListUtil", "the iso and code may error,skip");
                } else {
                    String str2 = (String) Y9.get(0);
                    if (i.b("TW", str2) && z10) {
                        identifier = context.getResources().getIdentifier("country_" + str2 + "_CN", "string", context.getPackageName());
                    } else {
                        identifier = context.getResources().getIdentifier("country_" + str2, "string", context.getPackageName());
                    }
                    LogUtil.a("CountryListUtil", "the countryIso is : " + str2 + " the resourceId is : " + identifier);
                    if (identifier == 0) {
                        string = "";
                    } else {
                        string = context.getResources().getString(identifier);
                        i.e(string, "getString(...)");
                    }
                    a c10 = c(string);
                    LogUtil.a("CountryListUtil", "the countryInfo is : " + c10);
                    String c11 = c10.c();
                    String a10 = c10.a();
                    String g10 = g(c11, str2, str, z10);
                    if (!i.b(g10, "") && !i.b(str2, "") && !i.b(a10, "")) {
                        Matcher matcher = f28883c.matcher(c10.b());
                        if (matcher.matches()) {
                            if (i.b(str2, matcher.group(1))) {
                                String str3 = " \n";
                                Y10 = StringsKt__StringsKt.Y(a10, new String[]{"/"}, false, 0, 6, null);
                                StringBuilder sb = new StringBuilder();
                                sb.append("the " + str2 + " has " + Y10.size() + " s code ,so we will add " + Y10.size() + " time the country -> " + g10 + " ");
                                for (String str4 : Y10) {
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append(" ");
                                    sb2.append(str4);
                                    String str5 = str3;
                                    sb2.append(str5);
                                    sb.append(sb2.toString());
                                    if (!i.b(str4, "")) {
                                        matrixCursor.addRow(new String[]{str2, g10, str4});
                                    }
                                    str3 = str5;
                                }
                                String sb3 = sb.toString();
                                i.e(sb3, "toString(...)");
                                LogUtil.a("CountryListUtil", sb3);
                            } else {
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append("country iso " + str2 + " not equal the info's iso :");
                                String group = matcher.group(1);
                                i.e(group, "group(...)");
                                int length = group.length();
                                for (int i10 = 0; i10 < length; i10++) {
                                    sb4.append(group.charAt(i10) + " \n");
                                }
                                String sb5 = sb4.toString();
                                i.e(sb5, "toString(...)");
                                LogUtil.a("CountryListUtil", sb5);
                            }
                        } else {
                            LogUtil.a("CountryListUtil", "the country " + c10.b() + " not equal " + str2);
                        }
                    } else {
                        LogUtil.a("CountryListUtil", "one of displayName,countryIso,countryCode is empty ,we will not add to the cursor");
                    }
                }
            }
            LogUtil.a("CountryListUtil", "the cursor count is : " + matrixCursor.getCount());
        }
        return matrixCursor;
    }

    public static final a c(String str) {
        List<String> Y9;
        Y9 = StringsKt__StringsKt.Y(str, new String[]{"+"}, false, 0, 6, null);
        String str2 = "";
        String str3 = "";
        String str4 = str3;
        for (String str5 : Y9) {
            if (f28883c.matcher(str5).matches()) {
                str3 = str5;
            } else if (f28884d.matcher(str5).matches()) {
                str4 = str5;
            } else {
                str2 = str5;
            }
        }
        LogUtil.a("CountryListUtil", "origin countryStr " + str + " , " + str2 + " iso " + str3 + " code " + str4);
        return new a(str2, str3, str4);
    }

    public static final String e(String str, String str2, String str3, boolean z10) {
        String str4;
        String str5;
        if (z10) {
            str4 = "country_" + str2 + "_in_" + str3 + "_CN";
        } else {
            str4 = "country_" + str2 + "_in_" + str3;
        }
        if (f28887g.get(str4) == null || (str5 = f28887g.get(str4)) == null) {
            str5 = str;
        }
        if (!i.b(str, str5)) {
            LogUtil.a("CountryListUtil", "the name has change because the name need to map ");
        }
        return str5;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x00ed, code lost:
    
        if (r10.size() <= 10) goto L42;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void f(android.content.Context r9, java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 333
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.phonenoareainquire.utils.b.f(android.content.Context, java.lang.String):void");
    }

    public static final String g(String str, String str2, String str3, boolean z10) {
        String str4;
        String e10 = e(str, str2, str3, z10);
        if (z10) {
            str4 = f28888h.get(str + "_CN");
        } else {
            str4 = f28888h.get(str);
        }
        String str5 = str4;
        if (str5 != null) {
            e10 = str5;
        }
        if (!i.b(str, e10)) {
            LogUtil.a("CountryListUtil", "the name of " + str2 + " has change because the name need to map ");
        }
        return e10;
    }

    public static final String h(String name, String currentSysLanguage, boolean z10) {
        String str;
        String str2;
        i.f(name, "name");
        i.f(currentSysLanguage, "currentSysLanguage");
        if (z10) {
            str = f28886f.get("com.oplus.phonenoareainquire_" + name + "_in_" + currentSysLanguage + "_CN");
        } else {
            str = f28886f.get("com.oplus.phonenoareainquire_" + name + "_in_" + currentSysLanguage);
        }
        if (str == null) {
            str = name;
        }
        boolean b10 = i.b(str, name);
        if (PhoneNumberAreaApplication.f28829a) {
            Log.d("CountryListUtil", "isSame = " + b10);
        }
        if (b10) {
            if (z10) {
                str2 = f28886f.get("com.oplus.phonenoareainquire_" + name + "_CN");
            } else {
                str2 = f28886f.get("com.oplus.phonenoareainquire_" + name);
            }
            if (str2 != null) {
                name = str2;
            }
            return name;
        }
        return str;
    }

    public static final void i(Context context, boolean z10, CountDownLatch countDownLatch) {
        int i10;
        i.f(context, "context");
        i.f(countDownLatch, "countDownLatch");
        LogUtil.a("CountryListUtil", "start load data to cursor");
        String b10 = c.b();
        synchronized (b.class) {
            try {
                Cursor cursor = f28890j;
                if (cursor != null) {
                    cursor.close();
                }
                f28890j = null;
                f(context, b10);
                ArrayList<String> arrayList = f28889i;
                if (arrayList != null) {
                    i10 = arrayList.size();
                } else {
                    i10 = 0;
                }
                LogUtil.a("CountryListUtil", "the support country list count " + i10);
                f28890j = b(context, z10, b10);
                f28889i = null;
                countDownLatch.countDown();
                q qVar = q.f35511a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Cursor d() {
        return f28890j;
    }
}
