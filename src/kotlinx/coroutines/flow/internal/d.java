package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.n;
import kotlinx.coroutines.internal.ThreadContextKt;
import p9.C1472f;
import v9.p;

/* compiled from: ChannelFlow.kt */
/* loaded from: classes4.dex */
public final class d {
    public static final <T, V> Object b(CoroutineContext coroutineContext, V v10, Object obj, p<? super V, ? super kotlin.coroutines.c<? super T>, ? extends Object> pVar, kotlin.coroutines.c<? super T> cVar) {
        Object c10;
        Object c11 = ThreadContextKt.c(coroutineContext, obj);
        try {
            Object invoke = ((p) n.b(pVar, 2)).invoke(v10, new l(cVar, coroutineContext));
            ThreadContextKt.a(coroutineContext, c11);
            c10 = kotlin.coroutines.intrinsics.b.c();
            if (invoke == c10) {
                C1472f.c(cVar);
            }
            return invoke;
        } catch (Throwable th) {
            ThreadContextKt.a(coroutineContext, c11);
            throw th;
        }
    }

    public static /* synthetic */ Object c(CoroutineContext coroutineContext, Object obj, Object obj2, p pVar, kotlin.coroutines.c cVar, int i10, Object obj3) {
        if ((i10 & 4) != 0) {
            obj2 = ThreadContextKt.b(coroutineContext);
        }
        return b(coroutineContext, obj, obj2, pVar, cVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> kotlinx.coroutines.flow.b<T> d(kotlinx.coroutines.flow.b<? super T> bVar, CoroutineContext coroutineContext) {
        if (!(bVar instanceof k) && !(bVar instanceof i)) {
            return new UndispatchedContextCollector(bVar, coroutineContext);
        }
        return bVar;
    }
}
