package com.google.common.collect;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Sets.java */
/* loaded from: classes3.dex */
public final class y {

    /* compiled from: Sets.java */
    /* loaded from: classes3.dex */
    public static abstract class a<E> extends AbstractSet<E> {
        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return y.g(this, collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            return super.retainAll((Collection) com.google.common.base.k.o(collection));
        }
    }

    public static boolean a(Set<?> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static int b(Set<?> set) {
        int i10;
        int i11 = 0;
        for (Object obj : set) {
            if (obj != null) {
                i10 = obj.hashCode();
            } else {
                i10 = 0;
            }
            i11 = ~(~(i11 + i10));
        }
        return i11;
    }

    public static <E> Set<E> c() {
        return Collections.newSetFromMap(new ConcurrentHashMap());
    }

    public static <E> HashSet<E> d() {
        return new HashSet<>();
    }

    public static <E> HashSet<E> e(E... eArr) {
        HashSet<E> f10 = f(eArr.length);
        Collections.addAll(f10, eArr);
        return f10;
    }

    public static <E> HashSet<E> f(int i10) {
        return new HashSet<>(Maps.a(i10));
    }

    public static boolean g(Set<?> set, Collection<?> collection) {
        com.google.common.base.k.o(collection);
        if (collection instanceof r) {
            collection = ((r) collection).d();
        }
        if ((collection instanceof Set) && collection.size() > set.size()) {
            return Iterators.h(set.iterator(), collection);
        }
        return h(set, collection.iterator());
    }

    public static boolean h(Set<?> set, Iterator<?> it) {
        boolean z10 = false;
        while (it.hasNext()) {
            z10 |= set.remove(it.next());
        }
        return z10;
    }
}
