package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;

/* compiled from: ChannelFlow.kt */
/* loaded from: classes4.dex */
public interface g<T> extends kotlinx.coroutines.flow.a<T> {

    /* compiled from: ChannelFlow.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        public static /* synthetic */ kotlinx.coroutines.flow.a a(g gVar, CoroutineContext coroutineContext, int i10, BufferOverflow bufferOverflow, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 1) != 0) {
                    coroutineContext = EmptyCoroutineContext.f34213a;
                }
                if ((i11 & 2) != 0) {
                    i10 = -3;
                }
                if ((i11 & 4) != 0) {
                    bufferOverflow = BufferOverflow.SUSPEND;
                }
                return gVar.a(coroutineContext, i10, bufferOverflow);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fuse");
        }
    }

    kotlinx.coroutines.flow.a<T> a(CoroutineContext coroutineContext, int i10, BufferOverflow bufferOverflow);
}
