package T2;

import android.os.SystemClock;
import com.android.volley.Request;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* compiled from: BasicNetwork.java */
/* loaded from: classes.dex */
public class b implements S2.d {

    /* renamed from: a, reason: collision with root package name */
    @Deprecated
    public final g f3709a;

    /* renamed from: b, reason: collision with root package name */
    public final a f3710b;

    /* renamed from: c, reason: collision with root package name */
    public final c f3711c;

    public b(a aVar) {
        this(aVar, new c(4096));
    }

    @Override // S2.d
    public S2.e a(Request<?> request) {
        IOException iOException;
        f fVar;
        byte[] bArr;
        f a10;
        int d10;
        List<S2.c> c10;
        byte[] bArr2;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        while (true) {
            Collections.emptyList();
            try {
                a10 = this.f3710b.a(request, e.c(request.l()));
                try {
                    d10 = a10.d();
                    c10 = a10.c();
                    break;
                } catch (IOException e10) {
                    bArr = null;
                    fVar = a10;
                    iOException = e10;
                }
            } catch (IOException e11) {
                iOException = e11;
                fVar = null;
                bArr = null;
            }
            i.a(request, i.e(request, iOException, elapsedRealtime, fVar, bArr));
        }
        if (d10 == 304) {
            return i.b(request, SystemClock.elapsedRealtime() - elapsedRealtime, c10);
        }
        InputStream a11 = a10.a();
        if (a11 != null) {
            bArr2 = i.c(a11, a10.b(), this.f3711c);
        } else {
            bArr2 = new byte[0];
        }
        i.d(SystemClock.elapsedRealtime() - elapsedRealtime, request, bArr2, d10);
        if (d10 >= 200 && d10 <= 299) {
            return new S2.e(d10, bArr2, false, SystemClock.elapsedRealtime() - elapsedRealtime, c10);
        }
        throw new IOException();
    }

    public b(a aVar, c cVar) {
        this.f3710b = aVar;
        this.f3709a = aVar;
        this.f3711c = cVar;
    }
}
