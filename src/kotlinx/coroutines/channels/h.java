package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlinx.coroutines.C1235b0;

/* compiled from: Channels.common.kt */
/* loaded from: classes4.dex */
public final /* synthetic */ class h {
    public static final void a(n<?> nVar, Throwable th) {
        CancellationException cancellationException = null;
        if (th != null) {
            if (th instanceof CancellationException) {
                cancellationException = (CancellationException) th;
            }
            if (cancellationException == null) {
                cancellationException = C1235b0.a("Channel was consumed, consumer had failed", th);
            }
        }
        nVar.e(cancellationException);
    }
}
