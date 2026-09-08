package com.google.common.base;

import java.io.Serializable;

/* loaded from: classes3.dex */
public abstract class Optional<T> implements Serializable {
    private static final long serialVersionUID = 0;

    public static <T> Optional<T> a() {
        return Absent.e();
    }

    public static <T> Optional<T> d(T t10) {
        return new Present(k.o(t10));
    }

    public abstract T b();

    public abstract boolean c();
}
