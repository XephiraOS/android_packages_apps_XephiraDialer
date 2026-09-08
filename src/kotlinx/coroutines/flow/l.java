package kotlinx.coroutines.flow;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.internal.C;

/* compiled from: SharedFlow.kt */
/* loaded from: classes4.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public static final C f34471a = new C("NO_VALUE");

    public static final <T> a<T> a(k<? extends T> kVar, CoroutineContext coroutineContext, int i10, BufferOverflow bufferOverflow) {
        if ((i10 == 0 || i10 == -3) && bufferOverflow == BufferOverflow.SUSPEND) {
            return kVar;
        }
        return new kotlinx.coroutines.flow.internal.e(kVar, coroutineContext, i10, bufferOverflow);
    }
}
