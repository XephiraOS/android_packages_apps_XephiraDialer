package kotlinx.coroutines;

import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.C1258i;
import kotlinx.coroutines.internal.ThreadContextKt;

/* compiled from: DispatchedTask.kt */
/* loaded from: classes4.dex */
public final class P {
    public static final <T> void a(O<? super T> o10, int i10) {
        boolean z10;
        kotlin.coroutines.c<? super T> d10 = o10.d();
        if (i10 == 4) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10 && (d10 instanceof C1258i) && b(i10) == b(o10.f34330c)) {
            CoroutineDispatcher coroutineDispatcher = ((C1258i) d10).f34511d;
            CoroutineContext context = d10.getContext();
            if (coroutineDispatcher.g0(context)) {
                coroutineDispatcher.f0(context, o10);
                return;
            } else {
                e(o10);
                return;
            }
        }
        d(o10, d10, z10);
    }

    public static final boolean b(int i10) {
        if (i10 == 1 || i10 == 2) {
            return true;
        }
        return false;
    }

    public static final boolean c(int i10) {
        if (i10 == 2) {
            return true;
        }
        return false;
    }

    public static final <T> void d(O<? super T> o10, kotlin.coroutines.c<? super T> cVar, boolean z10) {
        Object g10;
        O0<?> o02;
        boolean N02;
        Object k10 = o10.k();
        Throwable e10 = o10.e(k10);
        if (e10 != null) {
            Result.a aVar = Result.f34166a;
            g10 = kotlin.b.a(e10);
        } else {
            Result.a aVar2 = Result.f34166a;
            g10 = o10.g(k10);
        }
        Object b10 = Result.b(g10);
        if (z10) {
            kotlin.jvm.internal.i.d(cVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
            C1258i c1258i = (C1258i) cVar;
            kotlin.coroutines.c<T> cVar2 = c1258i.f34512e;
            Object obj = c1258i.f34514g;
            CoroutineContext context = cVar2.getContext();
            Object c10 = ThreadContextKt.c(context, obj);
            if (c10 != ThreadContextKt.f34495a) {
                o02 = CoroutineContextKt.g(cVar2, context, c10);
            } else {
                o02 = null;
            }
            try {
                c1258i.f34512e.resumeWith(b10);
                m9.q qVar = m9.q.f35511a;
                if (o02 != null) {
                    if (!N02) {
                        return;
                    }
                }
                return;
            } finally {
                if (o02 == null || o02.N0()) {
                    ThreadContextKt.a(context, c10);
                }
            }
        }
        cVar.resumeWith(b10);
    }

    public static final void e(O<?> o10) {
        W b10 = I0.f34322a.b();
        if (b10.s0()) {
            b10.m0(o10);
            return;
        }
        b10.q0(true);
        try {
            d(o10, o10.d(), true);
            do {
            } while (b10.v0());
        } finally {
            try {
            } finally {
            }
        }
    }
}
