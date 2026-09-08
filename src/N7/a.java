package N7;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: DefaultPoolExecutor.java */
/* loaded from: classes3.dex */
public final class a extends ThreadPoolExecutor {

    /* renamed from: a, reason: collision with root package name */
    public static final int f2376a;

    /* renamed from: b, reason: collision with root package name */
    public static final int f2377b;

    /* renamed from: c, reason: collision with root package name */
    public static final int f2378c;

    /* renamed from: d, reason: collision with root package name */
    public static volatile a f2379d;

    /* compiled from: DefaultPoolExecutor.java */
    /* renamed from: N7.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RejectedExecutionHandlerC0050a implements RejectedExecutionHandler {
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            H7.b.c("ContactsDefaultPoolExecutor", "Task rejected, too many task!");
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f2376a = availableProcessors;
        f2377b = Math.max(2, Math.min(availableProcessors - 1, 4));
        f2378c = (availableProcessors * 2) + 1;
    }

    public a(int i10, int i11, long j10, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i10, i11, j10, timeUnit, blockingQueue, threadFactory, new RejectedExecutionHandlerC0050a());
    }

    public static a a() {
        return new a(1, 1, 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(128), new b());
    }

    public static a b() {
        if (f2379d == null) {
            synchronized (a.class) {
                try {
                    if (f2379d == null) {
                        f2379d = new a(f2377b, f2378c, 30L, TimeUnit.SECONDS, new ArrayBlockingQueue(128), new b());
                        f2379d.allowCoreThreadTimeOut(true);
                    }
                } finally {
                }
            }
        }
        return f2379d;
    }
}
