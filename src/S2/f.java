package S2;

import android.os.Handler;
import android.os.Looper;
import com.android.volley.Request;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: RequestQueue.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicInteger f3396a;

    /* renamed from: b, reason: collision with root package name */
    public final Set<Request<?>> f3397b;

    /* renamed from: c, reason: collision with root package name */
    public final PriorityBlockingQueue<Request<?>> f3398c;

    /* renamed from: d, reason: collision with root package name */
    public final PriorityBlockingQueue<Request<?>> f3399d;

    /* renamed from: e, reason: collision with root package name */
    public final com.android.volley.a f3400e;

    /* renamed from: f, reason: collision with root package name */
    public final d f3401f;

    /* renamed from: g, reason: collision with root package name */
    public final g f3402g;

    /* renamed from: h, reason: collision with root package name */
    public final com.android.volley.c[] f3403h;

    /* renamed from: i, reason: collision with root package name */
    public com.android.volley.b f3404i;

    /* renamed from: j, reason: collision with root package name */
    public final List<b> f3405j;

    /* renamed from: k, reason: collision with root package name */
    public final List<a> f3406k;

    /* compiled from: RequestQueue.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(Request<?> request, int i10);
    }

    /* compiled from: RequestQueue.java */
    @Deprecated
    /* loaded from: classes.dex */
    public interface b<T> {
        void a(Request<T> request);
    }

    public f(com.android.volley.a aVar, d dVar, int i10, g gVar) {
        this.f3396a = new AtomicInteger();
        this.f3397b = new HashSet();
        this.f3398c = new PriorityBlockingQueue<>();
        this.f3399d = new PriorityBlockingQueue<>();
        this.f3405j = new ArrayList();
        this.f3406k = new ArrayList();
        this.f3400e = aVar;
        this.f3401f = dVar;
        this.f3403h = new com.android.volley.c[i10];
        this.f3402g = gVar;
    }

    public <T> Request<T> a(Request<T> request) {
        request.J(this);
        synchronized (this.f3397b) {
            this.f3397b.add(request);
        }
        request.L(d());
        request.b("add-to-queue");
        e(request, 0);
        b(request);
        return request;
    }

    public <T> void b(Request<T> request) {
        if (!request.M()) {
            f(request);
        } else {
            this.f3398c.add(request);
        }
    }

    public <T> void c(Request<T> request) {
        synchronized (this.f3397b) {
            this.f3397b.remove(request);
        }
        synchronized (this.f3405j) {
            try {
                Iterator<b> it = this.f3405j.iterator();
                while (it.hasNext()) {
                    it.next().a(request);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        e(request, 5);
    }

    public int d() {
        return this.f3396a.incrementAndGet();
    }

    public void e(Request<?> request, int i10) {
        synchronized (this.f3406k) {
            try {
                Iterator<a> it = this.f3406k.iterator();
                while (it.hasNext()) {
                    it.next().a(request, i10);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public <T> void f(Request<T> request) {
        this.f3399d.add(request);
    }

    public void g() {
        h();
        com.android.volley.b bVar = new com.android.volley.b(this.f3398c, this.f3399d, this.f3400e, this.f3402g);
        this.f3404i = bVar;
        bVar.start();
        for (int i10 = 0; i10 < this.f3403h.length; i10++) {
            com.android.volley.c cVar = new com.android.volley.c(this.f3399d, this.f3401f, this.f3400e, this.f3402g);
            this.f3403h[i10] = cVar;
            cVar.start();
        }
    }

    public void h() {
        com.android.volley.b bVar = this.f3404i;
        if (bVar != null) {
            bVar.d();
        }
        for (com.android.volley.c cVar : this.f3403h) {
            if (cVar != null) {
                cVar.e();
            }
        }
    }

    public f(com.android.volley.a aVar, d dVar, int i10) {
        this(aVar, dVar, i10, new S2.b(new Handler(Looper.getMainLooper())));
    }

    public f(com.android.volley.a aVar, d dVar) {
        this(aVar, dVar, 4);
    }
}
