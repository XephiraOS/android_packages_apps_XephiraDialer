package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.C1257h;

/* compiled from: CoroutineExceptionHandler.kt */
/* loaded from: classes4.dex */
public final class D {
    public static final void a(CoroutineContext coroutineContext, Throwable th) {
        try {
            C c10 = (C) coroutineContext.a(C.f34301u);
            if (c10 != null) {
                c10.Z(coroutineContext, th);
            } else {
                C1257h.a(coroutineContext, th);
            }
        } catch (Throwable th2) {
            C1257h.a(coroutineContext, b(th, th2));
        }
    }

    public static final Throwable b(Throwable th, Throwable th2) {
        if (th == th2) {
            return th;
        }
        RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
        m9.b.a(runtimeException, th);
        return runtimeException;
    }
}
