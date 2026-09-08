package kotlinx.coroutines.flow;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlinx.coroutines.C1268n;
import kotlinx.coroutines.internal.C;
import m9.q;
import p9.C1472f;

/* compiled from: StateFlow.kt */
/* loaded from: classes4.dex */
public final class o extends kotlinx.coroutines.flow.internal.c<StateFlowImpl<?>> {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f34474a = AtomicReferenceFieldUpdater.newUpdater(o.class, Object.class, "_state");
    private volatile Object _state;

    @Override // kotlinx.coroutines.flow.internal.c
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(StateFlowImpl<?> stateFlowImpl) {
        C c10;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f34474a;
        if (atomicReferenceFieldUpdater.get(this) == null) {
            c10 = n.f34472a;
            atomicReferenceFieldUpdater.set(this, c10);
            return true;
        }
        return false;
    }

    public final Object e(kotlin.coroutines.c<? super q> cVar) {
        kotlin.coroutines.c b10;
        C c10;
        Object c11;
        Object c12;
        b10 = IntrinsicsKt__IntrinsicsJvmKt.b(cVar);
        C1268n c1268n = new C1268n(b10, 1);
        c1268n.A();
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f34474a;
        c10 = n.f34472a;
        if (!atomicReferenceFieldUpdater.compareAndSet(this, c10, c1268n)) {
            Result.a aVar = Result.f34166a;
            c1268n.resumeWith(Result.b(q.f35511a));
        }
        Object x10 = c1268n.x();
        c11 = kotlin.coroutines.intrinsics.b.c();
        if (x10 == c11) {
            C1472f.c(cVar);
        }
        c12 = kotlin.coroutines.intrinsics.b.c();
        if (x10 == c12) {
            return x10;
        }
        return q.f35511a;
    }

    @Override // kotlinx.coroutines.flow.internal.c
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public kotlin.coroutines.c<q>[] b(StateFlowImpl<?> stateFlowImpl) {
        f34474a.set(this, null);
        return kotlinx.coroutines.flow.internal.b.f34458a;
    }

    public final void g() {
        C c10;
        C c11;
        C c12;
        C c13;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f34474a;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj != null) {
                c10 = n.f34473b;
                if (obj != c10) {
                    c11 = n.f34472a;
                    if (obj == c11) {
                        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f34474a;
                        c12 = n.f34473b;
                        if (atomicReferenceFieldUpdater2.compareAndSet(this, obj, c12)) {
                            return;
                        }
                    } else {
                        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = f34474a;
                        c13 = n.f34472a;
                        if (atomicReferenceFieldUpdater3.compareAndSet(this, obj, c13)) {
                            Result.a aVar = Result.f34166a;
                            ((C1268n) obj).resumeWith(Result.b(q.f35511a));
                            return;
                        }
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public final boolean h() {
        C c10;
        C c11;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f34474a;
        c10 = n.f34472a;
        Object andSet = atomicReferenceFieldUpdater.getAndSet(this, c10);
        kotlin.jvm.internal.i.c(andSet);
        c11 = n.f34473b;
        if (andSet == c11) {
            return true;
        }
        return false;
    }
}
