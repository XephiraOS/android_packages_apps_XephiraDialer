package T2;

import com.android.volley.Request;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: HurlStack.java */
/* loaded from: classes.dex */
public class h extends T2.a {

    /* renamed from: a, reason: collision with root package name */
    public final SSLSocketFactory f3736a;

    /* compiled from: HurlStack.java */
    /* loaded from: classes.dex */
    public static class a extends FilterInputStream {

        /* renamed from: a, reason: collision with root package name */
        public final HttpURLConnection f3737a;

        public a(HttpURLConnection httpURLConnection) {
            super(h.j(httpURLConnection));
            this.f3737a = httpURLConnection;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            super.close();
            this.f3737a.disconnect();
        }
    }

    /* compiled from: HurlStack.java */
    /* loaded from: classes.dex */
    public interface b {
    }

    public h() {
        this(null);
    }

    public static List<S2.c> e(Map<String, List<String>> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getKey() != null) {
                Iterator<String> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    arrayList.add(new S2.c(entry.getKey(), it.next()));
                }
            }
        }
        return arrayList;
    }

    public static boolean i(int i10, int i11) {
        if (i10 != 4 && ((100 > i11 || i11 >= 200) && i11 != 204 && i11 != 304)) {
            return true;
        }
        return false;
    }

    public static InputStream j(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getInputStream();
        } catch (IOException unused) {
            return httpURLConnection.getErrorStream();
        }
    }

    @Override // T2.a
    public f a(Request<?> request, Map<String, String> map) {
        String y10 = request.y();
        HashMap hashMap = new HashMap();
        hashMap.putAll(map);
        hashMap.putAll(request.n());
        HttpURLConnection k10 = k(new URL(y10), request);
        try {
            for (String str : hashMap.keySet()) {
                k10.setRequestProperty(str, (String) hashMap.get(str));
            }
            l(k10, request);
            int responseCode = k10.getResponseCode();
            if (responseCode != -1) {
                if (!i(request.o(), responseCode)) {
                    f fVar = new f(responseCode, e(k10.getHeaderFields()));
                    k10.disconnect();
                    return fVar;
                }
                return new f(responseCode, e(k10.getHeaderFields()), k10.getContentLength(), g(request, k10));
            }
            throw new IOException("Could not retrieve response code from HttpUrlConnection.");
        } catch (Throwable th) {
            if (0 == 0) {
                k10.disconnect();
            }
            throw th;
        }
    }

    public final void c(HttpURLConnection httpURLConnection, Request<?> request, byte[] bArr) {
        httpURLConnection.setDoOutput(true);
        if (!httpURLConnection.getRequestProperties().containsKey("Content-Type")) {
            httpURLConnection.setRequestProperty("Content-Type", request.k());
        }
        DataOutputStream dataOutputStream = new DataOutputStream(h(request, httpURLConnection, bArr.length));
        dataOutputStream.write(bArr);
        dataOutputStream.close();
    }

    public final void d(HttpURLConnection httpURLConnection, Request<?> request) {
        byte[] j10 = request.j();
        if (j10 != null) {
            c(httpURLConnection, request, j10);
        }
    }

    public HttpURLConnection f(URL url) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        return httpURLConnection;
    }

    public InputStream g(Request<?> request, HttpURLConnection httpURLConnection) {
        return new a(httpURLConnection);
    }

    public OutputStream h(Request<?> request, HttpURLConnection httpURLConnection, int i10) {
        return httpURLConnection.getOutputStream();
    }

    public final HttpURLConnection k(URL url, Request<?> request) {
        SSLSocketFactory sSLSocketFactory;
        HttpURLConnection f10 = f(url);
        int w10 = request.w();
        f10.setConnectTimeout(w10);
        f10.setReadTimeout(w10);
        f10.setUseCaches(false);
        f10.setDoInput(true);
        if ("https".equals(url.getProtocol()) && (sSLSocketFactory = this.f3736a) != null) {
            ((HttpsURLConnection) f10).setSSLSocketFactory(sSLSocketFactory);
        }
        return f10;
    }

    public void l(HttpURLConnection httpURLConnection, Request<?> request) {
        switch (request.o()) {
            case -1:
                byte[] r10 = request.r();
                if (r10 != null) {
                    httpURLConnection.setRequestMethod("POST");
                    c(httpURLConnection, request, r10);
                    return;
                }
                return;
            case 0:
                httpURLConnection.setRequestMethod("GET");
                return;
            case 1:
                httpURLConnection.setRequestMethod("POST");
                d(httpURLConnection, request);
                return;
            case 2:
                httpURLConnection.setRequestMethod("PUT");
                d(httpURLConnection, request);
                return;
            case 3:
                httpURLConnection.setRequestMethod("DELETE");
                return;
            case 4:
                httpURLConnection.setRequestMethod("HEAD");
                return;
            case 5:
                httpURLConnection.setRequestMethod("OPTIONS");
                return;
            case 6:
                httpURLConnection.setRequestMethod("TRACE");
                return;
            case 7:
                httpURLConnection.setRequestMethod("PATCH");
                d(httpURLConnection, request);
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    public h(b bVar) {
        this(bVar, null);
    }

    public h(b bVar, SSLSocketFactory sSLSocketFactory) {
        this.f3736a = sSLSocketFactory;
    }
}
