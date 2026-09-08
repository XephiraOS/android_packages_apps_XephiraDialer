package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.AbstractC1232a;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.s0;
import m9.q;

/* compiled from: ChannelCoroutine.kt */
/* loaded from: classes4.dex */
public class b<E> extends AbstractC1232a<q> implements a<E> {

    /* renamed from: d, reason: collision with root package name */
    public final a<E> f34408d;

    public b(CoroutineContext coroutineContext, a<E> aVar, boolean z10, boolean z11) {
        super(coroutineContext, z10, z11);
        this.f34408d = aVar;
    }

    @Override // kotlinx.coroutines.s0
    public void C(Throwable th) {
        CancellationException C02 = s0.C0(this, th, null, 1, null);
        this.f34408d.e(C02);
        z(C02);
    }

    public final a<E> N0() {
        return this.f34408d;
    }

    @Override // kotlinx.coroutines.channels.o
    public boolean d(Throwable th) {
        return this.f34408d.d(th);
    }

    @Override // kotlinx.coroutines.s0, kotlinx.coroutines.InterfaceC1265l0, kotlinx.coroutines.channels.n
    public final void e(CancellationException cancellationException) {
        if (isCancelled()) {
            return;
        }
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(F(), null, this);
        }
        C(cancellationException);
    }

    @Override // kotlinx.coroutines.channels.n
    public c<E> iterator() {
        return this.f34408d.iterator();
    }

    @Override // kotlinx.coroutines.channels.o
    public Object j(E e10) {
        return this.f34408d.j(e10);
    }

    @Override // kotlinx.coroutines.channels.o
    public Object k(E e10, kotlin.coroutines.c<? super q> cVar) {
        return this.f34408d.k(e10, cVar);
    }
}
