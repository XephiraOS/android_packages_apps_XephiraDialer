package k;

import java.util.concurrent.Executor;

/* compiled from: ArchTaskExecutor.java */
/* loaded from: classes.dex */
public class c extends e {

    /* renamed from: c, reason: collision with root package name */
    public static volatile c f34048c;

    /* renamed from: d, reason: collision with root package name */
    public static final Executor f34049d = new Executor() { // from class: k.a
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            c.h(runnable);
        }
    };

    /* renamed from: e, reason: collision with root package name */
    public static final Executor f34050e = new Executor() { // from class: k.b
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            c.i(runnable);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public e f34051a;

    /* renamed from: b, reason: collision with root package name */
    public final e f34052b;

    public c() {
        d dVar = new d();
        this.f34052b = dVar;
        this.f34051a = dVar;
    }

    public static Executor f() {
        return f34050e;
    }

    public static c g() {
        if (f34048c != null) {
            return f34048c;
        }
        synchronized (c.class) {
            try {
                if (f34048c == null) {
                    f34048c = new c();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f34048c;
    }

    public static /* synthetic */ void h(Runnable runnable) {
        g().c(runnable);
    }

    public static /* synthetic */ void i(Runnable runnable) {
        g().a(runnable);
    }

    @Override // k.e
    public void a(Runnable runnable) {
        this.f34051a.a(runnable);
    }

    @Override // k.e
    public boolean b() {
        return this.f34051a.b();
    }

    @Override // k.e
    public void c(Runnable runnable) {
        this.f34051a.c(runnable);
    }
}
