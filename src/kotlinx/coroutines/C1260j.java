package kotlinx.coroutines;

import java.util.concurrent.Future;

/* compiled from: Future.kt */
/* renamed from: kotlinx.coroutines.j, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1260j extends AbstractC1262k {

    /* renamed from: a, reason: collision with root package name */
    public final Future<?> f34542a;

    public C1260j(Future<?> future) {
        this.f34542a = future;
    }

    @Override // kotlinx.coroutines.AbstractC1264l
    public void f(Throwable th) {
        if (th != null) {
            this.f34542a.cancel(false);
        }
    }

    @Override // v9.l
    public /* bridge */ /* synthetic */ m9.q invoke(Throwable th) {
        f(th);
        return m9.q.f35511a;
    }

    public String toString() {
        return "CancelFutureOnCancel[" + this.f34542a + ']';
    }
}
