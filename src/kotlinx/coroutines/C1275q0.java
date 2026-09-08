package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;

/* compiled from: Job.kt */
/* renamed from: kotlinx.coroutines.q0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final /* synthetic */ class C1275q0 {
    public static final InterfaceC1280v a(InterfaceC1265l0 interfaceC1265l0) {
        return new C1269n0(interfaceC1265l0);
    }

    public static /* synthetic */ InterfaceC1280v b(InterfaceC1265l0 interfaceC1265l0, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            interfaceC1265l0 = null;
        }
        return C1271o0.a(interfaceC1265l0);
    }

    public static final void c(CoroutineContext coroutineContext, CancellationException cancellationException) {
        InterfaceC1265l0 interfaceC1265l0 = (InterfaceC1265l0) coroutineContext.a(InterfaceC1265l0.f34546v);
        if (interfaceC1265l0 != null) {
            interfaceC1265l0.e(cancellationException);
        }
    }

    public static /* synthetic */ void d(CoroutineContext coroutineContext, CancellationException cancellationException, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            cancellationException = null;
        }
        C1271o0.c(coroutineContext, cancellationException);
    }

    public static final void e(CoroutineContext coroutineContext) {
        InterfaceC1265l0 interfaceC1265l0 = (InterfaceC1265l0) coroutineContext.a(InterfaceC1265l0.f34546v);
        if (interfaceC1265l0 != null) {
            C1271o0.g(interfaceC1265l0);
        }
    }

    public static final void f(InterfaceC1265l0 interfaceC1265l0) {
        if (interfaceC1265l0.c()) {
        } else {
            throw interfaceC1265l0.B();
        }
    }
}
