package kotlinx.coroutines.flow;

import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.g;

/* compiled from: Context.kt */
/* loaded from: classes4.dex */
public final /* synthetic */ class f {
    public static final <T> a<T> a(a<? extends T> aVar, int i10, BufferOverflow bufferOverflow) {
        if (i10 < 0 && i10 != -2 && i10 != -1) {
            throw new IllegalArgumentException(("Buffer size should be non-negative, BUFFERED, or CONFLATED, but was " + i10).toString());
        }
        if (i10 == -1 && bufferOverflow != BufferOverflow.SUSPEND) {
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
        }
        if (i10 == -1) {
            bufferOverflow = BufferOverflow.DROP_OLDEST;
            i10 = 0;
        }
        int i11 = i10;
        BufferOverflow bufferOverflow2 = bufferOverflow;
        if (aVar instanceof kotlinx.coroutines.flow.internal.g) {
            return g.a.a((kotlinx.coroutines.flow.internal.g) aVar, null, i11, bufferOverflow2, 1, null);
        }
        return new kotlinx.coroutines.flow.internal.e(aVar, null, i11, bufferOverflow2, 2, null);
    }

    public static /* synthetic */ a b(a aVar, int i10, BufferOverflow bufferOverflow, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = -2;
        }
        if ((i11 & 2) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        return c.a(aVar, i10, bufferOverflow);
    }
}
