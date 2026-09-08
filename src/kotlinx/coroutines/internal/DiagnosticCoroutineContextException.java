package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;

/* compiled from: CoroutineExceptionHandlerImpl.kt */
/* loaded from: classes4.dex */
public final class DiagnosticCoroutineContextException extends RuntimeException {

    /* renamed from: a, reason: collision with root package name */
    public final transient CoroutineContext f34482a;

    public DiagnosticCoroutineContextException(CoroutineContext coroutineContext) {
        this.f34482a = coroutineContext;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    @Override // java.lang.Throwable
    public String getLocalizedMessage() {
        return this.f34482a.toString();
    }
}
