package com.google.common.base;

/* loaded from: classes3.dex */
class Suppliers$NonSerializableMemoizingSupplier<T> implements o<T> {

    /* renamed from: c, reason: collision with root package name */
    public static final o<Void> f24301c = new o() { // from class: com.google.common.base.p
        @Override // com.google.common.base.o
        public final Object get() {
            Void b10;
            b10 = Suppliers$NonSerializableMemoizingSupplier.b();
            return b10;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public volatile o<T> f24302a;

    /* renamed from: b, reason: collision with root package name */
    public T f24303b;

    public static /* synthetic */ Void b() {
        throw new IllegalStateException();
    }

    @Override // com.google.common.base.o
    public T get() {
        o<T> oVar = this.f24302a;
        o<T> oVar2 = (o<T>) f24301c;
        if (oVar != oVar2) {
            synchronized (this) {
                try {
                    if (this.f24302a != oVar2) {
                        T t10 = this.f24302a.get();
                        this.f24303b = t10;
                        this.f24302a = oVar2;
                        return t10;
                    }
                } finally {
                }
            }
        }
        return (T) g.a(this.f24303b);
    }

    public String toString() {
        Object obj = this.f24302a;
        StringBuilder sb = new StringBuilder();
        sb.append("Suppliers.memoize(");
        if (obj == f24301c) {
            obj = "<supplier that returned " + this.f24303b + ">";
        }
        sb.append(obj);
        sb.append(")");
        return sb.toString();
    }
}
