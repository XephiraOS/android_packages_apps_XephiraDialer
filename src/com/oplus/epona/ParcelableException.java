package com.oplus.epona;

import com.oplus.utils.C0864z;

/* loaded from: classes3.dex */
final class ParcelableException extends RuntimeException {
    private static final String TAG = "Epona->ParcelableException";

    private ParcelableException(Throwable th) {
        super(th);
    }

    public static ParcelableException create(ExceptionInfo exceptionInfo) {
        String name = exceptionInfo.getName();
        String message = exceptionInfo.getMessage();
        try {
            Class<?> cls = Class.forName(name);
            if (Throwable.class.isAssignableFrom(cls)) {
                return new ParcelableException((Throwable) cls.getConstructor(String.class).newInstance(message));
            }
        } catch (ReflectiveOperationException e10) {
            C0864z.d(TAG, e10.toString(), new Object[0]);
        }
        return new ParcelableException(new RuntimeException(name + ": " + message));
    }

    public <T extends Throwable> void maybeRethrow(Class<T> cls) {
        if (!cls.isAssignableFrom(getCause().getClass())) {
        } else {
            throw getCause();
        }
    }
}
