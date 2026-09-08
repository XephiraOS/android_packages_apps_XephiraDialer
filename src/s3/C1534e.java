package s3;

import java.util.concurrent.Executor;

/* compiled from: Executors.java */
/* renamed from: s3.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1534e {

    /* renamed from: a, reason: collision with root package name */
    public static final Executor f36760a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final Executor f36761b = new b();

    /* compiled from: Executors.java */
    /* renamed from: s3.e$a */
    /* loaded from: classes.dex */
    public class a implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            C1541l.u(runnable);
        }
    }

    /* compiled from: Executors.java */
    /* renamed from: s3.e$b */
    /* loaded from: classes.dex */
    public class b implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            runnable.run();
        }
    }

    public static Executor a() {
        return f36761b;
    }

    public static Executor b() {
        return f36760a;
    }
}
