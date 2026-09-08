package kotlinx.coroutines;

import java.io.Closeable;
import kotlin.coroutines.CoroutineContext;

/* compiled from: Executors.kt */
/* loaded from: classes4.dex */
public abstract class ExecutorCoroutineDispatcher extends CoroutineDispatcher implements Closeable {

    /* renamed from: c, reason: collision with root package name */
    public static final Key f34316c = new Key(null);

    /* compiled from: Executors.kt */
    /* loaded from: classes4.dex */
    public static final class Key extends kotlin.coroutines.b<CoroutineDispatcher, ExecutorCoroutineDispatcher> {
        public /* synthetic */ Key(kotlin.jvm.internal.f fVar) {
            this();
        }

        public Key() {
            super(CoroutineDispatcher.f34306b, new v9.l<CoroutineContext.a, ExecutorCoroutineDispatcher>() { // from class: kotlinx.coroutines.ExecutorCoroutineDispatcher.Key.1
                @Override // v9.l
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final ExecutorCoroutineDispatcher invoke(CoroutineContext.a aVar) {
                    if (aVar instanceof ExecutorCoroutineDispatcher) {
                        return (ExecutorCoroutineDispatcher) aVar;
                    }
                    return null;
                }
            });
        }
    }

    public abstract void close();
}
