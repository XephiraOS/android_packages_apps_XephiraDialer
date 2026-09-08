package kotlin;

import kotlin.Result;
import kotlin.jvm.internal.i;

/* compiled from: Result.kt */
/* loaded from: classes4.dex */
public final class b {
    public static final Object a(Throwable exception) {
        i.f(exception, "exception");
        return new Result.Failure(exception);
    }

    public static final void b(Object obj) {
        if (!(obj instanceof Result.Failure)) {
        } else {
            throw ((Result.Failure) obj).exception;
        }
    }
}
