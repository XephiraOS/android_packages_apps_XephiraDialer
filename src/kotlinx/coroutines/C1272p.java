package kotlinx.coroutines;

import kotlinx.coroutines.internal.C1258i;

/* compiled from: CancellableContinuation.kt */
/* renamed from: kotlinx.coroutines.p, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1272p {
    public static final void a(InterfaceC1266m<?> interfaceC1266m, T t10) {
        interfaceC1266m.i(new U(t10));
    }

    public static final <T> C1268n<T> b(kotlin.coroutines.c<? super T> cVar) {
        if (!(cVar instanceof C1258i)) {
            return new C1268n<>(cVar, 1);
        }
        C1268n<T> n10 = ((C1258i) cVar).n();
        if (n10 != null) {
            if (!n10.K()) {
                n10 = null;
            }
            if (n10 != null) {
                return n10;
            }
        }
        return new C1268n<>(cVar, 2);
    }
}
