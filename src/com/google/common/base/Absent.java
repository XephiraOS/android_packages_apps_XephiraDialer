package com.google.common.base;

/* loaded from: classes3.dex */
final class Absent<T> extends Optional<T> {

    /* renamed from: a, reason: collision with root package name */
    public static final Absent<Object> f24281a = new Absent<>();
    private static final long serialVersionUID = 0;

    private Absent() {
    }

    public static <T> Optional<T> e() {
        return f24281a;
    }

    private Object readResolve() {
        return f24281a;
    }

    @Override // com.google.common.base.Optional
    public T b() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    @Override // com.google.common.base.Optional
    public boolean c() {
        return false;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return 2040732332;
    }

    public String toString() {
        return "Optional.absent()";
    }
}
