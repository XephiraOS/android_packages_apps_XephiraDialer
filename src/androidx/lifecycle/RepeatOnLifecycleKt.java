package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;

/* compiled from: RepeatOnLifecycle.kt */
/* loaded from: classes.dex */
public final class RepeatOnLifecycleKt {
    public static final Object a(Lifecycle lifecycle, Lifecycle.State state, v9.p<? super kotlinx.coroutines.E, ? super kotlin.coroutines.c<? super m9.q>, ? extends Object> pVar, kotlin.coroutines.c<? super m9.q> cVar) {
        Object c10;
        if (state != Lifecycle.State.INITIALIZED) {
            if (lifecycle.b() == Lifecycle.State.DESTROYED) {
                return m9.q.f35511a;
            }
            Object e10 = kotlinx.coroutines.F.e(new RepeatOnLifecycleKt$repeatOnLifecycle$3(lifecycle, state, pVar, null), cVar);
            c10 = kotlin.coroutines.intrinsics.b.c();
            if (e10 == c10) {
                return e10;
            }
            return m9.q.f35511a;
        }
        throw new IllegalArgumentException("repeatOnLifecycle cannot start work with the INITIALIZED lifecycle state.".toString());
    }

    public static final Object b(InterfaceC0492o interfaceC0492o, Lifecycle.State state, v9.p<? super kotlinx.coroutines.E, ? super kotlin.coroutines.c<? super m9.q>, ? extends Object> pVar, kotlin.coroutines.c<? super m9.q> cVar) {
        Object c10;
        Object a10 = a(interfaceC0492o.getLifecycle(), state, pVar, cVar);
        c10 = kotlin.coroutines.intrinsics.b.c();
        if (a10 == c10) {
            return a10;
        }
        return m9.q.f35511a;
    }
}
