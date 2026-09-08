package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;

/* compiled from: Channel.kt */
/* loaded from: classes4.dex */
public interface n<E> {
    void e(CancellationException cancellationException);

    c<E> iterator();
}
