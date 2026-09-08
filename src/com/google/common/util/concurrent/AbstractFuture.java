package com.google.common.util.concurrent;

import com.google.common.base.n;
import com.google.j2objc.annotations.ReflectionSupport;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Locale;
import java.util.Objects;
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
import sun.misc.Unsafe;

@ReflectionSupport(ReflectionSupport.Level.FULL)
/* loaded from: classes3.dex */
public abstract class AbstractFuture<V> extends D4.a implements com.google.common.util.concurrent.f<V> {

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f24616d;

    /* renamed from: e, reason: collision with root package name */
    public static final Logger f24617e;

    /* renamed from: f, reason: collision with root package name */
    public static final b f24618f;

    /* renamed from: g, reason: collision with root package name */
    public static final Object f24619g;

    /* renamed from: a, reason: collision with root package name */
    public volatile Object f24620a;

    /* renamed from: b, reason: collision with root package name */
    public volatile d f24621b;

    /* renamed from: c, reason: collision with root package name */
    public volatile k f24622c;

    /* loaded from: classes3.dex */
    public static final class Failure {

        /* renamed from: b, reason: collision with root package name */
        public static final Failure f24623b = new Failure(new Throwable("Failure occurred while trying to finish a future.") { // from class: com.google.common.util.concurrent.AbstractFuture.Failure.1
            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        });

        /* renamed from: a, reason: collision with root package name */
        public final Throwable f24624a;

