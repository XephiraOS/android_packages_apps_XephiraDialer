package io.grpc;

import io.grpc.y;
import j9.C1203m;
import j9.RunnableC1202l;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes4.dex */
public class Context {

    /* renamed from: d, reason: collision with root package name */
    public static final Logger f32274d = Logger.getLogger(Context.class.getName());

    /* renamed from: e, reason: collision with root package name */
    public static final Context f32275e = new Context();

    /* renamed from: a, reason: collision with root package name */
    public final a f32276a;

    /* renamed from: b, reason: collision with root package name */
    public final y.d<d<?>, Object> f32277b;

    /* renamed from: c, reason: collision with root package name */
    public final int f32278c;

    /* loaded from: classes4.dex */
    public enum DirectExecutor implements Executor {
        INSTANCE;

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            runnable.run();
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Context.DirectExecutor";
        }
    }

    /* loaded from: classes4.dex */
    public static final class a extends Context implements Closeable {

        /* renamed from: f, reason: collision with root package name */
        public final C1203m f32281f;

        /* renamed from: g, reason: collision with root package name */
        public final Context f32282g;

        /* renamed from: h, reason: collision with root package name */
        public ArrayList<c> f32283h;

        /* renamed from: i, reason: collision with root package name */
        public b f32284i;

        /* renamed from: j, reason: collision with root package name */
        public Throwable f32285j;

        /* renamed from: k, reason: collision with root package name */
        public ScheduledFuture<?> f32286k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f32287l;

        /* renamed from: io.grpc.Context$a$a, reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0306a implements b {
            public C0306a() {
            }

            @Override // io.grpc.Context.b
            public void a(Context context) {
                a.this.Z(context.f());
            }
        }

        /* loaded from: classes4.dex */
        public final class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.this.Z(new TimeoutException("context timed out"));
                } catch (Throwable th) {
                    Context.f32274d.log(Level.SEVERE, "Cancel threw an exception, which should not happen", th);
                }
            }
        }

        public /* synthetic */ a(Context context, RunnableC1202l runnableC1202l) {
            this(context);
        }

        @Override // io.grpc.Context
        public void B(b bVar) {
            c0(bVar, this);
        }

        public final void X(c cVar) {
            synchronized (this) {
                try {
                    if (u()) {
                        cVar.b();
                    } else {
                        ArrayList<c> arrayList = this.f32283h;
                        if (arrayList == null) {
                            ArrayList<c> arrayList2 = new ArrayList<>();
                            this.f32283h = arrayList2;
                            arrayList2.add(cVar);
                            if (this.f32276a != null) {
                                C0306a c0306a = new C0306a();
                                this.f32284i = c0306a;
                                this.f32276a.X(new c(DirectExecutor.INSTANCE, c0306a, this));
                            }
                        } else {
                            arrayList.add(cVar);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public boolean Z(Throwable th) {
            ScheduledFuture<?> scheduledFuture;
            boolean z10;
            synchronized (this) {
                try {
                    scheduledFuture = null;
                    if (!this.f32287l) {
                        z10 = true;
                        this.f32287l = true;
                        ScheduledFuture<?> scheduledFuture2 = this.f32286k;
                        if (scheduledFuture2 != null) {
                            this.f32286k = null;
                            scheduledFuture = scheduledFuture2;
                        }
                        this.f32285j = th;
                    } else {
                        z10 = false;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            if (z10) {
                a0();
            }
            return z10;
        }

        @Override // io.grpc.Context
        public void a(b bVar, Executor executor) {
            Context.g(bVar, "cancellationListener");
            Context.g(executor, "executor");
            X(new c(executor, bVar, this));
        }

        public final void a0() {
            synchronized (this) {
                try {
                    ArrayList<c> arrayList = this.f32283h;
                    if (arrayList == null) {
                        return;
                    }
                    b bVar = this.f32284i;
                    this.f32284i = null;
                    this.f32283h = null;
                    Iterator<c> it = arrayList.iterator();
                    while (it.hasNext()) {
                        c next = it.next();
                        if (next.f32292c == this) {
                            next.b();
                        }
                    }
                    Iterator<c> it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        c next2 = it2.next();
                        if (next2.f32292c != this) {
                            next2.b();
                        }
                    }
                    a aVar = this.f32276a;
                    if (aVar != null) {
                        aVar.B(bVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // io.grpc.Context
        public Context c() {
            return this.f32282g.c();
        }

        public final void c0(b bVar, Context context) {
            synchronized (this) {
                try {
                    ArrayList<c> arrayList = this.f32283h;
                    if (arrayList != null) {
                        int size = arrayList.size() - 1;
                        while (true) {
                            if (size < 0) {
                                break;
                            }
                            c cVar = this.f32283h.get(size);
                            if (cVar.f32291b == bVar && cVar.f32292c == context) {
                                this.f32283h.remove(size);
                                break;
                            }
                            size--;
                        }
                        if (this.f32283h.isEmpty()) {
                            a aVar = this.f32276a;
                            if (aVar != null) {
                                aVar.B(this.f32284i);
                            }
                            this.f32284i = null;
                            this.f32283h = null;
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Z(null);
        }

        @Override // io.grpc.Context
        public Throwable f() {
            if (u()) {
                return this.f32285j;
            }
            return null;
        }

        public final void f0(C1203m c1203m, ScheduledExecutorService scheduledExecutorService) {
            if (!c1203m.h()) {
                synchronized (this) {
                    this.f32286k = c1203m.j(new b(), scheduledExecutorService);
                }
            } else {
                Z(new TimeoutException("context timed out"));
            }
        }

        @Override // io.grpc.Context
        public void o(Context context) {
            this.f32282g.o(context);
        }

        @Override // io.grpc.Context
        public C1203m s() {
            return this.f32281f;
        }

        @Override // io.grpc.Context
        public boolean u() {
            synchronized (this) {
                try {
                    if (this.f32287l) {
                        return true;
                    }
                    if (super.u()) {
                        Z(super.f());
                        return true;
                    }
                    return false;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public /* synthetic */ a(Context context, C1203m c1203m, RunnableC1202l runnableC1202l) {
            this(context, c1203m);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public a(io.grpc.Context r3) {
            /*
                r2 = this;
                io.grpc.y$d<io.grpc.Context$d<?>, java.lang.Object> r0 = r3.f32277b
                r1 = 0
                r2.<init>(r3, r0, r1)
                j9.m r3 = r3.s()
                r2.f32281f = r3
                io.grpc.Context r3 = new io.grpc.Context
                io.grpc.y$d<io.grpc.Context$d<?>, java.lang.Object> r0 = r2.f32277b
                r3.<init>(r2, r0, r1)
                r2.f32282g = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.grpc.Context.a.<init>(io.grpc.Context):void");
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public a(io.grpc.Context r3, j9.C1203m r4) {
            /*
                r2 = this;
                io.grpc.y$d<io.grpc.Context$d<?>, java.lang.Object> r0 = r3.f32277b
                r1 = 0
                r2.<init>(r3, r0, r1)
                r2.f32281f = r4
                io.grpc.Context r3 = new io.grpc.Context
                io.grpc.y$d<io.grpc.Context$d<?>, java.lang.Object> r4 = r2.f32277b
                r3.<init>(r2, r4, r1)
                r2.f32282g = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.grpc.Context.a.<init>(io.grpc.Context, j9.m):void");
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(Context context);
    }

    /* loaded from: classes4.dex */
    public static final class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final Executor f32290a;

        /* renamed from: b, reason: collision with root package name */
        public final b f32291b;

        /* renamed from: c, reason: collision with root package name */
        public final Context f32292c;

        public c(Executor executor, b bVar, Context context) {
            this.f32290a = executor;
            this.f32291b = bVar;
            this.f32292c = context;
        }

        public void b() {
            try {
                this.f32290a.execute(this);
            } catch (Throwable th) {
                Context.f32274d.log(Level.INFO, "Exception notifying context listener", th);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f32291b.a(this.f32292c);
        }
    }

    /* loaded from: classes4.dex */
    public static final class d<T> {

        /* renamed from: a, reason: collision with root package name */
        public final String f32293a;

        /* renamed from: b, reason: collision with root package name */
        public final T f32294b;

        public d(String str) {
            this(str, null);
        }

        public String toString() {
            return this.f32293a;
        }

        public d(String str, T t10) {
            this.f32293a = (String) Context.g(str, "name");
            this.f32294b = t10;
        }
    }

    /* loaded from: classes4.dex */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        public static final f f32295a;

        static {
            AtomicReference atomicReference = new AtomicReference();
            f32295a = a(atomicReference);
            Throwable th = (Throwable) atomicReference.get();
            if (th != null) {
                Context.f32274d.log(Level.FINE, "Storage override doesn't exist. Using default", th);
            }
        }

        public static f a(AtomicReference<? super ClassNotFoundException> atomicReference) {
            try {
                return (f) Class.forName("io.grpc.override.ContextStorageOverride").asSubclass(f.class).getConstructor(null).newInstance(null);
            } catch (ClassNotFoundException e10) {
                atomicReference.set(e10);
                return new H();
            } catch (Exception e11) {
                throw new RuntimeException("Storage override failed to initialize", e11);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class f {
        public abstract Context a();

        public abstract void b(Context context, Context context2);

        public abstract Context c(Context context);
    }

    public /* synthetic */ Context(Context context, y.d dVar, RunnableC1202l runnableC1202l) {
        this(context, (y.d<d<?>, Object>) dVar);
    }

    public static f G() {
        return e.f32295a;
    }

    public static void I(int i10) {
        if (i10 == 1000) {
            f32274d.log(Level.SEVERE, "Context ancestry chain length is abnormally long. This suggests an error in application code. Length exceeded: 1000", (Throwable) new Exception());
        }
    }

    public static a e(Context context) {
        if (context instanceof a) {
            return (a) context;
        }
        return context.f32276a;
    }

    public static <T> T g(T t10, Object obj) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static Context l() {
        Context a10 = G().a();
        if (a10 == null) {
            return f32275e;
        }
        return a10;
    }

    public static <T> d<T> y(String str) {
        return new d<>(str);
    }

    public void B(b bVar) {
        a aVar = this.f32276a;
        if (aVar != null) {
            aVar.c0(bVar, this);
        }
    }

    public a L() {
        return new a(this, (RunnableC1202l) null);
    }

    public a O(C1203m c1203m, ScheduledExecutorService scheduledExecutorService) {
        boolean z10;
        g(c1203m, "deadline");
        g(scheduledExecutorService, "scheduler");
        C1203m s10 = s();
        if (s10 != null && s10.compareTo(c1203m) <= 0) {
            z10 = false;
            c1203m = s10;
        } else {
            z10 = true;
        }
        a aVar = new a(this, c1203m, null);
        if (z10) {
            aVar.f0(c1203m, scheduledExecutorService);
        }
        return aVar;
    }

    public <V> Context S(d<V> dVar, V v10) {
        return new Context(this, (y.d<d<?>, Object>) y.a(this.f32277b, dVar, v10));
    }

    public void a(b bVar, Executor executor) {
        g(bVar, "cancellationListener");
        g(executor, "executor");
        a aVar = this.f32276a;
        if (aVar != null) {
            aVar.X(new c(executor, bVar, this));
        }
    }

    public Context c() {
        Context c10 = G().c(this);
        if (c10 == null) {
            return f32275e;
        }
        return c10;
    }

    public Throwable f() {
        a aVar = this.f32276a;
        if (aVar == null) {
            return null;
        }
        return aVar.f();
    }

    public void o(Context context) {
        g(context, "toAttach");
        G().b(this, context);
    }

    public Context r() {
        return new Context(this.f32277b, this.f32278c + 1);
    }

    public C1203m s() {
        a aVar = this.f32276a;
        if (aVar == null) {
            return null;
        }
        return aVar.s();
    }

    public boolean u() {
        a aVar = this.f32276a;
        if (aVar == null) {
            return false;
        }
        return aVar.u();
    }

    public Context(y.d<d<?>, Object> dVar, int i10) {
        this.f32276a = null;
        this.f32277b = dVar;
        this.f32278c = i10;
        I(i10);
    }

    public Context(Context context, y.d<d<?>, Object> dVar) {
        this.f32276a = e(context);
        this.f32277b = dVar;
        int i10 = context.f32278c + 1;
        this.f32278c = i10;
        I(i10);
    }

    public Context() {
        this.f32276a = null;
        this.f32277b = null;
        this.f32278c = 0;
        I(0);
    }
}
