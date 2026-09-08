package kotlinx.coroutines;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ThreadPoolDispatcher.kt */
/* loaded from: classes4.dex */
public final /* synthetic */ class M0 {
    public static final ExecutorCoroutineDispatcher b(final int i10, final String str) {
        if (i10 >= 1) {
            final AtomicInteger atomicInteger = new AtomicInteger();
            return C1239d0.b(Executors.newScheduledThreadPool(i10, new ThreadFactory() { // from class: kotlinx.coroutines.L0
                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(Runnable runnable) {
                    Thread c10;
                    c10 = M0.c(i10, str, atomicInteger, runnable);
                    return c10;
                }
            }));
        }
        throw new IllegalArgumentException(("Expected at least one thread, but " + i10 + " specified").toString());
    }

    public static final Thread c(int i10, String str, AtomicInteger atomicInteger, Runnable runnable) {
        if (i10 != 1) {
            str = str + '-' + atomicInteger.incrementAndGet();
        }
        Thread thread = new Thread(runnable, str);
        thread.setDaemon(true);
        return thread;
    }
}
