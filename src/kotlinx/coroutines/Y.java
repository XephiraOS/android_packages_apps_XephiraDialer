package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlinx.coroutines.X;

/* compiled from: EventLoop.kt */
/* loaded from: classes4.dex */
public abstract class Y extends W {
    public abstract Thread x0();

    public void y0(long j10, X.b bVar) {
        H.f34318i.I0(j10, bVar);
    }

    public final void z0() {
        Thread x02 = x0();
        if (Thread.currentThread() != x02) {
            C1236c.a();
            LockSupport.unpark(x02);
        }
    }
}
