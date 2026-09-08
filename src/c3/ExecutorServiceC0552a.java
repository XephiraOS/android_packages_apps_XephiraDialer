package c3;

import android.os.Process;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: GlideExecutor.java */
/* renamed from: c3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ExecutorServiceC0552a implements ExecutorService {

    /* renamed from: b, reason: collision with root package name */
    public static final long f12722b = TimeUnit.SECONDS.toMillis(10);

    /* renamed from: c, reason: collision with root package name */
    public static volatile int f12723c;

    /* renamed from: a, reason: collision with root package name */
    public final ExecutorService f12724a;

    /* compiled from: GlideExecutor.java */
    /* renamed from: c3.a$b */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f12725a;

        /* renamed from: b, reason: collision with root package name */
        public int f12726b;

        /* renamed from: c, reason: collision with root package name */
        public int f12727c;

        /* renamed from: d, reason: collision with root package name */
        public ThreadFactory f12728d = new c();

        /* renamed from: e, reason: collision with root package name */
        public e f12729e = e.f12743d;

        /* renamed from: f, reason: collision with root package name */
        public String f12730f;

        /* renamed from: g, reason: collision with root package name */
        public long f12731g;

        public b(boolean z10) {
            this.f12725a = z10;
        }

        public ExecutorServiceC0552a a() {
            if (!TextUtils.isEmpty(this.f12730f)) {
                ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(this.f12726b, this.f12727c, this.f12731g, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new d(this.f12728d, this.f12730f, this.f12729e, this.f12725a));
                if (this.f12731g != 0) {
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                }
                return new ExecutorServiceC0552a(threadPoolExecutor);
            }
            throw new IllegalArgumentException("Name must be non-null and non-empty, but given: " + this.f12730f);
        }

        public b b(String str) {
            this.f12730f = str;
            return this;
        }

        public b c(int i10) {
            this.f12726b = i10;
            this.f12727c = i10;
            return this;
        }
    }

    /* compiled from: GlideExecutor.java */
    /* renamed from: c3.a$c */
    /* loaded from: classes.dex */
    public static final class c implements ThreadFactory {

        /* compiled from: GlideExecutor.java */
        /* renamed from: c3.a$c$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0149a extends Thread {
            public C0149a(Runnable runnable) {
                super(runnable);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(9);
                super.run();
            }
        }

        public c() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new C0149a(runnable);
        }
    }

    /* compiled from: GlideExecutor.java */
    /* renamed from: c3.a$d */
    /* loaded from: classes.dex */
    public static final class d implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        public final ThreadFactory f12733a;

        /* renamed from: b, reason: collision with root package name */
        public final String f12734b;

        /* renamed from: c, reason: collision with root package name */
        public final e f12735c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f12736d;

        /* renamed from: e, reason: collision with root package name */
        public final AtomicInteger f12737e = new AtomicInteger();

        /* compiled from: GlideExecutor.java */
        /* renamed from: c3.a$d$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0150a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Runnable f12738a;

            public RunnableC0150a(Runnable runnable) {
                this.f12738a = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (d.this.f12736d) {
                    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                }
                try {
                    this.f12738a.run();
                } catch (Throwable th) {
                    d.this.f12735c.a(th);
                }
            }
        }

        public d(ThreadFactory threadFactory, String str, e eVar, boolean z10) {
            this.f12733a = threadFactory;
            this.f12734b = str;
            this.f12735c = eVar;
            this.f12736d = z10;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread newThread = this.f12733a.newThread(new RunnableC0150a(runnable));
            newThread.setName("glide-" + this.f12734b + "-thread-" + this.f12737e.getAndIncrement());
            return newThread;
        }
    }

    public ExecutorServiceC0552a(ExecutorService executorService) {
        this.f12724a = executorService;
    }

    public static int a() {
        if (b() >= 4) {
            return 2;
        }
        return 1;
    }

    public static int b() {
        if (f12723c == 0) {
            f12723c = Math.min(4, c3.b.a());
        }
        return f12723c;
    }

    public static b c() {
        return new b(true).c(a()).b("animation");
    }

    public static ExecutorServiceC0552a d() {
        return c().a();
    }

    public static b e() {
        return new b(true).c(1).b("disk-cache");
    }

    public static ExecutorServiceC0552a g() {
        return e().a();
    }

    public static b h() {
        return new b(false).c(b()).b("source");
    }

    public static ExecutorServiceC0552a i() {
        return h().a();
    }

    public static ExecutorServiceC0552a j() {
        return new ExecutorServiceC0552a(new ThreadPoolExecutor(0, Integer.MAX_VALUE, f12722b, TimeUnit.MILLISECONDS, new SynchronousQueue(), new d(new c(), "source-unlimited", e.f12743d, false)));
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j10, TimeUnit timeUnit) {
        return this.f12724a.awaitTermination(j10, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f12724a.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) {
        return this.f12724a.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection) {
        return (T) this.f12724a.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.f12724a.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.f12724a.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        this.f12724a.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        return this.f12724a.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        return this.f12724a.submit(runnable);
    }

    public String toString() {
        return this.f12724a.toString();
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j10, TimeUnit timeUnit) {
        return this.f12724a.invokeAll(collection, j10, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j10, TimeUnit timeUnit) {
        return (T) this.f12724a.invokeAny(collection, j10, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable runnable, T t10) {
        return this.f12724a.submit(runnable, t10);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> callable) {
        return this.f12724a.submit(callable);
    }

    /* compiled from: GlideExecutor.java */
    /* renamed from: c3.a$e */
    /* loaded from: classes.dex */
    public interface e {

        /* renamed from: a, reason: collision with root package name */
        public static final e f12740a = new C0151a();

        /* renamed from: b, reason: collision with root package name */
        public static final e f12741b;

        /* renamed from: c, reason: collision with root package name */
        public static final e f12742c;

        /* renamed from: d, reason: collision with root package name */
        public static final e f12743d;

        /* compiled from: GlideExecutor.java */
        /* renamed from: c3.a$e$b */
        /* loaded from: classes.dex */
        public class b implements e {
            @Override // c3.ExecutorServiceC0552a.e
            public void a(Throwable th) {
                if (th != null && Log.isLoggable("GlideExecutor", 6)) {
                    Log.e("GlideExecutor", "Request threw uncaught throwable", th);
                }
            }
        }

        /* compiled from: GlideExecutor.java */
        /* renamed from: c3.a$e$c */
        /* loaded from: classes.dex */
        public class c implements e {
            @Override // c3.ExecutorServiceC0552a.e
            public void a(Throwable th) {
                if (th == null) {
                } else {
                    throw new RuntimeException("Request threw uncaught throwable", th);
                }
            }
        }

        static {
            b bVar = new b();
            f12741b = bVar;
            f12742c = new c();
            f12743d = bVar;
        }

        void a(Throwable th);

        /* compiled from: GlideExecutor.java */
        /* renamed from: c3.a$e$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0151a implements e {
            @Override // c3.ExecutorServiceC0552a.e
            public void a(Throwable th) {
            }
        }
    }
}
