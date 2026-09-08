package E9;

import java.util.concurrent.TimeUnit;
import kotlinx.coroutines.internal.D;
import kotlinx.coroutines.internal.F;

/* compiled from: Tasks.kt */
/* loaded from: classes4.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public static final String f756a = D.e("kotlinx.coroutines.scheduler.default.name", "DefaultDispatcher");

    /* renamed from: b, reason: collision with root package name */
    public static final long f757b;

    /* renamed from: c, reason: collision with root package name */
    public static final int f758c;

    /* renamed from: d, reason: collision with root package name */
    public static final int f759d;

    /* renamed from: e, reason: collision with root package name */
    public static final long f760e;

    /* renamed from: f, reason: collision with root package name */
    public static f f761f;

    /* renamed from: g, reason: collision with root package name */
    public static final h f762g;

    /* renamed from: h, reason: collision with root package name */
    public static final h f763h;

    static {
        long f10;
        int b10;
        int e10;
        int e11;
        long f11;
        f10 = F.f("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 0L, 0L, 12, null);
        f757b = f10;
        b10 = B9.i.b(D.a(), 2);
        e10 = F.e("kotlinx.coroutines.scheduler.core.pool.size", b10, 1, 0, 8, null);
        f758c = e10;
        e11 = F.e("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 0, 2097150, 4, null);
        f759d = e11;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f11 = F.f("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 0L, 0L, 12, null);
        f760e = timeUnit.toNanos(f11);
        f761f = d.f746a;
        f762g = new i(0);
        f763h = new i(1);
    }
}
