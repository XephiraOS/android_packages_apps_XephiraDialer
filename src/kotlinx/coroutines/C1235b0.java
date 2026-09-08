package kotlinx.coroutines;

import java.util.concurrent.CancellationException;

/* compiled from: Exceptions.kt */
/* renamed from: kotlinx.coroutines.b0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1235b0 {
    public static final CancellationException a(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }
}
