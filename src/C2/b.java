package C2;

import com.android.incallui.Log;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: InCallUIThreadPoolExecutor.java */
/* loaded from: classes.dex */
public class b extends ThreadPoolExecutor {

    /* renamed from: a, reason: collision with root package name */
    public static final int f325a;

    /* renamed from: b, reason: collision with root package name */
    public static final int f326b;

    /* renamed from: c, reason: collision with root package name */
    public static final int f327c;

    /* renamed from: d, reason: collision with root package name */
    public static volatile b f328d;

    /* compiled from: InCallUIThreadPoolExecutor.java */
    /* loaded from: classes.dex */
    public class a implements RejectedExecutionHandler {
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            Log.e("InCallUIThreadPoolExecutor", "Task rejected, too many task!");
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f325a = availableProcessors;
        int i10 = availableProcessors + 1;
        f326b = i10;
        f327c = i10;
    }

    public b(int i10, int i11, long j10, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i10, i11, j10, timeUnit, blockingQueue, threadFactory, new a());
    }

    public static b a() {
        if (f328d == null) {
            synchronized (b.class) {
                try {
                    if (f328d == null) {
                        f328d = new b(f326b, f327c, 30L, TimeUnit.SECONDS, new ArrayBlockingQueue(64), new C2.a());
                    }
                } finally {
                }
            }
        }
        return f328d;
    }
}
