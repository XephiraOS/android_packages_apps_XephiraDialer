package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.d;
import kotlinx.coroutines.internal.ThreadContextKt;
import p9.C1472f;

/* compiled from: Builders.common.kt */
/* renamed from: kotlinx.coroutines.i */
/* loaded from: classes4.dex */
public final /* synthetic */ class C1248i {
    public static final <T> J<T> a(E e10, CoroutineContext coroutineContext, CoroutineStart coroutineStart, v9.p<? super E, ? super kotlin.coroutines.c<? super T>, ? extends Object> pVar) {
        K k10;
        CoroutineContext e11 = CoroutineContextKt.e(e10, coroutineContext);
        if (coroutineStart.c()) {
            k10 = new u0(e11, pVar);
        } else {
            k10 = new K(e11, true);
        }
        ((AbstractC1232a) k10).M0(coroutineStart, k10, pVar);
        return (J<T>) k10;
    }

    public static /* synthetic */ J b(E e10, CoroutineContext coroutineContext, CoroutineStart coroutineStart, v9.p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.f34213a;
        }
        if ((i10 & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return C1244g.a(e10, coroutineContext, coroutineStart, pVar);
    }

    public static final InterfaceC1265l0 c(E e10, CoroutineContext coroutineContext, CoroutineStart coroutineStart, v9.p<? super E, ? super kotlin.coroutines.c<? super m9.q>, ? extends Object> pVar) {
        AbstractC1232a e02;
        CoroutineContext e11 = CoroutineContextKt.e(e10, coroutineContext);
        if (coroutineStart.c()) {
            e02 = new v0(e11, pVar);
        } else {
            e02 = new E0(e11, true);
        }
        e02.M0(coroutineStart, e02, pVar);
        return e02;
    }

    public static /* synthetic */ InterfaceC1265l0 d(E e10, CoroutineContext coroutineContext, CoroutineStart coroutineStart, v9.p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.f34213a;
        }
        if ((i10 & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return C1244g.c(e10, coroutineContext, coroutineStart, pVar);
    }

    public static final <T> Object e(CoroutineContext coroutineContext, v9.p<? super E, ? super kotlin.coroutines.c<? super T>, ? extends Object> pVar, kotlin.coroutines.c<? super T> cVar) {
        Object N02;
        Object c10;
        CoroutineContext context = cVar.getContext();
        CoroutineContext d10 = CoroutineContextKt.d(context, coroutineContext);
        C1271o0.f(d10);
        if (d10 == context) {
            kotlinx.coroutines.internal.y yVar = new kotlinx.coroutines.internal.y(d10, cVar);
            N02 = D9.b.b(yVar, yVar, pVar);
        } else {
            d.b bVar = kotlin.coroutines.d.f34217t;
            if (kotlin.jvm.internal.i.b(d10.a(bVar), context.a(bVar))) {
                O0 o02 = new O0(d10, cVar);
                CoroutineContext context2 = o02.getContext();
                Object c11 = ThreadContextKt.c(context2, null);
                try {
                    Object b10 = D9.b.b(o02, o02, pVar);
                    ThreadContextKt.a(context2, c11);
                    N02 = b10;
                } catch (Throwable th) {
                    ThreadContextKt.a(context2, c11);
                    throw th;
                }
            } else {
                N n10 = new N(d10, cVar);
                D9.a.d(pVar, n10, n10, null, 4, null);
                N02 = n10.N0();
            }
        }
        c10 = kotlin.coroutines.intrinsics.b.c();
        if (N02 == c10) {
            C1472f.c(cVar);
        }
        return N02;
    }
}
