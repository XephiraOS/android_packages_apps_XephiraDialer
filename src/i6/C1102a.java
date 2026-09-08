package i6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/* compiled from: DefaultEffectiveFetchResult.java */
/* renamed from: i6.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1102a implements c {

    /* renamed from: a, reason: collision with root package name */
    public final HttpURLConnection f32189a;

    public C1102a(HttpURLConnection httpURLConnection) {
        this.f32189a = httpURLConnection;
    }

    @Override // i6.c
    public String J() {
        return this.f32189a.getContentType();
    }

    @Override // i6.c
    public String N() {
        try {
            if (d0()) {
                return null;
            }
            return "Unable to fetch " + this.f32189a.getURL() + ". Failed with " + this.f32189a.getResponseCode() + "\n" + a(this.f32189a);
        } catch (IOException e10) {
            l6.e.d("get error failed ", e10);
            return e10.getMessage();
        }
    }

    @Override // i6.c
    public InputStream Q() {
        return this.f32189a.getInputStream();
    }

    public final String a(HttpURLConnection httpURLConnection) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                    sb.append('\n');
                } else {
                    try {
                        break;
                    } catch (Exception unused) {
                    }
                }
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Exception unused2) {
                }
                throw th;
            }
        }
        bufferedReader.close();
        return sb.toString();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f32189a.disconnect();
    }

    @Override // i6.c
    public boolean d0() {
        try {
            if (this.f32189a.getResponseCode() / 100 != 2) {
                return false;
            }
            return true;
        } catch (IOException unused) {
            return false;
        }
    }
}
