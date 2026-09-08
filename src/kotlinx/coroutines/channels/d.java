package kotlinx.coroutines.channels;

import m9.q;

/* compiled from: Channel.kt */
/* loaded from: classes4.dex */
public final class d {
    public static final <E> a<E> a(int i10, BufferOverflow bufferOverflow, v9.l<? super E, q> lVar) {
        a<E> iVar;
        if (i10 != -2) {
            if (i10 != -1) {
                if (i10 != 0) {
                    if (i10 != Integer.MAX_VALUE) {
                        if (bufferOverflow == BufferOverflow.SUSPEND) {
                            return new BufferedChannel(i10, lVar);
                        }
                        return new i(i10, bufferOverflow, lVar);
                    }
                    return new BufferedChannel(Integer.MAX_VALUE, lVar);
                }
                if (bufferOverflow == BufferOverflow.SUSPEND) {
                    iVar = new BufferedChannel<>(0, lVar);
                } else {
                    iVar = new i<>(1, bufferOverflow, lVar);
                }
            } else {
                if (bufferOverflow == BufferOverflow.SUSPEND) {
                    return new i(1, BufferOverflow.DROP_OLDEST, lVar);
                }
                throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
            }
        } else if (bufferOverflow == BufferOverflow.SUSPEND) {
            iVar = new BufferedChannel<>(a.f34405w.a(), lVar);
        } else {
            iVar = new i<>(1, bufferOverflow, lVar);
        }
        return iVar;
    }

    public static /* synthetic */ a b(int i10, BufferOverflow bufferOverflow, v9.l lVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        if ((i11 & 2) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        if ((i11 & 4) != 0) {
            lVar = null;
        }
        return a(i10, bufferOverflow, lVar);
    }
}
