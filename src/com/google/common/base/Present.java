package com.google.common.base;

/* loaded from: classes3.dex */
final class Present<T> extends Optional<T> {
    private static final long serialVersionUID = 0;
    private final T reference;

    public Present(T t10) {
        this.reference = t10;
    }

    @Override // com.google.common.base.Optional
    public T b() {
        return this.reference;
    }

    @Override // com.google.common.base.Optional
    public boolean c() {
        return true;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Present) {
            return this.reference.equals(((Present) obj).reference);
        }
        return false;
    }

    public int hashCode() {
        return this.reference.hashCode() + 1502476572;
    }

    public String toString() {
        return "Optional.of(" + this.reference + ")";
    }
}
