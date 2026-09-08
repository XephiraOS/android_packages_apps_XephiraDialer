package E9;

/* compiled from: Dispatcher.kt */
/* loaded from: classes4.dex */
public final class b extends e {

    /* renamed from: i, reason: collision with root package name */
    public static final b f745i = new b();

    public b() {
        super(k.f758c, k.f759d, k.f760e, k.f756a);
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        return "Dispatchers.Default";
    }
}
