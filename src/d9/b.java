package D9;

import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.jvm.internal.n;
import kotlinx.coroutines.C1282x;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.internal.y;
import kotlinx.coroutines.t0;
import p9.C1472f;
import v9.p;

/* compiled from: Undispatched.kt */
/* loaded from: classes4.dex */
public final class b {
    public static final <R, T> void a(p<? super R, ? super c<? super T>, ? extends Object> pVar, R r10, c<? super T> cVar) {
        Object c10;
        c a10 = C1472f.a(cVar);
        try {
            CoroutineContext context = cVar.getContext();
            Object c11 = ThreadContextKt.c(context, null);
            try {
                Object invoke = ((p) n.b(pVar, 2)).invoke(r10, a10);
                c10 = kotlin.coroutines.intrinsics.b.c();
                if (invoke != c10) {
                    a10.resumeWith(Result.b(invoke));
                }
            } finally {
                ThreadContextKt.a(context, c11);
            }
        } catch (Throwable th) {
            Result.a aVar = Result.f34166a;
            a10.resumeWith(Result.b(kotlin.b.a(th)));
        }
    }

    public static final <T, R> Object b(y<? super T> yVar, R r10, p<? super R, ? super c<? super T>, ? extends Object> pVar) {
        Object c1282x;
        Object c10;
        Object c11;
        Object c12;
        try {
            c1282x = ((p) n.b(pVar, 2)).invoke(r10, yVar);
        } catch (Throwable th) {
            c1282x = new C1282x(th, false, 2, null);
        }
        c10 = kotlin.coroutines.intrinsics.b.c();
        if (c1282x == c10) {
            c12 = kotlin.coroutines.intrinsics.b.c();
            return c12;
        }
        Object m02 = yVar.m0(c1282x);
        if (m02 == t0.f34636b) {
            c11 = kotlin.coroutines.intrinsics.b.c();
            return c11;
        }
        if (!(m02 instanceof C1282x)) {
            return t0.h(m02);
        }
        throw ((C1282x) m02).f34650a;
    }
}
