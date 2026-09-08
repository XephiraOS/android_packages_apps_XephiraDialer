package com.heytap.epona;

/* loaded from: classes3.dex */
final class ParcelableException extends RuntimeException {
    public ParcelableException(Throwable th) {
        super(th);
    }

    public static ParcelableException a(ExceptionInfo exceptionInfo) {
        String name = exceptionInfo.getName();
        String message = exceptionInfo.getMessage();
        try {
            Class<?> cls = Class.forName(name);
            if (Throwable.class.isAssignableFrom(cls)) {
                return new ParcelableException((Throwable) cls.getConstructor(String.class).newInstance(message));
            }
        } catch (ReflectiveOperationException e10) {
            H5.a.c("ParcelableException", e10.toString(), new Object[0]);
        }
        return new ParcelableException(new RuntimeException(name + ": " + message));
    }

    public <T extends Throwable> void b(Class<T> cls) {
        if (!cls.isAssignableFrom(getCause().getClass())) {
        } else {
            throw getCause();
        }
    }
}
