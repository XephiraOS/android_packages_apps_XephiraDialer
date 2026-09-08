package com.google.zxing;

/* loaded from: classes3.dex */
public final class ChecksumException extends ReaderException {

    /* renamed from: c, reason: collision with root package name */
    public static final ChecksumException f24972c;

    static {
        ChecksumException checksumException = new ChecksumException();
        f24972c = checksumException;
        checksumException.setStackTrace(ReaderException.f25001b);
    }

    private ChecksumException() {
    }

    public static ChecksumException a() {
        if (ReaderException.f25000a) {
            return new ChecksumException();
        }
        return f24972c;
    }
}