        public Failure(Throwable th) {
            this.f24624a = (Throwable) com.google.common.base.k.o(th);
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class b {
        public b() {
        }

        public abstract boolean a(AbstractFuture<?> abstractFuture, Object obj, Object obj2);

        public abstract boolean b(AbstractFuture<?> abstractFuture, k kVar, k kVar2);

        public abstract d c(AbstractFuture<?> abstractFuture, d dVar);

        public abstract k d(AbstractFuture<?> abstractFuture, k kVar);

        public abstract void e(k kVar, k kVar2);

        public abstract void f(k kVar, Thread thread);
    }

    /* loaded from: classes3.dex */
    public static final class c {

        /* renamed from: c, reason: collision with root package name */
        public static final c f24625c;

        /* renamed from: d, reason: collision with root package name */
        public static final c f24626d;

        /* renamed from: a, reason: collision with root package name */
        public final boolean f24627a;

        /* renamed from: b, reason: collision with root package name */
        public final Throwable f24628b;

        static {
            if (AbstractFuture.f24616d) {
                f24626d = null;
                f24625c = null;
            } else {
                f24626d = new c(false, null);
                f24625c = new c(true, null);
            }
        }

        public c(boolean z10, Throwable th) {
            this.f24627a = z10;
            this.f24628b = th;
        }
    }

    /* loaded from: classes3.dex */
    public static final class d {

        /* renamed from: d, reason: collision with root package name */
        public static final d f24629d = new d();

        /* renamed from: a, reason: collision with root package name */
        public final Runnable f24630a = null;

        /* renamed from: b, reason: collision with root package name */
        public final Executor f24631b = null;

        /* renamed from: c, reason: collision with root package name */
        public d f24632c;
    }

    /* loaded from: classes3.dex */
    public static final class e extends b {

        /* renamed from: a, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<k, Thread> f24633a;

        /* renamed from: b, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<k, k> f24634b;

        /* renamed from: c, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<AbstractFuture, k> f24635c;

        /* renamed from: d, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<AbstractFuture, d> f24636d;

        /* renamed from: e, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<AbstractFuture, Object> f24637e;

        public e(AtomicReferenceFieldUpdater<k, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<k, k> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<AbstractFuture, k> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<AbstractFuture, d> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<AbstractFuture, Object> atomicReferenceFieldUpdater5) {
            super();
            this.f24633a = atomicReferenceFieldUpdater;
            this.f24634b = atomicReferenceFieldUpdater2;
            this.f24635c = atomicReferenceFieldUpdater3;
            this.f24636d = atomicReferenceFieldUpdater4;
            this.f24637e = atomicReferenceFieldUpdater5;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public boolean a(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            return this.f24637e.compareAndSet(abstractFuture, obj, obj2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public boolean b(AbstractFuture<?> abstractFuture, k kVar, k kVar2) {
            return this.f24635c.compareAndSet(abstractFuture, kVar, kVar2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public d c(AbstractFuture<?> abstractFuture, d dVar) {
            return this.f24636d.getAndSet(abstractFuture, dVar);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public k d(AbstractFuture<?> abstractFuture, k kVar) {
            return this.f24635c.getAndSet(abstractFuture, kVar);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public void e(k kVar, k kVar2) {
            this.f24634b.lazySet(kVar, kVar2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public void f(k kVar, Thread thread) {
            this.f24633a.lazySet(kVar, thread);
        }
    }

    /* loaded from: classes3.dex */
    public static final class f<V> implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final AbstractFuture<V> f24638a;

        /* renamed from: b, reason: collision with root package name */
        public final com.google.common.util.concurrent.f<? extends V> f24639b;

        @Override // java.lang.Runnable
        public void run() {
            if (this.f24638a.f24620a == this) {
                if (AbstractFuture.f24618f.a(this.f24638a, this, AbstractFuture.u(this.f24639b))) {
                    AbstractFuture.r(this.f24638a, false);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class g extends b {
        public g() {
            super();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public boolean a(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            synchronized (abstractFuture) {
                try {
                    if (abstractFuture.f24620a == obj) {
                        abstractFuture.f24620a = obj2;
                        return true;
                    }
                    return false;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public boolean b(AbstractFuture<?> abstractFuture, k kVar, k kVar2) {
            synchronized (abstractFuture) {
                try {
                    if (abstractFuture.f24622c == kVar) {
                        abstractFuture.f24622c = kVar2;
                        return true;
                    }
                    return false;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public d c(AbstractFuture<?> abstractFuture, d dVar) {
            d dVar2;
            synchronized (abstractFuture) {
                try {
                    dVar2 = abstractFuture.f24621b;
                    if (dVar2 != dVar) {
                        abstractFuture.f24621b = dVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return dVar2;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public k d(AbstractFuture<?> abstractFuture, k kVar) {
            k kVar2;
            synchronized (abstractFuture) {
                try {
                    kVar2 = abstractFuture.f24622c;
                    if (kVar2 != kVar) {
                        abstractFuture.f24622c = kVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return kVar2;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public void e(k kVar, k kVar2) {
            kVar.f24648b = kVar2;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public void f(k kVar, Thread thread) {
            kVar.f24647a = thread;
        }
    }

    /* loaded from: classes3.dex */
    public interface h<V> extends com.google.common.util.concurrent.f<V> {
    }

    /* loaded from: classes3.dex */
    public static abstract class i<V> extends AbstractFuture<V> implements h<V> {
        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public boolean cancel(boolean z10) {
            return super.cancel(z10);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final V get() {
            return (V) super.get();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public boolean isCancelled() {
            return super.isCancelled();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean isDone() {
            return super.isDone();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final V get(long j10, TimeUnit timeUnit) {
            return (V) super.get(j10, timeUnit);
        }
    }

    /* loaded from: classes3.dex */
    public static final class j extends b {

        /* renamed from: a, reason: collision with root package name */
        public static final Unsafe f24640a;

        /* renamed from: b, reason: collision with root package name */
        public static final long f24641b;

        /* renamed from: c, reason: collision with root package name */
        public static final long f24642c;

        /* renamed from: d, reason: collision with root package name */
        public static final long f24643d;

        /* renamed from: e, reason: collision with root package name */
        public static final long f24644e;

        /* renamed from: f, reason: collision with root package name */
        public static final long f24645f;

        /* loaded from: classes3.dex */
        public class a implements PrivilegedExceptionAction<Unsafe> {
            @Override // java.security.PrivilegedExceptionAction
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Unsafe run() {
                for (Field field : Unsafe.class.getDeclaredFields()) {
                    field.setAccessible(true);
                    Object obj = field.get(null);
                    if (Unsafe.class.isInstance(obj)) {
                        return (Unsafe) Unsafe.class.cast(obj);
                    }
                }
                throw new NoSuchFieldError("the Unsafe");
            }
        }

        static {
            Unsafe unsafe;
            try {
                try {
                    unsafe = Unsafe.getUnsafe();
                } catch (PrivilegedActionException e10) {
                    throw new RuntimeException("Could not initialize intrinsics", e10.getCause());
                }
            } catch (SecurityException unused) {
                unsafe = (Unsafe) AccessController.doPrivileged(new a());
            }
            try {
                f24642c = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("c"));
                f24641b = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField(com.heytap.accessory.e.f25269e));
                f24643d = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("a"));
                f24644e = unsafe.objectFieldOffset(k.class.getDeclaredField("a"));
                f24645f = unsafe.objectFieldOffset(k.class.getDeclaredField(com.heytap.accessory.e.f25269e));
                f24640a = unsafe;
            } catch (NoSuchFieldException e11) {
                throw new RuntimeException(e11);
            } catch (RuntimeException e12) {
                throw e12;
            }
        }

        public j() {
            super();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public boolean a(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            return f24640a.compareAndSwapObject(abstractFuture, f24643d, obj, obj2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public boolean b(AbstractFuture<?> abstractFuture, k kVar, k kVar2) {
            return f24640a.compareAndSwapObject(abstractFuture, f24642c, kVar, kVar2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public d c(AbstractFuture<?> abstractFuture, d dVar) {
            d dVar2;
            do {
                dVar2 = abstractFuture.f24621b;
                if (dVar == dVar2) {
                    return dVar2;
                }
            } while (!g(abstractFuture, dVar2, dVar));
            return dVar2;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public k d(AbstractFuture<?> abstractFuture, k kVar) {
            k kVar2;
            do {
                kVar2 = abstractFuture.f24622c;
                if (kVar == kVar2) {
                    return kVar2;
                }
            } while (!b(abstractFuture, kVar2, kVar));
            return kVar2;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public void e(k kVar, k kVar2) {
            f24640a.putObject(kVar, f24645f, kVar2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public void f(k kVar, Thread thread) {
            f24640a.putObject(kVar, f24644e, thread);
        }

        public boolean g(AbstractFuture<?> abstractFuture, d dVar, d dVar2) {
            return f24640a.compareAndSwapObject(abstractFuture, f24641b, dVar, dVar2);
        }
    }

    /* loaded from: classes3.dex */
    public static final class k {

        /* renamed from: c, reason: collision with root package name */
        public static final k f24646c = new k(false);

        /* renamed from: a, reason: collision with root package name */
        public volatile Thread f24647a;

        /* renamed from: b, reason: collision with root package name */
        public volatile k f24648b;

        public k(boolean z10) {
        }

        public void a(k kVar) {
            AbstractFuture.f24618f.e(this, kVar);
        }

        public void b() {
            Thread thread = this.f24647a;
            if (thread != null) {
                this.f24647a = null;
                LockSupport.unpark(thread);
            }
        }

        public k() {
            AbstractFuture.f24618f.f(this, Thread.currentThread());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.logging.Logger] */
    /* JADX WARN: Type inference failed for: r12v0, types: [com.google.common.util.concurrent.AbstractFuture$e] */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.google.common.util.concurrent.AbstractFuture$a] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r5v2, types: [com.google.common.util.concurrent.AbstractFuture$j] */
    static {
        boolean z10;
        g gVar;
        try {
            z10 = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z10 = false;
        }
        f24616d = z10;
        f24617e = Logger.getLogger(AbstractFuture.class.getName());
        ?? r42 = 0;
        r42 = 0;
        try {
            gVar = new j();
            e = null;
        } catch (Error | RuntimeException e10) {
            e = e10;
            try {
                gVar = new e(AtomicReferenceFieldUpdater.newUpdater(k.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(k.class, k.class, com.heytap.accessory.e.f25269e), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, k.class, "c"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, d.class, com.heytap.accessory.e.f25269e), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Object.class, "a"));
            } catch (Error | RuntimeException e11) {
                gVar = new g();
                r42 = e11;
            }
        }
        f24618f = gVar;
        if (r42 != 0) {
            ?? r02 = f24617e;
            Level level = Level.SEVERE;
            r02.log(level, "UnsafeAtomicHelper is broken!", e);
            r02.log(level, "SafeAtomicHelper is broken!", r42);
        }
        f24619g = new Object();
    }

    public static CancellationException p(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    public static void r(AbstractFuture<?> abstractFuture, boolean z10) {
        d dVar = null;
        while (true) {
            abstractFuture.y();
            if (z10) {
                abstractFuture.w();
                z10 = false;
            }
            abstractFuture.m();
            d q10 = abstractFuture.q(dVar);
            while (q10 != null) {
                dVar = q10.f24632c;
                Runnable runnable = q10.f24630a;
                Objects.requireNonNull(runnable);
                Runnable runnable2 = runnable;
                if (runnable2 instanceof f) {
                    f fVar = (f) runnable2;
                    abstractFuture = fVar.f24638a;
                    if (abstractFuture.f24620a == fVar) {
                        if (f24618f.a(abstractFuture, fVar, u(fVar.f24639b))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    Executor executor = q10.f24631b;
                    Objects.requireNonNull(executor);
                    s(runnable2, executor);
                }
                q10 = dVar;
            }
            return;
        }
    }

    public static void s(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e10) {
            f24617e.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static Object u(com.google.common.util.concurrent.f<?> fVar) {
        Throwable a10;
        if (fVar instanceof h) {
            Object obj = ((AbstractFuture) fVar).f24620a;
            if (obj instanceof c) {
                c cVar = (c) obj;
                if (cVar.f24627a) {
                    obj = cVar.f24628b != null ? new c(false, cVar.f24628b) : c.f24626d;
                }
            }
            Objects.requireNonNull(obj);
            return obj;
        }
        if ((fVar instanceof D4.a) && (a10 = D4.b.a((D4.a) fVar)) != null) {
            return new Failure(a10);
        }
        boolean isCancelled = fVar.isCancelled();
        if ((!f24616d) & isCancelled) {
            c cVar2 = c.f24626d;
            Objects.requireNonNull(cVar2);
            return cVar2;
        }
        try {
            Object v10 = v(fVar);
            if (isCancelled) {
                return new c(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + fVar));
            }
            if (v10 == null) {
                return f24619g;
            }
            return v10;
        } catch (Error | RuntimeException e10) {
            return new Failure(e10);
        } catch (CancellationException e11) {
            if (!isCancelled) {
                return new Failure(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + fVar, e11));
            }
            return new c(false, e11);
        } catch (ExecutionException e12) {
            if (isCancelled) {
                return new c(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + fVar, e12));
            }
            return new Failure(e12.getCause());
        }
    }

    private static <V> V v(Future<V> future) {
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

    public boolean A(V v10) {
        if (v10 == null) {
            v10 = (V) f24619g;
        }
        if (!f24618f.a(this, null, v10)) {
            return false;
        }
        r(this, false);
        return true;
    }

    @Override // D4.a
    public final Throwable a() {
        if (this instanceof h) {
            Object obj = this.f24620a;
            if (obj instanceof Failure) {
                return ((Failure) obj).f24624a;
            }
            return null;
        }
        return null;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z10) {
        boolean z11;
        c cVar;
        boolean z12;
        Object obj = this.f24620a;
        if (obj == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!(z11 | (obj instanceof f))) {
            return false;
        }
        if (f24616d) {
            cVar = new c(z10, new CancellationException("Future.cancel() was called."));
        } else {
            if (z10) {
                cVar = c.f24625c;
            } else {
                cVar = c.f24626d;
            }
            Objects.requireNonNull(cVar);
        }
        boolean z13 = false;
        while (true) {
            if (f24618f.a(this, obj, cVar)) {
                r(this, z10);
                if (!(obj instanceof f)) {
                    return true;
                }
                com.google.common.util.concurrent.f<? extends V> fVar = ((f) obj).f24639b;
                if (fVar instanceof h) {
                    this = (AbstractFuture) fVar;
                    obj = this.f24620a;
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
                obj = this.f24620a;
                if (!(obj instanceof f)) {
                    return z13;
                }
            }
        }
    }

    @Override // java.util.concurrent.Future
    public V get(long j10, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j10);
        if (!Thread.interrupted()) {
            Object obj = this.f24620a;
            if ((obj != null) & (!(obj instanceof f))) {
                return t(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
            if (nanos >= 1000) {
                k kVar = this.f24622c;
                if (kVar != k.f24646c) {
                    k kVar2 = new k();
                    do {
                        kVar2.a(kVar);
                        if (f24618f.b(this, kVar, kVar2)) {
                            do {
                                com.google.common.util.concurrent.h.a(this, nanos);
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.f24620a;
                                    if ((obj2 != null) & (!(obj2 instanceof f))) {
                                        return t(obj2);
                                    }
                                    nanos = nanoTime - System.nanoTime();
                                } else {
                                    z(kVar2);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            z(kVar2);
                        } else {
                            kVar = this.f24622c;
                        }
                    } while (kVar != k.f24646c);
                }
                Object obj3 = this.f24620a;
                Objects.requireNonNull(obj3);
                return t(obj3);
            }
            while (nanos > 0) {
                Object obj4 = this.f24620a;
                if ((obj4 != null) & (!(obj4 instanceof f))) {
                    return t(obj4);
                }
                if (!Thread.interrupted()) {
                    nanos = nanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String abstractFuture = toString();
            String obj5 = timeUnit.toString();
            Locale locale = Locale.ROOT;
            String lowerCase = obj5.toLowerCase(locale);
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
            throw new TimeoutException(str + " for " + abstractFuture);
        }
        throw new InterruptedException();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.f24620a instanceof c;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        boolean z10;
        if (this.f24620a != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        return (!(r2 instanceof f)) & z10;
    }

    public final void k(StringBuilder sb) {
        try {
            Object v10 = v(this);
            sb.append("SUCCESS, result=[");
            n(sb, v10);
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

    public final void l(StringBuilder sb) {
        String str;
        int length = sb.length();
        sb.append("PENDING");
        Object obj = this.f24620a;
        if (obj instanceof f) {
            sb.append(", setFuture=[");
            o(sb, ((f) obj).f24639b);
            sb.append("]");
        } else {
            try {
                str = n.a(x());
            } catch (RuntimeException | StackOverflowError e10) {
                str = "Exception thrown from implementation: " + e10.getClass();
            }
            if (str != null) {
                sb.append(", info=[");
                sb.append(str);
                sb.append("]");
            }
        }
        if (isDone()) {
            sb.delete(length, sb.length());
            k(sb);
        }
    }

    public final void n(StringBuilder sb, Object obj) {
        if (obj == null) {
            sb.append("null");
        } else {
            if (obj == this) {
                sb.append("this future");
                return;
            }
            sb.append(obj.getClass().getName());
            sb.append("@");
            sb.append(Integer.toHexString(System.identityHashCode(obj)));
        }
    }

    public final void o(StringBuilder sb, Object obj) {
        try {
            if (obj == this) {
                sb.append("this future");
            } else {
                sb.append(obj);
            }
        } catch (RuntimeException | StackOverflowError e10) {
            sb.append("Exception thrown from implementation: ");
            sb.append(e10.getClass());
        }
    }

    public final d q(d dVar) {
        d c10 = f24618f.c(this, d.f24629d);
        d dVar2 = dVar;
        while (c10 != null) {
            d dVar3 = c10.f24632c;
            c10.f24632c = dVar2;
            dVar2 = c10;
            c10 = dVar3;
        }
        return dVar2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final V t(Object obj) {
        if (!(obj instanceof c)) {
            if (!(obj instanceof Failure)) {
                if (obj == f24619g) {
                    return (V) com.google.common.util.concurrent.g.a();
                }
                return obj;
            }
            throw new ExecutionException(((Failure) obj).f24624a);
        }
        throw p("Task was cancelled.", ((c) obj).f24628b);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (getClass().getName().startsWith("com.google.common.util.concurrent.")) {
            sb.append(getClass().getSimpleName());
        } else {
            sb.append(getClass().getName());
        }
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            k(sb);
        } else {
            l(sb);
        }
        sb.append("]");
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String x() {
        if (this instanceof ScheduledFuture) {
            return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
        }
        return null;
    }

    public final void y() {
        for (k d10 = f24618f.d(this, k.f24646c); d10 != null; d10 = d10.f24648b) {
            d10.b();
        }
    }

    public final void z(k kVar) {
        kVar.f24647a = null;
        while (true) {
            k kVar2 = this.f24622c;
            if (kVar2 == k.f24646c) {
                return;
            }
            k kVar3 = null;
            while (kVar2 != null) {
                k kVar4 = kVar2.f24648b;
                if (kVar2.f24647a != null) {
                    kVar3 = kVar2;
                } else if (kVar3 != null) {
                    kVar3.f24648b = kVar4;
                    if (kVar3.f24647a == null) {
                        break;
                    }
                } else if (!f24618f.b(this, kVar2, kVar4)) {
                    break;
                }
                kVar2 = kVar4;
            }
            return;
        }
    }

    public void m() {
    }

    public void w() {
    }

    @Override // java.util.concurrent.Future
    public V get() {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f24620a;
            if ((obj2 != null) & (!(obj2 instanceof f))) {
                return t(obj2);
            }
            k kVar = this.f24622c;
            if (kVar != k.f24646c) {
                k kVar2 = new k();
                do {
                    kVar2.a(kVar);
                    if (f24618f.b(this, kVar, kVar2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f24620a;
                            } else {
                                z(kVar2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof f))));
                        return t(obj);
                    }
                    kVar = this.f24622c;
                } while (kVar != k.f24646c);
            }
            Object obj3 = this.f24620a;
            Objects.requireNonNull(obj3);
            return t(obj3);
        }
        throw new InterruptedException();
    }
}
