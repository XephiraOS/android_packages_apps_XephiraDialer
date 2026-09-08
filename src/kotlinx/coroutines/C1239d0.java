package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* compiled from: Executors.kt */
/* renamed from: kotlinx.coroutines.d0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1239d0 {
    public static final CoroutineDispatcher a(Executor executor) {
        Q q10;
        CoroutineDispatcher coroutineDispatcher;
        if (executor instanceof Q) {
            q10 = (Q) executor;
        } else {
            q10 = null;
        }
        if (q10 == null || (coroutineDispatcher = q10.f34333a) == null) {
            return new C1237c0(executor);
        }
        return coroutineDispatcher;
    }

    public static final ExecutorCoroutineDispatcher b(ExecutorService executorService) {
        return new C1237c0(executorService);
    }
}
