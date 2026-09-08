package C2;

import com.android.incallui.Log;
import java.lang.Thread;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: InCallUIThreadFactory.java */
/* loaded from: classes.dex */
public class a implements ThreadFactory {

    /* renamed from: d, reason: collision with root package name */
    public static final AtomicInteger f320d = new AtomicInteger(1);

    /* renamed from: a, reason: collision with root package name */
    public final AtomicInteger f321a = new AtomicInteger(1);

    /* renamed from: b, reason: collision with root package name */
    public final ThreadGroup f322b;

    /* renamed from: c, reason: collision with root package name */
    public final String f323c;

    /* compiled from: InCallUIThreadFactory.java */
    /* renamed from: C2.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0006a implements Thread.UncaughtExceptionHandler {
        public C0006a() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            Log.e("InCallUIThreadFactory", "Running task appeared exception! Thread [" + thread.getName() + "], because [" + th.getMessage() + "]");
        }
    }

    public a() {
        ThreadGroup threadGroup;
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            threadGroup = securityManager.getThreadGroup();
        } else {
            threadGroup = Thread.currentThread().getThreadGroup();
        }
        this.f322b = threadGroup;
        this.f323c = "personal assistant task pool No." + f320d.getAndIncrement() + ", thread No.";
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.f322b, runnable, this.f323c + this.f321a.getAndIncrement(), 0L);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (thread.getPriority() != 5) {
            thread.setPriority(5);
        }
        thread.setUncaughtExceptionHandler(new C0006a());
        return thread;
    }
}
