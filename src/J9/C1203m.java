package j9;

import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: Deadline.java */
/* renamed from: j9.m, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1203m implements Comparable<C1203m> {

    /* renamed from: d, reason: collision with root package name */
    public static final b f34027d = new b();

    /* renamed from: e, reason: collision with root package name */
    public static final long f34028e;

    /* renamed from: f, reason: collision with root package name */
    public static final long f34029f;

    /* renamed from: g, reason: collision with root package name */
    public static final long f34030g;

    /* renamed from: a, reason: collision with root package name */
    public final c f34031a;

    /* renamed from: b, reason: collision with root package name */
    public final long f34032b;

    /* renamed from: c, reason: collision with root package name */
    public volatile boolean f34033c;

    /* compiled from: Deadline.java */
    /* renamed from: j9.m$b */
    /* loaded from: classes4.dex */
    public static class b extends c {
        public b() {
        }

        @Override // j9.C1203m.c
        public long a() {
            return System.nanoTime();
        }
    }

    /* compiled from: Deadline.java */
    /* renamed from: j9.m$c */
    /* loaded from: classes4.dex */
    public static abstract class c {
        public abstract long a();
    }

    static {
        long nanos = TimeUnit.DAYS.toNanos(36500L);
        f34028e = nanos;
        f34029f = -nanos;
        f34030g = TimeUnit.SECONDS.toNanos(1L);
    }

    public C1203m(c cVar, long j10, boolean z10) {
        this(cVar, cVar.a(), j10, z10);
    }

    public static C1203m a(long j10, TimeUnit timeUnit) {
        return b(j10, timeUnit, f34027d);
    }

    public static C1203m b(long j10, TimeUnit timeUnit, c cVar) {
        c(timeUnit, "units");
        return new C1203m(cVar, timeUnit.toNanos(j10), true);
    }

    public static <T> T c(T t10, Object obj) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static c f() {
        return f34027d;
    }

    public final void d(C1203m c1203m) {
        if (this.f34031a == c1203m.f34031a) {
            return;
        }
        throw new AssertionError("Tickers (" + this.f34031a + " and " + c1203m.f34031a + ") don't match. Custom Ticker should only be used in tests!");
    }

    @Override // java.lang.Comparable
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public int compareTo(C1203m c1203m) {
        d(c1203m);
        long j10 = this.f34032b - c1203m.f34032b;
        if (j10 < 0) {
            return -1;
        }
        if (j10 > 0) {
            return 1;
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1203m)) {
            return false;
        }
        C1203m c1203m = (C1203m) obj;
        c cVar = this.f34031a;
        if (cVar != null ? cVar != c1203m.f34031a : c1203m.f34031a != null) {
            return false;
        }
        if (this.f34032b == c1203m.f34032b) {
            return true;
        }
        return false;
    }

    public boolean g(C1203m c1203m) {
        d(c1203m);
        if (this.f34032b - c1203m.f34032b < 0) {
            return true;
        }
        return false;
    }

    public boolean h() {
        if (!this.f34033c) {
            if (this.f34032b - this.f34031a.a() <= 0) {
                this.f34033c = true;
            } else {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return Arrays.asList(this.f34031a, Long.valueOf(this.f34032b)).hashCode();
    }

    public C1203m i(C1203m c1203m) {
        d(c1203m);
        if (!g(c1203m)) {
            return c1203m;
        }
        return this;
    }

    public ScheduledFuture<?> j(Runnable runnable, ScheduledExecutorService scheduledExecutorService) {
        c(runnable, "task");
        c(scheduledExecutorService, "scheduler");
        return scheduledExecutorService.schedule(runnable, this.f34032b - this.f34031a.a(), TimeUnit.NANOSECONDS);
    }

    public long k(TimeUnit timeUnit) {
        long a10 = this.f34031a.a();
        if (!this.f34033c && this.f34032b - a10 <= 0) {
            this.f34033c = true;
        }
        return timeUnit.convert(this.f34032b - a10, TimeUnit.NANOSECONDS);
    }

    public String toString() {
        long k10 = k(TimeUnit.NANOSECONDS);
        long abs = Math.abs(k10);
        long j10 = f34030g;
        long j11 = abs / j10;
        long abs2 = Math.abs(k10) % j10;
        StringBuilder sb = new StringBuilder();
        if (k10 < 0) {
            sb.append('-');
        }
        sb.append(j11);
        if (abs2 > 0) {
            sb.append(String.format(Locale.US, ".%09d", Long.valueOf(abs2)));
        }
        sb.append("s from now");
        if (this.f34031a != f34027d) {
            sb.append(" (ticker=" + this.f34031a + ")");
        }
        return sb.toString();
    }

    public C1203m(c cVar, long j10, long j11, boolean z10) {
        this.f34031a = cVar;
        long min = Math.min(f34028e, Math.max(f34029f, j11));
        this.f34032b = j10 + min;
        this.f34033c = z10 && min <= 0;
    }
}
