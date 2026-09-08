package E9;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.scheduling.CoroutineScheduler;

/* compiled from: Dispatcher.kt */
/* loaded from: classes4.dex */
public class e extends ExecutorCoroutineDispatcher {

    /* renamed from: d, reason: collision with root package name */
    public final int f747d;

    /* renamed from: e, reason: collision with root package name */
    public final int f748e;

    /* renamed from: f, reason: collision with root package name */
    public final long f749f;

    /* renamed from: g, reason: collision with root package name */
    public final String f750g;

    /* renamed from: h, reason: collision with root package name */
    public CoroutineScheduler f751h = i0();

    public e(int i10, int i11, long j10, String str) {
        this.f747d = i10;
        this.f748e = i11;
        this.f749f = j10;
        this.f750g = str;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void f0(CoroutineContext coroutineContext, Runnable runnable) {
        CoroutineScheduler.r(this.f751h, runnable, null, false, 6, null);
    }

    public final CoroutineScheduler i0() {
        return new CoroutineScheduler(this.f747d, this.f748e, this.f749f, this.f750g);
    }

    public final void j0(Runnable runnable, h hVar, boolean z10) {
        this.f751h.o(runnable, hVar, z10);
    }
}
