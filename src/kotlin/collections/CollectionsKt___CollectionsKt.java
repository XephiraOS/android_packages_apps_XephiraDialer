package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;
import kotlin.Pair;
import v9.InterfaceC1637a;

/* compiled from: _Collections.kt */
/* loaded from: classes4.dex */
public class CollectionsKt___CollectionsKt extends v {
    public static final <T, A extends Appendable> A A(Iterable<? extends T> iterable, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i10, CharSequence truncated, v9.l<? super T, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.i.f(iterable, "<this>");
        kotlin.jvm.internal.i.f(buffer, "buffer");
        kotlin.jvm.internal.i.f(separator, "separator");
        kotlin.jvm.internal.i.f(prefix, "prefix");
        kotlin.jvm.internal.i.f(postfix, "postfix");
        kotlin.jvm.internal.i.f(truncated, "truncated");
        buffer.append(prefix);
        int i11 = 0;
        for (T t10 : iterable) {
            i11++;
            if (i11 > 1) {
                buffer.append(separator);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            kotlin.text.g.a(buffer, t10, lVar);
        }
        if (i10 >= 0 && i11 > i10) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static /* synthetic */ Appendable B(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, v9.l lVar, int i11, Object obj) {
        CharSequence charSequence5;
        CharSequence charSequence6;
        int i12;
        CharSequence charSequence7;
        v9.l lVar2;
        if ((i11 & 2) != 0) {
            charSequence5 = ", ";
        } else {
            charSequence5 = charSequence;
        }
        CharSequence charSequence8 = "";
        if ((i11 & 4) != 0) {
            charSequence6 = "";
        } else {
            charSequence6 = charSequence2;
        }
        if ((i11 & 8) == 0) {
            charSequence8 = charSequence3;
        }
        if ((i11 & 16) != 0) {
            i12 = -1;
        } else {
            i12 = i10;
        }
        if ((i11 & 32) != 0) {
            charSequence7 = "...";
        } else {
            charSequence7 = charSequence4;
        }
        if ((i11 & 64) != 0) {
            lVar2 = null;
        } else {
            lVar2 = lVar;
        }
        return A(iterable, appendable, charSequence5, charSequence6, charSequence8, i12, charSequence7, lVar2);
    }

    public static final <T> String C(Iterable<? extends T> iterable, CharSequence separator, CharSequence prefix, CharSequence postfix, int i10, CharSequence truncated, v9.l<? super T, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.i.f(iterable, "<this>");
        kotlin.jvm.internal.i.f(separator, "separator");
        kotlin.jvm.internal.i.f(prefix, "prefix");
        kotlin.jvm.internal.i.f(postfix, "postfix");
        kotlin.jvm.internal.i.f(truncated, "truncated");
        String sb = ((StringBuilder) A(iterable, new StringBuilder(), separator, prefix, postfix, i10, truncated, lVar)).toString();
        kotlin.jvm.internal.i.e(sb, "toString(...)");
        return sb;
    }

    public static /* synthetic */ String D(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, v9.l lVar, int i11, Object obj) {
        CharSequence charSequence5;
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence6 = "";
        if ((i11 & 2) != 0) {
            charSequence5 = "";
        } else {
            charSequence5 = charSequence2;
        }
        if ((i11 & 4) == 0) {
            charSequence6 = charSequence3;
        }
        if ((i11 & 8) != 0) {
            i10 = -1;
        }
        int i12 = i10;
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i11 & 32) != 0) {
            lVar = null;
        }
        return C(iterable, charSequence, charSequence5, charSequence6, i12, charSequence7, lVar);
    }

