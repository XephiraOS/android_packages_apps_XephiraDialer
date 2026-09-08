package kotlinx.coroutines.flow;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.internal.C;

/* compiled from: StateFlow.kt */
/* loaded from: classes4.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public static final C f34472a = new C("NONE");

    /* renamed from: b, reason: collision with root package name */
    public static final C f34473b = new C("PENDING");

    public static final <T> i<T> a(T t10) {
        if (t10 == null) {
            t10 = (T) kotlinx.coroutines.flow.internal.j.f34464a;
        }
        return new StateFlowImpl(t10);
    }

    public static final <T> a<T> d(m<? extends T> mVar, CoroutineContext coroutineContext, int i10, BufferOverflow bufferOverflow) {
        if (((i10 >= 0 && i10 < 2) || i10 == -2) && bufferOverflow == BufferOverflow.DROP_OLDEST) {
            return mVar;
        }
        return l.a(mVar, coroutineContext, i10, bufferOverflow);
    }
}
