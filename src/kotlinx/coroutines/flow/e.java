package kotlinx.coroutines.flow;

import m9.q;

/* compiled from: Collect.kt */
/* loaded from: classes4.dex */
public final /* synthetic */ class e {
    public static final Object a(a<?> aVar, kotlin.coroutines.c<? super q> cVar) {
        Object c10;
        Object collect = aVar.collect(kotlinx.coroutines.flow.internal.i.f34463a, cVar);
        c10 = kotlin.coroutines.intrinsics.b.c();
        if (collect == c10) {
            return collect;
        }
        return q.f35511a;
    }

    public static final <T> Object b(a<? extends T> aVar, v9.p<? super T, ? super kotlin.coroutines.c<? super q>, ? extends Object> pVar, kotlin.coroutines.c<? super q> cVar) {
        a b10;
        Object c10;
        b10 = f.b(c.i(aVar, pVar), 0, null, 2, null);
        Object c11 = c.c(b10, cVar);
        c10 = kotlin.coroutines.intrinsics.b.c();
        if (c11 == c10) {
            return c11;
        }
        return q.f35511a;
    }
}
