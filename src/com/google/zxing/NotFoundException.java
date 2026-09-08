package com.google.zxing;

/* loaded from: classes3.dex */
public final class NotFoundException extends ReaderException {

    /* renamed from: c, reason: collision with root package name */
    public static final NotFoundException f24999c;

    static {
        NotFoundException notFoundException = new NotFoundException();
        f24999c = notFoundException;
        notFoundException.setStackTrace(ReaderException.f25001b);
    }

    private NotFoundException() {
    }

    public static NotFoundException a() {
        return f24999c;
    }
}
