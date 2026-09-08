package S2;

import android.os.Handler;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import java.util.concurrent.Executor;

/* compiled from: ExecutorDelivery.java */
/* loaded from: classes.dex */
public class b implements g {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f3382a;

    /* compiled from: ExecutorDelivery.java */
    /* loaded from: classes.dex */
    public class a implements Executor {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Handler f3383a;

        public a(Handler handler) {
            this.f3383a = handler;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f3383a.post(runnable);
        }
    }

    /* compiled from: ExecutorDelivery.java */
    /* renamed from: S2.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0063b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final Request f3385a;

        /* renamed from: b, reason: collision with root package name */
        public final com.android.volley.d f3386b;

        /* renamed from: c, reason: collision with root package name */
        public final Runnable f3387c;

        public RunnableC0063b(Request request, com.android.volley.d dVar, Runnable runnable) {
            this.f3385a = request;
            this.f3386b = dVar;
            this.f3387c = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f3385a.A()) {
                this.f3385a.i("canceled-at-delivery");
                return;
            }
            if (this.f3386b.b()) {
                this.f3385a.f(this.f3386b.f19247a);
            } else {
                this.f3385a.e(this.f3386b.f19249c);
            }
            if (this.f3386b.f19250d) {
                this.f3385a.b("intermediate-response");
            } else {
                this.f3385a.i("done");
            }
            Runnable runnable = this.f3387c;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public b(Handler handler) {
        this.f3382a = new a(handler);
    }

    @Override // S2.g
    public void a(Request<?> request, com.android.volley.d<?> dVar) {
        b(request, dVar, null);
    }

    @Override // S2.g
    public void b(Request<?> request, com.android.volley.d<?> dVar, Runnable runnable) {
        request.B();
        request.b("post-response");
        this.f3382a.execute(new RunnableC0063b(request, dVar, runnable));
    }

    @Override // S2.g
    public void c(Request<?> request, VolleyError volleyError) {
        request.b("post-error");
        this.f3382a.execute(new RunnableC0063b(request, com.android.volley.d.a(volleyError), null));
    }
}
