package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: Atomic.kt */
/* renamed from: kotlinx.coroutines.internal.b, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1251b<T> extends v {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f34503a = AtomicReferenceFieldUpdater.newUpdater(AbstractC1251b.class, Object.class, "_consensus");
    private volatile Object _consensus = C1250a.f34502a;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.internal.v
    public final Object a(Object obj) {
        Object obj2 = f34503a.get(this);
        if (obj2 == C1250a.f34502a) {
            obj2 = c(d(obj));
        }
        b(obj, obj2);
        return obj2;
    }

    public abstract void b(T t10, Object obj);

    public final Object c(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f34503a;
        Object obj2 = atomicReferenceFieldUpdater.get(this);
        Object obj3 = C1250a.f34502a;
        if (obj2 != obj3) {
            return obj2;
        }
        if (atomicReferenceFieldUpdater.compareAndSet(this, obj3, obj)) {
            return obj;
        }
        return atomicReferenceFieldUpdater.get(this);
    }

    public abstract Object d(T t10);
}
