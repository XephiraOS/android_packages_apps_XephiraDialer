package f7;

import com.oplus.epona.Call$Callback;
import com.oplus.epona.Request;
import com.oplus.epona.Response;
import com.oplus.epona.j;
import com.oplus.utils.C0864z;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: RealCall.java */
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public final j f31781a;

    /* renamed from: b, reason: collision with root package name */
    public final Request f31782b;

    /* renamed from: c, reason: collision with root package name */
    public AtomicBoolean f31783c = new AtomicBoolean(false);

    /* compiled from: RealCall.java */
    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final Call$Callback f31784a;

        public b(Call$Callback call$Callback) {
            this.f31784a = call$Callback;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            boolean z10 = false;
            z10 = false;
            z10 = false;
            try {
                try {
                    f.this.f(this.f31784a, true);
                    j jVar = f.this.f31781a;
                    jVar.f(this, true);
                    z10 = jVar;
                } catch (Exception e10) {
                    C0864z.d("Epona->RealCall", "AsyncCall run failed and exception is %s", e10.toString());
                    this.f31784a.onReceive(Response.b());
                    f.this.f31781a.f(this, false);
                }
            } catch (Throwable th) {
                f.this.f31781a.f(this, z10);
                throw th;
            }
        }
    }

    /* compiled from: RealCall.java */
    /* loaded from: classes3.dex */
    public static class c implements Call$Callback {

        /* renamed from: a, reason: collision with root package name */
        public Response f31786a;

        public c() {
            this.f31786a = null;
        }

        public Response a() {
            return this.f31786a;
        }

        @Override // com.oplus.epona.Call$Callback
        public void onReceive(Response response) {
            this.f31786a = response;
        }
    }

    public f(j jVar, Request request) {
        this.f31781a = jVar;
        this.f31782b = request;
    }

    public static f e(j jVar, Request request) {
        return new f(jVar, request);
    }

    public void c(Call$Callback call$Callback) {
        b bVar = new b(call$Callback);
        if (this.f31783c.getAndSet(true)) {
            C0864z.i("Epona->RealCall", "asyncExecute has been executed", new Object[0]);
            call$Callback.onReceive(Response.b());
        }
        this.f31781a.b(bVar);
    }

    public Response d() {
        Response f10;
        try {
            if (this.f31783c.getAndSet(true)) {
                C0864z.i("Epona->RealCall", "execute has been executed", new Object[0]);
                return Response.b();
            }
            try {
                this.f31781a.d(this);
                c cVar = new c();
                f(cVar, false);
                f10 = cVar.a();
            } catch (Exception e10) {
                C0864z.d("Epona->RealCall", "call has exception:" + e10.toString() + ", message:" + e10.getMessage(), new Object[0]);
                f10 = Response.f(e10.getMessage());
            }
            return f10;
        } finally {
            this.f31781a.g(this);
        }
    }

    public final void f(Call$Callback call$Callback, boolean z10) {
        ArrayList arrayList = new ArrayList(com.oplus.epona.d.k());
        arrayList.add(new com.oplus.epona.interceptor.b());
        arrayList.add(new com.oplus.epona.interceptor.d());
        arrayList.add(new com.oplus.epona.interceptor.e());
        arrayList.add(com.oplus.epona.d.i());
        new g(arrayList, 0, this.f31782b, call$Callback, z10).b();
    }
}
