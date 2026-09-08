package com.google.common.base;

import java.io.Serializable;

/* loaded from: classes3.dex */
class Suppliers$ExpiringMemoizingSupplier<T> implements o<T>, Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a, reason: collision with root package name */
    public volatile transient T f24297a;

    /* renamed from: b, reason: collision with root package name */
    public volatile transient long f24298b;
    final o<T> delegate;
    final long durationNanos;

    @Override // com.google.common.base.o
    public T get() {
        long j10 = this.f24298b;
        long nanoTime = System.nanoTime();
        if (j10 == 0 || nanoTime - j10 >= 0) {
            synchronized (this) {
                try {
                    if (j10 == this.f24298b) {
                        T t10 = this.delegate.get();
                        this.f24297a = t10;
                        long j11 = nanoTime + this.durationNanos;
                        if (j11 == 0) {
                            j11 = 1;
                        }
                        this.f24298b = j11;
                        return t10;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return (T) g.a(this.f24297a);
    }

    public String toString() {
        return "Suppliers.memoizeWithExpiration(" + this.delegate + ", " + this.durationNanos + ", NANOS)";
    }
}
