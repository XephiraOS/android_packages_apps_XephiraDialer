package androidx.room;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* compiled from: TransactionExecutor.java */
/* loaded from: classes.dex */
public class C implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f11230a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayDeque<Runnable> f11231b = new ArrayDeque<>();

    /* renamed from: c, reason: collision with root package name */
    public Runnable f11232c;

    /* compiled from: TransactionExecutor.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f11233a;

        public a(Runnable runnable) {
            this.f11233a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f11233a.run();
            } finally {
                C.this.a();
            }
        }
    }

    public C(Executor executor) {
        this.f11230a = executor;
    }

    public synchronized void a() {
        Runnable poll = this.f11231b.poll();
        this.f11232c = poll;
        if (poll != null) {
            this.f11230a.execute(poll);
        }
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(Runnable runnable) {
        this.f11231b.offer(new a(runnable));
        if (this.f11232c == null) {
            a();
        }
    }
}
