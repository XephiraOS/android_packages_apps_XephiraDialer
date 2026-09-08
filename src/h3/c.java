package H3;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/* compiled from: TextParser.java */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public long f1278a;

    /* renamed from: b, reason: collision with root package name */
    public String f1279b;

    /* renamed from: c, reason: collision with root package name */
    public BufferedReader f1280c;

    public c(String str) {
        this.f1279b = str;
        f();
    }

    public static String c(File file) {
        return b.a(file.getAbsolutePath());
    }

    public static int d(String str) {
        if (!str.equals("UTF-16LE") && !str.equals("UTF-16BE")) {
            if (str.equals("UTF-8") && b.f1276a) {
                return 3;
            }
            str.equals("GBK");
            return 0;
        }
        return 2;
    }

    public void a() {
        BufferedReader bufferedReader = this.f1280c;
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException e10) {
                H7.b.c("TextParser", "Exception e: " + e10);
            }
        }
    }

    public BufferedReader b() {
        return this.f1280c;
    }

    public long e() {
        return this.f1278a;
    }

    public void f() {
        String c10;
        a();
        this.f1278a = 0L;
        if (TextUtils.isEmpty(this.f1279b)) {
            return;
        }
        if (this.f1279b.contains("file://")) {
            this.f1279b = this.f1279b.replace("file://", "");
        }
        File file = new File(this.f1279b);
        if (!file.exists()) {
            H7.b.c("TextParser", "Not exist the File : " + this.f1279b);
            return;
        }
        long length = file.length();
        this.f1278a = length;
        if (length == 0 || (c10 = c(file)) == null) {
            return;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            int d10 = d(c10);
            if (d10 > 0) {
                fileInputStream.skip(d10);
            }
            try {
                this.f1280c = new BufferedReader(new InputStreamReader(fileInputStream, c10));
            } catch (UnsupportedEncodingException e10) {
                H7.b.c("TextParser", "Exception e: " + e10);
            }
        } catch (FileNotFoundException e11) {
            H7.b.c("TextParser", "Exception e: " + e11);
        } catch (IOException e12) {
            H7.b.c("TextParser", "Exception e: " + e12);
        }
    }

    public void g() {
        f();
    }
}
