package com.oplus.phonenoareainquire.utils;

import com.android.incallui.OplusPhoneUtils;
import com.oplus.phonenoareainquire.PhoneNoInquireProvider;
import com.oplus.phonenoareainquire.PhoneNumberAreaApplication;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.i;
import kotlin.text.StringsKt__StringsKt;
import m9.q;

/* compiled from: PortabilityNumbersUtil.kt */
/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f28898a = new e();

    /* renamed from: b, reason: collision with root package name */
    public static HashMap<String, String> f28899b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    public static ArrayList<String> f28900c = new ArrayList<>();

    /* compiled from: PortabilityNumbersUtil.kt */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f28901a;

        /* renamed from: b, reason: collision with root package name */
        public final String f28902b;

        public a(String mLocation, String mCarrier) {
            i.f(mLocation, "mLocation");
            i.f(mCarrier, "mCarrier");
            this.f28901a = mLocation;
            this.f28902b = mCarrier;
        }

        public final String a() {
            return this.f28902b;
        }

        public final String b() {
            return this.f28901a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (i.b(this.f28901a, aVar.f28901a) && i.b(this.f28902b, aVar.f28902b)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.f28901a.hashCode() * 31) + this.f28902b.hashCode();
        }

        public String toString() {
            return "NumberInfo(mLocation=" + this.f28901a + ", mCarrier=" + this.f28902b + ")";
        }
    }

    static {
        try {
            h();
        } catch (Throwable th) {
            LogUtil.b("PortabilityNumbersUtil", "Exception when loadLocationInfoCache " + th);
        }
    }

    public static final a a(String str, long j10) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
            try {
                randomAccessFile.readInt();
                randomAccessFile.readInt();
                int readInt = randomAccessFile.readInt();
                int readInt2 = randomAccessFile.readInt();
                int readInt3 = randomAccessFile.readInt();
                int readInt4 = randomAccessFile.readInt();
                int readInt5 = randomAccessFile.readInt();
                randomAccessFile.readInt();
                int i10 = 0;
                if (f28899b.size() == 0) {
                    String[] strArr = new String[readInt];
                    for (int i11 = 0; i11 < readInt; i11++) {
                        strArr[i11] = "";
                    }
                    for (int i12 = 0; i12 < readInt; i12++) {
                        String readUTF = randomAccessFile.readUTF();
                        i.e(readUTF, "readUTF(...)");
                        strArr[i12] = readUTF;
                    }
                    for (int i13 = 0; i13 < readInt2; i13++) {
                        byte readByte = randomAccessFile.readByte();
                        for (int i14 = 0; i14 < readInt; i14++) {
                            String str2 = ((int) readByte) + "_" + d(strArr[i14]);
                            String readUTF2 = randomAccessFile.readUTF();
                            HashMap<String, String> hashMap = f28899b;
                            i.c(readUTF2);
                            hashMap.put(str2, readUTF2);
                        }
                    }
                }
                while (i10 <= readInt4) {
                    int i15 = (readInt4 + i10) / 2;
                    randomAccessFile.seek((i15 * readInt5) + readInt3);
                    if (randomAccessFile.getFilePointer() >= randomAccessFile.length()) {
                        a aVar = new a(OplusPhoneUtils.DeviceState.UNLOCK_DEVICE, OplusPhoneUtils.DeviceState.UNLOCK_DEVICE);
                        kotlin.io.a.a(randomAccessFile, null);
                        return aVar;
                    }
                    long readLong = randomAccessFile.readLong();
                    if (j10 > readLong) {
                        i10 = i15 + 1;
                    } else {
                        if (j10 == readLong) {
                            a aVar2 = new a(String.valueOf((int) randomAccessFile.readShort()), String.valueOf((int) randomAccessFile.readByte()));
                            kotlin.io.a.a(randomAccessFile, null);
                            return aVar2;
                        }
                        readInt4 = i15 - 1;
                    }
                }
                a aVar3 = new a(OplusPhoneUtils.DeviceState.UNLOCK_DEVICE, OplusPhoneUtils.DeviceState.UNLOCK_DEVICE);
                kotlin.io.a.a(randomAccessFile, null);
                return aVar3;
            } finally {
            }
        } catch (IOException e10) {
            LogUtil.b("PortabilityNumbersUtil", "Exception when binary search : " + e10);
            return new a(OplusPhoneUtils.DeviceState.UNLOCK_DEVICE, OplusPhoneUtils.DeviceState.UNLOCK_DEVICE);
        } catch (NumberFormatException e11) {
            LogUtil.b("PortabilityNumbersUtil", "Exception when binary search = " + e11);
            return new a(OplusPhoneUtils.DeviceState.UNLOCK_DEVICE, OplusPhoneUtils.DeviceState.UNLOCK_DEVICE);
        }
    }

    public static final void b() {
        f28900c.clear();
        f28899b.clear();
    }

    public static final void c(InputStream input) {
        boolean z10;
        i.f(input, "input");
        try {
            File file = new File(PhoneNoInquireProvider.f28796F);
            if (!file.exists()) {
                String sPortedNumberFile = PhoneNoInquireProvider.f28796F;
                i.e(sPortedNumberFile, "sPortedNumberFile");
                f.a("PortabilityNumberData.dat", sPortedNumberFile);
                return;
            }
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
            try {
                dataInputStream = new DataInputStream(input);
                try {
                    int readInt = dataInputStream.readInt();
                    int readInt2 = dataInputStream.readInt();
                    LogUtil.a("PortabilityNumbersUtil", "the current version is : " + readInt2 + " ,the file version in assets is " + readInt);
                    if (readInt2 >= readInt) {
                        z10 = false;
                    } else {
                        z10 = true;
                    }
                    q qVar = q.f35511a;
                    kotlin.io.a.a(dataInputStream, null);
                    kotlin.io.a.a(dataInputStream, null);
                    if (z10) {
                        String sPortedNumberFile2 = PhoneNoInquireProvider.f28796F;
                        i.e(sPortedNumberFile2, "sPortedNumberFile");
                        f.a("PortabilityNumberData.dat", sPortedNumberFile2);
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
            LogUtil.b("PortabilityNumbersUtil", "Exception when copy file to data file directory : " + e10);
        }
    }

    public static final String d(String input) {
        i.f(input, "input");
        StringBuilder sb = new StringBuilder();
        int length = input.length();
        for (int i10 = 0; i10 < length; i10++) {
            char charAt = input.charAt(i10);
            if (('a' <= charAt && charAt < '{') || ('A' <= charAt && charAt < '[')) {
                sb.append(charAt);
            }
        }
        String sb2 = sb.toString();
        i.e(sb2, "toString(...)");
        return sb2;
    }

    public static final String e(a aVar, String str) {
        String str2;
        if (i.b(aVar.a(), OplusPhoneUtils.DeviceState.UNLOCK_DEVICE)) {
            return "";
        }
        String a10 = aVar.a();
        if (c.c(str)) {
            str2 = a10 + "_EN";
        } else {
            String upperCase = str.toUpperCase();
            i.e(upperCase, "toUpperCase(...)");
            str2 = a10 + "_" + upperCase;
        }
        if (f28899b.get(str2) == null) {
            String str3 = a10 + "_CN";
            if (f28899b.get(str3) == null) {
                return "";
            }
            return String.valueOf(f28899b.get(str3));
        }
        return String.valueOf(f28899b.get(str2));
    }

    public static final String f(a aVar) {
        if (i.b(aVar.b(), OplusPhoneUtils.DeviceState.UNLOCK_DEVICE)) {
            return "";
        }
        if (Integer.parseInt(aVar.b()) - 1 >= f28900c.size()) {
            LogUtil.a("PortabilityNumbersUtil", "there is no city indexed " + aVar.b());
            return "";
        }
        String str = f28900c.get(Integer.parseInt(aVar.b()) - 1);
        i.e(str, "get(...)");
        return str;
    }

    public static final a g(long j10, String systemLanguage) {
        i.f(systemLanguage, "systemLanguage");
        if (String.valueOf(j10).length() != 11) {
            return new a("", "");
        }
        try {
            String sPortedNumberFile = PhoneNoInquireProvider.f28796F;
            i.e(sPortedNumberFile, "sPortedNumberFile");
            a a10 = a(sPortedNumberFile, j10);
            return new a(f(a10), e(a10, systemLanguage));
        } catch (IOException e10) {
            LogUtil.b("PortabilityNumbersUtil", "IOException = " + e10);
            return new a("", "");
        } catch (NumberFormatException e11) {
            LogUtil.b("PortabilityNumbersUtil", "NumberFormatException = " + e11);
            return new a("", "");
        }
    }

    public static final void h() {
        CharSequence j02;
        List Y9;
        CharSequence j03;
        List Y10;
        CharSequence j04;
        String a10 = c.a();
        f28900c.clear();
        InputStreamReader inputStreamReader = new InputStreamReader(PhoneNumberAreaApplication.b("Multi_Language_Table.txt", PhoneNoInquireProvider.f28795E));
        try {
            int i10 = 1;
            int i11 = 0;
            for (String str : TextStreamsKt.c(inputStreamReader)) {
                j02 = StringsKt__StringsKt.j0(str);
                if (!i.b(j02.toString(), "")) {
                    if (i11 == 0) {
                        Y9 = StringsKt__StringsKt.Y(str, new String[]{"\t"}, false, 0, 6, null);
                        String[] strArr = (String[]) Y9.toArray(new String[0]);
                        int length = strArr.length;
                        int i12 = 0;
                        while (true) {
                            if (i12 >= length) {
                                break;
                            }
                            j03 = StringsKt__StringsKt.j0(strArr[i12]);
                            String obj = j03.toString();
                            String upperCase = a10.toUpperCase();
                            i.e(upperCase, "toUpperCase(...)");
                            if (i.b(obj, upperCase)) {
                                i10 = i12;
                                break;
                            }
                            i12++;
                        }
                        i11++;
                    } else {
                        Y10 = StringsKt__StringsKt.Y(str, new String[]{"\t"}, false, 0, 6, null);
                        String[] strArr2 = (String[]) Y10.toArray(new String[0]);
                        if (i10 >= strArr2.length) {
                            LogUtil.a("PortabilityNumbersUtil", "the language index is : " + i10 + " , the citys size is : " + strArr2.length);
                        } else if (f28900c.size() >= 500) {
                            kotlin.io.a.a(inputStreamReader, null);
                            return;
                        } else {
                            ArrayList<String> arrayList = f28900c;
                            j04 = StringsKt__StringsKt.j0(strArr2[i10]);
                            arrayList.add(j04.toString());
                        }
                    }
                }
            }
            q qVar = q.f35511a;
            kotlin.io.a.a(inputStreamReader, null);
        } finally {
        }
    }
}
