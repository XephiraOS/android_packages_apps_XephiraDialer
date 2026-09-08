package G;

import android.os.Handler;
import android.os.Process;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: RequestExecutor.java */
/* loaded from: classes.dex */
public class h {

    /* compiled from: RequestExecutor.java */
    /* loaded from: classes.dex */
    public static class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        public String f1074a;

        /* renamed from: b, reason: collision with root package name */
        public int f1075b;

        /* compiled from: RequestExecutor.java */
        /* renamed from: G.h$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0021a extends Thread {

            /* renamed from: a, reason: collision with root package name */
            public final int f1076a;

            public C0021a(Runnable runnable, String str, int i10) {
                super(runnable, str);
                this.f1076a = i10;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(this.f1076a);
                super.run();
            }
        }

        public a(String str, int i10) {
            this.f1074a = str;
            this.f1075b = i10;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new C0021a(runnable, this.f1074a, this.f1075b);
        }
    }

    /* compiled from: RequestExecutor.java */
    /* loaded from: classes.dex */
    public static class b implements Executor {

        /* renamed from: a, reason: collision with root package name */
        public final Handler f1077a;

        public b(Handler handler) {
            this.f1077a = (Handler) I.h.e(handler);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            if (this.f1077a.post((Runnable) I.h.e(runnable))) {
                return;
            }
            throw new RejectedExecutionException(this.f1077a + " is shutting down");
        }
    }

    /* compiled from: RequestExecutor.java */
    /* loaded from: classes.dex */
    public static class c<T> implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public Callable<T> f1078a;

        /* renamed from: b, reason: collision with root package name */
        public I.a<T> f1079b;

        /* renamed from: c, reason: collision with root package name */
        public Handler f1080c;

        /* compiled from: RequestExecutor.java */
        /* loaded from: classes.dex */
        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ I.a f1081a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Object f1082b;

            public a(I.a aVar, Object obj) {
                this.f1081a = aVar;
                this.f1082b = obj;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                this.f1081a.accept(this.f1082b);
            }
        }

        public c(Handler handler, Callable<T> callable, I.a<T> aVar) {
            this.f1078a = callable;
            this.f1079b = aVar;
            this.f1080c = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            T t10;
            try {
                t10 = this.f1078a.call();
            } catch (Exception unused) {
                t10 = null;
            }
            this.f1080c.post(new a(this.f1079b, t10));
        }
    }

    public static ThreadPoolExecutor a(String str, int i10, int i11) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, i11, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new a(str, i10));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static Executor b(Handler handler) {
        return new b(handler);
    }

    public static <T> void c(Executor executor, Callable<T> callable, I.a<T> aVar) {
        executor.execute(new c(G.b.a(), callable, aVar));
    }

    public static <T> T d(ExecutorService executorService, Callable<T> callable, int i10) {
        try {
            return executorService.submit(callable).get(i10, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e10) {
            throw e10;
        } catch (ExecutionException e11) {
            throw new RuntimeException(e11);
        } catch (TimeoutException unused) {
            throw new InterruptedException("timeout");
        }
    }
}
