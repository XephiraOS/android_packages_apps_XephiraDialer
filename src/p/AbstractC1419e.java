package p;

import java.util.Iterator;
import java.util.NoSuchElementException;
import w9.InterfaceC1658a;

/* compiled from: IndexBasedArrayIterator.kt */
/* renamed from: p.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1419e<T> implements Iterator<T>, InterfaceC1658a {

    /* renamed from: a, reason: collision with root package name */
    public int f35952a;

    /* renamed from: b, reason: collision with root package name */
    public int f35953b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f35954c;

    public AbstractC1419e(int i10) {
        this.f35952a = i10;
    }

    public abstract T a(int i10);

    public abstract void b(int i10);

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.f35953b < this.f35952a) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            T a10 = a(this.f35953b);
            this.f35953b++;
            this.f35954c = true;
            return a10;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        if (this.f35954c) {
            int i10 = this.f35953b - 1;
            this.f35953b = i10;
            b(i10);
            this.f35952a--;
            this.f35954c = false;
            return;
        }
        throw new IllegalStateException("Call next() before removing an element.".toString());
    }
}
