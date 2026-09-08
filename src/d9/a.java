package D9;

import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlinx.coroutines.internal.C1259j;
import m9.q;
import v9.l;
import v9.p;

/* compiled from: Cancellable.kt */
/* loaded from: classes4.dex */
public final class a {
    public static final void a(c<?> cVar, Throwable th) {
        Result.a aVar = Result.f34166a;
        cVar.resumeWith(Result.b(kotlin.b.a(th)));
        throw th;
    }

    public static final void b(c<? super q> cVar, c<?> cVar2) {
        c b10;
        try {
            b10 = IntrinsicsKt__IntrinsicsJvmKt.b(cVar);
            Result.a aVar = Result.f34166a;
            C1259j.c(b10, Result.b(q.f35511a), null, 2, null);
        } catch (Throwable th) {
            a(cVar2, th);
        }
    }

    public static final <R, T> void c(p<? super R, ? super c<? super T>, ? extends Object> pVar, R r10, c<? super T> cVar, l<? super Throwable, q> lVar) {
        c a10;
        c b10;
        try {
            a10 = IntrinsicsKt__IntrinsicsJvmKt.a(pVar, r10, cVar);
            b10 = IntrinsicsKt__IntrinsicsJvmKt.b(a10);
            Result.a aVar = Result.f34166a;
            C1259j.b(b10, Result.b(q.f35511a), lVar);
        } catch (Throwable th) {
            a(cVar, th);
        }
    }

    public static /* synthetic */ void d(p pVar, Object obj, c cVar, l lVar, int i10, Object obj2) {
        if ((i10 & 4) != 0) {
            lVar = null;
        }
        c(pVar, obj, cVar, lVar);
    }
}
