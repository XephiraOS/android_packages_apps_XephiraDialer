package com.google.zxing;

/* loaded from: classes3.dex */
public final class FormatException extends ReaderException {

    /* renamed from: c, reason: collision with root package name */
    public static final FormatException f24998c;

    static {
        FormatException formatException = new FormatException();
        f24998c = formatException;
        formatException.setStackTrace(ReaderException.f25001b);
    }

    private FormatException() {
    }

    public static FormatException a() {
        if (ReaderException.f25000a) {
            return new FormatException();
        }
        return f24998c;
    }

    public static FormatException b(Throwable th) {
        if (ReaderException.f25000a) {
            return new FormatException(th);
        }
        return f24998c;
    }

    public FormatException(Throwable th) {
        super(th);
    }
}
