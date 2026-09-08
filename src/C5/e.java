package C5;

import com.heytap.epona.Request;
import com.heytap.epona.Response;
import com.heytap.epona.interceptor.CallIPCComponentInterceptor;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: RealCall.java */
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public final com.heytap.epona.g f368a;

    /* renamed from: b, reason: collision with root package name */
    public final Request f369b;

    /* renamed from: c, reason: collision with root package name */
    public AtomicBoolean f370c = new AtomicBoolean(false);

    /* compiled from: RealCall.java */
    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final com.heytap.epona.a f371a;

        public b(com.heytap.epona.a aVar) {
            this.f371a = aVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            boolean z10 = false;
            z10 = false;
            z10 = false;
            try {
                try {
                    e.this.f(this.f371a, true);
                    com.heytap.epona.g gVar = e.this.f368a;
                    gVar.f(this, true);
                    z10 = gVar;
                } catch (Exception e10) {
                    H5.a.c("RealCall", "AsyncCall run failed and exception is %s", e10.toString());
                    this.f371a.O(Response.d());
                    e.this.f368a.f(this, false);
                }
            } catch (Throwable th) {
                e.this.f368a.f(this, z10);
                throw th;
            }
        }
    }

    /* compiled from: RealCall.java */
    /* loaded from: classes3.dex */
    public static class c implements com.heytap.epona.a {

        /* renamed from: a, reason: collision with root package name */
        public Response f373a;

        public c() {
            this.f373a = null;
        }

        @Override // com.heytap.epona.a
        public void O(Response response) {
            this.f373a = response;
        }

        public Response a() {
            return this.f373a;
        }
    }

    public e(com.heytap.epona.g gVar, Request request) {
        this.f368a = gVar;
        this.f369b = request;
    }

    public static e e(com.heytap.epona.g gVar, Request request) {
        return new e(gVar, request);
    }

    public void c(com.heytap.epona.a aVar) {
        b bVar = new b(aVar);
        if (this.f370c.getAndSet(true)) {
            H5.a.f("RealCall", "asyncExecute has been executed", new Object[0]);
            aVar.O(Response.d());
        }
        this.f368a.b(bVar);
    }

    public Response d() {
        if (this.f370c.getAndSet(true)) {
            H5.a.f("RealCall", "execute has been executed", new Object[0]);
            return Response.d();
        }
        try {
            this.f368a.d(this);
            c cVar = new c();
            f(cVar, false);
            return cVar.a();
        } finally {
            this.f368a.g(this);
        }
    }

    public final void f(com.heytap.epona.a aVar, boolean z10) {
        ArrayList arrayList = new ArrayList(com.heytap.epona.c.h());
        arrayList.add(new com.heytap.epona.interceptor.b());
        arrayList.add(new com.heytap.epona.interceptor.d());
        arrayList.add(new com.heytap.epona.interceptor.e());
        arrayList.add(new CallIPCComponentInterceptor());
        new f(arrayList, 0, this.f369b, aVar, z10).b();
    }
}
