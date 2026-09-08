package io.grpc;

/* loaded from: classes4.dex */
public class StatusException extends Exception {
    private static final long serialVersionUID = -660954903976144640L;
    private final boolean fillInStackTrace;
    private final Status status;
    private final u trailers;

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
}
