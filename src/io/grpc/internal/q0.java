package io.grpc.internal;

import java.util.IdentityHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: SharedResourceHolder.java */
/* loaded from: classes4.dex */
public final class q0 {

    /* renamed from: d, reason: collision with root package name */
    public static final q0 f33336d = new q0(new a());

    /* renamed from: a, reason: collision with root package name */
    public final IdentityHashMap<d<?>, c> f33337a = new IdentityHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    public final e f33338b;

    /* renamed from: c, reason: collision with root package name */
    public ScheduledExecutorService f33339c;

    /* compiled from: SharedResourceHolder.java */
    /* loaded from: classes4.dex */
    public class a implements e {
        @Override // io.grpc.internal.q0.e
        public ScheduledExecutorService a() {
            return Executors.newSingleThreadScheduledExecutor(GrpcUtil.i("grpc-shared-destroyer-%d", true));
        }
    }

    /* compiled from: SharedResourceHolder.java */
    /* loaded from: classes4.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f33340a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f33341b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f33342c;

        public b(c cVar, d dVar, Object obj) {
            this.f33340a = cVar;
            this.f33341b = dVar;
            this.f33342c = obj;
        }

        /* JADX WARN: Finally extract failed */
        @Override // java.lang.Runnable
        public void run() {
            synchronized (q0.this) {
                try {
                    if (this.f33340a.f33345b == 0) {
                        try {
                            this.f33341b.b(this.f33342c);
                            q0.this.f33337a.remove(this.f33341b);
                            if (q0.this.f33337a.isEmpty()) {
                                q0.this.f33339c.shutdown();
                                q0.this.f33339c = null;
                            }
                        } catch (Throwable th) {
                            q0.this.f33337a.remove(this.f33341b);
                            if (q0.this.f33337a.isEmpty()) {
                                q0.this.f33339c.shutdown();
                                q0.this.f33339c = null;
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* compiled from: SharedResourceHolder.java */
    /* loaded from: classes4.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final Object f33344a;

        /* renamed from: b, reason: collision with root package name */
        public int f33345b;

        /* renamed from: c, reason: collision with root package name */
        public ScheduledFuture<?> f33346c;

        public c(Object obj) {
            this.f33344a = obj;
        }
    }

    /* compiled from: SharedResourceHolder.java */
    /* loaded from: classes4.dex */
    public interface d<T> {
        void b(T t10);

        T create();
    }

    /* compiled from: SharedResourceHolder.java */
    /* loaded from: classes4.dex */
    public interface e {
        ScheduledExecutorService a();
    }

    public q0(e eVar) {
        this.f33338b = eVar;
    }

    public static <T> T d(d<T> dVar) {
        return (T) f33336d.e(dVar);
    }

    public static <T> T f(d<T> dVar, T t10) {
        return (T) f33336d.g(dVar, t10);
    }

    public synchronized <T> T e(d<T> dVar) {
        c cVar;
        try {
            cVar = this.f33337a.get(dVar);
            if (cVar == null) {
                cVar = new c(dVar.create());
                this.f33337a.put(dVar, cVar);
            }
            ScheduledFuture<?> scheduledFuture = cVar.f33346c;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
                cVar.f33346c = null;
            }
            cVar.f33345b++;
        } catch (Throwable th) {
            throw th;
        }
        return (T) cVar.f33344a;
    }

    public synchronized <T> T g(d<T> dVar, T t10) {
        boolean z10;
        boolean z11;
        try {
            c cVar = this.f33337a.get(dVar);
            if (cVar != null) {
                boolean z12 = false;
                if (t10 == cVar.f33344a) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                com.google.common.base.k.e(z10, "Releasing the wrong instance");
                if (cVar.f33345b > 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                com.google.common.base.k.v(z11, "Refcount has already reached zero");
                int i10 = cVar.f33345b - 1;
                cVar.f33345b = i10;
                if (i10 == 0) {
                    if (cVar.f33346c == null) {
                        z12 = true;
                    }
                    com.google.common.base.k.v(z12, "Destroy task already scheduled");
                    if (this.f33339c == null) {
                        this.f33339c = this.f33338b.a();
                    }
                    cVar.f33346c = this.f33339c.schedule(new K(new b(cVar, dVar, t10)), 1L, TimeUnit.SECONDS);
                }
            } else {
                throw new IllegalArgumentException("No cached instance found for " + dVar);
            }
        } catch (Throwable th) {
            throw th;
        }
        return null;
    }
}
