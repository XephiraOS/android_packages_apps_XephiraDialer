package H3;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;

/* compiled from: CSVReader.java */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public int f1272a;

    /* renamed from: b, reason: collision with root package name */
    public String f1273b;

    /* renamed from: c, reason: collision with root package name */
    public BufferedReader f1274c;

    /* renamed from: d, reason: collision with root package name */
    public c f1275d;

    public a(String str) {
        this.f1272a = 0;
        this.f1273b = null;
        c cVar = new c(str);
        this.f1275d = cVar;
        this.f1274c = cVar.b();
        String k10 = k();
        this.f1273b = k10;
        this.f1272a = d(k10);
        if (H7.a.b()) {
            H7.b.b("CSVReader", "CSVReader mTitle : " + this.f1273b);
        }
    }

    public static boolean a(String str) {
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 != str.length(); i12++) {
            if (str.charAt(i12) == '\"') {
                i11++;
                if (i12 < str.length() - 1 && str.charAt(i12 + 1) == '\"') {
                    i10++;
                }
            }
        }
        if (i10 == 0) {
            if (i11 % 2 != 0) {
                return false;
            }
            return true;
        }
        if (i11 % 2 != 0 || i10 % 2 != 0) {
            return false;
        }
        return true;
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str != null && str.length() > 2) {
            if (str.startsWith("\"\"") && str.endsWith("\"\"")) {
                if (str.length() - 2 > 2) {
                    return str.substring(2, str.length() - 2);
                }
                return str;
            }
            if (str.startsWith("\"") && str.endsWith("\"") && str.length() - 1 > 1) {
                return str.substring(1, str.length() - 1);
            }
            return str;
        }
        return str;
    }

    public static int d(String str) {
        if (str == null) {
            return 0;
        }
        int i10 = 0;
        for (int i11 = 0; i11 != str.length(); i11++) {
            if (str.charAt(i11) == ',') {
                i10++;
            }
        }
        return i10 + 1;
    }

    public void b() {
        this.f1275d.a();
    }

    public long e() {
        return this.f1275d.e();
    }

    public String[] f() {
        String k10 = k();
        while (k10 != null && k10.length() == 0) {
            k10 = k();
        }
        String str = k10;
        while (k10 != null && !a(str)) {
            k10 = k();
            if (k10 != null) {
                str = str + " ::: " + k10;
            }
        }
        return j(str);
    }

    public String[] g() {
        return j(this.f1273b);
    }

    public String h() {
        return this.f1273b;
    }

    public boolean i() {
        try {
            this.f1275d.g();
            BufferedReader b10 = this.f1275d.b();
            this.f1274c = b10;
            b10.readLine();
            return true;
        } catch (IOException e10) {
            H7.b.c("CSVReader", "Exception e: " + e10);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x011b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String[] j(java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 316
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: H3.a.j(java.lang.String):java.lang.String[]");
    }

    public final String k() {
        BufferedReader bufferedReader = this.f1274c;
        if (bufferedReader == null) {
            return null;
        }
        try {
            return bufferedReader.readLine();
        } catch (IOException e10) {
            H7.b.c("CSVReader", "Exception e: " + e10);
            return null;
        }
    }
}
