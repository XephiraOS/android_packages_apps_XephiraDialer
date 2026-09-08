package T2;

import android.os.SystemClock;
import com.android.contacts.framework.virtualsupport.utils.GrpcUtils;
import com.android.volley.AuthFailureError;
import com.android.volley.ClientError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.a;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.List;

/* compiled from: NetworkUtility.java */
/* loaded from: classes.dex */
public final class i {

    /* compiled from: NetworkUtility.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f3738a;

        /* renamed from: b, reason: collision with root package name */
        public final VolleyError f3739b;

        public b(String str, VolleyError volleyError) {
            this.f3738a = str;
            this.f3739b = volleyError;
        }
    }

    public static void a(Request<?> request, b bVar) {
        S2.h v10 = request.v();
        int w10 = request.w();
        try {
            v10.a(bVar.f3739b);
            request.b(String.format("%s-retry [timeout=%s]", bVar.f3738a, Integer.valueOf(w10)));
        } catch (VolleyError e10) {
            request.b(String.format("%s-timeout-giveup [timeout=%s]", bVar.f3738a, Integer.valueOf(w10)));
            throw e10;
        }
    }

    public static S2.e b(Request<?> request, long j10, List<S2.c> list) {
        a.C0186a l10 = request.l();
        if (l10 == null) {
            return new S2.e(304, (byte[]) null, true, j10, list);
        }
        return new S2.e(304, l10.f19225a, true, j10, e.a(list, l10));
    }

    public static byte[] c(InputStream inputStream, int i10, c cVar) {
        byte[] bArr;
        j jVar = new j(cVar, i10);
        try {
            bArr = cVar.a(1024);
            while (true) {
                try {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    jVar.write(bArr, 0, read);
                } catch (Throwable th) {
                    th = th;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused) {
                            com.android.volley.e.e("Error occurred when closing InputStream", new Object[0]);
                        }
                    }
                    cVar.b(bArr);
                    jVar.close();
                    throw th;
                }
            }
            byte[] byteArray = jVar.toByteArray();
            try {
                inputStream.close();
            } catch (IOException unused2) {
                com.android.volley.e.e("Error occurred when closing InputStream", new Object[0]);
            }
            cVar.b(bArr);
            jVar.close();
            return byteArray;
        } catch (Throwable th2) {
            th = th2;
            bArr = null;
        }
    }

    public static void d(long j10, Request<?> request, byte[] bArr, int i10) {
        Object obj;
        if (com.android.volley.e.f19252b || j10 > GrpcUtils.CREATE_CHANNEL_TIME_OUT) {
            Long valueOf = Long.valueOf(j10);
            if (bArr != null) {
                obj = Integer.valueOf(bArr.length);
            } else {
                obj = "null";
            }
            com.android.volley.e.b("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", request, valueOf, obj, Integer.valueOf(i10), Integer.valueOf(request.v().c()));
        }
    }

    public static b e(Request<?> request, IOException iOException, long j10, f fVar, byte[] bArr) {
        if (iOException instanceof SocketTimeoutException) {
            return new b("socket", new TimeoutError());
        }
        if (!(iOException instanceof MalformedURLException)) {
            if (fVar != null) {
                int d10 = fVar.d();
                com.android.volley.e.c("Unexpected response code %d for %s", Integer.valueOf(d10), request.y());
                if (bArr != null) {
                    S2.e eVar = new S2.e(d10, bArr, false, SystemClock.elapsedRealtime() - j10, fVar.c());
                    if (d10 != 401 && d10 != 403) {
                        if (d10 >= 400 && d10 <= 499) {
                            throw new ClientError(eVar);
                        }
                        if (d10 >= 500 && d10 <= 599 && request.O()) {
                            return new b("server", new ServerError(eVar));
                        }
                        throw new ServerError(eVar);
                    }
                    return new b("auth", new AuthFailureError(eVar));
                }
                return new b("network", new NetworkError());
            }
            if (request.N()) {
                return new b("connection", new NoConnectionError());
            }
            throw new NoConnectionError(iOException);
        }
        throw new RuntimeException("Bad URL " + request.y(), iOException);
    }
}
