package kotlinx.coroutines.internal;

import java.util.Iterator;
import kotlin.coroutines.CoroutineContext;

/* compiled from: CoroutineExceptionHandlerImpl.common.kt */
/* renamed from: kotlinx.coroutines.internal.h, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1257h {
    public static final void a(CoroutineContext coroutineContext, Throwable th) {
        Iterator<kotlinx.coroutines.C> it = C1256g.a().iterator();
        while (it.hasNext()) {
            try {
                it.next().Z(coroutineContext, th);
            } catch (Throwable th2) {
                C1256g.b(kotlinx.coroutines.D.b(th, th2));
            }
        }
        try {
            m9.b.a(th, new DiagnosticCoroutineContextException(coroutineContext));
        } catch (Throwable unused) {
        }
        C1256g.b(th);
    }
}
