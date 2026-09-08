package androidx.concurrent.futures;

import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public abstract class AbstractResolvableFuture<V> implements com.google.common.util.concurrent.f<V> {

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f7960d = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* renamed from: e, reason: collision with root package name */
    public static final Logger f7961e = Logger.getLogger(AbstractResolvableFuture.class.getName());

    /* renamed from: f, reason: collision with root package name */
    public static final b f7962f;

    /* renamed from: g, reason: collision with root package name */
    public static final Object f7963g;

    /* renamed from: a, reason: collision with root package name */
    public volatile Object f7964a;

    /* renamed from: b, reason: collision with root package name */
    public volatile d f7965b;

    /* renamed from: c, reason: collision with root package name */
    public volatile h f7966c;

    /* loaded from: classes.dex */
    public static final class Failure {

        /* renamed from: b, reason: collision with root package name */
        public static final Failure f7967b = new Failure(new Throwable("Failure occurred while trying to finish a future.") { // from class: androidx.concurrent.futures.AbstractResolvableFuture.Failure.1
            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        });

        /* renamed from: a, reason: collision with root package name */
        public final Throwable f7968a;

        public Failure(Throwable th) {
            this.f7968a = (Throwable) AbstractResolvableFuture.d(th);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class b {
        public b() {
        }

        public abstract boolean a(AbstractResolvableFuture<?> abstractResolvableFuture, d dVar, d dVar2);

        public abstract boolean b(AbstractResolvableFuture<?> abstractResolvableFuture, Object obj, Object obj2);

        public abstract boolean c(AbstractResolvableFuture<?> abstractResolvableFuture, h hVar, h hVar2);

        public abstract void d(h hVar, h hVar2);

        public abstract void e(h hVar, Thread thread);
    }

    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: c, reason: collision with root package name */
        public static final c f7969c;

        /* renamed from: d, reason: collision with root package name */
        public static final c f7970d;

        /* renamed from: a, reason: collision with root package name */
        public final boolean f7971a;

        /* renamed from: b, reason: collision with root package name */
        public final Throwable f7972b;

        static {
            if (AbstractResolvableFuture.f7960d) {
                f7970d = null;
                f7969c = null;
            } else {
                f7970d = new c(false, null);
                f7969c = new c(true, null);
            }
        }

        public c(boolean z10, Throwable th) {
            this.f7971a = z10;
            this.f7972b = th;
        }
    }

    /* loaded from: classes.dex */
    public static final class d {

        /* renamed from: d, reason: collision with root package name */
        public static final d f7973d = new d(null, null);

        /* renamed from: a, reason: collision with root package name */
        public final Runnable f7974a;

        /* renamed from: b, reason: collision with root package name */
        public final Executor f7975b;

        /* renamed from: c, reason: collision with root package name */
        public d f7976c;

        public d(Runnable runnable, Executor executor) {
            this.f7974a = runnable;
            this.f7975b = executor;
        }
    }

    /* loaded from: classes.dex */
    public static final class e extends b {

        /* renamed from: a, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<h, Thread> f7977a;

        /* renamed from: b, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<h, h> f7978b;

        /* renamed from: c, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<AbstractResolvableFuture, h> f7979c;

        /* renamed from: d, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<AbstractResolvableFuture, d> f7980d;

        /* renamed from: e, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<AbstractResolvableFuture, Object> f7981e;

        public e(AtomicReferenceFieldUpdater<h, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<h, h> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<AbstractResolvableFuture, h> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<AbstractResolvableFuture, d> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<AbstractResolvableFuture, Object> atomicReferenceFieldUpdater5) {
            super();
            this.f7977a = atomicReferenceFieldUpdater;
            this.f7978b = atomicReferenceFieldUpdater2;
            this.f7979c = atomicReferenceFieldUpdater3;
            this.f7980d = atomicReferenceFieldUpdater4;
            this.f7981e = atomicReferenceFieldUpdater5;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public boolean a(AbstractResolvableFuture<?> abstractResolvableFuture, d dVar, d dVar2) {
            return this.f7980d.compareAndSet(abstractResolvableFuture, dVar, dVar2);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public boolean b(AbstractResolvableFuture<?> abstractResolvableFuture, Object obj, Object obj2) {
            return this.f7981e.compareAndSet(abstractResolvableFuture, obj, obj2);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public boolean c(AbstractResolvableFuture<?> abstractResolvableFuture, h hVar, h hVar2) {
            return this.f7979c.compareAndSet(abstractResolvableFuture, hVar, hVar2);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public void d(h hVar, h hVar2) {
            this.f7978b.lazySet(hVar, hVar2);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public void e(h hVar, Thread thread) {
            this.f7977a.lazySet(hVar, thread);
        }
    }

    /* loaded from: classes.dex */
    public static final class f<V> implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final AbstractResolvableFuture<V> f7982a;

        /* renamed from: b, reason: collision with root package name */
        public final com.google.common.util.concurrent.f<? extends V> f7983b;

        @Override // java.lang.Runnable
        public void run() {
            if (this.f7982a.f7964a != this) {
                return;
            }
            if (AbstractResolvableFuture.f7962f.b(this.f7982a, this, AbstractResolvableFuture.i(this.f7983b))) {
                AbstractResolvableFuture.f(this.f7982a);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class g extends b {
        public g() {
            super();
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public boolean a(AbstractResolvableFuture<?> abstractResolvableFuture, d dVar, d dVar2) {
            synchronized (abstractResolvableFuture) {
                try {
                    if (abstractResolvableFuture.f7965b == dVar) {
                        abstractResolvableFuture.f7965b = dVar2;
                        return true;
                    }
                    return false;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public boolean b(AbstractResolvableFuture<?> abstractResolvableFuture, Object obj, Object obj2) {
            synchronized (abstractResolvableFuture) {
                try {
                    if (abstractResolvableFuture.f7964a == obj) {
                        abstractResolvableFuture.f7964a = obj2;
                        return true;
                    }
                    return false;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public boolean c(AbstractResolvableFuture<?> abstractResolvableFuture, h hVar, h hVar2) {
            synchronized (abstractResolvableFuture) {
                try {
                    if (abstractResolvableFuture.f7966c == hVar) {
                        abstractResolvableFuture.f7966c = hVar2;
                        return true;
                    }
                    return false;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public void d(h hVar, h hVar2) {
            hVar.f7986b = hVar2;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public void e(h hVar, Thread thread) {
            hVar.f7985a = thread;
        }
    }

    /* loaded from: classes.dex */
    public static final class h {

        /* renamed from: c, reason: collision with root package name */
        public static final h f7984c = new h(false);

        /* renamed from: a, reason: collision with root package name */
        public volatile Thread f7985a;

        /* renamed from: b, reason: collision with root package name */
        public volatile h f7986b;

        public h(boolean z10) {
        }

        public void a(h hVar) {
            AbstractResolvableFuture.f7962f.d(this, hVar);
        }

        public void b() {
            Thread thread = this.f7985a;
            if (thread != null) {
                this.f7985a = null;
                LockSupport.unpark(thread);
            }
        }

        public h() {
            AbstractResolvableFuture.f7962f.e(this, Thread.currentThread());
        }
    }

    static {
        b gVar;
        try {
            gVar = new e(AtomicReferenceFieldUpdater.newUpdater(h.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(h.class, h.class, com.heytap.accessory.e.f25269e), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, h.class, "c"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, d.class, com.heytap.accessory.e.f25269e), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, Object.class, "a"));
            th = null;
        } catch (Throwable th) {
            th = th;
            gVar = new g();
        }
        f7962f = gVar;
        if (th != null) {
            f7961e.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f7963g = new Object();
    }

    private void a(StringBuilder sb) {
        try {
            Object j10 = j(this);
            sb.append("SUCCESS, result=[");
            sb.append(p(j10));
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e10) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e10.getClass());
            sb.append(" thrown from get()]");
        } catch (ExecutionException e11) {
            sb.append("FAILURE, cause=[");
            sb.append(e11.getCause());
            sb.append("]");
        }
    }

    private static CancellationException c(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    public static <T> T d(T t10) {
        t10.getClass();
        return t10;
    }

    public static void f(AbstractResolvableFuture<?> abstractResolvableFuture) {
        d dVar = null;
        while (true) {
            abstractResolvableFuture.m();
            abstractResolvableFuture.b();
            d e10 = abstractResolvableFuture.e(dVar);
            while (e10 != null) {
                dVar = e10.f7976c;
                Runnable runnable = e10.f7974a;
                if (runnable instanceof f) {
                    f fVar = (f) runnable;
                    abstractResolvableFuture = fVar.f7982a;
                    if (abstractResolvableFuture.f7964a == fVar) {
                        if (f7962f.b(abstractResolvableFuture, fVar, i(fVar.f7983b))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    g(runnable, e10.f7975b);
                }
                e10 = dVar;
            }
            return;
        }
    }

    private static void g(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e10) {
            f7961e.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private V h(Object obj) {
        if (!(obj instanceof c)) {
            if (!(obj instanceof Failure)) {
                if (obj == f7963g) {
                    return null;
                }
                return obj;
            }
            throw new ExecutionException(((Failure) obj).f7968a);
        }
        throw c("Task was cancelled.", ((c) obj).f7972b);
    }

    public static Object i(com.google.common.util.concurrent.f<?> fVar) {
        if (fVar instanceof AbstractResolvableFuture) {
            Object obj = ((AbstractResolvableFuture) fVar).f7964a;
            if (obj instanceof c) {
                c cVar = (c) obj;
                if (cVar.f7971a) {
                    if (cVar.f7972b != null) {
                        return new c(false, cVar.f7972b);
                    }
                    return c.f7970d;
                }
                return obj;
            }
            return obj;
        }
        boolean isCancelled = fVar.isCancelled();
        if ((!f7960d) & isCancelled) {
            return c.f7970d;
        }
        try {
            Object j10 = j(fVar);
            if (j10 == null) {
                return f7963g;
            }
            return j10;
        } catch (CancellationException e10) {
            if (!isCancelled) {
                return new Failure(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + fVar, e10));
            }
            return new c(false, e10);
        } catch (ExecutionException e11) {
            return new Failure(e11.getCause());
        } catch (Throwable th) {
            return new Failure(th);
        }
    }

    public static <V> V j(Future<V> future) {
        V v10;
        boolean z10 = false;
        while (true) {
            try {
                v10 = future.get();
                break;
            } catch (InterruptedException unused) {
                z10 = true;
            } catch (Throwable th) {
                if (z10) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
        return v10;
    }

    private void m() {
        h hVar;
        do {
            hVar = this.f7966c;
        } while (!f7962f.c(this, hVar, h.f7984c));
        while (hVar != null) {
            hVar.b();
            hVar = hVar.f7986b;
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z10) {
        boolean z11;
        c cVar;
        boolean z12;
        Object obj = this.f7964a;
        if (obj == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!(z11 | (obj instanceof f))) {
            return false;
        }
        if (f7960d) {
            cVar = new c(z10, new CancellationException("Future.cancel() was called."));
        } else if (z10) {
            cVar = c.f7969c;
        } else {
            cVar = c.f7970d;
        }
        boolean z13 = false;
        while (true) {
            if (f7962f.b(this, obj, cVar)) {
                if (z10) {
                    this.k();
                }
                f(this);
                if (!(obj instanceof f)) {
                    return true;
                }
                com.google.common.util.concurrent.f<? extends V> fVar = ((f) obj).f7983b;
                if (fVar instanceof AbstractResolvableFuture) {
                    this = (AbstractResolvableFuture) fVar;
                    obj = this.f7964a;
                    if (obj == null) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    if (!(z12 | (obj instanceof f))) {
                        return true;
                    }
                    z13 = true;
                } else {
                    fVar.cancel(z10);
                    return true;
                }
            } else {
                obj = this.f7964a;
                if (!(obj instanceof f)) {
                    return z13;
                }
            }
        }
    }

    public final d e(d dVar) {
        d dVar2;
        do {
            dVar2 = this.f7965b;
        } while (!f7962f.a(this, dVar2, d.f7973d));
        while (true) {
            d dVar3 = dVar;
            dVar = dVar2;
            if (dVar != null) {
                dVar2 = dVar.f7976c;
                dVar.f7976c = dVar3;
            } else {
                return dVar3;
            }
        }
    }

    @Override // java.util.concurrent.Future
    public final V get(long j10, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j10);
        if (!Thread.interrupted()) {
            Object obj = this.f7964a;
            if ((obj != null) & (!(obj instanceof f))) {
                return h(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
            if (nanos >= 1000) {
                h hVar = this.f7966c;
                if (hVar != h.f7984c) {
                    h hVar2 = new h();
                    do {
                        hVar2.a(hVar);
                        if (f7962f.c(this, hVar, hVar2)) {
                            do {
                                LockSupport.parkNanos(this, nanos);
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.f7964a;
                                    if ((obj2 != null) & (!(obj2 instanceof f))) {
                                        return h(obj2);
                                    }
                                    nanos = nanoTime - System.nanoTime();
                                } else {
                                    n(hVar2);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            n(hVar2);
                        } else {
                            hVar = this.f7966c;
                        }
                    } while (hVar != h.f7984c);
                }
                return h(this.f7964a);
            }
            while (nanos > 0) {
                Object obj3 = this.f7964a;
                if ((obj3 != null) & (!(obj3 instanceof f))) {
                    return h(obj3);
                }
                if (!Thread.interrupted()) {
                    nanos = nanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String abstractResolvableFuture = toString();
            String obj4 = timeUnit.toString();
            Locale locale = Locale.ROOT;
            String lowerCase = obj4.toLowerCase(locale);
            String str = "Waited " + j10 + " " + timeUnit.toString().toLowerCase(locale);
            if (nanos + 1000 < 0) {
                String str2 = str + " (plus ";
                long j11 = -nanos;
                long convert = timeUnit.convert(j11, TimeUnit.NANOSECONDS);
                long nanos2 = j11 - timeUnit.toNanos(convert);
                boolean z10 = convert == 0 || nanos2 > 1000;
                if (convert > 0) {
                    String str3 = str2 + convert + " " + lowerCase;
                    if (z10) {
                        str3 = str3 + ",";
                    }
                    str2 = str3 + " ";
                }
                if (z10) {
                    str2 = str2 + nanos2 + " nanoseconds ";
                }
                str = str2 + "delay)";
            }
            if (isDone()) {
                throw new TimeoutException(str + " but future completed as timeout expired");
            }
            throw new TimeoutException(str + " for " + abstractResolvableFuture);
        }
        throw new InterruptedException();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f7964a instanceof c;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        boolean z10;
        if (this.f7964a != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        return (!(r2 instanceof f)) & z10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String l() {
        Object obj = this.f7964a;
        if (obj instanceof f) {
            return "setFuture=[" + p(((f) obj).f7983b) + "]";
        }
        if (this instanceof ScheduledFuture) {
            return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
        }
        return null;
    }

    public final void n(h hVar) {
        hVar.f7985a = null;
        while (true) {
            h hVar2 = this.f7966c;
            if (hVar2 == h.f7984c) {
                return;
            }
            h hVar3 = null;
            while (hVar2 != null) {
                h hVar4 = hVar2.f7986b;
                if (hVar2.f7985a != null) {
                    hVar3 = hVar2;
                } else if (hVar3 != null) {
                    hVar3.f7986b = hVar4;
                    if (hVar3.f7985a == null) {
                        break;
                    }
                } else if (!f7962f.c(this, hVar2, hVar4)) {
                    break;
                }
                hVar2 = hVar4;
            }
            return;
        }
    }

    public boolean o(V v10) {
        if (v10 == null) {
            v10 = (V) f7963g;
        }
        if (f7962f.b(this, null, v10)) {
            f(this);
            return true;
        }
        return false;
    }

    public final String p(Object obj) {
        if (obj == this) {
            return "this future";
        }
        return String.valueOf(obj);
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            a(sb);
        } else {
            try {
                str = l();
            } catch (RuntimeException e10) {
                str = "Exception thrown from implementation: " + e10.getClass();
            }
            if (str != null && !str.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(str);
                sb.append("]");
            } else if (isDone()) {
                a(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public void b() {
    }

    public void k() {
    }

    @Override // java.util.concurrent.Future
    public final V get() {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f7964a;
            if ((obj2 != null) & (!(obj2 instanceof f))) {
                return h(obj2);
            }
            h hVar = this.f7966c;
            if (hVar != h.f7984c) {
                h hVar2 = new h();
                do {
                    hVar2.a(hVar);
                    if (f7962f.c(this, hVar, hVar2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f7964a;
                            } else {
                                n(hVar2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof f))));
                        return h(obj);
                    }
                    hVar = this.f7966c;
                } while (hVar != h.f7984c);
            }
            return h(this.f7964a);
        }
        throw new InterruptedException();
    }
}
