package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

/* compiled from: Builders.kt */
/* renamed from: kotlinx.coroutines.h */
/* loaded from: classes4.dex */
public final /* synthetic */ class C1246h {
    public static final <T> T a(CoroutineContext coroutineContext, v9.p<? super E, ? super kotlin.coroutines.c<? super T>, ? extends Object> pVar) {
        W w10;
        W a10;
        CoroutineContext e10;
        Thread currentThread = Thread.currentThread();
        kotlin.coroutines.d dVar = (kotlin.coroutines.d) coroutineContext.a(kotlin.coroutines.d.f34217t);
        if (dVar == null) {
            a10 = I0.f34322a.b();
            e10 = CoroutineContextKt.e(C1241e0.f34422a, coroutineContext.r(a10));
        } else {
            W w11 = null;
            if (dVar instanceof W) {
                w10 = (W) dVar;
            } else {
                w10 = null;
            }
            if (w10 != null) {
                if (w10.w0()) {
                    w11 = w10;
                }
                if (w11 != null) {
                    a10 = w11;
                    e10 = CoroutineContextKt.e(C1241e0.f34422a, coroutineContext);
                }
            }
            a10 = I0.f34322a.a();
            e10 = CoroutineContextKt.e(C1241e0.f34422a, coroutineContext);
        }
        C1240e c1240e = new C1240e(e10, currentThread, a10);
        c1240e.M0(CoroutineStart.DEFAULT, c1240e, pVar);
        return (T) c1240e.N0();
    }

    public static /* synthetic */ Object b(CoroutineContext coroutineContext, v9.p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.f34213a;
        }
        return C1244g.e(coroutineContext, pVar);
    }
}
