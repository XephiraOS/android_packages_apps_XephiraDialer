package com.bumptech.glide.load.data;

import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.data.d;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import s3.C1532c;
import s3.C1536g;

/* compiled from: HttpUrlFetcher.java */
/* loaded from: classes.dex */
public class j implements d<InputStream> {

    /* renamed from: g, reason: collision with root package name */
    public static final b f19425g = new a();

    /* renamed from: a, reason: collision with root package name */
    public final d3.h f19426a;

    /* renamed from: b, reason: collision with root package name */
    public final int f19427b;

    /* renamed from: c, reason: collision with root package name */
    public final b f19428c;

    /* renamed from: d, reason: collision with root package name */
    public HttpURLConnection f19429d;

    /* renamed from: e, reason: collision with root package name */
    public InputStream f19430e;

    /* renamed from: f, reason: collision with root package name */
    public volatile boolean f19431f;

    /* compiled from: HttpUrlFetcher.java */
    /* loaded from: classes.dex */
    public static class a implements b {
        @Override // com.bumptech.glide.load.data.j.b
        public HttpURLConnection a(URL url) {
            return (HttpURLConnection) url.openConnection();
        }
    }

    /* compiled from: HttpUrlFetcher.java */
    /* loaded from: classes.dex */
    public interface b {
        HttpURLConnection a(URL url);
    }

    public j(d3.h hVar, int i10) {
        this(hVar, i10, f19425g);
    }

    public static int f(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getResponseCode();
        } catch (IOException e10) {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                Log.d("HttpUrlFetcher", "Failed to get a response code", e10);
                return -1;
            }
            return -1;
        }
    }

    public static boolean h(int i10) {
        if (i10 / 100 == 2) {
            return true;
        }
        return false;
    }

    public static boolean i(int i10) {
        if (i10 / 100 == 3) {
            return true;
        }
        return false;
    }

    @Override // com.bumptech.glide.load.data.d
    public Class<InputStream> a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.d
    public void b() {
        InputStream inputStream = this.f19430e;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.f19429d;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.f19429d = null;
    }

    public final HttpURLConnection c(URL url, Map<String, String> map) {
        try {
            HttpURLConnection a10 = this.f19428c.a(url);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                a10.addRequestProperty(entry.getKey(), entry.getValue());
            }
            a10.setConnectTimeout(this.f19427b);
            a10.setReadTimeout(this.f19427b);
            a10.setUseCaches(false);
            a10.setDoInput(true);
            a10.setInstanceFollowRedirects(false);
            return a10;
        } catch (IOException e10) {
            throw new HttpException("URL.openConnection threw", 0, e10);
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public void cancel() {
        this.f19431f = true;
    }

    @Override // com.bumptech.glide.load.data.d
    public DataSource d() {
        return DataSource.REMOTE;
    }

    @Override // com.bumptech.glide.load.data.d
    public void e(Priority priority, d.a<? super InputStream> aVar) {
        StringBuilder sb;
        long b10 = C1536g.b();
        try {
            try {
                aVar.f(j(this.f19426a.h(), 0, null, this.f19426a.e()));
            } catch (IOException e10) {
                if (Log.isLoggable("HttpUrlFetcher", 3)) {
                    Log.d("HttpUrlFetcher", "Failed to load data for url", e10);
                }
                aVar.c(e10);
                if (Log.isLoggable("HttpUrlFetcher", 2)) {
                    sb = new StringBuilder();
                } else {
                    return;
                }
            }
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                sb = new StringBuilder();
                sb.append("Finished http url fetcher fetch in ");
                sb.append(C1536g.a(b10));
                Log.v("HttpUrlFetcher", sb.toString());
            }
        } catch (Throwable th) {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + C1536g.a(b10));
            }
            throw th;
        }
    }

    public final InputStream g(HttpURLConnection httpURLConnection) {
        try {
            if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
                this.f19430e = C1532c.c(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
            } else {
                if (Log.isLoggable("HttpUrlFetcher", 3)) {
                    Log.d("HttpUrlFetcher", "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
                }
                this.f19430e = httpURLConnection.getInputStream();
            }
            return this.f19430e;
        } catch (IOException e10) {
            throw new HttpException("Failed to obtain InputStream", f(httpURLConnection), e10);
        }
    }

    public final InputStream j(URL url, int i10, URL url2, Map<String, String> map) {
        if (i10 < 5) {
            if (url2 != null) {
                try {
                    if (url.toURI().equals(url2.toURI())) {
                        throw new HttpException("In re-direct loop", -1);
                    }
                } catch (URISyntaxException unused) {
                }
            }
            HttpURLConnection c10 = c(url, map);
            this.f19429d = c10;
            try {
                c10.connect();
                this.f19430e = this.f19429d.getInputStream();
                if (this.f19431f) {
                    return null;
                }
                int f10 = f(this.f19429d);
                if (h(f10)) {
                    return g(this.f19429d);
                }
                if (i(f10)) {
                    String headerField = this.f19429d.getHeaderField("Location");
                    if (!TextUtils.isEmpty(headerField)) {
                        try {
                            URL url3 = new URL(url, headerField);
                            b();
                            return j(url3, i10 + 1, url, map);
                        } catch (MalformedURLException e10) {
                            throw new HttpException("Bad redirect url: " + headerField, f10, e10);
                        }
                    }
                    throw new HttpException("Received empty or null redirect url", f10);
                }
                if (f10 == -1) {
                    throw new HttpException(f10);
                }
                try {
                    throw new HttpException(this.f19429d.getResponseMessage(), f10);
                } catch (IOException e11) {
                    throw new HttpException("Failed to get a response message", f10, e11);
                }
            } catch (IOException e12) {
                throw new HttpException("Failed to connect or obtain data", f(this.f19429d), e12);
            }
        }
        throw new HttpException("Too many (> 5) redirects!", -1);
    }

    public j(d3.h hVar, int i10, b bVar) {
        this.f19426a = hVar;
        this.f19427b = i10;
        this.f19428c = bVar;
    }
}
