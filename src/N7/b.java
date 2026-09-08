package N7;

import java.lang.Thread;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: DefaultThreadFactory.java */
/* loaded from: classes3.dex */
public class b implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicInteger f2380a;

    /* renamed from: b, reason: collision with root package name */
    public final ThreadGroup f2381b;

    /* renamed from: c, reason: collision with root package name */
    public final AtomicInteger f2382c;

    /* renamed from: d, reason: collision with root package name */
    public final String f2383d;

    /* compiled from: DefaultThreadFactory.java */
    /* loaded from: classes3.dex */
    public class a implements Thread.UncaughtExceptionHandler {
        public a() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            H7.b.c("DefaultThreadFactory", "Running task appeared exception! Thread [" + thread.getName() + "], because [" + th.getMessage() + "]");
        }
    }

    public b() {
        ThreadGroup threadGroup;
        AtomicInteger atomicInteger = new AtomicInteger(1);
        this.f2380a = atomicInteger;
        this.f2382c = new AtomicInteger(1);
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            threadGroup = securityManager.getThreadGroup();
        } else {
            threadGroup = Thread.currentThread().getThreadGroup();
        }
        this.f2381b = threadGroup;
        this.f2383d = "Contacts task pool No." + atomicInteger.getAndIncrement() + "-thread-";
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.f2381b, runnable, this.f2383d + this.f2382c.getAndIncrement(), 0L);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (thread.getPriority() != 5) {
            thread.setPriority(5);
        }
        thread.setUncaughtExceptionHandler(new a());
        return thread;
    }
}
