package p;

import java.util.ConcurrentModificationException;
import q.C1474a;

/* compiled from: ArraySet.kt */
/* renamed from: p.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1418d {
    public static final <E> void a(C1416b<E> c1416b, int i10) {
        kotlin.jvm.internal.i.f(c1416b, "<this>");
        c1416b.k(new int[i10]);
        c1416b.j(new Object[i10]);
    }

    public static final <E> int b(C1416b<E> c1416b, int i10) {
        kotlin.jvm.internal.i.f(c1416b, "<this>");
        try {
            return C1474a.a(c1416b.e(), c1416b.h(), i10);
        } catch (IndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public static final <E> int c(C1416b<E> c1416b, Object obj, int i10) {
        kotlin.jvm.internal.i.f(c1416b, "<this>");
        int h10 = c1416b.h();
        if (h10 == 0) {
            return -1;
        }
        int b10 = b(c1416b, i10);
        if (b10 < 0) {
            return b10;
        }
        if (kotlin.jvm.internal.i.b(obj, c1416b.c()[b10])) {
            return b10;
        }
        int i11 = b10 + 1;
        while (i11 < h10 && c1416b.e()[i11] == i10) {
            if (kotlin.jvm.internal.i.b(obj, c1416b.c()[i11])) {
                return i11;
            }
            i11++;
        }
        for (int i12 = b10 - 1; i12 >= 0 && c1416b.e()[i12] == i10; i12--) {
            if (kotlin.jvm.internal.i.b(obj, c1416b.c()[i12])) {
                return i12;
            }
        }
        return ~i11;
    }

    public static final <E> int d(C1416b<E> c1416b) {
        kotlin.jvm.internal.i.f(c1416b, "<this>");
        return c(c1416b, null, 0);
    }
}
