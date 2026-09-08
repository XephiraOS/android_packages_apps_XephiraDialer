package kotlinx.coroutines;

import java.util.concurrent.Executor;
import kotlin.coroutines.EmptyCoroutineContext;

/* compiled from: Executors.kt */
/* loaded from: classes4.dex */
public final class Q implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public final CoroutineDispatcher f34333a;

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        CoroutineDispatcher coroutineDispatcher = this.f34333a;
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.f34213a;
        if (coroutineDispatcher.g0(emptyCoroutineContext)) {
            this.f34333a.f0(emptyCoroutineContext, runnable);
        } else {
            runnable.run();
        }
    }

    public String toString() {
        return this.f34333a.toString();
    }
}
