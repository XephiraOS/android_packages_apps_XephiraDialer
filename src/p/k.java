package p;

import q.C1474a;

/* compiled from: SparseArrayCompat.kt */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f35967a = new Object();

    public static final <E> E c(j<E> jVar, int i10) {
        E e10;
        kotlin.jvm.internal.i.f(jVar, "<this>");
        int a10 = C1474a.a(jVar.f35964b, jVar.f35966d, i10);
        if (a10 < 0 || (e10 = (E) jVar.f35965c[a10]) == f35967a) {
            return null;
        }
        return e10;
    }

    public static final <E> void d(j<E> jVar, int i10) {
        kotlin.jvm.internal.i.f(jVar, "<this>");
        int a10 = C1474a.a(jVar.f35964b, jVar.f35966d, i10);
        if (a10 >= 0) {
            Object[] objArr = jVar.f35965c;
            Object obj = objArr[a10];
            Object obj2 = f35967a;
            if (obj != obj2) {
                objArr[a10] = obj2;
                jVar.f35963a = true;
            }
        }
    }

    public static final <E> void e(j<E> jVar) {
        int i10 = jVar.f35966d;
        int[] iArr = jVar.f35964b;
        Object[] objArr = jVar.f35965c;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            Object obj = objArr[i12];
            if (obj != f35967a) {
                if (i12 != i11) {
                    iArr[i11] = iArr[i12];
                    objArr[i11] = obj;
                    objArr[i12] = null;
                }
                i11++;
            }
        }
        jVar.f35963a = false;
        jVar.f35966d = i11;
    }
}
