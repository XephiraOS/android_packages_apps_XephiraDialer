package kotlin.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.a;
import kotlin.jvm.internal.i;
import v9.l;

/* compiled from: CoroutineContextImpl.kt */
/* loaded from: classes4.dex */
public abstract class b<B extends CoroutineContext.a, E extends B> implements CoroutineContext.b<E> {

    /* renamed from: a, reason: collision with root package name */
    public final l<CoroutineContext.a, E> f34215a;

    /* renamed from: b, reason: collision with root package name */
    public final CoroutineContext.b<?> f34216b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.coroutines.CoroutineContext$b<?>] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r3v0, types: [v9.l<kotlin.coroutines.CoroutineContext$a, E extends B>, java.lang.Object, v9.l<? super kotlin.coroutines.CoroutineContext$a, ? extends E extends B>] */
    public b(CoroutineContext.b<B> baseKey, l<? super CoroutineContext.a, ? extends E> safeCast) {
        i.f(baseKey, "baseKey");
        i.f(safeCast, "safeCast");
        this.f34215a = safeCast;
        this.f34216b = baseKey instanceof b ? (CoroutineContext.b<B>) ((b) baseKey).f34216b : baseKey;
    }

    public final boolean a(CoroutineContext.b<?> key) {
        i.f(key, "key");
        if (key != this && this.f34216b != key) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Incorrect return type in method signature: (Lkotlin/coroutines/CoroutineContext$a;)TE; */
    public final CoroutineContext.a b(CoroutineContext.a element) {
        i.f(element, "element");
        return (CoroutineContext.a) this.f34215a.invoke(element);
    }
}
