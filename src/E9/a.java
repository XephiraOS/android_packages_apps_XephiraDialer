package E9;

import java.util.concurrent.Executor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.internal.D;
import kotlinx.coroutines.internal.F;

/* compiled from: Dispatcher.kt */
/* loaded from: classes4.dex */
public final class a extends ExecutorCoroutineDispatcher implements Executor {

    /* renamed from: d, reason: collision with root package name */
    public static final a f743d = new a();

    /* renamed from: e, reason: collision with root package name */
    public static final CoroutineDispatcher f744e;

    static {
        int b10;
        int e10;
        l lVar = l.f764c;
        b10 = B9.i.b(64, D.a());
        e10 = F.e("kotlinx.coroutines.io.parallelism", b10, 0, 0, 12, null);
        f744e = lVar.h0(e10);
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO".toString());
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        f0(EmptyCoroutineContext.f34213a, runnable);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void f0(CoroutineContext coroutineContext, Runnable runnable) {
        f744e.f0(coroutineContext, runnable);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        return "Dispatchers.IO";
    }
}
