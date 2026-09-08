package com.google.common.collect;

import java.math.RoundingMode;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: Lists.java */
/* loaded from: classes3.dex */
public final class n {

    /* compiled from: Lists.java */
    /* loaded from: classes3.dex */
    public static class a<T> extends AbstractList<List<T>> {

        /* renamed from: a, reason: collision with root package name */
        public final List<T> f24574a;

        /* renamed from: b, reason: collision with root package name */
        public final int f24575b;

        public a(List<T> list, int i10) {
            this.f24574a = list;
            this.f24575b = i10;
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<T> get(int i10) {
            com.google.common.base.k.m(i10, size());
            int i11 = this.f24575b;
            int i12 = i10 * i11;
            return this.f24574a.subList(i12, Math.min(i11 + i12, this.f24574a.size()));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return this.f24574a.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return com.google.common.math.a.a(this.f24574a.size(), this.f24575b, RoundingMode.CEILING);
        }
    }

    /* compiled from: Lists.java */
    /* loaded from: classes3.dex */
    public static class b<T> extends a<T> implements RandomAccess {
        public b(List<T> list, int i10) {
            super(list, i10);
        }
    }

    public static boolean a(List<?> list, Object obj) {
        if (obj == com.google.common.base.k.o(list)) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list2 = (List) obj;
        int size = list.size();
        if (size != list2.size()) {
            return false;
        }
        if ((list instanceof RandomAccess) && (list2 instanceof RandomAccess)) {
            for (int i10 = 0; i10 < size; i10++) {
                if (!com.google.common.base.h.a(list.get(i10), list2.get(i10))) {
                    return false;
                }
            }
            return true;
        }
        return Iterators.c(list.iterator(), list2.iterator());
    }

    public static int b(List<?> list, Object obj) {
        if (list instanceof RandomAccess) {
            return c(list, obj);
        }
        ListIterator<?> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (com.google.common.base.h.a(obj, listIterator.next())) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }

    public static int c(List<?> list, Object obj) {
        int size = list.size();
        int i10 = 0;
        if (obj == null) {
            while (i10 < size) {
                if (list.get(i10) == null) {
                    return i10;
                }
                i10++;
            }
            return -1;
        }
        while (i10 < size) {
            if (obj.equals(list.get(i10))) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static int computeArrayListCapacity(int i10) {
        f.b(i10, "arraySize");
        return com.google.common.primitives.b.b(i10 + 5 + (i10 / 10));
    }

    public static int d(List<?> list, Object obj) {
        if (list instanceof RandomAccess) {
            return e(list, obj);
        }
        ListIterator<?> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (com.google.common.base.h.a(obj, listIterator.previous())) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    public static int e(List<?> list, Object obj) {
        if (obj == null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                if (list.get(size) == null) {
                    return size;
                }
            }
            return -1;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            if (obj.equals(list.get(size2))) {
                return size2;
            }
        }
        return -1;
    }

    public static <E> ArrayList<E> f() {
        return new ArrayList<>();
    }

    public static <E> ArrayList<E> g(Iterable<? extends E> iterable) {
        com.google.common.base.k.o(iterable);
        if (iterable instanceof Collection) {
            return new ArrayList<>((Collection) iterable);
        }
        return h(iterable.iterator());
    }

    public static <E> ArrayList<E> h(Iterator<? extends E> it) {
        ArrayList<E> f10 = f();
        Iterators.a(f10, it);
        return f10;
    }

    @SafeVarargs
    public static <E> ArrayList<E> i(E... eArr) {
        com.google.common.base.k.o(eArr);
        ArrayList<E> arrayList = new ArrayList<>(computeArrayListCapacity(eArr.length));
        Collections.addAll(arrayList, eArr);
        return arrayList;
    }

    public static <T> List<List<T>> j(List<T> list, int i10) {
        boolean z10;
        com.google.common.base.k.o(list);
        if (i10 > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        com.google.common.base.k.d(z10);
        if (list instanceof RandomAccess) {
            return new b(list, i10);
        }
        return new a(list, i10);
    }
}
