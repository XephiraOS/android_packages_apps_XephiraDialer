package com.google.common.base;

import java.io.Serializable;

/* loaded from: classes3.dex */
class Suppliers$MemoizingSupplier<T> implements o<T>, Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a, reason: collision with root package name */
    public volatile transient boolean f24299a;

    /* renamed from: b, reason: collision with root package name */
    public transient T f24300b;
    final o<T> delegate;

    @Override // com.google.common.base.o
    public T get() {
        if (!this.f24299a) {
            synchronized (this) {
                try {
                    if (!this.f24299a) {
                        T t10 = this.delegate.get();
                        this.f24300b = t10;
                        this.f24299a = true;
                        return t10;
                    }
                } finally {
                }
            }
        }
        return (T) g.a(this.f24300b);
    }

    public String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder();
        sb.append("Suppliers.memoize(");
        if (this.f24299a) {
            obj = "<supplier that returned " + this.f24300b + ">";
        } else {
            obj = this.delegate;
        }
        sb.append(obj);
        sb.append(")");
        return sb.toString();
    }
}
