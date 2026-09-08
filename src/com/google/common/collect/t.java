package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;

/* compiled from: ObjectArrays.java */
/* loaded from: classes3.dex */
public final class t {
    public static Object a(Object obj, int i10) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("at index " + i10);
    }

    public static Object[] b(Object... objArr) {
        c(objArr, objArr.length);
        return objArr;
    }

    public static Object[] c(Object[] objArr, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            a(objArr[i11], i11);
        }
        return objArr;
    }

    public static Object[] d(Iterable<?> iterable, Object[] objArr) {
        Iterator<?> it = iterable.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            objArr[i10] = it.next();
            i10++;
        }
        return objArr;
    }

    public static <T> T[] e(T[] tArr, int i10) {
        return (T[]) v.b(tArr, i10);
    }

    public static Object[] f(Collection<?> collection) {
        return d(collection, new Object[collection.size()]);
    }

    public static <T> T[] g(Collection<?> collection, T[] tArr) {
        int size = collection.size();
        if (tArr.length < size) {
            tArr = (T[]) e(tArr, size);
        }
        d(collection, tArr);
        if (tArr.length > size) {
            tArr[size] = null;
        }
        return tArr;
    }

    public static <T> T[] h(Object[] objArr, int i10, int i11, T[] tArr) {
        com.google.common.base.k.t(i10, i10 + i11, objArr.length);
        if (tArr.length < i11) {
            tArr = (T[]) e(tArr, i11);
        } else if (tArr.length > i11) {
            tArr[i11] = null;
        }
        System.arraycopy(objArr, i10, tArr, 0, i11);
        return tArr;
    }
}
