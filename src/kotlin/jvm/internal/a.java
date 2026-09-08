package kotlin.jvm.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;
import w9.InterfaceC1658a;

/* compiled from: ArrayIterator.kt */
/* loaded from: classes4.dex */
public final class a<T> implements Iterator<T>, InterfaceC1658a {

    /* renamed from: a, reason: collision with root package name */
    public final T[] f34231a;

    /* renamed from: b, reason: collision with root package name */
    public int f34232b;

    public a(T[] array) {
        i.f(array, "array");
        this.f34231a = array;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.f34232b < this.f34231a.length) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public T next() {
        try {
            T[] tArr = this.f34231a;
            int i10 = this.f34232b;
            this.f34232b = i10 + 1;
            return tArr[i10];
        } catch (ArrayIndexOutOfBoundsException e10) {
            this.f34232b--;
            throw new NoSuchElementException(e10.getMessage());
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
