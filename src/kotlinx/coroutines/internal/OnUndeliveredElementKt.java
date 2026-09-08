package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;

/* compiled from: OnUndeliveredElement.kt */
/* loaded from: classes4.dex */
public final class OnUndeliveredElementKt {
    public static final <E> v9.l<Throwable, m9.q> a(final v9.l<? super E, m9.q> lVar, final E e10, final CoroutineContext coroutineContext) {
        return new v9.l<Throwable, m9.q>() { // from class: kotlinx.coroutines.internal.OnUndeliveredElementKt$bindCancellationFun$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public final void b(Throwable th) {
                OnUndeliveredElementKt.b(lVar, e10, coroutineContext);
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ m9.q invoke(Throwable th) {
                b(th);
                return m9.q.f35511a;
            }
        };
    }

    public static final <E> void b(v9.l<? super E, m9.q> lVar, E e10, CoroutineContext coroutineContext) {
        UndeliveredElementException c10 = c(lVar, e10, null);
        if (c10 != null) {
            kotlinx.coroutines.D.a(coroutineContext, c10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <E> UndeliveredElementException c(v9.l<? super E, m9.q> lVar, E e10, UndeliveredElementException undeliveredElementException) {
        try {
            lVar.invoke(e10);
        } catch (Throwable th) {
            if (undeliveredElementException != null && undeliveredElementException.getCause() != th) {
                m9.b.a(undeliveredElementException, th);
            } else {
                return new UndeliveredElementException("Exception in undelivered element handler for " + e10, th);
            }
        }
        return undeliveredElementException;
    }

    public static /* synthetic */ UndeliveredElementException d(v9.l lVar, Object obj, UndeliveredElementException undeliveredElementException, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            undeliveredElementException = null;
        }
        return c(lVar, obj, undeliveredElementException);
    }
}
