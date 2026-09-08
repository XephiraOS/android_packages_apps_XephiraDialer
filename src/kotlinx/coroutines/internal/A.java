package kotlinx.coroutines.internal;

import kotlinx.coroutines.internal.z;

/* compiled from: ConcurrentLinkedList.kt */
/* loaded from: classes4.dex */
public final class A<S extends z<S>> {
    public static final S b(Object obj) {
        if (obj != C1253d.f34505a) {
            kotlin.jvm.internal.i.d(obj, "null cannot be cast to non-null type S of kotlinx.coroutines.internal.SegmentOrClosed");
            return (S) obj;
        }
        throw new IllegalStateException("Does not contain segment".toString());
    }

    public static final boolean c(Object obj) {
        if (obj == C1253d.f34505a) {
            return true;
        }
        return false;
    }

    public static <S extends z<S>> Object a(Object obj) {
        return obj;
    }
}
