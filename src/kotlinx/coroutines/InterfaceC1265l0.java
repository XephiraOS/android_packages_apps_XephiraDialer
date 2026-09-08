package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;

/* compiled from: Job.kt */
/* renamed from: kotlinx.coroutines.l0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public interface InterfaceC1265l0 extends CoroutineContext.a {

    /* renamed from: v, reason: collision with root package name */
    public static final b f34546v = b.f34547a;

    /* compiled from: Job.kt */
    /* renamed from: kotlinx.coroutines.l0$a */
    /* loaded from: classes4.dex */
    public static final class a {
        public static /* synthetic */ void a(InterfaceC1265l0 interfaceC1265l0, CancellationException cancellationException, int i10, Object obj) {
            if (obj == null) {
                if ((i10 & 1) != 0) {
                    cancellationException = null;
                }
                interfaceC1265l0.e(cancellationException);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        public static <R> R b(InterfaceC1265l0 interfaceC1265l0, R r10, v9.p<? super R, ? super CoroutineContext.a, ? extends R> pVar) {
            return (R) CoroutineContext.a.C0326a.a(interfaceC1265l0, r10, pVar);
        }

        public static <E extends CoroutineContext.a> E c(InterfaceC1265l0 interfaceC1265l0, CoroutineContext.b<E> bVar) {
            return (E) CoroutineContext.a.C0326a.b(interfaceC1265l0, bVar);
        }

        public static /* synthetic */ T d(InterfaceC1265l0 interfaceC1265l0, boolean z10, boolean z11, v9.l lVar, int i10, Object obj) {
            if (obj == null) {
                if ((i10 & 1) != 0) {
                    z10 = false;
                }
                if ((i10 & 2) != 0) {
                    z11 = true;
                }
                return interfaceC1265l0.O(z10, z11, lVar);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
        }

        public static CoroutineContext e(InterfaceC1265l0 interfaceC1265l0, CoroutineContext.b<?> bVar) {
            return CoroutineContext.a.C0326a.c(interfaceC1265l0, bVar);
        }

        public static CoroutineContext f(InterfaceC1265l0 interfaceC1265l0, CoroutineContext coroutineContext) {
            return CoroutineContext.a.C0326a.d(interfaceC1265l0, coroutineContext);
        }
    }

    /* compiled from: Job.kt */
    /* renamed from: kotlinx.coroutines.l0$b */
    /* loaded from: classes4.dex */
    public static final class b implements CoroutineContext.b<InterfaceC1265l0> {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ b f34547a = new b();
    }

    CancellationException B();

    T O(boolean z10, boolean z11, v9.l<? super Throwable, m9.q> lVar);

    boolean X();

    boolean c();

    InterfaceC1277s c0(InterfaceC1279u interfaceC1279u);

    void e(CancellationException cancellationException);

    InterfaceC1265l0 getParent();

    boolean isCancelled();

    boolean start();

    Object u(kotlin.coroutines.c<? super m9.q> cVar);
}
