package kotlin.coroutines;

import java.io.Serializable;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.i;
import v9.p;

/* compiled from: CoroutineContextImpl.kt */
/* loaded from: classes4.dex */
public final class EmptyCoroutineContext implements CoroutineContext, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public static final EmptyCoroutineContext f34213a = new EmptyCoroutineContext();
    private static final long serialVersionUID = 0;

    private EmptyCoroutineContext() {
    }

    private final Object readResolve() {
        return f34213a;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext L(CoroutineContext.b<?> key) {
        i.f(key, "key");
        return this;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.a> E a(CoroutineContext.b<E> key) {
        i.f(key, "key");
        return null;
    }

    public int hashCode() {
        return 0;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext r(CoroutineContext context) {
        i.f(context, "context");
        return context;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R y(R r10, p<? super R, ? super CoroutineContext.a, ? extends R> operation) {
        i.f(operation, "operation");
        return r10;
    }
}
