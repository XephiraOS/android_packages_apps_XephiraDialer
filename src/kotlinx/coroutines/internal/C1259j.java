package kotlinx.coroutines.internal;

import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.I0;
import kotlinx.coroutines.InterfaceC1265l0;
import kotlinx.coroutines.O0;
import kotlinx.coroutines.W;

/* compiled from: DispatchedContinuation.kt */
/* renamed from: kotlinx.coroutines.internal.j */
/* loaded from: classes4.dex */
public final class C1259j {

    /* renamed from: a */
    public static final C f34515a = new C("UNDEFINED");

    /* renamed from: b */
    public static final C f34516b = new C("REUSABLE_CLAIMED");

    public static final <T> void b(kotlin.coroutines.c<? super T> cVar, Object obj, v9.l<? super Throwable, m9.q> lVar) {
        O0<?> o02;
        if (cVar instanceof C1258i) {
            C1258i c1258i = (C1258i) cVar;
            Object c10 = kotlinx.coroutines.A.c(obj, lVar);
            if (c1258i.f34511d.g0(c1258i.getContext())) {
                c1258i.f34513f = c10;
                c1258i.f34330c = 1;
                c1258i.f34511d.f0(c1258i.getContext(), c1258i);
                return;
            }
            W b10 = I0.f34322a.b();
            if (b10.s0()) {
                c1258i.f34513f = c10;
                c1258i.f34330c = 1;
                b10.m0(c1258i);
                return;
            }
            b10.q0(true);
            try {
                InterfaceC1265l0 interfaceC1265l0 = (InterfaceC1265l0) c1258i.getContext().a(InterfaceC1265l0.f34546v);
                if (interfaceC1265l0 != null && !interfaceC1265l0.c()) {
                    CancellationException B10 = interfaceC1265l0.B();
                    c1258i.a(c10, B10);
                    Result.a aVar = Result.f34166a;
                    c1258i.resumeWith(Result.b(kotlin.b.a(B10)));
                } else {
                    kotlin.coroutines.c<T> cVar2 = c1258i.f34512e;
                    Object obj2 = c1258i.f34514g;
                    CoroutineContext context = cVar2.getContext();
                    Object c11 = ThreadContextKt.c(context, obj2);
                    if (c11 != ThreadContextKt.f34495a) {
                        o02 = CoroutineContextKt.g(cVar2, context, c11);
                    } else {
                        o02 = null;
                    }
                    try {
                        c1258i.f34512e.resumeWith(obj);
                        m9.q qVar = m9.q.f35511a;
                    } finally {
                        if (o02 == null || o02.N0()) {
                            ThreadContextKt.a(context, c11);
                        }
                    }
                }
                do {
                } while (b10.v0());
            } finally {
                try {
                    return;
                } finally {
                }
            }
            return;
        }
        cVar.resumeWith(obj);
    }

    public static /* synthetic */ void c(kotlin.coroutines.c cVar, Object obj, v9.l lVar, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            lVar = null;
        }
        b(cVar, obj, lVar);
    }
}
