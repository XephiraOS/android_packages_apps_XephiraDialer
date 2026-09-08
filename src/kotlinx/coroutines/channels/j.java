package kotlinx.coroutines.channels;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.E;
import m9.q;

/* compiled from: Produce.kt */
/* loaded from: classes4.dex */
public final class j {
    public static final <E> n<E> a(E e10, CoroutineContext coroutineContext, int i10, BufferOverflow bufferOverflow, CoroutineStart coroutineStart, v9.l<? super Throwable, q> lVar, v9.p<? super l<? super E>, ? super kotlin.coroutines.c<? super q>, ? extends Object> pVar) {
        k kVar = new k(CoroutineContextKt.e(e10, coroutineContext), d.b(i10, bufferOverflow, null, 4, null));
        if (lVar != null) {
            kVar.h0(lVar);
        }
        kVar.M0(coroutineStart, kVar, pVar);
        return kVar;
    }

    public static /* synthetic */ n b(E e10, CoroutineContext coroutineContext, int i10, BufferOverflow bufferOverflow, CoroutineStart coroutineStart, v9.l lVar, v9.p pVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.f34213a;
        }
        CoroutineContext coroutineContext2 = coroutineContext;
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        int i12 = i10;
        if ((i11 & 4) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        BufferOverflow bufferOverflow2 = bufferOverflow;
        if ((i11 & 8) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        CoroutineStart coroutineStart2 = coroutineStart;
        if ((i11 & 16) != 0) {
            lVar = null;
        }
        return a(e10, coroutineContext2, i12, bufferOverflow2, coroutineStart2, lVar, pVar);
    }
}
