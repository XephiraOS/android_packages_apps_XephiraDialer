package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import p9.C1472f;

/* compiled from: Delay.kt */
/* loaded from: classes4.dex */
public final class M {
    public static final Object a(long j10, kotlin.coroutines.c<? super m9.q> cVar) {
        kotlin.coroutines.c b10;
        Object c10;
        Object c11;
        if (j10 > 0) {
            b10 = IntrinsicsKt__IntrinsicsJvmKt.b(cVar);
            C1268n c1268n = new C1268n(b10, 1);
            c1268n.A();
            if (j10 < Long.MAX_VALUE) {
                b(c1268n.getContext()).s(j10, c1268n);
            }
            Object x10 = c1268n.x();
            c10 = kotlin.coroutines.intrinsics.b.c();
            if (x10 == c10) {
                C1472f.c(cVar);
            }
            c11 = kotlin.coroutines.intrinsics.b.c();
            if (x10 == c11) {
                return x10;
            }
            return m9.q.f35511a;
        }
        return m9.q.f35511a;
    }

    public static final L b(CoroutineContext coroutineContext) {
        L l10;
        CoroutineContext.a a10 = coroutineContext.a(kotlin.coroutines.d.f34217t);
        if (a10 instanceof L) {
            l10 = (L) a10;
        } else {
            l10 = null;
        }
        if (l10 == null) {
            return I.a();
        }
        return l10;
    }
}
