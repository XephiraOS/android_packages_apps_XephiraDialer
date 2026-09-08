package kotlinx.coroutines;

import java.util.concurrent.CancellationException;

/* compiled from: Exceptions.kt */
/* loaded from: classes4.dex */
public final class JobCancellationException extends CancellationException {

    /* renamed from: a, reason: collision with root package name */
    public final transient InterfaceC1265l0 f34324a;

    public JobCancellationException(String str, Throwable th, InterfaceC1265l0 interfaceC1265l0) {
        super(str);
        this.f34324a = interfaceC1265l0;
        if (th != null) {
            initCause(th);
        }
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof JobCancellationException) {
                JobCancellationException jobCancellationException = (JobCancellationException) obj;
                if (!kotlin.jvm.internal.i.b(jobCancellationException.getMessage(), getMessage()) || !kotlin.jvm.internal.i.b(jobCancellationException.f34324a, this.f34324a) || !kotlin.jvm.internal.i.b(jobCancellationException.getCause(), getCause())) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public int hashCode() {
        int i10;
        String message = getMessage();
        kotlin.jvm.internal.i.c(message);
        int hashCode = ((message.hashCode() * 31) + this.f34324a.hashCode()) * 31;
        Throwable cause = getCause();
        if (cause != null) {
            i10 = cause.hashCode();
        } else {
            i10 = 0;
        }
        return hashCode + i10;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return super.toString() + "; job=" + this.f34324a;
    }
}
