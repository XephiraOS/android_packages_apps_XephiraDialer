package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes3.dex */
public final class Iterators {

    /* loaded from: classes3.dex */
    public enum EmptyModifiableIterator implements Iterator<Object> {
        INSTANCE;

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            f.c(false);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes3.dex */
    public class a<T> extends C<T> {

        /* renamed from: a, reason: collision with root package name */
        public boolean f24453a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f24454b;

        public a(Object obj) {
            this.f24454b = obj;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f24453a;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!this.f24453a) {
                this.f24453a = true;
                return (T) this.f24454b;
            }
            throw new NoSuchElementException();
        }
    }

    /* loaded from: classes3.dex */
    public static class b<E> implements u<E> {

        /* renamed from: a, reason: collision with root package name */
        public final Iterator<? extends E> f24455a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f24456b;

        /* renamed from: c, reason: collision with root package name */
        public E f24457c;

        public b(Iterator<? extends E> it) {
            this.f24455a = (Iterator) com.google.common.base.k.o(it);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (!this.f24456b && !this.f24455a.hasNext()) {
                return false;
            }
            return true;
        }

        @Override // com.google.common.collect.u, java.util.Iterator
        public E next() {
            if (!this.f24456b) {
                return this.f24455a.next();
            }
            E e10 = (E) s.a(this.f24457c);
            this.f24456b = false;
            this.f24457c = null;
            return e10;
        }

        @Override // com.google.common.collect.u
        public E peek() {
            if (!this.f24456b) {
                this.f24457c = this.f24455a.next();
                this.f24456b = true;
            }
            return (E) s.a(this.f24457c);
        }

        @Override // java.util.Iterator
        public void remove() {
            com.google.common.base.k.v(!this.f24456b, "Can't remove after you've peeked at next");
            this.f24455a.remove();
        }
    }

    public static <T> boolean a(Collection<T> collection, Iterator<? extends T> it) {
        com.google.common.base.k.o(collection);
        com.google.common.base.k.o(it);
        boolean z10 = false;
        while (it.hasNext()) {
            z10 |= collection.add(it.next());
        }
        return z10;
    }

    public static void b(Iterator<?> it) {
        com.google.common.base.k.o(it);
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    public static boolean c(Iterator<?> it, Iterator<?> it2) {
        while (it.hasNext()) {
            if (!it2.hasNext() || !com.google.common.base.h.a(it.next(), it2.next())) {
                return false;
            }
        }
        return !it2.hasNext();
    }

    public static <T> Iterator<T> d() {
        return EmptyModifiableIterator.INSTANCE;
    }

    public static <T> T e(Iterator<? extends T> it, T t10) {
        if (it.hasNext()) {
            return it.next();
        }
        return t10;
    }

    public static <T> u<T> f(Iterator<? extends T> it) {
        if (it instanceof b) {
            return (b) it;
        }
        return new b(it);
    }

    public static <T> T g(Iterator<T> it) {
        if (it.hasNext()) {
            T next = it.next();
            it.remove();
            return next;
        }
        return null;
    }

    public static boolean h(Iterator<?> it, Collection<?> collection) {
        com.google.common.base.k.o(collection);
        boolean z10 = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z10 = true;
            }
        }
        return z10;
    }

    public static <T> C<T> i(T t10) {
        return new a(t10);
    }

    public static int j(Iterator<?> it) {
        long j10 = 0;
        while (it.hasNext()) {
            it.next();
            j10++;
        }
        return com.google.common.primitives.b.b(j10);
    }

    public static String k(Iterator<?> it) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        boolean z10 = true;
        while (it.hasNext()) {
            if (!z10) {
                sb.append(", ");
            }
            sb.append(it.next());
            z10 = false;
        }
        sb.append(']');
        return sb.toString();
    }
}
