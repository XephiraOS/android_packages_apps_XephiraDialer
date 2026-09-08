package io.grpc;

/* loaded from: classes4.dex */
public class StatusRuntimeException extends RuntimeException {
    private static final long serialVersionUID = 1950934672280720624L;
    private final boolean fillInStackTrace;
    private final Status status;
    private final u trailers;

    public StatusRuntimeException(Status status) {
        this(status, null);
    }

    public final Status a() {
        return this.status;
    }

    public final u b() {
        return this.trailers;
    }

    @Override // java.lang.Throwable
    public synchronized Throwable fillInStackTrace() {
        Throwable th;
        if (this.fillInStackTrace) {
            th = super.fillInStackTrace();
        } else {
            th = this;
        }
        return th;
    }

    public StatusRuntimeException(Status status, u uVar) {
        this(status, uVar, true);
    }

    public StatusRuntimeException(Status status, u uVar, boolean z10) {
        super(Status.g(status), status.l());
        this.status = status;
        this.trailers = uVar;
        this.fillInStackTrace = z10;
        fillInStackTrace();
    }
}
