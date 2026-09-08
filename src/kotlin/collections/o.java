package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import o9.C1412b;

/* compiled from: Collections.kt */
/* loaded from: classes4.dex */
public class o extends n {
    public static <T> ArrayList<T> d(T... elements) {
        kotlin.jvm.internal.i.f(elements, "elements");
        if (elements.length == 0) {
            return new ArrayList<>();
        }
        return new ArrayList<>(new C1223d(elements, true));
    }

    public static final <T> Collection<T> e(T[] tArr) {
        kotlin.jvm.internal.i.f(tArr, "<this>");
        return new C1223d(tArr, false);
    }

    public static final <T extends Comparable<? super T>> int f(List<? extends T> list, T t10, int i10, int i11) {
        int a10;
        kotlin.jvm.internal.i.f(list, "<this>");
        m(list.size(), i10, i11);
        int i12 = i11 - 1;
        while (i10 <= i12) {
            int i13 = (i10 + i12) >>> 1;
            a10 = C1412b.a(list.get(i13), t10);
            if (a10 < 0) {
                i10 = i13 + 1;
            } else if (a10 > 0) {
                i12 = i13 - 1;
            } else {
                return i13;
            }
        }
        return -(i10 + 1);
    }

    public static /* synthetic */ int g(List list, Comparable comparable, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = list.size();
        }
        return f(list, comparable, i10, i11);
    }

    public static <T> List<T> h() {
        return EmptyList.f34170a;
    }

    public static <T> int i(List<? extends T> list) {
        kotlin.jvm.internal.i.f(list, "<this>");
        return list.size() - 1;
    }

    public static <T> List<T> j(T... elements) {
        List<T> h10;
        List<T> f10;
        kotlin.jvm.internal.i.f(elements, "elements");
        if (elements.length > 0) {
            f10 = C1228i.f(elements);
            return f10;
        }
        h10 = h();
        return h10;
    }

    public static <T> List<T> k(T... elements) {
        kotlin.jvm.internal.i.f(elements, "elements");
        if (elements.length == 0) {
            return new ArrayList();
        }
        return new ArrayList(new C1223d(elements, true));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> l(List<? extends T> list) {
        List<T> h10;
        List<T> b10;
        kotlin.jvm.internal.i.f(list, "<this>");
        int size = list.size();
        if (size == 0) {
            h10 = h();
            return h10;
        }
        if (size == 1) {
            b10 = n.b(list.get(0));
            return b10;
        }
        return list;
    }

    public static final void m(int i10, int i11, int i12) {
        if (i11 <= i12) {
            if (i11 >= 0) {
                if (i12 <= i10) {
                    return;
                }
                throw new IndexOutOfBoundsException("toIndex (" + i12 + ") is greater than size (" + i10 + ").");
            }
            throw new IndexOutOfBoundsException("fromIndex (" + i11 + ") is less than zero.");
        }
        throw new IllegalArgumentException("fromIndex (" + i11 + ") is greater than toIndex (" + i12 + ").");
    }

    public static void n() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    public static void o() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
