package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlinx.coroutines.C1244g;
import kotlinx.coroutines.S;

/* compiled from: PausingDispatcher.kt */
/* loaded from: classes.dex */
public final class PausingDispatcherKt {
    public static final <T> Object a(Lifecycle lifecycle, v9.p<? super kotlinx.coroutines.E, ? super kotlin.coroutines.c<? super T>, ? extends Object> pVar, kotlin.coroutines.c<? super T> cVar) {
        return c(lifecycle, Lifecycle.State.STARTED, pVar, cVar);
    }

    public static final <T> Object b(InterfaceC0492o interfaceC0492o, v9.p<? super kotlinx.coroutines.E, ? super kotlin.coroutines.c<? super T>, ? extends Object> pVar, kotlin.coroutines.c<? super T> cVar) {
        return a(interfaceC0492o.getLifecycle(), pVar, cVar);
    }

    public static final <T> Object c(Lifecycle lifecycle, Lifecycle.State state, v9.p<? super kotlinx.coroutines.E, ? super kotlin.coroutines.c<? super T>, ? extends Object> pVar, kotlin.coroutines.c<? super T> cVar) {
        return C1244g.g(S.c().i0(), new PausingDispatcherKt$whenStateAtLeast$2(lifecycle, state, pVar, null), cVar);
    }
}