    public static <T> T E(List<? extends T> list) {
        int i10;
        kotlin.jvm.internal.i.f(list, "<this>");
        if (!list.isEmpty()) {
            i10 = o.i(list);
            return list.get(i10);
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static <T> T F(List<? extends T> list) {
        kotlin.jvm.internal.i.f(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    public static <T extends Comparable<? super T>> T G(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.i.f(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) > 0) {
                next = next2;
            }
        }
        return next;
    }

    public static <T> List<T> H(Collection<? extends T> collection, T t10) {
        kotlin.jvm.internal.i.f(collection, "<this>");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(t10);
        return arrayList;
    }

    public static <T> T I(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.i.f(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) J((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            if (!it.hasNext()) {
                return next;
            }
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static final <T> T J(List<? extends T> list) {
        kotlin.jvm.internal.i.f(list, "<this>");
        int size = list.size();
        if (size != 0) {
            if (size == 1) {
                return list.get(0);
            }
            throw new IllegalArgumentException("List has more than one element.");
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static char[] K(Collection<Character> collection) {
        kotlin.jvm.internal.i.f(collection, "<this>");
        char[] cArr = new char[collection.size()];
        Iterator<Character> it = collection.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            cArr[i10] = it.next().charValue();
            i10++;
        }
        return cArr;
    }

    public static final <T, C extends Collection<? super T>> C L(Iterable<? extends T> iterable, C destination) {
        kotlin.jvm.internal.i.f(iterable, "<this>");
        kotlin.jvm.internal.i.f(destination, "destination");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            destination.add(it.next());
        }
        return destination;
    }

    public static <T> List<T> M(Iterable<? extends T> iterable) {
        List<T> h10;
        Object next;
        List<T> b10;
        kotlin.jvm.internal.i.f(iterable, "<this>");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size == 0) {
                h10 = o.h();
                return h10;
            }
            if (size != 1) {
                return O(collection);
            }
            if (iterable instanceof List) {
                next = ((List) iterable).get(0);
            } else {
                next = iterable.iterator().next();
            }
            b10 = n.b(next);
            return b10;
        }
        return o.l(N(iterable));
    }

    public static final <T> List<T> N(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.i.f(iterable, "<this>");
        if (iterable instanceof Collection) {
            return O((Collection) iterable);
        }
        return (List) L(iterable, new ArrayList());
    }

    public static final <T> List<T> O(Collection<? extends T> collection) {
        kotlin.jvm.internal.i.f(collection, "<this>");
        return new ArrayList(collection);
    }

    public static <T> Set<T> P(Iterable<? extends T> iterable) {
        Set<T> b10;
        Object next;
        int a10;
        kotlin.jvm.internal.i.f(iterable, "<this>");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size == 0) {
                b10 = K.b();
                return b10;
            }
            if (size != 1) {
                a10 = D.a(collection.size());
                return (Set) L(iterable, new LinkedHashSet(a10));
            }
            if (iterable instanceof List) {
                next = ((List) iterable).get(0);
            } else {
                next = iterable.iterator().next();
            }
            return J.a(next);
        }
        return K.c((Set) L(iterable, new LinkedHashSet()));
    }

    public static final <T> List<List<T>> Q(Iterable<? extends T> iterable, int i10, int i11, boolean z10) {
        int i12;
        int e10;
        kotlin.jvm.internal.i.f(iterable, "<this>");
        SlidingWindowKt.a(i10, i11);
        if ((iterable instanceof RandomAccess) && (iterable instanceof List)) {
            List list = (List) iterable;
            int size = list.size();
            int i13 = size / i11;
            if (size % i11 == 0) {
                i12 = 0;
            } else {
                i12 = 1;
            }
            ArrayList arrayList = new ArrayList(i13 + i12);
            int i14 = 0;
            while (i14 >= 0 && i14 < size) {
                e10 = B9.i.e(i10, size - i14);
                if (e10 < i10 && !z10) {
                    break;
                }
                ArrayList arrayList2 = new ArrayList(e10);
                for (int i15 = 0; i15 < e10; i15++) {
                    arrayList2.add(list.get(i15 + i14));
                }
                arrayList.add(arrayList2);
                i14 += i11;
            }
            return arrayList;
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator b10 = SlidingWindowKt.b(iterable.iterator(), i10, i11, z10, false);
        while (b10.hasNext()) {
            arrayList3.add((List) b10.next());
        }
        return arrayList3;
    }

    public static <T> Iterable<x<T>> R(final Iterable<? extends T> iterable) {
        kotlin.jvm.internal.i.f(iterable, "<this>");
        return new y(new InterfaceC1637a<Iterator<? extends T>>() { // from class: kotlin.collections.CollectionsKt___CollectionsKt$withIndex$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Iterator<T> invoke() {
                return iterable.iterator();
            }
        });
    }

    public static <T, R> List<Pair<T, R>> S(Iterable<? extends T> iterable, Iterable<? extends R> other) {
        int p10;
        int p11;
        kotlin.jvm.internal.i.f(iterable, "<this>");
        kotlin.jvm.internal.i.f(other, "other");
        Iterator<? extends T> it = iterable.iterator();
        Iterator<? extends R> it2 = other.iterator();
        p10 = p.p(iterable, 10);
        p11 = p.p(other, 10);
        ArrayList arrayList = new ArrayList(Math.min(p10, p11));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(m9.g.a(it.next(), it2.next()));
        }
        return arrayList;
    }

    public static <T> List<List<T>> t(Iterable<? extends T> iterable, int i10) {
        kotlin.jvm.internal.i.f(iterable, "<this>");
        return Q(iterable, i10, i10, true);
    }

    public static <T> boolean u(Iterable<? extends T> iterable, T t10) {
        kotlin.jvm.internal.i.f(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).contains(t10);
        }
        if (z(iterable, t10) >= 0) {
            return true;
        }
        return false;
    }

    public static <T> T v(List<? extends T> list) {
        kotlin.jvm.internal.i.f(list, "<this>");
        if (!list.isEmpty()) {
            return list.get(0);
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static <T> T w(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.i.f(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return (T) list.get(0);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        return it.next();
    }

    public static <T> T x(List<? extends T> list) {
        kotlin.jvm.internal.i.f(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static <T> T y(List<? extends T> list, int i10) {
        int i11;
        kotlin.jvm.internal.i.f(list, "<this>");
        if (i10 >= 0) {
            i11 = o.i(list);
            if (i10 <= i11) {
                return list.get(i10);
            }
        }
        return null;
    }

    public static final <T> int z(Iterable<? extends T> iterable, T t10) {
        kotlin.jvm.internal.i.f(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(t10);
        }
        int i10 = 0;
        for (T t11 : iterable) {
            if (i10 < 0) {
                o.o();
            }
            if (kotlin.jvm.internal.i.b(t10, t11)) {
                return i10;
            }
            i10++;
        }
        return -1;
    }
}
