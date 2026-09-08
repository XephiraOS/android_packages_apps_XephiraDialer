package com.google.common.base;

import java.util.concurrent.TimeUnit;

/* compiled from: Stopwatch.java */
/* loaded from: classes3.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final r f24334a = r.b();

    /* renamed from: b, reason: collision with root package name */
    public boolean f24335b;

    /* renamed from: c, reason: collision with root package name */
    public long f24336c;

    /* renamed from: d, reason: collision with root package name */
    public long f24337d;

    /* compiled from: Stopwatch.java */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f24338a;

        static {
            int[] iArr = new int[TimeUnit.values().length];
            f24338a = iArr;
            try {
                iArr[TimeUnit.NANOSECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f24338a[TimeUnit.MICROSECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f24338a[TimeUnit.MILLISECONDS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f24338a[TimeUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f24338a[TimeUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f24338a[TimeUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f24338a[TimeUnit.DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static String a(TimeUnit timeUnit) {
        switch (a.f24338a[timeUnit.ordinal()]) {
            case 1:
                return "ns";
            case 2:
                return "μs";
            case 3:
                return "ms";
            case 4:
                return "s";
            case 5:
                return "min";
            case 6:
                return "h";
            case 7:
                return com.android.contacts.list.d.f16900U;
            default:
                throw new AssertionError();
        }
    }

    public static TimeUnit b(long j10) {
        TimeUnit timeUnit = TimeUnit.DAYS;
        TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
        if (timeUnit.convert(j10, timeUnit2) > 0) {
            return timeUnit;
        }
        TimeUnit timeUnit3 = TimeUnit.HOURS;
        if (timeUnit3.convert(j10, timeUnit2) > 0) {
            return timeUnit3;
        }
        TimeUnit timeUnit4 = TimeUnit.MINUTES;
        if (timeUnit4.convert(j10, timeUnit2) > 0) {
            return timeUnit4;
        }
        TimeUnit timeUnit5 = TimeUnit.SECONDS;
        if (timeUnit5.convert(j10, timeUnit2) > 0) {
            return timeUnit5;
        }
        TimeUnit timeUnit6 = TimeUnit.MILLISECONDS;
        if (timeUnit6.convert(j10, timeUnit2) > 0) {
            return timeUnit6;
        }
        TimeUnit timeUnit7 = TimeUnit.MICROSECONDS;
        if (timeUnit7.convert(j10, timeUnit2) > 0) {
            return timeUnit7;
        }
        return timeUnit2;
    }

    public static m c() {
        return new m();
    }

    public long d(TimeUnit timeUnit) {
        return timeUnit.convert(e(), TimeUnit.NANOSECONDS);
    }

    public final long e() {
        if (this.f24335b) {
            return (this.f24334a.a() - this.f24337d) + this.f24336c;
        }
        return this.f24336c;
    }

    public m f() {
        this.f24336c = 0L;
        this.f24335b = false;
        return this;
    }

    public m g() {
        k.v(!this.f24335b, "This stopwatch is already running.");
        this.f24335b = true;
        this.f24337d = this.f24334a.a();
        return this;
    }

    public String toString() {
        long e10 = e();
        TimeUnit b10 = b(e10);
        return j.b(e10 / TimeUnit.NANOSECONDS.convert(1L, b10)) + " " + a(b10);
    }
}
