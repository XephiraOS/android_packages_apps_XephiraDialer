package kotlinx.coroutines.channels;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.D;
import kotlinx.coroutines.channels.o;
import m9.q;

/* compiled from: Produce.kt */
/* loaded from: classes4.dex */
public final class k<E> extends b<E> implements l<E> {
    public k(CoroutineContext coroutineContext, a<E> aVar) {
        super(coroutineContext, aVar, true, true);
    }

    @Override // kotlinx.coroutines.AbstractC1232a
    public void K0(Throwable th, boolean z10) {
        if (!N0().d(th) && !z10) {
            D.a(getContext(), th);
        }
    }

    @Override // kotlinx.coroutines.AbstractC1232a
    /* renamed from: O0, reason: merged with bridge method [inline-methods] */
    public void L0(q qVar) {
        o.a.a(N0(), null, 1, null);
    }

    @Override // kotlinx.coroutines.AbstractC1232a, kotlinx.coroutines.s0, kotlinx.coroutines.InterfaceC1265l0
    public boolean c() {
        return super.c();
    }
}
