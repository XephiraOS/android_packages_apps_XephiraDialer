package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.InterfaceC1266m;
import kotlinx.coroutines.L;

/* compiled from: LimitedDispatcher.kt */
/* loaded from: classes4.dex */
public final class l extends CoroutineDispatcher implements L {

    /* renamed from: h, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f34517h = AtomicIntegerFieldUpdater.newUpdater(l.class, "runningWorkers");

    /* renamed from: c, reason: collision with root package name */
    public final CoroutineDispatcher f34518c;

    /* renamed from: d, reason: collision with root package name */
    public final int f34519d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ L f34520e;

    /* renamed from: f, reason: collision with root package name */
    public final p<Runnable> f34521f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f34522g;
    private volatile int runningWorkers;

    /* compiled from: LimitedDispatcher.kt */
    /* loaded from: classes4.dex */
    public final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public Runnable f34523a;

        public a(Runnable runnable) {
            this.f34523a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i10 = 0;
            while (true) {
                try {
                    this.f34523a.run();
                } catch (Throwable th) {
                    kotlinx.coroutines.D.a(EmptyCoroutineContext.f34213a, th);
                }
                Runnable l02 = l.this.l0();
                if (l02 == null) {
                    return;
                }
                this.f34523a = l02;
                i10++;
                if (i10 >= 16 && l.this.f34518c.g0(l.this)) {
                    l.this.f34518c.f0(l.this, this);
                    return;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l(CoroutineDispatcher coroutineDispatcher, int i10) {
        L l10;
        this.f34518c = coroutineDispatcher;
        this.f34519d = i10;
        if (coroutineDispatcher instanceof L) {
            l10 = (L) coroutineDispatcher;
        } else {
            l10 = null;
        }
        this.f34520e = l10 == null ? kotlinx.coroutines.I.a() : l10;
        this.f34521f = new p<>(false);
        this.f34522g = new Object();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void f0(CoroutineContext coroutineContext, Runnable runnable) {
        Runnable l02;
        this.f34521f.a(runnable);
        if (f34517h.get(this) < this.f34519d && m0() && (l02 = l0()) != null) {
            this.f34518c.f0(this, new a(l02));
        }
    }

    public final Runnable l0() {
        while (true) {
            Runnable d10 = this.f34521f.d();
            if (d10 == null) {
                synchronized (this.f34522g) {
                    AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f34517h;
                    atomicIntegerFieldUpdater.decrementAndGet(this);
                    if (this.f34521f.c() == 0) {
                        return null;
                    }
                    atomicIntegerFieldUpdater.incrementAndGet(this);
                }
            } else {
                return d10;
            }
        }
    }

    public final boolean m0() {
        synchronized (this.f34522g) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f34517h;
            if (atomicIntegerFieldUpdater.get(this) >= this.f34519d) {
                return false;
            }
            atomicIntegerFieldUpdater.incrementAndGet(this);
            return true;
        }
    }

    @Override // kotlinx.coroutines.L
    public void s(long j10, InterfaceC1266m<? super m9.q> interfaceC1266m) {
        this.f34520e.s(j10, interfaceC1266m);
    }
}
