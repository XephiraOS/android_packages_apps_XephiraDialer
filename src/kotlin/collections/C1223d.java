package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import w9.InterfaceC1658a;

/* compiled from: Collections.kt */
/* renamed from: kotlin.collections.d, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1223d<T> implements Collection<T>, InterfaceC1658a {

    /* renamed from: a, reason: collision with root package name */
    public final T[] f34196a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f34197b;

    public C1223d(T[] values, boolean z10) {
        kotlin.jvm.internal.i.f(values, "values");
        this.f34196a = values;
        this.f34197b = z10;
    }

    public int a() {
        return this.f34196a.length;
    }

    @Override // java.util.Collection
    public boolean add(T t10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        boolean t10;
        t10 = C1229j.t(this.f34196a, obj);
        return t10;
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        kotlin.jvm.internal.i.f(elements, "elements");
        Collection<? extends Object> collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        if (this.f34196a.length == 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return kotlin.jvm.internal.b.a(this.f34196a);
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return a();
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] array) {
        kotlin.jvm.internal.i.f(array, "array");
        return (T[]) kotlin.jvm.internal.e.b(this, array);
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        return n.a(this.f34196a, this.f34197b);
    }
}
