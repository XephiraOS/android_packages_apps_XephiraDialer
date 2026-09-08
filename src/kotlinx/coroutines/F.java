package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.C1255f;
import p9.C1472f;

/* compiled from: CoroutineScope.kt */
/* loaded from: classes4.dex */
public final class F {
    public static final E a(CoroutineContext coroutineContext) {
        InterfaceC1280v b10;
        if (coroutineContext.a(InterfaceC1265l0.f34546v) == null) {
            b10 = C1275q0.b(null, 1, null);
            coroutineContext = coroutineContext.r(b10);
        }
        return new C1255f(coroutineContext);
    }

    public static final E b() {
        return new C1255f(G0.b(null, 1, null).r(S.c()));
    }

    public static final void c(E e10, CancellationException cancellationException) {
        InterfaceC1265l0 interfaceC1265l0 = (InterfaceC1265l0) e10.s().a(InterfaceC1265l0.f34546v);
        if (interfaceC1265l0 != null) {
            interfaceC1265l0.e(cancellationException);
            return;
        }
        throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + e10).toString());
    }

    public static /* synthetic */ void d(E e10, CancellationException cancellationException, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            cancellationException = null;
        }
        c(e10, cancellationException);
    }

    public static final <R> Object e(v9.p<? super E, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar, kotlin.coroutines.c<? super R> cVar) {
        Object c10;
        kotlinx.coroutines.internal.y yVar = new kotlinx.coroutines.internal.y(cVar.getContext(), cVar);
        Object b10 = D9.b.b(yVar, yVar, pVar);
        c10 = kotlin.coroutines.intrinsics.b.c();
        if (b10 == c10) {
            C1472f.c(cVar);
        }
        return b10;
    }

    public static final boolean f(E e10) {
        InterfaceC1265l0 interfaceC1265l0 = (InterfaceC1265l0) e10.s().a(InterfaceC1265l0.f34546v);
        if (interfaceC1265l0 != null) {
            return interfaceC1265l0.c();
        }
        return true;
    }
}
