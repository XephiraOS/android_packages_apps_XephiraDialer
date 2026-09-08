package androidx.loader.content;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public abstract class ModernAsyncTask<Params, Progress, Result> {

    /* renamed from: f, reason: collision with root package name */
    public static final ThreadFactory f10406f;

    /* renamed from: g, reason: collision with root package name */
    public static final BlockingQueue<Runnable> f10407g;

    /* renamed from: h, reason: collision with root package name */
    public static final Executor f10408h;

    /* renamed from: i, reason: collision with root package name */
    public static f f10409i;

    /* renamed from: j, reason: collision with root package name */
    public static volatile Executor f10410j;

    /* renamed from: a, reason: collision with root package name */
    public final g<Params, Result> f10411a;

    /* renamed from: b, reason: collision with root package name */
    public final FutureTask<Result> f10412b;

    /* renamed from: c, reason: collision with root package name */
    public volatile Status f10413c = Status.PENDING;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f10414d = new AtomicBoolean();

    /* renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f10415e = new AtomicBoolean();

    /* loaded from: classes.dex */
    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* loaded from: classes.dex */
    public static class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        public final AtomicInteger f10420a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ModernAsyncTask #" + this.f10420a.getAndIncrement());
        }
    }

    /* loaded from: classes.dex */
    public class b extends g<Params, Result> {
        public b() {
        }

        @Override // java.util.concurrent.Callable
        public Result call() {
            ModernAsyncTask.this.f10415e.set(true);
            Result result = null;
            try {
                Process.setThreadPriority(10);
                result = (Result) ModernAsyncTask.this.b(this.f10426a);
                Binder.flushPendingCommands();
                return result;
            } finally {
            }
        }
    }

    /* loaded from: classes.dex */
    public class c extends FutureTask<Result> {
        public c(Callable callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        public void done() {
            try {
                ModernAsyncTask.this.m(get());
            } catch (InterruptedException e10) {
                Log.w("AsyncTask", e10);
            } catch (CancellationException unused) {
                ModernAsyncTask.this.m(null);
            } catch (ExecutionException e11) {
                throw new RuntimeException("An error occurred while executing doInBackground()", e11.getCause());
            } catch (Throwable th) {
                throw new RuntimeException("An error occurred while executing doInBackground()", th);
            }
        }
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class d {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10423a;

        static {
            int[] iArr = new int[Status.values().length];
            f10423a = iArr;
            try {
                iArr[Status.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10423a[Status.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class e<Data> {

        /* renamed from: a, reason: collision with root package name */
        public final ModernAsyncTask f10424a;

        /* renamed from: b, reason: collision with root package name */
        public final Data[] f10425b;

        public e(ModernAsyncTask modernAsyncTask, Data... dataArr) {
            this.f10424a = modernAsyncTask;
            this.f10425b = dataArr;
        }
    }

    /* loaded from: classes.dex */
    public static class f extends Handler {
        public f() {
            super(Looper.getMainLooper());
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            e eVar = (e) message.obj;
            int i10 = message.what;
            if (i10 != 1) {
                if (i10 == 2) {
                    eVar.f10424a.k(eVar.f10425b);
                    return;
                }
                return;
            }
            eVar.f10424a.d(eVar.f10425b[0]);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class g<Params, Result> implements Callable<Result> {

        /* renamed from: a, reason: collision with root package name */
        public Params[] f10426a;
    }

    static {
        a aVar = new a();
        f10406f = aVar;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(10);
        f10407g = linkedBlockingQueue;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, linkedBlockingQueue, aVar);
        f10408h = threadPoolExecutor;
        f10410j = threadPoolExecutor;
    }

    public ModernAsyncTask() {
        b bVar = new b();
        this.f10411a = bVar;
        this.f10412b = new c(bVar);
    }

    public static Handler e() {
        f fVar;
        synchronized (ModernAsyncTask.class) {
            try {
                if (f10409i == null) {
                    f10409i = new f();
                }
                fVar = f10409i;
            } catch (Throwable th) {
                throw th;
            }
        }
        return fVar;
    }

    public final boolean a(boolean z10) {
        this.f10414d.set(true);
        return this.f10412b.cancel(z10);
    }

    public abstract Result b(Params... paramsArr);

    public final ModernAsyncTask<Params, Progress, Result> c(Executor executor, Params... paramsArr) {
        if (this.f10413c != Status.PENDING) {
            int i10 = d.f10423a[this.f10413c.ordinal()];
            if (i10 != 1) {
                if (i10 != 2) {
                    throw new IllegalStateException("We should never reach this state");
                }
                throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
            throw new IllegalStateException("Cannot execute task: the task is already running.");
        }
        this.f10413c = Status.RUNNING;
        j();
        this.f10411a.f10426a = paramsArr;
        executor.execute(this.f10412b);
        return this;
    }

    public void d(Result result) {
        if (f()) {
            h(result);
        } else {
            i(result);
        }
        this.f10413c = Status.FINISHED;
    }

    public final boolean f() {
        return this.f10414d.get();
    }

    public void h(Result result) {
        g();
    }

    public Result l(Result result) {
        e().obtainMessage(1, new e(this, result)).sendToTarget();
        return result;
    }

    public void m(Result result) {
        if (!this.f10415e.get()) {
            l(result);
        }
    }

    public void g() {
    }

    public void i(Result result) {
    }

    public void j() {
    }

    public void k(Progress... progressArr) {
    }
}
